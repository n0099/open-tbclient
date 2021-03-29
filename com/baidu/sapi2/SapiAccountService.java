package com.baidu.sapi2;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.sapi2.activity.SlideActiviy;
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
import com.baidu.sapi2.dto.GetOneKeyLoginStateDTO;
import com.baidu.sapi2.dto.GetOpenBdussDTO;
import com.baidu.sapi2.dto.GetQrCodeImageDTO;
import com.baidu.sapi2.dto.IqiyiLoginDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.QrLoginStstusCheckDTO;
import com.baidu.sapi2.dto.SetPopularPortraitDTO;
import com.baidu.sapi2.dto.SetPortraitDTO;
import com.baidu.sapi2.enums.PortraitCategory;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.result.CheckUserFaceIdResult;
import com.baidu.sapi2.result.DynamicPwdLoginResult;
import com.baidu.sapi2.result.FaceLoginStatusResult;
import com.baidu.sapi2.result.GetCaptchaResult;
import com.baidu.sapi2.result.GetDynamicPwdResult;
import com.baidu.sapi2.result.GetQrCodeImageResult;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.OAuthResult;
import com.baidu.sapi2.result.OneKeyLoginOptResult;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.result.QrAppLoginResult;
import com.baidu.sapi2.result.SapiResult;
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
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class SapiAccountService implements com.baidu.sapi2.service.interfaces.a {
    public static final String BUSINESS_FROM_ONE_KEY_LOGIN = "business_from_one_key_login";

    /* renamed from: c  reason: collision with root package name */
    public static final String f10627c = "SapiAccountService";

    /* renamed from: d  reason: collision with root package name */
    public static final String f10628d = "native";

    /* renamed from: a  reason: collision with root package name */
    public SapiConfiguration f10629a = SapiAccountManager.getInstance().getSapiConfiguration();

    /* renamed from: b  reason: collision with root package name */
    public c f10630b = new c();

    /* loaded from: classes2.dex */
    public class a extends GetTplStokenCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f10631a;

        public a(Context context) {
            this.f10631a = context;
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
            SapiAccountService.a(this.f10631a, getTplStokenResult.tplStokenMap.get("pp"));
        }
    }

    /* loaded from: classes2.dex */
    public class b implements com.baidu.sapi2.callback.a.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OneKeyLoginCallback f10633a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GetOneKeyLoginStateDTO f10634b;

        public b(OneKeyLoginCallback oneKeyLoginCallback, GetOneKeyLoginStateDTO getOneKeyLoginStateDTO) {
            this.f10633a = oneKeyLoginCallback;
            this.f10634b = getOneKeyLoginStateDTO;
        }

        @Override // com.baidu.sapi2.callback.a.d
        public void a(OneKeyLoginOptResult oneKeyLoginOptResult) {
            if (oneKeyLoginOptResult == null) {
                OneKeyLoginSdkCall.getInstance().preGetPhoneFail(this.f10633a, -100, null);
            } else if (TextUtils.isEmpty(oneKeyLoginOptResult.getSecurityPhone())) {
                OneKeyLoginSdkCall.getInstance().preGetPhoneFail(this.f10633a, oneKeyLoginOptResult.getCode(), oneKeyLoginOptResult.getSubCode(), null);
            } else {
                SapiAccountService.this.f10630b.a(this.f10633a, oneKeyLoginOptResult.getSecurityPhone(), this.f10634b.connectTimeout);
            }
        }
    }

    public String b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("client", "android"));
        arrayList.add(new PassNameValuePair("clientfrom", "native"));
        arrayList.add(new PassNameValuePair("adapter", "3"));
        arrayList.add(new PassNameValuePair("banner", "1"));
        arrayList.add(new PassNameValuePair("t", String.valueOf(System.currentTimeMillis())));
        return this.f10630b.r() + "?" + a(false) + "&" + SapiUtils.createRequestParams(arrayList);
    }

    public String c() {
        return this.f10630b.k() + "?" + a(true);
    }

    public void cancelRequest() {
        this.f10630b.a();
    }

    public void checkFaceLoginStatus(SapiCallback<FaceLoginStatusResult> sapiCallback, String str) {
        this.f10630b.a(sapiCallback, str);
    }

    public void checkUserFaceId(SapiCallback<CheckUserFaceIdResult> sapiCallback, String str) {
        this.f10630b.a(sapiCallback, str, (Map<String, String>) null);
    }

    public String d() {
        return this.f10630b.s() + "?" + f();
    }

    @Deprecated
    public boolean dynamicPwdLogin(SapiCallBack<SapiAccountResponse> sapiCallBack, String str, String str2) {
        return this.f10630b.a(sapiCallBack, str, str2, true);
    }

    public String e() {
        ArrayList arrayList;
        SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        String str = sapiConfiguration.environment.getWap() + "/wp/";
        new ArrayList().add(new PassNameValuePair("appid", sapiConfiguration.appId));
        SapiUtils.getClientId(sapiConfiguration.context);
        return str + "?" + f() + "&" + SapiUtils.createRequestParams(arrayList);
    }

    public void extendSysWebViewMethodCheck(SapiCallback<SapiResult> sapiCallback, String str, String str2) {
        this.f10630b.a(sapiCallback, str, str2);
    }

    public String f() {
        return a(true);
    }

    public void faceLoginSwitch(SapiCallback<SapiResult> sapiCallback, String str, boolean z, String str2) {
        this.f10630b.a(sapiCallback, str, z, str2);
    }

    public void fillUsername(FillUsernameCallback fillUsernameCallback, String str, String str2) {
        this.f10630b.a(fillUsernameCallback, str, str2);
    }

    public String g() {
        return this.f10630b.p() + "?" + f();
    }

    public void generateSsoHash(SsoHashCallback ssoHashCallback, String str, String str2) {
        this.f10630b.a(ssoHashCallback, str, str2);
    }

    public int getBdussState() {
        return new OpenBdussService(this.f10629a, "9.2.9.8").getBdussState();
    }

    public void getCaptcha(SapiCallback<GetCaptchaResult> sapiCallback) {
        EnhancedService.getInstance(this.f10629a, "9.2.9.8").getCaptcha(sapiCallback);
    }

    public String getCaptchaKey() {
        return EnhancedService.getInstance(this.f10629a, "9.2.9.8").getCaptchaKey();
    }

    public void getContacts(GetContactsCallback getContactsCallback, GetContactsDTO getContactsDTO) {
        GetContactsService.getInstance(this.f10629a, "9.2.9.8").getContacts(getContactsCallback, getContactsDTO);
    }

    @Deprecated
    public boolean getDynamicPwd(SapiCallBack<SapiResponse> sapiCallBack, String str) {
        return this.f10630b.a(sapiCallBack, str);
    }

    public String getExplainCameraDeatilUrl() {
        return this.f10630b.j() + "?" + f();
    }

    public void getHistoryPortraits(GetHistoryPortraitsCallback getHistoryPortraitsCallback, GetHistoryPortraitsDTO getHistoryPortraitsDTO) {
        new PortraitService(this.f10629a, "9.2.9.8").getHistoryPortraits(getHistoryPortraitsCallback, getHistoryPortraitsDTO);
    }

    public void getOneKeyLoginIsAvailable(GetOneKeyLoginStateDTO getOneKeyLoginStateDTO, OneKeyLoginCallback oneKeyLoginCallback) {
        if (oneKeyLoginCallback == null) {
            Log.e(f10627c, "When check oneKeyLogin's ability, oneKeyLoginCallback can't be null!");
        } else if (Build.VERSION.SDK_INT < 19) {
            OneKeyLoginSdkCall.getInstance().preGetPhoneFail(oneKeyLoginCallback, OneKeyLoginResult.ONE_KEY_LOGIN_CODE_ANDROID_VERSION_BELOW_KITKAT, null);
        } else {
            OneKeyLoginOptResult preLoginOptResult = OneKeyLoginSdkCall.getInstance().getPreLoginOptResult();
            if (preLoginOptResult != null && !TextUtils.isEmpty(preLoginOptResult.getSecurityPhone())) {
                this.f10630b.a(oneKeyLoginCallback, preLoginOptResult.getSecurityPhone(), getOneKeyLoginStateDTO.connectTimeout);
            } else {
                OneKeyLoginSdkCall.getInstance().preGetPhoneInfo(this.f10629a, OneKeyLoginSdkCall.OKL_SCENE_SAPI, getOneKeyLoginStateDTO.connectTimeout, new b(oneKeyLoginCallback, getOneKeyLoginStateDTO));
            }
        }
    }

    public void getOneKeyLoginToken(OneKeyLoginSdkCall.TokenListener tokenListener) {
        new OneKeyLoginSdkCall().getToken(this.f10629a, tokenListener);
    }

    public void getOpenBduss(GetOpenBdussDTO getOpenBdussDTO, GetOpenBdussCallback getOpenBdussCallback) {
        new OpenBdussService(this.f10629a, "9.2.9.8").getOpenBduss(getOpenBdussDTO, getOpenBdussCallback);
    }

    public JSONObject getPhoneNumAndOperatorType() {
        return new OneKeyLoginSdkCall().getEncryptPhone();
    }

    public void getPopularPortraitsInfo(GetPopularPortraitsCallback getPopularPortraitsCallback, String str, PortraitCategory portraitCategory) {
        new PortraitService(this.f10629a, "9.2.9.8").getPopularPortraitsInfo(getPopularPortraitsCallback, str, portraitCategory);
    }

    public void getQrCodeImage(SapiCallback<GetQrCodeImageResult> sapiCallback, GetQrCodeImageDTO getQrCodeImageDTO) {
        QrCodeService.getInstance(this.f10629a, "9.2.9.8").getQrCodeImage(sapiCallback, getQrCodeImageDTO);
    }

    public void getShareV3App(String str, List<String> list, String str2, com.baidu.sapi2.callback.a.b bVar) {
        this.f10630b.a(str, list, str2, bVar);
    }

    public Map<String, String> getTplStoken(GetTplStokenCallback getTplStokenCallback, String str, List<String> list) {
        return a(getTplStokenCallback, str, list, true);
    }

    public void getUserInfo(GetUserInfoCallback getUserInfoCallback, String str) {
        this.f10630b.a(getUserInfoCallback, str);
    }

    public String h() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("adapter", "3"));
        return this.f10630b.q() + "?" + f() + "&" + SapiUtils.createRequestParams(arrayList);
    }

    public void handleOneKeyLoginResult(OneKeyLoginCallback oneKeyLoginCallback, String str) {
        SapiAccountResponse b2 = com.baidu.sapi2.utils.e.b("business_from_one_key_login", str);
        if (b2 != null) {
            SapiAccountManager.getInstance().validate(a(b2));
            a(oneKeyLoginCallback, b2.accountType);
            return;
        }
        new OneKeyLoginSdkCall().loadOneKeyLoginFail(oneKeyLoginCallback, -103, null);
    }

    public String i() {
        return this.f10630b.f();
    }

    public void iqiyiSSOLogin(IqiyiLoginCallback iqiyiLoginCallback, IqiyiLoginDTO iqiyiLoginDTO) {
        this.f10630b.a(iqiyiLoginCallback, iqiyiLoginDTO);
    }

    public boolean isStokenExist(String str, List<String> list) {
        return this.f10630b.a(str, list);
    }

    public String j() {
        return this.f10630b.g();
    }

    public String k() {
        return this.f10630b.h();
    }

    public String l() {
        return this.f10630b.t() + "?" + f();
    }

    @Deprecated
    public void oauth(SapiCallback<OAuthResult> sapiCallback, String str) {
        this.f10630b.b(sapiCallback, str, null);
    }

    public void oauthAccessToken(SapiCallback<OAuthResult> sapiCallback, String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || sapiCallback == null) {
            return;
        }
        if (z) {
            this.f10630b.b(sapiCallback, str, str2);
        } else {
            this.f10630b.c(sapiCallback, str, str2);
        }
    }

    public void preGetPhoneInfo() {
        new OneKeyLoginSdkCall().preGetPhoneInfo(this.f10629a, "product");
    }

    public void qrAppLogin(SapiCallback<QrAppLoginResult> sapiCallback, String str, String str2) {
        QrCodeService.getInstance(this.f10629a, "9.2.9.8").qrAppLogin(sapiCallback, str, str2);
    }

    public void qrJoinLoginStatusCheck(QrLoginStatusCheckCallback qrLoginStatusCheckCallback, QrLoginStstusCheckDTO qrLoginStstusCheckDTO) {
        qrLoginStstusCheckDTO.isJoinCodeLogin = true;
        QrCodeService.getInstance(this.f10629a, "9.2.9.8").qrLoginStatusCheck(qrLoginStatusCheckCallback, qrLoginStstusCheckDTO, true);
    }

    public void qrLoginStatusCheck(QrLoginStatusCheckCallback qrLoginStatusCheckCallback, QrLoginStstusCheckDTO qrLoginStstusCheckDTO) {
        QrCodeService.getInstance(this.f10629a, "9.2.9.8").qrLoginStatusCheck(qrLoginStatusCheckCallback, qrLoginStstusCheckDTO, true);
    }

    public void relaseContactsSource() {
        GetContactsService.getInstance(this.f10629a, "9.2.9.8").relaseContactsSource();
    }

    public void sendContactsSms(SendSmsDTO sendSmsDTO) {
        GetContactsService.getInstance(this.f10629a, "9.2.9.8").sendSMS(sendSmsDTO);
    }

    public void setCloudShareAccount(int i, ShareStorage.StorageModel storageModel) {
        this.f10630b.a(i, storageModel);
    }

    public void setPopularPortrait(SetPopularPortraitCallback setPopularPortraitCallback, SetPopularPortraitDTO setPopularPortraitDTO) {
        new PortraitService(this.f10629a, "9.2.9.8").setPopularPortrait(setPopularPortraitCallback, setPopularPortraitDTO);
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
        QrCodeService.getInstance(this.f10629a, "9.2.9.8").stopLoginStatusCheck();
    }

    public void web2NativeLogin(Web2NativeLoginCallback web2NativeLoginCallback) {
        this.f10630b.a(web2NativeLoginCallback, true);
    }

    public boolean webLogin(Context context) {
        SapiAccount currentAccount;
        if (context == null || (currentAccount = SapiContext.getInstance().getCurrentAccount()) == null) {
            return false;
        }
        return SapiUtils.webLogin(context, currentAccount.bduss, currentAccount.ptoken);
    }

    public String a(BindWidgetAction bindWidgetAction) {
        if (bindWidgetAction != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new PassNameValuePair("adapter", "3"));
            return this.f10630b.a(bindWidgetAction) + "?" + f() + "&" + SapiUtils.createRequestParams(arrayList);
        }
        throw new IllegalArgumentException("BindWidgetAction can't be null");
    }

    public void checkUserFaceId(SapiCallback<CheckUserFaceIdResult> sapiCallback, String str, Map<String, String> map) {
        this.f10630b.a(sapiCallback, str, map);
    }

    @Deprecated
    public void dynamicPwdLogin(SapiCallback<DynamicPwdLoginResult> sapiCallback, String str, String str2) {
        EnhancedService.getInstance(this.f10629a, "9.2.9.8").dynamicPwdLogin(sapiCallback, str, str2, (Map) null);
    }

    @Deprecated
    public void getDynamicPwd(SapiCallback<GetDynamicPwdResult> sapiCallback, String str) {
        EnhancedService.getInstance(this.f10629a, "9.2.9.8").getDynamicPwd(sapiCallback, str);
    }

    public void getPopularPortraitsInfo(GetPopularPortraitsCallback getPopularPortraitsCallback, String str) {
        new PortraitService(this.f10629a, "9.2.9.8").getPopularPortraitsInfo(getPopularPortraitsCallback, str, PortraitCategory.NORMAL);
    }

    public void oauth(SapiCallback<OAuthResult> sapiCallback, String str, String str2) {
        this.f10630b.b(sapiCallback, str, str2);
    }

    public void web2NativeLogin(Web2NativeLoginCallback web2NativeLoginCallback, boolean z) {
        this.f10630b.a(web2NativeLoginCallback, z);
    }

    @Override // com.baidu.sapi2.service.interfaces.a
    public boolean webLogin(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("pp");
        SapiAccountManager.getInstance().getAccountService().getTplStoken(new a(context), str, arrayList);
        SapiAccount accountFromBduss = SapiContext.getInstance().getAccountFromBduss(str);
        if (accountFromBduss != null) {
            return a(context, accountFromBduss.bduss, accountFromBduss.ptoken);
        }
        return a(context, str, (String) null);
    }

    public void dynamicPwdLogin(DynamicPwdLoginCallback dynamicPwdLoginCallback, String str, String str2) {
        dynamicPwdLogin(dynamicPwdLoginCallback, str, str2, null);
    }

    public void getDynamicPwd(GetDynamicPwdCallback getDynamicPwdCallback, String str, String str2) {
        getDynamicPwd(getDynamicPwdCallback, str, str2, null);
    }

    public void dynamicPwdLogin(DynamicPwdLoginCallback dynamicPwdLoginCallback, String str, String str2, Map<String, String> map) {
        EnhancedService.getInstance(this.f10629a, "9.2.9.8").dynamicPwdLogin(dynamicPwdLoginCallback, str, str2, map);
    }

    public void getDynamicPwd(GetDynamicPwdCallback getDynamicPwdCallback, String str, String str2, Map<String, String> map) {
        EnhancedService.getInstance(this.f10629a, "9.2.9.8").getDynamicPwd(getDynamicPwdCallback, str, str2, map);
    }

    public void setPortrait(SetPortraitDTO setPortraitDTO, SetPortraitCallback setPortraitCallback) {
        new PortraitService(this.f10629a, "9.2.9.8").setPortrait(setPortraitDTO, setPortraitCallback);
    }

    public String a(SocialType socialType) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("type", socialType.getName()));
        arrayList.add(new PassNameValuePair("ostype", String.valueOf(socialType.getType())));
        return this.f10630b.m() + "?" + f() + "&" + SapiUtils.createRequestParams(arrayList);
    }

    @Override // com.baidu.sapi2.service.interfaces.a
    public boolean webLogin(Context context, String str, String str2) {
        return webLogin(context, str);
    }

    public String a() {
        return this.f10630b.e() + "?" + f();
    }

    public String a(String str) {
        String b2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("adapter", "3"));
        arrayList.add(new PassNameValuePair("wapsec", "center"));
        if (this.f10629a.accountCenterRealAutnen) {
            arrayList.add(new PassNameValuePair("realName", "1"));
        } else {
            arrayList.add(new PassNameValuePair("realName", "0"));
        }
        if (SapiWebView.ACCOUNT_CENTER_REAL_NAME.equals(str)) {
            b2 = this.f10630b.d();
        } else if (SapiWebView.ACCOUNT_CENTER_CHECK.equals(str)) {
            arrayList.add(new PassNameValuePair("hidebtmback", "1"));
            arrayList.add(new PassNameValuePair(SlideActiviy.EXTRA_PARAMS_SLIDE_PAGE, "1"));
            b2 = this.f10630b.c();
        } else {
            b2 = this.f10630b.b();
        }
        return b2 + "?" + a(false) + "&" + SapiUtils.createRequestParams(arrayList);
    }

    public String a(boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("clientfrom", "native"));
        arrayList.add(new PassNameValuePair("tpl", this.f10629a.tpl));
        arrayList.add(new PassNameValuePair("login_share_strategy", this.f10629a.loginShareStrategy().getStrValue()));
        arrayList.add(new PassNameValuePair("client", "android"));
        SapiConfiguration sapiConfiguration = this.f10629a;
        if (sapiConfiguration.showBottomBack) {
            arrayList.add(new PassNameValuePair("adapter", "8"));
        } else if (z) {
            arrayList.add(new PassNameValuePair("adapter", sapiConfiguration.customActionBarEnabled ? "3" : ""));
        }
        arrayList.add(new PassNameValuePair("t", String.valueOf(System.currentTimeMillis())));
        arrayList.add(new PassNameValuePair("act", this.f10629a.socialBindType.getName()));
        arrayList.add(new PassNameValuePair("hideExtraEntry", String.valueOf(this.f10629a.smsLoginConfig.flagHideExtraEntry.ordinal())));
        arrayList.add(new PassNameValuePair("loginLink", String.valueOf(this.f10629a.smsLoginConfig.flagShowLoginLink.ordinal())));
        arrayList.add(new PassNameValuePair("smsLoginLink", String.valueOf(this.f10629a.smsLoginConfig.flagShowSmsLoginLink.ordinal())));
        arrayList.add(new PassNameValuePair("lPFastRegLink", String.valueOf(this.f10629a.smsLoginConfig.flagShowFastRegLink.ordinal())));
        arrayList.add(new PassNameValuePair("lPlayout", String.valueOf(this.f10629a.configurableViewLayout.ordinal())));
        if (this.f10629a.uniteVerify) {
            arrayList.add(new PassNameValuePair("connect", "1"));
        }
        if (this.f10629a.language == Language.ENGLISH) {
            arrayList.add(new PassNameValuePair("lang", "en"));
        }
        arrayList.add(new PassNameValuePair("suppcheck", "1"));
        if (this.f10629a.supportFaceLogin) {
            arrayList.add(new PassNameValuePair("scanface", "1"));
        }
        if (this.f10629a.disableVoiceVerify) {
            arrayList.add(new PassNameValuePair("disable_voice_vcode", "1"));
        }
        return SapiUtils.createRequestParams(arrayList);
    }

    public boolean a(SapiCallBack<SapiAccountResponse> sapiCallBack, String str, String str2) {
        return this.f10630b.a(sapiCallBack, str, str2, false);
    }

    public boolean a(SapiAccount sapiAccount, List<String> list) {
        return this.f10630b.a(sapiAccount, list);
    }

    public Map<String, String> a(GetTplStokenCallback getTplStokenCallback, String str, List<String> list, boolean z) {
        return this.f10630b.a(getTplStokenCallback, str, list, z);
    }

    private boolean a(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                ArrayList arrayList = new ArrayList();
                for (String str3 : SapiUtils.getAuthorizedDomains()) {
                    if (!str.equals(SapiUtils.getCookie(SapiUtils.COOKIE_URL_PREFIX + str3, HttpRequest.BDUSS))) {
                        arrayList.add(new PassNameValuePair(SapiUtils.COOKIE_URL_PREFIX + str3, SapiUtils.buildBDUSSCookie(str3, str)));
                    }
                }
                if (!TextUtils.isEmpty(str2)) {
                    for (String str4 : SapiUtils.getAuthorizedDomainsForPtoken()) {
                        if (!str2.equals(SapiUtils.getCookie("https://" + str4, "PTOKEN"))) {
                            arrayList.add(new PassNameValuePair("https://" + str4, SapiUtils.buildPtokenCookie(str4, str2)));
                        }
                    }
                }
                SapiUtils.syncCookies(context, arrayList);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                ArrayList arrayList = new ArrayList();
                if (!TextUtils.isEmpty(str)) {
                    for (String str2 : SapiUtils.getAuthorizedDomainsForPtoken()) {
                        if (!str.equals(SapiUtils.getCookie("https://" + str2, "STOKEN"))) {
                            arrayList.add(new PassNameValuePair("https://" + str2, SapiUtils.buildStokenCookie(str2, str)));
                        }
                    }
                }
                SapiUtils.syncCookies(context, arrayList);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public void a(OneKeyLoginCallback oneKeyLoginCallback, String str, String str2, com.baidu.sapi2.callback.a.c cVar) {
        this.f10630b.a(oneKeyLoginCallback, str, str2, cVar);
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
        sapiAccount.app = TextUtils.isEmpty(sapiAccountResponse.app) ? SapiUtils.getAppName(this.f10629a.context) : sapiAccountResponse.app;
        sapiAccount.extra = sapiAccountResponse.extra;
        if (SocialType.UNKNOWN != sapiAccountResponse.socialType) {
            SapiContext.getInstance().put(SapiContext.KEY_PRE_LOGIN_TYPE, sapiAccountResponse.socialType.getName());
            sapiAccount.addSocialInfo(sapiAccountResponse.socialType, sapiAccountResponse.socialPortraitUrl);
            sapiAccount.putExtra("account_type", Integer.valueOf(sapiAccountResponse.accountType.getType()));
        }
        sapiAccount.putExtra("tpl", this.f10629a.tpl);
        if (!sapiAccountResponse.tplStokenMap.isEmpty()) {
            sapiAccount.addDispersionCertification(sapiAccountResponse.tplStokenMap);
        }
        SapiContext.getInstance().setAccountActionType(sapiAccountResponse.actionType);
        sapiAccount.addIsGuestAccount(sapiAccountResponse.isGuestAccount);
        if (!TextUtils.isEmpty(sapiAccountResponse.livingUname)) {
            new FaceLoginService().syncFaceLoginUID(this.f10629a.context, sapiAccountResponse.livingUname);
        }
        return sapiAccount;
    }

    private void a(OneKeyLoginCallback oneKeyLoginCallback, AccountType accountType) {
        OneKeyLoginResult oneKeyLoginResult = new OneKeyLoginResult();
        oneKeyLoginResult.setResultCode(0);
        oneKeyLoginCallback.onSuccess(oneKeyLoginResult);
    }
}
