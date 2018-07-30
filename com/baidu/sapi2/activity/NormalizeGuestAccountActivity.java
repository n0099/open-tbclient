package com.baidu.sapi2.activity;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.d.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.NormalizeGuestAccountDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.result.NormalizeGuestAccountResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.utils.enums.SocialType;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes2.dex */
public class NormalizeGuestAccountActivity extends BaseActivity {
    public static final String EXTRA_BDUSS = "EXTRA_BDUSS";
    private String bduss;
    private NormalizeGuestAccountResult result = new NormalizeGuestAccountResult() { // from class: com.baidu.sapi2.activity.NormalizeGuestAccountActivity.1
        @Override // com.baidu.sapi2.result.NormalizeGuestAccountResult
        public void finishActivity() {
            super.finishActivity();
            NormalizeGuestAccountActivity.this.finish();
            PassportSDK.getInstance().release();
        }
    };
    private SocialType socialType;

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(a.e.layout_sapi_sdk_webview_with_title_bar);
            this.bduss = getIntent().getStringExtra("EXTRA_BDUSS");
            SapiAccount accountFromBduss = SapiContext.getInstance(this).getAccountFromBduss(this.bduss);
            if (TextUtils.isEmpty(this.bduss) || accountFromBduss == null) {
                this.result.setResultCode(-204);
                this.result.setResultMsg(SapiResult.ERROR_MSG_PARAMS_ERROR);
                normalizeFail();
                return;
            }
            this.socialType = accountFromBduss.getSocialType();
            init();
            setupViews();
        } catch (Throwable th) {
            reportWebviewError(th);
            this.result.setResultCode(-202);
            this.result.setResultMsg(SapiResult.ERROR_MSG_UNKNOWN);
            normalizeFail();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
        this.result.activity = this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        configTitle();
        this.sapiWebView.setOnBackCallback(new SapiWebView.OnBackCallback() { // from class: com.baidu.sapi2.activity.NormalizeGuestAccountActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
            public void onBack() {
                NormalizeGuestAccountActivity.this.goBack();
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.NormalizeGuestAccountActivity.3
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                NormalizeGuestAccountActivity.this.onClose();
            }
        });
        this.sapiWebView.setNormalizeGuestAccountCallback(new SapiJsCallBacks.NormalizeGuestAccountCallback() { // from class: com.baidu.sapi2.activity.NormalizeGuestAccountActivity.4
            @Override // com.baidu.sapi2.SapiJsCallBacks.NormalizeGuestAccountCallback
            public void onSuccess(boolean z) {
                NormalizeGuestAccountActivity.this.result.isAccountMerge = z;
                NormalizeGuestAccountActivity.this.result.setResultCode(0);
                NormalizeGuestAccountActivity.this.result.setResultMsg("成功");
                NormalizeGuestAccountActivity.this.normalizeSucess();
            }

            @Override // com.baidu.sapi2.SapiJsCallBacks.NormalizeGuestAccountCallback
            public void onFailure(int i, String str) {
                NormalizeGuestAccountActivity.this.result.setResultCode(0);
                NormalizeGuestAccountActivity.this.result.setResultMsg("成功");
                NormalizeGuestAccountActivity.this.normalizeFail();
            }
        });
        ArrayList arrayList = new ArrayList();
        NormalizeGuestAccountDTO normalizeGuestAccountDTO = PassportSDK.getInstance().getNormalizeGuestAccountDTO();
        if (normalizeGuestAccountDTO != null && WebLoginDTO.statExtraValid(normalizeGuestAccountDTO.statExtra)) {
            arrayList.add(new BasicNameValuePair("extrajson", WebLoginDTO.getStatExtraDecode(normalizeGuestAccountDTO.statExtra)));
        }
        this.sapiWebView.loadNormalizeGuestAccount(arrayList, this.bduss, this.socialType);
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
        normalizeFail();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goBack() {
        if (this.sapiWebView.canGoBack()) {
            this.sapiWebView.goBack();
        } else {
            onClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void normalizeSucess() {
        if (PassportSDK.getInstance().getNormalizeGuestAccountCallback() != null) {
            PassportSDK.getInstance().getNormalizeGuestAccountCallback().onSuccess(this.result);
        }
        NormalizeGuestAccountDTO normalizeGuestAccountDTO = PassportSDK.getInstance().getNormalizeGuestAccountDTO();
        if (normalizeGuestAccountDTO != null && normalizeGuestAccountDTO.finishActivityAfterSuc) {
            finish();
            PassportSDK.getInstance().release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void normalizeFail() {
        if (PassportSDK.getInstance().getNormalizeGuestAccountCallback() != null) {
            PassportSDK.getInstance().getNormalizeGuestAccountCallback().onFailure(this.result);
        }
        finish();
        PassportSDK.getInstance().release();
    }
}
