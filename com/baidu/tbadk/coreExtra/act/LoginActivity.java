package com.baidu.tbadk.coreExtra.act;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.RegisterActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
/* loaded from: classes.dex */
public class LoginActivity extends BaseActivity<LoginActivity> {
    private SapiWebView abp;
    private TextView abv;
    private View abw;
    private View mBack;
    private NavigationBar mNavigationBar;
    private boolean abu = false;
    private int mFrom = -1;
    private com.baidu.tbadk.coreExtra.view.t abq = null;
    private final com.baidu.tbadk.core.a.b SV = new m(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(com.baidu.tieba.r.layout_sapi_webview_login);
        Intent intent = getIntent();
        this.abu = intent.getBooleanExtra(com.baidu.tbadk.core.frameworkData.c.CLOSE, false);
        this.mFrom = intent.getIntExtra("from", -1);
        uX();
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            bq.a((View) this.abp, com.baidu.tieba.n.cp_link_tip_b, false);
        }
    }

    protected void uX() {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.q.sapi_login_navi);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mBack.setOnClickListener(this);
        this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.t.login));
        this.abw = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.r.navigation_right_button_layout, (View.OnClickListener) null);
        this.abv = (TextView) this.abw.findViewById(com.baidu.tieba.q.right_textview);
        this.abv.setText(getPageContext().getString(com.baidu.tieba.t.account_regedit));
        ay.b(this.abv, com.baidu.tieba.n.navi_op_text, 1);
        this.abv.setOnClickListener(this);
        this.abp = (SapiWebView) findViewById(com.baidu.tieba.q.sapi_webview);
        com.baidu.tbadk.core.a.f.a(getPageContext().getPageActivity(), this.abp);
        this.abp.setOnFinishCallback(new p(this));
        this.abp.setAuthorizationListener(new q(this));
        this.abp.setVoiceLoginHandler(new r(this));
        this.abp.loadLogin();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mBack) {
            finish();
        } else if (view == this.abv) {
            if (this.mFrom == 2) {
                finish();
            } else {
                sendMessage(new CustomMessage(2002001, new RegisterActivityConfig(getPageContext().getPageActivity(), 1, true, 11038)));
            }
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.abp.onAuthorizedResult(i, i2, intent);
        if (i2 == -1 && i == 11038) {
            setResult(-1);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uY() {
        int i = 1;
        TbadkCoreApplication.m411getInst().onUserChanged();
        if (this.abu) {
            Intent intent = new Intent();
            intent.putExtra("BDUSS", TbadkCoreApplication.getCurrentBduss());
            setResult(-1, intent);
        } else {
            int intExtra = getIntent().getIntExtra("locate_type", -1);
            if (intExtra != -1) {
                i = intExtra;
            } else if (com.baidu.tbadk.core.sharedPref.b.sl().getBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), true)) {
                com.baidu.tbadk.core.sharedPref.b.sl().putBoolean("account_first_login_" + TbadkCoreApplication.getCurrentAccount(), false);
            }
            com.baidu.tbadk.core.c.b.a(getPageContext().getPageActivity(), i, false);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uZ() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            com.baidu.tbadk.core.a.a.qi().a(session.username, session.bduss, session.ptoken, this.SV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(AccountData accountData) {
        if (this.abq == null) {
            this.abq = new com.baidu.tbadk.coreExtra.view.t(getPageContext());
            this.abq.a(new s(this));
        }
        this.abq.xS();
        this.abq.k(accountData);
        this.abq.xO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vb() {
        if (this.mFrom == 3 && TbadkCoreApplication.m411getInst().getIsFirstUse()) {
            com.baidu.adp.lib.g.l.ht().b(new t(this));
        }
    }
}
