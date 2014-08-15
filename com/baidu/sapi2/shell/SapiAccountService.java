package com.baidu.sapi2.shell;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.d;
import com.baidu.sapi2.shell.callback.FillUsernameCallBack;
import com.baidu.sapi2.shell.callback.OAuthCallBack;
import com.baidu.sapi2.shell.callback.QrAppLoginCallBack;
import com.baidu.sapi2.shell.callback.QrPCLoginCallBack;
import com.baidu.sapi2.shell.callback.SapiCallBack;
import com.baidu.sapi2.shell.response.GetPortraitResponse;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SapiResponse;
import com.baidu.sapi2.utils.L;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.sapi2.utils.enums.RegistMode;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tbadk.TbConfig;
import java.net.URLEncoder;
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

    public String a() {
        return this.c.c() + "?" + e();
    }

    public String b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("adapter", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
        arrayList.add(new BasicNameValuePair("banner", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK));
        return this.c.d() + "?" + e() + "&" + SapiUtils.createRequestParams(arrayList);
    }

    public String a(BindWidgetAction bindWidgetAction) {
        if (bindWidgetAction == null) {
            throw new IllegalArgumentException("BindWidgetAction can't be null");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("adapter", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE));
        return this.c.a(bindWidgetAction) + "?" + e() + "&" + SapiUtils.createRequestParams(arrayList);
    }

    public String c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("tpl", SapiAccountManager.getInstance().getSapiConfiguration().tpl));
        arrayList.add(new BasicNameValuePair("showtype", "phone"));
        arrayList.add(new BasicNameValuePair("device", "wap"));
        arrayList.add(new BasicNameValuePair("adapter", "apps"));
        return this.c.e() + e() + "&" + SapiUtils.createRequestParams(arrayList);
    }

    public String d() {
        if (this.b == null) {
            return null;
        }
        return this.c.f();
    }

    public void cancelRequest() {
        this.c.a();
    }

    public void fillUsername(FillUsernameCallBack fillUsernameCallBack, String str, String str2, String str3) {
        this.c.a(fillUsernameCallBack, str, str2, str3);
    }

    public void setPortrait(SapiCallBack<SapiResponse> sapiCallBack, String str, String str2, String str3, byte[] bArr, String str4) {
        this.c.a(sapiCallBack, str, str2, str3, bArr, str4);
    }

    public void getPortrait(SapiCallBack<GetPortraitResponse> sapiCallBack, String str, String str2, String str3) {
        this.c.a(sapiCallBack, str, str2, str3);
    }

    String e() {
        if (this.b == null) {
            throw new IllegalStateException(SapiAccountManager.class.getSimpleName() + " have not been initialized");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("clientfrom", a));
        arrayList.add(new BasicNameValuePair("tpl", this.b.tpl));
        arrayList.add(new BasicNameValuePair("login_share_strategy", this.b.loginShareStrategy.getStrValue()));
        arrayList.add(new BasicNameValuePair("client", "android"));
        arrayList.add(new BasicNameValuePair("adapter", this.b.customActionBarEnabled ? TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE : ""));
        arrayList.add(new BasicNameValuePair("t", String.valueOf(System.currentTimeMillis())));
        arrayList.add(new BasicNameValuePair("act", this.b.socialBindType.getName()));
        arrayList.add(new BasicNameValuePair("loginInitType", String.valueOf(this.b.smsLoginConfig.flagLoginBtnType.ordinal())));
        arrayList.add(new BasicNameValuePair("loginLink", String.valueOf(this.b.smsLoginConfig.flagShowLoginLink.ordinal())));
        arrayList.add(new BasicNameValuePair("smsLoginLink", String.valueOf(this.b.smsLoginConfig.flagShowSmsLoginLink.ordinal())));
        arrayList.add(new BasicNameValuePair("lPFastRegLink", String.valueOf(this.b.smsLoginConfig.flagShowFastRegLink.ordinal())));
        if (this.b.registMode == RegistMode.FAST) {
            arrayList.add(new BasicNameValuePair("fastRegLink", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK));
        }
        if (this.b.collapseFastLoginArea) {
            arrayList.add(new BasicNameValuePair("otherLoginStyle", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK));
        }
        arrayList.add(new BasicNameValuePair("lPlayout", String.valueOf(this.b.configurableViewLayout.ordinal())));
        if (!this.b.showRegLink) {
            arrayList.add(new BasicNameValuePair("regLink", "0"));
        }
        if (!TextUtils.isEmpty(this.b.fastRegTitleText)) {
            try {
                arrayList.add(new BasicNameValuePair("fastRegText", URLEncoder.encode(this.b.fastRegTitleText, "UTF-8")));
            } catch (Throwable th) {
                L.e(th);
            }
        }
        return SapiUtils.createRequestParams(arrayList);
    }

    public String a(SocialType socialType, String str, String str2) {
        if (this.b == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("tpl", this.b.tpl));
        arrayList.add(new BasicNameValuePair("display", a));
        arrayList.add(new BasicNameValuePair("type", socialType.getType() + ""));
        arrayList.add(new BasicNameValuePair("act", this.b.socialBindType.getName()));
        arrayList.add(new BasicNameValuePair("access_token", str));
        arrayList.add(new BasicNameValuePair("osuid", str2));
        return this.c.k() + "?" + SapiUtils.createRequestParams(arrayList);
    }

    public String f() {
        if (this.b == null) {
            return null;
        }
        return this.c.l();
    }

    public String a(SocialType socialType) {
        if (this.b == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("tpl", this.b.tpl));
        arrayList.add(new BasicNameValuePair("display", a));
        arrayList.add(new BasicNameValuePair("type", socialType.getType() + ""));
        arrayList.add(new BasicNameValuePair("act", this.b.socialBindType.getName()));
        return this.c.m() + "?" + SapiUtils.createRequestParams(arrayList);
    }

    public String g() {
        if (this.b == null) {
            return null;
        }
        return this.c.n();
    }

    public String h() {
        if (this.b == null) {
            return null;
        }
        return this.c.o();
    }

    public boolean qrPCLogin(QrPCLoginCallBack qrPCLoginCallBack, String str, String str2, String str3, String str4, String str5) {
        return this.c.a(qrPCLoginCallBack, str, str2, str3, str4, str5);
    }

    public boolean qrAppLogin(QrAppLoginCallBack qrAppLoginCallBack, String str, String str2) {
        return this.c.a(qrAppLoginCallBack, str, str2);
    }

    public boolean a(SapiCallBack<SapiAccountResponse> sapiCallBack, String str) {
        return this.c.b(sapiCallBack, str);
    }

    public boolean getDynamicPwd(SapiCallBack<SapiResponse> sapiCallBack, String str) {
        return this.c.a(sapiCallBack, str);
    }

    public boolean dynamicPwdLogin(SapiCallBack<SapiAccountResponse> sapiCallBack, String str, String str2) {
        return this.c.a(sapiCallBack, str, str2, true);
    }

    public boolean a(SapiCallBack<SapiAccountResponse> sapiCallBack, String str, String str2) {
        return this.c.a(sapiCallBack, str, str2, false);
    }

    public void relogin(SapiCallBack<SapiResponse> sapiCallBack, SapiAccount.ReloginCredentials reloginCredentials) {
        this.c.a(sapiCallBack, reloginCredentials);
    }

    public int blockingRelogin(SapiAccount.ReloginCredentials reloginCredentials) {
        return this.c.a(reloginCredentials);
    }

    public void i() {
        this.c.b();
    }

    public boolean isDeviceLoginAvailable() {
        return d.a(this.b.context).b();
    }

    public boolean deviceLogin(SapiCallBack<SapiResponse> sapiCallBack) {
        if (!d.a(this.b.context).b()) {
            return false;
        }
        String a2 = d.a(this.b.context).a();
        if (TextUtils.isEmpty(a2) || "null".equalsIgnoreCase(a2)) {
            return this.c.a(sapiCallBack);
        }
        return this.c.d(sapiCallBack, a2);
    }

    public void oauth(OAuthCallBack oAuthCallBack, String str) {
        this.c.a(oAuthCallBack, str);
    }
}
