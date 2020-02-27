package com.baidu.sapi2.activity;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.i.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.WebFillUProfileCallback;
import com.baidu.sapi2.result.WebFillUProfileResult;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
/* loaded from: classes6.dex */
public class FillUProfileActivity extends BaseActivity {
    public static final String EXTRA_BDUSS = "EXTRA_BDUSS";
    public static final String EXTRA_SIMPLIFIED = "EXTRA_SIMPLIFIED";
    private WebFillUProfileResult r = new WebFillUProfileResult();
    private String s;
    private boolean t;

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
        WebFillUProfileCallback webFillUProfileCallback = PassportSDK.getInstance().getWebFillUProfileCallback();
        if (webFillUProfileCallback != null) {
            webFillUProfileCallback.onFailure(this.r);
        }
        finish();
        PassportSDK.getInstance().release();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
        this.s = getIntent().getStringExtra("EXTRA_BDUSS");
        this.t = getIntent().getBooleanExtra(EXTRA_SIMPLIFIED, false);
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
        setTitleText(a.g.sapi_sdk_title_filluprofile);
        final WebFillUProfileCallback webFillUProfileCallback = PassportSDK.getInstance().getWebFillUProfileCallback();
        if (TextUtils.isEmpty(this.s)) {
            this.r.setResultCode(-204);
            finishActivity();
        }
        this.sapiWebView.setOnBackCallback(new SapiWebView.OnBackCallback() { // from class: com.baidu.sapi2.activity.FillUProfileActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
            public void onBack() {
                FillUProfileActivity.this.e();
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
            public void onFailed(int i, String str) {
                if (webFillUProfileCallback != null) {
                    FillUProfileActivity.this.r.setResultCode(i);
                    FillUProfileActivity.this.r.setResultMsg(str);
                    webFillUProfileCallback.onSuccess(FillUProfileActivity.this.r);
                }
                FillUProfileActivity.this.finish();
                PassportSDK.getInstance().release();
            }

            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void onSuccess() {
                if (webFillUProfileCallback != null) {
                    FillUProfileActivity.this.r.setResultCode(0);
                    webFillUProfileCallback.onSuccess(FillUProfileActivity.this.r);
                }
                FillUProfileActivity.this.finish();
                PassportSDK.getInstance().release();
            }
        });
        this.sapiWebView.loadFillUProfile(this.s, this.t);
    }
}
