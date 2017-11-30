package com.baidu.sapi2;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.appsearchlib.Info;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.callback.DynamicPwdLoginCallback;
import com.baidu.sapi2.callback.FaceCheckCallback;
import com.baidu.sapi2.callback.FaceDelCallback;
import com.baidu.sapi2.callback.FaceLoginCallback;
import com.baidu.sapi2.callback.FaceModifyCallback;
import com.baidu.sapi2.callback.FaceRegCallback;
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
import com.baidu.sapi2.callback.QrPcLoginCallback;
import com.baidu.sapi2.callback.QuickUserRegCallback;
import com.baidu.sapi2.callback.SSOConfirmCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.callback.SetPopularPortraitCallback;
import com.baidu.sapi2.callback.SetPortraitCallback;
import com.baidu.sapi2.callback.VoiceCheckCallback;
import com.baidu.sapi2.callback.VoiceCodeSetCallback;
import com.baidu.sapi2.callback.VoiceLoginCallback;
import com.baidu.sapi2.callback.VoiceSwitchSetCallback;
import com.baidu.sapi2.callback.VoiceVerifyCallback;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.dto.FaceCheckDTO;
import com.baidu.sapi2.dto.FaceDelDTO;
import com.baidu.sapi2.dto.FaceLoginDTO;
import com.baidu.sapi2.dto.FaceModifyDTO;
import com.baidu.sapi2.dto.FaceRegDTO;
import com.baidu.sapi2.dto.GetHistoryPortraitsDTO;
import com.baidu.sapi2.dto.IqiyiLoginDTO;
import com.baidu.sapi2.dto.LoginDTO;
import com.baidu.sapi2.dto.PhoneRegDTO;
import com.baidu.sapi2.dto.QuickUserRegDTO;
import com.baidu.sapi2.dto.ReloginDTO;
import com.baidu.sapi2.dto.SSOConfirmDTO;
import com.baidu.sapi2.dto.SetPopularPortraitDTO;
import com.baidu.sapi2.dto.VoiceCheckDTO;
import com.baidu.sapi2.dto.VoiceCodeSetDTO;
import com.baidu.sapi2.dto.VoiceSwitchSetDTO;
import com.baidu.sapi2.dto.VoiceVerifyDTO;
import com.baidu.sapi2.result.DynamicPwdLoginResult;
import com.baidu.sapi2.result.FastRegResult;
import com.baidu.sapi2.result.GetCaptchaResult;
import com.baidu.sapi2.result.GetDynamicPwdResult;
import com.baidu.sapi2.result.LoginResult;
import com.baidu.sapi2.result.OAuthResult;
import com.baidu.sapi2.result.PhoneRegResult;
import com.baidu.sapi2.result.QrAppLoginResult;
import com.baidu.sapi2.result.ReloginResult;
import com.baidu.sapi2.result.VoiceRegResult;
import com.baidu.sapi2.shell.callback.FillUsernameCallBack;
import com.baidu.sapi2.shell.callback.GetUserInfoCallBack;
import com.baidu.sapi2.shell.callback.QrAppLoginCallBack;
import com.baidu.sapi2.shell.callback.QrPCLoginCallBack;
import com.baidu.sapi2.shell.callback.SapiCallBack;
import com.baidu.sapi2.shell.response.GetPortraitResponse;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SapiResponse;
import com.baidu.sapi2.utils.L;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.sapi2.utils.enums.BiometricType;
import com.baidu.sapi2.utils.enums.Language;
import com.baidu.sapi2.utils.enums.RegistMode;
import com.baidu.sapi2.utils.enums.SocialType;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public final class SapiAccountService {
    private static final String a = "native";
    private SapiConfiguration b = SapiAccountManager.getInstance().getSapiConfiguration();
    private b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SapiAccountService(Context context) {
        this.c = new b(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        return this.c.d() + "?" + k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("client", "android"));
        arrayList.add(new BasicNameValuePair("clientfrom", a));
        arrayList.add(new BasicNameValuePair("adapter", "3"));
        arrayList.add(new BasicNameValuePair("banner", "1"));
        arrayList.add(new BasicNameValuePair(Info.kBaiduTimeKey, String.valueOf(System.currentTimeMillis())));
        return this.c.e() + "?" + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("adapter", "3"));
        arrayList.add(new BasicNameValuePair("banner", "1"));
        arrayList.add(new BasicNameValuePair(Info.kBaiduTimeKey, String.valueOf(System.currentTimeMillis())));
        return this.c.f() + "?" + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("adapter", "3"));
        arrayList.add(new BasicNameValuePair("banner", "1"));
        return this.c.g() + "?" + k() + "&" + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(BindWidgetAction bindWidgetAction) {
        if (bindWidgetAction == null) {
            throw new IllegalArgumentException("BindWidgetAction can't be null");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("adapter", "3"));
        return this.c.a(bindWidgetAction) + "?" + k() + "&" + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String e() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("adapter", "3"));
        return this.c.j() + "?" + k() + "&" + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String f() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("adapter", "3"));
        return this.c.k() + "?" + k() + "&" + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String g() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("client", "android"));
        arrayList.add(new BasicNameValuePair("clientfrom", a));
        arrayList.add(new BasicNameValuePair("tpl", this.b.tpl));
        arrayList.add(new BasicNameValuePair("adapter", "3"));
        arrayList.add(new BasicNameValuePair("wapsec", "center"));
        List<BiometricType> list = this.b.biometricTypeList;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == BiometricType.LIVENESS_RECOG) {
                arrayList.add(new BasicNameValuePair("scanface", "1"));
            } else if (list.get(i) == BiometricType.VOICE_IDENTIFY) {
                arrayList.add(new BasicNameValuePair("voiceidentify", "1"));
            }
        }
        if (this.b.accountCenterRealAutnen) {
            arrayList.add(new BasicNameValuePair("realName", "1"));
        } else {
            arrayList.add(new BasicNameValuePair("realName", "0"));
        }
        return this.c.r() + "?" + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String h() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("tpl", SapiAccountManager.getInstance().getSapiConfiguration().tpl));
        arrayList.add(new BasicNameValuePair("showtype", "phone"));
        arrayList.add(new BasicNameValuePair("device", "wap"));
        arrayList.add(new BasicNameValuePair("adapter", "apps"));
        return this.c.h() + k() + "&" + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String i() {
        return this.c.i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String j() {
        SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        String str = sapiConfiguration.environment.getWap() + "/wp/";
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("clientfrom", a));
        arrayList.add(new BasicNameValuePair("client", "android"));
        arrayList.add(new BasicNameValuePair("appid", sapiConfiguration.appId));
        if (TextUtils.isEmpty(sapiConfiguration.clientId)) {
            sapiConfiguration.clientId = SapiUtils.getClientId(sapiConfiguration.context);
        }
        arrayList.add(new BasicNameValuePair("cuid", sapiConfiguration.clientId));
        arrayList.add(new BasicNameValuePair("tpl", sapiConfiguration.tpl));
        return str + "?" + SapiUtils.createRequestParams(arrayList);
    }

    String k() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("clientfrom", a));
        arrayList.add(new BasicNameValuePair("tpl", this.b.tpl));
        arrayList.add(new BasicNameValuePair("login_share_strategy", this.b.loginShareStrategy().getStrValue()));
        arrayList.add(new BasicNameValuePair("client", "android"));
        arrayList.add(new BasicNameValuePair("adapter", this.b.customActionBarEnabled ? "3" : ""));
        arrayList.add(new BasicNameValuePair(Info.kBaiduTimeKey, String.valueOf(System.currentTimeMillis())));
        arrayList.add(new BasicNameValuePair("act", this.b.socialBindType.getName()));
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
                L.e(th);
            }
        }
        if (this.b.uniteVerify) {
            arrayList.add(new BasicNameValuePair("connect", "1"));
        }
        if (this.b.language == Language.ENGLISH) {
            arrayList.add(new BasicNameValuePair("lang", "en"));
        }
        List<BiometricType> list = this.b.biometricTypeList;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == BiometricType.LIVENESS_RECOG) {
                arrayList.add(new BasicNameValuePair("scanface", "1"));
            } else if (list.get(i) == BiometricType.VOICE_IDENTIFY) {
                arrayList.add(new BasicNameValuePair("voiceidentify", "1"));
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
        arrayList.add(new BasicNameValuePair("act", this.b.socialBindType.getName()));
        arrayList.add(new BasicNameValuePair("access_token", str));
        arrayList.add(new BasicNameValuePair("osuid", str2));
        return this.c.t() + "?" + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("type", SocialType.QQ.getType() + ""));
        arrayList.add(new BasicNameValuePair("tpl", this.b.tpl));
        arrayList.add(new BasicNameValuePair("act", this.b.socialBindType.getName()));
        arrayList.add(new BasicNameValuePair("appid", this.b.qqAppID));
        arrayList.add(new BasicNameValuePair("access_token", str));
        arrayList.add(new BasicNameValuePair("osuid", str2));
        return this.c.t() + "?" + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("type", SocialType.XIAOMI.getType() + ""));
        arrayList.add(new BasicNameValuePair("tpl", this.b.tpl));
        arrayList.add(new BasicNameValuePair("act", "special"));
        arrayList.add(new BasicNameValuePair("appid", this.b.qqAppID));
        arrayList.add(new BasicNameValuePair("access_token", str));
        arrayList.add(new BasicNameValuePair("osuid", str2));
        arrayList.add(new BasicNameValuePair("phone", str3));
        arrayList.add(new BasicNameValuePair("client", "android"));
        return this.c.t() + "?" + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(boolean z, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("type", SocialType.WEIXIN.getType() + ""));
        arrayList.add(new BasicNameValuePair("tpl", this.b.tpl));
        arrayList.add(new BasicNameValuePair("display", a));
        arrayList.add(new BasicNameValuePair("clientfrom", a));
        arrayList.add(new BasicNameValuePair("client", "android"));
        if (z) {
            arrayList.add(new BasicNameValuePair("act", "bind"));
            arrayList.add(new BasicNameValuePair("wapsec", "center"));
            arrayList.add(new BasicNameValuePair("adapter", "3"));
            try {
                arrayList.add(new BasicNameValuePair("u", URLEncoder.encode(str, "UTF-8")));
            } catch (UnsupportedEncodingException e) {
                L.e(e);
            }
        } else {
            arrayList.add(new BasicNameValuePair("act", this.b.socialBindType.getName()));
        }
        arrayList.add(new BasicNameValuePair("app_key", this.b.wxAppID));
        arrayList.add(new BasicNameValuePair("scope", "snsapi_login"));
        return this.c.v() + "?" + SapiUtils.createRequestParams(arrayList);
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
        return this.c.w() + "?" + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String l() {
        return this.c.u();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(SocialType socialType) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("tpl", this.b.tpl));
        arrayList.add(new BasicNameValuePair("display", a));
        arrayList.add(new BasicNameValuePair("type", socialType.getType() + ""));
        arrayList.add(new BasicNameValuePair("act", this.b.socialBindType.getName()));
        arrayList.add(new BasicNameValuePair("guidebind", "1"));
        return this.c.v() + "?" + SapiUtils.createRequestParams(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String m() {
        return this.c.w();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String n() {
        return this.c.x();
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

    public void voiceCheck(VoiceCheckCallback voiceCheckCallback, VoiceCheckDTO voiceCheckDTO) {
        this.c.a(voiceCheckCallback, voiceCheckDTO);
    }

    public void voiceCheck(VoiceCheckCallback voiceCheckCallback, String str) {
        this.c.a(voiceCheckCallback, str, (String) null);
    }

    public void voiceCheckByUid(VoiceCheckCallback voiceCheckCallback, String str) {
        this.c.a(voiceCheckCallback, (String) null, str);
    }

    public void voiceReg(SapiCallback<VoiceRegResult> sapiCallback, String str, String str2, String str3, boolean z) {
        this.c.a(sapiCallback, str, str2, str3, z);
    }

    public void voiceLogin(VoiceLoginCallback voiceLoginCallback, String str, String str2) {
        this.c.a(voiceLoginCallback, str, str2);
    }

    public void voiceCodeSet(VoiceCodeSetCallback voiceCodeSetCallback, VoiceCodeSetDTO voiceCodeSetDTO) {
        this.c.a(voiceCodeSetCallback, voiceCodeSetDTO);
    }

    public void voiceSwitchSet(VoiceSwitchSetCallback voiceSwitchSetCallback, VoiceSwitchSetDTO voiceSwitchSetDTO) {
        this.c.a(voiceSwitchSetCallback, voiceSwitchSetDTO);
    }

    public void voiceVerify(VoiceVerifyCallback voiceVerifyCallback, VoiceVerifyDTO voiceVerifyDTO) {
        this.c.a(voiceVerifyCallback, voiceVerifyDTO);
    }

    public void faceCheck(FaceCheckCallback faceCheckCallback, FaceCheckDTO faceCheckDTO) {
        this.c.a(faceCheckCallback, faceCheckDTO);
    }

    public void faceReg(FaceRegCallback faceRegCallback, FaceRegDTO faceRegDTO) {
        this.c.a(faceRegCallback, faceRegDTO);
    }

    public void faceLogin(FaceLoginCallback faceLoginCallback, FaceLoginDTO faceLoginDTO) {
        this.c.a(faceLoginCallback, faceLoginDTO);
    }

    public void faceModify(FaceModifyCallback faceModifyCallback, FaceModifyDTO faceModifyDTO) {
        this.c.a(faceModifyCallback, faceModifyDTO);
    }

    public void faceDel(FaceDelCallback faceDelCallback, FaceDelDTO faceDelDTO) {
        this.c.a(faceDelCallback, faceDelDTO);
    }

    @Deprecated
    public void setPortrait(SapiCallBack<SapiResponse> sapiCallBack, String str, String str2, String str3, byte[] bArr, String str4) {
        this.c.a(sapiCallBack, str, str2, str3, bArr, str4);
    }

    public void setPortrait(SetPortraitCallback setPortraitCallback, String str, byte[] bArr, String str2) {
        this.c.a(setPortraitCallback, str, bArr, str2);
    }

    public void setPopularPortrait(SetPopularPortraitCallback setPopularPortraitCallback, SetPopularPortraitDTO setPopularPortraitDTO) {
        this.c.a(setPopularPortraitCallback, setPopularPortraitDTO);
    }

    @Deprecated
    public void getPortrait(SapiCallBack<GetPortraitResponse> sapiCallBack, String str, String str2, String str3) {
        this.c.a(sapiCallBack, str, str2, str3);
    }

    public void getHistoryPortraits(GetHistoryPortraitsCallback getHistoryPortraitsCallback, GetHistoryPortraitsDTO getHistoryPortraitsDTO) {
        this.c.a(getHistoryPortraitsCallback, getHistoryPortraitsDTO);
    }

    public void getPopularPortraitsInfo(GetPopularPortraitsCallback getPopularPortraitsCallback, String str) {
        this.c.a(getPopularPortraitsCallback, str);
    }

    public void getUserInfo(GetUserInfoCallback getUserInfoCallback, String str) {
        this.c.a(getUserInfoCallback, str);
    }

    @Deprecated
    public void getUserInfo(GetUserInfoCallBack getUserInfoCallBack, String str) {
        this.c.a(getUserInfoCallBack, str);
    }

    @Deprecated
    public void qrPCLogin(QrPCLoginCallBack qrPCLoginCallBack, String str, String str2, String str3, String str4, String str5) {
        this.c.a(qrPCLoginCallBack, str, str2, str3, str4, str5);
    }

    public void qrPcLogin(QrPcLoginCallback qrPcLoginCallback, String str, String str2, String str3) {
        this.c.a(qrPcLoginCallback, str, str2, str3);
    }

    @Deprecated
    public void qrAppLogin(QrAppLoginCallBack qrAppLoginCallBack, String str, String str2) {
        this.c.a(qrAppLoginCallBack, str, str2);
    }

    public void qrAppLogin(SapiCallback<QrAppLoginResult> sapiCallback, String str, String str2) {
        this.c.b(sapiCallback, str, str2);
    }

    public void wapSSOConfirm(SSOConfirmCallback sSOConfirmCallback, SSOConfirmDTO sSOConfirmDTO) {
        this.c.a(sSOConfirmCallback, sSOConfirmDTO);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(SapiCallBack<SapiAccountResponse> sapiCallBack, String str) {
        return this.c.b(sapiCallBack, str);
    }

    public void fastReg(SapiCallback<FastRegResult> sapiCallback, int i) {
        this.c.a(sapiCallback, i);
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
        this.c.b(sapiCallback, str);
    }

    public void getDynamicPwd(GetDynamicPwdCallback getDynamicPwdCallback, String str, String str2) {
        this.c.a(getDynamicPwdCallback, str, str2);
    }

    @Deprecated
    public boolean dynamicPwdLogin(SapiCallBack<SapiAccountResponse> sapiCallBack, String str, String str2) {
        return this.c.a(sapiCallBack, str, str2, true);
    }

    @Deprecated
    public void dynamicPwdLogin(SapiCallback<DynamicPwdLoginResult> sapiCallback, String str, String str2) {
        this.c.a(sapiCallback, str, str2);
    }

    public void dynamicPwdLogin(DynamicPwdLoginCallback dynamicPwdLoginCallback, String str, String str2) {
        this.c.a(dynamicPwdLoginCallback, str, str2);
    }

    @Deprecated
    public void relogin(SapiCallBack<SapiResponse> sapiCallBack, SapiAccount.ReloginCredentials reloginCredentials) {
        this.c.a(sapiCallBack, reloginCredentials);
    }

    public void relogin(SapiCallback<ReloginResult> sapiCallback, ReloginDTO reloginDTO) {
        this.c.a(sapiCallback, reloginDTO);
    }

    public int blockingRelogin(SapiAccount.ReloginCredentials reloginCredentials) {
        return this.c.a(reloginCredentials);
    }

    @Deprecated
    public void deviceLoginCheck() {
        this.c.c();
    }

    @Deprecated
    public boolean isDeviceLoginAvailable() {
        return c.a(this.b.context).b();
    }

    @Deprecated
    public boolean deviceLogin(SapiCallBack<SapiResponse> sapiCallBack) {
        if (!c.a(this.b.context).b()) {
            return false;
        }
        String a2 = c.a(this.b.context).a();
        if (TextUtils.isEmpty(a2) || "null".equalsIgnoreCase(a2)) {
            return this.c.a(sapiCallBack);
        }
        return this.c.d(sapiCallBack, a2);
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
        this.c.c(sapiCallback, str);
    }

    public void login(LoginCallback loginCallback, LoginDTO loginDTO) {
        this.c.a(loginCallback, loginDTO);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SapiCallback<LoginResult> sapiCallback, String str) {
        this.c.a(sapiCallback, str);
    }

    public String getCaptchaKey() {
        return this.c.b();
    }

    public void getCaptcha(SapiCallback<GetCaptchaResult> sapiCallback) {
        this.c.a(sapiCallback);
    }

    public void getRegCode(GetRegCodeCallback getRegCodeCallback, String str) {
        this.c.a(getRegCodeCallback, str);
    }

    public void phoneReg(SapiCallback<PhoneRegResult> sapiCallback, PhoneRegDTO phoneRegDTO) {
        this.c.a(sapiCallback, phoneRegDTO);
    }

    public void quickUserReg(QuickUserRegCallback quickUserRegCallback, QuickUserRegDTO quickUserRegDTO) {
        this.c.a(quickUserRegCallback, quickUserRegDTO);
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

    public boolean webLogin(Context context) {
        SapiAccount d;
        if (context == null || (d = c.a(context).d()) == null) {
            return false;
        }
        return SapiUtils.webLogin(context, d.bduss, d.k);
    }

    public boolean webLogin(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        SapiAccount b = c.a(context).b(str);
        if (b != null) {
            return SapiUtils.webLogin(context, b.bduss, b.k);
        }
        return SapiUtils.webLogin(context, str, null);
    }
}
