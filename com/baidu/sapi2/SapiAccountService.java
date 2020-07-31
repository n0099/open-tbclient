package com.baidu.sapi2;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.callback.DynamicPwdLoginCallback;
import com.baidu.sapi2.callback.FillUsernameCallback;
import com.baidu.sapi2.callback.GetContactsCallback;
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
import com.baidu.sapi2.dto.GetContactDTO;
import com.baidu.sapi2.dto.GetHistoryPortraitsDTO;
import com.baidu.sapi2.dto.GetOpenBdussDTO;
import com.baidu.sapi2.dto.GetQrCodeImageDTO;
import com.baidu.sapi2.dto.IqiyiLoginDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.QrLoginStstusCheckDTO;
import com.baidu.sapi2.dto.SendSmsDTO;
import com.baidu.sapi2.dto.SetPopularPortraitDTO;
import com.baidu.sapi2.dto.SetPortraitDTO;
import com.baidu.sapi2.result.CheckUserFaceIdResult;
import com.baidu.sapi2.result.DynamicPwdLoginResult;
import com.baidu.sapi2.result.FaceLoginStatusResult;
import com.baidu.sapi2.result.GetCaptchaResult;
import com.baidu.sapi2.result.GetDynamicPwdResult;
import com.baidu.sapi2.result.GetQrCodeImageResult;
import com.baidu.sapi2.result.OAuthResult;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.result.QrAppLoginResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.share.SapiShareClient;
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
import com.tencent.open.SocialOperation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
/* loaded from: classes19.dex */
public final class SapiAccountService implements com.baidu.sapi2.service.interfaces.a {
    public static final String BUSINESS_FROM_ONE_KEY_LOGIN = "business_from_one_key_login";
    private static final String a = "SapiAccountService";
    private static final String b = "native";
    private SapiConfiguration c = SapiAccountManager.getInstance().getSapiConfiguration();
    private L d = new L();

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(BindWidgetAction bindWidgetAction) {
        if (bindWidgetAction != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new PassNameValuePair("adapter", "3"));
            return this.d.a(bindWidgetAction) + "?" + g() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
        }
        throw new IllegalArgumentException("BindWidgetAction can't be null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("client", "android"));
        arrayList.add(new PassNameValuePair("clientfrom", b));
        arrayList.add(new PassNameValuePair("adapter", "3"));
        arrayList.add(new PassNameValuePair("banner", "1"));
        arrayList.add(new PassNameValuePair("t", String.valueOf(System.currentTimeMillis())));
        return this.d.q() + "?" + a(false) + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() {
        return this.d.k() + "?" + a(true);
    }

    public void cancelRequest() {
        this.d.b();
    }

    public void checkFaceLoginStatus(SapiCallback<FaceLoginStatusResult> sapiCallback, String str) {
        this.d.a(sapiCallback, str);
    }

    public void checkOneKeyLoginIsAvailable(OneKeyLoginCallback oneKeyLoginCallback, String str) {
        if (oneKeyLoginCallback == null) {
            Log.d(a, "OneKeyLoginCallback is null, because this is an init process");
        } else if (TextUtils.isEmpty(str)) {
            Log.d(a, "encryptPhoneNum is null or empty, unkown error occured");
            new com.baidu.sapi2.outsdk.c().b(oneKeyLoginCallback, -100, null);
        } else {
            this.d.a(oneKeyLoginCallback, str);
        }
    }

    public void checkUserFaceId(SapiCallback<CheckUserFaceIdResult> sapiCallback, String str) {
        this.d.a(sapiCallback, str, (Map<String, String>) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d() {
        return this.d.r() + "?" + g();
    }

    @Deprecated
    public boolean dynamicPwdLogin(SapiCallBack<SapiAccountResponse> sapiCallBack, String str, String str2) {
        return this.d.a(sapiCallBack, str, str2, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String e() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("adapter", "3"));
        arrayList.add(new PassNameValuePair("banner", "1"));
        arrayList.add(new PassNameValuePair("t", String.valueOf(System.currentTimeMillis())));
        return this.d.s() + "?" + a(false) + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
    }

    public void extendSysWebViewMethodCheck(SapiCallback<SapiResult> sapiCallback, String str, String str2) {
        this.d.a(sapiCallback, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String f() {
        ArrayList arrayList;
        SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        String str = sapiConfiguration.environment.getWap() + "/wp/";
        new ArrayList().add(new PassNameValuePair("appid", sapiConfiguration.appId));
        if (TextUtils.isEmpty(sapiConfiguration.clientId)) {
            sapiConfiguration.clientId = SapiUtils.getClientId(sapiConfiguration.context);
        }
        return str + "?" + g() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
    }

    public void faceLoginSwitch(SapiCallback<SapiResult> sapiCallback, String str, boolean z, String str2) {
        this.d.a(sapiCallback, str, z, str2);
    }

    public void fillUsername(FillUsernameCallback fillUsernameCallback, String str, String str2) {
        this.d.a(fillUsernameCallback, str, str2);
    }

    String g() {
        return a(true);
    }

    public void generateSsoHash(SsoHashCallback ssoHashCallback, String str, String str2) {
        this.d.a(ssoHashCallback, str, str2);
    }

    public int getBdussState() {
        return new OpenBdussService(this.c, SapiAccountManager.VERSION_NAME).getBdussState();
    }

    public void getCaptcha(SapiCallback<GetCaptchaResult> sapiCallback) {
        EnhancedService.getInstance(this.c, SapiAccountManager.VERSION_NAME).getCaptcha(sapiCallback);
    }

    public String getCaptchaKey() {
        return EnhancedService.getInstance(this.c, SapiAccountManager.VERSION_NAME).getCaptchaKey();
    }

    public void getContacts(GetContactsCallback getContactsCallback, GetContactDTO getContactDTO) {
        GetContactsService.getInstance(this.c, SapiAccountManager.VERSION_NAME).getContacts(getContactsCallback, getContactDTO);
    }

    @Deprecated
    public boolean getDynamicPwd(SapiCallBack<SapiResponse> sapiCallBack, String str) {
        return this.d.a(sapiCallBack, str);
    }

    public void getHistoryPortraits(GetHistoryPortraitsCallback getHistoryPortraitsCallback, GetHistoryPortraitsDTO getHistoryPortraitsDTO) {
        new PortraitService(this.c, SapiAccountManager.VERSION_NAME).getHistoryPortraits(getHistoryPortraitsCallback, getHistoryPortraitsDTO);
    }

    public String getIqiyiAccessToken() {
        return SapiContext.getInstance().getIqiyiAccesstoken();
    }

    public void getOpenBduss(GetOpenBdussDTO getOpenBdussDTO, GetOpenBdussCallback getOpenBdussCallback) {
        new OpenBdussService(this.c, SapiAccountManager.VERSION_NAME).getOpenBduss(getOpenBdussDTO, getOpenBdussCallback);
    }

    public void getPopularPortraitsInfo(GetPopularPortraitsCallback getPopularPortraitsCallback, String str) {
        new PortraitService(this.c, SapiAccountManager.VERSION_NAME).getPopularPortraitsInfo(getPopularPortraitsCallback, str);
    }

    public void getQrCodeImage(SapiCallback<GetQrCodeImageResult> sapiCallback, GetQrCodeImageDTO getQrCodeImageDTO) {
        QrCodeService.getInstance(this.c, SapiAccountManager.VERSION_NAME).getQrCodeImage(sapiCallback, getQrCodeImageDTO);
    }

    public Map<String, String> getTplStoken(GetTplStokenCallback getTplStokenCallback, String str, List<String> list) {
        return a(getTplStokenCallback, str, list, true);
    }

    public void getUserInfo(GetUserInfoCallback getUserInfoCallback, String str) {
        this.d.a(getUserInfoCallback, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String h() {
        return this.d.o() + "?" + g();
    }

    public void handleOneKeyLoginResult(OneKeyLoginCallback oneKeyLoginCallback, String str) {
        SapiAccountResponse b2 = com.baidu.sapi2.utils.g.b("business_from_one_key_login", str);
        if (b2 != null) {
            SapiShareClient.getInstance().validate(a(b2));
            a(oneKeyLoginCallback, b2.accountType);
            return;
        }
        new com.baidu.sapi2.outsdk.c().a(oneKeyLoginCallback, -103, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String i() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("adapter", "3"));
        return this.d.p() + "?" + g() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
    }

    public void iqiyiSSOLogin(IqiyiLoginCallback iqiyiLoginCallback, IqiyiLoginDTO iqiyiLoginDTO) {
        this.d.a(iqiyiLoginCallback, iqiyiLoginDTO);
    }

    public boolean isStokenExist(String str, List<String> list) {
        return this.d.a(str, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String j() {
        return this.d.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String k() {
        return this.d.h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String l() {
        return this.d.i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String m() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("adapter", "3"));
        arrayList.add(new PassNameValuePair("banner", "1"));
        return this.d.t() + "?" + a(false) + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String n() {
        return this.d.u() + "?" + g();
    }

    @Deprecated
    public void oauth(SapiCallback<OAuthResult> sapiCallback, String str) {
        this.d.b(sapiCallback, str, null);
    }

    public void preGetPhoneInfo() {
        new com.baidu.sapi2.outsdk.c().a(this.c, "product");
    }

    public void qrAppLogin(SapiCallback<QrAppLoginResult> sapiCallback, String str, String str2) {
        QrCodeService.getInstance(this.c, SapiAccountManager.VERSION_NAME).qrAppLogin(sapiCallback, str, str2);
    }

    public void qrJoinLoginStatusCheck(QrLoginStatusCheckCallback qrLoginStatusCheckCallback, QrLoginStstusCheckDTO qrLoginStstusCheckDTO) {
        qrLoginStstusCheckDTO.isJoinCodeLogin = true;
        QrCodeService.getInstance(this.c, SapiAccountManager.VERSION_NAME).qrLoginStatusCheck(qrLoginStatusCheckCallback, qrLoginStstusCheckDTO, true);
    }

    public void qrLoginStatusCheck(QrLoginStatusCheckCallback qrLoginStatusCheckCallback, QrLoginStstusCheckDTO qrLoginStstusCheckDTO) {
        QrCodeService.getInstance(this.c, SapiAccountManager.VERSION_NAME).qrLoginStatusCheck(qrLoginStatusCheckCallback, qrLoginStstusCheckDTO, true);
    }

    public void refreshOpenidToUid() {
        if (this.c.needOpenid) {
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
                    oauth(new N(this, urlParamsToMap, sapiAccount2), sapiAccount2.bduss);
                }
            }
        }
    }

    public void relaseContactsSource() {
        GetContactsService.getInstance(this.c, SapiAccountManager.VERSION_NAME).relaseContactsSource();
    }

    public void sendContactsSms(SendSmsDTO sendSmsDTO) {
        GetContactsService.getInstance(this.c, SapiAccountManager.VERSION_NAME).sendSMS(sendSmsDTO);
    }

    public void setIqiyiAccessToken(String str) {
        SapiContext.getInstance().setIqiyiAccesstoken(str);
        if (SapiShareClient.isInShareOtherInfoWhiteList()) {
            this.d.c(str);
            SapiShareClient.getInstance().validateOtherInfo();
        }
    }

    public void setPopularPortrait(SetPopularPortraitCallback setPopularPortraitCallback, SetPopularPortraitDTO setPopularPortraitDTO) {
        new PortraitService(this.c, SapiAccountManager.VERSION_NAME).setPopularPortrait(setPopularPortraitCallback, setPopularPortraitDTO);
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
        QrCodeService.getInstance(this.c, SapiAccountManager.VERSION_NAME).stopLoginStatusCheck();
    }

    public void web2NativeLogin(Web2NativeLoginCallback web2NativeLoginCallback) {
        this.d.a(web2NativeLoginCallback, false);
    }

    public void checkUserFaceId(SapiCallback<CheckUserFaceIdResult> sapiCallback, String str, Map<String, String> map) {
        this.d.a(sapiCallback, str, map);
    }

    @Deprecated
    public void dynamicPwdLogin(SapiCallback<DynamicPwdLoginResult> sapiCallback, String str, String str2) {
        EnhancedService.getInstance(this.c, SapiAccountManager.VERSION_NAME).dynamicPwdLogin(sapiCallback, str, str2, (Map) null);
    }

    @Deprecated
    public void getDynamicPwd(SapiCallback<GetDynamicPwdResult> sapiCallback, String str) {
        EnhancedService.getInstance(this.c, SapiAccountManager.VERSION_NAME).getDynamicPwd(sapiCallback, str);
    }

    public void oauth(SapiCallback<OAuthResult> sapiCallback, String str, String str2) {
        this.d.b(sapiCallback, str, str2);
    }

    public void web2NativeLogin(Web2NativeLoginCallback web2NativeLoginCallback, boolean z) {
        this.d.a(web2NativeLoginCallback, z);
    }

    public boolean webLogin(Context context) {
        SapiAccount currentAccount;
        if (context == null || (currentAccount = SapiContext.getInstance().getCurrentAccount()) == null) {
            return false;
        }
        return SapiUtils.webLogin(context, currentAccount.bduss, currentAccount.ptoken);
    }

    @Override // com.baidu.sapi2.service.interfaces.a
    public boolean webLogin(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("pp");
            SapiAccountManager.getInstance().getAccountService().getTplStoken(new M(this, context), str, arrayList);
            SapiAccount accountFromBduss = SapiContext.getInstance().getAccountFromBduss(str);
            if (accountFromBduss != null) {
                return a(context, accountFromBduss.bduss, accountFromBduss.ptoken);
            }
            return a(context, str, (String) null);
        }
        return false;
    }

    public void dynamicPwdLogin(DynamicPwdLoginCallback dynamicPwdLoginCallback, String str, String str2) {
        dynamicPwdLogin(dynamicPwdLoginCallback, str, str2, null);
    }

    public void getDynamicPwd(GetDynamicPwdCallback getDynamicPwdCallback, String str, String str2) {
        getDynamicPwd(getDynamicPwdCallback, str, str2, null);
    }

    public void dynamicPwdLogin(DynamicPwdLoginCallback dynamicPwdLoginCallback, String str, String str2, Map<String, String> map) {
        EnhancedService.getInstance(this.c, SapiAccountManager.VERSION_NAME).dynamicPwdLogin(dynamicPwdLoginCallback, str, str2, map);
    }

    public void getDynamicPwd(GetDynamicPwdCallback getDynamicPwdCallback, String str, String str2, Map<String, String> map) {
        EnhancedService.getInstance(this.c, SapiAccountManager.VERSION_NAME).getDynamicPwd(getDynamicPwdCallback, str, str2, map);
    }

    public void setPortrait(SetPortraitDTO setPortraitDTO, SetPortraitCallback setPortraitCallback) {
        new PortraitService(this.c, SapiAccountManager.VERSION_NAME).setPortrait(setPortraitDTO, setPortraitCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(SocialType socialType) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("type", socialType.getName()));
        return this.d.m() + "?" + g() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
    }

    @Override // com.baidu.sapi2.service.interfaces.a
    public boolean webLogin(Context context, String str, String str2) {
        return webLogin(context, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        return this.d.f() + "?" + g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(String str) {
        String c;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("adapter", "3"));
        arrayList.add(new PassNameValuePair("wapsec", "center"));
        if (this.c.accountCenterRealAutnen) {
            arrayList.add(new PassNameValuePair("realName", "1"));
        } else {
            arrayList.add(new PassNameValuePair("realName", "0"));
        }
        if (SapiWebView.ACCOUNT_CENTER_REAL_NAME.equals(str)) {
            c = this.d.e();
        } else if (SapiWebView.ACCOUNT_CENTER_CHECK.equals(str)) {
            arrayList.add(new PassNameValuePair("hidebtmback", "1"));
            c = this.d.d();
        } else {
            c = this.d.c();
        }
        return c + "?" + a(false) + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
    }

    String a(boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("clientfrom", b));
        arrayList.add(new PassNameValuePair("tpl", this.c.tpl));
        arrayList.add(new PassNameValuePair("login_share_strategy", this.c.loginShareStrategy().getStrValue()));
        arrayList.add(new PassNameValuePair("client", "android"));
        if (z) {
            arrayList.add(new PassNameValuePair("adapter", this.c.customActionBarEnabled ? "3" : ""));
        }
        arrayList.add(new PassNameValuePair("t", String.valueOf(System.currentTimeMillis())));
        arrayList.add(new PassNameValuePair("act", this.c.socialBindType.getName()));
        arrayList.add(new PassNameValuePair("hideExtraEntry", String.valueOf(this.c.smsLoginConfig.flagHideExtraEntry.ordinal())));
        arrayList.add(new PassNameValuePair("loginLink", String.valueOf(this.c.smsLoginConfig.flagShowLoginLink.ordinal())));
        arrayList.add(new PassNameValuePair("smsLoginLink", String.valueOf(this.c.smsLoginConfig.flagShowSmsLoginLink.ordinal())));
        arrayList.add(new PassNameValuePair("lPFastRegLink", String.valueOf(this.c.smsLoginConfig.flagShowFastRegLink.ordinal())));
        arrayList.add(new PassNameValuePair("lPlayout", String.valueOf(this.c.configurableViewLayout.ordinal())));
        if (this.c.uniteVerify) {
            arrayList.add(new PassNameValuePair("connect", "1"));
        }
        if (this.c.language == Language.ENGLISH) {
            arrayList.add(new PassNameValuePair("lang", com.baidu.fsg.base.statistics.h.a));
        }
        arrayList.add(new PassNameValuePair("suppcheck", "1"));
        if (this.c.supportFaceLogin) {
            arrayList.add(new PassNameValuePair("scanface", "1"));
        }
        if (this.c.disableVoiceVerify) {
            arrayList.add(new PassNameValuePair("disable_voice_vcode", "1"));
        }
        return SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(SocialType socialType, String str, String str2) {
        return a(socialType, str, str2, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(SocialType socialType, String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("display", b));
        arrayList.add(new PassNameValuePair("type", socialType.getType() + ""));
        arrayList.add(new PassNameValuePair("act", this.c.socialBindType.getName()));
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(new PassNameValuePair("appid", str3));
        }
        arrayList.add(new PassNameValuePair("access_token", str));
        arrayList.add(new PassNameValuePair("osuid", str2));
        return this.d.j() + "?" + g() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("type", SocialType.QQ_SSO.getType() + ""));
        arrayList.add(new PassNameValuePair("appid", this.c.qqAppID));
        arrayList.add(new PassNameValuePair("access_token", str));
        arrayList.add(new PassNameValuePair("osuid", str2));
        arrayList.add(new PassNameValuePair(SocialOperation.GAME_UNION_ID, str3));
        return this.d.j() + "?" + g() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(String str, String str2, boolean z) {
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(new PassNameValuePair("type", SocialType.WEIXIN.getType() + ""));
        arrayList.add(new PassNameValuePair("mkey", str2));
        arrayList.add(new PassNameValuePair("code", str));
        if (SapiAccountManager.getInstance().getConfignation().supportGuestAccountLogin) {
            arrayList.add(new PassNameValuePair("supportGuestAccount", "1"));
        }
        if (z) {
            arrayList.add(new PassNameValuePair("wapsec", "center"));
            arrayList.add(new PassNameValuePair("adapter", "3"));
        }
        arrayList.add(new PassNameValuePair("appid", this.c.wxAppID));
        arrayList.add(new PassNameValuePair("display", b));
        return this.d.j() + "?" + g() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
    }

    boolean a(SapiCallBack<SapiAccountResponse> sapiCallBack, String str, String str2) {
        return this.d.a(sapiCallBack, str, str2, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(SapiAccount sapiAccount, List<String> list) {
        return this.d.a(sapiAccount, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, String> a(GetTplStokenCallback getTplStokenCallback, String str, List<String> list, boolean z) {
        return this.d.a(getTplStokenCallback, str, list, z);
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
        this.d.a(oneKeyLoginCallback, str, str2, bVar);
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
        sapiAccount.app = TextUtils.isEmpty(sapiAccountResponse.app) ? SapiUtils.getAppName(this.c.context) : sapiAccountResponse.app;
        sapiAccount.extra = sapiAccountResponse.extra;
        if (SocialType.UNKNOWN != sapiAccountResponse.socialType) {
            SapiContext.getInstance().put(SapiContext.KEY_PRE_LOGIN_TYPE, sapiAccountResponse.socialType.getName());
            sapiAccount.addSocialInfo(sapiAccountResponse.socialType, sapiAccountResponse.socialPortraitUrl);
            sapiAccount.putExtra("account_type", Integer.valueOf(sapiAccountResponse.accountType.getType()));
        }
        sapiAccount.putExtra("tpl", this.c.tpl);
        if (!sapiAccountResponse.tplStokenMap.isEmpty()) {
            sapiAccount.addDispersionCertification(sapiAccountResponse.tplStokenMap);
        }
        SapiContext.getInstance().setAccountActionType(sapiAccountResponse.actionType);
        sapiAccount.addIsGuestAccount(sapiAccountResponse.isGuestAccount);
        if (!TextUtils.isEmpty(sapiAccountResponse.livingUname)) {
            new FaceLoginService().syncFaceLoginUID(this.c.context, sapiAccountResponse.livingUname);
        }
        return sapiAccount;
    }

    private void a(OneKeyLoginCallback oneKeyLoginCallback, AccountType accountType) {
        SapiUtils.reportGid(10002);
        OneKeyLoginResult oneKeyLoginResult = new OneKeyLoginResult();
        oneKeyLoginResult.setResultCode(0);
        oneKeyLoginCallback.onSuccess(oneKeyLoginResult);
    }
}
