package com.baidu.sapi2;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Xml;
import com.baidu.cloudsdk.common.http.AsyncHttpClient;
import com.baidu.cloudsdk.common.http.BinaryHttpResponseHandler;
import com.baidu.cloudsdk.common.http.HttpResponseHandler;
import com.baidu.cloudsdk.common.http.RequestParams;
import com.baidu.fsg.base.armor.RimArmor;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.callback.GetDynamicPwdCallback;
import com.baidu.sapi2.callback.GetRegCodeCallback;
import com.baidu.sapi2.callback.LoginCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.callback.SapiCallbackInterceptor;
import com.baidu.sapi2.dto.LoginDTO;
import com.baidu.sapi2.dto.PhoneRegDTO;
import com.baidu.sapi2.passhost.framework.PluginFacade;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.sapi2.result.DynamicPwdLoginResult;
import com.baidu.sapi2.result.GetCaptchaResult;
import com.baidu.sapi2.result.GetDynamicPwdResult;
import com.baidu.sapi2.result.GetRegCodeResult;
import com.baidu.sapi2.result.LoginResult;
import com.baidu.sapi2.result.PhoneRegResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.utils.SapiDataEncryptor;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.tencent.tauth.AuthActivity;
import java.io.ByteArrayInputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes2.dex */
public class EnhancedService extends AbstractService {
    private static final int a = 6;
    private static final String b = "3";
    private static EnhancedService f;
    private String c;
    private String d;
    private LoginDTO e;

    public static synchronized EnhancedService getInstance(SapiConfiguration sapiConfiguration, String str) {
        EnhancedService enhancedService;
        synchronized (EnhancedService.class) {
            if (f == null) {
                f = new EnhancedService(sapiConfiguration, str);
            }
            enhancedService = f;
        }
        return enhancedService;
    }

    private EnhancedService(SapiConfiguration sapiConfiguration, String str) {
        super(sapiConfiguration, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void login(final LoginCallback loginCallback, final LoginDTO loginDTO) {
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
            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_LOGIN, IEventCenterService.EventResult.PHASE.FAILURE);
        } else if (TextUtils.isEmpty(loginDTO.password)) {
            loginResult.setResultCode(-102);
            loginCallback.onFailure(loginResult);
            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_LOGIN, IEventCenterService.EventResult.PHASE.FAILURE);
        } else if (!SapiUtils.hasActiveNetwork(this.configuration.context)) {
            loginResult.setResultCode(-201);
            loginCallback.onFailure(loginResult);
            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_LOGIN, IEventCenterService.EventResult.PHASE.FAILURE);
        } else {
            this.asyncHttpClient = new AsyncHttpClient();
            this.asyncHttpClient.setUserAgent(getUaInfo());
            Map<String, String> a2 = a(SapiEnv.LOGIN_URI);
            a2.put("crypttype", String.valueOf(6));
            a2.put("cert_id", String.valueOf(1));
            if (!TextUtils.isEmpty(this.c) && !TextUtils.isEmpty(loginDTO.captcha)) {
                a2.put("verifycode", loginDTO.captcha);
                a2.put("vcodestr", this.c);
            }
            if (this.configuration.quickUserEnabled) {
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
                jSONObject.put(RimArmor.KEY, sapiDataEncryptor.getAESKey());
                a2.put("userinfo", sapiDataEncryptor.encrypt("-----BEGIN CERTIFICATE-----\nMIIFKDCCBBCgAwIBAgIQaG9YabPddabIY+N5IoXttzANBgkqhkiG9w0BAQUFADCB\nvDELMAkGA1UEBhMCVVMxFzAVBgNVBAoTDlZlcmlTaWduLCBJbmMuMR8wHQYDVQQL\nExZWZXJpU2lnbiBUcnVzdCBOZXR3b3JrMTswOQYDVQQLEzJUZXJtcyBvZiB1c2Ug\nYXQgaHR0cHM6Ly93d3cudmVyaXNpZ24uY29tL3JwYSAoYykxMDE2MDQGA1UEAxMt\nVmVyaVNpZ24gQ2xhc3MgMyBJbnRlcm5hdGlvbmFsIFNlcnZlciBDQSAtIEczMB4X\nDTEwMTIwMzAwMDAwMFoXDTEyMTIwMjIzNTk1OVowga8xCzAJBgNVBAYTAkNOMRAw\nDgYDVQQIEwdCZWlqaW5nMRAwDgYDVQQHFAdCZWlqaW5nMTkwNwYDVQQKFDBCZWlK\naW5nIEJhaWR1IE5ldGNvbSBTY2llbmNlIFRlY2hub2xvZ3kgQ28uLCBMdGQxJTAj\nBgNVBAsUHHNlcnZpY2Ugb3BlcmF0aW9uIGRlcGFydG1lbnQxGjAYBgNVBAMUEW9w\nZW5hcGkuYmFpZHUuY29tMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC68R1G\nWkkVvvjBOGKHOoyLxdtEcxBiVOGG8lvXTckB8jNrg4tihQzql+fJbr/X8V9MqQLw\nzzOyQViYlW+/GhC6u1jrP6t3Br0Wy8HyThDnvOAWyPFEawgbIywT20F41Iqayled\n/DQ/JCDWcNA7+xX56rqEcQd+6baNAiu9o962PwIDAQABo4IBszCCAa8wCQYDVR0T\nBAIwADALBgNVHQ8EBAMCBaAwQQYDVR0fBDowODA2oDSgMoYwaHR0cDovL1NWUklu\ndGwtRzMtY3JsLnZlcmlzaWduLmNvbS9TVlJJbnRsRzMuY3JsMEQGA1UdIAQ9MDsw\nOQYLYIZIAYb4RQEHFwMwKjAoBggrBgEFBQcCARYcaHR0cHM6Ly93d3cudmVyaXNp\nZ24uY29tL3JwYTAoBgNVHSUEITAfBglghkgBhvhCBAEGCCsGAQUFBwMBBggrBgEF\nBQcDAjByBggrBgEFBQcBAQRmMGQwJAYIKwYBBQUHMAGGGGh0dHA6Ly9vY3NwLnZl\ncmlzaWduLmNvbTA8BggrBgEFBQcwAoYwaHR0cDovL1NWUkludGwtRzMtYWlhLnZl\ncmlzaWduLmNvbS9TVlJJbnRsRzMuY2VyMG4GCCsGAQUFBwEMBGIwYKFeoFwwWjBY\nMFYWCWltYWdlL2dpZjAhMB8wBwYFKw4DAhoEFEtruSiWBgy70FI4mymsSweLIQUY\nMCYWJGh0dHA6Ly9sb2dvLnZlcmlzaWduLmNvbS92c2xvZ28xLmdpZjANBgkqhkiG\n9w0BAQUFAAOCAQEAgNIl8/QIKP4KWWWj6ltL6lVknoGlpUIoowvnv+57H7FdEYJb\n9zQewrAqoFkblB0mMiUEGdJOa7YxKKJialqz6KnlMrHQMAsB641BHLDESvLjuhio\nUsWmvBowIK92HQ2H9N01U8d1i5rTz5wwFK+Nvue/61tzCTTmbRgBuGPotQ/tcA+g\nYCNuEIHsJMbWiX9O3gflnMdRME7z9Hw9zMogt+lz7GudP/AO1K6sZ6VnQ931Gv1e\nIOmPCPfvO/Kw/aXSacoEWnMsy+qTIewVPT/MMgSaq9JewAQgLpMX+O5qqAJBYoDj\nxoZnHufGgOIKfNmSvYiHjDFJtP55PdEH21q+JA==\n-----END CERTIFICATE-----", jSONObject.toString()));
                a2.put("sig", calculateSig(a2, this.configuration.appSignKey));
                this.asyncHttpClient.post(this.configuration.context, a(), new RequestParams(a2), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.EnhancedService.1
                    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                    protected void onStart() {
                        loginCallback.onStart();
                        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_LOGIN, IEventCenterService.EventResult.PHASE.START);
                    }

                    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                    protected void onFinish() {
                        loginCallback.onFinish();
                        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_LOGIN, IEventCenterService.EventResult.PHASE.FINISH);
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                    public void onSuccess(int i, String str) {
                        EnhancedService.this.domainRetry.reset();
                        int errorCode = EnhancedService.this.getErrorCode(str);
                        loginResult.setResultCode(errorCode);
                        try {
                            JSONObject jSONObject2 = new JSONObject(sapiDataEncryptor.decrypt(new JSONObject(str).optString("userinfo")));
                            JSONObject optJSONObject = jSONObject2.optJSONObject("sdk");
                            loginResult.setResultMsg(optJSONObject.optString("msg"));
                            SapiResult.Action action = new SapiResult.Action();
                            action.actionMode = SapiResult.ActionMode.fromString(optJSONObject.optString(AuthActivity.ACTION_KEY));
                            action.actionType = SapiResult.ActionType.fromString(optJSONObject.optString("type"));
                            action.actionTitle = optJSONObject.optString("title");
                            action.actionUrl = optJSONObject.optString("url");
                            loginResult.action = action;
                            if (jSONObject2.optInt("needvcode") == 1) {
                                EnhancedService.this.c = jSONObject2.optString("vcodestr");
                                loginCallback.onCaptchaRequired(loginResult);
                            }
                            switch (AnonymousClass9.a[action.actionMode.ordinal()]) {
                                case 1:
                                    EnhancedService.this.e = loginDTO;
                                    loginCallback.onProxyActionRequired(loginResult);
                                    return;
                                case 2:
                                    if (errorCode == 0) {
                                        SapiAccount parseAccount = EnhancedService.this.parseAccount(jSONObject2);
                                        SapiAccount.ReloginCredentials reloginCredentials = new SapiAccount.ReloginCredentials();
                                        reloginCredentials.account = loginDTO.account;
                                        reloginCredentials.accountType = jSONObject2.optString("logintype");
                                        reloginCredentials.ubi = jSONObject2.optString("ubi");
                                        SapiContext.getInstance(EnhancedService.this.configuration.context).addReloginCredentials(parseAccount.uid, reloginCredentials);
                                        parseAccount.extra = SapiAccount.DispersionCertification.fromJSONObject(jSONObject2).toJSONObject().toString();
                                        ServiceManager.getInstance().getIsAccountManager().validate(parseAccount);
                                        loginCallback.onSuccess(loginResult);
                                        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_LOGIN, IEventCenterService.EventResult.PHASE.SUCCESS);
                                        return;
                                    } else if (errorCode == 18) {
                                        loginCallback.onLoginTypeConflict(loginResult);
                                        return;
                                    } else {
                                        loginCallback.onFailure(loginResult);
                                        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_LOGIN, IEventCenterService.EventResult.PHASE.FAILURE);
                                        return;
                                    }
                                default:
                                    loginCallback.onFailure(loginResult);
                                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_LOGIN, IEventCenterService.EventResult.PHASE.FAILURE);
                                    return;
                            }
                        } catch (Exception e) {
                            loginCallback.onFailure(loginResult);
                            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_LOGIN, IEventCenterService.EventResult.PHASE.FAILURE);
                            Log.e(e);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                    public void onFailure(Throwable th, String str) {
                        if (!EnhancedService.this.domainRetry.isShouldRetry()) {
                            EnhancedService.this.domainRetry.reset();
                            if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                                StatService.onEvent("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                                loginResult.setResultCode(-203);
                                loginCallback.onFailure(loginResult);
                                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_LOGIN, IEventCenterService.EventResult.PHASE.FAILURE);
                                return;
                            }
                            loginResult.setResultCode(-202);
                            loginCallback.onFailure(loginResult);
                            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_LOGIN, IEventCenterService.EventResult.PHASE.FAILURE);
                            return;
                        }
                        EnhancedService.this.domainRetry.retry();
                        EnhancedService.this.login(loginCallback, loginDTO);
                    }
                });
            } catch (Exception e) {
                loginResult.setResultCode(-202);
                loginCallback.onFailure(loginResult);
                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_LOGIN, IEventCenterService.EventResult.PHASE.FAILURE);
                Log.e(e);
            }
        }
    }

    /* renamed from: com.baidu.sapi2.EnhancedService$9  reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass9 {
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void getCaptcha(final SapiCallback<GetCaptchaResult> sapiCallback) {
        if (sapiCallback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        }
        if (TextUtils.isEmpty(this.c)) {
            throw new IllegalArgumentException("captchaKey can't be empty");
        }
        final GetCaptchaResult getCaptchaResult = new GetCaptchaResult();
        if (!SapiUtils.hasActiveNetwork(this.configuration.context)) {
            getCaptchaResult.setResultCode(-201);
            sapiCallback.onFailure(getCaptchaResult);
            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_CAPTCHA, IEventCenterService.EventResult.PHASE.FAILURE);
            return;
        }
        this.asyncHttpClient = new AsyncHttpClient();
        this.asyncHttpClient.setUserAgent(getUaInfo());
        this.asyncHttpClient.get(this.configuration.context, this.domainRetry.getDomain() + SapiEnv.CAPTCHA_URI + this.c, new BinaryHttpResponseHandler(Looper.getMainLooper(), new String[]{"image/png", "image/jpeg", "image/jpg", "image/gif"}) { // from class: com.baidu.sapi2.EnhancedService.2
            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onStart() {
                sapiCallback.onStart();
                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_CAPTCHA, IEventCenterService.EventResult.PHASE.START);
            }

            @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
            protected void onFinish() {
                sapiCallback.onFinish();
                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_CAPTCHA, IEventCenterService.EventResult.PHASE.FINISH);
            }

            @Override // com.baidu.cloudsdk.common.http.BinaryHttpResponseHandler
            protected void onSuccess(byte[] bArr) {
                EnhancedService.this.domainRetry.reset();
                if (bArr != null) {
                    getCaptchaResult.setResultCode(0);
                    getCaptchaResult.captchaImage = bArr;
                    sapiCallback.onSuccess(getCaptchaResult);
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_CAPTCHA, IEventCenterService.EventResult.PHASE.SUCCESS);
                    return;
                }
                getCaptchaResult.setResultCode(-202);
                sapiCallback.onFailure(getCaptchaResult);
                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_CAPTCHA, IEventCenterService.EventResult.PHASE.FAILURE);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.cloudsdk.common.http.BinaryHttpResponseHandler
            public void onFailure(Throwable th, byte[] bArr) {
                if (!EnhancedService.this.domainRetry.isShouldRetry()) {
                    EnhancedService.this.domainRetry.reset();
                    if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                        StatService.onEvent("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                        getCaptchaResult.setResultCode(-203);
                        sapiCallback.onFailure(getCaptchaResult);
                        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_CAPTCHA, IEventCenterService.EventResult.PHASE.FAILURE);
                        return;
                    }
                    getCaptchaResult.setResultCode(-202);
                    sapiCallback.onFailure(getCaptchaResult);
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_CAPTCHA, IEventCenterService.EventResult.PHASE.FAILURE);
                    return;
                }
                EnhancedService.this.domainRetry.retry();
                EnhancedService.this.getCaptcha(sapiCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void getLoginProxyResult(final SapiCallback<LoginResult> sapiCallback, String str) {
        final LoginResult loginResult = new LoginResult();
        if (TextUtils.isEmpty(str)) {
            loginResult.setResultCode(-202);
            sapiCallback.onFailure(loginResult);
        } else if (!SapiUtils.hasActiveNetwork(this.configuration.context)) {
            loginResult.setResultCode(-201);
            sapiCallback.onFailure(loginResult);
        } else {
            this.asyncHttpClient = new AsyncHttpClient();
            this.asyncHttpClient.setUserAgent(getUaInfo());
            this.asyncHttpClient.get(this.configuration.context, str, new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.EnhancedService.3
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                protected void onStart() {
                    sapiCallback.onStart();
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, IEventCenterService.EventResult.PHASE.START);
                }

                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                protected void onFinish() {
                    sapiCallback.onFinish();
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, IEventCenterService.EventResult.PHASE.FINISH);
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onSuccess(int i, String str2) {
                    try {
                        HashMap hashMap = new HashMap();
                        JSONObject jSONObject = new JSONObject(str2);
                        JSONObject optJSONObject = jSONObject.optJSONObject("errInfo");
                        int optInt = optJSONObject.optInt("no", -202);
                        loginResult.setResultCode(optInt);
                        loginResult.setResultMsg(optJSONObject.optString("msg"));
                        switch (optInt) {
                            case 0:
                                loginResult.setResultMsg("登录成功");
                                String optString = jSONObject.optJSONObject("data").optString("xml");
                                SapiAccount sapiAccount = new SapiAccount();
                                sapiAccount.app = SapiUtils.getAppName(EnhancedService.this.configuration.context);
                                SapiAccount.ReloginCredentials reloginCredentials = new SapiAccount.ReloginCredentials();
                                reloginCredentials.account = EnhancedService.this.e.account;
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
                                            } else if (name.equalsIgnoreCase("displayname")) {
                                                sapiAccount.displayname = newPullParser.nextText();
                                                break;
                                            } else if (name.equalsIgnoreCase("uid")) {
                                                sapiAccount.uid = newPullParser.nextText();
                                                break;
                                            } else if (name.equalsIgnoreCase("bduss")) {
                                                sapiAccount.bduss = newPullParser.nextText();
                                                break;
                                            } else if (name.equalsIgnoreCase(ISapiAccount.SAPI_ACCOUNT_PTOKEN)) {
                                                sapiAccount.ptoken = newPullParser.nextText();
                                                break;
                                            } else if (name.equalsIgnoreCase("stoken_list")) {
                                                z = true;
                                                break;
                                            } else if (name.equalsIgnoreCase(ISapiAccount.SAPI_ACCOUNT_STOKEN)) {
                                                if (z) {
                                                    String[] split = newPullParser.nextText().split("#");
                                                    hashMap.put(split[0], split[1]);
                                                    break;
                                                } else {
                                                    sapiAccount.stoken = newPullParser.nextText();
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
                                sapiAccount.putExtra("stoken_list", new JSONObject(hashMap));
                                SapiContext.getInstance(EnhancedService.this.configuration.context).addReloginCredentials(sapiAccount.uid, reloginCredentials);
                                ServiceManager.getInstance().getIsAccountManager().validate(sapiAccount);
                                sapiCallback.onSuccess(loginResult);
                                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, IEventCenterService.EventResult.PHASE.SUCCESS);
                                return;
                            default:
                                sapiCallback.onFailure(loginResult);
                                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, IEventCenterService.EventResult.PHASE.FAILURE);
                                return;
                        }
                    } catch (Exception e) {
                        sapiCallback.onFailure(loginResult);
                        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, IEventCenterService.EventResult.PHASE.FAILURE);
                        Log.e(e);
                    }
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onFailure(Throwable th, String str2) {
                    loginResult.setResultCode(-202);
                    sapiCallback.onFailure(loginResult);
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, IEventCenterService.EventResult.PHASE.FAILURE);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void getRegCode(final GetRegCodeCallback getRegCodeCallback, final String str) {
        if (getRegCodeCallback == null) {
            throw new IllegalArgumentException(GetRegCodeCallback.class.getSimpleName() + " can't be null");
        }
        final GetRegCodeResult getRegCodeResult = new GetRegCodeResult();
        if (TextUtils.isEmpty(str)) {
            getRegCodeResult.setResultCode(-101);
            getRegCodeCallback.onFailure(getRegCodeResult);
            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_REG_CODE, IEventCenterService.EventResult.PHASE.FAILURE);
        } else if (!SapiUtils.hasActiveNetwork(this.configuration.context)) {
            getRegCodeResult.setResultCode(-201);
            getRegCodeCallback.onFailure(getRegCodeResult);
            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_REG_CODE, IEventCenterService.EventResult.PHASE.FAILURE);
        } else {
            this.asyncHttpClient = new AsyncHttpClient();
            this.asyncHttpClient.setUserAgent(getUaInfo());
            Map<String, String> a2 = a(SapiEnv.GET_REG_CODE_URI);
            a2.put("phonenum", str);
            a2.put("sig", calculateSig(a2, this.configuration.appSignKey));
            this.asyncHttpClient.post(this.configuration.context, this.domainRetry.getDomain() + SapiEnv.GET_REG_CODE_URI, new RequestParams(a2), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.EnhancedService.4
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                protected void onStart() {
                    getRegCodeCallback.onStart();
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_REG_CODE, IEventCenterService.EventResult.PHASE.START);
                }

                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                protected void onFinish() {
                    getRegCodeCallback.onFinish();
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_REG_CODE, IEventCenterService.EventResult.PHASE.FINISH);
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onSuccess(int i, String str2) {
                    EnhancedService.this.domainRetry.reset();
                    int errorCode = EnhancedService.this.getErrorCode(str2);
                    getRegCodeResult.setResultCode(errorCode);
                    try {
                        getRegCodeResult.setResultMsg(new JSONObject(str2).optJSONObject("sdk").optString("msg"));
                        switch (errorCode) {
                            case 0:
                                getRegCodeCallback.onSuccess(getRegCodeResult);
                                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_REG_CODE, IEventCenterService.EventResult.PHASE.SUCCESS);
                                break;
                            case 8:
                                getRegCodeCallback.onPhoneNumberExist(getRegCodeResult);
                                break;
                            default:
                                getRegCodeCallback.onFailure(getRegCodeResult);
                                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_REG_CODE, IEventCenterService.EventResult.PHASE.FAILURE);
                                break;
                        }
                    } catch (Exception e) {
                        getRegCodeCallback.onFailure(getRegCodeResult);
                        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_REG_CODE, IEventCenterService.EventResult.PHASE.FAILURE);
                        Log.e(e);
                    }
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onFailure(Throwable th, String str2) {
                    if (!EnhancedService.this.domainRetry.isShouldRetry()) {
                        EnhancedService.this.domainRetry.reset();
                        if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                            StatService.onEvent("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                            getRegCodeResult.setResultCode(-203);
                            getRegCodeCallback.onFailure(getRegCodeResult);
                            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_REG_CODE, IEventCenterService.EventResult.PHASE.FAILURE);
                            return;
                        }
                        getRegCodeResult.setResultCode(-202);
                        getRegCodeCallback.onFailure(getRegCodeResult);
                        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_REG_CODE, IEventCenterService.EventResult.PHASE.FAILURE);
                        return;
                    }
                    EnhancedService.this.domainRetry.retry();
                    EnhancedService.this.getRegCode(getRegCodeCallback, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void phoneReg(final SapiCallback<PhoneRegResult> sapiCallback, final PhoneRegDTO phoneRegDTO) {
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
            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_PHONE_REG, IEventCenterService.EventResult.PHASE.FAILURE);
        } else if (TextUtils.isEmpty(phoneRegDTO.password) && !phoneRegDTO.noPwd) {
            phoneRegResult.setResultCode(-102);
            sapiCallback.onFailure(phoneRegResult);
            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_PHONE_REG, IEventCenterService.EventResult.PHASE.FAILURE);
        } else if (TextUtils.isEmpty(phoneRegDTO.regCode)) {
            phoneRegResult.setResultCode(-103);
            sapiCallback.onFailure(phoneRegResult);
            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_PHONE_REG, IEventCenterService.EventResult.PHASE.FAILURE);
        } else if (!SapiUtils.hasActiveNetwork(this.configuration.context)) {
            phoneRegResult.setResultCode(-201);
            sapiCallback.onFailure(phoneRegResult);
            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_PHONE_REG, IEventCenterService.EventResult.PHASE.FAILURE);
        } else {
            this.asyncHttpClient = new AsyncHttpClient();
            this.asyncHttpClient.setUserAgent(getUaInfo());
            Map<String, String> a2 = a(SapiEnv.PHONE_REG_URI);
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
                jSONObject.put(RimArmor.KEY, sapiDataEncryptor.getAESKey());
                a2.put("userinfo", sapiDataEncryptor.encrypt("-----BEGIN CERTIFICATE-----\nMIIFKDCCBBCgAwIBAgIQaG9YabPddabIY+N5IoXttzANBgkqhkiG9w0BAQUFADCB\nvDELMAkGA1UEBhMCVVMxFzAVBgNVBAoTDlZlcmlTaWduLCBJbmMuMR8wHQYDVQQL\nExZWZXJpU2lnbiBUcnVzdCBOZXR3b3JrMTswOQYDVQQLEzJUZXJtcyBvZiB1c2Ug\nYXQgaHR0cHM6Ly93d3cudmVyaXNpZ24uY29tL3JwYSAoYykxMDE2MDQGA1UEAxMt\nVmVyaVNpZ24gQ2xhc3MgMyBJbnRlcm5hdGlvbmFsIFNlcnZlciBDQSAtIEczMB4X\nDTEwMTIwMzAwMDAwMFoXDTEyMTIwMjIzNTk1OVowga8xCzAJBgNVBAYTAkNOMRAw\nDgYDVQQIEwdCZWlqaW5nMRAwDgYDVQQHFAdCZWlqaW5nMTkwNwYDVQQKFDBCZWlK\naW5nIEJhaWR1IE5ldGNvbSBTY2llbmNlIFRlY2hub2xvZ3kgQ28uLCBMdGQxJTAj\nBgNVBAsUHHNlcnZpY2Ugb3BlcmF0aW9uIGRlcGFydG1lbnQxGjAYBgNVBAMUEW9w\nZW5hcGkuYmFpZHUuY29tMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC68R1G\nWkkVvvjBOGKHOoyLxdtEcxBiVOGG8lvXTckB8jNrg4tihQzql+fJbr/X8V9MqQLw\nzzOyQViYlW+/GhC6u1jrP6t3Br0Wy8HyThDnvOAWyPFEawgbIywT20F41Iqayled\n/DQ/JCDWcNA7+xX56rqEcQd+6baNAiu9o962PwIDAQABo4IBszCCAa8wCQYDVR0T\nBAIwADALBgNVHQ8EBAMCBaAwQQYDVR0fBDowODA2oDSgMoYwaHR0cDovL1NWUklu\ndGwtRzMtY3JsLnZlcmlzaWduLmNvbS9TVlJJbnRsRzMuY3JsMEQGA1UdIAQ9MDsw\nOQYLYIZIAYb4RQEHFwMwKjAoBggrBgEFBQcCARYcaHR0cHM6Ly93d3cudmVyaXNp\nZ24uY29tL3JwYTAoBgNVHSUEITAfBglghkgBhvhCBAEGCCsGAQUFBwMBBggrBgEF\nBQcDAjByBggrBgEFBQcBAQRmMGQwJAYIKwYBBQUHMAGGGGh0dHA6Ly9vY3NwLnZl\ncmlzaWduLmNvbTA8BggrBgEFBQcwAoYwaHR0cDovL1NWUkludGwtRzMtYWlhLnZl\ncmlzaWduLmNvbS9TVlJJbnRsRzMuY2VyMG4GCCsGAQUFBwEMBGIwYKFeoFwwWjBY\nMFYWCWltYWdlL2dpZjAhMB8wBwYFKw4DAhoEFEtruSiWBgy70FI4mymsSweLIQUY\nMCYWJGh0dHA6Ly9sb2dvLnZlcmlzaWduLmNvbS92c2xvZ28xLmdpZjANBgkqhkiG\n9w0BAQUFAAOCAQEAgNIl8/QIKP4KWWWj6ltL6lVknoGlpUIoowvnv+57H7FdEYJb\n9zQewrAqoFkblB0mMiUEGdJOa7YxKKJialqz6KnlMrHQMAsB641BHLDESvLjuhio\nUsWmvBowIK92HQ2H9N01U8d1i5rTz5wwFK+Nvue/61tzCTTmbRgBuGPotQ/tcA+g\nYCNuEIHsJMbWiX9O3gflnMdRME7z9Hw9zMogt+lz7GudP/AO1K6sZ6VnQ931Gv1e\nIOmPCPfvO/Kw/aXSacoEWnMsy+qTIewVPT/MMgSaq9JewAQgLpMX+O5qqAJBYoDj\nxoZnHufGgOIKfNmSvYiHjDFJtP55PdEH21q+JA==\n-----END CERTIFICATE-----", jSONObject.toString()));
                a2.put("nopsw", phoneRegDTO.noPwd ? "1" : "0");
                a2.put("sig", calculateSig(a2, this.configuration.appSignKey));
                this.asyncHttpClient.post(this.configuration.context, this.domainRetry.getDomain() + SapiEnv.PHONE_REG_URI, new RequestParams(a2), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.EnhancedService.5
                    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                    protected void onStart() {
                        sapiCallback.onStart();
                        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_PHONE_REG, IEventCenterService.EventResult.PHASE.START);
                    }

                    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                    protected void onFinish() {
                        sapiCallback.onFinish();
                        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_PHONE_REG, IEventCenterService.EventResult.PHASE.FINISH);
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                    public void onSuccess(int i, String str) {
                        EnhancedService.this.domainRetry.reset();
                        int errorCode = EnhancedService.this.getErrorCode(str);
                        phoneRegResult.setResultCode(errorCode);
                        try {
                            JSONObject jSONObject2 = new JSONObject(sapiDataEncryptor.decrypt(new JSONObject(str).optString("userinfo")));
                            phoneRegResult.setResultMsg(jSONObject2.optJSONObject("sdk").optString("msg"));
                            switch (errorCode) {
                                case 0:
                                    SapiAccount parseAccount = EnhancedService.this.parseAccount(jSONObject2);
                                    SapiAccount.ReloginCredentials reloginCredentials = new SapiAccount.ReloginCredentials();
                                    reloginCredentials.account = phoneRegDTO.phoneNumber;
                                    reloginCredentials.accountType = jSONObject2.optString("logintype");
                                    reloginCredentials.ubi = jSONObject2.optString("ubi");
                                    SapiContext.getInstance(EnhancedService.this.configuration.context).addReloginCredentials(parseAccount.uid, reloginCredentials);
                                    parseAccount.extra = SapiAccount.DispersionCertification.fromJSONObject(jSONObject2).toJSONObject().toString();
                                    ServiceManager.getInstance().getIsAccountManager().validate(parseAccount);
                                    sapiCallback.onSuccess(phoneRegResult);
                                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_PHONE_REG, IEventCenterService.EventResult.PHASE.SUCCESS);
                                    break;
                                default:
                                    sapiCallback.onFailure(phoneRegResult);
                                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_PHONE_REG, IEventCenterService.EventResult.PHASE.FAILURE);
                                    break;
                            }
                        } catch (Exception e) {
                            sapiCallback.onFailure(phoneRegResult);
                            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_PHONE_REG, IEventCenterService.EventResult.PHASE.FAILURE);
                            Log.e(e);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                    public void onFailure(Throwable th, String str) {
                        if (!EnhancedService.this.domainRetry.isShouldRetry()) {
                            EnhancedService.this.domainRetry.reset();
                            if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                                StatService.onEvent("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                                phoneRegResult.setResultCode(-203);
                                sapiCallback.onFailure(phoneRegResult);
                                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_PHONE_REG, IEventCenterService.EventResult.PHASE.FAILURE);
                                return;
                            }
                            phoneRegResult.setResultCode(-202);
                            sapiCallback.onFailure(phoneRegResult);
                            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_PHONE_REG, IEventCenterService.EventResult.PHASE.FAILURE);
                            return;
                        }
                        EnhancedService.this.domainRetry.retry();
                        EnhancedService.this.phoneReg(sapiCallback, phoneRegDTO);
                    }
                });
            } catch (Exception e) {
                phoneRegResult.setResultCode(-202);
                sapiCallback.onFailure(phoneRegResult);
                Log.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void getDynamicPwd(final SapiCallback<GetDynamicPwdResult> sapiCallback, final String str) {
        if (sapiCallback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        }
        final GetDynamicPwdResult getDynamicPwdResult = new GetDynamicPwdResult();
        if (TextUtils.isEmpty(str)) {
            getDynamicPwdResult.setResultCode(-101);
            sapiCallback.onFailure(getDynamicPwdResult);
        } else if (!SapiUtils.hasActiveNetwork(this.configuration.context)) {
            getDynamicPwdResult.setResultCode(-201);
            sapiCallback.onFailure(getDynamicPwdResult);
        } else {
            this.asyncHttpClient = new AsyncHttpClient();
            this.asyncHttpClient.setUserAgent(getUaInfo());
            Map<String, String> a2 = a(SapiEnv.GET_DYNAMIC_PWD_URI);
            a2.put("username", str);
            a2.put("sig", calculateSig(a2, this.configuration.appSignKey));
            this.asyncHttpClient.post(this.configuration.context, this.domainRetry.getDomain() + SapiEnv.GET_DYNAMIC_PWD_URI, new RequestParams(a2), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.EnhancedService.6
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
                    EnhancedService.this.domainRetry.reset();
                    int errorCode = EnhancedService.this.getErrorCode(str2);
                    getDynamicPwdResult.setResultCode(errorCode);
                    try {
                        getDynamicPwdResult.setResultMsg(new JSONObject(str2).optJSONObject("sdk").optString("msg"));
                        switch (errorCode) {
                            case 0:
                                sapiCallback.onSuccess(getDynamicPwdResult);
                                break;
                            default:
                                sapiCallback.onFailure(getDynamicPwdResult);
                                break;
                        }
                    } catch (Exception e) {
                        sapiCallback.onFailure(getDynamicPwdResult);
                        Log.e(e);
                    }
                }

                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onFailure(Throwable th, String str2) {
                    if (!EnhancedService.this.domainRetry.isShouldRetry()) {
                        EnhancedService.this.domainRetry.reset();
                        if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                            StatService.onEvent("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                            getDynamicPwdResult.setResultCode(-203);
                            sapiCallback.onFailure(getDynamicPwdResult);
                            return;
                        }
                        getDynamicPwdResult.setResultCode(-202);
                        sapiCallback.onFailure(getDynamicPwdResult);
                        return;
                    }
                    EnhancedService.this.domainRetry.retry();
                    EnhancedService.this.getDynamicPwd(sapiCallback, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void getDynamicPwd(final GetDynamicPwdCallback getDynamicPwdCallback, final String str, final String str2) {
        if (getDynamicPwdCallback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        }
        final GetDynamicPwdResult getDynamicPwdResult = new GetDynamicPwdResult();
        if (TextUtils.isEmpty(str)) {
            getDynamicPwdResult.setResultCode(-101);
            getDynamicPwdCallback.onFailure(getDynamicPwdResult);
            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, IEventCenterService.EventResult.PHASE.FAILURE);
        } else if (!SapiUtils.hasActiveNetwork(this.configuration.context)) {
            getDynamicPwdResult.setResultCode(-201);
            getDynamicPwdCallback.onFailure(getDynamicPwdResult);
            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, IEventCenterService.EventResult.PHASE.FAILURE);
        } else {
            this.asyncHttpClient = new AsyncHttpClient();
            this.asyncHttpClient.setUserAgent(getUaInfo());
            Map<String, String> a2 = a(SapiEnv.GET_DYNAMIC_PWD_URI);
            a2.put("username", str);
            a2.put("svcd", "1");
            if (!TextUtils.isEmpty(this.c) && !TextUtils.isEmpty(this.d) && !TextUtils.isEmpty(str2)) {
                a2.put("vcodestr", this.c);
                a2.put("vcodesign", this.d);
                a2.put("verifycode", str2);
            }
            a2.put("sig", calculateSig(a2, this.configuration.appSignKey));
            this.asyncHttpClient.post(this.configuration.context, this.domainRetry.getDomain() + SapiEnv.GET_DYNAMIC_PWD_URI, new RequestParams(a2), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.EnhancedService.7
                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                protected void onStart() {
                    getDynamicPwdCallback.onStart();
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, IEventCenterService.EventResult.PHASE.START);
                }

                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                protected void onFinish() {
                    getDynamicPwdCallback.onFinish();
                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, IEventCenterService.EventResult.PHASE.FINISH);
                }

                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onSuccess(int i, String str3) {
                    EnhancedService.this.domainRetry.reset();
                    int errorCode = EnhancedService.this.getErrorCode(str3);
                    getDynamicPwdResult.setResultCode(errorCode);
                    try {
                        JSONObject optJSONObject = new JSONObject(str3).optJSONObject("sdk");
                        getDynamicPwdResult.setResultMsg(optJSONObject.optString("msg"));
                        switch (errorCode) {
                            case 0:
                                getDynamicPwdCallback.onSuccess(getDynamicPwdResult);
                                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, IEventCenterService.EventResult.PHASE.SUCCESS);
                                break;
                            case 5:
                                EnhancedService.this.c = optJSONObject.optString("vcodestr");
                                EnhancedService.this.d = optJSONObject.optString("vcodesign");
                                getDynamicPwdCallback.onCaptchaRequired(getDynamicPwdResult);
                                break;
                            default:
                                getDynamicPwdCallback.onFailure(getDynamicPwdResult);
                                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, IEventCenterService.EventResult.PHASE.FAILURE);
                                break;
                        }
                    } catch (Exception e) {
                        getDynamicPwdCallback.onFailure(getDynamicPwdResult);
                        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, IEventCenterService.EventResult.PHASE.FAILURE);
                        Log.e(e);
                    }
                }

                @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                public void onFailure(Throwable th, String str3) {
                    if (!EnhancedService.this.domainRetry.isShouldRetry()) {
                        EnhancedService.this.domainRetry.reset();
                        if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                            StatService.onEvent("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                            getDynamicPwdResult.setResultCode(-203);
                            getDynamicPwdCallback.onFailure(getDynamicPwdResult);
                            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, IEventCenterService.EventResult.PHASE.FAILURE);
                            return;
                        }
                        getDynamicPwdResult.setResultCode(-202);
                        getDynamicPwdCallback.onFailure(getDynamicPwdResult);
                        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, IEventCenterService.EventResult.PHASE.FAILURE);
                        return;
                    }
                    EnhancedService.this.domainRetry.retry();
                    EnhancedService.this.getDynamicPwd(getDynamicPwdCallback, str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dynamicPwdLogin(final SapiCallback<DynamicPwdLoginResult> sapiCallback, final String str, final String str2) {
        if (sapiCallback == null) {
            throw new IllegalArgumentException(SapiCallback.class.getSimpleName() + " can't be null");
        }
        final DynamicPwdLoginResult dynamicPwdLoginResult = new DynamicPwdLoginResult();
        if (TextUtils.isEmpty(str)) {
            dynamicPwdLoginResult.setResultCode(-101);
            sapiCallback.onFailure(dynamicPwdLoginResult);
            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_DYNAMICPWD_LOGIN, IEventCenterService.EventResult.PHASE.FINISH);
        } else if (TextUtils.isEmpty(str2)) {
            dynamicPwdLoginResult.setResultCode(-102);
            sapiCallback.onFailure(dynamicPwdLoginResult);
            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_DYNAMICPWD_LOGIN, IEventCenterService.EventResult.PHASE.FINISH);
        } else if (!SapiUtils.hasActiveNetwork(this.configuration.context)) {
            dynamicPwdLoginResult.setResultCode(-201);
            sapiCallback.onFailure(dynamicPwdLoginResult);
            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_DYNAMICPWD_LOGIN, IEventCenterService.EventResult.PHASE.FINISH);
        } else {
            this.asyncHttpClient = new AsyncHttpClient();
            this.asyncHttpClient.setUserAgent(getUaInfo());
            Map<String, String> a2 = a(SapiEnv.LOGIN_URI);
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
                jSONObject.put(RimArmor.KEY, sapiDataEncryptor.getAESKey());
                a2.put("userinfo", sapiDataEncryptor.encrypt("-----BEGIN CERTIFICATE-----\nMIIFKDCCBBCgAwIBAgIQaG9YabPddabIY+N5IoXttzANBgkqhkiG9w0BAQUFADCB\nvDELMAkGA1UEBhMCVVMxFzAVBgNVBAoTDlZlcmlTaWduLCBJbmMuMR8wHQYDVQQL\nExZWZXJpU2lnbiBUcnVzdCBOZXR3b3JrMTswOQYDVQQLEzJUZXJtcyBvZiB1c2Ug\nYXQgaHR0cHM6Ly93d3cudmVyaXNpZ24uY29tL3JwYSAoYykxMDE2MDQGA1UEAxMt\nVmVyaVNpZ24gQ2xhc3MgMyBJbnRlcm5hdGlvbmFsIFNlcnZlciBDQSAtIEczMB4X\nDTEwMTIwMzAwMDAwMFoXDTEyMTIwMjIzNTk1OVowga8xCzAJBgNVBAYTAkNOMRAw\nDgYDVQQIEwdCZWlqaW5nMRAwDgYDVQQHFAdCZWlqaW5nMTkwNwYDVQQKFDBCZWlK\naW5nIEJhaWR1IE5ldGNvbSBTY2llbmNlIFRlY2hub2xvZ3kgQ28uLCBMdGQxJTAj\nBgNVBAsUHHNlcnZpY2Ugb3BlcmF0aW9uIGRlcGFydG1lbnQxGjAYBgNVBAMUEW9w\nZW5hcGkuYmFpZHUuY29tMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC68R1G\nWkkVvvjBOGKHOoyLxdtEcxBiVOGG8lvXTckB8jNrg4tihQzql+fJbr/X8V9MqQLw\nzzOyQViYlW+/GhC6u1jrP6t3Br0Wy8HyThDnvOAWyPFEawgbIywT20F41Iqayled\n/DQ/JCDWcNA7+xX56rqEcQd+6baNAiu9o962PwIDAQABo4IBszCCAa8wCQYDVR0T\nBAIwADALBgNVHQ8EBAMCBaAwQQYDVR0fBDowODA2oDSgMoYwaHR0cDovL1NWUklu\ndGwtRzMtY3JsLnZlcmlzaWduLmNvbS9TVlJJbnRsRzMuY3JsMEQGA1UdIAQ9MDsw\nOQYLYIZIAYb4RQEHFwMwKjAoBggrBgEFBQcCARYcaHR0cHM6Ly93d3cudmVyaXNp\nZ24uY29tL3JwYTAoBgNVHSUEITAfBglghkgBhvhCBAEGCCsGAQUFBwMBBggrBgEF\nBQcDAjByBggrBgEFBQcBAQRmMGQwJAYIKwYBBQUHMAGGGGh0dHA6Ly9vY3NwLnZl\ncmlzaWduLmNvbTA8BggrBgEFBQcwAoYwaHR0cDovL1NWUkludGwtRzMtYWlhLnZl\ncmlzaWduLmNvbS9TVlJJbnRsRzMuY2VyMG4GCCsGAQUFBwEMBGIwYKFeoFwwWjBY\nMFYWCWltYWdlL2dpZjAhMB8wBwYFKw4DAhoEFEtruSiWBgy70FI4mymsSweLIQUY\nMCYWJGh0dHA6Ly9sb2dvLnZlcmlzaWduLmNvbS92c2xvZ28xLmdpZjANBgkqhkiG\n9w0BAQUFAAOCAQEAgNIl8/QIKP4KWWWj6ltL6lVknoGlpUIoowvnv+57H7FdEYJb\n9zQewrAqoFkblB0mMiUEGdJOa7YxKKJialqz6KnlMrHQMAsB641BHLDESvLjuhio\nUsWmvBowIK92HQ2H9N01U8d1i5rTz5wwFK+Nvue/61tzCTTmbRgBuGPotQ/tcA+g\nYCNuEIHsJMbWiX9O3gflnMdRME7z9Hw9zMogt+lz7GudP/AO1K6sZ6VnQ931Gv1e\nIOmPCPfvO/Kw/aXSacoEWnMsy+qTIewVPT/MMgSaq9JewAQgLpMX+O5qqAJBYoDj\nxoZnHufGgOIKfNmSvYiHjDFJtP55PdEH21q+JA==\n-----END CERTIFICATE-----", jSONObject.toString()));
                a2.put("sig", calculateSig(a2, this.configuration.appSignKey));
                this.asyncHttpClient.post(this.configuration.context, a(), new RequestParams(a2), new HttpResponseHandler(Looper.getMainLooper()) { // from class: com.baidu.sapi2.EnhancedService.8
                    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                    protected void onStart() {
                        sapiCallback.onStart();
                        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_DYNAMICPWD_LOGIN, IEventCenterService.EventResult.PHASE.START);
                    }

                    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                    protected void onFinish() {
                        sapiCallback.onFinish();
                        PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_DYNAMICPWD_LOGIN, IEventCenterService.EventResult.PHASE.FINISH);
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                    public void onSuccess(int i, String str3) {
                        EnhancedService.this.domainRetry.reset();
                        int errorCode = EnhancedService.this.getErrorCode(str3);
                        dynamicPwdLoginResult.setResultCode(errorCode);
                        try {
                            JSONObject jSONObject2 = new JSONObject(sapiDataEncryptor.decrypt(new JSONObject(str3).optString("userinfo")));
                            dynamicPwdLoginResult.setResultMsg(jSONObject2.optJSONObject("sdk").optString("msg"));
                            switch (errorCode) {
                                case 0:
                                    SapiAccount parseAccount = EnhancedService.this.parseAccount(jSONObject2);
                                    if (sapiCallback instanceof SapiCallbackInterceptor) {
                                        dynamicPwdLoginResult.session = parseAccount;
                                        ((SapiCallbackInterceptor) sapiCallback).beforeSuccess(dynamicPwdLoginResult);
                                    }
                                    parseAccount.extra = SapiAccount.DispersionCertification.fromJSONObject(jSONObject2).toJSONObject().toString();
                                    ServiceManager.getInstance().getIsAccountManager().validate(parseAccount);
                                    sapiCallback.onSuccess(dynamicPwdLoginResult);
                                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_DYNAMICPWD_LOGIN, IEventCenterService.EventResult.PHASE.SUCCESS);
                                    return;
                                default:
                                    sapiCallback.onFailure(dynamicPwdLoginResult);
                                    PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_DYNAMICPWD_LOGIN, IEventCenterService.EventResult.PHASE.FAILURE);
                                    return;
                            }
                        } catch (Exception e) {
                            sapiCallback.onFailure(dynamicPwdLoginResult);
                            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_DYNAMICPWD_LOGIN, IEventCenterService.EventResult.PHASE.FAILURE);
                            Log.e(e);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.cloudsdk.common.http.HttpResponseHandler
                    public void onFailure(Throwable th, String str3) {
                        if (!EnhancedService.this.domainRetry.isShouldRetry()) {
                            EnhancedService.this.domainRetry.reset();
                            if (th != null && SSLPeerUnverifiedException.class.getSimpleName().equals(th.getClass().getSimpleName())) {
                                StatService.onEvent("sslerr_interface", Collections.singletonMap("na_err_code", "0"), false);
                                dynamicPwdLoginResult.setResultCode(-203);
                                sapiCallback.onFailure(dynamicPwdLoginResult);
                                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_DYNAMICPWD_LOGIN, IEventCenterService.EventResult.PHASE.FINISH);
                                return;
                            }
                            dynamicPwdLoginResult.setResultCode(-202);
                            sapiCallback.onFailure(dynamicPwdLoginResult);
                            PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_DYNAMICPWD_LOGIN, IEventCenterService.EventResult.PHASE.FINISH);
                            return;
                        }
                        EnhancedService.this.domainRetry.retry();
                        EnhancedService.this.dynamicPwdLogin(sapiCallback, str, str2);
                    }
                });
            } catch (Exception e) {
                dynamicPwdLoginResult.setResultCode(-202);
                sapiCallback.onFailure(dynamicPwdLoginResult);
                PluginFacade.notify(IEventCenterService.EventId.EventMode.SAPIACCOUNT_DYNAMICPWD_LOGIN, IEventCenterService.EventResult.PHASE.FINISH);
                Log.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getCaptchaKey() {
        return this.c;
    }

    Map<String, String> a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("tpl", this.configuration.tpl);
        hashMap.put("appid", this.configuration.appId);
        if (TextUtils.isEmpty(this.configuration.clientId)) {
            this.configuration.clientId = SapiUtils.getClientId(this.configuration.context);
        }
        if (!TextUtils.isEmpty(this.configuration.clientId)) {
            hashMap.put("clientid", this.configuration.clientId);
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
        hashMap.put("sdk_version", "3");
        return hashMap;
    }

    String a() {
        return this.domainRetry.getDomain() + SapiEnv.LOGIN_URI;
    }
}
