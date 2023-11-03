package com.baidu.swan.apps;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.fj3;
import com.baidu.tieba.np2;
import com.baidu.tieba.os1;
import com.baidu.tieba.qs1;
import com.baidu.tieba.r72;
import com.baidu.tieba.rm1;
import com.baidu.tieba.xj3;
/* loaded from: classes4.dex */
public class SwanAppScopeDetailActivity extends SwanAppBaseActivity {
    public static final boolean q = rm1.a;
    public os1 m;
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
    public class b extends r72 {
        public b() {
        }

        @Override // com.baidu.tieba.r72, com.baidu.tieba.u72
        public void d(String str) {
            super.d(str);
            if (!TextUtils.isEmpty(str)) {
                ((TextView) SwanAppScopeDetailActivity.this.findViewById(R.id.obfuscated_res_0x7f0925fe)).setText(str);
            }
        }
    }

    public final void C() {
        findViewById(R.id.obfuscated_res_0x7f09033b).setOnClickListener(new a());
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
        os1 os1Var = this.m;
        if (os1Var != null) {
            os1Var.destroy();
            this.m = null;
        }
        this.n = null;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.baidu.tieba.os1] */
    public final void D() {
        if (TextUtils.isEmpty(this.n)) {
            return;
        }
        qs1 c = np2.F0().c(this);
        c.V(new b());
        this.m = c.getWebView();
        c.loadUrl(this.n);
        c.i((FrameLayout) findViewById(R.id.webview_container), this.m.covertToView());
    }

    public void E(Intent intent) {
        if (intent == null) {
            return;
        }
        this.n = fj3.h(intent, "url");
        if (q) {
            Log.d("ScopeDetailActivity", "mUrl=" + this.n);
        }
    }

    @Override // com.baidu.swan.apps.SwanAppBaseActivity, com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.vj4, android.app.Activity
    public void onCreate(Bundle bundle) {
        F(R.anim.obfuscated_res_0x7f01001d, R.anim.obfuscated_res_0x7f010026);
        super.onCreate(bundle);
        setContentView(R.layout.obfuscated_res_0x7f0d0953);
        xj3.a(this);
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
