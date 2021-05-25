package com.baidu.swan.apps;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import d.a.l0.a.f;
import d.a.l0.a.g;
import d.a.l0.a.k;
import d.a.l0.a.p.e.c;
import d.a.l0.a.p.e.e;
import d.a.l0.a.v2.n0;
import d.a.l0.a.v2.v;
/* loaded from: classes2.dex */
public class SwanAppScopeDetailActivity extends SwanAppBaseActivity {
    public static final boolean DEBUG = k.f43199a;
    public static final int INVALID_ANIM = 0;
    public static final String TAG = "ScopeDetailActivity";
    public int mEnterAnimWhenFinishing = 0;
    public int mExitAnimWhenFinishing = 0;
    public c mNgWebView;
    public String mUrl;

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
    public class b extends d.a.l0.a.h0.j.a {
        public b() {
        }

        @Override // d.a.l0.a.h0.j.a, d.a.l0.a.h0.j.d
        public void a(String str) {
            super.a(str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            ((TextView) SwanAppScopeDetailActivity.this.findViewById(f.title)).setText(str);
        }
    }

    private void initView() {
        findViewById(f.back).setOnClickListener(new a());
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [d.a.l0.a.p.e.c] */
    private void initWebView() {
        if (TextUtils.isEmpty(this.mUrl)) {
            return;
        }
        e h2 = new d.a.l0.a.p.e.j.b().h(this);
        h2.Z(new b());
        this.mNgWebView = h2.u();
        h2.loadUrl(this.mUrl);
        h2.l((FrameLayout) findViewById(f.webview_container), this.mNgWebView.covertToView());
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

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, d.a.l0.o.a.a.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        setPendingTransition(d.a.l0.a.a.aiapps_hold, d.a.l0.a.a.aiapps_slide_out_to_right);
        super.onCreate(bundle);
        setContentView(g.swanapp_scope_detail_activity);
        n0.a(this);
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
        this.mUrl = v.h(intent, "url");
        if (DEBUG) {
            Log.d(TAG, "mUrl=" + this.mUrl);
        }
    }

    public void setPendingTransition(int i2, int i3) {
        this.mEnterAnimWhenFinishing = i2;
        this.mExitAnimWhenFinishing = i3;
    }
}
