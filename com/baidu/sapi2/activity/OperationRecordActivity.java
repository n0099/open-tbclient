package com.baidu.sapi2.activity;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.c.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.SapiWebCallback;
import com.baidu.sapi2.result.SapiResult;
/* loaded from: classes2.dex */
public class OperationRecordActivity extends BaseActivity {
    public static final String EXTRA_BDUSS = "EXTRA_BDUSS";
    private String bduss;
    private SapiResult result = new SapiResult();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(a.e.layout_sapi_sdk_webview_with_title_bar);
            init();
            setupViews();
        } catch (Throwable th) {
            reportWebviewError(th);
            this.result.setResultCode(-202);
            this.result.setResultMsg(SapiResult.ERROR_MSG_UNKNOWN);
            finishActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
        this.bduss = getIntent().getStringExtra("EXTRA_BDUSS");
        if (TextUtils.isEmpty(this.bduss)) {
            this.result.setResultCode(-204);
            this.result.setResultMsg(SapiResult.ERROR_MSG_PARAMS_ERROR);
            finishActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setBtnVisibility(4, 0, 4);
        setTitleText(a.f.sapi_sdk_title_operation_record);
        this.sapiWebView.setOnBackCallback(new SapiWebView.OnBackCallback() { // from class: com.baidu.sapi2.activity.OperationRecordActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
            public void onBack() {
                OperationRecordActivity.this.goBack();
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.OperationRecordActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                OperationRecordActivity.this.onClose();
            }
        });
        this.sapiWebView.loadOperationRecord(this.bduss);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (this.executeSubClassMethod) {
            goBack();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        goBack();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onClose() {
        super.onClose();
        this.result.setResultCode(-301);
        this.result.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
        finishActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goBack() {
        if (this.sapiWebView.canGoBack()) {
            this.sapiWebView.goBack();
        } else {
            onClose();
        }
    }

    private void finishActivity() {
        SapiWebCallback sapiWebCallback = PassportSDK.getInstance().getSapiWebCallback();
        if (sapiWebCallback != null) {
            sapiWebCallback.onFinish(this.result);
        }
        PassportSDK.getInstance().release();
        finish();
    }
}
