package com.baidu.tbadk.coreExtra.act;

import android.os.Bundle;
import com.baidu.sapi2.SapiWebView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class ForgetPwdActivity extends BaseActivity<ForgetPwdActivity> {
    private SapiWebView Pp;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.x.layout_sapi_webview_forget_pwd);
        rb();
    }

    protected void rb() {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new v(this));
        this.mNavigationBar.setTitleText(getPageContext().getString(com.baidu.tieba.z.sapi_forget_password_title));
        this.Pp = (SapiWebView) findViewById(com.baidu.tieba.w.sapi_webview);
        com.baidu.tbadk.core.account.j.a(getPageContext().getPageActivity(), this.Pp);
        this.Pp.setOnBackCallback(new w(this));
        this.Pp.setOnFinishCallback(new x(this));
        this.Pp.loadForgetPwd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
    }
}
