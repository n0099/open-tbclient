package com.baidu.swan.apps;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import d.b.g0.a.f;
import d.b.g0.a.g;
import d.b.g0.a.i2.h0;
import d.b.g0.a.i2.u;
import d.b.g0.a.k;
import d.b.g0.a.p.d.c;
import d.b.g0.a.p.d.e;
/* loaded from: classes2.dex */
public class SwanAppScopeDetailActivity extends SwanAppBaseActivity {
    public static final boolean DEBUG = k.f45051a;
    public static final int INVALID_ANIM = 0;
    public static final String TAG = "ScopeDetailActivity";
    public c mNgWebView;
    public String mUrl;
    public boolean mIsReceivedTitle = true;
    public int mEnterAnimWhenFinishing = 0;
    public int mExitAnimWhenFinishing = 0;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SwanAppScopeDetailActivity.this.finish();
        }
    }

    /* loaded from: classes2.dex */
    public class b extends d.b.g0.a.e0.n.a {
        public b() {
        }

        @Override // d.b.g0.a.e0.n.a, d.b.g0.a.e0.n.d
        public void a(String str) {
            super.a(str);
            if (SwanAppScopeDetailActivity.this.mIsReceivedTitle) {
                SwanAppScopeDetailActivity.this.setTitle(str);
            }
        }
    }

    private void initView() {
        findViewById(f.back).setOnClickListener(new a());
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [d.b.g0.a.p.d.c] */
    private void initWebView() {
        if (TextUtils.isEmpty(this.mUrl)) {
            return;
        }
        e i = new d.b.g0.a.p.d.j.b().i(this);
        i.P(new b());
        this.mNgWebView = i.getWebView();
        i.loadUrl(this.mUrl);
        i.m((FrameLayout) findViewById(f.webview_container), this.mNgWebView.covertToView());
    }

    private void startExitActivityAnim() {
        if (this.mEnterAnimWhenFinishing == 0 && this.mExitAnimWhenFinishing == 0) {
            return;
        }
        overridePendingTransition(this.mEnterAnimWhenFinishing, this.mExitAnimWhenFinishing);
        this.mEnterAnimWhenFinishing = 0;
        this.mExitAnimWhenFinishing = 0;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        startExitActivityAnim();
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, d.b.g0.m.a.a.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        setPendingTransition(d.b.g0.a.a.aiapps_hold, d.b.g0.a.a.aiapps_slide_out_to_right);
        super.onCreate(bundle);
        setContentView(g.swanapp_scope_detail_activity);
        h0.a(this);
        parseIntent(getIntent());
        initView();
        initWebView();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        c cVar = this.mNgWebView;
        if (cVar != null) {
            cVar.destroy();
            this.mNgWebView = null;
        }
        this.mUrl = null;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        parseIntent(intent);
    }

    public void parseIntent(Intent intent) {
        if (intent == null) {
            return;
        }
        this.mUrl = u.h(intent, "url");
        if (DEBUG) {
            Log.d(TAG, "mUrl=" + this.mUrl);
        }
    }

    public void setIsReceivedTitle(boolean z) {
        this.mIsReceivedTitle = z;
    }

    public void setPendingTransition(int i, int i2) {
        this.mEnterAnimWhenFinishing = i;
        this.mExitAnimWhenFinishing = i2;
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ((TextView) findViewById(f.title)).setText(str);
    }
}
