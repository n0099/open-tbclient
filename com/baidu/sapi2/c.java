package com.baidu.sapi2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Xml;
import com.baidu.android.common.security.MD5Util;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.BinaryHttpResponseHandler;
import com.baidu.cloudsdk.common.http.HttpResponseHandler;
import com.baidu.cloudsdk.common.http.MultipartRequestParams;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.callback.GetHistoryPortraitsCallback;
import com.baidu.sapi2.callback.GetPopularPortraitsCallback;
import com.baidu.sapi2.callback.GetRegCodeCallback;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.callback.LoginCallback;
import com.baidu.sapi2.callback.QuickUserRegCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.callback.SetPopularPortraitCallback;
import com.baidu.sapi2.callback.VoiceCheckCallback;
import com.baidu.sapi2.callback.VoiceLoginCallback;
import com.baidu.sapi2.dto.GetHistoryPortraitsDTO;
import com.baidu.sapi2.dto.LoginDTO;
import com.baidu.sapi2.dto.PhoneRegDTO;
import com.baidu.sapi2.dto.QuickUserRegDTO;
import com.baidu.sapi2.dto.SetPopularPortraitDTO;
import com.baidu.sapi2.dto.VoiceCheckDTO;
import com.baidu.sapi2.result.DynamicPwdLoginResult;
import com.baidu.sapi2.result.FastRegResult;
import com.baidu.sapi2.result.GetCaptchaResult;
import com.baidu.sapi2.result.GetDynamicPwdResult;
import com.baidu.sapi2.result.GetHistoryPortraitsResult;
import com.baidu.sapi2.result.GetPopularPortraitsInfoResult;
import com.baidu.sapi2.result.GetRegCodeResult;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.result.LoginResult;
import com.baidu.sapi2.result.OAuthResult;
import com.baidu.sapi2.result.PhoneRegResult;
import com.baidu.sapi2.result.QuickUserRegResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.SetPopularPortraitResult;
import com.baidu.sapi2.result.VoiceCheckResult;
import com.baidu.sapi2.result.VoiceLoginResult;
import com.baidu.sapi2.result.VoiceRegResult;
import com.baidu.sapi2.share.SoftToken;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.sapi2.shell.callback.FillUserProfileCallBack;
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
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.b;
import com.baidu.sapi2.utils.c;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.QrLoginAction;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.game.GameInfoData;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
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
public final class c {
    private static final int a = 6;
    private static final String b = "3";
    private SapiConfiguration c = SapiAccountManager.getInstance().getSapiConfiguration();
    private AsyncHttpClient d;
    private com.baidu.sapi2.utils.f e;
    private String f;
    private LoginDTO g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.e = new com.baidu.sapi2.utils.f(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.d != null) {
            this.d.cancelRequests(this.c.context, true);
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
            com.baidu.sapi2.utils.b bVar = new com.baidu.sapi2.utils.b();
            try {
                this.d = new AsyncHttpClient();
                this.d.setUserAgent(A());
                HashMap hashMap = new HashMap();
                hashMap.put("crypttype", "11");
                hashMap.put("tpl", this.c.tpl);
                hashMap.put("appid", this.c.appId);
                if (TextUtils.isEmpty(this.c.clientId)) {
                    this.c.clientId = SapiUtils.getClientId(this.c.context);
                }
                hashMap.put("cuid", this.c.clientId);
                hashMap.put("cert_id", String.valueOf(2));
                hashMap.put("isdpass", GameInfoData.NOT_FROM_DETAIL);
                hashMap.put("username", reloginCredentials.account);
                hashMap.put("password", reloginCredentials.password);
                hashMap.put("UBI", reloginCredentials.ubi);
                hashMap.put("isphone", "3".equals(reloginCredentials.accountType) ? "1" : GameInfoData.NOT_FROM_DETAIL);
                hashMap.put(LoginActivityConfig.LOGIN_TYPE, "3");
                hashMap.put("key", bVar.a());
                hashMap.put("sdk_version", "2");
                hashMap.put("pinfo", com.baidu.sapi2.utils.c.b());
                hashMap.put("sig", a(hashMap, this.c.appSignKey));
                this.d.post(this.c.context, u(), new RequestParams(hashMap), new j(sapiCallBack, reloginCredentials));
            } catch (Exception e2) {
                d(-100, sapiCallBack, null);
                com.baidu.sapi2.utils.L.e(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class j extends HttpResponseHandler {
        final /* synthetic */ SapiCallBack a;
        final /* synthetic */ SapiAccount.ReloginCredentials b;

        j(SapiCallBack sapiCallBack, SapiAccount.ReloginCredentials reloginCredentials) {
            this.a = sapiCallBack;
            this.b = reloginCredentials;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
            c.this.d(c.this.b(str), this.a, str);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
            if (c.this.e.c()) {
                c.this.e.d();
                c.this.d(c.this.b(str), this.a, str);
                return;
            }
            c.this.e.b();
            c.this.a(this.a, this.b);
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
        com.baidu.sapi2.utils.b bVar = new com.baidu.sapi2.utils.b();
        try {
            this.d = new AsyncHttpClient();
            this.d.setUserAgent(A());
            HashMap hashMap = new HashMap();
            hashMap.put("crypttype", "11");
            hashMap.put("tpl", this.c.tpl);
            hashMap.put("appid", this.c.appId);
            if (TextUtils.isEmpty(this.c.clientId)) {
                this.c.clientId = SapiUtils.getClientId(this.c.context);
            }
            hashMap.put("cuid", this.c.clientId);
            hashMap.put("cert_id", "2");
            hashMap.put("isdpass", GameInfoData.NOT_FROM_DETAIL);
            hashMap.put("username", reloginCredentials.account);
            hashMap.put("password", reloginCredentials.password);
            hashMap.put("UBI", reloginCredentials.ubi);
            hashMap.put("isphone", "3".equals(reloginCredentials.accountType) ? "1" : GameInfoData.NOT_FROM_DETAIL);
            hashMap.put(LoginActivityConfig.LOGIN_TYPE, "3");
            hashMap.put("key", bVar.a());
            hashMap.put("sdk_version", "2");
            hashMap.put("pinfo", com.baidu.sapi2.utils.c.b());
            hashMap.put("sig", a(hashMap, this.c.appSignKey));
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                arrayList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            HttpUriRequest httpPost = new HttpPost(u());
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
                sapiAccountResponse.bduss = jSONObject.optString(SapiAccountManager.SESSION_BDUSS);
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
            this.d.setUserAgent(A());
            Map<String, String> a2 = a(com.baidu.sapi2.utils.g.a);
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
                a2.put("isphone", GameInfoData.NOT_FROM_DETAIL);
            }
            if (loginDTO.loginType == LoginDTO.LoginType.PHONE) {
                a2.put("isphone", "1");
            }
            com.baidu.sapi2.utils.b bVar = new com.baidu.sapi2.utils.b();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("username", loginDTO.account);
                jSONObject.put("password", loginDTO.password);
                jSONObject.put(LoginActivityConfig.LOGIN_TYPE, "3");
                jSONObject.put("key", bVar.a());
                a2.put("userinfo", bVar.a(b.C0021b.b, jSONObject.toString()));
                a2.put("sig", a(a2, this.c.appSignKey));
                this.d.post(this.c.context, u(), new RequestParams(a2), new b(loginCallback, loginResult, bVar, loginDTO));
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
        final /* synthetic */ com.baidu.sapi2.utils.b c;
        final /* synthetic */ LoginDTO d;

        b(LoginCallback loginCallback, LoginResult loginResult, com.baidu.sapi2.utils.b bVar, LoginDTO loginDTO) {
            this.a = loginCallback;
            this.b = loginResult;
            this.c = bVar;
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
            c.this.e.d();
            int b = c.this.b(str);
            this.b.setResultCode(b);
            try {
                JSONObject jSONObject = new JSONObject(this.c.a(new JSONObject(str).optString("userinfo")));
                JSONObject optJSONObject = jSONObject.optJSONObject("sdk");
                this.b.setResultMsg(optJSONObject.optString(AddFriendActivityConfig.MSG));
                SapiResult.Action action = new SapiResult.Action();
                action.actionMode = SapiResult.ActionMode.fromString(optJSONObject.optString("action"));
                action.actionType = SapiResult.ActionType.fromString(optJSONObject.optString("type"));
                action.actionTitle = optJSONObject.optString("title");
                action.actionUrl = optJSONObject.optString(ImageViewerConfig.URL);
                this.b.action = action;
                if (jSONObject.optInt("needvcode") == 1) {
                    c.this.f = jSONObject.optString("vcodestr");
                    this.a.onCaptchaRequired(this.b);
                }
                switch (action.actionMode) {
                    case URL:
                        c.this.g = this.d;
                        this.a.onProxyActionRequired(this.b);
                        return;
                    case MSG:
                        if (b == 0) {
                            SapiAccount a = c.this.a(jSONObject);
                            SapiAccount.ReloginCredentials reloginCredentials = new SapiAccount.ReloginCredentials();
                            reloginCredentials.account = this.d.account;
                            reloginCredentials.accountType = jSONObject.optString("logintype");
                            reloginCredentials.password = com.baidu.sapi2.utils.b.e(this.d.password);
                            reloginCredentials.ubi = jSONObject.optString("ubi");
                            com.baidu.sapi2.d.a(c.this.c.context).a(a.uid, reloginCredentials);
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
            if (c.this.e.c()) {
                c.this.e.d();
                this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.a.onFailure(this.b);
                return;
            }
            c.this.e.b();
            c.this.a(this.a, this.d);
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
            this.d.setUserAgent(A());
            this.d.get(this.c.context, str, new a(sapiCallback, loginResult));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends HttpResponseHandler {
        final /* synthetic */ SapiCallback a;
        final /* synthetic */ LoginResult b;

        a(SapiCallback sapiCallback, LoginResult loginResult) {
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
                        sapiAccount.app = SapiUtils.getAppName(c.this.c.context);
                        SapiAccount.ReloginCredentials reloginCredentials = new SapiAccount.ReloginCredentials();
                        reloginCredentials.account = c.this.g.account;
                        reloginCredentials.password = com.baidu.sapi2.utils.b.e(c.this.g.password);
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
                                    } else if (name.equalsIgnoreCase(SapiAccountManager.SESSION_BDUSS)) {
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
                        com.baidu.sapi2.d.a(c.this.c.context).a(sapiAccount.uid, reloginCredentials);
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
    public String b() {
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
        this.d.setUserAgent(A());
        this.d.get(this.c.context, this.e.a() + com.baidu.sapi2.utils.g.f + this.f, new e(new String[]{"image/png", "image/jpeg", "image/jpg", "image/gif"}, getCaptchaResult, sapiCallback));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends BinaryHttpResponseHandler {
        final /* synthetic */ GetCaptchaResult a;
        final /* synthetic */ SapiCallback b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String[] strArr, GetCaptchaResult getCaptchaResult, SapiCallback sapiCallback) {
            super(strArr);
            this.a = getCaptchaResult;
            this.b = sapiCallback;
        }

        @Override // com.baidu.cloudsdk.common.http.BinaryHttpResponseHandler
        protected void onSuccess(byte[] bArr) {
            c.this.e.d();
            if (bArr != null) {
                this.a.setResultCode(0);
                this.a.captchaImage = bArr;
                this.b.onSuccess(this.a);
                return;
            }
            this.a.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
            this.b.onFailure(this.a);
        }

        @Override // com.baidu.cloudsdk.common.http.BinaryHttpResponseHandler
        protected void onFailure(Throwable th, byte[] bArr) {
            if (c.this.e.c()) {
                c.this.e.d();
                this.a.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.b.onFailure(this.a);
                return;
            }
            c.this.e.b();
            c.this.a(this.b);
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
            this.d.setUserAgent(A());
            Map<String, String> a2 = a(com.baidu.sapi2.utils.g.g);
            a2.put("phonenum", str);
            a2.put("sig", a(a2, this.c.appSignKey));
            this.d.post(this.c.context, this.e.a() + com.baidu.sapi2.utils.g.g, new RequestParams(a2), new HandlerC0006c(getRegCodeCallback, getRegCodeResult, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.sapi2.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class HandlerC0006c extends HttpResponseHandler {
        final /* synthetic */ GetRegCodeCallback a;
        final /* synthetic */ GetRegCodeResult b;
        final /* synthetic */ String c;

        HandlerC0006c(GetRegCodeCallback getRegCodeCallback, GetRegCodeResult getRegCodeResult, String str) {
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
            c.this.e.d();
            int b = c.this.b(str);
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
            if (c.this.e.c()) {
                c.this.e.d();
                this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.a.onFailure(this.b);
                return;
            }
            c.this.e.b();
            c.this.a(this.a, this.c);
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
        } else if (TextUtils.isEmpty(phoneRegDTO.password)) {
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
            this.d.setUserAgent(A());
            Map<String, String> a2 = a(com.baidu.sapi2.utils.g.h);
            a2.put("crypttype", String.valueOf(6));
            a2.put("cert_id", String.valueOf(1));
            com.baidu.sapi2.utils.b bVar = new com.baidu.sapi2.utils.b();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("phonenum", phoneRegDTO.phoneNumber);
                jSONObject.put("passwd", phoneRegDTO.password);
                jSONObject.put("smscode", phoneRegDTO.regCode);
                jSONObject.put("key", bVar.a());
                a2.put("userinfo", bVar.a(b.C0021b.b, jSONObject.toString()));
                a2.put("sig", a(a2, this.c.appSignKey));
                this.d.post(this.c.context, this.e.a() + com.baidu.sapi2.utils.g.h, new RequestParams(a2), new g(sapiCallback, phoneRegResult, bVar, phoneRegDTO));
            } catch (Exception e2) {
                phoneRegResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                sapiCallback.onFailure(phoneRegResult);
                com.baidu.sapi2.utils.L.e(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends HttpResponseHandler {
        final /* synthetic */ SapiCallback a;
        final /* synthetic */ PhoneRegResult b;
        final /* synthetic */ com.baidu.sapi2.utils.b c;
        final /* synthetic */ PhoneRegDTO d;

        g(SapiCallback sapiCallback, PhoneRegResult phoneRegResult, com.baidu.sapi2.utils.b bVar, PhoneRegDTO phoneRegDTO) {
            this.a = sapiCallback;
            this.b = phoneRegResult;
            this.c = bVar;
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
            c.this.e.d();
            int b = c.this.b(str);
            this.b.setResultCode(b);
            try {
                JSONObject jSONObject = new JSONObject(this.c.a(new JSONObject(str).optString("userinfo")));
                this.b.setResultMsg(jSONObject.optJSONObject("sdk").optString(AddFriendActivityConfig.MSG));
                switch (b) {
                    case 0:
                        SapiAccount a = c.this.a(jSONObject);
                        SapiAccount.ReloginCredentials reloginCredentials = new SapiAccount.ReloginCredentials();
                        reloginCredentials.account = this.d.phoneNumber;
                        reloginCredentials.accountType = jSONObject.optString("logintype");
                        reloginCredentials.password = com.baidu.sapi2.utils.b.e(this.d.password);
                        reloginCredentials.ubi = jSONObject.optString("ubi");
                        com.baidu.sapi2.d.a(c.this.c.context).a(a.uid, reloginCredentials);
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
            if (c.this.e.c()) {
                c.this.e.d();
                this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.a.onFailure(this.b);
                return;
            }
            c.this.e.b();
            c.this.a(this.a, this.d);
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
            this.d.setUserAgent(A());
            Map<String, String> a2 = a(com.baidu.sapi2.utils.g.i);
            a2.put("crypttype", String.valueOf(6));
            a2.put("cert_id", String.valueOf(1));
            if (!TextUtils.isEmpty(this.f) && !TextUtils.isEmpty(quickUserRegDTO.captcha)) {
                a2.put("verifycode", quickUserRegDTO.captcha);
                a2.put("vcodestr", this.f);
            }
            com.baidu.sapi2.utils.b bVar = new com.baidu.sapi2.utils.b();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("username", quickUserRegDTO.username);
                jSONObject.put("loginpass", quickUserRegDTO.password);
                jSONObject.put("key", bVar.a());
                a2.put("userinfo", bVar.a(b.C0021b.b, jSONObject.toString()));
                a2.put("sig", a(a2, this.c.appSignKey));
                this.d.post(this.c.context, this.e.a() + com.baidu.sapi2.utils.g.i, new RequestParams(a2), new f(quickUserRegCallback, quickUserRegResult, bVar, quickUserRegDTO));
            } catch (Exception e2) {
                quickUserRegResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                quickUserRegCallback.onFailure(quickUserRegResult);
                com.baidu.sapi2.utils.L.e(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends HttpResponseHandler {
        final /* synthetic */ QuickUserRegCallback a;
        final /* synthetic */ QuickUserRegResult b;
        final /* synthetic */ com.baidu.sapi2.utils.b c;
        final /* synthetic */ QuickUserRegDTO d;

        f(QuickUserRegCallback quickUserRegCallback, QuickUserRegResult quickUserRegResult, com.baidu.sapi2.utils.b bVar, QuickUserRegDTO quickUserRegDTO) {
            this.a = quickUserRegCallback;
            this.b = quickUserRegResult;
            this.c = bVar;
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
            c.this.e.d();
            int b = c.this.b(str);
            this.b.setResultCode(b);
            try {
                JSONObject jSONObject = new JSONObject(this.c.a(new JSONObject(str).optString("userinfo")));
                this.b.setResultMsg(jSONObject.optJSONObject("sdk").optString(AddFriendActivityConfig.MSG));
                if (jSONObject.optInt("needvcode") == 1) {
                    c.this.f = jSONObject.optString("vcodestr");
                    this.a.onCaptchaRequired(this.b);
                }
                switch (b) {
                    case 0:
                        SapiAccount a = c.this.a(jSONObject);
                        SapiAccount.ReloginCredentials reloginCredentials = new SapiAccount.ReloginCredentials();
                        reloginCredentials.account = this.d.username;
                        reloginCredentials.accountType = jSONObject.optString("logintype");
                        reloginCredentials.password = com.baidu.sapi2.utils.b.e(this.d.password);
                        reloginCredentials.ubi = jSONObject.optString("ubi");
                        com.baidu.sapi2.d.a(c.this.c.context).a(a.uid, reloginCredentials);
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
            if (c.this.e.c()) {
                c.this.e.d();
                this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.a.onFailure(this.b);
                return;
            }
            c.this.e.b();
            c.this.a(this.a, this.d);
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
            this.d.setUserAgent(A());
            Map<String, String> a2 = a(com.baidu.sapi2.utils.g.t);
            a2.put("username", str);
            a2.put("sig", a(a2, this.c.appSignKey));
            this.d.post(this.c.context, this.e.a() + com.baidu.sapi2.utils.g.t, new RequestParams(a2), new i(sapiCallback, getDynamicPwdResult, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i extends HttpResponseHandler {
        final /* synthetic */ SapiCallback a;
        final /* synthetic */ GetDynamicPwdResult b;
        final /* synthetic */ String c;

        i(SapiCallback sapiCallback, GetDynamicPwdResult getDynamicPwdResult, String str) {
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
            c.this.e.d();
            int b = c.this.b(str);
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
            if (c.this.e.c()) {
                c.this.e.d();
                this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.a.onFailure(this.b);
                return;
            }
            c.this.e.b();
            c.this.b(this.a, this.c);
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
            this.d.setUserAgent(A());
            Map<String, String> a2 = a(com.baidu.sapi2.utils.g.a);
            a2.put("crypttype", String.valueOf(6));
            a2.put("cert_id", String.valueOf(1));
            a2.put("isphone", "1");
            a2.put("isdpass", "1");
            com.baidu.sapi2.utils.b bVar = new com.baidu.sapi2.utils.b();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("username", str);
                jSONObject.put("password", str2);
                jSONObject.put(LoginActivityConfig.LOGIN_TYPE, "3");
                jSONObject.put("key", bVar.a());
                a2.put("userinfo", bVar.a(b.C0021b.b, jSONObject.toString()));
                a2.put("sig", a(a2, this.c.appSignKey));
                this.d.post(this.c.context, u(), new RequestParams(a2), new h(sapiCallback, dynamicPwdLoginResult, bVar, str, str2));
            } catch (Exception e2) {
                dynamicPwdLoginResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                sapiCallback.onFailure(dynamicPwdLoginResult);
                com.baidu.sapi2.utils.L.e(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends HttpResponseHandler {
        final /* synthetic */ SapiCallback a;
        final /* synthetic */ DynamicPwdLoginResult b;
        final /* synthetic */ com.baidu.sapi2.utils.b c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        h(SapiCallback sapiCallback, DynamicPwdLoginResult dynamicPwdLoginResult, com.baidu.sapi2.utils.b bVar, String str, String str2) {
            this.a = sapiCallback;
            this.b = dynamicPwdLoginResult;
            this.c = bVar;
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
            c.this.e.d();
            int b = c.this.b(str);
            this.b.setResultCode(b);
            try {
                JSONObject jSONObject = new JSONObject(this.c.a(new JSONObject(str).optString("userinfo")));
                this.b.setResultMsg(jSONObject.optJSONObject("sdk").optString(AddFriendActivityConfig.MSG));
                switch (b) {
                    case 0:
                        com.baidu.sapi2.share.b.a().a(c.this.a(jSONObject));
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
            if (c.this.e.c()) {
                c.this.e.d();
                this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.a.onFailure(this.b);
                return;
            }
            c.this.e.b();
            c.this.a(this.a, this.d, this.e);
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
        com.baidu.sapi2.utils.b bVar = new com.baidu.sapi2.utils.b();
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(A());
        this.d.get(this.c.context, C(), new l(sapiCallBack, z2, bVar, str, str2));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class l extends HttpResponseHandler {
        final /* synthetic */ SapiCallBack a;
        final /* synthetic */ boolean b;
        final /* synthetic */ com.baidu.sapi2.utils.b c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        l(SapiCallBack sapiCallBack, boolean z, com.baidu.sapi2.utils.b bVar, String str, String str2) {
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
                c.this.a(-100, this.a, "", this.b, this.c);
                com.baidu.sapi2.utils.L.e(e);
            }
            if (c.this.e.c()) {
                c.this.e.d();
                c.this.a(-100, this.a, str2, this.b, this.c);
                return;
            }
            c.this.e.b();
            c.this.a(this.a, this.d, this.e, this.b);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                c.this.a(this.a, jSONObject.optString("cert"), jSONObject.optString("cert_id"), this.d, this.e, this.b, this.c);
            } catch (Exception e) {
                c.this.a(-100, this.a, str, this.b, this.c);
                com.baidu.sapi2.utils.L.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SapiCallBack<SapiAccountResponse> sapiCallBack, String str, String str2, String str3, String str4, boolean z2, com.baidu.sapi2.utils.b bVar) {
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(A());
        HashMap hashMap = new HashMap();
        hashMap.put("crypttype", "6");
        hashMap.put("tpl", this.c.tpl);
        hashMap.put("appid", this.c.appId);
        String str5 = this.c.clientId;
        if (!TextUtils.isEmpty(str5)) {
            hashMap.put("cuid", str5);
        }
        hashMap.put("cert_id", str2);
        hashMap.put("isdpass", "1");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("username", str3);
        jSONObject.put("isphone", "1");
        jSONObject.put("password", str4);
        jSONObject.put(LoginActivityConfig.LOGIN_TYPE, "3");
        jSONObject.put("key", bVar.a());
        jSONObject.put("sdk_version", "2");
        jSONObject.put("pinfo", com.baidu.sapi2.utils.c.b());
        hashMap.put("userinfo", bVar.a(str, jSONObject.toString()));
        hashMap.put("sig", a(hashMap, this.c.appSignKey));
        this.d.post(this.c.context, u(), new RequestParams(hashMap), new n(sapiCallBack, z2, bVar, str3, str4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class n extends HttpResponseHandler {
        final /* synthetic */ SapiCallBack a;
        final /* synthetic */ boolean b;
        final /* synthetic */ com.baidu.sapi2.utils.b c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        n(SapiCallBack sapiCallBack, boolean z, com.baidu.sapi2.utils.b bVar, String str, String str2) {
            this.a = sapiCallBack;
            this.b = z;
            this.c = bVar;
            this.d = str;
            this.e = str2;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
            c.this.a(c.this.b(str), this.a, str, this.b, this.c);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
            if (c.this.e.c()) {
                c.this.e.d();
                c.this.a(c.this.b(str), this.a, str, this.b, this.c);
                return;
            }
            c.this.e.b();
            c.this.a(this.a, this.d, this.e, this.b);
        }
    }

    void a(int i2, SapiCallBack<SapiAccountResponse> sapiCallBack, String str, boolean z2, com.baidu.sapi2.utils.b bVar) {
        if (str != null) {
            SapiAccountResponse sapiAccountResponse = new SapiAccountResponse();
            try {
                String optString = new JSONObject(str).optString("userinfo");
                String str2 = "";
                if (!TextUtils.isEmpty(optString)) {
                    str2 = bVar.a(optString);
                    JSONObject jSONObject = new JSONObject(str2);
                    sapiAccountResponse.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                    sapiAccountResponse.username = jSONObject.optString("uname");
                    sapiAccountResponse.uid = jSONObject.optString("uid");
                    sapiAccountResponse.email = jSONObject.optString("email");
                    sapiAccountResponse.bduss = jSONObject.optString(SapiAccountManager.SESSION_BDUSS);
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
        this.d.setUserAgent(A());
        HashMap hashMap = new HashMap();
        hashMap.put("appid", this.c.appId);
        hashMap.put("tpl", this.c.tpl);
        if (!TextUtils.isEmpty(this.c.clientId)) {
            hashMap.put("clientid", this.c.clientId);
        }
        if (!TextUtils.isEmpty(this.c.clientIp)) {
            hashMap.put("clientip", this.c.clientIp);
        }
        hashMap.put(SapiAccountManager.SESSION_BDUSS, str);
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
        this.d.post(this.c.context, p(), multipartRequestParams, new m(sapiCallBack, str, str2, str3, bArr, str4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class m extends HttpResponseHandler {
        final /* synthetic */ SapiCallBack a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ byte[] e;
        final /* synthetic */ String f;

        m(SapiCallBack sapiCallBack, String str, String str2, String str3, byte[] bArr, String str4) {
            this.a = sapiCallBack;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = bArr;
            this.f = str4;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (c.this.e.c()) {
                c.this.e.d();
                this.a.onSystemError(-100);
                return;
            }
            c.this.e.b();
            c.this.a(this.a, this.b, this.c, this.d, this.e, this.f);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            c.this.e.d();
            int b = c.this.b(str);
            if (b == 0) {
                SapiResponse sapiResponse = new SapiResponse();
                sapiResponse.errorCode = b;
                sapiResponse.errorMsg = "设置头像成功";
                this.a.onSuccess(sapiResponse);
                return;
            }
            this.a.onSystemError(b);
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
        this.d.setUserAgent(A());
        HashMap hashMap = new HashMap();
        hashMap.put("appid", this.c.appId);
        hashMap.put("tpl", this.c.tpl);
        if (!TextUtils.isEmpty(this.c.clientId)) {
            hashMap.put("clientid", this.c.clientId);
        }
        if (!TextUtils.isEmpty(this.c.clientIp)) {
            hashMap.put("clientip", this.c.clientIp);
        }
        hashMap.put(SapiAccountManager.SESSION_BDUSS, setPopularPortraitDTO.bduss);
        hashMap.put("serie", setPopularPortraitDTO.series);
        hashMap.put("num", String.valueOf(setPopularPortraitDTO.num));
        String a2 = a(hashMap, this.c.appSignKey);
        MultipartRequestParams multipartRequestParams = new MultipartRequestParams();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            multipartRequestParams.put(entry.getKey(), entry.getValue());
        }
        multipartRequestParams.put("sig", a2);
        this.d.post(this.c.context, t(), multipartRequestParams, new p(setPopularPortraitResult, setPopularPortraitCallback, setPopularPortraitDTO));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class p extends HttpResponseHandler {
        final /* synthetic */ SetPopularPortraitResult a;
        final /* synthetic */ SetPopularPortraitCallback b;
        final /* synthetic */ SetPopularPortraitDTO c;

        p(SetPopularPortraitResult setPopularPortraitResult, SetPopularPortraitCallback setPopularPortraitCallback, SetPopularPortraitDTO setPopularPortraitDTO) {
            this.a = setPopularPortraitResult;
            this.b = setPopularPortraitCallback;
            this.c = setPopularPortraitDTO;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (c.this.e.c()) {
                c.this.e.d();
                this.a.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.b.onFailure(this.a);
                return;
            }
            c.this.e.b();
            c.this.a(this.b, this.c);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            c.this.e.d();
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
        this.d.setUserAgent(A());
        HashMap hashMap = new HashMap();
        hashMap.put("appid", this.c.appId);
        hashMap.put("tpl", this.c.tpl);
        if (!TextUtils.isEmpty(this.c.clientId)) {
            hashMap.put("clientid", this.c.clientId);
        }
        if (!TextUtils.isEmpty(this.c.clientIp)) {
            hashMap.put("clientip", this.c.clientIp);
        }
        hashMap.put(SapiAccountManager.SESSION_BDUSS, str);
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
        this.d.post(this.c.context, this.e.a() + "/v2/sapi/center/getportrait", requestParams, new o(sapiCallBack, str, str2, str3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class o extends HttpResponseHandler {
        final /* synthetic */ SapiCallBack a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;

        o(SapiCallBack sapiCallBack, String str, String str2, String str3) {
            this.a = sapiCallBack;
            this.b = str;
            this.c = str2;
            this.d = str3;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (c.this.e.c()) {
                c.this.e.d();
                this.a.onSystemError(-100);
                return;
            }
            c.this.e.b();
            c.this.a(this.a, this.b, this.c, this.d);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            c.this.e.d();
            int b = c.this.b(str);
            if (b == 0) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    GetPortraitResponse getPortraitResponse = new GetPortraitResponse();
                    getPortraitResponse.errorCode = b;
                    getPortraitResponse.errorMsg = jSONObject.optString("errmsg");
                    String optString = jSONObject.optString(com.baidu.tbadk.core.frameworkData.c.PORTRAIT);
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
        this.d.setUserAgent(A());
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
        hashMap.put(SapiAccountManager.SESSION_BDUSS, getHistoryPortraitsDTO.bduss);
        String a2 = a(hashMap, this.c.appSignKey);
        RequestParams requestParams = new RequestParams();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            requestParams.put(entry.getKey(), entry.getValue());
        }
        requestParams.put("sig", a2);
        this.d.post(this.c.context, q(), requestParams, new r(getHistoryPortraitsResult, getHistoryPortraitsCallback, getHistoryPortraitsDTO));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class r extends HttpResponseHandler {
        final /* synthetic */ GetHistoryPortraitsResult a;
        final /* synthetic */ GetHistoryPortraitsCallback b;
        final /* synthetic */ GetHistoryPortraitsDTO c;

        r(GetHistoryPortraitsResult getHistoryPortraitsResult, GetHistoryPortraitsCallback getHistoryPortraitsCallback, GetHistoryPortraitsDTO getHistoryPortraitsDTO) {
            this.a = getHistoryPortraitsResult;
            this.b = getHistoryPortraitsCallback;
            this.c = getHistoryPortraitsDTO;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (c.this.e.c()) {
                c.this.e.d();
                this.a.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.b.onFailure(this.a);
                return;
            }
            c.this.e.b();
            c.this.a(this.b, this.c);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            c.this.e.d();
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
        this.d.setUserAgent(A());
        HashMap hashMap = new HashMap();
        hashMap.put(SapiAccountManager.SESSION_BDUSS, str);
        RequestParams requestParams = new RequestParams();
        for (Map.Entry entry : hashMap.entrySet()) {
            requestParams.put((String) entry.getKey(), (String) entry.getValue());
        }
        this.d.post(this.c.context, s(), requestParams, new q(getPopularPortraitsCallback, getPopularPortraitsInfoResult, str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class q extends HttpResponseHandler {
        final /* synthetic */ GetPopularPortraitsCallback a;
        final /* synthetic */ GetPopularPortraitsInfoResult b;
        final /* synthetic */ String c;

        q(GetPopularPortraitsCallback getPopularPortraitsCallback, GetPopularPortraitsInfoResult getPopularPortraitsInfoResult, String str) {
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
            if (c.this.e.c()) {
                c.this.e.d();
                this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.a.onFailure(this.b);
                return;
            }
            c.this.e.b();
            c.this.a(this.a, this.c);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            c.this.e.d();
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("errno");
                this.b.setResultCode(optInt);
                this.b.setResultMsg(jSONObject.optString("errmsg"));
                if (optInt == 0) {
                    JSONArray optJSONArray = jSONObject.optJSONArray(com.baidu.tbadk.core.frameworkData.c.LIST);
                    int length = optJSONArray.length();
                    this.b.popularPortraitsInfoList = new ArrayList(length);
                    for (int i2 = 0; i2 < length; i2++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                        if (optJSONObject != null) {
                            GetPopularPortraitsInfoResult.PopularPortraitsInfo popularPortraitsInfo = new GetPopularPortraitsInfoResult.PopularPortraitsInfo();
                            popularPortraitsInfo.num = optJSONObject.optInt("num");
                            popularPortraitsInfo.series = optJSONObject.optString("serie");
                            popularPortraitsInfo.url = optJSONObject.optString(ImageViewerConfig.URL);
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
        this.d.setUserAgent(A());
        HashMap hashMap = new HashMap();
        hashMap.put("appid", this.c.appId);
        hashMap.put("tpl", this.c.tpl);
        if (!TextUtils.isEmpty(this.c.clientId)) {
            hashMap.put("clientid", this.c.clientId);
        }
        if (!TextUtils.isEmpty(this.c.clientIp)) {
            hashMap.put("clientip", this.c.clientIp);
        }
        hashMap.put(SapiAccountManager.SESSION_BDUSS, str);
        String a2 = a(hashMap, this.c.appSignKey);
        RequestParams requestParams = new RequestParams();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            requestParams.put(entry.getKey(), entry.getValue());
        }
        requestParams.put("sig", a2);
        this.d.post(this.c.context, r(), requestParams, new t(getUserInfoCallback, getUserInfoResult, str));
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
            c.this.e.d();
            int b = c.this.b(str);
            this.b.setResultCode(b);
            switch (b) {
                case 0:
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        this.b.portraitSign = jSONObject.optString("portrait_tag");
                        String optString = jSONObject.optString(com.baidu.tbadk.core.frameworkData.c.PORTRAIT);
                        if (!TextUtils.isEmpty(optString)) {
                            this.b.portrait = String.format("http://himg.bdimg.com/sys/portrait/item/%s.jpg?%s", optString, this.b.portraitSign);
                        }
                        this.b.username = jSONObject.optString("username");
                        this.b.uid = jSONObject.optString("userid");
                        this.b.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                        this.b.incompleteUser = "1".equals(jSONObject.optString("incomplete_user"));
                        this.b.secureMobile = jSONObject.optString("securemobil");
                        this.b.secureEmail = jSONObject.optString("secureemail");
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
            if (c.this.e.c()) {
                c.this.e.d();
                this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.a.onFailure(this.b);
                return;
            }
            c.this.e.b();
            c.this.a(this.a, this.c);
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
        this.d.setUserAgent(A());
        HashMap hashMap = new HashMap();
        hashMap.put("appid", this.c.appId);
        hashMap.put("tpl", this.c.tpl);
        if (!TextUtils.isEmpty(this.c.clientId)) {
            hashMap.put("clientid", this.c.clientId);
        }
        if (!TextUtils.isEmpty(this.c.clientIp)) {
            hashMap.put("clientip", this.c.clientIp);
        }
        hashMap.put(SapiAccountManager.SESSION_BDUSS, str);
        String a2 = a(hashMap, this.c.appSignKey);
        RequestParams requestParams = new RequestParams();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            requestParams.put(entry.getKey(), entry.getValue());
        }
        requestParams.put("sig", a2);
        this.d.post(this.c.context, r(), requestParams, new u(getUserInfoCallBack, str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class u extends HttpResponseHandler {
        final /* synthetic */ GetUserInfoCallBack a;
        final /* synthetic */ String b;

        u(GetUserInfoCallBack getUserInfoCallBack, String str) {
            this.a = getUserInfoCallBack;
            this.b = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            c.this.e.d();
            this.a.onFinish();
            int b = c.this.b(str);
            switch (b) {
                case 0:
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        GetUserInfoResponse getUserInfoResponse = new GetUserInfoResponse();
                        getUserInfoResponse.errorCode = b;
                        getUserInfoResponse.errorMsg = jSONObject.optString("errmsg");
                        String optString = jSONObject.optString(com.baidu.tbadk.core.frameworkData.c.PORTRAIT);
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
            if (c.this.e.c()) {
                c.this.e.d();
                this.a.onFinish();
                this.a.onSystemError(-100);
                return;
            }
            c.this.e.b();
            c.this.a(this.a, this.b);
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
        com.baidu.sapi2.utils.b bVar = new com.baidu.sapi2.utils.b();
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(A());
        this.d.get(this.c.context, C(), new s(fillUsernameCallBack, bVar, str, str2, str3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class s extends HttpResponseHandler {
        final /* synthetic */ FillUsernameCallBack a;
        final /* synthetic */ com.baidu.sapi2.utils.b b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        s(FillUsernameCallBack fillUsernameCallBack, com.baidu.sapi2.utils.b bVar, String str, String str2, String str3) {
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
                com.baidu.sapi2.utils.L.e(e);
            }
            if (c.this.e.c()) {
                c.this.e.d();
                c.this.a(-100, this.a, str2, this.b);
                return;
            }
            c.this.a(this.a, this.c, this.d, this.e);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
            c.this.e.d();
            try {
                JSONObject jSONObject = new JSONObject(str);
                c.this.a(this.a, this.c, this.d, this.e, jSONObject.optString("cert"), jSONObject.optString("cert_id"), this.b);
            } catch (Exception e) {
                c.this.a(c.this.c(str), this.a, str, this.b);
                com.baidu.sapi2.utils.L.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FillUsernameCallBack fillUsernameCallBack, String str, String str2, String str3, String str4, String str5, com.baidu.sapi2.utils.b bVar) {
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(A());
        HashMap hashMap = new HashMap();
        hashMap.put("appid", this.c.appId);
        hashMap.put("tpl", this.c.tpl);
        hashMap.put("cert_id", str5);
        hashMap.put("crypttype", String.valueOf(6));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(SapiAccountManager.SESSION_BDUSS, str);
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
        jSONObject.put("key", bVar.a());
        hashMap.put("userinfo", bVar.a(str4, jSONObject.toString()));
        hashMap.put("sig", a(hashMap, this.c.appSignKey));
        this.d.post(this.c.context, o(), new RequestParams(hashMap), new y(fillUsernameCallBack, bVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class y extends HttpResponseHandler {
        final /* synthetic */ FillUsernameCallBack a;
        final /* synthetic */ com.baidu.sapi2.utils.b b;

        y(FillUsernameCallBack fillUsernameCallBack, com.baidu.sapi2.utils.b bVar) {
            this.a = fillUsernameCallBack;
            this.b = bVar;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
            c.this.a(c.this.c(str), this.a, str, this.b);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
            c.this.a(c.this.c(str), this.a, str, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(FillUserProfileCallBack fillUserProfileCallBack, String str) {
        if (fillUserProfileCallBack == null) {
            throw new IllegalArgumentException(FillUserProfileCallBack.class.getSimpleName() + " can't be null");
        }
        if (TextUtils.isEmpty(str)) {
            fillUserProfileCallBack.onFinish();
            fillUserProfileCallBack.onBdussInvalid();
        } else if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            fillUserProfileCallBack.onFinish();
            fillUserProfileCallBack.onNetworkFailed();
        } else if (!SapiUtils.isSimReady(this.c.context)) {
            fillUserProfileCallBack.onFinish();
            fillUserProfileCallBack.onSimUnavailable();
        } else {
            this.d = new AsyncHttpClient();
            this.d.setUserAgent(A());
            HashMap hashMap = new HashMap();
            hashMap.put("appid", this.c.appId);
            hashMap.put("tpl", this.c.tpl);
            if (!TextUtils.isEmpty(this.c.clientId)) {
                hashMap.put("clientid", this.c.clientId);
            }
            hashMap.put(SapiAccountManager.SESSION_BDUSS, str);
            hashMap.put("sig", a(hashMap, this.c.appSignKey));
            this.d.post(this.c.context, this.e.a() + com.baidu.sapi2.utils.g.F, new RequestParams(hashMap), new x(fillUserProfileCallBack, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class x extends HttpResponseHandler {
        final /* synthetic */ FillUserProfileCallBack a;
        final /* synthetic */ String b;

        x(FillUserProfileCallBack fillUserProfileCallBack, String str) {
            this.a = fillUserProfileCallBack;
            this.b = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            c.this.a(this.a, this.b, str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            c.this.a(this.a, this.b, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FillUserProfileCallBack fillUserProfileCallBack, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str2);
            int b2 = b(str2);
            switch (b2) {
                case 0:
                    String optString = jSONObject.optString("sms");
                    String optString2 = jSONObject.optString("vcode");
                    String optString3 = jSONObject.optString("upsmschannel");
                    if (SapiUtils.sendSms(this.c.context, optString2, optString) && !TextUtils.isEmpty(optString3)) {
                        this.d = new AsyncHttpClient();
                        this.d.setUserAgent(A());
                        CookieStore basicCookieStore = new BasicCookieStore();
                        BasicClientCookie basicClientCookie = new BasicClientCookie("BAIDUID", SapiUtils.getClientId(this.c.context));
                        basicClientCookie.setDomain("baidu.com");
                        basicClientCookie.setPath("/");
                        basicCookieStore.addCookie(basicClientCookie);
                        this.d.setCookieStore(basicCookieStore);
                        RequestParams requestParams = new RequestParams();
                        requestParams.put("channel_id", optString3);
                        requestParams.put("callback", "p");
                        requestParams.put("apiver", "v3");
                        requestParams.put("tt", String.valueOf(System.currentTimeMillis()));
                        this.d.get(this.c.context, "https://passport.baidu.com/channel/unicast", requestParams, new w(fillUserProfileCallBack, optString3, str, optString2));
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
                    fillUserProfileCallBack.onSystemError(b2);
                    break;
            }
        } catch (Throwable th) {
            fillUserProfileCallBack.onFinish();
            fillUserProfileCallBack.onSystemError(-100);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class w extends HttpResponseHandler {
        final /* synthetic */ FillUserProfileCallBack a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;

        w(FillUserProfileCallBack fillUserProfileCallBack, String str, String str2, String str3) {
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
                    switch (c.this.b(str.substring(indexOf + 1, indexOf2))) {
                        case 0:
                            HashMap hashMap = new HashMap();
                            hashMap.put("appid", c.this.c.appId);
                            hashMap.put("tpl", c.this.c.tpl);
                            if (!TextUtils.isEmpty(c.this.c.clientId)) {
                                hashMap.put("clientid", c.this.c.clientId);
                            }
                            hashMap.put("upsmschannel", this.b);
                            hashMap.put(SapiAccountManager.SESSION_BDUSS, this.c);
                            hashMap.put("vcode", this.d);
                            hashMap.put("sig", c.this.a(hashMap, c.this.c.appSignKey));
                            c.this.d = new AsyncHttpClient();
                            c.this.d.setUserAgent(c.this.A());
                            c.this.d.post(c.this.c.context, c.this.e.a() + com.baidu.sapi2.utils.g.G, new RequestParams(hashMap), new a());
                            return;
                        default:
                            this.a.onFinish();
                            this.a.onSystemError(-100);
                            return;
                    }
                } catch (Throwable th) {
                    com.baidu.sapi2.utils.L.e(th);
                    this.a.onFinish();
                    this.a.onSystemError(-100);
                    return;
                }
            }
            this.a.onFinish();
            this.a.onSystemError(-100);
        }

        /* loaded from: classes.dex */
        class a extends HttpResponseHandler {
            a() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str) {
                try {
                    int b = c.this.b(str);
                    switch (b) {
                        case 0:
                            SapiAccountResponse sapiAccountResponse = new SapiAccountResponse();
                            sapiAccountResponse.errorCode = b;
                            JSONObject jSONObject = new JSONObject(str);
                            sapiAccountResponse.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                            sapiAccountResponse.bduss = jSONObject.optString(SapiAccountManager.SESSION_BDUSS);
                            sapiAccountResponse.uid = jSONObject.optString("uid");
                            sapiAccountResponse.ptoken = jSONObject.optString(SapiAccountManager.SESSION_PTOKEN);
                            sapiAccountResponse.stoken = jSONObject.optString(SapiAccountManager.SESSION_STOKEN);
                            w.this.a.onFinish();
                            w.this.a.onSuccess(sapiAccountResponse);
                            break;
                        case 8:
                            w.this.a.onFinish();
                            w.this.a.onPhoneUnavailable();
                            break;
                        default:
                            w.this.a.onFinish();
                            w.this.a.onSystemError(b);
                            break;
                    }
                } catch (Throwable th) {
                    w.this.a.onFinish();
                    w.this.a.onSystemError(-100);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str) {
                w.this.a.onFinish();
                w.this.a.onSystemError(-100);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            this.a.onFinish();
            this.a.onSystemError(-100);
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
            this.d.setUserAgent(A());
            HashMap hashMap = new HashMap();
            hashMap.put("appid", this.c.appId);
            hashMap.put("tpl", this.c.tpl);
            if (!TextUtils.isEmpty(this.c.clientId)) {
                hashMap.put("clientid", this.c.clientId);
            }
            String b2 = com.baidu.sapi2.utils.h.b(com.baidu.sapi2.utils.g.H);
            if (!TextUtils.isEmpty(b2)) {
                hashMap.put("di", b2);
            }
            hashMap.put("username", voiceCheckDTO.account);
            if (voiceCheckDTO.accountType == null || voiceCheckDTO.accountType == VoiceCheckDTO.AccountType.MERGE) {
                hashMap.put("merge", "1");
            }
            if (voiceCheckDTO.accountType == VoiceCheckDTO.AccountType.USERNAME) {
                hashMap.put("isphone", GameInfoData.NOT_FROM_DETAIL);
            }
            if (voiceCheckDTO.accountType == VoiceCheckDTO.AccountType.PHONE) {
                hashMap.put("isphone", "1");
            }
            hashMap.put("sig", a(hashMap, this.c.appSignKey));
            this.d.post(this.c.context, this.e.a() + com.baidu.sapi2.utils.g.H, new RequestParams(hashMap), new v(voiceCheckCallback, voiceCheckResult, voiceCheckDTO));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class v extends HttpResponseHandler {
        final /* synthetic */ VoiceCheckCallback a;
        final /* synthetic */ VoiceCheckResult b;
        final /* synthetic */ VoiceCheckDTO c;

        v(VoiceCheckCallback voiceCheckCallback, VoiceCheckResult voiceCheckResult, VoiceCheckDTO voiceCheckDTO) {
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
            c.this.e.d();
            c.this.b(this.a, str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (c.this.e.c()) {
                c.this.e.d();
                this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.a.onFailure(this.b);
                return;
            }
            c.this.e.b();
            c.this.a(this.a, this.c);
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
        this.d.setUserAgent(A());
        HashMap hashMap = new HashMap();
        hashMap.put("appid", this.c.appId);
        hashMap.put("tpl", this.c.tpl);
        if (!TextUtils.isEmpty(this.c.clientId)) {
            hashMap.put("clientid", this.c.clientId);
        }
        if (!TextUtils.isEmpty(this.c.clientIp)) {
            hashMap.put("clientip", this.c.clientIp);
        }
        String b2 = com.baidu.sapi2.utils.h.b(com.baidu.sapi2.utils.g.H);
        if (!TextUtils.isEmpty(b2)) {
            hashMap.put("di", b2);
        }
        hashMap.put(SapiAccountManager.SESSION_BDUSS, str);
        hashMap.put("sig", a(hashMap, this.c.appSignKey));
        this.d.post(this.c.context, this.e.a() + com.baidu.sapi2.utils.g.H, new RequestParams(hashMap), new C(voiceCheckCallback, voiceCheckResult, str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class C extends HttpResponseHandler {
        final /* synthetic */ VoiceCheckCallback a;
        final /* synthetic */ VoiceCheckResult b;
        final /* synthetic */ String c;

        C(VoiceCheckCallback voiceCheckCallback, VoiceCheckResult voiceCheckResult, String str) {
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
            c.this.e.d();
            c.this.b(this.a, str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (c.this.e.c()) {
                c.this.e.d();
                this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.a.onFailure(this.b);
                return;
            }
            c.this.e.b();
            c.this.a(this.a, this.c);
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
                    voiceCheckResult.uid = com.baidu.sapi2.utils.b.b(jSONObject.optString("id"));
                    voiceCheckResult.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                    voiceCheckResult.signUp = "1".equals(jSONObject.optString("voice"));
                    voiceCheckResult.needVerify = "1".equals(jSONObject.optString("needverify"));
                    voiceCheckResult.authToken = jSONObject.optString("token");
                    if ("null".equals(voiceCheckResult.authToken)) {
                        voiceCheckResult.authToken = null;
                    }
                    voiceCheckResult.authSid = jSONObject.optString("authsid");
                    if ("null".equals(voiceCheckResult.authSid)) {
                        voiceCheckResult.authSid = null;
                    }
                    voiceCheckCallback.onSuccess(voiceCheckResult);
                    return;
                case 3:
                    voiceCheckCallback.onUserNotNormalized(voiceCheckResult);
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
        } catch (Exception e2) {
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
        this.d.setUserAgent(A());
        HashMap hashMap = new HashMap();
        hashMap.put("appid", this.c.appId);
        hashMap.put("tpl", this.c.tpl);
        if (!TextUtils.isEmpty(this.c.clientId)) {
            hashMap.put("clientid", this.c.clientId);
        }
        if (!TextUtils.isEmpty(this.c.clientIp)) {
            hashMap.put("clientip", this.c.clientIp);
        }
        hashMap.put(SapiAccountManager.SESSION_BDUSS, str);
        hashMap.put("sig", a(hashMap, this.c.appSignKey));
        this.d.post(this.c.context, this.e.a() + com.baidu.sapi2.utils.g.E, new RequestParams(hashMap), new B(sapiCallback, oAuthResult, str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class B extends HttpResponseHandler {
        final /* synthetic */ SapiCallback a;
        final /* synthetic */ OAuthResult b;
        final /* synthetic */ String c;

        B(SapiCallback sapiCallback, OAuthResult oAuthResult, String str) {
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
            c.this.e.d();
            try {
                JSONObject jSONObject = new JSONObject(str);
                int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                this.b.setResultCode(parseInt);
                switch (parseInt) {
                    case 0:
                        this.b.accessToken = jSONObject.optString("access_token");
                        this.b.expiresIn = jSONObject.optInt("expires_in");
                        this.b.scope = jSONObject.optString("scope");
                        this.b.refreshToken = jSONObject.optString("refresh_token");
                        this.b.sessionKey = jSONObject.optString("session_key");
                        this.b.sessionSecret = jSONObject.optString("session_secret");
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
            if (c.this.e.c()) {
                c.this.e.d();
                this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.a.onFailure(this.b);
                return;
            }
            c.this.e.b();
            c.this.c(this.a, this.c);
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
        this.d.setUserAgent(A());
        HashMap hashMap = new HashMap();
        hashMap.put("appid", this.c.appId);
        hashMap.put("tpl", this.c.tpl);
        if (!TextUtils.isEmpty(this.c.clientId)) {
            hashMap.put("clientid", this.c.clientId);
            hashMap.put("cuid", this.c.clientId);
        }
        if (!TextUtils.isEmpty(this.c.clientIp)) {
            hashMap.put("clientip", this.c.clientIp);
        }
        String b2 = com.baidu.sapi2.utils.h.b(com.baidu.sapi2.utils.g.I);
        if (!TextUtils.isEmpty(b2)) {
            hashMap.put("di", b2);
        }
        hashMap.put("voicemd5", str);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put(SapiAccountManager.SESSION_BDUSS, str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("authsid", str3);
        }
        if (z2) {
            hashMap.put("newuser", "1");
        } else {
            hashMap.put("newuser", GameInfoData.NOT_FROM_DETAIL);
        }
        hashMap.put("sig", a(hashMap, this.c.appSignKey));
        this.d.post(this.c.context, this.e.a() + com.baidu.sapi2.utils.g.I, new RequestParams(hashMap), new A(sapiCallback, z2, voiceRegResult, str, str2, str3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class A extends HttpResponseHandler {
        final /* synthetic */ SapiCallback a;
        final /* synthetic */ boolean b;
        final /* synthetic */ VoiceRegResult c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;
        final /* synthetic */ String f;

        A(SapiCallback sapiCallback, boolean z, VoiceRegResult voiceRegResult, String str, String str2, String str3) {
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
            c.this.e.d();
            c.this.a(this.a, str, this.b);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (c.this.e.c()) {
                c.this.e.d();
                this.c.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.a.onFailure(this.c);
                return;
            }
            c.this.e.b();
            c.this.a(this.a, this.d, this.e, this.f, this.b);
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
        this.d.setUserAgent(A());
        HashMap hashMap = new HashMap();
        hashMap.put("appid", this.c.appId);
        hashMap.put("tpl", this.c.tpl);
        if (!TextUtils.isEmpty(this.c.clientId)) {
            hashMap.put("clientid", this.c.clientId);
        }
        if (!TextUtils.isEmpty(this.c.clientIp)) {
            hashMap.put("clientip", this.c.clientIp);
        }
        String b2 = com.baidu.sapi2.utils.h.b(com.baidu.sapi2.utils.g.J);
        if (!TextUtils.isEmpty(b2)) {
            hashMap.put("di", b2);
        }
        hashMap.put("voicemd5", str);
        hashMap.put("id", com.baidu.sapi2.utils.b.c(str2));
        hashMap.put("sig", a(hashMap, this.c.appSignKey));
        this.d.post(this.c.context, this.e.a() + com.baidu.sapi2.utils.g.J, new RequestParams(hashMap), new z(voiceLoginCallback, voiceLoginResult, str, str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class z extends HttpResponseHandler {
        final /* synthetic */ VoiceLoginCallback a;
        final /* synthetic */ VoiceLoginResult b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;

        z(VoiceLoginCallback voiceLoginCallback, VoiceLoginResult voiceLoginResult, String str, String str2) {
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
            c.this.e.d();
            c.this.a(this.a, str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (c.this.e.c()) {
                c.this.e.d();
                this.b.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.a.onFailure(this.b);
                return;
            }
            c.this.e.b();
            c.this.a(this.a, this.c, this.d);
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
            this.d.setUserAgent(A());
            HashMap hashMap = new HashMap();
            hashMap.put(SapiUtils.KEY_QR_LOGIN_SIGN, str);
            hashMap.put(com.baidu.tbadk.core.frameworkData.c.CMD, str2);
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put(SapiAccountManager.SESSION_BDUSS, str3);
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
            this.d.post(this.c.context, this.e.a() + com.baidu.sapi2.utils.g.p, new RequestParams(hashMap), new D(qrPCLoginCallBack, str, str2, str3, str4, str5));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class D extends HttpResponseHandler {
        final /* synthetic */ QrPCLoginCallBack a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;
        final /* synthetic */ String f;

        D(QrPCLoginCallBack qrPCLoginCallBack, String str, String str2, String str3, String str4, String str5) {
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
            c.this.e.d();
            c.this.a(this.a, str);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
            if (c.this.e.c()) {
                c.this.e.d();
                c.this.a(this.a, str);
                return;
            }
            c.this.e.b();
            c.this.a(this.a, this.b, this.c, this.d, this.e, this.f);
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
            this.d.setUserAgent(A());
            HashMap hashMap = new HashMap();
            hashMap.put(SapiUtils.KEY_QR_LOGIN_SIGN, str);
            hashMap.put(com.baidu.tbadk.core.frameworkData.c.CMD, str2);
            if (!TextUtils.isEmpty(this.c.clientId)) {
                hashMap.put("clientid", this.c.clientId);
            }
            if (!TextUtils.isEmpty(this.c.clientIp)) {
                hashMap.put("clientip", this.c.clientIp);
            }
            hashMap.put("tpl", this.c.tpl);
            hashMap.put("appid", this.c.appId);
            hashMap.put("sig", a(hashMap, this.c.appSignKey));
            this.d.post(this.c.context, this.e.a() + com.baidu.sapi2.utils.g.q, new RequestParams(hashMap), new E(qrAppLoginCallBack, str, str2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class E extends HttpResponseHandler {
        final /* synthetic */ QrAppLoginCallBack a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        E(QrAppLoginCallBack qrAppLoginCallBack, String str, String str2) {
            this.a = qrAppLoginCallBack;
            this.b = str;
            this.c = str2;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
            c.this.e.d();
            c.this.a(i, this.a, str);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
            if (c.this.e.c()) {
                c.this.e.d();
                c.this.a(c.this.c(str), this.a, str);
                return;
            }
            c.this.e.b();
            c.this.a(this.a, this.b, this.c);
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
                sapiCallBack.onSystemError(257);
                return false;
            }
            return false;
        } else {
            this.d = new AsyncHttpClient();
            this.d.setUserAgent(A());
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
            this.d.post(this.c.context, this.e.a() + com.baidu.sapi2.utils.g.t, new RequestParams(hashMap), new L(sapiCallBack, str));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class L extends HttpResponseHandler {
        final /* synthetic */ SapiCallBack a;
        final /* synthetic */ String b;

        L(SapiCallBack sapiCallBack, String str) {
            this.a = sapiCallBack;
            this.b = str;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
            c.this.e.d();
            c.this.e(this.a, str);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
            if (c.this.e.c()) {
                c.this.e.d();
                c.this.e(this.a, str);
                return;
            }
            c.this.e.b();
            c.this.a(this.a, this.b);
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
            this.d.setUserAgent(A());
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
            this.d.post(this.c.context, this.e.a() + com.baidu.sapi2.utils.g.r, new RequestParams(hashMap), new J(sapiCallBack, str));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class J extends HttpResponseHandler {
        final /* synthetic */ SapiCallBack a;
        final /* synthetic */ String b;

        J(SapiCallBack sapiCallBack, String str) {
            this.a = sapiCallBack;
            this.b = str;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
            c.this.e.d();
            c.this.c(i, this.a, str);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
            if (c.this.e.c()) {
                c.this.e.d();
                c.this.c(c.this.c(str), this.a, str);
                return;
            }
            c.this.e.b();
            c.this.b(this.a, this.b);
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
            I i3 = new I(Looper.getMainLooper(), zArr);
            K k2 = new K(i3);
            if (SapiUtils.sendSms(this.c.context, str, SapiUtils.getFastRegChannel(this.c.context))) {
                this.d = new AsyncHttpClient();
                this.d.setUserAgent(A());
                Map<String, String> a2 = a(com.baidu.sapi2.utils.g.r);
                a2.put("sms", str);
                a2.put("sig", a(a2, this.c.appSignKey));
                RequestParams requestParams = new RequestParams(a2);
                i3.postDelayed(k2, i2 * 1000);
                sapiCallback.onStart();
                a(sapiCallback, requestParams, i3, k2, zArr);
                return;
            }
            fastRegResult.setResultCode(-102);
            sapiCallback.onFailure(fastRegResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class I extends Handler {
        final /* synthetic */ boolean[] a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        I(Looper looper, boolean[] zArr) {
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
    public class K implements Runnable {
        final /* synthetic */ Handler a;

        K(Handler handler) {
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
        this.d.post(this.c.context, this.e.a() + com.baidu.sapi2.utils.g.r, requestParams, new k(fastRegResult, handler, runnable, sapiCallback, requestParams, zArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class k extends HttpResponseHandler {
        final /* synthetic */ FastRegResult a;
        final /* synthetic */ Handler b;
        final /* synthetic */ Runnable c;
        final /* synthetic */ SapiCallback d;
        final /* synthetic */ RequestParams e;
        final /* synthetic */ boolean[] f;

        k(FastRegResult fastRegResult, Handler handler, Runnable runnable, SapiCallback sapiCallback, RequestParams requestParams, boolean[] zArr) {
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
            int b = c.this.b(str);
            this.a.setResultCode(b);
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.a.setResultMsg(jSONObject.optJSONObject("sdk").optString(AddFriendActivityConfig.MSG));
                switch (b) {
                    case 0:
                        c.this.e.d();
                        com.baidu.sapi2.share.b.a().a(c.this.a(jSONObject));
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
                        this.b.postDelayed(new a(), 400L);
                        return;
                    default:
                        c.this.e.d();
                        this.b.removeCallbacks(this.c);
                        this.d.onFinish();
                        this.d.onFailure(this.a);
                        return;
                }
            } catch (Exception e) {
                c.this.e.d();
                this.b.removeCallbacks(this.c);
                this.d.onFinish();
                this.d.onFailure(this.a);
                com.baidu.sapi2.utils.L.e(e);
            }
        }

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.a(k.this.d, k.this.e, k.this.b, k.this.c, k.this.f);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (c.this.e.c()) {
                c.this.e.d();
                this.a.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                this.b.removeCallbacks(this.c);
                this.d.onFinish();
                this.d.onFailure(this.a);
                return;
            }
            c.this.e.b();
            c.this.a(this.d, this.e, this.b, this.c, this.f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (this.c.b2cSyncEnabled() && SapiUtils.hasActiveNetwork(this.c.context)) {
            if (com.baidu.sapi2.d.a(this.c.context).s() == null || com.baidu.sapi2.d.a(this.c.context).w()) {
                this.d = new AsyncHttpClient();
                this.d.setUserAgent(A());
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
                hashMap.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, String.valueOf(com.baidu.sapi2.d.a(this.c.context).y()));
                hashMap.put("sig", a(hashMap, this.c.appSignKey));
                this.d.post(this.c.context, this.e.a() + com.baidu.sapi2.utils.g.L, new RequestParams(hashMap), new F());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class F extends HttpResponseHandler {
        F() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            c.this.e.d();
            if (c.this.b(str) == 0) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("sn", jSONObject.optString("sn"));
                    jSONObject2.put("seed", jSONObject.optString("seed"));
                    jSONObject2.put("pubkey", jSONObject.optString("pubkey"));
                    com.baidu.sapi2.d.a(c.this.c.context).f(jSONObject2.toString());
                } catch (Exception e) {
                    com.baidu.sapi2.utils.L.e(e);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (c.this.e.c()) {
                c.this.e.d();
                return;
            }
            c.this.e.b();
            c.this.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, String str3) {
        if (SapiUtils.hasActiveNetwork(this.c.context)) {
            String u2 = com.baidu.sapi2.d.a(this.c.context).u();
            String v2 = com.baidu.sapi2.d.a(this.c.context).v();
            if (!TextUtils.isEmpty(u2) && !TextUtils.isEmpty(v2) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (!str.equals(com.baidu.sapi2.d.a(this.c.context).t())) {
                    com.baidu.sapi2.d.a(this.c.context).c(true);
                    return;
                }
                this.d = new AsyncHttpClient();
                this.d.setUserAgent(A());
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
                hashMap.put("sync", com.baidu.sapi2.utils.d.b(str2, v2));
                hashMap.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, String.valueOf(com.baidu.sapi2.d.a(this.c.context).y()));
                String str4 = null;
                try {
                    str4 = SoftToken.getToken(u2, com.baidu.sapi2.d.a(this.c.context).x());
                } catch (Throwable th) {
                    com.baidu.sapi2.utils.L.e(th);
                }
                if (!TextUtils.isEmpty(str4)) {
                    hashMap.put(SapiUtils.KEY_QR_LOGIN_SIGN, a(hashMap, str4));
                    hashMap.put("sig", a(hashMap, this.c.appSignKey));
                    this.d.post(this.c.context, this.e.a() + com.baidu.sapi2.utils.g.M, new RequestParams(hashMap), new d(str3, str, str2));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends HttpResponseHandler {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        d(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            c.this.e.d();
            switch (c.this.b(str)) {
                case 0:
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        SapiAccount sapiAccount = new SapiAccount();
                        sapiAccount.bduss = jSONObject.optString(SapiAccountManager.SESSION_BDUSS);
                        sapiAccount.uid = jSONObject.optString("uid");
                        sapiAccount.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                        sapiAccount.username = jSONObject.optString("username");
                        sapiAccount.ptoken = jSONObject.optString(SapiAccountManager.SESSION_PTOKEN);
                        sapiAccount.app = "Web浏览器";
                        com.baidu.sapi2.share.b.a().a(sapiAccount, false);
                        HashMap hashMap = new HashMap();
                        hashMap.put(SapiUtils.QR_LOGIN_LP_APP, sapiAccount.app);
                        hashMap.put("sync_type", this.a);
                        com.baidu.sapi2.utils.a.a("b2c_login_share", hashMap);
                        return;
                    } catch (JSONException e) {
                        com.baidu.sapi2.utils.L.e(e);
                        return;
                    }
                case 4:
                    c.this.a(new a());
                    return;
                default:
                    return;
            }
        }

        /* loaded from: classes.dex */
        class a implements SapiCallBack<SapiResponse> {
            a() {
            }

            @Override // com.baidu.sapi2.shell.callback.SapiCallBack
            public void onSuccess(SapiResponse sapiResponse) {
                if (c.this.e.c()) {
                    c.this.e.d();
                    return;
                }
                c.this.e.b();
                c.this.a(d.this.b, d.this.c, d.this.a);
            }

            @Override // com.baidu.sapi2.shell.callback.SapiCallBack
            public void onNetworkFailed() {
            }

            @Override // com.baidu.sapi2.shell.callback.SapiCallBack
            public void onSystemError(int i) {
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (c.this.e.c()) {
                c.this.e.d();
                return;
            }
            c.this.e.b();
            c.this.a(this.b, this.c, this.a);
        }
    }

    void a(SapiCallBack<SapiResponse> sapiCallBack) {
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            if (sapiCallBack != null) {
                sapiCallBack.onNetworkFailed();
                return;
            }
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(A());
        RequestParams requestParams = new RequestParams();
        if (!TextUtils.isEmpty(this.c.clientId)) {
            requestParams.put("cuid", this.c.clientId);
        }
        requestParams.put("tpl", this.c.tpl);
        requestParams.put("appid", this.c.appId);
        this.d.get(this.c.context, n(), requestParams, new H(sapiCallBack));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class H extends HttpResponseHandler {
        final /* synthetic */ SapiCallBack a;

        H(SapiCallBack sapiCallBack) {
            this.a = sapiCallBack;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            try {
                int b = c.this.b(str);
                if (b == 0 || b == 110000) {
                    long optLong = new JSONObject(str).optLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, System.currentTimeMillis() / 1000);
                    com.baidu.sapi2.d.a(c.this.c.context).b((int) (optLong - (System.currentTimeMillis() / 1000)));
                    SapiResponse sapiResponse = new SapiResponse();
                    sapiResponse.errorCode = 0;
                    if (this.a != null) {
                        this.a.onSuccess(sapiResponse);
                        return;
                    }
                }
            } catch (JSONException e) {
                com.baidu.sapi2.utils.L.e(e);
            }
            if (this.a != null) {
                this.a.onSystemError(-100);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            if (this.a != null) {
                this.a.onSystemError(-100);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        if (this.c != null && this.c.context != null && SapiUtils.hasActiveNetwork(this.c.context)) {
            this.d = new AsyncHttpClient();
            this.d.setUserAgent(A());
            HashMap hashMap = new HashMap();
            if (com.baidu.sapi2.d.a(this.c.context).a() != null) {
                hashMap.put("device_id", com.baidu.sapi2.utils.c.d(this.c.context));
                hashMap.put("device_token", com.baidu.sapi2.d.a(this.c.context).a());
            }
            this.d.get(this.c.context, B().getDeviceUrl() + com.baidu.sapi2.utils.g.A, new RequestParams(hashMap), new G());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class G extends HttpResponseHandler {
        G() {
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
                        com.baidu.sapi2.d.a(c.this.c.context).a(true);
                    }
                } catch (JSONException e) {
                    com.baidu.sapi2.utils.L.e(e);
                    com.baidu.sapi2.d.a(c.this.c.context).a(false);
                }
            }
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
            com.baidu.sapi2.d.a(c.this.c.context).a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(SapiCallBack<SapiResponse> sapiCallBack) {
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
        this.d.setUserAgent(A());
        HashMap hashMap = new HashMap();
        String a2 = c.a.a(com.baidu.sapi2.utils.c.d(this.c.context));
        hashMap.put("ptpl", this.c.tpl);
        hashMap.put("device_id", a2);
        hashMap.put("device_info", com.baidu.sapi2.utils.c.d());
        hashMap.put("package_sign", this.c.deviceLoginSignKey);
        this.d.post(this.c.context, B().getDeviceUrl() + com.baidu.sapi2.utils.g.B, new RequestParams(hashMap), new M(sapiCallBack));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class M extends HttpResponseHandler {
        final /* synthetic */ SapiCallBack a;

        M(SapiCallBack sapiCallBack) {
            this.a = sapiCallBack;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            super.onSuccess(i, str);
            c.this.a(i, this.a, str);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            super.onFailure(th, str);
            c.this.a(c.this.c(str), this.a, str);
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
            this.d.setUserAgent(A());
            HashMap hashMap = new HashMap();
            String a2 = c.a.a(com.baidu.sapi2.utils.c.d(this.c.context));
            hashMap.put("ptpl", this.c.tpl);
            hashMap.put("device_id", a2);
            hashMap.put("device_info", com.baidu.sapi2.utils.c.d());
            hashMap.put("force_reg_token", str);
            this.d.post(this.c.context, B().getDeviceUrl() + com.baidu.sapi2.utils.g.D, new RequestParams(hashMap), new P(sapiCallBack));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class P extends HttpResponseHandler {
        final /* synthetic */ SapiCallBack a;

        P(SapiCallBack sapiCallBack) {
            this.a = sapiCallBack;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            c.this.b(i, this.a, str);
            super.onSuccess(i, str);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            c.this.b(c.this.c(str), this.a, str);
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
        this.d.setUserAgent(A());
        HashMap hashMap = new HashMap();
        String a2 = c.a.a(com.baidu.sapi2.utils.c.d(this.c.context));
        hashMap.put("ptpl", this.c.tpl);
        hashMap.put("device_id", a2);
        hashMap.put("device_token", str);
        hashMap.put("package_sign", this.c.deviceLoginSignKey);
        this.d.post(this.c.context, B().getDeviceUrl() + com.baidu.sapi2.utils.g.C, new RequestParams(hashMap), new O(sapiCallBack));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class O extends HttpResponseHandler {
        final /* synthetic */ SapiCallBack a;

        O(SapiCallBack sapiCallBack) {
            this.a = sapiCallBack;
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onSuccess(int i, String str) {
            c.this.a(i, this.a, str);
            super.onSuccess(i, str);
        }

        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
        public void onFailure(Throwable th, String str) {
            c.this.a(c.this.c(str), this.a, str);
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
                    sapiAccount.app = SapiUtils.getAppName(this.c.context);
                    if (jSONObject.has("device_token")) {
                        com.baidu.sapi2.d.a(this.c.context).a(jSONObject.getString("device_token"));
                    }
                    com.baidu.sapi2.share.b.a().a(sapiAccount);
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
                sapiAccountResponse.uid = jSONObject.optString("uid");
                sapiAccountResponse.bduss = jSONObject.optString(SapiAccountManager.SESSION_BDUSS);
                sapiAccountResponse.ptoken = jSONObject.optString(SapiAccountManager.SESSION_PTOKEN);
                if (!jSONObject.has("error_code") && !jSONObject.has("error_msg")) {
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
        if (!TextUtils.isEmpty(com.baidu.sapi2.utils.h.b(str))) {
            hashMap.put("di", com.baidu.sapi2.utils.h.b(str));
        }
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
    public String A() {
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
    public void a(int i2, FillUsernameCallBack fillUsernameCallBack, String str, com.baidu.sapi2.utils.b bVar) {
        if (str != null) {
            SapiAccountResponse sapiAccountResponse = new SapiAccountResponse();
            try {
                String optString = new JSONObject(str).optString("userinfo");
                if (!TextUtils.isEmpty(optString)) {
                    JSONObject jSONObject = new JSONObject(bVar.a(optString));
                    sapiAccountResponse.bduss = jSONObject.optString(SapiAccountManager.SESSION_BDUSS);
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
                if (!TextUtils.isEmpty(jSONObject.optString("errno")) && jSONObject.optString("errno").equals(GameInfoData.NOT_FROM_DETAIL)) {
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
                sapiAccountResponse.uid = jSONObject.optString("uid");
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

    SapiAccount a(JSONObject jSONObject) {
        SapiAccount sapiAccount = new SapiAccount();
        sapiAccount.uid = jSONObject.optString("uid");
        sapiAccount.bduss = jSONObject.optString(SapiAccountManager.SESSION_BDUSS);
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

    private Domain B() {
        return this.c.environment;
    }

    private String C() {
        return this.e.a() + "/sslcrypt/get_last_cert";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String e() {
        return B().getWap() + "/passport/login";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String f() {
        return B().getWap() + "/passport/getpass";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String g() {
        return B().getWap() + "/wp/wappassword";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String h() {
        return B().getWap() + "/wp/recordindex";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String i() {
        return B().getWap() + "/v2/?bindingaccount&";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String j() {
        return B().getWap() + "/v2/?bindingret";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(BindWidgetAction bindWidgetAction) {
        return B().getWap() + bindWidgetAction.getUri();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String k() {
        return B().getWap() + "/passport/authwidget";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String l() {
        return B().getWap() + "/wp/unitewidget";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String m() {
        return B().getWap() + "/wp/accountwidget-init";
    }

    String n() {
        return B().getWap() + "/wp/api/security/antireplaytoken";
    }

    String o() {
        return this.e.a() + "/v2/sapi/center/filluname";
    }

    String p() {
        return this.e.a() + "/v2/sapi/center/setportrait";
    }

    String q() {
        return B().getPortraitUrl() + "/sys/history";
    }

    String r() {
        return this.e.a() + "/v2/sapi/center/getuinfo";
    }

    String s() {
        return B().getPortraitUrl() + "/sys/portrait/hotitemlist";
    }

    String t() {
        return B().getPortraitUrl() + "/sys/sethotitem";
    }

    String u() {
        return this.e.a() + com.baidu.sapi2.utils.g.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String v() {
        return this.e.a() + "/phoenix/account/ssologin";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String w() {
        return this.e.a() + "/phoenix/account/ssologin";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String x() {
        return this.e.a() + com.baidu.sapi2.utils.g.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String y() {
        return this.e.a() + com.baidu.sapi2.utils.g.n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String z() {
        return this.e.a() + com.baidu.sapi2.utils.g.o;
    }
}
