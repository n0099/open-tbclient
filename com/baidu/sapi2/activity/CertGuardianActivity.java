package com.baidu.sapi2.activity;

import android.os.Bundle;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.CertGuardianCallback;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.result.CertGuardianResult;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class CertGuardianActivity extends BaseActivity {
    public static final String EXTRA_SCENE = "EXTRA_SCENE";
    public String t;
    public CertGuardianCallback u;
    public CertGuardianResult v;

    private void a() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null && sapiWebView.canGoBack()) {
            this.sapiWebView.back();
        } else {
            onClose();
        }
    }

    private void b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("sence", this.t));
        this.sapiWebView.loadCertGuardianUrl(arrayList);
    }

    private void finishActivity() {
        CertGuardianCallback certGuardianCallback = this.u;
        if (certGuardianCallback != null) {
            certGuardianCallback.onFinish(this.v);
        }
        finish();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public SapiWebDTO getWebDTO() {
        return CoreViewRouter.getInstance().getRealNameDTO();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
        this.t = getIntent().getStringExtra("EXTRA_SCENE");
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        a();
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (!this.executeSubClassMethod) {
            return;
        }
        a();
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText(R.string.sapi_sdk_title_cert_guardian);
        this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() { // from class: com.baidu.sapi2.activity.CertGuardianActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnNewBackCallback
            public boolean onBack() {
                SapiWebView sapiWebView = CertGuardianActivity.this.sapiWebView;
                if (sapiWebView != null && sapiWebView.canGoBack()) {
                    CertGuardianActivity.this.sapiWebView.goBack();
                    return false;
                }
                CertGuardianActivity.this.onClose();
                return false;
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.CertGuardianActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                CertGuardianActivity.this.onClose();
            }
        });
        this.sapiWebView.setCertGuardianRusultCallback(new SapiJsCallBacks.CertGuardianRusultCallback() { // from class: com.baidu.sapi2.activity.CertGuardianActivity.3
            @Override // com.baidu.sapi2.SapiJsCallBacks.CertGuardianRusultCallback
            public void onFinish(CertGuardianResult certGuardianResult) {
                CertGuardianActivity.this.v = certGuardianResult;
                CertGuardianActivity.this.onClose();
            }
        });
        b();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onClose() {
        super.onClose();
        if (this.v == null) {
            this.v = new CertGuardianResult();
        }
        if (this.v.getResultCode() == 110000) {
            this.v.setResultCode(0);
            this.v.setResultMsg("成功");
        } else {
            this.v.setResultCode(-301);
            this.v.setResultMsg("您已取消操作");
        }
        finishActivity();
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            this.u = CoreViewRouter.getInstance().getCertGuardianCallback();
            CoreViewRouter.getInstance().releaseCertGuardianCallback();
            setContentView(R.layout.layout_sapi_sdk_webview_with_title_bar);
            init();
            setupViews();
        } catch (Throwable th) {
            reportWebviewError(th);
            if (this.v == null) {
                this.v = new CertGuardianResult();
            }
            this.v.setResultCode(-202);
            this.v.setResultMsg("网络连接失败，请检查网络设置");
            finishActivity();
        }
    }
}
