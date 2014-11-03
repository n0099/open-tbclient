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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.download.CancelDownloadMessage;
/* loaded from: classes.dex */
public class FillUProfileActivity extends BaseActivity {
    private SapiWebView Kh;
    private String bduss;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.coreExtra.view.r Ki = null;
    private final com.baidu.tbadk.core.account.g BX = new p(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.layout_sapi_webview_fill_uprofile);
        this.bduss = getIntent().getStringExtra("EXTRA_BDUSS");
        oa();
    }

    protected void oa() {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new q(this));
        this.mNavigationBar.setTitleText(getString(com.baidu.tieba.y.sapi_filluprofile));
        if (TextUtils.isEmpty(this.bduss)) {
            Toast.makeText(this, "参数错误，无法正常化", 0).show();
            finish();
        }
        this.Kh = (SapiWebView) findViewById(com.baidu.tieba.v.sapi_webview);
        com.baidu.tbadk.core.account.j.a(this, this.Kh);
        this.Kh.setOnBackCallback(new r(this));
        this.Kh.setOnFinishCallback(new s(this));
        this.Kh.setAuthorizationListener(new t(this));
        this.Kh.loadFillUProfile(this.bduss);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ob() {
        TbadkApplication.m251getInst().onUserChanged();
        Intent intent = new Intent();
        intent.putExtra("BDUSS", TbadkApplication.getCurrentBduss());
        setResult(-1, intent);
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
            this.Ki.a(new u(this));
        }
        this.Ki.qc();
        this.Ki.g(accountData);
        this.Ki.pZ();
    }
}
