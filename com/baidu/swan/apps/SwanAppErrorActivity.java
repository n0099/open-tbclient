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
import com.baidu.tieba.ek3;
import com.baidu.tieba.hk4;
import com.baidu.tieba.hr2;
import com.baidu.tieba.j33;
import com.baidu.tieba.l33;
import com.baidu.tieba.r52;
import com.baidu.tieba.rp2;
import com.baidu.tieba.u83;
import com.baidu.tieba.vm1;
import com.baidu.tieba.zb3;
/* loaded from: classes4.dex */
public class SwanAppErrorActivity extends FragmentActivity {
    public static final boolean u = vm1.a;
    public hr2 j;
    public ForbiddenInfo k;
    public String l;
    public int p;
    public int q;
    public String s;
    public int t;
    public zb3 m = null;
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
        B(rp2.M().a());
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
        j33 i;
        super.onStart();
        if (TextUtils.equals(this.l, "type_app_forbidden") && (i = l33.k().i(this.k.appId)) != null && i.E()) {
            u83.K(this.k.appId);
        }
    }

    public ForbiddenInfo y() {
        return this.k;
    }

    public hr2 z() {
        return this.j;
    }

    public final void A() {
        r52 r52Var;
        hk4 a = k().a();
        if (getIntent() != null) {
            r52Var = r52.m3(this.r, this.l, this.s, this.t, this.k, this.p, this.q);
        } else if (this.j == null) {
            if (u) {
                Log.e("SwanAppErrorActivity", "launchInfo is null,error");
                return;
            }
            return;
        } else {
            r52Var = new r52();
        }
        a.a(R.id.obfuscated_res_0x7f09019a, r52Var);
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
            this.m = new zb3();
        }
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (z) {
            this.m.a(viewGroup);
        } else {
            this.m.b(viewGroup);
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.zj4, android.app.Activity
    public void onCreate(Bundle bundle) {
        D(R.anim.obfuscated_res_0x7f01001d, R.anim.obfuscated_res_0x7f010024);
        int c0 = ek3.c0(this);
        super.onCreate(bundle);
        ek3.g(this, c0);
        setContentView(R.layout.obfuscated_res_0x7f0d00aa);
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
        this.j = hr2.e1(intent);
        this.k = (ForbiddenInfo) intent.getParcelableExtra("swan_error_forbidden_info");
        this.p = intent.getIntExtra("swan_error_menu_notice_count", 0);
        this.q = intent.getIntExtra("swan_error_menu_privacy_count", 0);
        this.s = intent.getStringExtra(DeepLinkItem.DEEPLINK_WEBURL_KEY);
        this.t = intent.getIntExtra("webPermit", -1);
        this.r = intent.getStringExtra("swan_error_code");
        if (TextUtils.isEmpty(this.j.I()) && (forbiddenInfo = this.k) != null) {
            this.j.w0(forbiddenInfo.appId);
        }
        this.l = intent.getStringExtra("swan_error_type");
    }

    public final void D(int i, int i2) {
        this.n = i;
        this.o = i2;
    }
}
