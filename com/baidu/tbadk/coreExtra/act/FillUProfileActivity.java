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
/* loaded from: classes.dex */
public class FillUProfileActivity extends BaseActivity<FillUProfileActivity> {
    private SapiWebView Pp;
    private String bduss;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.coreExtra.view.t Pq = null;
    private final com.baidu.tbadk.core.account.g Gi = new p(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.x.layout_sapi_webview_fill_uprofile);
        this.bduss = getIntent().getStringExtra("EXTRA_BDUSS");
        rb();
    }

    protected void rb() {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new q(this));
        this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.z.sapi_filluprofile));
        if (TextUtils.isEmpty(this.bduss)) {
            Toast.makeText(getPageContext().getPageActivity(), "参数错误，无法正常化", 0).show();
            finish();
        }
        this.Pp = (SapiWebView) findViewById(com.baidu.tieba.w.sapi_webview);
        com.baidu.tbadk.core.account.j.a(getPageContext().getPageActivity(), this.Pp);
        this.Pp.setOnBackCallback(new r(this));
        this.Pp.setOnFinishCallback(new s(this));
        this.Pp.setAuthorizationListener(new t(this));
        this.Pp.loadFillUProfile(this.bduss);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rc() {
        TbadkCoreApplication.m255getInst().onUserChanged();
        Intent intent = new Intent();
        intent.putExtra("BDUSS", TbadkCoreApplication.getCurrentBduss());
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rd() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            com.baidu.tbadk.core.account.f.a(session.username, session.bduss, session.ptoken, this.Gi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(AccountData accountData) {
        if (this.Pq == null) {
            this.Pq = new com.baidu.tbadk.coreExtra.view.t(this);
            this.Pq.a(new u(this));
        }
        this.Pq.tv();
        this.Pq.g(accountData);
        this.Pq.ts();
    }
}
