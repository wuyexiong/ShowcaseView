package com.espian.showcaseview.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.espian.showcaseview.ShowcaseView;

public class SampleActivity extends Activity implements View.OnClickListener,
		ShowcaseView.OnShowcaseEventListener {

	ShowcaseView sv;
	Button button;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		button = (Button) findViewById(R.id.buttonBlocked);
        button.setOnClickListener(this);

        sv = ShowcaseView.insertShowcaseView(R.id.buttonBlocked, this, "ShowcaseView Sample", "When the ShowcaseView is showing, " +
                "pressing the button will show a gesture. When it is hidden " +
                "it'll go to another Activity.", null);
        sv.setOnShowcaseEventListener(this);

	}

	@Override
	public void onClick(View view) {
		if (sv.isShown()) {
            sv.animateGesture(0, 0, 0, -400).start();
		} else {
			startActivity(new Intent(this, ActionItemsSampleActivity.class));
		}
	}

	@Override
	public void onShowcaseViewHide(ShowcaseView showcaseView) {
		button.setText(R.string.button_show);
	}

	@Override
	public void onShowcaseViewShow(ShowcaseView showcaseView) {
		button.setText(R.string.button_hide);
	}
}
