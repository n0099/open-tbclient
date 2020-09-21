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
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.ap.u;
/* loaded from: classes3.dex */
public class SwanAppScopeDetailActivity extends SwanAppBaseActivity {
    private static final boolean DEBUG = b.DEBUG;
    private d bTV;
    private boolean bTW = true;
    private int mEnterAnimWhenFinishing = 0;
    private int mExitAnimWhenFinishing = 0;
    private String mUrl;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        ae(a.C0326a.aiapps_hold, a.C0326a.aiapps_slide_out_to_right);
        super.onCreate(bundle);
        setContentView(a.g.swanapp_scope_detail_activity);
        ah.R(this);
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
            this.mUrl = u.safeGetStringExtra(intent, "url");
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
            f bv = new com.baidu.swan.apps.adaptation.b.a.b().bv(this);
            bv.a(new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.SwanAppScopeDetailActivity.2
                @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
                public void hQ(String str) {
                    super.hQ(str);
                    if (SwanAppScopeDetailActivity.this.bTW) {
                        SwanAppScopeDetailActivity.this.setTitle(str);
                    }
                }
            });
            this.bTV = bv.abB();
            bv.loadUrl(this.mUrl);
            bv.a((FrameLayout) findViewById(a.f.webview_container), this.bTV.covertToView());
        }
    }

    public void ae(int i, int i2) {
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
        if (this.bTV != null) {
            this.bTV.destroy();
            this.bTV = null;
        }
        this.mUrl = null;
    }
}
