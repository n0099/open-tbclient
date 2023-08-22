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
import com.baidu.tieba.c34;
import com.baidu.tieba.do3;
import com.baidu.tieba.e34;
import com.baidu.tieba.mo3;
import com.baidu.tieba.s24;
import com.baidu.tieba.xo3;
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
            e34.a(InstallAntiBlockingActivity.this.a, str, "success", null, new c34(InstallAntiBlockingActivity.this.b));
            InstallAntiBlockingActivity.this.finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int c0 = xo3.c0(this);
        super.onCreate(bundle);
        xo3.g(this, c0);
        s24.t();
        setContentView(R.layout.obfuscated_res_0x7f0d00b7);
        Intent intent = getIntent();
        if (intent != null) {
            this.c = intent.getStringExtra("type");
            this.a = intent.getStringExtra("packageName");
            this.b = do3.d(intent.getStringExtra("ubc_params"));
        }
        ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f091153);
        View findViewById = findViewById(R.id.obfuscated_res_0x7f091155);
        if (TextUtils.equals(this.c, "authorize")) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070154));
            layoutParams.gravity = 80;
            imageView.setLayoutParams(layoutParams);
            findViewById(R.id.obfuscated_res_0x7f091154).setVisibility(0);
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f080198);
            findViewById(R.id.obfuscated_res_0x7f091151).setBackgroundResource(R.color.obfuscated_res_0x7f06043a);
            s24.o();
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f070153));
            layoutParams2.gravity = 80;
            imageView.setLayoutParams(layoutParams2);
            findViewById(R.id.obfuscated_res_0x7f091154).setVisibility(8);
            if (mo3.m()) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f080196);
            } else if (mo3.n()) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f080197);
            } else if (mo3.r()) {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f080199);
            } else {
                imageView.setImageResource(R.drawable.obfuscated_res_0x7f080195);
            }
            findViewById(R.id.obfuscated_res_0x7f091151).setBackgroundResource(R.color.obfuscated_res_0x7f060408);
            s24.p();
        }
        findViewById.setOnClickListener(new a());
        e34.a(this.a, this.c, "success", null, new c34(this.b));
    }
}
