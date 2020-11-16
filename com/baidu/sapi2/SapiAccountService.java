package com.baidu.sapi2;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.fsg.base.statistics.h;
import com.baidu.sapi2.callback.DynamicPwdLoginCallback;
import com.baidu.sapi2.callback.FillUsernameCallback;
import com.baidu.sapi2.callback.GetDynamicPwdCallback;
import com.baidu.sapi2.callback.GetHistoryPortraitsCallback;
import com.baidu.sapi2.callback.GetOpenBdussCallback;
import com.baidu.sapi2.callback.GetPopularPortraitsCallback;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.callback.IqiyiLoginCallback;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.callback.QrLoginStatusCheckCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.callback.SetPopularPortraitCallback;
import com.baidu.sapi2.callback.SetPortraitCallback;
import com.baidu.sapi2.callback.SsoHashCallback;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.contacts.callback.GetContactsCallback;
import com.baidu.sapi2.contacts.dto.GetContactsDTO;
import com.baidu.sapi2.contacts.dto.SendSmsDTO;
import com.baidu.sapi2.dto.GetHistoryPortraitsDTO;
import com.baidu.sapi2.dto.GetOpenBdussDTO;
import com.baidu.sapi2.dto.GetQrCodeImageDTO;
import com.baidu.sapi2.dto.IqiyiLoginDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.QrLoginStstusCheckDTO;
import com.baidu.sapi2.dto.SetPopularPortraitDTO;
import com.baidu.sapi2.dto.SetPortraitDTO;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.result.CheckUserFaceIdResult;
import com.baidu.sapi2.result.DynamicPwdLoginResult;
import com.baidu.sapi2.result.FaceLoginStatusResult;
import com.baidu.sapi2.result.GetCaptchaResult;
import com.baidu.sapi2.result.GetDynamicPwdResult;
import com.baidu.sapi2.result.GetQrCodeImageResult;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.OAuthResult;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.result.QrAppLoginResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.share.SapiShareClient;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.shell.callback.SapiCallBack;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SapiResponse;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.sapi2.utils.enums.Language;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public final class SapiAccountService implements com.baidu.sapi2.service.interfaces.a {
    public static final String BUSINESS_FROM_ONE_KEY_LOGIN = "business_from_one_key_login";
    private static final String c = "SapiAccountService";
    private static final String d = "native";

    /* renamed from: a  reason: collision with root package name */
    private SapiConfiguration f3228a = SapiAccountManager.getInstance().getSapiConfiguration();
    private c b = new c();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public class a extends GetTplStokenCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f3229a;

        a(Context context) {
            this.f3229a = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFailure(GetTplStokenResult getTplStokenResult) {
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onSuccess(GetTplStokenResult getTplStokenResult) {
            SapiAccountService.a(this.f3229a, getTplStokenResult.tplStokenMap.get("pp"));
        }
    }

    /* loaded from: classes15.dex */
    class b implements SapiCallback<OAuthResult> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Map f3230a;
        final /* synthetic */ SapiAccount b;

        b(Map map, SapiAccount sapiAccount) {
            this.f3230a = map;
            this.b = sapiAccount;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: a */
        public void onFailure(OAuthResult oAuthResult) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.sapi2.callback.SapiCallback
        /* renamed from: b */
        public void onSuccess(OAuthResult oAuthResult) {
            if (TextUtils.isEmpty(oAuthResult.openid)) {
                return;
            }
            this.f3230a.put(oAuthResult.openid, this.b.uid);
            SapiContext.getInstance().put(SapiContext.KEY_OPENID_UID_LIST, SapiUtils.mapToUrlParams(this.f3230a, false));
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onFinish() {
        }

        @Override // com.baidu.sapi2.callback.SapiCallback
        public void onStart() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(BindWidgetAction bindWidgetAction) {
        if (bindWidgetAction != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new PassNameValuePair("adapter", "3"));
            return this.b.a(bindWidgetAction) + "?" + f() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
        }
        throw new IllegalArgumentException("BindWidgetAction can't be null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("client", "android"));
        arrayList.add(new PassNameValuePair("clientfrom", d));
        arrayList.add(new PassNameValuePair("adapter", "3"));
        arrayList.add(new PassNameValuePair("banner", "1"));
        arrayList.add(new PassNameValuePair("t", String.valueOf(System.currentTimeMillis())));
        return this.b.q() + "?" + a(false) + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() {
        return this.b.k() + "?" + a(true);
    }

    public void cancelRequest() {
        this.b.a();
    }

    public void checkFaceLoginStatus(SapiCallback<FaceLoginStatusResult> sapiCallback, String str) {
        this.b.a(sapiCallback, str);
    }

    public void checkOneKeyLoginIsAvailable(OneKeyLoginCallback oneKeyLoginCallback, String str, int i) {
        if (oneKeyLoginCallback == null) {
            Log.d(c, "OneKeyLoginCallback is null, because this is an init process");
        } else if (TextUtils.isEmpty(str)) {
            Log.d(c, "encryptPhoneNum is null or empty, unkown error occured");
            new OneKeyLoginSdkCall().b(oneKeyLoginCallback, -100, null);
        } else {
            this.b.a(oneKeyLoginCallback, str, i);
        }
    }

    public void checkUserFaceId(SapiCallback<CheckUserFaceIdResult> sapiCallback, String str) {
        this.b.a(sapiCallback, str, (Map<String, String>) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d() {
        return this.b.r() + "?" + f();
    }

    @Deprecated
    public boolean dynamicPwdLogin(SapiCallBack<SapiAccountResponse> sapiCallBack, String str, String str2) {
        return this.b.a(sapiCallBack, str, str2, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String e() {
        ArrayList arrayList;
        SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        String str = sapiConfiguration.environment.getWap() + "/wp/";
        new ArrayList().add(new PassNameValuePair("appid", sapiConfiguration.appId));
        if (TextUtils.isEmpty(sapiConfiguration.clientId)) {
            sapiConfiguration.clientId = SapiUtils.getClientId(sapiConfiguration.context);
        }
        return str + "?" + f() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
    }

    public void extendSysWebViewMethodCheck(SapiCallback<SapiResult> sapiCallback, String str, String str2) {
        this.b.a(sapiCallback, str, str2);
    }

    String f() {
        return a(true);
    }

    public void faceLoginSwitch(SapiCallback<SapiResult> sapiCallback, String str, boolean z, String str2) {
        this.b.a(sapiCallback, str, z, str2);
    }

    public void fillUsername(FillUsernameCallback fillUsernameCallback, String str, String str2) {
        this.b.a(fillUsernameCallback, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String g() {
        return this.b.o() + "?" + f();
    }

    public void generateSsoHash(SsoHashCallback ssoHashCallback, String str, String str2) {
        this.b.a(ssoHashCallback, str, str2);
    }

    public int getBdussState() {
        return new OpenBdussService(this.f3228a, "8.9.9.1").getBdussState();
    }

    public void getCaptcha(SapiCallback<GetCaptchaResult> sapiCallback) {
        EnhancedService.getInstance(this.f3228a, "8.9.9.1").getCaptcha(sapiCallback);
    }

    public String getCaptchaKey() {
        return EnhancedService.getInstance(this.f3228a, "8.9.9.1").getCaptchaKey();
    }

    public void getContacts(GetContactsCallback getContactsCallback, GetContactsDTO getContactsDTO) {
        GetContactsService.getInstance(this.f3228a, "8.9.9.1").getContacts(getContactsCallback, getContactsDTO);
    }

    @Deprecated
    public boolean getDynamicPwd(SapiCallBack<SapiResponse> sapiCallBack, String str) {
        return this.b.a(sapiCallBack, str);
    }

    public String getExplainCameraDeatilUrl() {
        return this.b.j() + "?" + f();
    }

    public void getHistoryPortraits(GetHistoryPortraitsCallback getHistoryPortraitsCallback, GetHistoryPortraitsDTO getHistoryPortraitsDTO) {
        new PortraitService(this.f3228a, "8.9.9.1").getHistoryPortraits(getHistoryPortraitsCallback, getHistoryPortraitsDTO);
    }

    public String getIqiyiAccessToken() {
        return SapiContext.getInstance().getIqiyiAccesstoken();
    }

    public void getOneKeyLoginToken(OneKeyLoginSdkCall.TokenListener tokenListener) {
        new OneKeyLoginSdkCall().b(this.f3228a, tokenListener);
    }

    public void getOpenBduss(GetOpenBdussDTO getOpenBdussDTO, GetOpenBdussCallback getOpenBdussCallback) {
        new OpenBdussService(this.f3228a, "8.9.9.1").getOpenBduss(getOpenBdussDTO, getOpenBdussCallback);
    }

    public JSONObject getPhoneNumAndOperatorType() {
        return new OneKeyLoginSdkCall().b();
    }

    public void getPopularPortraitsInfo(GetPopularPortraitsCallback getPopularPortraitsCallback, String str) {
        new PortraitService(this.f3228a, "8.9.9.1").getPopularPortraitsInfo(getPopularPortraitsCallback, str);
    }

    public void getQrCodeImage(SapiCallback<GetQrCodeImageResult> sapiCallback, GetQrCodeImageDTO getQrCodeImageDTO) {
        QrCodeService.getInstance(this.f3228a, "8.9.9.1").getQrCodeImage(sapiCallback, getQrCodeImageDTO);
    }

    public Map<String, String> getTplStoken(GetTplStokenCallback getTplStokenCallback, String str, List<String> list) {
        return a(getTplStokenCallback, str, list, true);
    }

    public void getUserInfo(GetUserInfoCallback getUserInfoCallback, String str) {
        this.b.a(getUserInfoCallback, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String h() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("adapter", "3"));
        return this.b.p() + "?" + f() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
    }

    public void handleOneKeyLoginResult(OneKeyLoginCallback oneKeyLoginCallback, String str) {
        SapiAccountResponse b2 = com.baidu.sapi2.utils.d.b("business_from_one_key_login", str);
        if (b2 != null) {
            SapiShareClient.getInstance().validate(a(b2));
            a(oneKeyLoginCallback, b2.accountType);
            return;
        }
        new OneKeyLoginSdkCall().a(oneKeyLoginCallback, -103, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String i() {
        return this.b.f();
    }

    public void iqiyiSSOLogin(IqiyiLoginCallback iqiyiLoginCallback, IqiyiLoginDTO iqiyiLoginDTO) {
        this.b.a(iqiyiLoginCallback, iqiyiLoginDTO);
    }

    public boolean isStokenExist(String str, List<String> list) {
        return this.b.a(str, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String j() {
        return this.b.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String k() {
        return this.b.h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String l() {
        return this.b.s() + "?" + f();
    }

    @Deprecated
    public void oauth(SapiCallback<OAuthResult> sapiCallback, String str) {
        this.b.b(sapiCallback, str, null);
    }

    public void preGetPhoneInfo() {
        new OneKeyLoginSdkCall().a(this.f3228a, "product");
    }

    public void qrAppLogin(SapiCallback<QrAppLoginResult> sapiCallback, String str, String str2) {
        QrCodeService.getInstance(this.f3228a, "8.9.9.1").qrAppLogin(sapiCallback, str, str2);
    }

    public void qrJoinLoginStatusCheck(QrLoginStatusCheckCallback qrLoginStatusCheckCallback, QrLoginStstusCheckDTO qrLoginStstusCheckDTO) {
        qrLoginStstusCheckDTO.isJoinCodeLogin = true;
        QrCodeService.getInstance(this.f3228a, "8.9.9.1").qrLoginStatusCheck(qrLoginStatusCheckCallback, qrLoginStstusCheckDTO, true);
    }

    public void qrLoginStatusCheck(QrLoginStatusCheckCallback qrLoginStatusCheckCallback, QrLoginStstusCheckDTO qrLoginStstusCheckDTO) {
        QrCodeService.getInstance(this.f3228a, "8.9.9.1").qrLoginStatusCheck(qrLoginStatusCheckCallback, qrLoginStstusCheckDTO, true);
    }

    public void refreshOpenidToUid() {
        if (this.f3228a.needOpenid) {
            List<SapiAccount> loginAccounts = SapiAccountManager.getInstance().getLoginAccounts();
            loginAccounts.addAll(SapiAccountManager.getInstance().getShareAccounts());
            if (loginAccounts.size() == 0) {
                SapiContext.getInstance().put(SapiContext.KEY_OPENID_UID_LIST, "");
                return;
            }
            Map<String, String> urlParamsToMap = SapiUtils.urlParamsToMap(SapiContext.getInstance().getString(SapiContext.KEY_OPENID_UID_LIST));
            Collection<String> values = urlParamsToMap.values();
            for (SapiAccount sapiAccount : loginAccounts) {
                if (!values.contains(sapiAccount.uid)) {
                    values.remove(sapiAccount.uid);
                }
            }
            SapiContext.getInstance().put(SapiContext.KEY_OPENID_UID_LIST, SapiUtils.mapToUrlParams(urlParamsToMap, false));
            for (SapiAccount sapiAccount2 : loginAccounts) {
                if (!urlParamsToMap.containsValue(sapiAccount2.uid)) {
                    oauth(new b(urlParamsToMap, sapiAccount2), sapiAccount2.bduss);
                }
            }
        }
    }

    public void relaseContactsSource() {
        GetContactsService.getInstance(this.f3228a, "8.9.9.1").relaseContactsSource();
    }

    public void sendContactsSms(SendSmsDTO sendSmsDTO) {
        GetContactsService.getInstance(this.f3228a, "8.9.9.1").sendSMS(sendSmsDTO);
    }

    public void setCloudShareAccount(int i, ShareStorage.StorageModel storageModel) {
        this.b.a(i, storageModel);
    }

    public void setIqiyiAccessToken(String str) {
        SapiContext.getInstance().setIqiyiAccesstoken(str);
        if (SapiShareClient.isInShareOtherInfoWhiteList()) {
            this.b.c(str);
            SapiShareClient.getInstance().validateOtherInfo();
        }
    }

    public void setPopularPortrait(SetPopularPortraitCallback setPopularPortraitCallback, SetPopularPortraitDTO setPopularPortraitDTO) {
        new PortraitService(this.f3228a, "8.9.9.1").setPopularPortrait(setPopularPortraitCallback, setPopularPortraitDTO);
    }

    @Deprecated
    public void setPortrait(SetPortraitCallback setPortraitCallback, String str, byte[] bArr, String str2) {
        SetPortraitDTO setPortraitDTO = new SetPortraitDTO();
        setPortraitDTO.bduss = str;
        setPortraitDTO.file = bArr;
        setPortraitDTO.contentType = str2;
        setPortrait(setPortraitDTO, setPortraitCallback);
    }

    public void stopQrLoginStatusCheck() {
        QrCodeService.getInstance(this.f3228a, "8.9.9.1").stopLoginStatusCheck();
    }

    public void web2NativeLogin(Web2NativeLoginCallback web2NativeLoginCallback) {
        this.b.a(web2NativeLoginCallback, false);
    }

    public void checkUserFaceId(SapiCallback<CheckUserFaceIdResult> sapiCallback, String str, Map<String, String> map) {
        this.b.a(sapiCallback, str, map);
    }

    @Deprecated
    public void dynamicPwdLogin(SapiCallback<DynamicPwdLoginResult> sapiCallback, String str, String str2) {
        EnhancedService.getInstance(this.f3228a, "8.9.9.1").dynamicPwdLogin(sapiCallback, str, str2, (Map) null);
    }

    @Deprecated
    public void getDynamicPwd(SapiCallback<GetDynamicPwdResult> sapiCallback, String str) {
        EnhancedService.getInstance(this.f3228a, "8.9.9.1").getDynamicPwd(sapiCallback, str);
    }

    public void oauth(SapiCallback<OAuthResult> sapiCallback, String str, String str2) {
        this.b.b(sapiCallback, str, str2);
    }

    public void web2NativeLogin(Web2NativeLoginCallback web2NativeLoginCallback, boolean z) {
        this.b.a(web2NativeLoginCallback, z);
    }

    public boolean webLogin(Context context) {
        SapiAccount currentAccount;
        if (context == null || (currentAccount = SapiContext.getInstance().getCurrentAccount()) == null) {
            return false;
        }
        return SapiUtils.webLogin(context, currentAccount.bduss, currentAccount.ptoken);
    }

    public void dynamicPwdLogin(DynamicPwdLoginCallback dynamicPwdLoginCallback, String str, String str2) {
        dynamicPwdLogin(dynamicPwdLoginCallback, str, str2, null);
    }

    public void getDynamicPwd(GetDynamicPwdCallback getDynamicPwdCallback, String str, String str2) {
        getDynamicPwd(getDynamicPwdCallback, str, str2, null);
    }

    @Override // com.baidu.sapi2.service.interfaces.a
    public boolean webLogin(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("pp");
            SapiAccountManager.getInstance().getAccountService().getTplStoken(new a(context), str, arrayList);
            SapiAccount accountFromBduss = SapiContext.getInstance().getAccountFromBduss(str);
            if (accountFromBduss != null) {
                return a(context, accountFromBduss.bduss, accountFromBduss.ptoken);
            }
            return a(context, str, (String) null);
        }
        return false;
    }

    public void dynamicPwdLogin(DynamicPwdLoginCallback dynamicPwdLoginCallback, String str, String str2, Map<String, String> map) {
        EnhancedService.getInstance(this.f3228a, "8.9.9.1").dynamicPwdLogin(dynamicPwdLoginCallback, str, str2, map);
    }

    public void getDynamicPwd(GetDynamicPwdCallback getDynamicPwdCallback, String str, String str2, Map<String, String> map) {
        EnhancedService.getInstance(this.f3228a, "8.9.9.1").getDynamicPwd(getDynamicPwdCallback, str, str2, map);
    }

    public void setPortrait(SetPortraitDTO setPortraitDTO, SetPortraitCallback setPortraitCallback) {
        new PortraitService(this.f3228a, "8.9.9.1").setPortrait(setPortraitDTO, setPortraitCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(SocialType socialType) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("type", socialType.getName()));
        return this.b.m() + "?" + f() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        return this.b.e() + "?" + f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(String str) {
        String b2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("adapter", "3"));
        arrayList.add(new PassNameValuePair("wapsec", "center"));
        if (this.f3228a.accountCenterRealAutnen) {
            arrayList.add(new PassNameValuePair("realName", "1"));
        } else {
            arrayList.add(new PassNameValuePair("realName", "0"));
        }
        if (SapiWebView.ACCOUNT_CENTER_REAL_NAME.equals(str)) {
            b2 = this.b.d();
        } else if (SapiWebView.ACCOUNT_CENTER_CHECK.equals(str)) {
            arrayList.add(new PassNameValuePair("hidebtmback", "1"));
            b2 = this.b.c();
        } else {
            b2 = this.b.b();
        }
        return b2 + "?" + a(false) + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
    }

    String a(boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("clientfrom", d));
        arrayList.add(new PassNameValuePair("tpl", this.f3228a.tpl));
        arrayList.add(new PassNameValuePair("login_share_strategy", this.f3228a.loginShareStrategy().getStrValue()));
        arrayList.add(new PassNameValuePair("client", "android"));
        if (z) {
            arrayList.add(new PassNameValuePair("adapter", this.f3228a.customActionBarEnabled ? "3" : ""));
        }
        arrayList.add(new PassNameValuePair("t", String.valueOf(System.currentTimeMillis())));
        arrayList.add(new PassNameValuePair("act", this.f3228a.socialBindType.getName()));
        arrayList.add(new PassNameValuePair("hideExtraEntry", String.valueOf(this.f3228a.smsLoginConfig.flagHideExtraEntry.ordinal())));
        arrayList.add(new PassNameValuePair("loginLink", String.valueOf(this.f3228a.smsLoginConfig.flagShowLoginLink.ordinal())));
        arrayList.add(new PassNameValuePair("smsLoginLink", String.valueOf(this.f3228a.smsLoginConfig.flagShowSmsLoginLink.ordinal())));
        arrayList.add(new PassNameValuePair("lPFastRegLink", String.valueOf(this.f3228a.smsLoginConfig.flagShowFastRegLink.ordinal())));
        arrayList.add(new PassNameValuePair("lPlayout", String.valueOf(this.f3228a.configurableViewLayout.ordinal())));
        if (this.f3228a.uniteVerify) {
            arrayList.add(new PassNameValuePair("connect", "1"));
        }
        if (this.f3228a.language == Language.ENGLISH) {
            arrayList.add(new PassNameValuePair("lang", h.f1495a));
        }
        arrayList.add(new PassNameValuePair("suppcheck", "1"));
        if (this.f3228a.supportFaceLogin) {
            arrayList.add(new PassNameValuePair("scanface", "1"));
        }
        if (this.f3228a.disableVoiceVerify) {
            arrayList.add(new PassNameValuePair("disable_voice_vcode", "1"));
        }
        return SapiUtils.createRequestParams(arrayList);
    }

    @Override // com.baidu.sapi2.service.interfaces.a
    public boolean webLogin(Context context, String str, String str2) {
        return webLogin(context, str);
    }

    boolean a(SapiCallBack<SapiAccountResponse> sapiCallBack, String str, String str2) {
        return this.b.a(sapiCallBack, str, str2, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(SapiAccount sapiAccount, List<String> list) {
        return this.b.a(sapiAccount, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, String> a(GetTplStokenCallback getTplStokenCallback, String str, List<String> list, boolean z) {
        return this.b.a(getTplStokenCallback, str, list, z);
    }

    private boolean a(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            ArrayList arrayList = new ArrayList();
            for (String str3 : SapiUtils.getAuthorizedDomains()) {
                if (!str.equals(SapiUtils.getCookie(SapiUtils.COOKIE_URL_PREFIX + str3, "BDUSS"))) {
                    arrayList.add(new PassNameValuePair(SapiUtils.COOKIE_URL_PREFIX + str3, SapiUtils.buildBDUSSCookie(str3, str)));
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                for (String str4 : SapiUtils.getAuthorizedDomainsForPtoken()) {
                    if (!str2.equals(SapiUtils.getCookie(SapiUtils.COOKIE_HTTPS_URL_PREFIX + str4, "PTOKEN"))) {
                        arrayList.add(new PassNameValuePair(SapiUtils.COOKIE_HTTPS_URL_PREFIX + str4, SapiUtils.buildPtokenCookie(str4, str2)));
                    }
                }
            }
            SapiUtils.syncCookies(context, arrayList);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                for (String str2 : SapiUtils.getAuthorizedDomainsForPtoken()) {
                    if (!str.equals(SapiUtils.getCookie(SapiUtils.COOKIE_HTTPS_URL_PREFIX + str2, "STOKEN"))) {
                        arrayList.add(new PassNameValuePair(SapiUtils.COOKIE_HTTPS_URL_PREFIX + str2, SapiUtils.buildStokenCookie(str2, str)));
                    }
                }
            }
            SapiUtils.syncCookies(context, arrayList);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(OneKeyLoginCallback oneKeyLoginCallback, String str, String str2, com.baidu.sapi2.callback.a.b bVar) {
        this.b.a(oneKeyLoginCallback, str, str2, bVar);
    }

    private SapiAccount a(SapiAccountResponse sapiAccountResponse) {
        SapiAccount sapiAccount = new SapiAccount();
        sapiAccount.uid = sapiAccountResponse.uid;
        sapiAccount.bduss = sapiAccountResponse.bduss;
        sapiAccount.displayname = sapiAccountResponse.displayname;
        sapiAccount.stoken = sapiAccountResponse.stoken;
        sapiAccount.ptoken = sapiAccountResponse.ptoken;
        sapiAccount.email = sapiAccountResponse.email;
        sapiAccount.username = sapiAccountResponse.username;
        sapiAccount.app = TextUtils.isEmpty(sapiAccountResponse.app) ? SapiUtils.getAppName(this.f3228a.context) : sapiAccountResponse.app;
        sapiAccount.extra = sapiAccountResponse.extra;
        if (SocialType.UNKNOWN != sapiAccountResponse.socialType) {
            SapiContext.getInstance().put(SapiContext.KEY_PRE_LOGIN_TYPE, sapiAccountResponse.socialType.getName());
            sapiAccount.addSocialInfo(sapiAccountResponse.socialType, sapiAccountResponse.socialPortraitUrl);
            sapiAccount.putExtra("account_type", Integer.valueOf(sapiAccountResponse.accountType.getType()));
        }
        sapiAccount.putExtra("tpl", this.f3228a.tpl);
        if (!sapiAccountResponse.tplStokenMap.isEmpty()) {
            sapiAccount.addDispersionCertification(sapiAccountResponse.tplStokenMap);
        }
        SapiContext.getInstance().setAccountActionType(sapiAccountResponse.actionType);
        sapiAccount.addIsGuestAccount(sapiAccountResponse.isGuestAccount);
        if (!TextUtils.isEmpty(sapiAccountResponse.livingUname)) {
            new FaceLoginService().syncFaceLoginUID(this.f3228a.context, sapiAccountResponse.livingUname);
        }
        return sapiAccount;
    }

    private void a(OneKeyLoginCallback oneKeyLoginCallback, AccountType accountType) {
        OneKeyLoginResult oneKeyLoginResult = new OneKeyLoginResult();
        oneKeyLoginResult.setResultCode(0);
        oneKeyLoginCallback.onSuccess(oneKeyLoginResult);
    }
}
