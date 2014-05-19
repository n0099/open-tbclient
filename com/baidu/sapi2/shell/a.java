package com.baidu.sapi2.shell;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.security.MD5Util;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.HttpResponseHandler;
import com.baidu.cloudsdk.common.http.MultipartRequestParams;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.mobstat.BasicStoreTools;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.shell.callback.FillUsernameCallBack;
import com.baidu.sapi2.shell.callback.QrAppLoginCallBack;
import com.baidu.sapi2.shell.callback.QrPCLoginCallBack;
import com.baidu.sapi2.shell.callback.SapiCallBack;
import com.baidu.sapi2.shell.response.GetPortraitResponse;
import com.baidu.sapi2.shell.response.QrAppLoginResponse;
import com.baidu.sapi2.shell.response.QrPCLoginResponse;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SapiResponse;
import com.baidu.sapi2.utils.L;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.d;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.tbadk.TbConfig;
import java.io.ByteArrayInputStream;
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
    private AsyncHttpClient c;
    private com.baidu.sapi2.utils.e d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        this.d = new com.baidu.sapi2.utils.e(context);
    }

    public void a() {
        if (this.c != null) {
            this.c.cancelRequests(this.b.context, true);
        }
    }

    public void a(SapiCallBack<SapiResponse> sapiCallBack, SapiAccount.ReloginCredentials reloginCredentials) {
        if (reloginCredentials == null) {
            throw new IllegalArgumentException("ReloginCredentials can't be null");
        }
        if (TextUtils.isEmpty(reloginCredentials.account)) {
            if (sapiCallBack != null) {
                sapiCallBack.onSystemError(SapiErrorCode.USERNAME_EMPTY);
            }
        } else if (TextUtils.isEmpty(reloginCredentials.password)) {
            if (sapiCallBack != null) {
                sapiCallBack.onSystemError(SapiErrorCode.PWD_EMPTY);
            }
        } else if (TextUtils.isEmpty(reloginCredentials.ubi)) {
            if (sapiCallBack != null) {
                sapiCallBack.onSystemError(SapiErrorCode.NEED_REQUIRED_ITEMS);
            }
        } else if (this.b == null || this.b.context == null) {
            if (sapiCallBack != null) {
                sapiCallBack.onSystemError(-100);
            }
        } else if (!SapiUtils.hasActiveNetwork(this.b.context)) {
            if (sapiCallBack != null) {
                sapiCallBack.onNetworkFailed();
            }
        } else {
            com.baidu.sapi2.shell.b bVar = new com.baidu.sapi2.shell.b();
            try {
                this.c = new AsyncHttpClient();
                this.c.setUserAgent(x());
                HashMap hashMap = new HashMap();
                hashMap.put("crypttype", "11");
                hashMap.put("tpl", this.b.tpl);
                hashMap.put("appid", this.b.appId);
                hashMap.put("cuid", this.b.clientId);
                hashMap.put("cert_id", TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT);
                hashMap.put("isdpass", "0");
                hashMap.put("username", reloginCredentials.account);
                hashMap.put("password", reloginCredentials.password);
                hashMap.put("UBI", reloginCredentials.ubi);
                hashMap.put("isphone", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE.equals(reloginCredentials.accountType) ? TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK : "0");
                hashMap.put("login_type", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                hashMap.put("key", bVar.a());
                hashMap.put("sdk_version", TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT);
                hashMap.put("pinfo", com.baidu.sapi2.utils.d.b());
                hashMap.put("sig", a(hashMap, this.b.appSignKey));
                this.c.post(this.b.context, j(), new RequestParams(hashMap), new l(sapiCallBack, reloginCredentials));
            } catch (Exception e2) {
                d(-100, sapiCallBack, null);
                L.e(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class l extends HttpResponseHandler {
        final /* synthetic */ SapiCallBack a;
        final /* synthetic */ SapiAccount.ReloginCredentials b;

        l(SapiCallBack sapiCallBack, SapiAccount.ReloginCredentials reloginCredentials) {
            this.a = sapiCallBack;
            this.b = reloginCredentials;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
            a.this.d(a.this.a(str), this.a, str);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
            if (a.this.d.c()) {
                a.this.d.d();
                a.this.d(a.this.a(str), this.a, str);
                return;
            }
            a.this.d.b();
            a.this.a(this.a, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i2, SapiCallBack<SapiResponse> sapiCallBack, String str) {
        if (str != null) {
            SapiAccountResponse sapiAccountResponse = new SapiAccountResponse();
            sapiAccountResponse.errorCode = i2;
            try {
                JSONObject jSONObject = new JSONObject(str);
                sapiAccountResponse.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                sapiAccountResponse.username = jSONObject.optString("uname");
                sapiAccountResponse.uid = jSONObject.optString(SapiAccountManager.SESSION_UID);
                sapiAccountResponse.email = jSONObject.optString("email");
                sapiAccountResponse.bduss = jSONObject.optString(SapiAccountManager.SESSION_BDUSS);
                sapiAccountResponse.ptoken = jSONObject.optString(SapiAccountManager.SESSION_PTOKEN);
                sapiAccountResponse.stoken = jSONObject.optString(SapiAccountManager.SESSION_STOKEN);
                sapiAccountResponse.authSid = jSONObject.optString("authsid");
                if (sapiCallBack != null) {
                    switch (i2) {
                        case 0:
                            SapiAccount sapiAccount = new SapiAccount();
                            sapiAccount.displayname = sapiAccountResponse.displayname;
                            sapiAccount.bduss = sapiAccountResponse.bduss;
                            sapiAccount.ptoken = sapiAccountResponse.ptoken;
                            sapiAccount.stoken = sapiAccountResponse.stoken;
                            sapiAccount.uid = sapiAccountResponse.uid;
                            sapiAccount.username = sapiAccountResponse.username;
                            sapiAccount.app = com.baidu.sapi2.utils.c.a(this.b.context);
                            sapiAccount.extra = str;
                            if (SapiUtils.isValidAccount(sapiAccount)) {
                                com.baidu.sapi2.d.a(this.b.context).a(sapiAccount);
                                com.baidu.sapi2.d.a(this.b.context).c(sapiAccount);
                            }
                            sapiCallBack.onSuccess(sapiAccountResponse);
                            return;
                        default:
                            sapiCallBack.onSystemError(i2);
                            return;
                    }
                }
            } catch (Exception e2) {
                L.e(e2);
                if (sapiCallBack != null) {
                    sapiCallBack.onSystemError(-100);
                }
            }
        } else if (sapiCallBack != null) {
            sapiCallBack.onSystemError(i2);
        }
    }

    public boolean a(SapiCallBack<SapiAccountResponse> sapiCallBack, String str, String str2, boolean z) {
        if (this.b == null || this.b.context == null) {
            return false;
        }
        if (!SapiUtils.hasActiveNetwork(this.b.context)) {
            if (sapiCallBack != null) {
                sapiCallBack.onNetworkFailed();
            }
            return true;
        }
        com.baidu.sapi2.shell.b bVar = new com.baidu.sapi2.shell.b();
        this.c = new AsyncHttpClient();
        this.c.get(this.b.context, z(), new m(sapiCallBack, z, bVar, str, str2));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class m extends HttpResponseHandler {
        final /* synthetic */ SapiCallBack a;
        final /* synthetic */ boolean b;
        final /* synthetic */ com.baidu.sapi2.shell.b c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        m(SapiCallBack sapiCallBack, boolean z, com.baidu.sapi2.shell.b bVar, String str, String str2) {
            this.a = sapiCallBack;
            this.b = z;
            this.c = bVar;
            this.d = str;
            this.e = str2;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
            JSONObject jSONObject = new JSONObject();
            String str2 = "";
            try {
                jSONObject.put("failure_info", str);
                str2 = jSONObject.toString();
            } catch (JSONException e) {
                a.this.a(-100, this.a, "", this.b, this.c);
                L.e(e);
            }
            if (a.this.d.c()) {
                a.this.d.d();
                a.this.a(-100, this.a, str2, this.b, this.c);
                return;
            }
            a.this.d.b();
            a.this.a(this.a, this.d, this.e, this.b);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                a.this.a(this.a, jSONObject.optString("cert"), jSONObject.optString("cert_id"), this.d, this.e, this.b, this.c);
            } catch (Exception e) {
                a.this.a(-100, this.a, str, this.b, this.c);
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(SapiCallBack<SapiAccountResponse> sapiCallBack, String str, String str2, String str3, String str4, boolean z, com.baidu.sapi2.shell.b bVar) {
        this.c = new AsyncHttpClient();
        this.c.setUserAgent(x());
        HashMap hashMap = new HashMap();
        hashMap.put("crypttype", "6");
        hashMap.put("tpl", this.b.tpl);
        hashMap.put("appid", this.b.appId);
        hashMap.put("cuid", this.b.clientId);
        hashMap.put("cert_id", str2);
        hashMap.put("isdpass", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("username", str3);
        jSONObject.put("isphone", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
        jSONObject.put("password", str4);
        jSONObject.put("login_type", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
        jSONObject.put("key", bVar.a());
        jSONObject.put("sdk_version", TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT);
        jSONObject.put("pinfo", com.baidu.sapi2.utils.d.b());
        hashMap.put("userinfo", bVar.a(str, jSONObject.toString()));
        hashMap.put("sig", a(hashMap, this.b.appSignKey));
        this.c.post(this.b.context, j(), new RequestParams(hashMap), new n(sapiCallBack, z, bVar, str3, str4));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class n extends HttpResponseHandler {
        final /* synthetic */ SapiCallBack a;
        final /* synthetic */ boolean b;
        final /* synthetic */ com.baidu.sapi2.shell.b c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        n(SapiCallBack sapiCallBack, boolean z, com.baidu.sapi2.shell.b bVar, String str, String str2) {
            this.a = sapiCallBack;
            this.b = z;
            this.c = bVar;
            this.d = str;
            this.e = str2;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
            a.this.a(a.this.a(str), this.a, str, this.b, this.c);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
            if (a.this.d.c()) {
                a.this.d.d();
                a.this.a(a.this.a(str), this.a, str, this.b, this.c);
                return;
            }
            a.this.d.b();
            a.this.a(this.a, this.d, this.e, this.b);
        }
    }

    void a(int i2, SapiCallBack<SapiAccountResponse> sapiCallBack, String str, boolean z, com.baidu.sapi2.shell.b bVar) {
        if (str != null) {
            SapiAccountResponse sapiAccountResponse = new SapiAccountResponse();
            try {
                String optString = new JSONObject(str).optString("userinfo");
                String str2 = "";
                if (!TextUtils.isEmpty(optString)) {
                    str2 = bVar.b(optString);
                    JSONObject jSONObject = new JSONObject(str2);
                    sapiAccountResponse.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                    sapiAccountResponse.username = jSONObject.optString("uname");
                    sapiAccountResponse.uid = jSONObject.optString(SapiAccountManager.SESSION_UID);
                    sapiAccountResponse.email = jSONObject.optString("email");
                    sapiAccountResponse.bduss = jSONObject.optString(SapiAccountManager.SESSION_BDUSS);
                    sapiAccountResponse.ptoken = jSONObject.optString(SapiAccountManager.SESSION_PTOKEN);
                    sapiAccountResponse.stoken = jSONObject.optString(SapiAccountManager.SESSION_STOKEN);
                    sapiAccountResponse.authSid = jSONObject.optString("authsid");
                }
                if (sapiCallBack != null) {
                    switch (i2) {
                        case 0:
                            if (z) {
                                SapiAccount sapiAccount = new SapiAccount();
                                sapiAccount.displayname = sapiAccountResponse.displayname;
                                sapiAccount.bduss = sapiAccountResponse.bduss;
                                sapiAccount.ptoken = sapiAccountResponse.ptoken;
                                sapiAccount.stoken = sapiAccountResponse.stoken;
                                sapiAccount.uid = sapiAccountResponse.uid;
                                sapiAccount.username = sapiAccountResponse.username;
                                sapiAccount.app = com.baidu.sapi2.utils.c.a(this.b.context);
                                sapiAccount.extra = str2;
                                if (SapiUtils.isValidAccount(sapiAccount)) {
                                    com.baidu.sapi2.share.b.a().a(sapiAccount);
                                }
                            }
                            sapiCallBack.onSuccess(sapiAccountResponse);
                            return;
                        default:
                            sapiCallBack.onSystemError(i2);
                            return;
                    }
                }
            } catch (Exception e2) {
                L.e(e2);
                if (sapiCallBack != null) {
                    sapiCallBack.onSystemError(-100);
                }
            }
        } else if (sapiCallBack != null) {
            sapiCallBack.onSystemError(i2);
        }
    }

    public void a(SapiCallBack<SapiResponse> sapiCallBack, String str, String str2, String str3, byte[] bArr, String str4) {
        if (sapiCallBack == null) {
            throw new IllegalArgumentException(SapiCallBack.class.getSimpleName() + "can't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("file can't be empty");
        }
        if (!SapiUtils.hasActiveNetwork(this.b.context)) {
            sapiCallBack.onNetworkFailed();
            return;
        }
        this.c = new AsyncHttpClient();
        HashMap hashMap = new HashMap();
        hashMap.put("appid", this.b.appId);
        hashMap.put("tpl", this.b.tpl);
        if (!TextUtils.isEmpty(this.b.clientId)) {
            hashMap.put("clientid", this.b.clientId);
        }
        if (!TextUtils.isEmpty(this.b.clientIp)) {
            hashMap.put("clientip", this.b.clientIp);
        }
        hashMap.put(SapiAccountManager.SESSION_BDUSS, str);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put(SapiAccountManager.SESSION_PTOKEN, str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put(SapiAccountManager.SESSION_STOKEN, str3);
        }
        String a2 = a(hashMap, this.b.appSignKey);
        MultipartRequestParams multipartRequestParams = new MultipartRequestParams();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            multipartRequestParams.put(entry.getKey(), entry.getValue());
        }
        multipartRequestParams.put("sig", a2);
        multipartRequestParams.put("file", new ByteArrayInputStream(bArr), "portrait.jpg", TextUtils.isEmpty(str4) ? "image/jpeg" : str4);
        this.c.post(this.b.context, h(), multipartRequestParams, new o(sapiCallBack, str, str2, str3, bArr, str4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class o extends HttpResponseHandler {
        final /* synthetic */ SapiCallBack a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ byte[] e;
        final /* synthetic */ String f;

        o(SapiCallBack sapiCallBack, String str, String str2, String str3, byte[] bArr, String str4) {
            this.a = sapiCallBack;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = bArr;
            this.f = str4;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (a.this.d.c()) {
                a.this.d.d();
                this.a.onSystemError(-100);
                return;
            }
            a.this.d.b();
            a.this.a(this.a, this.b, this.c, this.d, this.e, this.f);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            a.this.d.d();
            int a = a.this.a(str);
            if (a == 0) {
                SapiResponse sapiResponse = new SapiResponse();
                sapiResponse.errorCode = a;
                sapiResponse.errorMsg = "设置头像成功";
                this.a.onSuccess(sapiResponse);
                return;
            }
            this.a.onSystemError(a);
        }
    }

    public void a(SapiCallBack<GetPortraitResponse> sapiCallBack, String str, String str2, String str3) {
        if (sapiCallBack == null) {
            throw new IllegalArgumentException(SapiCallBack.class.getSimpleName() + "can't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        if (!SapiUtils.hasActiveNetwork(this.b.context)) {
            sapiCallBack.onNetworkFailed();
            return;
        }
        this.c = new AsyncHttpClient();
        HashMap hashMap = new HashMap();
        hashMap.put("appid", this.b.appId);
        hashMap.put("tpl", this.b.tpl);
        if (!TextUtils.isEmpty(this.b.clientId)) {
            hashMap.put("clientid", this.b.clientId);
        }
        if (!TextUtils.isEmpty(this.b.clientIp)) {
            hashMap.put("clientip", this.b.clientIp);
        }
        hashMap.put(SapiAccountManager.SESSION_BDUSS, str);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put(SapiAccountManager.SESSION_PTOKEN, str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put(SapiAccountManager.SESSION_STOKEN, str3);
        }
        String a2 = a(hashMap, this.b.appSignKey);
        RequestParams requestParams = new RequestParams();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            requestParams.put(entry.getKey(), entry.getValue());
        }
        requestParams.put("sig", a2);
        this.c.post(this.b.context, i(), requestParams, new h(sapiCallBack, str, str2, str3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends HttpResponseHandler {
        final /* synthetic */ SapiCallBack a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;

        h(SapiCallBack sapiCallBack, String str, String str2, String str3) {
            this.a = sapiCallBack;
            this.b = str;
            this.c = str2;
            this.d = str3;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (a.this.d.c()) {
                a.this.d.d();
                this.a.onSystemError(-100);
                return;
            }
            a.this.d.b();
            a.this.a(this.a, this.b, this.c, this.d);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            a.this.d.d();
            int a = a.this.a(str);
            if (a == 0) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    GetPortraitResponse getPortraitResponse = new GetPortraitResponse();
                    getPortraitResponse.errorCode = a;
                    getPortraitResponse.errorMsg = jSONObject.optString("errmsg");
                    String optString = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
                    if (!TextUtils.isEmpty(optString)) {
                        getPortraitResponse.portrait = String.format("http://himg.bdimg.com/sys/portrait/item/%s.jpg", optString);
                    }
                    this.a.onSuccess(getPortraitResponse);
                    return;
                } catch (JSONException e) {
                    this.a.onSystemError(a);
                    L.e(e);
                    return;
                }
            }
            this.a.onSystemError(a);
        }
    }

    public boolean a(FillUsernameCallBack fillUsernameCallBack, String str, String str2, String str3) {
        if (!SapiUtils.hasActiveNetwork(this.b.context)) {
            if (fillUsernameCallBack != null) {
                fillUsernameCallBack.onNetworkFailed();
            }
            return false;
        }
        com.baidu.sapi2.shell.b bVar = new com.baidu.sapi2.shell.b();
        this.c = new AsyncHttpClient();
        this.c.get(this.b.context, z(), new i(fillUsernameCallBack, bVar, str, str2, str3));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i extends HttpResponseHandler {
        final /* synthetic */ FillUsernameCallBack a;
        final /* synthetic */ com.baidu.sapi2.shell.b b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        i(FillUsernameCallBack fillUsernameCallBack, com.baidu.sapi2.shell.b bVar, String str, String str2, String str3) {
            this.a = fillUsernameCallBack;
            this.b = bVar;
            this.c = str;
            this.d = str2;
            this.e = str3;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
            JSONObject jSONObject = new JSONObject();
            String str2 = "";
            try {
                jSONObject.put("failure_info", str);
                str2 = jSONObject.toString();
            } catch (JSONException e) {
                L.e(e);
            }
            if (a.this.d.c()) {
                a.this.d.d();
                a.this.a(-100, this.a, str2, this.b);
                return;
            }
            a.this.a(this.a, this.c, this.d, this.e);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
            a.this.d.d();
            try {
                JSONObject jSONObject = new JSONObject(str);
                a.this.a(this.a, this.c, this.d, this.e, jSONObject.optString("cert"), jSONObject.optString("cert_id"), this.b);
            } catch (Exception e) {
                a.this.a(a.this.b(str), this.a, str, this.b);
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(FillUsernameCallBack fillUsernameCallBack, String str, String str2, String str3, String str4, String str5, com.baidu.sapi2.shell.b bVar) {
        this.c = new AsyncHttpClient();
        HashMap hashMap = new HashMap();
        hashMap.put("appid", this.b.appId);
        hashMap.put("tpl", this.b.tpl);
        hashMap.put("cert_id", str5);
        hashMap.put("crypttype", String.valueOf(6));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(SapiAccountManager.SESSION_BDUSS, str);
        if (!TextUtils.isEmpty(this.b.clientId)) {
            jSONObject.put("clientid", this.b.clientId);
        }
        if (!TextUtils.isEmpty(this.b.clientIp)) {
            jSONObject.put("clientip", this.b.clientIp);
        }
        jSONObject.put(SapiAccountManager.SESSION_PTOKEN, str2);
        jSONObject.put("username", str3);
        jSONObject.put("key", bVar.a());
        hashMap.put("userinfo", bVar.a(str4, jSONObject.toString()));
        hashMap.put("sig", a(hashMap, this.b.appSignKey));
        this.c.post(this.b.context, g(), new RequestParams(hashMap), new j(fillUsernameCallBack, bVar));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class j extends HttpResponseHandler {
        final /* synthetic */ FillUsernameCallBack a;
        final /* synthetic */ com.baidu.sapi2.shell.b b;

        j(FillUsernameCallBack fillUsernameCallBack, com.baidu.sapi2.shell.b bVar) {
            this.a = fillUsernameCallBack;
            this.b = bVar;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
            a.this.a(a.this.b(str), this.a, str, this.b);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
            a.this.a(a.this.b(str), this.a, str, this.b);
        }
    }

    public boolean a(QrPCLoginCallBack qrPCLoginCallBack, String str, String str2, String str3, String str4, String str5) {
        if (this.b == null || this.b.context == null) {
            if (qrPCLoginCallBack != null) {
                qrPCLoginCallBack.onFinish();
            }
            return false;
        } else if (!SapiUtils.hasActiveNetwork(this.b.context)) {
            if (qrPCLoginCallBack != null) {
                qrPCLoginCallBack.onFinish();
                qrPCLoginCallBack.onNetworkFailed();
            }
            return false;
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (qrPCLoginCallBack != null) {
                qrPCLoginCallBack.onFinish();
                qrPCLoginCallBack.onQrCodeInvalid();
            }
            return false;
        } else if (TextUtils.isEmpty(str3)) {
            if (qrPCLoginCallBack != null) {
                qrPCLoginCallBack.onFinish();
                qrPCLoginCallBack.onBdussInvalid();
            }
            return false;
        } else {
            this.c = new AsyncHttpClient();
            this.c.setUserAgent(x());
            HashMap hashMap = new HashMap();
            hashMap.put("sign", str);
            hashMap.put(com.baidu.tbadk.core.frameworkData.a.CMD, str2);
            hashMap.put(SapiAccountManager.SESSION_BDUSS, str3);
            if (!TextUtils.isEmpty(str5)) {
                hashMap.put(SapiAccountManager.SESSION_PTOKEN, str5);
            }
            if (!TextUtils.isEmpty(str4)) {
                hashMap.put(SapiAccountManager.SESSION_STOKEN, str4);
            }
            hashMap.put("clientid", this.b.clientId);
            if (!TextUtils.isEmpty(this.b.clientIp)) {
                hashMap.put("clientip", this.b.clientIp);
            }
            hashMap.put("tpl", this.b.tpl);
            hashMap.put("appid", this.b.appId);
            hashMap.put("sig", a(hashMap, this.b.appSignKey));
            this.c.post(this.b.context, t(), new RequestParams(hashMap), new k(qrPCLoginCallBack, str, str2, str3, str4, str5));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class k extends HttpResponseHandler {
        final /* synthetic */ QrPCLoginCallBack a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;
        final /* synthetic */ String f;

        k(QrPCLoginCallBack qrPCLoginCallBack, String str, String str2, String str3, String str4, String str5) {
            this.a = qrPCLoginCallBack;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = str5;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
            a.this.d.d();
            a.this.a(this.a, str);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
            if (a.this.d.c()) {
                a.this.d.d();
                a.this.a(this.a, str);
                return;
            }
            a.this.d.b();
            a.this.a(this.a, this.b, this.c, this.d, this.e, this.f);
        }
    }

    public boolean a(QrAppLoginCallBack qrAppLoginCallBack, String str, String str2) {
        if (this.b == null || this.b.context == null) {
            if (qrAppLoginCallBack != null) {
                qrAppLoginCallBack.onFinish();
                return false;
            }
            return false;
        } else if (!SapiUtils.hasActiveNetwork(this.b.context)) {
            if (qrAppLoginCallBack != null) {
                qrAppLoginCallBack.onFinish();
                qrAppLoginCallBack.onNetworkFailed();
                return false;
            }
            return false;
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (qrAppLoginCallBack != null) {
                qrAppLoginCallBack.onFinish();
                qrAppLoginCallBack.onQrCodeInvalid();
                return false;
            }
            return false;
        } else {
            this.c = new AsyncHttpClient();
            this.c.setUserAgent(x());
            HashMap hashMap = new HashMap();
            hashMap.put("sign", str);
            hashMap.put(com.baidu.tbadk.core.frameworkData.a.CMD, str2);
            hashMap.put("clientid", this.b.clientId);
            if (!TextUtils.isEmpty(this.b.clientIp)) {
                hashMap.put("clientip", this.b.clientIp);
            }
            hashMap.put("tpl", this.b.tpl);
            hashMap.put("appid", this.b.appId);
            hashMap.put("sig", a(hashMap, this.b.appSignKey));
            this.c.post(this.b.context, u(), new RequestParams(hashMap), new g(qrAppLoginCallBack, str, str2));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends HttpResponseHandler {
        final /* synthetic */ QrAppLoginCallBack a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        g(QrAppLoginCallBack qrAppLoginCallBack, String str, String str2) {
            this.a = qrAppLoginCallBack;
            this.b = str;
            this.c = str2;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
            a.this.d.d();
            a.this.a(i, this.a, str);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
            if (a.this.d.c()) {
                a.this.d.d();
                a.this.a(a.this.b(str), this.a, str);
                return;
            }
            a.this.d.b();
            a.this.a(this.a, this.b, this.c);
        }
    }

    public boolean a(SapiCallBack<SapiResponse> sapiCallBack, String str) {
        if (this.b == null || this.b.context == null) {
            return false;
        }
        if (!SapiUtils.hasActiveNetwork(this.b.context)) {
            if (sapiCallBack != null) {
                sapiCallBack.onNetworkFailed();
                return false;
            }
            return false;
        } else if (TextUtils.isEmpty(str)) {
            if (sapiCallBack != null) {
                sapiCallBack.onSystemError(257);
                return false;
            }
            return false;
        } else {
            this.c = new AsyncHttpClient();
            this.c.setUserAgent(x());
            HashMap hashMap = new HashMap();
            hashMap.put("username", str);
            hashMap.put("clientid", this.b.clientId);
            if (!TextUtils.isEmpty(this.b.clientIp)) {
                hashMap.put("clientip", this.b.clientIp);
            }
            hashMap.put("tpl", this.b.tpl);
            hashMap.put("appid", this.b.appId);
            hashMap.put("sig", a(hashMap, this.b.appSignKey));
            this.c.post(this.b.context, w(), new RequestParams(hashMap), new d(sapiCallBack, str));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends HttpResponseHandler {
        final /* synthetic */ SapiCallBack a;
        final /* synthetic */ String b;

        d(SapiCallBack sapiCallBack, String str) {
            this.a = sapiCallBack;
            this.b = str;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
            a.this.d.d();
            a.this.e(this.a, str);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
            if (a.this.d.c()) {
                a.this.d.d();
                a.this.e(this.a, str);
                return;
            }
            a.this.d.b();
            a.this.a(this.a, this.b);
        }
    }

    public boolean b(SapiCallBack<SapiAccountResponse> sapiCallBack, String str) {
        if (this.b == null || this.b.context == null) {
            return false;
        }
        if (!SapiUtils.hasActiveNetwork(this.b.context)) {
            if (sapiCallBack != null) {
                sapiCallBack.onNetworkFailed();
                return false;
            }
            return false;
        } else if (TextUtils.isEmpty(str)) {
            if (sapiCallBack != null) {
                sapiCallBack.onSystemError(SapiErrorCode.INVALID_ARG);
                return false;
            }
            return false;
        } else {
            this.c = new AsyncHttpClient();
            this.c.setUserAgent(x());
            HashMap hashMap = new HashMap();
            hashMap.put("sms", str);
            hashMap.put("clientid", this.b.clientId);
            if (!TextUtils.isEmpty(this.b.clientIp)) {
                hashMap.put("clientip", this.b.clientIp);
            }
            hashMap.put("tpl", this.b.tpl);
            hashMap.put("appid", this.b.appId);
            hashMap.put("sig", a(hashMap, this.b.appSignKey));
            this.c.post(this.b.context, v(), new RequestParams(hashMap), new c(sapiCallBack, str));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends HttpResponseHandler {
        final /* synthetic */ SapiCallBack a;
        final /* synthetic */ String b;

        c(SapiCallBack sapiCallBack, String str) {
            this.a = sapiCallBack;
            this.b = str;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
            a.this.d.d();
            a.this.c(i, this.a, str);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
            if (a.this.d.c()) {
                a.this.d.d();
                a.this.c(a.this.b(str), this.a, str);
                return;
            }
            a.this.d.b();
            a.this.b(this.a, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.b != null && this.b.context != null && SapiUtils.hasActiveNetwork(this.b.context)) {
            this.c = new AsyncHttpClient();
            this.c.setUserAgent(x());
            HashMap hashMap = new HashMap();
            if (com.baidu.sapi2.d.a(this.b.context).a() != null) {
                hashMap.put(BasicStoreTools.DEVICE_ID, com.baidu.sapi2.utils.d.d(this.b.context));
                hashMap.put("device_token", com.baidu.sapi2.d.a(this.b.context).a());
            }
            this.c.get(this.b.context, p(), new RequestParams(hashMap), new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends HttpResponseHandler {
        b() {
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
            if (str != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("error_code") || jSONObject.has("error_msg") || jSONObject.optInt("fulfilbind") != 0) {
                        return;
                    }
                    if (jSONObject.optInt(TbConfig.ST_TYPE_REG) == 1 || jSONObject.optInt(TbConfig.ST_TYPE_LOGIN) == 1) {
                        com.baidu.sapi2.d.a(a.this.b.context).a(true);
                    }
                } catch (JSONException e) {
                    L.e(e);
                    com.baidu.sapi2.d.a(a.this.b.context).a(false);
                }
            }
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
            com.baidu.sapi2.d.a(a.this.b.context).a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(SapiCallBack<SapiResponse> sapiCallBack) {
        if (this.b == null || this.b.context == null || TextUtils.isEmpty(this.b.deviceLoginSignKey) || !com.baidu.sapi2.d.a(this.b.context).b()) {
            return false;
        }
        if (!SapiUtils.hasActiveNetwork(this.b.context)) {
            if (sapiCallBack != null) {
                sapiCallBack.onNetworkFailed();
                return false;
            }
            return false;
        }
        this.c = new AsyncHttpClient();
        this.c.setUserAgent(x());
        HashMap hashMap = new HashMap();
        String a2 = d.a.a(com.baidu.sapi2.utils.d.d(this.b.context));
        hashMap.put("ptpl", this.b.tpl);
        hashMap.put(BasicStoreTools.DEVICE_ID, a2);
        hashMap.put("device_info", com.baidu.sapi2.utils.d.d());
        hashMap.put("package_sign", this.b.deviceLoginSignKey);
        this.c.post(this.b.context, r(), new RequestParams(hashMap), new HandlerC0009a(sapiCallBack));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.sapi2.shell.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class HandlerC0009a extends HttpResponseHandler {
        final /* synthetic */ SapiCallBack a;

        HandlerC0009a(SapiCallBack sapiCallBack) {
            this.a = sapiCallBack;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
            a.this.a(i, this.a, str);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
            a.this.a(a.this.b(str), this.a, str);
        }
    }

    void c(SapiCallBack<SapiResponse> sapiCallBack, String str) {
        if (this.b != null && this.b.context != null && !TextUtils.isEmpty(this.b.deviceLoginSignKey)) {
            if (!SapiUtils.hasActiveNetwork(this.b.context)) {
                if (sapiCallBack != null) {
                    sapiCallBack.onNetworkFailed();
                    return;
                }
                return;
            }
            this.c = new AsyncHttpClient();
            this.c.setUserAgent(x());
            HashMap hashMap = new HashMap();
            String a2 = d.a.a(com.baidu.sapi2.utils.d.d(this.b.context));
            hashMap.put("ptpl", this.b.tpl);
            hashMap.put(BasicStoreTools.DEVICE_ID, a2);
            hashMap.put("device_info", com.baidu.sapi2.utils.d.d());
            hashMap.put("force_reg_token", str);
            this.c.post(this.b.context, s(), new RequestParams(hashMap), new f(sapiCallBack));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends HttpResponseHandler {
        final /* synthetic */ SapiCallBack a;

        f(SapiCallBack sapiCallBack) {
            this.a = sapiCallBack;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            a.this.b(i, this.a, str);
            super.onSuccess(i, str);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            a.this.b(a.this.b(str), this.a, str);
            super.onFailure(th, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(SapiCallBack<SapiResponse> sapiCallBack, String str) {
        if (this.b == null || this.b.context == null || TextUtils.isEmpty(this.b.deviceLoginSignKey)) {
            return false;
        }
        if (!SapiUtils.hasActiveNetwork(this.b.context)) {
            if (sapiCallBack != null) {
                sapiCallBack.onNetworkFailed();
                return false;
            }
            return false;
        }
        this.c = new AsyncHttpClient();
        this.c.setUserAgent(x());
        HashMap hashMap = new HashMap();
        String a2 = d.a.a(com.baidu.sapi2.utils.d.d(this.b.context));
        hashMap.put("ptpl", this.b.tpl);
        hashMap.put(BasicStoreTools.DEVICE_ID, a2);
        hashMap.put("device_token", str);
        hashMap.put("package_sign", this.b.deviceLoginSignKey);
        this.c.post(this.b.context, q(), new RequestParams(hashMap), new e(sapiCallBack));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends HttpResponseHandler {
        final /* synthetic */ SapiCallBack a;

        e(SapiCallBack sapiCallBack) {
            this.a = sapiCallBack;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            a.this.a(i, this.a, str);
            super.onSuccess(i, str);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            a.this.a(a.this.b(str), this.a, str);
            super.onFailure(th, str);
        }
    }

    void a(int i2, SapiCallBack<SapiResponse> sapiCallBack, String str) {
        if (str != null) {
            SapiAccountResponse sapiAccountResponse = new SapiAccountResponse();
            try {
                JSONObject jSONObject = new JSONObject(str);
                sapiAccountResponse.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                sapiAccountResponse.uid = jSONObject.optString(SapiAccountManager.SESSION_UID);
                sapiAccountResponse.bduss = jSONObject.optString(SapiAccountManager.SESSION_BDUSS);
                sapiAccountResponse.ptoken = jSONObject.optString(SapiAccountManager.SESSION_PTOKEN);
                if (jSONObject.optInt("error_code") == 104) {
                    c(sapiCallBack, jSONObject.optString("force_reg_token"));
                    return;
                }
                if (!jSONObject.has("error_code") && !jSONObject.has("error_msg")) {
                    SapiAccount sapiAccount = new SapiAccount();
                    sapiAccount.uid = sapiAccountResponse.uid;
                    sapiAccount.bduss = sapiAccountResponse.bduss;
                    sapiAccount.displayname = sapiAccountResponse.displayname;
                    sapiAccount.stoken = sapiAccountResponse.stoken;
                    sapiAccount.ptoken = sapiAccountResponse.ptoken;
                    sapiAccount.app = com.baidu.sapi2.utils.c.a(this.b.context);
                    if (jSONObject.has("device_token")) {
                        com.baidu.sapi2.d.a(this.b.context).a(jSONObject.getString("device_token"));
                    }
                    if (SapiUtils.isValidAccount(sapiAccount)) {
                        com.baidu.sapi2.share.b.a().a(sapiAccount);
                    }
                }
                if (sapiCallBack != null) {
                    switch (jSONObject.optInt("error_code")) {
                        case 0:
                            sapiCallBack.onSuccess(null);
                            return;
                        default:
                            sapiCallBack.onSystemError(jSONObject.optInt("error_code"));
                            return;
                    }
                }
            } catch (Exception e2) {
                if (sapiCallBack != null) {
                    sapiCallBack.onSystemError(-100);
                }
            }
        } else if (sapiCallBack != null) {
            sapiCallBack.onSystemError(i2);
        }
    }

    void b(int i2, SapiCallBack<SapiResponse> sapiCallBack, String str) {
        if (str != null) {
            SapiAccountResponse sapiAccountResponse = new SapiAccountResponse();
            try {
                JSONObject jSONObject = new JSONObject(str);
                sapiAccountResponse.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                sapiAccountResponse.uid = jSONObject.optString(SapiAccountManager.SESSION_UID);
                sapiAccountResponse.bduss = jSONObject.optString(SapiAccountManager.SESSION_BDUSS);
                sapiAccountResponse.ptoken = jSONObject.optString(SapiAccountManager.SESSION_PTOKEN);
                if (!jSONObject.has("error_code") && !jSONObject.has("error_msg")) {
                    SapiAccount sapiAccount = new SapiAccount();
                    sapiAccount.uid = sapiAccountResponse.uid;
                    sapiAccount.bduss = sapiAccountResponse.bduss;
                    sapiAccount.displayname = sapiAccountResponse.displayname;
                    sapiAccount.stoken = sapiAccountResponse.stoken;
                    sapiAccount.ptoken = sapiAccountResponse.ptoken;
                    sapiAccount.app = com.baidu.sapi2.utils.c.a(this.b.context);
                    if (jSONObject.has("device_token")) {
                        com.baidu.sapi2.d.a(this.b.context).a(jSONObject.getString("device_token"));
                    }
                    if (SapiUtils.isValidAccount(sapiAccount)) {
                        com.baidu.sapi2.share.b.a().a(sapiAccount);
                    }
                }
                if (sapiCallBack != null) {
                    switch (jSONObject.optInt("error_code")) {
                        case 0:
                            sapiCallBack.onSuccess(null);
                            return;
                        default:
                            sapiCallBack.onSystemError(jSONObject.optInt("error_code"));
                            return;
                    }
                }
            } catch (Exception e2) {
                if (sapiCallBack != null) {
                    sapiCallBack.onSystemError(-100);
                }
            }
        } else if (sapiCallBack != null) {
            sapiCallBack.onSystemError(i2);
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
            } catch (UnsupportedEncodingException e2) {
                L.e(e2);
            }
            sb.append("&");
        }
        sb.append("sign_key=").append(str);
        return MD5Util.toMd5(sb.toString().getBytes(), false);
    }

    private String x() {
        return "tpl:" + this.b.tpl + ";android_sapi_v" + SapiAccountManager.VERSION_NAME;
    }

    int a(String str) {
        try {
            return new JSONObject(str).getInt("errno");
        } catch (Exception e2) {
            L.e(e2);
            return -100;
        }
    }

    int b(String str) {
        int a2 = a(str);
        if (a2 == 110000) {
            return 0;
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, FillUsernameCallBack fillUsernameCallBack, String str, com.baidu.sapi2.shell.b bVar) {
        if (str != null) {
            SapiAccountResponse sapiAccountResponse = new SapiAccountResponse();
            try {
                String optString = new JSONObject(str).optString("userinfo");
                if (!TextUtils.isEmpty(optString)) {
                    JSONObject jSONObject = new JSONObject(bVar.b(optString));
                    sapiAccountResponse.bduss = jSONObject.optString(SapiAccountManager.SESSION_BDUSS);
                    sapiAccountResponse.ptoken = jSONObject.optString(SapiAccountManager.SESSION_PTOKEN);
                    sapiAccountResponse.stoken = jSONObject.optString(SapiAccountManager.SESSION_STOKEN);
                    sapiAccountResponse.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                    sapiAccountResponse.uid = jSONObject.optString(SapiAccountManager.SESSION_UID);
                    sapiAccountResponse.username = jSONObject.optString("uname");
                    sapiAccountResponse.email = jSONObject.optString("email");
                    switch (i2) {
                        case 0:
                            SapiAccount sapiAccount = new SapiAccount();
                            sapiAccount.displayname = sapiAccountResponse.displayname;
                            sapiAccount.bduss = sapiAccountResponse.bduss;
                            sapiAccount.ptoken = sapiAccountResponse.ptoken;
                            sapiAccount.stoken = sapiAccountResponse.stoken;
                            sapiAccount.uid = sapiAccountResponse.uid;
                            sapiAccount.username = sapiAccountResponse.username;
                            sapiAccount.app = com.baidu.sapi2.utils.c.a(this.b.context);
                            sapiAccount.extra = jSONObject.toString();
                            if (SapiUtils.isValidAccount(sapiAccount)) {
                                com.baidu.sapi2.share.b.a().a(sapiAccount);
                            }
                            fillUsernameCallBack.onSuccess(sapiAccountResponse);
                            return;
                        case SapiErrorCode.USER_IS_NOT_ONLINE /* 160103 */:
                            fillUsernameCallBack.onInvalidBduss();
                            return;
                        case SapiErrorCode.USER_DO_HAVE_NAME /* 160104 */:
                            fillUsernameCallBack.onUserHaveUsername();
                            return;
                        case SapiErrorCode.FILL_UNAME_CANNOT_BE_USE /* 160105 */:
                        case SapiErrorCode.FILL_UNAME_IS_EXIST /* 160111 */:
                            fillUsernameCallBack.onUsernameAlreadyExist();
                            return;
                        case SapiErrorCode.FILL_UNAME_FORMAT_ERROR /* 160110 */:
                            fillUsernameCallBack.onUsernameFormatError();
                            return;
                        default:
                            fillUsernameCallBack.onSystemError(i2);
                            return;
                    }
                }
                return;
            } catch (Throwable th) {
                fillUsernameCallBack.onSystemError(i2);
                return;
            }
        }
        fillUsernameCallBack.onSystemError(i2);
    }

    void a(QrPCLoginCallBack qrPCLoginCallBack, String str) {
        qrPCLoginCallBack.onFinish();
        try {
            JSONObject jSONObject = new JSONObject(str);
            int parseInt = Integer.parseInt(jSONObject.optString("errno"));
            switch (parseInt) {
                case SapiErrorCode.INVALID_ARG /* -103 */:
                case 1:
                    qrPCLoginCallBack.onQrCodeInvalid();
                    break;
                case 0:
                    JSONObject optJSONObject = jSONObject.optJSONObject("local");
                    if (optJSONObject == null) {
                        qrPCLoginCallBack.onSuccess(null);
                        break;
                    } else {
                        QrPCLoginResponse qrPCLoginResponse = new QrPCLoginResponse();
                        qrPCLoginResponse.errorCode = parseInt;
                        qrPCLoginResponse.country = optJSONObject.optString("country");
                        qrPCLoginResponse.province = optJSONObject.optString("provice");
                        qrPCLoginResponse.city = optJSONObject.optString("city");
                        qrPCLoginCallBack.onSuccess(qrPCLoginResponse);
                        break;
                    }
                case 2:
                case SapiErrorCode.BDUSS_IS_EMPTY /* 160102 */:
                    qrPCLoginCallBack.onBdussInvalid();
                    break;
                case 3:
                    qrPCLoginCallBack.onUserNotNormalized();
                    break;
                default:
                    qrPCLoginCallBack.onSystemError(parseInt);
                    break;
            }
        } catch (Exception e2) {
            qrPCLoginCallBack.onSystemError(-100);
        }
    }

    void a(int i2, QrAppLoginCallBack qrAppLoginCallBack, String str) {
        qrAppLoginCallBack.onFinish();
        if (str != null) {
            QrAppLoginResponse qrAppLoginResponse = new QrAppLoginResponse();
            try {
                JSONObject jSONObject = new JSONObject(str);
                int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                qrAppLoginResponse.errorCode = parseInt;
                JSONObject optJSONObject = jSONObject.optJSONObject("local");
                if (optJSONObject != null) {
                    qrAppLoginResponse.country = optJSONObject.optString("country");
                    qrAppLoginResponse.province = optJSONObject.optString("provice");
                    qrAppLoginResponse.city = optJSONObject.optString("city");
                }
                if (!TextUtils.isEmpty(jSONObject.optString("errno")) && jSONObject.optString("errno").equals("0")) {
                    SapiAccount sapiAccount = new SapiAccount();
                    sapiAccount.uid = jSONObject.optString(SapiAccountManager.SESSION_UID);
                    sapiAccount.bduss = jSONObject.optString(SapiAccountManager.SESSION_BDUSS);
                    sapiAccount.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                    sapiAccount.username = jSONObject.optString("uname");
                    sapiAccount.stoken = jSONObject.optString(SapiAccountManager.SESSION_STOKEN);
                    sapiAccount.ptoken = jSONObject.optString(SapiAccountManager.SESSION_PTOKEN);
                    sapiAccount.extra = str;
                    sapiAccount.app = com.baidu.sapi2.utils.c.a(this.b.context);
                    if (SapiUtils.isValidAccount(sapiAccount)) {
                        com.baidu.sapi2.share.b.a().a(sapiAccount);
                    }
                }
                if (qrAppLoginCallBack != null) {
                    switch (parseInt) {
                        case SapiErrorCode.INVALID_ARG /* -103 */:
                        case 1:
                            qrAppLoginCallBack.onQrCodeInvalid();
                            return;
                        case 0:
                            qrAppLoginCallBack.onSuccess(qrAppLoginResponse);
                            return;
                        case 2:
                        case SapiErrorCode.BDUSS_IS_EMPTY /* 160102 */:
                            qrAppLoginCallBack.onBdussInvalid();
                            return;
                        case 3:
                            qrAppLoginCallBack.onUserNotNormalized();
                            return;
                        default:
                            qrAppLoginCallBack.onSystemError(parseInt);
                            return;
                    }
                }
            } catch (Exception e2) {
                if (qrAppLoginCallBack != null) {
                    qrAppLoginCallBack.onSystemError(-100);
                }
            }
        } else if (qrAppLoginCallBack != null) {
            qrAppLoginCallBack.onSystemError(i2);
        }
    }

    void c(int i2, SapiCallBack<SapiAccountResponse> sapiCallBack, String str) {
        if (str != null) {
            SapiAccountResponse sapiAccountResponse = new SapiAccountResponse();
            try {
                JSONObject jSONObject = new JSONObject(str);
                sapiAccountResponse.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                sapiAccountResponse.username = jSONObject.optString("uname");
                sapiAccountResponse.uid = jSONObject.optString(SapiAccountManager.SESSION_UID);
                sapiAccountResponse.bduss = jSONObject.optString(SapiAccountManager.SESSION_BDUSS);
                sapiAccountResponse.ptoken = jSONObject.optString(SapiAccountManager.SESSION_PTOKEN);
                sapiAccountResponse.stoken = jSONObject.optString(SapiAccountManager.SESSION_STOKEN);
                sapiAccountResponse.newReg = jSONObject.optBoolean("newreg");
                if (sapiAccountResponse.newReg) {
                    sapiAccountResponse.authSid = jSONObject.optString("authsid");
                }
                if (sapiCallBack != null) {
                    switch (jSONObject.optInt("errno")) {
                        case 0:
                            sapiCallBack.onSuccess(sapiAccountResponse);
                            return;
                        case 2:
                        case 16:
                        case SapiErrorCode.SMS_LOGIN_TOO_MUCH /* 190016 */:
                            sapiCallBack.onSystemError(jSONObject.optInt("errno"));
                            return;
                        default:
                            sapiCallBack.onSystemError(i2);
                            return;
                    }
                }
            } catch (Exception e2) {
                if (sapiCallBack != null) {
                    sapiCallBack.onSystemError(-100);
                }
            }
        } else if (sapiCallBack != null) {
            sapiCallBack.onSystemError(i2);
        }
    }

    void e(SapiCallBack<SapiResponse> sapiCallBack, String str) {
        try {
            int parseInt = Integer.parseInt(new JSONObject(str).optString("errno"));
            switch (parseInt) {
                case 0:
                    SapiResponse sapiResponse = new SapiResponse();
                    sapiResponse.errorCode = parseInt;
                    sapiResponse.errorMsg = "短信验证码发送成功";
                    sapiCallBack.onSuccess(sapiResponse);
                    break;
                default:
                    sapiCallBack.onSystemError(parseInt);
                    break;
            }
        } catch (Exception e2) {
            sapiCallBack.onSystemError(-100);
        }
    }

    private Domain y() {
        return this.b.environment;
    }

    private String z() {
        return this.d.a() + "/sslcrypt/get_last_cert";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() {
        return y().getWap() + "/passport/login";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d() {
        return y().getWap() + "/passport/getpass";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String e() {
        return y().getWap() + "/v2/?bindingaccount&";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String f() {
        return y().getWap() + "/v2/?bindingret";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(BindWidgetAction bindWidgetAction) {
        return y().getWap() + bindWidgetAction.getUri();
    }

    String g() {
        return this.d.a() + "/v2/sapi/center/filluname";
    }

    String h() {
        return this.d.a() + "/v2/sapi/center/setportrait";
    }

    String i() {
        return this.d.a() + "/v2/sapi/center/getportrait";
    }

    String j() {
        return this.d.a() + com.baidu.sapi2.utils.f.a;
    }

    public String k() {
        return this.d.a() + "/phoenix/account/ssologin";
    }

    public String l() {
        return this.d.a() + "/phoenix/account/ssologin";
    }

    public String m() {
        return this.d.a() + com.baidu.sapi2.utils.f.h;
    }

    public String n() {
        return this.d.a() + com.baidu.sapi2.utils.f.i;
    }

    public String o() {
        return this.d.a() + com.baidu.sapi2.utils.f.j;
    }

    public String p() {
        return y().getDeviceUrl() + com.baidu.sapi2.utils.f.v;
    }

    public String q() {
        return y().getDeviceUrl() + com.baidu.sapi2.utils.f.x;
    }

    public String r() {
        return y().getDeviceUrl() + com.baidu.sapi2.utils.f.w;
    }

    public String s() {
        return y().getDeviceUrl() + com.baidu.sapi2.utils.f.y;
    }

    public String t() {
        return this.d.a() + com.baidu.sapi2.utils.f.k;
    }

    public String u() {
        return this.d.a() + com.baidu.sapi2.utils.f.l;
    }

    public String v() {
        return this.d.a() + com.baidu.sapi2.utils.f.m;
    }

    public String w() {
        return this.d.a() + com.baidu.sapi2.utils.f.o;
    }
}
