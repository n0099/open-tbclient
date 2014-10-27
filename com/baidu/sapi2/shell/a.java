package com.baidu.sapi2.shell;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.security.MD5Util;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.HttpResponseHandler;
import com.baidu.cloudsdk.common.http.MultipartRequestParams;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.shell.callback.FillUserProfileCallBack;
import com.baidu.sapi2.shell.callback.FillUsernameCallBack;
import com.baidu.sapi2.shell.callback.GetUserInfoCallBack;
import com.baidu.sapi2.shell.callback.OAuthCallBack;
import com.baidu.sapi2.shell.callback.QrAppLoginCallBack;
import com.baidu.sapi2.shell.callback.QrPCLoginCallBack;
import com.baidu.sapi2.shell.callback.SapiCallBack;
import com.baidu.sapi2.shell.callback.VoiceCheckCallBack;
import com.baidu.sapi2.shell.callback.VoiceLoginCallBack;
import com.baidu.sapi2.shell.callback.VoiceRegCallBack;
import com.baidu.sapi2.shell.response.GetPortraitResponse;
import com.baidu.sapi2.shell.response.GetUserInfoResponse;
import com.baidu.sapi2.shell.response.OAuthResponse;
import com.baidu.sapi2.shell.response.QrAppLoginResponse;
import com.baidu.sapi2.shell.response.QrPCLoginResponse;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SapiResponse;
import com.baidu.sapi2.shell.response.VoiceCheckResponse;
import com.baidu.sapi2.utils.L;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.c;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.QrLoginAction;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a {
    private static final int a = 6;
    private SapiConfiguration b = SapiAccountManager.getInstance().getSapiConfiguration();
    private AsyncHttpClient c;
    private com.baidu.sapi2.utils.d d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        this.d = new com.baidu.sapi2.utils.d(context);
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
                this.c.setUserAgent(J());
                HashMap hashMap = new HashMap();
                hashMap.put("crypttype", "11");
                hashMap.put("tpl", this.b.tpl);
                hashMap.put("appid", this.b.appId);
                if (TextUtils.isEmpty(this.b.clientId)) {
                    this.b.clientId = SapiUtils.getClientId(this.b.context);
                }
                hashMap.put("cuid", this.b.clientId);
                hashMap.put("cert_id", TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT);
                hashMap.put("isdpass", "0");
                hashMap.put("username", reloginCredentials.account);
                hashMap.put("password", reloginCredentials.password);
                hashMap.put("UBI", reloginCredentials.ubi);
                hashMap.put("isphone", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE.equals(reloginCredentials.accountType) ? "1" : "0");
                hashMap.put(LoginActivityConfig.LOGIN_TYPE, TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                hashMap.put("key", bVar.a());
                hashMap.put("sdk_version", TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT);
                hashMap.put("pinfo", com.baidu.sapi2.utils.c.b());
                hashMap.put("sig", a(hashMap, this.b.appSignKey));
                this.c.post(this.b.context, p(), new RequestParams(hashMap), new t(sapiCallBack, reloginCredentials));
            } catch (Exception e2) {
                d(-100, sapiCallBack, null);
                L.e(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class t extends HttpResponseHandler {
        final /* synthetic */ SapiCallBack a;
        final /* synthetic */ SapiAccount.ReloginCredentials b;

        t(SapiCallBack sapiCallBack, SapiAccount.ReloginCredentials reloginCredentials) {
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

    public int a(SapiAccount.ReloginCredentials reloginCredentials) {
        if (reloginCredentials == null) {
            throw new IllegalArgumentException("ReloginCredentials can't be null");
        }
        if (TextUtils.isEmpty(reloginCredentials.account)) {
            return SapiErrorCode.USERNAME_EMPTY;
        }
        if (TextUtils.isEmpty(reloginCredentials.password)) {
            return SapiErrorCode.PWD_EMPTY;
        }
        if (TextUtils.isEmpty(reloginCredentials.ubi)) {
            return SapiErrorCode.NEED_REQUIRED_ITEMS;
        }
        if (!SapiUtils.hasActiveNetwork(this.b.context)) {
            return SapiErrorCode.NETWORK_FAILED;
        }
        com.baidu.sapi2.shell.b bVar = new com.baidu.sapi2.shell.b();
        try {
            this.c = new AsyncHttpClient();
            this.c.setUserAgent(J());
            HashMap hashMap = new HashMap();
            hashMap.put("crypttype", "11");
            hashMap.put("tpl", this.b.tpl);
            hashMap.put("appid", this.b.appId);
            if (TextUtils.isEmpty(this.b.clientId)) {
                this.b.clientId = SapiUtils.getClientId(this.b.context);
            }
            hashMap.put("cuid", this.b.clientId);
            hashMap.put("cert_id", TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT);
            hashMap.put("isdpass", "0");
            hashMap.put("username", reloginCredentials.account);
            hashMap.put("password", reloginCredentials.password);
            hashMap.put("UBI", reloginCredentials.ubi);
            hashMap.put("isphone", TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE.equals(reloginCredentials.accountType) ? "1" : "0");
            hashMap.put(LoginActivityConfig.LOGIN_TYPE, TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
            hashMap.put("key", bVar.a());
            hashMap.put("sdk_version", TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT);
            hashMap.put("pinfo", com.baidu.sapi2.utils.c.b());
            hashMap.put("sig", a(hashMap, this.b.appSignKey));
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                arrayList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            HttpUriRequest httpPost = new HttpPost(p());
            httpPost.setEntity(new UrlEncodedFormEntity(arrayList, "UTF-8"));
            HttpResponse execute = this.c.execute(httpPost);
            if (200 == execute.getStatusLine().getStatusCode()) {
                String entityUtils = EntityUtils.toString(execute.getEntity());
                if (!TextUtils.isEmpty(entityUtils)) {
                    int a2 = a(entityUtils);
                    if (a2 == 0) {
                        JSONObject jSONObject = new JSONObject(entityUtils);
                        SapiAccount sapiAccount = new SapiAccount();
                        sapiAccount.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                        sapiAccount.bduss = jSONObject.optString(SapiAccountManager.SESSION_BDUSS);
                        sapiAccount.ptoken = jSONObject.optString(SapiAccountManager.SESSION_PTOKEN);
                        sapiAccount.stoken = jSONObject.optString(SapiAccountManager.SESSION_STOKEN);
                        sapiAccount.uid = jSONObject.optString(SapiAccountManager.SESSION_UID);
                        sapiAccount.username = jSONObject.optString("uname");
                        sapiAccount.app = SapiUtils.getAppName(this.b.context);
                        sapiAccount.extra = entityUtils;
                        com.baidu.sapi2.share.c.a().a(sapiAccount);
                        return a2;
                    }
                    return a2;
                }
            }
        } catch (Throwable th) {
            L.e(th);
        }
        return -100;
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
                            sapiAccount.app = SapiUtils.getAppName(this.b.context);
                            sapiAccount.extra = str;
                            com.baidu.sapi2.share.c.a().a(sapiAccount);
                            sapiCallBack.onSuccess(sapiAccountResponse);
                            break;
                        default:
                            sapiCallBack.onSystemError(i2);
                            break;
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
        this.c.setUserAgent(J());
        this.c.get(this.b.context, L(), new u(sapiCallBack, z, bVar, str, str2));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class u extends HttpResponseHandler {
        final /* synthetic */ SapiCallBack a;
        final /* synthetic */ boolean b;
        final /* synthetic */ com.baidu.sapi2.shell.b c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        u(SapiCallBack sapiCallBack, boolean z, com.baidu.sapi2.shell.b bVar, String str, String str2) {
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
        this.c.setUserAgent(J());
        HashMap hashMap = new HashMap();
        hashMap.put("crypttype", "6");
        hashMap.put("tpl", this.b.tpl);
        hashMap.put("appid", this.b.appId);
        String str5 = this.b.clientId;
        if (!TextUtils.isEmpty(str5)) {
            hashMap.put("cuid", str5);
        }
        hashMap.put("cert_id", str2);
        hashMap.put("isdpass", "1");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("username", str3);
        jSONObject.put("isphone", "1");
        jSONObject.put("password", str4);
        jSONObject.put(LoginActivityConfig.LOGIN_TYPE, TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
        jSONObject.put("key", bVar.a());
        jSONObject.put("sdk_version", TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT);
        jSONObject.put("pinfo", com.baidu.sapi2.utils.c.b());
        hashMap.put("userinfo", bVar.a(str, jSONObject.toString()));
        hashMap.put("sig", a(hashMap, this.b.appSignKey));
        this.c.post(this.b.context, p(), new RequestParams(hashMap), new v(sapiCallBack, z, bVar, str3, str4));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class v extends HttpResponseHandler {
        final /* synthetic */ SapiCallBack a;
        final /* synthetic */ boolean b;
        final /* synthetic */ com.baidu.sapi2.shell.b c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        v(SapiCallBack sapiCallBack, boolean z, com.baidu.sapi2.shell.b bVar, String str, String str2) {
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
                                sapiAccount.app = SapiUtils.getAppName(this.b.context);
                                sapiAccount.extra = str2;
                                com.baidu.sapi2.share.c.a().a(sapiAccount);
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
        this.c.setUserAgent(J());
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
        this.c.post(this.b.context, m(), multipartRequestParams, new w(sapiCallBack, str, str2, str3, bArr, str4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class w extends HttpResponseHandler {
        final /* synthetic */ SapiCallBack a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ byte[] e;
        final /* synthetic */ String f;

        w(SapiCallBack sapiCallBack, String str, String str2, String str3, byte[] bArr, String str4) {
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
        this.c.setUserAgent(J());
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
        this.c.post(this.b.context, n(), requestParams, new p(sapiCallBack, str, str2, str3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class p extends HttpResponseHandler {
        final /* synthetic */ SapiCallBack a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;

        p(SapiCallBack sapiCallBack, String str, String str2, String str3) {
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

    public void a(GetUserInfoCallBack getUserInfoCallBack, String str) {
        if (getUserInfoCallBack == null) {
            throw new IllegalArgumentException(GetUserInfoCallBack.class.getSimpleName() + " can't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        if (!SapiUtils.hasActiveNetwork(this.b.context)) {
            getUserInfoCallBack.onFinish();
            getUserInfoCallBack.onNetworkFailed();
            return;
        }
        this.c = new AsyncHttpClient();
        this.c.setUserAgent(J());
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
        String a2 = a(hashMap, this.b.appSignKey);
        RequestParams requestParams = new RequestParams();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            requestParams.put(entry.getKey(), entry.getValue());
        }
        requestParams.put("sig", a2);
        this.c.post(this.b.context, o(), requestParams, new q(getUserInfoCallBack, str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class q extends HttpResponseHandler {
        final /* synthetic */ GetUserInfoCallBack a;
        final /* synthetic */ String b;

        q(GetUserInfoCallBack getUserInfoCallBack, String str) {
            this.a = getUserInfoCallBack;
            this.b = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            a.this.d.d();
            this.a.onFinish();
            int a = a.this.a(str);
            switch (a) {
                case 0:
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        GetUserInfoResponse getUserInfoResponse = new GetUserInfoResponse();
                        getUserInfoResponse.errorCode = a;
                        getUserInfoResponse.errorMsg = jSONObject.optString("errmsg");
                        String optString = jSONObject.optString(com.baidu.tbadk.core.frameworkData.a.PORTRAIT);
                        if (!TextUtils.isEmpty(optString)) {
                            getUserInfoResponse.portrait = String.format("http://himg.bdimg.com/sys/portrait/item/%s.jpg", optString);
                        }
                        getUserInfoResponse.username = jSONObject.optString("username");
                        getUserInfoResponse.uid = jSONObject.optString("userid");
                        getUserInfoResponse.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                        getUserInfoResponse.incompleteUser = "1".equals(jSONObject.optString("incomplete_user"));
                        getUserInfoResponse.secureMobile = jSONObject.optString("securemobil");
                        getUserInfoResponse.secureEmail = jSONObject.optString("secureemail");
                        this.a.onSuccess(getUserInfoResponse);
                        return;
                    } catch (JSONException e) {
                        this.a.onSystemError(a);
                        L.e(e);
                        return;
                    }
                case SapiErrorCode.BDUSS_IS_EXPIRED /* 400021 */:
                    this.a.onBdussInvalid();
                    return;
                default:
                    this.a.onSystemError(a);
                    return;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (a.this.d.c()) {
                a.this.d.d();
                this.a.onFinish();
                this.a.onSystemError(-100);
                return;
            }
            a.this.d.b();
            a.this.a(this.a, this.b);
        }
    }

    public void a(FillUsernameCallBack fillUsernameCallBack, String str, String str2, String str3) {
        if (!SapiUtils.hasActiveNetwork(this.b.context)) {
            if (fillUsernameCallBack != null) {
                fillUsernameCallBack.onNetworkFailed();
                return;
            }
            return;
        }
        com.baidu.sapi2.shell.b bVar = new com.baidu.sapi2.shell.b();
        this.c = new AsyncHttpClient();
        this.c.setUserAgent(J());
        this.c.get(this.b.context, L(), new r(fillUsernameCallBack, bVar, str, str2, str3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class r extends HttpResponseHandler {
        final /* synthetic */ FillUsernameCallBack a;
        final /* synthetic */ com.baidu.sapi2.shell.b b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        r(FillUsernameCallBack fillUsernameCallBack, com.baidu.sapi2.shell.b bVar, String str, String str2, String str3) {
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
    public void a(FillUsernameCallBack fillUsernameCallBack, String str, String str2, String str3, String str4, String str5, com.baidu.sapi2.shell.b bVar) {
        this.c = new AsyncHttpClient();
        this.c.setUserAgent(J());
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
        if (!TextUtils.isEmpty(str2)) {
            jSONObject.put(SapiAccountManager.SESSION_PTOKEN, str2);
        }
        jSONObject.put("username", str3);
        jSONObject.put("key", bVar.a());
        hashMap.put("userinfo", bVar.a(str4, jSONObject.toString()));
        hashMap.put("sig", a(hashMap, this.b.appSignKey));
        this.c.post(this.b.context, l(), new RequestParams(hashMap), new s(fillUsernameCallBack, bVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class s extends HttpResponseHandler {
        final /* synthetic */ FillUsernameCallBack a;
        final /* synthetic */ com.baidu.sapi2.shell.b b;

        s(FillUsernameCallBack fillUsernameCallBack, com.baidu.sapi2.shell.b bVar) {
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

    public void a(FillUserProfileCallBack fillUserProfileCallBack, String str) {
        if (fillUserProfileCallBack == null) {
            throw new IllegalArgumentException(FillUserProfileCallBack.class.getSimpleName() + " can't be null");
        }
        if (TextUtils.isEmpty(str)) {
            fillUserProfileCallBack.onFinish();
            fillUserProfileCallBack.onBdussInvalid();
        } else if (!SapiUtils.hasActiveNetwork(this.b.context)) {
            fillUserProfileCallBack.onFinish();
            fillUserProfileCallBack.onNetworkFailed();
        } else if (!SapiUtils.isSimReady(this.b.context)) {
            fillUserProfileCallBack.onFinish();
            fillUserProfileCallBack.onSimUnavailable();
        } else {
            this.c = new AsyncHttpClient();
            this.c.setUserAgent(J());
            HashMap hashMap = new HashMap();
            hashMap.put("appid", this.b.appId);
            hashMap.put("tpl", this.b.tpl);
            if (!TextUtils.isEmpty(this.b.clientId)) {
                hashMap.put("clientid", this.b.clientId);
            }
            hashMap.put(SapiAccountManager.SESSION_BDUSS, str);
            hashMap.put("sig", a(hashMap, this.b.appSignKey));
            this.c.post(this.b.context, E(), new RequestParams(hashMap), new o(fillUserProfileCallBack, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class o extends HttpResponseHandler {
        final /* synthetic */ FillUserProfileCallBack a;
        final /* synthetic */ String b;

        o(FillUserProfileCallBack fillUserProfileCallBack, String str) {
            this.a = fillUserProfileCallBack;
            this.b = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            a.this.a(this.a, this.b, str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            a.this.a(this.a, this.b, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FillUserProfileCallBack fillUserProfileCallBack, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str2);
            int a2 = a(str2);
            switch (a2) {
                case 0:
                    String optString = jSONObject.optString("sms");
                    String optString2 = jSONObject.optString("vcode");
                    String optString3 = jSONObject.optString("upsmschannel");
                    if (SapiUtils.sendSms(this.b.context, optString2, optString) && !TextUtils.isEmpty(optString3)) {
                        this.c = new AsyncHttpClient();
                        this.c.setUserAgent(J());
                        CookieStore basicCookieStore = new BasicCookieStore();
                        BasicClientCookie basicClientCookie = new BasicClientCookie("BAIDUID", SapiUtils.getClientId(this.b.context));
                        basicClientCookie.setDomain("baidu.com");
                        basicClientCookie.setPath("/");
                        basicCookieStore.addCookie(basicClientCookie);
                        this.c.setCookieStore(basicCookieStore);
                        RequestParams requestParams = new RequestParams();
                        requestParams.put("channel_id", optString3);
                        requestParams.put("callback", "p");
                        requestParams.put("apiver", "v3");
                        requestParams.put("tt", String.valueOf(System.currentTimeMillis()));
                        this.c.get(this.b.context, "https://passport.baidu.com/channel/unicast", requestParams, new d(fillUserProfileCallBack, optString3, str, optString2));
                        break;
                    } else {
                        fillUserProfileCallBack.onFinish();
                        fillUserProfileCallBack.onSystemError(-100);
                        break;
                    }
                case 1:
                    fillUserProfileCallBack.onFinish();
                    fillUserProfileCallBack.onBdussInvalid();
                    break;
                case SapiErrorCode.FILL_USER_PROFILE_USER_NORMALIZED /* 61002 */:
                    fillUserProfileCallBack.onFinish();
                    fillUserProfileCallBack.onUserNormalized();
                    break;
                default:
                    fillUserProfileCallBack.onFinish();
                    fillUserProfileCallBack.onSystemError(a2);
                    break;
            }
        } catch (Throwable th) {
            fillUserProfileCallBack.onFinish();
            fillUserProfileCallBack.onSystemError(-100);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends HttpResponseHandler {
        final /* synthetic */ FillUserProfileCallBack a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;

        d(FillUserProfileCallBack fillUserProfileCallBack, String str, String str2, String str3) {
            this.a = fillUserProfileCallBack;
            this.b = str;
            this.c = str2;
            this.d = str3;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            if (TextUtils.isEmpty(str)) {
                this.a.onFinish();
                this.a.onSystemError(-100);
                return;
            }
            int indexOf = str.indexOf("(");
            int indexOf2 = str.indexOf(")");
            if (indexOf >= 0) {
                try {
                    switch (a.this.a(str.substring(indexOf + 1, indexOf2))) {
                        case 0:
                            HashMap hashMap = new HashMap();
                            hashMap.put("appid", a.this.b.appId);
                            hashMap.put("tpl", a.this.b.tpl);
                            if (!TextUtils.isEmpty(a.this.b.clientId)) {
                                hashMap.put("clientid", a.this.b.clientId);
                            }
                            hashMap.put("upsmschannel", this.b);
                            hashMap.put(SapiAccountManager.SESSION_BDUSS, this.c);
                            hashMap.put("vcode", this.d);
                            hashMap.put("sig", a.this.a(hashMap, a.this.b.appSignKey));
                            a.this.c = new AsyncHttpClient();
                            a.this.c.setUserAgent(a.this.J());
                            a.this.c.post(a.this.b.context, a.this.F(), new RequestParams(hashMap), new HandlerC0021a());
                            return;
                        default:
                            this.a.onFinish();
                            this.a.onSystemError(-100);
                            return;
                    }
                } catch (Throwable th) {
                    L.e(th);
                    this.a.onFinish();
                    this.a.onSystemError(-100);
                    return;
                }
            }
            this.a.onFinish();
            this.a.onSystemError(-100);
        }

        /* renamed from: com.baidu.sapi2.shell.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class HandlerC0021a extends HttpResponseHandler {
            HandlerC0021a() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str) {
                try {
                    int a = a.this.a(str);
                    switch (a) {
                        case 0:
                            SapiAccountResponse sapiAccountResponse = new SapiAccountResponse();
                            sapiAccountResponse.errorCode = a;
                            JSONObject jSONObject = new JSONObject(str);
                            sapiAccountResponse.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                            sapiAccountResponse.bduss = jSONObject.optString(SapiAccountManager.SESSION_BDUSS);
                            sapiAccountResponse.uid = jSONObject.optString(SapiAccountManager.SESSION_UID);
                            sapiAccountResponse.ptoken = jSONObject.optString(SapiAccountManager.SESSION_PTOKEN);
                            sapiAccountResponse.stoken = jSONObject.optString(SapiAccountManager.SESSION_STOKEN);
                            d.this.a.onFinish();
                            d.this.a.onSuccess(sapiAccountResponse);
                            break;
                        case 8:
                            d.this.a.onFinish();
                            d.this.a.onPhoneUnavailable();
                            break;
                        default:
                            d.this.a.onFinish();
                            d.this.a.onSystemError(a);
                            break;
                    }
                } catch (Throwable th) {
                    d.this.a.onFinish();
                    d.this.a.onSystemError(-100);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str) {
                d.this.a.onFinish();
                d.this.a.onSystemError(-100);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            this.a.onFinish();
            this.a.onSystemError(-100);
        }
    }

    public void a(VoiceCheckCallBack voiceCheckCallBack, String str, boolean z, boolean z2) {
        if (voiceCheckCallBack == null) {
            throw new IllegalArgumentException(VoiceCheckCallBack.class.getSimpleName() + " can't be null");
        }
        if (!this.b.voiceUserEnabled) {
            voiceCheckCallBack.onFinish();
            voiceCheckCallBack.onNotEnabled();
        } else if (TextUtils.isEmpty(str)) {
            voiceCheckCallBack.onFinish();
            voiceCheckCallBack.onSystemError(SapiErrorCode.USERNAME_EMPTY);
        } else if (!SapiUtils.hasActiveNetwork(this.b.context)) {
            voiceCheckCallBack.onFinish();
            voiceCheckCallBack.onNetworkFailed();
        } else {
            this.c = new AsyncHttpClient();
            this.c.setUserAgent(J());
            HashMap hashMap = new HashMap();
            hashMap.put("appid", this.b.appId);
            hashMap.put("tpl", this.b.tpl);
            if (!TextUtils.isEmpty(this.b.clientId)) {
                hashMap.put("clientid", this.b.clientId);
            }
            hashMap.put("username", str);
            if (z) {
                hashMap.put("merge", "1");
            }
            if (z2) {
                hashMap.put("isphone", "1");
            } else {
                hashMap.put("isphone", "0");
            }
            hashMap.put("sig", a(hashMap, this.b.appSignKey));
            this.c.post(this.b.context, G(), new RequestParams(hashMap), new c(voiceCheckCallBack, str, z, z2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends HttpResponseHandler {
        final /* synthetic */ VoiceCheckCallBack a;
        final /* synthetic */ String b;
        final /* synthetic */ boolean c;
        final /* synthetic */ boolean d;

        c(VoiceCheckCallBack voiceCheckCallBack, String str, boolean z, boolean z2) {
            this.a = voiceCheckCallBack;
            this.b = str;
            this.c = z;
            this.d = z2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            a.this.d.d();
            a.this.b(this.a, str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (a.this.d.c()) {
                a.this.d.d();
                a.this.b(this.a, str);
                return;
            }
            a.this.d.b();
            a.this.a(this.a, this.b, this.c, this.d);
        }
    }

    public void a(VoiceCheckCallBack voiceCheckCallBack, String str) {
        if (voiceCheckCallBack == null) {
            throw new IllegalArgumentException(VoiceCheckCallBack.class.getSimpleName() + " can't be null");
        }
        if (TextUtils.isEmpty(str)) {
            voiceCheckCallBack.onFinish();
            voiceCheckCallBack.onSystemError(SapiErrorCode.BDUSS_IS_EMPTY);
        } else if (!SapiUtils.hasActiveNetwork(this.b.context)) {
            voiceCheckCallBack.onFinish();
            voiceCheckCallBack.onNetworkFailed();
        } else {
            this.c = new AsyncHttpClient();
            this.c.setUserAgent(J());
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
            hashMap.put("sig", a(hashMap, this.b.appSignKey));
            this.c.post(this.b.context, G(), new RequestParams(hashMap), new b(voiceCheckCallBack, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends HttpResponseHandler {
        final /* synthetic */ VoiceCheckCallBack a;
        final /* synthetic */ String b;

        b(VoiceCheckCallBack voiceCheckCallBack, String str) {
            this.a = voiceCheckCallBack;
            this.b = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            a.this.d.d();
            a.this.b(this.a, str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (a.this.d.c()) {
                a.this.d.d();
                a.this.b(this.a, str);
                return;
            }
            a.this.d.b();
            a.this.a(this.a, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(VoiceCheckCallBack voiceCheckCallBack, String str) {
        voiceCheckCallBack.onFinish();
        try {
            JSONObject jSONObject = new JSONObject(str);
            int parseInt = Integer.parseInt(jSONObject.optString("errno"));
            switch (parseInt) {
                case 0:
                    VoiceCheckResponse voiceCheckResponse = new VoiceCheckResponse();
                    voiceCheckResponse.errorCode = parseInt;
                    voiceCheckResponse.uid = com.baidu.sapi2.shell.b.c(jSONObject.optString("id"));
                    voiceCheckResponse.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                    voiceCheckResponse.signUp = "1".equals(jSONObject.optString("voice"));
                    voiceCheckResponse.needVerify = "1".equals(jSONObject.optString("needverify"));
                    voiceCheckResponse.authToken = jSONObject.optString("token");
                    if ("null".equals(voiceCheckResponse.authToken)) {
                        voiceCheckResponse.authToken = null;
                    }
                    voiceCheckResponse.authSid = jSONObject.optString("authsid");
                    if ("null".equals(voiceCheckResponse.authSid)) {
                        voiceCheckResponse.authSid = null;
                    }
                    voiceCheckCallBack.onSuccess(voiceCheckResponse);
                    return;
                case 2:
                    voiceCheckCallBack.onUsernameNotExist();
                    return;
                case 3:
                    voiceCheckCallBack.onUserNotNormalized();
                    return;
                case 4:
                    voiceCheckCallBack.onUserForbidden();
                    return;
                case SapiErrorCode.BDUSS_IS_EXPIRED /* 400021 */:
                    voiceCheckCallBack.onBdussInvalid();
                    return;
                case SapiErrorCode.LOGIN_MERGE_CONFIRM /* 400401 */:
                    voiceCheckCallBack.onLoginMergeConfirm();
                    return;
                default:
                    voiceCheckCallBack.onSystemError(parseInt);
                    return;
            }
        } catch (Exception e2) {
            voiceCheckCallBack.onSystemError(-100);
        }
    }

    public void a(OAuthCallBack oAuthCallBack, String str) {
        if (!SapiUtils.hasActiveNetwork(this.b.context)) {
            if (oAuthCallBack != null) {
                oAuthCallBack.onFinish();
                oAuthCallBack.onNetworkFailed();
            }
        } else if (TextUtils.isEmpty(str)) {
            if (oAuthCallBack != null) {
                oAuthCallBack.onFinish();
                oAuthCallBack.onSystemError(SapiErrorCode.BDUSS_IS_EMPTY);
            }
        } else {
            this.c = new AsyncHttpClient();
            this.c.setUserAgent(J());
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
            hashMap.put("sig", a(hashMap, this.b.appSignKey));
            this.c.post(this.b.context, D(), new RequestParams(hashMap), new HandlerC0020a(oAuthCallBack, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.sapi2.shell.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class HandlerC0020a extends HttpResponseHandler {
        final /* synthetic */ OAuthCallBack a;
        final /* synthetic */ String b;

        HandlerC0020a(OAuthCallBack oAuthCallBack, String str) {
            this.a = oAuthCallBack;
            this.b = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
            a.this.d.d();
            a.this.b(this.a, str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
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

    public void a(VoiceRegCallBack voiceRegCallBack, String str, String str2, String str3, boolean z) {
        if (voiceRegCallBack == null) {
            throw new IllegalArgumentException(VoiceRegCallBack.class.getSimpleName() + " can't be null");
        }
        if (!this.b.voiceUserEnabled) {
            voiceRegCallBack.onFinish();
            voiceRegCallBack.onNotEnabled();
        } else if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("voiceMd5 can't be empty");
        } else {
            if (!SapiUtils.hasActiveNetwork(this.b.context)) {
                voiceRegCallBack.onFinish();
                voiceRegCallBack.onNetworkFailed();
                return;
            }
            this.c = new AsyncHttpClient();
            this.c.setUserAgent(J());
            HashMap hashMap = new HashMap();
            hashMap.put("appid", this.b.appId);
            hashMap.put("tpl", this.b.tpl);
            if (!TextUtils.isEmpty(this.b.clientId)) {
                hashMap.put("clientid", this.b.clientId);
                hashMap.put("cuid", this.b.clientId);
            }
            if (!TextUtils.isEmpty(this.b.clientIp)) {
                hashMap.put("clientip", this.b.clientIp);
            }
            hashMap.put("voicemd5", str);
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put(SapiAccountManager.SESSION_BDUSS, str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put("authsid", str3);
            }
            if (z) {
                hashMap.put("newuser", "1");
            } else {
                hashMap.put("newuser", "0");
            }
            hashMap.put("sig", a(hashMap, this.b.appSignKey));
            this.c.post(this.b.context, H(), new RequestParams(hashMap), new h(voiceRegCallBack, z, str, str2, str3));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends HttpResponseHandler {
        final /* synthetic */ VoiceRegCallBack a;
        final /* synthetic */ boolean b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        h(VoiceRegCallBack voiceRegCallBack, boolean z, String str, String str2, String str3) {
            this.a = voiceRegCallBack;
            this.b = z;
            this.c = str;
            this.d = str2;
            this.e = str3;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            a.this.d.d();
            a.this.a(this.a, str, this.b);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (a.this.d.c()) {
                a.this.d.d();
                a.this.a(this.a, str, this.b);
                return;
            }
            a.this.d.b();
            a.this.a(this.a, this.c, this.d, this.e, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(VoiceRegCallBack voiceRegCallBack, String str, boolean z) {
        voiceRegCallBack.onFinish();
        try {
            JSONObject jSONObject = new JSONObject(str);
            int parseInt = Integer.parseInt(jSONObject.optString("errno"));
            switch (parseInt) {
                case 0:
                    SapiResponse sapiResponse = new SapiResponse();
                    sapiResponse.errorCode = parseInt;
                    if (z) {
                        SapiAccount sapiAccount = new SapiAccount();
                        sapiAccount.uid = jSONObject.optString(SapiAccountManager.SESSION_UID);
                        sapiAccount.bduss = jSONObject.optString(SapiAccountManager.SESSION_BDUSS);
                        sapiAccount.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                        sapiAccount.username = jSONObject.optString("uname");
                        sapiAccount.ptoken = jSONObject.optString(SapiAccountManager.SESSION_PTOKEN);
                        sapiAccount.stoken = jSONObject.optString(SapiAccountManager.SESSION_STOKEN);
                        sapiAccount.app = SapiUtils.getAppName(this.b.context);
                        sapiAccount.extra = str;
                        com.baidu.sapi2.share.c.a().a(sapiAccount);
                    }
                    voiceRegCallBack.onSuccess(sapiResponse);
                    return;
                case SapiErrorCode.VOICE_REG_AUTH_EXPIRED /* 62004 */:
                    voiceRegCallBack.onAuthExpired();
                    return;
                default:
                    voiceRegCallBack.onSystemError(parseInt);
                    return;
            }
        } catch (Exception e2) {
            voiceRegCallBack.onSystemError(-100);
        }
    }

    public void a(VoiceLoginCallBack voiceLoginCallBack, String str, String str2) {
        if (voiceLoginCallBack == null) {
            throw new IllegalArgumentException(VoiceLoginCallBack.class.getSimpleName() + " can't be null");
        }
        if (!this.b.voiceUserEnabled) {
            voiceLoginCallBack.onFinish();
            voiceLoginCallBack.onNotEnabled();
        } else if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("voiceMd5 can't be empty");
        } else {
            if (TextUtils.isEmpty(str2)) {
                throw new IllegalArgumentException("uid can't be empty");
            }
            if (!SapiUtils.hasActiveNetwork(this.b.context)) {
                voiceLoginCallBack.onFinish();
                voiceLoginCallBack.onNetworkFailed();
                return;
            }
            this.c = new AsyncHttpClient();
            this.c.setUserAgent(J());
            HashMap hashMap = new HashMap();
            hashMap.put("appid", this.b.appId);
            hashMap.put("tpl", this.b.tpl);
            if (!TextUtils.isEmpty(this.b.clientId)) {
                hashMap.put("clientid", this.b.clientId);
            }
            if (!TextUtils.isEmpty(this.b.clientIp)) {
                hashMap.put("clientip", this.b.clientIp);
            }
            hashMap.put("voicemd5", str);
            hashMap.put("id", com.baidu.sapi2.shell.b.d(str2));
            hashMap.put("sig", a(hashMap, this.b.appSignKey));
            this.c.post(this.b.context, I(), new RequestParams(hashMap), new g(voiceLoginCallBack, str, str2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends HttpResponseHandler {
        final /* synthetic */ VoiceLoginCallBack a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        g(VoiceLoginCallBack voiceLoginCallBack, String str, String str2) {
            this.a = voiceLoginCallBack;
            this.b = str;
            this.c = str2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            a.this.d.d();
            a.this.a(this.a, str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (a.this.d.c()) {
                a.this.d.d();
                a.this.a(this.a, str);
                return;
            }
            a.this.d.b();
            a.this.a(this.a, this.b, this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(VoiceLoginCallBack voiceLoginCallBack, String str) {
        voiceLoginCallBack.onFinish();
        try {
            JSONObject jSONObject = new JSONObject(str);
            int parseInt = Integer.parseInt(jSONObject.optString("errno"));
            switch (parseInt) {
                case 0:
                    SapiResponse sapiResponse = new SapiResponse();
                    sapiResponse.errorCode = parseInt;
                    SapiAccount sapiAccount = new SapiAccount();
                    sapiAccount.uid = jSONObject.optString(SapiAccountManager.SESSION_UID);
                    sapiAccount.bduss = jSONObject.optString(SapiAccountManager.SESSION_BDUSS);
                    sapiAccount.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                    sapiAccount.username = jSONObject.optString("uname");
                    sapiAccount.ptoken = jSONObject.optString(SapiAccountManager.SESSION_PTOKEN);
                    sapiAccount.stoken = jSONObject.optString(SapiAccountManager.SESSION_STOKEN);
                    sapiAccount.app = SapiUtils.getAppName(this.b.context);
                    sapiAccount.extra = str;
                    com.baidu.sapi2.share.c.a().a(sapiAccount);
                    voiceLoginCallBack.onSuccess(sapiResponse);
                    break;
                default:
                    voiceLoginCallBack.onSystemError(parseInt);
                    break;
            }
        } catch (Exception e2) {
            voiceLoginCallBack.onSystemError(-100);
        }
    }

    public void a(QrPCLoginCallBack qrPCLoginCallBack, String str, String str2, String str3, String str4, String str5) {
        if (!SapiUtils.hasActiveNetwork(this.b.context)) {
            if (qrPCLoginCallBack != null) {
                qrPCLoginCallBack.onFinish();
                qrPCLoginCallBack.onNetworkFailed();
            }
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (qrPCLoginCallBack != null) {
                qrPCLoginCallBack.onFinish();
                qrPCLoginCallBack.onQrCodeInvalid();
            }
        } else if (TextUtils.isEmpty(str3) && QrLoginAction.LOGIN.getName().equals(str2)) {
            if (qrPCLoginCallBack != null) {
                qrPCLoginCallBack.onFinish();
                qrPCLoginCallBack.onBdussInvalid();
            }
        } else {
            this.c = new AsyncHttpClient();
            this.c.setUserAgent(J());
            HashMap hashMap = new HashMap();
            hashMap.put(SapiUtils.KEY_QR_LOGIN_SIGN, str);
            hashMap.put(com.baidu.tbadk.core.frameworkData.a.CMD, str2);
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put(SapiAccountManager.SESSION_BDUSS, str3);
            }
            if (!TextUtils.isEmpty(str5)) {
                hashMap.put(SapiAccountManager.SESSION_PTOKEN, str5);
            }
            if (!TextUtils.isEmpty(str4)) {
                hashMap.put(SapiAccountManager.SESSION_STOKEN, str4);
            }
            if (!TextUtils.isEmpty(this.b.clientId)) {
                hashMap.put("clientid", this.b.clientId);
            }
            if (!TextUtils.isEmpty(this.b.clientIp)) {
                hashMap.put("clientip", this.b.clientIp);
            }
            hashMap.put("tpl", this.b.tpl);
            hashMap.put("appid", this.b.appId);
            hashMap.put("sig", a(hashMap, this.b.appSignKey));
            this.c.post(this.b.context, z(), new RequestParams(hashMap), new f(qrPCLoginCallBack, str, str2, str3, str4, str5));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends HttpResponseHandler {
        final /* synthetic */ QrPCLoginCallBack a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;
        final /* synthetic */ String f;

        f(QrPCLoginCallBack qrPCLoginCallBack, String str, String str2, String str3, String str4, String str5) {
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

    public void a(QrAppLoginCallBack qrAppLoginCallBack, String str, String str2) {
        if (!SapiUtils.hasActiveNetwork(this.b.context)) {
            if (qrAppLoginCallBack != null) {
                qrAppLoginCallBack.onFinish();
                qrAppLoginCallBack.onNetworkFailed();
            }
        } else if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (qrAppLoginCallBack != null) {
                qrAppLoginCallBack.onFinish();
                qrAppLoginCallBack.onQrCodeInvalid();
            }
        } else {
            this.c = new AsyncHttpClient();
            this.c.setUserAgent(J());
            HashMap hashMap = new HashMap();
            hashMap.put(SapiUtils.KEY_QR_LOGIN_SIGN, str);
            hashMap.put(com.baidu.tbadk.core.frameworkData.a.CMD, str2);
            if (!TextUtils.isEmpty(this.b.clientId)) {
                hashMap.put("clientid", this.b.clientId);
            }
            if (!TextUtils.isEmpty(this.b.clientIp)) {
                hashMap.put("clientip", this.b.clientIp);
            }
            hashMap.put("tpl", this.b.tpl);
            hashMap.put("appid", this.b.appId);
            hashMap.put("sig", a(hashMap, this.b.appSignKey));
            this.c.post(this.b.context, A(), new RequestParams(hashMap), new e(qrAppLoginCallBack, str, str2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends HttpResponseHandler {
        final /* synthetic */ QrAppLoginCallBack a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        e(QrAppLoginCallBack qrAppLoginCallBack, String str, String str2) {
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
            this.c.setUserAgent(J());
            HashMap hashMap = new HashMap();
            hashMap.put("username", str);
            if (!TextUtils.isEmpty(this.b.clientId)) {
                hashMap.put("clientid", this.b.clientId);
            }
            if (!TextUtils.isEmpty(this.b.clientIp)) {
                hashMap.put("clientip", this.b.clientIp);
            }
            hashMap.put("tpl", this.b.tpl);
            hashMap.put("appid", this.b.appId);
            hashMap.put("sig", a(hashMap, this.b.appSignKey));
            this.c.post(this.b.context, C(), new RequestParams(hashMap), new m(sapiCallBack, str));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class m extends HttpResponseHandler {
        final /* synthetic */ SapiCallBack a;
        final /* synthetic */ String b;

        m(SapiCallBack sapiCallBack, String str) {
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
            this.c.setUserAgent(J());
            HashMap hashMap = new HashMap();
            hashMap.put("sms", str);
            if (!TextUtils.isEmpty(this.b.clientId)) {
                hashMap.put("clientid", this.b.clientId);
            }
            if (!TextUtils.isEmpty(this.b.clientIp)) {
                hashMap.put("clientip", this.b.clientIp);
            }
            hashMap.put("tpl", this.b.tpl);
            hashMap.put("appid", this.b.appId);
            hashMap.put("sig", a(hashMap, this.b.appSignKey));
            this.c.post(this.b.context, B(), new RequestParams(hashMap), new n(sapiCallBack, str));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class n extends HttpResponseHandler {
        final /* synthetic */ SapiCallBack a;
        final /* synthetic */ String b;

        n(SapiCallBack sapiCallBack, String str) {
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
            this.c.setUserAgent(J());
            HashMap hashMap = new HashMap();
            if (com.baidu.sapi2.c.a(this.b.context).a() != null) {
                hashMap.put("device_id", com.baidu.sapi2.utils.c.d(this.b.context));
                hashMap.put("device_token", com.baidu.sapi2.c.a(this.b.context).a());
            }
            this.c.get(this.b.context, v(), new RequestParams(hashMap), new l());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class l extends HttpResponseHandler {
        l() {
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            if (str != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("error_code") || jSONObject.has("error_msg") || jSONObject.optInt("fulfilbind") != 0) {
                        return;
                    }
                    if (jSONObject.optInt(TbConfig.ST_TYPE_REG) == 1 || jSONObject.optInt("login") == 1) {
                        com.baidu.sapi2.c.a(a.this.b.context).a(true);
                    }
                } catch (JSONException e) {
                    L.e(e);
                    com.baidu.sapi2.c.a(a.this.b.context).a(false);
                }
            }
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
            com.baidu.sapi2.c.a(a.this.b.context).a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(SapiCallBack<SapiResponse> sapiCallBack) {
        if (this.b == null || this.b.context == null || TextUtils.isEmpty(this.b.deviceLoginSignKey) || !com.baidu.sapi2.c.a(this.b.context).b()) {
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
        this.c.setUserAgent(J());
        HashMap hashMap = new HashMap();
        String a2 = c.a.a(com.baidu.sapi2.utils.c.d(this.b.context));
        hashMap.put("ptpl", this.b.tpl);
        hashMap.put("device_id", a2);
        hashMap.put("device_info", com.baidu.sapi2.utils.c.d());
        hashMap.put("package_sign", this.b.deviceLoginSignKey);
        this.c.post(this.b.context, x(), new RequestParams(hashMap), new j(sapiCallBack));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class j extends HttpResponseHandler {
        final /* synthetic */ SapiCallBack a;

        j(SapiCallBack sapiCallBack) {
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
            this.c.setUserAgent(J());
            HashMap hashMap = new HashMap();
            String a2 = c.a.a(com.baidu.sapi2.utils.c.d(this.b.context));
            hashMap.put("ptpl", this.b.tpl);
            hashMap.put("device_id", a2);
            hashMap.put("device_info", com.baidu.sapi2.utils.c.d());
            hashMap.put("force_reg_token", str);
            this.c.post(this.b.context, y(), new RequestParams(hashMap), new i(sapiCallBack));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i extends HttpResponseHandler {
        final /* synthetic */ SapiCallBack a;

        i(SapiCallBack sapiCallBack) {
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
        this.c.setUserAgent(J());
        HashMap hashMap = new HashMap();
        String a2 = c.a.a(com.baidu.sapi2.utils.c.d(this.b.context));
        hashMap.put("ptpl", this.b.tpl);
        hashMap.put("device_id", a2);
        hashMap.put("device_token", str);
        hashMap.put("package_sign", this.b.deviceLoginSignKey);
        this.c.post(this.b.context, w(), new RequestParams(hashMap), new k(sapiCallBack));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class k extends HttpResponseHandler {
        final /* synthetic */ SapiCallBack a;

        k(SapiCallBack sapiCallBack) {
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
                    sapiAccount.app = SapiUtils.getAppName(this.b.context);
                    if (jSONObject.has("device_token")) {
                        com.baidu.sapi2.c.a(this.b.context).a(jSONObject.getString("device_token"));
                    }
                    com.baidu.sapi2.share.c.a().a(sapiAccount);
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
                    sapiAccount.app = SapiUtils.getAppName(this.b.context);
                    if (jSONObject.has("device_token")) {
                        com.baidu.sapi2.c.a(this.b.context).a(jSONObject.getString("device_token"));
                    }
                    com.baidu.sapi2.share.c.a().a(sapiAccount);
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

    /* JADX INFO: Access modifiers changed from: private */
    public String a(Map<String, String> map, String str) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public String J() {
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
                            sapiAccount.app = SapiUtils.getAppName(this.b.context);
                            sapiAccount.extra = jSONObject.toString();
                            com.baidu.sapi2.share.c.a().a(sapiAccount);
                            fillUsernameCallBack.onSuccess(sapiAccountResponse);
                            break;
                        case SapiErrorCode.USER_IS_NOT_ONLINE /* 160103 */:
                            fillUsernameCallBack.onInvalidBduss();
                            break;
                        case SapiErrorCode.USER_DO_HAVE_NAME /* 160104 */:
                            fillUsernameCallBack.onUserHaveUsername();
                            break;
                        case SapiErrorCode.FILL_UNAME_CANNOT_BE_USE /* 160105 */:
                        case SapiErrorCode.FILL_UNAME_IS_EXIST /* 160111 */:
                            fillUsernameCallBack.onUsernameAlreadyExist();
                            break;
                        case SapiErrorCode.FILL_UNAME_FORMAT_ERROR /* 160110 */:
                            fillUsernameCallBack.onUsernameFormatError();
                            break;
                        default:
                            fillUsernameCallBack.onSystemError(i2);
                            break;
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

    void b(OAuthCallBack oAuthCallBack, String str) {
        oAuthCallBack.onFinish();
        try {
            JSONObject jSONObject = new JSONObject(str);
            int parseInt = Integer.parseInt(jSONObject.optString("errno"));
            switch (parseInt) {
                case 0:
                    OAuthResponse oAuthResponse = new OAuthResponse();
                    oAuthResponse.errorCode = parseInt;
                    oAuthResponse.errorMsg = jSONObject.optString("errmsg");
                    oAuthResponse.accessToken = jSONObject.optString("access_token");
                    oAuthResponse.expiresIn = jSONObject.optInt("expires_in");
                    oAuthResponse.refreshToken = jSONObject.optString("refresh_token");
                    oAuthResponse.sessionKey = jSONObject.optString("session_key");
                    oAuthResponse.sessionSecret = jSONObject.optString("session_secret");
                    oAuthResponse.extra = str;
                    oAuthCallBack.onSuccess(oAuthResponse);
                    break;
                default:
                    oAuthCallBack.onSystemError(parseInt);
                    break;
            }
        } catch (Throwable th) {
            oAuthCallBack.onSystemError(-100);
        }
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
                    return;
                case 0:
                    QrPCLoginResponse qrPCLoginResponse = new QrPCLoginResponse();
                    qrPCLoginResponse.errorCode = parseInt;
                    JSONObject optJSONObject = jSONObject.optJSONObject("local");
                    if (optJSONObject != null) {
                        qrPCLoginResponse.country = optJSONObject.optString("country");
                        qrPCLoginResponse.province = optJSONObject.optString("provice");
                        qrPCLoginResponse.city = optJSONObject.optString("city");
                    }
                    qrPCLoginCallBack.onSuccess(qrPCLoginResponse);
                    return;
                case 2:
                case SapiErrorCode.BDUSS_IS_EMPTY /* 160102 */:
                    qrPCLoginCallBack.onBdussInvalid();
                    return;
                case 3:
                    qrPCLoginCallBack.onUserNotNormalized();
                    return;
                default:
                    qrPCLoginCallBack.onSystemError(parseInt);
                    return;
            }
        } catch (Exception e2) {
            qrPCLoginCallBack.onSystemError(-100);
        }
    }

    void a(int i2, QrAppLoginCallBack qrAppLoginCallBack, String str) {
        if (qrAppLoginCallBack != null) {
            qrAppLoginCallBack.onFinish();
        }
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
                    sapiAccount.app = SapiUtils.getAppName(this.b.context);
                    com.baidu.sapi2.share.c.a().a(sapiAccount);
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

    private Domain K() {
        return this.b.environment;
    }

    private String L() {
        return this.d.a() + "/sslcrypt/get_last_cert";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() {
        return K().getWap() + "/passport/login";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d() {
        return K().getWap() + "/passport/getpass";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String e() {
        return K().getWap() + "/wp/wappassword";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String f() {
        return K().getWap() + "/wp/recordindex";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String g() {
        return K().getWap() + "/v2/?bindingaccount&";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String h() {
        return K().getWap() + "/v2/?bindingret";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(BindWidgetAction bindWidgetAction) {
        return K().getWap() + bindWidgetAction.getUri();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String i() {
        return K().getWap() + "/passport/authwidget";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String j() {
        return K().getWap() + "/wp/unitewidget";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String k() {
        return K().getWap() + "/wp/accountwidget-init";
    }

    String l() {
        return this.d.a() + "/v2/sapi/center/filluname";
    }

    String m() {
        return this.d.a() + "/v2/sapi/center/setportrait";
    }

    String n() {
        return this.d.a() + "/v2/sapi/center/getportrait";
    }

    String o() {
        return this.d.a() + "/v2/sapi/center/getuinfo";
    }

    String p() {
        return this.d.a() + com.baidu.sapi2.utils.e.a;
    }

    public String q() {
        return this.d.a() + "/phoenix/account/ssologin";
    }

    public String r() {
        return this.d.a() + "/phoenix/account/ssologin";
    }

    public String s() {
        return this.d.a() + com.baidu.sapi2.utils.e.h;
    }

    public String t() {
        return this.d.a() + com.baidu.sapi2.utils.e.i;
    }

    public String u() {
        return this.d.a() + com.baidu.sapi2.utils.e.j;
    }

    public String v() {
        return K().getDeviceUrl() + com.baidu.sapi2.utils.e.v;
    }

    public String w() {
        return K().getDeviceUrl() + com.baidu.sapi2.utils.e.x;
    }

    public String x() {
        return K().getDeviceUrl() + com.baidu.sapi2.utils.e.w;
    }

    public String y() {
        return K().getDeviceUrl() + com.baidu.sapi2.utils.e.y;
    }

    public String z() {
        return this.d.a() + com.baidu.sapi2.utils.e.k;
    }

    public String A() {
        return this.d.a() + com.baidu.sapi2.utils.e.l;
    }

    public String B() {
        return this.d.a() + com.baidu.sapi2.utils.e.m;
    }

    public String C() {
        return this.d.a() + com.baidu.sapi2.utils.e.o;
    }

    public String D() {
        return this.d.a() + com.baidu.sapi2.utils.e.z;
    }

    public String E() {
        return this.d.a() + com.baidu.sapi2.utils.e.A;
    }

    public String F() {
        return this.d.a() + com.baidu.sapi2.utils.e.B;
    }

    public String G() {
        return this.d.a() + com.baidu.sapi2.utils.e.C;
    }

    public String H() {
        return this.d.a() + com.baidu.sapi2.utils.e.D;
    }

    public String I() {
        return this.d.a() + com.baidu.sapi2.utils.e.E;
    }
}
