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
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.result.NormalizeGuestAccountResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.utils.b;
import com.baidu.sapi2.utils.enums.SocialType;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class NormalizeGuestAccountActivity extends BaseActivity {
    public static final String EXTRA_BDUSS = "EXTRA_BDUSS";
    private NormalizeGuestAccountResult r = new NormalizeGuestAccountResult() { // from class: com.baidu.sapi2.activity.NormalizeGuestAccountActivity.1
        @Override // com.baidu.sapi2.result.NormalizeGuestAccountResult
        public void finishActivity() {
            super.finishActivity();
            NormalizeGuestAccountActivity.this.finish();
            PassportSDK.getInstance().release();
        }
    };
    private String s;
    private SocialType t;

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null && sapiWebView.canGoBack()) {
            this.sapiWebView.goBack();
        } else {
            onClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (PassportSDK.getInstance().getNormalizeGuestAccountCallback() != null) {
            PassportSDK.getInstance().getNormalizeGuestAccountCallback().onFailure(this.r);
        }
        finish();
        PassportSDK.getInstance().release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (PassportSDK.getInstance().getNormalizeGuestAccountCallback() != null) {
            PassportSDK.getInstance().getNormalizeGuestAccountCallback().onSuccess(this.r);
        }
        NormalizeGuestAccountDTO normalizeGuestAccountDTO = PassportSDK.getInstance().getNormalizeGuestAccountDTO();
        if (normalizeGuestAccountDTO == null || !normalizeGuestAccountDTO.finishActivityAfterSuc) {
            return;
        }
        finish();
        PassportSDK.getInstance().release();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public SapiWebDTO getWebDTO() {
        return PassportSDK.getInstance().getNormalizeGuestAccountDTO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
        this.r.activity = this;
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
        this.r.setResultCode(-301);
        this.r.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
        f();
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(a.f.layout_sapi_sdk_webview_with_title_bar);
            this.s = getIntent().getStringExtra("EXTRA_BDUSS");
            SapiAccount accountFromBduss = SapiContext.getInstance(this).getAccountFromBduss(this.s);
            if (!TextUtils.isEmpty(this.s) && accountFromBduss != null) {
                this.t = accountFromBduss.getSocialType();
                init();
                setupViews();
                return;
            }
            this.r.setResultCode(-204);
            this.r.setResultMsg(SapiResult.ERROR_MSG_PARAMS_ERROR);
            f();
        } catch (Throwable th) {
            reportWebviewError(th);
            this.r.setResultCode(-202);
            this.r.setResultMsg(SapiResult.ERROR_MSG_UNKNOWN);
            f();
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
        this.sapiWebView.setOnBackCallback(new SapiWebView.OnBackCallback() { // from class: com.baidu.sapi2.activity.NormalizeGuestAccountActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
            public void onBack() {
                NormalizeGuestAccountActivity.this.e();
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.NormalizeGuestAccountActivity.3
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                NormalizeGuestAccountActivity.this.onClose();
            }
        });
        String str = "";
        ArrayList arrayList = new ArrayList();
        NormalizeGuestAccountDTO normalizeGuestAccountDTO = PassportSDK.getInstance().getNormalizeGuestAccountDTO();
        if (normalizeGuestAccountDTO != null) {
            if (WebLoginDTO.statExtraValid(normalizeGuestAccountDTO.statExtra)) {
                arrayList.add(new PassNameValuePair("extrajson", WebLoginDTO.getStatExtraDecode(normalizeGuestAccountDTO.statExtra)));
            }
            str = normalizeGuestAccountDTO.description;
        }
        this.sapiWebView.setNormalizeGuestAccountCallback(new SapiJsCallBacks.NormalizeGuestAccountCallback() { // from class: com.baidu.sapi2.activity.NormalizeGuestAccountActivity.4
            @Override // com.baidu.sapi2.SapiJsCallBacks.NormalizeGuestAccountCallback
            public void onFailure(int i, String str2) {
                NormalizeGuestAccountActivity.this.r.setResultCode(i);
                NormalizeGuestAccountActivity.this.r.setResultMsg(str2);
                NormalizeGuestAccountActivity.this.f();
            }

            @Override // com.baidu.sapi2.SapiJsCallBacks.NormalizeGuestAccountCallback
            public void onSuccess(boolean z, String str2) {
                NormalizeGuestAccountActivity.this.r.isAccountMerge = z;
                NormalizeGuestAccountActivity.this.r.setNormalizeWay(str2);
                NormalizeGuestAccountActivity.this.r.setResultCode(0);
                NormalizeGuestAccountActivity.this.r.setResultMsg("成功");
                NormalizeGuestAccountActivity.this.g();
                new b().a(b.e);
            }
        }, str);
        this.sapiWebView.loadNormalizeGuestAccount(arrayList, this.s, this.t);
    }
}
