package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.bdprivate.activity.BaseActivity;
import com.baidu.swan.bdprivate.b;
/* loaded from: classes11.dex */
public class LoginServiceAgreementActivity extends BaseActivity {
    private SwanAppActionBar cXa;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.bdprivate.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int releaseFixedOrientation = al.releaseFixedOrientation(this);
        super.onCreate(bundle);
        al.fixedOrientation(this, releaseFixedOrientation);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        Bundle extras = intent.getExtras();
        setContentView(b.f.activity_login_service_agreement);
        NgWebView ngWebView = (NgWebView) findViewById(b.e.aiapps_webView_container);
        if (extras != null) {
            ngWebView.loadUrl(extras.getString("url"));
        }
        this.cXa = (SwanAppActionBar) findViewById(b.e.ai_apps_title_bar);
        this.cXa.setLeftBackViewVisibility(true);
        this.cXa.setLeftBackViewClickListener(new View.OnClickListener() { // from class: com.baidu.swan.bdprivate.extensions.loginauthmobile.LoginServiceAgreementActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LoginServiceAgreementActivity.this.finish();
            }
        });
        this.cXa.setTitle(b.g.swanapp_service_agreement);
        this.cXa.setRightZoneVisibility(false);
    }
}
