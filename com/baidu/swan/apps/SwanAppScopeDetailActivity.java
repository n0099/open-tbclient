package com.baidu.swan.apps;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.fm3;
import com.baidu.tieba.ns2;
import com.baidu.tieba.nv1;
import com.baidu.tieba.pv1;
import com.baidu.tieba.qp1;
import com.baidu.tieba.ra2;
import com.baidu.tieba.xm3;
/* loaded from: classes4.dex */
public class SwanAppScopeDetailActivity extends SwanAppBaseActivity {
    public static final boolean q = qp1.a;
    public nv1 m;
    public String n;
    public int o = 0;
    public int p = 0;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            SwanAppScopeDetailActivity.this.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends ra2 {
        public b() {
        }

        @Override // com.baidu.tieba.ra2, com.baidu.tieba.ua2
        public void d(String str) {
            super.d(str);
            if (!TextUtils.isEmpty(str)) {
                ((TextView) SwanAppScopeDetailActivity.this.findViewById(R.id.obfuscated_res_0x7f09246f)).setText(str);
            }
        }
    }

    public final void C() {
        findViewById(R.id.obfuscated_res_0x7f090322).setOnClickListener(new a());
    }

    public final void G() {
        if (this.o != 0 || this.p != 0) {
            overridePendingTransition(this.o, this.p);
            this.o = 0;
            this.p = 0;
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        G();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        nv1 nv1Var = this.m;
        if (nv1Var != null) {
            nv1Var.destroy();
            this.m = null;
        }
        this.n = null;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.baidu.tieba.nv1] */
    public final void D() {
        if (TextUtils.isEmpty(this.n)) {
            return;
        }
        pv1 c = ns2.F0().c(this);
        c.Y(new b());
        this.m = c.r();
        c.loadUrl(this.n);
        c.j((FrameLayout) findViewById(R.id.webview_container), this.m.covertToView());
    }

    public void E(Intent intent) {
        if (intent == null) {
            return;
        }
        this.n = fm3.h(intent, "url");
        if (q) {
            Log.d("ScopeDetailActivity", "mUrl=" + this.n);
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.wm4, android.app.Activity
    public void onCreate(Bundle bundle) {
        F(R.anim.obfuscated_res_0x7f01001d, R.anim.obfuscated_res_0x7f010026);
        super.onCreate(bundle);
        setContentView(R.layout.obfuscated_res_0x7f0d08dc);
        xm3.a(this);
        E(getIntent());
        C();
        D();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        E(intent);
    }

    public void F(int i, int i2) {
        this.o = i;
        this.p = i2;
    }
}
