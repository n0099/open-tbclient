package com.baidu.sapi2.activity;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.g.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.SapiWebCallback;
import com.baidu.sapi2.result.SapiResult;
/* loaded from: classes19.dex */
public class OperationRecordActivity extends BaseActivity {
    public static final String EXTRA_BDUSS = "EXTRA_BDUSS";
    private SapiResult r = new SapiResult();
    private String s;

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null && sapiWebView.canGoBack()) {
            this.sapiWebView.goBack();
        } else {
            onClose();
        }
    }

    private void finishActivity() {
        SapiWebCallback sapiWebCallback = PassportSDK.getInstance().getSapiWebCallback();
        if (sapiWebCallback != null) {
            sapiWebCallback.onFinish(this.r);
        }
        finish();
        PassportSDK.getInstance().release();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
        this.s = getIntent().getStringExtra("EXTRA_BDUSS");
        if (TextUtils.isEmpty(this.s)) {
            this.r.setResultCode(-204);
            this.r.setResultMsg("参数错误，请稍后再试");
            finishActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onClose() {
        super.onClose();
        this.r.setResultCode(-301);
        this.r.setResultMsg("您已取消操作");
        finishActivity();
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
            this.r.setResultCode(-202);
            this.r.setResultMsg("网络连接失败，请检查网络设置");
            finishActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (!this.executeSubClassMethod) {
            return;
        }
        e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setBtnVisibility(4, 0, 4);
        setTitleText(a.g.sapi_sdk_title_operation_record);
        this.sapiWebView.setOnBackCallback(new SapiWebView.OnBackCallback() { // from class: com.baidu.sapi2.activity.OperationRecordActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
            public void onBack() {
                OperationRecordActivity.this.e();
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.OperationRecordActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                OperationRecordActivity.this.onClose();
            }
        });
        this.sapiWebView.loadOperationRecord(this.s);
    }
}
