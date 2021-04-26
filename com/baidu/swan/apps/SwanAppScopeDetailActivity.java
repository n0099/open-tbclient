package com.baidu.swan.apps;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import d.a.h0.a.f;
import d.a.h0.a.g;
import d.a.h0.a.i2.h0;
import d.a.h0.a.i2.u;
import d.a.h0.a.k;
import d.a.h0.a.p.d.c;
import d.a.h0.a.p.d.e;
/* loaded from: classes.dex */
public class SwanAppScopeDetailActivity extends SwanAppBaseActivity {
    public static final boolean DEBUG = k.f43101a;
    public static final int INVALID_ANIM = 0;
    public static final String TAG = "ScopeDetailActivity";
    public c mNgWebView;
    public String mUrl;
    public boolean mIsReceivedTitle = true;
    public int mEnterAnimWhenFinishing = 0;
    public int mExitAnimWhenFinishing = 0;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SwanAppScopeDetailActivity.this.finish();
        }
    }

    /* loaded from: classes.dex */
    public class b extends d.a.h0.a.e0.n.a {
        public b() {
        }

        @Override // d.a.h0.a.e0.n.a, d.a.h0.a.e0.n.d
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

    /* JADX WARN: Type inference failed for: r1v1, types: [d.a.h0.a.p.d.c] */
    private void initWebView() {
        if (TextUtils.isEmpty(this.mUrl)) {
            return;
        }
        e i2 = new d.a.h0.a.p.d.j.b().i(this);
        i2.X(new b());
        this.mNgWebView = i2.s();
        i2.loadUrl(this.mUrl);
        i2.k((FrameLayout) findViewById(f.webview_container), this.mNgWebView.covertToView());
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

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, d.a.h0.m.a.a.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        setPendingTransition(d.a.h0.a.a.aiapps_hold, d.a.h0.a.a.aiapps_slide_out_to_right);
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

    public void setPendingTransition(int i2, int i3) {
        this.mEnterAnimWhenFinishing = i2;
        this.mExitAnimWhenFinishing = i3;
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ((TextView) findViewById(f.title)).setText(str);
    }
}
