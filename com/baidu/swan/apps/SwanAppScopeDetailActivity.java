package com.baidu.swan.apps;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.dn3;
import com.baidu.tieba.lm3;
import com.baidu.tieba.ts2;
import com.baidu.tieba.tv1;
import com.baidu.tieba.vv1;
import com.baidu.tieba.wp1;
import com.baidu.tieba.xa2;
/* loaded from: classes3.dex */
public class SwanAppScopeDetailActivity extends SwanAppBaseActivity {
    public static final boolean q = wp1.a;
    public tv1 m;
    public String n;
    public int o = 0;
    public int p = 0;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            SwanAppScopeDetailActivity.this.finish();
        }
    }

    /* loaded from: classes3.dex */
    public class b extends xa2 {
        public b() {
        }

        @Override // com.baidu.tieba.xa2, com.baidu.tieba.ab2
        public void d(String str) {
            super.d(str);
            if (!TextUtils.isEmpty(str)) {
                ((TextView) SwanAppScopeDetailActivity.this.findViewById(R.id.obfuscated_res_0x7f0923a4)).setText(str);
            }
        }
    }

    public final void A() {
        findViewById(R.id.obfuscated_res_0x7f090319).setOnClickListener(new a());
    }

    public final void E() {
        if (this.o != 0 || this.p != 0) {
            overridePendingTransition(this.o, this.p);
            this.o = 0;
            this.p = 0;
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        E();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        tv1 tv1Var = this.m;
        if (tv1Var != null) {
            tv1Var.destroy();
            this.m = null;
        }
        this.n = null;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.baidu.tieba.tv1] */
    public final void B() {
        if (TextUtils.isEmpty(this.n)) {
            return;
        }
        vv1 c = ts2.F0().c(this);
        c.Y(new b());
        this.m = c.r();
        c.loadUrl(this.n);
        c.j((FrameLayout) findViewById(R.id.webview_container), this.m.covertToView());
    }

    public void C(Intent intent) {
        if (intent == null) {
            return;
        }
        this.n = lm3.h(intent, "url");
        if (q) {
            Log.d("ScopeDetailActivity", "mUrl=" + this.n);
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.cn4, android.app.Activity
    public void onCreate(Bundle bundle) {
        D(R.anim.obfuscated_res_0x7f01001c, R.anim.obfuscated_res_0x7f010025);
        super.onCreate(bundle);
        setContentView(R.layout.obfuscated_res_0x7f0d088a);
        dn3.a(this);
        C(getIntent());
        A();
        B();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        C(intent);
    }

    public void D(int i, int i2) {
        this.o = i;
        this.p = i2;
    }
}
