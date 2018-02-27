package com.baidu.sapi2.activity;

import android.os.Bundle;
import android.widget.Toast;
import com.baidu.c.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.utils.SapiUtils;
/* loaded from: classes2.dex */
public class QrLoginActivity extends TitleActivity {
    public static final String EXTRA_BOOLEAN_FINISH_PAGE = "EXTRA_BOOLEAN_FINISH_PAGE";
    public static final String EXTRA_STRING_QR_LOGIN_URL = "EXTRA_STRING_QR_LOGIN_URL";
    private boolean finishPage;
    private String url;

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.e.layout_sapi_sdk_webview_with_title_bar);
        this.url = getIntent().getStringExtra(EXTRA_STRING_QR_LOGIN_URL);
        this.finishPage = getIntent().getBooleanExtra(EXTRA_BOOLEAN_FINISH_PAGE, true);
        if (!SapiUtils.isQrLoginSchema(this.url)) {
            Toast.makeText(this, "抱歉，您扫描的二维码有误，请重新扫描", 0).show();
            finishActivity();
            return;
        }
        setupViews();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity, com.baidu.sapi2.activity.BaseActivity
    public void setupViews() {
        super.setupViews();
        setTitle("二维码扫码登录");
        this.sapiWebView.setWebViewTitleCallback(new SapiWebView.WebViewTitleCallback() { // from class: com.baidu.sapi2.activity.QrLoginActivity.1
            @Override // com.baidu.sapi2.SapiWebView.WebViewTitleCallback
            public void onTitleChange(String str) {
                QrLoginActivity.this.setTitleText(str);
            }
        });
        this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() { // from class: com.baidu.sapi2.activity.QrLoginActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnNewBackCallback
            public boolean onBack() {
                if (!QrLoginActivity.this.sapiWebView.canGoBack()) {
                    QrLoginActivity.this.finishActivity();
                    return false;
                }
                QrLoginActivity.this.sapiWebView.goBack();
                return false;
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.QrLoginActivity.3
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                QrLoginActivity.this.finishActivity();
            }
        });
        this.sapiWebView.loadQrLogin(new SapiWebView.QrLoginCallback() { // from class: com.baidu.sapi2.activity.QrLoginActivity.4
            @Override // com.baidu.sapi2.SapiWebView.QrLoginCallback
            public void loginStatusChange(boolean z) {
                PassportSDK.getInstance().getQrLoginCallback().loginStatusChange(z);
            }
        }, this.url, this.finishPage);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (this.executeSubClassMethod) {
            goBack();
        }
    }

    private void goBack() {
        if (this.sapiWebView.canGoBack()) {
            this.sapiWebView.back();
        } else {
            finishActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity() {
        PassportSDK.getInstance().release();
        finish();
    }
}
