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
import com.baidu.tieba.ek3;
import com.baidu.tieba.jy3;
import com.baidu.tieba.kj3;
import com.baidu.tieba.ly3;
import com.baidu.tieba.tj3;
import com.baidu.tieba.zx3;
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
            ly3.a(InstallAntiBlockingActivity.this.a, str, "success", null, new jy3(InstallAntiBlockingActivity.this.b));
            InstallAntiBlockingActivity.this.finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int c0 = ek3.c0(this);
        super.onCreate(bundle);
        ek3.g(this, c0);
        zx3.t();
        setContentView(R.layout.obfuscated_res_0x7f0d00ba);
        Intent intent = getIntent();
        if (intent != null) {
            this.c = intent.getStringExtra("type");
            this.a = intent.getStringExtra("packageName");
            this.b = kj3.d(intent.getStringExtra("ubc_params"));
        }
        ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f0911c6);
        View findViewById = findViewById(R.id.obfuscated_res_0x7f0911c8);
        if (TextUtils.equals(this.c, "authorize")) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070154));
            layoutParams.gravity = 80;
            imageView.setLayoutParams(layoutParams);
            findViewById(R.id.obfuscated_res_0x7f0911c7).setVisibility(0);
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f08019e);
            findViewById(R.id.obfuscated_res_0x7f0911c4).setBackgroundResource(R.color.obfuscated_res_0x7f06043e);
            zx3.o();
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070153));
            layoutParams2.gravity = 80;
            imageView.setLayoutParams(layoutParams2);
            findViewById(R.id.obfuscated_res_0x7f0911c7).setVisibility(8);
            if (tj3.m()) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f08019c);
            } else if (tj3.n()) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f08019d);
            } else if (tj3.r()) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f08019f);
            } else {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f08019b);
            }
            findViewById(R.id.obfuscated_res_0x7f0911c4).setBackgroundResource(R.color.obfuscated_res_0x7f06040c);
            zx3.p();
        }
        findViewById.setOnClickListener(new a());
        ly3.a(this.a, this.c, "success", null, new jy3(this.b));
    }
}
