package com.baidu.sapi2.views;

import com.baidu.d.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.callback.GetDynamicPwdCallback;
import com.baidu.sapi2.result.GetDynamicPwdResult;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.views.SmsLoginView;
/* loaded from: classes2.dex */
class l extends GetDynamicPwdCallback {
    final /* synthetic */ SmsLoginView.c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(SmsLoginView.c cVar) {
        this.a = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: a */
    public void onCaptchaRequired(GetDynamicPwdResult getDynamicPwdResult) {
        if (SmsLoginView.this.q) {
            SmsLoginView.b(SmsLoginView.f.f, getDynamicPwdResult.getResultCode() + "");
        } else {
            SmsLoginView.b(SmsLoginView.f.i, getDynamicPwdResult.getResultCode() + "");
        }
        if (SmsLoginView.this.o != null) {
            SmsLoginView.this.o.cancel();
        }
        WebAuthResult webAuthResult = new WebAuthResult();
        webAuthResult.setResultCode(getDynamicPwdResult.getResultCode());
        webAuthResult.setResultMsg(getDynamicPwdResult.getResultMsg());
        SapiAccountManager.getInstance().getConfignation().presetPhoneNumber = SmsLoginView.this.p;
        if (PassportSDK.getInstance().getSmsViewLoginCallback() != null) {
            SmsLoginView.this.p = "";
            PassportSDK.getInstance().getSmsViewLoginCallback().onNeedBack(webAuthResult);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: b */
    public void onFailure(GetDynamicPwdResult getDynamicPwdResult) {
        if (SmsLoginView.this.q) {
            SmsLoginView.b(SmsLoginView.f.f, getDynamicPwdResult.getResultCode() + "");
            SmsLoginView.this.j.setText(a.g.sapi_sdk_sms_get_check_code);
        } else {
            SmsLoginView.b(SmsLoginView.f.i, getDynamicPwdResult.getResultCode() + "");
            SmsLoginView.this.j.setText(a.g.sapi_sdk_sms_re_get_check_code);
        }
        if (SmsLoginView.this.o != null) {
            SmsLoginView.this.o.cancel();
        }
        SmsLoginView.this.j.setEnabled(true);
        SmsLoginView.this.a(true);
        if (getDynamicPwdResult.noNeedBack) {
            SmsLoginView.this.k.setText(getDynamicPwdResult.getResultMsg());
            SmsLoginView.this.k.setVisibility(0);
            return;
        }
        WebAuthResult webAuthResult = new WebAuthResult();
        webAuthResult.setResultCode(getDynamicPwdResult.getResultCode());
        webAuthResult.setResultMsg(getDynamicPwdResult.getResultMsg());
        SapiAccountManager.getInstance().getConfignation().presetPhoneNumber = SmsLoginView.this.p;
        if (PassportSDK.getInstance().getSmsViewLoginCallback() != null) {
            SmsLoginView.this.p = "";
            PassportSDK.getInstance().getSmsViewLoginCallback().onNeedBack(webAuthResult);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: c */
    public void onSuccess(GetDynamicPwdResult getDynamicPwdResult) {
        if (SmsLoginView.this.q) {
            SmsLoginView.b(SmsLoginView.f.e, (String) null);
        } else {
            SmsLoginView.b(SmsLoginView.f.h, (String) null);
        }
    }

    public void onFinish() {
    }

    public void onStart() {
    }
}
