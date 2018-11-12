package com.baidu.sapi2;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.fsg.base.BaiduRimConstants;
import com.baidu.fsg.base.statistics.h;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.callback.DynamicPwdLoginCallback;
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
import com.baidu.sapi2.callback.QrLoginStatusCheckCallback;
import com.baidu.sapi2.callback.SSOConfirmCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.callback.SetPopularPortraitCallback;
import com.baidu.sapi2.callback.SetPortraitCallback;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.dto.GetHistoryPortraitsDTO;
import com.baidu.sapi2.dto.IqiyiLoginDTO;
import com.baidu.sapi2.dto.LoginDTO;
import com.baidu.sapi2.dto.PhoneRegDTO;
import com.baidu.sapi2.dto.QrLoginStstusCheckDTO;
import com.baidu.sapi2.dto.SSOConfirmDTO;
import com.baidu.sapi2.dto.SetPopularPortraitDTO;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.sapi2.result.CheckUserFaceIdResult;
import com.baidu.sapi2.result.DynamicPwdLoginResult;
import com.baidu.sapi2.result.FaceLoginStatusResult;
import com.baidu.sapi2.result.FastRegResult;
import com.baidu.sapi2.result.GetCaptchaResult;
import com.baidu.sapi2.result.GetDynamicPwdResult;
import com.baidu.sapi2.result.GetQrCodeImageResult;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.LoginResult;
import com.baidu.sapi2.result.OAuthResult;
import com.baidu.sapi2.result.PhoneRegResult;
import com.baidu.sapi2.result.QrAppLoginResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.service.interfaces.ISAccountService;
import com.baidu.sapi2.shell.callback.GetUserInfoCallBack;
import com.baidu.sapi2.shell.callback.SapiCallBack;
import com.baidu.sapi2.shell.response.GetPortraitResponse;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SapiResponse;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.sapi2.utils.enums.Language;
import com.baidu.sapi2.utils.enums.RegistMode;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.searchbox.ng.ai.apps.aps.AiAppsApsUtils;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.element.MarkerModel;
import com.baidu.webkit.internal.ETAG;
import com.tencent.open.SocialConstants;
import com.tencent.open.SocialOperation;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public final class SapiAccountService implements ISAccountService {
    private static final String a = "native";
    private SapiConfiguration b = SapiAccountManager.getInstance().getSapiConfiguration();
    private a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SapiAccountService(Context context) {
        this.c = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        return this.c.b() + "?" + j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("client", HttpConstants.OS_TYPE_VALUE));
        arrayList.add(new BasicNameValuePair("clientfrom", a));
        arrayList.add(new BasicNameValuePair("adapter", "3"));
        arrayList.add(new BasicNameValuePair("banner", "1"));
        arrayList.add(new BasicNameValuePair("t", String.valueOf(System.currentTimeMillis())));
        return this.c.c() + "?" + a(false) + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("adapter", "3"));
        arrayList.add(new BasicNameValuePair("banner", "1"));
        arrayList.add(new BasicNameValuePair("t", String.valueOf(System.currentTimeMillis())));
        return this.c.d() + "?" + a(false) + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("adapter", "3"));
        arrayList.add(new BasicNameValuePair("banner", "1"));
        return this.c.e() + "?" + a(false) + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(BindWidgetAction bindWidgetAction) {
        if (bindWidgetAction == null) {
            throw new IllegalArgumentException("BindWidgetAction can't be null");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("adapter", "3"));
        return this.c.a(bindWidgetAction) + "?" + j() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String e() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("adapter", "3"));
        return this.c.h() + "?" + j() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String f() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("adapter", "3"));
        return this.c.i() + "?" + j() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(SocialType socialType) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("type", socialType.getName()));
        return this.c.p() + "?" + j() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(String str) {
        String l;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("adapter", "3"));
        arrayList.add(new BasicNameValuePair("wapsec", MarkerModel.SubBase.CENTER));
        if (this.b.accountCenterRealAutnen) {
            arrayList.add(new BasicNameValuePair("realName", "1"));
        } else {
            arrayList.add(new BasicNameValuePair("realName", "0"));
        }
        if (SapiWebView.ACCOUNT_CENTER_REAL_NAME.equals(str)) {
            l = this.c.n();
        } else if (SapiWebView.ACCOUNT_CENTER_CHECK.equals(str)) {
            arrayList.add(new BasicNameValuePair("hidebtmback", "1"));
            l = this.c.m();
        } else {
            l = this.c.l();
        }
        return l + "?" + a(false) + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String g() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair(BaiduRimConstants.TPL_INIT_KEY, SapiAccountManager.getInstance().getSapiConfiguration().tpl));
        arrayList.add(new BasicNameValuePair("showtype", ISapiAccount.SAPI_ACCOUNT_PHONE));
        arrayList.add(new BasicNameValuePair(Config.DEVICE_PART, "wap"));
        arrayList.add(new BasicNameValuePair("adapter", "apps"));
        return this.c.f() + j() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String h() {
        return this.c.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String i() {
        ArrayList arrayList;
        SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        String str = sapiConfiguration.environment.getWap(SapiUtils.getDefaultHttpsEnabled()) + "/wp/";
        new ArrayList().add(new BasicNameValuePair("appid", sapiConfiguration.appId));
        if (TextUtils.isEmpty(sapiConfiguration.clientId)) {
            sapiConfiguration.clientId = SapiUtils.getClientId(sapiConfiguration.context);
        }
        return str + "?" + j() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
    }

    String j() {
        return a(true);
    }

    String a(boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("clientfrom", a));
        arrayList.add(new BasicNameValuePair(BaiduRimConstants.TPL_INIT_KEY, this.b.tpl));
        arrayList.add(new BasicNameValuePair("login_share_strategy", this.b.loginShareStrategy().getStrValue()));
        arrayList.add(new BasicNameValuePair("client", HttpConstants.OS_TYPE_VALUE));
        if (z) {
            arrayList.add(new BasicNameValuePair("adapter", this.b.customActionBarEnabled ? "3" : ""));
        }
        arrayList.add(new BasicNameValuePair("t", String.valueOf(System.currentTimeMillis())));
        arrayList.add(new BasicNameValuePair(SocialConstants.PARAM_ACT, this.b.socialBindType.getName()));
        arrayList.add(new BasicNameValuePair("hideExtraEntry", String.valueOf(this.b.smsLoginConfig.flagHideExtraEntry.ordinal())));
        arrayList.add(new BasicNameValuePair("loginLink", String.valueOf(this.b.smsLoginConfig.flagShowLoginLink.ordinal())));
        arrayList.add(new BasicNameValuePair("smsLoginLink", String.valueOf(this.b.smsLoginConfig.flagShowSmsLoginLink.ordinal())));
        arrayList.add(new BasicNameValuePair("lPFastRegLink", String.valueOf(this.b.smsLoginConfig.flagShowFastRegLink.ordinal())));
        if (this.b.registMode == RegistMode.FAST) {
            arrayList.add(new BasicNameValuePair("fastRegLink", "1"));
        }
        if (this.b.quickUserEnabled) {
            arrayList.add(new BasicNameValuePair("quick_user", "1"));
            if (this.b.registMode == RegistMode.QUICK_USER) {
                arrayList.add(new BasicNameValuePair("regtype", "2"));
            }
        }
        arrayList.add(new BasicNameValuePair("lPlayout", String.valueOf(this.b.configurableViewLayout.ordinal())));
        if (!this.b.showRegLink) {
            arrayList.add(new BasicNameValuePair("regLink", "0"));
        }
        if (!TextUtils.isEmpty(this.b.fastRegTitleText)) {
            try {
                arrayList.add(new BasicNameValuePair("fastRegText", URLEncoder.encode(this.b.fastRegTitleText, "UTF-8")));
            } catch (Throwable th) {
                Log.e(th);
            }
        }
        if (this.b.uniteVerify) {
            arrayList.add(new BasicNameValuePair("connect", "1"));
        }
        if (this.b.language == Language.ENGLISH) {
            arrayList.add(new BasicNameValuePair("lang", h.a));
        }
        arrayList.add(new BasicNameValuePair("suppcheck", "1"));
        if (this.b.supportFaceLogin) {
            arrayList.add(new BasicNameValuePair("scanface", "1"));
        }
        if (this.b.disableVoiceVerify) {
            arrayList.add(new BasicNameValuePair("disable_voice_vcode", "1"));
        }
        return SapiUtils.createRequestParams(arrayList);
    }

    String a(SocialType socialType, String str, String str2) {
        return a(socialType, str, str2, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(SocialType socialType, String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("display", a));
        arrayList.add(new BasicNameValuePair("type", socialType.getType() + ""));
        arrayList.add(new BasicNameValuePair(SocialConstants.PARAM_ACT, this.b.socialBindType.getName()));
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(new BasicNameValuePair("appid", str3));
        }
        arrayList.add(new BasicNameValuePair("access_token", str));
        arrayList.add(new BasicNameValuePair("osuid", str2));
        return this.c.r() + "?" + j() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("type", SocialType.QQ_SSO.getType() + ""));
        arrayList.add(new BasicNameValuePair("appid", this.b.qqAppID));
        arrayList.add(new BasicNameValuePair("access_token", str));
        arrayList.add(new BasicNameValuePair("osuid", str2));
        arrayList.add(new BasicNameValuePair(SocialOperation.GAME_UNION_ID, str3));
        return this.c.r() + "?" + j() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("type", SocialType.XIAOMI.getType() + ""));
        arrayList.add(new BasicNameValuePair("appid", this.b.xiaomiAppID + ""));
        arrayList.add(new BasicNameValuePair("access_token", str));
        arrayList.add(new BasicNameValuePair("osuid", str2));
        arrayList.add(new BasicNameValuePair(ISapiAccount.SAPI_ACCOUNT_PHONE, str3));
        return this.c.r() + "?" + j() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(boolean z, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("type", SocialType.WEIXIN.getType() + ""));
        arrayList.add(new BasicNameValuePair("display", a));
        arrayList.add(new BasicNameValuePair(AiAppsApsUtils.APP_KEY, this.b.wxAppID));
        arrayList.add(new BasicNameValuePair("scope", "snsapi_login"));
        if (SapiAccountManager.getInstance().getConfignation().supportGuestAccountLogin) {
            arrayList.add(new BasicNameValuePair("supportGuestAccount", "1"));
        }
        if (z) {
            arrayList.add(new BasicNameValuePair(SocialConstants.PARAM_ACT, "bind"));
            arrayList.add(new BasicNameValuePair("wapsec", MarkerModel.SubBase.CENTER));
            arrayList.add(new BasicNameValuePair("adapter", "3"));
            if (TextUtils.isEmpty(str)) {
                str = this.b.environment.getWap(SapiUtils.getDefaultHttpsEnabled()) + SapiEnv.ACCOUNT_CENTER_ACCOUNT_BIND + "?" + j() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
            }
            try {
                arrayList.add(new BasicNameValuePair("u", URLEncoder.encode(str, "UTF-8")));
            } catch (UnsupportedEncodingException e) {
                Log.e(e);
            }
        } else {
            arrayList.add(new BasicNameValuePair(SocialConstants.PARAM_ACT, this.b.socialBindType.getName()));
        }
        return this.c.t() + "?" + j() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(String str, String str2, boolean z) {
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(new BasicNameValuePair("mkey", str2));
        arrayList.add(new BasicNameValuePair("code", str));
        if (z) {
            arrayList.add(new BasicNameValuePair("wapsec", MarkerModel.SubBase.CENTER));
            arrayList.add(new BasicNameValuePair("adapter", "3"));
        }
        arrayList.add(new BasicNameValuePair("appid", this.b.wxAppID));
        arrayList.add(new BasicNameValuePair("display", a));
        return this.c.u() + "?" + j() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String k() {
        return this.c.s();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b(SocialType socialType) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("display", a));
        arrayList.add(new BasicNameValuePair("type", socialType.getType() + ""));
        arrayList.add(new BasicNameValuePair("guidebind", "1"));
        return this.c.t() + "?" + j() + ETAG.ITEM_SEPARATOR + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String l() {
        return this.c.u();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String m() {
        return this.c.v();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(SapiCallBack<SapiAccountResponse> sapiCallBack, String str, String str2) {
        return this.c.a(sapiCallBack, str, str2, false);
    }

    public void cancelRequest() {
        this.c.a();
    }

    public void fillUsername(FillUsernameCallback fillUsernameCallback, String str, String str2) {
        this.c.a(fillUsernameCallback, str, str2);
    }

    public void fillUserProfile(FillUserProfileCallback fillUserProfileCallback, String str) {
        this.c.a(fillUserProfileCallback, str);
    }

    public void setPortrait(SetPortraitCallback setPortraitCallback, String str, byte[] bArr, String str2) {
        new PortraitService(this.b, SapiAccountManager.VERSION_NAME).setPortrait(setPortraitCallback, str, bArr, str2);
    }

    public void setPopularPortrait(SetPopularPortraitCallback setPopularPortraitCallback, SetPopularPortraitDTO setPopularPortraitDTO) {
        new PortraitService(this.b, SapiAccountManager.VERSION_NAME).setPopularPortrait(setPopularPortraitCallback, setPopularPortraitDTO);
    }

    @Deprecated
    public void getPortrait(SapiCallBack<GetPortraitResponse> sapiCallBack, String str, String str2, String str3) {
        new PortraitService(this.b, SapiAccountManager.VERSION_NAME).getPortrait(sapiCallBack, str, str2, str3);
    }

    public void getHistoryPortraits(GetHistoryPortraitsCallback getHistoryPortraitsCallback, GetHistoryPortraitsDTO getHistoryPortraitsDTO) {
        new PortraitService(this.b, SapiAccountManager.VERSION_NAME).getHistoryPortraits(getHistoryPortraitsCallback, getHistoryPortraitsDTO);
    }

    public void getPopularPortraitsInfo(GetPopularPortraitsCallback getPopularPortraitsCallback, String str) {
        new PortraitService(this.b, SapiAccountManager.VERSION_NAME).getPopularPortraitsInfo(getPopularPortraitsCallback, str);
    }

    public void getUserInfo(GetUserInfoCallback getUserInfoCallback, String str) {
        this.c.a(getUserInfoCallback, str);
    }

    @Deprecated
    public void getUserInfo(GetUserInfoCallBack getUserInfoCallBack, String str) {
        this.c.a(getUserInfoCallBack, str);
    }

    public void getQrCodeContent(SapiCallback<GetQrCodeImageResult> sapiCallback, String str) {
        QrCodeService.getInstance(this.b, SapiAccountManager.VERSION_NAME).getQrCodeContent(sapiCallback, str);
    }

    public void getQrCodeUrl(SapiCallback<GetQrCodeImageResult> sapiCallback) {
        QrCodeService.getInstance(this.b, SapiAccountManager.VERSION_NAME).getQrCodeUrl(sapiCallback);
    }

    public void getQrCodeImage(String str, SapiCallback<GetQrCodeImageResult> sapiCallback) {
        QrCodeService.getInstance(this.b, SapiAccountManager.VERSION_NAME).getQrCodeImage(sapiCallback, str);
    }

    public void getQrCodeImage(SapiCallback<GetQrCodeImageResult> sapiCallback) {
        getQrCodeImage(null, sapiCallback);
    }

    public void qrLoginStatusCheck(QrLoginStatusCheckCallback qrLoginStatusCheckCallback, QrLoginStstusCheckDTO qrLoginStstusCheckDTO) {
        QrCodeService.getInstance(this.b, SapiAccountManager.VERSION_NAME).qrLoginStatusCheck(qrLoginStatusCheckCallback, qrLoginStstusCheckDTO);
    }

    public void qrJoinLoginStatusCheck(QrLoginStatusCheckCallback qrLoginStatusCheckCallback, QrLoginStstusCheckDTO qrLoginStstusCheckDTO) {
        qrLoginStstusCheckDTO.isJoinCodeLogin = true;
        QrCodeService.getInstance(this.b, SapiAccountManager.VERSION_NAME).qrLoginStatusCheck(qrLoginStatusCheckCallback, qrLoginStstusCheckDTO);
    }

    public void stopQrLoginStatusCheck() {
        QrCodeService.getInstance(this.b, SapiAccountManager.VERSION_NAME).stopLoginStatusCheck();
    }

    public void qrAppLogin(SapiCallback<QrAppLoginResult> sapiCallback, String str, String str2) {
        QrCodeService.getInstance(this.b, SapiAccountManager.VERSION_NAME).qrAppLogin(sapiCallback, str, str2);
    }

    public void wapSSOConfirm(SSOConfirmCallback sSOConfirmCallback, SSOConfirmDTO sSOConfirmDTO) {
        this.c.a(sSOConfirmCallback, sSOConfirmDTO);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(SapiCallBack<SapiAccountResponse> sapiCallBack, String str) {
        return this.c.b(sapiCallBack, str);
    }

    public void fastReg(SapiCallback<FastRegResult> sapiCallback, int i) {
        fastReg(sapiCallback, i, null);
    }

    public void fastReg(SapiCallback<FastRegResult> sapiCallback, int i, Map<String, String> map) {
        this.c.a(sapiCallback, i, map);
    }

    public void fastReg(SapiCallback<FastRegResult> sapiCallback) {
        fastReg(sapiCallback, 15);
    }

    @Deprecated
    public boolean getDynamicPwd(SapiCallBack<SapiResponse> sapiCallBack, String str) {
        return this.c.a(sapiCallBack, str);
    }

    @Deprecated
    public void getDynamicPwd(SapiCallback<GetDynamicPwdResult> sapiCallback, String str) {
        EnhancedService.getInstance(this.b, SapiAccountManager.VERSION_NAME).getDynamicPwd(sapiCallback, str);
    }

    public void getDynamicPwd(GetDynamicPwdCallback getDynamicPwdCallback, String str, String str2) {
        EnhancedService.getInstance(this.b, SapiAccountManager.VERSION_NAME).getDynamicPwd(getDynamicPwdCallback, str, str2, (Map) null);
    }

    public void getDynamicPwd(GetDynamicPwdCallback getDynamicPwdCallback, String str, String str2, Map<String, String> map) {
        EnhancedService.getInstance(this.b, SapiAccountManager.VERSION_NAME).getDynamicPwd(getDynamicPwdCallback, str, str2, map);
    }

    @Deprecated
    public boolean dynamicPwdLogin(SapiCallBack<SapiAccountResponse> sapiCallBack, String str, String str2) {
        return this.c.a(sapiCallBack, str, str2, true);
    }

    @Deprecated
    public void dynamicPwdLogin(SapiCallback<DynamicPwdLoginResult> sapiCallback, String str, String str2) {
        EnhancedService.getInstance(this.b, SapiAccountManager.VERSION_NAME).dynamicPwdLogin(sapiCallback, str, str2, (Map) null);
    }

    public void dynamicPwdLogin(DynamicPwdLoginCallback dynamicPwdLoginCallback, String str, String str2) {
        dynamicPwdLogin(dynamicPwdLoginCallback, str, str2, null);
    }

    public void dynamicPwdLogin(DynamicPwdLoginCallback dynamicPwdLoginCallback, String str, String str2, Map<String, String> map) {
        EnhancedService.getInstance(this.b, SapiAccountManager.VERSION_NAME).dynamicPwdLogin(dynamicPwdLoginCallback, str, str2, map);
    }

    public boolean isStokenExist(String str, List<String> list) {
        return this.c.a(str, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(SapiAccount sapiAccount, List<String> list) {
        return this.c.a(sapiAccount, list);
    }

    public Map<String, String> getTplStoken(GetTplStokenCallback getTplStokenCallback, String str, List<String> list) {
        return a(getTplStokenCallback, str, list, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, String> a(GetTplStokenCallback getTplStokenCallback, String str, List<String> list, boolean z) {
        return this.c.a(getTplStokenCallback, str, list, z);
    }

    @Deprecated
    public void oauth(SapiCallback<OAuthResult> sapiCallback, String str) {
        this.c.a(sapiCallback, str, (String) null);
    }

    public void oauth(SapiCallback<OAuthResult> sapiCallback, String str, String str2) {
        this.c.a(sapiCallback, str, str2);
    }

    public void login(LoginCallback loginCallback, LoginDTO loginDTO) {
        EnhancedService.getInstance(this.b, SapiAccountManager.VERSION_NAME).login(loginCallback, loginDTO);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SapiCallback<LoginResult> sapiCallback, String str) {
        EnhancedService.getInstance(this.b, SapiAccountManager.VERSION_NAME).getLoginProxyResult(sapiCallback, str);
    }

    public String getCaptchaKey() {
        return EnhancedService.getInstance(this.b, SapiAccountManager.VERSION_NAME).getCaptchaKey();
    }

    public void getCaptcha(SapiCallback<GetCaptchaResult> sapiCallback) {
        EnhancedService.getInstance(this.b, SapiAccountManager.VERSION_NAME).getCaptcha(sapiCallback);
    }

    public void getRegCode(GetRegCodeCallback getRegCodeCallback, String str) {
        EnhancedService.getInstance(this.b, SapiAccountManager.VERSION_NAME).getRegCode(getRegCodeCallback, str);
    }

    public void phoneReg(SapiCallback<PhoneRegResult> sapiCallback, PhoneRegDTO phoneRegDTO) {
        EnhancedService.getInstance(this.b, SapiAccountManager.VERSION_NAME).phoneReg(sapiCallback, phoneRegDTO);
    }

    public void web2NativeLogin(Web2NativeLoginCallback web2NativeLoginCallback) {
        this.c.a(web2NativeLoginCallback, false);
    }

    public void web2NativeLogin(Web2NativeLoginCallback web2NativeLoginCallback, boolean z) {
        this.c.a(web2NativeLoginCallback, z);
    }

    public void iqiyiSSOLogin(IqiyiLoginCallback iqiyiLoginCallback, IqiyiLoginDTO iqiyiLoginDTO) {
        this.c.a(iqiyiLoginCallback, iqiyiLoginDTO);
    }

    public void checkUserFaceId(SapiCallback<CheckUserFaceIdResult> sapiCallback, String str) {
        this.c.a(sapiCallback, str, (Map<String, String>) null);
    }

    public void checkUserFaceId(SapiCallback<CheckUserFaceIdResult> sapiCallback, String str, Map<String, String> map) {
        this.c.a(sapiCallback, str, map);
    }

    public void checkFaceLoginStatus(SapiCallback<FaceLoginStatusResult> sapiCallback, String str) {
        this.c.a(sapiCallback, str);
    }

    public void faceLoginSwitch(SapiCallback<SapiResult> sapiCallback, String str, boolean z, String str2) {
        this.c.a(sapiCallback, str, z, str2);
    }

    public void setIqiyiAccessToken(String str) {
        SapiContext.getInstance(this.b.context).setIqiyiAccesstoken(str);
        if (com.baidu.sapi2.share.a.d()) {
            this.c.d(str);
            com.baidu.sapi2.share.a.a().b();
        }
    }

    public String getIqiyiAccessToken() {
        return SapiContext.getInstance(this.b.context).getIqiyiAccesstoken();
    }

    public boolean webLogin(Context context) {
        SapiAccount currentAccount;
        if (context == null || (currentAccount = SapiContext.getInstance(context).getCurrentAccount()) == null) {
            return false;
        }
        return SapiUtils.webLogin(context, currentAccount.bduss, currentAccount.ptoken);
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountService
    public boolean webLogin(final Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("pp");
        SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() { // from class: com.baidu.sapi2.SapiAccountService.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            /* renamed from: a */
            public void onSuccess(GetTplStokenResult getTplStokenResult) {
                SapiAccountService.a(context, getTplStokenResult.tplStokenMap.get("pp"));
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            /* renamed from: b */
            public void onFailure(GetTplStokenResult getTplStokenResult) {
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onStart() {
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
            }
        }, str, arrayList);
        SapiAccount accountFromBduss = SapiContext.getInstance(context).getAccountFromBduss(str);
        if (accountFromBduss != null) {
            return a(context, accountFromBduss.bduss, accountFromBduss.ptoken);
        }
        return a(context, str, (String) null);
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountService
    public boolean webLogin(Context context, String str, String str2) {
        return webLogin(context, str);
    }

    private boolean a(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            ArrayList arrayList = new ArrayList();
            for (String str3 : SapiUtils.getAuthorizedDomains(context)) {
                if (!str.equals(SapiUtils.getCookie(SapiUtils.COOKIE_URL_PREFIX + str3, "BDUSS"))) {
                    arrayList.add(new BasicNameValuePair(SapiUtils.COOKIE_URL_PREFIX + str3, SapiUtils.buildBDUSSCookie(str3, str)));
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                for (String str4 : SapiUtils.getAuthorizedDomainsForPtoken(context)) {
                    if (!str2.equals(SapiUtils.getCookie(SapiUtils.COOKIE_HTTPS_URL_PREFIX + str4, "PTOKEN"))) {
                        arrayList.add(new BasicNameValuePair(SapiUtils.COOKIE_HTTPS_URL_PREFIX + str4, SapiUtils.buildPtokenCookie(str4, str2)));
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
                        arrayList.add(new BasicNameValuePair(SapiUtils.COOKIE_HTTPS_URL_PREFIX + str2, SapiUtils.buildStokenCookie(str2, str)));
                    }
                }
            }
            SapiUtils.syncCookies(context, arrayList);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public void checkFaceLoginEnable(Context context, Map<String, Long> map) {
        if (this.b.supportFaceLogin && SapiContext.getInstance(context).getSapiOptions().faceLoginCheckEnabled) {
            this.c.a(context, map);
        }
    }

    public void refreshOpenidToUid() {
        if (this.b.needOpenid) {
            List<SapiAccount> loginAccounts = SapiAccountManager.getInstance().getLoginAccounts();
            loginAccounts.addAll(SapiAccountManager.getInstance().getShareAccounts());
            if (loginAccounts.size() == 0) {
                SapiContext.getInstance(this.b.context).put(SapiContext.KEY_OPENID_UID_LIST, "");
                return;
            }
            final Map<String, String> urlParamsToMap = SapiUtils.urlParamsToMap(SapiContext.getInstance(this.b.context).getString(SapiContext.KEY_OPENID_UID_LIST));
            Collection<String> values = urlParamsToMap.values();
            for (SapiAccount sapiAccount : loginAccounts) {
                if (!values.contains(sapiAccount.uid)) {
                    values.remove(sapiAccount.uid);
                }
            }
            SapiContext.getInstance(this.b.context).put(SapiContext.KEY_OPENID_UID_LIST, SapiUtils.mapToUrlParams(urlParamsToMap));
            for (final SapiAccount sapiAccount2 : loginAccounts) {
                if (!urlParamsToMap.containsValue(sapiAccount2.uid)) {
                    oauth(new SapiCallback<OAuthResult>() { // from class: com.baidu.sapi2.SapiAccountService.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.sapi2.callback.SapiCallback
                        /* renamed from: a */
                        public void onSuccess(OAuthResult oAuthResult) {
                            if (!TextUtils.isEmpty(oAuthResult.openid)) {
                                urlParamsToMap.put(oAuthResult.openid, sapiAccount2.uid);
                                SapiContext.getInstance(SapiAccountService.this.b.context).put(SapiContext.KEY_OPENID_UID_LIST, SapiUtils.mapToUrlParams(urlParamsToMap));
                            }
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.sapi2.callback.SapiCallback
                        /* renamed from: b */
                        public void onFailure(OAuthResult oAuthResult) {
                        }

                        @Override // com.baidu.sapi2.callback.SapiCallback
                        public void onStart() {
                        }

                        @Override // com.baidu.sapi2.callback.SapiCallback
                        public void onFinish() {
                        }
                    }, sapiAccount2.bduss);
                }
            }
        }
    }
}
