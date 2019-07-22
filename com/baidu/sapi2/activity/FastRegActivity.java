package com.baidu.sapi2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.d.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.dto.WebRegDTO;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.SocialType;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class FastRegActivity extends BaseActivity {
    public static final String EXTRA_RESULT_CODE = "result_code";
    public static final String EXTRA_RESULT_MSG = "result_msg";
    public static final int RESULT_AUTH_FAILURE = 1002;
    public static final int RESULT_AUTH_SUCCESS = 1001;
    private int businessFrom;
    private WebAuthResult webAuthResult = new WebAuthResult() { // from class: com.baidu.sapi2.activity.FastRegActivity.1
        @Override // com.baidu.sapi2.shell.result.WebAuthResult
        public void finishActivity() {
            super.finishActivity();
            if (FastRegActivity.this.businessFrom == 2002) {
                PassportSDK.getInstance().release();
            } else {
                FastRegActivity.this.setResult(1001);
            }
            FastRegActivity.this.finish();
        }
    };
    private AuthorizationListener authorizationListener = new AuthorizationListener() { // from class: com.baidu.sapi2.activity.FastRegActivity.2
        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void onSuccess(AccountType accountType) {
            super.onSuccess(accountType);
            FastRegActivity.this.loginSuc(accountType, false);
        }

        @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
        public void onFailed(int i, String str) {
            if (FastRegActivity.this.businessFrom == 2002) {
                WebAuthListener webAuthListener = PassportSDK.getInstance().getWebAuthListener();
                if (webAuthListener != null) {
                    FastRegActivity.this.webAuthResult.setResultCode(i);
                    FastRegActivity.this.webAuthResult.setResultMsg(str);
                    webAuthListener.onFailure(FastRegActivity.this.webAuthResult);
                }
            } else {
                Intent intent = new Intent();
                intent.putExtra("result_code", i);
                intent.putExtra("result_msg", str);
                FastRegActivity.this.setResult(1002, intent);
            }
            FastRegActivity.this.finish();
        }
    };

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(a.f.layout_sapi_sdk_webview_with_title_bar);
            init();
            setupViews();
        } catch (Throwable th) {
            reportWebviewError(th);
            this.webAuthResult.setResultCode(-202);
            this.webAuthResult.setResultMsg(SapiResult.ERROR_MSG_UNKNOWN);
            finishActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
        this.businessFrom = getIntent().getIntExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, 2002);
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
    public void onRightBtnClick() {
        super.onRightBtnClick();
        this.sapiWebView.back();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onClose() {
        super.onClose();
        if (this.businessFrom == 2002) {
            WebAuthListener webAuthListener = PassportSDK.getInstance().getWebAuthListener();
            if (webAuthListener != null) {
                this.webAuthResult.setResultCode(-301);
                this.webAuthResult.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
                webAuthListener.onFailure(this.webAuthResult);
            }
            PassportSDK.getInstance().release();
        } else {
            Intent intent = new Intent();
            intent.putExtra("result_code", -301);
            intent.putExtra("result_msg", SapiResult.ERROR_MSG_PROCESSED_END);
            setResult(1002, intent);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText(a.g.sapi_sdk_title_fast_reg);
        configTitle();
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.FastRegActivity.3
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                FastRegActivity.this.onClose();
            }
        });
        this.sapiWebView.setAuthorizationListener(this.authorizationListener);
        this.sapiWebView.setSocialLoginHandler(new Handler() { // from class: com.baidu.sapi2.activity.FastRegActivity.4
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                PassportSDK.getInstance().getThirdPartyService().loadThirdPartyLogin(FastRegActivity.this, (SocialType) message.obj, 2001);
            }
        });
        WebRegDTO webRegDTO = PassportSDK.getInstance().getWebRegDTO();
        ArrayList arrayList = new ArrayList();
        WebLoginDTO webLoginDTO = PassportSDK.getInstance().getWebLoginDTO();
        if (webLoginDTO != null && WebLoginDTO.statExtraValid(webLoginDTO.statExtra)) {
            arrayList.add(new PassNameValuePair("extrajson", WebLoginDTO.getStatExtraDecode(webLoginDTO.statExtra)));
        }
        if (webRegDTO != null && webRegDTO.extraParams != null) {
            arrayList.addAll(webRegDTO.extraParams);
        }
        this.sapiWebView.loadFastReg(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loginSuc(AccountType accountType, boolean z) {
        if (z) {
            if (this.businessFrom == 2002) {
                PassportSDK.getInstance().release();
                finish();
                return;
            } else if (this.businessFrom == 2001) {
                setResult(1001);
                finish();
                return;
            } else {
                return;
            }
        }
        WebAuthListener webAuthListener = PassportSDK.getInstance().getWebAuthListener();
        if (webAuthListener != null) {
            this.webAuthResult.accountType = accountType;
            this.webAuthResult.setResultCode(0);
            webAuthListener.onSuccess(this.webAuthResult);
        }
        if (this.businessFrom == 2002) {
            WebRegDTO webRegDTO = PassportSDK.getInstance().getWebRegDTO();
            if (webRegDTO != null && webRegDTO.finishActivityAfterSuc) {
                PassportSDK.getInstance().release();
                finish();
            }
        } else if (this.businessFrom == 2003 || this.businessFrom == 2004) {
            setResult(1001);
            finish();
        } else {
            WebLoginDTO webLoginDTO = PassportSDK.getInstance().getWebLoginDTO();
            if (webLoginDTO != null && webLoginDTO.finishActivityAfterSuc) {
                setResult(1001);
                finish();
            }
        }
    }

    private void finishActivity() {
        WebAuthListener webAuthListener = PassportSDK.getInstance().getWebAuthListener();
        if (webAuthListener != null) {
            webAuthListener.onFailure(this.webAuthResult);
        }
        PassportSDK.getInstance().release();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 2001 && i2 == 1001) {
            loginSuc(SapiAccountManager.getInstance().getSession().getAccountType(), true);
        }
    }
}
