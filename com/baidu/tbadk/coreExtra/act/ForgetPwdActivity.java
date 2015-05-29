package com.baidu.tbadk.coreExtra.act;

import android.os.Bundle;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class ForgetPwdActivity extends BaseActivity<ForgetPwdActivity> {
    private SapiWebView abp;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setContentView(com.baidu.tieba.r.layout_sapi_webview_forget_pwd);
        uX();
    }

    protected void uX() {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new i(this));
        this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.t.sapi_forget_password_title));
        this.abp = (SapiWebView) findViewById(com.baidu.tieba.q.sapi_webview);
        com.baidu.tbadk.core.a.f.a(getPageContext().getPageActivity(), this.abp);
        this.abp.setOnBackCallback(new j(this));
        this.abp.setOnFinishCallback(new k(this));
        this.abp.loadForgetPwd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}
