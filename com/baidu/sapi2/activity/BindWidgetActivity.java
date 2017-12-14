package com.baidu.sapi2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.b.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.WebBindWidgetCallback;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.WebBindWidgetResult;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import java.util.Collections;
/* loaded from: classes2.dex */
public class BindWidgetActivity extends TitleActivity {
    public static final String EXTRA_BDUSS = "EXTRA_BDUSS";
    public static final String EXTRA_BIND_WIDGET_ACTION = "EXTRA_BIND_WIDGET_ACTION";
    private String bduss;
    private BindWidgetAction bindWidgetAction;
    private WebBindWidgetResult result = new WebBindWidgetResult();

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
        WebBindWidgetCallback webBindWidgetCallback = PassportSDK.getInstance().getWebBindWidgetCallback();
        this.bindWidgetAction = (BindWidgetAction) getIntent().getSerializableExtra(EXTRA_BIND_WIDGET_ACTION);
        this.bduss = getIntent().getStringExtra("EXTRA_BDUSS");
        if (this.bindWidgetAction == null || TextUtils.isEmpty(this.bduss)) {
            if (webBindWidgetCallback != null) {
                this.result.setResultCode(SapiResult.ERROR_CODE_PARAMS_ERROR);
                this.result.setResultMsg(SapiResult.ERROR_MSG_PARAMS_ERROR);
                webBindWidgetCallback.onFinish(this.result);
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
        setTitleText(this.bindWidgetAction.getName());
        this.sapiWebView.setOnBackCallback(new SapiWebView.OnBackCallback() { // from class: com.baidu.sapi2.activity.BindWidgetActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
            public void onBack() {
                BindWidgetActivity.this.goBack();
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.BindWidgetActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                if (PassportSDK.getInstance().getWebBindWidgetCallback() != null) {
                    BindWidgetActivity.this.result.setResultCode(-301);
                    BindWidgetActivity.this.result.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
                    PassportSDK.getInstance().getWebBindWidgetCallback().onFinish(BindWidgetActivity.this.result);
                }
                PassportSDK.getInstance().release();
                BindWidgetActivity.this.finish();
            }
        });
        this.sapiWebView.setBindWidgetCallback(new SapiWebView.BindWidgetCallback() { // from class: com.baidu.sapi2.activity.BindWidgetActivity.3
            @Override // com.baidu.sapi2.SapiWebView.BindWidgetCallback
            public void onPhoneNumberExist(String str) {
                SapiAccountManager.getInstance().getSapiConfiguration().presetPhoneNumber = str;
                Intent intent = new Intent(BindWidgetActivity.this, LoginActivity.class);
                intent.putExtra(LoginActivity.EXTRA_LOGIN_TYPE, WebLoginDTO.EXTRA_LOGIN_WITH_SMS);
                BindWidgetActivity.this.startActivityForResult(intent, 0);
            }
        });
        this.sapiWebView.loadBindWidget(this.bindWidgetAction, this.bduss, Collections.singletonList(SapiWebView.EXTRA_BIND_WIDGET_CONFLICT_DETECT));
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
        if (PassportSDK.getInstance().getWebBindWidgetCallback() != null) {
            this.result.setResultCode(-301);
            this.result.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
            PassportSDK.getInstance().getWebBindWidgetCallback().onFinish(this.result);
        }
        PassportSDK.getInstance().release();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (PassportSDK.getInstance().getWebBindWidgetCallback() != null) {
                this.result.setResultCode(-301);
                this.result.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
                PassportSDK.getInstance().getWebBindWidgetCallback().onFinish(this.result);
            }
            PassportSDK.getInstance().release();
            finish();
        }
    }
}
