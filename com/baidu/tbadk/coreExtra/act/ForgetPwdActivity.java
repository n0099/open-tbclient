package com.baidu.tbadk.coreExtra.act;

import android.os.Bundle;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class ForgetPwdActivity extends BaseActivity {
    private SapiWebView a;
    private NavigationBar b;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.layout_sapi_webview_forget_pwd);
        a();
    }

    protected void a() {
        this.b = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.b.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new v(this));
        this.b.a(getString(com.baidu.tieba.y.sapi_forget_password_title));
        this.a = (SapiWebView) findViewById(com.baidu.tieba.v.sapi_webview);
        com.baidu.tbadk.core.account.j.a(this, this.a);
        this.a.setOnBackCallback(new w(this));
        this.a.setOnFinishCallback(new x(this));
        this.a.loadForgetPwd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.b.c(i);
    }
}
