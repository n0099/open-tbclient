package com.baidu.swan.gamecenter.appmanager.install;

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
import com.baidu.tieba.fy3;
import com.baidu.tieba.gj3;
import com.baidu.tieba.hy3;
import com.baidu.tieba.pj3;
import com.baidu.tieba.vx3;
import org.json.JSONObject;
@SuppressLint({"BaseActivity"})
/* loaded from: classes4.dex */
public class InstallAntiBlockingActivity extends Activity {
    public String a;
    public JSONObject b;
    public String c;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            if (TextUtils.equals(InstallAntiBlockingActivity.this.c, "authorize")) {
                str = "authorizeClick";
            } else {
                str = "continueClick";
            }
            hy3.a(InstallAntiBlockingActivity.this.a, str, "success", null, new fy3(InstallAntiBlockingActivity.this.b));
            InstallAntiBlockingActivity.this.finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int c0 = ak3.c0(this);
        super.onCreate(bundle);
        ak3.g(this, c0);
        vx3.t();
        setContentView(R.layout.obfuscated_res_0x7f0d00b9);
        Intent intent = getIntent();
        if (intent != null) {
            this.c = intent.getStringExtra("type");
            this.a = intent.getStringExtra("packageName");
            this.b = gj3.d(intent.getStringExtra("ubc_params"));
        }
        ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f09119c);
        View findViewById = findViewById(R.id.obfuscated_res_0x7f09119e);
        if (TextUtils.equals(this.c, "authorize")) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070154));
            layoutParams.gravity = 80;
            imageView.setLayoutParams(layoutParams);
            findViewById(R.id.obfuscated_res_0x7f09119d).setVisibility(0);
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f08019c);
            findViewById(R.id.obfuscated_res_0x7f09119a).setBackgroundResource(R.color.obfuscated_res_0x7f06043c);
            vx3.o();
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
            vx3.p();
        }
        findViewById.setOnClickListener(new a());
        hy3.a(this.a, this.c, "success", null, new fy3(this.b));
    }
}
