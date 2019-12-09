package com.baidu.sapi2.views;

import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.callback.DynamicPwdLoginCallback;
import com.baidu.sapi2.result.DynamicPwdLoginResult;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.views.SmsLoginView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class i extends DynamicPwdLoginCallback {
    final /* synthetic */ SmsLoginView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(SmsLoginView smsLoginView) {
        this.a = smsLoginView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.sapi2.callback.SapiCallback
    /* renamed from: a */
    public void onFailure(DynamicPwdLoginResult dynamicPwdLoginResult) {
        SmsLoginView.b(SmsLoginView.f.l, dynamicPwdLoginResult.getResultCode() + "");
        WebAuthResult webAuthResult = new WebAuthResult();
        webAuthResult.setResultCode(dynamicPwdLoginResult.getResultCode());
        webAuthResult.setResultMsg(dynamicPwdLoginResult.getResultMsg());
        if (dynamicPwdLoginResult.noNeedBack) {
            this.a.k.setText(dynamicPwdLoginResult.getResultMsg());
            this.a.k.setVisibility(0);
            this.a.i.setText("");
            if (PassportSDK.getInstance().getSmsViewLoginCallback() != null) {
                PassportSDK.getInstance().getSmsViewLoginCallback().onFailure(webAuthResult);
                return;
            }
            return;
        }
        SapiAccountManager.getInstance().getConfignation().presetPhoneNumber = this.a.p;
        if (PassportSDK.getInstance().getSmsViewLoginCallback() != null) {
            this.a.p = "";
            PassportSDK.getInstance().getSmsViewLoginCallback().onNeedBack(webAuthResult);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.sapi2.callback.SapiCallback
    /* renamed from: b */
    public void onSuccess(DynamicPwdLoginResult dynamicPwdLoginResult) {
        SmsLoginView.b("success", (String) null);
        WebAuthResult webAuthResult = new WebAuthResult();
        webAuthResult.setResultCode(dynamicPwdLoginResult.getResultCode());
        webAuthResult.setResultMsg(dynamicPwdLoginResult.getResultMsg());
        webAuthResult.accountType = AccountType.NORMAL;
        if (PassportSDK.getInstance().getSmsViewLoginCallback() != null) {
            SapiContext.getInstance().putEncryptStr(SapiContext.KEY_LAST_LOGIN_PHONE, this.a.p);
            SapiContext.getInstance().put(SapiContext.KEY_PRE_LOGIN_TYPE, "sms");
            PassportSDK.getInstance().getSmsViewLoginCallback().onSuccess(webAuthResult);
        }
        new com.baidu.sapi2.utils.b().a(com.baidu.sapi2.utils.b.b);
    }

    @Override // com.baidu.sapi2.callback.SapiCallback
    public void onFinish() {
        this.a.a();
    }

    @Override // com.baidu.sapi2.callback.SapiCallback
    public void onStart() {
        this.a.b();
    }
}
