package com.baidu.sapi2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.callback.FillUsernameCallback;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.callback.IqiyiLoginCallback;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.callback.SsoHashCallback;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.sapi2.dto.IqiyiLoginDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.sapi2.result.CheckUserFaceIdResult;
import com.baidu.sapi2.result.FaceLoginStatusResult;
import com.baidu.sapi2.result.FillUsernameResult;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.result.IqiyiLoginResult;
import com.baidu.sapi2.result.OAuthResult;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.Web2NativeLoginResult;
import com.baidu.sapi2.share.SapiShareClient;
import com.baidu.sapi2.shell.callback.SapiCallBack;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SapiResponse;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiDataEncryptor;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiDeviceUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import java.io.UnsupportedEncodingException;
import java.net.HttpCookie;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
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
/* loaded from: classes19.dex */
public final class L {
    private static final String a = "L";
    private static final int b = 6;
    private static final String c = "3";
    private SapiConfiguration d = SapiAccountManager.getInstance().getSapiConfiguration();

    private Domain v() {
        return this.d.environment;
    }

    private String w() {
        return "/sslcrypt/get_last_cert";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String x() {
        return "tpl:" + this.d.tpl + ";android_sapi_v" + SapiAccountManager.VERSION_NAME;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.put("accesstoken", str);
            new HttpClientWrap().post(com.baidu.sapi2.utils.h.z, httpHashMapWrap, null, x(), new s(this, Looper.getMainLooper()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d() {
        return v().getWap() + "/v4/security";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String e() {
        return v().getWap() + "/wp/v3/ucenter/realnameverify";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String f() {
        return v().getWap() + "/v6/shippingAddress";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String g() {
        return v().getURL() + com.baidu.sapi2.utils.h.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String h() {
        return v().getURL() + com.baidu.sapi2.utils.h.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String i() {
        return v().getURL() + "/phoenix/account/ssologin";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String j() {
        return v().getURL() + "/phoenix/account/ssologin";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String k() {
        return v().getWap() + "/v6/invoiceManage";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String l() {
        return v().getWap() + com.baidu.sapi2.utils.h.L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String m() {
        return v().getURL() + com.baidu.sapi2.utils.h.B;
    }

    String n() {
        return v().getWap() + com.baidu.sapi2.utils.h.K;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String o() {
        return v().getWap() + com.baidu.sapi2.utils.h.M;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String p() {
        return v().getWap() + "/wp/unitewidget";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String q() {
        return v().getWap() + "/passport/getpass";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String r() {
        return v().getWap() + "/passport/login";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String s() {
        return v().getWap() + "/wp/wappassword";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String t() {
        return v().getWap() + "/wp/recordindex";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String u() {
        return v().getWap() + "/v3/login/api/login";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(SapiCallback<OAuthResult> sapiCallback, String str, String str2) {
        SapiUtils.notNull(sapiCallback, SapiCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        OAuthResult oAuthResult = new OAuthResult();
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        if (!TextUtils.isEmpty(str2)) {
            httpHashMapWrap.put("openPlatformId", str2);
        }
        httpHashMapWrap.put("bduss", str);
        new HttpClientWrap().post(com.baidu.sapi2.utils.h.u, httpHashMapWrap, null, x(), new I(this, Looper.getMainLooper(), sapiCallback, oAuthResult));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() {
        return v().getWap() + "/wp/v3/ucenter/index";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Web2NativeLoginCallback web2NativeLoginCallback, boolean z) {
        SapiUtils.notNull(web2NativeLoginCallback, Web2NativeLoginCallback.class.getSimpleName() + " can't be null");
        Web2NativeLoginResult web2NativeLoginResult = new Web2NativeLoginResult();
        String cookieBduss = SapiUtils.getCookieBduss();
        String cookiePtoken = SapiUtils.getCookiePtoken();
        if (TextUtils.isEmpty(cookieBduss)) {
            web2NativeLoginResult.setResultCode(-101);
            web2NativeLoginCallback.onBdussEmpty(web2NativeLoginResult);
            return;
        }
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        String str = "";
        String str2 = "";
        if (currentAccount != null) {
            str = currentAccount.bduss;
            str2 = currentAccount.ptoken;
        }
        if (cookieBduss.equals(str) && !TextUtils.isEmpty(cookiePtoken) && cookiePtoken.equals(str2)) {
            web2NativeLoginResult.setResultCode(0);
            web2NativeLoginCallback.onSuccess(web2NativeLoginResult);
        } else if (SapiAccountManager.getInstance().isLogin() && !z) {
            SapiAccount currentAccount2 = SapiContext.getInstance().getCurrentAccount();
            if (!cookieBduss.equals(currentAccount2.bduss)) {
                SapiAccountManager.getInstance().getAccountService().webLogin(this.d.context, currentAccount2.bduss);
            }
            web2NativeLoginResult.setResultCode(0);
            web2NativeLoginCallback.onSuccess(web2NativeLoginResult);
        } else {
            a((GetUserInfoCallback) new C(this, web2NativeLoginResult, web2NativeLoginCallback, cookieBduss, cookiePtoken), cookieBduss);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(SapiCallBack<SapiResponse> sapiCallBack, String str) {
        try {
            int parseInt = Integer.parseInt(new JSONObject(str).optString(BaseJsonData.TAG_ERRNO));
            if (parseInt != 0) {
                sapiCallBack.onSystemError(parseInt);
            } else {
                SapiResponse sapiResponse = new SapiResponse();
                sapiResponse.errorCode = parseInt;
                sapiResponse.errorMsg = "短信验证码发送成功";
                sapiCallBack.onSuccess(sapiResponse);
            }
        } catch (Exception e) {
            sapiCallBack.onSystemError(-100);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(String str) {
        try {
            return new JSONObject(str).getInt(BaseJsonData.TAG_ERRNO);
        } catch (Exception e) {
            Log.e(e);
            return -100;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(SapiCallBack<SapiAccountResponse> sapiCallBack, String str, String str2, boolean z) {
        SapiConfiguration sapiConfiguration = this.d;
        if (sapiConfiguration != null && sapiConfiguration.context != null) {
            SapiUtils.notNull(sapiCallBack, SapiCallBack.class.getSimpleName() + " can't be null");
            new HttpClientWrap().get(w(), null, null, x(), new D(this, Looper.getMainLooper(), sapiCallBack, z, new SapiDataEncryptor(), str, str2));
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SapiCallBack<SapiAccountResponse> sapiCallBack, String str, String str2, String str3, String str4, boolean z, SapiDataEncryptor sapiDataEncryptor) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, CertificateException, JSONException {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("crypttype", "6");
        String deviceInfo = SapiDeviceInfo.getDeviceInfo(com.baidu.sapi2.utils.h.a);
        if (!TextUtils.isEmpty(deviceInfo)) {
            httpHashMapWrap.put(AppIconSetting.DEFAULT_LARGE_ICON, deviceInfo);
        }
        httpHashMapWrap.put("cert_id", str2);
        httpHashMapWrap.put("isdpass", "1");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("username", str3);
        jSONObject.put("isphone", "1");
        jSONObject.put("password", str4);
        jSONObject.put(Constants.KEY_LOGIN_TYPE, "3");
        jSONObject.put("key", sapiDataEncryptor.getAESKey());
        jSONObject.put(SapiContext.KEY_SDK_VERSION, "2");
        jSONObject.put("pinfo", SapiDeviceUtils.b());
        httpHashMapWrap.put(TableDefine.DB_TABLE_USERINFO, sapiDataEncryptor.encrypt(str, jSONObject.toString()));
        new HttpClientWrap().post(com.baidu.sapi2.utils.h.a, httpHashMapWrap, null, x(), new E(this, Looper.getMainLooper(), sapiCallBack, z, sapiDataEncryptor));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, SapiCallBack<SapiAccountResponse> sapiCallBack, String str, boolean z, SapiDataEncryptor sapiDataEncryptor) {
        if (str == null) {
            if (sapiCallBack != null) {
                sapiCallBack.onSystemError(i);
                return;
            }
            return;
        }
        SapiAccountResponse sapiAccountResponse = new SapiAccountResponse();
        try {
            String optString = new JSONObject(str).optString(TableDefine.DB_TABLE_USERINFO);
            JSONObject jSONObject = null;
            if (!TextUtils.isEmpty(optString)) {
                jSONObject = new JSONObject(sapiDataEncryptor.decrypt(optString));
                sapiAccountResponse.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
                sapiAccountResponse.username = jSONObject.optString(BdStatsConstant.StatsKey.UNAME);
                sapiAccountResponse.uid = jSONObject.optString("uid");
                sapiAccountResponse.email = jSONObject.optString(NotificationCompat.CATEGORY_EMAIL);
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
                    SapiAccount a2 = a(sapiAccountResponse);
                    a2.addDispersionCertification(SapiAccount.DispersionCertification.fromJSONObject(jSONObject).tplStokenMap);
                    a2.putExtra("tpl", this.d.tpl);
                    SapiShareClient.getInstance().validate(a2);
                }
                sapiCallBack.onSuccess(sapiAccountResponse);
            }
        } catch (Exception e) {
            Log.e(e);
            if (sapiCallBack != null) {
                sapiCallBack.onSystemError(-100);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(GetUserInfoCallback getUserInfoCallback, String str) {
        SapiUtils.notNull(getUserInfoCallback, GetUserInfoCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        GetUserInfoResult getUserInfoResult = new GetUserInfoResult();
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("bduss", str);
        SapiAccount accountFromBduss = SapiContext.getInstance().getAccountFromBduss(str);
        if (accountFromBduss != null && !TextUtils.isEmpty(accountFromBduss.ptoken)) {
            httpHashMapWrap.put("ptoken", accountFromBduss.ptoken);
        }
        String deviceInfo = SapiDeviceInfo.getDeviceInfo(com.baidu.sapi2.utils.h.b);
        if (!TextUtils.isEmpty(deviceInfo)) {
            httpHashMapWrap.put(AppIconSetting.DEFAULT_LARGE_ICON, deviceInfo);
        }
        new HttpClientWrap().post(com.baidu.sapi2.utils.h.b, httpHashMapWrap, null, x(), new F(this, Looper.getMainLooper(), getUserInfoCallback, getUserInfoResult));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(FillUsernameCallback fillUsernameCallback, String str, String str2) {
        SapiUtils.notNull(fillUsernameCallback, FillUsernameCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        SapiUtils.notEmpty(str2, "username can't be empty");
        FillUsernameResult fillUsernameResult = new FillUsernameResult();
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("cert_id", String.valueOf(1));
        httpHashMapWrap.put("crypttype", String.valueOf(6));
        JSONObject jSONObject = new JSONObject();
        SapiDataEncryptor sapiDataEncryptor = new SapiDataEncryptor();
        try {
            jSONObject.put("bduss", str);
            if (!TextUtils.isEmpty(this.d.clientId)) {
                jSONObject.put("clientid", this.d.clientId);
            }
            if (!TextUtils.isEmpty(this.d.clientIp)) {
                jSONObject.put("clientip", this.d.clientIp);
            }
            jSONObject.put("username", str2);
            jSONObject.put("key", sapiDataEncryptor.getAESKey());
            httpHashMapWrap.put(TableDefine.DB_TABLE_USERINFO, sapiDataEncryptor.encrypt("-----BEGIN CERTIFICATE-----\nMIIFKDCCBBCgAwIBAgIQaG9YabPddabIY+N5IoXttzANBgkqhkiG9w0BAQUFADCB\nvDELMAkGA1UEBhMCVVMxFzAVBgNVBAoTDlZlcmlTaWduLCBJbmMuMR8wHQYDVQQL\nExZWZXJpU2lnbiBUcnVzdCBOZXR3b3JrMTswOQYDVQQLEzJUZXJtcyBvZiB1c2Ug\nYXQgaHR0cHM6Ly93d3cudmVyaXNpZ24uY29tL3JwYSAoYykxMDE2MDQGA1UEAxMt\nVmVyaVNpZ24gQ2xhc3MgMyBJbnRlcm5hdGlvbmFsIFNlcnZlciBDQSAtIEczMB4X\nDTEwMTIwMzAwMDAwMFoXDTEyMTIwMjIzNTk1OVowga8xCzAJBgNVBAYTAkNOMRAw\nDgYDVQQIEwdCZWlqaW5nMRAwDgYDVQQHFAdCZWlqaW5nMTkwNwYDVQQKFDBCZWlK\naW5nIEJhaWR1IE5ldGNvbSBTY2llbmNlIFRlY2hub2xvZ3kgQ28uLCBMdGQxJTAj\nBgNVBAsUHHNlcnZpY2Ugb3BlcmF0aW9uIGRlcGFydG1lbnQxGjAYBgNVBAMUEW9w\nZW5hcGkuYmFpZHUuY29tMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC68R1G\nWkkVvvjBOGKHOoyLxdtEcxBiVOGG8lvXTckB8jNrg4tihQzql+fJbr/X8V9MqQLw\nzzOyQViYlW+/GhC6u1jrP6t3Br0Wy8HyThDnvOAWyPFEawgbIywT20F41Iqayled\n/DQ/JCDWcNA7+xX56rqEcQd+6baNAiu9o962PwIDAQABo4IBszCCAa8wCQYDVR0T\nBAIwADALBgNVHQ8EBAMCBaAwQQYDVR0fBDowODA2oDSgMoYwaHR0cDovL1NWUklu\ndGwtRzMtY3JsLnZlcmlzaWduLmNvbS9TVlJJbnRsRzMuY3JsMEQGA1UdIAQ9MDsw\nOQYLYIZIAYb4RQEHFwMwKjAoBggrBgEFBQcCARYcaHR0cHM6Ly93d3cudmVyaXNp\nZ24uY29tL3JwYTAoBgNVHSUEITAfBglghkgBhvhCBAEGCCsGAQUFBwMBBggrBgEF\nBQcDAjByBggrBgEFBQcBAQRmMGQwJAYIKwYBBQUHMAGGGGh0dHA6Ly9vY3NwLnZl\ncmlzaWduLmNvbTA8BggrBgEFBQcwAoYwaHR0cDovL1NWUkludGwtRzMtYWlhLnZl\ncmlzaWduLmNvbS9TVlJJbnRsRzMuY2VyMG4GCCsGAQUFBwEMBGIwYKFeoFwwWjBY\nMFYWCWltYWdlL2dpZjAhMB8wBwYFKw4DAhoEFEtruSiWBgy70FI4mymsSweLIQUY\nMCYWJGh0dHA6Ly9sb2dvLnZlcmlzaWduLmNvbS92c2xvZ28xLmdpZjANBgkqhkiG\n9w0BAQUFAAOCAQEAgNIl8/QIKP4KWWWj6ltL6lVknoGlpUIoowvnv+57H7FdEYJb\n9zQewrAqoFkblB0mMiUEGdJOa7YxKKJialqz6KnlMrHQMAsB641BHLDESvLjuhio\nUsWmvBowIK92HQ2H9N01U8d1i5rTz5wwFK+Nvue/61tzCTTmbRgBuGPotQ/tcA+g\nYCNuEIHsJMbWiX9O3gflnMdRME7z9Hw9zMogt+lz7GudP/AO1K6sZ6VnQ931Gv1e\nIOmPCPfvO/Kw/aXSacoEWnMsy+qTIewVPT/MMgSaq9JewAQgLpMX+O5qqAJBYoDj\nxoZnHufGgOIKfNmSvYiHjDFJtP55PdEH21q+JA==\n-----END CERTIFICATE-----", jSONObject.toString()));
            new HttpClientWrap().post(com.baidu.sapi2.utils.h.n, httpHashMapWrap, null, x(), new G(this, Looper.getMainLooper(), fillUsernameCallback, fillUsernameResult, sapiDataEncryptor));
        } catch (Throwable th) {
            fillUsernameResult.setResultCode(-202);
            fillUsernameCallback.onFailure(fillUsernameResult);
            Log.e(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(String str, List<String> list) {
        SapiUtils.notEmpty(str, "bduss can't be empty");
        if (list != null && !list.isEmpty()) {
            return a(SapiContext.getInstance().getAccountFromBduss(str), list);
        }
        throw new IllegalArgumentException("targetTplList can't be null or empty");
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
    public Map<String, String> a(GetTplStokenCallback getTplStokenCallback, String str, List<String> list, boolean z) {
        SapiUtils.notNull(getTplStokenCallback, GetTplStokenCallback.class.getSimpleName() + " can't be null");
        GetTplStokenResult getTplStokenResult = new GetTplStokenResult();
        if (list != null && !list.isEmpty()) {
            SapiAccount accountFromBduss = SapiContext.getInstance().getAccountFromBduss(str);
            if (accountFromBduss == null) {
                getTplStokenResult.setResultCode(-301);
                getTplStokenCallback.onFailure(getTplStokenResult);
                return getTplStokenResult.tplStokenMap;
            }
            String str2 = accountFromBduss.ptoken;
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
                        return getTplStokenResult.tplStokenMap;
                    }
                } catch (JSONException e) {
                    Log.e(e);
                    getTplStokenResult.setResultCode(-304);
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
            httpHashMapWrap.put("sign", SecurityUtil.md5((this.d.appId + this.d.tpl + str + this.d.appSignKey).getBytes(), false));
            httpHashMapWrap.put("return_type", "1");
            if (!TextUtils.isEmpty(str2)) {
                httpHashMapWrap.put("ptoken", str2);
            }
            httpHashMapWrap.put("tpl_list", str3);
            new HttpClientWrap().post(com.baidu.sapi2.utils.h.v, httpHashMapWrap, null, x(), new H(this, Looper.getMainLooper(), getTplStokenCallback, getTplStokenResult, accountFromBduss, list, z, str2));
            return getTplStokenResult.tplStokenMap;
        }
        getTplStokenResult.setResultCode(-302);
        getTplStokenResult.setResultMsg("参数错误，请稍后再试");
        getTplStokenCallback.onFailure(getTplStokenResult);
        return getTplStokenResult.tplStokenMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(SapiCallBack<SapiResponse> sapiCallBack, String str) {
        Context context;
        SapiConfiguration sapiConfiguration = this.d;
        if (sapiConfiguration == null || (context = sapiConfiguration.context) == null) {
            return false;
        }
        if (!SapiUtils.hasActiveNetwork(context)) {
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
            httpHashMapWrap.put("username", str);
            new HttpClientWrap().post(com.baidu.sapi2.utils.h.o, httpHashMapWrap, null, x(), new J(this, Looper.getMainLooper(), sapiCallBack));
            return true;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(IqiyiLoginCallback iqiyiLoginCallback, IqiyiLoginDTO iqiyiLoginDTO) {
        if (iqiyiLoginCallback != null) {
            iqiyiLoginCallback.onStart();
            String str = iqiyiLoginDTO.accessToken;
            String str2 = iqiyiLoginDTO.phoneNum;
            String str3 = iqiyiLoginDTO.openID;
            IqiyiLoginResult iqiyiLoginResult = new IqiyiLoginResult();
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            boolean z = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) ? false : true;
            if (z || currentAccount != null) {
                if (z && currentAccount == null) {
                    a(iqiyiLoginCallback, iqiyiLoginDTO, iqiyiLoginResult);
                    return;
                } else {
                    SapiAccountManager.getInstance().getAccountService().getUserInfo(new K(this, iqiyiLoginCallback, iqiyiLoginDTO, iqiyiLoginResult, str2), currentAccount.bduss);
                    return;
                }
            }
            iqiyiLoginCallback.onLogin(iqiyiLoginResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(IqiyiLoginCallback iqiyiLoginCallback, IqiyiLoginDTO iqiyiLoginDTO, IqiyiLoginResult iqiyiLoginResult) {
        if (!TextUtils.isEmpty(iqiyiLoginDTO.accessToken) && !TextUtils.isEmpty(iqiyiLoginDTO.openID)) {
            HttpHashMapWrap a2 = a(j());
            if (!TextUtils.isEmpty(iqiyiLoginDTO.phoneNum)) {
                a2.put("crypt_m", iqiyiLoginDTO.phoneNum);
            }
            a2.put("access_token", iqiyiLoginDTO.accessToken);
            a2.put("osuid", iqiyiLoginDTO.openID);
            a2.put("json", "1");
            a2.put("type", SocialType.IQIYI.getType() + "");
            a2.put("act", "special");
            a2.put("display", "native");
            new HttpClientWrap().get(j(), a2, null, x(), new r(this, Looper.getMainLooper(), iqiyiLoginCallback, iqiyiLoginResult));
            return;
        }
        iqiyiLoginCallback.onLogin(iqiyiLoginResult);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SapiCallback<CheckUserFaceIdResult> sapiCallback, String str, Map<String, String> map) {
        SapiUtils.notNull(sapiCallback, SapiCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        HttpHashMapWrap a2 = a(com.baidu.sapi2.utils.h.C);
        a2.put("clientfrom", "native");
        a2.put("bduss", str);
        if (map != null && !map.isEmpty()) {
            a2.putAll(map);
        }
        new HttpClientWrap().post(com.baidu.sapi2.utils.h.C, a2, null, x(), new t(this, Looper.getMainLooper(), sapiCallback, new CheckUserFaceIdResult()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SapiCallback<FaceLoginStatusResult> sapiCallback, String str) {
        SapiAccount currentAccount;
        if (SapiContext.getInstance().getSapiOptions().q().contains(SapiAccountManager.getInstance().getConfignation().tpl) && (currentAccount = SapiContext.getInstance().getCurrentAccount()) != null) {
            str = currentAccount.bduss;
        }
        SapiUtils.notNull(sapiCallback, SapiCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        HttpHashMapWrap a2 = a(com.baidu.sapi2.utils.h.E);
        a2.put("clientfrom", "native");
        a2.put("bduss", str);
        new HttpClientWrap().post(com.baidu.sapi2.utils.h.E, a2, null, x(), new u(this, Looper.getMainLooper(), sapiCallback, new FaceLoginStatusResult()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SapiCallback<SapiResult> sapiCallback, String str, boolean z, String str2) {
        SapiAccount currentAccount;
        if (SapiContext.getInstance().getSapiOptions().q().contains(SapiAccountManager.getInstance().getConfignation().tpl) && (currentAccount = SapiContext.getInstance().getCurrentAccount()) != null) {
            str = currentAccount.bduss;
        }
        SapiUtils.notNull(sapiCallback, SapiCallback.class.getSimpleName() + " can't be null");
        SapiUtils.notEmpty(str, "bduss can't be empty");
        HttpHashMapWrap a2 = a(com.baidu.sapi2.utils.h.E);
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
        new HttpClientWrap().post(com.baidu.sapi2.utils.h.D, a2, null, x(), new v(this, Looper.getMainLooper(), sapiCallback, new CheckUserFaceIdResult(), z));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"NewApi"})
    public void a(SsoHashCallback ssoHashCallback, String str, String str2) {
        SapiUtils.notNull(ssoHashCallback, "SsoHashCallback can't be null");
        new w(this, str, str2, ssoHashCallback).execute(com.baidu.sapi2.utils.h.F);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SapiCallback<SapiResult> sapiCallback, String str, String str2) {
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("open_appid", str);
        httpHashMapWrap.put("open_apikey", str2);
        httpHashMapWrap.put("time", System.currentTimeMillis() + "");
        new HttpClientWrap().post(com.baidu.sapi2.utils.h.G, httpHashMapWrap, null, x(), new x(this, Looper.getMainLooper(), sapiCallback, new SapiResult()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(OneKeyLoginCallback oneKeyLoginCallback, String str) {
        OneKeyLoginResult oneKeyLoginResult = new OneKeyLoginResult();
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put(FuFaceItem.JK_ABILITY, "onekeylogin");
        httpHashMapWrap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, "api");
        httpHashMapWrap.put("clientfrom", "native");
        httpHashMapWrap.put("mobile", str);
        SapiConfiguration sapiConfiguration = this.d;
        new HttpClientWrap().get(n(), httpHashMapWrap, a(sapiConfiguration.context, sapiConfiguration), x(), new y(this, Looper.getMainLooper(), oneKeyLoginResult, str, oneKeyLoginCallback));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(OneKeyLoginCallback oneKeyLoginCallback, String str, String str2, com.baidu.sapi2.callback.a.b bVar) {
        String packageName;
        JSONObject jSONObject = new JSONObject();
        try {
            String c2 = new com.baidu.sapi2.outsdk.c().c();
            jSONObject.put("token", str);
            jSONObject.put("tpl", this.d.tpl);
            jSONObject.put("client", "android");
            jSONObject.put("clientfrom", "native");
            jSONObject.put("appid", this.d.appId);
            jSONObject.put("operator", c2);
            jSONObject.put(FaceBaseDTO.KEY_BUSINESS_SCENE, "api");
            jSONObject.put("sign", str2);
            if ("CM".equals(c2)) {
                packageName = this.d.chinaMobileAppID;
            } else if ("CT".equals(c2)) {
                packageName = this.d.chinaTelecomAppKey;
            } else {
                packageName = this.d.context.getPackageName();
                jSONObject.put("CUVersion", "2");
            }
            jSONObject.put("appid", packageName);
        } catch (JSONException e) {
            Log.e(e);
        }
        com.baidu.sapi2.utils.g.a(SapiContext.getInstance().getOneKeyLoginJsCode(), OneKeyLoginResult.secondJsCode, jSONObject.toString(), this.d.context, new A(this, oneKeyLoginCallback, bVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(OneKeyLoginCallback oneKeyLoginCallback, String str, String str2, String str3, OneKeyLoginResult oneKeyLoginResult) {
        new HttpClientWrap().get(str, new B(this, Looper.getMainLooper(), str2, oneKeyLoginCallback, str3, oneKeyLoginResult));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<HttpCookie> a(Context context, SapiConfiguration sapiConfiguration) {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 9) {
            String deviceInfo = SapiContext.getInstance().getDeviceInfo();
            String cookie = SapiUtils.getCookie(sapiConfiguration.environment.getWap(), "HISTORY");
            String cookie2 = SapiUtils.getCookie("https://baidu.com", "BAIDUID");
            HttpCookie httpCookie = new HttpCookie("cuid", SapiUtils.getClientId(sapiConfiguration.context));
            if (deviceInfo == null) {
                deviceInfo = "";
            }
            HttpCookie httpCookie2 = new HttpCookie("DVIF", deviceInfo);
            HttpCookie httpCookie3 = new HttpCookie("HISTORY", cookie);
            HttpCookie httpCookie4 = new HttpCookie("BAIDUID", cookie2);
            String replaceAll = sapiConfiguration.environment.getURL().replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "").replaceAll("(:[0-9]{1,4})?", "");
            String replaceAll2 = sapiConfiguration.environment.getWap().replace("http://", "").replace(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "").replaceAll("(:[0-9]{1,4})?", "");
            httpCookie.setDomain(replaceAll);
            httpCookie.setPath("/");
            httpCookie2.setDomain(replaceAll2);
            httpCookie2.setPath("/");
            httpCookie3.setDomain(replaceAll2);
            httpCookie3.setPath("/");
            httpCookie4.setDomain("https://baidu.com");
            httpCookie4.setPath("/");
            arrayList.add(httpCookie);
            arrayList.add(httpCookie2);
            arrayList.add(httpCookie3);
            arrayList.add(httpCookie4);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HashMap<String, String> hashMap) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair(this.d.environment.getWap(), hashMap.get("HISTORY")));
        SapiUtils.syncCookies(this.d.context, arrayList);
    }

    SapiAccount a(JSONObject jSONObject) {
        SapiAccount sapiAccount = new SapiAccount();
        sapiAccount.uid = jSONObject.optString("uid");
        sapiAccount.bduss = jSONObject.optString("bduss");
        sapiAccount.displayname = jSONObject.optString(SapiAccountManager.SESSION_DISPLAYNAME);
        sapiAccount.username = jSONObject.optString(BdStatsConstant.StatsKey.UNAME);
        sapiAccount.stoken = jSONObject.optString("stoken");
        sapiAccount.ptoken = jSONObject.optString("ptoken");
        sapiAccount.extra = jSONObject.toString();
        sapiAccount.app = SapiUtils.getAppName(this.d.context);
        return sapiAccount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SapiAccount a(SapiAccountResponse sapiAccountResponse) {
        SapiAccount sapiAccount = new SapiAccount();
        sapiAccount.displayname = sapiAccountResponse.displayname;
        sapiAccount.bduss = sapiAccountResponse.bduss;
        sapiAccount.ptoken = sapiAccountResponse.ptoken;
        sapiAccount.stoken = sapiAccountResponse.stoken;
        sapiAccount.uid = sapiAccountResponse.uid;
        sapiAccount.username = sapiAccountResponse.username;
        sapiAccount.app = SapiUtils.getAppName(this.d.context);
        return sapiAccount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(BindWidgetAction bindWidgetAction) {
        return v().getWap() + bindWidgetAction.getUri();
    }
}
