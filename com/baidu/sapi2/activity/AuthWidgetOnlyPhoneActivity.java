package com.baidu.sapi2.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AuthWidgetOnlyPhoneActivity extends BaseActivity {
    public static final String EXTRA_PARAM_AUTH_ID = "EXTRA_PARAM_AUTH_ID";
    public static final String EXTRA_PARAM_SCENE = "EXTRA_PARAM_SCENE";
    public static final String w = "ppsdk://authwidget/u";
    public String t;
    public String u;
    public SapiResult v = new SapiResult();

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        a();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onClose() {
        super.onClose();
        if (CoreViewRouter.getInstance().getAuthWidgetCallback() != null) {
            this.v.setResultCode(-301);
            this.v.setResultMsg("您已取消操作");
            CoreViewRouter.getInstance().getAuthWidgetCallback().onFailure(this.v);
        }
        finish();
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (!this.executeSubClassMethod) {
            return;
        }
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null && sapiWebView.canGoBack()) {
            this.sapiWebView.goBack();
            return;
        }
        if (CoreViewRouter.getInstance().getAuthWidgetCallback() != null) {
            this.v.setResultCode(-301);
            this.v.setResultMsg("您已取消操作");
            CoreViewRouter.getInstance().getAuthWidgetCallback().onFailure(this.v);
        }
        finish();
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_sapi_sdk_webview_with_title_bar);
        this.t = getIntent().getStringExtra("EXTRA_PARAM_AUTH_ID");
        this.u = getIntent().getStringExtra(EXTRA_PARAM_SCENE);
        init();
        setupViews();
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        this.sapiWebView.setOnBackCallback(new SapiWebView.OnBackCallback() { // from class: com.baidu.sapi2.activity.AuthWidgetOnlyPhoneActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
            public void onBack() {
                AuthWidgetOnlyPhoneActivity.this.a();
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.AuthWidgetOnlyPhoneActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                AuthWidgetOnlyPhoneActivity.this.onClose();
            }
        });
        this.sapiWebView.setLeftBtnVisibleCallback(new SapiWebView.LeftBtnVisibleCallback() { // from class: com.baidu.sapi2.activity.AuthWidgetOnlyPhoneActivity.3
            @Override // com.baidu.sapi2.SapiWebView.LeftBtnVisibleCallback
            public void onLeftBtnVisible(int i) {
                if (i == 0) {
                    AuthWidgetOnlyPhoneActivity.this.setBtnVisibility(4, 4, 4);
                } else {
                    AuthWidgetOnlyPhoneActivity.this.setBtnVisibility(4, 0, 4);
                }
            }
        });
        this.sapiWebView.setWebviewClientCallback(new SapiWebView.WebviewClientCallback() { // from class: com.baidu.sapi2.activity.AuthWidgetOnlyPhoneActivity.4
            @Override // com.baidu.sapi2.SapiWebView.WebviewClientCallback
            public void onPageFinished(WebView webView, String str) {
            }

            @Override // com.baidu.sapi2.SapiWebView.WebviewClientCallback
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            }

            @Override // com.baidu.sapi2.SapiWebView.WebviewClientCallback
            public void shouldOverrideUrlLoading(WebView webView, String str) {
                if (!TextUtils.isEmpty(str) && str.contains(AuthWidgetOnlyPhoneActivity.w)) {
                    if (CoreViewRouter.getInstance().getAuthWidgetCallback() != null) {
                        CoreViewRouter.getInstance().getAuthWidgetCallback().onSuccess(AuthWidgetOnlyPhoneActivity.this.t);
                    }
                    AuthWidgetOnlyPhoneActivity.this.finish();
                }
            }
        });
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("u", w));
        arrayList.add(new PassNameValuePair("scene", this.u));
        arrayList.add(new PassNameValuePair("authid", this.t));
        this.sapiWebView.loadAuthWidget(arrayList);
    }
}
