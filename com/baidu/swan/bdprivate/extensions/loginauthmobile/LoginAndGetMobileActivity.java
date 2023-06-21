package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.ap3;
import com.baidu.tieba.gv2;
import com.baidu.tieba.rb3;
import com.baidu.tieba.tp3;
import com.baidu.tieba.xt3;
import com.baidu.tieba.yt3;
import com.baidu.tieba.zt3;
/* loaded from: classes4.dex */
public class LoginAndGetMobileActivity extends FragmentActivity implements SwanAppLoginAndGetMobileDialog.b {
    public LinearLayout a;
    public String b = "";
    public boolean c = false;
    public SwanAppLoginAndGetMobileDialog d;
    public QuickLoginInfo e;
    public String f;
    public String g;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LoginAndGetMobileActivity loginAndGetMobileActivity = LoginAndGetMobileActivity.this;
            ap3.a(loginAndGetMobileActivity, loginAndGetMobileActivity.getWindow().getDecorView().getWindowToken());
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        if (this.d instanceof SwanAppPhoneLoginDialog) {
            ap3.a(this, getWindow().getDecorView().getWindowToken());
        }
        overridePendingTransition(0, R.anim.obfuscated_res_0x7f0100b4);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        if (this.d instanceof SwanAppPhoneLoginDialog) {
            tp3.e0(new a());
        }
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        boolean a2 = gv2.M().a();
        if (this.c != a2) {
            SwanAppLoginAndGetMobileDialog swanAppLoginAndGetMobileDialog = this.d;
            if (swanAppLoginAndGetMobileDialog != null) {
                swanAppLoginAndGetMobileDialog.L1(a2);
            }
            this.c = a2;
        }
        super.onResume();
    }

    public final void t1() {
        u1();
        v1();
    }

    public final void u1() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091ec5);
        this.a = linearLayout;
        linearLayout.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f060b89));
        this.a.getBackground().mutate().setAlpha(0);
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog.b
    public void B0(boolean z) {
        if (z) {
            finish();
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog.b
    public void onLoginResult(int i) {
        xt3.a().onResult(i);
        if (i != 0) {
            rb3.f(this, R.string.obfuscated_res_0x7f0f14f6).H(true);
        } else {
            finish();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int c0 = tp3.c0(this);
        super.onCreate(bundle);
        tp3.g(this, c0);
        getWindow().addFlags(256);
        getWindow().addFlags(512);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.flags &= -1025;
        getWindow().setAttributes(attributes);
        setContentView(R.layout.obfuscated_res_0x7f0d00bf);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.b = extras.getString("app_name", "");
            this.e = (QuickLoginInfo) extras.getParcelable("quick_login_info");
            this.f = extras.getString("launch_from");
            this.g = extras.getString("appid");
        }
        this.c = gv2.M().a();
        t1();
    }

    public final void v1() {
        String str;
        String str2;
        this.d = zt3.a(this.b, this.c, this.e, this.f, this.g);
        QuickLoginInfo quickLoginInfo = this.e;
        if (quickLoginInfo != null && quickLoginInfo.supportQuickLogin) {
            str = "swan_quick_login";
            str2 = "quickLogin";
        } else {
            str = "swan_phone_login";
            str2 = "telLogin";
        }
        this.d.N1(this);
        this.d.P1(this);
        this.d.show(getSupportFragmentManager(), str);
        yt3.a("show", str2, null, this.f, this.g);
    }
}
