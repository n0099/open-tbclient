package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.bdprivate.activity.BaseActivity;
import d.a.i0.a.v2.q0;
import d.a.i0.b.e;
import d.a.i0.b.f;
import d.a.i0.b.g;
/* loaded from: classes3.dex */
public class LoginServiceAgreementActivity extends BaseActivity {
    public static final String KEY_URL = "url";
    public SwanAppActionBar mActionBar;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LoginServiceAgreementActivity.this.finish();
        }
    }

    @Override // com.baidu.swan.bdprivate.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int Z = q0.Z(this);
        super.onCreate(bundle);
        q0.g(this, Z);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        Bundle extras = intent.getExtras();
        setContentView(f.activity_login_service_agreement);
        NgWebView ngWebView = (NgWebView) findViewById(e.aiapps_webView_container);
        if (extras != null) {
            ngWebView.loadUrl(extras.getString("url"));
        }
        SwanAppActionBar swanAppActionBar = (SwanAppActionBar) findViewById(e.ai_apps_title_bar);
        this.mActionBar = swanAppActionBar;
        swanAppActionBar.setLeftBackViewVisibility(true);
        this.mActionBar.setLeftBackViewClickListener(new a());
        this.mActionBar.setTitle(g.swanapp_service_agreement);
        this.mActionBar.setRightZoneVisibility(false);
    }
}
