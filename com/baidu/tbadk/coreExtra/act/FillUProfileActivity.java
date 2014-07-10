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
    private SapiWebView a;
    private NavigationBar b;
    private String d;
    private com.baidu.tbadk.coreExtra.view.s c = null;
    private final com.baidu.tbadk.core.account.g e = new p(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.layout_sapi_webview_fill_uprofile);
        this.d = getIntent().getStringExtra("EXTRA_BDUSS");
        a();
    }

    protected void a() {
        this.b = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.b.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new q(this));
        this.b.a(getString(com.baidu.tieba.y.sapi_filluprofile));
        if (TextUtils.isEmpty(this.d)) {
            Toast.makeText(this, "参数错误，无法正常化", 0).show();
            finish();
        }
        this.a = (SapiWebView) findViewById(com.baidu.tieba.v.sapi_webview);
        com.baidu.tbadk.core.account.j.a(this, this.a);
        this.a.setOnBackCallback(new r(this));
        this.a.setOnFinishCallback(new s(this));
        this.a.setAuthorizationListener(new t(this));
        this.a.loadFillUProfile(this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.b.c(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        TbadkApplication.m252getInst().onUserChanged();
        Intent intent = new Intent();
        intent.putExtra("BDUSS", TbadkApplication.getCurrentBduss());
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        com.baidu.tbadk.core.account.f.a(session.username, session.bduss, session.ptoken, this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AccountData accountData) {
        if (this.c == null) {
            this.c = new com.baidu.tbadk.coreExtra.view.s(this);
            this.c.a(new u(this));
        }
        this.c.e();
        this.c.a(accountData);
        this.c.a();
    }
}
