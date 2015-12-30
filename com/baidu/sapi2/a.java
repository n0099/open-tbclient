package com.baidu.sapi2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Xml;
import android.widget.Toast;
import com.baidu.android.common.security.MD5Util;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.BinaryHttpResponseHandler;
import com.baidu.cloudsdk.common.http.HttpResponseHandler;
import com.baidu.cloudsdk.common.http.MultipartRequestParams;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.callback.FillUserProfileCallback;
import com.baidu.sapi2.callback.FillUsernameCallback;
import com.baidu.sapi2.callback.GetHistoryPortraitsCallback;
import com.baidu.sapi2.callback.GetPopularPortraitsCallback;
import com.baidu.sapi2.callback.GetRegCodeCallback;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.callback.LoginCallback;
import com.baidu.sapi2.callback.QrPcLoginCallback;
import com.baidu.sapi2.callback.QuickUserRegCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.callback.SapiCallbackInterceptor;
import com.baidu.sapi2.callback.SetPopularPortraitCallback;
import com.baidu.sapi2.callback.SetPortraitCallback;
import com.baidu.sapi2.callback.VoiceCheckCallback;
import com.baidu.sapi2.callback.VoiceCodeSetCallback;
import com.baidu.sapi2.callback.VoiceLoginCallback;
import com.baidu.sapi2.dto.GetHistoryPortraitsDTO;
import com.baidu.sapi2.dto.LoginDTO;
import com.baidu.sapi2.dto.PhoneRegDTO;
import com.baidu.sapi2.dto.QuickUserRegDTO;
import com.baidu.sapi2.dto.SetPopularPortraitDTO;
import com.baidu.sapi2.dto.VoiceCheckDTO;
import com.baidu.sapi2.dto.VoiceCodeSetDTO;
import com.baidu.sapi2.result.DynamicPwdLoginResult;
import com.baidu.sapi2.result.FastRegResult;
import com.baidu.sapi2.result.FillUserProfileResult;
import com.baidu.sapi2.result.FillUsernameResult;
import com.baidu.sapi2.result.GetCaptchaResult;
import com.baidu.sapi2.result.GetDynamicPwdResult;
import com.baidu.sapi2.result.GetHistoryPortraitsResult;
import com.baidu.sapi2.result.GetPopularPortraitsInfoResult;
import com.baidu.sapi2.result.GetRegCodeResult;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.result.LoginResult;
import com.baidu.sapi2.result.OAuthResult;
import com.baidu.sapi2.result.PhoneRegResult;
import com.baidu.sapi2.result.QrAppLoginResult;
import com.baidu.sapi2.result.QrPcLoginResult;
import com.baidu.sapi2.result.QuickUserRegResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.SetPopularPortraitResult;
import com.baidu.sapi2.result.SetPortraitResult;
import com.baidu.sapi2.result.VoiceCheckResult;
import com.baidu.sapi2.result.VoiceCodeSetResult;
import com.baidu.sapi2.result.VoiceLoginResult;
import com.baidu.sapi2.result.VoiceRegResult;
import com.baidu.sapi2.share.SoftToken;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.sapi2.shell.callback.FillUsernameCallBack;
import com.baidu.sapi2.shell.callback.GetUserInfoCallBack;
import com.baidu.sapi2.shell.callback.QrAppLoginCallBack;
import com.baidu.sapi2.shell.callback.QrPCLoginCallBack;
import com.baidu.sapi2.shell.callback.SapiCallBack;
import com.baidu.sapi2.shell.response.GetPortraitResponse;
import com.baidu.sapi2.shell.response.GetUserInfoResponse;
import com.baidu.sapi2.shell.response.QrAppLoginResponse;
import com.baidu.sapi2.shell.response.QrPCLoginResponse;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SapiResponse;
import com.baidu.sapi2.utils.SapiDataEncryptor;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.a;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.QrLoginAction;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a {
    private static final int a = 6;
    private static final String b = "3";
    private SapiConfiguration c = SapiAccountManager.getInstance().getSapiConfiguration();
    private AsyncHttpClient d;
    private E e;
    private String f;
    private LoginDTO g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class E {
        static List<String> b = new ArrayList();
        static int c;
        Context a;

        private void e() {
            b.clear();
            b.add(com.baidu.sapi2.utils.d.c);
            b.add(com.baidu.sapi2.utils.d.d);
            b.add(com.baidu.sapi2.utils.d.e);
        }

        public E(Context context) {
            this.a = context;
            d();
            e();
        }

        public String a() {
            String url = SapiAccountManager.getInstance().getSapiConfiguration().environment.getURL();
            if (c > 0) {
                if (c > b.size()) {
                    c = 1;
                }
                return b.get(c - 1);
            }
            return url;
        }

        public void b() {
            c++;
        }

        public boolean c() {
            return c >= b.size();
        }

        public void d() {
            c = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        this.e = new E(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.d != null) {
            this.d.cancelRequests(this.c.context, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.c.environment != Domain.DOMAIN_ONLINE && SapiUtils.hasActiveNetwork(this.c.context)) {
            this.d = new AsyncHttpClient();
            this.d.setUserAgent(B());
            this.d.get(this.c.context, this.e.a() + com.baidu.sapi2.utils.d.O, new j());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class j extends HttpResponseHandler {
        j() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            try {
                String optString = new JSONObject(str).optString(SocialConstants.ANDROID_CLIENT_TYPE);
                if (!SapiAccountManager.VERSION_NAME.equals(optString)) {
                    String[] split = optString.split("\\.");
                    String[] split2 = SapiAccountManager.VERSION_NAME.split("\\.");
                    for (int i2 = 0; i2 < 2; i2++) {
                        if (Integer.parseInt(split[i2]) > Integer.parseInt(split2[i2])) {
                            Toast.makeText(a.this.c.context, String.format("检测到Passport SDK新版本%s", optString), 0).show();
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
                com.baidu.sapi2.utils.L.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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
        } else if (this.c == null || this.c.context == null) {
            if (sapiCallBack != null) {
                sapiCallBack.onSystemError(-100);
            }
        } else if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            if (sapiCallBack != null) {
                sapiCallBack.onNetworkFailed();
            }
        } else {
            SapiDataEncryptor sapiDataEncryptor = new SapiDataEncryptor();
            try {
                this.d = new AsyncHttpClient();
                this.d.setUserAgent(B());
                HashMap hashMap = new HashMap();
                hashMap.put("crypttype", "11");
                hashMap.put("tpl", this.c.tpl);
                hashMap.put("appid", this.c.appId);
                if (TextUtils.isEmpty(this.c.clientId)) {
                    this.c.clientId = SapiUtils.getClientId(this.c.context);
                }
                hashMap.put(SocialConstants.PARAM_CUID, this.c.clientId);
                hashMap.put("cert_id", String.valueOf(2));
                hashMap.put("isdpass", "0");
                hashMap.put("username", reloginCredentials.account);
                hashMap.put("password", reloginCredentials.password);
                hashMap.put("UBI", reloginCredentials.ubi);
                hashMap.put("isphone", "3".equals(reloginCredentials.accountType) ? "1" : "0");
                hashMap.put(LoginActivityConfig.LOGIN_TYPE, "3");
                hashMap.put("key", sapiDataEncryptor.a());
                hashMap.put("sdk_version", "2");
                hashMap.put("pinfo", com.baidu.sapi2.utils.a.b());
                hashMap.put("sig", a(hashMap, this.c.appSignKey));
                this.d.post(this.c.context, v(), new RequestParams(hashMap), new c(sapiCallBack, reloginCredentials));
            } catch (Exception e2) {
                d(-100, sapiCallBack, null);
                com.baidu.sapi2.utils.L.e(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends HttpResponseHandler {
        final /* synthetic */ SapiCallBack a;
        final /* synthetic */ SapiAccount.ReloginCredentials b;

        c(SapiCallBack sapiCallBack, SapiAccount.ReloginCredentials reloginCredentials) {
            this.a = sapiCallBack;
            this.b = reloginCredentials;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            a.this.e.d();
            a.this.d(a.this.b(str), this.a, str);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (a.this.e.c()) {
                a.this.e.d();
                a.this.d(a.this.b(str), this.a, str);
                return;
            }
            a.this.e.b();
            a.this.a(this.a, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            return SapiErrorCode.NETWORK_FAILED;
        }
        SapiDataEncryptor sapiDataEncryptor = new SapiDataEncryptor();
        try {
            this.d = new AsyncHttpClient();
            this.d.setUserAgent(B());
            HashMap hashMap = new HashMap();
            hashMap.put("crypttype", "11");
            hashMap.put("tpl", this.c.tpl);
            hashMap.put("appid", this.c.appId);
            if (TextUtils.isEmpty(this.c.clientId)) {
                this.c.clientId = SapiUtils.getClientId(this.c.context);
            }
            hashMap.put(SocialConstants.PARAM_CUID, this.c.clientId);
            hashMap.put("cert_id", "2");
            hashMap.put("isdpass", "0");
            hashMap.put("username", reloginCredentials.account);
            hashMap.put("password", reloginCredentials.password);
            hashMap.put("UBI", reloginCredentials.ubi);
            hashMap.put("isphone", "3".equals(reloginCredentials.accountType) ? "1" : "0");
            hashMap.put(LoginActivityConfig.LOGIN_TYPE, "3");
            hashMap.put("key", sapiDataEncryptor.a());
            hashMap.put("sdk_version", "2");
            hashMap.put("pinfo", com.baidu.sapi2.utils.a.b());
            hashMap.put("sig", a(hashMap, this.c.appSignKey));
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                arrayList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            HttpUriRequest httpPost = new HttpPost(v());
            httpPost.setEntity(new UrlEncodedFormEntity(arrayList, "UTF-8"));
            HttpResponse execute = this.d.execute(httpPost);
            if (200 == execute.getStatusLine().getStatusCode()) {
                String entityUtils = EntityUtils.toString(execute.getEntity());
                if (!TextUtils.isEmpty(entityUtils)) {
                    int b2 = b(entityUtils);
                    if (b2 == 0) {
                        com.baidu.sapi2.share.b.a().a(a(new JSONObject(entityUtils)));
                        return b2;
                    }
                    return b2;
                }
            }
        } catch (Throwable th) {
            com.baidu.sapi2.utils.L.e(th);
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
                sapiAccountResponse.uid = jSONObject.optString("uid");
                sapiAccountResponse.email = jSONObject.optString("email");
                sapiAccountResponse.bduss = jSONObject.optString("bduss");
                sapiAccountResponse.ptoken = jSONObject.optString(SapiAccountManager.SESSION_PTOKEN);
                sapiAccountResponse.stoken = jSONObject.optString(SapiAccountManager.SESSION_STOKEN);
                sapiAccountResponse.authSid = jSONObject.optString("authsid");
                if (sapiCallBack != null) {
                    switch (i2) {
                        case 0:
                            SapiAccount a2 = a(sapiAccountResponse);
                            a2.extra = str;
                            com.baidu.sapi2.share.b.a().a(a2);
                            sapiCallBack.onSuccess(sapiAccountResponse);
                            break;
                        default:
                            sapiCallBack.onSystemError(i2);
                            break;
                    }
                }
            } catch (Exception e2) {
                com.baidu.sapi2.utils.L.e(e2);
                if (sapiCallBack != null) {
                    sapiCallBack.onSystemError(-100);
                }
            }
        } else if (sapiCallBack != null) {
            sapiCallBack.onSystemError(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(LoginCallback loginCallback, LoginDTO loginDTO) {
        if (loginCallback == null) {
            throw new IllegalArgumentException(LoginCallback.class.getSimpleName() + " can't be null");
        }
        if (loginDTO == null) {
            throw new IllegalArgumentException(LoginDTO.class.getSimpleName() + " can't be null");
        }
        LoginResult loginResult = new LoginResult();
        if (TextUtils.isEmpty(loginDTO.account)) {
            loginResult.setResultCode(-101);
            loginCallback.onFailure(loginResult);
        } else if (TextUtils.isEmpty(loginDTO.password)) {
            loginResult.setResultCode(-102);
            loginCallback.onFailure(loginResult);
        } else if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            loginResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            loginCallback.onFailure(loginResult);
        } else {
            this.d = new AsyncHttpClient();
            this.d.setUserAgent(B());
            Map<String, String> a2 = a(com.baidu.sapi2.utils.d.a);
            a2.put("crypttype", String.valueOf(6));
            a2.put("cert_id", String.valueOf(1));
            if (!TextUtils.isEmpty(this.f) && !TextUtils.isEmpty(loginDTO.captcha)) {
                a2.put("verifycode", loginDTO.captcha);
                a2.put("vcodestr", this.f);
            }
            if (this.c.quickUserEnabled) {
                a2.put("quick_user", "1");
            }
            if (loginDTO.loginType == null || loginDTO.loginType == LoginDTO.LoginType.MERGE) {
                a2.put("loginmerge", "true");
            }
            if (loginDTO.loginType == LoginDTO.LoginType.USERNAME) {
                a2.put("isphone", "0");
            }
            if (loginDTO.loginType == LoginDTO.LoginType.PHONE) {
                a2.put("isphone", "1");
            }
            SapiDataEncryptor sapiDataEncryptor = new SapiDataEncryptor();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("username", loginDTO.account);
                jSONObject.put("password", loginDTO.password);
                jSONObject.put(LoginActivityConfig.LOGIN_TYPE, "3");
                jSONObject.put("key", sapiDataEncryptor.a());
                a2.put("userinfo", sapiDataEncryptor.a(SapiDataEncryptor.b.b, jSONObject.toString()));
                a2.put("sig", a(a2, this.c.appSignKey));
                this.d.post(this.c.context, v(), new RequestParams(a2), new b(loginCallback, loginResult, sapiDataEncryptor, loginDTO));
            } catch (Exception e2) {
                loginResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                loginCallback.onFailure(loginResult);
                com.baidu.sapi2.utils.L.e(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends HttpResponseHandler {
        final /* synthetic */ LoginCallback a;
        final /* synthetic */ LoginResult b;
        final /* synthetic */ SapiDataEncryptor c;
        final /* synthetic */ LoginDTO d;

        b(LoginCallback loginCallback, LoginResult loginResult, SapiDataEncryptor sapiDataEncryptor, LoginDTO loginDTO) {
            this.a = loginCallback;
            this.b = loginResult;
            this.c = sapiDataEncryptor;
            this.d = loginDTO;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        protected void onStart() {
            this.a.onStart();
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        protected void onFinish() {
            this.a.onFinish();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            a.this.e.d();
            int b = a.this.b(str);
            this.b.setResultCode(b);
            try {
                JSONObject jSONObject = new JSONObject(this.c.a(new JSONObject(str).optString("userinfo")));
                JSONObject optJSONObject = jSONObject.optJSONObject("sdk");
                this.b.setResultMsg(optJSONObject.optString(AddFriendActivityConfig.MSG));
                SapiResult.Action action = new SapiResult.Action();
                action.actionMode = SapiResult.ActionMode.fromString(optJSONObject.optString("action"));
                action.actionType = SapiResult.ActionType.fromString(optJSONObject.optString("type"));
                action.actionTitle = optJSONObject.optString("title");
                action.actionUrl = optJSONObject.optString("url");
                this.b.action = action;
                if (jSONObject.optInt("needvcode") == 1) {
                    a.this.f = jSONObject.optString("vcodestr");
                    this.a.onCaptchaRequired(this.b);
                }
                switch (action.actionMode) {
                    case URL:
                        a.this.g = this.d;
                        this.a.onProxyActionRequired(this.b);
                        return;
                    case MSG:
                        if (b == 0) {
                            SapiAccount a = a.this.a(jSONObject);
                            SapiAccount.ReloginCredentials reloginCredentials = new SapiAccount.ReloginCredentials();
                            reloginCredentials.account = this.d.account;
                            reloginCredentials.accountType = jSONObject.optString("logintype");
                            reloginCredentials.password = SapiDataEncryptor.encryptPwd(this.d.password);
                            reloginCredentials.ubi = jSONObject.optString("ubi");
                            com.baidu.sapi2.d.a(a.this.c.context).a(a.uid, reloginCredentials);
                            com.baidu.sapi2.share.b.a().a(a);
                            this.a.onSuccess(this.b);
                            return;
                        } else if (b == 18) {
                            this.a.onLoginTypeConflict(this.b);
                            return;
                        } else {
                            this.a.onFailure(this.b);
                            return;
                        }
                    default:
                        this.a.onFailure(this.b);
                        return;
                }
            } catch (Exception e) {
                this.a.onFailure(this.b);
                com.baidu.sapi2.utils.L.e(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (a.this.e.c()) {
                a.this.e.d();
                this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.a.onFailure(this.b);
                return;
            }
            a.this.e.b();
            a.this.a(this.a, this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SapiCallback<LoginResult> sapiCallback, String str) {
        LoginResult loginResult = new LoginResult();
        if (TextUtils.isEmpty(str)) {
            loginResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
            sapiCallback.onFailure(loginResult);
        } else if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            loginResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            sapiCallback.onFailure(loginResult);
        } else {
            this.d = new AsyncHttpClient();
            this.d.setUserAgent(B());
            this.d.get(this.c.context, str, new e(sapiCallback, loginResult));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends HttpResponseHandler {
        final /* synthetic */ SapiCallback a;
        final /* synthetic */ LoginResult b;

        e(SapiCallback sapiCallback, LoginResult loginResult) {
            this.a = sapiCallback;
            this.b = loginResult;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        protected void onStart() {
            this.a.onStart();
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        protected void onFinish() {
            this.a.onFinish();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject optJSONObject = jSONObject.optJSONObject("errInfo");
                int optInt = optJSONObject.optInt("no", SapiResult.ERROR_CODE_UNKNOWN);
                this.b.setResultCode(optInt);
                this.b.setResultMsg(optJSONObject.optString(AddFriendActivityConfig.MSG));
                switch (optInt) {
                    case 0:
                        this.b.setResultMsg("登录成功");
                        String optString = jSONObject.optJSONObject("data").optString("xml");
                        SapiAccount sapiAccount = new SapiAccount();
                        sapiAccount.app = SapiUtils.getAppName(a.this.c.context);
                        SapiAccount.ReloginCredentials reloginCredentials = new SapiAccount.ReloginCredentials();
                        reloginCredentials.account = a.this.g.account;
                        reloginCredentials.password = SapiDataEncryptor.encryptPwd(a.this.g.password);
                        XmlPullParser newPullParser = Xml.newPullParser();
                        newPullParser.setInput(new ByteArrayInputStream(optString.getBytes()), "UTF-8");
                        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                            switch (eventType) {
                                case 2:
                                    String name = newPullParser.getName();
                                    if (name.equalsIgnoreCase("uname")) {
                                        sapiAccount.username = newPullParser.nextText();
                                        break;
                                    } else if (name.equalsIgnoreCase(SapiAccountManager.SESSION_DISPLAYNAME)) {
                                        sapiAccount.displayname = newPullParser.nextText();
                                        break;
                                    } else if (name.equalsIgnoreCase("uid")) {
                                        sapiAccount.uid = newPullParser.nextText();
                                        break;
                                    } else if (name.equalsIgnoreCase("bduss")) {
                                        sapiAccount.bduss = newPullParser.nextText();
                                        break;
                                    } else if (name.equalsIgnoreCase(SapiAccountManager.SESSION_PTOKEN)) {
                                        sapiAccount.ptoken = newPullParser.nextText();
                                        break;
                                    } else if (name.equalsIgnoreCase(SapiAccountManager.SESSION_STOKEN)) {
                                        sapiAccount.stoken = newPullParser.nextText();
                                        break;
                                    } else if (name.equalsIgnoreCase("ubi")) {
                                        reloginCredentials.ubi = newPullParser.nextText();
                                        break;
                                    } else if (name.equalsIgnoreCase("accounttype")) {
                                        reloginCredentials.accountType = newPullParser.nextText();
                                        break;
                                    } else {
                                        break;
                                    }
                            }
                        }
                        com.baidu.sapi2.d.a(a.this.c.context).a(sapiAccount.uid, reloginCredentials);
                        com.baidu.sapi2.share.b.a().a(sapiAccount);
                        this.a.onSuccess(this.b);
                        return;
                    default:
                        this.a.onFailure(this.b);
                        return;
                }
            } catch (Exception e) {
                this.a.onFailure(this.b);
                com.baidu.sapi2.utils.L.e(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
            this.a.onFailure(this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SapiCallback<GetCaptchaResult> sapiCallback) {
        if (sapiCallback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        }
        if (TextUtils.isEmpty(this.f)) {
            throw new IllegalArgumentException("captchaKey can't be empty");
        }
        GetCaptchaResult getCaptchaResult = new GetCaptchaResult();
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            getCaptchaResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            sapiCallback.onFailure(getCaptchaResult);
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(B());
        this.d.get(this.c.context, this.e.a() + com.baidu.sapi2.utils.d.f + this.f, new d(new String[]{"image/png", "image/jpeg", "image/jpg", "image/gif"}, sapiCallback, getCaptchaResult));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends BinaryHttpResponseHandler {
        final /* synthetic */ SapiCallback a;
        final /* synthetic */ GetCaptchaResult b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String[] strArr, SapiCallback sapiCallback, GetCaptchaResult getCaptchaResult) {
            super(strArr);
            this.a = sapiCallback;
            this.b = getCaptchaResult;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        protected void onStart() {
            this.a.onStart();
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        protected void onFinish() {
            this.a.onFinish();
        }

        @Override // com.baidu.cloudsdk.common.http.BinaryHttpResponseHandler
        protected void onSuccess(byte[] bArr) {
            a.this.e.d();
            if (bArr != null) {
                this.b.setResultCode(0);
                this.b.captchaImage = bArr;
                this.a.onSuccess(this.b);
                return;
            }
            this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
            this.a.onFailure(this.b);
        }

        @Override // com.baidu.cloudsdk.common.http.BinaryHttpResponseHandler
        protected void onFailure(Throwable th, byte[] bArr) {
            if (a.this.e.c()) {
                a.this.e.d();
                this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.a.onFailure(this.b);
                return;
            }
            a.this.e.b();
            a.this.a(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(GetRegCodeCallback getRegCodeCallback, String str) {
        if (getRegCodeCallback == null) {
            throw new IllegalArgumentException(GetRegCodeCallback.class.getSimpleName() + " can't be null");
        }
        GetRegCodeResult getRegCodeResult = new GetRegCodeResult();
        if (TextUtils.isEmpty(str)) {
            getRegCodeResult.setResultCode(-101);
            getRegCodeCallback.onFailure(getRegCodeResult);
        } else if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            getRegCodeResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            getRegCodeCallback.onFailure(getRegCodeResult);
        } else {
            this.d = new AsyncHttpClient();
            this.d.setUserAgent(B());
            Map<String, String> a2 = a(com.baidu.sapi2.utils.d.g);
            a2.put("phonenum", str);
            a2.put("sig", a(a2, this.c.appSignKey));
            this.d.post(this.c.context, this.e.a() + com.baidu.sapi2.utils.d.g, new RequestParams(a2), new g(getRegCodeCallback, getRegCodeResult, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends HttpResponseHandler {
        final /* synthetic */ GetRegCodeCallback a;
        final /* synthetic */ GetRegCodeResult b;
        final /* synthetic */ String c;

        g(GetRegCodeCallback getRegCodeCallback, GetRegCodeResult getRegCodeResult, String str) {
            this.a = getRegCodeCallback;
            this.b = getRegCodeResult;
            this.c = str;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        protected void onStart() {
            this.a.onStart();
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        protected void onFinish() {
            this.a.onFinish();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            a.this.e.d();
            int b = a.this.b(str);
            this.b.setResultCode(b);
            try {
                this.b.setResultMsg(new JSONObject(str).optJSONObject("sdk").optString(AddFriendActivityConfig.MSG));
                switch (b) {
                    case 0:
                        this.a.onSuccess(this.b);
                        break;
                    case 8:
                        this.a.onPhoneNumberExist(this.b);
                        break;
                    default:
                        this.a.onFailure(this.b);
                        break;
                }
            } catch (Exception e) {
                this.a.onFailure(this.b);
                com.baidu.sapi2.utils.L.e(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (a.this.e.c()) {
                a.this.e.d();
                this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.a.onFailure(this.b);
                return;
            }
            a.this.e.b();
            a.this.a(this.a, this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SapiCallback<PhoneRegResult> sapiCallback, PhoneRegDTO phoneRegDTO) {
        if (sapiCallback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        }
        if (phoneRegDTO == null) {
            throw new IllegalArgumentException(PhoneRegDTO.class.getSimpleName() + " can't be null");
        }
        PhoneRegResult phoneRegResult = new PhoneRegResult();
        if (TextUtils.isEmpty(phoneRegDTO.phoneNumber)) {
            phoneRegResult.setResultCode(-101);
            sapiCallback.onFailure(phoneRegResult);
        } else if (TextUtils.isEmpty(phoneRegDTO.password) && !phoneRegDTO.noPwd) {
            phoneRegResult.setResultCode(-102);
            sapiCallback.onFailure(phoneRegResult);
        } else if (TextUtils.isEmpty(phoneRegDTO.regCode)) {
            phoneRegResult.setResultCode(-103);
            sapiCallback.onFailure(phoneRegResult);
        } else if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            phoneRegResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            sapiCallback.onFailure(phoneRegResult);
        } else {
            this.d = new AsyncHttpClient();
            this.d.setUserAgent(B());
            Map<String, String> a2 = a(com.baidu.sapi2.utils.d.h);
            a2.put("crypttype", String.valueOf(6));
            a2.put("cert_id", String.valueOf(1));
            SapiDataEncryptor sapiDataEncryptor = new SapiDataEncryptor();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("phonenum", phoneRegDTO.phoneNumber);
                if (!phoneRegDTO.noPwd) {
                    jSONObject.put("passwd", phoneRegDTO.password);
                }
                jSONObject.put("smscode", phoneRegDTO.regCode);
                jSONObject.put("key", sapiDataEncryptor.a());
                a2.put("userinfo", sapiDataEncryptor.a(SapiDataEncryptor.b.b, jSONObject.toString()));
                a2.put("nopsw", phoneRegDTO.noPwd ? "1" : "0");
                a2.put("sig", a(a2, this.c.appSignKey));
                this.d.post(this.c.context, this.e.a() + com.baidu.sapi2.utils.d.h, new RequestParams(a2), new f(sapiCallback, phoneRegResult, sapiDataEncryptor, phoneRegDTO));
            } catch (Exception e2) {
                phoneRegResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                sapiCallback.onFailure(phoneRegResult);
                com.baidu.sapi2.utils.L.e(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends HttpResponseHandler {
        final /* synthetic */ SapiCallback a;
        final /* synthetic */ PhoneRegResult b;
        final /* synthetic */ SapiDataEncryptor c;
        final /* synthetic */ PhoneRegDTO d;

        f(SapiCallback sapiCallback, PhoneRegResult phoneRegResult, SapiDataEncryptor sapiDataEncryptor, PhoneRegDTO phoneRegDTO) {
            this.a = sapiCallback;
            this.b = phoneRegResult;
            this.c = sapiDataEncryptor;
            this.d = phoneRegDTO;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        protected void onStart() {
            this.a.onStart();
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        protected void onFinish() {
            this.a.onFinish();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            a.this.e.d();
            int b = a.this.b(str);
            this.b.setResultCode(b);
            try {
                JSONObject jSONObject = new JSONObject(this.c.a(new JSONObject(str).optString("userinfo")));
                this.b.setResultMsg(jSONObject.optJSONObject("sdk").optString(AddFriendActivityConfig.MSG));
                switch (b) {
                    case 0:
                        SapiAccount a = a.this.a(jSONObject);
                        SapiAccount.ReloginCredentials reloginCredentials = new SapiAccount.ReloginCredentials();
                        reloginCredentials.account = this.d.phoneNumber;
                        reloginCredentials.accountType = jSONObject.optString("logintype");
                        reloginCredentials.password = SapiDataEncryptor.encryptPwd(this.d.password);
                        reloginCredentials.ubi = jSONObject.optString("ubi");
                        com.baidu.sapi2.d.a(a.this.c.context).a(a.uid, reloginCredentials);
                        com.baidu.sapi2.share.b.a().a(a);
                        this.a.onSuccess(this.b);
                        break;
                    default:
                        this.a.onFailure(this.b);
                        break;
                }
            } catch (Exception e) {
                this.a.onFailure(this.b);
                com.baidu.sapi2.utils.L.e(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (a.this.e.c()) {
                a.this.e.d();
                this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.a.onFailure(this.b);
                return;
            }
            a.this.e.b();
            a.this.a(this.a, this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(QuickUserRegCallback quickUserRegCallback, QuickUserRegDTO quickUserRegDTO) {
        if (!this.c.quickUserEnabled) {
            throw new IllegalStateException("quick user not enabled");
        }
        if (quickUserRegCallback == null) {
            throw new IllegalArgumentException(QuickUserRegCallback.class.getSimpleName() + " can't be null");
        }
        if (quickUserRegDTO == null) {
            throw new IllegalArgumentException(QuickUserRegDTO.class.getSimpleName() + " can't be null");
        }
        QuickUserRegResult quickUserRegResult = new QuickUserRegResult();
        if (TextUtils.isEmpty(quickUserRegDTO.username)) {
            quickUserRegResult.setResultCode(-101);
            quickUserRegCallback.onFailure(quickUserRegResult);
        } else if (TextUtils.isEmpty(quickUserRegDTO.password)) {
            quickUserRegResult.setResultCode(-102);
            quickUserRegCallback.onFailure(quickUserRegResult);
        } else if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            quickUserRegResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            quickUserRegCallback.onFailure(quickUserRegResult);
        } else {
            this.d = new AsyncHttpClient();
            this.d.setUserAgent(B());
            Map<String, String> a2 = a(com.baidu.sapi2.utils.d.i);
            a2.put("crypttype", String.valueOf(6));
            a2.put("cert_id", String.valueOf(1));
            if (!TextUtils.isEmpty(this.f) && !TextUtils.isEmpty(quickUserRegDTO.captcha)) {
                a2.put("verifycode", quickUserRegDTO.captcha);
                a2.put("vcodestr", this.f);
            }
            SapiDataEncryptor sapiDataEncryptor = new SapiDataEncryptor();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("username", quickUserRegDTO.username);
                jSONObject.put("loginpass", quickUserRegDTO.password);
                jSONObject.put("key", sapiDataEncryptor.a());
                a2.put("userinfo", sapiDataEncryptor.a(SapiDataEncryptor.b.b, jSONObject.toString()));
                a2.put("sig", a(a2, this.c.appSignKey));
                this.d.post(this.c.context, this.e.a() + com.baidu.sapi2.utils.d.i, new RequestParams(a2), new i(quickUserRegCallback, quickUserRegResult, sapiDataEncryptor, quickUserRegDTO));
            } catch (Exception e2) {
                quickUserRegResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                quickUserRegCallback.onFailure(quickUserRegResult);
                com.baidu.sapi2.utils.L.e(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i extends HttpResponseHandler {
        final /* synthetic */ QuickUserRegCallback a;
        final /* synthetic */ QuickUserRegResult b;
        final /* synthetic */ SapiDataEncryptor c;
        final /* synthetic */ QuickUserRegDTO d;

        i(QuickUserRegCallback quickUserRegCallback, QuickUserRegResult quickUserRegResult, SapiDataEncryptor sapiDataEncryptor, QuickUserRegDTO quickUserRegDTO) {
            this.a = quickUserRegCallback;
            this.b = quickUserRegResult;
            this.c = sapiDataEncryptor;
            this.d = quickUserRegDTO;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        protected void onStart() {
            this.a.onStart();
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        protected void onFinish() {
            this.a.onFinish();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            a.this.e.d();
            int b = a.this.b(str);
            this.b.setResultCode(b);
            try {
                JSONObject jSONObject = new JSONObject(this.c.a(new JSONObject(str).optString("userinfo")));
                this.b.setResultMsg(jSONObject.optJSONObject("sdk").optString(AddFriendActivityConfig.MSG));
                if (jSONObject.optInt("needvcode") == 1) {
                    a.this.f = jSONObject.optString("vcodestr");
                    this.a.onCaptchaRequired(this.b);
                }
                switch (b) {
                    case 0:
                        SapiAccount a = a.this.a(jSONObject);
                        SapiAccount.ReloginCredentials reloginCredentials = new SapiAccount.ReloginCredentials();
                        reloginCredentials.account = this.d.username;
                        reloginCredentials.accountType = jSONObject.optString("logintype");
                        reloginCredentials.password = SapiDataEncryptor.encryptPwd(this.d.password);
                        reloginCredentials.ubi = jSONObject.optString("ubi");
                        com.baidu.sapi2.d.a(a.this.c.context).a(a.uid, reloginCredentials);
                        com.baidu.sapi2.share.b.a().a(a);
                        this.a.onSuccess(this.b);
                        return;
                    case 5:
                        JSONArray optJSONArray = jSONObject.optJSONArray("suggnames");
                        if (optJSONArray != null) {
                            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                this.b.sugUsernameList.add(optJSONArray.optString(i2));
                            }
                        }
                        this.a.onUsernameExist(this.b);
                        return;
                    default:
                        this.a.onFailure(this.b);
                        return;
                }
            } catch (Exception e) {
                this.a.onFailure(this.b);
                com.baidu.sapi2.utils.L.e(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (a.this.e.c()) {
                a.this.e.d();
                this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.a.onFailure(this.b);
                return;
            }
            a.this.e.b();
            a.this.a(this.a, this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(SapiCallback<GetDynamicPwdResult> sapiCallback, String str) {
        if (sapiCallback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        }
        GetDynamicPwdResult getDynamicPwdResult = new GetDynamicPwdResult();
        if (TextUtils.isEmpty(str)) {
            getDynamicPwdResult.setResultCode(-101);
            sapiCallback.onFailure(getDynamicPwdResult);
        } else if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            getDynamicPwdResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            sapiCallback.onFailure(getDynamicPwdResult);
        } else {
            this.d = new AsyncHttpClient();
            this.d.setUserAgent(B());
            Map<String, String> a2 = a(com.baidu.sapi2.utils.d.t);
            a2.put("username", str);
            a2.put("sig", a(a2, this.c.appSignKey));
            this.d.post(this.c.context, this.e.a() + com.baidu.sapi2.utils.d.t, new RequestParams(a2), new h(sapiCallback, getDynamicPwdResult, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends HttpResponseHandler {
        final /* synthetic */ SapiCallback a;
        final /* synthetic */ GetDynamicPwdResult b;
        final /* synthetic */ String c;

        h(SapiCallback sapiCallback, GetDynamicPwdResult getDynamicPwdResult, String str) {
            this.a = sapiCallback;
            this.b = getDynamicPwdResult;
            this.c = str;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        protected void onStart() {
            this.a.onStart();
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        protected void onFinish() {
            this.a.onFinish();
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            a.this.e.d();
            int b = a.this.b(str);
            this.b.setResultCode(b);
            try {
                this.b.setResultMsg(new JSONObject(str).optJSONObject("sdk").optString(AddFriendActivityConfig.MSG));
                switch (b) {
                    case 0:
                        this.a.onSuccess(this.b);
                        break;
                    default:
                        this.a.onFailure(this.b);
                        break;
                }
            } catch (Exception e) {
                this.a.onFailure(this.b);
                com.baidu.sapi2.utils.L.e(e);
            }
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (a.this.e.c()) {
                a.this.e.d();
                this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.a.onFailure(this.b);
                return;
            }
            a.this.e.b();
            a.this.b(this.a, this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SapiCallback<DynamicPwdLoginResult> sapiCallback, String str, String str2) {
        if (sapiCallback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        }
        DynamicPwdLoginResult dynamicPwdLoginResult = new DynamicPwdLoginResult();
        if (TextUtils.isEmpty(str)) {
            dynamicPwdLoginResult.setResultCode(-101);
            sapiCallback.onFailure(dynamicPwdLoginResult);
        } else if (TextUtils.isEmpty(str2)) {
            dynamicPwdLoginResult.setResultCode(-102);
            sapiCallback.onFailure(dynamicPwdLoginResult);
        } else if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            dynamicPwdLoginResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            sapiCallback.onFailure(dynamicPwdLoginResult);
        } else {
            this.d = new AsyncHttpClient();
            this.d.setUserAgent(B());
            Map<String, String> a2 = a(com.baidu.sapi2.utils.d.a);
            a2.put("crypttype", String.valueOf(6));
            a2.put("cert_id", String.valueOf(1));
            a2.put("isphone", "1");
            a2.put("isdpass", "1");
            SapiDataEncryptor sapiDataEncryptor = new SapiDataEncryptor();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("username", str);
                jSONObject.put("password", str2);
                jSONObject.put(LoginActivityConfig.LOGIN_TYPE, "3");
                jSONObject.put("key", sapiDataEncryptor.a());
                a2.put("userinfo", sapiDataEncryptor.a(SapiDataEncryptor.b.b, jSONObject.toString()));
                a2.put("sig", a(a2, this.c.appSignKey));
                this.d.post(this.c.context, v(), new RequestParams(a2), new m(sapiCallback, dynamicPwdLoginResult, sapiDataEncryptor, str, str2));
            } catch (Exception e2) {
                dynamicPwdLoginResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                sapiCallback.onFailure(dynamicPwdLoginResult);
                com.baidu.sapi2.utils.L.e(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class m extends HttpResponseHandler {
        final /* synthetic */ SapiCallback a;
        final /* synthetic */ DynamicPwdLoginResult b;
        final /* synthetic */ SapiDataEncryptor c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        m(SapiCallback sapiCallback, DynamicPwdLoginResult dynamicPwdLoginResult, SapiDataEncryptor sapiDataEncryptor, String str, String str2) {
            this.a = sapiCallback;
            this.b = dynamicPwdLoginResult;
            this.c = sapiDataEncryptor;
            this.d = str;
            this.e = str2;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        protected void onStart() {
            this.a.onStart();
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        protected void onFinish() {
            this.a.onFinish();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            a.this.e.d();
            int b = a.this.b(str);
            this.b.setResultCode(b);
            try {
                JSONObject jSONObject = new JSONObject(this.c.a(new JSONObject(str).optString("userinfo")));
                this.b.setResultMsg(jSONObject.optJSONObject("sdk").optString(AddFriendActivityConfig.MSG));
                switch (b) {
                    case 0:
                        SapiAccount a = a.this.a(jSONObject);
                        if (this.a instanceof SapiCallbackInterceptor) {
                            this.b.session = a;
                            ((SapiCallbackInterceptor) this.a).beforeSuccess(this.b);
                        }
                        com.baidu.sapi2.share.b.a().a(a);
                        this.a.onSuccess(this.b);
                        return;
                    default:
                        this.a.onFailure(this.b);
                        return;
                }
            } catch (Exception e) {
                this.a.onFailure(this.b);
                com.baidu.sapi2.utils.L.e(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (a.this.e.c()) {
                a.this.e.d();
                this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.a.onFailure(this.b);
                return;
            }
            a.this.e.b();
            a.this.a(this.a, this.d, this.e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(SapiCallBack<SapiAccountResponse> sapiCallBack, String str, String str2, boolean z2) {
        if (this.c == null || this.c.context == null) {
            return false;
        }
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            if (sapiCallBack != null) {
                sapiCallBack.onNetworkFailed();
            }
            return true;
        }
        SapiDataEncryptor sapiDataEncryptor = new SapiDataEncryptor();
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(B());
        this.d.get(this.c.context, D(), new o(sapiCallBack, z2, sapiDataEncryptor, str, str2));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class o extends HttpResponseHandler {
        final /* synthetic */ SapiCallBack a;
        final /* synthetic */ boolean b;
        final /* synthetic */ SapiDataEncryptor c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        o(SapiCallBack sapiCallBack, boolean z, SapiDataEncryptor sapiDataEncryptor, String str, String str2) {
            this.a = sapiCallBack;
            this.b = z;
            this.c = sapiDataEncryptor;
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
                com.baidu.sapi2.utils.L.e(e);
            }
            if (a.this.e.c()) {
                a.this.e.d();
                a.this.a(-100, this.a, str2, this.b, this.c);
                return;
            }
            a.this.e.b();
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
                com.baidu.sapi2.utils.L.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SapiCallBack<SapiAccountResponse> sapiCallBack, String str, String str2, String str3, String str4, boolean z2, SapiDataEncryptor sapiDataEncryptor) {
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(B());
        HashMap hashMap = new HashMap();
        hashMap.put("crypttype", "6");
        hashMap.put("tpl", this.c.tpl);
        hashMap.put("appid", this.c.appId);
        String str5 = this.c.clientId;
        if (!TextUtils.isEmpty(str5)) {
            hashMap.put(SocialConstants.PARAM_CUID, str5);
        }
        hashMap.put("cert_id", str2);
        hashMap.put("isdpass", "1");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("username", str3);
        jSONObject.put("isphone", "1");
        jSONObject.put("password", str4);
        jSONObject.put(LoginActivityConfig.LOGIN_TYPE, "3");
        jSONObject.put("key", sapiDataEncryptor.a());
        jSONObject.put("sdk_version", "2");
        jSONObject.put("pinfo", com.baidu.sapi2.utils.a.b());
        hashMap.put("userinfo", sapiDataEncryptor.a(str, jSONObject.toString()));
        hashMap.put("sig", a(hashMap, this.c.appSignKey));
        this.d.post(this.c.context, v(), new RequestParams(hashMap), new n(sapiCallBack, z2, sapiDataEncryptor, str3, str4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class n extends HttpResponseHandler {
        final /* synthetic */ SapiCallBack a;
        final /* synthetic */ boolean b;
        final /* synthetic */ SapiDataEncryptor c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        n(SapiCallBack sapiCallBack, boolean z, SapiDataEncryptor sapiDataEncryptor, String str, String str2) {
            this.a = sapiCallBack;
            this.b = z;
            this.c = sapiDataEncryptor;
            this.d = str;
            this.e = str2;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
            a.this.a(a.this.b(str), this.a, str, this.b, this.c);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
            if (a.this.e.c()) {
                a.this.e.d();
                a.this.a(a.this.b(str), this.a, str, this.b, this.c);
                return;
            }
            a.this.e.b();
            a.this.a(this.a, this.d, this.e, this.b);
        }
    }

    void a(int i2, SapiCallBack<SapiAccountResponse> sapiCallBack, String str, boolean z2, SapiDataEncryptor sapiDataEncryptor) {
        if (str != null) {
            SapiAccountResponse sapiAccountResponse = new SapiAccountResponse();
            try {
                String optString = new JSONObject(str).optString("userinfo");
                String str2 = "";
                if (!TextUtils.isEmpty(optString)) {
                    str2 = sapiDataEncryptor.a(optString);
                    JSONObject jSONObject = new JSONObject(str2);
                    sapiAccountResponse.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                    sapiAccountResponse.username = jSONObject.optString("uname");
                    sapiAccountResponse.uid = jSONObject.optString("uid");
                    sapiAccountResponse.email = jSONObject.optString("email");
                    sapiAccountResponse.bduss = jSONObject.optString("bduss");
                    sapiAccountResponse.ptoken = jSONObject.optString(SapiAccountManager.SESSION_PTOKEN);
                    sapiAccountResponse.stoken = jSONObject.optString(SapiAccountManager.SESSION_STOKEN);
                    sapiAccountResponse.authSid = jSONObject.optString("authsid");
                }
                if (sapiCallBack != null) {
                    switch (i2) {
                        case 0:
                            if (z2) {
                                SapiAccount a2 = a(sapiAccountResponse);
                                a2.extra = str2;
                                com.baidu.sapi2.share.b.a().a(a2);
                            }
                            sapiCallBack.onSuccess(sapiAccountResponse);
                            return;
                        default:
                            sapiCallBack.onSystemError(i2);
                            return;
                    }
                }
            } catch (Exception e2) {
                com.baidu.sapi2.utils.L.e(e2);
                if (sapiCallBack != null) {
                    sapiCallBack.onSystemError(-100);
                }
            }
        } else if (sapiCallBack != null) {
            sapiCallBack.onSystemError(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            sapiCallBack.onNetworkFailed();
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(B());
        HashMap hashMap = new HashMap();
        hashMap.put("appid", this.c.appId);
        hashMap.put("tpl", this.c.tpl);
        if (!TextUtils.isEmpty(this.c.clientId)) {
            hashMap.put("clientid", this.c.clientId);
        }
        if (!TextUtils.isEmpty(this.c.clientIp)) {
            hashMap.put("clientip", this.c.clientIp);
        }
        hashMap.put("bduss", str);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put(SapiAccountManager.SESSION_PTOKEN, str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put(SapiAccountManager.SESSION_STOKEN, str3);
        }
        String a2 = a(hashMap, this.c.appSignKey);
        MultipartRequestParams multipartRequestParams = new MultipartRequestParams();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            multipartRequestParams.put(entry.getKey(), entry.getValue());
        }
        multipartRequestParams.put("sig", a2);
        multipartRequestParams.put("file", new ByteArrayInputStream(bArr), "portrait.jpg", TextUtils.isEmpty(str4) ? "image/jpeg" : str4);
        this.d.post(this.c.context, q(), multipartRequestParams, new q(sapiCallBack, str, str2, str3, bArr, str4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class q extends HttpResponseHandler {
        final /* synthetic */ SapiCallBack a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ byte[] e;
        final /* synthetic */ String f;

        q(SapiCallBack sapiCallBack, String str, String str2, String str3, byte[] bArr, String str4) {
            this.a = sapiCallBack;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = bArr;
            this.f = str4;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (a.this.e.c()) {
                a.this.e.d();
                this.a.onSystemError(-100);
                return;
            }
            a.this.e.b();
            a.this.a(this.a, this.b, this.c, this.d, this.e, this.f);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            a.this.e.d();
            int b = a.this.b(str);
            if (b == 0) {
                SapiResponse sapiResponse = new SapiResponse();
                sapiResponse.errorCode = b;
                sapiResponse.errorMsg = SetPortraitResult.RESULT_MSG_SUCCESS;
                this.a.onSuccess(sapiResponse);
                return;
            }
            this.a.onSystemError(b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SetPortraitCallback setPortraitCallback, String str, byte[] bArr, String str2) {
        if (setPortraitCallback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("file can't be empty");
        }
        SetPortraitResult setPortraitResult = new SetPortraitResult();
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            setPortraitResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            setPortraitCallback.onFailure(setPortraitResult);
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(B());
        HashMap hashMap = new HashMap();
        hashMap.put("appid", this.c.appId);
        hashMap.put("tpl", this.c.tpl);
        if (!TextUtils.isEmpty(this.c.clientId)) {
            hashMap.put("clientid", this.c.clientId);
        }
        if (!TextUtils.isEmpty(this.c.clientIp)) {
            hashMap.put("clientip", this.c.clientIp);
        }
        hashMap.put("bduss", str);
        String a2 = a(hashMap, this.c.appSignKey);
        MultipartRequestParams multipartRequestParams = new MultipartRequestParams();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            multipartRequestParams.put(entry.getKey(), entry.getValue());
        }
        multipartRequestParams.put("sig", a2);
        multipartRequestParams.put("file", new ByteArrayInputStream(bArr), "portrait.jpg", TextUtils.isEmpty(str2) ? "image/jpeg" : str2);
        this.d.post(this.c.context, q(), multipartRequestParams, new p(setPortraitCallback, setPortraitResult, str, bArr, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class p extends HttpResponseHandler {
        final /* synthetic */ SetPortraitCallback a;
        final /* synthetic */ SetPortraitResult b;
        final /* synthetic */ String c;
        final /* synthetic */ byte[] d;
        final /* synthetic */ String e;

        p(SetPortraitCallback setPortraitCallback, SetPortraitResult setPortraitResult, String str, byte[] bArr, String str2) {
            this.a = setPortraitCallback;
            this.b = setPortraitResult;
            this.c = str;
            this.d = bArr;
            this.e = str2;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        protected void onStart() {
            this.a.onStart();
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        protected void onFinish() {
            this.a.onFinish();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            a.this.e.d();
            this.b.setResultCode(a.this.b(str));
            switch (this.b.getResultCode()) {
                case 0:
                    this.a.onSuccess(this.b);
                    return;
                case 160103:
                    this.a.onBdussExpired(this.b);
                    return;
                default:
                    this.a.onFailure(this.b);
                    return;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (a.this.e.c()) {
                a.this.e.d();
                this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.a.onFailure(this.b);
                return;
            }
            a.this.e.b();
            a.this.a(this.a, this.c, this.d, this.e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SetPopularPortraitCallback setPopularPortraitCallback, SetPopularPortraitDTO setPopularPortraitDTO) {
        if (setPopularPortraitCallback == null) {
            throw new IllegalArgumentException("SetPopularPortraitCallback can't be null");
        }
        if (setPopularPortraitDTO == null) {
            throw new IllegalArgumentException("SetPopularPortraitDto can't be null");
        }
        if (TextUtils.isEmpty(setPopularPortraitDTO.bduss)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        if (TextUtils.isEmpty(setPopularPortraitDTO.series)) {
            throw new IllegalArgumentException("series can't be empty");
        }
        SetPopularPortraitResult setPopularPortraitResult = new SetPopularPortraitResult();
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            setPopularPortraitResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            setPopularPortraitCallback.onFailure(setPopularPortraitResult);
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(B());
        HashMap hashMap = new HashMap();
        hashMap.put("appid", this.c.appId);
        hashMap.put("tpl", this.c.tpl);
        if (!TextUtils.isEmpty(this.c.clientId)) {
            hashMap.put("clientid", this.c.clientId);
        }
        if (!TextUtils.isEmpty(this.c.clientIp)) {
            hashMap.put("clientip", this.c.clientIp);
        }
        hashMap.put("bduss", setPopularPortraitDTO.bduss);
        hashMap.put("serie", setPopularPortraitDTO.series);
        hashMap.put("num", String.valueOf(setPopularPortraitDTO.num));
        String a2 = a(hashMap, this.c.appSignKey);
        MultipartRequestParams multipartRequestParams = new MultipartRequestParams();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            multipartRequestParams.put(entry.getKey(), entry.getValue());
        }
        multipartRequestParams.put("sig", a2);
        this.d.post(this.c.context, u(), multipartRequestParams, new s(setPopularPortraitResult, setPopularPortraitCallback, setPopularPortraitDTO));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class s extends HttpResponseHandler {
        final /* synthetic */ SetPopularPortraitResult a;
        final /* synthetic */ SetPopularPortraitCallback b;
        final /* synthetic */ SetPopularPortraitDTO c;

        s(SetPopularPortraitResult setPopularPortraitResult, SetPopularPortraitCallback setPopularPortraitCallback, SetPopularPortraitDTO setPopularPortraitDTO) {
            this.a = setPopularPortraitResult;
            this.b = setPopularPortraitCallback;
            this.c = setPopularPortraitDTO;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (a.this.e.c()) {
                a.this.e.d();
                this.a.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.b.onFailure(this.a);
                return;
            }
            a.this.e.b();
            a.this.a(this.b, this.c);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            a.this.e.d();
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i2 = jSONObject.getInt("errno");
                this.a.setResultCode(i2);
                this.a.setResultMsg(jSONObject.optString("errmsg"));
                if (i2 == 0) {
                    this.b.onSuccess(this.a);
                } else {
                    this.b.onFailure(this.a);
                }
            } catch (JSONException e) {
                this.a.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.b.onFailure(this.a);
                com.baidu.sapi2.utils.L.e(e);
            }
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onStart() {
            this.b.onStart();
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFinish() {
            this.b.onFinish();
        }
    }

    public void a(SapiCallBack<GetPortraitResponse> sapiCallBack, String str, String str2, String str3) {
        if (sapiCallBack == null) {
            throw new IllegalArgumentException(SapiCallBack.class.getSimpleName() + "can't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            sapiCallBack.onNetworkFailed();
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(B());
        HashMap hashMap = new HashMap();
        hashMap.put("appid", this.c.appId);
        hashMap.put("tpl", this.c.tpl);
        if (!TextUtils.isEmpty(this.c.clientId)) {
            hashMap.put("clientid", this.c.clientId);
        }
        if (!TextUtils.isEmpty(this.c.clientIp)) {
            hashMap.put("clientip", this.c.clientIp);
        }
        hashMap.put("bduss", str);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put(SapiAccountManager.SESSION_PTOKEN, str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put(SapiAccountManager.SESSION_STOKEN, str3);
        }
        String a2 = a(hashMap, this.c.appSignKey);
        RequestParams requestParams = new RequestParams();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            requestParams.put(entry.getKey(), entry.getValue());
        }
        requestParams.put("sig", a2);
        this.d.post(this.c.context, this.e.a() + "/v2/sapi/center/getportrait", requestParams, new r(sapiCallBack, str, str2, str3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class r extends HttpResponseHandler {
        final /* synthetic */ SapiCallBack a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;

        r(SapiCallBack sapiCallBack, String str, String str2, String str3) {
            this.a = sapiCallBack;
            this.b = str;
            this.c = str2;
            this.d = str3;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (a.this.e.c()) {
                a.this.e.d();
                this.a.onSystemError(-100);
                return;
            }
            a.this.e.b();
            a.this.a(this.a, this.b, this.c, this.d);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            a.this.e.d();
            int b = a.this.b(str);
            if (b == 0) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    GetPortraitResponse getPortraitResponse = new GetPortraitResponse();
                    getPortraitResponse.errorCode = b;
                    getPortraitResponse.errorMsg = jSONObject.optString("errmsg");
                    String optString = jSONObject.optString(IntentConfig.PORTRAIT);
                    if (!TextUtils.isEmpty(optString)) {
                        getPortraitResponse.portrait = String.format("http://himg.bdimg.com/sys/portrait/item/%s.jpg", optString);
                    }
                    this.a.onSuccess(getPortraitResponse);
                    return;
                } catch (JSONException e) {
                    this.a.onSystemError(b);
                    com.baidu.sapi2.utils.L.e(e);
                    return;
                }
            }
            this.a.onSystemError(b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(GetHistoryPortraitsCallback getHistoryPortraitsCallback, GetHistoryPortraitsDTO getHistoryPortraitsDTO) {
        if (getHistoryPortraitsCallback == null) {
            throw new IllegalArgumentException("getHistoryPortaits callback can't be null");
        }
        if (getHistoryPortraitsDTO == null) {
            throw new IllegalArgumentException("getHistoryPortrats dto can't be null");
        }
        if (TextUtils.isEmpty(getHistoryPortraitsDTO.bduss)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        if (getHistoryPortraitsDTO.maxNum < 0 || getHistoryPortraitsDTO.maxNum > 10) {
            throw new IllegalArgumentException("abnormal request history number");
        }
        GetHistoryPortraitsResult getHistoryPortraitsResult = new GetHistoryPortraitsResult();
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            getHistoryPortraitsResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            getHistoryPortraitsCallback.onFailure(getHistoryPortraitsResult);
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(B());
        HashMap hashMap = new HashMap();
        hashMap.put("appid", this.c.appId);
        hashMap.put("tpl", this.c.tpl);
        hashMap.put("length", String.valueOf(getHistoryPortraitsDTO.maxNum));
        if (!TextUtils.isEmpty(this.c.clientId)) {
            hashMap.put("clientid", this.c.clientId);
        }
        if (!TextUtils.isEmpty(this.c.clientIp)) {
            hashMap.put("clientip", this.c.clientIp);
        }
        hashMap.put("bduss", getHistoryPortraitsDTO.bduss);
        String a2 = a(hashMap, this.c.appSignKey);
        RequestParams requestParams = new RequestParams();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            requestParams.put(entry.getKey(), entry.getValue());
        }
        requestParams.put("sig", a2);
        this.d.post(this.c.context, r(), requestParams, new u(getHistoryPortraitsResult, getHistoryPortraitsCallback, getHistoryPortraitsDTO));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class u extends HttpResponseHandler {
        final /* synthetic */ GetHistoryPortraitsResult a;
        final /* synthetic */ GetHistoryPortraitsCallback b;
        final /* synthetic */ GetHistoryPortraitsDTO c;

        u(GetHistoryPortraitsResult getHistoryPortraitsResult, GetHistoryPortraitsCallback getHistoryPortraitsCallback, GetHistoryPortraitsDTO getHistoryPortraitsDTO) {
            this.a = getHistoryPortraitsResult;
            this.b = getHistoryPortraitsCallback;
            this.c = getHistoryPortraitsDTO;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (a.this.e.c()) {
                a.this.e.d();
                this.a.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.b.onFailure(this.a);
                return;
            }
            a.this.e.b();
            a.this.a(this.b, this.c);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            a.this.e.d();
            try {
                JSONObject jSONObject = new JSONObject(str);
                int i2 = jSONObject.getInt("errno");
                this.a.setResultCode(i2);
                this.a.setResultMsg(jSONObject.optString("errmsg"));
                if (i2 == 0) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("history");
                    int length = optJSONArray.length();
                    this.a.historyPortraits = new ArrayList(length);
                    for (int i3 = 0; i3 < length; i3++) {
                        this.a.historyPortraits.add(optJSONArray.optString(i3));
                    }
                    this.b.onSuccess(this.a);
                    return;
                }
                this.b.onFailure(this.a);
            } catch (JSONException e) {
                this.a.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.b.onFailure(this.a);
                com.baidu.sapi2.utils.L.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(GetPopularPortraitsCallback getPopularPortraitsCallback, String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bduss can't be empty nor null");
        }
        GetPopularPortraitsInfoResult getPopularPortraitsInfoResult = new GetPopularPortraitsInfoResult();
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            getPopularPortraitsInfoResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            getPopularPortraitsCallback.onFailure(getPopularPortraitsInfoResult);
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(B());
        HashMap hashMap = new HashMap();
        hashMap.put("bduss", str);
        RequestParams requestParams = new RequestParams();
        for (Map.Entry entry : hashMap.entrySet()) {
            requestParams.put((String) entry.getKey(), (String) entry.getValue());
        }
        this.d.post(this.c.context, t(), requestParams, new v(getPopularPortraitsCallback, getPopularPortraitsInfoResult, str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class v extends HttpResponseHandler {
        final /* synthetic */ GetPopularPortraitsCallback a;
        final /* synthetic */ GetPopularPortraitsInfoResult b;
        final /* synthetic */ String c;

        v(GetPopularPortraitsCallback getPopularPortraitsCallback, GetPopularPortraitsInfoResult getPopularPortraitsInfoResult, String str) {
            this.a = getPopularPortraitsCallback;
            this.b = getPopularPortraitsInfoResult;
            this.c = str;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onStart() {
            this.a.onStart();
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFinish() {
            this.a.onFinish();
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (a.this.e.c()) {
                a.this.e.d();
                this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.a.onFailure(this.b);
                return;
            }
            a.this.e.b();
            a.this.a(this.a, this.c);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            a.this.e.d();
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("errno");
                this.b.setResultCode(optInt);
                this.b.setResultMsg(jSONObject.optString("errmsg"));
                if (optInt == 0) {
                    JSONArray optJSONArray = jSONObject.optJSONArray(IntentConfig.LIST);
                    int length = optJSONArray.length();
                    this.b.popularPortraitsInfoList = new ArrayList(length);
                    for (int i2 = 0; i2 < length; i2++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                        if (optJSONObject != null) {
                            GetPopularPortraitsInfoResult.PopularPortraitsInfo popularPortraitsInfo = new GetPopularPortraitsInfoResult.PopularPortraitsInfo();
                            popularPortraitsInfo.num = optJSONObject.optInt("num");
                            popularPortraitsInfo.series = optJSONObject.optString("serie");
                            popularPortraitsInfo.url = optJSONObject.optString("url");
                            popularPortraitsInfo.myItem = optJSONObject.optInt("myitem");
                            this.b.popularPortraitsInfoList.add(popularPortraitsInfo);
                        }
                    }
                    this.a.onSuccess(this.b);
                    return;
                }
                this.a.onFailure(this.b);
            } catch (JSONException e) {
                this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.a.onFailure(this.b);
                com.baidu.sapi2.utils.L.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(GetUserInfoCallback getUserInfoCallback, String str) {
        if (getUserInfoCallback == null) {
            throw new IllegalArgumentException(GetUserInfoCallback.class.getSimpleName() + " can't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        GetUserInfoResult getUserInfoResult = new GetUserInfoResult();
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            getUserInfoResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            getUserInfoCallback.onFailure(getUserInfoResult);
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(B());
        HashMap hashMap = new HashMap();
        hashMap.put("appid", this.c.appId);
        hashMap.put("tpl", this.c.tpl);
        if (!TextUtils.isEmpty(this.c.clientId)) {
            hashMap.put("clientid", this.c.clientId);
        }
        if (!TextUtils.isEmpty(this.c.clientIp)) {
            hashMap.put("clientip", this.c.clientIp);
        }
        hashMap.put("bduss", str);
        String a2 = a(hashMap, this.c.appSignKey);
        RequestParams requestParams = new RequestParams();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            requestParams.put(entry.getKey(), entry.getValue());
        }
        requestParams.put("sig", a2);
        this.d.post(this.c.context, s(), requestParams, new t(getUserInfoCallback, getUserInfoResult, str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class t extends HttpResponseHandler {
        final /* synthetic */ GetUserInfoCallback a;
        final /* synthetic */ GetUserInfoResult b;
        final /* synthetic */ String c;

        t(GetUserInfoCallback getUserInfoCallback, GetUserInfoResult getUserInfoResult, String str) {
            this.a = getUserInfoCallback;
            this.b = getUserInfoResult;
            this.c = str;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        protected void onStart() {
            this.a.onStart();
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        protected void onFinish() {
            this.a.onFinish();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            a.this.e.d();
            int b = a.this.b(str);
            this.b.setResultCode(b);
            switch (b) {
                case 0:
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        this.b.portraitSign = jSONObject.optString("portrait_tag");
                        this.b.isInitialPortrait = "0".equals(this.b.portraitSign);
                        String optString = jSONObject.optString(IntentConfig.PORTRAIT);
                        if (!TextUtils.isEmpty(optString)) {
                            this.b.portrait = String.format("http://himg.bdimg.com/sys/portrait/item/%s.jpg?%s", optString, this.b.portraitSign);
                        }
                        this.b.username = jSONObject.optString("username");
                        this.b.uid = jSONObject.optString("userid");
                        this.b.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                        this.b.incompleteUser = "1".equals(jSONObject.optString("incomplete_user"));
                        this.b.secureMobile = jSONObject.optString("securemobil");
                        this.b.secureEmail = jSONObject.optString("secureemail");
                        this.b.havePwd = "1".equals(jSONObject.optString("have_psw"));
                        this.a.onSuccess(this.b);
                        return;
                    } catch (Exception e) {
                        this.a.onFailure(this.b);
                        com.baidu.sapi2.utils.L.e(e);
                        return;
                    }
                case 400021:
                    this.a.onBdussExpired(this.b);
                    return;
                default:
                    this.a.onFailure(this.b);
                    return;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (a.this.e.c()) {
                a.this.e.d();
                this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.a.onFailure(this.b);
                return;
            }
            a.this.e.b();
            a.this.a(this.a, this.c);
        }
    }

    public void a(GetUserInfoCallBack getUserInfoCallBack, String str) {
        if (getUserInfoCallBack == null) {
            throw new IllegalArgumentException(GetUserInfoCallBack.class.getSimpleName() + " can't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            getUserInfoCallBack.onFinish();
            getUserInfoCallBack.onNetworkFailed();
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(B());
        HashMap hashMap = new HashMap();
        hashMap.put("appid", this.c.appId);
        hashMap.put("tpl", this.c.tpl);
        if (!TextUtils.isEmpty(this.c.clientId)) {
            hashMap.put("clientid", this.c.clientId);
        }
        if (!TextUtils.isEmpty(this.c.clientIp)) {
            hashMap.put("clientip", this.c.clientIp);
        }
        hashMap.put("bduss", str);
        String a2 = a(hashMap, this.c.appSignKey);
        RequestParams requestParams = new RequestParams();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            requestParams.put(entry.getKey(), entry.getValue());
        }
        requestParams.put("sig", a2);
        this.d.post(this.c.context, s(), requestParams, new z(getUserInfoCallBack, str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class z extends HttpResponseHandler {
        final /* synthetic */ GetUserInfoCallBack a;
        final /* synthetic */ String b;

        z(GetUserInfoCallBack getUserInfoCallBack, String str) {
            this.a = getUserInfoCallBack;
            this.b = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            a.this.e.d();
            this.a.onFinish();
            int b = a.this.b(str);
            switch (b) {
                case 0:
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        GetUserInfoResponse getUserInfoResponse = new GetUserInfoResponse();
                        getUserInfoResponse.errorCode = b;
                        getUserInfoResponse.errorMsg = jSONObject.optString("errmsg");
                        String optString = jSONObject.optString(IntentConfig.PORTRAIT);
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
                        this.a.onSystemError(b);
                        com.baidu.sapi2.utils.L.e(e);
                        return;
                    }
                case 400021:
                    this.a.onBdussInvalid();
                    return;
                default:
                    this.a.onSystemError(b);
                    return;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (a.this.e.c()) {
                a.this.e.d();
                this.a.onFinish();
                this.a.onSystemError(-100);
                return;
            }
            a.this.e.b();
            a.this.a(this.a, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(FillUsernameCallback fillUsernameCallback, String str, String str2) {
        if (fillUsernameCallback == null) {
            throw new IllegalArgumentException(FillUsernameCallback.class.getSimpleName() + " can't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("username can't be empty");
        }
        FillUsernameResult fillUsernameResult = new FillUsernameResult();
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            fillUsernameResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            fillUsernameCallback.onFailure(fillUsernameResult);
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(B());
        HashMap hashMap = new HashMap();
        hashMap.put("appid", this.c.appId);
        hashMap.put("tpl", this.c.tpl);
        hashMap.put("cert_id", String.valueOf(1));
        hashMap.put("crypttype", String.valueOf(6));
        JSONObject jSONObject = new JSONObject();
        SapiDataEncryptor sapiDataEncryptor = new SapiDataEncryptor();
        try {
            jSONObject.put("bduss", str);
            if (!TextUtils.isEmpty(this.c.clientId)) {
                jSONObject.put("clientid", this.c.clientId);
            }
            if (!TextUtils.isEmpty(this.c.clientIp)) {
                jSONObject.put("clientip", this.c.clientIp);
            }
            jSONObject.put("username", str2);
            jSONObject.put("key", sapiDataEncryptor.a());
            hashMap.put("userinfo", sapiDataEncryptor.a(SapiDataEncryptor.b.b, jSONObject.toString()));
            hashMap.put("sig", a(hashMap, this.c.appSignKey));
            this.d.post(this.c.context, p(), new RequestParams(hashMap), new y(fillUsernameCallback, fillUsernameResult, sapiDataEncryptor, str, str2));
        } catch (Throwable th) {
            fillUsernameResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
            fillUsernameCallback.onFailure(fillUsernameResult);
            com.baidu.sapi2.utils.L.e(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class y extends HttpResponseHandler {
        final /* synthetic */ FillUsernameCallback a;
        final /* synthetic */ FillUsernameResult b;
        final /* synthetic */ SapiDataEncryptor c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        y(FillUsernameCallback fillUsernameCallback, FillUsernameResult fillUsernameResult, SapiDataEncryptor sapiDataEncryptor, String str, String str2) {
            this.a = fillUsernameCallback;
            this.b = fillUsernameResult;
            this.c = sapiDataEncryptor;
            this.d = str;
            this.e = str2;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        protected void onStart() {
            this.a.onStart();
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        protected void onFinish() {
            this.a.onFinish();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            a.this.e.d();
            int b = a.this.b(str);
            this.b.setResultCode(b);
            try {
                JSONObject jSONObject = new JSONObject(this.c.a(new JSONObject(str).optString("userinfo")));
                switch (b) {
                    case 0:
                    case 110000:
                        SapiAccount sapiAccount = new SapiAccount();
                        sapiAccount.bduss = jSONObject.optString("bduss");
                        sapiAccount.ptoken = jSONObject.optString(SapiAccountManager.SESSION_PTOKEN);
                        sapiAccount.stoken = jSONObject.optString(SapiAccountManager.SESSION_STOKEN);
                        sapiAccount.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                        sapiAccount.username = jSONObject.optString("uname");
                        sapiAccount.uid = jSONObject.optString("uid");
                        sapiAccount.extra = jSONObject.toString();
                        this.b.session = sapiAccount;
                        this.a.onSuccess(this.b);
                        break;
                    case 160103:
                        this.a.onBdussExpired(this.b);
                        break;
                    case 160104:
                        this.a.onUserHaveUsername(this.b);
                        break;
                    default:
                        this.a.onFailure(this.b);
                        break;
                }
            } catch (Throwable th) {
                this.a.onFailure(this.b);
                com.baidu.sapi2.utils.L.e(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (a.this.e.c()) {
                a.this.e.d();
                this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.a.onFailure(this.b);
                return;
            }
            a.this.e.b();
            a.this.a(this.a, this.d, this.e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(FillUsernameCallBack fillUsernameCallBack, String str, String str2, String str3) {
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            if (fillUsernameCallBack != null) {
                fillUsernameCallBack.onNetworkFailed();
                return;
            }
            return;
        }
        SapiDataEncryptor sapiDataEncryptor = new SapiDataEncryptor();
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(B());
        this.d.get(this.c.context, D(), new x(fillUsernameCallBack, sapiDataEncryptor, str, str2, str3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class x extends HttpResponseHandler {
        final /* synthetic */ FillUsernameCallBack a;
        final /* synthetic */ SapiDataEncryptor b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        x(FillUsernameCallBack fillUsernameCallBack, SapiDataEncryptor sapiDataEncryptor, String str, String str2, String str3) {
            this.a = fillUsernameCallBack;
            this.b = sapiDataEncryptor;
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
                com.baidu.sapi2.utils.L.e(e);
            }
            if (a.this.e.c()) {
                a.this.e.d();
                a.this.a(-100, this.a, str2, this.b);
                return;
            }
            a.this.a(this.a, this.c, this.d, this.e);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
            a.this.e.d();
            try {
                JSONObject jSONObject = new JSONObject(str);
                a.this.a(this.a, this.c, this.d, this.e, jSONObject.optString("cert"), jSONObject.optString("cert_id"), this.b);
            } catch (Exception e) {
                a.this.a(a.this.c(str), this.a, str, this.b);
                com.baidu.sapi2.utils.L.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FillUsernameCallBack fillUsernameCallBack, String str, String str2, String str3, String str4, String str5, SapiDataEncryptor sapiDataEncryptor) {
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(B());
        HashMap hashMap = new HashMap();
        hashMap.put("appid", this.c.appId);
        hashMap.put("tpl", this.c.tpl);
        hashMap.put("cert_id", str5);
        hashMap.put("crypttype", String.valueOf(6));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("bduss", str);
        if (!TextUtils.isEmpty(this.c.clientId)) {
            jSONObject.put("clientid", this.c.clientId);
        }
        if (!TextUtils.isEmpty(this.c.clientIp)) {
            jSONObject.put("clientip", this.c.clientIp);
        }
        if (!TextUtils.isEmpty(str2)) {
            jSONObject.put(SapiAccountManager.SESSION_PTOKEN, str2);
        }
        jSONObject.put("username", str3);
        jSONObject.put("key", sapiDataEncryptor.a());
        hashMap.put("userinfo", sapiDataEncryptor.a(str4, jSONObject.toString()));
        hashMap.put("sig", a(hashMap, this.c.appSignKey));
        this.d.post(this.c.context, p(), new RequestParams(hashMap), new w(fillUsernameCallBack, sapiDataEncryptor));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class w extends HttpResponseHandler {
        final /* synthetic */ FillUsernameCallBack a;
        final /* synthetic */ SapiDataEncryptor b;

        w(FillUsernameCallBack fillUsernameCallBack, SapiDataEncryptor sapiDataEncryptor) {
            this.a = fillUsernameCallBack;
            this.b = sapiDataEncryptor;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
            a.this.a(a.this.c(str), this.a, str, this.b);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
            a.this.a(a.this.c(str), this.a, str, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(FillUserProfileCallback fillUserProfileCallback, String str) {
        if (fillUserProfileCallback == null) {
            throw new IllegalArgumentException(FillUserProfileCallback.class.getSimpleName() + " can't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        FillUserProfileResult fillUserProfileResult = new FillUserProfileResult();
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            fillUserProfileResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            fillUserProfileCallback.onFailure(fillUserProfileResult);
        } else if (!SapiUtils.isSimReady(this.c.context)) {
            fillUserProfileResult.setResultCode(-101);
            fillUserProfileCallback.onFailure(fillUserProfileResult);
        } else {
            this.d = new AsyncHttpClient();
            this.d.setUserAgent(B());
            HashMap hashMap = new HashMap();
            hashMap.put("appid", this.c.appId);
            hashMap.put("tpl", this.c.tpl);
            if (!TextUtils.isEmpty(this.c.clientId)) {
                hashMap.put("clientid", this.c.clientId);
            }
            hashMap.put("bduss", str);
            hashMap.put("sig", a(hashMap, this.c.appSignKey));
            this.d.post(this.c.context, this.e.a() + com.baidu.sapi2.utils.d.F, new RequestParams(hashMap), new l(fillUserProfileCallback, fillUserProfileResult, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class l extends HttpResponseHandler {
        final /* synthetic */ FillUserProfileCallback a;
        final /* synthetic */ FillUserProfileResult b;
        final /* synthetic */ String c;

        l(FillUserProfileCallback fillUserProfileCallback, FillUserProfileResult fillUserProfileResult, String str) {
            this.a = fillUserProfileCallback;
            this.b = fillUserProfileResult;
            this.c = str;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        protected void onStart() {
            this.a.onStart();
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        protected void onFinish() {
            this.a.onFinish();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int b = a.this.b(str);
                this.b.setResultCode(b);
                switch (b) {
                    case 0:
                        String optString = jSONObject.optString("sms");
                        String optString2 = jSONObject.optString("vcode");
                        String optString3 = jSONObject.optString("upsmschannel");
                        if (SapiUtils.sendSms(a.this.c.context, optString2, optString) && !TextUtils.isEmpty(optString3)) {
                            a.this.d = new AsyncHttpClient();
                            a.this.d.setUserAgent(a.this.B());
                            CookieStore basicCookieStore = new BasicCookieStore();
                            BasicClientCookie basicClientCookie = new BasicClientCookie("BAIDUID", SapiUtils.getClientId(a.this.c.context));
                            basicClientCookie.setDomain("baidu.com");
                            basicClientCookie.setPath("/");
                            basicCookieStore.addCookie(basicClientCookie);
                            a.this.d.setCookieStore(basicCookieStore);
                            RequestParams requestParams = new RequestParams();
                            requestParams.put("channel_id", optString3);
                            requestParams.put("callback", "p");
                            requestParams.put("apiver", "v3");
                            requestParams.put("tt", String.valueOf(System.currentTimeMillis()));
                            a.this.d.get(a.this.c.context, "https://passport.baidu.com/channel/unicast", requestParams, new HandlerC0024a(optString3, optString2));
                            break;
                        } else {
                            this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                            this.a.onFailure(this.b);
                            break;
                        }
                    case 1:
                        this.a.onBdussExpired(this.b);
                        break;
                    case FillUserProfileResult.RESULT_CODE_COMPLETE_USER /* 61002 */:
                        this.a.onCompleteUser(this.b);
                        break;
                    default:
                        this.a.onFailure(this.b);
                        break;
                }
            } catch (Throwable th) {
                this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.a.onFailure(this.b);
            }
        }

        /* renamed from: com.baidu.sapi2.a$l$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class HandlerC0024a extends HttpResponseHandler {
            final /* synthetic */ String a;
            final /* synthetic */ String b;

            HandlerC0024a(String str, String str2) {
                this.a = str;
                this.b = str2;
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onStart() {
                l.this.a.onStart();
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onFinish() {
                l.this.a.onFinish();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str) {
                if (TextUtils.isEmpty(str)) {
                    l.this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    l.this.a.onFailure(l.this.b);
                    return;
                }
                int indexOf = str.indexOf("(");
                int indexOf2 = str.indexOf(")");
                if (indexOf >= 0) {
                    try {
                        int b = a.this.b(str.substring(indexOf + 1, indexOf2));
                        l.this.b.setResultCode(b);
                        switch (b) {
                            case 0:
                                HashMap hashMap = new HashMap();
                                hashMap.put("appid", a.this.c.appId);
                                hashMap.put("tpl", a.this.c.tpl);
                                if (!TextUtils.isEmpty(a.this.c.clientId)) {
                                    hashMap.put("clientid", a.this.c.clientId);
                                }
                                hashMap.put("upsmschannel", this.a);
                                hashMap.put("bduss", l.this.c);
                                hashMap.put("vcode", this.b);
                                hashMap.put("sig", a.this.a(hashMap, a.this.c.appSignKey));
                                a.this.d = new AsyncHttpClient();
                                a.this.d.setUserAgent(a.this.B());
                                a.this.d.post(a.this.c.context, a.this.e.a() + com.baidu.sapi2.utils.d.G, new RequestParams(hashMap), new HandlerC0025a());
                                return;
                            default:
                                l.this.a.onFailure(l.this.b);
                                return;
                        }
                    } catch (Throwable th) {
                        com.baidu.sapi2.utils.L.e(th);
                        l.this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                        l.this.a.onFailure(l.this.b);
                        return;
                    }
                }
                l.this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                l.this.a.onFailure(l.this.b);
            }

            /* renamed from: com.baidu.sapi2.a$l$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class HandlerC0025a extends HttpResponseHandler {
                HandlerC0025a() {
                }

                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                protected void onStart() {
                    l.this.a.onStart();
                }

                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                protected void onFinish() {
                    l.this.a.onFinish();
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onSuccess(int i, String str) {
                    try {
                        int b = a.this.b(str);
                        l.this.b.setResultCode(b);
                        switch (b) {
                            case 0:
                                SapiAccount sapiAccount = new SapiAccount();
                                JSONObject jSONObject = new JSONObject(str);
                                sapiAccount.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                                sapiAccount.bduss = jSONObject.optString("bduss");
                                sapiAccount.uid = jSONObject.optString("uid");
                                sapiAccount.ptoken = jSONObject.optString(SapiAccountManager.SESSION_PTOKEN);
                                sapiAccount.stoken = jSONObject.optString(SapiAccountManager.SESSION_STOKEN);
                                l.this.b.session = sapiAccount;
                                l.this.a.onSuccess(l.this.b);
                                break;
                            default:
                                l.this.a.onFailure(l.this.b);
                                break;
                        }
                    } catch (Throwable th) {
                        l.this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                        l.this.a.onFailure(l.this.b);
                    }
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onFailure(Throwable th, String str) {
                    l.this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    l.this.a.onFailure(l.this.b);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str) {
                l.this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                l.this.a.onFailure(l.this.b);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
            this.a.onFailure(this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(VoiceCheckCallback voiceCheckCallback, VoiceCheckDTO voiceCheckDTO) {
        if (voiceCheckCallback == null) {
            throw new IllegalArgumentException(VoiceCheckCallback.class.getSimpleName() + " can't be null");
        }
        if (voiceCheckDTO == null) {
            throw new IllegalArgumentException(VoiceCheckDTO.class.getSimpleName() + " can't be null");
        }
        VoiceCheckResult voiceCheckResult = new VoiceCheckResult();
        if (TextUtils.isEmpty(voiceCheckDTO.account)) {
            voiceCheckResult.setResultCode(-101);
            voiceCheckCallback.onFailure(voiceCheckResult);
        } else if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            voiceCheckResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            voiceCheckCallback.onFailure(voiceCheckResult);
        } else {
            this.d = new AsyncHttpClient();
            this.d.setUserAgent(B());
            HashMap hashMap = new HashMap();
            hashMap.put("appid", this.c.appId);
            hashMap.put("tpl", this.c.tpl);
            if (!TextUtils.isEmpty(this.c.clientId)) {
                hashMap.put("clientid", this.c.clientId);
            }
            String b2 = com.baidu.sapi2.utils.e.b(com.baidu.sapi2.utils.d.H);
            if (!TextUtils.isEmpty(b2)) {
                hashMap.put("di", b2);
            }
            hashMap.put("username", voiceCheckDTO.account);
            if (voiceCheckDTO.accountType == null || voiceCheckDTO.accountType == VoiceCheckDTO.AccountType.MERGE) {
                hashMap.put("merge", "1");
            }
            if (voiceCheckDTO.accountType == VoiceCheckDTO.AccountType.USERNAME) {
                hashMap.put("isphone", "0");
            }
            if (voiceCheckDTO.accountType == VoiceCheckDTO.AccountType.PHONE) {
                hashMap.put("isphone", "1");
            }
            hashMap.put("sig", a(hashMap, this.c.appSignKey));
            this.d.post(this.c.context, this.e.a() + com.baidu.sapi2.utils.d.H, new RequestParams(hashMap), new C(voiceCheckCallback, voiceCheckResult, voiceCheckDTO));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class C extends HttpResponseHandler {
        final /* synthetic */ VoiceCheckCallback a;
        final /* synthetic */ VoiceCheckResult b;
        final /* synthetic */ VoiceCheckDTO c;

        C(VoiceCheckCallback voiceCheckCallback, VoiceCheckResult voiceCheckResult, VoiceCheckDTO voiceCheckDTO) {
            this.a = voiceCheckCallback;
            this.b = voiceCheckResult;
            this.c = voiceCheckDTO;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        protected void onStart() {
            this.a.onStart();
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        protected void onFinish() {
            this.a.onFinish();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            a.this.e.d();
            a.this.b(this.a, str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (a.this.e.c()) {
                a.this.e.d();
                this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.a.onFailure(this.b);
                return;
            }
            a.this.e.b();
            a.this.a(this.a, this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(VoiceCheckCallback voiceCheckCallback, String str) {
        if (voiceCheckCallback == null) {
            throw new IllegalArgumentException(VoiceCheckCallback.class.getSimpleName() + " can't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        VoiceCheckResult voiceCheckResult = new VoiceCheckResult();
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            voiceCheckResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            voiceCheckCallback.onFailure(voiceCheckResult);
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(B());
        HashMap hashMap = new HashMap();
        hashMap.put("appid", this.c.appId);
        hashMap.put("tpl", this.c.tpl);
        if (!TextUtils.isEmpty(this.c.clientId)) {
            hashMap.put("clientid", this.c.clientId);
        }
        if (!TextUtils.isEmpty(this.c.clientIp)) {
            hashMap.put("clientip", this.c.clientIp);
        }
        String b2 = com.baidu.sapi2.utils.e.b(com.baidu.sapi2.utils.d.H);
        if (!TextUtils.isEmpty(b2)) {
            hashMap.put("di", b2);
        }
        hashMap.put("bduss", str);
        hashMap.put("sig", a(hashMap, this.c.appSignKey));
        this.d.post(this.c.context, this.e.a() + com.baidu.sapi2.utils.d.H, new RequestParams(hashMap), new B(voiceCheckCallback, voiceCheckResult, str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class B extends HttpResponseHandler {
        final /* synthetic */ VoiceCheckCallback a;
        final /* synthetic */ VoiceCheckResult b;
        final /* synthetic */ String c;

        B(VoiceCheckCallback voiceCheckCallback, VoiceCheckResult voiceCheckResult, String str) {
            this.a = voiceCheckCallback;
            this.b = voiceCheckResult;
            this.c = str;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        protected void onStart() {
            this.a.onStart();
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        protected void onFinish() {
            this.a.onFinish();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            a.this.e.d();
            a.this.b(this.a, str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (a.this.e.c()) {
                a.this.e.d();
                this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.a.onFailure(this.b);
                return;
            }
            a.this.e.b();
            a.this.a(this.a, this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(VoiceCheckCallback voiceCheckCallback, String str) {
        VoiceCheckResult voiceCheckResult = new VoiceCheckResult();
        try {
            JSONObject jSONObject = new JSONObject(str);
            int parseInt = Integer.parseInt(jSONObject.optString("errno"));
            voiceCheckResult.setResultCode(parseInt);
            switch (parseInt) {
                case 0:
                    voiceCheckResult.uid = SapiDataEncryptor.b(jSONObject.optString("id"));
                    voiceCheckResult.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                    voiceCheckResult.signUp = "1".equals(jSONObject.optString("voice"));
                    voiceCheckResult.needVerify = "1".equals(jSONObject.optString("needverify"));
                    voiceCheckResult.authToken = jSONObject.optString(SocialConstants.TOKEN_RESPONSE_TYPE);
                    if ("null".equals(voiceCheckResult.authToken)) {
                        voiceCheckResult.authToken = null;
                    }
                    voiceCheckResult.authSid = jSONObject.optString("authsid");
                    if ("null".equals(voiceCheckResult.authSid)) {
                        voiceCheckResult.authSid = null;
                    }
                    try {
                        voiceCheckResult.voiceCode = Integer.parseInt(SapiDataEncryptor.b(jSONObject.optString("password")));
                    } catch (Exception e2) {
                        voiceCheckResult.voiceCode = -1;
                        com.baidu.sapi2.utils.L.e(e2);
                    }
                    voiceCheckCallback.onSuccess(voiceCheckResult);
                    return;
                case 3:
                    voiceCheckCallback.onIncompleteUser(voiceCheckResult);
                    return;
                case 400021:
                    voiceCheckCallback.onBdussExpired(voiceCheckResult);
                    return;
                case VoiceCheckResult.RESULT_CODE_ACCOUNT_TYPE_CONFLICT /* 400401 */:
                    voiceCheckCallback.onAccountTypeConflict(voiceCheckResult);
                    return;
                default:
                    voiceCheckCallback.onFailure(voiceCheckResult);
                    return;
            }
        } catch (Exception e3) {
            voiceCheckResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
            voiceCheckCallback.onFailure(voiceCheckResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(SapiCallback<OAuthResult> sapiCallback, String str) {
        if (sapiCallback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        OAuthResult oAuthResult = new OAuthResult();
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            oAuthResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            sapiCallback.onFailure(oAuthResult);
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(B());
        HashMap hashMap = new HashMap();
        hashMap.put("appid", this.c.appId);
        hashMap.put("tpl", this.c.tpl);
        if (!TextUtils.isEmpty(this.c.clientId)) {
            hashMap.put("clientid", this.c.clientId);
        }
        if (!TextUtils.isEmpty(this.c.clientIp)) {
            hashMap.put("clientip", this.c.clientIp);
        }
        hashMap.put("bduss", str);
        hashMap.put("sig", a(hashMap, this.c.appSignKey));
        this.d.post(this.c.context, this.e.a() + com.baidu.sapi2.utils.d.E, new RequestParams(hashMap), new A(sapiCallback, oAuthResult, str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class A extends HttpResponseHandler {
        final /* synthetic */ SapiCallback a;
        final /* synthetic */ OAuthResult b;
        final /* synthetic */ String c;

        A(SapiCallback sapiCallback, OAuthResult oAuthResult, String str) {
            this.a = sapiCallback;
            this.b = oAuthResult;
            this.c = str;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        protected void onStart() {
            this.a.onStart();
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        protected void onFinish() {
            this.a.onFinish();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            a.this.e.d();
            try {
                JSONObject jSONObject = new JSONObject(str);
                int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                this.b.setResultCode(parseInt);
                switch (parseInt) {
                    case 0:
                        this.b.accessToken = jSONObject.optString(SocialConstants.PARAM_ACCESS_TOKEN);
                        this.b.expiresIn = jSONObject.optInt(SocialConstants.PARAM_EXPIRES_IN);
                        this.b.scope = jSONObject.optString("scope");
                        this.b.refreshToken = jSONObject.optString("refresh_token");
                        this.b.sessionKey = jSONObject.optString(SocialConstants.PARAM_SESSION_KEY);
                        this.b.sessionSecret = jSONObject.optString(SocialConstants.PARAM_SESSION_SECRET);
                        this.b.extra = str;
                        this.a.onSuccess(this.b);
                        break;
                    default:
                        this.a.onFailure(this.b);
                        break;
                }
            } catch (Throwable th) {
                this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.a.onFailure(this.b);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (a.this.e.c()) {
                a.this.e.d();
                this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.a.onFailure(this.b);
                return;
            }
            a.this.e.b();
            a.this.c(this.a, this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SapiCallback<VoiceRegResult> sapiCallback, String str, String str2, String str3, boolean z2) {
        if (sapiCallback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("voiceMd5 can't be empty");
        }
        VoiceRegResult voiceRegResult = new VoiceRegResult();
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            voiceRegResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            sapiCallback.onFailure(voiceRegResult);
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(B());
        HashMap hashMap = new HashMap();
        hashMap.put("appid", this.c.appId);
        hashMap.put("tpl", this.c.tpl);
        if (!TextUtils.isEmpty(this.c.clientId)) {
            hashMap.put("clientid", this.c.clientId);
            hashMap.put(SocialConstants.PARAM_CUID, this.c.clientId);
        }
        if (!TextUtils.isEmpty(this.c.clientIp)) {
            hashMap.put("clientip", this.c.clientIp);
        }
        String b2 = com.baidu.sapi2.utils.e.b(com.baidu.sapi2.utils.d.I);
        if (!TextUtils.isEmpty(b2)) {
            hashMap.put("di", b2);
        }
        hashMap.put("voicemd5", str);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("bduss", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("authsid", str3);
        }
        if (z2) {
            hashMap.put("newuser", "1");
        } else {
            hashMap.put("newuser", "0");
        }
        hashMap.put("sig", a(hashMap, this.c.appSignKey));
        this.d.post(this.c.context, this.e.a() + com.baidu.sapi2.utils.d.I, new RequestParams(hashMap), new D(sapiCallback, z2, voiceRegResult, str, str2, str3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class D extends HttpResponseHandler {
        final /* synthetic */ SapiCallback a;
        final /* synthetic */ boolean b;
        final /* synthetic */ VoiceRegResult c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;
        final /* synthetic */ String f;

        D(SapiCallback sapiCallback, boolean z, VoiceRegResult voiceRegResult, String str, String str2, String str3) {
            this.a = sapiCallback;
            this.b = z;
            this.c = voiceRegResult;
            this.d = str;
            this.e = str2;
            this.f = str3;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        protected void onStart() {
            this.a.onStart();
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        protected void onFinish() {
            this.a.onFinish();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            a.this.e.d();
            a.this.a(this.a, str, this.b);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (a.this.e.c()) {
                a.this.e.d();
                this.c.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.a.onFailure(this.c);
                return;
            }
            a.this.e.b();
            a.this.a(this.a, this.d, this.e, this.f, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SapiCallback<VoiceRegResult> sapiCallback, String str, boolean z2) {
        VoiceRegResult voiceRegResult = new VoiceRegResult();
        try {
            JSONObject jSONObject = new JSONObject(str);
            int parseInt = Integer.parseInt(jSONObject.optString("errno"));
            voiceRegResult.setResultCode(parseInt);
            switch (parseInt) {
                case 0:
                    if (z2) {
                        com.baidu.sapi2.share.b.a().a(a(jSONObject));
                    }
                    sapiCallback.onSuccess(voiceRegResult);
                    return;
                default:
                    sapiCallback.onFailure(voiceRegResult);
                    return;
            }
        } catch (Exception e2) {
            voiceRegResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
            sapiCallback.onFailure(voiceRegResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(VoiceLoginCallback voiceLoginCallback, String str, String str2) {
        if (voiceLoginCallback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("voiceMd5 can't be empty");
        }
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("uid can't be empty");
        }
        VoiceLoginResult voiceLoginResult = new VoiceLoginResult();
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            voiceLoginResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            voiceLoginCallback.onFailure(voiceLoginResult);
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(B());
        HashMap hashMap = new HashMap();
        hashMap.put("appid", this.c.appId);
        hashMap.put("tpl", this.c.tpl);
        if (!TextUtils.isEmpty(this.c.clientId)) {
            hashMap.put("clientid", this.c.clientId);
        }
        if (!TextUtils.isEmpty(this.c.clientIp)) {
            hashMap.put("clientip", this.c.clientIp);
        }
        String b2 = com.baidu.sapi2.utils.e.b(com.baidu.sapi2.utils.d.J);
        if (!TextUtils.isEmpty(b2)) {
            hashMap.put("di", b2);
        }
        hashMap.put("voicemd5", str);
        hashMap.put("id", SapiDataEncryptor.c(str2));
        hashMap.put("sig", a(hashMap, this.c.appSignKey));
        this.d.post(this.c.context, this.e.a() + com.baidu.sapi2.utils.d.J, new RequestParams(hashMap), new F(voiceLoginCallback, voiceLoginResult, str, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class F extends HttpResponseHandler {
        final /* synthetic */ VoiceLoginCallback a;
        final /* synthetic */ VoiceLoginResult b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;

        F(VoiceLoginCallback voiceLoginCallback, VoiceLoginResult voiceLoginResult, String str, String str2) {
            this.a = voiceLoginCallback;
            this.b = voiceLoginResult;
            this.c = str;
            this.d = str2;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        protected void onStart() {
            this.a.onStart();
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        protected void onFinish() {
            this.a.onFinish();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            a.this.e.d();
            a.this.a(this.a, str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (a.this.e.c()) {
                a.this.e.d();
                this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.a.onFailure(this.b);
                return;
            }
            a.this.e.b();
            a.this.a(this.a, this.c, this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(VoiceLoginCallback voiceLoginCallback, String str) {
        VoiceLoginResult voiceLoginResult = new VoiceLoginResult();
        try {
            JSONObject jSONObject = new JSONObject(str);
            int parseInt = Integer.parseInt(jSONObject.optString("errno"));
            voiceLoginResult.setResultCode(parseInt);
            switch (parseInt) {
                case 0:
                    com.baidu.sapi2.share.b.a().a(a(jSONObject));
                    voiceLoginCallback.onSuccess(voiceLoginResult);
                    break;
                case VoiceLoginResult.RESULT_CODE_PWD_VERIFY_FAILURE /* 71042 */:
                    voiceLoginCallback.onPwdVerifyFailure(voiceLoginResult);
                    break;
                default:
                    voiceLoginCallback.onFailure(voiceLoginResult);
                    break;
            }
        } catch (Exception e2) {
            voiceLoginResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
            voiceLoginCallback.onFailure(voiceLoginResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(VoiceCodeSetCallback voiceCodeSetCallback, VoiceCodeSetDTO voiceCodeSetDTO) {
        if (voiceCodeSetCallback == null) {
            throw new IllegalArgumentException(VoiceCodeSetCallback.class.getSimpleName() + " can't be null");
        }
        if (voiceCodeSetDTO == null) {
            throw new IllegalArgumentException("VoiceCodeSetDTO can't be empty");
        }
        if (TextUtils.isEmpty(voiceCodeSetDTO.bduss)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        if (voiceCodeSetDTO.voiceCode > 10 || voiceCodeSetDTO.voiceCode < 0) {
            throw new IllegalArgumentException("abnormal voice code");
        }
        VoiceCodeSetResult voiceCodeSetResult = new VoiceCodeSetResult();
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            voiceCodeSetResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            voiceCodeSetCallback.onFailure(voiceCodeSetResult);
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(B());
        HashMap hashMap = new HashMap();
        hashMap.put("appid", this.c.appId);
        hashMap.put("tpl", this.c.tpl);
        if (!TextUtils.isEmpty(this.c.clientId)) {
            hashMap.put("clientid", this.c.clientId);
        }
        if (!TextUtils.isEmpty(this.c.clientIp)) {
            hashMap.put("clientip", this.c.clientIp);
        }
        String b2 = com.baidu.sapi2.utils.e.b(com.baidu.sapi2.utils.d.K);
        if (!TextUtils.isEmpty(b2)) {
            hashMap.put("di", b2);
        }
        hashMap.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, String.valueOf(com.baidu.sapi2.d.a(this.c.context).w()));
        hashMap.put("bduss", voiceCodeSetDTO.bduss);
        hashMap.put("password", SapiDataEncryptor.c(String.valueOf(voiceCodeSetDTO.voiceCode)));
        hashMap.put("sig", a(hashMap, this.c.appSignKey));
        this.d.post(this.c.context, this.e.a() + com.baidu.sapi2.utils.d.K, new RequestParams(hashMap), new O(voiceCodeSetCallback, voiceCodeSetResult, voiceCodeSetDTO));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class O extends HttpResponseHandler {
        final /* synthetic */ VoiceCodeSetCallback a;
        final /* synthetic */ VoiceCodeSetResult b;
        final /* synthetic */ VoiceCodeSetDTO c;

        O(VoiceCodeSetCallback voiceCodeSetCallback, VoiceCodeSetResult voiceCodeSetResult, VoiceCodeSetDTO voiceCodeSetDTO) {
            this.a = voiceCodeSetCallback;
            this.b = voiceCodeSetResult;
            this.c = voiceCodeSetDTO;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        protected void onStart() {
            this.a.onStart();
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        protected void onFinish() {
            this.a.onFinish();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            a.this.e.d();
            try {
                int parseInt = Integer.parseInt(new JSONObject(str).optString("errno"));
                this.b.setResultCode(parseInt);
                if (parseInt == 0) {
                    this.a.onSuccess(this.b);
                } else if (1 == parseInt) {
                    this.a.onBdussExpired(this.b);
                } else {
                    this.a.onFailure(this.b);
                }
            } catch (Exception e) {
                this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.a.onFailure(this.b);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (a.this.e.c()) {
                a.this.e.d();
                this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.a.onFailure(this.b);
                return;
            }
            a.this.e.b();
            a.this.a(this.a, this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(QrPCLoginCallBack qrPCLoginCallBack, String str, String str2, String str3, String str4, String str5) {
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
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
            this.d = new AsyncHttpClient();
            this.d.setUserAgent(B());
            HashMap hashMap = new HashMap();
            hashMap.put(SapiUtils.KEY_QR_LOGIN_SIGN, str);
            hashMap.put(IntentConfig.CMD, str2);
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put("bduss", str3);
            }
            if (!TextUtils.isEmpty(str5)) {
                hashMap.put(SapiAccountManager.SESSION_PTOKEN, str5);
            }
            if (!TextUtils.isEmpty(str4)) {
                hashMap.put(SapiAccountManager.SESSION_STOKEN, str4);
            }
            if (!TextUtils.isEmpty(this.c.clientId)) {
                hashMap.put("clientid", this.c.clientId);
            }
            if (!TextUtils.isEmpty(this.c.clientIp)) {
                hashMap.put("clientip", this.c.clientIp);
            }
            hashMap.put("tpl", this.c.tpl);
            hashMap.put("appid", this.c.appId);
            hashMap.put("sig", a(hashMap, this.c.appSignKey));
            this.d.post(this.c.context, this.e.a() + com.baidu.sapi2.utils.d.p, new RequestParams(hashMap), new L(qrPCLoginCallBack, str, str2, str3, str4, str5));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class L extends HttpResponseHandler {
        final /* synthetic */ QrPCLoginCallBack a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;
        final /* synthetic */ String f;

        L(QrPCLoginCallBack qrPCLoginCallBack, String str, String str2, String str3, String str4, String str5) {
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
            a.this.e.d();
            a.this.a(this.a, str);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
            if (a.this.e.c()) {
                a.this.e.d();
                a.this.a(this.a, str);
                return;
            }
            a.this.e.b();
            a.this.a(this.a, this.b, this.c, this.d, this.e, this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(QrPcLoginCallback qrPcLoginCallback, String str, String str2, String str3) {
        if (qrPcLoginCallback == null) {
            throw new IllegalArgumentException(QrPcLoginCallback.class.getSimpleName() + " can't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("sign can't be empty");
        }
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("cmd can't be empty");
        }
        if (TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        QrPcLoginResult qrPcLoginResult = new QrPcLoginResult();
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            qrPcLoginResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            qrPcLoginCallback.onFailure(qrPcLoginResult);
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(B());
        HashMap hashMap = new HashMap();
        hashMap.put(SapiUtils.KEY_QR_LOGIN_SIGN, str);
        hashMap.put(IntentConfig.CMD, str2);
        hashMap.put("bduss", str3);
        if (!TextUtils.isEmpty(this.c.clientId)) {
            hashMap.put("clientid", this.c.clientId);
        }
        if (!TextUtils.isEmpty(this.c.clientIp)) {
            hashMap.put("clientip", this.c.clientIp);
        }
        hashMap.put("tpl", this.c.tpl);
        hashMap.put("appid", this.c.appId);
        hashMap.put("sig", a(hashMap, this.c.appSignKey));
        this.d.post(this.c.context, this.e.a() + com.baidu.sapi2.utils.d.p, new RequestParams(hashMap), new K(qrPcLoginCallback, qrPcLoginResult, str, str2, str3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class K extends HttpResponseHandler {
        final /* synthetic */ QrPcLoginCallback a;
        final /* synthetic */ QrPcLoginResult b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        K(QrPcLoginCallback qrPcLoginCallback, QrPcLoginResult qrPcLoginResult, String str, String str2, String str3) {
            this.a = qrPcLoginCallback;
            this.b = qrPcLoginResult;
            this.c = str;
            this.d = str2;
            this.e = str3;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        protected void onStart() {
            this.a.onStart();
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        protected void onFinish() {
            this.a.onFinish();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (a.this.e.c()) {
                a.this.e.d();
                this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.a.onFailure(this.b);
                return;
            }
            a.this.e.b();
            a.this.a(this.a, this.c, this.d, this.e);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            a.this.e.d();
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.b.setResultCode(Integer.parseInt(jSONObject.optString("errno")));
                switch (this.b.getResultCode()) {
                    case 0:
                        JSONObject optJSONObject = jSONObject.optJSONObject("local");
                        if (optJSONObject != null) {
                            this.b.country = optJSONObject.optString("country");
                            this.b.province = optJSONObject.optString("provice");
                            this.b.city = optJSONObject.optString("city");
                        }
                        this.a.onSuccess(this.b);
                        return;
                    case 2:
                    case 160102:
                        this.a.onBdussExpired(this.b);
                        return;
                    case 3:
                        this.a.onIncompleteUser(this.b);
                        return;
                    default:
                        this.a.onFailure(this.b);
                        return;
                }
            } catch (Throwable th) {
                this.a.onFailure(this.b);
                com.baidu.sapi2.utils.L.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(QrAppLoginCallBack qrAppLoginCallBack, String str, String str2) {
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
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
            this.d = new AsyncHttpClient();
            this.d.setUserAgent(B());
            HashMap hashMap = new HashMap();
            hashMap.put(SapiUtils.KEY_QR_LOGIN_SIGN, str);
            hashMap.put(IntentConfig.CMD, str2);
            if (!TextUtils.isEmpty(this.c.clientId)) {
                hashMap.put("clientid", this.c.clientId);
            }
            if (!TextUtils.isEmpty(this.c.clientIp)) {
                hashMap.put("clientip", this.c.clientIp);
            }
            hashMap.put("tpl", this.c.tpl);
            hashMap.put("appid", this.c.appId);
            hashMap.put("sig", a(hashMap, this.c.appSignKey));
            this.d.post(this.c.context, this.e.a() + com.baidu.sapi2.utils.d.q, new RequestParams(hashMap), new N(qrAppLoginCallBack, str, str2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class N extends HttpResponseHandler {
        final /* synthetic */ QrAppLoginCallBack a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        N(QrAppLoginCallBack qrAppLoginCallBack, String str, String str2) {
            this.a = qrAppLoginCallBack;
            this.b = str;
            this.c = str2;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
            a.this.e.d();
            a.this.a(i, this.a, str);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
            if (a.this.e.c()) {
                a.this.e.d();
                a.this.a(a.this.c(str), this.a, str);
                return;
            }
            a.this.e.b();
            a.this.a(this.a, this.b, this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(SapiCallback<QrAppLoginResult> sapiCallback, String str, String str2) {
        if (sapiCallback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("sign can't be empty");
        }
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("cmd can't be empty");
        }
        QrAppLoginResult qrAppLoginResult = new QrAppLoginResult();
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            qrAppLoginResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            sapiCallback.onFailure(qrAppLoginResult);
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(B());
        HashMap hashMap = new HashMap();
        hashMap.put(SapiUtils.KEY_QR_LOGIN_SIGN, str);
        hashMap.put(IntentConfig.CMD, str2);
        if (!TextUtils.isEmpty(this.c.clientId)) {
            hashMap.put("clientid", this.c.clientId);
        }
        if (!TextUtils.isEmpty(this.c.clientIp)) {
            hashMap.put("clientip", this.c.clientIp);
        }
        hashMap.put("tpl", this.c.tpl);
        hashMap.put("appid", this.c.appId);
        hashMap.put("sig", a(hashMap, this.c.appSignKey));
        this.d.post(this.c.context, this.e.a() + com.baidu.sapi2.utils.d.q, new RequestParams(hashMap), new M(sapiCallback, qrAppLoginResult, str, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class M extends HttpResponseHandler {
        final /* synthetic */ SapiCallback a;
        final /* synthetic */ QrAppLoginResult b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;

        M(SapiCallback sapiCallback, QrAppLoginResult qrAppLoginResult, String str, String str2) {
            this.a = sapiCallback;
            this.b = qrAppLoginResult;
            this.c = str;
            this.d = str2;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        protected void onStart() {
            this.a.onStart();
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        protected void onFinish() {
            this.a.onFinish();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (a.this.e.c()) {
                a.this.e.d();
                this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.a.onFailure(this.b);
                return;
            }
            a.this.e.b();
            a.this.b(this.a, this.c, this.d);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            a.this.e.d();
            try {
                JSONObject jSONObject = new JSONObject(str);
                int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                this.b.setResultCode(parseInt);
                switch (parseInt) {
                    case 0:
                        JSONObject optJSONObject = jSONObject.optJSONObject("local");
                        if (optJSONObject != null) {
                            this.b.country = optJSONObject.optString("country");
                            this.b.province = optJSONObject.optString("provice");
                            this.b.city = optJSONObject.optString("city");
                        }
                        com.baidu.sapi2.share.b.a().a(a.this.a(jSONObject));
                        this.a.onSuccess(this.b);
                        return;
                    default:
                        this.a.onFailure(this.b);
                        return;
                }
            } catch (Throwable th) {
                this.a.onFailure(this.b);
                com.baidu.sapi2.utils.L.e(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(SapiCallBack<SapiResponse> sapiCallBack, String str) {
        if (this.c == null || this.c.context == null) {
            return false;
        }
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            if (sapiCallBack != null) {
                sapiCallBack.onNetworkFailed();
                return false;
            }
            return false;
        } else if (TextUtils.isEmpty(str)) {
            if (sapiCallBack != null) {
                sapiCallBack.onSystemError(SapiErrorCode.PHONE_NULL);
                return false;
            }
            return false;
        } else {
            this.d = new AsyncHttpClient();
            this.d.setUserAgent(B());
            HashMap hashMap = new HashMap();
            hashMap.put("username", str);
            if (!TextUtils.isEmpty(this.c.clientId)) {
                hashMap.put("clientid", this.c.clientId);
            }
            if (!TextUtils.isEmpty(this.c.clientIp)) {
                hashMap.put("clientip", this.c.clientIp);
            }
            hashMap.put("tpl", this.c.tpl);
            hashMap.put("appid", this.c.appId);
            hashMap.put("sig", a(hashMap, this.c.appSignKey));
            this.d.post(this.c.context, this.e.a() + com.baidu.sapi2.utils.d.t, new RequestParams(hashMap), new H(sapiCallBack, str));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class H extends HttpResponseHandler {
        final /* synthetic */ SapiCallBack a;
        final /* synthetic */ String b;

        H(SapiCallBack sapiCallBack, String str) {
            this.a = sapiCallBack;
            this.b = str;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
            a.this.e.d();
            a.this.e(this.a, str);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
            if (a.this.e.c()) {
                a.this.e.d();
                a.this.e(this.a, str);
                return;
            }
            a.this.e.b();
            a.this.a(this.a, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(SapiCallBack<SapiAccountResponse> sapiCallBack, String str) {
        if (this.c == null || this.c.context == null) {
            return false;
        }
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            if (sapiCallBack != null) {
                sapiCallBack.onNetworkFailed();
                return false;
            }
            return false;
        } else if (TextUtils.isEmpty(str)) {
            if (sapiCallBack != null) {
                sapiCallBack.onSystemError(-103);
                return false;
            }
            return false;
        } else {
            this.d = new AsyncHttpClient();
            this.d.setUserAgent(B());
            HashMap hashMap = new HashMap();
            hashMap.put("sms", str);
            if (!TextUtils.isEmpty(this.c.clientId)) {
                hashMap.put("clientid", this.c.clientId);
            }
            if (!TextUtils.isEmpty(this.c.clientIp)) {
                hashMap.put("clientip", this.c.clientIp);
            }
            hashMap.put("tpl", this.c.tpl);
            hashMap.put("appid", this.c.appId);
            hashMap.put("sig", a(hashMap, this.c.appSignKey));
            this.d.post(this.c.context, this.e.a() + com.baidu.sapi2.utils.d.r, new RequestParams(hashMap), new G(sapiCallBack, str));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class G extends HttpResponseHandler {
        final /* synthetic */ SapiCallBack a;
        final /* synthetic */ String b;

        G(SapiCallBack sapiCallBack, String str) {
            this.a = sapiCallBack;
            this.b = str;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
            a.this.e.d();
            a.this.c(i, this.a, str);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
            if (a.this.e.c()) {
                a.this.e.d();
                a.this.c(a.this.c(str), this.a, str);
                return;
            }
            a.this.e.b();
            a.this.b(this.a, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SapiCallback<FastRegResult> sapiCallback, int i2) {
        if (sapiCallback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        }
        FastRegResult fastRegResult = new FastRegResult();
        if (i2 < 10 || i2 > 90) {
            throw new IllegalArgumentException("timeoutSeconds must between 10 and 90");
        }
        if (!SapiUtils.isSimReady(this.c.context)) {
            fastRegResult.setResultCode(-101);
            sapiCallback.onFailure(fastRegResult);
        } else if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            fastRegResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            sapiCallback.onFailure(fastRegResult);
        } else {
            boolean[] zArr = {false};
            String str = UUID.randomUUID().toString() + "-" + System.currentTimeMillis() + ",点击发送直接注册";
            J j2 = new J(Looper.getMainLooper(), zArr);
            I i3 = new I(j2);
            if (SapiUtils.sendSms(this.c.context, str, SapiUtils.getFastRegChannel(this.c.context))) {
                this.d = new AsyncHttpClient();
                this.d.setUserAgent(B());
                Map<String, String> a2 = a(com.baidu.sapi2.utils.d.r);
                a2.put("sms", str);
                a2.put("sig", a(a2, this.c.appSignKey));
                RequestParams requestParams = new RequestParams(a2);
                j2.postDelayed(i3, i2 * 1000);
                sapiCallback.onStart();
                a(sapiCallback, requestParams, j2, i3, zArr);
                return;
            }
            fastRegResult.setResultCode(-102);
            sapiCallback.onFailure(fastRegResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class J extends Handler {
        final /* synthetic */ boolean[] a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        J(Looper looper, boolean[] zArr) {
            super(looper);
            this.a = zArr;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES /* 1001 */:
                    this.a[0] = true;
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class I implements Runnable {
        final /* synthetic */ Handler a;

        I(Handler handler) {
            this.a = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message.obtain(this.a, (int) BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SapiCallback<FastRegResult> sapiCallback, RequestParams requestParams, Handler handler, Runnable runnable, boolean[] zArr) {
        FastRegResult fastRegResult = new FastRegResult();
        if (zArr[0]) {
            this.e.d();
            fastRegResult.setResultCode(-103);
            sapiCallback.onFinish();
            sapiCallback.onFailure(fastRegResult);
            return;
        }
        this.d.post(this.c.context, this.e.a() + com.baidu.sapi2.utils.d.r, requestParams, new HandlerC0021a(fastRegResult, handler, runnable, sapiCallback, requestParams, zArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.sapi2.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class HandlerC0021a extends HttpResponseHandler {
        final /* synthetic */ FastRegResult a;
        final /* synthetic */ Handler b;
        final /* synthetic */ Runnable c;
        final /* synthetic */ SapiCallback d;
        final /* synthetic */ RequestParams e;
        final /* synthetic */ boolean[] f;

        HandlerC0021a(FastRegResult fastRegResult, Handler handler, Runnable runnable, SapiCallback sapiCallback, RequestParams requestParams, boolean[] zArr) {
            this.a = fastRegResult;
            this.b = handler;
            this.c = runnable;
            this.d = sapiCallback;
            this.e = requestParams;
            this.f = zArr;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            int b = a.this.b(str);
            this.a.setResultCode(b);
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.a.setResultMsg(jSONObject.optJSONObject("sdk").optString(AddFriendActivityConfig.MSG));
                switch (b) {
                    case 0:
                        a.this.e.d();
                        com.baidu.sapi2.share.b.a().a(a.this.a(jSONObject));
                        this.a.newReg = jSONObject.optBoolean("newreg");
                        this.a.authSid = jSONObject.optString("authsid");
                        if ("null".equals(this.a.authSid)) {
                            this.a.authSid = null;
                        }
                        this.b.removeCallbacks(this.c);
                        this.d.onFinish();
                        this.d.onSuccess(this.a);
                        return;
                    case 7:
                        this.b.postDelayed(new RunnableC0022a(), 400L);
                        return;
                    default:
                        a.this.e.d();
                        this.b.removeCallbacks(this.c);
                        this.d.onFinish();
                        this.d.onFailure(this.a);
                        return;
                }
            } catch (Exception e) {
                a.this.e.d();
                this.b.removeCallbacks(this.c);
                this.d.onFinish();
                this.d.onFailure(this.a);
                com.baidu.sapi2.utils.L.e(e);
            }
        }

        /* renamed from: com.baidu.sapi2.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0022a implements Runnable {
            RunnableC0022a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a(HandlerC0021a.this.d, HandlerC0021a.this.e, HandlerC0021a.this.b, HandlerC0021a.this.c, HandlerC0021a.this.f);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (a.this.e.c()) {
                a.this.e.d();
                this.a.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.b.removeCallbacks(this.c);
                this.d.onFinish();
                this.d.onFailure(this.a);
                return;
            }
            a.this.e.b();
            a.this.a(this.d, this.e, this.b, this.c, this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        if (this.c.b2cSyncEnabled() && SapiUtils.hasActiveNetwork(this.c.context)) {
            if (com.baidu.sapi2.d.a(this.c.context).q() == null || com.baidu.sapi2.d.a(this.c.context).u()) {
                this.d = new AsyncHttpClient();
                this.d.setUserAgent(B());
                HashMap hashMap = new HashMap();
                if (!TextUtils.isEmpty(this.c.clientId)) {
                    hashMap.put("clientid", this.c.clientId);
                }
                if (!TextUtils.isEmpty(this.c.clientIp)) {
                    hashMap.put("clientip", this.c.clientIp);
                }
                hashMap.put("tpl", this.c.tpl);
                hashMap.put("appid", this.c.appId);
                hashMap.put("deviceid", SapiUtils.getCUID(this.c.context));
                hashMap.put(SapiUtils.QR_LOGIN_LP_APP, this.c.context.getPackageName());
                hashMap.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, String.valueOf(com.baidu.sapi2.d.a(this.c.context).w()));
                hashMap.put("sig", a(hashMap, this.c.appSignKey));
                this.d.post(this.c.context, this.e.a() + com.baidu.sapi2.utils.d.M, new RequestParams(hashMap), new V());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class V extends HttpResponseHandler {
        V() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            a.this.e.d();
            if (a.this.b(str) == 0) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("sn", jSONObject.optString("sn"));
                    jSONObject2.put("seed", jSONObject.optString("seed"));
                    jSONObject2.put("pubkey", jSONObject.optString("pubkey"));
                    com.baidu.sapi2.d.a(a.this.c.context).f(jSONObject2.toString());
                } catch (Exception e) {
                    com.baidu.sapi2.utils.L.e(e);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (a.this.e.c()) {
                a.this.e.d();
                return;
            }
            a.this.e.b();
            a.this.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, String str3, int i2) {
        if (SapiUtils.hasActiveNetwork(this.c.context)) {
            String s2 = com.baidu.sapi2.d.a(this.c.context).s();
            String t2 = com.baidu.sapi2.d.a(this.c.context).t();
            if (!TextUtils.isEmpty(s2) && !TextUtils.isEmpty(t2) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (!str.equals(com.baidu.sapi2.d.a(this.c.context).r())) {
                    com.baidu.sapi2.d.a(this.c.context).c(true);
                    return;
                }
                this.d = new AsyncHttpClient();
                this.d.setUserAgent(B());
                HashMap hashMap = new HashMap();
                if (!TextUtils.isEmpty(this.c.clientId)) {
                    hashMap.put("clientid", this.c.clientId);
                }
                if (!TextUtils.isEmpty(this.c.clientIp)) {
                    hashMap.put("clientip", this.c.clientIp);
                }
                hashMap.put("tpl", this.c.tpl);
                hashMap.put("appid", this.c.appId);
                hashMap.put("deviceid", SapiUtils.getCUID(this.c.context));
                hashMap.put(SapiUtils.QR_LOGIN_LP_APP, this.c.context.getPackageName());
                hashMap.put("sync", com.baidu.sapi2.utils.b.b(str2, t2));
                hashMap.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, String.valueOf(com.baidu.sapi2.d.a(this.c.context).w()));
                String str4 = null;
                try {
                    str4 = SoftToken.getToken(s2, com.baidu.sapi2.d.a(this.c.context).v());
                } catch (Throwable th) {
                    com.baidu.sapi2.utils.L.e(th);
                }
                if (!TextUtils.isEmpty(str4)) {
                    hashMap.put(SapiUtils.KEY_QR_LOGIN_SIGN, a(hashMap, str4));
                    hashMap.put("sig", a(hashMap, this.c.appSignKey));
                    this.d.post(this.c.context, this.e.a() + com.baidu.sapi2.utils.d.N, new RequestParams(hashMap), new k(str3, i2, str, str2));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class k extends HttpResponseHandler {
        final /* synthetic */ String a;
        final /* synthetic */ int b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;

        k(String str, int i, String str2, String str3) {
            this.a = str;
            this.b = i;
            this.c = str2;
            this.d = str3;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            a.this.e.d();
            switch (a.this.b(str)) {
                case 0:
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        SapiAccount sapiAccount = new SapiAccount();
                        sapiAccount.bduss = jSONObject.optString("bduss");
                        sapiAccount.uid = jSONObject.optString("uid");
                        sapiAccount.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                        sapiAccount.username = jSONObject.optString("username");
                        sapiAccount.ptoken = jSONObject.optString(SapiAccountManager.SESSION_PTOKEN);
                        sapiAccount.app = "Web浏览器";
                        com.baidu.sapi2.share.b.a().a(sapiAccount, false);
                        HashMap hashMap = new HashMap();
                        hashMap.put(SapiUtils.QR_LOGIN_LP_APP, sapiAccount.app);
                        hashMap.put("sync_type", this.a);
                        StatService.a("b2c_login_share", hashMap);
                        return;
                    } catch (JSONException e) {
                        com.baidu.sapi2.utils.L.e(e);
                        return;
                    }
                case 4:
                    a.this.b(new C0023a());
                    return;
                default:
                    return;
            }
        }

        /* renamed from: com.baidu.sapi2.a$k$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0023a implements SapiCallback<SapiResult> {
            C0023a() {
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(SapiResult sapiResult) {
                if (k.this.b > 0) {
                    a.this.a(k.this.c, k.this.d, k.this.a, k.this.b - 1);
                }
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(SapiResult sapiResult) {
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onStart() {
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (a.this.e.c()) {
                a.this.e.d();
                return;
            }
            a.this.e.b();
            a.this.a(this.c, this.d, this.a, this.b);
        }
    }

    void b(SapiCallback<SapiResult> sapiCallback) {
        SapiResult sapiResult = new SapiResult();
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            sapiResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            sapiCallback.onFailure(sapiResult);
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(B());
        RequestParams requestParams = new RequestParams();
        if (!TextUtils.isEmpty(this.c.clientId)) {
            requestParams.put(SocialConstants.PARAM_CUID, this.c.clientId);
        }
        requestParams.put("tpl", this.c.tpl);
        requestParams.put("appid", this.c.appId);
        this.d.get(this.c.context, o(), requestParams, new U(sapiCallback, sapiResult));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class U extends HttpResponseHandler {
        final /* synthetic */ SapiCallback a;
        final /* synthetic */ SapiResult b;

        U(SapiCallback sapiCallback, SapiResult sapiResult) {
            this.a = sapiCallback;
            this.b = sapiResult;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        protected void onStart() {
            this.a.onStart();
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        protected void onFinish() {
            this.a.onFinish();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            try {
                int b = a.this.b(str);
                this.b.setResultCode(b);
                if (b == 0 || b == 110000) {
                    long optLong = new JSONObject(str).optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, System.currentTimeMillis() / 1000);
                    com.baidu.sapi2.d.a(a.this.c.context).a((int) (optLong - (System.currentTimeMillis() / 1000)));
                    this.a.onSuccess(this.b);
                    return;
                }
            } catch (Throwable th) {
                com.baidu.sapi2.utils.L.e(th);
            }
            this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
            this.a.onFailure(this.b);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
            this.a.onFailure(this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (this.c != null && this.c.context != null && SapiUtils.hasActiveNetwork(this.c.context)) {
            this.d = new AsyncHttpClient();
            this.d.setUserAgent(B());
            HashMap hashMap = new HashMap();
            if (com.baidu.sapi2.d.a(this.c.context).a() != null) {
                hashMap.put("device_id", com.baidu.sapi2.utils.a.d(this.c.context));
                hashMap.put("device_token", com.baidu.sapi2.d.a(this.c.context).a());
            }
            this.d.get(this.c.context, C().getDeviceUrl() + com.baidu.sapi2.utils.d.A, new RequestParams(hashMap), new T());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class T extends HttpResponseHandler {
        T() {
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            if (str != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has(SocialConstants.PARAM_ERROR_CODE) || jSONObject.has(SocialConstants.PARAM_ERROR_MSG) || jSONObject.optInt("fulfilbind") != 0) {
                        return;
                    }
                    if (jSONObject.optInt(TbConfig.ST_TYPE_REG) == 1 || jSONObject.optInt("login") == 1) {
                        com.baidu.sapi2.d.a(a.this.c.context).a(true);
                    }
                } catch (JSONException e) {
                    com.baidu.sapi2.utils.L.e(e);
                    com.baidu.sapi2.d.a(a.this.c.context).a(false);
                }
            }
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
            com.baidu.sapi2.d.a(a.this.c.context).a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(SapiCallBack<SapiResponse> sapiCallBack) {
        if (this.c == null || this.c.context == null || TextUtils.isEmpty(this.c.deviceLoginSignKey) || !com.baidu.sapi2.d.a(this.c.context).b()) {
            return false;
        }
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            if (sapiCallBack != null) {
                sapiCallBack.onNetworkFailed();
                return false;
            }
            return false;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(B());
        HashMap hashMap = new HashMap();
        String a2 = a.C0039a.a(com.baidu.sapi2.utils.a.d(this.c.context));
        hashMap.put("ptpl", this.c.tpl);
        hashMap.put("device_id", a2);
        hashMap.put("device_info", com.baidu.sapi2.utils.a.d());
        hashMap.put("package_sign", this.c.deviceLoginSignKey);
        this.d.post(this.c.context, C().getDeviceUrl() + com.baidu.sapi2.utils.d.B, new RequestParams(hashMap), new S(sapiCallBack));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class S extends HttpResponseHandler {
        final /* synthetic */ SapiCallBack a;

        S(SapiCallBack sapiCallBack) {
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
            a.this.a(a.this.c(str), this.a, str);
        }
    }

    void c(SapiCallBack<SapiResponse> sapiCallBack, String str) {
        if (this.c != null && this.c.context != null && !TextUtils.isEmpty(this.c.deviceLoginSignKey)) {
            if (!SapiUtils.hasActiveNetwork(this.c.context)) {
                if (sapiCallBack != null) {
                    sapiCallBack.onNetworkFailed();
                    return;
                }
                return;
            }
            this.d = new AsyncHttpClient();
            this.d.setUserAgent(B());
            HashMap hashMap = new HashMap();
            String a2 = a.C0039a.a(com.baidu.sapi2.utils.a.d(this.c.context));
            hashMap.put("ptpl", this.c.tpl);
            hashMap.put("device_id", a2);
            hashMap.put("device_info", com.baidu.sapi2.utils.a.d());
            hashMap.put("force_reg_token", str);
            this.d.post(this.c.context, C().getDeviceUrl() + com.baidu.sapi2.utils.d.D, new RequestParams(hashMap), new R(sapiCallBack));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class R extends HttpResponseHandler {
        final /* synthetic */ SapiCallBack a;

        R(SapiCallBack sapiCallBack) {
            this.a = sapiCallBack;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            a.this.b(i, this.a, str);
            super.onSuccess(i, str);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            a.this.b(a.this.c(str), this.a, str);
            super.onFailure(th, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(SapiCallBack<SapiResponse> sapiCallBack, String str) {
        if (this.c == null || this.c.context == null || TextUtils.isEmpty(this.c.deviceLoginSignKey)) {
            return false;
        }
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            if (sapiCallBack != null) {
                sapiCallBack.onNetworkFailed();
                return false;
            }
            return false;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(B());
        HashMap hashMap = new HashMap();
        String a2 = a.C0039a.a(com.baidu.sapi2.utils.a.d(this.c.context));
        hashMap.put("ptpl", this.c.tpl);
        hashMap.put("device_id", a2);
        hashMap.put("device_token", str);
        hashMap.put("package_sign", this.c.deviceLoginSignKey);
        this.d.post(this.c.context, C().getDeviceUrl() + com.baidu.sapi2.utils.d.C, new RequestParams(hashMap), new Q(sapiCallBack));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class Q extends HttpResponseHandler {
        final /* synthetic */ SapiCallBack a;

        Q(SapiCallBack sapiCallBack) {
            this.a = sapiCallBack;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            a.this.a(i, this.a, str);
            super.onSuccess(i, str);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            a.this.a(a.this.c(str), this.a, str);
            super.onFailure(th, str);
        }
    }

    void a(int i2, SapiCallBack<SapiResponse> sapiCallBack, String str) {
        if (str != null) {
            SapiAccountResponse sapiAccountResponse = new SapiAccountResponse();
            try {
                JSONObject jSONObject = new JSONObject(str);
                sapiAccountResponse.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                sapiAccountResponse.uid = jSONObject.optString("uid");
                sapiAccountResponse.bduss = jSONObject.optString("bduss");
                sapiAccountResponse.ptoken = jSONObject.optString(SapiAccountManager.SESSION_PTOKEN);
                if (jSONObject.optInt(SocialConstants.PARAM_ERROR_CODE) == 104) {
                    c(sapiCallBack, jSONObject.optString("force_reg_token"));
                    return;
                }
                if (!jSONObject.has(SocialConstants.PARAM_ERROR_CODE) && !jSONObject.has(SocialConstants.PARAM_ERROR_MSG)) {
                    SapiAccount sapiAccount = new SapiAccount();
                    sapiAccount.uid = sapiAccountResponse.uid;
                    sapiAccount.bduss = sapiAccountResponse.bduss;
                    sapiAccount.displayname = sapiAccountResponse.displayname;
                    sapiAccount.stoken = sapiAccountResponse.stoken;
                    sapiAccount.ptoken = sapiAccountResponse.ptoken;
                    sapiAccount.app = SapiUtils.getAppName(this.c.context);
                    if (jSONObject.has("device_token")) {
                        com.baidu.sapi2.d.a(this.c.context).a(jSONObject.getString("device_token"));
                    }
                    com.baidu.sapi2.share.b.a().a(sapiAccount);
                }
                if (sapiCallBack != null) {
                    switch (jSONObject.optInt(SocialConstants.PARAM_ERROR_CODE)) {
                        case 0:
                            sapiCallBack.onSuccess(null);
                            return;
                        default:
                            sapiCallBack.onSystemError(jSONObject.optInt(SocialConstants.PARAM_ERROR_CODE));
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
                sapiAccountResponse.uid = jSONObject.optString("uid");
                sapiAccountResponse.bduss = jSONObject.optString("bduss");
                sapiAccountResponse.ptoken = jSONObject.optString(SapiAccountManager.SESSION_PTOKEN);
                if (!jSONObject.has(SocialConstants.PARAM_ERROR_CODE) && !jSONObject.has(SocialConstants.PARAM_ERROR_MSG)) {
                    SapiAccount sapiAccount = new SapiAccount();
                    sapiAccount.uid = sapiAccountResponse.uid;
                    sapiAccount.bduss = sapiAccountResponse.bduss;
                    sapiAccount.displayname = sapiAccountResponse.displayname;
                    sapiAccount.stoken = sapiAccountResponse.stoken;
                    sapiAccount.ptoken = sapiAccountResponse.ptoken;
                    sapiAccount.app = SapiUtils.getAppName(this.c.context);
                    if (jSONObject.has("device_token")) {
                        com.baidu.sapi2.d.a(this.c.context).a(jSONObject.getString("device_token"));
                    }
                    com.baidu.sapi2.share.b.a().a(sapiAccount);
                }
                if (sapiCallBack != null) {
                    switch (jSONObject.optInt(SocialConstants.PARAM_ERROR_CODE)) {
                        case 0:
                            sapiCallBack.onSuccess(null);
                            return;
                        default:
                            sapiCallBack.onSystemError(jSONObject.optInt(SocialConstants.PARAM_ERROR_CODE));
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

    Map<String, String> a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("tpl", this.c.tpl);
        hashMap.put("appid", this.c.appId);
        if (TextUtils.isEmpty(this.c.clientId)) {
            this.c.clientId = SapiUtils.getClientId(this.c.context);
        }
        if (!TextUtils.isEmpty(this.c.clientId)) {
            hashMap.put("clientid", this.c.clientId);
        }
        if (!TextUtils.isEmpty(com.baidu.sapi2.utils.e.b(str))) {
            hashMap.put("di", com.baidu.sapi2.utils.e.b(str));
        }
        hashMap.put("clientfrom", "mobilesdk_enhanced");
        hashMap.put("sdk_version", "3");
        return hashMap;
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
                com.baidu.sapi2.utils.L.e(e2);
            }
            sb.append("&");
        }
        sb.append("sign_key=").append(str);
        return MD5Util.toMd5(sb.toString().getBytes(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String B() {
        return "tpl:" + this.c.tpl + ";android_sapi_v" + SapiAccountManager.VERSION_NAME;
    }

    int b(String str) {
        try {
            return new JSONObject(str).getInt("errno");
        } catch (Exception e2) {
            com.baidu.sapi2.utils.L.e(e2);
            return -100;
        }
    }

    int c(String str) {
        int b2 = b(str);
        if (b2 == 110000) {
            return 0;
        }
        return b2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, FillUsernameCallBack fillUsernameCallBack, String str, SapiDataEncryptor sapiDataEncryptor) {
        if (str != null) {
            SapiAccountResponse sapiAccountResponse = new SapiAccountResponse();
            try {
                String optString = new JSONObject(str).optString("userinfo");
                if (!TextUtils.isEmpty(optString)) {
                    JSONObject jSONObject = new JSONObject(sapiDataEncryptor.a(optString));
                    sapiAccountResponse.bduss = jSONObject.optString("bduss");
                    sapiAccountResponse.ptoken = jSONObject.optString(SapiAccountManager.SESSION_PTOKEN);
                    sapiAccountResponse.stoken = jSONObject.optString(SapiAccountManager.SESSION_STOKEN);
                    sapiAccountResponse.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                    sapiAccountResponse.uid = jSONObject.optString("uid");
                    sapiAccountResponse.username = jSONObject.optString("uname");
                    sapiAccountResponse.email = jSONObject.optString("email");
                    switch (i2) {
                        case 0:
                            SapiAccount a2 = a(sapiAccountResponse);
                            a2.extra = jSONObject.toString();
                            com.baidu.sapi2.share.b.a().a(a2);
                            fillUsernameCallBack.onSuccess(sapiAccountResponse);
                            break;
                        case 160103:
                            fillUsernameCallBack.onInvalidBduss();
                            break;
                        case 160104:
                            fillUsernameCallBack.onUserHaveUsername();
                            break;
                        case 160105:
                        case 160111:
                            fillUsernameCallBack.onUsernameAlreadyExist();
                            break;
                        case 160110:
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

    void a(QrPCLoginCallBack qrPCLoginCallBack, String str) {
        qrPCLoginCallBack.onFinish();
        try {
            JSONObject jSONObject = new JSONObject(str);
            int parseInt = Integer.parseInt(jSONObject.optString("errno"));
            switch (parseInt) {
                case -103:
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
                case 160102:
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
                    com.baidu.sapi2.share.b.a().a(a(jSONObject));
                }
                if (qrAppLoginCallBack != null) {
                    switch (parseInt) {
                        case -103:
                        case 1:
                            qrAppLoginCallBack.onQrCodeInvalid();
                            return;
                        case 0:
                            qrAppLoginCallBack.onSuccess(qrAppLoginResponse);
                            return;
                        case 2:
                        case 160102:
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
                sapiAccountResponse.uid = jSONObject.optString("uid");
                sapiAccountResponse.bduss = jSONObject.optString("bduss");
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

    SapiAccount a(JSONObject jSONObject) {
        SapiAccount sapiAccount = new SapiAccount();
        sapiAccount.uid = jSONObject.optString("uid");
        sapiAccount.bduss = jSONObject.optString("bduss");
        sapiAccount.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
        sapiAccount.username = jSONObject.optString("uname");
        sapiAccount.stoken = jSONObject.optString(SapiAccountManager.SESSION_STOKEN);
        sapiAccount.ptoken = jSONObject.optString(SapiAccountManager.SESSION_PTOKEN);
        sapiAccount.extra = jSONObject.toString();
        sapiAccount.app = SapiUtils.getAppName(this.c.context);
        return sapiAccount;
    }

    SapiAccount a(SapiAccountResponse sapiAccountResponse) {
        SapiAccount sapiAccount = new SapiAccount();
        sapiAccount.displayname = sapiAccountResponse.displayname;
        sapiAccount.bduss = sapiAccountResponse.bduss;
        sapiAccount.ptoken = sapiAccountResponse.ptoken;
        sapiAccount.stoken = sapiAccountResponse.stoken;
        sapiAccount.uid = sapiAccountResponse.uid;
        sapiAccount.username = sapiAccountResponse.username;
        sapiAccount.app = SapiUtils.getAppName(this.c.context);
        return sapiAccount;
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

    private Domain C() {
        return this.c.environment;
    }

    private String D() {
        return this.e.a() + "/sslcrypt/get_last_cert";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String f() {
        return C().getWap() + "/passport/login";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String g() {
        return C().getWap() + "/passport/getpass";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String h() {
        return C().getWap() + "/wp/wappassword";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String i() {
        return C().getWap() + "/wp/recordindex";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String j() {
        return C().getWap() + "/v2/?bindingaccount&";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String k() {
        return C().getWap() + "/v2/?bindingret";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(BindWidgetAction bindWidgetAction) {
        return C().getWap() + bindWidgetAction.getUri();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String l() {
        return C().getWap() + "/passport/authwidget";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String m() {
        return C().getWap() + "/wp/unitewidget";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String n() {
        return C().getWap() + "/wp/accountwidget-init";
    }

    String o() {
        return C().getWap() + "/wp/api/security/antireplaytoken";
    }

    String p() {
        return this.e.a() + "/v2/sapi/center/filluname";
    }

    String q() {
        return this.e.a() + "/v2/sapi/center/setportrait";
    }

    String r() {
        return C().getPortraitUrl() + "/sys/history";
    }

    String s() {
        return this.e.a() + "/v2/sapi/center/getuinfo";
    }

    String t() {
        return C().getPortraitUrl() + "/sys/portrait/hotitemlist";
    }

    String u() {
        return C().getPortraitUrl() + "/sys/sethotitem";
    }

    String v() {
        return this.e.a() + com.baidu.sapi2.utils.d.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String w() {
        return this.e.a() + "/phoenix/account/ssologin";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String x() {
        return this.e.a() + "/phoenix/account/ssologin";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String y() {
        return this.e.a() + com.baidu.sapi2.utils.d.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String z() {
        return this.e.a() + com.baidu.sapi2.utils.d.n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String A() {
        return this.e.a() + com.baidu.sapi2.utils.d.o;
    }
}
