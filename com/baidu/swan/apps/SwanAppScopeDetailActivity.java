package com.baidu.swan.apps;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.adaptation.b.d;
import com.baidu.swan.apps.adaptation.b.f;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.u;
/* loaded from: classes8.dex */
public class SwanAppScopeDetailActivity extends SwanAppBaseActivity {
    private static final boolean DEBUG = b.DEBUG;
    private d cDQ;
    private String mUrl;
    private boolean cDR = true;
    private int cDM = 0;
    private int cDN = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        Y(a.C0358a.aiapps_hold, a.C0358a.aiapps_slide_out_to_right);
        super.onCreate(bundle);
        setContentView(a.g.swanapp_scope_detail_activity);
        ah.N(this);
        k(getIntent());
        initView();
        initWebView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        k(intent);
    }

    public void k(Intent intent) {
        if (intent != null) {
            this.mUrl = u.a(intent, "url");
            if (DEBUG) {
                Log.d("ScopeDetailActivity", "mUrl=" + this.mUrl);
            }
        }
    }

    public void setTitle(String str) {
        if (!TextUtils.isEmpty(str)) {
            ((TextView) findViewById(a.f.title)).setText(str);
        }
    }

    private void initView() {
        findViewById(a.f.back).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.swan.apps.SwanAppScopeDetailActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SwanAppScopeDetailActivity.this.finish();
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.swan.apps.adaptation.b.d] */
    private void initWebView() {
        if (!TextUtils.isEmpty(this.mUrl)) {
            f cl = new com.baidu.swan.apps.adaptation.b.a.b().cl(this);
            cl.a(new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.SwanAppScopeDetailActivity.2
                @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
                public void iB(String str) {
                    super.iB(str);
                    if (SwanAppScopeDetailActivity.this.cDR) {
                        SwanAppScopeDetailActivity.this.setTitle(str);
                    }
                }
            });
            this.cDQ = cl.aiZ();
            cl.loadUrl(this.mUrl);
            cl.b((FrameLayout) findViewById(a.f.webview_container), this.cDQ.covertToView());
        }
    }

    public void Y(int i, int i2) {
        this.cDM = i;
        this.cDN = i2;
    }

    private void agp() {
        if (this.cDM != 0 || this.cDN != 0) {
            overridePendingTransition(this.cDM, this.cDN);
            this.cDM = 0;
            this.cDN = 0;
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        agp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.cDQ != null) {
            this.cDQ.destroy();
            this.cDQ = null;
        }
        this.mUrl = null;
    }
}
