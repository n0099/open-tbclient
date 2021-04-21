package com.baidu.sapi2.activity;

import android.os.Bundle;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.dto.WebRegDTO;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.enums.AccountType;
import d.b.y.a.f;
import d.b.y.a.g;
/* loaded from: classes2.dex */
public class RegisterActivity extends BaseActivity {
    public WebAuthResult p = new WebAuthResult() { // from class: com.baidu.sapi2.activity.RegisterActivity.1
        @Override // com.baidu.sapi2.shell.result.WebAuthResult
        public void finishActivity() {
            super.finishActivity();
            RegisterActivity.this.finish();
            CoreViewRouter.getInstance().release();
        }
    };

    @Override // com.baidu.sapi2.activity.TitleActivity
    public SapiWebDTO getWebDTO() {
        return CoreViewRouter.getInstance().getWebRegDTO();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
        this.p.activity = this;
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        this.sapiWebView.back();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onClose() {
        super.onClose();
        WebAuthListener webAuthListener = CoreViewRouter.getInstance().getWebAuthListener();
        this.p.setResultCode(-301);
        this.p.setResultMsg("您已取消操作");
        if (webAuthListener != null) {
            webAuthListener.onFailure(this.p);
        }
        finish();
        CoreViewRouter.getInstance().release();
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(f.layout_sapi_sdk_webview_with_title_bar);
            init();
            setupViews();
        } catch (Throwable th) {
            reportWebviewError(th);
            WebAuthListener webAuthListener = CoreViewRouter.getInstance().getWebAuthListener();
            if (webAuthListener != null) {
                this.p.setResultCode(-202);
                this.p.setResultMsg("网络连接失败，请检查网络设置");
                webAuthListener.onFailure(this.p);
            }
            finish();
            CoreViewRouter.getInstance().release();
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (this.executeSubClassMethod) {
            this.sapiWebView.back();
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText(g.sapi_sdk_title_register);
        final WebAuthListener webAuthListener = CoreViewRouter.getInstance().getWebAuthListener();
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.RegisterActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                RegisterActivity.this.onClose();
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
                RegisterActivity.this.p.setResultCode(i);
                RegisterActivity.this.p.setResultMsg(str);
                WebAuthListener webAuthListener2 = webAuthListener;
                if (webAuthListener2 != null) {
                    webAuthListener2.onFailure(RegisterActivity.this.p);
                }
                RegisterActivity.this.finish();
                CoreViewRouter.getInstance().release();
            }

            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void onSuccess(AccountType accountType) {
                super.onSuccess(accountType);
                RegisterActivity.this.p.accountType = accountType;
                RegisterActivity.this.p.setResultCode(0);
                WebAuthListener webAuthListener2 = webAuthListener;
                if (webAuthListener2 != null) {
                    webAuthListener2.onSuccess(RegisterActivity.this.p);
                }
                WebRegDTO webRegDTO = CoreViewRouter.getInstance().getWebRegDTO();
                if (webRegDTO == null || !webRegDTO.finishActivityAfterSuc) {
                    return;
                }
                RegisterActivity.this.finish();
                CoreViewRouter.getInstance().release();
            }
        });
        setNewLoginTitleAndSetStyleChangeCallBack();
        WebRegDTO webRegDTO = CoreViewRouter.getInstance().getWebRegDTO();
        this.sapiWebView.loadRegist(webRegDTO != null ? webRegDTO.extraParams : null);
    }
}
