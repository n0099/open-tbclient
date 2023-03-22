package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.bdprivate.activity.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.nl3;
/* loaded from: classes3.dex */
public class LoginServiceAgreementActivity extends BaseActivity {
    public SwanAppActionBar b;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            LoginServiceAgreementActivity.this.finish();
        }
    }

    @Override // com.baidu.swan.bdprivate.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int c0 = nl3.c0(this);
        super.onCreate(bundle);
        nl3.g(this, c0);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        Bundle extras = intent.getExtras();
        setContentView(R.layout.obfuscated_res_0x7f0d0044);
        NgWebView ngWebView = (NgWebView) findViewById(R.id.obfuscated_res_0x7f0901b1);
        if (extras != null) {
            ngWebView.loadUrl(extras.getString("url"));
        }
        SwanAppActionBar swanAppActionBar = (SwanAppActionBar) findViewById(R.id.obfuscated_res_0x7f090185);
        this.b = swanAppActionBar;
        swanAppActionBar.setLeftBackViewVisibility(true);
        this.b.setLeftBackViewClickListener(new a());
        this.b.setTitle(R.string.obfuscated_res_0x7f0f13ee);
        this.b.setRightZoneVisibility(false);
    }
}
