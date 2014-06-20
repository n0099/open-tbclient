package com.baidu.tbadk.coreExtra.act;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.download.CancelDownloadMessage;
/* loaded from: classes.dex */
public class LoginActivity extends BaseActivity {
    private static boolean d = false;
    private SapiWebView a;
    private boolean b = false;
    private com.baidu.tbadk.coreExtra.view.q c = null;
    private final com.baidu.tbadk.core.account.g e = new ak(this);

    static {
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.ai.class, LoginActivity.class);
        a();
    }

    public static void a() {
        if (Build.VERSION.SDK_INT < 9 || TbConfig.USE_OLD_LOGIN || !TbadkApplication.m252getInst().isPassportV6ShouldOpen()) {
            d = true;
        } else {
            d = false;
        }
    }

    public static void a(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        if (d) {
            intent = new Intent(context, Login2Activity.class);
            intent.putExtra("has_exit_dialog", false);
        }
        context.startActivity(intent);
    }

    public static void a(Activity activity, int i, String str, int i2) {
        Intent intent = new Intent(activity, LoginActivity.class);
        if (d) {
            intent = new Intent(activity, Login2Activity.class);
            intent.putExtra("has_exit_dialog", false);
            intent.putExtra("info", str);
        }
        intent.putExtra("locate_type", i);
        activity.startActivityForResult(intent, i2);
    }

    public static void a(Activity activity, String str, boolean z, int i) {
        Intent intent = new Intent(activity, LoginActivity.class);
        if (d) {
            intent = new Intent(activity, Login2Activity.class);
            intent.putExtra("has_exit_dialog", false);
            intent.putExtra("info", str);
        }
        intent.putExtra("close", z);
        activity.startActivityForResult(intent, i);
    }

    public static void a(Context context, String str) {
        Intent intent = new Intent(context, LoginActivity.class);
        if (d) {
            intent = new Intent(context, Login2Activity.class);
            intent.putExtra("account", str);
            intent.putExtra("has_exit_dialog", false);
        }
        context.startActivity(intent);
    }

    public static void a(Context context, int i) {
        Intent intent = new Intent(context, LoginActivity.class);
        if (d) {
            intent = new Intent(context, Login2Activity.class);
            intent.putExtra("login_type", i);
            intent.putExtra("has_exit_dialog", false);
        }
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.layout_sapi_webview_login);
        this.b = getIntent().getBooleanExtra("close", false);
        b();
    }

    protected void b() {
        this.a = (SapiWebView) findViewById(com.baidu.tieba.v.sapi_webview);
        com.baidu.tbadk.core.account.j.a(this, this.a);
        this.a.setOnFinishCallback(new am(this));
        this.a.setAuthorizationListener(new an(this));
        this.a.loadLogin();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.a.onAuthorizedResult(i, i2, intent);
        if (i2 == -1 && i == 11003) {
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        TbadkApplication.m252getInst().onUserChanged();
        if (this.b) {
            Intent intent = new Intent();
            intent.putExtra("BDUSS", TbadkApplication.getCurrentBduss());
            setResult(-1, intent);
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2008001, com.baidu.tbadk.core.frameworkData.a.STOP));
            MessageManager.getInstance().sendMessage(new CustomMessage(2008001, com.baidu.tbadk.core.frameworkData.a.START));
            int intExtra = getIntent().getIntExtra("locate_type", -1);
            if (intExtra == -1) {
                intExtra = 1;
            }
            com.baidu.tbadk.core.b.b.a(this, intExtra, false);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        com.baidu.tbadk.core.account.f.a(session.username, session.bduss, session.ptoken, this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AccountData accountData) {
        if (this.c == null) {
            this.c = new com.baidu.tbadk.coreExtra.view.q(this);
            this.c.a(new ao(this));
        }
        this.c.e();
        this.c.a(accountData);
        this.c.a();
    }

    private void e() {
        if (TbadkApplication.m252getInst().getIsFirstUse()) {
            sendMessage(new CustomMessage(2017000, new com.baidu.tbadk.core.atomData.r(this).a("from_logo_page")));
        } else {
            sendMessage(new CustomMessage(2017001, new com.baidu.tbadk.core.atomData.ak(this).a(1)));
        }
        finish();
    }
}
