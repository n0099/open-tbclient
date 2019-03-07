package com.baidu.sapi2.activity;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.d.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.WebFillUProfileCallback;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.WebFillUProfileResult;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
/* loaded from: classes2.dex */
public class FillUProfileActivity extends BaseActivity {
    public static final String EXTRA_BDUSS = "EXTRA_BDUSS";
    public static final String EXTRA_SIMPLIFIED = "EXTRA_SIMPLIFIED";
    private String bduss;
    private WebFillUProfileResult result = new WebFillUProfileResult();
    private boolean simplified;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(a.f.layout_sapi_sdk_webview_with_title_bar);
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
        this.simplified = getIntent().getBooleanExtra(EXTRA_SIMPLIFIED, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setBtnVisibility(4, 0, 4);
        setTitleText(a.g.sapi_sdk_title_filluprofile);
        final WebFillUProfileCallback webFillUProfileCallback = PassportSDK.getInstance().getWebFillUProfileCallback();
        if (TextUtils.isEmpty(this.bduss)) {
            this.result.setResultCode(-204);
            finishActivity();
        }
        this.sapiWebView.setOnBackCallback(new SapiWebView.OnBackCallback() { // from class: com.baidu.sapi2.activity.FillUProfileActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
            public void onBack() {
                FillUProfileActivity.this.goBack();
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.FillUProfileActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                FillUProfileActivity.this.onClose();
            }
        });
        this.sapiWebView.setAuthorizationListener(new AuthorizationListener() { // from class: com.baidu.sapi2.activity.FillUProfileActivity.3
            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void onSuccess() {
                if (webFillUProfileCallback != null) {
                    FillUProfileActivity.this.result.setResultCode(0);
                    webFillUProfileCallback.onSuccess(FillUProfileActivity.this.result);
                }
                PassportSDK.getInstance().release();
                FillUProfileActivity.this.finish();
            }

            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void onFailed(int i, String str) {
                if (webFillUProfileCallback != null) {
                    FillUProfileActivity.this.result.setResultCode(i);
                    FillUProfileActivity.this.result.setResultMsg(str);
                    webFillUProfileCallback.onSuccess(FillUProfileActivity.this.result);
                }
                PassportSDK.getInstance().release();
                FillUProfileActivity.this.finish();
            }
        });
        this.sapiWebView.loadFillUProfile(this.bduss, this.simplified);
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
        if (this.sapiWebView != null && this.sapiWebView.canGoBack()) {
            this.sapiWebView.goBack();
        } else {
            onClose();
        }
    }

    private void finishActivity() {
        WebFillUProfileCallback webFillUProfileCallback = PassportSDK.getInstance().getWebFillUProfileCallback();
        if (webFillUProfileCallback != null) {
            webFillUProfileCallback.onFailure(this.result);
        }
        PassportSDK.getInstance().release();
        finish();
    }
}
