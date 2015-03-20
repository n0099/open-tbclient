package com.baidu.tbadk.coreExtra.act;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.adp.framework.MessageManager;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class FillUProfileActivity extends BaseActivity<FillUProfileActivity> {
    private SapiWebView aam;
    private String bduss;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.coreExtra.view.t aan = null;
    private final com.baidu.tbadk.core.a.b Sj = new c(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(w.layout_sapi_webview_fill_uprofile);
        this.bduss = getIntent().getStringExtra("EXTRA_BDUSS");
        uo();
    }

    protected void uo() {
        this.mNavigationBar = (NavigationBar) findViewById(v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new d(this));
        this.mNavigationBar.setTitleText(getPageContext().getString(y.sapi_filluprofile));
        if (TextUtils.isEmpty(this.bduss)) {
            Toast.makeText(getPageContext().getPageActivity(), "参数错误，无法正常化", 0).show();
            finish();
        }
        this.aam = (SapiWebView) findViewById(v.sapi_webview);
        com.baidu.tbadk.core.a.f.a(getPageContext().getPageActivity(), this.aam);
        this.aam.setOnBackCallback(new e(this));
        this.aam.setOnFinishCallback(new f(this));
        this.aam.setAuthorizationListener(new g(this));
        this.aam.loadFillUProfile(this.bduss);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void up() {
        TbadkCoreApplication.m411getInst().onUserChanged();
        Intent intent = new Intent();
        intent.putExtra("BDUSS", TbadkCoreApplication.getCurrentBduss());
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uq() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            com.baidu.tbadk.core.a.a.pD().a(session.username, session.bduss, session.ptoken, this.Sj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(AccountData accountData) {
        if (this.aan == null) {
            this.aan = new com.baidu.tbadk.coreExtra.view.t(getPageContext());
            this.aan.a(new h(this));
        }
        this.aan.xa();
        this.aan.k(accountData);
        this.aan.wW();
    }
}
