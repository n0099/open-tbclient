package com.baidu.sapi2.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.searchbox.player.model.YYOption;
import com.baidu.tieba.R;
import com.baidu.validation.result.ValidationResult;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AuthWidgetForCashierActivity extends BaseActivity {
    public static final String u = "passport://passport.baidu.com/cashiersdk_auth_pass";
    public static final String v = "EXTRA_PARAM_AUTH_ID";
    public static final String w = "RESULT_KEY_CODE";
    public static final String x = "RESULT_KEY_MSG";
    public static final int y = 102;
    public String t;

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null && sapiWebView.canGoBack()) {
            this.sapiWebView.goBack();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(w, 1);
        intent.putExtra(x, "用户取消");
        setResult(102, intent);
        finish();
    }

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
        Intent intent = new Intent();
        intent.putExtra(w, 1);
        intent.putExtra(x, "用户取消");
        setResult(102, intent);
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

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_sapi_sdk_webview_with_title_bar);
        this.t = getIntent().getStringExtra("EXTRA_PARAM_AUTH_ID");
        init();
        setupViews();
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        this.sapiWebView.setOnBackCallback(new SapiWebView.OnBackCallback() { // from class: com.baidu.sapi2.activity.AuthWidgetForCashierActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
            public void onBack() {
                AuthWidgetForCashierActivity.this.a();
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.AuthWidgetForCashierActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                AuthWidgetForCashierActivity.this.onClose();
            }
        });
        this.sapiWebView.setLeftBtnVisibleCallback(new SapiWebView.LeftBtnVisibleCallback() { // from class: com.baidu.sapi2.activity.AuthWidgetForCashierActivity.3
            @Override // com.baidu.sapi2.SapiWebView.LeftBtnVisibleCallback
            public void onLeftBtnVisible(int i) {
                if (i == 0) {
                    AuthWidgetForCashierActivity.this.setBtnVisibility(4, 4, 4);
                } else {
                    AuthWidgetForCashierActivity.this.setBtnVisibility(4, 0, 4);
                }
            }
        });
        this.sapiWebView.setWebviewClientCallback(new SapiWebView.WebviewClientCallback() { // from class: com.baidu.sapi2.activity.AuthWidgetForCashierActivity.4
            @Override // com.baidu.sapi2.SapiWebView.WebviewClientCallback
            public void onPageFinished(WebView webView, String str) {
            }

            @Override // com.baidu.sapi2.SapiWebView.WebviewClientCallback
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            }

            @Override // com.baidu.sapi2.SapiWebView.WebviewClientCallback
            public void shouldOverrideUrlLoading(WebView webView, String str) {
                if (!TextUtils.isEmpty(str) && str.contains(AuthWidgetForCashierActivity.u)) {
                    Intent intent = new Intent();
                    intent.putExtra(AuthWidgetForCashierActivity.w, 0);
                    intent.putExtra(AuthWidgetForCashierActivity.x, ValidationResult.MSG_SUCCESS);
                    AuthWidgetForCashierActivity.this.setResult(102, intent);
                    AuthWidgetForCashierActivity.this.finish();
                }
            }
        });
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("u", u));
        arrayList.add(new PassNameValuePair("scene", BindVerifyActivity.SCENE));
        arrayList.add(new PassNameValuePair("isnew", YYOption.IsLive.VALUE_TRUE));
        arrayList.add(new PassNameValuePair("authid", this.t));
        this.sapiWebView.loadAuthWidget(arrayList, true);
    }
}
