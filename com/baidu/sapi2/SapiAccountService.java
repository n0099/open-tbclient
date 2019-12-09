package com.baidu.sapi2;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.mobstat.Config;
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
import com.baidu.sapi2.result.CheckUserFaceIdResult;
import com.baidu.sapi2.result.DynamicPwdLoginResult;
import com.baidu.sapi2.result.FaceLoginStatusResult;
import com.baidu.sapi2.result.GetCaptchaResult;
import com.baidu.sapi2.result.GetDynamicPwdResult;
import com.baidu.sapi2.result.GetQrCodeImageResult;
import com.baidu.sapi2.result.OAuthResult;
import com.baidu.sapi2.result.QrAppLoginResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.share.SapiShareClient;
import com.baidu.sapi2.shell.callback.SapiCallBack;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SapiResponse;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.sapi2.utils.enums.Language;
import com.baidu.sapi2.utils.enums.SocialType;
import com.tencent.open.SocialOperation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public final class SapiAccountService implements com.baidu.sapi2.service.interfaces.a {
    private static final String a = "native";
    private SapiConfiguration b = SapiAccountManager.getInstance().getSapiConfiguration();
    private G c = new G();

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("client", "android"));
        arrayList.add(new PassNameValuePair("clientfrom", a));
        arrayList.add(new PassNameValuePair("adapter", "3"));
        arrayList.add(new PassNameValuePair("banner", "1"));
        arrayList.add(new PassNameValuePair("t", String.valueOf(System.currentTimeMillis())));
        return this.c.p() + "?" + a(false) + "&" + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() {
        return this.c.m() + "?" + a(true);
    }

    public void cancelRequest() {
        this.c.a();
    }

    public void checkFaceLoginStatus(SapiCallback<FaceLoginStatusResult> sapiCallback, String str) {
        this.c.a(sapiCallback, str);
    }

    public void checkPush(com.baidu.sapi2.callback.a.a aVar) {
        this.c.a(aVar);
    }

    public void checkUserFaceId(SapiCallback<CheckUserFaceIdResult> sapiCallback, String str) {
        this.c.a(sapiCallback, str, (Map<String, String>) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d() {
        return this.c.q() + "?" + g();
    }

    @Deprecated
    public boolean dynamicPwdLogin(SapiCallBack<SapiAccountResponse> sapiCallBack, String str, String str2) {
        return this.c.a(sapiCallBack, str, str2, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String e() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("adapter", "3"));
        arrayList.add(new PassNameValuePair("banner", "1"));
        arrayList.add(new PassNameValuePair("t", String.valueOf(System.currentTimeMillis())));
        return this.c.r() + "?" + a(false) + "&" + SapiUtils.createRequestParams(arrayList);
    }

    public void extendSysWebViewMethodCheck(SapiCallback<SapiResult> sapiCallback, String str, String str2) {
        this.c.a(sapiCallback, str, str2);
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
        return str + "?" + g() + "&" + SapiUtils.createRequestParams(arrayList);
    }

    public void faceLoginSwitch(SapiCallback<SapiResult> sapiCallback, String str, boolean z, String str2) {
        this.c.a(sapiCallback, str, z, str2);
    }

    public void fillUsername(FillUsernameCallback fillUsernameCallback, String str, String str2) {
        this.c.a(fillUsernameCallback, str, str2);
    }

    String g() {
        return a(true);
    }

    public void generateSsoHash(SsoHashCallback ssoHashCallback, String str, String str2) {
        this.c.a(ssoHashCallback, str, str2);
    }

    public void getCaptcha(SapiCallback<GetCaptchaResult> sapiCallback) {
        EnhancedService.getInstance(this.b, SapiAccountManager.VERSION_NAME).getCaptcha(sapiCallback);
    }

    public String getCaptchaKey() {
        return EnhancedService.getInstance(this.b, SapiAccountManager.VERSION_NAME).getCaptchaKey();
    }

    public void getContacts(GetContactsCallback getContactsCallback, GetContactDTO getContactDTO) {
        GetContactsService.getInstance(this.b, SapiAccountManager.VERSION_NAME).getContacts(getContactsCallback, getContactDTO);
    }

    @Deprecated
    public boolean getDynamicPwd(SapiCallBack<SapiResponse> sapiCallBack, String str) {
        return this.c.a(sapiCallBack, str);
    }

    public void getHistoryPortraits(GetHistoryPortraitsCallback getHistoryPortraitsCallback, GetHistoryPortraitsDTO getHistoryPortraitsDTO) {
        new PortraitService(this.b, SapiAccountManager.VERSION_NAME).getHistoryPortraits(getHistoryPortraitsCallback, getHistoryPortraitsDTO);
    }

    public String getIqiyiAccessToken() {
        return SapiContext.getInstance(this.b.context).getIqiyiAccesstoken();
    }

    public void getOpenBduss(GetOpenBdussDTO getOpenBdussDTO, GetOpenBdussCallback getOpenBdussCallback) {
        new OpenBdussService(this.b, SapiAccountManager.VERSION_NAME).getOpenBduss(getOpenBdussDTO, getOpenBdussCallback);
    }

    public void getPopularPortraitsInfo(GetPopularPortraitsCallback getPopularPortraitsCallback, String str) {
        new PortraitService(this.b, SapiAccountManager.VERSION_NAME).getPopularPortraitsInfo(getPopularPortraitsCallback, str);
    }

    public void getQrCodeImage(SapiCallback<GetQrCodeImageResult> sapiCallback, GetQrCodeImageDTO getQrCodeImageDTO) {
        QrCodeService.getInstance(this.b, SapiAccountManager.VERSION_NAME).getQrCodeImage(sapiCallback, getQrCodeImageDTO);
    }

    public Map<String, String> getTplStoken(GetTplStokenCallback getTplStokenCallback, String str, List<String> list) {
        return a(getTplStokenCallback, str, list, true);
    }

    public void getUserInfo(GetUserInfoCallback getUserInfoCallback, String str) {
        this.c.a(getUserInfoCallback, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String h() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("adapter", "3"));
        return this.c.o() + "?" + g() + "&" + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String i() {
        return this.c.f();
    }

    public void iqiyiSSOLogin(IqiyiLoginCallback iqiyiLoginCallback, IqiyiLoginDTO iqiyiLoginDTO) {
        this.c.a(iqiyiLoginCallback, iqiyiLoginDTO);
    }

    public boolean isStokenExist(String str, List<String> list) {
        return this.c.a(str, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String j() {
        return this.c.k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String k() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair(TableDefine.PaSubscribeColumns.COLUMN_TPL, SapiAccountManager.getInstance().getSapiConfiguration().tpl));
        arrayList.add(new PassNameValuePair("showtype", "phone"));
        arrayList.add(new PassNameValuePair(Config.DEVICE_PART, "wap"));
        arrayList.add(new PassNameValuePair("adapter", "apps"));
        return this.c.l() + g() + "&" + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String l() {
        return this.c.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String m() {
        return this.c.h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String n() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("adapter", "3"));
        arrayList.add(new PassNameValuePair("banner", "1"));
        return this.c.s() + "?" + a(false) + "&" + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String o() {
        return this.c.t() + "?" + g();
    }

    @Deprecated
    public void oauth(SapiCallback<OAuthResult> sapiCallback, String str) {
        this.c.b(sapiCallback, str, null);
    }

    public void qrAppLogin(SapiCallback<QrAppLoginResult> sapiCallback, String str, String str2) {
        QrCodeService.getInstance(this.b, SapiAccountManager.VERSION_NAME).qrAppLogin(sapiCallback, str, str2);
    }

    public void qrJoinLoginStatusCheck(QrLoginStatusCheckCallback qrLoginStatusCheckCallback, QrLoginStstusCheckDTO qrLoginStstusCheckDTO) {
        qrLoginStstusCheckDTO.isJoinCodeLogin = true;
        QrCodeService.getInstance(this.b, SapiAccountManager.VERSION_NAME).qrLoginStatusCheck(qrLoginStatusCheckCallback, qrLoginStstusCheckDTO, true);
    }

    public void qrLoginStatusCheck(QrLoginStatusCheckCallback qrLoginStatusCheckCallback, QrLoginStstusCheckDTO qrLoginStstusCheckDTO) {
        QrCodeService.getInstance(this.b, SapiAccountManager.VERSION_NAME).qrLoginStatusCheck(qrLoginStatusCheckCallback, qrLoginStstusCheckDTO, true);
    }

    public void refreshOpenidToUid() {
        if (this.b.needOpenid) {
            List<SapiAccount> loginAccounts = SapiAccountManager.getInstance().getLoginAccounts();
            loginAccounts.addAll(SapiAccountManager.getInstance().getShareAccounts());
            if (loginAccounts.size() == 0) {
                SapiContext.getInstance(this.b.context).put(SapiContext.KEY_OPENID_UID_LIST, "");
                return;
            }
            Map<String, String> urlParamsToMap = SapiUtils.urlParamsToMap(SapiContext.getInstance(this.b.context).getString(SapiContext.KEY_OPENID_UID_LIST));
            Collection<String> values = urlParamsToMap.values();
            for (SapiAccount sapiAccount : loginAccounts) {
                if (!values.contains(sapiAccount.uid)) {
                    values.remove(sapiAccount.uid);
                }
            }
            SapiContext.getInstance(this.b.context).put(SapiContext.KEY_OPENID_UID_LIST, SapiUtils.mapToUrlParams(urlParamsToMap, false));
            for (SapiAccount sapiAccount2 : loginAccounts) {
                if (!urlParamsToMap.containsValue(sapiAccount2.uid)) {
                    oauth(new I(this, urlParamsToMap, sapiAccount2), sapiAccount2.bduss);
                }
            }
        }
    }

    public void relaseContactsSource() {
        GetContactsService.getInstance(this.b, SapiAccountManager.VERSION_NAME).relaseContactsSource();
    }

    public void sendContactsSms(SendSmsDTO sendSmsDTO) {
        GetContactsService.getInstance(this.b, SapiAccountManager.VERSION_NAME).sendSMS(sendSmsDTO);
    }

    public void setIqiyiAccessToken(String str) {
        SapiContext.getInstance(this.b.context).setIqiyiAccesstoken(str);
        if (SapiShareClient.isInShareOtherInfoWhiteList()) {
            this.c.c(str);
            SapiShareClient.getInstance().validateOtherInfo();
        }
    }

    public void setPopularPortrait(SetPopularPortraitCallback setPopularPortraitCallback, SetPopularPortraitDTO setPopularPortraitDTO) {
        new PortraitService(this.b, SapiAccountManager.VERSION_NAME).setPopularPortrait(setPopularPortraitCallback, setPopularPortraitDTO);
    }

    public void setPortrait(SetPortraitCallback setPortraitCallback, String str, byte[] bArr, String str2) {
        new PortraitService(this.b, SapiAccountManager.VERSION_NAME).setPortrait(setPortraitCallback, str, bArr, str2);
    }

    public void stopQrLoginStatusCheck() {
        QrCodeService.getInstance(this.b, SapiAccountManager.VERSION_NAME).stopLoginStatusCheck();
    }

    public void web2NativeLogin(Web2NativeLoginCallback web2NativeLoginCallback) {
        this.c.a(web2NativeLoginCallback, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(BindWidgetAction bindWidgetAction) {
        if (bindWidgetAction != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new PassNameValuePair("adapter", "3"));
            return this.c.a(bindWidgetAction) + "?" + g() + "&" + SapiUtils.createRequestParams(arrayList);
        }
        throw new IllegalArgumentException("BindWidgetAction can't be null");
    }

    public void checkUserFaceId(SapiCallback<CheckUserFaceIdResult> sapiCallback, String str, Map<String, String> map) {
        this.c.a(sapiCallback, str, map);
    }

    @Deprecated
    public void dynamicPwdLogin(SapiCallback<DynamicPwdLoginResult> sapiCallback, String str, String str2) {
        EnhancedService.getInstance(this.b, SapiAccountManager.VERSION_NAME).dynamicPwdLogin(sapiCallback, str, str2, (Map) null);
    }

    @Deprecated
    public void getDynamicPwd(SapiCallback<GetDynamicPwdResult> sapiCallback, String str) {
        EnhancedService.getInstance(this.b, SapiAccountManager.VERSION_NAME).getDynamicPwd(sapiCallback, str);
    }

    public void oauth(SapiCallback<OAuthResult> sapiCallback, String str, String str2) {
        this.c.b(sapiCallback, str, str2);
    }

    public void web2NativeLogin(Web2NativeLoginCallback web2NativeLoginCallback, boolean z) {
        this.c.a(web2NativeLoginCallback, z);
    }

    public boolean webLogin(Context context) {
        SapiAccount currentAccount;
        if (context == null || (currentAccount = SapiContext.getInstance(context).getCurrentAccount()) == null) {
            return false;
        }
        return SapiUtils.webLogin(context, currentAccount.bduss, currentAccount.ptoken);
    }

    @Override // com.baidu.sapi2.service.interfaces.a
    public boolean webLogin(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("pp");
            SapiAccountManager.getInstance().getAccountService().getTplStoken(new H(this, context), str, arrayList);
            SapiAccount accountFromBduss = SapiContext.getInstance(context).getAccountFromBduss(str);
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
        EnhancedService.getInstance(this.b, SapiAccountManager.VERSION_NAME).dynamicPwdLogin(dynamicPwdLoginCallback, str, str2, map);
    }

    public void getDynamicPwd(GetDynamicPwdCallback getDynamicPwdCallback, String str, String str2, Map<String, String> map) {
        EnhancedService.getInstance(this.b, SapiAccountManager.VERSION_NAME).getDynamicPwd(getDynamicPwdCallback, str, str2, map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(SocialType socialType) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("type", socialType.getName()));
        return this.c.n() + "?" + g() + "&" + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b(SocialType socialType) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair(LogConfig.KEY_DISPLAY, a));
        arrayList.add(new PassNameValuePair("type", socialType.getType() + ""));
        arrayList.add(new PassNameValuePair("guidebind", "1"));
        arrayList.add(new PassNameValuePair("expSid", this.b.sidValue));
        return this.c.j() + "?" + g() + "&" + SapiUtils.createRequestParams(arrayList);
    }

    @Override // com.baidu.sapi2.service.interfaces.a
    public boolean webLogin(Context context, String str, String str2) {
        return webLogin(context, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        return this.c.e() + "?" + g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(String str) {
        String b;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("adapter", "3"));
        arrayList.add(new PassNameValuePair("wapsec", "center"));
        if (this.b.accountCenterRealAutnen) {
            arrayList.add(new PassNameValuePair("realName", "1"));
        } else {
            arrayList.add(new PassNameValuePair("realName", "0"));
        }
        if (SapiWebView.ACCOUNT_CENTER_REAL_NAME.equals(str)) {
            b = this.c.d();
        } else if (SapiWebView.ACCOUNT_CENTER_CHECK.equals(str)) {
            arrayList.add(new PassNameValuePair("hidebtmback", "1"));
            b = this.c.c();
        } else {
            b = this.c.b();
        }
        return b + "?" + a(false) + "&" + SapiUtils.createRequestParams(arrayList);
    }

    String a(boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("clientfrom", a));
        arrayList.add(new PassNameValuePair(TableDefine.PaSubscribeColumns.COLUMN_TPL, this.b.tpl));
        arrayList.add(new PassNameValuePair("login_share_strategy", this.b.loginShareStrategy().getStrValue()));
        arrayList.add(new PassNameValuePair("client", "android"));
        if (z) {
            arrayList.add(new PassNameValuePair("adapter", this.b.customActionBarEnabled ? "3" : ""));
        }
        arrayList.add(new PassNameValuePair("t", String.valueOf(System.currentTimeMillis())));
        arrayList.add(new PassNameValuePair("act", this.b.socialBindType.getName()));
        arrayList.add(new PassNameValuePair("hideExtraEntry", String.valueOf(this.b.smsLoginConfig.flagHideExtraEntry.ordinal())));
        arrayList.add(new PassNameValuePair("loginLink", String.valueOf(this.b.smsLoginConfig.flagShowLoginLink.ordinal())));
        arrayList.add(new PassNameValuePair("smsLoginLink", String.valueOf(this.b.smsLoginConfig.flagShowSmsLoginLink.ordinal())));
        arrayList.add(new PassNameValuePair("lPFastRegLink", String.valueOf(this.b.smsLoginConfig.flagShowFastRegLink.ordinal())));
        arrayList.add(new PassNameValuePair("lPlayout", String.valueOf(this.b.configurableViewLayout.ordinal())));
        if (this.b.uniteVerify) {
            arrayList.add(new PassNameValuePair("connect", "1"));
        }
        if (this.b.language == Language.ENGLISH) {
            arrayList.add(new PassNameValuePair("lang", "en"));
        }
        arrayList.add(new PassNameValuePair("suppcheck", "1"));
        if (this.b.supportFaceLogin) {
            arrayList.add(new PassNameValuePair("scanface", "1"));
        }
        if (this.b.disableVoiceVerify) {
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
        arrayList.add(new PassNameValuePair(LogConfig.KEY_DISPLAY, a));
        arrayList.add(new PassNameValuePair("type", socialType.getType() + ""));
        arrayList.add(new PassNameValuePair("act", this.b.socialBindType.getName()));
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(new PassNameValuePair("appid", str3));
        }
        arrayList.add(new PassNameValuePair("access_token", str));
        arrayList.add(new PassNameValuePair("osuid", str2));
        arrayList.add(new PassNameValuePair("expSid", this.b.sidValue));
        return this.c.i() + "?" + g() + "&" + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("type", SocialType.QQ_SSO.getType() + ""));
        arrayList.add(new PassNameValuePair("appid", this.b.qqAppID));
        arrayList.add(new PassNameValuePair("access_token", str));
        arrayList.add(new PassNameValuePair("osuid", str2));
        arrayList.add(new PassNameValuePair(SocialOperation.GAME_UNION_ID, str3));
        arrayList.add(new PassNameValuePair("expSid", this.b.sidValue));
        return this.c.i() + "?" + g() + "&" + SapiUtils.createRequestParams(arrayList);
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
        arrayList.add(new PassNameValuePair("appid", this.b.wxAppID));
        arrayList.add(new PassNameValuePair(LogConfig.KEY_DISPLAY, a));
        arrayList.add(new PassNameValuePair("expSid", this.b.sidValue));
        return this.c.i() + "?" + g() + "&" + SapiUtils.createRequestParams(arrayList);
    }

    boolean a(SapiCallBack<SapiAccountResponse> sapiCallBack, String str, String str2) {
        return this.c.a(sapiCallBack, str, str2, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(SapiAccount sapiAccount, List<String> list) {
        return this.c.a(sapiAccount, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, String> a(GetTplStokenCallback getTplStokenCallback, String str, List<String> list, boolean z) {
        return this.c.a(getTplStokenCallback, str, list, z);
    }

    private boolean a(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            ArrayList arrayList = new ArrayList();
            for (String str3 : SapiUtils.getAuthorizedDomains(context)) {
                if (!str.equals(SapiUtils.getCookie(SapiUtils.COOKIE_URL_PREFIX + str3, "BDUSS"))) {
                    arrayList.add(new PassNameValuePair(SapiUtils.COOKIE_URL_PREFIX + str3, SapiUtils.buildBDUSSCookie(str3, str)));
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                for (String str4 : SapiUtils.getAuthorizedDomainsForPtoken(context)) {
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
                for (String str2 : SapiUtils.getAuthorizedDomainsForPtoken(context)) {
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
}
