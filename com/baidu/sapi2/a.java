package com.baidu.sapi2;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Looper;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.android.common.security.MD5Util;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.activity.LoginActivity;
import com.baidu.sapi2.callback.FillUsernameCallback;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.callback.IqiyiLoginCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.callback.SsoHashCallback;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.sapi2.dto.IqiyiLoginDTO;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.sapi2.result.CheckUserFaceIdResult;
import com.baidu.sapi2.result.FaceLoginStatusResult;
import com.baidu.sapi2.result.FillUsernameResult;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.result.IqiyiLoginResult;
import com.baidu.sapi2.result.OAuthResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.SsoHashResult;
import com.baidu.sapi2.result.Web2NativeLoginResult;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.share.a.b;
import com.baidu.sapi2.shell.callback.SapiCallBack;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SapiResponse;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.PtokenStat;
import com.baidu.sapi2.utils.SapiDataEncryptor;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiDeviceUtils;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.security.cert.CertificateException;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a {
    private static final int a = 6;
    private static final String b = "3";
    private SapiConfiguration c = SapiAccountManager.getInstance().getSapiConfiguration();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final Web2NativeLoginCallback web2NativeLoginCallback, boolean z) {
        SapiUtils.notNull(web2NativeLoginCallback, Web2NativeLoginCallback.class.getSimpleName() + " can't be null");
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
                    sapiAccount.app = SapiUtils.getAppName(a.this.c.context);
                    com.baidu.sapi2.share.a.a().a(sapiAccount);
                    web2NativeLoginResult.setResultCode(0);
                    web2NativeLoginCallback.onSuccess(web2NativeLoginResult);
                    new PtokenStat().onEvent(PtokenStat.WEB_2_NATIVE);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                /* renamed from: c */
                public void onFailure(GetUserInfoResult getUserInfoResult) {
                    web2NativeLoginResult.setResultCode(-202);
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
    public boolean a(final SapiCallBack<SapiAccountResponse> sapiCallBack, final String str, final String str2, final boolean z) {
        if (this.c == null || this.c.context == null) {
            return false;
        }
        SapiUtils.notNull(sapiCallBack, SapiCallBack.class.getSimpleName() + " can't be null");
        final SapiDataEncryptor sapiDataEncryptor = new SapiDataEncryptor();
        new HttpClientWrap().get(w(), null, null, u(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.a.10
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str3) {
                if (i == -201) {
                    sapiCallBack.onNetworkFailed();
                } else {
                    sapiCallBack.onSystemError(i);
                }
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
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
    public void a(final SapiCallBack<SapiAccountResponse> sapiCallBack, String str, String str2, String str3, String str4, final boolean z, final SapiDataEncryptor sapiDataEncryptor) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, CertificateException, JSONException {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("crypttype", Constants.VIA_SHARE_TYPE_INFO);
        String deviceInfo = SapiDeviceInfo.getDeviceInfo(SapiEnv.LOGIN_URI);
        if (!TextUtils.isEmpty(deviceInfo)) {
            httpHashMapWrap.put(AppIconSetting.DEFAULT_LARGE_ICON, deviceInfo);
        }
        httpHashMapWrap.put("cert_id", str2);
        httpHashMapWrap.put("isdpass", "1");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(LoginActivity.EXTRA_PARAM_USERNAME, str3);
        jSONObject.put("isphone", "1");
        jSONObject.put("password", str4);
        jSONObject.put("login_type", "3");
        jSONObject.put("key", sapiDataEncryptor.getAESKey());
        jSONObject.put(SapiContext.KEY_SDK_VERSION, "2");
        jSONObject.put("pinfo", SapiDeviceUtils.getBrandName());
        httpHashMapWrap.put("userinfo", sapiDataEncryptor.encrypt(str, jSONObject.toString()));
        new HttpClientWrap().post(SapiEnv.LOGIN_URI, httpHashMapWrap, null, u(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.a.11
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i, String str5) {
                super.onSuccess(i, str5);
                a.this.a(a.this.b(str5), sapiCallBack, str5, z, sapiDataEncryptor);
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str5) {
                super.onFailure(th, i, str5);
                if (i == -201) {
                    sapiCallBack.onNetworkFailed();
                } else {
                    sapiCallBack.onSystemError(i);
                }
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
                    sapiAccountResponse.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                    sapiAccountResponse.username = jSONObject.optString("uname");
                    sapiAccountResponse.uid = jSONObject.optString("uid");
                    sapiAccountResponse.email = jSONObject.optString(NotificationCompat.CATEGORY_EMAIL);
                    sapiAccountResponse.bduss = jSONObject.optString("bduss");
                    sapiAccountResponse.ptoken = jSONObject.optString("ptoken");
                    sapiAccountResponse.stoken = jSONObject.optString("stoken");
                    sapiAccountResponse.authSid = jSONObject.optString("authsid");
                }
                if (sapiCallBack != null) {
                    switch (i) {
                        case 0:
                            if (z) {
                                SapiAccount a2 = a(sapiAccountResponse);
                                a2.addDispersionCertification(SapiAccount.DispersionCertification.fromJSONObject(jSONObject).tplStokenMap);
                                a2.putExtra("tpl", this.c.tpl);
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
    public void a(final GetUserInfoCallback getUserInfoCallback, String str) {
        SapiUtils.notNull(getUserInfoCallback, GetUserInfoCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        final GetUserInfoResult getUserInfoResult = new GetUserInfoResult();
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("bduss", str);
        SapiAccount accountFromBduss = SapiContext.getInstance(this.c.context).getAccountFromBduss(str);
        if (accountFromBduss != null && !TextUtils.isEmpty(accountFromBduss.ptoken)) {
            httpHashMapWrap.put("ptoken", accountFromBduss.ptoken);
        }
        String deviceAuthToken = SapiAccountManager.getInstance().getDeviceAuthToken(this.c.context, accountFromBduss == null ? null : accountFromBduss.uid, 122);
        if (!TextUtils.isEmpty(deviceAuthToken)) {
            httpHashMapWrap.put("once_token", deviceAuthToken);
        }
        String deviceInfo = SapiDeviceInfo.getDeviceInfo(SapiEnv.GET_USER_INFO_URI);
        if (!TextUtils.isEmpty(deviceInfo)) {
            httpHashMapWrap.put(AppIconSetting.DEFAULT_LARGE_ICON, deviceInfo);
        }
        new HttpClientWrap().post(SapiEnv.GET_USER_INFO_URI, httpHashMapWrap, null, u(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.a.12
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onStart() {
                getUserInfoCallback.onStart();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFinish() {
                getUserInfoCallback.onFinish();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i, String str2) {
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
                            getUserInfoResult.username = jSONObject.optString(LoginActivity.EXTRA_PARAM_USERNAME);
                            getUserInfoResult.uid = jSONObject.optString("userid");
                            getUserInfoResult.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                            getUserInfoResult.incompleteUser = "1".equals(jSONObject.optString("incomplete_user"));
                            getUserInfoResult.secureMobile = jSONObject.optString("securemobil");
                            getUserInfoResult.secureEmail = jSONObject.optString("secureemail");
                            getUserInfoResult.havePwd = "1".equals(jSONObject.optString("have_psw"));
                            getUserInfoResult.carSdkFace = jSONObject.optInt("carSdkFace");
                            getUserInfoResult.faceLoginSwitch = jSONObject.optInt("faceLoginSwitch");
                            getUserInfoCallback.onSuccess(getUserInfoResult);
                            return;
                        } catch (Exception e) {
                            getUserInfoCallback.onFailure(getUserInfoResult);
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
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str2) {
                getUserInfoResult.setResultCode(i);
                getUserInfoCallback.onFailure(getUserInfoResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final FillUsernameCallback fillUsernameCallback, String str, String str2) {
        SapiUtils.notNull(fillUsernameCallback, FillUsernameCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        SapiUtils.notEmpty(str2, "username can't be empty");
        final FillUsernameResult fillUsernameResult = new FillUsernameResult();
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("cert_id", String.valueOf(1));
        httpHashMapWrap.put("crypttype", String.valueOf(6));
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
            jSONObject.put(LoginActivity.EXTRA_PARAM_USERNAME, str2);
            jSONObject.put("key", sapiDataEncryptor.getAESKey());
            httpHashMapWrap.put("userinfo", sapiDataEncryptor.encrypt(SapiDataEncryptor.Cert1.CERT, jSONObject.toString()));
            new HttpClientWrap().post(SapiEnv.FILL_UNAME, httpHashMapWrap, null, u(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.a.13
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onStart() {
                    fillUsernameCallback.onStart();
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onFinish() {
                    fillUsernameCallback.onFinish();
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onSuccess(int i, String str3) {
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
                                sapiAccount.ptoken = jSONObject3.optString("ptoken");
                                sapiAccount.stoken = jSONObject3.optString("stoken");
                                sapiAccount.displayname = jSONObject3.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                                sapiAccount.username = jSONObject3.optString("uname");
                                sapiAccount.uid = jSONObject3.optString("uid");
                                sapiAccount.app = SapiUtils.getAppName(a.this.c.context);
                                sapiAccount.addDispersionCertification(SapiAccount.DispersionCertification.fromJSONObject(jSONObject3).tplStokenMap);
                                sapiAccount.putExtra("tpl", a.this.c.tpl);
                                com.baidu.sapi2.share.a.a().a(sapiAccount);
                                fillUsernameResult.session = sapiAccount;
                                fillUsernameCallback.onSuccess(fillUsernameResult);
                                new PtokenStat().onEvent(PtokenStat.FILLNAME_WIDGE);
                                break;
                            case 160103:
                                fillUsernameCallback.onBdussExpired(fillUsernameResult);
                                break;
                            case FillUsernameResult.RESULT_CODE_USER_HAVE_USERNAME /* 160104 */:
                                fillUsernameCallback.onUserHaveUsername(fillUsernameResult);
                                break;
                            default:
                                fillUsernameCallback.onFailure(fillUsernameResult);
                                break;
                        }
                    } catch (Throwable th) {
                        fillUsernameCallback.onFailure(fillUsernameResult);
                        Log.e(th);
                    }
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onFailure(Throwable th, int i, String str3) {
                    fillUsernameResult.setResultCode(i);
                    fillUsernameCallback.onFailure(fillUsernameResult);
                }
            });
        } catch (Throwable th) {
            fillUsernameResult.setResultCode(-202);
            fillUsernameCallback.onFailure(fillUsernameResult);
            Log.e(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(String str, List<String> list) {
        SapiUtils.notEmpty(str, "bduss can't be empty");
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
    public Map<String, String> a(final GetTplStokenCallback getTplStokenCallback, String str, final List<String> list, final boolean z) {
        SapiUtils.notNull(getTplStokenCallback, GetTplStokenCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        final GetTplStokenResult getTplStokenResult = new GetTplStokenResult();
        if (list == null || list.isEmpty()) {
            getTplStokenResult.setResultCode(-302);
            getTplStokenResult.setResultMsg(SapiResult.ERROR_MSG_PARAMS_ERROR);
            getTplStokenCallback.onFailure(getTplStokenResult);
            return getTplStokenResult.tplStokenMap;
        }
        final SapiAccount accountFromBduss = SapiContext.getInstance(this.c.context).getAccountFromBduss(str);
        if (accountFromBduss == null) {
            getTplStokenResult.setResultCode(-301);
            getTplStokenCallback.onFailure(getTplStokenResult);
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
                    getTplStokenResult.setResultMsg(SapiResult.RESULT_MSG_SUCCESS);
                    getTplStokenCallback.onSuccess(getTplStokenResult);
                    return getTplStokenResult.tplStokenMap;
                }
            } catch (JSONException e) {
                Log.e(e);
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
            getTplStokenResult.setResultCode(-305);
            getTplStokenResult.failureType = GetTplStokenResult.FailureType.PTOKEN_EMPTY;
            getTplStokenCallback.onFailure(getTplStokenResult);
        }
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("bduss", str);
        httpHashMapWrap.put("sign", MD5Util.toMd5((this.c.appId + this.c.tpl + str + this.c.appSignKey).getBytes(), false));
        httpHashMapWrap.put("return_type", "1");
        if (!TextUtils.isEmpty(str2)) {
            httpHashMapWrap.put("ptoken", str2);
        }
        httpHashMapWrap.put("tpl_list", str3);
        new HttpClientWrap().post(SapiEnv.GET_STOKEN_URI, httpHashMapWrap, null, u(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.a.14
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onStart() {
                getTplStokenCallback.onStart();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFinish() {
                getTplStokenCallback.onFinish();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i2, String str5) {
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
                                return;
                            }
                            getTplStokenResult.setResultCode(-306);
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
                    Log.e(e2);
                    if (!TextUtils.isEmpty(str2)) {
                        getTplStokenResult.setResultCode(-205);
                        getTplStokenCallback.onFailure(getTplStokenResult);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i2, String str5) {
                if (!TextUtils.isEmpty(str2)) {
                    getTplStokenResult.setResultCode(i2);
                    getTplStokenCallback.onFailure(getTplStokenResult);
                }
            }
        });
        return getTplStokenResult.tplStokenMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final SapiCallback<OAuthResult> sapiCallback, String str, String str2) {
        SapiUtils.notNull(sapiCallback, SapiCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        final OAuthResult oAuthResult = new OAuthResult();
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        if (!TextUtils.isEmpty(str2)) {
            httpHashMapWrap.put("openPlatformId", str2);
        }
        httpHashMapWrap.put("bduss", str);
        new HttpClientWrap().post(SapiEnv.OAUTH_URI, httpHashMapWrap, null, u(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.a.15
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onStart() {
                sapiCallback.onStart();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFinish() {
                sapiCallback.onFinish();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i, String str3) {
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
                            break;
                        default:
                            sapiCallback.onFailure(oAuthResult);
                            break;
                    }
                } catch (Throwable th) {
                    oAuthResult.setResultCode(-202);
                    sapiCallback.onFailure(oAuthResult);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str3) {
                oAuthResult.setResultCode(i);
                sapiCallback.onFailure(oAuthResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(final SapiCallBack<SapiResponse> sapiCallBack, String str) {
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
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.put(LoginActivity.EXTRA_PARAM_USERNAME, str);
            new HttpClientWrap().post(SapiEnv.GET_DYNAMIC_PWD_URI, httpHashMapWrap, null, u(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.a.16
                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onSuccess(int i, String str2) {
                    a.this.b(sapiCallBack, str2);
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onFailure(Throwable th, int i, String str2) {
                    if (i == -203) {
                        sapiCallBack.onSystemError(i);
                    } else {
                        a.this.b(sapiCallBack, str2);
                    }
                }
            });
            return true;
        }
    }

    void b(SapiCallBack<SapiResponse> sapiCallBack, String str) {
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

    HttpHashMapWrap a(String str) {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        String deviceInfo = SapiDeviceInfo.getDeviceInfo(str);
        if (!TextUtils.isEmpty(deviceInfo)) {
            httpHashMapWrap.put(AppIconSetting.DEFAULT_LARGE_ICON, deviceInfo);
        }
        httpHashMapWrap.put("clientfrom", "mobilesdk_enhanced");
        httpHashMapWrap.put(SapiContext.KEY_SDK_VERSION, "3");
        return httpHashMapWrap;
    }

    private String u() {
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
                SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() { // from class: com.baidu.sapi2.a.17
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
    public void a(final IqiyiLoginCallback iqiyiLoginCallback, IqiyiLoginDTO iqiyiLoginDTO, final IqiyiLoginResult iqiyiLoginResult) {
        if (TextUtils.isEmpty(iqiyiLoginDTO.accessToken) || TextUtils.isEmpty(iqiyiLoginDTO.openID)) {
            iqiyiLoginCallback.onLogin(iqiyiLoginResult);
            return;
        }
        HttpHashMapWrap a2 = a(p());
        if (!TextUtils.isEmpty(iqiyiLoginDTO.phoneNum)) {
            a2.put("crypt_m", iqiyiLoginDTO.phoneNum);
        }
        a2.put("access_token", iqiyiLoginDTO.accessToken);
        a2.put("osuid", iqiyiLoginDTO.openID);
        a2.put("json", "1");
        a2.put("type", SocialType.IQIYI.getType() + "");
        a2.put(SocialConstants.PARAM_ACT, "special");
        a2.put("display", "native");
        new HttpClientWrap().get(p(), a2, null, u(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.a.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onStart() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFinish() {
                iqiyiLoginCallback.onFinish();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i, String str) {
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
                        a3.putExtra("tpl", a.this.c.tpl);
                        com.baidu.sapi2.share.a.a().a(a3);
                        iqiyiLoginCallback.onSuccess(iqiyiLoginResult);
                        return;
                    }
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    iqiyiLoginResult.nextUrl = jSONObject.optString("next_url");
                    iqiyiLoginCallback.onBindWebview(iqiyiLoginResult);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str) {
                iqiyiLoginResult.setResultCode(i);
                iqiyiLoginCallback.onFailure(iqiyiLoginResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.put("accesstoken", str);
            new HttpClientWrap().post(SapiEnv.GET_IQIYI_ACCOUNT_INFO_URI, httpHashMapWrap, null, u(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.a.3
                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onSuccess(int i, String str2) {
                    super.onSuccess(i, str2);
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onFailure(Throwable th, int i, String str2) {
                    super.onFailure(th, i, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final SapiCallback<CheckUserFaceIdResult> sapiCallback, String str, Map<String, String> map) {
        SapiUtils.notNull(sapiCallback, SapiCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        HttpHashMapWrap a2 = a(SapiEnv.CHECK_USER_FACE_ID);
        a2.put("clientfrom", "native");
        a2.put("bduss", str);
        if (map != null && !map.isEmpty()) {
            a2.putAll(map);
        }
        final CheckUserFaceIdResult checkUserFaceIdResult = new CheckUserFaceIdResult();
        new HttpClientWrap().post(SapiEnv.CHECK_USER_FACE_ID, a2, null, u(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.a.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onStart() {
                sapiCallback.onStart();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFinish() {
                sapiCallback.onFinish();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str2) {
                checkUserFaceIdResult.setResultCode(i);
                sapiCallback.onFailure(checkUserFaceIdResult);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i, String str2) {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                    checkUserFaceIdResult.setResultCode(parseInt);
                    checkUserFaceIdResult.setResultMsg(jSONObject.optString("errmsg"));
                    if (parseInt == 0) {
                        checkUserFaceIdResult.status = jSONObject.optInt("status");
                        checkUserFaceIdResult.livingUname = jSONObject.optString("livinguname");
                        checkUserFaceIdResult.authsid = jSONObject.optString("authsid");
                        checkUserFaceIdResult.authWidgetURL = jSONObject.optString("authurl");
                        sapiCallback.onSuccess(checkUserFaceIdResult);
                    } else {
                        sapiCallback.onFailure(checkUserFaceIdResult);
                    }
                } catch (Throwable th) {
                    checkUserFaceIdResult.setResultCode(-202);
                    sapiCallback.onFailure(checkUserFaceIdResult);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final SapiCallback<FaceLoginStatusResult> sapiCallback, String str) {
        SapiUtils.notNull(sapiCallback, SapiCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        HttpHashMapWrap a2 = a(SapiEnv.FACE_LOGIN_STATUS_CHECK);
        a2.put("clientfrom", "native");
        a2.put("bduss", str);
        final FaceLoginStatusResult faceLoginStatusResult = new FaceLoginStatusResult();
        new HttpClientWrap().post(SapiEnv.FACE_LOGIN_STATUS_CHECK, a2, null, u(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.a.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onStart() {
                sapiCallback.onStart();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFinish() {
                sapiCallback.onFinish();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str2) {
                faceLoginStatusResult.setResultCode(i);
                sapiCallback.onFailure(faceLoginStatusResult);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i, String str2) {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                    faceLoginStatusResult.setResultCode(parseInt);
                    faceLoginStatusResult.setResultMsg(jSONObject.optString("errmsg"));
                    if (parseInt == 0) {
                        faceLoginStatusResult.status = jSONObject.optInt("status");
                        faceLoginStatusResult.livingUname = jSONObject.optString("livinguname");
                        faceLoginStatusResult.authsid = jSONObject.optString("authsid");
                        faceLoginStatusResult.authWidgetURL = jSONObject.optString("authurl");
                        faceLoginStatusResult.faceLoginSwitch = jSONObject.optInt("faceLoginEnabled") == 1;
                        sapiCallback.onSuccess(faceLoginStatusResult);
                    } else {
                        sapiCallback.onFailure(faceLoginStatusResult);
                    }
                } catch (Throwable th) {
                    faceLoginStatusResult.setResultCode(-202);
                    sapiCallback.onFailure(faceLoginStatusResult);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final SapiCallback<SapiResult> sapiCallback, String str, final boolean z, String str2) {
        SapiUtils.notNull(sapiCallback, SapiCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        HttpHashMapWrap a2 = a(SapiEnv.FACE_LOGIN_STATUS_CHECK);
        if (z) {
            a2.put("action", "enable_face_login");
        } else {
            a2.put("action", "disable_face_login");
        }
        if (!TextUtils.isEmpty(str2)) {
            a2.put("callbackKey", str2);
        }
        a2.put("guidefrom", FaceBaseDTO.BUSINESS_SENCE_FACE_LOGIN_SWITCH);
        a2.put("clientfrom", "native");
        a2.put("bduss", str);
        final CheckUserFaceIdResult checkUserFaceIdResult = new CheckUserFaceIdResult();
        new HttpClientWrap().post(SapiEnv.FACE_LOGIN_SWITCH_URI, a2, null, u(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.a.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onStart() {
                sapiCallback.onStart();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFinish() {
                sapiCallback.onFinish();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str3) {
                checkUserFaceIdResult.setResultCode(i);
                sapiCallback.onFailure(checkUserFaceIdResult);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i, String str3) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                    checkUserFaceIdResult.setResultCode(parseInt);
                    checkUserFaceIdResult.setResultMsg(jSONObject.optString("errmsg"));
                    if (parseInt == 0) {
                        if (z) {
                            String optString = jSONObject.optString("livinguname");
                            if (!TextUtils.isEmpty(optString)) {
                                new b().a(a.this.c.context, optString);
                            }
                        }
                        sapiCallback.onSuccess(checkUserFaceIdResult);
                        return;
                    }
                    sapiCallback.onFailure(checkUserFaceIdResult);
                } catch (Throwable th) {
                    checkUserFaceIdResult.setResultCode(-202);
                    sapiCallback.onFailure(checkUserFaceIdResult);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(9)
    public void a(final com.baidu.sapi2.callback.a.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        }
        SapiAccount session = SapiAccountManager.getInstance().getSession();
        if (session != null) {
            final com.baidu.sapi2.result.a.a aVar2 = new com.baidu.sapi2.result.a.a();
            HttpHashMapWrap a2 = a(SapiEnv.PUSH_CHECK_URI);
            a2.put("clientfrom", "native");
            a2.put("bduss", session.bduss);
            a2.put("stoken", session.stoken);
            new HttpClientWrap().post(SapiEnv.PUSH_CHECK_URI, a2, null, u(), new HttpHandlerWrap(true) { // from class: com.baidu.sapi2.a.7
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onStart() {
                    aVar.onStart();
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onFinish() {
                    aVar.onFinish();
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onFailure(Throwable th, int i, String str) {
                    aVar2.setResultCode(i);
                    aVar.onFailure(aVar2);
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onSuccess(int i, String str) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                        aVar2.setResultCode(parseInt);
                        aVar2.setResultMsg(jSONObject.optString("errmsg"));
                        if (parseInt == 0) {
                            aVar2.a = jSONObject.optInt(Config.PUSH, 0) == 1;
                            aVar2.b = jSONObject.optString("url");
                            aVar2.c = jSONObject.optString("title");
                            aVar2.d = jSONObject.optString("msg");
                            aVar2.e = jSONObject.optInt("interval", 5);
                            aVar.onSuccess(aVar2);
                        } else {
                            aVar.onFailure(aVar2);
                        }
                    } catch (Throwable th) {
                        aVar2.setResultCode(-202);
                        aVar.onFailure(aVar2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.baidu.sapi2.a$8] */
    @SuppressLint({"NewApi"})
    public void a(final SsoHashCallback ssoHashCallback, final String str, final String str2) {
        SapiUtils.notNull(ssoHashCallback, "SsoHashCallback can't be null");
        new AsyncTask<String, Void, Long>() { // from class: com.baidu.sapi2.a.8
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public Long doInBackground(String... strArr) {
                try {
                    URLConnection openConnection = new URL(strArr[0]).openConnection();
                    openConnection.setConnectTimeout(3000);
                    openConnection.connect();
                    return Long.valueOf(openConnection.getDate() / 1000);
                } catch (Exception e) {
                    Log.e(e);
                    return 0L;
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: a */
            public void onPostExecute(Long l) {
                SsoHashResult ssoHashResult = new SsoHashResult();
                ssoHashResult.ssoHash = new com.baidu.sapi2.utils.a().a(l, str, str2);
                ssoHashResult.setResultCode(0);
                ssoHashCallback.onSuccess(ssoHashResult);
            }
        }.execute(SapiEnv.HASH_TIMESTAMP_URL);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(final SapiCallback<SapiResult> sapiCallback, String str, String str2) {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("open_appid", str);
        httpHashMapWrap.put("open_apikey", str2);
        httpHashMapWrap.put("time", System.currentTimeMillis() + "");
        final SapiResult sapiResult = new SapiResult();
        new HttpClientWrap().post(SapiEnv.EXTEND_SYS_WEBVIEW_METHOD_CHECK, httpHashMapWrap, null, u(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.a.9
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onStart() {
                sapiCallback.onStart();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFinish() {
                sapiCallback.onFinish();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i, String str3) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    sapiResult.setResultCode(jSONObject.optInt("errno"));
                    sapiResult.setResultMsg(jSONObject.optString("errmsg"));
                } catch (JSONException e) {
                    Log.e(e);
                }
                if (sapiResult.getResultCode() == 0) {
                    sapiCallback.onSuccess(sapiResult);
                } else {
                    sapiCallback.onFailure(sapiResult);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str3) {
                sapiResult.setResultCode(i);
                sapiResult.setResultMsg(str3);
                sapiCallback.onFailure(sapiResult);
            }
        });
    }

    SapiAccount a(JSONObject jSONObject) {
        SapiAccount sapiAccount = new SapiAccount();
        sapiAccount.uid = jSONObject.optString("uid");
        sapiAccount.bduss = jSONObject.optString("bduss");
        sapiAccount.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
        sapiAccount.username = jSONObject.optString("uname");
        sapiAccount.stoken = jSONObject.optString("stoken");
        sapiAccount.ptoken = jSONObject.optString("ptoken");
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

    private Domain v() {
        return this.c.environment;
    }

    private String w() {
        return "/sslcrypt/get_last_cert";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        return v().getWap() + "/v3/login/api/login";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() {
        return v().getWap() + "/passport/login";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d() {
        return v().getWap() + "/passport/getpass";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String e() {
        return v().getWap() + "/wp/wappassword";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String f() {
        return v().getWap() + "/wp/recordindex";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String g() {
        return v().getWap() + "/v2/?bindingaccount&";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String h() {
        return v().getWap() + "/v2/?bindingret";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(BindWidgetAction bindWidgetAction) {
        return v().getWap() + bindWidgetAction.getUri();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String i() {
        return v().getWap() + "/wp/unitewidget";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String j() {
        return v().getWap() + "/wp/v3/ucenter/index";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String k() {
        return v().getWap() + "/v4/security";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String l() {
        return v().getWap() + "/wp/v3/ucenter/realnameverify";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String m() {
        return v().getURL() + SapiEnv.NORMALIZE_GUEST_ACCOUNT_URI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String n() {
        return v().getWap() + "/v6/shippingAddress";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String o() {
        return v().getWap() + "/v6/invoiceManage";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String p() {
        return v().getURL() + "/phoenix/account/ssologin";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String q() {
        return v().getURL() + "/phoenix/account/ssologin";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String r() {
        return v().getURL() + SapiEnv.SOCIAL_START_URI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String s() {
        return v().getURL() + SapiEnv.SOCIAL_AFTER_AUTH_URI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String t() {
        return v().getURL() + SapiEnv.SOCIAL_FINISH_AUTH_URI;
    }
}
