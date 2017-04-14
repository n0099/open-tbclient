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
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.callback.FaceCheckCallback;
import com.baidu.sapi2.callback.FaceDelCallback;
import com.baidu.sapi2.callback.FaceLoginCallback;
import com.baidu.sapi2.callback.FaceModifyCallback;
import com.baidu.sapi2.callback.FaceRegCallback;
import com.baidu.sapi2.callback.FillUserProfileCallback;
import com.baidu.sapi2.callback.FillUsernameCallback;
import com.baidu.sapi2.callback.GetDynamicPwdCallback;
import com.baidu.sapi2.callback.GetHistoryPortraitsCallback;
import com.baidu.sapi2.callback.GetPopularPortraitsCallback;
import com.baidu.sapi2.callback.GetRegCodeCallback;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.callback.IqiyiLoginCallback;
import com.baidu.sapi2.callback.LoginCallback;
import com.baidu.sapi2.callback.QrPcLoginCallback;
import com.baidu.sapi2.callback.QuickUserRegCallback;
import com.baidu.sapi2.callback.SSOConfirmCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.callback.SapiCallbackInterceptor;
import com.baidu.sapi2.callback.SetPopularPortraitCallback;
import com.baidu.sapi2.callback.SetPortraitCallback;
import com.baidu.sapi2.callback.VoiceCheckCallback;
import com.baidu.sapi2.callback.VoiceCodeSetCallback;
import com.baidu.sapi2.callback.VoiceLoginCallback;
import com.baidu.sapi2.callback.VoiceSwitchSetCallback;
import com.baidu.sapi2.callback.VoiceVerifyCallback;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.dto.FaceCheckDTO;
import com.baidu.sapi2.dto.FaceDelDTO;
import com.baidu.sapi2.dto.FaceLoginDTO;
import com.baidu.sapi2.dto.FaceModifyDTO;
import com.baidu.sapi2.dto.FaceRegDTO;
import com.baidu.sapi2.dto.GetHistoryPortraitsDTO;
import com.baidu.sapi2.dto.IqiyiLoginDTO;
import com.baidu.sapi2.dto.LoginDTO;
import com.baidu.sapi2.dto.PhoneRegDTO;
import com.baidu.sapi2.dto.QuickUserRegDTO;
import com.baidu.sapi2.dto.ReloginDTO;
import com.baidu.sapi2.dto.SSOConfirmDTO;
import com.baidu.sapi2.dto.SetPopularPortraitDTO;
import com.baidu.sapi2.dto.VoiceCheckDTO;
import com.baidu.sapi2.dto.VoiceCodeSetDTO;
import com.baidu.sapi2.dto.VoiceSwitchSetDTO;
import com.baidu.sapi2.dto.VoiceVerifyDTO;
import com.baidu.sapi2.result.DynamicPwdLoginResult;
import com.baidu.sapi2.result.FaceCheckResult;
import com.baidu.sapi2.result.FaceDelResult;
import com.baidu.sapi2.result.FaceLoginResult;
import com.baidu.sapi2.result.FaceModifyResult;
import com.baidu.sapi2.result.FaceRegResult;
import com.baidu.sapi2.result.FastRegResult;
import com.baidu.sapi2.result.FillUserProfileResult;
import com.baidu.sapi2.result.FillUsernameResult;
import com.baidu.sapi2.result.GetCaptchaResult;
import com.baidu.sapi2.result.GetDynamicPwdResult;
import com.baidu.sapi2.result.GetHistoryPortraitsResult;
import com.baidu.sapi2.result.GetPopularPortraitsInfoResult;
import com.baidu.sapi2.result.GetRegCodeResult;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.result.IqiyiLoginResult;
import com.baidu.sapi2.result.LoginResult;
import com.baidu.sapi2.result.OAuthResult;
import com.baidu.sapi2.result.PhoneRegResult;
import com.baidu.sapi2.result.QrAppLoginResult;
import com.baidu.sapi2.result.QrPcLoginResult;
import com.baidu.sapi2.result.QuickUserRegResult;
import com.baidu.sapi2.result.ReloginResult;
import com.baidu.sapi2.result.SSOConfirmResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.SetPopularPortraitResult;
import com.baidu.sapi2.result.SetPortraitResult;
import com.baidu.sapi2.result.VoiceCheckResult;
import com.baidu.sapi2.result.VoiceCodeSetResult;
import com.baidu.sapi2.result.VoiceLoginResult;
import com.baidu.sapi2.result.VoiceRegResult;
import com.baidu.sapi2.result.VoiceSwitchSetResult;
import com.baidu.sapi2.result.VoiceVerifyResult;
import com.baidu.sapi2.result.Web2NativeLoginResult;
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
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.utils.L;
import com.baidu.sapi2.utils.SapiDataEncryptor;
import com.baidu.sapi2.utils.SapiDeviceUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.e;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.QrLoginAction;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.sapi2.utils.enums.Switch;
import com.baidu.sapi2.utils.f;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.security.cert.CertificateException;
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
public final class b {
    private static final int a = 6;
    private static final String b = "3";
    private SapiConfiguration c = SapiAccountManager.getInstance().getSapiConfiguration();
    private AsyncHttpClient d;
    private a e;
    private String f;
    private String g;
    private LoginDTO h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        static List<String> b = new ArrayList();
        static int c;
        Context a;

        private void f() {
            b.clear();
            b.add(f.d);
            b.add(f.e);
            b.add(f.f);
        }

        public a(Context context) {
            this.a = context;
            e();
            f();
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
            return !d() && (c.a(this.a).c() || !SapiUtils.getDefaultHttpsEnabled());
        }

        public boolean d() {
            return c >= b.size();
        }

        public void e() {
            c = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context) {
        this.e = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.d != null) {
            this.d.cancelRequests(this.c.context, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final SapiCallBack<SapiResponse> sapiCallBack, final SapiAccount.ReloginCredentials reloginCredentials) {
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
                this.d.setUserAgent(y());
                HashMap hashMap = new HashMap();
                hashMap.put("crypttype", "11");
                hashMap.put("tpl", this.c.tpl);
                hashMap.put("appid", this.c.appId);
                if (TextUtils.isEmpty(this.c.clientId)) {
                    this.c.clientId = SapiUtils.getClientId(this.c.context);
                }
                hashMap.put("cuid", this.c.clientId);
                hashMap.put("cert_id", String.valueOf(2));
                hashMap.put("isdpass", "0");
                hashMap.put("username", reloginCredentials.account);
                hashMap.put("password", reloginCredentials.password);
                hashMap.put("UBI", reloginCredentials.ubi);
                hashMap.put("isphone", "3".equals(reloginCredentials.accountType) ? "1" : "0");
                hashMap.put(LoginActivityConfig.LOGIN_TYPE, "3");
                hashMap.put("key", sapiDataEncryptor.a());
                hashMap.put("sdk_version", "2");
                hashMap.put("pinfo", SapiDeviceUtils.getBrandName());
                hashMap.put("sig", a(hashMap, this.c.appSignKey));
                this.d.post(this.c.context, s(), new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.1
                    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                    public void onSuccess(int i, String str) {
                        b.this.e.e();
                        b.this.a(b.this.b(str), sapiCallBack, str, reloginCredentials.ubi);
                    }

                    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                    public void onFailure(Throwable th, String str) {
                        if (!b.this.e.c()) {
                            b.this.e.e();
                            if (th == null || !SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                                b.this.a(b.this.b(str), sapiCallBack, str, reloginCredentials.ubi);
                                return;
                            }
                            StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                            sapiCallBack.onSystemError(-203);
                            return;
                        }
                        b.this.e.b();
                        b.this.a(sapiCallBack, reloginCredentials);
                    }
                });
            } catch (Exception e) {
                a(-100, sapiCallBack, (String) null, (String) null);
                L.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final SapiCallback<ReloginResult> sapiCallback, final ReloginDTO reloginDTO) {
        if (sapiCallback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        }
        if (reloginDTO == null) {
            throw new IllegalArgumentException(ReloginDTO.class.getSimpleName() + " can't be null");
        }
        final ReloginResult reloginResult = new ReloginResult();
        if (TextUtils.isEmpty(reloginDTO.bduss)) {
            reloginResult.setResultCode(-101);
            sapiCallback.onFailure(reloginResult);
        } else if (TextUtils.isEmpty(reloginDTO.password)) {
            reloginResult.setResultCode(-102);
            sapiCallback.onFailure(reloginResult);
        } else if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            reloginResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            sapiCallback.onFailure(reloginResult);
        } else {
            this.d = new AsyncHttpClient();
            this.d.setUserAgent(y());
            Map<String, String> a2 = a(f.b);
            a2.put("crypttype", String.valueOf(6));
            a2.put("cert_id", String.valueOf(1));
            a2.put(SapiAccountManager.SESSION_BDUSS, reloginDTO.bduss);
            final SapiDataEncryptor sapiDataEncryptor = new SapiDataEncryptor();
            try {
                JSONObject jSONObject = new JSONObject();
                if (reloginDTO.getPasswordType() == ReloginDTO.PasswordType.PLAIN) {
                    jSONObject.put("password", SapiDataEncryptor.encryptPwd(reloginDTO.password));
                } else {
                    jSONObject.put("password", reloginDTO.password);
                }
                jSONObject.put("key", sapiDataEncryptor.a());
                a2.put("userinfo", sapiDataEncryptor.a(SapiDataEncryptor.a.b, jSONObject.toString()));
                a2.put("sig", a(a2, this.c.appSignKey));
                this.d.post(this.c.context, this.e.a() + f.b, new RequestParams(a2), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.12
                    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                    protected void onStart() {
                        sapiCallback.onStart();
                    }

                    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                    protected void onFinish() {
                        sapiCallback.onFinish();
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                    public void onSuccess(int i, String str) {
                        b.this.e.e();
                        int b2 = b.this.b(str);
                        reloginResult.setResultCode(b2);
                        try {
                            JSONObject jSONObject2 = new JSONObject(sapiDataEncryptor.a(new JSONObject(str).optString("userinfo")));
                            reloginResult.setResultMsg(jSONObject2.optString("errmsg"));
                            switch (b2) {
                                case 0:
                                    reloginResult.session = b.this.a(jSONObject2);
                                    SapiAccount.a a3 = SapiAccount.a.a(jSONObject2);
                                    if (a3.b == null) {
                                        SapiAccount b3 = c.a(b.this.c.context).b(reloginDTO.bduss);
                                        if (b3 != null) {
                                            reloginResult.session.m = b3.m;
                                        }
                                    } else {
                                        reloginResult.session.m = a3.a().toString();
                                    }
                                    if (SapiUtils.isValidAccount(reloginResult.session) && SapiAccountManager.getInstance().isLogin()) {
                                        SapiAccount session = SapiAccountManager.getInstance().getSession();
                                        if (reloginResult.session.uid.equals(session.uid)) {
                                            session.uid = reloginResult.session.uid;
                                            session.bduss = reloginResult.session.bduss;
                                            session.k = reloginResult.session.k;
                                            session.displayname = reloginResult.session.displayname;
                                            session.username = reloginResult.session.username;
                                            session.m = reloginResult.session.m;
                                            SapiAccountManager.getInstance().validate(session);
                                        }
                                    }
                                    sapiCallback.onSuccess(reloginResult);
                                    return;
                                default:
                                    sapiCallback.onFailure(reloginResult);
                                    return;
                            }
                        } catch (Exception e) {
                            sapiCallback.onFailure(reloginResult);
                            L.e(e);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                    public void onFailure(Throwable th, String str) {
                        if (!b.this.e.c()) {
                            b.this.e.e();
                            if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                                StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                                reloginResult.setResultCode(-203);
                                sapiCallback.onFailure(reloginResult);
                                return;
                            }
                            reloginResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                            sapiCallback.onFailure(reloginResult);
                            return;
                        }
                        b.this.e.b();
                        b.this.a(sapiCallback, reloginDTO);
                    }
                });
            } catch (Exception e) {
                reloginResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                sapiCallback.onFailure(reloginResult);
                L.e(e);
            }
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
            this.d.setUserAgent(y());
            HashMap hashMap = new HashMap();
            hashMap.put("crypttype", "11");
            hashMap.put("tpl", this.c.tpl);
            hashMap.put("appid", this.c.appId);
            if (TextUtils.isEmpty(this.c.clientId)) {
                this.c.clientId = SapiUtils.getClientId(this.c.context);
            }
            hashMap.put("cuid", this.c.clientId);
            hashMap.put("cert_id", "2");
            hashMap.put("isdpass", "0");
            hashMap.put("username", reloginCredentials.account);
            hashMap.put("password", reloginCredentials.password);
            hashMap.put("UBI", reloginCredentials.ubi);
            hashMap.put("isphone", "3".equals(reloginCredentials.accountType) ? "1" : "0");
            hashMap.put(LoginActivityConfig.LOGIN_TYPE, "3");
            hashMap.put("key", sapiDataEncryptor.a());
            hashMap.put("sdk_version", "2");
            hashMap.put("pinfo", SapiDeviceUtils.getBrandName());
            hashMap.put("sig", a(hashMap, this.c.appSignKey));
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                arrayList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            HttpUriRequest httpPost = new HttpPost(s());
            httpPost.setEntity(new UrlEncodedFormEntity(arrayList, "UTF-8"));
            HttpResponse execute = this.d.execute(httpPost);
            if (200 == execute.getStatusLine().getStatusCode()) {
                String entityUtils = EntityUtils.toString(execute.getEntity());
                if (!TextUtils.isEmpty(entityUtils)) {
                    int b2 = b(entityUtils);
                    if (b2 == 0) {
                        JSONObject jSONObject = new JSONObject(entityUtils);
                        SapiAccount a2 = a(jSONObject);
                        SapiAccount.a a3 = SapiAccount.a.a(jSONObject);
                        if (a3.b == null) {
                            SapiAccount c = c.a(this.c.context).c(reloginCredentials.ubi);
                            if (c != null) {
                                a2.m = c.m;
                            }
                        } else {
                            a2.m = a3.a().toString();
                        }
                        com.baidu.sapi2.share.a.a().a(a2);
                        return b2;
                    }
                    return b2;
                }
            }
        } catch (Throwable th) {
            L.e(th);
        }
        return -100;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, SapiCallBack<SapiResponse> sapiCallBack, String str, String str2) {
        if (str != null) {
            SapiAccountResponse sapiAccountResponse = new SapiAccountResponse();
            sapiAccountResponse.errorCode = i;
            try {
                JSONObject jSONObject = new JSONObject(str);
                sapiAccountResponse.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                sapiAccountResponse.username = jSONObject.optString("uname");
                sapiAccountResponse.uid = jSONObject.optString(SapiAccountManager.SESSION_UID);
                sapiAccountResponse.email = jSONObject.optString("email");
                sapiAccountResponse.bduss = jSONObject.optString(SapiAccountManager.SESSION_BDUSS);
                sapiAccountResponse.ptoken = jSONObject.optString("ptoken");
                sapiAccountResponse.stoken = jSONObject.optString("stoken");
                sapiAccountResponse.authSid = jSONObject.optString("authsid");
                if (sapiCallBack != null) {
                    switch (i) {
                        case 0:
                            SapiAccount a2 = a(sapiAccountResponse);
                            SapiAccount.a a3 = SapiAccount.a.a(jSONObject);
                            if (a3.b == null) {
                                SapiAccount c = c.a(this.c.context).c(str2);
                                if (c != null) {
                                    a2.m = c.m;
                                }
                            } else {
                                a2.m = a3.a().toString();
                            }
                            com.baidu.sapi2.share.a.a().a(a2);
                            sapiCallBack.onSuccess(sapiAccountResponse);
                            return;
                        default:
                            sapiCallBack.onSystemError(i);
                            return;
                    }
                }
            } catch (Exception e) {
                L.e(e);
                if (sapiCallBack != null) {
                    sapiCallBack.onSystemError(-100);
                }
            }
        } else if (sapiCallBack != null) {
            sapiCallBack.onSystemError(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final LoginCallback loginCallback, final LoginDTO loginDTO) {
        if (loginCallback == null) {
            throw new IllegalArgumentException(LoginCallback.class.getSimpleName() + " can't be null");
        }
        if (loginDTO == null) {
            throw new IllegalArgumentException(LoginDTO.class.getSimpleName() + " can't be null");
        }
        final LoginResult loginResult = new LoginResult();
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
            this.d.setUserAgent(y());
            Map<String, String> a2 = a(f.a);
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
            a2.put("supphttps", "true");
            final SapiDataEncryptor sapiDataEncryptor = new SapiDataEncryptor();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("username", loginDTO.account);
                jSONObject.put("password", loginDTO.password);
                jSONObject.put(LoginActivityConfig.LOGIN_TYPE, "3");
                jSONObject.put("key", sapiDataEncryptor.a());
                a2.put("userinfo", sapiDataEncryptor.a(SapiDataEncryptor.a.b, jSONObject.toString()));
                a2.put("sig", a(a2, this.c.appSignKey));
                this.d.post(this.c.context, s(), new RequestParams(a2), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.23
                    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                    protected void onStart() {
                        loginCallback.onStart();
                    }

                    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                    protected void onFinish() {
                        loginCallback.onFinish();
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                    public void onSuccess(int i, String str) {
                        b.this.e.e();
                        int b2 = b.this.b(str);
                        loginResult.setResultCode(b2);
                        try {
                            JSONObject jSONObject2 = new JSONObject(sapiDataEncryptor.a(new JSONObject(str).optString("userinfo")));
                            JSONObject optJSONObject = jSONObject2.optJSONObject("sdk");
                            loginResult.setResultMsg(optJSONObject.optString(AddFriendActivityConfig.MSG));
                            SapiResult.Action action = new SapiResult.Action();
                            action.actionMode = SapiResult.ActionMode.fromString(optJSONObject.optString("action"));
                            action.actionType = SapiResult.ActionType.fromString(optJSONObject.optString("type"));
                            action.actionTitle = optJSONObject.optString(VrPlayerActivityConfig.TITLE);
                            action.actionUrl = optJSONObject.optString("url");
                            loginResult.action = action;
                            if (jSONObject2.optInt("needvcode") == 1) {
                                b.this.f = jSONObject2.optString("vcodestr");
                                loginCallback.onCaptchaRequired(loginResult);
                            }
                            switch (AnonymousClass54.a[action.actionMode.ordinal()]) {
                                case 1:
                                    b.this.h = loginDTO;
                                    loginCallback.onProxyActionRequired(loginResult);
                                    return;
                                case 2:
                                    if (b2 == 0) {
                                        SapiAccount a3 = b.this.a(jSONObject2);
                                        SapiAccount.ReloginCredentials reloginCredentials = new SapiAccount.ReloginCredentials();
                                        reloginCredentials.account = loginDTO.account;
                                        reloginCredentials.accountType = jSONObject2.optString("logintype");
                                        reloginCredentials.password = SapiDataEncryptor.encryptPwd(loginDTO.password);
                                        reloginCredentials.ubi = jSONObject2.optString("ubi");
                                        c.a(b.this.c.context).a(a3.uid, reloginCredentials);
                                        a3.m = SapiAccount.a.a(jSONObject2).a().toString();
                                        com.baidu.sapi2.share.a.a().a(a3);
                                        loginCallback.onSuccess(loginResult);
                                        return;
                                    } else if (b2 == 18) {
                                        loginCallback.onLoginTypeConflict(loginResult);
                                        return;
                                    } else {
                                        loginCallback.onFailure(loginResult);
                                        return;
                                    }
                                default:
                                    loginCallback.onFailure(loginResult);
                                    return;
                            }
                        } catch (Exception e) {
                            loginCallback.onFailure(loginResult);
                            L.e(e);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                    public void onFailure(Throwable th, String str) {
                        if (!b.this.e.c()) {
                            b.this.e.e();
                            if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                                StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                                loginResult.setResultCode(-203);
                                loginCallback.onFailure(loginResult);
                                return;
                            }
                            loginResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                            loginCallback.onFailure(loginResult);
                            return;
                        }
                        b.this.e.b();
                        b.this.a(loginCallback, loginDTO);
                    }
                });
            } catch (Exception e) {
                loginResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                loginCallback.onFailure(loginResult);
                L.e(e);
            }
        }
    }

    /* renamed from: com.baidu.sapi2.b$54  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass54 {
        static final /* synthetic */ int[] a = new int[SapiResult.ActionMode.values().length];

        static {
            try {
                a[SapiResult.ActionMode.URL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[SapiResult.ActionMode.MSG.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final SapiCallback<LoginResult> sapiCallback, String str) {
        final LoginResult loginResult = new LoginResult();
        if (TextUtils.isEmpty(str)) {
            loginResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
            sapiCallback.onFailure(loginResult);
        } else if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            loginResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            sapiCallback.onFailure(loginResult);
        } else {
            this.d = new AsyncHttpClient();
            this.d.setUserAgent(y());
            this.d.get(this.c.context, str, new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.34
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                protected void onStart() {
                    sapiCallback.onStart();
                }

                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                protected void onFinish() {
                    sapiCallback.onFinish();
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onSuccess(int i, String str2) {
                    try {
                        HashMap hashMap = new HashMap();
                        JSONObject jSONObject = new JSONObject(str2);
                        JSONObject optJSONObject = jSONObject.optJSONObject("errInfo");
                        int optInt = optJSONObject.optInt("no", SapiResult.ERROR_CODE_UNKNOWN);
                        loginResult.setResultCode(optInt);
                        loginResult.setResultMsg(optJSONObject.optString(AddFriendActivityConfig.MSG));
                        switch (optInt) {
                            case 0:
                                loginResult.setResultMsg("登录成功");
                                String optString = jSONObject.optJSONObject("data").optString("xml");
                                SapiAccount sapiAccount = new SapiAccount();
                                sapiAccount.app = SapiUtils.getAppName(b.this.c.context);
                                SapiAccount.ReloginCredentials reloginCredentials = new SapiAccount.ReloginCredentials();
                                reloginCredentials.account = b.this.h.account;
                                reloginCredentials.password = SapiDataEncryptor.encryptPwd(b.this.h.password);
                                XmlPullParser newPullParser = Xml.newPullParser();
                                newPullParser.setInput(new ByteArrayInputStream(optString.getBytes()), "UTF-8");
                                boolean z = false;
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
                                            } else if (name.equalsIgnoreCase(SapiAccountManager.SESSION_UID)) {
                                                sapiAccount.uid = newPullParser.nextText();
                                                break;
                                            } else if (name.equalsIgnoreCase(SapiAccountManager.SESSION_BDUSS)) {
                                                sapiAccount.bduss = newPullParser.nextText();
                                                break;
                                            } else if (name.equalsIgnoreCase("ptoken")) {
                                                sapiAccount.k = newPullParser.nextText();
                                                break;
                                            } else if (name.equalsIgnoreCase("stoken_list")) {
                                                z = true;
                                                break;
                                            } else if (name.equalsIgnoreCase("stoken")) {
                                                if (z) {
                                                    String[] split = newPullParser.nextText().split("#");
                                                    hashMap.put(split[0], split[1]);
                                                    break;
                                                } else {
                                                    sapiAccount.l = newPullParser.nextText();
                                                    break;
                                                }
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
                                sapiAccount.a("stoken_list", new JSONObject(hashMap));
                                c.a(b.this.c.context).a(sapiAccount.uid, reloginCredentials);
                                com.baidu.sapi2.share.a.a().a(sapiAccount);
                                sapiCallback.onSuccess(loginResult);
                                return;
                            default:
                                sapiCallback.onFailure(loginResult);
                                return;
                        }
                    } catch (Exception e) {
                        sapiCallback.onFailure(loginResult);
                        L.e(e);
                    }
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onFailure(Throwable th, String str2) {
                    loginResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    sapiCallback.onFailure(loginResult);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final SapiCallback<GetCaptchaResult> sapiCallback) {
        if (sapiCallback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        }
        if (TextUtils.isEmpty(this.f)) {
            throw new IllegalArgumentException("captchaKey can't be empty");
        }
        final GetCaptchaResult getCaptchaResult = new GetCaptchaResult();
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            getCaptchaResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            sapiCallback.onFailure(getCaptchaResult);
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(y());
        this.d.get(this.c.context, this.e.a() + f.g + this.f, new BinaryHttpResponseHandler(Looper.getMainLooper(), new String[]{"image/png", "image/jpeg", "image/jpg", "image/gif"}) { // from class: com.baidu.sapi2.b.45
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onStart() {
                sapiCallback.onStart();
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onFinish() {
                sapiCallback.onFinish();
            }

            @Override // com.baidu.cloudsdk.common.http.BinaryHttpResponseHandler
            protected void onSuccess(byte[] bArr) {
                b.this.e.e();
                if (bArr != null) {
                    getCaptchaResult.setResultCode(0);
                    getCaptchaResult.captchaImage = bArr;
                    sapiCallback.onSuccess(getCaptchaResult);
                    return;
                }
                getCaptchaResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                sapiCallback.onFailure(getCaptchaResult);
            }

            @Override // com.baidu.cloudsdk.common.http.BinaryHttpResponseHandler
            protected void onFailure(Throwable th, byte[] bArr) {
                if (!b.this.e.c()) {
                    b.this.e.e();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        getCaptchaResult.setResultCode(-203);
                        sapiCallback.onFailure(getCaptchaResult);
                        return;
                    }
                    getCaptchaResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    sapiCallback.onFailure(getCaptchaResult);
                    return;
                }
                b.this.e.b();
                b.this.a(sapiCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final GetRegCodeCallback getRegCodeCallback, final String str) {
        if (getRegCodeCallback == null) {
            throw new IllegalArgumentException(GetRegCodeCallback.class.getSimpleName() + " can't be null");
        }
        final GetRegCodeResult getRegCodeResult = new GetRegCodeResult();
        if (TextUtils.isEmpty(str)) {
            getRegCodeResult.setResultCode(-101);
            getRegCodeCallback.onFailure(getRegCodeResult);
        } else if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            getRegCodeResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            getRegCodeCallback.onFailure(getRegCodeResult);
        } else {
            this.d = new AsyncHttpClient();
            this.d.setUserAgent(y());
            Map<String, String> a2 = a(f.h);
            a2.put("phonenum", str);
            a2.put("sig", a(a2, this.c.appSignKey));
            this.d.post(this.c.context, this.e.a() + f.h, new RequestParams(a2), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.55
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                protected void onStart() {
                    getRegCodeCallback.onStart();
                }

                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                protected void onFinish() {
                    getRegCodeCallback.onFinish();
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onSuccess(int i, String str2) {
                    b.this.e.e();
                    int b2 = b.this.b(str2);
                    getRegCodeResult.setResultCode(b2);
                    try {
                        getRegCodeResult.setResultMsg(new JSONObject(str2).optJSONObject("sdk").optString(AddFriendActivityConfig.MSG));
                        switch (b2) {
                            case 0:
                                getRegCodeCallback.onSuccess(getRegCodeResult);
                                break;
                            case 8:
                                getRegCodeCallback.onPhoneNumberExist(getRegCodeResult);
                                break;
                            default:
                                getRegCodeCallback.onFailure(getRegCodeResult);
                                break;
                        }
                    } catch (Exception e) {
                        getRegCodeCallback.onFailure(getRegCodeResult);
                        L.e(e);
                    }
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onFailure(Throwable th, String str2) {
                    if (!b.this.e.c()) {
                        b.this.e.e();
                        if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                            StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                            getRegCodeResult.setResultCode(-203);
                            getRegCodeCallback.onFailure(getRegCodeResult);
                            return;
                        }
                        getRegCodeResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                        getRegCodeCallback.onFailure(getRegCodeResult);
                        return;
                    }
                    b.this.e.b();
                    b.this.a(getRegCodeCallback, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final SapiCallback<PhoneRegResult> sapiCallback, final PhoneRegDTO phoneRegDTO) {
        if (sapiCallback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        }
        if (phoneRegDTO == null) {
            throw new IllegalArgumentException(PhoneRegDTO.class.getSimpleName() + " can't be null");
        }
        final PhoneRegResult phoneRegResult = new PhoneRegResult();
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
            this.d.setUserAgent(y());
            Map<String, String> a2 = a(f.i);
            a2.put("crypttype", String.valueOf(6));
            a2.put("cert_id", String.valueOf(1));
            final SapiDataEncryptor sapiDataEncryptor = new SapiDataEncryptor();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("phonenum", phoneRegDTO.phoneNumber);
                if (!phoneRegDTO.noPwd) {
                    jSONObject.put("passwd", phoneRegDTO.password);
                }
                jSONObject.put("smscode", phoneRegDTO.regCode);
                jSONObject.put("key", sapiDataEncryptor.a());
                a2.put("userinfo", sapiDataEncryptor.a(SapiDataEncryptor.a.b, jSONObject.toString()));
                a2.put("nopsw", phoneRegDTO.noPwd ? "1" : "0");
                a2.put("sig", a(a2, this.c.appSignKey));
                this.d.post(this.c.context, this.e.a() + f.i, new RequestParams(a2), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.56
                    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                    protected void onStart() {
                        sapiCallback.onStart();
                    }

                    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                    protected void onFinish() {
                        sapiCallback.onFinish();
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                    public void onSuccess(int i, String str) {
                        b.this.e.e();
                        int b2 = b.this.b(str);
                        phoneRegResult.setResultCode(b2);
                        try {
                            JSONObject jSONObject2 = new JSONObject(sapiDataEncryptor.a(new JSONObject(str).optString("userinfo")));
                            phoneRegResult.setResultMsg(jSONObject2.optJSONObject("sdk").optString(AddFriendActivityConfig.MSG));
                            switch (b2) {
                                case 0:
                                    SapiAccount a3 = b.this.a(jSONObject2);
                                    SapiAccount.ReloginCredentials reloginCredentials = new SapiAccount.ReloginCredentials();
                                    reloginCredentials.account = phoneRegDTO.phoneNumber;
                                    reloginCredentials.accountType = jSONObject2.optString("logintype");
                                    reloginCredentials.password = SapiDataEncryptor.encryptPwd(phoneRegDTO.password);
                                    reloginCredentials.ubi = jSONObject2.optString("ubi");
                                    c.a(b.this.c.context).a(a3.uid, reloginCredentials);
                                    a3.m = SapiAccount.a.a(jSONObject2).a().toString();
                                    com.baidu.sapi2.share.a.a().a(a3);
                                    sapiCallback.onSuccess(phoneRegResult);
                                    break;
                                default:
                                    sapiCallback.onFailure(phoneRegResult);
                                    break;
                            }
                        } catch (Exception e) {
                            sapiCallback.onFailure(phoneRegResult);
                            L.e(e);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                    public void onFailure(Throwable th, String str) {
                        if (!b.this.e.c()) {
                            b.this.e.e();
                            if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                                StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                                phoneRegResult.setResultCode(-203);
                                sapiCallback.onFailure(phoneRegResult);
                                return;
                            }
                            phoneRegResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                            sapiCallback.onFailure(phoneRegResult);
                            return;
                        }
                        b.this.e.b();
                        b.this.a(sapiCallback, phoneRegDTO);
                    }
                });
            } catch (Exception e) {
                phoneRegResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                sapiCallback.onFailure(phoneRegResult);
                L.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final QuickUserRegCallback quickUserRegCallback, final QuickUserRegDTO quickUserRegDTO) {
        if (!this.c.quickUserEnabled) {
            throw new IllegalStateException("quick user not enabled");
        }
        if (quickUserRegCallback == null) {
            throw new IllegalArgumentException(QuickUserRegCallback.class.getSimpleName() + " can't be null");
        }
        if (quickUserRegDTO == null) {
            throw new IllegalArgumentException(QuickUserRegDTO.class.getSimpleName() + " can't be null");
        }
        final QuickUserRegResult quickUserRegResult = new QuickUserRegResult();
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
            this.d.setUserAgent(y());
            Map<String, String> a2 = a(f.j);
            a2.put("crypttype", String.valueOf(6));
            a2.put("cert_id", String.valueOf(1));
            if (!TextUtils.isEmpty(this.f) && !TextUtils.isEmpty(quickUserRegDTO.captcha)) {
                a2.put("verifycode", quickUserRegDTO.captcha);
                a2.put("vcodestr", this.f);
            }
            final SapiDataEncryptor sapiDataEncryptor = new SapiDataEncryptor();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("username", quickUserRegDTO.username);
                jSONObject.put("loginpass", quickUserRegDTO.password);
                jSONObject.put("key", sapiDataEncryptor.a());
                a2.put("userinfo", sapiDataEncryptor.a(SapiDataEncryptor.a.b, jSONObject.toString()));
                a2.put("sig", a(a2, this.c.appSignKey));
                this.d.post(this.c.context, this.e.a() + f.j, new RequestParams(a2), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.57
                    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                    protected void onStart() {
                        quickUserRegCallback.onStart();
                    }

                    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                    protected void onFinish() {
                        quickUserRegCallback.onFinish();
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                    public void onSuccess(int i, String str) {
                        b.this.e.e();
                        int b2 = b.this.b(str);
                        quickUserRegResult.setResultCode(b2);
                        try {
                            JSONObject jSONObject2 = new JSONObject(sapiDataEncryptor.a(new JSONObject(str).optString("userinfo")));
                            quickUserRegResult.setResultMsg(jSONObject2.optJSONObject("sdk").optString(AddFriendActivityConfig.MSG));
                            if (jSONObject2.optInt("needvcode") == 1) {
                                b.this.f = jSONObject2.optString("vcodestr");
                                quickUserRegCallback.onCaptchaRequired(quickUserRegResult);
                            }
                            switch (b2) {
                                case 0:
                                    SapiAccount a3 = b.this.a(jSONObject2);
                                    SapiAccount.ReloginCredentials reloginCredentials = new SapiAccount.ReloginCredentials();
                                    reloginCredentials.account = quickUserRegDTO.username;
                                    reloginCredentials.accountType = jSONObject2.optString("logintype");
                                    reloginCredentials.password = SapiDataEncryptor.encryptPwd(quickUserRegDTO.password);
                                    reloginCredentials.ubi = jSONObject2.optString("ubi");
                                    c.a(b.this.c.context).a(a3.uid, reloginCredentials);
                                    a3.m = SapiAccount.a.a(jSONObject2).a().toString();
                                    com.baidu.sapi2.share.a.a().a(a3);
                                    quickUserRegCallback.onSuccess(quickUserRegResult);
                                    return;
                                case 5:
                                    JSONArray optJSONArray = jSONObject2.optJSONArray("suggnames");
                                    if (optJSONArray != null) {
                                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                            quickUserRegResult.sugUsernameList.add(optJSONArray.optString(i2));
                                        }
                                    }
                                    quickUserRegCallback.onUsernameExist(quickUserRegResult);
                                    return;
                                default:
                                    quickUserRegCallback.onFailure(quickUserRegResult);
                                    return;
                            }
                        } catch (Exception e) {
                            quickUserRegCallback.onFailure(quickUserRegResult);
                            L.e(e);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                    public void onFailure(Throwable th, String str) {
                        if (!b.this.e.c()) {
                            b.this.e.e();
                            if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                                StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                                quickUserRegResult.setResultCode(-203);
                                quickUserRegCallback.onFailure(quickUserRegResult);
                                return;
                            }
                            quickUserRegResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                            quickUserRegCallback.onFailure(quickUserRegResult);
                            return;
                        }
                        b.this.e.b();
                        b.this.a(quickUserRegCallback, quickUserRegDTO);
                    }
                });
            } catch (Exception e) {
                quickUserRegResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                quickUserRegCallback.onFailure(quickUserRegResult);
                L.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final Web2NativeLoginCallback web2NativeLoginCallback, boolean z) {
        if (web2NativeLoginCallback == null) {
            throw new IllegalArgumentException(Web2NativeLoginCallback.class.getSimpleName() + " can't be null");
        }
        final Web2NativeLoginResult web2NativeLoginResult = new Web2NativeLoginResult();
        final String cookieBduss = SapiUtils.getCookieBduss();
        final String cookiePtoken = SapiUtils.getCookiePtoken();
        if (TextUtils.isEmpty(cookieBduss)) {
            web2NativeLoginResult.setResultCode(-101);
            web2NativeLoginCallback.onBdussEmpty(web2NativeLoginResult);
        } else if (!SapiAccountManager.getInstance().isLogin() || z) {
            a(new GetUserInfoCallback() { // from class: com.baidu.sapi2.b.58
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.LoginStatusAware
                /* renamed from: a */
                public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                    web2NativeLoginResult.setResultCode(400021);
                    web2NativeLoginCallback.onBdussExpired(web2NativeLoginResult);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                /* renamed from: b */
                public void onSuccess(GetUserInfoResult getUserInfoResult) {
                    SapiAccount sapiAccount = new SapiAccount();
                    sapiAccount.uid = getUserInfoResult.uid;
                    sapiAccount.username = getUserInfoResult.username;
                    sapiAccount.displayname = getUserInfoResult.displayname;
                    sapiAccount.bduss = cookieBduss;
                    if (!TextUtils.isEmpty(cookiePtoken)) {
                        sapiAccount.k = cookiePtoken;
                    }
                    com.baidu.sapi2.share.a.a().a(sapiAccount);
                    web2NativeLoginResult.setResultCode(0);
                    web2NativeLoginCallback.onSuccess(web2NativeLoginResult);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                /* renamed from: c */
                public void onFailure(GetUserInfoResult getUserInfoResult) {
                    web2NativeLoginResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    web2NativeLoginCallback.onFailure(web2NativeLoginResult);
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onStart() {
                    web2NativeLoginCallback.onStart();
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFinish() {
                    web2NativeLoginCallback.onFinish();
                }
            }, cookieBduss);
        } else {
            SapiAccount session = SapiAccountManager.getInstance().getSession();
            if (!cookieBduss.equals(session.bduss)) {
                SapiAccountManager.getInstance().getAccountService().webLogin(this.c.context, session.bduss);
            }
            web2NativeLoginResult.setResultCode(0);
            web2NativeLoginCallback.onSuccess(web2NativeLoginResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(final SapiCallback<GetDynamicPwdResult> sapiCallback, final String str) {
        if (sapiCallback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        }
        final GetDynamicPwdResult getDynamicPwdResult = new GetDynamicPwdResult();
        if (TextUtils.isEmpty(str)) {
            getDynamicPwdResult.setResultCode(-101);
            sapiCallback.onFailure(getDynamicPwdResult);
        } else if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            getDynamicPwdResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            sapiCallback.onFailure(getDynamicPwdResult);
        } else {
            this.d = new AsyncHttpClient();
            this.d.setUserAgent(y());
            Map<String, String> a2 = a(f.v);
            a2.put("username", str);
            a2.put("sig", a(a2, this.c.appSignKey));
            this.d.post(this.c.context, this.e.a() + f.v, new RequestParams(a2), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.2
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                protected void onStart() {
                    sapiCallback.onStart();
                }

                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                protected void onFinish() {
                    sapiCallback.onFinish();
                }

                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onSuccess(int i, String str2) {
                    b.this.e.e();
                    int b2 = b.this.b(str2);
                    getDynamicPwdResult.setResultCode(b2);
                    try {
                        getDynamicPwdResult.setResultMsg(new JSONObject(str2).optJSONObject("sdk").optString(AddFriendActivityConfig.MSG));
                        switch (b2) {
                            case 0:
                                sapiCallback.onSuccess(getDynamicPwdResult);
                                break;
                            default:
                                sapiCallback.onFailure(getDynamicPwdResult);
                                break;
                        }
                    } catch (Exception e) {
                        sapiCallback.onFailure(getDynamicPwdResult);
                        L.e(e);
                    }
                }

                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onFailure(Throwable th, String str2) {
                    if (!b.this.e.c()) {
                        b.this.e.e();
                        if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                            StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                            getDynamicPwdResult.setResultCode(-203);
                            sapiCallback.onFailure(getDynamicPwdResult);
                            return;
                        }
                        getDynamicPwdResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                        sapiCallback.onFailure(getDynamicPwdResult);
                        return;
                    }
                    b.this.e.b();
                    b.this.b(sapiCallback, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final GetDynamicPwdCallback getDynamicPwdCallback, final String str, final String str2) {
        if (getDynamicPwdCallback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        }
        final GetDynamicPwdResult getDynamicPwdResult = new GetDynamicPwdResult();
        if (TextUtils.isEmpty(str)) {
            getDynamicPwdResult.setResultCode(-101);
            getDynamicPwdCallback.onFailure(getDynamicPwdResult);
        } else if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            getDynamicPwdResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            getDynamicPwdCallback.onFailure(getDynamicPwdResult);
        } else {
            this.d = new AsyncHttpClient();
            this.d.setUserAgent(y());
            Map<String, String> a2 = a(f.v);
            a2.put("username", str);
            a2.put("svcd", "1");
            if (!TextUtils.isEmpty(this.f) && !TextUtils.isEmpty(this.g) && !TextUtils.isEmpty(str2)) {
                a2.put("vcodestr", this.f);
                a2.put("vcodesign", this.g);
                a2.put("verifycode", str2);
            }
            a2.put("sig", a(a2, this.c.appSignKey));
            this.d.post(this.c.context, this.e.a() + f.v, new RequestParams(a2), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.3
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                protected void onStart() {
                    getDynamicPwdCallback.onStart();
                }

                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                protected void onFinish() {
                    getDynamicPwdCallback.onFinish();
                }

                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onSuccess(int i, String str3) {
                    b.this.e.e();
                    int b2 = b.this.b(str3);
                    getDynamicPwdResult.setResultCode(b2);
                    try {
                        JSONObject optJSONObject = new JSONObject(str3).optJSONObject("sdk");
                        getDynamicPwdResult.setResultMsg(optJSONObject.optString(AddFriendActivityConfig.MSG));
                        switch (b2) {
                            case 0:
                                getDynamicPwdCallback.onSuccess(getDynamicPwdResult);
                                break;
                            case 5:
                                b.this.f = optJSONObject.optString("vcodestr");
                                b.this.g = optJSONObject.optString("vcodesign");
                                getDynamicPwdCallback.onCaptchaRequired(getDynamicPwdResult);
                                break;
                            default:
                                getDynamicPwdCallback.onFailure(getDynamicPwdResult);
                                break;
                        }
                    } catch (Exception e) {
                        getDynamicPwdCallback.onFailure(getDynamicPwdResult);
                        L.e(e);
                    }
                }

                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onFailure(Throwable th, String str3) {
                    if (!b.this.e.c()) {
                        b.this.e.e();
                        if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                            StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                            getDynamicPwdResult.setResultCode(-203);
                            getDynamicPwdCallback.onFailure(getDynamicPwdResult);
                            return;
                        }
                        getDynamicPwdResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                        getDynamicPwdCallback.onFailure(getDynamicPwdResult);
                        return;
                    }
                    b.this.e.b();
                    b.this.a(getDynamicPwdCallback, str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final SapiCallback<DynamicPwdLoginResult> sapiCallback, final String str, final String str2) {
        if (sapiCallback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        }
        final DynamicPwdLoginResult dynamicPwdLoginResult = new DynamicPwdLoginResult();
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
            this.d.setUserAgent(y());
            Map<String, String> a2 = a(f.a);
            a2.put("crypttype", String.valueOf(6));
            a2.put("cert_id", String.valueOf(1));
            a2.put("isphone", "1");
            a2.put("isdpass", "1");
            final SapiDataEncryptor sapiDataEncryptor = new SapiDataEncryptor();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("username", str);
                jSONObject.put("password", str2);
                jSONObject.put(LoginActivityConfig.LOGIN_TYPE, "3");
                jSONObject.put("key", sapiDataEncryptor.a());
                a2.put("userinfo", sapiDataEncryptor.a(SapiDataEncryptor.a.b, jSONObject.toString()));
                a2.put("sig", a(a2, this.c.appSignKey));
                this.d.post(this.c.context, s(), new RequestParams(a2), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.4
                    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                    protected void onStart() {
                        sapiCallback.onStart();
                    }

                    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                    protected void onFinish() {
                        sapiCallback.onFinish();
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                    public void onSuccess(int i, String str3) {
                        b.this.e.e();
                        int b2 = b.this.b(str3);
                        dynamicPwdLoginResult.setResultCode(b2);
                        try {
                            JSONObject jSONObject2 = new JSONObject(sapiDataEncryptor.a(new JSONObject(str3).optString("userinfo")));
                            dynamicPwdLoginResult.setResultMsg(jSONObject2.optJSONObject("sdk").optString(AddFriendActivityConfig.MSG));
                            switch (b2) {
                                case 0:
                                    SapiAccount a3 = b.this.a(jSONObject2);
                                    if (sapiCallback instanceof SapiCallbackInterceptor) {
                                        dynamicPwdLoginResult.session = a3;
                                        ((SapiCallbackInterceptor) sapiCallback).beforeSuccess(dynamicPwdLoginResult);
                                    }
                                    a3.m = SapiAccount.a.a(jSONObject2).a().toString();
                                    com.baidu.sapi2.share.a.a().a(a3);
                                    sapiCallback.onSuccess(dynamicPwdLoginResult);
                                    return;
                                default:
                                    sapiCallback.onFailure(dynamicPwdLoginResult);
                                    return;
                            }
                        } catch (Exception e) {
                            sapiCallback.onFailure(dynamicPwdLoginResult);
                            L.e(e);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                    public void onFailure(Throwable th, String str3) {
                        if (!b.this.e.c()) {
                            b.this.e.e();
                            if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                                StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                                dynamicPwdLoginResult.setResultCode(-203);
                                sapiCallback.onFailure(dynamicPwdLoginResult);
                                return;
                            }
                            dynamicPwdLoginResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                            sapiCallback.onFailure(dynamicPwdLoginResult);
                            return;
                        }
                        b.this.e.b();
                        b.this.a(sapiCallback, str, str2);
                    }
                });
            } catch (Exception e) {
                dynamicPwdLoginResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                sapiCallback.onFailure(dynamicPwdLoginResult);
                L.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(final SapiCallBack<SapiAccountResponse> sapiCallBack, final String str, final String str2, final boolean z) {
        if (this.c == null || this.c.context == null) {
            return false;
        }
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            if (sapiCallBack != null) {
                sapiCallBack.onNetworkFailed();
            }
            return true;
        }
        final SapiDataEncryptor sapiDataEncryptor = new SapiDataEncryptor();
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(y());
        this.d.get(this.c.context, A(), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.5
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str3) {
                super.onFailure(th, str3);
                JSONObject jSONObject = new JSONObject();
                String str4 = "";
                try {
                    jSONObject.put("failure_info", str3);
                    str4 = jSONObject.toString();
                } catch (JSONException e) {
                    b.this.a(-100, sapiCallBack, "", z, sapiDataEncryptor);
                    L.e(e);
                }
                if (!b.this.e.c()) {
                    b.this.e.e();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        sapiCallBack.onSystemError(-203);
                        return;
                    }
                    b.this.a(-100, sapiCallBack, str4, z, sapiDataEncryptor);
                    return;
                }
                b.this.e.b();
                b.this.a(sapiCallBack, str, str2, z);
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str3) {
                super.onSuccess(i, str3);
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    b.this.a(sapiCallBack, jSONObject.optString("cert"), jSONObject.optString("cert_id"), str, str2, z, sapiDataEncryptor);
                } catch (Exception e) {
                    b.this.a(-100, sapiCallBack, str3, z, sapiDataEncryptor);
                    L.e(e);
                }
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final SapiCallBack<SapiAccountResponse> sapiCallBack, String str, String str2, final String str3, final String str4, final boolean z, final SapiDataEncryptor sapiDataEncryptor) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, CertificateException, JSONException {
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(y());
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
        jSONObject.put("key", sapiDataEncryptor.a());
        jSONObject.put("sdk_version", "2");
        jSONObject.put("pinfo", SapiDeviceUtils.getBrandName());
        hashMap.put("userinfo", sapiDataEncryptor.a(str, jSONObject.toString()));
        hashMap.put("sig", a(hashMap, this.c.appSignKey));
        this.d.post(this.c.context, s(), new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.6
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str6) {
                super.onSuccess(i, str6);
                b.this.a(b.this.b(str6), sapiCallBack, str6, z, sapiDataEncryptor);
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str6) {
                super.onFailure(th, str6);
                if (!b.this.e.c()) {
                    b.this.e.e();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        sapiCallBack.onSystemError(-203);
                        return;
                    }
                    b.this.a(b.this.b(str6), sapiCallBack, str6, z, sapiDataEncryptor);
                    return;
                }
                b.this.e.b();
                b.this.a(sapiCallBack, str3, str4, z);
            }
        });
    }

    void a(int i, SapiCallBack<SapiAccountResponse> sapiCallBack, String str, boolean z, SapiDataEncryptor sapiDataEncryptor) {
        if (str != null) {
            SapiAccountResponse sapiAccountResponse = new SapiAccountResponse();
            try {
                String optString = new JSONObject(str).optString("userinfo");
                JSONObject jSONObject = null;
                if (!TextUtils.isEmpty(optString)) {
                    jSONObject = new JSONObject(sapiDataEncryptor.a(optString));
                    sapiAccountResponse.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                    sapiAccountResponse.username = jSONObject.optString("uname");
                    sapiAccountResponse.uid = jSONObject.optString(SapiAccountManager.SESSION_UID);
                    sapiAccountResponse.email = jSONObject.optString("email");
                    sapiAccountResponse.bduss = jSONObject.optString(SapiAccountManager.SESSION_BDUSS);
                    sapiAccountResponse.ptoken = jSONObject.optString("ptoken");
                    sapiAccountResponse.stoken = jSONObject.optString("stoken");
                    sapiAccountResponse.authSid = jSONObject.optString("authsid");
                }
                if (sapiCallBack != null) {
                    switch (i) {
                        case 0:
                            if (z) {
                                SapiAccount a2 = a(sapiAccountResponse);
                                a2.m = SapiAccount.a.a(jSONObject).a().toString();
                                com.baidu.sapi2.share.a.a().a(a2);
                            }
                            sapiCallBack.onSuccess(sapiAccountResponse);
                            return;
                        default:
                            sapiCallBack.onSystemError(i);
                            return;
                    }
                }
            } catch (Exception e) {
                L.e(e);
                if (sapiCallBack != null) {
                    sapiCallBack.onSystemError(-100);
                }
            }
        } else if (sapiCallBack != null) {
            sapiCallBack.onSystemError(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final SapiCallBack<SapiResponse> sapiCallBack, final String str, final String str2, final String str3, final byte[] bArr, final String str4) {
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
        this.d.setUserAgent(y());
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
            hashMap.put("ptoken", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("stoken", str3);
        }
        String a2 = a(hashMap, this.c.appSignKey);
        MultipartRequestParams multipartRequestParams = new MultipartRequestParams();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            multipartRequestParams.put(entry.getKey(), entry.getValue());
        }
        multipartRequestParams.put("sig", a2);
        multipartRequestParams.put("file", new ByteArrayInputStream(bArr), "portrait.jpg", TextUtils.isEmpty(str4) ? "image/jpeg" : str4);
        this.d.post(this.c.context, m(), multipartRequestParams, new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.7
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str5) {
                if (!b.this.e.c()) {
                    b.this.e.e();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        sapiCallBack.onSystemError(-203);
                        return;
                    }
                    sapiCallBack.onSystemError(-100);
                    return;
                }
                b.this.e.b();
                b.this.a(sapiCallBack, str, str2, str3, bArr, str4);
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str5) {
                b.this.e.e();
                int b2 = b.this.b(str5);
                if (b2 == 0) {
                    SapiResponse sapiResponse = new SapiResponse();
                    sapiResponse.errorCode = b2;
                    sapiResponse.errorMsg = SetPortraitResult.RESULT_MSG_SUCCESS;
                    sapiCallBack.onSuccess(sapiResponse);
                    return;
                }
                sapiCallBack.onSystemError(b2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final SetPortraitCallback setPortraitCallback, final String str, final byte[] bArr, final String str2) {
        if (setPortraitCallback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("file can't be empty");
        }
        final SetPortraitResult setPortraitResult = new SetPortraitResult();
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            setPortraitResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            setPortraitCallback.onFailure(setPortraitResult);
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(y());
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
        MultipartRequestParams multipartRequestParams = new MultipartRequestParams();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            multipartRequestParams.put(entry.getKey(), entry.getValue());
        }
        multipartRequestParams.put("sig", a2);
        multipartRequestParams.put("file", new ByteArrayInputStream(bArr), "portrait.jpg", TextUtils.isEmpty(str2) ? "image/jpeg" : str2);
        this.d.post(this.c.context, m(), multipartRequestParams, new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.8
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onStart() {
                setPortraitCallback.onStart();
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onFinish() {
                setPortraitCallback.onFinish();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str3) {
                b.this.e.e();
                setPortraitResult.setResultCode(b.this.b(str3));
                switch (setPortraitResult.getResultCode()) {
                    case 0:
                        setPortraitCallback.onSuccess(setPortraitResult);
                        return;
                    case 160103:
                        setPortraitCallback.onBdussExpired(setPortraitResult);
                        return;
                    default:
                        setPortraitCallback.onFailure(setPortraitResult);
                        return;
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str3) {
                if (!b.this.e.c()) {
                    b.this.e.e();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        setPortraitResult.setResultCode(-203);
                        setPortraitCallback.onFailure(setPortraitResult);
                        return;
                    }
                    setPortraitResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    setPortraitCallback.onFailure(setPortraitResult);
                    return;
                }
                b.this.e.b();
                b.this.a(setPortraitCallback, str, bArr, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final SetPopularPortraitCallback setPopularPortraitCallback, final SetPopularPortraitDTO setPopularPortraitDTO) {
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
        final SetPopularPortraitResult setPopularPortraitResult = new SetPopularPortraitResult();
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            setPopularPortraitResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            setPopularPortraitCallback.onFailure(setPopularPortraitResult);
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(y());
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
        this.d.post(this.c.context, q(), multipartRequestParams, new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.9
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str) {
                if (!b.this.e.c()) {
                    b.this.e.e();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        setPopularPortraitResult.setResultCode(-203);
                        setPopularPortraitCallback.onFailure(setPopularPortraitResult);
                        return;
                    }
                    setPopularPortraitResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    setPopularPortraitCallback.onFailure(setPopularPortraitResult);
                    return;
                }
                b.this.e.b();
                b.this.a(setPopularPortraitCallback, setPopularPortraitDTO);
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str) {
                b.this.e.e();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int i2 = jSONObject.getInt("errno");
                    setPopularPortraitResult.setResultCode(i2);
                    setPopularPortraitResult.setResultMsg(jSONObject.optString("errmsg"));
                    if (i2 == 0) {
                        setPopularPortraitCallback.onSuccess(setPopularPortraitResult);
                    } else {
                        setPopularPortraitCallback.onFailure(setPopularPortraitResult);
                    }
                } catch (JSONException e) {
                    setPopularPortraitResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    setPopularPortraitCallback.onFailure(setPopularPortraitResult);
                    L.e(e);
                }
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onStart() {
                setPopularPortraitCallback.onStart();
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFinish() {
                setPopularPortraitCallback.onFinish();
            }
        });
    }

    public void a(final SapiCallBack<GetPortraitResponse> sapiCallBack, final String str, final String str2, final String str3) {
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
        this.d.setUserAgent(y());
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
            hashMap.put("ptoken", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("stoken", str3);
        }
        String a2 = a(hashMap, this.c.appSignKey);
        RequestParams requestParams = new RequestParams();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            requestParams.put(entry.getKey(), entry.getValue());
        }
        requestParams.put("sig", a2);
        this.d.post(this.c.context, this.e.a() + "/v2/sapi/center/getportrait", requestParams, new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.10
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str4) {
                if (!b.this.e.c()) {
                    b.this.e.e();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        sapiCallBack.onSystemError(-203);
                        return;
                    }
                    sapiCallBack.onSystemError(-100);
                    return;
                }
                b.this.e.b();
                b.this.a(sapiCallBack, str, str2, str3);
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str4) {
                b.this.e.e();
                int b2 = b.this.b(str4);
                if (b2 == 0) {
                    try {
                        JSONObject jSONObject = new JSONObject(str4);
                        GetPortraitResponse getPortraitResponse = new GetPortraitResponse();
                        getPortraitResponse.errorCode = b2;
                        getPortraitResponse.errorMsg = jSONObject.optString("errmsg");
                        String optString = jSONObject.optString(IntentConfig.PORTRAIT);
                        if (!TextUtils.isEmpty(optString)) {
                            getPortraitResponse.portrait = String.format("http://himg.bdimg.com/sys/portrait/item/%s.jpg", optString);
                            getPortraitResponse.portraitHttps = String.format("https://ss0.bdstatic.com/7Ls0a8Sm1A5BphGlnYG/sys/portrait/item/%s.jpg", optString);
                        }
                        sapiCallBack.onSuccess(getPortraitResponse);
                        return;
                    } catch (JSONException e) {
                        sapiCallBack.onSystemError(b2);
                        L.e(e);
                        return;
                    }
                }
                sapiCallBack.onSystemError(b2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final GetHistoryPortraitsCallback getHistoryPortraitsCallback, final GetHistoryPortraitsDTO getHistoryPortraitsDTO) {
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
        final GetHistoryPortraitsResult getHistoryPortraitsResult = new GetHistoryPortraitsResult();
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            getHistoryPortraitsResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            getHistoryPortraitsCallback.onFailure(getHistoryPortraitsResult);
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(y());
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
        this.d.post(this.c.context, n(), requestParams, new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.11
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str) {
                if (!b.this.e.c()) {
                    b.this.e.e();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        getHistoryPortraitsResult.setResultCode(-203);
                        getHistoryPortraitsCallback.onFailure(getHistoryPortraitsResult);
                        return;
                    }
                    getHistoryPortraitsResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    getHistoryPortraitsCallback.onFailure(getHistoryPortraitsResult);
                    return;
                }
                b.this.e.b();
                b.this.a(getHistoryPortraitsCallback, getHistoryPortraitsDTO);
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str) {
                b.this.e.e();
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int i2 = jSONObject.getInt("errno");
                    getHistoryPortraitsResult.setResultCode(i2);
                    getHistoryPortraitsResult.setResultMsg(jSONObject.optString("errmsg"));
                    if (i2 == 0) {
                        JSONArray optJSONArray = jSONObject.optJSONArray("history");
                        int length = optJSONArray.length();
                        getHistoryPortraitsResult.historyPortraits = new ArrayList(length);
                        for (int i3 = 0; i3 < length; i3++) {
                            getHistoryPortraitsResult.historyPortraits.add(optJSONArray.optString(i3));
                        }
                        getHistoryPortraitsCallback.onSuccess(getHistoryPortraitsResult);
                        return;
                    }
                    getHistoryPortraitsCallback.onFailure(getHistoryPortraitsResult);
                } catch (JSONException e) {
                    getHistoryPortraitsResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    getHistoryPortraitsCallback.onFailure(getHistoryPortraitsResult);
                    L.e(e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final GetPopularPortraitsCallback getPopularPortraitsCallback, final String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bduss can't be empty nor null");
        }
        final GetPopularPortraitsInfoResult getPopularPortraitsInfoResult = new GetPopularPortraitsInfoResult();
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            getPopularPortraitsInfoResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            getPopularPortraitsCallback.onFailure(getPopularPortraitsInfoResult);
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(y());
        HashMap hashMap = new HashMap();
        hashMap.put(SapiAccountManager.SESSION_BDUSS, str);
        RequestParams requestParams = new RequestParams();
        for (Map.Entry entry : hashMap.entrySet()) {
            requestParams.put((String) entry.getKey(), (String) entry.getValue());
        }
        this.d.post(this.c.context, p(), requestParams, new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.13
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onStart() {
                getPopularPortraitsCallback.onStart();
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFinish() {
                getPopularPortraitsCallback.onFinish();
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str2) {
                if (!b.this.e.c()) {
                    b.this.e.e();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        getPopularPortraitsInfoResult.setResultCode(-203);
                        getPopularPortraitsCallback.onFailure(getPopularPortraitsInfoResult);
                        return;
                    }
                    getPopularPortraitsInfoResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    getPopularPortraitsCallback.onFailure(getPopularPortraitsInfoResult);
                    return;
                }
                b.this.e.b();
                b.this.a(getPopularPortraitsCallback, str);
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str2) {
                b.this.e.e();
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    int optInt = jSONObject.optInt("errno");
                    getPopularPortraitsInfoResult.setResultCode(optInt);
                    getPopularPortraitsInfoResult.setResultMsg(jSONObject.optString("errmsg"));
                    if (optInt == 0) {
                        JSONArray optJSONArray = jSONObject.optJSONArray(IntentConfig.LIST);
                        int length = optJSONArray.length();
                        getPopularPortraitsInfoResult.popularPortraitsInfoList = new ArrayList(length);
                        for (int i2 = 0; i2 < length; i2++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                            if (optJSONObject != null) {
                                GetPopularPortraitsInfoResult.PopularPortraitsInfo popularPortraitsInfo = new GetPopularPortraitsInfoResult.PopularPortraitsInfo();
                                popularPortraitsInfo.num = optJSONObject.optInt("num");
                                popularPortraitsInfo.series = optJSONObject.optString("serie");
                                popularPortraitsInfo.url = optJSONObject.optString("url");
                                popularPortraitsInfo.myItem = optJSONObject.optInt("myitem");
                                getPopularPortraitsInfoResult.popularPortraitsInfoList.add(popularPortraitsInfo);
                            }
                        }
                        getPopularPortraitsCallback.onSuccess(getPopularPortraitsInfoResult);
                        return;
                    }
                    getPopularPortraitsCallback.onFailure(getPopularPortraitsInfoResult);
                } catch (JSONException e) {
                    getPopularPortraitsInfoResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    getPopularPortraitsCallback.onFailure(getPopularPortraitsInfoResult);
                    L.e(e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final GetUserInfoCallback getUserInfoCallback, final String str) {
        if (getUserInfoCallback == null) {
            throw new IllegalArgumentException(GetUserInfoCallback.class.getSimpleName() + " can't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        final GetUserInfoResult getUserInfoResult = new GetUserInfoResult();
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            getUserInfoResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            getUserInfoCallback.onFailure(getUserInfoResult);
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(y());
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
        hashMap.put("sdkversion", SapiAccountManager.VERSION_NAME);
        SapiAccount b2 = c.a(this.c.context).b(str);
        if (b2 != null && !TextUtils.isEmpty(b2.k)) {
            hashMap.put("ptoken", b2.k);
        }
        hashMap.put("client", "android");
        String b3 = e.b(f.k);
        if (!TextUtils.isEmpty(b3)) {
            hashMap.put("di", b3);
        }
        String a2 = a(hashMap, this.c.appSignKey);
        RequestParams requestParams = new RequestParams();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            requestParams.put(entry.getKey(), entry.getValue());
        }
        requestParams.put("sig", a2);
        this.d.post(this.c.context, o(), requestParams, new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.14
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onStart() {
                getUserInfoCallback.onStart();
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onFinish() {
                getUserInfoCallback.onFinish();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str2) {
                b.this.e.e();
                int b4 = b.this.b(str2);
                getUserInfoResult.setResultCode(b4);
                switch (b4) {
                    case 0:
                        try {
                            JSONObject jSONObject = new JSONObject(str2);
                            getUserInfoResult.portraitSign = jSONObject.optString("portrait_tag");
                            getUserInfoResult.isInitialPortrait = "0".equals(getUserInfoResult.portraitSign);
                            String optString = jSONObject.optString(IntentConfig.PORTRAIT);
                            if (!TextUtils.isEmpty(optString)) {
                                getUserInfoResult.portrait = String.format("http://himg.bdimg.com/sys/portrait/item/%s.jpg?%s", optString, getUserInfoResult.portraitSign);
                                getUserInfoResult.portraitHttps = String.format("https://ss0.bdstatic.com/7Ls0a8Sm1A5BphGlnYG/sys/portrait/item/%s.jpg?%s", optString, getUserInfoResult.portraitSign);
                            }
                            getUserInfoResult.username = jSONObject.optString("username");
                            getUserInfoResult.uid = jSONObject.optString("userid");
                            getUserInfoResult.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                            getUserInfoResult.incompleteUser = "1".equals(jSONObject.optString("incomplete_user"));
                            getUserInfoResult.secureMobile = jSONObject.optString("securemobil");
                            getUserInfoResult.secureEmail = jSONObject.optString("secureemail");
                            getUserInfoResult.havePwd = "1".equals(jSONObject.optString("have_psw"));
                            getUserInfoCallback.onSuccess(getUserInfoResult);
                            return;
                        } catch (Exception e) {
                            getUserInfoCallback.onFailure(getUserInfoResult);
                            L.e(e);
                            return;
                        }
                    case 400021:
                        getUserInfoCallback.onBdussExpired(getUserInfoResult);
                        return;
                    default:
                        getUserInfoCallback.onFailure(getUserInfoResult);
                        return;
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str2) {
                if (!b.this.e.c()) {
                    b.this.e.e();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        getUserInfoResult.setResultCode(-203);
                        getUserInfoCallback.onFailure(getUserInfoResult);
                        return;
                    }
                    getUserInfoResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    getUserInfoCallback.onFailure(getUserInfoResult);
                    return;
                }
                b.this.e.b();
                b.this.a(getUserInfoCallback, str);
            }
        });
    }

    public void a(final GetUserInfoCallBack getUserInfoCallBack, final String str) {
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
        this.d.setUserAgent(y());
        HashMap hashMap = new HashMap();
        hashMap.put("appid", this.c.appId);
        hashMap.put("tpl", this.c.tpl);
        if (!TextUtils.isEmpty(this.c.clientId)) {
            hashMap.put("clientid", this.c.clientId);
        }
        if (!TextUtils.isEmpty(this.c.clientIp)) {
            hashMap.put("clientip", this.c.clientIp);
        }
        hashMap.put("sdkversion", SapiAccountManager.VERSION_NAME);
        SapiAccount b2 = c.a(this.c.context).b(str);
        if (b2 != null && !TextUtils.isEmpty(b2.k)) {
            hashMap.put("ptoken", b2.k);
        }
        hashMap.put("client", "android");
        String b3 = e.b(f.k);
        if (!TextUtils.isEmpty(b3)) {
            hashMap.put("di", b3);
        }
        hashMap.put(SapiAccountManager.SESSION_BDUSS, str);
        String a2 = a(hashMap, this.c.appSignKey);
        RequestParams requestParams = new RequestParams();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            requestParams.put(entry.getKey(), entry.getValue());
        }
        requestParams.put("sig", a2);
        this.d.post(this.c.context, o(), requestParams, new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.15
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str2) {
                b.this.e.e();
                getUserInfoCallBack.onFinish();
                int b4 = b.this.b(str2);
                switch (b4) {
                    case 0:
                        try {
                            JSONObject jSONObject = new JSONObject(str2);
                            GetUserInfoResponse getUserInfoResponse = new GetUserInfoResponse();
                            getUserInfoResponse.errorCode = b4;
                            getUserInfoResponse.errorMsg = jSONObject.optString("errmsg");
                            String optString = jSONObject.optString(IntentConfig.PORTRAIT);
                            if (!TextUtils.isEmpty(optString)) {
                                getUserInfoResponse.portrait = String.format("http://himg.bdimg.com/sys/portrait/item/%s.jpg", optString);
                                getUserInfoResponse.portraitHttps = String.format("https://ss0.bdstatic.com/7Ls0a8Sm1A5BphGlnYG/sys/portrait/item/%s.jpg", optString);
                            }
                            getUserInfoResponse.username = jSONObject.optString("username");
                            getUserInfoResponse.uid = jSONObject.optString("userid");
                            getUserInfoResponse.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                            getUserInfoResponse.incompleteUser = "1".equals(jSONObject.optString("incomplete_user"));
                            getUserInfoResponse.secureMobile = jSONObject.optString("securemobil");
                            getUserInfoResponse.secureEmail = jSONObject.optString("secureemail");
                            getUserInfoCallBack.onSuccess(getUserInfoResponse);
                            return;
                        } catch (JSONException e) {
                            getUserInfoCallBack.onSystemError(b4);
                            L.e(e);
                            return;
                        }
                    case 400021:
                        getUserInfoCallBack.onBdussInvalid();
                        return;
                    default:
                        getUserInfoCallBack.onSystemError(b4);
                        return;
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str2) {
                if (!b.this.e.c()) {
                    b.this.e.e();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        getUserInfoCallBack.onFinish();
                        getUserInfoCallBack.onSystemError(-203);
                        return;
                    }
                    getUserInfoCallBack.onFinish();
                    getUserInfoCallBack.onSystemError(-100);
                    return;
                }
                b.this.e.b();
                b.this.a(getUserInfoCallBack, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final FillUsernameCallback fillUsernameCallback, final String str, final String str2) {
        if (fillUsernameCallback == null) {
            throw new IllegalArgumentException(FillUsernameCallback.class.getSimpleName() + " can't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("username can't be empty");
        }
        final FillUsernameResult fillUsernameResult = new FillUsernameResult();
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            fillUsernameResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            fillUsernameCallback.onFailure(fillUsernameResult);
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(y());
        HashMap hashMap = new HashMap();
        hashMap.put("appid", this.c.appId);
        hashMap.put("tpl", this.c.tpl);
        hashMap.put("cert_id", String.valueOf(1));
        hashMap.put("crypttype", String.valueOf(6));
        JSONObject jSONObject = new JSONObject();
        final SapiDataEncryptor sapiDataEncryptor = new SapiDataEncryptor();
        try {
            jSONObject.put(SapiAccountManager.SESSION_BDUSS, str);
            if (!TextUtils.isEmpty(this.c.clientId)) {
                jSONObject.put("clientid", this.c.clientId);
            }
            if (!TextUtils.isEmpty(this.c.clientIp)) {
                jSONObject.put("clientip", this.c.clientIp);
            }
            jSONObject.put("username", str2);
            jSONObject.put("key", sapiDataEncryptor.a());
            hashMap.put("userinfo", sapiDataEncryptor.a(SapiDataEncryptor.a.b, jSONObject.toString()));
            hashMap.put("sig", a(hashMap, this.c.appSignKey));
            this.d.post(this.c.context, l(), new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.16
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                protected void onStart() {
                    fillUsernameCallback.onStart();
                }

                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                protected void onFinish() {
                    fillUsernameCallback.onFinish();
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onSuccess(int i, String str3) {
                    b.this.e.e();
                    int b2 = b.this.b(str3);
                    fillUsernameResult.setResultCode(b2);
                    try {
                        JSONObject jSONObject2 = new JSONObject(sapiDataEncryptor.a(new JSONObject(str3).optString("userinfo")));
                        switch (b2) {
                            case 0:
                            case 110000:
                                SapiAccount sapiAccount = new SapiAccount();
                                sapiAccount.bduss = jSONObject2.optString(SapiAccountManager.SESSION_BDUSS);
                                sapiAccount.k = jSONObject2.optString("ptoken");
                                sapiAccount.l = jSONObject2.optString("stoken");
                                sapiAccount.displayname = jSONObject2.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                                sapiAccount.username = jSONObject2.optString("uname");
                                sapiAccount.uid = jSONObject2.optString(SapiAccountManager.SESSION_UID);
                                sapiAccount.m = SapiAccount.a.a(jSONObject2).a().toString();
                                com.baidu.sapi2.share.a.a().a(sapiAccount);
                                fillUsernameResult.session = sapiAccount;
                                fillUsernameCallback.onSuccess(fillUsernameResult);
                                break;
                            case 160103:
                                fillUsernameCallback.onBdussExpired(fillUsernameResult);
                                break;
                            case 160104:
                                fillUsernameCallback.onUserHaveUsername(fillUsernameResult);
                                break;
                            default:
                                fillUsernameCallback.onFailure(fillUsernameResult);
                                break;
                        }
                    } catch (Throwable th) {
                        fillUsernameCallback.onFailure(fillUsernameResult);
                        L.e(th);
                    }
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onFailure(Throwable th, String str3) {
                    if (!b.this.e.c()) {
                        b.this.e.e();
                        if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                            StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                            fillUsernameResult.setResultCode(-203);
                            fillUsernameCallback.onFailure(fillUsernameResult);
                            return;
                        }
                        fillUsernameResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                        fillUsernameCallback.onFailure(fillUsernameResult);
                        return;
                    }
                    b.this.e.b();
                    b.this.a(fillUsernameCallback, str, str2);
                }
            });
        } catch (Throwable th) {
            fillUsernameResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
            fillUsernameCallback.onFailure(fillUsernameResult);
            L.e(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final FillUsernameCallBack fillUsernameCallBack, final String str, final String str2, final String str3) {
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            if (fillUsernameCallBack != null) {
                fillUsernameCallBack.onNetworkFailed();
                return;
            }
            return;
        }
        final SapiDataEncryptor sapiDataEncryptor = new SapiDataEncryptor();
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(y());
        this.d.get(this.c.context, A(), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.17
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str4) {
                super.onFailure(th, str4);
                JSONObject jSONObject = new JSONObject();
                String str5 = "";
                try {
                    jSONObject.put("failure_info", str4);
                    str5 = jSONObject.toString();
                } catch (JSONException e) {
                    L.e(e);
                }
                if (!b.this.e.c()) {
                    b.this.e.e();
                    if (th == null || !SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        b.this.a(-100, fillUsernameCallBack, str5, sapiDataEncryptor);
                        return;
                    }
                    StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                    fillUsernameCallBack.onSystemError(-203);
                    return;
                }
                b.this.a(fillUsernameCallBack, str, str2, str3);
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str4) {
                super.onSuccess(i, str4);
                b.this.e.e();
                try {
                    JSONObject jSONObject = new JSONObject(str4);
                    b.this.a(fillUsernameCallBack, str, str2, str3, jSONObject.optString("cert"), jSONObject.optString("cert_id"), sapiDataEncryptor);
                } catch (Exception e) {
                    b.this.a(b.this.c(str4), fillUsernameCallBack, str4, sapiDataEncryptor);
                    L.e(e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final FillUsernameCallBack fillUsernameCallBack, String str, String str2, String str3, String str4, String str5, final SapiDataEncryptor sapiDataEncryptor) throws JSONException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, CertificateException {
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(y());
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
            jSONObject.put("ptoken", str2);
        }
        jSONObject.put("username", str3);
        jSONObject.put("key", sapiDataEncryptor.a());
        hashMap.put("userinfo", sapiDataEncryptor.a(str4, jSONObject.toString()));
        hashMap.put("sig", a(hashMap, this.c.appSignKey));
        this.d.post(this.c.context, l(), new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.18
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str6) {
                super.onSuccess(i, str6);
                b.this.a(b.this.c(str6), fillUsernameCallBack, str6, sapiDataEncryptor);
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str6) {
                super.onFailure(th, str6);
                b.this.a(b.this.c(str6), fillUsernameCallBack, str6, sapiDataEncryptor);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final FillUserProfileCallback fillUserProfileCallback, final String str) {
        if (fillUserProfileCallback == null) {
            throw new IllegalArgumentException(FillUserProfileCallback.class.getSimpleName() + " can't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        final FillUserProfileResult fillUserProfileResult = new FillUserProfileResult();
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            fillUserProfileResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            fillUserProfileCallback.onFailure(fillUserProfileResult);
        } else if (!SapiUtils.isSimReady(this.c.context)) {
            fillUserProfileResult.setResultCode(-101);
            fillUserProfileCallback.onFailure(fillUserProfileResult);
        } else {
            this.d = new AsyncHttpClient();
            this.d.setUserAgent(y());
            HashMap hashMap = new HashMap();
            hashMap.put("appid", this.c.appId);
            hashMap.put("tpl", this.c.tpl);
            if (!TextUtils.isEmpty(this.c.clientId)) {
                hashMap.put("clientid", this.c.clientId);
            }
            hashMap.put(SapiAccountManager.SESSION_BDUSS, str);
            hashMap.put("sig", a(hashMap, this.c.appSignKey));
            this.d.post(this.c.context, this.e.a() + f.J, new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.19
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                protected void onStart() {
                    fillUserProfileCallback.onStart();
                }

                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                protected void onFinish() {
                    fillUserProfileCallback.onFinish();
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onSuccess(int i, String str2) {
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        int b2 = b.this.b(str2);
                        fillUserProfileResult.setResultCode(b2);
                        switch (b2) {
                            case 0:
                                String optString = jSONObject.optString("sms");
                                final String optString2 = jSONObject.optString("vcode");
                                final String optString3 = jSONObject.optString("upsmschannel");
                                boolean z = false;
                                if (SapiUtils.checkRequestPermission("android.permission.SEND_SMS", b.this.c.context)) {
                                    z = SapiUtils.sendSms(b.this.c.context, optString2, optString);
                                }
                                if (z && !TextUtils.isEmpty(optString3)) {
                                    b.this.d = new AsyncHttpClient();
                                    b.this.d.setUserAgent(b.this.y());
                                    CookieStore basicCookieStore = new BasicCookieStore();
                                    BasicClientCookie basicClientCookie = new BasicClientCookie("BAIDUID", SapiUtils.getClientId(b.this.c.context));
                                    basicClientCookie.setDomain("baidu.com");
                                    basicClientCookie.setPath("/");
                                    basicCookieStore.addCookie(basicClientCookie);
                                    b.this.d.setCookieStore(basicCookieStore);
                                    RequestParams requestParams = new RequestParams();
                                    requestParams.put("channel_id", optString3);
                                    requestParams.put("callback", "p");
                                    requestParams.put("apiver", "v3");
                                    requestParams.put("tt", String.valueOf(System.currentTimeMillis()));
                                    b.this.d.get(b.this.c.context, "https://passport.baidu.com/channel/unicast", requestParams, new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.19.1
                                        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                                        protected void onStart() {
                                            fillUserProfileCallback.onStart();
                                        }

                                        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                                        protected void onFinish() {
                                            fillUserProfileCallback.onFinish();
                                        }

                                        /* JADX INFO: Access modifiers changed from: protected */
                                        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                                        public void onSuccess(int i2, String str3) {
                                            if (TextUtils.isEmpty(str3)) {
                                                fillUserProfileResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                                                fillUserProfileCallback.onFailure(fillUserProfileResult);
                                                return;
                                            }
                                            int indexOf = str3.indexOf("(");
                                            int indexOf2 = str3.indexOf(")");
                                            if (indexOf >= 0) {
                                                try {
                                                    int b3 = b.this.b(str3.substring(indexOf + 1, indexOf2));
                                                    fillUserProfileResult.setResultCode(b3);
                                                    switch (b3) {
                                                        case 0:
                                                            HashMap hashMap2 = new HashMap();
                                                            hashMap2.put("appid", b.this.c.appId);
                                                            hashMap2.put("tpl", b.this.c.tpl);
                                                            if (!TextUtils.isEmpty(b.this.c.clientId)) {
                                                                hashMap2.put("clientid", b.this.c.clientId);
                                                            }
                                                            hashMap2.put("upsmschannel", optString3);
                                                            hashMap2.put(SapiAccountManager.SESSION_BDUSS, str);
                                                            hashMap2.put("vcode", optString2);
                                                            hashMap2.put("sig", b.this.a(hashMap2, b.this.c.appSignKey));
                                                            b.this.a(fillUserProfileCallback, fillUserProfileResult, hashMap2);
                                                            break;
                                                    }
                                                    fillUserProfileCallback.onFailure(fillUserProfileResult);
                                                    return;
                                                } catch (Throwable th) {
                                                    L.e(th);
                                                    fillUserProfileResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                                                    fillUserProfileCallback.onFailure(fillUserProfileResult);
                                                    return;
                                                }
                                            }
                                            fillUserProfileResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                                            fillUserProfileCallback.onFailure(fillUserProfileResult);
                                        }

                                        /* JADX INFO: Access modifiers changed from: protected */
                                        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                                        public void onFailure(Throwable th, String str3) {
                                            fillUserProfileResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                                            fillUserProfileCallback.onFailure(fillUserProfileResult);
                                        }
                                    });
                                    return;
                                }
                                fillUserProfileResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                                fillUserProfileCallback.onFailure(fillUserProfileResult);
                                return;
                            case 1:
                                fillUserProfileCallback.onBdussExpired(fillUserProfileResult);
                                return;
                            case FillUserProfileResult.RESULT_CODE_COMPLETE_USER /* 61002 */:
                                fillUserProfileCallback.onCompleteUser(fillUserProfileResult);
                                return;
                            default:
                                fillUserProfileCallback.onFailure(fillUserProfileResult);
                                return;
                        }
                    } catch (Throwable th) {
                        fillUserProfileResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                        fillUserProfileCallback.onFailure(fillUserProfileResult);
                    }
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onFailure(Throwable th, String str2) {
                    fillUserProfileResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    fillUserProfileCallback.onFailure(fillUserProfileResult);
                }
            });
        }
    }

    void a(final FillUserProfileCallback fillUserProfileCallback, final FillUserProfileResult fillUserProfileResult, Map<String, String> map) {
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(y());
        this.d.post(this.c.context, this.e.a() + f.K, new RequestParams(map), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.20
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onStart() {
                fillUserProfileCallback.onStart();
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onFinish() {
                fillUserProfileCallback.onFinish();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str) {
                try {
                    int b2 = b.this.b(str);
                    fillUserProfileResult.setResultCode(b2);
                    switch (b2) {
                        case 0:
                            SapiAccount sapiAccount = new SapiAccount();
                            JSONObject jSONObject = new JSONObject(str);
                            sapiAccount.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                            sapiAccount.bduss = jSONObject.optString(SapiAccountManager.SESSION_BDUSS);
                            sapiAccount.uid = jSONObject.optString(SapiAccountManager.SESSION_UID);
                            sapiAccount.k = jSONObject.optString("ptoken");
                            sapiAccount.l = jSONObject.optString("stoken");
                            sapiAccount.m = SapiAccount.a.a(jSONObject).a().toString();
                            fillUserProfileResult.session = sapiAccount;
                            if (SapiAccountManager.getInstance().isLogin()) {
                                SapiAccount session = SapiAccountManager.getInstance().getSession();
                                if (session.uid.equals(fillUserProfileResult.session.uid)) {
                                    session.displayname = fillUserProfileResult.session.displayname;
                                    session.bduss = fillUserProfileResult.session.bduss;
                                    session.k = fillUserProfileResult.session.k;
                                    session.m = fillUserProfileResult.session.m;
                                    SapiAccountManager.getInstance().validate(session);
                                }
                            }
                            fillUserProfileCallback.onSuccess(fillUserProfileResult);
                            return;
                        default:
                            fillUserProfileCallback.onFailure(fillUserProfileResult);
                            return;
                    }
                } catch (Throwable th) {
                    fillUserProfileResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    fillUserProfileCallback.onFailure(fillUserProfileResult);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str) {
                fillUserProfileResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                fillUserProfileCallback.onFailure(fillUserProfileResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final VoiceCheckCallback voiceCheckCallback, final VoiceCheckDTO voiceCheckDTO) {
        if (voiceCheckCallback == null) {
            throw new IllegalArgumentException(VoiceCheckCallback.class.getSimpleName() + " can't be null");
        }
        if (voiceCheckDTO == null) {
            throw new IllegalArgumentException(VoiceCheckDTO.class.getSimpleName() + " can't be null");
        }
        final VoiceCheckResult voiceCheckResult = new VoiceCheckResult();
        if (TextUtils.isEmpty(voiceCheckDTO.account)) {
            voiceCheckResult.setResultCode(-101);
            voiceCheckCallback.onFailure(voiceCheckResult);
        } else if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            voiceCheckResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            voiceCheckCallback.onFailure(voiceCheckResult);
        } else {
            this.d = new AsyncHttpClient();
            this.d.setUserAgent(y());
            HashMap hashMap = new HashMap();
            hashMap.put("appid", this.c.appId);
            hashMap.put("tpl", this.c.tpl);
            if (!TextUtils.isEmpty(this.c.clientId)) {
                hashMap.put("clientid", this.c.clientId);
            }
            String b2 = e.b(f.L);
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
            this.d.post(this.c.context, this.e.a() + f.L, new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.21
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                protected void onStart() {
                    voiceCheckCallback.onStart();
                }

                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                protected void onFinish() {
                    voiceCheckCallback.onFinish();
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onSuccess(int i, String str) {
                    b.this.e.e();
                    b.this.a(voiceCheckCallback, str);
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onFailure(Throwable th, String str) {
                    if (!b.this.e.c()) {
                        b.this.e.e();
                        if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                            StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                            voiceCheckResult.setResultCode(-203);
                            voiceCheckCallback.onFailure(voiceCheckResult);
                            return;
                        }
                        voiceCheckResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                        voiceCheckCallback.onFailure(voiceCheckResult);
                        return;
                    }
                    b.this.e.b();
                    b.this.a(voiceCheckCallback, voiceCheckDTO);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final VoiceCheckCallback voiceCheckCallback, final String str, final String str2) {
        if (voiceCheckCallback == null) {
            throw new IllegalArgumentException(VoiceCheckCallback.class.getSimpleName() + " can't be null");
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("either uid or bduss should be assigned");
        }
        final VoiceCheckResult voiceCheckResult = new VoiceCheckResult();
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            voiceCheckResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            voiceCheckCallback.onFailure(voiceCheckResult);
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(y());
        HashMap hashMap = new HashMap();
        hashMap.put("appid", this.c.appId);
        hashMap.put("tpl", this.c.tpl);
        if (!TextUtils.isEmpty(this.c.clientId)) {
            hashMap.put("clientid", this.c.clientId);
        }
        if (!TextUtils.isEmpty(this.c.clientIp)) {
            hashMap.put("clientip", this.c.clientIp);
        }
        String b2 = e.b(f.L);
        if (!TextUtils.isEmpty(b2)) {
            hashMap.put("di", b2);
        }
        if (!TextUtils.isEmpty(str)) {
            hashMap.put(SapiAccountManager.SESSION_BDUSS, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("userid", str2);
        }
        hashMap.put("sig", a(hashMap, this.c.appSignKey));
        this.d.post(this.c.context, this.e.a() + f.L, new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.22
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onStart() {
                voiceCheckCallback.onStart();
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onFinish() {
                voiceCheckCallback.onFinish();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str3) {
                b.this.e.e();
                b.this.a(voiceCheckCallback, str3);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str3) {
                if (!b.this.e.c()) {
                    b.this.e.e();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        voiceCheckResult.setResultCode(-203);
                        voiceCheckCallback.onFailure(voiceCheckResult);
                        return;
                    }
                    voiceCheckResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    voiceCheckCallback.onFailure(voiceCheckResult);
                    return;
                }
                b.this.e.b();
                b.this.a(voiceCheckCallback, str, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(VoiceCheckCallback voiceCheckCallback, String str) {
        VoiceCheckResult voiceCheckResult = new VoiceCheckResult();
        try {
            JSONObject jSONObject = new JSONObject(str);
            int parseInt = Integer.parseInt(jSONObject.optString("errno"));
            voiceCheckResult.setResultCode(parseInt);
            switch (parseInt) {
                case 0:
                    voiceCheckResult.uid = SapiDataEncryptor.b(jSONObject.optString("id"), SapiDataEncryptor.a);
                    voiceCheckResult.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                    voiceCheckResult.signUp = "1".equals(jSONObject.optString("voice"));
                    voiceCheckResult.needVerify = "1".equals(jSONObject.optString("needverify"));
                    voiceCheckResult.authToken = jSONObject.optString("token");
                    if (!TextUtils.isEmpty(jSONObject.optString("loginswitch")) && jSONObject.optString("loginswitch").equals("1")) {
                        voiceCheckResult.switchState = Switch.ON;
                    } else {
                        voiceCheckResult.switchState = Switch.OFF;
                    }
                    if ("null".equals(voiceCheckResult.authToken)) {
                        voiceCheckResult.authToken = null;
                    }
                    voiceCheckResult.authSid = jSONObject.optString("authsid");
                    if ("null".equals(voiceCheckResult.authSid)) {
                        voiceCheckResult.authSid = null;
                    }
                    try {
                        voiceCheckResult.voiceCode = Integer.parseInt(SapiDataEncryptor.b(jSONObject.optString("password"), SapiDataEncryptor.a));
                    } catch (Exception e) {
                        voiceCheckResult.voiceCode = -1;
                        L.e(e);
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
        } catch (Exception e2) {
            voiceCheckResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
            voiceCheckCallback.onFailure(voiceCheckResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(String str, List<String> list) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("targetTplList can't be null or empty");
        }
        return a(c.a(this.c.context).b(str), list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(SapiAccount sapiAccount, List<String> list) {
        boolean z;
        if (sapiAccount == null || TextUtils.isEmpty(sapiAccount.m)) {
            return false;
        }
        try {
            SapiAccount.a a2 = SapiAccount.a.a(new JSONObject(sapiAccount.m));
            Iterator<String> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                if (!a2.b.containsKey(it.next())) {
                    z = false;
                    break;
                }
            }
            return z;
        } catch (JSONException e) {
            L.e(e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, String> a(final GetTplStokenCallback getTplStokenCallback, final String str, final List<String> list, final boolean z) {
        if (getTplStokenCallback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        final GetTplStokenResult getTplStokenResult = new GetTplStokenResult();
        if (list == null || list.isEmpty()) {
            getTplStokenResult.setResultCode(GetTplStokenResult.ERROR_CODE_TARGET_TPL_LIST_EMPTY);
            getTplStokenResult.setResultMsg(SapiResult.ERROR_MSG_PARAMS_ERROR);
            getTplStokenCallback.onFailure(getTplStokenResult);
            return getTplStokenResult.tplStokenMap;
        }
        final SapiAccount b2 = c.a(this.c.context).b(str);
        if (b2 == null) {
            getTplStokenResult.setResultCode(GetTplStokenResult.ERROR_CODE_BDUSS_NOT_EXIST);
            getTplStokenCallback.onFailure(getTplStokenResult);
            return getTplStokenResult.tplStokenMap;
        }
        final String str2 = b2.k;
        if (a(str, list)) {
            try {
                SapiAccount.a a2 = SapiAccount.a.a(new JSONObject(b2.m));
                Iterator<String> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String next = it.next();
                    if (a2.b.containsKey(next)) {
                        getTplStokenResult.tplStokenMap.put(next, a2.b.get(next));
                    } else {
                        getTplStokenResult.tplStokenMap.clear();
                        break;
                    }
                }
                if (!getTplStokenResult.tplStokenMap.isEmpty()) {
                    getTplStokenResult.setResultCode(0);
                    getTplStokenResult.setResultMsg(SapiResult.RESULT_MSG_SUCCESS);
                    getTplStokenCallback.onSuccess(getTplStokenResult);
                    return getTplStokenResult.tplStokenMap;
                }
            } catch (JSONException e) {
                L.e(e);
                getTplStokenResult.setResultCode(GetTplStokenResult.ERROR_CODE_PARSE_DATA_FAIL);
                getTplStokenCallback.onFailure(getTplStokenResult);
                return getTplStokenResult.tplStokenMap;
            }
        }
        String str3 = list.get(0);
        int i = 1;
        while (i < list.size()) {
            String str4 = str3 + "|" + list.get(i);
            i++;
            str3 = str4;
        }
        if (TextUtils.isEmpty(str2)) {
            getTplStokenResult.setResultCode(GetTplStokenResult.ERROR_CODE_PTOKEN_EMPTY);
            getTplStokenResult.failureType = GetTplStokenResult.FailureType.PTOKEN_EMPTY;
            getTplStokenCallback.onFailure(getTplStokenResult);
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(y());
        HashMap hashMap = new HashMap();
        hashMap.put("appid", this.c.appId);
        hashMap.put("tpl", this.c.tpl);
        hashMap.put(SapiAccountManager.SESSION_BDUSS, str);
        hashMap.put(SapiUtils.KEY_QR_LOGIN_SIGN, MD5Util.toMd5((this.c.appId + this.c.tpl + str + this.c.appSignKey).getBytes(), false));
        hashMap.put("client", "android");
        hashMap.put("return_type", "1");
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("ptoken", str2);
        }
        hashMap.put("tpl_list", str3);
        hashMap.put("sig", a(hashMap, this.c.appSignKey));
        this.d.post(this.c.context, this.e.a() + f.I, new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.24
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onStart() {
                getTplStokenCallback.onStart();
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onFinish() {
                getTplStokenCallback.onFinish();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i2, String str5) {
                b.this.e.e();
                try {
                    JSONObject jSONObject = new JSONObject(str5);
                    int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                    getTplStokenResult.setResultCode(parseInt);
                    switch (parseInt) {
                        case 0:
                            Map<String, String> b3 = SapiAccount.a.b(jSONObject.optJSONObject("stoken_list"));
                            getTplStokenResult.tplStokenMap = b3;
                            SapiAccount.b bVar = new SapiAccount.b();
                            if (!TextUtils.isEmpty(b2.m)) {
                                bVar = SapiAccount.b.a(new JSONObject(b2.m));
                            }
                            bVar.i.b.putAll(b3);
                            if (SocialType.UNKNOWN == b2.getSocialType()) {
                                b2.m = bVar.i.a().toString();
                            } else {
                                b2.m = bVar.a().toString();
                            }
                            if (list.size() == b3.size()) {
                                if (!z) {
                                    c.a(b.this.c.context).a(b2);
                                    c.a(b.this.c.context).a(b2, false);
                                    c.a(b.this.c.context).c(b2);
                                } else {
                                    com.baidu.sapi2.share.a.a().a(b2);
                                }
                                getTplStokenCallback.onSuccess(getTplStokenResult);
                                return;
                            }
                            getTplStokenResult.setResultCode(GetTplStokenResult.ERROR_CODE_STOKENS_NOT_MATCH);
                            getTplStokenCallback.onFailure(getTplStokenResult);
                            return;
                        case 8:
                            if (!TextUtils.isEmpty(str2)) {
                                String optString = jSONObject.optString("ssnerror");
                                if (TextUtils.isEmpty(optString)) {
                                    optString = "0";
                                }
                                int parseInt2 = Integer.parseInt(optString);
                                if (parseInt2 == GetTplStokenResult.FailureType.BDUSS_PTOKEN_NOT_MATCH.ordinal()) {
                                    getTplStokenResult.failureType = GetTplStokenResult.FailureType.BDUSS_PTOKEN_NOT_MATCH;
                                } else if (parseInt2 == GetTplStokenResult.FailureType.BDUSS_EXPIRED.ordinal()) {
                                    getTplStokenResult.failureType = GetTplStokenResult.FailureType.BDUSS_EXPIRED;
                                }
                                getTplStokenResult.setResultMsg(jSONObject.optString("errmsg"));
                                getTplStokenCallback.onFailure(getTplStokenResult);
                                return;
                            }
                            return;
                        default:
                            if (!TextUtils.isEmpty(str2)) {
                                getTplStokenResult.setResultMsg(jSONObject.optString("errmsg"));
                                getTplStokenCallback.onFailure(getTplStokenResult);
                                return;
                            }
                            return;
                    }
                } catch (Exception e2) {
                    L.e(e2);
                    if (!TextUtils.isEmpty(str2)) {
                        getTplStokenResult.setResultCode(SapiResult.ERROR_CODE_SERVER_DATA_ERROR);
                        getTplStokenCallback.onFailure(getTplStokenResult);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str5) {
                if (!b.this.e.c()) {
                    b.this.e.e();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        if (!TextUtils.isEmpty(str2)) {
                            getTplStokenResult.setResultCode(-203);
                            getTplStokenCallback.onFailure(getTplStokenResult);
                            return;
                        }
                        return;
                    } else if (!TextUtils.isEmpty(str2)) {
                        getTplStokenResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                        getTplStokenCallback.onFailure(getTplStokenResult);
                        return;
                    } else {
                        return;
                    }
                }
                b.this.e.b();
                b.this.a(getTplStokenCallback, str, list, z);
            }
        });
        return getTplStokenResult.tplStokenMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(final SapiCallback<OAuthResult> sapiCallback, final String str) {
        if (sapiCallback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        final OAuthResult oAuthResult = new OAuthResult();
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            oAuthResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            sapiCallback.onFailure(oAuthResult);
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(y());
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
        this.d.post(this.c.context, this.e.a() + f.H, new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.25
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onStart() {
                sapiCallback.onStart();
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onFinish() {
                sapiCallback.onFinish();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str2) {
                b.this.e.e();
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                    oAuthResult.setResultCode(parseInt);
                    switch (parseInt) {
                        case 0:
                            oAuthResult.accessToken = jSONObject.optString("access_token");
                            oAuthResult.expiresIn = jSONObject.optInt("expires_in");
                            oAuthResult.scope = jSONObject.optString("scope");
                            oAuthResult.refreshToken = jSONObject.optString("refresh_token");
                            oAuthResult.sessionKey = jSONObject.optString("session_key");
                            oAuthResult.sessionSecret = jSONObject.optString("session_secret");
                            oAuthResult.extra = str2;
                            sapiCallback.onSuccess(oAuthResult);
                            break;
                        default:
                            sapiCallback.onFailure(oAuthResult);
                            break;
                    }
                } catch (Throwable th) {
                    oAuthResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    sapiCallback.onFailure(oAuthResult);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str2) {
                if (!b.this.e.c()) {
                    b.this.e.e();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        oAuthResult.setResultCode(-203);
                        sapiCallback.onFailure(oAuthResult);
                        return;
                    }
                    oAuthResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    sapiCallback.onFailure(oAuthResult);
                    return;
                }
                b.this.e.b();
                b.this.c(sapiCallback, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final SapiCallback<VoiceRegResult> sapiCallback, final String str, final String str2, final String str3, final boolean z) {
        if (sapiCallback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("voiceMd5 can't be empty");
        }
        final VoiceRegResult voiceRegResult = new VoiceRegResult();
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            voiceRegResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            sapiCallback.onFailure(voiceRegResult);
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(y());
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
        String b2 = e.b(f.M);
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
        if (z) {
            hashMap.put("newuser", "1");
        } else {
            hashMap.put("newuser", "0");
        }
        hashMap.put("sig", a(hashMap, this.c.appSignKey));
        this.d.post(this.c.context, this.e.a() + f.M, new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.26
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onStart() {
                sapiCallback.onStart();
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onFinish() {
                sapiCallback.onFinish();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str4) {
                b.this.e.e();
                b.this.a(sapiCallback, str4, z);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str4) {
                if (!b.this.e.c()) {
                    b.this.e.e();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        voiceRegResult.setResultCode(-203);
                        sapiCallback.onFailure(voiceRegResult);
                        return;
                    }
                    voiceRegResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    sapiCallback.onFailure(voiceRegResult);
                    return;
                }
                b.this.e.b();
                b.this.a(sapiCallback, str, str2, str3, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SapiCallback<VoiceRegResult> sapiCallback, String str, boolean z) {
        VoiceRegResult voiceRegResult = new VoiceRegResult();
        try {
            JSONObject jSONObject = new JSONObject(str);
            int parseInt = Integer.parseInt(jSONObject.optString("errno"));
            voiceRegResult.setResultCode(parseInt);
            switch (parseInt) {
                case 0:
                    if (z) {
                        SapiAccount a2 = a(jSONObject);
                        a2.m = SapiAccount.a.a(jSONObject).a().toString();
                        com.baidu.sapi2.share.a.a().a(a2);
                    }
                    sapiCallback.onSuccess(voiceRegResult);
                    return;
                default:
                    sapiCallback.onFailure(voiceRegResult);
                    return;
            }
        } catch (Exception e) {
            voiceRegResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
            sapiCallback.onFailure(voiceRegResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final VoiceLoginCallback voiceLoginCallback, final String str, final String str2) {
        if (voiceLoginCallback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("voiceMd5 can't be empty");
        }
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("uid can't be empty");
        }
        final VoiceLoginResult voiceLoginResult = new VoiceLoginResult();
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            voiceLoginResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            voiceLoginCallback.onFailure(voiceLoginResult);
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(y());
        HashMap hashMap = new HashMap();
        hashMap.put("appid", this.c.appId);
        hashMap.put("tpl", this.c.tpl);
        if (!TextUtils.isEmpty(this.c.clientId)) {
            hashMap.put("clientid", this.c.clientId);
        }
        if (!TextUtils.isEmpty(this.c.clientIp)) {
            hashMap.put("clientip", this.c.clientIp);
        }
        String b2 = e.b(f.N);
        if (!TextUtils.isEmpty(b2)) {
            hashMap.put("di", b2);
        }
        hashMap.put("voicemd5", str);
        hashMap.put("id", SapiDataEncryptor.c(str2, SapiDataEncryptor.a));
        hashMap.put("sig", a(hashMap, this.c.appSignKey));
        this.d.post(this.c.context, this.e.a() + f.N, new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.27
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onStart() {
                voiceLoginCallback.onStart();
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onFinish() {
                voiceLoginCallback.onFinish();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str3) {
                b.this.e.e();
                b.this.a(voiceLoginCallback, str3);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str3) {
                if (!b.this.e.c()) {
                    b.this.e.e();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        voiceLoginResult.setResultCode(-203);
                        voiceLoginCallback.onFailure(voiceLoginResult);
                        return;
                    }
                    voiceLoginResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    voiceLoginCallback.onFailure(voiceLoginResult);
                    return;
                }
                b.this.e.b();
                b.this.a(voiceLoginCallback, str, str2);
            }
        });
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
                    SapiAccount a2 = a(jSONObject);
                    a2.m = SapiAccount.a.a(jSONObject).a().toString();
                    com.baidu.sapi2.share.a.a().a(a2);
                    voiceLoginCallback.onSuccess(voiceLoginResult);
                    break;
                case VoiceLoginResult.RESULT_CODE_PWD_VERIFY_FAILURE /* 71042 */:
                    voiceLoginCallback.onPwdVerifyFailure(voiceLoginResult);
                    break;
                default:
                    voiceLoginCallback.onFailure(voiceLoginResult);
                    break;
            }
        } catch (Exception e) {
            voiceLoginResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
            voiceLoginCallback.onFailure(voiceLoginResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final VoiceCodeSetCallback voiceCodeSetCallback, final VoiceCodeSetDTO voiceCodeSetDTO) {
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
        final VoiceCodeSetResult voiceCodeSetResult = new VoiceCodeSetResult();
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            voiceCodeSetResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            voiceCodeSetCallback.onFailure(voiceCodeSetResult);
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(y());
        HashMap hashMap = new HashMap();
        hashMap.put("appid", this.c.appId);
        hashMap.put("tpl", this.c.tpl);
        if (!TextUtils.isEmpty(this.c.clientId)) {
            hashMap.put("clientid", this.c.clientId);
        }
        if (!TextUtils.isEmpty(this.c.clientIp)) {
            hashMap.put("clientip", this.c.clientIp);
        }
        String b2 = e.b(f.O);
        if (!TextUtils.isEmpty(b2)) {
            hashMap.put("di", b2);
        }
        hashMap.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, String.valueOf(c.a(this.c.context).w()));
        hashMap.put(SapiAccountManager.SESSION_BDUSS, voiceCodeSetDTO.bduss);
        hashMap.put("password", SapiDataEncryptor.c(String.valueOf(voiceCodeSetDTO.voiceCode), SapiDataEncryptor.a));
        hashMap.put("sig", a(hashMap, this.c.appSignKey));
        this.d.post(this.c.context, this.e.a() + f.O, new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.28
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onStart() {
                voiceCodeSetCallback.onStart();
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onFinish() {
                voiceCodeSetCallback.onFinish();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str) {
                b.this.e.e();
                try {
                    int parseInt = Integer.parseInt(new JSONObject(str).optString("errno"));
                    voiceCodeSetResult.setResultCode(parseInt);
                    if (parseInt == 0) {
                        voiceCodeSetCallback.onSuccess(voiceCodeSetResult);
                    } else if (1 == parseInt) {
                        voiceCodeSetCallback.onBdussExpired(voiceCodeSetResult);
                    } else {
                        voiceCodeSetCallback.onFailure(voiceCodeSetResult);
                    }
                } catch (Exception e) {
                    voiceCodeSetResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    voiceCodeSetCallback.onFailure(voiceCodeSetResult);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str) {
                if (!b.this.e.c()) {
                    b.this.e.e();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        voiceCodeSetResult.setResultCode(-203);
                        voiceCodeSetCallback.onFailure(voiceCodeSetResult);
                        return;
                    }
                    voiceCodeSetResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    voiceCodeSetCallback.onFailure(voiceCodeSetResult);
                    return;
                }
                b.this.e.b();
                b.this.a(voiceCodeSetCallback, voiceCodeSetDTO);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final VoiceSwitchSetCallback voiceSwitchSetCallback, final VoiceSwitchSetDTO voiceSwitchSetDTO) {
        if (voiceSwitchSetCallback == null) {
            throw new IllegalArgumentException(VoiceSwitchSetCallback.class.getSimpleName() + " can't be null");
        }
        if (voiceSwitchSetDTO == null) {
            throw new IllegalArgumentException("VoiceSwitchSetDTO can't be empty");
        }
        if (TextUtils.isEmpty(voiceSwitchSetDTO.bduss)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        final VoiceSwitchSetResult voiceSwitchSetResult = new VoiceSwitchSetResult();
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            voiceSwitchSetResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            voiceSwitchSetCallback.onFailure(voiceSwitchSetResult);
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(y());
        HashMap hashMap = new HashMap();
        hashMap.put("appid", this.c.appId);
        hashMap.put("tpl", this.c.tpl);
        if (!TextUtils.isEmpty(this.c.clientId)) {
            hashMap.put("clientid", this.c.clientId);
        }
        if (!TextUtils.isEmpty(this.c.clientIp)) {
            hashMap.put("clientip", this.c.clientIp);
        }
        String b2 = e.b(f.P);
        if (!TextUtils.isEmpty(b2)) {
            hashMap.put("di", b2);
        }
        hashMap.put(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, String.valueOf(c.a(this.c.context).w()));
        hashMap.put(SapiAccountManager.SESSION_BDUSS, voiceSwitchSetDTO.bduss);
        hashMap.put("status", voiceSwitchSetDTO.action == Switch.ON ? "1" : "0");
        hashMap.put("sig", a(hashMap, this.c.appSignKey));
        this.d.post(this.c.context, this.e.a() + f.P, new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.29
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onStart() {
                voiceSwitchSetCallback.onStart();
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onFinish() {
                voiceSwitchSetCallback.onFinish();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str) {
                b.this.e.e();
                try {
                    int parseInt = Integer.parseInt(new JSONObject(str).optString("errno"));
                    voiceSwitchSetResult.setResultCode(parseInt);
                    if (parseInt == 0) {
                        voiceSwitchSetCallback.onSuccess(voiceSwitchSetResult);
                    } else if (1 == parseInt) {
                        voiceSwitchSetCallback.onBdussExpired(voiceSwitchSetResult);
                    } else {
                        voiceSwitchSetCallback.onFailure(voiceSwitchSetResult);
                    }
                } catch (Exception e) {
                    voiceSwitchSetResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    voiceSwitchSetCallback.onFailure(voiceSwitchSetResult);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str) {
                if (!b.this.e.c()) {
                    b.this.e.e();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        voiceSwitchSetResult.setResultCode(-203);
                        voiceSwitchSetCallback.onFailure(voiceSwitchSetResult);
                        return;
                    }
                    voiceSwitchSetResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    voiceSwitchSetCallback.onFailure(voiceSwitchSetResult);
                    return;
                }
                b.this.e.b();
                b.this.a(voiceSwitchSetCallback, voiceSwitchSetDTO);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final VoiceVerifyCallback voiceVerifyCallback, final VoiceVerifyDTO voiceVerifyDTO) {
        if (voiceVerifyCallback == null) {
            throw new IllegalArgumentException(VoiceVerifyCallback.class.getSimpleName() + " can't be null");
        }
        if (voiceVerifyDTO == null) {
            throw new IllegalArgumentException(VoiceVerifyDTO.class.getSimpleName() + " can't be null");
        }
        if (TextUtils.isEmpty(voiceVerifyDTO.voiceMD5)) {
            throw new IllegalArgumentException("voiceMD5 must be assigned");
        }
        final VoiceVerifyResult voiceVerifyResult = new VoiceVerifyResult();
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            voiceVerifyResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            voiceVerifyCallback.onFailure(voiceVerifyResult);
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(y());
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
        String b2 = e.b(f.Q);
        if (!TextUtils.isEmpty(b2)) {
            hashMap.put("di", b2);
        }
        hashMap.put("md5", voiceVerifyDTO.voiceMD5);
        hashMap.put("sig", a(hashMap, this.c.appSignKey));
        this.d.post(this.c.context, this.e.a() + f.Q, new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.30
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onStart() {
                voiceVerifyCallback.onStart();
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onFinish() {
                voiceVerifyCallback.onFinish();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str) {
                b.this.e.e();
                int b3 = b.this.b(str);
                voiceVerifyResult.setResultCode(b3);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (b3 == 0) {
                        voiceVerifyCallback.onSuccess(voiceVerifyResult);
                    } else {
                        voiceVerifyResult.setResultMsg(jSONObject.optString("errmsg"));
                        voiceVerifyCallback.onFailure(voiceVerifyResult);
                    }
                } catch (JSONException e) {
                    voiceVerifyResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    voiceVerifyCallback.onFailure(voiceVerifyResult);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str) {
                if (!b.this.e.c()) {
                    b.this.e.e();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        voiceVerifyResult.setResultCode(-203);
                        voiceVerifyCallback.onFailure(voiceVerifyResult);
                        return;
                    }
                    voiceVerifyResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    voiceVerifyCallback.onFailure(voiceVerifyResult);
                    return;
                }
                b.this.e.b();
                b.this.a(voiceVerifyCallback, voiceVerifyDTO);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final FaceCheckCallback faceCheckCallback, final FaceCheckDTO faceCheckDTO) {
        if (faceCheckCallback == null) {
            throw new IllegalArgumentException(FaceCheckCallback.class.getSimpleName() + " can't be null");
        }
        if (faceCheckDTO == null) {
            throw new IllegalArgumentException(FaceCheckDTO.class.getSimpleName() + " can't be empty");
        }
        if (TextUtils.isEmpty(faceCheckDTO.bduss) && TextUtils.isEmpty(faceCheckDTO.account)) {
            throw new IllegalArgumentException("either bduss or account must be assigned");
        }
        final FaceCheckResult faceCheckResult = new FaceCheckResult();
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            faceCheckResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            faceCheckCallback.onFailure(faceCheckResult);
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(y());
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
        String b2 = e.b(f.T);
        if (!TextUtils.isEmpty(b2)) {
            hashMap.put("di", b2);
        }
        if (!TextUtils.isEmpty(faceCheckDTO.bduss)) {
            hashMap.put(SapiAccountManager.SESSION_BDUSS, faceCheckDTO.bduss);
        } else {
            hashMap.put("username", faceCheckDTO.account);
            if (faceCheckDTO.accountType == null || faceCheckDTO.accountType == FaceCheckDTO.AccountType.MERGE) {
                hashMap.put("merge", "1");
            }
            if (faceCheckDTO.accountType == FaceCheckDTO.AccountType.USERNAME) {
                hashMap.put("isphone", "0");
            }
            if (faceCheckDTO.accountType == FaceCheckDTO.AccountType.PHONE) {
                hashMap.put("isphone", "1");
            }
        }
        hashMap.put("sig", a(hashMap, this.c.appSignKey));
        this.d.post(this.c.context, this.e.a() + f.T, new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.31
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onStart() {
                faceCheckCallback.onStart();
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onFinish() {
                faceCheckCallback.onFinish();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str) {
                b.this.e.e();
                int b3 = b.this.b(str);
                faceCheckResult.setResultCode(b3);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (b3 == 0) {
                        faceCheckResult.faceId = jSONObject.optString("faceid");
                        faceCheckResult.uid = SapiDataEncryptor.b(faceCheckResult.faceId, SapiDataEncryptor.b);
                        faceCheckResult.hasFace = jSONObject.optInt("hasface") == 1;
                        if (!faceCheckResult.hasFace) {
                            faceCheckCallback.onNoRegistered(faceCheckResult);
                        } else {
                            faceCheckResult.isTrusted = jSONObject.optInt("isTrusted") != 0;
                            if (faceCheckResult.isTrusted) {
                                faceCheckResult.authId = jSONObject.optString("authsid");
                                faceCheckCallback.onSuccess(faceCheckResult);
                            } else {
                                faceCheckResult.authToken = jSONObject.optString("authtoken");
                                faceCheckCallback.onNeedVerify(faceCheckResult);
                            }
                        }
                    } else if (3 == b3) {
                        faceCheckCallback.onAccountTypeConflict(faceCheckResult);
                    } else if (1 == b3) {
                        faceCheckCallback.onBdussExpired(faceCheckResult);
                    } else {
                        faceCheckResult.setResultMsg(jSONObject.optString("errmsg"));
                        faceCheckCallback.onFailure(faceCheckResult);
                    }
                } catch (JSONException e) {
                    faceCheckResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    faceCheckCallback.onFailure(faceCheckResult);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str) {
                if (!b.this.e.c()) {
                    b.this.e.e();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        faceCheckResult.setResultCode(-203);
                        faceCheckCallback.onFailure(faceCheckResult);
                        return;
                    }
                    faceCheckResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    faceCheckCallback.onFailure(faceCheckResult);
                    return;
                }
                b.this.e.b();
                b.this.a(faceCheckCallback, faceCheckDTO);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final FaceLoginCallback faceLoginCallback, final FaceLoginDTO faceLoginDTO) {
        if (faceLoginCallback == null) {
            throw new IllegalArgumentException(FaceLoginCallback.class.getSimpleName() + " can't be null");
        }
        if (faceLoginDTO == null) {
            throw new IllegalArgumentException(FaceLoginDTO.class.getSimpleName() + " can't be empty");
        }
        if (TextUtils.isEmpty(faceLoginDTO.faceId)) {
            throw new IllegalArgumentException("face id can't be empty");
        }
        if (TextUtils.isEmpty(faceLoginDTO.authId)) {
            throw new IllegalArgumentException("auth id can't be empty");
        }
        if (TextUtils.isEmpty(faceLoginDTO.facePictureEncoded)) {
            throw new IllegalArgumentException("face picture can't be empty");
        }
        final FaceLoginResult faceLoginResult = new FaceLoginResult();
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            faceLoginResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            faceLoginCallback.onFailure(faceLoginResult);
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(y());
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
        String b2 = e.b(f.S);
        if (!TextUtils.isEmpty(b2)) {
            hashMap.put("di", b2);
        }
        hashMap.put("faceid", faceLoginDTO.faceId);
        hashMap.put("authsid", faceLoginDTO.authId);
        hashMap.put("facepic", faceLoginDTO.facePictureEncoded);
        hashMap.put("sig", a(hashMap, this.c.appSignKey));
        this.d.post(this.c.context, this.e.a() + f.S, new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.32
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onStart() {
                faceLoginCallback.onStart();
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onFinish() {
                faceLoginCallback.onFinish();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str) {
                b.this.e.e();
                int b3 = b.this.b(str);
                faceLoginResult.setResultCode(b3);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (b3 == 0) {
                        SapiAccount a2 = b.this.a(jSONObject);
                        a2.m = SapiAccount.a.a(jSONObject).a().toString();
                        SapiAccountManager.getInstance().validate(a2);
                        faceLoginCallback.onSuccess(faceLoginResult);
                    } else if (4 == b3) {
                        faceLoginCallback.onPwdVerifyFailure(faceLoginResult);
                    } else {
                        faceLoginResult.setResultMsg(jSONObject.optString("errmsg"));
                        faceLoginCallback.onFailure(faceLoginResult);
                    }
                } catch (JSONException e) {
                    faceLoginResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    faceLoginCallback.onFailure(faceLoginResult);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str) {
                if (!b.this.e.c()) {
                    b.this.e.e();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        faceLoginResult.setResultCode(-203);
                        faceLoginCallback.onFailure(faceLoginResult);
                        return;
                    }
                    faceLoginResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    faceLoginCallback.onFailure(faceLoginResult);
                    return;
                }
                b.this.e.b();
                b.this.a(faceLoginCallback, faceLoginDTO);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final FaceRegCallback faceRegCallback, final FaceRegDTO faceRegDTO) {
        if (faceRegCallback == null) {
            throw new IllegalArgumentException(FaceRegCallback.class.getSimpleName() + " can't be null");
        }
        if (faceRegDTO == null) {
            throw new IllegalArgumentException(FaceRegDTO.class.getSimpleName() + " can't be empty");
        }
        if (TextUtils.isEmpty(faceRegDTO.bduss)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        if (TextUtils.isEmpty(faceRegDTO.picturesEncoded)) {
            throw new IllegalArgumentException("face pictures can't be empty");
        }
        final FaceRegResult faceRegResult = new FaceRegResult();
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            faceRegResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            faceRegCallback.onFailure(faceRegResult);
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(y());
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
        String b2 = e.b(f.R);
        if (!TextUtils.isEmpty(b2)) {
            hashMap.put("di", b2);
        }
        if (!TextUtils.isEmpty(faceRegDTO.bduss)) {
            hashMap.put(SapiAccountManager.SESSION_BDUSS, faceRegDTO.bduss);
        }
        hashMap.put("facepics", faceRegDTO.picturesEncoded);
        hashMap.put("sig", a(hashMap, this.c.appSignKey));
        this.d.post(this.c.context, this.e.a() + f.R, new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.33
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onStart() {
                faceRegCallback.onStart();
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onFinish() {
                faceRegCallback.onFinish();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str) {
                b.this.e.e();
                int b3 = b.this.b(str);
                faceRegResult.setResultCode(b3);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (b3 == 0) {
                        faceRegCallback.onSuccess(faceRegResult);
                    } else if (1 == b3) {
                        faceRegCallback.onBdussExpired(faceRegResult);
                    } else {
                        faceRegResult.setResultMsg(jSONObject.optString("errmsg"));
                        faceRegCallback.onFailure(faceRegResult);
                    }
                } catch (JSONException e) {
                    faceRegResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    faceRegCallback.onFailure(faceRegResult);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str) {
                if (!b.this.e.c()) {
                    b.this.e.e();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        faceRegResult.setResultCode(-203);
                        faceRegCallback.onFailure(faceRegResult);
                        return;
                    }
                    faceRegResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    faceRegCallback.onFailure(faceRegResult);
                    return;
                }
                b.this.e.b();
                b.this.a(faceRegCallback, faceRegDTO);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final FaceModifyCallback faceModifyCallback, final FaceModifyDTO faceModifyDTO) {
        if (faceModifyCallback == null) {
            throw new IllegalArgumentException(FaceRegCallback.class.getSimpleName() + " can't be null");
        }
        if (faceModifyDTO == null) {
            throw new IllegalArgumentException(FaceRegDTO.class.getSimpleName() + " can't be empty");
        }
        if (TextUtils.isEmpty(faceModifyDTO.bduss)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        if (TextUtils.isEmpty(faceModifyDTO.picturesEncoded)) {
            throw new IllegalArgumentException("face images can't be empty");
        }
        final FaceModifyResult faceModifyResult = new FaceModifyResult();
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            faceModifyResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            faceModifyCallback.onFailure(faceModifyResult);
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(y());
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
        String b2 = e.b(f.U);
        if (!TextUtils.isEmpty(b2)) {
            hashMap.put("di", b2);
        }
        if (!TextUtils.isEmpty(faceModifyDTO.bduss)) {
            hashMap.put(SapiAccountManager.SESSION_BDUSS, faceModifyDTO.bduss);
        }
        hashMap.put("facepics", faceModifyDTO.picturesEncoded);
        hashMap.put("sig", a(hashMap, this.c.appSignKey));
        this.d.post(this.c.context, this.e.a() + f.U, new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.35
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onStart() {
                faceModifyCallback.onStart();
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onFinish() {
                faceModifyCallback.onFinish();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str) {
                b.this.e.e();
                int b3 = b.this.b(str);
                faceModifyResult.setResultCode(b3);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (b3 == 0) {
                        faceModifyCallback.onSuccess(faceModifyResult);
                    } else if (1 == b3) {
                        faceModifyCallback.onBdussExpired(faceModifyResult);
                    } else {
                        faceModifyResult.setResultMsg(jSONObject.optString("errmsg"));
                        faceModifyCallback.onFailure(faceModifyResult);
                    }
                } catch (JSONException e) {
                    faceModifyResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    faceModifyCallback.onFailure(faceModifyResult);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str) {
                if (!b.this.e.c()) {
                    b.this.e.e();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        faceModifyResult.setResultCode(-203);
                        faceModifyCallback.onFailure(faceModifyResult);
                        return;
                    }
                    faceModifyResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    faceModifyCallback.onFailure(faceModifyResult);
                    return;
                }
                b.this.e.b();
                b.this.a(faceModifyCallback, faceModifyDTO);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final FaceDelCallback faceDelCallback, final FaceDelDTO faceDelDTO) {
        if (faceDelCallback == null) {
            throw new IllegalArgumentException(FaceRegCallback.class.getSimpleName() + " can't be null");
        }
        if (faceDelDTO == null) {
            throw new IllegalArgumentException(FaceRegDTO.class.getSimpleName() + " can't be empty");
        }
        if (TextUtils.isEmpty(faceDelDTO.bduss)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        final FaceDelResult faceDelResult = new FaceDelResult();
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            faceDelResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            faceDelCallback.onFailure(faceDelResult);
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(y());
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
        String b2 = e.b(f.V);
        if (!TextUtils.isEmpty(b2)) {
            hashMap.put("di", b2);
        }
        if (!TextUtils.isEmpty(faceDelDTO.bduss)) {
            hashMap.put(SapiAccountManager.SESSION_BDUSS, faceDelDTO.bduss);
        }
        hashMap.put("sig", a(hashMap, this.c.appSignKey));
        this.d.post(this.c.context, this.e.a() + f.V, new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.36
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onStart() {
                faceDelCallback.onStart();
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onFinish() {
                faceDelCallback.onFinish();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str) {
                b.this.e.e();
                int b3 = b.this.b(str);
                faceDelResult.setResultCode(b3);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (b3 == 0) {
                        faceDelCallback.onSuccess(faceDelResult);
                    } else if (1 == b3) {
                        faceDelCallback.onBdussExpired(faceDelResult);
                    } else {
                        faceDelResult.setResultMsg(jSONObject.optString("errmsg"));
                        faceDelCallback.onFailure(faceDelResult);
                    }
                } catch (JSONException e) {
                    faceDelResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    faceDelCallback.onFailure(faceDelResult);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str) {
                if (!b.this.e.c()) {
                    b.this.e.e();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        faceDelResult.setResultCode(-203);
                        faceDelCallback.onFailure(faceDelResult);
                        return;
                    }
                    faceDelResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    faceDelCallback.onFailure(faceDelResult);
                    return;
                }
                b.this.e.b();
                b.this.a(faceDelCallback, faceDelDTO);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final QrPCLoginCallBack qrPCLoginCallBack, final String str, final String str2, final String str3, final String str4, final String str5) {
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
            this.d.setUserAgent(y());
            HashMap hashMap = new HashMap();
            hashMap.put(SapiUtils.KEY_QR_LOGIN_SIGN, str);
            hashMap.put(IntentConfig.CMD, str2);
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put(SapiAccountManager.SESSION_BDUSS, str3);
            }
            if (!TextUtils.isEmpty(str5)) {
                hashMap.put("ptoken", str5);
            }
            if (!TextUtils.isEmpty(str4)) {
                hashMap.put("stoken", str4);
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
            this.d.post(this.c.context, this.e.a() + f.r, new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.37
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onSuccess(int i, String str6) {
                    super.onSuccess(i, str6);
                    b.this.e.e();
                    b.this.a(qrPCLoginCallBack, str6);
                }

                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onFailure(Throwable th, String str6) {
                    super.onFailure(th, str6);
                    if (!b.this.e.c()) {
                        b.this.e.e();
                        if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                            StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                            qrPCLoginCallBack.onSystemError(-203);
                            return;
                        }
                        b.this.a(qrPCLoginCallBack, str6);
                        return;
                    }
                    b.this.e.b();
                    b.this.a(qrPCLoginCallBack, str, str2, str3, str4, str5);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final QrPcLoginCallback qrPcLoginCallback, final String str, final String str2, final String str3) {
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
        final QrPcLoginResult qrPcLoginResult = new QrPcLoginResult();
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            qrPcLoginResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            qrPcLoginCallback.onFailure(qrPcLoginResult);
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(y());
        HashMap hashMap = new HashMap();
        hashMap.put(SapiUtils.KEY_QR_LOGIN_SIGN, str);
        hashMap.put(IntentConfig.CMD, str2);
        hashMap.put(SapiAccountManager.SESSION_BDUSS, str3);
        if (!TextUtils.isEmpty(this.c.clientId)) {
            hashMap.put("clientid", this.c.clientId);
        }
        if (!TextUtils.isEmpty(this.c.clientIp)) {
            hashMap.put("clientip", this.c.clientIp);
        }
        hashMap.put("tpl", this.c.tpl);
        hashMap.put("appid", this.c.appId);
        hashMap.put("sig", a(hashMap, this.c.appSignKey));
        this.d.post(this.c.context, this.e.a() + f.r, new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.38
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onStart() {
                qrPcLoginCallback.onStart();
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onFinish() {
                qrPcLoginCallback.onFinish();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str4) {
                if (!b.this.e.c()) {
                    b.this.e.e();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        qrPcLoginResult.setResultCode(-203);
                        qrPcLoginCallback.onFailure(qrPcLoginResult);
                        return;
                    }
                    qrPcLoginResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    qrPcLoginCallback.onFailure(qrPcLoginResult);
                    return;
                }
                b.this.e.b();
                b.this.a(qrPcLoginCallback, str, str2, str3);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str4) {
                b.this.e.e();
                try {
                    JSONObject jSONObject = new JSONObject(str4);
                    qrPcLoginResult.setResultCode(Integer.parseInt(jSONObject.optString("errno")));
                    switch (qrPcLoginResult.getResultCode()) {
                        case 0:
                            JSONObject optJSONObject = jSONObject.optJSONObject("local");
                            if (optJSONObject != null) {
                                qrPcLoginResult.country = optJSONObject.optString("country");
                                qrPcLoginResult.province = optJSONObject.optString("provice");
                                qrPcLoginResult.city = optJSONObject.optString("city");
                            }
                            qrPcLoginCallback.onSuccess(qrPcLoginResult);
                            return;
                        case 2:
                        case 160102:
                            qrPcLoginCallback.onBdussExpired(qrPcLoginResult);
                            return;
                        case 3:
                            qrPcLoginCallback.onIncompleteUser(qrPcLoginResult);
                            return;
                        default:
                            qrPcLoginCallback.onFailure(qrPcLoginResult);
                            return;
                    }
                } catch (Throwable th) {
                    qrPcLoginCallback.onFailure(qrPcLoginResult);
                    L.e(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final QrAppLoginCallBack qrAppLoginCallBack, final String str, final String str2) {
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
            this.d.setUserAgent(y());
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
            this.d.post(this.c.context, this.e.a() + f.s, new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.39
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onSuccess(int i, String str3) {
                    super.onSuccess(i, str3);
                    b.this.e.e();
                    b.this.a(i, qrAppLoginCallBack, str3);
                }

                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onFailure(Throwable th, String str3) {
                    super.onFailure(th, str3);
                    if (!b.this.e.c()) {
                        b.this.e.e();
                        if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                            StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                            qrAppLoginCallBack.onSystemError(-203);
                            return;
                        }
                        b.this.a(b.this.c(str3), qrAppLoginCallBack, str3);
                        return;
                    }
                    b.this.e.b();
                    b.this.a(qrAppLoginCallBack, str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(final SapiCallback<QrAppLoginResult> sapiCallback, final String str, final String str2) {
        if (sapiCallback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("sign can't be empty");
        }
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("cmd can't be empty");
        }
        final QrAppLoginResult qrAppLoginResult = new QrAppLoginResult();
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            qrAppLoginResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            sapiCallback.onFailure(qrAppLoginResult);
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(y());
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
        this.d.post(this.c.context, this.e.a() + f.s, new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.40
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onStart() {
                sapiCallback.onStart();
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onFinish() {
                sapiCallback.onFinish();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str3) {
                if (!b.this.e.c()) {
                    b.this.e.e();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        qrAppLoginResult.setResultCode(-203);
                        sapiCallback.onFailure(qrAppLoginResult);
                    }
                    qrAppLoginResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    sapiCallback.onFailure(qrAppLoginResult);
                    return;
                }
                b.this.e.b();
                b.this.b(sapiCallback, str, str2);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str3) {
                b.this.e.e();
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                    qrAppLoginResult.setResultCode(parseInt);
                    switch (parseInt) {
                        case 0:
                            JSONObject optJSONObject = jSONObject.optJSONObject("local");
                            if (optJSONObject != null) {
                                qrAppLoginResult.country = optJSONObject.optString("country");
                                qrAppLoginResult.province = optJSONObject.optString("provice");
                                qrAppLoginResult.city = optJSONObject.optString("city");
                            }
                            SapiAccount a2 = b.this.a(jSONObject);
                            a2.m = SapiAccount.a.a(jSONObject).a().toString();
                            com.baidu.sapi2.share.a.a().a(a2);
                            sapiCallback.onSuccess(qrAppLoginResult);
                            return;
                        default:
                            sapiCallback.onFailure(qrAppLoginResult);
                            return;
                    }
                } catch (Throwable th) {
                    sapiCallback.onFailure(qrAppLoginResult);
                    L.e(th);
                }
            }
        });
    }

    public void a(final SSOConfirmCallback sSOConfirmCallback, final SSOConfirmDTO sSOConfirmDTO) {
        if (sSOConfirmCallback == null) {
            throw new IllegalArgumentException(SSOConfirmCallback.class.getSimpleName() + " can't be null");
        }
        if (sSOConfirmDTO == null) {
            throw new IllegalArgumentException(SSOConfirmDTO.class.getSimpleName() + "can't be null");
        }
        if (TextUtils.isEmpty(sSOConfirmDTO.channelID)) {
            throw new IllegalArgumentException("channel id can't be empty");
        }
        if (TextUtils.isEmpty(sSOConfirmDTO.bduss)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        final SSOConfirmResult sSOConfirmResult = new SSOConfirmResult();
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            sSOConfirmResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            sSOConfirmCallback.onFailure(sSOConfirmResult);
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(y());
        Map<String, String> a2 = a(f.W);
        if (!TextUtils.isEmpty(this.c.clientId)) {
            a2.put("cuid", this.c.clientId);
        }
        if (!TextUtils.isEmpty(this.c.clientIp)) {
            a2.put("clientip", this.c.clientIp);
        }
        a2.put("channel_id", sSOConfirmDTO.channelID);
        a2.put(SapiAccountManager.SESSION_BDUSS, sSOConfirmDTO.bduss);
        a2.put("refuse", sSOConfirmDTO.authorized ? "0" : "1");
        a2.put("sig", a(a2, this.c.appSignKey));
        this.d.post(this.c.context, this.e.a() + f.W, new RequestParams(a2), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.41
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onStart() {
                sSOConfirmCallback.onStart();
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onFinish() {
                sSOConfirmCallback.onFinish();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str) {
                if (!b.this.e.c()) {
                    b.this.e.e();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        sSOConfirmResult.setResultCode(-203);
                        sSOConfirmCallback.onFailure(sSOConfirmResult);
                        return;
                    }
                    sSOConfirmResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    sSOConfirmCallback.onFailure(sSOConfirmResult);
                    return;
                }
                b.this.e.b();
                b.this.a(sSOConfirmCallback, sSOConfirmDTO);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str) {
                b.this.e.e();
                try {
                    int b2 = b.this.b(str);
                    sSOConfirmResult.setResultCode(b2);
                    if (b2 == 0) {
                        sSOConfirmCallback.onSuccess(sSOConfirmResult);
                    } else {
                        sSOConfirmCallback.onFailure(sSOConfirmResult);
                    }
                } catch (Throwable th) {
                    sSOConfirmResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    sSOConfirmCallback.onFailure(sSOConfirmResult);
                    L.e(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(final SapiCallBack<SapiResponse> sapiCallBack, final String str) {
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
            this.d.setUserAgent(y());
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
            this.d.post(this.c.context, this.e.a() + f.v, new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.42
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onSuccess(int i, String str2) {
                    super.onSuccess(i, str2);
                    b.this.e.e();
                    b.this.e(sapiCallBack, str2);
                }

                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onFailure(Throwable th, String str2) {
                    super.onFailure(th, str2);
                    if (!b.this.e.c()) {
                        b.this.e.e();
                        if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                            StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                            sapiCallBack.onSystemError(-203);
                            return;
                        }
                        b.this.e(sapiCallBack, str2);
                        return;
                    }
                    b.this.e.b();
                    b.this.a(sapiCallBack, str);
                }
            });
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(final SapiCallBack<SapiAccountResponse> sapiCallBack, final String str) {
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
            this.d.setUserAgent(y());
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
            this.d.post(this.c.context, this.e.a() + f.t, new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.43
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onSuccess(int i, String str2) {
                    super.onSuccess(i, str2);
                    b.this.e.e();
                    b.this.c(i, sapiCallBack, str2);
                }

                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onFailure(Throwable th, String str2) {
                    super.onFailure(th, str2);
                    if (!b.this.e.c()) {
                        b.this.e.e();
                        if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                            StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                            sapiCallBack.onSystemError(-203);
                            return;
                        }
                        b.this.c(b.this.c(str2), sapiCallBack, str2);
                        return;
                    }
                    b.this.e.b();
                    b.this.b(sapiCallBack, str);
                }
            });
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SapiCallback<FastRegResult> sapiCallback, int i) {
        if (sapiCallback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        }
        FastRegResult fastRegResult = new FastRegResult();
        if (i < 10 || i > 90) {
            throw new IllegalArgumentException("timeoutSeconds must between 10 and 90");
        }
        if (!SapiUtils.isSimReady(this.c.context)) {
            fastRegResult.setResultCode(-101);
            sapiCallback.onFailure(fastRegResult);
        } else if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            fastRegResult.setResultCode(SapiResult.ERROR_CODE_NETWORK_UNAVAILABLE);
            sapiCallback.onFailure(fastRegResult);
        } else {
            final boolean[] zArr = {false};
            String str = UUID.randomUUID().toString() + "-" + System.currentTimeMillis() + ",点击发送直接登录";
            final Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.44
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    switch (message.what) {
                        case 1001:
                            zArr[0] = true;
                            return;
                        default:
                            return;
                    }
                }
            };
            Runnable runnable = new Runnable() { // from class: com.baidu.sapi2.b.46
                @Override // java.lang.Runnable
                public void run() {
                    Message.obtain(handler, 1001).sendToTarget();
                }
            };
            if (SapiUtils.checkRequestPermission("android.permission.SEND_SMS", this.c.context) ? SapiUtils.sendSms(this.c.context, str, SapiUtils.getFastRegChannel(this.c.context)) : false) {
                this.d = new AsyncHttpClient();
                this.d.setUserAgent(y());
                Map<String, String> a2 = a(f.t);
                a2.put("sms", str);
                a2.put("sig", a(a2, this.c.appSignKey));
                RequestParams requestParams = new RequestParams(a2);
                handler.postDelayed(runnable, i * 1000);
                sapiCallback.onStart();
                a(sapiCallback, requestParams, handler, runnable, zArr);
                return;
            }
            fastRegResult.setResultCode(-102);
            sapiCallback.onFailure(fastRegResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final SapiCallback<FastRegResult> sapiCallback, final RequestParams requestParams, final Handler handler, final Runnable runnable, final boolean[] zArr) {
        final FastRegResult fastRegResult = new FastRegResult();
        if (zArr[0]) {
            this.e.e();
            fastRegResult.setResultCode(-103);
            sapiCallback.onFinish();
            sapiCallback.onFailure(fastRegResult);
            return;
        }
        this.d.post(this.c.context, this.e.a() + f.t, requestParams, new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.47
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str) {
                int b2 = b.this.b(str);
                fastRegResult.setResultCode(b2);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    fastRegResult.setResultMsg(jSONObject.optJSONObject("sdk").optString(AddFriendActivityConfig.MSG));
                    switch (b2) {
                        case 0:
                            b.this.e.e();
                            SapiAccount a2 = b.this.a(jSONObject);
                            a2.m = SapiAccount.a.a(jSONObject).a().toString();
                            com.baidu.sapi2.share.a.a().a(a2);
                            fastRegResult.newReg = jSONObject.optBoolean("newreg");
                            fastRegResult.authSid = jSONObject.optString("authsid");
                            if ("null".equals(fastRegResult.authSid)) {
                                fastRegResult.authSid = null;
                            }
                            handler.removeCallbacks(runnable);
                            sapiCallback.onFinish();
                            sapiCallback.onSuccess(fastRegResult);
                            return;
                        case 7:
                            handler.postDelayed(new Runnable() { // from class: com.baidu.sapi2.b.47.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    b.this.a(sapiCallback, requestParams, handler, runnable, zArr);
                                }
                            }, 400L);
                            return;
                        default:
                            b.this.e.e();
                            handler.removeCallbacks(runnable);
                            sapiCallback.onFinish();
                            sapiCallback.onFailure(fastRegResult);
                            return;
                    }
                } catch (Exception e) {
                    b.this.e.e();
                    handler.removeCallbacks(runnable);
                    sapiCallback.onFinish();
                    sapiCallback.onFailure(fastRegResult);
                    L.e(e);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str) {
                if (!b.this.e.c()) {
                    b.this.e.e();
                    handler.removeCallbacks(runnable);
                    sapiCallback.onFinish();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        fastRegResult.setResultCode(-203);
                        sapiCallback.onFailure(fastRegResult);
                        return;
                    }
                    fastRegResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    sapiCallback.onFailure(fastRegResult);
                    return;
                }
                b.this.e.b();
                b.this.a(sapiCallback, requestParams, handler, runnable, zArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (this.c != null && this.c.context != null && SapiUtils.hasActiveNetwork(this.c.context)) {
            this.d = new AsyncHttpClient();
            this.d.setUserAgent(y());
            HashMap hashMap = new HashMap();
            if (c.a(this.c.context).a() != null) {
                hashMap.put("device_id", SapiDeviceUtils.createDeviceID(this.c.context));
                hashMap.put("device_token", c.a(this.c.context).a());
            }
            this.d.get(this.c.context, z().getDeviceUrl() + f.D, new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.48
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onSuccess(int i, String str) {
                    if (str != null) {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            if (jSONObject.has("error_code") || jSONObject.has("error_msg") || jSONObject.optInt("fulfilbind") != 0) {
                                return;
                            }
                            if (jSONObject.optInt(TbConfig.ST_TYPE_REG) == 1 || jSONObject.optInt("login") == 1) {
                                c.a(b.this.c.context).a(true);
                            }
                        } catch (JSONException e) {
                            L.e(e);
                            c.a(b.this.c.context).a(false);
                        }
                    }
                }

                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onFailure(Throwable th, String str) {
                    super.onFailure(th, str);
                    c.a(b.this.c.context).a(false);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(final SapiCallBack<SapiResponse> sapiCallBack) {
        if (this.c == null || this.c.context == null || TextUtils.isEmpty(this.c.deviceLoginSignKey) || !c.a(this.c.context).b()) {
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
        this.d.setUserAgent(y());
        HashMap hashMap = new HashMap();
        String encryptDeviceId = SapiDeviceUtils.DeviceCrypto.encryptDeviceId(SapiDeviceUtils.createDeviceID(this.c.context));
        hashMap.put("ptpl", this.c.tpl);
        hashMap.put("device_id", encryptDeviceId);
        hashMap.put("device_info", SapiDeviceUtils.createDeviceInfo());
        hashMap.put("package_sign", this.c.deviceLoginSignKey);
        this.d.post(this.c.context, z().getDeviceUrl() + f.E, new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.49
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str) {
                super.onSuccess(i, str);
                b.this.a(i, sapiCallBack, str);
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str) {
                super.onFailure(th, str);
                b.this.a(b.this.c(str), sapiCallBack, str);
            }
        });
        return true;
    }

    void c(final SapiCallBack<SapiResponse> sapiCallBack, String str) {
        if (this.c != null && this.c.context != null && !TextUtils.isEmpty(this.c.deviceLoginSignKey)) {
            if (!SapiUtils.hasActiveNetwork(this.c.context)) {
                if (sapiCallBack != null) {
                    sapiCallBack.onNetworkFailed();
                    return;
                }
                return;
            }
            this.d = new AsyncHttpClient();
            this.d.setUserAgent(y());
            HashMap hashMap = new HashMap();
            String encryptDeviceId = SapiDeviceUtils.DeviceCrypto.encryptDeviceId(SapiDeviceUtils.createDeviceID(this.c.context));
            hashMap.put("ptpl", this.c.tpl);
            hashMap.put("device_id", encryptDeviceId);
            hashMap.put("device_info", SapiDeviceUtils.createDeviceInfo());
            hashMap.put("force_reg_token", str);
            this.d.post(this.c.context, z().getDeviceUrl() + f.G, new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.50
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onSuccess(int i, String str2) {
                    b.this.b(i, sapiCallBack, str2);
                    super.onSuccess(i, str2);
                }

                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onFailure(Throwable th, String str2) {
                    b.this.b(b.this.c(str2), sapiCallBack, str2);
                    super.onFailure(th, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(final SapiCallBack<SapiResponse> sapiCallBack, String str) {
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
        this.d.setUserAgent(y());
        HashMap hashMap = new HashMap();
        String encryptDeviceId = SapiDeviceUtils.DeviceCrypto.encryptDeviceId(SapiDeviceUtils.createDeviceID(this.c.context));
        hashMap.put("ptpl", this.c.tpl);
        hashMap.put("device_id", encryptDeviceId);
        hashMap.put("device_token", str);
        hashMap.put("package_sign", this.c.deviceLoginSignKey);
        this.d.post(this.c.context, z().getDeviceUrl() + f.F, new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.51
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str2) {
                b.this.a(i, sapiCallBack, str2);
                super.onSuccess(i, str2);
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str2) {
                b.this.a(b.this.c(str2), sapiCallBack, str2);
                super.onFailure(th, str2);
            }
        });
        return true;
    }

    void a(int i, SapiCallBack<SapiResponse> sapiCallBack, String str) {
        if (str != null) {
            SapiAccountResponse sapiAccountResponse = new SapiAccountResponse();
            try {
                JSONObject jSONObject = new JSONObject(str);
                sapiAccountResponse.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                sapiAccountResponse.uid = jSONObject.optString(SapiAccountManager.SESSION_UID);
                sapiAccountResponse.bduss = jSONObject.optString(SapiAccountManager.SESSION_BDUSS);
                sapiAccountResponse.ptoken = jSONObject.optString("ptoken");
                if (jSONObject.optInt("error_code") == 104) {
                    c(sapiCallBack, jSONObject.optString("force_reg_token"));
                    return;
                }
                if (!jSONObject.has("error_code") && !jSONObject.has("error_msg")) {
                    SapiAccount sapiAccount = new SapiAccount();
                    sapiAccount.uid = sapiAccountResponse.uid;
                    sapiAccount.bduss = sapiAccountResponse.bduss;
                    sapiAccount.displayname = sapiAccountResponse.displayname;
                    sapiAccount.l = sapiAccountResponse.stoken;
                    sapiAccount.k = sapiAccountResponse.ptoken;
                    sapiAccount.app = SapiUtils.getAppName(this.c.context);
                    if (jSONObject.has("device_token")) {
                        c.a(this.c.context).a(jSONObject.getString("device_token"));
                    }
                    com.baidu.sapi2.share.a.a().a(sapiAccount);
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
            } catch (Exception e) {
                if (sapiCallBack != null) {
                    sapiCallBack.onSystemError(-100);
                }
            }
        } else if (sapiCallBack != null) {
            sapiCallBack.onSystemError(i);
        }
    }

    void b(int i, SapiCallBack<SapiResponse> sapiCallBack, String str) {
        if (str != null) {
            SapiAccountResponse sapiAccountResponse = new SapiAccountResponse();
            try {
                JSONObject jSONObject = new JSONObject(str);
                sapiAccountResponse.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                sapiAccountResponse.uid = jSONObject.optString(SapiAccountManager.SESSION_UID);
                sapiAccountResponse.bduss = jSONObject.optString(SapiAccountManager.SESSION_BDUSS);
                sapiAccountResponse.ptoken = jSONObject.optString("ptoken");
                if (!jSONObject.has("error_code") && !jSONObject.has("error_msg")) {
                    SapiAccount sapiAccount = new SapiAccount();
                    sapiAccount.uid = sapiAccountResponse.uid;
                    sapiAccount.bduss = sapiAccountResponse.bduss;
                    sapiAccount.displayname = sapiAccountResponse.displayname;
                    sapiAccount.l = sapiAccountResponse.stoken;
                    sapiAccount.k = sapiAccountResponse.ptoken;
                    sapiAccount.app = SapiUtils.getAppName(this.c.context);
                    if (jSONObject.has("device_token")) {
                        c.a(this.c.context).a(jSONObject.getString("device_token"));
                    }
                    com.baidu.sapi2.share.a.a().a(sapiAccount);
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
            } catch (Exception e) {
                if (sapiCallBack != null) {
                    sapiCallBack.onSystemError(-100);
                }
            }
        } else if (sapiCallBack != null) {
            sapiCallBack.onSystemError(i);
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
        String b2 = e.b(str);
        if (!TextUtils.isEmpty(b2)) {
            hashMap.put("di", b2);
        }
        hashMap.put("clientfrom", "mobilesdk_enhanced");
        hashMap.put("sdk_version", "3");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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
            } catch (UnsupportedEncodingException e) {
                L.e(e);
            }
            sb.append("&");
        }
        sb.append("sign_key=").append(str);
        return MD5Util.toMd5(sb.toString().getBytes(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String y() {
        return "tpl:" + this.c.tpl + ";android_sapi_v" + SapiAccountManager.VERSION_NAME;
    }

    int b(String str) {
        try {
            return new JSONObject(str).getInt("errno");
        } catch (Exception e) {
            L.e(e);
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
    public void a(int i, FillUsernameCallBack fillUsernameCallBack, String str, SapiDataEncryptor sapiDataEncryptor) {
        if (str != null) {
            SapiAccountResponse sapiAccountResponse = new SapiAccountResponse();
            try {
                String optString = new JSONObject(str).optString("userinfo");
                if (!TextUtils.isEmpty(optString)) {
                    JSONObject jSONObject = new JSONObject(sapiDataEncryptor.a(optString));
                    sapiAccountResponse.bduss = jSONObject.optString(SapiAccountManager.SESSION_BDUSS);
                    sapiAccountResponse.ptoken = jSONObject.optString("ptoken");
                    sapiAccountResponse.stoken = jSONObject.optString("stoken");
                    sapiAccountResponse.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                    sapiAccountResponse.uid = jSONObject.optString(SapiAccountManager.SESSION_UID);
                    sapiAccountResponse.username = jSONObject.optString("uname");
                    sapiAccountResponse.email = jSONObject.optString("email");
                    switch (i) {
                        case 0:
                            SapiAccount a2 = a(sapiAccountResponse);
                            a2.m = SapiAccount.a.a(jSONObject).a().toString();
                            com.baidu.sapi2.share.a.a().a(a2);
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
                            fillUsernameCallBack.onSystemError(i);
                            break;
                    }
                }
                return;
            } catch (Throwable th) {
                fillUsernameCallBack.onSystemError(i);
                return;
            }
        }
        fillUsernameCallBack.onSystemError(i);
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
        } catch (Exception e) {
            qrPCLoginCallBack.onSystemError(-100);
        }
    }

    void a(int i, QrAppLoginCallBack qrAppLoginCallBack, String str) {
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
                    SapiAccount a2 = a(jSONObject);
                    a2.m = SapiAccount.a.a(jSONObject).a().toString();
                    com.baidu.sapi2.share.a.a().a(a2);
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
            } catch (Exception e) {
                if (qrAppLoginCallBack != null) {
                    qrAppLoginCallBack.onSystemError(-100);
                }
            }
        } else if (qrAppLoginCallBack != null) {
            qrAppLoginCallBack.onSystemError(i);
        }
    }

    void c(int i, SapiCallBack<SapiAccountResponse> sapiCallBack, String str) {
        if (str != null) {
            SapiAccountResponse sapiAccountResponse = new SapiAccountResponse();
            try {
                JSONObject jSONObject = new JSONObject(str);
                sapiAccountResponse.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                sapiAccountResponse.username = jSONObject.optString("uname");
                sapiAccountResponse.uid = jSONObject.optString(SapiAccountManager.SESSION_UID);
                sapiAccountResponse.bduss = jSONObject.optString(SapiAccountManager.SESSION_BDUSS);
                sapiAccountResponse.ptoken = jSONObject.optString("ptoken");
                sapiAccountResponse.stoken = jSONObject.optString("stoken");
                sapiAccountResponse.newReg = jSONObject.optBoolean("newreg");
                sapiAccountResponse.tplStokenMap = SapiAccount.a.b(jSONObject.optJSONObject("stoken_list"));
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
                            sapiCallBack.onSystemError(i);
                            return;
                    }
                }
            } catch (Exception e) {
                if (sapiCallBack != null) {
                    sapiCallBack.onSystemError(-100);
                }
            }
        } else if (sapiCallBack != null) {
            sapiCallBack.onSystemError(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final IqiyiLoginCallback iqiyiLoginCallback, final IqiyiLoginDTO iqiyiLoginDTO) {
        if (iqiyiLoginCallback != null) {
            iqiyiLoginCallback.onStart();
            String str = iqiyiLoginDTO.accessToken;
            final String str2 = iqiyiLoginDTO.phoneNum;
            String str3 = iqiyiLoginDTO.openID;
            final IqiyiLoginResult iqiyiLoginResult = new IqiyiLoginResult();
            SapiAccount session = SapiAccountManager.getInstance().getSession();
            boolean z = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) ? false : true;
            if (!z && session == null) {
                iqiyiLoginCallback.onLogin(iqiyiLoginResult);
            } else if (z && session == null) {
                a(iqiyiLoginCallback, iqiyiLoginDTO, iqiyiLoginResult);
            } else {
                SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() { // from class: com.baidu.sapi2.b.52
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.LoginStatusAware
                    /* renamed from: a */
                    public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                        b.this.a(iqiyiLoginCallback, iqiyiLoginDTO, iqiyiLoginResult);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: b */
                    public void onSuccess(GetUserInfoResult getUserInfoResult) {
                        String str4 = getUserInfoResult.secureMobile;
                        boolean z2 = getUserInfoResult.incompleteUser;
                        if (TextUtils.isEmpty(str4)) {
                            if (z2) {
                                b.this.a(iqiyiLoginCallback, iqiyiLoginDTO, iqiyiLoginResult);
                                return;
                            } else if (!TextUtils.isEmpty(str2)) {
                                b.this.a(iqiyiLoginCallback, iqiyiLoginDTO, iqiyiLoginResult);
                                return;
                            } else {
                                iqiyiLoginCallback.onSuccess(iqiyiLoginResult);
                                return;
                            }
                        }
                        iqiyiLoginCallback.onSuccess(iqiyiLoginResult);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: c */
                    public void onFailure(GetUserInfoResult getUserInfoResult) {
                        iqiyiLoginResult.setResultCode(getUserInfoResult.getResultCode());
                        iqiyiLoginResult.setResultMsg(getUserInfoResult.getResultMsg());
                        iqiyiLoginCallback.onFailure(iqiyiLoginResult);
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                    }
                }, session.bduss);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final IqiyiLoginCallback iqiyiLoginCallback, final IqiyiLoginDTO iqiyiLoginDTO, final IqiyiLoginResult iqiyiLoginResult) {
        if (TextUtils.isEmpty(iqiyiLoginDTO.accessToken) || TextUtils.isEmpty(iqiyiLoginDTO.openID)) {
            iqiyiLoginCallback.onLogin(iqiyiLoginResult);
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(y());
        Map<String, String> a2 = a(t());
        if (!TextUtils.isEmpty(iqiyiLoginDTO.phoneNum)) {
            a2.put("crypt_m", iqiyiLoginDTO.phoneNum);
        }
        a2.put("access_token", iqiyiLoginDTO.accessToken);
        a2.put("osuid", iqiyiLoginDTO.openID);
        a2.put("json", "1");
        a2.put("type", SocialType.IQIYI.getType() + "");
        a2.put("act", "special");
        a2.put("display", "native");
        a2.put("client", "android");
        a2.put("sig", a(a2, this.c.appSignKey));
        this.d.get(this.c.context, t(), new RequestParams(a2), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.b.53
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onStart() {
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onFinish() {
                iqiyiLoginCallback.onFinish();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str) {
                super.onSuccess(i, str);
                b.this.e.e();
                if (b.this.b(str) == 302) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        iqiyiLoginResult.nextUrl = jSONObject.optString("next_url");
                        iqiyiLoginCallback.onBindWebview(iqiyiLoginResult);
                        return;
                    } catch (JSONException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                SocialResponse b2 = SapiWebView.b(str);
                if (b2 == null) {
                    iqiyiLoginResult.setResultCode(-100);
                    iqiyiLoginResult.setResultMsg("登录失败");
                    iqiyiLoginCallback.onFailure(iqiyiLoginResult);
                } else if (b2.errorCode != -100) {
                    iqiyiLoginResult.setResultCode(-100);
                    iqiyiLoginResult.setResultMsg("登录失败");
                    iqiyiLoginCallback.onFailure(iqiyiLoginResult);
                } else {
                    SapiAccount a3 = b.this.a(b2);
                    a3.a(b2.socialType, b2.socialPortraitUrl);
                    a3.a(GiftTabActivityConfig.ACCOUNT_TYPE, Integer.valueOf(b2.accountType.getType()));
                    a3.a("stoken_list", new JSONObject(b2.tplStokenMap));
                    com.baidu.sapi2.share.a.a().a(a3);
                    iqiyiLoginCallback.onSuccess(iqiyiLoginResult);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str) {
                super.onFailure(th, str);
                if (!b.this.e.c()) {
                    b.this.e.e();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.a("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        iqiyiLoginResult.setResultCode(-203);
                        iqiyiLoginCallback.onFailure(iqiyiLoginResult);
                        return;
                    }
                    iqiyiLoginResult.setResultCode(SapiResult.ERROR_CODE_UNKNOWN);
                    iqiyiLoginCallback.onFailure(iqiyiLoginResult);
                    return;
                }
                b.this.e.b();
                iqiyiLoginCallback.onStart();
                b.this.a(iqiyiLoginCallback, iqiyiLoginDTO, iqiyiLoginResult);
            }
        });
    }

    SapiAccount a(JSONObject jSONObject) {
        SapiAccount sapiAccount = new SapiAccount();
        sapiAccount.uid = jSONObject.optString(SapiAccountManager.SESSION_UID);
        sapiAccount.bduss = jSONObject.optString(SapiAccountManager.SESSION_BDUSS);
        sapiAccount.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
        sapiAccount.username = jSONObject.optString("uname");
        sapiAccount.l = jSONObject.optString("stoken");
        sapiAccount.k = jSONObject.optString("ptoken");
        sapiAccount.m = jSONObject.toString();
        sapiAccount.app = SapiUtils.getAppName(this.c.context);
        return sapiAccount;
    }

    SapiAccount a(SapiAccountResponse sapiAccountResponse) {
        SapiAccount sapiAccount = new SapiAccount();
        sapiAccount.displayname = sapiAccountResponse.displayname;
        sapiAccount.bduss = sapiAccountResponse.bduss;
        sapiAccount.k = sapiAccountResponse.ptoken;
        sapiAccount.l = sapiAccountResponse.stoken;
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
        } catch (Exception e) {
            sapiCallBack.onSystemError(-100);
        }
    }

    private Domain z() {
        return this.c.environment;
    }

    private String A() {
        return this.e.a() + "/sslcrypt/get_last_cert";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d() {
        return z().getWap() + "/passport/login";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String e() {
        return z().getWap() + "/passport/getpass";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String f() {
        return z().getWap() + "/wp/wappassword";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String g() {
        return z().getWap() + "/wp/recordindex";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String h() {
        return z().getWap() + "/v2/?bindingaccount&";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String i() {
        return z().getWap() + "/v2/?bindingret";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(BindWidgetAction bindWidgetAction) {
        return z().getWap() + bindWidgetAction.getUri();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String j() {
        return z().getWap() + "/passport/authwidget";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String k() {
        return z().getWap() + "/wp/unitewidget";
    }

    String l() {
        return this.e.a() + "/v2/sapi/center/filluname";
    }

    String m() {
        return this.e.a() + "/v2/sapi/center/setportrait";
    }

    String n() {
        return z().getPortraitUrl() + "/sys/history";
    }

    String o() {
        return this.e.a() + f.k;
    }

    String p() {
        return z().getPortraitUrl() + "/sys/portrait/hotitemlist";
    }

    String q() {
        return z().getPortraitUrl() + "/sys/sethotitem";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String r() {
        return z().getWap() + "/wp/v3/ucenter/index";
    }

    String s() {
        return this.e.a() + f.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String t() {
        return this.e.a() + "/phoenix/account/ssologin";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String u() {
        return this.e.a() + "/phoenix/account/ssologin";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String v() {
        return this.e.a() + f.o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String w() {
        return this.e.a() + f.p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String x() {
        return this.e.a() + f.q;
    }
}
