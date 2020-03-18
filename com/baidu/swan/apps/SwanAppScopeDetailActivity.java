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
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.r;
/* loaded from: classes11.dex */
public class SwanAppScopeDetailActivity extends SwanAppBaseActivity {
    private static final boolean DEBUG = b.DEBUG;
    private d bbl;
    private boolean bbm = true;
    private int mEnterAnimWhenFinishing = 0;
    private int mExitAnimWhenFinishing = 0;
    private String mUrl;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        V(a.C0197a.aiapps_hold, a.C0197a.aiapps_slide_out_to_right);
        super.onCreate(bundle);
        setContentView(a.g.swanapp_scope_detail_activity);
        af.W(this);
        C(getIntent());
        initView();
        initWebView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        C(intent);
    }

    public void C(Intent intent) {
        if (intent != null) {
            this.mUrl = r.safeGetStringExtra(intent, "url");
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
            f bA = new com.baidu.swan.apps.adaptation.b.a.b().bA(this);
            bA.a(new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.SwanAppScopeDetailActivity.2
                @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
                public void em(String str) {
                    super.em(str);
                    if (SwanAppScopeDetailActivity.this.bbm) {
                        SwanAppScopeDetailActivity.this.setTitle(str);
                    }
                }
            });
            this.bbl = bA.IS();
            bA.loadUrl(this.mUrl);
            bA.a((FrameLayout) findViewById(a.f.webview_container), this.bbl.covertToView());
        }
    }

    public void V(int i, int i2) {
        this.mEnterAnimWhenFinishing = i;
        this.mExitAnimWhenFinishing = i2;
    }

    private void startExitActivityAnim() {
        if (this.mEnterAnimWhenFinishing != 0 || this.mExitAnimWhenFinishing != 0) {
            overridePendingTransition(this.mEnterAnimWhenFinishing, this.mExitAnimWhenFinishing);
            this.mEnterAnimWhenFinishing = 0;
            this.mExitAnimWhenFinishing = 0;
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        startExitActivityAnim();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bbl != null) {
            this.bbl.destroy();
            this.bbl = null;
        }
        this.mUrl = null;
    }
}
