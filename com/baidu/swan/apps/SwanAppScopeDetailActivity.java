package com.baidu.swan.apps;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.fu2;
import com.baidu.tieba.fx1;
import com.baidu.tieba.hx1;
import com.baidu.tieba.ir1;
import com.baidu.tieba.jc2;
import com.baidu.tieba.po3;
import com.baidu.tieba.xn3;
/* loaded from: classes4.dex */
public class SwanAppScopeDetailActivity extends SwanAppBaseActivity {
    public static final boolean q = ir1.a;
    public fx1 m;
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
    public class b extends jc2 {
        public b() {
        }

        @Override // com.baidu.tieba.jc2, com.baidu.tieba.mc2
        public void d(String str) {
            super.d(str);
            if (!TextUtils.isEmpty(str)) {
                ((TextView) SwanAppScopeDetailActivity.this.findViewById(R.id.obfuscated_res_0x7f092560)).setText(str);
            }
        }
    }

    public final void B() {
        findViewById(R.id.obfuscated_res_0x7f090323).setOnClickListener(new a());
    }

    public final void F() {
        if (this.o != 0 || this.p != 0) {
            overridePendingTransition(this.o, this.p);
            this.o = 0;
            this.p = 0;
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        F();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        fx1 fx1Var = this.m;
        if (fx1Var != null) {
            fx1Var.destroy();
            this.m = null;
        }
        this.n = null;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.baidu.tieba.fx1] */
    public final void C() {
        if (TextUtils.isEmpty(this.n)) {
            return;
        }
        hx1 c = fu2.F0().c(this);
        c.W(new b());
        this.m = c.r();
        c.loadUrl(this.n);
        c.i((FrameLayout) findViewById(R.id.webview_container), this.m.covertToView());
    }

    public void D(Intent intent) {
        if (intent == null) {
            return;
        }
        this.n = xn3.h(intent, "url");
        if (q) {
            Log.d("ScopeDetailActivity", "mUrl=" + this.n);
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.oo4, android.app.Activity
    public void onCreate(Bundle bundle) {
        E(R.anim.obfuscated_res_0x7f01001d, R.anim.obfuscated_res_0x7f010026);
        super.onCreate(bundle);
        setContentView(R.layout.obfuscated_res_0x7f0d092f);
        po3.a(this);
        D(getIntent());
        B();
        C();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        D(intent);
    }

    public void E(int i, int i2) {
        this.o = i;
        this.p = i2;
    }
}
