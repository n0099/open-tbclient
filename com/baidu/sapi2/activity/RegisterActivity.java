package com.baidu.sapi2.activity;

import android.os.Bundle;
import com.baidu.d.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.dto.WebRegDTO;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.enums.AccountType;
/* loaded from: classes2.dex */
public class RegisterActivity extends BaseActivity {
    private WebAuthResult r = new WebAuthResult() { // from class: com.baidu.sapi2.activity.RegisterActivity.1
        @Override // com.baidu.sapi2.shell.result.WebAuthResult
        public void finishActivity() {
            super.finishActivity();
            RegisterActivity.this.finish();
            PassportSDK.getInstance().release();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public SapiWebDTO getWebDTO() {
        return PassportSDK.getInstance().getWebRegDTO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
        this.r.activity = this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onClose() {
        super.onClose();
        WebAuthListener webAuthListener = PassportSDK.getInstance().getWebAuthListener();
        this.r.setResultCode(-301);
        this.r.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
        if (webAuthListener != null) {
            webAuthListener.onFailure(this.r);
        }
        finish();
        PassportSDK.getInstance().release();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(a.f.layout_sapi_sdk_webview_with_title_bar);
            init();
            setupViews();
        } catch (Throwable th) {
            reportWebviewError(th);
            WebAuthListener webAuthListener = PassportSDK.getInstance().getWebAuthListener();
            if (webAuthListener != null) {
                this.r.setResultCode(-202);
                this.r.setResultMsg(SapiResult.ERROR_MSG_UNKNOWN);
                webAuthListener.onFailure(this.r);
            }
            finish();
            PassportSDK.getInstance().release();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (!this.executeSubClassMethod) {
            return;
        }
        this.sapiWebView.back();
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
                SapiWebView sapiWebView = RegisterActivity.this.sapiWebView;
                if (sapiWebView != null && sapiWebView.canGoBack()) {
                    RegisterActivity.this.sapiWebView.goBack();
                } else {
                    RegisterActivity.this.onClose();
                }
            }
        });
        this.sapiWebView.setAuthorizationListener(new AuthorizationListener() { // from class: com.baidu.sapi2.activity.RegisterActivity.3
            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void beforeSuccess(SapiAccount sapiAccount) {
                super.beforeSuccess(sapiAccount);
                WebAuthListener webAuthListener2 = webAuthListener;
                if (webAuthListener2 != null) {
                    webAuthListener2.beforeSuccess(sapiAccount);
                }
            }

            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void onFailed(int i, String str) {
                RegisterActivity.this.r.setResultCode(i);
                RegisterActivity.this.r.setResultMsg(str);
                WebAuthListener webAuthListener2 = webAuthListener;
                if (webAuthListener2 != null) {
                    webAuthListener2.onFailure(RegisterActivity.this.r);
                }
                RegisterActivity.this.finish();
                PassportSDK.getInstance().release();
            }

            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void onSuccess(AccountType accountType) {
                super.onSuccess(accountType);
                RegisterActivity.this.r.accountType = accountType;
                RegisterActivity.this.r.setResultCode(0);
                WebAuthListener webAuthListener2 = webAuthListener;
                if (webAuthListener2 != null) {
                    webAuthListener2.onSuccess(RegisterActivity.this.r);
                }
                WebRegDTO webRegDTO = PassportSDK.getInstance().getWebRegDTO();
                if (webRegDTO == null || !webRegDTO.finishActivityAfterSuc) {
                    return;
                }
                RegisterActivity.this.finish();
                PassportSDK.getInstance().release();
            }
        });
        WebRegDTO webRegDTO = PassportSDK.getInstance().getWebRegDTO();
        this.sapiWebView.loadRegist(webRegDTO != null ? webRegDTO.extraParams : null);
    }
}
