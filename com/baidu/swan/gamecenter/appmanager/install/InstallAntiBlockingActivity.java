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
import com.baidu.tieba.gl3;
import com.baidu.tieba.mz3;
import com.baidu.tieba.rl3;
import com.baidu.tieba.wz3;
import com.baidu.tieba.xk3;
import com.baidu.tieba.yz3;
import org.json.JSONObject;
@SuppressLint({"BaseActivity"})
/* loaded from: classes3.dex */
public class InstallAntiBlockingActivity extends Activity {
    public String a;
    public JSONObject b;
    public String c;

    /* loaded from: classes3.dex */
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
            yz3.a(InstallAntiBlockingActivity.this.a, str, "success", null, new wz3(InstallAntiBlockingActivity.this.b));
            InstallAntiBlockingActivity.this.finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int c0 = rl3.c0(this);
        super.onCreate(bundle);
        rl3.g(this, c0);
        mz3.t();
        setContentView(R.layout.obfuscated_res_0x7f0d00b4);
        Intent intent = getIntent();
        if (intent != null) {
            this.c = intent.getStringExtra("type");
            this.a = intent.getStringExtra("packageName");
            this.b = xk3.d(intent.getStringExtra("ubc_params"));
        }
        ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f0910ba);
        View findViewById = findViewById(R.id.obfuscated_res_0x7f0910bc);
        if (TextUtils.equals(this.c, "authorize")) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07014d));
            layoutParams.gravity = 80;
            imageView.setLayoutParams(layoutParams);
            findViewById(R.id.obfuscated_res_0x7f0910bb).setVisibility(0);
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f080180);
            findViewById(R.id.obfuscated_res_0x7f0910b8).setBackgroundResource(R.color.obfuscated_res_0x7f06031b);
            mz3.o();
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07014c));
            layoutParams2.gravity = 80;
            imageView.setLayoutParams(layoutParams2);
            findViewById(R.id.obfuscated_res_0x7f0910bb).setVisibility(8);
            if (gl3.m()) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f08017e);
            } else if (gl3.n()) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f08017f);
            } else if (gl3.r()) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f080181);
            } else {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f08017d);
            }
            findViewById(R.id.obfuscated_res_0x7f0910b8).setBackgroundResource(R.color.obfuscated_res_0x7f0602ea);
            mz3.p();
        }
        findViewById.setOnClickListener(new a());
        yz3.a(this.a, this.c, "success", null, new wz3(this.b));
    }
}
