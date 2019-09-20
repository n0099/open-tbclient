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
import com.baidu.sapi2.utils.enums.ShareDirectionType;
import com.baidu.sapi2.utils.enums.Switch;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public final class SapiConfiguration {
    public static final int JOIN_LOGIN = 4;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_CHINA_MOBILE_OAUTH = 5;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_FACE_LOGIN = 4;
    @Deprecated
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_FAST_REG = 2;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_LOGIN = 0;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_SMS_LOGIN = 1;
    private final LoginShareStrategy a;
    public final boolean accountCenterRealAutnen;
    public int activityExitAnimId;
    public int activityOpenAnimId;
    public final String appId;
    public final String appSignKey;
    private boolean b;
    public final String bdOauthAppId;
    public String chinaMobileAppID;
    public String chinaMobileAppKey;
    public String chinaTelecomAppKey;
    public String chinaTelecomAppSecret;
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
    public boolean showPmnRationaleDialog;
    public String sidValue;
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
    public boolean supportGuestAccountLogin;
    public final boolean supportPhoto;
    public boolean supportSpecialLogin;
    public final boolean syncCacheOnInit;
    public final String tpl;
    public final boolean uniteVerify;
    public final String userAgent;
    public final String wxAppID;
    public final Long xiaomiAppID;
    public final String xiaomiRedirectUri;

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
        this.xiaomiAppID = builder.m;
        this.mzAppID = builder.n;
        this.sinaAppId = builder.o;
        this.bdOauthAppId = builder.p;
        this.xiaomiRedirectUri = builder.v;
        this.meizuRedirectUri = builder.w;
        this.sinaRedirectUri = builder.x;
        this.chinaMobileAppID = builder.q;
        this.chinaMobileAppKey = builder.r;
        this.chinaTelecomAppKey = builder.s;
        this.chinaTelecomAppSecret = builder.t;
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
        this.syncCacheOnInit = builder.M;
        this.silentShareOnUpgrade = builder.N;
        this.accountCenterRealAutnen = builder.O;
        this.forbidSslErrorDialog = builder.P;
        this.enableShare = builder.Q;
        this.supportPhoto = builder.R;
        this.processName = builder.S;
        this.isNightMode = builder.U;
        this.showCloseBtn = builder.G;
        this.supportSpecialLogin = builder.V;
        this.userAgent = builder.T;
        this.activityOpenAnimId = builder.W;
        this.activityExitAnimId = builder.X;
        this.showPmnRationaleDialog = builder.Y;
        this.disableVoiceVerify = builder.aa;
        this.needOpenid = builder.ab;
        this.supportFaceLogin = builder.ac;
        this.b = builder.ad;
    }

    public String getTpl() {
        return this.tpl;
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

    public Domain getEnvironment() {
        return this.environment;
    }

    public BindType getSocialBindType() {
        return this.socialBindType;
    }

    public Language getLanguage() {
        return this.language;
    }

    public List<FastLoginFeature> getFastLoginFeatureList() {
        return this.fastLoginFeatureList;
    }

    public String getWxAppID() {
        return this.wxAppID;
    }

    public String getQqAppID() {
        return this.qqAppID;
    }

    public Long getXiaomiAppID() {
        return this.xiaomiAppID;
    }

    public String getMzAppID() {
        return this.mzAppID;
    }

    public String getXiaomiRedirectUri() {
        return this.xiaomiRedirectUri;
    }

    public String getRealnameAuthenticateStoken() {
        return this.realnameAuthenticateStoken;
    }

    public String getMeizuRedirectUri() {
        return this.meizuRedirectUri;
    }

    public String getSkin() {
        return this.skin;
    }

    public String getPresetPhoneNumber() {
        return this.presetPhoneNumber;
    }

    public boolean getCustomActionBarEnabled() {
        return this.customActionBarEnabled;
    }

    public Switch getConfigurableViewLayout() {
        return this.configurableViewLayout;
    }

    public boolean getDebug() {
        return this.debug;
    }

    public boolean getUniteVerify() {
        return this.uniteVerify;
    }

    public boolean getSyncCacheOnInit() {
        return this.syncCacheOnInit;
    }

    public boolean getSilentShareOnUpgrade() {
        return this.silentShareOnUpgrade;
    }

    public boolean getForbidSslErrorDialog() {
        return this.forbidSslErrorDialog;
    }

    /* loaded from: classes.dex */
    public static class Builder {
        private String B;
        private String C;
        private boolean D;
        private SmsLoginConfig K;
        private String S;
        private String T;
        private Context a;
        private boolean ab;
        private String b;
        private String c;
        private String d;
        private String e;
        private Domain f;
        private BindType g;
        private Language h;
        private LoginShareStrategy i;
        private List<FastLoginFeature> j;
        private String k;
        private String l;
        private Long m;
        private String n;
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
        private String y;
        private String z;
        private int A = -1;
        private boolean E = false;
        private boolean F = false;
        private boolean G = false;
        private boolean H = true;
        private Switch I = Switch.OFF;
        private boolean J = false;
        private boolean L = false;
        private boolean M = true;
        private boolean N = true;
        private boolean O = true;
        private boolean P = false;
        private boolean Q = true;
        private boolean R = true;
        private boolean U = false;
        private boolean V = true;
        private int W = 0;
        private int X = 0;
        private boolean Y = false;
        private boolean Z = false;
        private boolean aa = true;
        private boolean ac = true;
        private boolean ad = true;

        public Builder(Context context) {
            this.a = context.getApplicationContext();
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

        public Builder setSocialBindType(BindType bindType) {
            this.g = bindType;
            return this;
        }

        public Builder presetPhoneNumber(String str) {
            this.C = str;
            return this;
        }

        public Builder forbidPresetPhoneNumber(boolean z) {
            this.D = z;
            return this;
        }

        public Builder showRegLink(boolean z) {
            this.H = z;
            return this;
        }

        public Builder configurableViewLayout(Switch r1) {
            this.I = r1;
            return this;
        }

        public Builder debug(boolean z) {
            this.J = z;
            return this;
        }

        public Builder syncCacheOnInit(boolean z) {
            this.M = z;
            return this;
        }

        public Builder silentShareOnUpgrade(boolean z) {
            this.N = z;
            return this;
        }

        public Builder initialShareStrategy(LoginShareStrategy loginShareStrategy) {
            this.i = loginShareStrategy;
            return this;
        }

        public Builder fastLoginSupport(FastLoginFeature... fastLoginFeatureArr) {
            this.j = new ArrayList();
            if (fastLoginFeatureArr != null) {
                Collections.addAll(this.j, fastLoginFeatureArr);
            }
            return this;
        }

        public Builder wxAppID(String str) {
            this.k = str;
            return this;
        }

        public Builder qqAppID(String str) {
            this.l = str;
            return this;
        }

        public Builder sinaAppID(String str, String str2) {
            this.o = str;
            this.x = str2;
            return this;
        }

        public Builder bdOauthAppId(String str) {
            this.p = str;
            return this;
        }

        public Builder sinaAppID(String str) {
            return sinaAppID(str, Domain.DOMAIN_ONLINE.getURL(true));
        }

        public Builder xiaomiLoginConfig(Long l, String str) {
            this.m = l;
            this.v = str;
            return this;
        }

        public Builder meizuLoginConfig(String str, String str2) {
            this.n = str;
            this.w = str2;
            return this;
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

        public Builder realnameAuthenticateStoken(String str) {
            this.u = str;
            return this;
        }

        public Builder sofireSdkConfig(String str, String str2, int i) {
            this.y = str;
            this.z = str2;
            this.A = i;
            return this;
        }

        public Builder skin(String str) {
            this.B = str;
            return this;
        }

        public Builder customActionBar(boolean z) {
            this.E = z;
            return this;
        }

        public Builder showBottomBack(boolean z) {
            this.F = z;
            return this;
        }

        public Builder smsLoginConfig(SmsLoginConfig smsLoginConfig) {
            this.K = smsLoginConfig;
            return this;
        }

        public Builder uniteVerify(boolean z) {
            this.L = z;
            return this;
        }

        public Builder setSupportFaceLogin(boolean z) {
            this.ac = z;
            return this;
        }

        public Builder setSupportTouchLogin(boolean z) {
            this.ad = z;
            return this;
        }

        public Builder setLowerUpdateFreq(boolean z) {
            return this;
        }

        public Builder setNeedOpenid(boolean z) {
            this.ab = z;
            SapiContext.MAX_SHARE_ACCOUNTS = Integer.MAX_VALUE;
            return this;
        }

        public Builder setProcessName(String str) {
            boolean z;
            if (!TextUtils.isEmpty(str)) {
                Iterator<String> it = SapiOptions.g().iterator();
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
                    this.S = str;
                }
            }
            return this;
        }

        public Builder setLanguage(Language language) {
            this.h = language;
            return this;
        }

        public Builder supportRealNameAuthen(boolean z) {
            this.O = z;
            return this;
        }

        public Builder setSupportPhoto(boolean z) {
            this.R = z;
            return this;
        }

        public Builder forbidSslErrorDalog(boolean z) {
            this.P = z;
            return this;
        }

        public Builder enableShare(boolean z) {
            this.Q = z;
            return this;
        }

        public Builder customWebviewUA(String str) {
            this.T = str;
            return this;
        }

        public Builder setNightMode(boolean z) {
            this.U = z;
            return this;
        }

        public Builder setShowCloseBtn(boolean z) {
            this.G = z;
            return this;
        }

        public Builder setSupSpecialLogin(boolean z) {
            this.V = z;
            return this;
        }

        public Builder setActivityAnim(int i, int i2) {
            this.W = i;
            this.X = i2;
            return this;
        }

        public Builder showPmnRationaleDialog(boolean z) {
            this.Y = z;
            return this;
        }

        public Builder setSupNewVerSapiLogin(boolean z) {
            this.Z = z;
            return this;
        }

        public Builder setDisableVoiceVerify(boolean z) {
            this.aa = z;
            return this;
        }

        public SapiConfiguration build() {
            if (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.c) || TextUtils.isEmpty(this.d)) {
                throw new IllegalArgumentException("tpl, appId, appsignkey can not be null, please use setProductLineInfo(String tpl, String appId, String appSignKey)to initialize them.");
            }
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
            if (this.K == null) {
                this.K = new SmsLoginConfig(Switch.OFF, Switch.OFF, Switch.OFF);
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
    }

    /* loaded from: classes.dex */
    public static class SmsLoginConfig {
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
            this.flagShowFastRegLink = Switch.OFF;
            this.flagHideExtraEntry = Switch.OFF;
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

    public LoginShareStrategy loginShareStrategy() {
        SapiOptions sapiOptions = SapiContext.getInstance(this.context).getSapiOptions();
        LoginShareStrategy loginShareStrategy = sapiOptions.getSpecificShareStrategy().get(this.tpl);
        if (loginShareStrategy == null) {
            if (sapiOptions.getGlobalShareStrategy() != null) {
                return sapiOptions.getGlobalShareStrategy();
            }
            return this.a;
        }
        return loginShareStrategy;
    }

    public String loginShareDirection() {
        String str = SapiContext.getInstance(this.context).getSapiOptions().shareDirection.get(this.tpl);
        if (TextUtils.isEmpty(str)) {
            return ShareDirectionType.BOTH;
        }
        return str;
    }

    public boolean isSupportTouchLogin() {
        return this.b && SapiContext.getInstance(this.context).getSapiOptions().gray.a(SapiOptions.b.a).c;
    }

    public Context getContext() {
        return this.context;
    }
}
