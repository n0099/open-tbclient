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
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.download.CancelDownloadMessage;
/* loaded from: classes.dex */
public class LoginActivity extends BaseActivity {
    private static boolean KZ = false;
    private SapiWebView Kh;
    private boolean Kq = false;
    private com.baidu.tbadk.coreExtra.view.r Ki = null;
    private final com.baidu.tbadk.core.account.g BX = new ak(this);

    static {
        checkPassV6Switch();
        if (KZ) {
            TbadkApplication.m251getInst().RegisterIntent(LoginActivityConfig.class, Login2Activity.class);
        } else {
            TbadkApplication.m251getInst().RegisterIntent(LoginActivityConfig.class, LoginActivity.class);
        }
    }

    public static void checkPassV6Switch() {
        if (Build.VERSION.SDK_INT < 9 || TbConfig.USE_OLD_LOGIN || !TbadkApplication.m251getInst().isPassportV6ShouldOpen()) {
            KZ = true;
        } else if (Build.VERSION.SDK_INT <= 10) {
            if (UtilHelper.webViewIsProbablyCorrupt(TbadkApplication.m251getInst())) {
                TbadkApplication.m251getInst().incPassportV6CrashCount();
                KZ = true;
                return;
            }
            KZ = false;
        } else {
            KZ = false;
        }
    }

    public static void x(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        if (KZ) {
            intent = new Intent(context, Login2Activity.class);
            intent.putExtra(LoginActivityConfig.HAS_EXIT_DIALOG, false);
        }
        context.startActivity(intent);
    }

    public static void a(Activity activity, int i, String str, int i2) {
        Intent intent = new Intent(activity, LoginActivity.class);
        if (KZ) {
            intent = new Intent(activity, Login2Activity.class);
            intent.putExtra(LoginActivityConfig.HAS_EXIT_DIALOG, false);
            intent.putExtra(LoginActivityConfig.INFO, str);
        }
        intent.putExtra("locate_type", i);
        activity.startActivityForResult(intent, i2);
    }

    public static void a(Activity activity, String str, boolean z, int i) {
        Intent intent = new Intent(activity, LoginActivity.class);
        if (KZ) {
            intent = new Intent(activity, Login2Activity.class);
            intent.putExtra(LoginActivityConfig.HAS_EXIT_DIALOG, false);
            intent.putExtra(LoginActivityConfig.INFO, str);
        }
        intent.putExtra(LoginActivityConfig.CLOSE, z);
        activity.startActivityForResult(intent, i);
    }

    public static void o(Context context, String str) {
        Intent intent = new Intent(context, LoginActivity.class);
        if (KZ) {
            intent = new Intent(context, Login2Activity.class);
            intent.putExtra(LoginActivityConfig.ACCOUNT, str);
            intent.putExtra(LoginActivityConfig.HAS_EXIT_DIALOG, false);
        }
        context.startActivity(intent);
    }

    public static void g(Context context, int i) {
        Intent intent = new Intent(context, LoginActivity.class);
        if (KZ) {
            intent = new Intent(context, Login2Activity.class);
            intent.putExtra(LoginActivityConfig.LOGIN_TYPE, i);
            intent.putExtra(LoginActivityConfig.HAS_EXIT_DIALOG, false);
        }
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.layout_sapi_webview_login);
        this.Kq = getIntent().getBooleanExtra(LoginActivityConfig.CLOSE, false);
        oa();
    }

    protected void oa() {
        this.Kh = (SapiWebView) findViewById(com.baidu.tieba.v.sapi_webview);
        com.baidu.tbadk.core.account.j.a(this, this.Kh);
        this.Kh.setOnFinishCallback(new am(this));
        this.Kh.setAuthorizationListener(new an(this));
        this.Kh.loadLogin();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.Kh.onAuthorizedResult(i, i2, intent);
        if (i2 == -1 && i == 11003) {
            oq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ob() {
        int i = 1;
        TbadkApplication.m251getInst().onUserChanged();
        if (this.Kq) {
            Intent intent = new Intent();
            intent.putExtra("BDUSS", TbadkApplication.getCurrentBduss());
            setResult(-1, intent);
        } else {
            int intExtra = getIntent().getIntExtra("locate_type", -1);
            if (intExtra != -1) {
                i = intExtra;
            } else if (com.baidu.tbadk.core.sharedPref.b.lk().getBoolean("account_first_login_" + TbadkApplication.getCurrentAccount(), true)) {
                i = 4;
                com.baidu.tbadk.core.sharedPref.b.lk().putBoolean("account_first_login_" + TbadkApplication.getCurrentAccount(), false);
            }
            com.baidu.tbadk.core.b.b.a(this, i, false);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oc() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            com.baidu.tbadk.core.account.f.a(session.username, session.bduss, session.ptoken, this.BX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(AccountData accountData) {
        if (this.Ki == null) {
            this.Ki = new com.baidu.tbadk.coreExtra.view.r(this);
            this.Ki.a(new ao(this));
        }
        this.Ki.qc();
        this.Ki.g(accountData);
        this.Ki.pZ();
    }

    private void oq() {
        if (TbadkApplication.m251getInst().getIsFirstUse()) {
            sendMessage(new CustomMessage(2015000, new GuildActivityConfig(this).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE)));
        } else {
            sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(this).createNormalCfg(1)));
        }
        finish();
    }
}
