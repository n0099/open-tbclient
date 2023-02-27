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
import com.baidu.tieba.bf3;
import com.baidu.tieba.gn3;
import com.baidu.tieba.ju2;
import com.baidu.tieba.kn4;
import com.baidu.tieba.l63;
import com.baidu.tieba.n63;
import com.baidu.tieba.t82;
import com.baidu.tieba.ts2;
import com.baidu.tieba.wb3;
import com.baidu.tieba.wp1;
/* loaded from: classes3.dex */
public class SwanAppErrorActivity extends FragmentActivity {
    public static final boolean u = wp1.a;
    public ju2 j;
    public ForbiddenInfo k;
    public String l;
    public int p;
    public int q;
    public String s;
    public int t;
    public bf3 m = null;
    public int n = 0;
    public int o = 0;
    public String r = "";

    public final void C() {
        if (this.n != 0 || this.o != 0) {
            overridePendingTransition(this.n, this.o);
            this.n = 0;
            this.o = 0;
        }
    }

    public void D() {
        z(ts2.M().a());
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        C();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        D();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        l63 i;
        super.onStart();
        if (TextUtils.equals(this.l, "type_app_forbidden") && (i = n63.k().i(this.k.appId)) != null && i.E()) {
            wb3.K(this.k.appId);
        }
    }

    public ForbiddenInfo w() {
        return this.k;
    }

    public ju2 x() {
        return this.j;
    }

    public final void A(Intent intent) {
        ForbiddenInfo forbiddenInfo;
        if (intent == null) {
            return;
        }
        this.j = ju2.d1(intent);
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

    public final void B(int i, int i2) {
        this.n = i;
        this.o = i2;
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.cn4, android.app.Activity
    public void onCreate(Bundle bundle) {
        B(R.anim.obfuscated_res_0x7f01001c, R.anim.obfuscated_res_0x7f010023);
        int c0 = gn3.c0(this);
        super.onCreate(bundle);
        gn3.g(this, c0);
        setContentView(R.layout.obfuscated_res_0x7f0d00a2);
        A(getIntent());
        y();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        A(intent);
        y();
    }

    public void z(boolean z) {
        Window window = getWindow();
        if (window == null) {
            if (u) {
                Log.e("SwanAppErrorActivity", "activity or window is null");
                return;
            }
            return;
        }
        if (this.m == null) {
            this.m = new bf3();
        }
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (z) {
            this.m.a(viewGroup);
        } else {
            this.m.b(viewGroup);
        }
    }

    public final void y() {
        t82 t82Var;
        kn4 a = l().a();
        if (getIntent() != null) {
            t82Var = t82.f3(this.r, this.l, this.s, this.t, this.k, this.p, this.q);
        } else if (this.j == null) {
            if (u) {
                Log.e("SwanAppErrorActivity", "launchInfo is null,error");
                return;
            }
            return;
        } else {
            t82Var = new t82();
        }
        a.a(R.id.obfuscated_res_0x7f090176, t82Var);
        a.e();
    }
}
