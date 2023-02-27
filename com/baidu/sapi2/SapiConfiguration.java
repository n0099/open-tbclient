package com.baidu.sapi2;

import android.content.Context;
import android.text.TextUtils;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public final class SapiConfiguration implements NoProguard {
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
    public final String honorAppID;
    public final String honorRedirectUri;
    public final LoginShareStrategy initialShareStrategy;
    public boolean isDarkMode;
    public boolean isHideLoginHelpEntrance;
    public final boolean isNewLogin;
    public boolean isNightMode;
    public boolean isShowBottomBackText;
    public boolean isSupportDebugShareLogin;
    public final Language language;
    public CallbackTextSizeListener mCallbackTextSizeListener;
    public boolean mPrivacyParamesRegulation;
    public String mTPLAppName;
    public String mTPLCuid;
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

    /* loaded from: classes2.dex */
    public interface CallbackTextSizeListener extends NoProguard {
        int callbackTextSize();
    }

    /* loaded from: classes2.dex */
    public static class Builder implements NoProguard {
        public String appId;
        public String appSignKey;
        public String bdOauthAppId;
        public String cfoAppKey;
        public boolean cfoOpenDebugMode;
        public Context context;
        public String deviceName;
        public Domain environment;
        public String faceLincenseFile;
        public String faceLincenseID;
        public Map<String, String> faceResPaths;
        public List<FastLoginFeature> fastLoginFeatureList;
        public boolean forbidPresetPhoneNumber;
        public String googleClientId;
        public String honorAppID;
        public String honorRedirectUri;
        public LoginShareStrategy initialShareStrategy;
        public boolean isSupportDebugShareLogin;
        public Language language;
        public CallbackTextSizeListener mCallbackTextSizeListener;
        public boolean mPrivacyParamesRegulation;
        public String mTPLAppName;
        public String mTPLCuid;
        public String meizuRedirectUri;
        public String mzAppID;
        public String presetPhoneNumber;
        public String processName;
        public String qqAppID;
        public String realnameAuthenticateStoken;
        public String sinaAppID;
        public String sinaRedirectUri;
        public String skin;
        public SmsLoginConfig smsLoginConfig;
        public BindType socialBindType;
        public boolean supportBrowseMode;
        public boolean supportCheckFloatfLayer;
        public String tpl;
        public String twitterAppKey;
        public UbcUploadImplCallback ubcUploadImplCallback;
        public String userAgent;
        public String wxAppID;
        public Long xiaomiAppID;
        public String xiaomiRedirectUri;
        public String yyAppId;
        public boolean agreeDangerousProtocol = true;
        public String sofireAppKey = "740000";
        public String sofireSecKey = "a7968de484f90a9036b5f2b40382ea43";
        public int sofireHostID = 1;
        public boolean customActionBarEnabled = false;
        public boolean showBottomBack = false;
        public boolean showCloseBtn = false;
        public boolean showRegLink = true;
        public Switch configurableViewLayout = Switch.OFF;
        public boolean debug = false;
        public boolean uniteVerify = false;
        public boolean accountCenterRealNameAuthen = true;
        public boolean forbidSslErrorDialog = false;
        public boolean enableShare = true;
        public boolean supportPhoto = true;
        public boolean isNightMode = false;
        public boolean isDarkMode = false;
        public int activityOpenAnimId = 0;
        public int activityExitAnimId = 0;
        public boolean supNewVerSapiLogin = false;
        public boolean disableVoiceVerify = true;
        public boolean supportFaceLogin = true;
        public boolean supportTouchLogin = true;
        public boolean supportGestureSlide = true;
        public boolean syncOneKeyLoginInfo = true;
        public boolean supportMultipleAccounts = true;
        public boolean isNewLogin = true;
        public int textZoom = 100;
        public boolean isShowBottomBackText = false;
        public int browseModeState = 1;
        public boolean isHideLoginHelpEntrance = false;

        public Builder setLowerUpdateFreq(boolean z) {
            return this;
        }

        public Builder(Context context) {
            this.context = context.getApplicationContext();
        }

        public Builder bdOauthAppId(String str) {
            this.bdOauthAppId = str;
            return this;
        }

        public Builder configurableViewLayout(Switch r1) {
            this.configurableViewLayout = r1;
            return this;
        }

        public Builder customActionBar(boolean z) {
            this.customActionBarEnabled = z;
            return this;
        }

        public Builder customWebviewUA(String str) {
            this.userAgent = str;
            return this;
        }

        public Builder debug(boolean z) {
            this.debug = z;
            return this;
        }

        public Builder enableShare(boolean z) {
            this.enableShare = z;
            return this;
        }

        public Builder fastLoginSupport(FastLoginFeature... fastLoginFeatureArr) {
            ArrayList arrayList = new ArrayList();
            this.fastLoginFeatureList = arrayList;
            if (fastLoginFeatureArr == null) {
                return this;
            }
            Collections.addAll(arrayList, fastLoginFeatureArr);
            return this;
        }

        public Builder forbidPresetPhoneNumber(boolean z) {
            this.forbidPresetPhoneNumber = z;
            return this;
        }

        public Builder forbidSslErrorDalog(boolean z) {
            this.forbidSslErrorDialog = z;
            return this;
        }

        public Builder googleOauthConfig(String str) {
            this.googleClientId = str;
            return this;
        }

        public Builder initialShareStrategy(LoginShareStrategy loginShareStrategy) {
            this.initialShareStrategy = loginShareStrategy;
            return this;
        }

        public Builder isHideLoginHelpEntrance(boolean z) {
            this.isHideLoginHelpEntrance = z;
            return this;
        }

        public Builder isNewLogin(boolean z) {
            this.isNewLogin = z;
            return this;
        }

        public Builder presetPhoneNumber(String str) {
            this.presetPhoneNumber = str;
            return this;
        }

        public Builder qqAppID(String str) {
            this.qqAppID = str;
            return this;
        }

        public Builder realnameAuthenticateStoken(String str) {
            this.realnameAuthenticateStoken = str;
            return this;
        }

        public Builder setAgreeDangerousProtocol(boolean z) {
            this.agreeDangerousProtocol = z;
            try {
                FH.setAgreePolicy(this.context, z);
            } catch (Exception e) {
                Log.e(e);
            }
            return this;
        }

        public Builder setBrowseModeState(int i) {
            this.browseModeState = i;
            return this;
        }

        public Builder setDarkMode(boolean z) {
            this.isDarkMode = z;
            return this;
        }

        public Builder setDebugSupportShareLogin(boolean z) {
            this.isSupportDebugShareLogin = z;
            return this;
        }

        public Builder setDeviceName(String str) {
            this.deviceName = str;
            return this;
        }

        public Builder setDisableVoiceVerify(boolean z) {
            this.disableVoiceVerify = z;
            return this;
        }

        public Builder setFaceResPaths(Map<String, String> map) {
            this.faceResPaths = map;
            return this;
        }

        public Builder setLanguage(Language language) {
            this.language = language;
            return this;
        }

        public Builder setNightMode(boolean z) {
            this.isNightMode = z;
            return this;
        }

        public Builder setProcessName(String str) {
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

        public Builder setRuntimeEnvironment(Domain domain) {
            this.environment = domain;
            return this;
        }

        public Builder setShowBottomBackText(boolean z) {
            this.isShowBottomBackText = z;
            return this;
        }

        public Builder setShowCloseBtn(boolean z) {
            this.showCloseBtn = z;
            return this;
        }

        public Builder setSocialBindType(BindType bindType) {
            this.socialBindType = bindType;
            return this;
        }

        public Builder setSupNewVerSapiLogin(boolean z) {
            this.supNewVerSapiLogin = z;
            return this;
        }

        public Builder setSupportBrowseMode(boolean z) {
            this.supportBrowseMode = z;
            return this;
        }

        public Builder setSupportCheckFloatfLayer(boolean z) {
            this.supportCheckFloatfLayer = z;
            return this;
        }

        public Builder setSupportFaceLogin(boolean z) {
            this.supportFaceLogin = z;
            return this;
        }

        public Builder setSupportGestureSlide(boolean z) {
            this.supportGestureSlide = z;
            return this;
        }

        public Builder setSupportMultipleAccounts(boolean z) {
            this.supportMultipleAccounts = z;
            return this;
        }

        public Builder setSupportPhoto(boolean z) {
            this.supportPhoto = z;
            return this;
        }

        public Builder setSupportTouchLogin(boolean z) {
            this.supportTouchLogin = z;
            return this;
        }

        public Builder setTextSizeZoomListener(CallbackTextSizeListener callbackTextSizeListener) {
            this.mCallbackTextSizeListener = callbackTextSizeListener;
            return this;
        }

        public Builder setTextZoom(int i) {
            if (i > 0 && i < 200) {
                this.textZoom = i;
            }
            return this;
        }

        public Builder setUbcUploadImplCallback(UbcUploadImplCallback ubcUploadImplCallback) {
            this.ubcUploadImplCallback = ubcUploadImplCallback;
            return this;
        }

        public Builder showBottomBack(boolean z) {
            this.showBottomBack = z;
            return this;
        }

        public Builder showRegLink(boolean z) {
            this.showRegLink = z;
            return this;
        }

        public Builder sinaAppID(String str) {
            return sinaAppID(str, Domain.DOMAIN_ONLINE.getURL(true));
        }

        public Builder skin(String str) {
            this.skin = str;
            return this;
        }

        public Builder smsLoginConfig(SmsLoginConfig smsLoginConfig) {
            this.smsLoginConfig = smsLoginConfig;
            return this;
        }

        public Builder supportRealNameAuthen(boolean z) {
            this.accountCenterRealNameAuthen = z;
            return this;
        }

        public Builder syncOneKeyLoginInfo(boolean z) {
            this.syncOneKeyLoginInfo = z;
            return this;
        }

        public Builder twitterOauthConfig(String str) {
            this.twitterAppKey = str;
            return this;
        }

        public Builder uniteVerify(boolean z) {
            this.uniteVerify = z;
            return this;
        }

        public Builder wxAppID(String str) {
            this.wxAppID = str;
            return this;
        }

        public Builder yyOauthConfig(String str) {
            this.yyAppId = str;
            return this;
        }

        public SapiConfiguration build() {
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
                return new SapiConfiguration(this);
            }
            throw new IllegalArgumentException("tpl, appId, appsignkey can not be null, please use setProductLineInfo(String tpl, String appId, String appSignKey)to initialize them.");
        }

        public Builder cfoAppID(String str, boolean z) {
            this.cfoAppKey = str;
            this.cfoOpenDebugMode = z;
            return this;
        }

        public Builder honorAppID(String str, String str2) {
            this.honorAppID = str;
            if (TextUtils.isEmpty(str2)) {
                str2 = "honorid://redirect_url";
            }
            this.honorRedirectUri = str2;
            return this;
        }

        public Builder meizuLoginConfig(String str, String str2) {
            this.mzAppID = str;
            this.meizuRedirectUri = str2;
            return this;
        }

        public Builder setActivityAnim(int i, int i2) {
            this.activityOpenAnimId = i;
            this.activityExitAnimId = i2;
            return this;
        }

        public Builder setFaceLincense(String str, String str2) {
            this.faceLincenseID = str;
            this.faceLincenseFile = str2;
            return this;
        }

        public Builder setPrivacyParamesConfig(String str, boolean z) {
            if (z && TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("privacyParamesRegulation is true , so tAppname and tCuid can not be empty");
            }
            this.mTPLAppName = str;
            this.mPrivacyParamesRegulation = z;
            return this;
        }

        public Builder sinaAppID(String str, String str2) {
            this.sinaAppID = str;
            this.sinaRedirectUri = str2;
            return this;
        }

        public Builder xiaoAppID(Long l, String str) {
            this.xiaomiAppID = l;
            this.xiaomiRedirectUri = str;
            return this;
        }

        public Builder setPrivacyParamesConfig(String str, String str2, boolean z) {
            if (z && TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("privacyParamesRegulation is true , so tAppname and tCuid can not be empty");
            }
            this.mTPLAppName = str;
            this.mTPLCuid = str2;
            this.mPrivacyParamesRegulation = z;
            return this;
        }

        public Builder setProductLineInfo(String str, String str2, String str3) {
            this.tpl = str;
            this.appId = str2;
            this.appSignKey = str3;
            return this;
        }

        public Builder sofireSdkConfig(String str, String str2, int i) {
            this.sofireAppKey = str;
            this.sofireSecKey = str2;
            this.sofireHostID = i;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static class SmsLoginConfig implements NoProguard {
        public Switch flagHideExtraEntry;
        public Switch flagLoginBtnType;
        public Switch flagShowFastRegLink;
        public Switch flagShowLoginLink;
        public Switch flagShowSmsLoginLink;

        public SmsLoginConfig(Switch r1, Switch r2, @Deprecated Switch r3) {
            r1 = r1 == null ? Switch.OFF : r1;
            r2 = r2 == null ? Switch.OFF : r2;
            r3 = r3 == null ? Switch.OFF : r3;
            this.flagShowLoginLink = r1;
            this.flagShowSmsLoginLink = r2;
            this.flagLoginBtnType = r3;
            Switch r12 = Switch.OFF;
            this.flagShowFastRegLink = r12;
            this.flagHideExtraEntry = r12;
        }

        public SmsLoginConfig(Switch r1, Switch r2, Switch r3, @Deprecated Switch r4, Switch r5) {
            r1 = r1 == null ? Switch.OFF : r1;
            r2 = r2 == null ? Switch.OFF : r2;
            r3 = r3 == null ? Switch.OFF : r3;
            r4 = r4 == null ? Switch.OFF : r4;
            r5 = r5 == null ? Switch.OFF : r5;
            this.flagHideExtraEntry = r1;
            this.flagShowLoginLink = r2;
            this.flagShowSmsLoginLink = r3;
            this.flagLoginBtnType = r4;
            this.flagShowFastRegLink = r5;
        }
    }

    public SapiConfiguration(Builder builder) {
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
        this.honorAppID = builder.honorAppID;
        this.honorRedirectUri = builder.honorRedirectUri;
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
        this.mTPLAppName = builder.mTPLAppName;
        this.mTPLCuid = builder.mTPLCuid;
        this.faceResPaths = builder.faceResPaths;
        this.mCallbackTextSizeListener = builder.mCallbackTextSizeListener;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppSignKey() {
        return this.appSignKey;
    }

    public String getClientId() {
        return this.clientId;
    }

    public String getClientIp() {
        return this.clientIp;
    }

    public Switch getConfigurableViewLayout() {
        return this.configurableViewLayout;
    }

    public Context getContext() {
        return this.context;
    }

    public boolean getCustomActionBarEnabled() {
        return this.customActionBarEnabled;
    }

    public boolean getDebug() {
        return this.debug;
    }

    public Domain getEnvironment() {
        return this.environment;
    }

    public List<FastLoginFeature> getFastLoginFeatureList() {
        return this.fastLoginFeatureList;
    }

    public boolean getForbidSslErrorDialog() {
        return this.forbidSslErrorDialog;
    }

    public String getHonorAppID() {
        return this.honorAppID;
    }

    public Language getLanguage() {
        return this.language;
    }

    public String getMeizuRedirectUri() {
        return this.meizuRedirectUri;
    }

    public String getMzAppID() {
        return this.mzAppID;
    }

    public String getPresetPhoneNumber() {
        return this.presetPhoneNumber;
    }

    public String getQqAppID() {
        return this.qqAppID;
    }

    public String getRealnameAuthenticateStoken() {
        return this.realnameAuthenticateStoken;
    }

    public String getSkin() {
        return this.skin;
    }

    public BindType getSocialBindType() {
        return this.socialBindType;
    }

    public int getTextZoom() {
        CallbackTextSizeListener callbackTextSizeListener = this.mCallbackTextSizeListener;
        if (callbackTextSizeListener == null) {
            return this.textZoom;
        }
        return callbackTextSizeListener.callbackTextSize();
    }

    public String getTpl() {
        return this.tpl;
    }

    public boolean getUniteVerify() {
        return this.uniteVerify;
    }

    public String getWxAppID() {
        return this.wxAppID;
    }

    public boolean isAgreeDangerousProtocol() {
        return this.agreeDangerousProtocol;
    }

    public boolean isShowBottomBackText() {
        return this.isShowBottomBackText;
    }

    public boolean isSupportBrowseMode() {
        if (this.supportBrowseMode && this.browseModeState != 0) {
            return true;
        }
        return false;
    }

    public boolean isSupportTouchLogin() {
        if (!this.supportTouchLogin || !SapiContext.getInstance().getSapiOptions().gray.getGrayModuleByFunName(SapiOptions.Gray.FUN_NAME_GINGER).meetGray) {
            return false;
        }
        return true;
    }

    public boolean isValidateSpCommit() {
        return SapiContext.getInstance().getSapiOptions().gray.getGrayModuleByFunName(SapiOptions.Gray.FUN_NAME_VALIDATE_SP_COMMIT).meetGray;
    }

    public LoginShareStrategy loginShareStrategy() {
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

    public void setAgreeDangerousProtocol(boolean z) {
        this.agreeDangerousProtocol = z;
        try {
            FH.setAgreePolicy(this.context, z);
        } catch (Exception e) {
            Log.e(e);
        }
    }
}
