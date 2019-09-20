package com.baidu.sapi2.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.d.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.utils.SapiUtils;
import java.net.URLDecoder;
/* loaded from: classes2.dex */
public class AuthWidgetActivity extends BaseActivity {
    public static final String EXTRA_PARAM_AUTH_URL = "auth_url";
    private String authUrl;
    private SapiResult result = new SapiResult();
    private String u;

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(a.f.layout_sapi_sdk_webview_with_title_bar);
            this.authUrl = getIntent().getStringExtra(EXTRA_PARAM_AUTH_URL);
            this.u = SapiUtils.urlParamsToMap(this.authUrl).get("u");
            if (TextUtils.isEmpty(this.authUrl) || TextUtils.isEmpty(this.u)) {
                this.result.setResultCode(-204);
                this.result.setResultMsg(SapiResult.ERROR_MSG_PARAMS_ERROR);
                finishActivity();
                return;
            }
            init();
            setupViews();
        } catch (Throwable th) {
            reportWebviewError(th);
            finishActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        configTitle();
        this.sapiWebView.setOnBackCallback(new SapiWebView.OnBackCallback() { // from class: com.baidu.sapi2.activity.AuthWidgetActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
            public void onBack() {
                AuthWidgetActivity.this.goBack();
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.AuthWidgetActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                AuthWidgetActivity.this.onClose();
            }
        });
        this.sapiWebView.setLeftBtnVisibleCallback(new SapiWebView.LeftBtnVisibleCallback() { // from class: com.baidu.sapi2.activity.AuthWidgetActivity.3
            @Override // com.baidu.sapi2.SapiWebView.LeftBtnVisibleCallback
            public void onLeftBtnVisible(int i) {
                if (i == 0) {
                    AuthWidgetActivity.this.setBtnVisibility(4, 4, 4);
                } else {
                    AuthWidgetActivity.this.setBtnVisibility(4, 0, 4);
                }
            }
        });
        this.sapiWebView.setWebviewClientCallback(new SapiWebView.WebviewClientCallback() { // from class: com.baidu.sapi2.activity.AuthWidgetActivity.4
            @Override // com.baidu.sapi2.SapiWebView.WebviewClientCallback
            public void shouldOverrideUrlLoading(WebView webView, String str) {
                if (!TextUtils.isEmpty(str) && str.contains(URLDecoder.decode(AuthWidgetActivity.this.u))) {
                    PassportSDK.getInstance().getAuthWidgetCallback().onSuccess(SapiUtils.urlParamsToMap(str).get("authsid"));
                    AuthWidgetActivity.this.finish();
                }
            }

            @Override // com.baidu.sapi2.SapiWebView.WebviewClientCallback
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            }

            @Override // com.baidu.sapi2.SapiWebView.WebviewClientCallback
            public void onPageFinished(WebView webView, String str) {
            }
        });
        this.sapiWebView.loadUrl(this.authUrl);
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
            return;
        }
        this.result.setResultCode(-301);
        this.result.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
        finishActivity();
    }

    private void finishActivity() {
        if (PassportSDK.getInstance().getAuthWidgetCallback() != null) {
            PassportSDK.getInstance().getAuthWidgetCallback().onFailure(this.result);
        }
        finish();
        PassportSDK.getInstance().release();
    }
}
