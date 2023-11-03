package com.baidu.sapi2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.pass.http.HttpHashMap;
import com.baidu.pass.http.ReqPriority;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.callback.FillUsernameCallback;
import com.baidu.sapi2.callback.GetCertStatusCallback;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.GetUserAttrInfoCallback;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.callback.IqiyiLoginCallback;
import com.baidu.sapi2.callback.IsShowRealNameCallback;
import com.baidu.sapi2.callback.LoginWithUCAuthCallback;
import com.baidu.sapi2.callback.NetCallback;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.callback.SsoHashCallback;
import com.baidu.sapi2.callback.UserLogoutCallback;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.callback.inner.ExecuteJsCallback;
import com.baidu.sapi2.callback.inner.GetOnlineAppCallback;
import com.baidu.sapi2.callback.inner.GetShareV3AppCallback;
import com.baidu.sapi2.callback.inner.LoadExternalWebViewActivityCallback;
import com.baidu.sapi2.callback.inner.LoginHistoryCallback;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.sapi2.dto.IqiyiLoginDTO;
import com.baidu.sapi2.dto.IsShowRealNameGuideDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.result.CheckUserFaceIdResult;
import com.baidu.sapi2.result.FaceLoginStatusResult;
import com.baidu.sapi2.result.FillUsernameResult;
import com.baidu.sapi2.result.GetCertStatusResult;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.GetUserAttrInfoResult;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.result.IqiyiLoginResult;
import com.baidu.sapi2.result.IsShowRealNameGuideResult;
import com.baidu.sapi2.result.LoginWithUCAuthResult;
import com.baidu.sapi2.result.OAuthResult;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.SsoHashResult;
import com.baidu.sapi2.result.Web2NativeLoginResult;
import com.baidu.sapi2.share.GetOnlineRequestShareModel;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.ShareUtils;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.shell.callback.SapiCallBack;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SapiResponse;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.stat.OneKeyLoginStat;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.sapi2.utils.GetTplStokenStat;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.PtokenStat;
import com.baidu.sapi2.utils.SapiCoreUtil;
import com.baidu.sapi2.utils.SapiDataEncryptor;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiDeviceUtils;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.Security;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.sapi2.views.logindialog.view.a;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tieba.external.music.data.MusicData;
import com.baidu.tieba.zj1;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.fun.ad.sdk.FunAdSdk;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.yy.sdk.crashreportbaidu.ActivityHistory;
import java.io.UnsupportedEncodingException;
import java.net.HttpCookie;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.security.cert.CertificateException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class SapiAccountRepository {
    public static final String API_V3 = "3";
    public static final int SSL_AES = 6;
    public static final String TAG = "SapiAccountRepository";
    public SapiConfiguration configuration = SapiAccountManager.getInstance().getSapiConfiguration();

    /* loaded from: classes3.dex */
    public interface OneKeyRequestJsCallback {
        void failure(int i, String str);

        void success();
    }

    private String getLastCert() {
        return "/sslcrypt/get_last_cert";
    }

    private String getUserAttrInfoUrl() {
        return SapiEnv.GET_USER_ATTR_INFO;
    }

    public void cancelRequest() {
    }

    private String getAppUc2PassLoginUrl() {
        return this.configuration.environment.getWap() + SapiEnv.APP_UC_PASS_LOGIN;
    }

    private String getCheckAvailableLoginHistoryUrl() {
        return getDomain().getWap() + "/v3/api/login/historylist";
    }

    private Domain getDomain() {
        return this.configuration.environment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getUaInfo() {
        return "tpl:" + this.configuration.tpl + ";android_sapi_v9.7.5.1";
    }

    public String getAcccountCenterUrl() {
        return getDomain().getWap() + "/wp/v3/ucenter/index";
    }

    public String getAccountCenterCheckUrl() {
        return getDomain().getWap() + "/v6/safetyInspection";
    }

    public String getAccountRealNameUrl() {
        return getDomain().getWap() + "/wp/v3/ucenter/realnameverify";
    }

    public String getAuthWidgetUrl() {
        return getDomain().getWap() + "/v6/authwidget";
    }

    public String getCertGuardUrl() {
        return getDomain().getWap() + "/static/manage-chunk/guardian-cert.html";
    }

    public String getCertStatusUrl() {
        return getDomain().getWap() + SapiEnv.GET_CERT_STATUS;
    }

    public String getChangeUsername() {
        return getDomain().getWap() + "/static/manage-chunk/change-username.html";
    }

    public String getChildVerifyUrl() {
        return getDomain().getWap() + SapiEnv.CHILD_VERIFY;
    }

    public String getContactAddressUrl() {
        return getDomain().getWap() + "/v6/shippingAddress";
    }

    public String getDomainAfterAuth() {
        return getDomain().getURL() + SapiEnv.SOCIAL_AFTER_AUTH_URI;
    }

    public String getDomainFinishBind() {
        return getDomain().getURL() + SapiEnv.SOCIAL_FINISH_AUTH_URI;
    }

    public String getDomainSSOFinish() {
        return getDomain().getURL() + "/phoenix/account/ssologin";
    }

    public String getDomainSSOSecondcard() {
        return getDomain().getURL() + SapiEnv.SSO_SECONDCARD_URI;
    }

    public String getDomainSSOStart() {
        return getDomain().getURL() + "/phoenix/account/ssologin";
    }

    public String getDoubleListUrl() {
        return getDomain().getWap() + "/static/manage-chunk/account-info.html";
    }

    public String getExplainCameraDeatilUrl() {
        return getDomain().getWap() + SapiEnv.EXPLAIN_CAMERA_DETAIL;
    }

    public String getInvoiceAddressUrl() {
        return getDomain().getWap() + "/v6/invoiceManage";
    }

    public String getIsShowRealNameGuideUrl() {
        return getDomain().getURL() + SapiEnv.IS_SHOW_REAL_NAME_GUIDE;
    }

    public String getLoadOneKeyLoginUrl() {
        return getDomain().getWap() + SapiEnv.LOAD_ONE_KEY_LOGIN;
    }

    public String getNormalizeGuestAccountUrl() {
        return getDomain().getURL() + SapiEnv.NORMALIZE_GUEST_ACCOUNT_URI;
    }

    public String getOneKeyLoginAbilityUrl() {
        return getDomain().getWap() + SapiEnv.ONE_KEY_LOGIN_ABILITY;
    }

    public String getOnlineAppUrl() {
        return getDomain().getURL() + SapiEnv.SHARE_LOGIN_GET_ONLINE_APP;
    }

    public String getShareV3AppUrl() {
        return getDomain().getURL() + SapiEnv.CLOUD_SHARE_V3_APP;
    }

    public String getSwitchAccountUrl() {
        return getDomain().getWap() + SapiEnv.SWITCH_ACCOUNT;
    }

    public String getUniteVerifyUrl() {
        return getDomain().getWap() + "/wp/unitewidget";
    }

    public String getUserLogoutUrl() {
        return getDomain().getURL() + SapiEnv.USER_LOGOUT;
    }

    public String getWapForgetPwdUrl() {
        return getDomain().getWap() + "/passport/getpass";
    }

    public String getWapLoginUrl() {
        return getDomain().getWap() + "/passport/login";
    }

    public String getWapShareLoginUrl() {
        return getDomain().getWap() + "/v3/login/api/login";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOneKeyLoginCookies(HashMap<String, String> hashMap) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair(this.configuration.environment.getWap(), hashMap.get("HISTORY")));
        SapiUtils.syncCookies(this.configuration.context, arrayList);
    }

    public HttpHashMapWrap buildSapiParams(String str) {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        String deviceInfo = SapiDeviceInfo.getDeviceInfo(str);
        if (!TextUtils.isEmpty(deviceInfo)) {
            httpHashMapWrap.put(AppIconSetting.DEFAULT_LARGE_ICON, deviceInfo);
        }
        httpHashMapWrap.put("clientfrom", "mobilesdk_enhanced");
        httpHashMapWrap.put("sdk_version", "3");
        return httpHashMapWrap;
    }

    public String getBindWidgetUrl(BindWidgetAction bindWidgetAction) {
        return getDomain().getWap() + bindWidgetAction.getUri();
    }

    public void getCertStatus(final GetCertStatusCallback getCertStatusCallback) {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        String certStatusUrl = getCertStatusUrl();
        List<HttpCookie> buildNaCookie = ParamsUtil.buildNaCookie(certStatusUrl, this.configuration);
        buildNaCookie.addAll(ParamsUtil.buildLoginStatusCookie(certStatusUrl, this.configuration));
        new HttpClientWrap().post(certStatusUrl, ReqPriority.IMMEDIATE, httpHashMapWrap, buildNaCookie, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.SapiAccountRepository.20
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str) {
                GetCertStatusResult getCertStatusResult = new GetCertStatusResult();
                getCertStatusResult.setResultCode(i);
                getCertStatusResult.setResultMsg(str);
                getCertStatusCallback.onFailure(getCertStatusResult);
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i, String str) {
                GetCertStatusResult getCertStatusResult = new GetCertStatusResult();
                if (i != 200) {
                    getCertStatusResult.setResultCode(-202);
                    getCertStatusResult.setResultMsg("网络连接失败，请检查网络设置");
                    getCertStatusCallback.onFailure(getCertStatusResult);
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("code");
                    if (optInt != 50000) {
                        if (optInt != 110000) {
                            if (optInt != 400021) {
                                getCertStatusResult.setResultCode(-801);
                                getCertStatusResult.setResultMsg("服务异常，请稍后再试");
                                getCertStatusCallback.onFailure(getCertStatusResult);
                            } else {
                                getCertStatusResult.setResultCode(400021);
                                getCertStatusResult.setResultMsg("当前用户不在线");
                                getCertStatusCallback.onFailure(getCertStatusResult);
                            }
                        } else {
                            getCertStatusResult = GetCertStatusResult.parseFromJSONObject(jSONObject.optJSONObject("data"));
                            if (getCertStatusResult.getResultCode() == 110000) {
                                getCertStatusCallback.onSuccess(getCertStatusResult);
                            } else {
                                getCertStatusCallback.onFailure(getCertStatusResult);
                            }
                        }
                    } else {
                        getCertStatusResult.setResultCode(50000);
                        getCertStatusResult.setResultMsg(GetCertStatusResult.MESSAGE_BUSINESS_RESULT_RISK_CONTROL);
                        getCertStatusCallback.onFailure(getCertStatusResult);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    getCertStatusResult.setResultCode(-205);
                    getCertStatusResult.setResultMsg("服务端数据异常，请稍后再试");
                    getCertStatusCallback.onFailure(getCertStatusResult);
                }
            }
        });
    }

    public int getErrorCode(String str) {
        try {
            return new JSONObject(str).getInt("errno");
        } catch (Exception e) {
            Log.e(e);
            return -100;
        }
    }

    public SapiAccount responseToAccount(SapiAccountResponse sapiAccountResponse) {
        SapiAccount sapiAccount = new SapiAccount();
        sapiAccount.displayname = sapiAccountResponse.displayname;
        sapiAccount.bduss = sapiAccountResponse.bduss;
        sapiAccount.ptoken = sapiAccountResponse.ptoken;
        sapiAccount.stoken = sapiAccountResponse.stoken;
        sapiAccount.uid = sapiAccountResponse.uid;
        sapiAccount.username = sapiAccountResponse.username;
        sapiAccount.app = SapiUtils.getAppName(this.configuration.context);
        return sapiAccount;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getAccessTokenCacheKey(String str, String str2) {
        return new String(Base64.encode((str + str2).getBytes(), 0));
    }

    public void getUserInfo(GetUserInfoCallback getUserInfoCallback, String str) {
        getUserInfo(getUserInfoCallback, str, "", "");
    }

    public boolean isStokenExist(String str, List<String> list) {
        SapiUtils.notEmpty(str, "bduss can't be empty");
        if (list != null && !list.isEmpty()) {
            return isAccountStokenExist(SapiContext.getInstance().getAccountFromBduss(str), list);
        }
        throw new IllegalArgumentException("targetTplList can't be null or empty");
    }

    @SuppressLint({"NewApi"})
    public void generateSsoHash(final SsoHashCallback ssoHashCallback, final String str, final String str2) {
        SapiUtils.notNull(ssoHashCallback, "SsoHashCallback can't be null");
        new AsyncTask<String, Void, Long>() { // from class: com.baidu.sapi2.SapiAccountRepository.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.AsyncTask
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
            @Override // android.os.AsyncTask
            public void onPostExecute(Long l) {
                SsoHashResult ssoHashResult = new SsoHashResult();
                ssoHashResult.ssoHash = new Security().encryptSsoHash(l, str, str2);
                ssoHashResult.setResultCode(0);
                ssoHashCallback.onSuccess(ssoHashResult);
            }
        }.execute(SapiEnv.HASH_TIMESTAMP_URL);
    }

    public void getUserInfo(GetUserInfoCallback getUserInfoCallback, String str, String str2) {
        getUserInfo(getUserInfoCallback, str, str2, "", "");
    }

    public void oauthAccessToken(SapiCallback<OAuthResult> sapiCallback, String str, String str2) {
        OAuthResult cachedOauthResult = getCachedOauthResult(str, str2);
        if (cachedOauthResult != null) {
            sapiCallback.onSuccess(cachedOauthResult);
        } else {
            oauth(sapiCallback, str, str2, null);
        }
    }

    private void requestFirstJsCode(String str, final String str2, String str3, final OneKeyRequestJsCallback oneKeyRequestJsCallback) {
        new HttpClientWrap().get(str, ReqPriority.IMMEDIATE, new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.SapiAccountRepository.22
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str4) {
                OneKeyRequestJsCallback oneKeyRequestJsCallback2 = oneKeyRequestJsCallback;
                if (oneKeyRequestJsCallback2 != null) {
                    oneKeyRequestJsCallback2.failure(-105, "");
                }
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i, String str4) {
                String md5 = SecurityUtil.md5(str4.getBytes(), false);
                String str5 = str2;
                if (str5 != null && str5.equals(md5)) {
                    SapiContext.getInstance().setOneKeyLoginJSCode(str4);
                    SapiContext.getInstance().setOnekeyLoginJsMd5(str2);
                    OneKeyRequestJsCallback oneKeyRequestJsCallback2 = oneKeyRequestJsCallback;
                    if (oneKeyRequestJsCallback2 != null) {
                        oneKeyRequestJsCallback2.success();
                        return;
                    }
                    return;
                }
                OneKeyRequestJsCallback oneKeyRequestJsCallback3 = oneKeyRequestJsCallback;
                if (oneKeyRequestJsCallback3 != null) {
                    oneKeyRequestJsCallback3.failure(-106, "");
                }
                Log.d(SapiAccountRepository.TAG, "oneKeyLogin check javsScript MD5 failed");
            }
        });
    }

    public void loadOneKeyLogin(OneKeyLoginCallback oneKeyLoginCallback, String str, String str2, LoadExternalWebViewActivityCallback loadExternalWebViewActivityCallback) {
        loadOneKeyLogin(oneKeyLoginCallback, str, str2, true, loadExternalWebViewActivityCallback);
    }

    public void getUserInfo(final GetUserInfoCallback getUserInfoCallback, String str, String str2, String str3, String str4) {
        SapiUtils.notNull(getUserInfoCallback, GetUserInfoCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        getUserInfo(str, str2, str3, str4, new NetCallback() { // from class: com.baidu.sapi2.SapiAccountRepository.4
            @Override // com.baidu.sapi2.callback.NetCallback
            public void onFailure(Throwable th, int i, String str5) {
                GetUserInfoResult getUserInfoResult = new GetUserInfoResult();
                getUserInfoResult.setResultCode(i);
                getUserInfoCallback.onFailure(getUserInfoResult);
            }

            @Override // com.baidu.sapi2.callback.NetCallback
            public void onSuccess(int i, String str5) {
                GetUserInfoResult getUserInfoResult = new GetUserInfoResult();
                int errorCode = SapiAccountRepository.this.getErrorCode(str5);
                getUserInfoResult.setResultCode(errorCode);
                if (errorCode != 0) {
                    if (errorCode != 400021) {
                        getUserInfoCallback.onFailure(getUserInfoResult);
                        return;
                    } else {
                        getUserInfoCallback.onBdussExpired(getUserInfoResult);
                        return;
                    }
                }
                try {
                    JSONObject jSONObject = new JSONObject(str5);
                    String optString = jSONObject.optString("portrait_tag");
                    getUserInfoResult.portraitSign = optString;
                    getUserInfoResult.isInitialPortrait = "0".equals(optString);
                    String optString2 = jSONObject.optString("portrait");
                    if (!TextUtils.isEmpty(optString2)) {
                        getUserInfoResult.portrait = String.format("http://himg.bdimg.com/sys/portrait/item/%s.jpg?%s", optString2, getUserInfoResult.portraitSign);
                        getUserInfoResult.portraitHttps = String.format("https://himg.bdimg.com/sys/portrait/item/%s.jpg?%s", optString2, getUserInfoResult.portraitSign);
                    }
                    getUserInfoResult.username = jSONObject.optString("username");
                    getUserInfoResult.uid = jSONObject.optString(DpStatConstants.KEY_USER_ID);
                    getUserInfoResult.displayname = jSONObject.optString("displayname");
                    getUserInfoResult.incompleteUser = "1".equals(jSONObject.optString("incomplete_user"));
                    getUserInfoResult.secureMobile = jSONObject.optString("securemobil");
                    getUserInfoResult.secureEmail = jSONObject.optString("secureemail");
                    getUserInfoResult.havePwd = "1".equals(jSONObject.optString("have_psw"));
                    getUserInfoResult.carSdkFace = jSONObject.optInt("carSdkFace");
                    getUserInfoResult.faceLoginSwitch = jSONObject.optInt("faceLoginSwitch");
                    getUserInfoCallback.onSuccess(getUserInfoResult);
                } catch (Exception unused) {
                    getUserInfoCallback.onFailure(getUserInfoResult);
                }
            }
        });
    }

    public static String calculateSig(Map<String, String> map, String str) {
        map.remove(FunAdSdk.PLATFORM_SIG);
        ArrayList arrayList = new ArrayList();
        for (String str2 : map.keySet()) {
            arrayList.add(str2);
        }
        Collections.sort(arrayList);
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            try {
                String str4 = map.get(str3);
                if (!TextUtils.isEmpty(str4)) {
                    sb.append(str3);
                    sb.append("=");
                    sb.append(URLEncoder.encode(str4, "UTF-8"));
                    sb.append("&");
                }
            } catch (UnsupportedEncodingException e) {
                com.baidu.pass.biometrics.base.debug.Log.e(e);
            }
        }
        sb.append("sign_key=");
        sb.append(str);
        return SecurityUtil.md5(sb.toString().getBytes(), false);
    }

    private OAuthResult getCachedOauthResult(String str, String str2) {
        JSONObject jSONObject;
        String string = SapiContext.getInstance().getString(getAccessTokenCacheKey(str, str2));
        try {
            jSONObject = new JSONObject(string);
        } catch (JSONException e) {
            String str3 = TAG;
            Log.e(str3, "formatOauthResult: " + e.getMessage());
            jSONObject = null;
        }
        if (jSONObject != null) {
            OAuthResult formatOauthResult = formatOauthResult(jSONObject);
            if (System.currentTimeMillis() / 1000 < jSONObject.optLong("cachedTimeSecond", 0L) + formatOauthResult.expiresIn) {
                String str4 = TAG;
                Log.d(str4, "getCachedOauthResult result: " + string);
                return formatOauthResult;
            }
        }
        return null;
    }

    public void checkFaceLoginStatus(final SapiCallback<FaceLoginStatusResult> sapiCallback, String str) {
        SapiAccount currentAccount;
        if (SapiContext.getInstance().getSapiOptions().getOpenBdussTpls().contains(SapiAccountManager.getInstance().getConfignation().tpl) && (currentAccount = SapiContext.getInstance().getCurrentAccount()) != null) {
            str = currentAccount.bduss;
        }
        SapiUtils.notNull(sapiCallback, SapiCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        HttpHashMapWrap buildSapiParams = buildSapiParams(SapiEnv.FACE_LOGIN_STATUS_CHECK);
        buildSapiParams.put("clientfrom", "native");
        buildSapiParams.put("bduss", str);
        final FaceLoginStatusResult faceLoginStatusResult = new FaceLoginStatusResult();
        new HttpClientWrap().post(SapiEnv.FACE_LOGIN_STATUS_CHECK, buildSapiParams, null, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.SapiAccountRepository.13
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str2) {
                faceLoginStatusResult.setResultCode(i);
                sapiCallback.onFailure(faceLoginStatusResult);
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFinish() {
                sapiCallback.onFinish();
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onStart() {
                sapiCallback.onStart();
            }

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
                        FaceLoginStatusResult faceLoginStatusResult2 = faceLoginStatusResult;
                        boolean z = true;
                        if (jSONObject.optInt("faceLoginEnabled") != 1) {
                            z = false;
                        }
                        faceLoginStatusResult2.faceLoginSwitch = z;
                        sapiCallback.onSuccess(faceLoginStatusResult);
                    } else {
                        sapiCallback.onFailure(faceLoginStatusResult);
                    }
                } catch (Throwable unused) {
                    faceLoginStatusResult.setResultCode(-202);
                    sapiCallback.onFailure(faceLoginStatusResult);
                }
            }
        });
    }

    public void setCloudShareAccount(final int i, ShareStorage.StorageModel storageModel) {
        SapiAccount currentAccount;
        if (!SapiContext.getInstance().getSapiOptions().gray.getGrayModuleByFunName(SapiOptions.Gray.FUN_NAME_SHARE_V3).meetGray) {
            return;
        }
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        if (i != 2) {
            if (i != 3) {
                if (i != 4) {
                    return;
                }
                httpHashMapWrap.put("cmd", "reset");
            } else {
                httpHashMapWrap.put("cmd", "delete");
            }
        } else {
            httpHashMapWrap.put("cmd", "insert");
        }
        if (i == 2 && storageModel.flag == 0 && (currentAccount = SapiContext.getInstance().getCurrentAccount()) != null) {
            httpHashMapWrap.put("bduss", currentAccount.bduss);
            httpHashMapWrap.put("ptoken", currentAccount.ptoken);
            httpHashMapWrap.put("stoken", currentAccount.stoken);
        }
        httpHashMapWrap.put("app", SapiUtils.getAppName(this.configuration.context));
        httpHashMapWrap.put("pkg", this.configuration.context.getPackageName());
        new HttpClientWrap().post(SapiEnv.CLOUND_SHARE_ACCOUNT, ReqPriority.IMMEDIATE, httpHashMapWrap, new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.SapiAccountRepository.24
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i2, String str) {
                SapiStatUtil.statSetCloudShareAccount(i, 2);
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onStart() {
                Log.d(SapiAccountRepository.TAG, "set clound share account start");
                SapiStatUtil.statSetCloudShareAccount(i, 0);
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i2, String str) {
                try {
                    if (new JSONObject(str).optInt("code") == 110000) {
                        SapiStatUtil.statSetCloudShareAccount(i, 1);
                        return;
                    }
                } catch (Exception e) {
                    Log.e(e);
                }
                SapiStatUtil.statSetCloudShareAccount(i, 2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public OAuthResult formatOauthResult(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        OAuthResult oAuthResult = new OAuthResult();
        try {
            oAuthResult.setResultCode(Integer.parseInt(jSONObject.optString("errno")));
        } catch (Exception e) {
            String str = TAG;
            Log.e(str, "formatOauthResult parseInt: " + e.getMessage());
        }
        oAuthResult.accessToken = jSONObject.optString("access_token");
        oAuthResult.expiresIn = jSONObject.optInt("expires_in");
        oAuthResult.scope = jSONObject.optString("scope");
        oAuthResult.refreshToken = jSONObject.optString("refresh_token");
        oAuthResult.sessionKey = jSONObject.optString("session_key");
        oAuthResult.sessionSecret = jSONObject.optString("session_secret");
        oAuthResult.extra = jSONObject.optString("extra");
        oAuthResult.openid = jSONObject.optString("openid");
        return oAuthResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getThroughServer(final IqiyiLoginCallback iqiyiLoginCallback, IqiyiLoginDTO iqiyiLoginDTO, final IqiyiLoginResult iqiyiLoginResult) {
        if (!TextUtils.isEmpty(iqiyiLoginDTO.accessToken) && !TextUtils.isEmpty(iqiyiLoginDTO.openID)) {
            HttpHashMapWrap buildSapiParams = buildSapiParams(getDomainSSOStart());
            if (!TextUtils.isEmpty(iqiyiLoginDTO.phoneNum)) {
                buildSapiParams.put("crypt_m", iqiyiLoginDTO.phoneNum);
            }
            buildSapiParams.put("access_token", iqiyiLoginDTO.accessToken);
            buildSapiParams.put("osuid", iqiyiLoginDTO.openID);
            buildSapiParams.put("json", "1");
            buildSapiParams.put("type", SocialType.IQIYI.getType() + "");
            buildSapiParams.put("act", "special");
            buildSapiParams.put(CriusAttrConstants.DISPLAY, "native");
            new HttpClientWrap().get(getDomainSSOStart(), ReqPriority.IMMEDIATE, buildSapiParams, null, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.SapiAccountRepository.11
                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onStart() {
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onFailure(Throwable th, int i, String str) {
                    iqiyiLoginResult.setResultCode(i);
                    iqiyiLoginCallback.onFailure(iqiyiLoginResult);
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onFinish() {
                    iqiyiLoginCallback.onFinish();
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onSuccess(int i, String str) {
                    if (SapiAccountRepository.this.getErrorCode(str) == 302) {
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
                    SocialResponse parseOpenApiAuthorizedResult = SapiWebView.parseOpenApiAuthorizedResult(str, SapiAccountRepository.this.configuration.context);
                    if (parseOpenApiAuthorizedResult == null) {
                        iqiyiLoginResult.setResultCode(-100);
                        iqiyiLoginResult.setResultMsg("登录失败");
                        iqiyiLoginCallback.onFailure(iqiyiLoginResult);
                    } else if (parseOpenApiAuthorizedResult.errorCode != -100) {
                        iqiyiLoginResult.setResultCode(-100);
                        iqiyiLoginResult.setResultMsg("登录失败");
                        iqiyiLoginCallback.onFailure(iqiyiLoginResult);
                    } else {
                        SapiAccount responseToAccount = SapiAccountRepository.this.responseToAccount(parseOpenApiAuthorizedResult);
                        responseToAccount.addSocialInfo(parseOpenApiAuthorizedResult.socialType, parseOpenApiAuthorizedResult.socialPortraitUrl, parseOpenApiAuthorizedResult.socialNickname);
                        responseToAccount.putExtra("account_type", Integer.valueOf(parseOpenApiAuthorizedResult.accountType.getType()));
                        responseToAccount.addDispersionCertification(parseOpenApiAuthorizedResult.tplStokenMap);
                        responseToAccount.addIsGuestAccount(parseOpenApiAuthorizedResult.isGuestAccount);
                        responseToAccount.putExtra("tpl", SapiAccountRepository.this.configuration.tpl);
                        SapiAccountManager.getInstance().validate(responseToAccount);
                        iqiyiLoginCallback.onSuccess(iqiyiLoginResult);
                    }
                }
            });
            return;
        }
        iqiyiLoginCallback.onLogin(iqiyiLoginResult);
    }

    public void checkOneKeyLoginIsAvailable(final OneKeyLoginCallback oneKeyLoginCallback, final String str, int i) {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("ability", "onekeylogin");
        httpHashMapWrap.put("scene", "api");
        httpHashMapWrap.put("clientfrom", "native");
        httpHashMapWrap.put("mobile", str);
        httpHashMapWrap.put("oneKeySdkVersion", DefaultDiskStorage.DEFAULT_DISK_STORAGE_VERSION_PREFIX);
        String oneKeyLoginAbilityUrl = getOneKeyLoginAbilityUrl();
        List<HttpCookie> buildNaCookie = ParamsUtil.buildNaCookie(oneKeyLoginAbilityUrl, this.configuration);
        final long currentTimeMillis = System.currentTimeMillis();
        OneKeyLoginStat.CheckAbility.statExtMap.put("phoneNum", str);
        OneKeyLoginStat.CheckAbility.statExtMap.put("connectTimeout", Integer.valueOf(i));
        OneKeyLoginStat.CheckAbility.statExtMap.put("scene", "api");
        OneKeyLoginStat.CheckAbility.statExtMap.put("netType", SapiUtils.getNetworkClass(this.configuration.context));
        OneKeyLoginStat.CheckAbility.statExtMap.put("operator", zj1.d().c(this.configuration.context));
        new HttpClientWrap().get(oneKeyLoginAbilityUrl, ReqPriority.IMMEDIATE, httpHashMapWrap, buildNaCookie, getUaInfo(), i, new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.SapiAccountRepository.17
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i2, String str2) {
                OneKeyLoginStat.CheckAbility.statExtMap.put("dur", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                OneKeyLoginStat.CheckAbility.statExtMap.put("code", Integer.valueOf(i2));
                OneKeyLoginStat.CheckAbility.sValue = "0";
                OneKeyLoginStat.CheckAbility.upload();
                String str3 = SapiAccountRepository.TAG;
                Log.d(str3, "onFailure, error = " + th + ", errorCode = " + i2 + ", responseBody = " + str2);
                SapiStatUtil.statOneKeyCheckAbility(i2, -114, false, OneKeyLoginSdkCall.getInstance().getOperatorType());
                new OneKeyLoginSdkCall().preGetPhoneFail(oneKeyLoginCallback, i2, null);
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i2, String str2) {
                OneKeyLoginStat.CheckAbility.statExtMap.put("dur", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                SapiAccountRepository.this.processOneKeyLoginIsAvailable(i2, str2, str, oneKeyLoginCallback);
            }
        });
    }

    public void getOnlineAppShareModel(List<GetOnlineRequestShareModel> list, String str, final GetOnlineAppCallback getOnlineAppCallback) {
        if (getOnlineAppCallback != null && list != null && list.size() != 0) {
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.put(CommandUBCHelper.COMMAND_UBC_STATISTICS_SOURCE_VALUE_CLIENT, "android");
            httpHashMapWrap.put("clientfrom", "native");
            JSONArray jSONArray = new JSONArray();
            for (GetOnlineRequestShareModel getOnlineRequestShareModel : list) {
                jSONArray.put(GetOnlineRequestShareModel.parseModel2JsonObject(getOnlineRequestShareModel));
            }
            httpHashMapWrap.put("applist", jSONArray.toString());
            httpHashMapWrap.put("frominterflow", str);
            String onlineAppUrl = getOnlineAppUrl();
            new HttpClientWrap().post(onlineAppUrl, httpHashMapWrap, ParamsUtil.buildNaCookie(onlineAppUrl, this.configuration), getUaInfo(), new HttpHandlerWrap() { // from class: com.baidu.sapi2.SapiAccountRepository.26
                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onFailure(Throwable th, int i, String str2) {
                    Log.d(ShareUtils.TAG, "getOnlineAppShareModel fail responseBody=" + str2);
                    getOnlineAppCallback.onFailure();
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onSuccess(int i, String str2) {
                    Log.d(ShareUtils.TAG, "getOnlineAppShareModel success response=" + str2);
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        if (jSONObject.optInt("errno") != 0) {
                            getOnlineAppCallback.onFailure();
                            return;
                        }
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        if (optJSONObject == null) {
                            getOnlineAppCallback.onFailure();
                            return;
                        }
                        JSONArray optJSONArray = optJSONObject.optJSONArray("applist");
                        if (optJSONArray == null) {
                            getOnlineAppCallback.onFailure();
                        } else {
                            getOnlineAppCallback.onSuccess(optJSONArray);
                        }
                    } catch (JSONException e) {
                        Log.e(SapiAccountRepository.TAG, e.getMessage());
                        getOnlineAppCallback.onFailure();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processOneKeyLoginIsAvailable(int i, String str, String str2, final OneKeyLoginCallback oneKeyLoginCallback) {
        JSONObject jSONObject;
        boolean z;
        boolean z2 = true;
        Log.d(TAG, "onSuccess, statusCode = " + i + ", response = " + str);
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
            jSONObject = null;
        }
        final OneKeyLoginResult oneKeyLoginResult = new OneKeyLoginResult();
        if (jSONObject == null) {
            SapiStatUtil.statOneKeyCheckAbility(i, -113, false, OneKeyLoginSdkCall.getInstance().getOperatorType());
            new OneKeyLoginSdkCall().preGetPhoneFail(oneKeyLoginCallback, -100, null);
            OneKeyLoginStat.CheckAbility.statExtMap.put("code", -113);
            OneKeyLoginStat.CheckAbility.sValue = "0";
            OneKeyLoginStat.CheckAbility.upload();
            return;
        }
        final int optInt = jSONObject.optInt("errno");
        if (optInt == 0 && (jSONObject2 = jSONObject.optJSONObject("data")) != null && 1 == jSONObject2.optInt("enable")) {
            z = true;
        } else {
            z = false;
        }
        if (z && jSONObject2 != null) {
            oneKeyLoginResult.enable = true;
            oneKeyLoginResult.setResultCode(0);
            if (jSONObject2.optInt("hasHistory", -1) != 1) {
                z2 = false;
            }
            oneKeyLoginResult.hasHistory = z2;
            oneKeyLoginResult.encryptPhoneNum = str2;
            String optString = jSONObject2.optString("sign");
            oneKeyLoginResult.sign = optString;
            OneKeyLoginSdkCall.signFromAbilityApi = optString;
            oneKeyLoginResult.operator = new OneKeyLoginSdkCall().getOperatorType();
            String optString2 = jSONObject2.optString(PackageTable.MD5);
            String optString3 = jSONObject2.optString("url");
            final String optString4 = jSONObject2.optString("js");
            String onekeyLoginJsMd5 = SapiContext.getInstance().getOnekeyLoginJsMd5();
            if (optString2 != null && optString2.equals(onekeyLoginJsMd5)) {
                OneKeyLoginResult.secondJsCode = optString4;
                oneKeyLoginCallback.available(oneKeyLoginResult);
                OneKeyLoginStat.CheckAbility.statExtMap.put("code", Integer.valueOf(optInt));
                OneKeyLoginStat.CheckAbility.statExtMap.put(OneKeyLoginStat.CheckAbility.KEY_EXT_JS_ABLE, "1");
                OneKeyLoginStat.CheckAbility.statExtMap.put(OneKeyLoginStat.CheckAbility.KEY_EXT_JS_ABLE_REPETITION, "1");
                OneKeyLoginStat.CheckAbility.sValue = "1";
                OneKeyLoginStat.CheckAbility.upload();
            } else {
                OneKeyLoginStat.CheckAbility.statExtMap.put(OneKeyLoginStat.CheckAbility.KEY_EXT_JS_ABLE_REPETITION, "0");
                final long currentTimeMillis = System.currentTimeMillis();
                requestFirstJsCode(optString3, optString2, optString4, new OneKeyRequestJsCallback() { // from class: com.baidu.sapi2.SapiAccountRepository.18
                    @Override // com.baidu.sapi2.SapiAccountRepository.OneKeyRequestJsCallback
                    public void failure(int i2, String str3) {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        new OneKeyLoginSdkCall().preGetPhoneFail(oneKeyLoginCallback, i2, str3);
                        OneKeyLoginStat.CheckAbility.statExtMap.put("code", Integer.valueOf(optInt));
                        OneKeyLoginStat.CheckAbility.statExtMap.put(OneKeyLoginStat.CheckAbility.KEY_EXT_JS_ABLE, "0");
                        OneKeyLoginStat.CheckAbility.sValue = "0";
                        OneKeyLoginStat.CheckAbility.statExtMap.put(OneKeyLoginStat.CheckAbility.KEY_EXT_JS_DUR, Long.valueOf(currentTimeMillis2 - currentTimeMillis));
                        OneKeyLoginStat.CheckAbility.upload();
                    }

                    @Override // com.baidu.sapi2.SapiAccountRepository.OneKeyRequestJsCallback
                    public void success() {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        OneKeyLoginResult.secondJsCode = optString4;
                        oneKeyLoginCallback.available(oneKeyLoginResult);
                        OneKeyLoginStat.CheckAbility.statExtMap.put("code", Integer.valueOf(optInt));
                        OneKeyLoginStat.CheckAbility.statExtMap.put(OneKeyLoginStat.CheckAbility.KEY_EXT_JS_ABLE, "1");
                        OneKeyLoginStat.CheckAbility.statExtMap.put(OneKeyLoginStat.CheckAbility.KEY_EXT_JS_DUR, Long.valueOf(currentTimeMillis2 - currentTimeMillis));
                        OneKeyLoginStat.CheckAbility.sValue = "1";
                        OneKeyLoginStat.CheckAbility.upload();
                    }
                });
            }
        } else {
            new OneKeyLoginSdkCall().preGetPhoneFail(oneKeyLoginCallback, optInt, jSONObject.optString("errmsg"));
            OneKeyLoginStat.CheckAbility.statExtMap.put("code", Integer.valueOf(optInt));
            OneKeyLoginStat.CheckAbility.sValue = "0";
            OneKeyLoginStat.CheckAbility.upload();
        }
        SapiStatUtil.statOneKeyCheckAbility(i, optInt, oneKeyLoginResult.enable, oneKeyLoginResult.operator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void realDynamicPwdLogin(final SapiCallBack<SapiAccountResponse> sapiCallBack, String str, String str2, String str3, String str4, final boolean z, final SapiDataEncryptor sapiDataEncryptor) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, CertificateException, JSONException {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("crypttype", "6");
        String deviceInfo = SapiDeviceInfo.getDeviceInfo(SapiEnv.LOGIN_URI);
        if (!TextUtils.isEmpty(deviceInfo)) {
            httpHashMapWrap.put(AppIconSetting.DEFAULT_LARGE_ICON, deviceInfo);
        }
        httpHashMapWrap.put("cert_id", str2);
        httpHashMapWrap.put("isdpass", "1");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("username", str3);
        jSONObject.put("isphone", "1");
        jSONObject.put(a.m, str4);
        jSONObject.put("login_type", "3");
        jSONObject.put("key", sapiDataEncryptor.getAESKey());
        jSONObject.put("sdk_version", "2");
        jSONObject.put("pinfo", SapiDeviceUtils.getBrandName());
        httpHashMapWrap.put(TableDefine.DB_TABLE_USERINFO, sapiDataEncryptor.encrypt(str, jSONObject.toString()));
        new HttpClientWrap().post(SapiEnv.LOGIN_URI, httpHashMapWrap, null, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.SapiAccountRepository.3
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str5) {
                super.onFailure(th, i, str5);
                if (i == -201) {
                    sapiCallBack.onNetworkFailed();
                } else {
                    sapiCallBack.onSystemError(i);
                }
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i, String str5) {
                super.onSuccess(i, str5);
                SapiAccountRepository sapiAccountRepository = SapiAccountRepository.this;
                sapiAccountRepository.handleDynamicPwdLogin(sapiAccountRepository.getErrorCode(str5), sapiCallBack, str5, z, sapiDataEncryptor);
            }
        });
    }

    public void checkAvailableLoginHistory(String str, final LoginHistoryCallback loginHistoryCallback) {
        Log.d("history", "checkAvailableLoginHistory loginHistoryInfo=" + str);
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("historyBdussList", str);
        new HttpClientWrap().post(getCheckAvailableLoginHistoryUrl(), ReqPriority.IMMEDIATE, httpHashMapWrap, new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.SapiAccountRepository.25
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str2) {
                Log.d(ActivityHistory.TAG, "checkAvailableLoginHistory onFailure errorCode=" + i + ", responseBody=" + str2);
                loginHistoryCallback.onFailure();
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i, String str2, HashMap<String, String> hashMap) {
                JSONObject jSONObject;
                JSONObject optJSONObject;
                Log.d(ActivityHistory.TAG, "checkAvailableLoginHistory onSuccess statusCode=" + i + ", responseBody=" + str2);
                JSONArray jSONArray = null;
                try {
                    jSONObject = new JSONObject(str2);
                } catch (JSONException e) {
                    e.printStackTrace();
                    jSONObject = null;
                }
                if (jSONObject == null) {
                    loginHistoryCallback.onFailure();
                    return;
                }
                if (jSONObject.optInt("code") == 110000 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                    jSONArray = optJSONObject.optJSONArray("historyList");
                }
                if (jSONArray != null) {
                    loginHistoryCallback.onResult(jSONArray);
                } else {
                    loginHistoryCallback.onFailure();
                }
            }
        });
    }

    public void handleGetDynamicPwd(SapiCallBack<SapiResponse> sapiCallBack, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            EnhancedService.smsCodeLength = jSONObject.optInt("smsCodeLength", 6);
            int parseInt = Integer.parseInt(jSONObject.optString("errno"));
            if (parseInt != 0) {
                sapiCallBack.onSystemError(parseInt);
            } else {
                SapiResponse sapiResponse = new SapiResponse();
                sapiResponse.errorCode = parseInt;
                sapiResponse.errorMsg = "短信验证码发送成功";
                sapiCallBack.onSuccess(sapiResponse);
            }
        } catch (Exception unused) {
            sapiCallBack.onSystemError(-100);
        }
    }

    public boolean isAccountStokenExist(SapiAccount sapiAccount, List<String> list) {
        if (sapiAccount != null && !TextUtils.isEmpty(sapiAccount.extra)) {
            try {
                SapiAccount.DispersionCertification fromJSONObject = SapiAccount.DispersionCertification.fromJSONObject(new JSONObject(sapiAccount.extra));
                for (String str : list) {
                    if (!fromJSONObject.tplStokenMap.containsKey(str)) {
                        return false;
                    }
                }
                return true;
            } catch (JSONException e) {
                Log.e(e);
            }
        }
        return false;
    }

    public void isShowRealNameGuide(IsShowRealNameGuideDTO isShowRealNameGuideDTO, final IsShowRealNameCallback isShowRealNameCallback) {
        if (isShowRealNameGuideDTO == null) {
            return;
        }
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("type", isShowRealNameGuideDTO.type);
        httpHashMapWrap.put("historyTime", isShowRealNameGuideDTO.historyTime);
        String isShowRealNameGuideUrl = getIsShowRealNameGuideUrl();
        List<HttpCookie> buildNaCookie = ParamsUtil.buildNaCookie(isShowRealNameGuideUrl, this.configuration);
        buildNaCookie.addAll(ParamsUtil.buildLoginStatusCookie(isShowRealNameGuideUrl, this.configuration));
        new HttpClientWrap().post(isShowRealNameGuideUrl, ReqPriority.IMMEDIATE, httpHashMapWrap, buildNaCookie, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.SapiAccountRepository.27
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str) {
                IsShowRealNameGuideResult isShowRealNameGuideResult = new IsShowRealNameGuideResult();
                isShowRealNameGuideResult.setResultCode(i);
                isShowRealNameGuideResult.setResultMsg(str);
                isShowRealNameCallback.onFailure(isShowRealNameGuideResult);
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i, String str) {
                IsShowRealNameGuideResult isShowRealNameGuideResult = new IsShowRealNameGuideResult();
                if (i != 200) {
                    isShowRealNameGuideResult.setResultCode(-202);
                    isShowRealNameGuideResult.setResultMsg("网络连接失败，请检查网络设置");
                    isShowRealNameCallback.onFailure(isShowRealNameGuideResult);
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("code");
                    if (optInt != 110000) {
                        if (optInt != 400021) {
                            isShowRealNameGuideResult.setResultCode(-801);
                            isShowRealNameGuideResult.setResultMsg("服务异常，请稍后再试");
                            isShowRealNameCallback.onFailure(isShowRealNameGuideResult);
                        } else {
                            isShowRealNameGuideResult.setResultCode(400021);
                            isShowRealNameGuideResult.setResultMsg("当前用户不在线");
                            isShowRealNameCallback.onFailure(isShowRealNameGuideResult);
                        }
                    } else {
                        isShowRealNameGuideResult = IsShowRealNameGuideResult.parseFromJSONObject(jSONObject.optJSONObject("data"));
                        if (isShowRealNameGuideResult.getResultCode() == 110000) {
                            isShowRealNameCallback.onSuccess(isShowRealNameGuideResult);
                        } else {
                            isShowRealNameCallback.onFailure(isShowRealNameGuideResult);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    isShowRealNameGuideResult.setResultCode(-205);
                    isShowRealNameGuideResult.setResultMsg("服务端数据异常，请稍后再试");
                    isShowRealNameCallback.onFailure(isShowRealNameGuideResult);
                }
            }
        });
    }

    public void userLogout(int i, final UserLogoutCallback userLogoutCallback) {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("logout_type", String.valueOf(i));
        String userLogoutUrl = getUserLogoutUrl();
        List<HttpCookie> buildNaCookie = ParamsUtil.buildNaCookie(userLogoutUrl, this.configuration);
        buildNaCookie.addAll(ParamsUtil.buildLoginStatusCookie(userLogoutUrl, this.configuration));
        new HttpClientWrap().post(userLogoutUrl, ReqPriority.IMMEDIATE, httpHashMapWrap, buildNaCookie, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.SapiAccountRepository.21
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i2, String str) {
                SapiResult sapiResult = new SapiResult();
                sapiResult.setResultCode(i2);
                sapiResult.setResultMsg(str);
                userLogoutCallback.onFailure(sapiResult);
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i2, String str) {
                SapiResult sapiResult = new SapiResult();
                try {
                    int optInt = new JSONObject(str).optInt("code");
                    if (optInt != 110000) {
                        sapiResult.setResultCode(optInt);
                        userLogoutCallback.onFailure(sapiResult);
                    } else {
                        userLogoutCallback.onSuccess(sapiResult);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    sapiResult.setResultCode(-205);
                    sapiResult.setResultMsg("服务端数据异常，请稍后再试");
                    userLogoutCallback.onFailure(sapiResult);
                }
            }
        });
    }

    public void checkUserFaceId(final SapiCallback<CheckUserFaceIdResult> sapiCallback, String str, Map<String, String> map) {
        SapiUtils.notNull(sapiCallback, SapiCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        HttpHashMapWrap buildSapiParams = buildSapiParams(SapiEnv.CHECK_USER_FACE_ID);
        buildSapiParams.put("clientfrom", "native");
        buildSapiParams.put("bduss", str);
        if (map != null && !map.isEmpty()) {
            buildSapiParams.putAll(map);
        }
        final CheckUserFaceIdResult checkUserFaceIdResult = new CheckUserFaceIdResult();
        new HttpClientWrap().post(SapiEnv.CHECK_USER_FACE_ID, buildSapiParams, null, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.SapiAccountRepository.12
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str2) {
                checkUserFaceIdResult.setResultCode(i);
                sapiCallback.onFailure(checkUserFaceIdResult);
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFinish() {
                sapiCallback.onFinish();
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onStart() {
                sapiCallback.onStart();
            }

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
                        checkUserFaceIdResult.action = jSONObject.optString("action");
                        sapiCallback.onSuccess(checkUserFaceIdResult);
                    } else {
                        sapiCallback.onFailure(checkUserFaceIdResult);
                    }
                } catch (Throwable unused) {
                    checkUserFaceIdResult.setResultCode(-202);
                    sapiCallback.onFailure(checkUserFaceIdResult);
                }
            }
        });
    }

    public void extendSysWebViewMethodCheck(final SapiCallback<SapiResult> sapiCallback, String str, String str2) {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("open_appid", str);
        httpHashMapWrap.put("open_apikey", str2);
        httpHashMapWrap.put("time", System.currentTimeMillis() + "");
        final SapiResult sapiResult = new SapiResult();
        new HttpClientWrap().post(SapiEnv.EXTEND_SYS_WEBVIEW_METHOD_CHECK, httpHashMapWrap, null, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.SapiAccountRepository.16
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str3) {
                sapiResult.setResultCode(i);
                sapiResult.setResultMsg(str3);
                sapiCallback.onFailure(sapiResult);
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFinish() {
                sapiCallback.onFinish();
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onStart() {
                sapiCallback.onStart();
            }

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
        });
    }

    public boolean dynamicPwdLogin(final SapiCallBack<SapiAccountResponse> sapiCallBack, final String str, final String str2, final boolean z) {
        SapiConfiguration sapiConfiguration = this.configuration;
        if (sapiConfiguration != null && sapiConfiguration.context != null) {
            SapiUtils.notNull(sapiCallBack, SapiCallBack.class.getSimpleName() + " can't be null");
            final SapiDataEncryptor sapiDataEncryptor = new SapiDataEncryptor();
            new HttpClientWrap().get(getLastCert(), ReqPriority.IMMEDIATE, null, null, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.SapiAccountRepository.2
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
                    if (!TextUtils.isEmpty(str3)) {
                        SapiAccountRepository.this.handleDynamicPwdLogin(-100, sapiCallBack, str3, z, sapiDataEncryptor);
                        return;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(str3);
                        SapiAccountRepository.this.realDynamicPwdLogin(sapiCallBack, jSONObject.optString("cert"), jSONObject.optString("cert_id"), str, str2, z, sapiDataEncryptor);
                    } catch (Exception e) {
                        SapiAccountRepository.this.handleDynamicPwdLogin(-100, sapiCallBack, str3, z, sapiDataEncryptor);
                        Log.e(e);
                    }
                }
            });
            return true;
        }
        return false;
    }

    public void loginWithUCAuth(String str, String str2, String str3, final LoginWithUCAuthCallback loginWithUCAuthCallback) {
        String appUc2PassLoginUrl = getAppUc2PassLoginUrl();
        List<HttpCookie> buildLoginStatusCookie = ParamsUtil.buildLoginStatusCookie(appUc2PassLoginUrl, this.configuration);
        HttpHashMap httpHashMap = new HttpHashMap();
        httpHashMap.put("tpl", str);
        httpHashMap.put("appid", str2);
        httpHashMap.put("ucdata", str3);
        httpHashMap.put(CommandUBCHelper.COMMAND_UBC_STATISTICS_SOURCE_VALUE_CLIENT, "android");
        httpHashMap.put("clientfrom", "native");
        httpHashMap.put(FunAdSdk.PLATFORM_SIG, calculateSig(httpHashMap.getMap(), SapiAccountManager.getInstance().getConfignation().appSignKey));
        new HttpClientWrap().post(appUc2PassLoginUrl, ReqPriority.IMMEDIATE, httpHashMap, buildLoginStatusCookie, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.SapiAccountRepository.29
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str4) {
                LoginWithUCAuthResult loginWithUCAuthResult = new LoginWithUCAuthResult();
                loginWithUCAuthResult.setResultCode(i);
                loginWithUCAuthResult.setResultMsg(str4);
                loginWithUCAuthCallback.onFailure(loginWithUCAuthResult);
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i, String str4) {
                LoginWithUCAuthResult parseFromJSONObject = LoginWithUCAuthResult.parseFromJSONObject(str4);
                if (parseFromJSONObject.getResultCode() != 0) {
                    loginWithUCAuthCallback.onFailure(parseFromJSONObject);
                    return;
                }
                SapiAccount sapiAccount = new SapiAccount();
                sapiAccount.uid = parseFromJSONObject.uid;
                sapiAccount.displayname = parseFromJSONObject.displayname;
                sapiAccount.bduss = parseFromJSONObject.bduss;
                sapiAccount.ptoken = parseFromJSONObject.ptoken;
                sapiAccount.stoken = parseFromJSONObject.stoken;
                SapiAccountManager.getInstance().validate(sapiAccount, false, false);
                loginWithUCAuthCallback.onSuccess(parseFromJSONObject);
            }
        });
    }

    public void oauth(final SapiCallback<OAuthResult> sapiCallback, final String str, final String str2, String str3) {
        SapiUtils.notNull(sapiCallback, SapiCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        if (!TextUtils.isEmpty(str2)) {
            httpHashMapWrap.put("openPlatformId", str2);
        }
        httpHashMapWrap.put("bduss", str);
        if (!TextUtils.isEmpty(str3)) {
            httpHashMapWrap.put("scope", str3);
        }
        new HttpClientWrap().post(SapiEnv.OAUTH_URI, httpHashMapWrap, null, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.SapiAccountRepository.8
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str4) {
                String str5 = SapiAccountRepository.TAG;
                Log.d(str5, "oauth failure: code=" + i + " body=" + str4);
                OAuthResult oAuthResult = new OAuthResult();
                oAuthResult.setResultCode(i);
                sapiCallback.onFailure(oAuthResult);
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFinish() {
                sapiCallback.onFinish();
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onStart() {
                sapiCallback.onStart();
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i, String str4) {
                JSONObject jSONObject;
                String str5 = SapiAccountRepository.TAG;
                Log.d(str5, "oauth success: " + str4);
                try {
                    jSONObject = new JSONObject(str4);
                } catch (JSONException e) {
                    String str6 = SapiAccountRepository.TAG;
                    Log.e(str6, "formatOauthResult: " + e.getMessage());
                    jSONObject = null;
                }
                if (jSONObject != null) {
                    try {
                        jSONObject.put("extra", str4);
                        jSONObject.put("cachedTimeSecond", System.currentTimeMillis() / 1000);
                    } catch (JSONException e2) {
                        String str7 = SapiAccountRepository.TAG;
                        Log.e(str7, "" + e2.getMessage());
                    }
                }
                OAuthResult formatOauthResult = SapiAccountRepository.this.formatOauthResult(jSONObject);
                if (jSONObject != null && formatOauthResult != null) {
                    if (formatOauthResult.getResultCode() == 0) {
                        SapiContext.getInstance().put(SapiAccountRepository.this.getAccessTokenCacheKey(str, str2), jSONObject.toString());
                        sapiCallback.onSuccess(formatOauthResult);
                        return;
                    }
                    sapiCallback.onFailure(formatOauthResult);
                    return;
                }
                OAuthResult oAuthResult = new OAuthResult();
                oAuthResult.setResultCode(-202);
                sapiCallback.onFailure(oAuthResult);
            }
        });
    }

    public void faceLoginSwitch(final SapiCallback<SapiResult> sapiCallback, String str, final boolean z, String str2) {
        SapiAccount currentAccount;
        if (SapiContext.getInstance().getSapiOptions().getOpenBdussTpls().contains(SapiAccountManager.getInstance().getConfignation().tpl) && (currentAccount = SapiContext.getInstance().getCurrentAccount()) != null) {
            str = currentAccount.bduss;
        }
        SapiUtils.notNull(sapiCallback, SapiCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        HttpHashMapWrap buildSapiParams = buildSapiParams(SapiEnv.FACE_LOGIN_STATUS_CHECK);
        if (z) {
            buildSapiParams.put("action", "enable_face_login");
        } else {
            buildSapiParams.put("action", "disable_face_login");
        }
        if (!TextUtils.isEmpty(str2)) {
            buildSapiParams.put("callbackKey", str2);
        }
        buildSapiParams.put("guidefrom", FaceBaseDTO.BUSINESS_SENCE_FACE_LOGIN_SWITCH);
        buildSapiParams.put("clientfrom", "native");
        buildSapiParams.put("bduss", str);
        final CheckUserFaceIdResult checkUserFaceIdResult = new CheckUserFaceIdResult();
        new HttpClientWrap().post(SapiEnv.FACE_LOGIN_SWITCH_URI, buildSapiParams, null, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.SapiAccountRepository.14
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str3) {
                checkUserFaceIdResult.setResultCode(i);
                sapiCallback.onFailure(checkUserFaceIdResult);
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFinish() {
                sapiCallback.onFinish();
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onStart() {
                sapiCallback.onStart();
            }

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
                                new FaceLoginService().syncFaceLoginUID(SapiAccountRepository.this.configuration.context, optString);
                            }
                        }
                        sapiCallback.onSuccess(checkUserFaceIdResult);
                        return;
                    }
                    sapiCallback.onFailure(checkUserFaceIdResult);
                } catch (Throwable unused) {
                    checkUserFaceIdResult.setResultCode(-202);
                    sapiCallback.onFailure(checkUserFaceIdResult);
                }
            }
        });
    }

    public void fillUsername(final FillUsernameCallback fillUsernameCallback, String str, String str2) {
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
            String clientId = SapiUtils.getClientId(this.configuration.context);
            if (!TextUtils.isEmpty(clientId)) {
                jSONObject.put("clientid", clientId);
            }
            if (!TextUtils.isEmpty(this.configuration.clientIp)) {
                jSONObject.put(DnsModel.CLIENTIP_KEY, this.configuration.clientIp);
            }
            jSONObject.put("username", str2);
            jSONObject.put("key", sapiDataEncryptor.getAESKey());
            httpHashMapWrap.put(TableDefine.DB_TABLE_USERINFO, sapiDataEncryptor.encrypt(SapiDataEncryptor.Cert1.CERT, jSONObject.toString()));
            new HttpClientWrap().post(SapiEnv.FILL_UNAME, httpHashMapWrap, null, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.SapiAccountRepository.6
                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onFailure(Throwable th, int i, String str3) {
                    fillUsernameResult.setResultCode(i);
                    fillUsernameCallback.onFailure(fillUsernameResult);
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onFinish() {
                    fillUsernameCallback.onFinish();
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onStart() {
                    fillUsernameCallback.onStart();
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onSuccess(int i, String str3) {
                    int errorCode = SapiAccountRepository.this.getErrorCode(str3);
                    fillUsernameResult.setResultCode(errorCode);
                    try {
                        JSONObject jSONObject2 = new JSONObject(str3);
                        fillUsernameResult.setResultMsg(jSONObject2.optString("errmsg"));
                        JSONObject jSONObject3 = new JSONObject(sapiDataEncryptor.decrypt(jSONObject2.optString(TableDefine.DB_TABLE_USERINFO)));
                        if (errorCode != 0 && errorCode != 110000) {
                            switch (errorCode) {
                                case 160103:
                                    fillUsernameCallback.onBdussExpired(fillUsernameResult);
                                    return;
                                case FillUsernameResult.RESULT_CODE_USER_HAVE_USERNAME /* 160104 */:
                                    fillUsernameCallback.onUserHaveUsername(fillUsernameResult);
                                    return;
                                default:
                                    fillUsernameCallback.onFailure(fillUsernameResult);
                                    return;
                            }
                        }
                        SapiAccount sapiAccount = new SapiAccount();
                        sapiAccount.bduss = jSONObject3.optString("bduss");
                        sapiAccount.ptoken = jSONObject3.optString("ptoken");
                        sapiAccount.stoken = jSONObject3.optString("stoken");
                        sapiAccount.displayname = jSONObject3.optString("displayname");
                        sapiAccount.username = jSONObject3.optString("uname");
                        sapiAccount.uid = jSONObject3.optString("uid");
                        sapiAccount.app = SapiUtils.getAppName(SapiAccountRepository.this.configuration.context);
                        sapiAccount.addDispersionCertification(SapiAccount.DispersionCertification.fromJSONObject(jSONObject3).tplStokenMap);
                        sapiAccount.putExtra("tpl", SapiAccountRepository.this.configuration.tpl);
                        SapiAccountManager.getInstance().validate(sapiAccount);
                        fillUsernameResult.session = sapiAccount;
                        fillUsernameCallback.onSuccess(fillUsernameResult);
                        new PtokenStat().onEvent(PtokenStat.FILLNAME_WIDGE);
                    } catch (Throwable th) {
                        fillUsernameCallback.onFailure(fillUsernameResult);
                        Log.e(th);
                    }
                }
            });
        } catch (Throwable th) {
            fillUsernameResult.setResultCode(-202);
            fillUsernameCallback.onFailure(fillUsernameResult);
            Log.e(th);
        }
    }

    public boolean getDynamicPwd(final SapiCallBack<SapiResponse> sapiCallBack, String str) {
        Context context;
        SapiConfiguration sapiConfiguration = this.configuration;
        if (sapiConfiguration == null || (context = sapiConfiguration.context) == null) {
            return false;
        }
        if (!SapiUtils.hasActiveNetwork(context)) {
            if (sapiCallBack != null) {
                sapiCallBack.onNetworkFailed();
            }
            return false;
        } else if (TextUtils.isEmpty(str)) {
            if (sapiCallBack != null) {
                sapiCallBack.onSystemError(257);
            }
            return false;
        } else {
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.put("username", str);
            new HttpClientWrap().post(SapiEnv.GET_DYNAMIC_PWD_URI, httpHashMapWrap, null, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.SapiAccountRepository.9
                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onFailure(Throwable th, int i, String str2) {
                    if (i == -203) {
                        sapiCallBack.onSystemError(i);
                    } else {
                        SapiAccountRepository.this.handleGetDynamicPwd(sapiCallBack, str2);
                    }
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onSuccess(int i, String str2) {
                    SapiAccountRepository.this.handleGetDynamicPwd(sapiCallBack, str2);
                }
            });
            return true;
        }
    }

    public void iqiyiSSOLogin(final IqiyiLoginCallback iqiyiLoginCallback, final IqiyiLoginDTO iqiyiLoginDTO) {
        boolean z;
        if (iqiyiLoginCallback == null) {
            return;
        }
        iqiyiLoginCallback.onStart();
        String str = iqiyiLoginDTO.accessToken;
        final String str2 = iqiyiLoginDTO.phoneNum;
        String str3 = iqiyiLoginDTO.openID;
        final IqiyiLoginResult iqiyiLoginResult = new IqiyiLoginResult();
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            z = true;
        } else {
            z = false;
        }
        if (!z && currentAccount == null) {
            iqiyiLoginCallback.onLogin(iqiyiLoginResult);
        } else if (z && currentAccount == null) {
            getThroughServer(iqiyiLoginCallback, iqiyiLoginDTO, iqiyiLoginResult);
        } else {
            SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback() { // from class: com.baidu.sapi2.SapiAccountRepository.10
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFinish() {
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onStart() {
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.LoginStatusAware
                public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                    SapiAccountRepository.this.getThroughServer(iqiyiLoginCallback, iqiyiLoginDTO, iqiyiLoginResult);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFailure(GetUserInfoResult getUserInfoResult) {
                    iqiyiLoginResult.setResultCode(getUserInfoResult.getResultCode());
                    iqiyiLoginResult.setResultMsg(getUserInfoResult.getResultMsg());
                    iqiyiLoginCallback.onFailure(iqiyiLoginResult);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onSuccess(GetUserInfoResult getUserInfoResult) {
                    String str4 = getUserInfoResult.secureMobile;
                    boolean z2 = getUserInfoResult.incompleteUser;
                    if (TextUtils.isEmpty(str4)) {
                        if (!z2) {
                            if (TextUtils.isEmpty(str2)) {
                                iqiyiLoginCallback.onSuccess(iqiyiLoginResult);
                                return;
                            } else {
                                SapiAccountRepository.this.getThroughServer(iqiyiLoginCallback, iqiyiLoginDTO, iqiyiLoginResult);
                                return;
                            }
                        }
                        SapiAccountRepository.this.getThroughServer(iqiyiLoginCallback, iqiyiLoginDTO, iqiyiLoginResult);
                        return;
                    }
                    iqiyiLoginCallback.onSuccess(iqiyiLoginResult);
                }
            }, currentAccount.bduss);
        }
    }

    public void getShareV3App(String str, List<String> list, String str2, final GetShareV3AppCallback getShareV3AppCallback) {
        if (getShareV3AppCallback == null) {
            return;
        }
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put(CommandUBCHelper.COMMAND_UBC_STATISTICS_SOURCE_VALUE_CLIENT, "android");
        httpHashMapWrap.put("clientfrom", "native");
        httpHashMapWrap.put("tpl", str);
        StringBuilder sb = new StringBuilder();
        sb.append(PreferencesUtil.LEFT_MOUNT);
        for (String str3 : list) {
            sb.append("\"");
            sb.append(str3);
            sb.append("\"");
            sb.append(",");
        }
        StringBuilder deleteCharAt = sb.deleteCharAt(sb.length() - 1);
        deleteCharAt.append(PreferencesUtil.RIGHT_MOUNT);
        httpHashMapWrap.put("interflowPkgList", deleteCharAt.toString());
        httpHashMapWrap.put("currentAppPkg", str2);
        String shareV3AppUrl = getShareV3AppUrl();
        new HttpClientWrap().post(shareV3AppUrl, httpHashMapWrap, ParamsUtil.buildNaCookie(shareV3AppUrl, this.configuration), getUaInfo(), new HttpHandlerWrap() { // from class: com.baidu.sapi2.SapiAccountRepository.23
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str4) {
                ShareLoginStat.GetShareListStat.statExtMap.put(ShareLoginStat.GetShareListStat.KEY_FROM_NET_ERRCODE, Integer.valueOf(i));
                Log.d(ShareUtils.TAG, "requestShareV3AppFromCloud fail responseBody=" + str4);
                getShareV3AppCallback.onFailure();
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i, String str4) {
                JSONObject jSONObject;
                JSONObject optJSONObject;
                Log.d(ShareUtils.TAG, "requestShareV3AppFromCloud success response=" + str4);
                ShareLoginStat.GetShareListStat.statExtMap.put(ShareLoginStat.GetShareListStat.KEY_FROM_NET_ERRCODE, Integer.valueOf(i));
                JSONArray jSONArray = null;
                try {
                    jSONObject = new JSONObject(str4);
                } catch (JSONException e) {
                    Log.e(SapiAccountRepository.TAG, e.getMessage());
                    jSONObject = null;
                }
                if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                    jSONArray = optJSONObject.optJSONArray("list");
                }
                if (jSONArray != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        ShareStorage.StorageModel fromJSON = ShareStorage.StorageModel.fromJSON(jSONArray.optJSONObject(i2));
                        if (fromJSON != null) {
                            arrayList.add(fromJSON);
                        }
                    }
                    SapiContext.getInstance().put(SapiContext.KEY_SHARE_MODELS_FROM_CLOUD_CACHE, jSONArray.toString());
                    getShareV3AppCallback.onSuccess(arrayList);
                    return;
                }
                getShareV3AppCallback.onFailure();
            }
        });
    }

    public Map<String, String> getTplStoken(final GetTplStokenCallback getTplStokenCallback, String str, final List<String> list, final boolean z) {
        final long currentTimeMillis = System.currentTimeMillis();
        SapiUtils.notNull(getTplStokenCallback, GetTplStokenCallback.class.getSimpleName() + " can't be null");
        final GetTplStokenResult getTplStokenResult = new GetTplStokenResult();
        if (list != null && !list.isEmpty()) {
            final SapiAccount accountFromBduss = SapiContext.getInstance().getAccountFromBduss(str);
            if (accountFromBduss == null) {
                getTplStokenResult.setResultCode(-301);
                getTplStokenCallback.onFailure(getTplStokenResult);
                GetTplStokenStat.onEventAutoStat(String.valueOf(System.currentTimeMillis() - currentTimeMillis), String.valueOf(-301), "bduss 本地不存在");
                return getTplStokenResult.tplStokenMap;
            }
            final String str2 = accountFromBduss.ptoken;
            if (isStokenExist(str, list)) {
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
                        GetTplStokenStat.onEventAutoStat(String.valueOf(System.currentTimeMillis() - currentTimeMillis), String.valueOf(0), "成功");
                        return getTplStokenResult.tplStokenMap;
                    }
                } catch (JSONException e) {
                    Log.e(e);
                    getTplStokenResult.setResultCode(GetTplStokenResult.ERROR_CODE_PARSE_DATA_FAIL);
                    getTplStokenCallback.onFailure(getTplStokenResult);
                    GetTplStokenStat.onEventAutoStat(String.valueOf(System.currentTimeMillis() - currentTimeMillis), String.valueOf((int) GetTplStokenResult.ERROR_CODE_PARSE_DATA_FAIL), "服务端数据异常，请稍后再试");
                    return getTplStokenResult.tplStokenMap;
                }
            }
            String str3 = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                str3 = str3 + "|" + list.get(i);
            }
            if (TextUtils.isEmpty(str2)) {
                getTplStokenResult.setResultCode(-305);
                getTplStokenResult.failureType = GetTplStokenResult.FailureType.PTOKEN_EMPTY;
                getTplStokenCallback.onFailure(getTplStokenResult);
            }
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.put("bduss", str);
            httpHashMapWrap.put("sign", SecurityUtil.md5((this.configuration.appId + this.configuration.tpl + str + this.configuration.appSignKey).getBytes(), false));
            httpHashMapWrap.put("return_type", "1");
            if (!TextUtils.isEmpty(str2)) {
                httpHashMapWrap.put("ptoken", str2);
            }
            httpHashMapWrap.put("tpl_list", str3);
            new HttpClientWrap().post(SapiEnv.GET_STOKEN_URI, httpHashMapWrap, null, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.SapiAccountRepository.7
                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onFailure(Throwable th, int i2, String str4) {
                    if (!TextUtils.isEmpty(str2)) {
                        getTplStokenResult.setResultCode(i2);
                        getTplStokenCallback.onFailure(getTplStokenResult);
                        GetTplStokenStat.onEventAutoStat(String.valueOf(System.currentTimeMillis() - currentTimeMillis), String.valueOf(i2), "网络连接失败，请检查网络设置");
                    }
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onFinish() {
                    getTplStokenCallback.onFinish();
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onStart() {
                    getTplStokenCallback.onStart();
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onSuccess(int i2, String str4) {
                    try {
                        JSONObject jSONObject = new JSONObject(str4);
                        int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                        getTplStokenResult.setResultCode(parseInt);
                        if (parseInt != 0) {
                            if (parseInt != 8) {
                                if (!TextUtils.isEmpty(str2)) {
                                    String optString = jSONObject.optString("errmsg");
                                    getTplStokenResult.setResultMsg(optString);
                                    getTplStokenCallback.onFailure(getTplStokenResult);
                                    GetTplStokenStat.onEventAutoStat(String.valueOf(System.currentTimeMillis() - currentTimeMillis), String.valueOf(i2), optString);
                                    return;
                                }
                                return;
                            } else if (!TextUtils.isEmpty(str2)) {
                                String optString2 = jSONObject.optString("ssnerror");
                                if (TextUtils.isEmpty(optString2)) {
                                    optString2 = "0";
                                }
                                int parseInt2 = Integer.parseInt(optString2);
                                if (parseInt2 == GetTplStokenResult.FailureType.BDUSS_PTOKEN_NOT_MATCH.ordinal()) {
                                    getTplStokenResult.failureType = GetTplStokenResult.FailureType.BDUSS_PTOKEN_NOT_MATCH;
                                } else if (parseInt2 == GetTplStokenResult.FailureType.BDUSS_EXPIRED.ordinal()) {
                                    getTplStokenResult.failureType = GetTplStokenResult.FailureType.BDUSS_EXPIRED;
                                }
                                String optString3 = jSONObject.optString("errmsg");
                                getTplStokenResult.setResultMsg(optString3);
                                getTplStokenCallback.onFailure(getTplStokenResult);
                                GetTplStokenStat.onEventAutoStat(String.valueOf(System.currentTimeMillis() - currentTimeMillis), String.valueOf(8), optString3);
                                return;
                            } else {
                                return;
                            }
                        }
                        Map<String, String> tplStokenMap = SapiAccount.DispersionCertification.getTplStokenMap(jSONObject.optJSONObject("stoken_list"));
                        getTplStokenResult.tplStokenMap = tplStokenMap;
                        SapiAccount.ExtraProperty extraProperty = new SapiAccount.ExtraProperty();
                        if (!TextUtils.isEmpty(accountFromBduss.extra)) {
                            extraProperty = SapiAccount.ExtraProperty.fromJSONObject(new JSONObject(accountFromBduss.extra));
                        }
                        extraProperty.dispersionCertification.tplStokenMap.putAll(tplStokenMap);
                        accountFromBduss.extra = extraProperty.toJSONObject().toString();
                        if (list.size() == tplStokenMap.size()) {
                            if (z) {
                                SapiAccountManager.getInstance().validate(accountFromBduss, false, true);
                            } else {
                                SapiContext.getInstance().setCurrentAccount(accountFromBduss);
                                SapiContext.getInstance().addLoginAccount(accountFromBduss);
                                new ShareCallPacking().asyncMarkLoginState(5);
                            }
                            getTplStokenCallback.onSuccess(getTplStokenResult);
                            return;
                        }
                        getTplStokenResult.setResultCode(-306);
                        getTplStokenCallback.onFailure(getTplStokenResult);
                        GetTplStokenStat.onEventAutoStat(String.valueOf(System.currentTimeMillis() - currentTimeMillis), String.valueOf(-306), "服务端数据异常，请稍后再试");
                    } catch (Exception e2) {
                        Log.e(e2);
                        if (!TextUtils.isEmpty(str2)) {
                            getTplStokenResult.setResultCode(-205);
                            getTplStokenCallback.onFailure(getTplStokenResult);
                            GetTplStokenStat.onEventAutoStat(String.valueOf(System.currentTimeMillis() - currentTimeMillis), String.valueOf(-205), "服务端数据异常，请稍后再试");
                        }
                    }
                }
            });
            return getTplStokenResult.tplStokenMap;
        }
        getTplStokenResult.setResultCode(-302);
        getTplStokenResult.setResultMsg("参数错误，请稍后再试");
        getTplStokenCallback.onFailure(getTplStokenResult);
        GetTplStokenStat.onEventAutoStat(String.valueOf(System.currentTimeMillis() - currentTimeMillis), String.valueOf(-302), "参数错误，请稍后再试");
        return getTplStokenResult.tplStokenMap;
    }

    public void getUserAttrInfo(String str, String str2, String str3, final String str4, final GetUserAttrInfoCallback getUserAttrInfoCallback) {
        String userAttrInfoUrl = getUserAttrInfoUrl();
        List<HttpCookie> buildLoginStatusCookie = ParamsUtil.buildLoginStatusCookie(userAttrInfoUrl, this.configuration);
        HttpHashMap httpHashMap = new HttpHashMap();
        httpHashMap.put("appname", str);
        httpHashMap.put(GetUserAttrInfoResult.KEY_DATA_FIELDS, str2);
        httpHashMap.put(GetUserAttrInfoResult.KEY_DATA_EXT_FIELDS, str3);
        new HttpClientWrap().get(userAttrInfoUrl, ReqPriority.IMMEDIATE, httpHashMap, buildLoginStatusCookie, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.SapiAccountRepository.28
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str5) {
                GetUserAttrInfoResult getUserAttrInfoResult = new GetUserAttrInfoResult();
                getUserAttrInfoResult.setResultCode(i);
                getUserAttrInfoResult.setResultMsg(str5);
                getUserAttrInfoCallback.onFailure(getUserAttrInfoResult);
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i, String str5) {
                GetUserAttrInfoResult parseFromJSONObject = GetUserAttrInfoResult.parseFromJSONObject(str5);
                if (parseFromJSONObject.getResultCode() != 0) {
                    getUserAttrInfoCallback.onFailure(parseFromJSONObject);
                    return;
                }
                getUserAttrInfoCallback.onSuccess(parseFromJSONObject);
                parseFromJSONObject.setCacheTime(System.currentTimeMillis() / 1000);
                parseFromJSONObject.setIsLocalData(true);
                SapiContext.getInstance().setUserAttrInfo(str4, parseFromJSONObject.toJsonStr());
            }
        });
    }

    public void getUserInfo(GetUserInfoCallback getUserInfoCallback, String str, String str2, String str3) {
        String str4;
        SapiUtils.notNull(getUserInfoCallback, GetUserInfoCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        SapiAccount accountFromBduss = SapiContext.getInstance().getAccountFromBduss(str);
        if (accountFromBduss != null) {
            str4 = accountFromBduss.ptoken;
        } else {
            str4 = null;
        }
        getUserInfo(getUserInfoCallback, str, str4, str2, str3);
    }

    public void getUserInfo(String str, String str2, String str3, String str4, final NetCallback netCallback) {
        SapiUtils.notNull(netCallback, "callback can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("bduss", str);
        if (!TextUtils.isEmpty(str3)) {
            httpHashMapWrap.put("login_type", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            httpHashMapWrap.put("log_extra", str4);
        }
        if (!TextUtils.isEmpty(str2)) {
            httpHashMapWrap.put("ptoken", str2);
        }
        String deviceInfo = SapiDeviceInfo.getDeviceInfo(SapiEnv.GET_USER_INFO_URI);
        if (!TextUtils.isEmpty(deviceInfo)) {
            httpHashMapWrap.put(AppIconSetting.DEFAULT_LARGE_ICON, deviceInfo);
        }
        new HttpClientWrap().post(SapiEnv.GET_USER_INFO_URI, httpHashMapWrap, null, getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.SapiAccountRepository.5
            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str5) {
                netCallback.onFailure(th, i, str5);
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i, String str5) {
                netCallback.onSuccess(i, str5);
            }
        });
    }

    public void handleDynamicPwdLogin(int i, SapiCallBack<SapiAccountResponse> sapiCallBack, String str, boolean z, SapiDataEncryptor sapiDataEncryptor) {
        if (str != null) {
            SapiAccountResponse sapiAccountResponse = new SapiAccountResponse();
            try {
                String optString = new JSONObject(str).optString(TableDefine.DB_TABLE_USERINFO);
                JSONObject jSONObject = null;
                if (!TextUtils.isEmpty(optString)) {
                    jSONObject = new JSONObject(sapiDataEncryptor.decrypt(optString));
                    sapiAccountResponse.displayname = jSONObject.optString("displayname");
                    sapiAccountResponse.username = jSONObject.optString("uname");
                    sapiAccountResponse.uid = jSONObject.optString("uid");
                    sapiAccountResponse.email = jSONObject.optString("email");
                    sapiAccountResponse.bduss = jSONObject.optString("bduss");
                    sapiAccountResponse.ptoken = jSONObject.optString("ptoken");
                    sapiAccountResponse.stoken = jSONObject.optString("stoken");
                    sapiAccountResponse.authSid = jSONObject.optString("authsid");
                }
                if (sapiCallBack != null) {
                    if (i != 0) {
                        sapiCallBack.onSystemError(i);
                        return;
                    }
                    if (z) {
                        SapiAccount responseToAccount = responseToAccount(sapiAccountResponse);
                        responseToAccount.addDispersionCertification(SapiAccount.DispersionCertification.fromJSONObject(jSONObject).tplStokenMap);
                        responseToAccount.putExtra("tpl", this.configuration.tpl);
                        SapiAccountManager.getInstance().validate(responseToAccount);
                    }
                    sapiCallBack.onSuccess(sapiAccountResponse);
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

    public void loadOneKeyLogin(final OneKeyLoginCallback oneKeyLoginCallback, String str, String str2, final boolean z, final LoadExternalWebViewActivityCallback loadExternalWebViewActivityCallback) {
        JSONObject jSONObject = new JSONObject();
        try {
            String operatorType = new OneKeyLoginSdkCall().getOperatorType();
            jSONObject.put("token", str);
            jSONObject.put("tpl", this.configuration.tpl);
            jSONObject.put(CommandUBCHelper.COMMAND_UBC_STATISTICS_SOURCE_VALUE_CLIENT, "android");
            jSONObject.put("clientfrom", "native");
            jSONObject.put("appid", OneKeyLoginSdkCall.oneKeyLoginAppKey);
            jSONObject.put("operator", operatorType);
            jSONObject.put("scene", "api");
            jSONObject.put("sign", str2);
            if ("CU".equals(operatorType)) {
                jSONObject.put("CUVersion", "2");
            }
        } catch (JSONException e) {
            Log.e(e);
        }
        String oneKeyLoginJsCode = SapiContext.getInstance().getOneKeyLoginJsCode();
        String str3 = OneKeyLoginResult.secondJsCode;
        final long currentTimeMillis = System.currentTimeMillis();
        OneKeyLoginStat.LoadLogin.statExtMap.put("netType", SapiUtils.getNetworkClass(this.configuration.context));
        OneKeyLoginStat.LoadLogin.statExtMap.put("operator", zj1.d().c(this.configuration.context));
        SapiCoreUtil.executeJsCode(oneKeyLoginJsCode, str3, jSONObject.toString(), this.configuration.context, new ExecuteJsCallback() { // from class: com.baidu.sapi2.SapiAccountRepository.19
            @Override // com.baidu.sapi2.callback.inner.ExecuteJsCallback
            public void jsExecuteCompleted(String str4) {
                OneKeyLoginStat.OauthToken.statExtMap.put(OneKeyLoginStat.LoadLogin.KEY_EXT_DUR_JS, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                JSONObject jSONObject2 = null;
                if (!TextUtils.isEmpty(str4)) {
                    try {
                        jSONObject2 = new JSONObject(str4);
                    } catch (JSONException e2) {
                        OneKeyLoginStat.LoadLogin.statExtMap.put("code", "JSONException");
                        OneKeyLoginStat.LoadLogin.sValue = "0";
                        OneKeyLoginStat.LoadLogin.upload();
                        Log.e(e2);
                    }
                    HttpHashMap httpHashMap = new HttpHashMap();
                    if (jSONObject2 != null) {
                        Iterator<String> keys = jSONObject2.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            httpHashMap.put(next, jSONObject2.optString(next));
                        }
                    }
                    httpHashMap.put("oneKeySdkVersion", DefaultDiskStorage.DEFAULT_DISK_STORAGE_VERSION_PREFIX);
                    if (z) {
                        httpHashMap.put("yyNormalOneKey", "1");
                    }
                    String loadOneKeyLoginUrl = SapiAccountRepository.this.getLoadOneKeyLoginUrl();
                    List<HttpCookie> buildNaCookie = ParamsUtil.buildNaCookie(loadOneKeyLoginUrl, SapiAccountRepository.this.configuration);
                    final long currentTimeMillis2 = System.currentTimeMillis();
                    new HttpClientWrap().post(loadOneKeyLoginUrl, httpHashMap, buildNaCookie, SapiAccountRepository.this.getUaInfo(), new HttpHandlerWrap(Looper.getMainLooper()) { // from class: com.baidu.sapi2.SapiAccountRepository.19.1
                        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                        public void onFailure(Throwable th, int i, String str5) {
                            OneKeyLoginStat.LoadLogin.statExtMap.put("dur", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                            OneKeyLoginStat.LoadLogin.statExtMap.put("code", Integer.valueOf(i));
                            OneKeyLoginStat.LoadLogin.sValue = "0";
                            OneKeyLoginStat.LoadLogin.upload();
                            String str6 = SapiAccountRepository.TAG;
                            Log.d(str6, "onFailure, error = " + th + ", errorCode = " + i + ", responseBody = " + str5);
                            new OneKeyLoginSdkCall().loadOneKeyLoginFail(oneKeyLoginCallback, -100, null);
                            SapiStatUtil.statOneKeyLoginPassAction(0, "-114", "net error");
                        }

                        /* JADX WARN: Removed duplicated region for block: B:43:0x0128 A[Catch: Exception -> 0x015c, TryCatch #0 {Exception -> 0x015c, blocks: (B:3:0x003f, B:6:0x006a, B:8:0x0077, B:10:0x009a, B:9:0x008e, B:12:0x009e, B:15:0x00a8, B:17:0x00b0, B:20:0x00b9, B:22:0x00c1, B:25:0x00ca, B:27:0x00d2, B:29:0x00d8, B:30:0x00de, B:32:0x00f2, B:34:0x0106, B:36:0x010c, B:41:0x0122, B:43:0x0128, B:45:0x0158, B:44:0x0141, B:38:0x0115, B:40:0x011b), top: B:50:0x003f }] */
                        /* JADX WARN: Removed duplicated region for block: B:44:0x0141 A[Catch: Exception -> 0x015c, TryCatch #0 {Exception -> 0x015c, blocks: (B:3:0x003f, B:6:0x006a, B:8:0x0077, B:10:0x009a, B:9:0x008e, B:12:0x009e, B:15:0x00a8, B:17:0x00b0, B:20:0x00b9, B:22:0x00c1, B:25:0x00ca, B:27:0x00d2, B:29:0x00d8, B:30:0x00de, B:32:0x00f2, B:34:0x0106, B:36:0x010c, B:41:0x0122, B:43:0x0128, B:45:0x0158, B:44:0x0141, B:38:0x0115, B:40:0x011b), top: B:50:0x003f }] */
                        @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public void onSuccess(int i, String str5, HashMap<String, String> hashMap) {
                            String optString;
                            OneKeyLoginStat.LoadLogin.statExtMap.put("dur", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                            Log.d(SapiAccountRepository.TAG, "onSuccess, statusCode = " + i + ", response = " + str5);
                            try {
                                JSONObject jSONObject3 = new JSONObject(str5);
                                JSONObject optJSONObject = jSONObject3.optJSONObject("errInfo");
                                String optString2 = optJSONObject.optString("no");
                                String optString3 = optJSONObject.optString("msg");
                                SapiStatUtil.statOneKeyLoginPassAction(0, optString2, optString3);
                                OneKeyLoginStat.LoadLogin.statExtMap.put("code", optString2);
                                OneKeyLoginStat.LoadLogin.sValue = "1";
                                if (!"0".equals(optString2)) {
                                    String str6 = "";
                                    if (!"400101".equals(optString2) && !"400031".equals(optString2) && !"400023".equals(optString2)) {
                                        if (!"400704".equals(optString2) && !"400706".equals(optString2)) {
                                            if ("400801".equals(optString2)) {
                                                JSONObject optJSONObject2 = jSONObject3.optJSONObject("data");
                                                if (optJSONObject2 != null) {
                                                    str6 = optJSONObject2.optString("mobile");
                                                }
                                                new OneKeyLoginSdkCall().transMobile(oneKeyLoginCallback, Integer.parseInt(optString2), str6);
                                                OneKeyLoginStat.LoadLogin.upload();
                                                return;
                                            }
                                            new OneKeyLoginSdkCall().loadOneKeyLoginFail(oneKeyLoginCallback, Integer.parseInt(optString2), optString3);
                                            OneKeyLoginStat.LoadLogin.upload();
                                            return;
                                        }
                                        JSONObject optJSONObject3 = jSONObject3.optJSONObject("data");
                                        if (optJSONObject3 != null) {
                                            optString = optJSONObject3.optString("ppDatau");
                                            if (TextUtils.isEmpty(optString)) {
                                                OneKeyLoginResult oneKeyLoginResult = new OneKeyLoginResult();
                                                oneKeyLoginResult.setResultCode(-104);
                                                oneKeyLoginCallback.onGuideProcess(oneKeyLoginResult);
                                                loadExternalWebViewActivityCallback.needLoadExternalWebView("", optString);
                                            } else {
                                                new OneKeyLoginSdkCall().loadOneKeyLoginFail(oneKeyLoginCallback, -100, null);
                                                OneKeyLoginStat.LoadLogin.statExtMap.put("code", -100);
                                                OneKeyLoginStat.LoadLogin.sValue = "0";
                                            }
                                            OneKeyLoginStat.LoadLogin.upload();
                                            return;
                                        }
                                        optString = null;
                                        if (TextUtils.isEmpty(optString)) {
                                        }
                                        OneKeyLoginStat.LoadLogin.upload();
                                        return;
                                    }
                                    JSONObject optJSONObject4 = jSONObject3.optJSONObject("data");
                                    if (optJSONObject4 != null) {
                                        optString = optJSONObject4.optString("verifyUrl");
                                        if (TextUtils.isEmpty(optString)) {
                                        }
                                        OneKeyLoginStat.LoadLogin.upload();
                                        return;
                                    }
                                    optString = null;
                                    if (TextUtils.isEmpty(optString)) {
                                    }
                                    OneKeyLoginStat.LoadLogin.upload();
                                    return;
                                }
                                SapiAccountRepository.this.setOneKeyLoginCookies(hashMap);
                                JSONObject optJSONObject5 = jSONObject3.optJSONObject("data");
                                if (optJSONObject5 != null) {
                                    SapiAccountManager.getInstance().getAccountService().handleOneKeyLoginResult(oneKeyLoginCallback, optJSONObject5.optString("xml"));
                                } else {
                                    new OneKeyLoginSdkCall().loadOneKeyLoginFail(oneKeyLoginCallback, -100, null);
                                }
                                OneKeyLoginStat.LoadLogin.upload();
                            } catch (Exception e3) {
                                Log.e(e3);
                                new OneKeyLoginSdkCall().loadOneKeyLoginFail(oneKeyLoginCallback, -100, null);
                                SapiStatUtil.statOneKeyLoginPassAction(0, "-113", "json error");
                                OneKeyLoginStat.LoadLogin.statExtMap.put("code", e3.getMessage());
                                OneKeyLoginStat.LoadLogin.sValue = "0";
                                OneKeyLoginStat.LoadLogin.upload();
                            }
                        }
                    });
                    return;
                }
                Log.e(SapiAccountRepository.TAG, "oneKeyLogin execute JavaScript failed, it only support after KitKat version");
                new OneKeyLoginSdkCall().loadOneKeyLoginFail(oneKeyLoginCallback, -107, null);
                SapiStatUtil.statOneKeyLoginPassAction(-1, MusicData.MUSIC_NORMAL_ID, "js execute fail");
                OneKeyLoginStat.LoadLogin.statExtMap.put("code", -107);
                OneKeyLoginStat.LoadLogin.sValue = "0";
                OneKeyLoginStat.LoadLogin.upload();
            }
        });
    }

    public void web2NativeLogin(final Web2NativeLoginCallback web2NativeLoginCallback, boolean z) {
        String str;
        SapiUtils.notNull(web2NativeLoginCallback, Web2NativeLoginCallback.class.getSimpleName() + " can't be null");
        final Web2NativeLoginResult web2NativeLoginResult = new Web2NativeLoginResult();
        final String cookieBduss = SapiUtils.getCookieBduss();
        final String cookiePtoken = SapiUtils.getCookiePtoken();
        if (TextUtils.isEmpty(cookieBduss)) {
            web2NativeLoginResult.setResultCode(-101);
            web2NativeLoginCallback.onBdussEmpty(web2NativeLoginResult);
            return;
        }
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        String str2 = "";
        if (currentAccount == null) {
            str = "";
        } else {
            str2 = currentAccount.bduss;
            str = currentAccount.ptoken;
        }
        if (cookieBduss.equals(str2) && !TextUtils.isEmpty(cookiePtoken) && cookiePtoken.equals(str)) {
            web2NativeLoginResult.setResultCode(0);
            web2NativeLoginCallback.onSuccess(web2NativeLoginResult);
        } else if (SapiAccountManager.getInstance().isLogin() && !z) {
            SapiAccount currentAccount2 = SapiContext.getInstance().getCurrentAccount();
            if (!cookieBduss.equals(currentAccount2.bduss)) {
                SapiAccountManager.getInstance().getAccountService().webLogin(this.configuration.context, currentAccount2.bduss);
            }
            web2NativeLoginResult.setResultCode(0);
            web2NativeLoginCallback.onSuccess(web2NativeLoginResult);
        } else {
            getUserInfo(new GetUserInfoCallback() { // from class: com.baidu.sapi2.SapiAccountRepository.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.LoginStatusAware
                public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                    web2NativeLoginResult.setResultCode(400021);
                    web2NativeLoginCallback.onBdussExpired(web2NativeLoginResult);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFailure(GetUserInfoResult getUserInfoResult) {
                    web2NativeLoginResult.setResultCode(-202);
                    web2NativeLoginCallback.onFailure(web2NativeLoginResult);
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFinish() {
                    web2NativeLoginCallback.onFinish();
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onStart() {
                    web2NativeLoginCallback.onStart();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onSuccess(GetUserInfoResult getUserInfoResult) {
                    SapiAccount sapiAccount = new SapiAccount();
                    sapiAccount.uid = getUserInfoResult.uid;
                    sapiAccount.username = getUserInfoResult.username;
                    sapiAccount.displayname = getUserInfoResult.displayname;
                    sapiAccount.bduss = cookieBduss;
                    if (!TextUtils.isEmpty(cookiePtoken)) {
                        sapiAccount.ptoken = cookiePtoken;
                    }
                    sapiAccount.app = SapiUtils.getAppName(SapiAccountRepository.this.configuration.context);
                    SapiAccountManager.getInstance().validate(sapiAccount);
                    web2NativeLoginResult.setResultCode(0);
                    web2NativeLoginCallback.onSuccess(web2NativeLoginResult);
                    new PtokenStat().onEvent(PtokenStat.WEB_2_NATIVE);
                }
            }, cookieBduss);
        }
    }
}
