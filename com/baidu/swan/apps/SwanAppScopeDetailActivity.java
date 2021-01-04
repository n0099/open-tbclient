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
/* loaded from: classes9.dex */
public class SwanAppScopeDetailActivity extends SwanAppBaseActivity {
    private static final boolean DEBUG = b.DEBUG;
    private d cEG;
    private String mUrl;
    private boolean cEH = true;
    private int cEC = 0;
    private int cED = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        ab(a.C0372a.aiapps_hold, a.C0372a.aiapps_slide_out_to_right);
        super.onCreate(bundle);
        setContentView(a.g.swanapp_scope_detail_activity);
        ah.T(this);
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
            f co = new com.baidu.swan.apps.adaptation.b.a.b().co(this);
            co.a(new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.SwanAppScopeDetailActivity.2
                @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
                public void jg(String str) {
                    super.jg(str);
                    if (SwanAppScopeDetailActivity.this.cEH) {
                        SwanAppScopeDetailActivity.this.setTitle(str);
                    }
                }
            });
            this.cEG = co.amr();
            co.loadUrl(this.mUrl);
            co.b((FrameLayout) findViewById(a.f.webview_container), this.cEG.covertToView());
        }
    }

    public void ab(int i, int i2) {
        this.cEC = i;
        this.cED = i2;
    }

    private void ajH() {
        if (this.cEC != 0 || this.cED != 0) {
            overridePendingTransition(this.cEC, this.cED);
            this.cEC = 0;
            this.cED = 0;
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        ajH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.cEG != null) {
            this.cEG.destroy();
            this.cEG = null;
        }
        this.mUrl = null;
    }
}
