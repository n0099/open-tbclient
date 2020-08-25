package com.baidu.sapi2;

import android.content.Context;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import com.baidu.sapi2.e;
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
/* loaded from: classes12.dex */
public final class SapiConfiguration implements NoProguard {
    public static final int JOIN_LOGIN = 4;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_CHINA_MOBILE_OAUTH = 5;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_FACE_LOGIN = 4;
    @Deprecated
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_FAST_REG = 2;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_LOGIN = 0;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_NAME_PHONE_EMAIL_LOGIN = 6;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_SMS_LOGIN = 1;
    private final LoginShareStrategy a;
    public final boolean accountCenterRealAutnen;
    public int activityExitAnimId;
    public int activityOpenAnimId;
    public final String appId;
    public final String appSignKey;
    private boolean b;
    public final String bdOauthAppId;
    private boolean c;
    public String chinaMobileAppID;
    public String chinaMobileAppKey;
    public String chinaTelecomAppKey;
    public String chinaTelecomAppSecret;
    public String chinaUnicomAppKey;
    public String chinaUnicomAppPublicKey;
    public String clientId;
    public String clientIp;
    public final Switch configurableViewLayout;
    public final Context context;
    public final boolean customActionBarEnabled;
    public final boolean debug;
    public boolean disableVoiceVerify;
    public final boolean enableShare;
    public final Domain environment;
    public final List<FastLoginFeature> fastLoginFeatureList;
    public boolean forbidPresetPhoneNumber;
    public final boolean forbidSslErrorDialog;
    public String googleClientId;
    public boolean isDarkMode;
    public boolean isNightMode;
    public final Language language;
    public final String meizuRedirectUri;
    public final String mzAppID;
    public boolean needOpenid;
    public String presetPhoneNumber;
    public final String processName;
    public final String qqAppID;
    public final String realnameAuthenticateStoken;
    public boolean showBottomBack;
    public boolean showCloseBtn;
    public final boolean silentShareOnUpgrade;
    public final String sinaAppId;
    public final String sinaRedirectUri;
    public String skin;
    public final SmsLoginConfig smsLoginConfig;
    public final BindType socialBindType;
    public final String sofireAppKey;
    public final int sofireHostID;
    public final String sofireSecKey;
    public boolean supportFaceLogin;
    public boolean supportGestureSlide;
    public boolean supportGuestAccountLogin;
    public boolean supportMultipleAccounts;
    public final boolean supportPhoto;
    public boolean syncOneKeyLoginInfo;
    public final String tpl;
    public String twitterAppKey;
    public final boolean uniteVerify;
    public final String userAgent;
    public final String wxAppID;
    public final Long xiaomiAppID;
    public final String xiaomiRedirectUri;

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

    public boolean getSilentShareOnUpgrade() {
        return this.silentShareOnUpgrade;
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
        return this.b;
    }

    public boolean isSupportTouchLogin() {
        return this.c && SapiContext.getInstance().getSapiOptions().u.a(e.c.c).c;
    }

    public String loginShareDirection() {
        String str = SapiContext.getInstance().getSapiOptions().j.get(this.tpl);
        return TextUtils.isEmpty(str) ? com.baidu.sapi2.utils.enums.a.c : str;
    }

    public LoginShareStrategy loginShareStrategy() {
        e sapiOptions = SapiContext.getInstance().getSapiOptions();
        LoginShareStrategy loginShareStrategy = sapiOptions.p().get(this.tpl);
        if (loginShareStrategy == null) {
            if (sapiOptions.h() != null) {
                return sapiOptions.h();
            }
            return this.a;
        }
        return loginShareStrategy;
    }

    public void setAgreeDangerousProtocol(boolean z) {
        this.b = z;
        try {
            FH.setAgreePolicy(this.context, this.b);
        } catch (Exception e) {
            Log.e(e);
        }
    }

    /* loaded from: classes12.dex */
    public static class Builder implements NoProguard {
        private String A;
        private String B;
        private String C;
        private String G;
        private String H;
        private boolean I;
        private SmsLoginConfig P;
        private String W;
        private String X;
        private Context a;
        private String b;
        private String c;
        private String d;
        private String e;
        private boolean e0;
        private Domain f;
        private BindType g;
        private Language h;
        private LoginShareStrategy i;
        private List<FastLoginFeature> j;
        private String k;
        private String l;
        private String m;
        private Long n;
        private String o;
        private String p;
        private String q;
        private String r;
        private String s;
        private String t;
        private String u;
        private String v;
        private String w;
        private String x;
        private String z;
        private boolean y = true;
        private String D = "740000";
        private String E = "a7968de484f90a9036b5f2b40382ea43";
        private int F = 1;
        private boolean J = false;
        private boolean K = false;
        private boolean L = false;
        private boolean M = true;
        private Switch N = Switch.OFF;
        private boolean O = false;
        private boolean Q = false;
        private boolean R = true;
        private boolean S = true;
        private boolean T = false;
        private boolean U = true;
        private boolean V = true;
        private boolean Y = false;
        private boolean Z = false;
        private int a0 = 0;
        private int b0 = 0;
        private boolean c0 = false;
        private boolean d0 = true;
        private boolean f0 = true;
        private boolean g0 = true;
        private boolean h0 = true;
        private boolean i0 = true;
        private boolean j0 = true;

        public Builder(Context context) {
            this.a = context.getApplicationContext();
        }

        public Builder bdOauthAppId(String str) {
            this.p = str;
            return this;
        }

        public SapiConfiguration build() {
            if (!TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(this.c) && !TextUtils.isEmpty(this.d)) {
                if (this.f == null) {
                    this.f = Domain.DOMAIN_ONLINE;
                }
                if (this.h == null) {
                    this.h = Language.CHINESE;
                }
                if (this.g == null) {
                    this.g = BindType.BIND_MOBILE;
                }
                if (this.i == null) {
                    this.i = LoginShareStrategy.getDefault();
                }
                if (this.j == null) {
                    this.j = new ArrayList();
                }
                if (this.P == null) {
                    Switch r1 = Switch.OFF;
                    this.P = new SmsLoginConfig(r1, r1, r1);
                }
                if (this.N == null) {
                    this.N = Switch.OFF;
                }
                if (this.K) {
                    this.J = true;
                }
                Log.enable(this.O);
                return new SapiConfiguration(this);
            }
            throw new IllegalArgumentException("tpl, appId, appsignkey can not be null, please use setProductLineInfo(String tpl, String appId, String appSignKey)to initialize them.");
        }

        public Builder chinaMobileOauthConfig(String str, String str2) {
            this.q = str;
            this.r = str2;
            return this;
        }

        public Builder chinaTelecomOauthConfig(String str, String str2) {
            this.s = str;
            this.t = str2;
            return this;
        }

        public Builder chinaUnicomOauthConfig(String str, String str2) {
            this.u = str;
            this.v = str2;
            return this;
        }

        public Builder configurableViewLayout(Switch r1) {
            this.N = r1;
            return this;
        }

        public Builder customActionBar(boolean z) {
            this.J = z;
            return this;
        }

        public Builder customWebviewUA(String str) {
            this.X = str;
            return this;
        }

        public Builder debug(boolean z) {
            this.O = z;
            return this;
        }

        public Builder enableShare(boolean z) {
            this.U = z;
            return this;
        }

        public Builder fastLoginSupport(FastLoginFeature... fastLoginFeatureArr) {
            this.j = new ArrayList();
            if (fastLoginFeatureArr != null) {
                Collections.addAll(this.j, fastLoginFeatureArr);
            }
            return this;
        }

        public Builder forbidPresetPhoneNumber(boolean z) {
            this.I = z;
            return this;
        }

        public Builder forbidSslErrorDalog(boolean z) {
            this.T = z;
            return this;
        }

        public Builder googleOauthConfig(String str) {
            this.x = str;
            return this;
        }

        public Builder initialShareStrategy(LoginShareStrategy loginShareStrategy) {
            this.i = loginShareStrategy;
            return this;
        }

        public Builder meizuLoginConfig(String str, String str2) {
            this.m = str;
            this.B = str2;
            return this;
        }

        public Builder presetPhoneNumber(String str) {
            this.H = str;
            return this;
        }

        public Builder qqAppID(String str) {
            this.l = str;
            return this;
        }

        public Builder realnameAuthenticateStoken(String str) {
            this.z = str;
            return this;
        }

        public Builder setActivityAnim(int i, int i2) {
            this.a0 = i;
            this.b0 = i2;
            return this;
        }

        public Builder setAgreeDangerousProtocol(boolean z) {
            this.y = z;
            try {
                FH.setAgreePolicy(this.a, z);
            } catch (Exception e) {
                Log.e(e);
            }
            return this;
        }

        public Builder setDarkMode(boolean z) {
            this.Z = z;
            return this;
        }

        public Builder setDisableVoiceVerify(boolean z) {
            this.d0 = z;
            return this;
        }

        public Builder setLanguage(Language language) {
            this.h = language;
            return this;
        }

        public Builder setLowerUpdateFreq(boolean z) {
            return this;
        }

        public Builder setNeedOpenid(boolean z) {
            this.e0 = z;
            SapiContext.MAX_SHARE_ACCOUNTS = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            return this;
        }

        public Builder setNightMode(boolean z) {
            this.Y = z;
            return this;
        }

        public Builder setProcessName(String str) {
            boolean z;
            if (!TextUtils.isEmpty(str)) {
                Iterator<String> it = e.u().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    } else if (str.matches(it.next())) {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    this.W = str;
                }
            }
            return this;
        }

        public Builder setProductLineInfo(String str, String str2, String str3) {
            this.b = str;
            this.c = str2;
            this.d = str3;
            return this;
        }

        public Builder setRuntimeEnvironment(Domain domain) {
            this.f = domain;
            return this;
        }

        public Builder setShowCloseBtn(boolean z) {
            this.L = z;
            return this;
        }

        public Builder setSocialBindType(BindType bindType) {
            this.g = bindType;
            return this;
        }

        public Builder setSupNewVerSapiLogin(boolean z) {
            this.c0 = z;
            return this;
        }

        public Builder setSupportFaceLogin(boolean z) {
            this.f0 = z;
            return this;
        }

        public Builder setSupportGestureSlide(boolean z) {
            this.h0 = z;
            return this;
        }

        public Builder setSupportMultipleAccounts(boolean z) {
            this.j0 = z;
            return this;
        }

        public Builder setSupportPhoto(boolean z) {
            this.V = z;
            return this;
        }

        public Builder setSupportTouchLogin(boolean z) {
            this.g0 = z;
            return this;
        }

        public Builder showBottomBack(boolean z) {
            this.K = z;
            return this;
        }

        public Builder showRegLink(boolean z) {
            this.M = z;
            return this;
        }

        public Builder silentShareOnUpgrade(boolean z) {
            this.R = z;
            return this;
        }

        public Builder sinaAppID(String str, String str2) {
            this.o = str;
            this.C = str2;
            return this;
        }

        public Builder skin(String str) {
            this.G = str;
            return this;
        }

        public Builder smsLoginConfig(SmsLoginConfig smsLoginConfig) {
            this.P = smsLoginConfig;
            return this;
        }

        public Builder sofireSdkConfig(String str, String str2, int i) {
            this.D = str;
            this.E = str2;
            this.F = i;
            return this;
        }

        public Builder supportRealNameAuthen(boolean z) {
            this.S = z;
            return this;
        }

        public Builder syncOneKeyLoginInfo(boolean z) {
            this.i0 = z;
            return this;
        }

        public Builder twitterOauthConfig(String str) {
            this.w = str;
            return this;
        }

        public Builder uniteVerify(boolean z) {
            this.Q = z;
            return this;
        }

        public Builder wxAppID(String str) {
            this.k = str;
            return this;
        }

        public Builder xiaoAppID(Long l, String str) {
            this.n = l;
            this.A = str;
            return this;
        }

        public Builder sinaAppID(String str) {
            return sinaAppID(str, Domain.DOMAIN_ONLINE.getURL(true));
        }
    }

    private SapiConfiguration(Builder builder) {
        this.context = builder.a;
        this.tpl = builder.b;
        this.appId = builder.c;
        this.appSignKey = builder.d;
        this.environment = builder.f;
        this.language = builder.h;
        this.socialBindType = builder.g;
        this.a = builder.i;
        this.fastLoginFeatureList = builder.j;
        this.wxAppID = builder.k;
        this.qqAppID = builder.l;
        this.mzAppID = builder.m;
        this.sinaAppId = builder.o;
        this.bdOauthAppId = builder.p;
        this.meizuRedirectUri = builder.B;
        this.sinaRedirectUri = builder.C;
        this.xiaomiAppID = builder.n;
        this.xiaomiRedirectUri = builder.A;
        this.chinaMobileAppID = builder.q;
        this.chinaMobileAppKey = builder.r;
        this.chinaTelecomAppKey = builder.s;
        this.chinaTelecomAppSecret = builder.t;
        this.b = builder.y;
        this.chinaUnicomAppKey = builder.u;
        this.chinaUnicomAppPublicKey = builder.v;
        this.twitterAppKey = builder.w;
        this.googleClientId = builder.x;
        this.sofireAppKey = builder.D;
        this.sofireSecKey = builder.E;
        this.sofireHostID = builder.F;
        this.realnameAuthenticateStoken = builder.z;
        this.skin = builder.G;
        this.presetPhoneNumber = builder.H;
        this.forbidPresetPhoneNumber = builder.I;
        this.customActionBarEnabled = builder.J;
        this.showBottomBack = builder.K;
        this.configurableViewLayout = builder.N;
        this.debug = builder.O;
        this.smsLoginConfig = builder.P;
        this.uniteVerify = builder.Q;
        this.silentShareOnUpgrade = builder.R;
        this.accountCenterRealAutnen = builder.S;
        this.forbidSslErrorDialog = builder.T;
        this.enableShare = builder.U;
        this.supportPhoto = builder.V;
        this.processName = builder.W;
        this.isNightMode = builder.Y;
        this.isDarkMode = builder.Z;
        this.showCloseBtn = builder.L;
        this.userAgent = builder.X;
        this.activityOpenAnimId = builder.a0;
        this.activityExitAnimId = builder.b0;
        this.disableVoiceVerify = builder.d0;
        this.needOpenid = builder.e0;
        this.supportFaceLogin = builder.f0;
        this.c = builder.g0;
        this.supportGestureSlide = builder.h0;
        this.syncOneKeyLoginInfo = builder.i0;
        this.supportMultipleAccounts = builder.j0;
    }

    /* loaded from: classes12.dex */
    public static class SmsLoginConfig implements NoProguard {
        public Switch flagHideExtraEntry;
        public Switch flagLoginBtnType;
        public Switch flagShowFastRegLink;
        public Switch flagShowLoginLink;
        public Switch flagShowSmsLoginLink;

        public SmsLoginConfig(Switch r2, Switch r3, @Deprecated Switch r4) {
            r2 = r2 == null ? Switch.OFF : r2;
            r3 = r3 == null ? Switch.OFF : r3;
            r4 = r4 == null ? Switch.OFF : r4;
            this.flagShowLoginLink = r2;
            this.flagShowSmsLoginLink = r3;
            this.flagLoginBtnType = r4;
            Switch r0 = Switch.OFF;
            this.flagShowFastRegLink = r0;
            this.flagHideExtraEntry = r0;
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
