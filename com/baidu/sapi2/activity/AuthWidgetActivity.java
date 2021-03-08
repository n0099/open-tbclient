package com.baidu.sapi2.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.j.a.a;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.utils.SapiUtils;
import java.net.URLDecoder;
/* loaded from: classes3.dex */
public class AuthWidgetActivity extends BaseActivity {
    public static final String EXTRA_PARAM_AUTH_URL = "auth_url";
    private String p;
    private String q;
    private SapiResult r = new SapiResult();

    private void finishActivity() {
        if (CoreViewRouter.getInstance().getAuthWidgetCallback() != null) {
            CoreViewRouter.getInstance().getAuthWidgetCallback().onFailure(this.r);
        }
        finish();
        CoreViewRouter.getInstance().release();
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
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onClose() {
        super.onClose();
        this.r.setResultCode(-301);
        this.r.setResultMsg("您已取消操作");
        finishActivity();
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(a.f.layout_sapi_sdk_webview_with_title_bar);
            this.p = getIntent().getStringExtra(EXTRA_PARAM_AUTH_URL);
            this.q = SapiUtils.urlParamsToMap(this.p).get("u");
            if (!TextUtils.isEmpty(this.p) && !TextUtils.isEmpty(this.q)) {
                init();
                setupViews();
                return;
            }
            this.r.setResultCode(-204);
            this.r.setResultMsg("参数错误，请稍后再试");
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
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        this.sapiWebView.setOnBackCallback(new SapiWebView.OnBackCallback() { // from class: com.baidu.sapi2.activity.AuthWidgetActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
            public void onBack() {
                AuthWidgetActivity.this.a();
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
                if (TextUtils.isEmpty(str) || !str.contains(URLDecoder.decode(AuthWidgetActivity.this.q))) {
                    return;
                }
                CoreViewRouter.getInstance().getAuthWidgetCallback().onSuccess(SapiUtils.urlParamsToMap(str).get("authsid"));
                AuthWidgetActivity.this.finish();
            }
        });
        this.sapiWebView.loadUrl(this.p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null && sapiWebView.canGoBack()) {
            this.sapiWebView.goBack();
            return;
        }
        this.r.setResultCode(-301);
        this.r.setResultMsg("您已取消操作");
        finishActivity();
    }
}
