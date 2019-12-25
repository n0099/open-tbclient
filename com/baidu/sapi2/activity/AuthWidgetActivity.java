package com.baidu.sapi2.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.i.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.utils.SapiUtils;
import java.net.URLDecoder;
/* loaded from: classes4.dex */
public class AuthWidgetActivity extends BaseActivity {
    public static final String EXTRA_PARAM_AUTH_URL = "auth_url";
    private String r;
    private String s;
    private SapiResult t = new SapiResult();

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null && sapiWebView.canGoBack()) {
            this.sapiWebView.goBack();
            return;
        }
        this.t.setResultCode(-301);
        this.t.setResultMsg("您已取消操作");
        finishActivity();
    }

    private void finishActivity() {
        if (PassportSDK.getInstance().getAuthWidgetCallback() != null) {
            PassportSDK.getInstance().getAuthWidgetCallback().onFailure(this.t);
        }
        finish();
        PassportSDK.getInstance().release();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
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
        this.t.setResultCode(-301);
        this.t.setResultMsg("您已取消操作");
        finishActivity();
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(a.f.layout_sapi_sdk_webview_with_title_bar);
            this.r = getIntent().getStringExtra(EXTRA_PARAM_AUTH_URL);
            this.s = SapiUtils.urlParamsToMap(this.r).get("u");
            if (!TextUtils.isEmpty(this.r) && !TextUtils.isEmpty(this.s)) {
                init();
                setupViews();
                return;
            }
            this.t.setResultCode(-204);
            this.t.setResultMsg("参数错误，请稍后再试");
            finishActivity();
        } catch (Throwable th) {
            reportWebviewError(th);
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
        configTitle();
        this.sapiWebView.setOnBackCallback(new SapiWebView.OnBackCallback() { // from class: com.baidu.sapi2.activity.AuthWidgetActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
            public void onBack() {
                AuthWidgetActivity.this.e();
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
            public void onPageFinished(WebView webView, String str) {
            }

            @Override // com.baidu.sapi2.SapiWebView.WebviewClientCallback
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            }

            @Override // com.baidu.sapi2.SapiWebView.WebviewClientCallback
            public void shouldOverrideUrlLoading(WebView webView, String str) {
                if (TextUtils.isEmpty(str) || !str.contains(URLDecoder.decode(AuthWidgetActivity.this.s))) {
                    return;
                }
                PassportSDK.getInstance().getAuthWidgetCallback().onSuccess(SapiUtils.urlParamsToMap(str).get("authsid"));
                AuthWidgetActivity.this.finish();
            }
        });
        this.sapiWebView.loadUrl(this.r);
    }
}
