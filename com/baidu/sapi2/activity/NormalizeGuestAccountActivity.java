package com.baidu.sapi2.activity;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.NormalizeGuestAccountDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.result.NormalizeGuestAccountResult;
import com.baidu.sapi2.utils.c;
import com.baidu.sapi2.utils.enums.SocialType;
import d.b.a0.a.f;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class NormalizeGuestAccountActivity extends BaseActivity {
    public static final String EXTRA_BDUSS = "EXTRA_BDUSS";
    public NormalizeGuestAccountResult p = new NormalizeGuestAccountResult() { // from class: com.baidu.sapi2.activity.NormalizeGuestAccountActivity.1
        @Override // com.baidu.sapi2.result.NormalizeGuestAccountResult
        public void finishActivity() {
            super.finishActivity();
            NormalizeGuestAccountActivity.this.finish();
            CoreViewRouter.getInstance().release();
        }
    };
    public String q;
    public SocialType r;

    @Override // com.baidu.sapi2.activity.TitleActivity
    public SapiWebDTO getWebDTO() {
        return CoreViewRouter.getInstance().getNormalizeGuestAccountDTO();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
        this.p.activity = this;
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        a();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onClose() {
        super.onClose();
        this.p.setResultCode(-301);
        this.p.setResultMsg("您已取消操作");
        b();
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(f.layout_sapi_sdk_webview_with_title_bar);
            this.q = getIntent().getStringExtra("EXTRA_BDUSS");
            SapiAccount accountFromBduss = SapiContext.getInstance().getAccountFromBduss(this.q);
            if (!TextUtils.isEmpty(this.q) && accountFromBduss != null) {
                this.r = accountFromBduss.getSocialType();
                init();
                setupViews();
                return;
            }
            this.p.setResultCode(-204);
            this.p.setResultMsg("参数错误，请稍后再试");
            b();
        } catch (Throwable th) {
            reportWebviewError(th);
            this.p.setResultCode(-202);
            this.p.setResultMsg("网络连接失败，请检查网络设置");
            b();
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
        String str;
        super.setupViews();
        this.sapiWebView.setOnBackCallback(new SapiWebView.OnBackCallback() { // from class: com.baidu.sapi2.activity.NormalizeGuestAccountActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnBackCallback
            public void onBack() {
                NormalizeGuestAccountActivity.this.a();
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.NormalizeGuestAccountActivity.3
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                NormalizeGuestAccountActivity.this.onClose();
            }
        });
        ArrayList arrayList = new ArrayList();
        NormalizeGuestAccountDTO normalizeGuestAccountDTO = CoreViewRouter.getInstance().getNormalizeGuestAccountDTO();
        if (normalizeGuestAccountDTO != null) {
            if (WebLoginDTO.statExtraValid(normalizeGuestAccountDTO.statExtra)) {
                arrayList.add(new PassNameValuePair("extrajson", WebLoginDTO.getStatExtraDecode(normalizeGuestAccountDTO.statExtra)));
            }
            str = normalizeGuestAccountDTO.description;
        } else {
            str = "";
        }
        this.sapiWebView.setNormalizeGuestAccountCallback(new SapiJsCallBacks.NormalizeGuestAccountCallback() { // from class: com.baidu.sapi2.activity.NormalizeGuestAccountActivity.4
            @Override // com.baidu.sapi2.SapiJsCallBacks.NormalizeGuestAccountCallback
            public void onFailure(int i, String str2) {
                NormalizeGuestAccountActivity.this.p.setResultCode(i);
                NormalizeGuestAccountActivity.this.p.setResultMsg(str2);
                NormalizeGuestAccountActivity.this.b();
            }

            @Override // com.baidu.sapi2.SapiJsCallBacks.NormalizeGuestAccountCallback
            public void onSuccess(boolean z, String str2) {
                NormalizeGuestAccountActivity.this.p.isAccountMerge = z;
                NormalizeGuestAccountActivity.this.p.setNormalizeWay(str2);
                NormalizeGuestAccountActivity.this.p.setResultCode(0);
                NormalizeGuestAccountActivity.this.p.setResultMsg("成功");
                NormalizeGuestAccountActivity.this.c();
                new c().a(c.f11446e);
            }
        }, str);
        setNewLoginTitleAndSetStyleChangeCallBack();
        this.sapiWebView.loadNormalizeGuestAccount(arrayList, this.q, this.r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null && sapiWebView.canGoBack()) {
            this.sapiWebView.goBack();
        } else {
            onClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (CoreViewRouter.getInstance().getNormalizeGuestAccountCallback() != null) {
            CoreViewRouter.getInstance().getNormalizeGuestAccountCallback().onFailure(this.p);
        }
        finish();
        CoreViewRouter.getInstance().release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (CoreViewRouter.getInstance().getNormalizeGuestAccountCallback() != null) {
            CoreViewRouter.getInstance().getNormalizeGuestAccountCallback().onSuccess(this.p);
        }
        NormalizeGuestAccountDTO normalizeGuestAccountDTO = CoreViewRouter.getInstance().getNormalizeGuestAccountDTO();
        if (normalizeGuestAccountDTO == null || !normalizeGuestAccountDTO.finishActivityAfterSuc) {
            return;
        }
        finish();
        CoreViewRouter.getInstance().release();
    }
}
