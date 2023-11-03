package com.baidu.swan.game.guide.install;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.baidu.tieba.ak3;
import com.baidu.tieba.gj3;
import com.baidu.tieba.pj3;
import com.baidu.tieba.yw3;
@SuppressLint({"BaseActivity"})
/* loaded from: classes4.dex */
public class GameNowInstallAntiBlockingActivity extends Activity {
    public String a;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            TextUtils.equals(GameNowInstallAntiBlockingActivity.this.a, "authorize");
            GameNowInstallAntiBlockingActivity.this.finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int c0 = ak3.c0(this);
        super.onCreate(bundle);
        ak3.g(this, c0);
        yw3.q();
        setContentView(R.layout.obfuscated_res_0x7f0d00b9);
        Intent intent = getIntent();
        if (intent != null) {
            this.a = intent.getStringExtra("type");
            intent.getStringExtra("packageName");
            gj3.d(intent.getStringExtra("ubc_params"));
        }
        ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f09119c);
        View findViewById = findViewById(R.id.obfuscated_res_0x7f09119e);
        if (TextUtils.equals(this.a, "authorize")) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070154));
            layoutParams.gravity = 80;
            imageView.setLayoutParams(layoutParams);
            findViewById(R.id.obfuscated_res_0x7f09119d).setVisibility(0);
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f08019c);
            findViewById(R.id.obfuscated_res_0x7f09119a).setBackgroundResource(R.color.obfuscated_res_0x7f06043c);
            yw3.n();
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070153));
            layoutParams2.gravity = 80;
            imageView.setLayoutParams(layoutParams2);
            findViewById(R.id.obfuscated_res_0x7f09119d).setVisibility(8);
            if (pj3.m()) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f08019a);
            } else if (pj3.n()) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f08019b);
            } else if (pj3.r()) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f08019d);
            } else {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f080199);
            }
            findViewById(R.id.obfuscated_res_0x7f09119a).setBackgroundResource(R.color.obfuscated_res_0x7f06040a);
            yw3.o();
        }
        findViewById.setOnClickListener(new a());
    }
}
