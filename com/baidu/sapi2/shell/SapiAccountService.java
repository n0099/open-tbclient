package com.baidu.sapi2.shell;

import android.content.Context;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.shell.callback.FastRegCallBack;
import com.baidu.sapi2.shell.callback.GetDynamicPwdCallBack;
import com.baidu.sapi2.shell.callback.LoginCallBack;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.SocialType;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public final class SapiAccountService {
    private static final String a = "native";
    private SapiConfiguration b = SapiAccountManager.getInstance().getSapiConfiguration();
    private a c;

    public SapiAccountService(Context context) {
        this.c = new a(context);
    }

    public String getLoginUrl() {
        return this.c.a() + "?" + a();
    }

    String a() {
        if (this.b == null) {
            throw new IllegalStateException(SapiAccountManager.class.getSimpleName() + " have not been initialized");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("clientfrom", a));
        arrayList.add(new BasicNameValuePair("tpl", this.b.tpl));
        arrayList.add(new BasicNameValuePair("login_share_strategy", this.b.loginShareStrategy.getStrValue()));
        arrayList.add(new BasicNameValuePair("client", SocialConstants.ANDROID_CLIENT_TYPE));
        arrayList.add(new BasicNameValuePair("adapter", this.b.customActionBarEnabled ? "3" : ""));
        arrayList.add(new BasicNameValuePair("t", String.valueOf(System.currentTimeMillis())));
        if (this.b.skin != null) {
            arrayList.add(new BasicNameValuePair("skin", this.b.skin));
        }
        arrayList.add(new BasicNameValuePair("act", this.b.socialBindType.getName()));
        return SapiUtils.createRequestParams(arrayList);
    }

    public String getUrlBind(SocialType socialType, String str, String str2) {
        if (this.b == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("tpl", this.b.tpl));
        arrayList.add(new BasicNameValuePair(SocialConstants.PARAM_DISPLAY, a));
        arrayList.add(new BasicNameValuePair("type", socialType.getType() + ""));
        arrayList.add(new BasicNameValuePair("act", this.b.socialBindType.getName()));
        arrayList.add(new BasicNameValuePair("access_token", str));
        arrayList.add(new BasicNameValuePair("osuid", str2));
        return this.c.c() + "?" + SapiUtils.createRequestParams(arrayList);
    }

    public String getUrlSSOFinish() {
        if (this.b == null) {
            return null;
        }
        return this.c.d();
    }

    public String getUrlBind(SocialType socialType) {
        if (this.b == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("tpl", this.b.tpl));
        arrayList.add(new BasicNameValuePair(SocialConstants.PARAM_DISPLAY, a));
        arrayList.add(new BasicNameValuePair("type", socialType.getType() + ""));
        arrayList.add(new BasicNameValuePair("act", this.b.socialBindType.getName()));
        return this.c.e() + "?" + SapiUtils.createRequestParams(arrayList);
    }

    public String getUrlAfterAuth() {
        if (this.b == null) {
            return null;
        }
        return this.c.f();
    }

    public String getUrlFinishBind() {
        if (this.b == null) {
            return null;
        }
        return this.c.g();
    }

    public boolean fastReg(FastRegCallBack fastRegCallBack, String str) {
        return this.c.a(fastRegCallBack, str);
    }

    public boolean getDynamicPwd(GetDynamicPwdCallBack getDynamicPwdCallBack, String str) {
        return this.c.a(getDynamicPwdCallBack, str);
    }

    public boolean dynamicPwdLogin(LoginCallBack loginCallBack, String str, String str2) {
        return this.c.a(loginCallBack, str, str2);
    }
}
