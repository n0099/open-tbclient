package com.baidu.sapi2.activity;

import android.os.Bundle;
import android.widget.Toast;
import com.baidu.d.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.QrLoginCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.result.QrAppLoginResult;
import com.baidu.sapi2.result.QrLoginResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.QrLoginAction;
/* loaded from: classes2.dex */
public class QrLoginActivity extends BaseActivity {
    public static final String EXTRA_BOOLEAN_FINISH_PAGE = "EXTRA_BOOLEAN_FINISH_PAGE";
    public static final String EXTRA_STRING_QR_LOGIN_URL = "EXTRA_STRING_QR_LOGIN_URL";
    private String r;
    private boolean s;
    QrLoginResult t = new QrLoginResult();

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        QrLoginCallback qrLoginCallback = PassportSDK.getInstance().getQrLoginCallback();
        if (qrLoginCallback != null) {
            qrLoginCallback.onFinish(this.t);
        }
        if (z) {
            finish();
        }
        PassportSDK.getInstance().release();
    }

    private void e() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null && sapiWebView.canGoBack()) {
            this.sapiWebView.back();
        } else {
            onClose();
        }
    }

    private void finishActivity() {
        b(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
        this.r = getIntent().getStringExtra(EXTRA_STRING_QR_LOGIN_URL);
        this.s = getIntent().getBooleanExtra(EXTRA_BOOLEAN_FINISH_PAGE, true);
        if (SapiUtils.isQrLoginSchema(this.r)) {
            return;
        }
        Toast.makeText(this, "抱歉，您扫描的二维码有误，请重新扫描", 0).show();
        this.t.setResultCode(-204);
        this.t.setResultMsg(SapiResult.ERROR_MSG_PARAMS_ERROR);
        finishActivity();
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
        SapiAccountManager.getInstance().getAccountService().qrAppLogin(new SapiCallback<QrAppLoginResult>() { // from class: com.baidu.sapi2.activity.QrLoginActivity.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(QrAppLoginResult qrAppLoginResult) {
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onStart() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(QrAppLoginResult qrAppLoginResult) {
            }
        }, this.r, QrLoginAction.CANCEL.getName());
        this.t.setResultCode(-301);
        this.t.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
        finishActivity();
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(a.f.layout_sapi_sdk_webview_with_title_bar);
            init();
            setupViews();
        } catch (Throwable th) {
            reportWebviewError(th);
            this.t.setResultCode(-202);
            this.t.setResultMsg(SapiResult.ERROR_MSG_UNKNOWN);
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
        setTitle(a.g.sapi_sdk_title_qr_login);
        this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() { // from class: com.baidu.sapi2.activity.QrLoginActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnNewBackCallback
            public boolean onBack() {
                SapiWebView sapiWebView = QrLoginActivity.this.sapiWebView;
                if (sapiWebView != null && sapiWebView.canGoBack()) {
                    QrLoginActivity.this.sapiWebView.goBack();
                    return false;
                }
                QrLoginActivity.this.onClose();
                return false;
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.QrLoginActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                QrLoginActivity.this.onClose();
            }
        });
        this.sapiWebView.loadQrLogin(new SapiWebView.QrLoginCallback() { // from class: com.baidu.sapi2.activity.QrLoginActivity.3
            @Override // com.baidu.sapi2.SapiWebView.QrLoginCallback
            public void loginStatusChange(boolean z) {
                QrLoginResult qrLoginResult = QrLoginActivity.this.t;
                qrLoginResult.loginStatusChange = z;
                qrLoginResult.setResultCode(0);
                QrLoginActivity.this.t.setResultMsg("成功");
                QrLoginActivity qrLoginActivity = QrLoginActivity.this;
                qrLoginActivity.b(qrLoginActivity.s);
            }
        }, this.r, false);
    }
}
