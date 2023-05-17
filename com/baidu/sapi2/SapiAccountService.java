package com.baidu.sapi2;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.sapi2.activity.BindVerifyActivity;
import com.baidu.sapi2.activity.SlideActiviy;
import com.baidu.sapi2.callback.DynamicPwdLoginCallback;
import com.baidu.sapi2.callback.DynamicPwdWithAuthCallback;
import com.baidu.sapi2.callback.FillUsernameCallback;
import com.baidu.sapi2.callback.GetCertStatusCallback;
import com.baidu.sapi2.callback.GetDynamicPwdCallback;
import com.baidu.sapi2.callback.GetHistoryPortraitsCallback;
import com.baidu.sapi2.callback.GetOpenBdussCallback;
import com.baidu.sapi2.callback.GetPopularPortraitsCallback;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.GetUserAttrInfoCallback;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.callback.IqiyiLoginCallback;
import com.baidu.sapi2.callback.IsShowRealNameCallback;
import com.baidu.sapi2.callback.LoginWithUCAuthCallback;
import com.baidu.sapi2.callback.NetCallback;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.callback.QrLoginStatusCheckCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.callback.SetPopularPortraitCallback;
import com.baidu.sapi2.callback.SetPortraitCallback;
import com.baidu.sapi2.callback.SsoHashCallback;
import com.baidu.sapi2.callback.UserLogoutCallback;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.callback.inner.GetOnlineAppCallback;
import com.baidu.sapi2.callback.inner.GetShareV3AppCallback;
import com.baidu.sapi2.callback.inner.LoadExternalWebViewActivityCallback;
import com.baidu.sapi2.callback.inner.LoginHistoryCallback;
import com.baidu.sapi2.callback.inner.OneKeyLoginOptCallback;
import com.baidu.sapi2.contacts.callback.GetContactsCallback;
import com.baidu.sapi2.contacts.dto.GetContactsDTO;
import com.baidu.sapi2.contacts.dto.SendSmsDTO;
import com.baidu.sapi2.dto.GetHistoryPortraitsDTO;
import com.baidu.sapi2.dto.GetOneKeyLoginStateDTO;
import com.baidu.sapi2.dto.GetOpenBdussDTO;
import com.baidu.sapi2.dto.GetQrCodeImageDTO;
import com.baidu.sapi2.dto.IqiyiLoginDTO;
import com.baidu.sapi2.dto.IsShowRealNameGuideDTO;
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
import com.baidu.sapi2.service.interfaces.ISAccountService;
import com.baidu.sapi2.share.GetOnlineRequestShareModel;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.shell.callback.SapiCallBack;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SapiResponse;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiCoreUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.sapi2.utils.enums.Enums;
import com.baidu.sapi2.utils.enums.Language;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.huawei.hms.framework.common.ExceptionCode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class SapiAccountService implements ISAccountService {
    public static final String BUSINESS_FROM_ONE_KEY_LOGIN = "business_from_one_key_login";
    public static final String DISPLAY_TYPE_NATIVE = "native";
    public static final String TAG = "SapiAccountService";
    public SapiConfiguration configuration = SapiAccountManager.getInstance().getSapiConfiguration();
    public SapiAccountRepository sapiAccountRepository = new SapiAccountRepository();

    public void cancelRequest() {
        this.sapiAccountRepository.cancelRequest();
    }

    public String getAddressManageUrl() {
        return this.sapiAccountRepository.getContactAddressUrl() + "?" + getRequestParams();
    }

    public String getAuthWidgetUrl() {
        return this.sapiAccountRepository.getAuthWidgetUrl() + "?" + getAuthRequestParams();
    }

    public int getBdussState() {
        return new OpenBdussService(this.configuration, "9.7.5").getBdussState();
    }

    public String getCaptchaKey() {
        return EnhancedService.getInstance(this.configuration, "9.7.5").getCaptchaKey();
    }

    public String getCertGuardUrl() {
        return this.sapiAccountRepository.getCertGuardUrl() + "?" + getRequestParams();
    }

    public String getChangeUsernameUrl() {
        return this.sapiAccountRepository.getChangeUsername() + "?" + getRequestParams();
    }

    public String getChildVerifyUrl() {
        return this.sapiAccountRepository.getChildVerifyUrl() + "?" + getRequestParams();
    }

    public String getDoubleListUrl() {
        return this.sapiAccountRepository.getDoubleListUrl() + "?" + getRequestParams();
    }

    public String getExplainCameraDeatilUrl() {
        return this.sapiAccountRepository.getExplainCameraDeatilUrl() + "?" + getRequestParams();
    }

    public String getInvoiceBuildUrl() {
        return this.sapiAccountRepository.getInvoiceAddressUrl() + "?" + getRequestParams(true);
    }

    public String getLoginUrl() {
        return this.sapiAccountRepository.getWapLoginUrl() + "?" + getRequestParams();
    }

    public JSONObject getPhoneNumAndOperatorType() {
        return new OneKeyLoginSdkCall().getEncryptPhone();
    }

    public String getRequestParams() {
        return getRequestParams(true);
    }

    public String getSwitchAccountUrl() {
        return this.sapiAccountRepository.getSwitchAccountUrl() + "?" + getRequestParams();
    }

    public String getUrlAfterAuth() {
        return this.sapiAccountRepository.getDomainAfterAuth();
    }

    public String getUrlFinishBind() {
        return this.sapiAccountRepository.getDomainFinishBind();
    }

    public String getUrlSSOFinish() {
        return this.sapiAccountRepository.getDomainSSOFinish();
    }

    public String getUrlSSOSecondcard() {
        return this.sapiAccountRepository.getDomainSSOSecondcard();
    }

    public String getWapShareLoginUrl() {
        return this.sapiAccountRepository.getWapShareLoginUrl() + "?" + getRequestParams();
    }

    public void preGetPhoneInfo() {
        new OneKeyLoginSdkCall().preGetPhoneInfo(this.configuration, "product");
    }

    public void relaseContactsSource() {
        GetContactsService.getInstance(this.configuration, "9.7.5").relaseContactsSource();
    }

    public void stopLooperLoginCheck() {
        EnhancedService.getInstance(this.configuration, "9.7.5").stopLooperLoginCheck();
    }

    public void stopQrLoginStatusCheck() {
        QrCodeService.getInstance(this.configuration, "9.7.5").stopLoginStatusCheck();
    }

    public String getAuthWidgetUrl(boolean z) {
        return this.sapiAccountRepository.getAuthWidgetUrl() + "?" + getAuthRequestParams(z);
    }

    public void getCaptcha(SapiCallback<GetCaptchaResult> sapiCallback) {
        EnhancedService.getInstance(this.configuration, "9.7.5").getCaptcha(sapiCallback);
    }

    public void getCertInfo(GetCertStatusCallback getCertStatusCallback) {
        this.sapiAccountRepository.getCertStatus(getCertStatusCallback);
    }

    public void getOneKeyLoginToken(OneKeyLoginSdkCall.TokenListener tokenListener) {
        new OneKeyLoginSdkCall().getToken(this.configuration, tokenListener);
    }

    public void sendContactsSms(SendSmsDTO sendSmsDTO) {
        GetContactsService.getInstance(this.configuration, "9.7.5").sendSMS(sendSmsDTO);
    }

    public void web2NativeLogin(Web2NativeLoginCallback web2NativeLoginCallback) {
        this.sapiAccountRepository.web2NativeLogin(web2NativeLoginCallback, true);
    }

    public boolean webLogin(Context context) {
        SapiAccount currentAccount;
        if (context == null || (currentAccount = SapiContext.getInstance().getCurrentAccount()) == null) {
            return false;
        }
        return SapiUtils.webLogin(context, currentAccount.bduss, currentAccount.ptoken);
    }

    private boolean asyncBduss2Web(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                ArrayList arrayList = new ArrayList();
                for (String str3 : SapiUtils.getAuthorizedDomains()) {
                    if (!str.equals(SapiUtils.getCookie(SapiUtils.COOKIE_URL_PREFIX + str3, HttpRequest.BDUSS))) {
                        arrayList.add(new PassNameValuePair(SapiUtils.COOKIE_URL_PREFIX + str3, SapiUtils.buildBDUSSBFESSCookie(str3, str)));
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

    public static boolean asyncStoken2Web(Context context, String str) {
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

    public void handleOneKeyLoginResult(OneKeyLoginCallback oneKeyLoginCallback, String str) {
        SapiAccountResponse parseAccountXmlToResponse = SapiCoreUtil.parseAccountXmlToResponse("business_from_one_key_login", str);
        if (parseAccountXmlToResponse != null) {
            String operatorType = new OneKeyLoginSdkCall().getOperatorType();
            if ("CM".equals(operatorType)) {
                SapiContext.getInstance().setPreLoginType(Enums.LastLoginType.ONEKEYLOGIN_CM.getName());
            } else if ("CU".equals(operatorType)) {
                SapiContext.getInstance().setPreLoginType(Enums.LastLoginType.ONEKEYLOGIN_CU.getName());
            } else if ("CT".equals(operatorType)) {
                SapiContext.getInstance().setPreLoginType(Enums.LastLoginType.ONEKEYLOGIN_CT.getName());
            }
            SapiAccountManager.getInstance().validate(sapiAccountResponseToAccount(parseAccountXmlToResponse));
            authorizeOneKeyLoginSuccess(oneKeyLoginCallback, parseAccountXmlToResponse.accountType);
            return;
        }
        new OneKeyLoginSdkCall().loadOneKeyLoginFail(oneKeyLoginCallback, -103, null);
    }

    private void authorizeOneKeyLoginSuccess(OneKeyLoginCallback oneKeyLoginCallback, AccountType accountType) {
        OneKeyLoginResult oneKeyLoginResult = new OneKeyLoginResult();
        oneKeyLoginResult.setResultCode(0);
        oneKeyLoginCallback.onSuccess(oneKeyLoginResult);
    }

    public void checkAvailableLoginHistory(String str, LoginHistoryCallback loginHistoryCallback) {
        this.sapiAccountRepository.checkAvailableLoginHistory(str, loginHistoryCallback);
    }

    public void checkFaceLoginStatus(SapiCallback<FaceLoginStatusResult> sapiCallback, String str) {
        this.sapiAccountRepository.checkFaceLoginStatus(sapiCallback, str);
    }

    public void checkUserFaceId(SapiCallback<CheckUserFaceIdResult> sapiCallback, String str) {
        this.sapiAccountRepository.checkUserFaceId(sapiCallback, str, null);
    }

    public void getContacts(GetContactsCallback getContactsCallback, GetContactsDTO getContactsDTO) {
        GetContactsService.getInstance(this.configuration, "9.7.5").getContacts(getContactsCallback, getContactsDTO);
    }

    @Deprecated
    public void getDynamicPwd(SapiCallback<GetDynamicPwdResult> sapiCallback, String str) {
        EnhancedService.getInstance(this.configuration, "9.7.5").getDynamicPwd(sapiCallback, str);
    }

    public void getHistoryPortraits(GetHistoryPortraitsCallback getHistoryPortraitsCallback, GetHistoryPortraitsDTO getHistoryPortraitsDTO) {
        new PortraitService(this.configuration, "9.7.5").getHistoryPortraits(getHistoryPortraitsCallback, getHistoryPortraitsDTO);
    }

    public void getOpenBduss(GetOpenBdussDTO getOpenBdussDTO, GetOpenBdussCallback getOpenBdussCallback) {
        new OpenBdussService(this.configuration, "9.7.5").getOpenBduss(getOpenBdussDTO, getOpenBdussCallback);
    }

    public void getPopularPortraitsInfo(GetPopularPortraitsCallback getPopularPortraitsCallback, String str) {
        new PortraitService(this.configuration, "9.7.5").getPopularPortraitsInfo(getPopularPortraitsCallback, str, PortraitCategory.NORMAL);
    }

    public void getQrCodeImage(SapiCallback<GetQrCodeImageResult> sapiCallback, GetQrCodeImageDTO getQrCodeImageDTO) {
        QrCodeService.getInstance(this.configuration, "9.7.5").getQrCodeImage(sapiCallback, getQrCodeImageDTO);
    }

    public void getUserInfo(GetUserInfoCallback getUserInfoCallback, String str) {
        this.sapiAccountRepository.getUserInfo(getUserInfoCallback, str);
    }

    public void iqiyiSSOLogin(IqiyiLoginCallback iqiyiLoginCallback, IqiyiLoginDTO iqiyiLoginDTO) {
        this.sapiAccountRepository.iqiyiSSOLogin(iqiyiLoginCallback, iqiyiLoginDTO);
    }

    public void isShowRealNameGuide(IsShowRealNameGuideDTO isShowRealNameGuideDTO, IsShowRealNameCallback isShowRealNameCallback) {
        this.sapiAccountRepository.isShowRealNameGuide(isShowRealNameGuideDTO, isShowRealNameCallback);
    }

    public boolean isStokenExist(SapiAccount sapiAccount, List<String> list) {
        return this.sapiAccountRepository.isAccountStokenExist(sapiAccount, list);
    }

    @Deprecated
    public void oauth(SapiCallback<OAuthResult> sapiCallback, String str) {
        this.sapiAccountRepository.oauth(sapiCallback, str, null, null);
    }

    public void qrJoinLoginStatusCheck(QrLoginStatusCheckCallback qrLoginStatusCheckCallback, QrLoginStstusCheckDTO qrLoginStstusCheckDTO) {
        qrLoginStstusCheckDTO.isJoinCodeLogin = true;
        QrCodeService.getInstance(this.configuration, "9.7.5").qrLoginStatusCheck(qrLoginStatusCheckCallback, qrLoginStstusCheckDTO, true);
    }

    public void qrLoginStatusCheck(QrLoginStatusCheckCallback qrLoginStatusCheckCallback, QrLoginStstusCheckDTO qrLoginStstusCheckDTO) {
        QrCodeService.getInstance(this.configuration, "9.7.5").qrLoginStatusCheck(qrLoginStatusCheckCallback, qrLoginStstusCheckDTO, true);
    }

    public void setCloudShareAccount(int i, ShareStorage.StorageModel storageModel) {
        this.sapiAccountRepository.setCloudShareAccount(i, storageModel);
    }

    public void setPopularPortrait(SetPopularPortraitCallback setPopularPortraitCallback, SetPopularPortraitDTO setPopularPortraitDTO) {
        new PortraitService(this.configuration, "9.7.5").setPopularPortrait(setPopularPortraitCallback, setPopularPortraitDTO);
    }

    public void setPortrait(SetPortraitDTO setPortraitDTO, SetPortraitCallback setPortraitCallback) {
        new PortraitService(this.configuration, "9.7.5").setPortrait(setPortraitDTO, setPortraitCallback);
    }

    public void startLooper(String str, DynamicPwdWithAuthCallback dynamicPwdWithAuthCallback) {
        EnhancedService.getInstance(this.configuration, "9.7.5").startLooper(str, dynamicPwdWithAuthCallback);
    }

    public void userLogout(int i, UserLogoutCallback userLogoutCallback) {
        this.sapiAccountRepository.userLogout(i, userLogoutCallback);
    }

    public void web2NativeLogin(Web2NativeLoginCallback web2NativeLoginCallback, boolean z) {
        this.sapiAccountRepository.web2NativeLogin(web2NativeLoginCallback, z);
    }

    private SapiAccount sapiAccountResponseToAccount(SapiAccountResponse sapiAccountResponse) {
        String str;
        SapiAccount sapiAccount = new SapiAccount();
        sapiAccount.uid = sapiAccountResponse.uid;
        sapiAccount.bduss = sapiAccountResponse.bduss;
        sapiAccount.displayname = sapiAccountResponse.displayname;
        sapiAccount.stoken = sapiAccountResponse.stoken;
        sapiAccount.ptoken = sapiAccountResponse.ptoken;
        sapiAccount.email = sapiAccountResponse.email;
        sapiAccount.username = sapiAccountResponse.username;
        if (TextUtils.isEmpty(sapiAccountResponse.app)) {
            str = SapiUtils.getAppName(this.configuration.context);
        } else {
            str = sapiAccountResponse.app;
        }
        sapiAccount.app = str;
        sapiAccount.extra = sapiAccountResponse.extra;
        sapiAccount.fromType = sapiAccountResponse.fromType.getValue();
        SocialType socialType = SocialType.UNKNOWN;
        SocialType socialType2 = sapiAccountResponse.socialType;
        if (socialType != socialType2) {
            sapiAccount.addSocialInfo(socialType2, sapiAccountResponse.socialPortraitUrl, sapiAccountResponse.socialNickname);
            sapiAccount.putExtra("account_type", Integer.valueOf(sapiAccountResponse.accountType.getType()));
        }
        sapiAccount.putExtra("tpl", this.configuration.tpl);
        if (!sapiAccountResponse.tplStokenMap.isEmpty()) {
            sapiAccount.addDispersionCertification(sapiAccountResponse.tplStokenMap);
        }
        SapiContext.getInstance().setAccountActionType(sapiAccountResponse.actionType);
        sapiAccount.addIsGuestAccount(sapiAccountResponse.isGuestAccount);
        if (!TextUtils.isEmpty(sapiAccountResponse.livingUname)) {
            new FaceLoginService().syncFaceLoginUID(this.configuration.context, sapiAccountResponse.livingUname);
        }
        return sapiAccount;
    }

    public String getAccountCenterUrl(String str) {
        String acccountCenterUrl;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("adapter", "3"));
        arrayList.add(new PassNameValuePair("wapsec", "center"));
        if (this.configuration.accountCenterRealAutnen) {
            arrayList.add(new PassNameValuePair(BindVerifyActivity.m, "1"));
        } else {
            arrayList.add(new PassNameValuePair(BindVerifyActivity.m, "0"));
        }
        if (SapiWebView.ACCOUNT_CENTER_REAL_NAME.equals(str)) {
            acccountCenterUrl = this.sapiAccountRepository.getAccountRealNameUrl();
        } else if (SapiWebView.ACCOUNT_CENTER_CHECK.equals(str)) {
            arrayList.add(new PassNameValuePair("hidebtmback", "1"));
            arrayList.add(new PassNameValuePair(SlideActiviy.EXTRA_PARAMS_SLIDE_PAGE, "1"));
            acccountCenterUrl = this.sapiAccountRepository.getAccountCenterCheckUrl();
        } else {
            acccountCenterUrl = this.sapiAccountRepository.getAcccountCenterUrl();
        }
        return acccountCenterUrl + "?" + getRequestParams(false) + "&" + SapiUtils.createRequestParams(arrayList);
    }

    public void checkUserFaceId(SapiCallback<CheckUserFaceIdResult> sapiCallback, String str, Map<String, String> map) {
        this.sapiAccountRepository.checkUserFaceId(sapiCallback, str, map);
    }

    public void dynamicPwdLogin(DynamicPwdLoginCallback dynamicPwdLoginCallback, String str, String str2) {
        dynamicPwdLogin(dynamicPwdLoginCallback, str, str2, (Map<String, String>) null);
    }

    public void extendSysWebViewMethodCheck(SapiCallback<SapiResult> sapiCallback, String str, String str2) {
        this.sapiAccountRepository.extendSysWebViewMethodCheck(sapiCallback, str, str2);
    }

    public boolean fastRegDynamicPwdLogin(SapiCallBack<SapiAccountResponse> sapiCallBack, String str, String str2) {
        return this.sapiAccountRepository.dynamicPwdLogin(sapiCallBack, str, str2, false);
    }

    public void fillUsername(FillUsernameCallback fillUsernameCallback, String str, String str2) {
        this.sapiAccountRepository.fillUsername(fillUsernameCallback, str, str2);
    }

    public void generateSsoHash(SsoHashCallback ssoHashCallback, String str, String str2) {
        this.sapiAccountRepository.generateSsoHash(ssoHashCallback, str, str2);
    }

    public void getDynamicPwd(DynamicPwdWithAuthCallback dynamicPwdWithAuthCallback, String str, boolean z) {
        EnhancedService.getInstance(this.configuration, "9.7.5").getDynamicPwd(dynamicPwdWithAuthCallback, str, z);
    }

    public void getOnlineAppShareModel(List<GetOnlineRequestShareModel> list, String str, GetOnlineAppCallback getOnlineAppCallback) {
        this.sapiAccountRepository.getOnlineAppShareModel(list, str, getOnlineAppCallback);
    }

    public void getPopularPortraitsInfo(GetPopularPortraitsCallback getPopularPortraitsCallback, String str, PortraitCategory portraitCategory) {
        new PortraitService(this.configuration, "9.7.5").getPopularPortraitsInfo(getPopularPortraitsCallback, str, portraitCategory);
    }

    public Map<String, String> getTplStoken(GetTplStokenCallback getTplStokenCallback, String str, List<String> list) {
        return getTplStoken(getTplStokenCallback, str, list, true);
    }

    public void getUserInfo(GetUserInfoCallback getUserInfoCallback, String str, String str2) {
        this.sapiAccountRepository.getUserInfo(getUserInfoCallback, str, str2);
    }

    public void oauth(SapiCallback<OAuthResult> sapiCallback, String str, String str2) {
        this.sapiAccountRepository.oauth(sapiCallback, str, str2, null);
    }

    public void qrAppLogin(SapiCallback<QrAppLoginResult> sapiCallback, String str, String str2) {
        QrCodeService.getInstance(this.configuration, "9.7.5").qrAppLogin(sapiCallback, str, str2);
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountService
    public boolean webLogin(Context context, String str, String str2) {
        return webLogin(context, str);
    }

    public void dynamicPwdLogin(DynamicPwdLoginCallback dynamicPwdLoginCallback, String str, String str2, Map<String, String> map) {
        EnhancedService.getInstance(this.configuration, "9.7.5").dynamicPwdLogin(dynamicPwdLoginCallback, str, str2, map);
    }

    public void faceLoginSwitch(SapiCallback<SapiResult> sapiCallback, String str, boolean z, String str2) {
        this.sapiAccountRepository.faceLoginSwitch(sapiCallback, str, z, str2);
    }

    public void getDynamicPwd(GetDynamicPwdCallback getDynamicPwdCallback, String str, String str2, Map<String, String> map) {
        EnhancedService.getInstance(this.configuration, "9.7.5").getDynamicPwd(getDynamicPwdCallback, str, str2, map);
    }

    public void getQrCodeLoginWithEncuidImage(SapiCallback<GetQrCodeImageResult> sapiCallback, GetQrCodeImageDTO getQrCodeImageDTO, String str, String str2) {
        QrCodeService.getInstance(this.configuration, "9.7.5").getQrCodeLoginWithEnuidImage(sapiCallback, getQrCodeImageDTO, str, str2);
    }

    public void getShareV3App(String str, List<String> list, String str2, GetShareV3AppCallback getShareV3AppCallback) {
        this.sapiAccountRepository.getShareV3App(str, list, str2, getShareV3AppCallback);
    }

    public Map<String, String> getTplStoken(GetTplStokenCallback getTplStokenCallback, String str, List<String> list, boolean z) {
        return this.sapiAccountRepository.getTplStoken(getTplStokenCallback, str, list, z);
    }

    public void getUserInfo(GetUserInfoCallback getUserInfoCallback, String str, String str2, String str3) {
        this.sapiAccountRepository.getUserInfo(getUserInfoCallback, str, str2, str3);
    }

    public void loadOneKeyLogin(OneKeyLoginCallback oneKeyLoginCallback, String str, String str2, LoadExternalWebViewActivityCallback loadExternalWebViewActivityCallback) {
        loadOneKeyLogin(oneKeyLoginCallback, str, str2, true, loadExternalWebViewActivityCallback);
    }

    public void loginWithUCAuth(String str, String str2, String str3, LoginWithUCAuthCallback loginWithUCAuthCallback) {
        this.sapiAccountRepository.loginWithUCAuth(str, str2, str3, loginWithUCAuthCallback);
    }

    public void oauthAccessToken(SapiCallback<OAuthResult> sapiCallback, String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && sapiCallback != null) {
            if (z) {
                this.sapiAccountRepository.oauth(sapiCallback, str, str2, null);
            } else {
                this.sapiAccountRepository.oauthAccessToken(sapiCallback, str, str2);
            }
        }
    }

    public void oauthWithScope(SapiCallback<OAuthResult> sapiCallback, String str, String str2, String str3) {
        this.sapiAccountRepository.oauth(sapiCallback, str, str2, str3);
    }

    @Deprecated
    public void setPortrait(SetPortraitCallback setPortraitCallback, String str, byte[] bArr, String str2) {
        SetPortraitDTO setPortraitDTO = new SetPortraitDTO();
        setPortraitDTO.bduss = str;
        setPortraitDTO.file = bArr;
        setPortraitDTO.contentType = str2;
        setPortrait(setPortraitDTO, setPortraitCallback);
    }

    public void dynamicPwdLogin(DynamicPwdWithAuthCallback dynamicPwdWithAuthCallback, String str, String str2, boolean z) {
        EnhancedService.getInstance(this.configuration, "9.7.5").dynamicPwdLogin(dynamicPwdWithAuthCallback, str, str2, z);
    }

    @Deprecated
    public void dynamicPwdLogin(SapiCallback<DynamicPwdLoginResult> sapiCallback, String str, String str2) {
        EnhancedService.getInstance(this.configuration, "9.7.5").dynamicPwdLogin(sapiCallback, str, str2, (Map) null);
    }

    public void getDynamicPwd(GetDynamicPwdCallback getDynamicPwdCallback, String str, String str2) {
        getDynamicPwd(getDynamicPwdCallback, str, str2, null);
    }

    public void getUserInfo(String str, String str2, NetCallback netCallback) {
        this.sapiAccountRepository.getUserInfo(str, str2, "", "", netCallback);
    }

    @Deprecated
    public boolean dynamicPwdLogin(SapiCallBack<SapiAccountResponse> sapiCallBack, String str, String str2) {
        return this.sapiAccountRepository.dynamicPwdLogin(sapiCallBack, str, str2, true);
    }

    public String getAuthRequestParams() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("tpl", this.configuration.tpl));
        arrayList.add(new PassNameValuePair("clientfrom", "native"));
        arrayList.add(new PassNameValuePair(CommandUBCHelper.COMMAND_UBC_STATISTICS_SOURCE_VALUE_CLIENT, "android"));
        arrayList.add(new PassNameValuePair("adapter", "3"));
        arrayList.add(new PassNameValuePair("skin", ""));
        arrayList.add(new PassNameValuePair("liveAbility", "1"));
        arrayList.add(new PassNameValuePair("suppcheck", "1"));
        return SapiUtils.createRequestParams(arrayList);
    }

    public String getRealnameAuthenticateUrl() {
        ArrayList arrayList;
        SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
        String str = sapiConfiguration.environment.getWap() + "/wp/";
        new ArrayList().add(new PassNameValuePair("appid", sapiConfiguration.appId));
        SapiUtils.getClientId(sapiConfiguration.context);
        return str + "?" + getRequestParams() + "&" + SapiUtils.createRequestParams(arrayList);
    }

    public String getAuthRequestParams(boolean z) {
        String str;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("clientfrom", "native"));
        if (z) {
            arrayList.add(new PassNameValuePair("tpl", "tspd_trade"));
        } else {
            arrayList.add(new PassNameValuePair("tpl", this.configuration.tpl));
        }
        arrayList.add(new PassNameValuePair("login_share_strategy", this.configuration.loginShareStrategy().getStrValue()));
        arrayList.add(new PassNameValuePair(CommandUBCHelper.COMMAND_UBC_STATISTICS_SOURCE_VALUE_CLIENT, "android"));
        if (this.configuration.showBottomBack) {
            arrayList.add(new PassNameValuePair("adapter", "8"));
        } else {
            if (this.configuration.customActionBarEnabled) {
                str = "3";
            } else {
                str = "";
            }
            arrayList.add(new PassNameValuePair("adapter", str));
        }
        arrayList.add(new PassNameValuePair("t", String.valueOf(System.currentTimeMillis())));
        arrayList.add(new PassNameValuePair("act", this.configuration.socialBindType.getName()));
        arrayList.add(new PassNameValuePair("hideExtraEntry", String.valueOf(this.configuration.smsLoginConfig.flagHideExtraEntry.ordinal())));
        arrayList.add(new PassNameValuePair("loginLink", String.valueOf(this.configuration.smsLoginConfig.flagShowLoginLink.ordinal())));
        arrayList.add(new PassNameValuePair("smsLoginLink", String.valueOf(this.configuration.smsLoginConfig.flagShowSmsLoginLink.ordinal())));
        arrayList.add(new PassNameValuePair("lPFastRegLink", String.valueOf(this.configuration.smsLoginConfig.flagShowFastRegLink.ordinal())));
        arrayList.add(new PassNameValuePair("lPlayout", String.valueOf(this.configuration.configurableViewLayout.ordinal())));
        if (this.configuration.uniteVerify) {
            arrayList.add(new PassNameValuePair(ExceptionCode.CONNECT, "1"));
        }
        if (this.configuration.language == Language.ENGLISH) {
            arrayList.add(new PassNameValuePair(WebvttCueParser.TAG_LANG, "en"));
        }
        arrayList.add(new PassNameValuePair("suppcheck", "1"));
        if (this.configuration.supportFaceLogin) {
            arrayList.add(new PassNameValuePair("scanface", "1"));
            arrayList.add(new PassNameValuePair("liveAbility", "1"));
        }
        if (this.configuration.disableVoiceVerify) {
            arrayList.add(new PassNameValuePair("disable_voice_vcode", "1"));
        }
        return SapiUtils.createRequestParams(arrayList);
    }

    public String getRequestParams(boolean z) {
        String str;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("clientfrom", "native"));
        arrayList.add(new PassNameValuePair("tpl", this.configuration.tpl));
        arrayList.add(new PassNameValuePair("login_share_strategy", this.configuration.loginShareStrategy().getStrValue()));
        arrayList.add(new PassNameValuePair(CommandUBCHelper.COMMAND_UBC_STATISTICS_SOURCE_VALUE_CLIENT, "android"));
        if (this.configuration.showBottomBack) {
            arrayList.add(new PassNameValuePair("adapter", "8"));
        } else if (z) {
            if (this.configuration.customActionBarEnabled) {
                str = "3";
            } else {
                str = "";
            }
            arrayList.add(new PassNameValuePair("adapter", str));
        }
        arrayList.add(new PassNameValuePair("t", String.valueOf(System.currentTimeMillis())));
        arrayList.add(new PassNameValuePair("act", this.configuration.socialBindType.getName()));
        arrayList.add(new PassNameValuePair("hideExtraEntry", String.valueOf(this.configuration.smsLoginConfig.flagHideExtraEntry.ordinal())));
        arrayList.add(new PassNameValuePair("loginLink", String.valueOf(this.configuration.smsLoginConfig.flagShowLoginLink.ordinal())));
        arrayList.add(new PassNameValuePair("smsLoginLink", String.valueOf(this.configuration.smsLoginConfig.flagShowSmsLoginLink.ordinal())));
        arrayList.add(new PassNameValuePair("lPFastRegLink", String.valueOf(this.configuration.smsLoginConfig.flagShowFastRegLink.ordinal())));
        arrayList.add(new PassNameValuePair("lPlayout", String.valueOf(this.configuration.configurableViewLayout.ordinal())));
        if (this.configuration.uniteVerify) {
            arrayList.add(new PassNameValuePair(ExceptionCode.CONNECT, "1"));
        }
        if (this.configuration.language == Language.ENGLISH) {
            arrayList.add(new PassNameValuePair(WebvttCueParser.TAG_LANG, "en"));
        }
        arrayList.add(new PassNameValuePair("suppcheck", "1"));
        if (this.configuration.supportFaceLogin) {
            arrayList.add(new PassNameValuePair("scanface", "1"));
            arrayList.add(new PassNameValuePair("liveAbility", "1"));
        }
        if (this.configuration.disableVoiceVerify) {
            arrayList.add(new PassNameValuePair("disable_voice_vcode", "1"));
        }
        return SapiUtils.createRequestParams(arrayList);
    }

    public String getBindWidgetUrl(BindWidgetAction bindWidgetAction) {
        if (bindWidgetAction != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new PassNameValuePair("adapter", "3"));
            return this.sapiAccountRepository.getBindWidgetUrl(bindWidgetAction) + "?" + getRequestParams() + "&" + SapiUtils.createRequestParams(arrayList);
        }
        throw new IllegalArgumentException("BindWidgetAction can't be null");
    }

    @Deprecated
    public boolean getDynamicPwd(SapiCallBack<SapiResponse> sapiCallBack, String str) {
        return this.sapiAccountRepository.getDynamicPwd(sapiCallBack, str);
    }

    public boolean isStokenExist(String str, List<String> list) {
        return this.sapiAccountRepository.isStokenExist(str, list);
    }

    public String getForgetPwdUrl() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair(CommandUBCHelper.COMMAND_UBC_STATISTICS_SOURCE_VALUE_CLIENT, "android"));
        arrayList.add(new PassNameValuePair("clientfrom", "native"));
        arrayList.add(new PassNameValuePair("adapter", "3"));
        arrayList.add(new PassNameValuePair(SpeedStatsUtils.UBC_VALUE_BANNER, "1"));
        arrayList.add(new PassNameValuePair("t", String.valueOf(System.currentTimeMillis())));
        return this.sapiAccountRepository.getWapForgetPwdUrl() + "?" + getRequestParams(false) + "&" + SapiUtils.createRequestParams(arrayList);
    }

    public String getNormalizeGuestAccountUrl(SocialType socialType) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("type", socialType.getName()));
        arrayList.add(new PassNameValuePair("ostype", String.valueOf(socialType.getType())));
        return this.sapiAccountRepository.getNormalizeGuestAccountUrl() + "?" + getRequestParams() + "&" + SapiUtils.createRequestParams(arrayList);
    }

    public void getOneKeyLoginIsAvailable(final GetOneKeyLoginStateDTO getOneKeyLoginStateDTO, final OneKeyLoginCallback oneKeyLoginCallback) {
        if (oneKeyLoginCallback == null) {
            Log.e(TAG, "When check oneKeyLogin's ability, oneKeyLoginCallback can't be null!");
        } else if (Build.VERSION.SDK_INT < 19) {
            OneKeyLoginSdkCall.getInstance().preGetPhoneFail(oneKeyLoginCallback, -109, null);
        } else {
            OneKeyLoginOptResult preLoginOptResult = OneKeyLoginSdkCall.getInstance().getPreLoginOptResult();
            if (preLoginOptResult != null && !TextUtils.isEmpty(preLoginOptResult.getSecurityPhone())) {
                this.sapiAccountRepository.checkOneKeyLoginIsAvailable(oneKeyLoginCallback, preLoginOptResult.getSecurityPhone(), getOneKeyLoginStateDTO.connectTimeout);
            } else {
                OneKeyLoginSdkCall.getInstance().preGetPhoneInfo(this.configuration.context, OneKeyLoginSdkCall.OKL_SCENE_SAPI, getOneKeyLoginStateDTO.connectTimeout, false, new OneKeyLoginOptCallback() { // from class: com.baidu.sapi2.SapiAccountService.2
                    @Override // com.baidu.sapi2.callback.inner.OneKeyLoginOptCallback
                    public void onFinish(OneKeyLoginOptResult oneKeyLoginOptResult) {
                        if (oneKeyLoginOptResult == null) {
                            OneKeyLoginSdkCall.getInstance().preGetPhoneFail(oneKeyLoginCallback, -100, null);
                        } else if (TextUtils.isEmpty(oneKeyLoginOptResult.getSecurityPhone())) {
                            OneKeyLoginSdkCall.getInstance().preGetPhoneFail(oneKeyLoginCallback, oneKeyLoginOptResult.getCode(), oneKeyLoginOptResult.getSubCode(), null);
                        } else {
                            SapiAccountService.this.sapiAccountRepository.checkOneKeyLoginIsAvailable(oneKeyLoginCallback, oneKeyLoginOptResult.getSecurityPhone(), getOneKeyLoginStateDTO.connectTimeout);
                        }
                    }
                });
            }
        }
    }

    public String getUniteVerifyUrl() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PassNameValuePair("adapter", "3"));
        return this.sapiAccountRepository.getUniteVerifyUrl() + "?" + getRequestParams() + "&" + SapiUtils.createRequestParams(arrayList);
    }

    public void getUserAttrInfo(String str, String str2, String str3, String str4, GetUserAttrInfoCallback getUserAttrInfoCallback) {
        this.sapiAccountRepository.getUserAttrInfo(str, str2, str3, str4, getUserAttrInfoCallback);
    }

    public void loadOneKeyLogin(OneKeyLoginCallback oneKeyLoginCallback, String str, String str2, boolean z, LoadExternalWebViewActivityCallback loadExternalWebViewActivityCallback) {
        this.sapiAccountRepository.loadOneKeyLogin(oneKeyLoginCallback, str, str2, z, loadExternalWebViewActivityCallback);
    }

    public void preGetPhoneInfo(Context context, String str, int i, boolean z, OneKeyLoginOptCallback oneKeyLoginOptCallback) {
        OneKeyLoginSdkCall.getInstance().preGetPhoneInfo(context, str, i, z, oneKeyLoginOptCallback);
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountService
    public boolean webLogin(final Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("pp");
            SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() { // from class: com.baidu.sapi2.SapiAccountService.1
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
                    SapiAccountService.asyncStoken2Web(context, getTplStokenResult.tplStokenMap.get("pp"));
                }
            }, str, arrayList);
            SapiAccount accountFromBduss = SapiContext.getInstance().getAccountFromBduss(str);
            if (accountFromBduss != null) {
                return asyncBduss2Web(context, accountFromBduss.bduss, accountFromBduss.ptoken);
            }
            return asyncBduss2Web(context, str, null);
        }
        return false;
    }
}
