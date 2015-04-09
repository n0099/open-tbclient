package com.baidu.tbadk.coreExtra.act;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class LoginActivity extends BaseActivity<LoginActivity> {
    private SapiWebView aao;
    private boolean aas = false;
    private com.baidu.tbadk.coreExtra.view.t aap = null;
    private final com.baidu.tbadk.core.a.b Sl = new m(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(w.layout_sapi_webview_login);
        this.aas = getIntent().getBooleanExtra(LoginActivityConfig.CLOSE, false);
        uo();
    }

    protected void uo() {
        this.aao = (SapiWebView) findViewById(v.sapi_webview);
        com.baidu.tbadk.core.a.f.a(getPageContext().getPageActivity(), this.aao);
        this.aao.setOnFinishCallback(new p(this));
        this.aao.setAuthorizationListener(new q(this));
        this.aao.loadLogin();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.aao.onAuthorizedResult(i, i2, intent);
        if (i2 == -1 && i == 11003) {
            us();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void up() {
        int i = 1;
        TbadkCoreApplication.m411getInst().onUserChanged();
        if (this.aas) {
            Intent intent = new Intent();
            intent.putExtra("BDUSS", TbadkCoreApplication.getCurrentBduss());
            setResult(-1, intent);
        } else {
            int intExtra = getIntent().getIntExtra("locate_type", -1);
            if (intExtra != -1) {
                i = intExtra;
            } else if (com.baidu.tbadk.core.sharedPref.b.rB().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                com.baidu.tbadk.core.sharedPref.b.rB().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
            com.baidu.tbadk.core.c.b.a(getPageContext().getPageActivity(), i, false);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uq() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            com.baidu.tbadk.core.a.a.pD().a(session.username, session.bduss, session.ptoken, this.Sl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(AccountData accountData) {
        if (this.aap == null) {
            this.aap = new com.baidu.tbadk.coreExtra.view.t(getPageContext());
            this.aap.a(new r(this));
        }
        this.aap.xg();
        this.aap.k(accountData);
        this.aap.xc();
    }

    private void us() {
        if (TbadkCoreApplication.m411getInst().getIsFirstUse() && MessageManager.getInstance().findTask(2015000) != null) {
            sendMessage(new CustomMessage(2015000, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE)));
        } else {
            sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        finish();
    }
}
