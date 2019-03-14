package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.d.a.a.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.dto.WebRegDTO;
import com.baidu.sapi2.dto.WebSocialLoginDTO;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.social.SocialLoginBase;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.views.ViewUtility;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class BaseSSOLoginActivity extends SocialLoginBase {
    protected int businessFrom;
    protected WebAuthResult webAuthResult = new WebAuthResult() { // from class: com.baidu.sapi2.activity.social.BaseSSOLoginActivity.1
        @Override // com.baidu.sapi2.shell.result.WebAuthResult
        public void finishActivity() {
            if (BaseSSOLoginActivity.this.businessFrom == 2001) {
                BaseSSOLoginActivity.this.setActivtyResult(1001);
            } else {
                PassportSDK.getInstance().release();
            }
            BaseSSOLoginActivity.this.finish();
        }
    };
    protected AuthorizationListener authorizationListener = new AuthorizationListener() { // from class: com.baidu.sapi2.activity.social.BaseSSOLoginActivity.2
        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void onSuccess(AccountType accountType) {
            super.onSuccess(accountType);
            WebAuthListener webAuthListener = PassportSDK.getInstance().getWebAuthListener();
            if (webAuthListener != null) {
                BaseSSOLoginActivity.this.webAuthResult.accountType = accountType;
                BaseSSOLoginActivity.this.webAuthResult.setResultCode(0);
                webAuthListener.onSuccess(BaseSSOLoginActivity.this.webAuthResult);
            }
            if (BaseSSOLoginActivity.this.businessFrom == 2001) {
                WebRegDTO webRegDTO = PassportSDK.getInstance().getWebRegDTO();
                if (webRegDTO != null) {
                    if (webRegDTO.finishActivityAfterSuc) {
                        BaseSSOLoginActivity.this.setActivtyResult(1001);
                        BaseSSOLoginActivity.this.finish();
                        return;
                    }
                    return;
                }
                WebLoginDTO webLoginDTO = PassportSDK.getInstance().getWebLoginDTO();
                if (webLoginDTO != null && webLoginDTO.finishActivityAfterSuc) {
                    BaseSSOLoginActivity.this.setActivtyResult(1001);
                    BaseSSOLoginActivity.this.finish();
                }
            } else if (BaseSSOLoginActivity.this.businessFrom == 2003 || BaseSSOLoginActivity.this.businessFrom == 2004) {
                BaseSSOLoginActivity.this.setActivtyResult(1001);
                BaseSSOLoginActivity.this.finish();
            } else {
                WebSocialLoginDTO socialLoginDTO = PassportSDK.getInstance().getSocialLoginDTO();
                if (socialLoginDTO != null && socialLoginDTO.finishActivityAfterSuc) {
                    PassportSDK.getInstance().release();
                    BaseSSOLoginActivity.this.finish();
                }
            }
        }

        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void beforeSuccess(SapiAccount sapiAccount) {
            super.beforeSuccess(sapiAccount);
            if (PassportSDK.getInstance().getWebAuthListener() != null) {
                PassportSDK.getInstance().getWebAuthListener().beforeSuccess(sapiAccount);
            }
        }

        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void onFailed(int i, String str) {
            if (BaseSSOLoginActivity.this.businessFrom == 2001) {
                Intent intent = new Intent();
                intent.putExtra("result_code", i);
                intent.putExtra("result_msg", str);
                BaseSSOLoginActivity.this.setActivtyResult(1002, intent);
            } else if (PassportSDK.getInstance().getWebAuthListener() != null) {
                BaseSSOLoginActivity.this.webAuthResult.setResultCode(i);
                BaseSSOLoginActivity.this.webAuthResult.setResultMsg(str);
                PassportSDK.getInstance().getWebAuthListener().onFailure(BaseSSOLoginActivity.this.webAuthResult);
                PassportSDK.getInstance().release();
            }
            BaseSSOLoginActivity.this.finish();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(a.C0041a.layout_sapi_sdk_webview_with_title_bar);
            initData();
        } catch (Throwable th) {
            reportWebviewError(th);
            if (PassportSDK.getInstance().getWebAuthListener() != null) {
                this.webAuthResult.setResultCode(-202);
                this.webAuthResult.setResultMsg(SapiResult.ERROR_MSG_UNKNOWN);
                PassportSDK.getInstance().getWebAuthListener().onFailure(this.webAuthResult);
            }
            PassportSDK.getInstance().release();
            finish();
        }
    }

    private void initData() {
        super.init();
        this.businessFrom = getIntent().getIntExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, 2001);
        this.webAuthResult.activity = this;
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    protected SapiWebDTO getWebDTO() {
        return PassportSDK.getInstance().getSocialLoginDTO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (this.executeSubClassMethod) {
            this.sapiWebView.onKeyUp(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onRightBtnClick() {
        super.onRightBtnClick();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        this.sapiWebView.onKeyUp(4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        ViewUtility.enableStatusBarTint(this, -1);
        configTitle();
        this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() { // from class: com.baidu.sapi2.activity.social.BaseSSOLoginActivity.3
            @Override // com.baidu.sapi2.SapiWebView.OnNewBackCallback
            public boolean onBack() {
                BaseSSOLoginActivity.this.handleBack(BaseSSOLoginActivity.this.businessFrom);
                return true;
            }
        });
        this.sapiWebView.setOnBackCallback(new SapiWebView.OnBackCallback() { // from class: com.baidu.sapi2.activity.social.BaseSSOLoginActivity.4
            @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
            public void onBack() {
                BaseSSOLoginActivity.this.handleBack(BaseSSOLoginActivity.this.businessFrom);
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.social.BaseSSOLoginActivity.5
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                BaseSSOLoginActivity.this.handleBack(BaseSSOLoginActivity.this.businessFrom);
            }
        });
        this.sapiWebView.setAuthorizationListener(this.authorizationListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<PassNameValuePair> getStatParamList() {
        ArrayList arrayList = new ArrayList();
        WebLoginDTO webLoginDTO = PassportSDK.getInstance().getWebLoginDTO();
        WebSocialLoginDTO socialLoginDTO = PassportSDK.getInstance().getSocialLoginDTO();
        if (webLoginDTO != null && WebLoginDTO.statExtraValid(webLoginDTO.statExtra)) {
            arrayList.add(new PassNameValuePair("extrajson", WebLoginDTO.getStatExtraDecode(webLoginDTO.statExtra)));
        } else if (socialLoginDTO != null && WebLoginDTO.statExtraValid(socialLoginDTO.statExtra)) {
            arrayList.add(new PassNameValuePair("extrajson", WebLoginDTO.getStatExtraDecode(socialLoginDTO.statExtra)));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handleBack(int i) {
        if (i == 2001) {
            Intent intent = new Intent();
            intent.putExtra("result_code", -301);
            intent.putExtra("result_msg", SapiResult.ERROR_MSG_PROCESSED_END);
            setActivtyResult(1002, intent);
        } else if (PassportSDK.getInstance().getWebAuthListener() != null) {
            this.webAuthResult.setResultCode(-301);
            this.webAuthResult.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
            PassportSDK.getInstance().getWebAuthListener().onFailure(this.webAuthResult);
            PassportSDK.getInstance().release();
        }
        SapiUtils.hideSoftInput(this);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setActivtyResult(int i, Intent intent) {
        setResult(i, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setActivtyResult(int i) {
        setResult(i);
    }
}
