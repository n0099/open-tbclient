package com.baidu.tbadk.coreExtra.act;

import android.app.Activity;
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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
/* loaded from: classes.dex */
public class LoginActivity extends BaseActivity<LoginActivity> {
    private static boolean QI = false;
    private SapiWebView PO;
    private boolean PY = false;
    private com.baidu.tbadk.coreExtra.view.t PP = null;
    private final com.baidu.tbadk.core.account.g Gi = new ak(this);

    static {
        checkPassV6Switch();
        if (QI) {
            TbadkCoreApplication.m255getInst().RegisterIntent(LoginActivityConfig.class, Login2Activity.class);
        } else {
            TbadkCoreApplication.m255getInst().RegisterIntent(LoginActivityConfig.class, LoginActivity.class);
        }
    }

    public static void checkPassV6Switch() {
        if (Build.VERSION.SDK_INT < 9 || TbConfig.USE_OLD_LOGIN || !TbadkCoreApplication.m255getInst().isPassportV6ShouldOpen()) {
            QI = true;
        } else if (Build.VERSION.SDK_INT <= 10) {
            if (UtilHelper.webViewIsProbablyCorrupt(TbadkCoreApplication.m255getInst().getContext())) {
                TbadkCoreApplication.m255getInst().incPassportV6CrashCount();
                QI = true;
                return;
            }
            QI = false;
        } else {
            QI = false;
        }
    }

    public static void a(Activity activity, String str, boolean z, int i) {
        Intent intent = new Intent(activity, LoginActivity.class);
        if (QI) {
            intent = new Intent(activity, Login2Activity.class);
            intent.putExtra(LoginActivityConfig.HAS_EXIT_DIALOG, false);
            intent.putExtra(LoginActivityConfig.INFO, str);
        }
        intent.putExtra(LoginActivityConfig.CLOSE, z);
        activity.startActivityForResult(intent, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.x.layout_sapi_webview_login);
        this.PY = getIntent().getBooleanExtra(LoginActivityConfig.CLOSE, false);
        rg();
    }

    protected void rg() {
        this.PO = (SapiWebView) findViewById(com.baidu.tieba.w.sapi_webview);
        com.baidu.tbadk.core.account.j.a(getPageContext().getPageActivity(), this.PO);
        this.PO.setOnFinishCallback(new am(this));
        this.PO.setAuthorizationListener(new an(this));
        this.PO.loadLogin();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.PO.onAuthorizedResult(i, i2, intent);
        if (i2 == -1 && i == 11003) {
            rw();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rh() {
        int i = 1;
        TbadkCoreApplication.m255getInst().onUserChanged();
        if (this.PY) {
            Intent intent = new Intent();
            intent.putExtra("BDUSS", TbadkCoreApplication.getCurrentBduss());
            setResult(-1, intent);
        } else {
            int intExtra = getIntent().getIntExtra("locate_type", -1);
            if (intExtra != -1) {
                i = intExtra;
            } else if (com.baidu.tbadk.core.sharedPref.b.oc().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                com.baidu.tbadk.core.sharedPref.b.oc().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
            com.baidu.tbadk.core.b.b.a(getPageContext().getPageActivity(), i, false);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ri() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            com.baidu.tbadk.core.account.f.a(session.username, session.bduss, session.ptoken, this.Gi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(AccountData accountData) {
        if (this.PP == null) {
            this.PP = new com.baidu.tbadk.coreExtra.view.t(this);
            this.PP.a(new ao(this));
        }
        this.PP.tG();
        this.PP.g(accountData);
        this.PP.tD();
    }

    private void rw() {
        sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
        finish();
    }
}
