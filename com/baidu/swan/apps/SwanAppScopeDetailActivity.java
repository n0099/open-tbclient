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
    private d czU;
    private String mUrl;
    private boolean czV = true;
    private int czQ = 0;
    private int czR = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        ab(a.C0355a.aiapps_hold, a.C0355a.aiapps_slide_out_to_right);
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
            f cn2 = new com.baidu.swan.apps.adaptation.b.a.b().cn(this);
            cn2.a(new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.SwanAppScopeDetailActivity.2
                @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
                public void hV(String str) {
                    super.hV(str);
                    if (SwanAppScopeDetailActivity.this.czV) {
                        SwanAppScopeDetailActivity.this.setTitle(str);
                    }
                }
            });
            this.czU = cn2.aiy();
            cn2.loadUrl(this.mUrl);
            cn2.b((FrameLayout) findViewById(a.f.webview_container), this.czU.covertToView());
        }
    }

    public void ab(int i, int i2) {
        this.czQ = i;
        this.czR = i2;
    }

    private void afO() {
        if (this.czQ != 0 || this.czR != 0) {
            overridePendingTransition(this.czQ, this.czR);
            this.czQ = 0;
            this.czR = 0;
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        afO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.czU != null) {
            this.czU.destroy();
            this.czU = null;
        }
        this.mUrl = null;
    }
}
