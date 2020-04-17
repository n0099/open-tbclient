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
    private d bzz;
    private String mUrl;
    private boolean bzA = true;
    private int mEnterAnimWhenFinishing = 0;
    private int mExitAnimWhenFinishing = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.swan.support.v4.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        X(a.C0227a.aiapps_hold, a.C0227a.aiapps_slide_out_to_right);
        super.onCreate(bundle);
        setContentView(a.g.swanapp_scope_detail_activity);
        af.S(this);
        B(getIntent());
        initView();
        initWebView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        B(intent);
    }

    public void B(Intent intent) {
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
            f bo = new com.baidu.swan.apps.adaptation.b.a.b().bo(this);
            bo.a(new com.baidu.swan.apps.core.f.a() { // from class: com.baidu.swan.apps.SwanAppScopeDetailActivity.2
                @Override // com.baidu.swan.apps.core.f.a, com.baidu.swan.apps.core.f.d
                public void ff(String str) {
                    super.ff(str);
                    if (SwanAppScopeDetailActivity.this.bzA) {
                        SwanAppScopeDetailActivity.this.setTitle(str);
                    }
                }
            });
            this.bzz = bo.QE();
            bo.loadUrl(this.mUrl);
            bo.a((FrameLayout) findViewById(a.f.webview_container), this.bzz.covertToView());
        }
    }

    public void X(int i, int i2) {
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
        if (this.bzz != null) {
            this.bzz.destroy();
            this.bzz = null;
        }
        this.mUrl = null;
    }
}
