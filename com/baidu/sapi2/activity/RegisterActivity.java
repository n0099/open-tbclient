package com.baidu.sapi2.activity;

import android.os.Bundle;
import com.baidu.b.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.WebRegDTO;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.enums.AccountType;
/* loaded from: classes2.dex */
public class RegisterActivity extends TitleActivity {
    WebAuthResult webAuthResult = new WebAuthResult();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.e.layout_sapi_sdk_webview_with_title_bar);
        setupViews();
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity, com.baidu.sapi2.activity.BaseActivity
    public void init() {
        super.init();
        this.webAuthResult.activity = this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (this.executeSubClassMethod) {
            this.sapiWebView.back();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity, com.baidu.sapi2.activity.BaseActivity
    public void setupViews() {
        super.setupViews();
        configTitle();
        final WebAuthListener webAuthListener = PassportSDK.getInstance().getWebAuthListener();
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.RegisterActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                RegisterActivity.this.finish();
            }
        });
        this.sapiWebView.setAuthorizationListener(new AuthorizationListener() { // from class: com.baidu.sapi2.activity.RegisterActivity.2
            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void onSuccess(AccountType accountType) {
                super.onSuccess(accountType);
                RegisterActivity.this.webAuthResult.accountType = accountType;
                RegisterActivity.this.webAuthResult.setResultCode(0);
                webAuthListener.onSuccess(RegisterActivity.this.webAuthResult);
                PassportSDK.getInstance().release();
                RegisterActivity.this.finish();
            }

            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void onFailed(int i, String str) {
                RegisterActivity.this.webAuthResult.setResultCode(i);
                RegisterActivity.this.webAuthResult.setResultMsg(str);
                webAuthListener.onFailure(RegisterActivity.this.webAuthResult);
                PassportSDK.getInstance().release();
                RegisterActivity.this.finish();
            }

            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void beforeSuccess(SapiAccount sapiAccount) {
                super.beforeSuccess(sapiAccount);
                webAuthListener.beforeSuccess(sapiAccount);
            }
        });
        WebRegDTO webRegDTO = PassportSDK.getInstance().getWebRegDTO();
        this.sapiWebView.loadRegist(webRegDTO != null ? webRegDTO.extraParams : null);
    }
}
