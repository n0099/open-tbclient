package com.baidu.sapi2;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.SapiOptions;
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
/* loaded from: classes2.dex */
public final class SapiConfiguration implements NoProguard {
    public static final int JOIN_LOGIN = 4;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_CHINA_MOBILE_OAUTH = 5;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_FACE_LOGIN = 4;
    @Deprecated
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_FAST_REG = 2;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_LOGIN = 0;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_NAME_PHONE_EMAIL_LOGIN = 6;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_SMS_LOGIN = 1;

    /* renamed from: a  reason: collision with root package name */
    public final LoginShareStrategy f10635a;
    public final boolean accountCenterRealAutnen;
    public int activityExitAnimId;
    public int activityOpenAnimId;
    public final String appId;
    public final String appSignKey;

    /* renamed from: b  reason: collision with root package name */
    public boolean f10636b;
    public final String bdOauthAppId;

    /* renamed from: c  reason: collision with root package name */
    public boolean f10637c;
    public String clientId;
    public String clientIp;
    public final Switch configurableViewLayout;
    public final Context context;
    public boolean customActionBarEnabled;
    public final boolean debug;
    public boolean disableVoiceVerify;
    public final boolean enableShare;
    public final Domain environment;
    public final List<FastLoginFeature> fastLoginFeatureList;
    public boolean forbidPresetPhoneNumber;
    public final boolean forbidSslErrorDialog;
    public String googleClientId;
    public boolean isDarkMode;
    public final boolean isNewLogin;
    public boolean isNightMode;
    public final Language language;
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
    public boolean supportCheckFloatfLayer;
    public boolean supportFaceLogin;
    public boolean supportGestureSlide;
    public boolean supportGuestAccountLogin;
    public boolean supportMultipleAccounts;
    public boolean supportNetwork;
    public final boolean supportPhoto;
    public boolean syncOneKeyLoginInfo;
    public int textZoom;
    public final String tpl;
    public String twitterAppKey;
    public final boolean uniteVerify;
    public final String userAgent;
    public final String wxAppID;
    public final Long xiaomiAppID;
    public final String xiaomiRedirectUri;
    public String yyAppId;

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
        return this.f10636b;
    }

    public boolean isSupportTouchLogin() {
        return this.f10637c && SapiContext.getInstance().getSapiOptions().gray.getGrayModuleByFunName(SapiOptions.Gray.FUN_NAME_GINGER).f10805c;
    }

    public boolean isValidateSpCommit() {
        return SapiContext.getInstance().getSapiOptions().gray.getGrayModuleByFunName(SapiOptions.Gray.FUN_NAME_VALIDATE_SP_COMMIT).f10805c;
    }

    public LoginShareStrategy loginShareStrategy() {
        SapiOptions sapiOptions = SapiContext.getInstance().getSapiOptions();
        LoginShareStrategy loginShareStrategy = sapiOptions.getSpecificShareStrategy().get(this.tpl);
        if (loginShareStrategy != null) {
            Log.d(com.baidu.sapi2.share.d.f11376a, "loginShareStrategy shareStrategy is " + loginShareStrategy.getStrValue());
            return loginShareStrategy;
        }
        LoginShareStrategy globalShareStrategy = sapiOptions.getGlobalShareStrategy();
        if (globalShareStrategy != null) {
            Log.d(com.baidu.sapi2.share.d.f11376a, "loginShareStrategy getGlobalShareStrategy is " + globalShareStrategy.getStrValue());
            return globalShareStrategy;
        }
        return this.f10635a;
    }

    public void setAgreeDangerousProtocol(boolean z) {
        this.f10636b = z;
        try {
            FH.setAgreePolicy(this.context, z);
        } catch (Exception e2) {
            Log.e(e2);
        }
    }

    /* loaded from: classes2.dex */
    public static class Builder implements NoProguard {
        public String B;
        public String C;
        public boolean D;
        public SmsLoginConfig K;
        public String Q;
        public String R;

        /* renamed from: a  reason: collision with root package name */
        public Context f10638a;

        /* renamed from: b  reason: collision with root package name */
        public String f10639b;

        /* renamed from: c  reason: collision with root package name */
        public String f10640c;

        /* renamed from: d  reason: collision with root package name */
        public String f10641d;
        public boolean d0;

        /* renamed from: e  reason: collision with root package name */
        public String f10642e;

        /* renamed from: f  reason: collision with root package name */
        public Domain f10643f;

        /* renamed from: g  reason: collision with root package name */
        public BindType f10644g;

        /* renamed from: h  reason: collision with root package name */
        public Language f10645h;
        public LoginShareStrategy i;
        public List<FastLoginFeature> j;
        public String k;
        public String l;
        public String m;
        public Long n;
        public String o;
        public String p;
        public String q;
        public String r;
        public String s;
        public String u;
        public String v;
        public String w;
        public String x;
        public boolean t = true;
        public String y = "740000";
        public String z = "a7968de484f90a9036b5f2b40382ea43";
        public int A = 1;
        public boolean E = false;
        public boolean F = false;
        public boolean G = false;
        public boolean H = true;
        public Switch I = Switch.OFF;
        public boolean J = false;
        public boolean L = false;
        public boolean M = true;
        public boolean N = false;
        public boolean O = true;
        public boolean P = true;
        public boolean S = false;
        public boolean T = false;
        public int U = 0;
        public int V = 0;
        public boolean W = false;
        public boolean X = true;
        public boolean Y = true;
        public boolean Z = true;
        public boolean a0 = true;
        public boolean b0 = true;
        public boolean c0 = true;
        public boolean e0 = true;
        public int f0 = 100;

        public Builder(Context context) {
            this.f10638a = context.getApplicationContext();
        }

        public Builder bdOauthAppId(String str) {
            this.p = str;
            return this;
        }

        public SapiConfiguration build() {
            if (!TextUtils.isEmpty(this.f10639b) && !TextUtils.isEmpty(this.f10640c) && !TextUtils.isEmpty(this.f10641d)) {
                if (this.f10643f == null) {
                    this.f10643f = Domain.DOMAIN_ONLINE;
                }
                if (this.f10645h == null) {
                    this.f10645h = Language.CHINESE;
                }
                if (this.f10644g == null) {
                    this.f10644g = BindType.BIND_MOBILE;
                }
                if (this.i == null) {
                    this.i = LoginShareStrategy.getDefault();
                }
                if (this.j == null) {
                    this.j = new ArrayList();
                }
                if (this.K == null) {
                    Switch r1 = Switch.OFF;
                    this.K = new SmsLoginConfig(r1, r1, r1);
                }
                if (this.I == null) {
                    this.I = Switch.OFF;
                }
                if (this.F) {
                    this.E = true;
                }
                Log.enable(this.J);
                return new SapiConfiguration(this);
            }
            throw new IllegalArgumentException("tpl, appId, appsignkey can not be null, please use setProductLineInfo(String tpl, String appId, String appSignKey)to initialize them.");
        }

        public Builder configurableViewLayout(Switch r1) {
            this.I = r1;
            return this;
        }

        public Builder customActionBar(boolean z) {
            this.E = z;
            return this;
        }

        public Builder customWebviewUA(String str) {
            this.R = str;
            return this;
        }

        public Builder debug(boolean z) {
            this.J = z;
            return this;
        }

        public Builder enableShare(boolean z) {
            this.O = z;
            return this;
        }

        public Builder fastLoginSupport(FastLoginFeature... fastLoginFeatureArr) {
            ArrayList arrayList = new ArrayList();
            this.j = arrayList;
            if (fastLoginFeatureArr == null) {
                return this;
            }
            Collections.addAll(arrayList, fastLoginFeatureArr);
            return this;
        }

        public Builder forbidPresetPhoneNumber(boolean z) {
            this.D = z;
            return this;
        }

        public Builder forbidSslErrorDalog(boolean z) {
            this.N = z;
            return this;
        }

        public Builder googleOauthConfig(String str) {
            this.r = str;
            return this;
        }

        public Builder initialShareStrategy(LoginShareStrategy loginShareStrategy) {
            this.i = loginShareStrategy;
            return this;
        }

        public Builder isNewLogin(boolean z) {
            this.e0 = z;
            return this;
        }

        public Builder meizuLoginConfig(String str, String str2) {
            this.m = str;
            this.w = str2;
            return this;
        }

        public Builder presetPhoneNumber(String str) {
            this.C = str;
            return this;
        }

        public Builder qqAppID(String str) {
            this.l = str;
            return this;
        }

        public Builder realnameAuthenticateStoken(String str) {
            this.u = str;
            return this;
        }

        public Builder setActivityAnim(int i, int i2) {
            this.U = i;
            this.V = i2;
            return this;
        }

        public Builder setAgreeDangerousProtocol(boolean z) {
            this.t = z;
            try {
                FH.setAgreePolicy(this.f10638a, z);
            } catch (Exception e2) {
                Log.e(e2);
            }
            return this;
        }

        public Builder setDarkMode(boolean z) {
            this.T = z;
            return this;
        }

        public Builder setDisableVoiceVerify(boolean z) {
            this.X = z;
            return this;
        }

        public Builder setLanguage(Language language) {
            this.f10645h = language;
            return this;
        }

        public Builder setLowerUpdateFreq(boolean z) {
            return this;
        }

        public Builder setNightMode(boolean z) {
            this.S = z;
            return this;
        }

        public Builder setProcessName(String str) {
            if (TextUtils.isEmpty(str)) {
                return this;
            }
            boolean z = false;
            Iterator<String> it = SapiOptions.g().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (str.matches(it.next())) {
                    z = true;
                    break;
                }
            }
            if (z) {
                this.Q = str;
            }
            return this;
        }

        public Builder setProductLineInfo(String str, String str2, String str3) {
            this.f10639b = str;
            this.f10640c = str2;
            this.f10641d = str3;
            return this;
        }

        public Builder setRuntimeEnvironment(Domain domain) {
            this.f10643f = domain;
            return this;
        }

        public Builder setShowCloseBtn(boolean z) {
            this.G = z;
            return this;
        }

        public Builder setSocialBindType(BindType bindType) {
            this.f10644g = bindType;
            return this;
        }

        public Builder setSupNewVerSapiLogin(boolean z) {
            this.W = z;
            return this;
        }

        public Builder setSupportCheckFloatfLayer(boolean z) {
            this.d0 = z;
            return this;
        }

        public Builder setSupportFaceLogin(boolean z) {
            this.Y = z;
            return this;
        }

        public Builder setSupportGestureSlide(boolean z) {
            this.a0 = z;
            return this;
        }

        public Builder setSupportMultipleAccounts(boolean z) {
            this.c0 = z;
            return this;
        }

        public Builder setSupportPhoto(boolean z) {
            this.P = z;
            return this;
        }

        public Builder setSupportTouchLogin(boolean z) {
            this.Z = z;
            return this;
        }

        public Builder setTextZoom(int i) {
            if (i > 0 && i < 200) {
                this.f0 = i;
            }
            return this;
        }

        public Builder showBottomBack(boolean z) {
            this.F = z;
            return this;
        }

        public Builder showRegLink(boolean z) {
            this.H = z;
            return this;
        }

        public Builder sinaAppID(String str, String str2) {
            this.o = str;
            this.x = str2;
            return this;
        }

        public Builder skin(String str) {
            this.B = str;
            return this;
        }

        public Builder smsLoginConfig(SmsLoginConfig smsLoginConfig) {
            this.K = smsLoginConfig;
            return this;
        }

        public Builder sofireSdkConfig(String str, String str2, int i) {
            this.y = str;
            this.z = str2;
            this.A = i;
            return this;
        }

        public Builder supportRealNameAuthen(boolean z) {
            this.M = z;
            return this;
        }

        public Builder syncOneKeyLoginInfo(boolean z) {
            this.b0 = z;
            return this;
        }

        public Builder twitterOauthConfig(String str) {
            this.q = str;
            return this;
        }

        public Builder uniteVerify(boolean z) {
            this.L = z;
            return this;
        }

        public Builder wxAppID(String str) {
            this.k = str;
            return this;
        }

        public Builder xiaoAppID(Long l, String str) {
            this.n = l;
            this.v = str;
            return this;
        }

        public Builder yyOauthConfig(String str) {
            this.s = str;
            return this;
        }

        public Builder sinaAppID(String str) {
            return sinaAppID(str, Domain.DOMAIN_ONLINE.getURL(true));
        }
    }

    public SapiConfiguration(Builder builder) {
        this.supportNetwork = true;
        this.context = builder.f10638a;
        this.tpl = builder.f10639b;
        this.appId = builder.f10640c;
        this.appSignKey = builder.f10641d;
        this.environment = builder.f10643f;
        this.language = builder.f10645h;
        this.socialBindType = builder.f10644g;
        this.f10635a = builder.i;
        this.fastLoginFeatureList = builder.j;
        this.wxAppID = builder.k;
        this.qqAppID = builder.l;
        this.mzAppID = builder.m;
        this.sinaAppId = builder.o;
        this.bdOauthAppId = builder.p;
        this.meizuRedirectUri = builder.w;
        this.sinaRedirectUri = builder.x;
        this.xiaomiAppID = builder.n;
        this.xiaomiRedirectUri = builder.v;
        this.f10636b = builder.t;
        this.twitterAppKey = builder.q;
        this.googleClientId = builder.r;
        this.yyAppId = builder.s;
        this.sofireAppKey = builder.y;
        this.sofireSecKey = builder.z;
        this.sofireHostID = builder.A;
        this.realnameAuthenticateStoken = builder.u;
        this.skin = builder.B;
        this.presetPhoneNumber = builder.C;
        this.forbidPresetPhoneNumber = builder.D;
        this.customActionBarEnabled = builder.E;
        this.showBottomBack = builder.F;
        this.configurableViewLayout = builder.I;
        this.debug = builder.J;
        this.smsLoginConfig = builder.K;
        this.uniteVerify = builder.L;
        this.accountCenterRealAutnen = builder.M;
        this.forbidSslErrorDialog = builder.N;
        this.enableShare = builder.O;
        this.supportPhoto = builder.P;
        this.processName = builder.Q;
        this.isNightMode = builder.S;
        this.isDarkMode = builder.T;
        this.isNewLogin = builder.e0;
        this.showCloseBtn = builder.G;
        this.userAgent = builder.R;
        this.activityOpenAnimId = builder.U;
        this.activityExitAnimId = builder.V;
        this.disableVoiceVerify = builder.X;
        this.supportFaceLogin = builder.Y;
        this.f10637c = builder.Z;
        this.supportGestureSlide = builder.a0;
        this.syncOneKeyLoginInfo = builder.b0;
        this.supportMultipleAccounts = builder.c0;
        this.supportCheckFloatfLayer = builder.d0;
        this.textZoom = builder.f0;
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
}
