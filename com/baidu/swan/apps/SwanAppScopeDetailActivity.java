package com.baidu.swan.apps;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.er2;
import com.baidu.tieba.eu1;
import com.baidu.tieba.gu1;
import com.baidu.tieba.ho1;
import com.baidu.tieba.i92;
import com.baidu.tieba.ol3;
import com.baidu.tieba.wk3;
/* loaded from: classes3.dex */
public class SwanAppScopeDetailActivity extends SwanAppBaseActivity {
    public static final boolean q = ho1.a;
    public eu1 m;
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
    public class b extends i92 {
        public b() {
        }

        @Override // com.baidu.tieba.i92, com.baidu.tieba.l92
        public void d(String str) {
            super.d(str);
            if (!TextUtils.isEmpty(str)) {
                ((TextView) SwanAppScopeDetailActivity.this.findViewById(R.id.obfuscated_res_0x7f09240b)).setText(str);
            }
        }
    }

    public final void C() {
        findViewById(R.id.obfuscated_res_0x7f090315).setOnClickListener(new a());
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
        eu1 eu1Var = this.m;
        if (eu1Var != null) {
            eu1Var.destroy();
            this.m = null;
        }
        this.n = null;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.baidu.tieba.eu1] */
    public final void D() {
        if (TextUtils.isEmpty(this.n)) {
            return;
        }
        gu1 c = er2.F0().c(this);
        c.Y(new b());
        this.m = c.s();
        c.loadUrl(this.n);
        c.j((FrameLayout) findViewById(R.id.webview_container), this.m.covertToView());
    }

    public void E(Intent intent) {
        if (intent == null) {
            return;
        }
        this.n = wk3.h(intent, "url");
        if (q) {
            Log.d("ScopeDetailActivity", "mUrl=" + this.n);
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.nl4, android.app.Activity
    public void onCreate(Bundle bundle) {
        F(R.anim.obfuscated_res_0x7f01001c, R.anim.obfuscated_res_0x7f010025);
        super.onCreate(bundle);
        setContentView(R.layout.obfuscated_res_0x7f0d08ab);
        ol3.a(this);
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
