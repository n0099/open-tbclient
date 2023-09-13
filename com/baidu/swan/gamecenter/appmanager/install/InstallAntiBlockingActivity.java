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
import com.baidu.tieba.bp3;
import com.baidu.tieba.g34;
import com.baidu.tieba.ho3;
import com.baidu.tieba.i34;
import com.baidu.tieba.qo3;
import com.baidu.tieba.w24;
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
            i34.a(InstallAntiBlockingActivity.this.a, str, "success", null, new g34(InstallAntiBlockingActivity.this.b));
            InstallAntiBlockingActivity.this.finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int c0 = bp3.c0(this);
        super.onCreate(bundle);
        bp3.g(this, c0);
        w24.t();
        setContentView(R.layout.obfuscated_res_0x7f0d00ba);
        Intent intent = getIntent();
        if (intent != null) {
            this.c = intent.getStringExtra("type");
            this.a = intent.getStringExtra("packageName");
            this.b = ho3.d(intent.getStringExtra("ubc_params"));
        }
        ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f091155);
        View findViewById = findViewById(R.id.obfuscated_res_0x7f091157);
        if (TextUtils.equals(this.c, "authorize")) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070156));
            layoutParams.gravity = 80;
            imageView.setLayoutParams(layoutParams);
            findViewById(R.id.obfuscated_res_0x7f091156).setVisibility(0);
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f080199);
            findViewById(R.id.obfuscated_res_0x7f091153).setBackgroundResource(R.color.obfuscated_res_0x7f06043c);
            w24.o();
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070155));
            layoutParams2.gravity = 80;
            imageView.setLayoutParams(layoutParams2);
            findViewById(R.id.obfuscated_res_0x7f091156).setVisibility(8);
            if (qo3.m()) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f080197);
            } else if (qo3.n()) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f080198);
            } else if (qo3.r()) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f08019a);
            } else {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f080196);
            }
            findViewById(R.id.obfuscated_res_0x7f091153).setBackgroundResource(R.color.obfuscated_res_0x7f06040a);
            w24.p();
        }
        findViewById.setOnClickListener(new a());
        i34.a(this.a, this.c, "success", null, new g34(this.b));
    }
}
