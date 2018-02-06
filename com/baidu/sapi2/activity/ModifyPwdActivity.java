package com.baidu.sapi2.activity;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.c.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.WebModifyPwdCallback;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.WebModifyPwdResult;
/* loaded from: classes2.dex */
public class ModifyPwdActivity extends TitleActivity {
    public static final String EXTRA_BDUSS = "EXTRA_BDUSS";
    private String bduss;
    private WebModifyPwdResult result = new WebModifyPwdResult();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.e.layout_sapi_sdk_webview_with_title_bar);
        init();
        setupViews();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity, com.baidu.sapi2.activity.BaseActivity
    public void init() {
        super.init();
        WebModifyPwdCallback webModifyPwdCallback = PassportSDK.getInstance().getWebModifyPwdCallback();
        this.bduss = getIntent().getStringExtra("EXTRA_BDUSS");
        if (TextUtils.isEmpty(this.bduss)) {
            if (webModifyPwdCallback != null) {
                this.result.setResultCode(-204);
                this.result.setResultMsg(SapiResult.ERROR_MSG_PARAMS_ERROR);
                webModifyPwdCallback.onFinish(this.result);
            }
            PassportSDK.getInstance().release();
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity, com.baidu.sapi2.activity.BaseActivity
    public void setupViews() {
        super.setupViews();
        setBtnVisibility(4, 0, 4);
        setTitleText(a.f.sapi_sdk_modify_password_title);
        this.sapiWebView.setOnBackCallback(new SapiWebView.OnBackCallback() { // from class: com.baidu.sapi2.activity.ModifyPwdActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
            public void onBack() {
                ModifyPwdActivity.this.goBack();
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.ModifyPwdActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                WebModifyPwdCallback webModifyPwdCallback = PassportSDK.getInstance().getWebModifyPwdCallback();
                if (webModifyPwdCallback != null) {
                    ModifyPwdActivity.this.result.setResultCode(-301);
                    ModifyPwdActivity.this.result.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
                    webModifyPwdCallback.onFinish(ModifyPwdActivity.this.result);
                }
                PassportSDK.getInstance().release();
                ModifyPwdActivity.this.finish();
            }
        });
        this.sapiWebView.setChangePwdCallback(new SapiWebView.ChangePwdCallback() { // from class: com.baidu.sapi2.activity.ModifyPwdActivity.3
            @Override // com.baidu.sapi2.SapiWebView.ChangePwdCallback
            public void onSuccess() {
                WebModifyPwdCallback webModifyPwdCallback = PassportSDK.getInstance().getWebModifyPwdCallback();
                if (webModifyPwdCallback != null) {
                    ModifyPwdActivity.this.result.setResultCode(0);
                    ModifyPwdActivity.this.result.setResultMsg("成功");
                    webModifyPwdCallback.onFinish(ModifyPwdActivity.this.result);
                }
                PassportSDK.getInstance().release();
                ModifyPwdActivity.this.finish();
            }
        });
        this.sapiWebView.loadModifyPwd(this.bduss);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (this.executeSubClassMethod) {
            goBack();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goBack() {
        if (this.sapiWebView.canGoBack()) {
            this.sapiWebView.goBack();
            return;
        }
        WebModifyPwdCallback webModifyPwdCallback = PassportSDK.getInstance().getWebModifyPwdCallback();
        if (webModifyPwdCallback != null) {
            this.result.setResultCode(-301);
            this.result.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
            webModifyPwdCallback.onFinish(this.result);
        }
        PassportSDK.getInstance().release();
        finish();
    }
}
