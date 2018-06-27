package com.baidu.sapi2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.android.common.security.MD5Util;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.HttpResponseHandler;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.fsg.base.armor.RimArmor;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.biometrics.liveness.activity.LivenessRecogActivity;
import com.baidu.sapi2.callback.FillUserProfileCallback;
import com.baidu.sapi2.callback.FillUsernameCallback;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.callback.IqiyiLoginCallback;
import com.baidu.sapi2.callback.SSOConfirmCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.dto.IqiyiLoginDTO;
import com.baidu.sapi2.dto.SSOConfirmDTO;
import com.baidu.sapi2.passhost.framework.PluginFacade;
import com.baidu.sapi2.passhost.hostsdk.service.ThreadPoolService;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.sapi2.passhost.pluginsdk.service.TPRunnable;
import com.baidu.sapi2.result.FastRegResult;
import com.baidu.sapi2.result.FillUserProfileResult;
import com.baidu.sapi2.result.FillUsernameResult;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.result.IqiyiLoginResult;
import com.baidu.sapi2.result.OAuthResult;
import com.baidu.sapi2.result.SSOConfirmResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.Web2NativeLoginResult;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.sapi2.shell.callback.GetUserInfoCallBack;
import com.baidu.sapi2.shell.callback.SapiCallBack;
import com.baidu.sapi2.shell.response.GetUserInfoResponse;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SapiResponse;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.utils.SapiDataEncryptor;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiDeviceUtils;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiHost;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import java.io.UnsupportedEncodingException;
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
import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a {
    private static final int a = 6;
    private static final String b = "3";
    private SapiConfiguration c = SapiAccountManager.getInstance().getSapiConfiguration();
    private AsyncHttpClient d;
    private C0081a e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.sapi2.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0081a {
        static List<String> b = new ArrayList();
        static int c;
        Context a;

        private void f() {
            b.clear();
            b.add(SapiEnv.PASS_RETRY_IP1);
            b.add(SapiEnv.PASS_RETRY_IP2);
            b.add(SapiEnv.PASS_RETRY_IP3);
        }

        public C0081a(Context context) {
            this.a = context;
            e();
            f();
        }

        public String a() {
            String url = SapiAccountManager.getInstance().getSapiConfiguration().environment.getURL(SapiUtils.getDefaultHttpsEnabled());
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
            return !d() && (SapiContext.getInstance(this.a).isHostsHijacked() || !SapiUtils.getDefaultHttpsEnabled());
        }

        public boolean d() {
            return c >= b.size();
        }

        public void e() {
            c = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        this.e = new C0081a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.d != null) {
            this.d.cancelRequests(this.c.context, true);
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
            a(new GetUserInfoCallback() { // from class: com.baidu.sapi2.a.1
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
                        sapiAccount.ptoken = cookiePtoken;
                    }
                    com.baidu.sapi2.share.a.a().a(sapiAccount);
                    web2NativeLoginResult.setResultCode(0);
                    web2NativeLoginCallback.onSuccess(web2NativeLoginResult);
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_WEB_2_NATIVE_LOGIN, IEventCenterService.EventResult.PHASE.SUCCESS);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                /* renamed from: c */
                public void onFailure(GetUserInfoResult getUserInfoResult) {
                    web2NativeLoginResult.setResultCode(-202);
                    web2NativeLoginCallback.onFailure(web2NativeLoginResult);
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_WEB_2_NATIVE_LOGIN, IEventCenterService.EventResult.PHASE.FAILURE);
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onStart() {
                    web2NativeLoginCallback.onStart();
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_WEB_2_NATIVE_LOGIN, IEventCenterService.EventResult.PHASE.START);
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFinish() {
                    web2NativeLoginCallback.onFinish();
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_WEB_2_NATIVE_LOGIN, IEventCenterService.EventResult.PHASE.FINISH);
                }
            }, cookieBduss);
        } else {
            SapiAccount session = SapiAccountManager.getInstance().getSession();
            if (!cookieBduss.equals(session.bduss)) {
                SapiAccountManager.getInstance().getAccountService().webLogin(this.c.context, session.bduss);
            }
            web2NativeLoginResult.setResultCode(0);
            web2NativeLoginCallback.onSuccess(web2NativeLoginResult);
            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_WEB_2_NATIVE_LOGIN, IEventCenterService.EventResult.PHASE.SUCCESS);
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
        this.d.setUserAgent(w());
        this.d.get(this.c.context, y(), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.a.12
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str3) {
                super.onFailure(th, str3);
                JSONObject jSONObject = new JSONObject();
                String str4 = "";
                try {
                    jSONObject.put("failure_info", str3);
                    str4 = jSONObject.toString();
                } catch (JSONException e) {
                    a.this.a(-100, sapiCallBack, "", z, sapiDataEncryptor);
                    Log.e(e);
                }
                if (!a.this.e.c()) {
                    a.this.e.e();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.onEvent("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        sapiCallBack.onSystemError(-203);
                        return;
                    }
                    a.this.a(-100, sapiCallBack, str4, z, sapiDataEncryptor);
                    return;
                }
                a.this.e.b();
                a.this.a(sapiCallBack, str, str2, z);
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str3) {
                super.onSuccess(i, str3);
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    a.this.a(sapiCallBack, jSONObject.optString("cert"), jSONObject.optString("cert_id"), str, str2, z, sapiDataEncryptor);
                } catch (Exception e) {
                    a.this.a(-100, sapiCallBack, str3, z, sapiDataEncryptor);
                    Log.e(e);
                }
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final SapiCallBack<SapiAccountResponse> sapiCallBack, String str, String str2, final String str3, final String str4, final boolean z, final SapiDataEncryptor sapiDataEncryptor) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, CertificateException, JSONException {
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(w());
        HashMap hashMap = new HashMap();
        hashMap.put("crypttype", Constants.VIA_SHARE_TYPE_INFO);
        hashMap.put("tpl", this.c.tpl);
        hashMap.put("appid", this.c.appId);
        String str5 = this.c.clientId;
        if (!TextUtils.isEmpty(str5)) {
            hashMap.put("cuid", str5);
        }
        String deviceInfo = SapiDeviceInfo.getDeviceInfo(SapiEnv.LOGIN_URI);
        if (!TextUtils.isEmpty(deviceInfo)) {
            hashMap.put(AppIconSetting.DEFAULT_LARGE_ICON, deviceInfo);
        }
        hashMap.put("cert_id", str2);
        hashMap.put("isdpass", "1");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("username", str3);
        jSONObject.put("isphone", "1");
        jSONObject.put("password", str4);
        jSONObject.put("login_type", "3");
        jSONObject.put(RimArmor.KEY, sapiDataEncryptor.getAESKey());
        jSONObject.put(SapiContext.KEY_SDK_VERSION, "2");
        jSONObject.put("pinfo", SapiDeviceUtils.getBrandName());
        hashMap.put("userinfo", sapiDataEncryptor.encrypt(str, jSONObject.toString()));
        hashMap.put("sig", SapiUtils.calculateSig(hashMap, this.c.appSignKey));
        this.d.post(this.c.context, q(), new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.a.14
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str6) {
                super.onSuccess(i, str6);
                a.this.a(a.this.b(str6), sapiCallBack, str6, z, sapiDataEncryptor);
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str6) {
                super.onFailure(th, str6);
                if (!a.this.e.c()) {
                    a.this.e.e();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.onEvent("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        sapiCallBack.onSystemError(-203);
                        return;
                    }
                    a.this.a(a.this.b(str6), sapiCallBack, str6, z, sapiDataEncryptor);
                    return;
                }
                a.this.e.b();
                a.this.a(sapiCallBack, str3, str4, z);
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
                    jSONObject = new JSONObject(sapiDataEncryptor.decrypt(optString));
                    sapiAccountResponse.displayname = jSONObject.optString("displayname");
                    sapiAccountResponse.username = jSONObject.optString("uname");
                    sapiAccountResponse.uid = jSONObject.optString("uid");
                    sapiAccountResponse.email = jSONObject.optString("email");
                    sapiAccountResponse.bduss = jSONObject.optString("bduss");
                    sapiAccountResponse.ptoken = jSONObject.optString(ISapiAccount.SAPI_ACCOUNT_PTOKEN);
                    sapiAccountResponse.stoken = jSONObject.optString(ISapiAccount.SAPI_ACCOUNT_STOKEN);
                    sapiAccountResponse.authSid = jSONObject.optString("authsid");
                }
                if (sapiCallBack != null) {
                    switch (i) {
                        case 0:
                            if (z) {
                                SapiAccount a2 = a(sapiAccountResponse);
                                a2.addDispersionCertification(SapiAccount.DispersionCertification.fromJSONObject(jSONObject).tplStokenMap);
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
                Log.e(e);
                if (sapiCallBack != null) {
                    sapiCallBack.onSystemError(-100);
                }
            }
        } else if (sapiCallBack != null) {
            sapiCallBack.onSystemError(i);
        }
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
            getUserInfoResult.setResultCode(-201);
            getUserInfoCallback.onFailure(getUserInfoResult);
            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_USERINFO, IEventCenterService.EventResult.PHASE.FAILURE);
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(w());
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
        hashMap.put("sdkversion", SapiAccountManager.VERSION_NAME);
        SapiAccount accountFromBduss = SapiContext.getInstance(this.c.context).getAccountFromBduss(str);
        if (accountFromBduss != null && !TextUtils.isEmpty(accountFromBduss.ptoken)) {
            hashMap.put(ISapiAccount.SAPI_ACCOUNT_PTOKEN, accountFromBduss.ptoken);
        }
        hashMap.put("client", HttpConstants.OS_TYPE_VALUE);
        String deviceInfo = SapiDeviceInfo.getDeviceInfo("/v2/sapi/center/getuinfo");
        if (!TextUtils.isEmpty(deviceInfo)) {
            hashMap.put(AppIconSetting.DEFAULT_LARGE_ICON, deviceInfo);
        }
        String pisDeviceInfo = SapiDeviceInfo.getPisDeviceInfo();
        if (!TextUtils.isEmpty(pisDeviceInfo)) {
            hashMap.put("pis_di", pisDeviceInfo);
        }
        String calculateSig = SapiUtils.calculateSig(hashMap, this.c.appSignKey);
        RequestParams requestParams = new RequestParams();
        for (Map.Entry entry : hashMap.entrySet()) {
            requestParams.put((String) entry.getKey(), (String) entry.getValue());
        }
        requestParams.put("sig", calculateSig);
        this.d.post(this.c.context, k(), requestParams, new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.a.15
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onStart() {
                getUserInfoCallback.onStart();
                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_USERINFO, IEventCenterService.EventResult.PHASE.START);
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onFinish() {
                getUserInfoCallback.onFinish();
                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_USERINFO, IEventCenterService.EventResult.PHASE.FINISH);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str2) {
                a.this.e.e();
                int b2 = a.this.b(str2);
                getUserInfoResult.setResultCode(b2);
                switch (b2) {
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
                            getUserInfoResult.displayname = jSONObject.optString("displayname");
                            getUserInfoResult.incompleteUser = "1".equals(jSONObject.optString("incomplete_user"));
                            getUserInfoResult.secureMobile = jSONObject.optString("securemobil");
                            getUserInfoResult.secureEmail = jSONObject.optString("secureemail");
                            getUserInfoResult.havePwd = "1".equals(jSONObject.optString("have_psw"));
                            getUserInfoCallback.onSuccess(getUserInfoResult);
                            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_USERINFO, IEventCenterService.EventResult.PHASE.SUCCESS);
                            return;
                        } catch (Exception e) {
                            getUserInfoCallback.onFailure(getUserInfoResult);
                            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_USERINFO, IEventCenterService.EventResult.PHASE.FAILURE);
                            Log.e(e);
                            return;
                        }
                    case 400021:
                        getUserInfoCallback.onBdussExpired(getUserInfoResult);
                        return;
                    default:
                        getUserInfoCallback.onFailure(getUserInfoResult);
                        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_USERINFO, IEventCenterService.EventResult.PHASE.FAILURE);
                        return;
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str2) {
                if (!a.this.e.c()) {
                    a.this.e.e();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.onEvent("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        getUserInfoResult.setResultCode(-203);
                        getUserInfoCallback.onFailure(getUserInfoResult);
                        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_USERINFO, IEventCenterService.EventResult.PHASE.FAILURE);
                        return;
                    }
                    getUserInfoResult.setResultCode(-202);
                    getUserInfoCallback.onFailure(getUserInfoResult);
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_USERINFO, IEventCenterService.EventResult.PHASE.FAILURE);
                    return;
                }
                a.this.e.b();
                a.this.a(getUserInfoCallback, str);
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
        this.d.setUserAgent(w());
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
        SapiAccount accountFromBduss = SapiContext.getInstance(this.c.context).getAccountFromBduss(str);
        if (accountFromBduss != null && !TextUtils.isEmpty(accountFromBduss.ptoken)) {
            hashMap.put(ISapiAccount.SAPI_ACCOUNT_PTOKEN, accountFromBduss.ptoken);
        }
        hashMap.put("client", HttpConstants.OS_TYPE_VALUE);
        String deviceInfo = SapiDeviceInfo.getDeviceInfo("/v2/sapi/center/getuinfo");
        if (!TextUtils.isEmpty(deviceInfo)) {
            hashMap.put(AppIconSetting.DEFAULT_LARGE_ICON, deviceInfo);
        }
        String pisDeviceInfo = SapiDeviceInfo.getPisDeviceInfo();
        if (!TextUtils.isEmpty(pisDeviceInfo)) {
            hashMap.put("pis_di", pisDeviceInfo);
        }
        hashMap.put("bduss", str);
        String calculateSig = SapiUtils.calculateSig(hashMap, this.c.appSignKey);
        RequestParams requestParams = new RequestParams();
        for (Map.Entry entry : hashMap.entrySet()) {
            requestParams.put((String) entry.getKey(), (String) entry.getValue());
        }
        requestParams.put("sig", calculateSig);
        this.d.post(this.c.context, k(), requestParams, new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.a.16
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str2) {
                a.this.e.e();
                getUserInfoCallBack.onFinish();
                int b2 = a.this.b(str2);
                switch (b2) {
                    case 0:
                        try {
                            JSONObject jSONObject = new JSONObject(str2);
                            GetUserInfoResponse getUserInfoResponse = new GetUserInfoResponse();
                            getUserInfoResponse.errorCode = b2;
                            getUserInfoResponse.errorMsg = jSONObject.optString("errmsg");
                            String optString = jSONObject.optString(IntentConfig.PORTRAIT);
                            if (!TextUtils.isEmpty(optString)) {
                                getUserInfoResponse.portrait = String.format(SapiHost.getHost(SapiHost.DOMAIN_BDIMG) + "/sys/portrait/item/%s.jpg", optString);
                                getUserInfoResponse.portraitHttps = String.format(SapiHost.getHost(SapiHost.DOMAIN_PORTRAIT_HTTPS_URL) + "/sys/portrait/item/%s.jpg", optString);
                            }
                            getUserInfoResponse.username = jSONObject.optString("username");
                            getUserInfoResponse.uid = jSONObject.optString("userid");
                            getUserInfoResponse.displayname = jSONObject.optString("displayname");
                            getUserInfoResponse.incompleteUser = "1".equals(jSONObject.optString("incomplete_user"));
                            getUserInfoResponse.secureMobile = jSONObject.optString("securemobil");
                            getUserInfoResponse.secureEmail = jSONObject.optString("secureemail");
                            getUserInfoCallBack.onSuccess(getUserInfoResponse);
                            return;
                        } catch (JSONException e) {
                            getUserInfoCallBack.onSystemError(b2);
                            Log.e(e);
                            return;
                        }
                    case 400021:
                        getUserInfoCallBack.onBdussInvalid();
                        return;
                    default:
                        getUserInfoCallBack.onSystemError(b2);
                        return;
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str2) {
                if (!a.this.e.c()) {
                    a.this.e.e();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.onEvent("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        getUserInfoCallBack.onFinish();
                        getUserInfoCallBack.onSystemError(-203);
                        return;
                    }
                    getUserInfoCallBack.onFinish();
                    getUserInfoCallBack.onSystemError(-100);
                    return;
                }
                a.this.e.b();
                a.this.a(getUserInfoCallBack, str);
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
            fillUsernameResult.setResultCode(-201);
            fillUsernameCallback.onFailure(fillUsernameResult);
            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FILL_USENAME, IEventCenterService.EventResult.PHASE.FAILURE);
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(w());
        HashMap hashMap = new HashMap();
        hashMap.put("appid", this.c.appId);
        hashMap.put("tpl", this.c.tpl);
        hashMap.put("cert_id", String.valueOf(1));
        hashMap.put("crypttype", String.valueOf(6));
        JSONObject jSONObject = new JSONObject();
        final SapiDataEncryptor sapiDataEncryptor = new SapiDataEncryptor();
        try {
            jSONObject.put("bduss", str);
            if (!TextUtils.isEmpty(this.c.clientId)) {
                jSONObject.put("clientid", this.c.clientId);
            }
            if (!TextUtils.isEmpty(this.c.clientIp)) {
                jSONObject.put("clientip", this.c.clientIp);
            }
            jSONObject.put("username", str2);
            jSONObject.put(RimArmor.KEY, sapiDataEncryptor.getAESKey());
            hashMap.put("userinfo", sapiDataEncryptor.encrypt("-----BEGIN CERTIFICATE-----\nMIIFKDCCBBCgAwIBAgIQaG9YabPddabIY+N5IoXttzANBgkqhkiG9w0BAQUFADCB\nvDELMAkGA1UEBhMCVVMxFzAVBgNVBAoTDlZlcmlTaWduLCBJbmMuMR8wHQYDVQQL\nExZWZXJpU2lnbiBUcnVzdCBOZXR3b3JrMTswOQYDVQQLEzJUZXJtcyBvZiB1c2Ug\nYXQgaHR0cHM6Ly93d3cudmVyaXNpZ24uY29tL3JwYSAoYykxMDE2MDQGA1UEAxMt\nVmVyaVNpZ24gQ2xhc3MgMyBJbnRlcm5hdGlvbmFsIFNlcnZlciBDQSAtIEczMB4X\nDTEwMTIwMzAwMDAwMFoXDTEyMTIwMjIzNTk1OVowga8xCzAJBgNVBAYTAkNOMRAw\nDgYDVQQIEwdCZWlqaW5nMRAwDgYDVQQHFAdCZWlqaW5nMTkwNwYDVQQKFDBCZWlK\naW5nIEJhaWR1IE5ldGNvbSBTY2llbmNlIFRlY2hub2xvZ3kgQ28uLCBMdGQxJTAj\nBgNVBAsUHHNlcnZpY2Ugb3BlcmF0aW9uIGRlcGFydG1lbnQxGjAYBgNVBAMUEW9w\nZW5hcGkuYmFpZHUuY29tMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC68R1G\nWkkVvvjBOGKHOoyLxdtEcxBiVOGG8lvXTckB8jNrg4tihQzql+fJbr/X8V9MqQLw\nzzOyQViYlW+/GhC6u1jrP6t3Br0Wy8HyThDnvOAWyPFEawgbIywT20F41Iqayled\n/DQ/JCDWcNA7+xX56rqEcQd+6baNAiu9o962PwIDAQABo4IBszCCAa8wCQYDVR0T\nBAIwADALBgNVHQ8EBAMCBaAwQQYDVR0fBDowODA2oDSgMoYwaHR0cDovL1NWUklu\ndGwtRzMtY3JsLnZlcmlzaWduLmNvbS9TVlJJbnRsRzMuY3JsMEQGA1UdIAQ9MDsw\nOQYLYIZIAYb4RQEHFwMwKjAoBggrBgEFBQcCARYcaHR0cHM6Ly93d3cudmVyaXNp\nZ24uY29tL3JwYTAoBgNVHSUEITAfBglghkgBhvhCBAEGCCsGAQUFBwMBBggrBgEF\nBQcDAjByBggrBgEFBQcBAQRmMGQwJAYIKwYBBQUHMAGGGGh0dHA6Ly9vY3NwLnZl\ncmlzaWduLmNvbTA8BggrBgEFBQcwAoYwaHR0cDovL1NWUkludGwtRzMtYWlhLnZl\ncmlzaWduLmNvbS9TVlJJbnRsRzMuY2VyMG4GCCsGAQUFBwEMBGIwYKFeoFwwWjBY\nMFYWCWltYWdlL2dpZjAhMB8wBwYFKw4DAhoEFEtruSiWBgy70FI4mymsSweLIQUY\nMCYWJGh0dHA6Ly9sb2dvLnZlcmlzaWduLmNvbS92c2xvZ28xLmdpZjANBgkqhkiG\n9w0BAQUFAAOCAQEAgNIl8/QIKP4KWWWj6ltL6lVknoGlpUIoowvnv+57H7FdEYJb\n9zQewrAqoFkblB0mMiUEGdJOa7YxKKJialqz6KnlMrHQMAsB641BHLDESvLjuhio\nUsWmvBowIK92HQ2H9N01U8d1i5rTz5wwFK+Nvue/61tzCTTmbRgBuGPotQ/tcA+g\nYCNuEIHsJMbWiX9O3gflnMdRME7z9Hw9zMogt+lz7GudP/AO1K6sZ6VnQ931Gv1e\nIOmPCPfvO/Kw/aXSacoEWnMsy+qTIewVPT/MMgSaq9JewAQgLpMX+O5qqAJBYoDj\nxoZnHufGgOIKfNmSvYiHjDFJtP55PdEH21q+JA==\n-----END CERTIFICATE-----", jSONObject.toString()));
            hashMap.put("sig", SapiUtils.calculateSig(hashMap, this.c.appSignKey));
            this.d.post(this.c.context, j(), new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.a.17
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                protected void onStart() {
                    fillUsernameCallback.onStart();
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FILL_USENAME, IEventCenterService.EventResult.PHASE.START);
                }

                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                protected void onFinish() {
                    fillUsernameCallback.onFinish();
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FILL_USENAME, IEventCenterService.EventResult.PHASE.FINISH);
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onSuccess(int i, String str3) {
                    a.this.e.e();
                    int b2 = a.this.b(str3);
                    fillUsernameResult.setResultCode(b2);
                    try {
                        JSONObject jSONObject2 = new JSONObject(str3);
                        fillUsernameResult.setResultMsg(jSONObject2.optString("errmsg"));
                        JSONObject jSONObject3 = new JSONObject(sapiDataEncryptor.decrypt(jSONObject2.optString("userinfo")));
                        switch (b2) {
                            case 0:
                            case 110000:
                                SapiAccount sapiAccount = new SapiAccount();
                                sapiAccount.bduss = jSONObject3.optString("bduss");
                                sapiAccount.ptoken = jSONObject3.optString(ISapiAccount.SAPI_ACCOUNT_PTOKEN);
                                sapiAccount.stoken = jSONObject3.optString(ISapiAccount.SAPI_ACCOUNT_STOKEN);
                                sapiAccount.displayname = jSONObject3.optString("displayname");
                                sapiAccount.username = jSONObject3.optString("uname");
                                sapiAccount.uid = jSONObject3.optString("uid");
                                sapiAccount.addDispersionCertification(SapiAccount.DispersionCertification.fromJSONObject(jSONObject3).tplStokenMap);
                                com.baidu.sapi2.share.a.a().a(sapiAccount);
                                fillUsernameResult.session = sapiAccount;
                                fillUsernameCallback.onSuccess(fillUsernameResult);
                                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FILL_USENAME, IEventCenterService.EventResult.PHASE.SUCCESS);
                                break;
                            case 160103:
                                fillUsernameCallback.onBdussExpired(fillUsernameResult);
                                break;
                            case 160104:
                                fillUsernameCallback.onUserHaveUsername(fillUsernameResult);
                                break;
                            default:
                                fillUsernameCallback.onFailure(fillUsernameResult);
                                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FILL_USENAME, IEventCenterService.EventResult.PHASE.FAILURE);
                                break;
                        }
                    } catch (Throwable th) {
                        fillUsernameCallback.onFailure(fillUsernameResult);
                        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FILL_USENAME, IEventCenterService.EventResult.PHASE.FAILURE);
                        Log.e(th);
                    }
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onFailure(Throwable th, String str3) {
                    if (!a.this.e.c()) {
                        a.this.e.e();
                        if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                            StatService.onEvent("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                            fillUsernameResult.setResultCode(-203);
                            fillUsernameCallback.onFailure(fillUsernameResult);
                            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FILL_USENAME, IEventCenterService.EventResult.PHASE.FAILURE);
                            return;
                        }
                        fillUsernameResult.setResultCode(-202);
                        fillUsernameCallback.onFailure(fillUsernameResult);
                        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FILL_USENAME, IEventCenterService.EventResult.PHASE.FAILURE);
                        return;
                    }
                    a.this.e.b();
                    a.this.a(fillUsernameCallback, str, str2);
                }
            });
        } catch (Throwable th) {
            fillUsernameResult.setResultCode(-202);
            fillUsernameCallback.onFailure(fillUsernameResult);
            Log.e(th);
        }
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
            fillUserProfileResult.setResultCode(-201);
            fillUserProfileCallback.onFailure(fillUserProfileResult);
        } else if (!SapiUtils.isSimReady(this.c.context)) {
            fillUserProfileResult.setResultCode(-101);
            fillUserProfileCallback.onFailure(fillUserProfileResult);
        } else {
            this.d = new AsyncHttpClient();
            this.d.setUserAgent(w());
            HashMap hashMap = new HashMap();
            hashMap.put("appid", this.c.appId);
            hashMap.put("tpl", this.c.tpl);
            if (!TextUtils.isEmpty(this.c.clientId)) {
                hashMap.put("clientid", this.c.clientId);
            }
            hashMap.put("bduss", str);
            hashMap.put("sig", SapiUtils.calculateSig(hashMap, this.c.appSignKey));
            this.d.post(this.c.context, this.e.a() + SapiEnv.FILL_USER_PROFILE_SEND_URI, new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.a.18
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
                        int b2 = a.this.b(str2);
                        fillUserProfileResult.setResultCode(b2);
                        switch (b2) {
                            case 0:
                                String optString = jSONObject.optString("sms");
                                final String optString2 = jSONObject.optString("vcode");
                                final String optString3 = jSONObject.optString("upsmschannel");
                                boolean z = false;
                                if (SapiUtils.checkRequestPermission("android.permission.SEND_SMS", a.this.c.context)) {
                                    z = com.baidu.sapi2.utils.a.a(optString2, optString);
                                }
                                if (z && !TextUtils.isEmpty(optString3)) {
                                    a.this.d = new AsyncHttpClient();
                                    a.this.d.setUserAgent(a.this.w());
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
                                    requestParams.put(PushConstants.PUSH_NOTIFICATION_CREATE_TIMES_TAMP, String.valueOf(System.currentTimeMillis()));
                                    a.this.d.get(a.this.c.context, a.this.e.a() + SapiEnv.GET_QR_LOGIN_STATUS_CHECK, requestParams, new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.a.18.1
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
                                                fillUserProfileResult.setResultCode(-202);
                                                fillUserProfileCallback.onFailure(fillUserProfileResult);
                                                return;
                                            }
                                            int indexOf = str3.indexOf("(");
                                            int indexOf2 = str3.indexOf(")");
                                            if (indexOf >= 0) {
                                                try {
                                                    int b3 = a.this.b(str3.substring(indexOf + 1, indexOf2));
                                                    fillUserProfileResult.setResultCode(b3);
                                                    switch (b3) {
                                                        case 0:
                                                            HashMap hashMap2 = new HashMap();
                                                            hashMap2.put("appid", a.this.c.appId);
                                                            hashMap2.put("tpl", a.this.c.tpl);
                                                            if (!TextUtils.isEmpty(a.this.c.clientId)) {
                                                                hashMap2.put("clientid", a.this.c.clientId);
                                                            }
                                                            hashMap2.put("upsmschannel", optString3);
                                                            hashMap2.put("bduss", str);
                                                            hashMap2.put("vcode", optString2);
                                                            hashMap2.put("sig", SapiUtils.calculateSig(hashMap2, a.this.c.appSignKey));
                                                            a.this.a(fillUserProfileCallback, fillUserProfileResult, hashMap2);
                                                            break;
                                                    }
                                                    fillUserProfileCallback.onFailure(fillUserProfileResult);
                                                    return;
                                                } catch (Throwable th) {
                                                    Log.e(th);
                                                    fillUserProfileResult.setResultCode(-202);
                                                    fillUserProfileCallback.onFailure(fillUserProfileResult);
                                                    return;
                                                }
                                            }
                                            fillUserProfileResult.setResultCode(-202);
                                            fillUserProfileCallback.onFailure(fillUserProfileResult);
                                        }

                                        /* JADX INFO: Access modifiers changed from: protected */
                                        @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                                        public void onFailure(Throwable th, String str3) {
                                            fillUserProfileResult.setResultCode(-202);
                                            fillUserProfileCallback.onFailure(fillUserProfileResult);
                                        }
                                    });
                                    return;
                                }
                                fillUserProfileResult.setResultCode(-202);
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
                        fillUserProfileResult.setResultCode(-202);
                        fillUserProfileCallback.onFailure(fillUserProfileResult);
                    }
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onFailure(Throwable th, String str2) {
                    fillUserProfileResult.setResultCode(-202);
                    fillUserProfileCallback.onFailure(fillUserProfileResult);
                }
            });
        }
    }

    void a(final FillUserProfileCallback fillUserProfileCallback, final FillUserProfileResult fillUserProfileResult, Map<String, String> map) {
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(w());
        this.d.post(this.c.context, this.e.a() + SapiEnv.FILL_USER_PROFILE_BIND_URI, new RequestParams(map), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.a.19
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
                    int b2 = a.this.b(str);
                    fillUserProfileResult.setResultCode(b2);
                    switch (b2) {
                        case 0:
                            SapiAccount sapiAccount = new SapiAccount();
                            JSONObject jSONObject = new JSONObject(str);
                            sapiAccount.displayname = jSONObject.optString("displayname");
                            sapiAccount.bduss = jSONObject.optString("bduss");
                            sapiAccount.uid = jSONObject.optString("uid");
                            sapiAccount.ptoken = jSONObject.optString(ISapiAccount.SAPI_ACCOUNT_PTOKEN);
                            sapiAccount.stoken = jSONObject.optString(ISapiAccount.SAPI_ACCOUNT_STOKEN);
                            sapiAccount.addDispersionCertification(SapiAccount.DispersionCertification.fromJSONObject(jSONObject).tplStokenMap);
                            fillUserProfileResult.session = sapiAccount;
                            if (SapiAccountManager.getInstance().isLogin()) {
                                SapiAccount session = SapiAccountManager.getInstance().getSession();
                                if (session.uid.equals(fillUserProfileResult.session.uid)) {
                                    session.displayname = fillUserProfileResult.session.displayname;
                                    session.bduss = fillUserProfileResult.session.bduss;
                                    session.ptoken = fillUserProfileResult.session.ptoken;
                                    session.extra = fillUserProfileResult.session.extra;
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
                    fillUserProfileResult.setResultCode(-202);
                    fillUserProfileCallback.onFailure(fillUserProfileResult);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str) {
                fillUserProfileResult.setResultCode(-202);
                fillUserProfileCallback.onFailure(fillUserProfileResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(String str, List<String> list) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("targetTplList can't be null or empty");
        }
        return a(SapiContext.getInstance(this.c.context).getAccountFromBduss(str), list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(SapiAccount sapiAccount, List<String> list) {
        boolean z;
        if (sapiAccount == null || TextUtils.isEmpty(sapiAccount.extra)) {
            return false;
        }
        try {
            SapiAccount.DispersionCertification fromJSONObject = SapiAccount.DispersionCertification.fromJSONObject(new JSONObject(sapiAccount.extra));
            Iterator<String> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                if (!fromJSONObject.tplStokenMap.containsKey(it.next())) {
                    z = false;
                    break;
                }
            }
            return z;
        } catch (JSONException e) {
            Log.e(e);
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
            getTplStokenResult.setResultCode(-302);
            getTplStokenResult.setResultMsg(SapiResult.ERROR_MSG_PARAMS_ERROR);
            getTplStokenCallback.onFailure(getTplStokenResult);
            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_TPL_STOKEN, IEventCenterService.EventResult.PHASE.FAILURE);
            return getTplStokenResult.tplStokenMap;
        }
        final SapiAccount accountFromBduss = SapiContext.getInstance(this.c.context).getAccountFromBduss(str);
        if (accountFromBduss == null) {
            getTplStokenResult.setResultCode(-301);
            getTplStokenCallback.onFailure(getTplStokenResult);
            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_TPL_STOKEN, IEventCenterService.EventResult.PHASE.FAILURE);
            return getTplStokenResult.tplStokenMap;
        }
        final String str2 = accountFromBduss.ptoken;
        if (a(str, list)) {
            try {
                SapiAccount.DispersionCertification fromJSONObject = SapiAccount.DispersionCertification.fromJSONObject(new JSONObject(accountFromBduss.extra));
                Iterator<String> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String next = it.next();
                    if (fromJSONObject.tplStokenMap.containsKey(next)) {
                        getTplStokenResult.tplStokenMap.put(next, fromJSONObject.tplStokenMap.get(next));
                    } else {
                        getTplStokenResult.tplStokenMap.clear();
                        break;
                    }
                }
                if (!getTplStokenResult.tplStokenMap.isEmpty()) {
                    getTplStokenResult.setResultCode(0);
                    getTplStokenResult.setResultMsg("成功");
                    getTplStokenCallback.onSuccess(getTplStokenResult);
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_TPL_STOKEN, IEventCenterService.EventResult.PHASE.SUCCESS);
                    return getTplStokenResult.tplStokenMap;
                }
            } catch (JSONException e) {
                Log.e(e);
                getTplStokenResult.setResultCode(-304);
                getTplStokenCallback.onFailure(getTplStokenResult);
                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_TPL_STOKEN, IEventCenterService.EventResult.PHASE.FAILURE);
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
            getTplStokenResult.setResultCode(-305);
            getTplStokenResult.failureType = GetTplStokenResult.FailureType.PTOKEN_EMPTY;
            getTplStokenCallback.onFailure(getTplStokenResult);
            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_TPL_STOKEN, IEventCenterService.EventResult.PHASE.FAILURE);
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(w());
        HashMap hashMap = new HashMap();
        hashMap.put("appid", this.c.appId);
        hashMap.put("tpl", this.c.tpl);
        hashMap.put("bduss", str);
        hashMap.put("sign", MD5Util.toMd5((this.c.appId + this.c.tpl + str + this.c.appSignKey).getBytes(), false));
        hashMap.put("client", HttpConstants.OS_TYPE_VALUE);
        hashMap.put("return_type", "1");
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put(ISapiAccount.SAPI_ACCOUNT_PTOKEN, str2);
        }
        hashMap.put("tpl_list", str3);
        hashMap.put("sig", SapiUtils.calculateSig(hashMap, this.c.appSignKey));
        this.d.post(this.c.context, this.e.a() + SapiEnv.GET_STOKEN_URI, new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.a.20
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onStart() {
                getTplStokenCallback.onStart();
                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_TPL_STOKEN, IEventCenterService.EventResult.PHASE.START);
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onFinish() {
                getTplStokenCallback.onFinish();
                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_TPL_STOKEN, IEventCenterService.EventResult.PHASE.FINISH);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i2, String str5) {
                a.this.e.e();
                try {
                    JSONObject jSONObject = new JSONObject(str5);
                    int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                    getTplStokenResult.setResultCode(parseInt);
                    switch (parseInt) {
                        case 0:
                            Map<String, String> tplStokenMap = SapiAccount.DispersionCertification.getTplStokenMap(jSONObject.optJSONObject("stoken_list"));
                            getTplStokenResult.tplStokenMap = tplStokenMap;
                            SapiAccount.ExtraProperty extraProperty = new SapiAccount.ExtraProperty();
                            if (!TextUtils.isEmpty(accountFromBduss.extra)) {
                                extraProperty = SapiAccount.ExtraProperty.fromJSONObject(new JSONObject(accountFromBduss.extra));
                            }
                            extraProperty.dispersionCertification.tplStokenMap.putAll(tplStokenMap);
                            accountFromBduss.extra = extraProperty.toJSONObject().toString();
                            if (list.size() == tplStokenMap.size()) {
                                if (!z) {
                                    SapiContext.getInstance(a.this.c.context).setCurrentAccount(accountFromBduss);
                                    SapiAccountManager.getInstance().preFetchStoken(accountFromBduss, false);
                                    SapiContext.getInstance(a.this.c.context).addLoginAccount(accountFromBduss);
                                    new ShareCallPacking().markLoginState(false);
                                } else {
                                    com.baidu.sapi2.share.a.a().a(accountFromBduss);
                                }
                                getTplStokenCallback.onSuccess(getTplStokenResult);
                                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_TPL_STOKEN, IEventCenterService.EventResult.PHASE.SUCCESS);
                                return;
                            }
                            getTplStokenResult.setResultCode(-306);
                            getTplStokenCallback.onFailure(getTplStokenResult);
                            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_TPL_STOKEN, IEventCenterService.EventResult.PHASE.FAILURE);
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
                                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_TPL_STOKEN, IEventCenterService.EventResult.PHASE.FAILURE);
                                return;
                            }
                            return;
                        default:
                            if (!TextUtils.isEmpty(str2)) {
                                getTplStokenResult.setResultMsg(jSONObject.optString("errmsg"));
                                getTplStokenCallback.onFailure(getTplStokenResult);
                                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_TPL_STOKEN, IEventCenterService.EventResult.PHASE.FAILURE);
                                return;
                            }
                            return;
                    }
                } catch (Exception e2) {
                    Log.e(e2);
                    if (!TextUtils.isEmpty(str2)) {
                        getTplStokenResult.setResultCode(-205);
                        getTplStokenCallback.onFailure(getTplStokenResult);
                        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_TPL_STOKEN, IEventCenterService.EventResult.PHASE.FAILURE);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str5) {
                if (!a.this.e.c()) {
                    a.this.e.e();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.onEvent("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        if (!TextUtils.isEmpty(str2)) {
                            getTplStokenResult.setResultCode(-203);
                            getTplStokenCallback.onFailure(getTplStokenResult);
                            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_TPL_STOKEN, IEventCenterService.EventResult.PHASE.FAILURE);
                            return;
                        }
                        return;
                    } else if (!TextUtils.isEmpty(str2)) {
                        getTplStokenResult.setResultCode(-202);
                        getTplStokenCallback.onFailure(getTplStokenResult);
                        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_TPL_STOKEN, IEventCenterService.EventResult.PHASE.FAILURE);
                        return;
                    } else {
                        return;
                    }
                }
                a.this.e.b();
                a.this.a(getTplStokenCallback, str, list, z);
            }
        });
        return getTplStokenResult.tplStokenMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final SapiCallback<OAuthResult> sapiCallback, final String str, final String str2) {
        if (sapiCallback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("bduss can't be empty");
        }
        final OAuthResult oAuthResult = new OAuthResult();
        if (!SapiUtils.hasActiveNetwork(this.c.context)) {
            oAuthResult.setResultCode(-201);
            sapiCallback.onFailure(oAuthResult);
            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_OAUTH, IEventCenterService.EventResult.PHASE.FAILURE);
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(w());
        HashMap hashMap = new HashMap();
        hashMap.put("appid", this.c.appId);
        hashMap.put("tpl", this.c.tpl);
        if (!TextUtils.isEmpty(this.c.clientId)) {
            hashMap.put("clientid", this.c.clientId);
        }
        if (!TextUtils.isEmpty(this.c.clientIp)) {
            hashMap.put("clientip", this.c.clientIp);
        }
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("openPlatformId", str2);
        }
        hashMap.put("bduss", str);
        hashMap.put("sig", SapiUtils.calculateSig(hashMap, this.c.appSignKey));
        this.d.post(this.c.context, this.e.a() + SapiEnv.OAUTH_URI, new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.a.2
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onStart() {
                sapiCallback.onStart();
                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_OAUTH, IEventCenterService.EventResult.PHASE.START);
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onFinish() {
                sapiCallback.onFinish();
                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_OAUTH, IEventCenterService.EventResult.PHASE.FINISH);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str3) {
                a.this.e.e();
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                    oAuthResult.setResultCode(parseInt);
                    switch (parseInt) {
                        case 0:
                            oAuthResult.accessToken = jSONObject.optString("access_token");
                            oAuthResult.expiresIn = jSONObject.optInt("expires_in");
                            oAuthResult.scope = jSONObject.optString("scope");
                            oAuthResult.refreshToken = jSONObject.optString(Oauth2AccessToken.KEY_REFRESH_TOKEN);
                            oAuthResult.sessionKey = jSONObject.optString("session_key");
                            oAuthResult.sessionSecret = jSONObject.optString("session_secret");
                            oAuthResult.extra = str3;
                            oAuthResult.openid = jSONObject.optString("openid");
                            sapiCallback.onSuccess(oAuthResult);
                            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_OAUTH, IEventCenterService.EventResult.PHASE.SUCCESS);
                            break;
                        default:
                            sapiCallback.onFailure(oAuthResult);
                            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_OAUTH, IEventCenterService.EventResult.PHASE.FAILURE);
                            break;
                    }
                } catch (Throwable th) {
                    oAuthResult.setResultCode(-202);
                    sapiCallback.onFailure(oAuthResult);
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_OAUTH, IEventCenterService.EventResult.PHASE.FAILURE);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str3) {
                if (!a.this.e.c()) {
                    a.this.e.e();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.onEvent("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        oAuthResult.setResultCode(-203);
                        sapiCallback.onFailure(oAuthResult);
                        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_OAUTH, IEventCenterService.EventResult.PHASE.FAILURE);
                        return;
                    }
                    oAuthResult.setResultCode(-202);
                    sapiCallback.onFailure(oAuthResult);
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_OAUTH, IEventCenterService.EventResult.PHASE.FAILURE);
                    return;
                }
                a.this.e.b();
                a.this.a(sapiCallback, str, str2);
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
            sSOConfirmResult.setResultCode(-201);
            sSOConfirmCallback.onFailure(sSOConfirmResult);
            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_WAP_SSO_CONFIRM, IEventCenterService.EventResult.PHASE.FAILURE);
            return;
        }
        this.d = new AsyncHttpClient();
        this.d.setUserAgent(w());
        Map<String, String> a2 = a(SapiEnv.WAP_SSO_CONFIRM);
        if (!TextUtils.isEmpty(this.c.clientId)) {
            a2.put("cuid", this.c.clientId);
        }
        if (!TextUtils.isEmpty(this.c.clientIp)) {
            a2.put("clientip", this.c.clientIp);
        }
        a2.put("channel_id", sSOConfirmDTO.channelID);
        a2.put("bduss", sSOConfirmDTO.bduss);
        a2.put("refuse", sSOConfirmDTO.authorized ? "0" : "1");
        a2.put("sig", SapiUtils.calculateSig(a2, this.c.appSignKey));
        this.d.post(this.c.context, this.e.a() + SapiEnv.WAP_SSO_CONFIRM, new RequestParams(a2), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.a.3
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onStart() {
                sSOConfirmCallback.onStart();
                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_WAP_SSO_CONFIRM, IEventCenterService.EventResult.PHASE.START);
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onFinish() {
                sSOConfirmCallback.onFinish();
                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_WAP_SSO_CONFIRM, IEventCenterService.EventResult.PHASE.FINISH);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str) {
                if (!a.this.e.c()) {
                    a.this.e.e();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.onEvent("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        sSOConfirmResult.setResultCode(-203);
                        sSOConfirmCallback.onFailure(sSOConfirmResult);
                        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_WAP_SSO_CONFIRM, IEventCenterService.EventResult.PHASE.FAILURE);
                        return;
                    }
                    sSOConfirmResult.setResultCode(-202);
                    sSOConfirmCallback.onFailure(sSOConfirmResult);
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_WAP_SSO_CONFIRM, IEventCenterService.EventResult.PHASE.FAILURE);
                    return;
                }
                a.this.e.b();
                a.this.a(sSOConfirmCallback, sSOConfirmDTO);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str) {
                a.this.e.e();
                try {
                    int b2 = a.this.b(str);
                    sSOConfirmResult.setResultCode(b2);
                    if (b2 == 0) {
                        sSOConfirmCallback.onSuccess(sSOConfirmResult);
                        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_WAP_SSO_CONFIRM, IEventCenterService.EventResult.PHASE.SUCCESS);
                    } else {
                        sSOConfirmCallback.onFailure(sSOConfirmResult);
                        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_WAP_SSO_CONFIRM, IEventCenterService.EventResult.PHASE.FAILURE);
                    }
                } catch (Throwable th) {
                    sSOConfirmResult.setResultCode(-202);
                    sSOConfirmCallback.onFailure(sSOConfirmResult);
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_WAP_SSO_CONFIRM, IEventCenterService.EventResult.PHASE.FAILURE);
                    Log.e(th);
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
                sapiCallBack.onSystemError(257);
                return false;
            }
            return false;
        } else {
            this.d = new AsyncHttpClient();
            this.d.setUserAgent(w());
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
            hashMap.put("sig", SapiUtils.calculateSig(hashMap, this.c.appSignKey));
            this.d.post(this.c.context, this.e.a() + SapiEnv.GET_DYNAMIC_PWD_URI, new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.a.4
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onSuccess(int i, String str2) {
                    super.onSuccess(i, str2);
                    a.this.e.e();
                    a.this.c(sapiCallBack, str2);
                }

                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onFailure(Throwable th, String str2) {
                    super.onFailure(th, str2);
                    if (!a.this.e.c()) {
                        a.this.e.e();
                        if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                            StatService.onEvent("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                            sapiCallBack.onSystemError(-203);
                            return;
                        }
                        a.this.c(sapiCallBack, str2);
                        return;
                    }
                    a.this.e.b();
                    a.this.a(sapiCallBack, str);
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
            this.d.setUserAgent(w());
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
            hashMap.put("sig", SapiUtils.calculateSig(hashMap, this.c.appSignKey));
            this.d.post(this.c.context, this.e.a() + SapiEnv.FAST_REG_URI, new RequestParams(hashMap), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.a.5
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onSuccess(int i, String str2) {
                    super.onSuccess(i, str2);
                    a.this.e.e();
                    a.this.a(i, sapiCallBack, str2);
                }

                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onFailure(Throwable th, String str2) {
                    super.onFailure(th, str2);
                    if (!a.this.e.c()) {
                        a.this.e.e();
                        if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                            StatService.onEvent("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                            sapiCallBack.onSystemError(-203);
                            return;
                        }
                        a.this.a(a.this.c(str2), sapiCallBack, str2);
                        return;
                    }
                    a.this.e.b();
                    a.this.b(sapiCallBack, str);
                }
            });
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SapiCallback<FastRegResult> sapiCallback, int i, Map<String, String> map) {
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
            fastRegResult.setResultCode(-201);
            sapiCallback.onFailure(fastRegResult);
        } else {
            final boolean[] zArr = {false};
            String str = UUID.randomUUID().toString() + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + System.currentTimeMillis() + ",点击发送直接登录";
            final Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.a.6
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
            Runnable runnable = new Runnable() { // from class: com.baidu.sapi2.a.7
                @Override // java.lang.Runnable
                public void run() {
                    Message.obtain(handler, 1001).sendToTarget();
                }
            };
            if (SapiUtils.checkRequestPermission("android.permission.SEND_SMS", this.c.context) ? com.baidu.sapi2.utils.a.a(str, SapiUtils.getFastRegChannel(this.c.context)) : false) {
                this.d = new AsyncHttpClient();
                this.d.setUserAgent(w());
                Map<String, String> a2 = a(SapiEnv.FAST_REG_URI);
                if (map != null && map.size() > 0) {
                    a2.putAll(map);
                }
                a2.put("sms", str);
                a2.put("sig", SapiUtils.calculateSig(a2, this.c.appSignKey));
                RequestParams requestParams = new RequestParams(a2);
                handler.postDelayed(runnable, i * 1000);
                sapiCallback.onStart();
                a(sapiCallback, requestParams, handler, runnable, zArr);
                return;
            }
            fastRegResult.setResultCode(FastRegResult.ERROR_CODE_SEND_SMS_FAILED);
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
            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_RECURSIVE_FAST_REG, IEventCenterService.EventResult.PHASE.FINISH);
            sapiCallback.onFailure(fastRegResult);
            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_RECURSIVE_FAST_REG, IEventCenterService.EventResult.PHASE.FAILURE);
            return;
        }
        this.d.post(this.c.context, this.e.a() + SapiEnv.FAST_REG_URI, requestParams, new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.a.8
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str) {
                int b2 = a.this.b(str);
                fastRegResult.setResultCode(b2);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    fastRegResult.setResultMsg(jSONObject.optJSONObject("sdk").optString("msg"));
                    switch (b2) {
                        case 0:
                            a.this.e.e();
                            SapiAccount a2 = a.this.a(jSONObject);
                            a2.addDispersionCertification(SapiAccount.DispersionCertification.fromJSONObject(jSONObject).tplStokenMap);
                            com.baidu.sapi2.share.a.a().a(a2);
                            fastRegResult.newReg = jSONObject.optBoolean("newreg");
                            fastRegResult.authSid = jSONObject.optString("authsid");
                            if ("null".equals(fastRegResult.authSid)) {
                                fastRegResult.authSid = null;
                            }
                            handler.removeCallbacks(runnable);
                            sapiCallback.onFinish();
                            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_RECURSIVE_FAST_REG, IEventCenterService.EventResult.PHASE.FINISH);
                            sapiCallback.onSuccess(fastRegResult);
                            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_RECURSIVE_FAST_REG, IEventCenterService.EventResult.PHASE.SUCCESS);
                            return;
                        case 7:
                            handler.postDelayed(new Runnable() { // from class: com.baidu.sapi2.a.8.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    a.this.a(sapiCallback, requestParams, handler, runnable, zArr);
                                }
                            }, 400L);
                            return;
                        default:
                            a.this.e.e();
                            handler.removeCallbacks(runnable);
                            sapiCallback.onFinish();
                            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_RECURSIVE_FAST_REG, IEventCenterService.EventResult.PHASE.FINISH);
                            sapiCallback.onFailure(fastRegResult);
                            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_RECURSIVE_FAST_REG, IEventCenterService.EventResult.PHASE.FAILURE);
                            return;
                    }
                } catch (Exception e) {
                    a.this.e.e();
                    handler.removeCallbacks(runnable);
                    sapiCallback.onFinish();
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_RECURSIVE_FAST_REG, IEventCenterService.EventResult.PHASE.FINISH);
                    sapiCallback.onFailure(fastRegResult);
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_RECURSIVE_FAST_REG, IEventCenterService.EventResult.PHASE.FAILURE);
                    Log.e(e);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str) {
                if (!a.this.e.c()) {
                    a.this.e.e();
                    handler.removeCallbacks(runnable);
                    sapiCallback.onFinish();
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_RECURSIVE_FAST_REG, IEventCenterService.EventResult.PHASE.FINISH);
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.onEvent("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        fastRegResult.setResultCode(-203);
                        sapiCallback.onFailure(fastRegResult);
                        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_RECURSIVE_FAST_REG, IEventCenterService.EventResult.PHASE.FAILURE);
                        return;
                    }
                    fastRegResult.setResultCode(-202);
                    sapiCallback.onFailure(fastRegResult);
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_RECURSIVE_FAST_REG, IEventCenterService.EventResult.PHASE.FAILURE);
                    return;
                }
                a.this.e.b();
                a.this.a(sapiCallback, requestParams, handler, runnable, zArr);
            }
        });
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
        String deviceInfo = SapiDeviceInfo.getDeviceInfo(str);
        if (!TextUtils.isEmpty(deviceInfo)) {
            hashMap.put(AppIconSetting.DEFAULT_LARGE_ICON, deviceInfo);
        }
        String pisDeviceInfo = SapiDeviceInfo.getPisDeviceInfo();
        if (!TextUtils.isEmpty(pisDeviceInfo)) {
            hashMap.put("pis_di", pisDeviceInfo);
        }
        hashMap.put("clientfrom", "mobilesdk_enhanced");
        hashMap.put(SapiContext.KEY_SDK_VERSION, "3");
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String w() {
        return "tpl:" + this.c.tpl + ";android_sapi_v" + SapiAccountManager.VERSION_NAME;
    }

    int b(String str) {
        try {
            return new JSONObject(str).getInt("errno");
        } catch (Exception e) {
            Log.e(e);
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

    void a(int i, SapiCallBack<SapiAccountResponse> sapiCallBack, String str) {
        if (str != null) {
            SapiAccountResponse sapiAccountResponse = new SapiAccountResponse();
            try {
                JSONObject jSONObject = new JSONObject(str);
                sapiAccountResponse.displayname = jSONObject.optString("displayname");
                sapiAccountResponse.username = jSONObject.optString("uname");
                sapiAccountResponse.uid = jSONObject.optString("uid");
                sapiAccountResponse.bduss = jSONObject.optString("bduss");
                sapiAccountResponse.ptoken = jSONObject.optString(ISapiAccount.SAPI_ACCOUNT_PTOKEN);
                sapiAccountResponse.stoken = jSONObject.optString(ISapiAccount.SAPI_ACCOUNT_STOKEN);
                sapiAccountResponse.newReg = jSONObject.optBoolean("newreg");
                sapiAccountResponse.tplStokenMap = SapiAccount.DispersionCertification.getTplStokenMap(jSONObject.optJSONObject("stoken_list"));
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
                SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() { // from class: com.baidu.sapi2.a.9
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.LoginStatusAware
                    /* renamed from: a */
                    public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                        a.this.a(iqiyiLoginCallback, iqiyiLoginDTO, iqiyiLoginResult);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    /* renamed from: b */
                    public void onSuccess(GetUserInfoResult getUserInfoResult) {
                        String str4 = getUserInfoResult.secureMobile;
                        boolean z2 = getUserInfoResult.incompleteUser;
                        if (TextUtils.isEmpty(str4)) {
                            if (z2) {
                                a.this.a(iqiyiLoginCallback, iqiyiLoginDTO, iqiyiLoginResult);
                                return;
                            } else if (!TextUtils.isEmpty(str2)) {
                                a.this.a(iqiyiLoginCallback, iqiyiLoginDTO, iqiyiLoginResult);
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
        this.d.setUserAgent(w());
        Map<String, String> a2 = a(r());
        if (!TextUtils.isEmpty(iqiyiLoginDTO.phoneNum)) {
            a2.put("crypt_m", iqiyiLoginDTO.phoneNum);
        }
        a2.put("access_token", iqiyiLoginDTO.accessToken);
        a2.put("osuid", iqiyiLoginDTO.openID);
        a2.put("json", "1");
        a2.put("type", SocialType.IQIYI.getType() + "");
        a2.put(SocialConstants.PARAM_ACT, "special");
        a2.put(LivenessRecogActivity.f.a, "native");
        a2.put("client", HttpConstants.OS_TYPE_VALUE);
        a2.put("sig", SapiUtils.calculateSig(a2, this.c.appSignKey));
        this.d.get(this.c.context, r(), new RequestParams(a2), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.a.10
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onStart() {
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onFinish() {
                iqiyiLoginCallback.onFinish();
                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, IEventCenterService.EventResult.PHASE.FINISH);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onSuccess(int i, String str) {
                super.onSuccess(i, str);
                a.this.e.e();
                if (a.this.b(str) != 302) {
                    SocialResponse b2 = SapiWebView.b(str, a.this.c.context);
                    if (b2 == null) {
                        iqiyiLoginResult.setResultCode(-100);
                        iqiyiLoginResult.setResultMsg("登录失败");
                        iqiyiLoginCallback.onFailure(iqiyiLoginResult);
                        return;
                    } else if (b2.errorCode != -100) {
                        iqiyiLoginResult.setResultCode(-100);
                        iqiyiLoginResult.setResultMsg("登录失败");
                        iqiyiLoginCallback.onFailure(iqiyiLoginResult);
                        return;
                    } else {
                        SapiAccount a3 = a.this.a(b2);
                        a3.addSocialInfo(b2.socialType, b2.socialPortraitUrl);
                        a3.putExtra(GiftTabActivityConfig.ACCOUNT_TYPE, Integer.valueOf(b2.accountType.getType()));
                        a3.addDispersionCertification(b2.tplStokenMap);
                        a3.addIsGuestAccount(b2.isGuestAccount);
                        com.baidu.sapi2.share.a.a().a(a3);
                        iqiyiLoginCallback.onSuccess(iqiyiLoginResult);
                        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, IEventCenterService.EventResult.PHASE.SUCCESS);
                        return;
                    }
                }
                try {
                    iqiyiLoginResult.nextUrl = new JSONObject(str).optString("next_url");
                    iqiyiLoginCallback.onBindWebview(iqiyiLoginResult);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            public void onFailure(Throwable th, String str) {
                super.onFailure(th, str);
                if (!a.this.e.c()) {
                    a.this.e.e();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.onEvent("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        iqiyiLoginResult.setResultCode(-203);
                        iqiyiLoginCallback.onFailure(iqiyiLoginResult);
                        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, IEventCenterService.EventResult.PHASE.FAILURE);
                        return;
                    }
                    iqiyiLoginResult.setResultCode(-202);
                    iqiyiLoginCallback.onFailure(iqiyiLoginResult);
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, IEventCenterService.EventResult.PHASE.FAILURE);
                    return;
                }
                a.this.e.b();
                iqiyiLoginCallback.onStart();
                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_THROUGH_SERVER, IEventCenterService.EventResult.PHASE.START);
                a.this.a(iqiyiLoginCallback, iqiyiLoginDTO, iqiyiLoginResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(String str) {
        if (!TextUtils.isEmpty(str) && SapiUtils.hasActiveNetwork(this.c.context)) {
            this.d = new AsyncHttpClient();
            this.d.setUserAgent(w());
            HashMap hashMap = new HashMap();
            hashMap.put("tpl", this.c.tpl);
            hashMap.put("appid", this.c.appId);
            hashMap.put("accesstoken", str);
            String calculateSig = SapiUtils.calculateSig(hashMap, this.c.appSignKey);
            RequestParams requestParams = new RequestParams();
            for (Map.Entry entry : hashMap.entrySet()) {
                requestParams.put((String) entry.getKey(), (String) entry.getValue());
            }
            requestParams.put("sig", calculateSig);
            this.d.post(this.c.context, o(), requestParams, new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.a.11
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onSuccess(int i, String str2) {
                    super.onSuccess(i, str2);
                }

                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onFailure(Throwable th, String str2) {
                    super.onFailure(th, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context) {
        if (context != null) {
            final String faceLoginUid = SapiContext.getInstance(context).getFaceLoginUid();
            if (!TextUtils.isEmpty(faceLoginUid)) {
                this.d = new AsyncHttpClient();
                this.d.setUserAgent(w());
                HashMap hashMap = new HashMap();
                hashMap.put("client", HttpConstants.OS_TYPE_VALUE);
                hashMap.put("cuid", this.c.clientId);
                hashMap.put("uid", faceLoginUid);
                hashMap.put("zid", SapiAccountManager.getInstance().getSafeFacade().getCurrentZid(context));
                hashMap.put("clientfrom", "native");
                String deviceInfo = SapiDeviceInfo.getDeviceInfo(SapiEnv.FACE_LOGIN_ENABLE);
                if (!TextUtils.isEmpty(deviceInfo)) {
                    hashMap.put(AppIconSetting.DEFAULT_LARGE_ICON, deviceInfo);
                }
                hashMap.put("sapiver", "1");
                hashMap.put("tpl", this.c.tpl);
                hashMap.put("appid", this.c.appId);
                RequestParams requestParams = new RequestParams(hashMap);
                requestParams.put("sig", SapiUtils.calculateSig(hashMap, this.c.appSignKey));
                this.d.post(context, this.e.a() + SapiEnv.FACE_LOGIN_ENABLE, requestParams, new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.a.13
                    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                    public void onSuccess(int i, final String str) {
                        ThreadPoolService.getInstance().runImport(new TPRunnable(new Runnable() { // from class: com.baidu.sapi2.a.13.1
                            @Override // java.lang.Runnable
                            public void run() {
                                new FaceLoginService().saveFaceLoginCheckResult(faceLoginUid, str);
                            }
                        }));
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                    public void onFailure(Throwable th, String str) {
                    }
                });
            }
        }
    }

    SapiAccount a(JSONObject jSONObject) {
        SapiAccount sapiAccount = new SapiAccount();
        sapiAccount.uid = jSONObject.optString("uid");
        sapiAccount.bduss = jSONObject.optString("bduss");
        sapiAccount.displayname = jSONObject.optString("displayname");
        sapiAccount.username = jSONObject.optString("uname");
        sapiAccount.stoken = jSONObject.optString(ISapiAccount.SAPI_ACCOUNT_STOKEN);
        sapiAccount.ptoken = jSONObject.optString(ISapiAccount.SAPI_ACCOUNT_PTOKEN);
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

    void c(SapiCallBack<SapiResponse> sapiCallBack, String str) {
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

    private Domain x() {
        return this.c.environment;
    }

    private String y() {
        return this.e.a() + "/sslcrypt/get_last_cert";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        return x().getWap(SapiUtils.getDefaultHttpsEnabled()) + "/passport/login";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() {
        return x().getWap(SapiUtils.getDefaultHttpsEnabled()) + "/passport/getpass";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d() {
        return x().getWap(SapiUtils.getDefaultHttpsEnabled()) + "/wp/wappassword";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String e() {
        return x().getWap(SapiUtils.getDefaultHttpsEnabled()) + "/wp/recordindex";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String f() {
        return x().getWap(SapiUtils.getDefaultHttpsEnabled()) + "/v2/?bindingaccount&";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String g() {
        return x().getWap(SapiUtils.getDefaultHttpsEnabled()) + "/v2/?bindingret";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(BindWidgetAction bindWidgetAction) {
        return x().getWap(SapiUtils.getDefaultHttpsEnabled()) + bindWidgetAction.getUri();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String h() {
        return x().getWap(SapiUtils.getDefaultHttpsEnabled()) + "/passport/authwidget";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String i() {
        return x().getWap(SapiUtils.getDefaultHttpsEnabled()) + "/wp/unitewidget";
    }

    String j() {
        return this.e.a() + "/v2/sapi/center/filluname";
    }

    String k() {
        return this.e.a() + "/v2/sapi/center/getuinfo";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String l() {
        return x().getWap(SapiUtils.getDefaultHttpsEnabled()) + "/wp/v3/ucenter/index";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String m() {
        return x().getWap(SapiUtils.getDefaultHttpsEnabled()) + "/v4/security";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String n() {
        return x().getWap(SapiUtils.getDefaultHttpsEnabled()) + "/wp/v3/ucenter/realnameverify";
    }

    String o() {
        return x().getURL(SapiUtils.getDefaultHttpsEnabled()) + SapiEnv.GET_IQIYI_ACCOUNT_INFO_URI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String p() {
        return x().getURL(SapiUtils.getDefaultHttpsEnabled()) + SapiEnv.NORMALIZE_GUEST_ACCOUNT_URI;
    }

    String q() {
        return this.e.a() + SapiEnv.LOGIN_URI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String r() {
        return this.e.a() + "/phoenix/account/ssologin";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String s() {
        return this.e.a() + "/phoenix/account/ssologin";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String t() {
        return this.e.a() + SapiEnv.SOCIAL_START_URI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String u() {
        return this.e.a() + SapiEnv.SOCIAL_AFTER_AUTH_URI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String v() {
        return this.e.a() + SapiEnv.SOCIAL_FINISH_AUTH_URI;
    }
}
