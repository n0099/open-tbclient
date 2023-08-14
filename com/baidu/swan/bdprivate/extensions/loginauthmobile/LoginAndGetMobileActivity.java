package com.baidu.swan.bdprivate.extensions.loginauthmobile;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.fu2;
import com.baidu.tieba.qa3;
import com.baidu.tieba.so3;
import com.baidu.tieba.ws3;
import com.baidu.tieba.xs3;
import com.baidu.tieba.ys3;
import com.baidu.tieba.zn3;
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
            zn3.a(loginAndGetMobileActivity, loginAndGetMobileActivity.getWindow().getDecorView().getWindowToken());
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        if (this.d instanceof SwanAppPhoneLoginDialog) {
            zn3.a(this, getWindow().getDecorView().getWindowToken());
        }
        overridePendingTransition(0, R.anim.obfuscated_res_0x7f0100b6);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        if (this.d instanceof SwanAppPhoneLoginDialog) {
            so3.e0(new a());
        }
        super.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        boolean a2 = fu2.M().a();
        if (this.c != a2) {
            SwanAppLoginAndGetMobileDialog swanAppLoginAndGetMobileDialog = this.d;
            if (swanAppLoginAndGetMobileDialog != null) {
                swanAppLoginAndGetMobileDialog.M1(a2);
            }
            this.c = a2;
        }
        super.onResume();
    }

    public final void s1() {
        t1();
        u1();
    }

    public final void t1() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091f71);
        this.a = linearLayout;
        linearLayout.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f060b92));
        this.a.getBackground().mutate().setAlpha(0);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        int c0 = so3.c0(this);
        super.onCreate(bundle);
        so3.g(this, c0);
        getWindow().addFlags(256);
        getWindow().addFlags(512);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.flags &= -1025;
        getWindow().setAttributes(attributes);
        setContentView(R.layout.obfuscated_res_0x7f0d00be);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.b = extras.getString("app_name", "");
            this.e = (QuickLoginInfo) extras.getParcelable("quick_login_info");
            this.f = extras.getString("launch_from");
            this.g = extras.getString("appid");
        }
        this.c = fu2.M().a();
        s1();
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog.b
    public void onLoginResult(int i) {
        ws3.a().onResult(i);
        if (i != 0) {
            qa3.f(this, R.string.obfuscated_res_0x7f0f152d).H(true);
        } else {
            finish();
        }
    }

    @Override // com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppLoginAndGetMobileDialog.b
    public void w0(boolean z) {
        if (z) {
            finish();
        }
    }

    public final void u1() {
        String str;
        String str2;
        this.d = ys3.a(this.b, this.c, this.e, this.f, this.g);
        QuickLoginInfo quickLoginInfo = this.e;
        if (quickLoginInfo != null && quickLoginInfo.supportQuickLogin) {
            str = "swan_quick_login";
            str2 = "quickLogin";
        } else {
            str = "swan_phone_login";
            str2 = "telLogin";
        }
        this.d.O1(this);
        this.d.Q1(this);
        this.d.show(getSupportFragmentManager(), str);
        xs3.a("show", str2, null, this.f, this.g);
    }
}
