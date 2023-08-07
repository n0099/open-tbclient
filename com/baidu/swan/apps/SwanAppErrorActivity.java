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
import com.baidu.tieba.fa2;
import com.baidu.tieba.fu2;
import com.baidu.tieba.id3;
import com.baidu.tieba.ir1;
import com.baidu.tieba.ng3;
import com.baidu.tieba.so3;
import com.baidu.tieba.vv2;
import com.baidu.tieba.wo4;
import com.baidu.tieba.x73;
import com.baidu.tieba.z73;
/* loaded from: classes4.dex */
public class SwanAppErrorActivity extends FragmentActivity {
    public static final boolean u = ir1.a;
    public vv2 j;
    public ForbiddenInfo k;
    public String l;
    public int p;
    public int q;
    public String s;
    public int t;
    public ng3 m = null;
    public int n = 0;
    public int o = 0;
    public String r = "";

    public final void D() {
        if (this.n != 0 || this.o != 0) {
            overridePendingTransition(this.n, this.o);
            this.n = 0;
            this.o = 0;
        }
    }

    public void E() {
        A(fu2.M().a());
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        D();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        E();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        x73 i;
        super.onStart();
        if (TextUtils.equals(this.l, "type_app_forbidden") && (i = z73.k().i(this.k.appId)) != null && i.E()) {
            id3.K(this.k.appId);
        }
    }

    public ForbiddenInfo x() {
        return this.k;
    }

    public vv2 y() {
        return this.j;
    }

    public void A(boolean z) {
        Window window = getWindow();
        if (window == null) {
            if (u) {
                Log.e("SwanAppErrorActivity", "activity or window is null");
                return;
            }
            return;
        }
        if (this.m == null) {
            this.m = new ng3();
        }
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (z) {
            this.m.a(viewGroup);
        } else {
            this.m.b(viewGroup);
        }
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, com.baidu.tieba.oo4, android.app.Activity
    public void onCreate(Bundle bundle) {
        C(R.anim.obfuscated_res_0x7f01001d, R.anim.obfuscated_res_0x7f010024);
        int c0 = so3.c0(this);
        super.onCreate(bundle);
        so3.g(this, c0);
        setContentView(R.layout.obfuscated_res_0x7f0d00a5);
        B(getIntent());
        z();
    }

    @Override // com.baidu.swan.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        B(intent);
        z();
    }

    public final void B(Intent intent) {
        ForbiddenInfo forbiddenInfo;
        if (intent == null) {
            return;
        }
        this.j = vv2.d1(intent);
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

    public final void C(int i, int i2) {
        this.n = i;
        this.o = i2;
    }

    public final void z() {
        fa2 fa2Var;
        wo4 a = k().a();
        if (getIntent() != null) {
            fa2Var = fa2.h3(this.r, this.l, this.s, this.t, this.k, this.p, this.q);
        } else if (this.j == null) {
            if (u) {
                Log.e("SwanAppErrorActivity", "launchInfo is null,error");
                return;
            }
            return;
        } else {
            fa2Var = new fa2();
        }
        a.a(R.id.obfuscated_res_0x7f090188, fa2Var);
        a.e();
    }
}
