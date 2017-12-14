package com.baidu.sapi2.activity;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.b.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.SapiWebCallback;
import com.baidu.sapi2.result.SapiResult;
/* loaded from: classes2.dex */
public class OperationRecordActivity extends TitleActivity {
    public static final String EXTRA_BDUSS = "EXTRA_BDUSS";
    private String bduss;
    private SapiResult result = new SapiResult();

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
        this.bduss = getIntent().getStringExtra("EXTRA_BDUSS");
        if (TextUtils.isEmpty(this.bduss)) {
            SapiWebCallback sapiWebCallback = PassportSDK.getInstance().getSapiWebCallback();
            if (sapiWebCallback != null) {
                this.result.setResultCode(SapiResult.ERROR_CODE_PARAMS_ERROR);
                this.result.setResultMsg(SapiResult.ERROR_MSG_PARAMS_ERROR);
                sapiWebCallback.onFinish(this.result);
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
        setTitleText(a.f.sapi_sdk_operation_record_title);
        this.sapiWebView.setOnBackCallback(new SapiWebView.OnBackCallback() { // from class: com.baidu.sapi2.activity.OperationRecordActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
            public void onBack() {
                OperationRecordActivity.this.goBack();
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.OperationRecordActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                SapiWebCallback sapiWebCallback = PassportSDK.getInstance().getSapiWebCallback();
                if (sapiWebCallback != null) {
                    OperationRecordActivity.this.result.setResultCode(-301);
                    OperationRecordActivity.this.result.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
                    sapiWebCallback.onFinish(OperationRecordActivity.this.result);
                }
                PassportSDK.getInstance().release();
                OperationRecordActivity.this.finish();
            }
        });
        this.sapiWebView.loadOperationRecord(this.bduss);
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
        SapiWebCallback sapiWebCallback = PassportSDK.getInstance().getSapiWebCallback();
        if (sapiWebCallback != null) {
            this.result.setResultCode(-301);
            this.result.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
            sapiWebCallback.onFinish(this.result);
        }
        PassportSDK.getInstance().release();
        finish();
    }
}
