package com.baidu.sapi2.shell;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.a.i;
import com.baidu.sapi2.shell.callback.FastRegCallBack;
import com.baidu.sapi2.shell.callback.GetDynamicPwdCallBack;
import com.baidu.sapi2.shell.callback.LoginCallBack;
import com.baidu.sapi2.shell.response.FastRegResponse;
import com.baidu.sapi2.shell.response.LoginResponse;
import com.baidu.sapi2.utils.L;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.f;
import com.baidu.sapi2.utils.g;
import com.baidu.sapi2.utils.h;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a {
    private static final int a = 6;
    private SapiConfiguration b = SapiAccountManager.getInstance().getSapiConfiguration();
    private com.baidu.sapi2.a.a c;
    private g d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        this.d = new g(context);
    }

    public final boolean a(LoginCallBack loginCallBack, String str, String str2) {
        if (this.b.context == null) {
            return false;
        }
        if (!SapiUtils.hasActiveNetwork(this.b.context)) {
            if (loginCallBack != null) {
                loginCallBack.onNetworkFailed();
            }
            return true;
        } else if (this.b != null) {
            com.baidu.sapi2.shell.b bVar = new com.baidu.sapi2.shell.b();
            this.c = new com.baidu.sapi2.a.a();
            this.c.a(this.b.context, l(), new C0012a(loginCallBack, bVar, str, str2));
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.sapi2.shell.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0012a extends i {
        final /* synthetic */ LoginCallBack a;
        final /* synthetic */ com.baidu.sapi2.shell.b b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;

        C0012a(LoginCallBack loginCallBack, com.baidu.sapi2.shell.b bVar, String str, String str2) {
            this.a = loginCallBack;
            this.b = bVar;
            this.c = str;
            this.d = str2;
        }

        @Override // com.baidu.sapi2.a.i
        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
            JSONObject jSONObject = new JSONObject();
            String str2 = "";
            try {
                jSONObject.put("failure_info", str);
                str2 = jSONObject.toString();
            } catch (JSONException e) {
                a.this.a(-100, this.a, "", this.b);
                L.e(e);
            }
            if (a.this.d.c()) {
                a.this.d.d();
                a.this.a(-100, this.a, str2, this.b);
                return;
            }
            a.this.d.b();
            a.this.a(this.a, this.c, this.d);
        }

        @Override // com.baidu.sapi2.a.i
        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                a.this.a(this.a, jSONObject.optString("cert"), jSONObject.optString("cert_id"), this.c, this.d, this.b);
            } catch (Exception e) {
                a.this.a(-100, this.a, str, this.b);
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(LoginCallBack loginCallBack, String str, String str2, String str3, String str4, com.baidu.sapi2.shell.b bVar) {
        this.c = new com.baidu.sapi2.a.a();
        this.c.a(j());
        HashMap hashMap = new HashMap();
        hashMap.put("crypttype", "6");
        hashMap.put("tpl", this.b.tpl);
        hashMap.put("appid", this.b.appId);
        hashMap.put(SocialConstants.PARAM_CUID, this.b.clientId);
        hashMap.put("cert_id", str2);
        hashMap.put("isdpass", SocialConstants.TRUE);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("username", str3);
        jSONObject.put("isphone", SocialConstants.TRUE);
        jSONObject.put("password", str4);
        jSONObject.put("login_type", "3");
        jSONObject.put("key", bVar.a());
        jSONObject.put("sdk_version", "2");
        jSONObject.put("pinfo", f.b());
        hashMap.put("userinfo", bVar.a(str, jSONObject.toString()));
        hashMap.put("sig", a(hashMap, this.b.appSignKey));
        this.c.b(this.b.context, b(), new com.baidu.sapi2.a.b(hashMap), new b(loginCallBack, bVar, str3, str4));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends i {
        final /* synthetic */ LoginCallBack a;
        final /* synthetic */ com.baidu.sapi2.shell.b b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;

        b(LoginCallBack loginCallBack, com.baidu.sapi2.shell.b bVar, String str, String str2) {
            this.a = loginCallBack;
            this.b = bVar;
            this.c = str;
            this.d = str2;
        }

        @Override // com.baidu.sapi2.a.i
        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
            a.this.a(a.this.a(str), this.a, str, this.b);
        }

        @Override // com.baidu.sapi2.a.i
        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
            if (a.this.d.c()) {
                a.this.d.d();
                a.this.a(a.this.a(str), this.a, str, this.b);
                return;
            }
            a.this.d.b();
            a.this.a(this.a, this.c, this.d);
        }
    }

    final void a(int i, LoginCallBack loginCallBack, String str, com.baidu.sapi2.shell.b bVar) {
        if (str != null) {
            LoginResponse loginResponse = new LoginResponse();
            try {
                String optString = new JSONObject(str).optString("userinfo");
                if (!TextUtils.isEmpty(optString)) {
                    JSONObject jSONObject = new JSONObject(bVar.a(optString));
                    loginResponse.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                    loginResponse.username = jSONObject.optString("uname");
                    loginResponse.uid = jSONObject.optString(SapiAccountManager.SESSION_UID);
                    loginResponse.email = jSONObject.optString("email");
                    loginResponse.weakPass = jSONObject.optInt("weakpass");
                    loginResponse.bduss = jSONObject.optString("bduss");
                    loginResponse.ptoken = jSONObject.optString(SapiAccountManager.SESSION_PTOKEN);
                    loginResponse.stoken = jSONObject.optString(SapiAccountManager.SESSION_STOKEN);
                    loginResponse.auth = jSONObject.optString("auth");
                    loginResponse.authSid = jSONObject.optString("authsid");
                }
                if (loginCallBack != null) {
                    switch (i) {
                        case 0:
                            loginCallBack.onSuccess(loginResponse);
                            return;
                        case 3:
                            loginCallBack.onPasswordWrong();
                            return;
                        case 4:
                            loginCallBack.onPasswordWrong();
                            return;
                        case 16:
                        case SapiErrorCode.SMS_LOGIN_TOO_MUCH /* 190016 */:
                            loginCallBack.onCannotLogin();
                            return;
                        default:
                            loginCallBack.onSystemError(i);
                            return;
                    }
                }
            } catch (Exception e) {
                L.e(e);
                if (loginCallBack != null) {
                    loginCallBack.onSystemError(-100);
                }
            }
        } else if (loginCallBack != null) {
            loginCallBack.onSystemError(i);
        }
    }

    public final boolean a(GetDynamicPwdCallBack getDynamicPwdCallBack, String str) {
        if (this.b == null || this.b.context == null) {
            return false;
        }
        if (!SapiUtils.hasActiveNetwork(this.b.context)) {
            if (getDynamicPwdCallBack != null) {
                getDynamicPwdCallBack.onNetworkFailed();
                return false;
            }
            return false;
        } else if (TextUtils.isEmpty(str)) {
            if (getDynamicPwdCallBack != null) {
                getDynamicPwdCallBack.onPhoneFormatError();
                return false;
            }
            return false;
        } else {
            this.c = new com.baidu.sapi2.a.a();
            this.c.a(j());
            HashMap hashMap = new HashMap();
            hashMap.put("username", str);
            hashMap.put("clientid", this.b.clientId);
            if (!TextUtils.isEmpty(this.b.clientIp)) {
                hashMap.put("clientip", this.b.clientIp);
            }
            hashMap.put("tpl", this.b.tpl);
            hashMap.put("appid", this.b.appId);
            hashMap.put("sig", a(hashMap, this.b.appSignKey));
            this.c.b(this.b.context, i(), new com.baidu.sapi2.a.b(hashMap), new c(getDynamicPwdCallBack, str));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends i {
        final /* synthetic */ GetDynamicPwdCallBack a;
        final /* synthetic */ String b;

        c(GetDynamicPwdCallBack getDynamicPwdCallBack, String str) {
            this.a = getDynamicPwdCallBack;
            this.b = str;
        }

        @Override // com.baidu.sapi2.a.i
        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
            a.this.d.d();
            a.this.b(this.a, str);
        }

        @Override // com.baidu.sapi2.a.i
        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
            if (a.this.d.c()) {
                a.this.d.d();
                a.this.b(this.a, str);
                return;
            }
            a.this.d.b();
            a.this.a(this.a, this.b);
        }
    }

    public final boolean a(FastRegCallBack fastRegCallBack, String str) {
        if (this.b == null || this.b.context == null) {
            return false;
        }
        if (!SapiUtils.hasActiveNetwork(this.b.context)) {
            if (fastRegCallBack != null) {
                fastRegCallBack.onNetworkFailed();
                return false;
            }
            return false;
        } else if (TextUtils.isEmpty(str)) {
            if (fastRegCallBack != null) {
                fastRegCallBack.onSystemError(SapiErrorCode.INVALID_ARG);
                return false;
            }
            return false;
        } else {
            this.c = new com.baidu.sapi2.a.a();
            this.c.a(j());
            HashMap hashMap = new HashMap();
            hashMap.put("sms", str);
            hashMap.put("clientid", this.b.clientId);
            if (!TextUtils.isEmpty(this.b.clientIp)) {
                hashMap.put("clientip", this.b.clientIp);
            }
            hashMap.put("tpl", this.b.tpl);
            hashMap.put("appid", this.b.appId);
            hashMap.put("sig", a(hashMap, this.b.appSignKey));
            this.c.b(this.b.context, h(), new com.baidu.sapi2.a.b(hashMap), new d(fastRegCallBack, str));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends i {
        final /* synthetic */ FastRegCallBack a;
        final /* synthetic */ String b;

        d(FastRegCallBack fastRegCallBack, String str) {
            this.a = fastRegCallBack;
            this.b = str;
        }

        @Override // com.baidu.sapi2.a.i
        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
            a.this.d.d();
            a.this.a(i, this.a, str);
        }

        @Override // com.baidu.sapi2.a.i
        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
            if (a.this.d.c()) {
                a.this.d.d();
                a.this.a(a.this.b(str), this.a, str);
                return;
            }
            a.this.d.b();
            a.this.a(this.a, this.b);
        }
    }

    private String a(Map<String, String> map, String str) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : map.keySet()) {
            arrayList.add(str2);
        }
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            sb.append(str3);
            sb.append("=");
            try {
                String str4 = map.get(str3);
                if (!TextUtils.isEmpty(str4)) {
                    sb.append(URLEncoder.encode(str4, "UTF-8"));
                }
            } catch (UnsupportedEncodingException e) {
                L.e(e);
            }
            sb.append("&");
        }
        sb.append("sign_key=").append(str);
        return com.baidu.sapi2.utils.b.b.a(sb.toString());
    }

    private String j() {
        return "tpl:" + this.b.tpl + ";android_sapi_v6.3.0";
    }

    final int a(String str) {
        try {
            return new JSONObject(str).getInt("errno");
        } catch (Exception e) {
            L.e(e);
            return -100;
        }
    }

    final int b(String str) {
        int a2 = a(str);
        if (a2 == 110000) {
            return 0;
        }
        return a2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    final void a(int i, FastRegCallBack fastRegCallBack, String str) {
        if (str != null) {
            FastRegResponse fastRegResponse = new FastRegResponse();
            try {
                JSONObject jSONObject = new JSONObject(str);
                fastRegResponse.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                fastRegResponse.username = jSONObject.optString("uname");
                fastRegResponse.uid = jSONObject.optString(SapiAccountManager.SESSION_UID);
                fastRegResponse.bduss = jSONObject.optString("bduss");
                fastRegResponse.ptoken = jSONObject.optString(SapiAccountManager.SESSION_PTOKEN);
                fastRegResponse.stoken = jSONObject.optString(SapiAccountManager.SESSION_STOKEN);
                fastRegResponse.newReg = jSONObject.optBoolean("newreg");
                if (fastRegResponse.newReg) {
                    fastRegResponse.authSid = jSONObject.optString("authsid");
                }
                if (fastRegCallBack != null) {
                    switch (jSONObject.optInt("errno")) {
                        case 0:
                            fastRegCallBack.onSuccess(fastRegResponse);
                            return;
                        case 2:
                            fastRegCallBack.onWaitingLogin();
                            return;
                        case 16:
                        case SapiErrorCode.SMS_LOGIN_TOO_MUCH /* 190016 */:
                            fastRegCallBack.onCannotLogin();
                            break;
                    }
                    fastRegCallBack.onSystemError(i);
                }
            } catch (Exception e) {
                if (fastRegCallBack != null) {
                    fastRegCallBack.onSystemError(-100);
                }
            }
        } else if (fastRegCallBack != null) {
            fastRegCallBack.onSystemError(i);
        }
    }

    final void b(GetDynamicPwdCallBack getDynamicPwdCallBack, String str) {
        try {
            int parseInt = Integer.parseInt(new JSONObject(str).optString("errno"));
            switch (parseInt) {
                case 0:
                    getDynamicPwdCallBack.onSuccess(null);
                    break;
                case 1:
                case 257:
                    getDynamicPwdCallBack.onPhoneFormatError();
                    break;
                case 16:
                    getDynamicPwdCallBack.onCannotLogin();
                    break;
                default:
                    getDynamicPwdCallBack.onSystemError(parseInt);
                    break;
            }
        } catch (Exception e) {
            getDynamicPwdCallBack.onSystemError(-100);
        }
    }

    private Domain k() {
        return this.b.environment;
    }

    private String l() {
        return this.d.a() + "/sslcrypt/get_last_cert";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String a() {
        return k().getWap() + "/passport/login";
    }

    final String b() {
        return this.d.a() + h.a;
    }

    public final String c() {
        return this.d.a() + "/phoenix/account/ssologin";
    }

    public final String d() {
        return this.d.a() + "/phoenix/account/ssologin";
    }

    public final String e() {
        return this.d.a() + h.h;
    }

    public final String f() {
        return this.d.a() + h.i;
    }

    public final String g() {
        return this.d.a() + h.j;
    }

    public final String h() {
        return this.d.a() + h.k;
    }

    public final String i() {
        return this.d.a() + h.m;
    }
}
