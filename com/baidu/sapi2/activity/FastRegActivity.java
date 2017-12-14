package com.baidu.sapi2.activity;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.b.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.WebRegDTO;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.enums.AccountType;
/* loaded from: classes2.dex */
public class FastRegActivity extends BaseActivity {
    public static final String EXTRA_PARAM_BUSINESS_FROM = "extra_params_business_from";
    public static final int EXTRA_PARAM_FROM_LOGIN = 2001;
    public static final int EXTRA_PARAM_FROM_PASS_SDK_ENTER = 2002;
    public static final String EXTRA_RESULT_CODE = "result_code";
    public static final String EXTRA_RESULT_MSG = "result_msg";
    public static final int RESULT_AUTH_FAILURE = 1002;
    public static final int RESULT_AUTH_SUCCESS = 1001;
    private int businessFrom;
    private WebAuthResult webAuthResult = new WebAuthResult();

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.e.layout_sapi_sdk_webview);
        setupViews();
        initData();
    }

    private void initData() {
        this.businessFrom = getIntent().getIntExtra(EXTRA_PARAM_BUSINESS_FROM, EXTRA_PARAM_FROM_PASS_SDK_ENTER);
        this.webAuthResult.activity = this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity
    public void setupViews() {
        super.setupViews();
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.FastRegActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                if (FastRegActivity.this.businessFrom == 2002) {
                    WebAuthListener webAuthListener = PassportSDK.getInstance().getWebAuthListener();
                    if (webAuthListener != null) {
                        FastRegActivity.this.webAuthResult.setResultCode(-301);
                        FastRegActivity.this.webAuthResult.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
                        webAuthListener.onFailure(FastRegActivity.this.webAuthResult);
                    }
                    PassportSDK.getInstance().release();
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("result_code", -301);
                    intent.putExtra("result_msg", SapiResult.ERROR_MSG_PROCESSED_END);
                    FastRegActivity.this.setResult(1002);
                }
                FastRegActivity.this.finish();
            }
        });
        this.sapiWebView.setAuthorizationListener(new AuthorizationListener() { // from class: com.baidu.sapi2.activity.FastRegActivity.2
            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void onSuccess(AccountType accountType) {
                super.onSuccess(accountType);
                if (FastRegActivity.this.businessFrom == 2002) {
                    WebAuthListener webAuthListener = PassportSDK.getInstance().getWebAuthListener();
                    if (webAuthListener != null) {
                        FastRegActivity.this.webAuthResult.accountType = accountType;
                        FastRegActivity.this.webAuthResult.setResultCode(0);
                        webAuthListener.onSuccess(FastRegActivity.this.webAuthResult);
                    }
                    PassportSDK.getInstance().release();
                } else {
                    FastRegActivity.this.setResult(1001);
                }
                FastRegActivity.this.finish();
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
        });
        WebRegDTO webRegDTO = PassportSDK.getInstance().getWebRegDTO();
        this.sapiWebView.loadFastReg(webRegDTO != null ? webRegDTO.extraParams : null);
    }
}
