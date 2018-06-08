package com.baidu.sapi2;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.fsg.base.statistics.h;
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
import com.baidu.sapi2.result.DynamicPwdLoginResult;
import com.baidu.sapi2.result.FastRegResult;
import com.baidu.sapi2.result.GetCaptchaResult;
import com.baidu.sapi2.result.GetDynamicPwdResult;
import com.baidu.sapi2.result.GetQrCodeImageResult;
import com.baidu.sapi2.result.LoginResult;
import com.baidu.sapi2.result.OAuthResult;
import com.baidu.sapi2.result.PhoneRegResult;
import com.baidu.sapi2.service.interfaces.ISAccountService;
import com.baidu.sapi2.shell.callback.FillUsernameCallBack;
import com.baidu.sapi2.shell.callback.GetUserInfoCallBack;
import com.baidu.sapi2.shell.callback.SapiCallBack;
import com.baidu.sapi2.shell.response.GetPortraitResponse;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SapiResponse;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.sapi2.utils.enums.BiometricType;
import com.baidu.sapi2.utils.enums.Language;
import com.baidu.sapi2.utils.enums.RegistMode;
import com.baidu.sapi2.utils.enums.SocialType;
import com.tencent.open.SocialConstants;
import com.tencent.open.SocialOperation;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
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
        return this.c.c() + "?" + j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("client", HttpConstants.OS_TYPE_VALUE));
        arrayList.add(new BasicNameValuePair("clientfrom", a));
        arrayList.add(new BasicNameValuePair("adapter", "3"));
        arrayList.add(new BasicNameValuePair("banner", "1"));
        arrayList.add(new BasicNameValuePair(Info.kBaiduTimeKey, String.valueOf(System.currentTimeMillis())));
        return this.c.d() + "?" + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("adapter", "3"));
        arrayList.add(new BasicNameValuePair("banner", "1"));
        arrayList.add(new BasicNameValuePair(Info.kBaiduTimeKey, String.valueOf(System.currentTimeMillis())));
        return this.c.e() + "?" + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("adapter", "3"));
        arrayList.add(new BasicNameValuePair("banner", "1"));
        return this.c.f() + "?" + j() + "&" + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(BindWidgetAction bindWidgetAction) {
        if (bindWidgetAction == null) {
            throw new IllegalArgumentException("BindWidgetAction can't be null");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("adapter", "3"));
        return this.c.a(bindWidgetAction) + "?" + j() + "&" + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String e() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("adapter", "3"));
        return this.c.i() + "?" + j() + "&" + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String f() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("adapter", "3"));
        return this.c.j() + "?" + j() + "&" + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("client", HttpConstants.OS_TYPE_VALUE));
        arrayList.add(new BasicNameValuePair("clientfrom", a));
        arrayList.add(new BasicNameValuePair("tpl", this.b.tpl));
        arrayList.add(new BasicNameValuePair("adapter", "3"));
        arrayList.add(new BasicNameValuePair("wapsec", "center"));
        List<BiometricType> list = this.b.biometricTypeList;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == BiometricType.LIVENESS_RECOG) {
                arrayList.add(new BasicNameValuePair("scanface", "1"));
            }
        }
        if (this.b.accountCenterRealAutnen) {
            arrayList.add(new BasicNameValuePair("realName", "1"));
        } else {
            arrayList.add(new BasicNameValuePair("realName", "0"));
        }
        if (z) {
            return this.c.n() + "?" + SapiUtils.createRequestParams(arrayList);
        }
        return this.c.m() + "?" + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String g() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("tpl", SapiAccountManager.getInstance().getSapiConfiguration().tpl));
        arrayList.add(new BasicNameValuePair("showtype", ISapiAccount.SAPI_ACCOUNT_PHONE));
        arrayList.add(new BasicNameValuePair("device", "wap"));
        arrayList.add(new BasicNameValuePair("adapter", "apps"));
        return this.c.g() + j() + "&" + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String h() {
        return this.c.h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String i() {
        SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        String str = sapiConfiguration.environment.getWap(SapiUtils.getDefaultHttpsEnabled()) + "/wp/";
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("clientfrom", a));
        arrayList.add(new BasicNameValuePair("client", HttpConstants.OS_TYPE_VALUE));
        arrayList.add(new BasicNameValuePair("appid", sapiConfiguration.appId));
        if (TextUtils.isEmpty(sapiConfiguration.clientId)) {
            sapiConfiguration.clientId = SapiUtils.getClientId(sapiConfiguration.context);
        }
        arrayList.add(new BasicNameValuePair("cuid", sapiConfiguration.clientId));
        arrayList.add(new BasicNameValuePair("tpl", sapiConfiguration.tpl));
        return str + "?" + SapiUtils.createRequestParams(arrayList);
    }

    String j() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("clientfrom", a));
        arrayList.add(new BasicNameValuePair("tpl", this.b.tpl));
        arrayList.add(new BasicNameValuePair("login_share_strategy", this.b.loginShareStrategy().getStrValue()));
        arrayList.add(new BasicNameValuePair("client", HttpConstants.OS_TYPE_VALUE));
        arrayList.add(new BasicNameValuePair("adapter", this.b.customActionBarEnabled ? "3" : ""));
        arrayList.add(new BasicNameValuePair(Info.kBaiduTimeKey, String.valueOf(System.currentTimeMillis())));
        arrayList.add(new BasicNameValuePair(SocialConstants.PARAM_ACT, this.b.socialBindType.getName()));
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
        List<BiometricType> list = this.b.biometricTypeList;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == BiometricType.LIVENESS_RECOG) {
                arrayList.add(new BasicNameValuePair("scanface", "1"));
            }
        }
        return SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(SocialType socialType, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("tpl", this.b.tpl));
        arrayList.add(new BasicNameValuePair("display", a));
        arrayList.add(new BasicNameValuePair("type", socialType.getType() + ""));
        arrayList.add(new BasicNameValuePair(SocialConstants.PARAM_ACT, this.b.socialBindType.getName()));
        arrayList.add(new BasicNameValuePair("access_token", str));
        arrayList.add(new BasicNameValuePair("osuid", str2));
        return this.c.q() + "?" + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("type", SocialType.QQ_SSO.getType() + ""));
        arrayList.add(new BasicNameValuePair("tpl", this.b.tpl));
        arrayList.add(new BasicNameValuePair(SocialConstants.PARAM_ACT, this.b.socialBindType.getName()));
        arrayList.add(new BasicNameValuePair("appid", this.b.qqAppID));
        arrayList.add(new BasicNameValuePair("access_token", str));
        arrayList.add(new BasicNameValuePair("osuid", str2));
        arrayList.add(new BasicNameValuePair(SocialOperation.GAME_UNION_ID, str3));
        return this.c.q() + "?" + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("type", SocialType.XIAOMI.getType() + ""));
        arrayList.add(new BasicNameValuePair("tpl", this.b.tpl));
        arrayList.add(new BasicNameValuePair(SocialConstants.PARAM_ACT, "special"));
        arrayList.add(new BasicNameValuePair("appid", this.b.qqAppID));
        arrayList.add(new BasicNameValuePair("access_token", str));
        arrayList.add(new BasicNameValuePair("osuid", str2));
        arrayList.add(new BasicNameValuePair(ISapiAccount.SAPI_ACCOUNT_PHONE, str3));
        arrayList.add(new BasicNameValuePair("client", HttpConstants.OS_TYPE_VALUE));
        return this.c.q() + "?" + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(boolean z, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("type", SocialType.WEIXIN.getType() + ""));
        arrayList.add(new BasicNameValuePair("tpl", this.b.tpl));
        arrayList.add(new BasicNameValuePair("display", a));
        arrayList.add(new BasicNameValuePair("clientfrom", a));
        arrayList.add(new BasicNameValuePair("client", HttpConstants.OS_TYPE_VALUE));
        if (z) {
            arrayList.add(new BasicNameValuePair(SocialConstants.PARAM_ACT, "bind"));
            arrayList.add(new BasicNameValuePair("wapsec", "center"));
            arrayList.add(new BasicNameValuePair("adapter", "3"));
            try {
                arrayList.add(new BasicNameValuePair("u", URLEncoder.encode(str, "UTF-8")));
            } catch (UnsupportedEncodingException e) {
                Log.e(e);
            }
        } else {
            arrayList.add(new BasicNameValuePair(SocialConstants.PARAM_ACT, this.b.socialBindType.getName()));
        }
        arrayList.add(new BasicNameValuePair("app_key", this.b.wxAppID));
        arrayList.add(new BasicNameValuePair("scope", "snsapi_login"));
        return this.c.s() + "?" + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(String str, String str2, boolean z) {
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(new BasicNameValuePair("mkey", str2));
        arrayList.add(new BasicNameValuePair("code", str));
        if (z) {
            arrayList.add(new BasicNameValuePair("wapsec", "center"));
            arrayList.add(new BasicNameValuePair("adapter", "3"));
        }
        arrayList.add(new BasicNameValuePair("appid", this.b.wxAppID));
        arrayList.add(new BasicNameValuePair("display", a));
        return this.c.t() + "?" + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String k() {
        return this.c.r();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(SocialType socialType) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("tpl", this.b.tpl));
        arrayList.add(new BasicNameValuePair("display", a));
        arrayList.add(new BasicNameValuePair("type", socialType.getType() + ""));
        arrayList.add(new BasicNameValuePair(SocialConstants.PARAM_ACT, this.b.socialBindType.getName()));
        arrayList.add(new BasicNameValuePair("guidebind", "1"));
        return this.c.s() + "?" + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String l() {
        return this.c.t();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String m() {
        return this.c.u();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(SapiCallBack<SapiAccountResponse> sapiCallBack, String str, String str2) {
        return this.c.a(sapiCallBack, str, str2, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(Map<String, String> map, String str) {
        return this.c.a(map, str);
    }

    public void cancelRequest() {
        this.c.a();
    }

    @Deprecated
    public void fillUsername(FillUsernameCallBack fillUsernameCallBack, String str, String str2, String str3) {
        this.c.a(fillUsernameCallBack, str, str2, str3);
    }

    public void fillUsername(FillUsernameCallback fillUsernameCallback, String str, String str2) {
        this.c.a(fillUsernameCallback, str, str2);
    }

    public void fillUserProfile(FillUserProfileCallback fillUserProfileCallback, String str) {
        this.c.a(fillUserProfileCallback, str);
    }

    @Deprecated
    public void setPortrait(SapiCallBack<SapiResponse> sapiCallBack, String str, String str2, String str3, byte[] bArr, String str4) {
        new PortraitService(this.b, SapiAccountManager.VERSION_NAME).setPortrait(sapiCallBack, str, str2, str3, bArr, str4);
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

    public void getQrCodeImage(SapiCallback<GetQrCodeImageResult> sapiCallback) {
        QrCodeService.getInstance(this.b, SapiAccountManager.VERSION_NAME).getQrCodeImage(sapiCallback);
    }

    public void qrLoginStatusCheck(QrLoginStatusCheckCallback qrLoginStatusCheckCallback, QrLoginStstusCheckDTO qrLoginStstusCheckDTO) {
        QrCodeService.getInstance(this.b, SapiAccountManager.VERSION_NAME).qrLoginStatusCheck(qrLoginStatusCheckCallback, qrLoginStstusCheckDTO);
    }

    public void stopQrLoginStatusCheck() {
        QrCodeService.getInstance(this.b, SapiAccountManager.VERSION_NAME).stopLoginStatusCheck();
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
        EnhancedService.getInstance(this.b, SapiAccountManager.VERSION_NAME).getDynamicPwd(getDynamicPwdCallback, str, str2);
    }

    @Deprecated
    public boolean dynamicPwdLogin(SapiCallBack<SapiAccountResponse> sapiCallBack, String str, String str2) {
        return this.c.a(sapiCallBack, str, str2, true);
    }

    @Deprecated
    public void dynamicPwdLogin(SapiCallback<DynamicPwdLoginResult> sapiCallback, String str, String str2) {
        EnhancedService.getInstance(this.b, SapiAccountManager.VERSION_NAME).dynamicPwdLogin(sapiCallback, str, str2);
    }

    public void dynamicPwdLogin(DynamicPwdLoginCallback dynamicPwdLoginCallback, String str, String str2) {
        EnhancedService.getInstance(this.b, SapiAccountManager.VERSION_NAME).dynamicPwdLogin(dynamicPwdLoginCallback, str, str2);
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

    public void oauth(SapiCallback<OAuthResult> sapiCallback, String str) {
        this.c.a(sapiCallback, str);
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
    public boolean webLogin(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        SapiAccount accountFromBduss = SapiContext.getInstance(context).getAccountFromBduss(str);
        if (accountFromBduss != null) {
            return SapiUtils.webLogin(context, accountFromBduss.bduss, accountFromBduss.ptoken);
        }
        return SapiUtils.webLogin(context, str, null);
    }

    public void faceLoginEnable(Context context) {
        if (this.b.supportFaceLogin && SapiContext.getInstance(context).getSapiOptions().faceLoginCheckEnabled) {
            try {
                Class.forName("com.baidu.fsg.api.BaiduRIM");
                if (!SapiAccountManager.getInstance().isLogin() && !TextUtils.isEmpty(SapiContext.getInstance(context).getFaceLoginUid())) {
                    this.c.a(context);
                }
            } catch (Throwable th) {
                Log.e(th);
                throw new RuntimeException("face login is support, but there is no face jar file");
            }
        }
    }
}
