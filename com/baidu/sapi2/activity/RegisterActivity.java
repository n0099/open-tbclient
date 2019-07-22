package com.baidu.sapi2.activity;

import android.os.Bundle;
import com.baidu.d.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.WebRegDTO;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.enums.AccountType;
/* loaded from: classes2.dex */
public class RegisterActivity extends BaseActivity {
    private WebAuthResult webAuthResult = new WebAuthResult() { // from class: com.baidu.sapi2.activity.RegisterActivity.1
        @Override // com.baidu.sapi2.shell.result.WebAuthResult
        public void finishActivity() {
            super.finishActivity();
            PassportSDK.getInstance().release();
            RegisterActivity.this.finish();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(a.f.layout_sapi_sdk_webview_with_title_bar);
            setupViews();
            init();
        } catch (Throwable th) {
            reportWebviewError(th);
            WebAuthListener webAuthListener = PassportSDK.getInstance().getWebAuthListener();
            if (webAuthListener != null) {
                this.webAuthResult.setResultCode(-202);
                this.webAuthResult.setResultMsg(SapiResult.ERROR_MSG_UNKNOWN);
                webAuthListener.onFailure(this.webAuthResult);
            }
            PassportSDK.getInstance().release();
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
        this.webAuthResult.activity = this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (this.executeSubClassMethod) {
            this.sapiWebView.back();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onClose() {
        super.onClose();
        WebAuthListener webAuthListener = PassportSDK.getInstance().getWebAuthListener();
        this.webAuthResult.setResultCode(-301);
        this.webAuthResult.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
        if (webAuthListener != null) {
            webAuthListener.onFailure(this.webAuthResult);
        }
        PassportSDK.getInstance().release();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText(a.g.sapi_sdk_title_register);
        configTitle();
        final WebAuthListener webAuthListener = PassportSDK.getInstance().getWebAuthListener();
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.RegisterActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                if (RegisterActivity.this.sapiWebView != null && RegisterActivity.this.sapiWebView.canGoBack()) {
                    RegisterActivity.this.sapiWebView.goBack();
                } else {
                    RegisterActivity.this.onClose();
                }
            }
        });
        this.sapiWebView.setAuthorizationListener(new AuthorizationListener() { // from class: com.baidu.sapi2.activity.RegisterActivity.3
            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void onSuccess(AccountType accountType) {
                super.onSuccess(accountType);
                RegisterActivity.this.webAuthResult.accountType = accountType;
                RegisterActivity.this.webAuthResult.setResultCode(0);
                if (webAuthListener != null) {
                    webAuthListener.onSuccess(RegisterActivity.this.webAuthResult);
                }
                WebRegDTO webRegDTO = PassportSDK.getInstance().getWebRegDTO();
                if (webRegDTO != null && webRegDTO.finishActivityAfterSuc) {
                    PassportSDK.getInstance().release();
                    RegisterActivity.this.finish();
                }
            }

            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void onFailed(int i, String str) {
                RegisterActivity.this.webAuthResult.setResultCode(i);
                RegisterActivity.this.webAuthResult.setResultMsg(str);
                if (webAuthListener != null) {
                    webAuthListener.onFailure(RegisterActivity.this.webAuthResult);
                }
                PassportSDK.getInstance().release();
                RegisterActivity.this.finish();
            }

            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void beforeSuccess(SapiAccount sapiAccount) {
                super.beforeSuccess(sapiAccount);
                if (webAuthListener != null) {
                    webAuthListener.beforeSuccess(sapiAccount);
                }
            }
        });
        WebRegDTO webRegDTO = PassportSDK.getInstance().getWebRegDTO();
        this.sapiWebView.loadRegist(webRegDTO != null ? webRegDTO.extraParams : null);
    }
}
