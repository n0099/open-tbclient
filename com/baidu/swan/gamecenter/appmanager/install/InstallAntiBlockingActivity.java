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
import com.baidu.tieba.bk3;
import com.baidu.tieba.gy3;
import com.baidu.tieba.hj3;
import com.baidu.tieba.iy3;
import com.baidu.tieba.qj3;
import com.baidu.tieba.wx3;
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
            iy3.a(InstallAntiBlockingActivity.this.a, str, "success", null, new gy3(InstallAntiBlockingActivity.this.b));
            InstallAntiBlockingActivity.this.finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int c0 = bk3.c0(this);
        super.onCreate(bundle);
        bk3.g(this, c0);
        wx3.t();
        setContentView(R.layout.obfuscated_res_0x7f0d00ba);
        Intent intent = getIntent();
        if (intent != null) {
            this.c = intent.getStringExtra("type");
            this.a = intent.getStringExtra("packageName");
            this.b = hj3.d(intent.getStringExtra("ubc_params"));
        }
        ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f0911c5);
        View findViewById = findViewById(R.id.obfuscated_res_0x7f0911c7);
        if (TextUtils.equals(this.c, "authorize")) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070154));
            layoutParams.gravity = 80;
            imageView.setLayoutParams(layoutParams);
            findViewById(R.id.obfuscated_res_0x7f0911c6).setVisibility(0);
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f08019e);
            findViewById(R.id.obfuscated_res_0x7f0911c3).setBackgroundResource(R.color.obfuscated_res_0x7f06043e);
            wx3.o();
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070153));
            layoutParams2.gravity = 80;
            imageView.setLayoutParams(layoutParams2);
            findViewById(R.id.obfuscated_res_0x7f0911c6).setVisibility(8);
            if (qj3.m()) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f08019c);
            } else if (qj3.n()) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f08019d);
            } else if (qj3.r()) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f08019f);
            } else {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f08019b);
            }
            findViewById(R.id.obfuscated_res_0x7f0911c3).setBackgroundResource(R.color.obfuscated_res_0x7f06040c);
            wx3.p();
        }
        findViewById.setOnClickListener(new a());
        iy3.a(this.a, this.c, "success", null, new gy3(this.b));
    }
}
