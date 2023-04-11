package com.baidu.swan.apps;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tbadk.core.util.schemeaction.deeplink.DeepLinkItem;
import com.baidu.tieba.R;
import com.baidu.tieba.b72;
import com.baidu.tieba.br2;
import com.baidu.tieba.ea3;
import com.baidu.tieba.eo1;
import com.baidu.tieba.jd3;
import com.baidu.tieba.ol3;
import com.baidu.tieba.rs2;
import com.baidu.tieba.sl4;
import com.baidu.tieba.t43;
import com.baidu.tieba.v43;
/* loaded from: classes3.dex */
public class SwanAppErrorActivity extends FragmentActivity {
    public static final boolean u = eo1.a;
    public rs2 j;
    public ForbiddenInfo k;
    public String l;
    public int p;
    public int q;
    public String s;
    public int t;
    public jd3 m = null;
    public int n = 0;
    public int o = 0;
    public String r = "";

    public final void E() {
        if (this.n != 0 || this.o != 0) {
            overridePendingTransition(this.n, this.o);
            this.n = 0;
            this.o = 0;
        }
    }

    public void F() {
        B(br2.M().a());
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        E();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        F();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        t43 i;
        super.onStart();
        if (TextUtils.equals(this.l, "type_app_forbidden") && (i = v43.k().i(this.k.appId)) != null && i.E()) {
            ea3.K(this.k.appId);
        }
    }

    public ForbiddenInfo y() {
        return this.k;
    }

    public rs2 z() {
        return this.j;
    }

    public final void A() {
        b72 b72Var;
        sl4 a = l().a();
        if (getIntent() != null) {
            b72Var = b72.i3(this.r, this.l, this.s, this.t, this.k, this.p, this.q);
        } else if (this.j == null) {
            if (u) {
                Log.e("SwanAppErrorActivity", "launchInfo is null,error");
                return;
            }
            return;
        } else {
            b72Var = new b72();
        }
        a.a(R.id.obfuscated_res_0x7f09017b, b72Var);
        a.e();
    }

    public void B(boolean z) {
        Window window = getWindow();
        if (window == null) {
            if (u) {
                Log.e("SwanAppErrorActivity", "activity or window is null");
                return;
            }
            return;
        }
        if (this.m == null) {
            this.m = new jd3();
        }
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (z) {
            this.m.a(viewGroup);
        } else {
            this.m.b(viewGroup);
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.kl4, android.app.Activity
    public void onCreate(Bundle bundle) {
        D(R.anim.obfuscated_res_0x7f01001c, R.anim.obfuscated_res_0x7f010023);
        int c0 = ol3.c0(this);
        super.onCreate(bundle);
        ol3.g(this, c0);
        setContentView(R.layout.obfuscated_res_0x7f0d00a3);
        C(getIntent());
        A();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        C(intent);
        A();
    }

    public final void C(Intent intent) {
        ForbiddenInfo forbiddenInfo;
        if (intent == null) {
            return;
        }
        this.j = rs2.d1(intent);
        this.k = (ForbiddenInfo) intent.getParcelableExtra("swan_error_forbidden_info");
        this.p = intent.getIntExtra("swan_error_menu_notice_count", 0);
        this.q = intent.getIntExtra("swan_error_menu_privacy_count", 0);
        this.s = intent.getStringExtra(DeepLinkItem.DEEPLINK_WEBURL_KEY);
        this.t = intent.getIntExtra("webPermit", -1);
        this.r = intent.getStringExtra("swan_error_code");
        if (TextUtils.isEmpty(this.j.H()) && (forbiddenInfo = this.k) != null) {
            this.j.v0(forbiddenInfo.appId);
        }
        this.l = intent.getStringExtra("swan_error_type");
    }

    public final void D(int i, int i2) {
        this.n = i;
        this.o = i2;
    }
}
