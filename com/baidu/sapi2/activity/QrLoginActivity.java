package com.baidu.sapi2.activity;

import android.os.Bundle;
import android.widget.Toast;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.QrLoginCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.result.QrAppLoginResult;
import com.baidu.sapi2.result.QrLoginResult;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.QrLoginAction;
import d.b.y.a.f;
import d.b.y.a.g;
/* loaded from: classes2.dex */
public class QrLoginActivity extends BaseActivity {
    public static final String EXTRA_BOOLEAN_FINISH_PAGE = "EXTRA_BOOLEAN_FINISH_PAGE";
    public static final String EXTRA_STRING_QR_LOGIN_URL = "EXTRA_STRING_QR_LOGIN_URL";
    public String p;
    public boolean q;
    public QrLoginResult r = new QrLoginResult();

    private void finishActivity() {
        a(true);
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
        this.p = getIntent().getStringExtra(EXTRA_STRING_QR_LOGIN_URL);
        this.q = getIntent().getBooleanExtra(EXTRA_BOOLEAN_FINISH_PAGE, true);
        if (SapiUtils.isQrLoginSchema(this.p)) {
            return;
        }
        Toast.makeText(this, "抱歉，您扫描的二维码有误，请重新扫描", 0).show();
        this.r.setResultCode(-204);
        this.r.setResultMsg("参数错误，请稍后再试");
        finishActivity();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        a();
    }

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
        }, this.p, QrLoginAction.CANCEL.getName());
        this.r.setResultCode(-301);
        this.r.setResultMsg("您已取消操作");
        finishActivity();
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(f.layout_sapi_sdk_webview_with_title_bar);
            init();
            setupViews();
        } catch (Throwable th) {
            reportWebviewError(th);
            this.r.setResultCode(-202);
            this.r.setResultMsg("网络连接失败，请检查网络设置");
            finishActivity();
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (this.executeSubClassMethod) {
            a();
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitle(g.sapi_sdk_title_qr_login);
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
                QrLoginResult qrLoginResult = QrLoginActivity.this.r;
                qrLoginResult.loginStatusChange = z;
                qrLoginResult.setResultCode(0);
                QrLoginActivity.this.r.setResultMsg("成功");
                QrLoginActivity qrLoginActivity = QrLoginActivity.this;
                qrLoginActivity.a(qrLoginActivity.q);
            }
        }, this.p, false);
    }

    private void a() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null && sapiWebView.canGoBack()) {
            this.sapiWebView.back();
        } else {
            onClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        try {
            this.sapiWebView.destroy();
        } catch (Exception unused) {
        }
        QrLoginCallback qrLoginCallback = CoreViewRouter.getInstance().getQrLoginCallback();
        if (qrLoginCallback != null) {
            qrLoginCallback.onFinish(this.r);
        }
        if (z) {
            finish();
        }
        CoreViewRouter.getInstance().release();
    }
}
