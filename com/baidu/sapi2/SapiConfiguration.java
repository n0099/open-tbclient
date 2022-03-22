package com.baidu.sapi2;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.callback.UbcUploadImplCallback;
import com.baidu.sapi2.share.ShareUtils;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.enums.BindType;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.Language;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.sapi2.utils.enums.Switch;
import com.baidu.sofire.ac.FH;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public final class SapiConfiguration implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BROWSE_MODE_STATE_ONLY = 2;
    public static final int BROWSE_MODE_STATE_USER_AUTHORIZED = 1;
    public static final int BROWSE_MODE_STATE_USER_UNSELECTED = 0;
    public static final int JOIN_LOGIN = 4;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_CHINA_MOBILE_OAUTH = 5;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_FACE_LOGIN = 4;
    @Deprecated
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_FAST_REG = 2;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_LOGIN = 0;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_NAME_PHONE_EMAIL_LOGIN = 6;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_PRE_NAME_PHONE_LOGIN = 7;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_SMS_LOGIN = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean accountCenterRealAutnen;
    public int activityExitAnimId;
    public int activityOpenAnimId;
    public boolean agreeDangerousProtocol;
    public final String appId;
    public final String appSignKey;
    public final String bdOauthAppId;
    public int browseModeState;
    public final String cfoAppKey;
    public final boolean cfoOpenDebugMode;
    public String clientId;
    public String clientIp;
    public final Switch configurableViewLayout;
    public final Context context;
    public boolean customActionBarEnabled;
    public final boolean debug;
    public String deviceName;
    public boolean disableVoiceVerify;
    public final boolean enableShare;
    public final Domain environment;
    public final String faceLincenseFile;
    public final String faceLincenseID;
    public Map<String, String> faceResPaths;
    public final List<FastLoginFeature> fastLoginFeatureList;
    public boolean forbidPresetPhoneNumber;
    public final boolean forbidSslErrorDialog;
    public String googleClientId;
    public final LoginShareStrategy initialShareStrategy;
    public boolean isDarkMode;
    public boolean isHideLoginHelpEntrance;
    public final boolean isNewLogin;
    public boolean isNightMode;
    public boolean isShowBottomBackText;
    public boolean isSupportDebugShareLogin;
    public final Language language;
    public boolean mPrivacyParamesRegulation;
    public String mTAppName;
    public final String meizuRedirectUri;
    public final String mzAppID;
    public String presetPhoneNumber;
    public final String processName;
    public final String qqAppID;
    public final String realnameAuthenticateStoken;
    public boolean showBottomBack;
    public boolean showCloseBtn;
    public final String sinaAppId;
    public final String sinaRedirectUri;
    public String skin;
    public final SmsLoginConfig smsLoginConfig;
    public final BindType socialBindType;
    public final String sofireAppKey;
    public final int sofireHostID;
    public final String sofireSecKey;
    public boolean supportBrowseMode;
    public boolean supportCheckFloatfLayer;
    public boolean supportFaceLogin;
    public boolean supportGestureSlide;
    public boolean supportGuestAccountLogin;
    public boolean supportMultipleAccounts;
    public boolean supportNetwork;
    public final boolean supportPhoto;
    public boolean supportTouchLogin;
    public boolean syncOneKeyLoginInfo;
    public int textZoom;
    public final String tpl;
    public String twitterAppKey;
    public UbcUploadImplCallback ubcUploadImplCallback;
    public final boolean uniteVerify;
    public final String userAgent;
    public final String wxAppID;
    public final Long xiaomiAppID;
    public final String xiaomiRedirectUri;
    public String yyAppId;

    /* renamed from: com.baidu.sapi2.SapiConfiguration$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public /* synthetic */ SapiConfiguration(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.appId : (String) invokeV.objValue;
    }

    public String getAppSignKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.appSignKey : (String) invokeV.objValue;
    }

    public String getClientId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.clientId : (String) invokeV.objValue;
    }

    public String getClientIp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.clientIp : (String) invokeV.objValue;
    }

    public Switch getConfigurableViewLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.configurableViewLayout : (Switch) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.context : (Context) invokeV.objValue;
    }

    public boolean getCustomActionBarEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.customActionBarEnabled : invokeV.booleanValue;
    }

    public boolean getDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.debug : invokeV.booleanValue;
    }

    public Domain getEnvironment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.environment : (Domain) invokeV.objValue;
    }

    public List<FastLoginFeature> getFastLoginFeatureList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.fastLoginFeatureList : (List) invokeV.objValue;
    }

    public boolean getForbidSslErrorDialog() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.forbidSslErrorDialog : invokeV.booleanValue;
    }

    public Language getLanguage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.language : (Language) invokeV.objValue;
    }

    public String getMeizuRedirectUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.meizuRedirectUri : (String) invokeV.objValue;
    }

    public String getMzAppID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mzAppID : (String) invokeV.objValue;
    }

    public String getPresetPhoneNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.presetPhoneNumber : (String) invokeV.objValue;
    }

    public String getQqAppID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.qqAppID : (String) invokeV.objValue;
    }

    public String getRealnameAuthenticateStoken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.realnameAuthenticateStoken : (String) invokeV.objValue;
    }

    public String getSkin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.skin : (String) invokeV.objValue;
    }

    public BindType getSocialBindType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.socialBindType : (BindType) invokeV.objValue;
    }

    public String getTpl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.tpl : (String) invokeV.objValue;
    }

    public boolean getUniteVerify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.uniteVerify : invokeV.booleanValue;
    }

    public String getWxAppID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.wxAppID : (String) invokeV.objValue;
    }

    public boolean isAgreeDangerousProtocol() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.agreeDangerousProtocol : invokeV.booleanValue;
    }

    public boolean isShowBottomBackText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.isShowBottomBackText : invokeV.booleanValue;
    }

    public boolean isSupportBrowseMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.supportBrowseMode && this.browseModeState != 0 : invokeV.booleanValue;
    }

    public boolean isSupportTouchLogin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.supportTouchLogin && SapiContext.getInstance().getSapiOptions().gray.getGrayModuleByFunName(SapiOptions.Gray.FUN_NAME_GINGER).meetGray : invokeV.booleanValue;
    }

    public boolean isValidateSpCommit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? SapiContext.getInstance().getSapiOptions().gray.getGrayModuleByFunName(SapiOptions.Gray.FUN_NAME_VALIDATE_SP_COMMIT).meetGray : invokeV.booleanValue;
    }

    public LoginShareStrategy loginShareStrategy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            SapiOptions sapiOptions = SapiContext.getInstance().getSapiOptions();
            LoginShareStrategy loginShareStrategy = sapiOptions.getSpecificShareStrategy().get(this.tpl);
            if (loginShareStrategy != null) {
                Log.d(ShareUtils.TAG, "loginShareStrategy shareStrategy is " + loginShareStrategy.getStrValue());
                return loginShareStrategy;
            }
            LoginShareStrategy globalShareStrategy = sapiOptions.getGlobalShareStrategy();
            if (globalShareStrategy != null) {
                Log.d(ShareUtils.TAG, "loginShareStrategy getGlobalShareStrategy is " + globalShareStrategy.getStrValue());
                return globalShareStrategy;
            }
            return this.initialShareStrategy;
        }
        return (LoginShareStrategy) invokeV.objValue;
    }

    public void setAgreeDangerousProtocol(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.agreeDangerousProtocol = z;
            try {
                FH.setAgreePolicy(this.context, z);
            } catch (Exception e2) {
                Log.e(e2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class Builder implements NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean accountCenterRealNameAuthen;
        public int activityExitAnimId;
        public int activityOpenAnimId;
        public boolean agreeDangerousProtocol;
        public String appId;
        public String appSignKey;
        public String bdOauthAppId;
        public int browseModeState;
        public String cfoAppKey;
        public boolean cfoOpenDebugMode;
        public Switch configurableViewLayout;
        public Context context;
        public boolean customActionBarEnabled;
        public boolean debug;
        public String deviceName;
        public boolean disableVoiceVerify;
        public boolean enableShare;
        public Domain environment;
        public String faceLincenseFile;
        public String faceLincenseID;
        public Map<String, String> faceResPaths;
        public List<FastLoginFeature> fastLoginFeatureList;
        public boolean forbidPresetPhoneNumber;
        public boolean forbidSslErrorDialog;
        public String googleClientId;
        public LoginShareStrategy initialShareStrategy;
        public boolean isDarkMode;
        public boolean isHideLoginHelpEntrance;
        public boolean isNewLogin;
        public boolean isNightMode;
        public boolean isShowBottomBackText;
        public boolean isSupportDebugShareLogin;
        public Language language;
        public boolean mPrivacyParamesRegulation;
        public String mTAppName;
        public String meizuRedirectUri;
        public String mzAppID;
        public String presetPhoneNumber;
        public String processName;
        public String qqAppID;
        public String realnameAuthenticateStoken;
        public boolean showBottomBack;
        public boolean showCloseBtn;
        public boolean showRegLink;
        public String sinaAppID;
        public String sinaRedirectUri;
        public String skin;
        public SmsLoginConfig smsLoginConfig;
        public BindType socialBindType;
        public String sofireAppKey;
        public int sofireHostID;
        public String sofireSecKey;
        public boolean supNewVerSapiLogin;
        public boolean supportBrowseMode;
        public boolean supportCheckFloatfLayer;
        public boolean supportFaceLogin;
        public boolean supportGestureSlide;
        public boolean supportMultipleAccounts;
        public boolean supportPhoto;
        public boolean supportTouchLogin;
        public boolean syncOneKeyLoginInfo;
        public int textZoom;
        public String tpl;
        public String twitterAppKey;
        public UbcUploadImplCallback ubcUploadImplCallback;
        public boolean uniteVerify;
        public String userAgent;
        public String wxAppID;
        public Long xiaomiAppID;
        public String xiaomiRedirectUri;
        public String yyAppId;

        public Builder(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.agreeDangerousProtocol = true;
            this.sofireAppKey = "740000";
            this.sofireSecKey = "a7968de484f90a9036b5f2b40382ea43";
            this.sofireHostID = 1;
            this.customActionBarEnabled = false;
            this.showBottomBack = false;
            this.showCloseBtn = false;
            this.showRegLink = true;
            this.configurableViewLayout = Switch.OFF;
            this.debug = false;
            this.uniteVerify = false;
            this.accountCenterRealNameAuthen = true;
            this.forbidSslErrorDialog = false;
            this.enableShare = true;
            this.supportPhoto = true;
            this.isNightMode = false;
            this.isDarkMode = false;
            this.activityOpenAnimId = 0;
            this.activityExitAnimId = 0;
            this.supNewVerSapiLogin = false;
            this.disableVoiceVerify = true;
            this.supportFaceLogin = true;
            this.supportTouchLogin = true;
            this.supportGestureSlide = true;
            this.syncOneKeyLoginInfo = true;
            this.supportMultipleAccounts = true;
            this.isNewLogin = true;
            this.textZoom = 100;
            this.isShowBottomBackText = false;
            this.browseModeState = 1;
            this.isHideLoginHelpEntrance = false;
            this.context = context.getApplicationContext();
        }

        public Builder bdOauthAppId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                this.bdOauthAppId = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public SapiConfiguration build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (!TextUtils.isEmpty(this.tpl) && !TextUtils.isEmpty(this.appId) && !TextUtils.isEmpty(this.appSignKey)) {
                    if (this.environment == null) {
                        this.environment = Domain.DOMAIN_ONLINE;
                    }
                    if (this.language == null) {
                        this.language = Language.CHINESE;
                    }
                    if (this.socialBindType == null) {
                        this.socialBindType = BindType.BIND_MOBILE;
                    }
                    if (this.initialShareStrategy == null) {
                        this.initialShareStrategy = LoginShareStrategy.getDefault();
                    }
                    if (this.fastLoginFeatureList == null) {
                        this.fastLoginFeatureList = new ArrayList();
                    }
                    if (this.smsLoginConfig == null) {
                        Switch r1 = Switch.OFF;
                        this.smsLoginConfig = new SmsLoginConfig(r1, r1, r1);
                    }
                    if (this.configurableViewLayout == null) {
                        this.configurableViewLayout = Switch.OFF;
                    }
                    if (this.showBottomBack) {
                        this.customActionBarEnabled = true;
                    }
                    Log.enable(this.debug);
                    return new SapiConfiguration(this, null);
                }
                throw new IllegalArgumentException("tpl, appId, appsignkey can not be null, please use setProductLineInfo(String tpl, String appId, String appSignKey)to initialize them.");
            }
            return (SapiConfiguration) invokeV.objValue;
        }

        public Builder cfoAppID(String str, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z)) == null) {
                this.cfoAppKey = str;
                this.cfoOpenDebugMode = z;
                return this;
            }
            return (Builder) invokeLZ.objValue;
        }

        public Builder configurableViewLayout(Switch r5) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, r5)) == null) {
                this.configurableViewLayout = r5;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder customActionBar(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
                this.customActionBarEnabled = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder customWebviewUA(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.userAgent = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder debug(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                this.debug = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder enableShare(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048583, this, z)) == null) {
                this.enableShare = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder fastLoginSupport(FastLoginFeature... fastLoginFeatureArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fastLoginFeatureArr)) == null) {
                ArrayList arrayList = new ArrayList();
                this.fastLoginFeatureList = arrayList;
                if (fastLoginFeatureArr == null) {
                    return this;
                }
                Collections.addAll(arrayList, fastLoginFeatureArr);
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder forbidPresetPhoneNumber(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
                this.forbidPresetPhoneNumber = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder forbidSslErrorDalog(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048586, this, z)) == null) {
                this.forbidSslErrorDialog = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder googleOauthConfig(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
                this.googleClientId = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder initialShareStrategy(LoginShareStrategy loginShareStrategy) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, loginShareStrategy)) == null) {
                this.initialShareStrategy = loginShareStrategy;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder isHideLoginHelpEntrance(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048589, this, z)) == null) {
                this.isHideLoginHelpEntrance = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder isNewLogin(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048590, this, z)) == null) {
                this.isNewLogin = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder meizuLoginConfig(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, str, str2)) == null) {
                this.mzAppID = str;
                this.meizuRedirectUri = str2;
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder presetPhoneNumber(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
                this.presetPhoneNumber = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder qqAppID(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
                this.qqAppID = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder realnameAuthenticateStoken(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, str)) == null) {
                this.realnameAuthenticateStoken = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setActivityAnim(int i, int i2) {
            InterceptResult invokeII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeII = interceptable.invokeII(1048595, this, i, i2)) == null) {
                this.activityOpenAnimId = i;
                this.activityExitAnimId = i2;
                return this;
            }
            return (Builder) invokeII.objValue;
        }

        public Builder setAgreeDangerousProtocol(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048596, this, z)) == null) {
                this.agreeDangerousProtocol = z;
                try {
                    FH.setAgreePolicy(this.context, z);
                } catch (Exception e2) {
                    Log.e(e2);
                }
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setBrowseModeState(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) {
                this.browseModeState = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setDarkMode(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048598, this, z)) == null) {
                this.isDarkMode = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setDebugSupportShareLogin(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048599, this, z)) == null) {
                this.isSupportDebugShareLogin = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setDeviceName(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
                this.deviceName = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setDisableVoiceVerify(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048601, this, z)) == null) {
                this.disableVoiceVerify = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setFaceLincense(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048602, this, str, str2)) == null) {
                this.faceLincenseID = str;
                this.faceLincenseFile = str2;
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder setFaceResPaths(Map<String, String> map) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, map)) == null) {
                this.faceResPaths = map;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setLanguage(Language language) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, language)) == null) {
                this.language = language;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setLowerUpdateFreq(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(1048605, this, z)) == null) ? this : (Builder) invokeZ.objValue;
        }

        public Builder setNightMode(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048606, this, z)) == null) {
                this.isNightMode = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setPrivacyParamesConfig(String str, boolean z) {
            InterceptResult invokeLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048608, this, str, z)) == null) {
                if (z && TextUtils.isEmpty(str)) {
                    throw new IllegalArgumentException("privacyParamesRegulation is true , so tAppname and tCuid can not be empty");
                }
                this.mTAppName = str;
                this.mPrivacyParamesRegulation = z;
                return this;
            }
            return (Builder) invokeLZ.objValue;
        }

        public Builder setProcessName(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return this;
                }
                boolean z = false;
                Iterator<String> it = SapiOptions.getInitialProcessNameWhiteList().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (str.matches(it.next())) {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    this.processName = str;
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setProductLineInfo(String str, String str2, String str3) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048610, this, str, str2, str3)) == null) {
                this.tpl = str;
                this.appId = str2;
                this.appSignKey = str3;
                return this;
            }
            return (Builder) invokeLLL.objValue;
        }

        public Builder setRuntimeEnvironment(Domain domain) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, domain)) == null) {
                this.environment = domain;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setShowBottomBackText(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048612, this, z)) == null) {
                this.isShowBottomBackText = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setShowCloseBtn(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048613, this, z)) == null) {
                this.showCloseBtn = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setSocialBindType(BindType bindType) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, bindType)) == null) {
                this.socialBindType = bindType;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setSupNewVerSapiLogin(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048615, this, z)) == null) {
                this.supNewVerSapiLogin = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setSupportBrowseMode(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048616, this, z)) == null) {
                this.supportBrowseMode = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setSupportCheckFloatfLayer(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048617, this, z)) == null) {
                this.supportCheckFloatfLayer = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setSupportFaceLogin(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048618, this, z)) == null) {
                this.supportFaceLogin = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setSupportGestureSlide(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048619, this, z)) == null) {
                this.supportGestureSlide = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setSupportMultipleAccounts(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048620, this, z)) == null) {
                this.supportMultipleAccounts = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setSupportPhoto(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048621, this, z)) == null) {
                this.supportPhoto = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setSupportTouchLogin(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048622, this, z)) == null) {
                this.supportTouchLogin = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder setTextZoom(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048623, this, i)) == null) {
                if (i > 0 && i < 200) {
                    this.textZoom = i;
                }
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setUbcUploadImplCallback(UbcUploadImplCallback ubcUploadImplCallback) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, ubcUploadImplCallback)) == null) {
                this.ubcUploadImplCallback = ubcUploadImplCallback;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder showBottomBack(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048625, this, z)) == null) {
                this.showBottomBack = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder showRegLink(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048626, this, z)) == null) {
                this.showRegLink = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder sinaAppID(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048628, this, str, str2)) == null) {
                this.sinaAppID = str;
                this.sinaRedirectUri = str2;
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder skin(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, str)) == null) {
                this.skin = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder smsLoginConfig(SmsLoginConfig smsLoginConfig) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, smsLoginConfig)) == null) {
                this.smsLoginConfig = smsLoginConfig;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder sofireSdkConfig(String str, String str2, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048631, this, str, str2, i)) == null) {
                this.sofireAppKey = str;
                this.sofireSecKey = str2;
                this.sofireHostID = i;
                return this;
            }
            return (Builder) invokeLLI.objValue;
        }

        public Builder supportRealNameAuthen(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048632, this, z)) == null) {
                this.accountCenterRealNameAuthen = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder syncOneKeyLoginInfo(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048633, this, z)) == null) {
                this.syncOneKeyLoginInfo = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder twitterOauthConfig(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, str)) == null) {
                this.twitterAppKey = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder uniteVerify(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048635, this, z)) == null) {
                this.uniteVerify = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder wxAppID(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048636, this, str)) == null) {
                this.wxAppID = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder xiaoAppID(Long l, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048637, this, l, str)) == null) {
                this.xiaomiAppID = l;
                this.xiaomiRedirectUri = str;
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder yyOauthConfig(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, str)) == null) {
                this.yyAppId = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder sinaAppID(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, str)) == null) ? sinaAppID(str, Domain.DOMAIN_ONLINE.getURL(true)) : (Builder) invokeL.objValue;
        }

        public Builder setPrivacyParamesConfig(String str, String str2, boolean z) {
            InterceptResult invokeLLZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048607, this, str, str2, z)) == null) {
                if (z && TextUtils.isEmpty(str)) {
                    throw new IllegalArgumentException("privacyParamesRegulation is true , so tAppname and tCuid can not be empty");
                }
                this.mTAppName = str;
                this.mPrivacyParamesRegulation = z;
                return this;
            }
            return (Builder) invokeLLZ.objValue;
        }
    }

    public SapiConfiguration(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.supportNetwork = true;
        this.context = builder.context;
        this.tpl = builder.tpl;
        this.appId = builder.appId;
        this.appSignKey = builder.appSignKey;
        this.environment = builder.environment;
        this.faceLincenseID = builder.faceLincenseID;
        this.faceLincenseFile = builder.faceLincenseFile;
        this.language = builder.language;
        this.socialBindType = builder.socialBindType;
        this.initialShareStrategy = builder.initialShareStrategy;
        this.fastLoginFeatureList = builder.fastLoginFeatureList;
        this.wxAppID = builder.wxAppID;
        this.qqAppID = builder.qqAppID;
        this.mzAppID = builder.mzAppID;
        this.sinaAppId = builder.sinaAppID;
        this.bdOauthAppId = builder.bdOauthAppId;
        this.meizuRedirectUri = builder.meizuRedirectUri;
        this.sinaRedirectUri = builder.sinaRedirectUri;
        this.xiaomiAppID = builder.xiaomiAppID;
        this.xiaomiRedirectUri = builder.xiaomiRedirectUri;
        this.cfoAppKey = builder.cfoAppKey;
        this.cfoOpenDebugMode = builder.cfoOpenDebugMode;
        this.twitterAppKey = builder.twitterAppKey;
        this.googleClientId = builder.googleClientId;
        this.yyAppId = builder.yyAppId;
        this.agreeDangerousProtocol = builder.agreeDangerousProtocol;
        this.sofireAppKey = builder.sofireAppKey;
        this.sofireSecKey = builder.sofireSecKey;
        this.sofireHostID = builder.sofireHostID;
        this.realnameAuthenticateStoken = builder.realnameAuthenticateStoken;
        this.skin = builder.skin;
        this.presetPhoneNumber = builder.presetPhoneNumber;
        this.forbidPresetPhoneNumber = builder.forbidPresetPhoneNumber;
        this.customActionBarEnabled = builder.customActionBarEnabled;
        this.showBottomBack = builder.showBottomBack;
        this.configurableViewLayout = builder.configurableViewLayout;
        this.debug = builder.debug;
        this.smsLoginConfig = builder.smsLoginConfig;
        this.uniteVerify = builder.uniteVerify;
        this.accountCenterRealAutnen = builder.accountCenterRealNameAuthen;
        this.forbidSslErrorDialog = builder.forbidSslErrorDialog;
        this.enableShare = builder.enableShare;
        this.supportPhoto = builder.supportPhoto;
        this.processName = builder.processName;
        this.isNightMode = builder.isNightMode;
        this.isDarkMode = builder.isDarkMode;
        this.isNewLogin = builder.isNewLogin;
        this.showCloseBtn = builder.showCloseBtn;
        this.userAgent = builder.userAgent;
        this.activityOpenAnimId = builder.activityOpenAnimId;
        this.activityExitAnimId = builder.activityExitAnimId;
        this.disableVoiceVerify = builder.disableVoiceVerify;
        this.supportFaceLogin = builder.supportFaceLogin;
        this.supportTouchLogin = builder.supportTouchLogin;
        this.supportGestureSlide = builder.supportGestureSlide;
        this.syncOneKeyLoginInfo = builder.syncOneKeyLoginInfo;
        this.supportMultipleAccounts = builder.supportMultipleAccounts;
        this.supportCheckFloatfLayer = builder.supportCheckFloatfLayer;
        this.textZoom = builder.textZoom;
        this.isShowBottomBackText = builder.isShowBottomBackText;
        this.deviceName = builder.deviceName;
        this.isHideLoginHelpEntrance = builder.isHideLoginHelpEntrance;
        this.browseModeState = builder.browseModeState;
        this.supportBrowseMode = builder.supportBrowseMode;
        this.isSupportDebugShareLogin = builder.isSupportDebugShareLogin;
        this.ubcUploadImplCallback = builder.ubcUploadImplCallback;
        this.mPrivacyParamesRegulation = builder.mPrivacyParamesRegulation;
        this.mTAppName = builder.mTAppName;
        this.faceResPaths = builder.faceResPaths;
    }

    /* loaded from: classes4.dex */
    public static class SmsLoginConfig implements NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Switch flagHideExtraEntry;
        public Switch flagLoginBtnType;
        public Switch flagShowFastRegLink;
        public Switch flagShowLoginLink;
        public Switch flagShowSmsLoginLink;

        public SmsLoginConfig(Switch r6, Switch r7, @Deprecated Switch r8) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r6, r7, r8};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            r6 = r6 == null ? Switch.OFF : r6;
            r7 = r7 == null ? Switch.OFF : r7;
            r8 = r8 == null ? Switch.OFF : r8;
            this.flagShowLoginLink = r6;
            this.flagShowSmsLoginLink = r7;
            this.flagLoginBtnType = r8;
            Switch r62 = Switch.OFF;
            this.flagShowFastRegLink = r62;
            this.flagHideExtraEntry = r62;
        }

        public SmsLoginConfig(Switch r6, Switch r7, Switch r8, @Deprecated Switch r9, Switch r10) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r6, r7, r8, r9, r10};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            r6 = r6 == null ? Switch.OFF : r6;
            r7 = r7 == null ? Switch.OFF : r7;
            r8 = r8 == null ? Switch.OFF : r8;
            r9 = r9 == null ? Switch.OFF : r9;
            r10 = r10 == null ? Switch.OFF : r10;
            this.flagHideExtraEntry = r6;
            this.flagShowLoginLink = r7;
            this.flagShowSmsLoginLink = r8;
            this.flagLoginBtnType = r9;
            this.flagShowFastRegLink = r10;
        }
    }
}
