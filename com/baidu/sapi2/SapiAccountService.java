package com.baidu.sapi2;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
import com.baidu.sapi2.callback.NetCallback;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.callback.QrLoginStatusCheckCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.callback.SetPopularPortraitCallback;
import com.baidu.sapi2.callback.SetPortraitCallback;
import com.baidu.sapi2.callback.SsoHashCallback;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.callback.inner.GetShareV3AppCallback;
import com.baidu.sapi2.callback.inner.LoadExternalWebViewActivityCallback;
import com.baidu.sapi2.callback.inner.OneKeyLoginOptCallback;
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
import com.baidu.sapi2.service.interfaces.ISAccountService;
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
import com.baidu.sapi2.utils.enums.Language;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class SapiAccountService implements ISAccountService {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BUSINESS_FROM_ONE_KEY_LOGIN = "business_from_one_key_login";
    public static final String DISPLAY_TYPE_NATIVE = "native";
    public static final String TAG = "SapiAccountService";
    public transient /* synthetic */ FieldHolder $fh;
    public SapiConfiguration configuration;
    public SapiAccountRepository sapiAccountRepository;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-379239814, "Lcom/baidu/sapi2/SapiAccountService;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-379239814, "Lcom/baidu/sapi2/SapiAccountService;");
        }
    }

    public SapiAccountService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.configuration = SapiAccountManager.getInstance().getSapiConfiguration();
        this.sapiAccountRepository = new SapiAccountRepository();
    }

    private boolean asyncBduss2Web(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, this, context, str, str2)) == null) {
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
        return invokeLLL.booleanValue;
    }

    public static boolean asyncStoken2Web(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
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
        return invokeLL.booleanValue;
    }

    private void authorizeOneKeyLoginSuccess(OneKeyLoginCallback oneKeyLoginCallback, AccountType accountType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, this, oneKeyLoginCallback, accountType) == null) {
            OneKeyLoginResult oneKeyLoginResult = new OneKeyLoginResult();
            oneKeyLoginResult.setResultCode(0);
            oneKeyLoginCallback.onSuccess(oneKeyLoginResult);
        }
    }

    private SapiAccount sapiAccountResponseToAccount(SapiAccountResponse sapiAccountResponse) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, sapiAccountResponse)) == null) {
            SapiAccount sapiAccount = new SapiAccount();
            sapiAccount.uid = sapiAccountResponse.uid;
            sapiAccount.bduss = sapiAccountResponse.bduss;
            sapiAccount.displayname = sapiAccountResponse.displayname;
            sapiAccount.stoken = sapiAccountResponse.stoken;
            sapiAccount.ptoken = sapiAccountResponse.ptoken;
            sapiAccount.email = sapiAccountResponse.email;
            sapiAccount.username = sapiAccountResponse.username;
            sapiAccount.app = TextUtils.isEmpty(sapiAccountResponse.app) ? SapiUtils.getAppName(this.configuration.context) : sapiAccountResponse.app;
            sapiAccount.extra = sapiAccountResponse.extra;
            sapiAccount.fromType = sapiAccountResponse.fromType.getValue();
            if (SocialType.UNKNOWN != sapiAccountResponse.socialType) {
                SapiContext.getInstance().put(SapiContext.KEY_PRE_LOGIN_TYPE, sapiAccountResponse.socialType.getName());
                sapiAccount.addSocialInfo(sapiAccountResponse.socialType, sapiAccountResponse.socialPortraitUrl, sapiAccountResponse.socialNickname);
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
        return (SapiAccount) invokeL.objValue;
    }

    public void cancelRequest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.sapiAccountRepository.cancelRequest();
        }
    }

    public void checkFaceLoginStatus(SapiCallback<FaceLoginStatusResult> sapiCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sapiCallback, str) == null) {
            this.sapiAccountRepository.checkFaceLoginStatus(sapiCallback, str);
        }
    }

    public void checkUserFaceId(SapiCallback<CheckUserFaceIdResult> sapiCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, sapiCallback, str) == null) {
            this.sapiAccountRepository.checkUserFaceId(sapiCallback, str, null);
        }
    }

    @Deprecated
    public boolean dynamicPwdLogin(SapiCallBack<SapiAccountResponse> sapiCallBack, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048583, this, sapiCallBack, str, str2)) == null) ? this.sapiAccountRepository.dynamicPwdLogin(sapiCallBack, str, str2, true) : invokeLLL.booleanValue;
    }

    public void extendSysWebViewMethodCheck(SapiCallback<SapiResult> sapiCallback, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sapiCallback, str, str2) == null) {
            this.sapiAccountRepository.extendSysWebViewMethodCheck(sapiCallback, str, str2);
        }
    }

    public void faceLoginSwitch(SapiCallback<SapiResult> sapiCallback, String str, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{sapiCallback, str, Boolean.valueOf(z), str2}) == null) {
            this.sapiAccountRepository.faceLoginSwitch(sapiCallback, str, z, str2);
        }
    }

    public boolean fastRegDynamicPwdLogin(SapiCallBack<SapiAccountResponse> sapiCallBack, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, sapiCallBack, str, str2)) == null) ? this.sapiAccountRepository.dynamicPwdLogin(sapiCallBack, str, str2, false) : invokeLLL.booleanValue;
    }

    public void fillUsername(FillUsernameCallback fillUsernameCallback, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, fillUsernameCallback, str, str2) == null) {
            this.sapiAccountRepository.fillUsername(fillUsernameCallback, str, str2);
        }
    }

    public void generateSsoHash(SsoHashCallback ssoHashCallback, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, ssoHashCallback, str, str2) == null) {
            this.sapiAccountRepository.generateSsoHash(ssoHashCallback, str, str2);
        }
    }

    public String getAccountCenterUrl(String str) {
        InterceptResult invokeL;
        String acccountCenterUrl;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new PassNameValuePair("adapter", "3"));
            arrayList.add(new PassNameValuePair("wapsec", "center"));
            if (this.configuration.accountCenterRealAutnen) {
                arrayList.add(new PassNameValuePair("realName", "1"));
            } else {
                arrayList.add(new PassNameValuePair("realName", "0"));
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
        return (String) invokeL.objValue;
    }

    public String getAddressManageUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.sapiAccountRepository.getContactAddressUrl() + "?" + getRequestParams();
        }
        return (String) invokeV.objValue;
    }

    public String getAuthRequestParams(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048591, this, z)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new PassNameValuePair("clientfrom", "native"));
            if (z) {
                arrayList.add(new PassNameValuePair("tpl", "tspd_trade"));
            } else {
                arrayList.add(new PassNameValuePair("tpl", this.configuration.tpl));
            }
            arrayList.add(new PassNameValuePair("login_share_strategy", this.configuration.loginShareStrategy().getStrValue()));
            arrayList.add(new PassNameValuePair("client", "android"));
            if (this.configuration.showBottomBack) {
                arrayList.add(new PassNameValuePair("adapter", "8"));
            } else {
                arrayList.add(new PassNameValuePair("adapter", this.configuration.customActionBarEnabled ? "3" : ""));
            }
            arrayList.add(new PassNameValuePair("t", String.valueOf(System.currentTimeMillis())));
            arrayList.add(new PassNameValuePair("act", this.configuration.socialBindType.getName()));
            arrayList.add(new PassNameValuePair("hideExtraEntry", String.valueOf(this.configuration.smsLoginConfig.flagHideExtraEntry.ordinal())));
            arrayList.add(new PassNameValuePair("loginLink", String.valueOf(this.configuration.smsLoginConfig.flagShowLoginLink.ordinal())));
            arrayList.add(new PassNameValuePair("smsLoginLink", String.valueOf(this.configuration.smsLoginConfig.flagShowSmsLoginLink.ordinal())));
            arrayList.add(new PassNameValuePair("lPFastRegLink", String.valueOf(this.configuration.smsLoginConfig.flagShowFastRegLink.ordinal())));
            arrayList.add(new PassNameValuePair("lPlayout", String.valueOf(this.configuration.configurableViewLayout.ordinal())));
            if (this.configuration.uniteVerify) {
                arrayList.add(new PassNameValuePair("connect", "1"));
            }
            if (this.configuration.language == Language.ENGLISH) {
                arrayList.add(new PassNameValuePair("lang", "en"));
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
        return (String) invokeZ.objValue;
    }

    public String getAuthWidgetUrl(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048592, this, z)) == null) {
            return this.sapiAccountRepository.getAuthWidgetUrl() + "?" + getAuthRequestParams(z);
        }
        return (String) invokeZ.objValue;
    }

    public int getBdussState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? new OpenBdussService(this.configuration, "9.3.7.1").getBdussState() : invokeV.intValue;
    }

    public String getBindWidgetUrl(BindWidgetAction bindWidgetAction) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, bindWidgetAction)) == null) {
            if (bindWidgetAction != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new PassNameValuePair("adapter", "3"));
                return this.sapiAccountRepository.getBindWidgetUrl(bindWidgetAction) + "?" + getRequestParams() + "&" + SapiUtils.createRequestParams(arrayList);
            }
            throw new IllegalArgumentException("BindWidgetAction can't be null");
        }
        return (String) invokeL.objValue;
    }

    public void getCaptcha(SapiCallback<GetCaptchaResult> sapiCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, sapiCallback) == null) {
            EnhancedService.getInstance(this.configuration, "9.3.7.1").getCaptcha(sapiCallback);
        }
    }

    public String getCaptchaKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? EnhancedService.getInstance(this.configuration, "9.3.7.1").getCaptchaKey() : (String) invokeV.objValue;
    }

    public String getChildVerifyUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.sapiAccountRepository.getChildVerifyUrl() + "?" + getRequestParams();
        }
        return (String) invokeV.objValue;
    }

    public void getContacts(GetContactsCallback getContactsCallback, GetContactsDTO getContactsDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, getContactsCallback, getContactsDTO) == null) {
            GetContactsService.getInstance(this.configuration, "9.3.7.1").getContacts(getContactsCallback, getContactsDTO);
        }
    }

    @Deprecated
    public boolean getDynamicPwd(SapiCallBack<SapiResponse> sapiCallBack, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048602, this, sapiCallBack, str)) == null) ? this.sapiAccountRepository.getDynamicPwd(sapiCallBack, str) : invokeLL.booleanValue;
    }

    public String getExplainCameraDeatilUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.sapiAccountRepository.getExplainCameraDeatilUrl() + "?" + getRequestParams();
        }
        return (String) invokeV.objValue;
    }

    public String getForgetPwdUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new PassNameValuePair("client", "android"));
            arrayList.add(new PassNameValuePair("clientfrom", "native"));
            arrayList.add(new PassNameValuePair("adapter", "3"));
            arrayList.add(new PassNameValuePair("banner", "1"));
            arrayList.add(new PassNameValuePair("t", String.valueOf(System.currentTimeMillis())));
            return this.sapiAccountRepository.getWapForgetPwdUrl() + "?" + getRequestParams(false) + "&" + SapiUtils.createRequestParams(arrayList);
        }
        return (String) invokeV.objValue;
    }

    public void getHistoryPortraits(GetHistoryPortraitsCallback getHistoryPortraitsCallback, GetHistoryPortraitsDTO getHistoryPortraitsDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, getHistoryPortraitsCallback, getHistoryPortraitsDTO) == null) {
            new PortraitService(this.configuration, "9.3.7.1").getHistoryPortraits(getHistoryPortraitsCallback, getHistoryPortraitsDTO);
        }
    }

    public String getInvoiceBuildUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.sapiAccountRepository.getInvoiceAddressUrl() + "?" + getRequestParams(true);
        }
        return (String) invokeV.objValue;
    }

    public String getLoginUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.sapiAccountRepository.getWapLoginUrl() + "?" + getRequestParams();
        }
        return (String) invokeV.objValue;
    }

    public String getNormalizeGuestAccountUrl(SocialType socialType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, socialType)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new PassNameValuePair("type", socialType.getName()));
            arrayList.add(new PassNameValuePair("ostype", String.valueOf(socialType.getType())));
            return this.sapiAccountRepository.getNormalizeGuestAccountUrl() + "?" + getRequestParams() + "&" + SapiUtils.createRequestParams(arrayList);
        }
        return (String) invokeL.objValue;
    }

    public void getOneKeyLoginIsAvailable(GetOneKeyLoginStateDTO getOneKeyLoginStateDTO, OneKeyLoginCallback oneKeyLoginCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048609, this, getOneKeyLoginStateDTO, oneKeyLoginCallback) == null) {
            if (oneKeyLoginCallback == null) {
                Log.e(TAG, "When check oneKeyLogin's ability, oneKeyLoginCallback can't be null!");
            } else if (Build.VERSION.SDK_INT < 19) {
                OneKeyLoginSdkCall.getInstance().preGetPhoneFail(oneKeyLoginCallback, -109, null);
            } else {
                OneKeyLoginOptResult preLoginOptResult = OneKeyLoginSdkCall.getInstance().getPreLoginOptResult();
                if (preLoginOptResult != null && !TextUtils.isEmpty(preLoginOptResult.getSecurityPhone())) {
                    this.sapiAccountRepository.checkOneKeyLoginIsAvailable(oneKeyLoginCallback, preLoginOptResult.getSecurityPhone(), getOneKeyLoginStateDTO.connectTimeout);
                } else {
                    OneKeyLoginSdkCall.getInstance().preGetPhoneInfo(this.configuration, OneKeyLoginSdkCall.OKL_SCENE_SAPI, getOneKeyLoginStateDTO.connectTimeout, new OneKeyLoginOptCallback(this, oneKeyLoginCallback, getOneKeyLoginStateDTO) { // from class: com.baidu.sapi2.SapiAccountService.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ SapiAccountService this$0;
                        public final /* synthetic */ OneKeyLoginCallback val$callback;
                        public final /* synthetic */ GetOneKeyLoginStateDTO val$dto;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, oneKeyLoginCallback, getOneKeyLoginStateDTO};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$callback = oneKeyLoginCallback;
                            this.val$dto = getOneKeyLoginStateDTO;
                        }

                        @Override // com.baidu.sapi2.callback.inner.OneKeyLoginOptCallback
                        public void onFinish(OneKeyLoginOptResult oneKeyLoginOptResult) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, oneKeyLoginOptResult) == null) {
                                if (oneKeyLoginOptResult == null) {
                                    OneKeyLoginSdkCall.getInstance().preGetPhoneFail(this.val$callback, -100, null);
                                } else if (TextUtils.isEmpty(oneKeyLoginOptResult.getSecurityPhone())) {
                                    OneKeyLoginSdkCall.getInstance().preGetPhoneFail(this.val$callback, oneKeyLoginOptResult.getCode(), oneKeyLoginOptResult.getSubCode(), null);
                                } else {
                                    this.this$0.sapiAccountRepository.checkOneKeyLoginIsAvailable(this.val$callback, oneKeyLoginOptResult.getSecurityPhone(), this.val$dto.connectTimeout);
                                }
                            }
                        }
                    });
                }
            }
        }
    }

    public void getOneKeyLoginToken(OneKeyLoginSdkCall.TokenListener tokenListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, tokenListener) == null) {
            new OneKeyLoginSdkCall().getToken(this.configuration, tokenListener);
        }
    }

    public void getOpenBduss(GetOpenBdussDTO getOpenBdussDTO, GetOpenBdussCallback getOpenBdussCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, getOpenBdussDTO, getOpenBdussCallback) == null) {
            new OpenBdussService(this.configuration, "9.3.7.1").getOpenBduss(getOpenBdussDTO, getOpenBdussCallback);
        }
    }

    public JSONObject getPhoneNumAndOperatorType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? new OneKeyLoginSdkCall().getEncryptPhone() : (JSONObject) invokeV.objValue;
    }

    public void getPopularPortraitsInfo(GetPopularPortraitsCallback getPopularPortraitsCallback, String str, PortraitCategory portraitCategory) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048614, this, getPopularPortraitsCallback, str, portraitCategory) == null) {
            new PortraitService(this.configuration, "9.3.7.1").getPopularPortraitsInfo(getPopularPortraitsCallback, str, portraitCategory);
        }
    }

    public void getQrCodeImage(SapiCallback<GetQrCodeImageResult> sapiCallback, GetQrCodeImageDTO getQrCodeImageDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048615, this, sapiCallback, getQrCodeImageDTO) == null) {
            QrCodeService.getInstance(this.configuration, "9.3.7.1").getQrCodeImage(sapiCallback, getQrCodeImageDTO);
        }
    }

    public void getQrCodeLoginWithEncuidImage(SapiCallback<GetQrCodeImageResult> sapiCallback, GetQrCodeImageDTO getQrCodeImageDTO, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048616, this, sapiCallback, getQrCodeImageDTO, str, str2) == null) {
            QrCodeService.getInstance(this.configuration, "9.3.7.1").getQrCodeLoginWithEnuidImage(sapiCallback, getQrCodeImageDTO, str, str2);
        }
    }

    public String getRealnameAuthenticateUrl() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            SapiConfiguration sapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
            String str = sapiConfiguration.environment.getWap() + "/wp/";
            new ArrayList().add(new PassNameValuePair("appid", sapiConfiguration.appId));
            SapiUtils.getClientId(sapiConfiguration.context);
            return str + "?" + getRequestParams() + "&" + SapiUtils.createRequestParams(arrayList);
        }
        return (String) invokeV.objValue;
    }

    public String getRequestParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? getRequestParams(true) : (String) invokeV.objValue;
    }

    public void getShareV3App(String str, List<String> list, String str2, GetShareV3AppCallback getShareV3AppCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048620, this, str, list, str2, getShareV3AppCallback) == null) {
            this.sapiAccountRepository.getShareV3App(str, list, str2, getShareV3AppCallback);
        }
    }

    public String getSwitchAccountUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.sapiAccountRepository.getSwitchAccountUrl() + "?" + getRequestParams();
        }
        return (String) invokeV.objValue;
    }

    public Map<String, String> getTplStoken(GetTplStokenCallback getTplStokenCallback, String str, List<String> list) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048622, this, getTplStokenCallback, str, list)) == null) ? getTplStoken(getTplStokenCallback, str, list, true) : (Map) invokeLLL.objValue;
    }

    public String getUniteVerifyUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new PassNameValuePair("adapter", "3"));
            return this.sapiAccountRepository.getUniteVerifyUrl() + "?" + getRequestParams() + "&" + SapiUtils.createRequestParams(arrayList);
        }
        return (String) invokeV.objValue;
    }

    public String getUrlAfterAuth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.sapiAccountRepository.getDomainAfterAuth() : (String) invokeV.objValue;
    }

    public String getUrlFinishBind() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.sapiAccountRepository.getDomainFinishBind() : (String) invokeV.objValue;
    }

    public String getUrlSSOFinish() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.sapiAccountRepository.getDomainSSOFinish() : (String) invokeV.objValue;
    }

    public void getUserInfo(GetUserInfoCallback getUserInfoCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048628, this, getUserInfoCallback, str) == null) {
            this.sapiAccountRepository.getUserInfo(getUserInfoCallback, str);
        }
    }

    public String getWapShareLoginUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.sapiAccountRepository.getWapShareLoginUrl() + "?" + getRequestParams();
        }
        return (String) invokeV.objValue;
    }

    public void handleOneKeyLoginResult(OneKeyLoginCallback oneKeyLoginCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048631, this, oneKeyLoginCallback, str) == null) {
            SapiAccountResponse parseAccountXmlToResponse = SapiCoreUtil.parseAccountXmlToResponse("business_from_one_key_login", str);
            if (parseAccountXmlToResponse != null) {
                SapiAccountManager.getInstance().validate(sapiAccountResponseToAccount(parseAccountXmlToResponse));
                authorizeOneKeyLoginSuccess(oneKeyLoginCallback, parseAccountXmlToResponse.accountType);
                return;
            }
            new OneKeyLoginSdkCall().loadOneKeyLoginFail(oneKeyLoginCallback, -103, null);
        }
    }

    public void iqiyiSSOLogin(IqiyiLoginCallback iqiyiLoginCallback, IqiyiLoginDTO iqiyiLoginDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048632, this, iqiyiLoginCallback, iqiyiLoginDTO) == null) {
            this.sapiAccountRepository.iqiyiSSOLogin(iqiyiLoginCallback, iqiyiLoginDTO);
        }
    }

    public boolean isStokenExist(String str, List<String> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048634, this, str, list)) == null) ? this.sapiAccountRepository.isStokenExist(str, list) : invokeLL.booleanValue;
    }

    public void loadOneKeyLogin(OneKeyLoginCallback oneKeyLoginCallback, String str, String str2, LoadExternalWebViewActivityCallback loadExternalWebViewActivityCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048635, this, oneKeyLoginCallback, str, str2, loadExternalWebViewActivityCallback) == null) {
            this.sapiAccountRepository.loadOneKeyLogin(oneKeyLoginCallback, str, str2, loadExternalWebViewActivityCallback);
        }
    }

    @Deprecated
    public void oauth(SapiCallback<OAuthResult> sapiCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048636, this, sapiCallback, str) == null) {
            this.sapiAccountRepository.oauth(sapiCallback, str, null);
        }
    }

    public void oauthAccessToken(SapiCallback<OAuthResult> sapiCallback, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048638, this, new Object[]{sapiCallback, str, str2, Boolean.valueOf(z)}) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || sapiCallback == null) {
            return;
        }
        if (z) {
            this.sapiAccountRepository.oauth(sapiCallback, str, str2);
        } else {
            this.sapiAccountRepository.oauthAccessToken(sapiCallback, str, str2);
        }
    }

    public void preGetPhoneInfo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            new OneKeyLoginSdkCall().preGetPhoneInfo(this.configuration, "product");
        }
    }

    public void qrAppLogin(SapiCallback<QrAppLoginResult> sapiCallback, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048640, this, sapiCallback, str, str2) == null) {
            QrCodeService.getInstance(this.configuration, "9.3.7.1").qrAppLogin(sapiCallback, str, str2);
        }
    }

    public void qrJoinLoginStatusCheck(QrLoginStatusCheckCallback qrLoginStatusCheckCallback, QrLoginStstusCheckDTO qrLoginStstusCheckDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048641, this, qrLoginStatusCheckCallback, qrLoginStstusCheckDTO) == null) {
            qrLoginStstusCheckDTO.isJoinCodeLogin = true;
            QrCodeService.getInstance(this.configuration, "9.3.7.1").qrLoginStatusCheck(qrLoginStatusCheckCallback, qrLoginStstusCheckDTO, true);
        }
    }

    public void qrLoginStatusCheck(QrLoginStatusCheckCallback qrLoginStatusCheckCallback, QrLoginStstusCheckDTO qrLoginStstusCheckDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048642, this, qrLoginStatusCheckCallback, qrLoginStstusCheckDTO) == null) {
            QrCodeService.getInstance(this.configuration, "9.3.7.1").qrLoginStatusCheck(qrLoginStatusCheckCallback, qrLoginStstusCheckDTO, true);
        }
    }

    public void relaseContactsSource() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            GetContactsService.getInstance(this.configuration, "9.3.7.1").relaseContactsSource();
        }
    }

    public void sendContactsSms(SendSmsDTO sendSmsDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, sendSmsDTO) == null) {
            GetContactsService.getInstance(this.configuration, "9.3.7.1").sendSMS(sendSmsDTO);
        }
    }

    public void setCloudShareAccount(int i2, ShareStorage.StorageModel storageModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048645, this, i2, storageModel) == null) {
            this.sapiAccountRepository.setCloudShareAccount(i2, storageModel);
        }
    }

    public void setPopularPortrait(SetPopularPortraitCallback setPopularPortraitCallback, SetPopularPortraitDTO setPopularPortraitDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048646, this, setPopularPortraitCallback, setPopularPortraitDTO) == null) {
            new PortraitService(this.configuration, "9.3.7.1").setPopularPortrait(setPopularPortraitCallback, setPopularPortraitDTO);
        }
    }

    @Deprecated
    public void setPortrait(SetPortraitCallback setPortraitCallback, String str, byte[] bArr, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048647, this, setPortraitCallback, str, bArr, str2) == null) {
            SetPortraitDTO setPortraitDTO = new SetPortraitDTO();
            setPortraitDTO.bduss = str;
            setPortraitDTO.file = bArr;
            setPortraitDTO.contentType = str2;
            setPortrait(setPortraitDTO, setPortraitCallback);
        }
    }

    public void stopQrLoginStatusCheck() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048649, this) == null) {
            QrCodeService.getInstance(this.configuration, "9.3.7.1").stopLoginStatusCheck();
        }
    }

    public void web2NativeLogin(Web2NativeLoginCallback web2NativeLoginCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, web2NativeLoginCallback) == null) {
            this.sapiAccountRepository.web2NativeLogin(web2NativeLoginCallback, true);
        }
    }

    public boolean webLogin(Context context) {
        InterceptResult invokeL;
        SapiAccount currentAccount;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048652, this, context)) == null) {
            if (context == null || (currentAccount = SapiContext.getInstance().getCurrentAccount()) == null) {
                return false;
            }
            return SapiUtils.webLogin(context, currentAccount.bduss, currentAccount.ptoken);
        }
        return invokeL.booleanValue;
    }

    public void checkUserFaceId(SapiCallback<CheckUserFaceIdResult> sapiCallback, String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, sapiCallback, str, map) == null) {
            this.sapiAccountRepository.checkUserFaceId(sapiCallback, str, map);
        }
    }

    @Deprecated
    public void dynamicPwdLogin(SapiCallback<DynamicPwdLoginResult> sapiCallback, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, sapiCallback, str, str2) == null) {
            EnhancedService.getInstance(this.configuration, "9.3.7.1").dynamicPwdLogin(sapiCallback, str, str2, (Map) null);
        }
    }

    @Deprecated
    public void getDynamicPwd(SapiCallback<GetDynamicPwdResult> sapiCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, sapiCallback, str) == null) {
            EnhancedService.getInstance(this.configuration, "9.3.7.1").getDynamicPwd(sapiCallback, str);
        }
    }

    public void getPopularPortraitsInfo(GetPopularPortraitsCallback getPopularPortraitsCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, getPopularPortraitsCallback, str) == null) {
            new PortraitService(this.configuration, "9.3.7.1").getPopularPortraitsInfo(getPopularPortraitsCallback, str, PortraitCategory.NORMAL);
        }
    }

    public String getRequestParams(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048619, this, z)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new PassNameValuePair("clientfrom", "native"));
            arrayList.add(new PassNameValuePair("tpl", this.configuration.tpl));
            arrayList.add(new PassNameValuePair("login_share_strategy", this.configuration.loginShareStrategy().getStrValue()));
            arrayList.add(new PassNameValuePair("client", "android"));
            if (this.configuration.showBottomBack) {
                arrayList.add(new PassNameValuePair("adapter", "8"));
            } else if (z) {
                arrayList.add(new PassNameValuePair("adapter", this.configuration.customActionBarEnabled ? "3" : ""));
            }
            arrayList.add(new PassNameValuePair("t", String.valueOf(System.currentTimeMillis())));
            arrayList.add(new PassNameValuePair("act", this.configuration.socialBindType.getName()));
            arrayList.add(new PassNameValuePair("hideExtraEntry", String.valueOf(this.configuration.smsLoginConfig.flagHideExtraEntry.ordinal())));
            arrayList.add(new PassNameValuePair("loginLink", String.valueOf(this.configuration.smsLoginConfig.flagShowLoginLink.ordinal())));
            arrayList.add(new PassNameValuePair("smsLoginLink", String.valueOf(this.configuration.smsLoginConfig.flagShowSmsLoginLink.ordinal())));
            arrayList.add(new PassNameValuePair("lPFastRegLink", String.valueOf(this.configuration.smsLoginConfig.flagShowFastRegLink.ordinal())));
            arrayList.add(new PassNameValuePair("lPlayout", String.valueOf(this.configuration.configurableViewLayout.ordinal())));
            if (this.configuration.uniteVerify) {
                arrayList.add(new PassNameValuePair("connect", "1"));
            }
            if (this.configuration.language == Language.ENGLISH) {
                arrayList.add(new PassNameValuePair("lang", "en"));
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
        return (String) invokeZ.objValue;
    }

    public Map<String, String> getTplStoken(GetTplStokenCallback getTplStokenCallback, String str, List<String> list, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048623, this, new Object[]{getTplStokenCallback, str, list, Boolean.valueOf(z)})) == null) ? this.sapiAccountRepository.getTplStoken(getTplStokenCallback, str, list, z) : (Map) invokeCommon.objValue;
    }

    public void getUserInfo(String str, String str2, NetCallback netCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048629, this, str, str2, netCallback) == null) {
            this.sapiAccountRepository.getUserInfo(str, str2, netCallback);
        }
    }

    public boolean isStokenExist(SapiAccount sapiAccount, List<String> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048633, this, sapiAccount, list)) == null) ? this.sapiAccountRepository.isAccountStokenExist(sapiAccount, list) : invokeLL.booleanValue;
    }

    public void oauth(SapiCallback<OAuthResult> sapiCallback, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048637, this, sapiCallback, str, str2) == null) {
            this.sapiAccountRepository.oauth(sapiCallback, str, str2);
        }
    }

    public void web2NativeLogin(Web2NativeLoginCallback web2NativeLoginCallback, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048651, this, web2NativeLoginCallback, z) == null) {
            this.sapiAccountRepository.web2NativeLogin(web2NativeLoginCallback, z);
        }
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountService
    public boolean webLogin(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048653, this, context, str)) == null) {
            if (context == null || TextUtils.isEmpty(str)) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add("pp");
            SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback(this, context) { // from class: com.baidu.sapi2.SapiAccountService.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SapiAccountService this$0;
                public final /* synthetic */ Context val$context;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$context = context;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFailure(GetTplStokenResult getTplStokenResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, getTplStokenResult) == null) {
                    }
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFinish() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    }
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onStart() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onSuccess(GetTplStokenResult getTplStokenResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048580, this, getTplStokenResult) == null) {
                        SapiAccountService.asyncStoken2Web(this.val$context, getTplStokenResult.tplStokenMap.get("pp"));
                    }
                }
            }, str, arrayList);
            SapiAccount accountFromBduss = SapiContext.getInstance().getAccountFromBduss(str);
            if (accountFromBduss != null) {
                return asyncBduss2Web(context, accountFromBduss.bduss, accountFromBduss.ptoken);
            }
            return asyncBduss2Web(context, str, null);
        }
        return invokeLL.booleanValue;
    }

    public void dynamicPwdLogin(DynamicPwdLoginCallback dynamicPwdLoginCallback, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, dynamicPwdLoginCallback, str, str2) == null) {
            dynamicPwdLogin(dynamicPwdLoginCallback, str, str2, null);
        }
    }

    public void getDynamicPwd(GetDynamicPwdCallback getDynamicPwdCallback, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048599, this, getDynamicPwdCallback, str, str2) == null) {
            getDynamicPwd(getDynamicPwdCallback, str, str2, null);
        }
    }

    public void dynamicPwdLogin(DynamicPwdLoginCallback dynamicPwdLoginCallback, String str, String str2, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, dynamicPwdLoginCallback, str, str2, map) == null) {
            EnhancedService.getInstance(this.configuration, "9.3.7.1").dynamicPwdLogin(dynamicPwdLoginCallback, str, str2, map);
        }
    }

    public void getDynamicPwd(GetDynamicPwdCallback getDynamicPwdCallback, String str, String str2, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048600, this, getDynamicPwdCallback, str, str2, map) == null) {
            EnhancedService.getInstance(this.configuration, "9.3.7.1").getDynamicPwd(getDynamicPwdCallback, str, str2, map);
        }
    }

    public void setPortrait(SetPortraitDTO setPortraitDTO, SetPortraitCallback setPortraitCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048648, this, setPortraitDTO, setPortraitCallback) == null) {
            new PortraitService(this.configuration, "9.3.7.1").setPortrait(setPortraitDTO, setPortraitCallback);
        }
    }

    @Override // com.baidu.sapi2.service.interfaces.ISAccountService
    public boolean webLogin(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048654, this, context, str, str2)) == null) ? webLogin(context, str) : invokeLLL.booleanValue;
    }
}
