package com.baidu.swan.gamecenter.appmanager.install;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.swan.apps.ap.ac;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.ap.v;
import com.baidu.swan.gamecenter.a;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public class InstallAntiBlockingActivity extends Activity {
    private JSONObject dUQ;
    private String mPackageName;
    private String mType;

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        int releaseFixedOrientation = ak.releaseFixedOrientation(this);
        super.onCreate(bundle);
        ak.fixedOrientation(this, releaseFixedOrientation);
        a.aUL();
        setContentView(a.e.aiapps_install_guide_layout);
        Intent intent = getIntent();
        if (intent != null) {
            this.mType = intent.getStringExtra("type");
            this.mPackageName = intent.getStringExtra("packageName");
            this.dUQ = v.parseString(intent.getStringExtra("ubc_params"));
        }
        ImageView imageView = (ImageView) findViewById(a.d.install_guide_image);
        View findViewById = findViewById(a.d.install_guide_layout);
        if (TextUtils.equals(this.mType, "authorize")) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(a.b.aiapps_install_image_height));
            layoutParams.gravity = 80;
            imageView.setLayoutParams(layoutParams);
            findViewById(a.d.install_guide_image_mask).setVisibility(0);
            imageView.setImageResource(a.c.aiapps_install_guide_request);
            findViewById(a.d.install_guide_bg_mask).setBackgroundResource(a.C0531a.aiapps_install_guide_mask);
            a.aUG();
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(a.b.aiapps_install_guide_image_height));
            layoutParams2.gravity = 80;
            imageView.setLayoutParams(layoutParams2);
            findViewById(a.d.install_guide_image_mask).setVisibility(8);
            if (ac.isEmui()) {
                imageView.setImageResource(a.c.aiapps_install_guide_emui);
            } else if (ac.isMiui()) {
                imageView.setImageResource(a.c.aiapps_install_guide_miui);
            } else if (ac.isVivo()) {
                imageView.setImageResource(a.c.aiapps_install_guide_vivo);
            } else {
                imageView.setImageResource(a.c.aiapps_install_guide_default);
            }
            findViewById(a.d.install_guide_bg_mask).setBackgroundResource(a.C0531a.aiapps_anti_block_mask);
            a.aUI();
        }
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.gamecenter.appmanager.install.InstallAntiBlockingActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.swan.gamecenter.appmanager.d.c.a(InstallAntiBlockingActivity.this.mPackageName, TextUtils.equals(InstallAntiBlockingActivity.this.mType, "authorize") ? "authorizeClick" : "continueClick", "success", null, new com.baidu.swan.gamecenter.appmanager.d.a(InstallAntiBlockingActivity.this.dUQ));
                InstallAntiBlockingActivity.this.finish();
            }
        });
        com.baidu.swan.gamecenter.appmanager.d.c.a(this.mPackageName, this.mType, "success", null, new com.baidu.swan.gamecenter.appmanager.d.a(this.dUQ));
    }
}
