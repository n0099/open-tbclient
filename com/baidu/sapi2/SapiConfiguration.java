package com.baidu.sapi2;

import android.content.Context;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import com.baidu.sapi2.base.debug.Log;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiConfiguration;
import com.baidu.sapi2.utils.enums.BindType;
import com.baidu.sapi2.utils.enums.BiometricType;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.Language;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import com.baidu.sapi2.utils.enums.RegistMode;
import com.baidu.sapi2.utils.enums.Switch;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public final class SapiConfiguration implements ISapiConfiguration {
    public static final int JOIN_LOGIN = 4;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_CUSTOM = 3;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_FAST_REG = 2;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_LOGIN = 0;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_SMS_LOGIN = 1;
    private final LoginShareStrategy a;
    public final boolean accountCenterRealAutnen;
    public int activityExitAnimId;
    public int activityOpenAnimId;
    public final String appId;
    public final String appSignKey;
    public final List<BiometricType> biometricTypeList;
    public String clientId;
    public String clientIp;
    public final Switch configurableViewLayout;
    public final Context context;
    public final boolean customActionBarEnabled;
    public final boolean debug;
    public final boolean enableShare;
    public final Domain environment;
    public final List<FastLoginFeature> fastLoginFeatureList;
    public final boolean fastRegConfirm;
    public final String fastRegConfirmMsg;
    public final String fastRegTitleText;
    public boolean forbidPresetPhoneNumber;
    public final boolean forbidSslErrorDialog;
    public final String hwAppId;
    public final String hwLoginChannelId;
    public final boolean importSofire;
    public boolean isNightMode;
    public final Language language;
    public final boolean lowerUpdateFreq;
    public final String meizuRedirectUri;
    public final String mzAppID;
    public boolean needOpenid;
    public String presetPhoneNumber;
    public final String processName;
    public final String qqAppID;
    public final boolean quickUserEnabled;
    public final String realnameAuthenticateStoken;
    public final RegistMode registMode;
    public final boolean showBottomBack;
    public boolean showPmnRationaleDialog;
    public final boolean showRegLink;
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
        this.language = builder.i;
        this.socialBindType = builder.g;
        this.registMode = builder.h;
        this.a = builder.j;
        this.fastLoginFeatureList = builder.k;
        this.hwLoginChannelId = builder.l;
        this.wxAppID = builder.m;
        this.hwAppId = builder.n;
        this.qqAppID = builder.o;
        this.xiaomiAppID = builder.p;
        this.mzAppID = builder.q;
        this.sinaAppId = builder.r;
        this.xiaomiRedirectUri = builder.t;
        this.meizuRedirectUri = builder.u;
        this.sinaRedirectUri = builder.v;
        this.sofireAppKey = builder.w;
        this.sofireSecKey = builder.x;
        this.sofireHostID = builder.y;
        this.importSofire = builder.z;
        this.realnameAuthenticateStoken = builder.s;
        this.fastRegConfirm = builder.A;
        this.fastRegConfirmMsg = builder.B;
        this.skin = builder.C;
        this.presetPhoneNumber = builder.D;
        this.forbidPresetPhoneNumber = builder.E;
        this.customActionBarEnabled = builder.F;
        this.showBottomBack = builder.G;
        this.showRegLink = builder.H;
        this.configurableViewLayout = builder.I;
        this.fastRegTitleText = builder.J;
        this.debug = builder.K;
        this.smsLoginConfig = builder.L;
        this.uniteVerify = builder.M;
        this.syncCacheOnInit = builder.N;
        this.silentShareOnUpgrade = builder.O;
        this.quickUserEnabled = builder.P;
        this.biometricTypeList = builder.Q;
        this.accountCenterRealAutnen = builder.R;
        this.forbidSslErrorDialog = builder.S;
        this.enableShare = builder.T;
        this.supportPhoto = builder.U;
        this.processName = builder.V;
        this.supportFaceLogin = builder.X;
        this.lowerUpdateFreq = builder.Y;
        this.isNightMode = builder.Z;
        this.supportSpecialLogin = builder.aa;
        this.userAgent = builder.W;
        this.activityOpenAnimId = builder.ab;
        this.activityExitAnimId = builder.ac;
        this.showPmnRationaleDialog = builder.ad;
        this.needOpenid = builder.af;
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiConfiguration
    public String getTpl() {
        return this.tpl;
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiConfiguration
    public String getAppId() {
        return this.appId;
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiConfiguration
    public String getAppSignKey() {
        return this.appSignKey;
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiConfiguration
    public String getClientId() {
        return this.clientId;
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiConfiguration
    public String getClientIp() {
        return this.clientIp;
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiConfiguration
    public Domain getEnvironment() {
        return this.environment;
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiConfiguration
    public BindType getSocialBindType() {
        return this.socialBindType;
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiConfiguration
    public RegistMode getRegistMode() {
        return this.registMode;
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiConfiguration
    public Language getLanguage() {
        return this.language;
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiConfiguration
    public List<FastLoginFeature> getFastLoginFeatureList() {
        return this.fastLoginFeatureList;
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiConfiguration
    public String getWxAppID() {
        return this.wxAppID;
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiConfiguration
    public String getHwAppId() {
        return this.hwAppId;
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiConfiguration
    public String getQqAppID() {
        return this.qqAppID;
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiConfiguration
    public Long getXiaomiAppID() {
        return this.xiaomiAppID;
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiConfiguration
    public String getMzAppID() {
        return this.mzAppID;
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiConfiguration
    public String getXiaomiRedirectUri() {
        return this.xiaomiRedirectUri;
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiConfiguration
    public String getRealnameAuthenticateStoken() {
        return this.realnameAuthenticateStoken;
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiConfiguration
    public String getMeizuRedirectUri() {
        return this.meizuRedirectUri;
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiConfiguration
    public boolean getFastRegConfirm() {
        return this.fastRegConfirm;
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiConfiguration
    public String getFastRegConfirmMsg() {
        return this.fastRegConfirmMsg;
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiConfiguration
    public String getSkin() {
        return this.skin;
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiConfiguration
    public String getPresetPhoneNumber() {
        return this.presetPhoneNumber;
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiConfiguration
    public boolean getCustomActionBarEnabled() {
        return this.customActionBarEnabled;
    }

    public boolean getShowBottomBack() {
        return this.showBottomBack;
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiConfiguration
    public boolean getShowRegLink() {
        return this.showRegLink;
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiConfiguration
    public Switch getConfigurableViewLayout() {
        return this.configurableViewLayout;
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiConfiguration
    public String getFastRegTitleText() {
        return this.fastRegTitleText;
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiConfiguration
    public boolean getDebug() {
        return this.debug;
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiConfiguration
    public boolean getUniteVerify() {
        return this.uniteVerify;
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiConfiguration
    public boolean getSyncCacheOnInit() {
        return this.syncCacheOnInit;
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiConfiguration
    public boolean getSilentShareOnUpgrade() {
        return this.silentShareOnUpgrade;
    }

    @Override // com.baidu.sapi2.passhost.pluginsdk.service.ISapiConfiguration
    public boolean getQuickUserEnabled() {
        return this.quickUserEnabled;
    }

    public boolean getForbidSslErrorDialog() {
        return this.forbidSslErrorDialog;
    }

    /* loaded from: classes.dex */
    public static class Builder {
        private String B;
        private String C;
        private String D;
        private boolean E;
        private String J;
        private SmsLoginConfig L;
        private List<BiometricType> Q;
        private String V;
        private String W;
        private boolean X;
        private boolean Y;
        private Context a;
        private boolean af;
        private String b;
        private String c;
        private String d;
        private String e;
        private Domain f;
        private BindType g;
        private RegistMode h;
        private Language i;
        private LoginShareStrategy j;
        private List<FastLoginFeature> k;
        private String l;
        private String m;
        private String n;
        private String o;
        private Long p;
        private String q;
        private String r;
        private String s;
        private String t;
        private String u;
        private String v;
        private String w;
        private String x;
        private int y = -1;
        private boolean z = true;
        private boolean A = false;
        private boolean F = false;
        private boolean G = false;
        private boolean H = true;
        private Switch I = Switch.OFF;
        private boolean K = false;
        private boolean M = false;
        private boolean N = true;
        private boolean O = true;
        private boolean P = false;
        private boolean R = true;
        private boolean S = false;
        private boolean T = true;
        private boolean U = true;
        private boolean Z = false;
        private boolean aa = true;
        private int ab = 0;
        private int ac = 0;
        private boolean ad = false;
        private boolean ae = false;

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

        public Builder registMode(RegistMode registMode) {
            this.h = registMode;
            return this;
        }

        public Builder presetPhoneNumber(String str) {
            this.D = str;
            return this;
        }

        public Builder forbidPresetPhoneNumber(boolean z) {
            this.E = z;
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

        public Builder fastRegTitleText(String str) {
            this.J = str;
            return this;
        }

        public Builder debug(boolean z) {
            this.K = z;
            return this;
        }

        public Builder syncCacheOnInit(boolean z) {
            this.N = z;
            return this;
        }

        public Builder silentShareOnUpgrade(boolean z) {
            this.O = z;
            return this;
        }

        public Builder initialShareStrategy(LoginShareStrategy loginShareStrategy) {
            this.j = loginShareStrategy;
            return this;
        }

        public Builder fastLoginSupport(FastLoginFeature... fastLoginFeatureArr) {
            this.k = new ArrayList();
            if (fastLoginFeatureArr != null) {
                Collections.addAll(this.k, fastLoginFeatureArr);
                if (this.k.contains(FastLoginFeature.TX_WEIBO_WEBVIEW)) {
                    this.k.remove(FastLoginFeature.TX_WEIBO_WEBVIEW);
                }
            }
            return this;
        }

        public Builder wxAppID(String str) {
            this.m = str;
            return this;
        }

        public Builder hwAppID(String str) {
            this.n = str;
            return this;
        }

        public Builder hwLoginChannelId(String str) {
            this.l = str;
            return this;
        }

        public Builder qqAppID(String str) {
            this.o = str;
            return this;
        }

        public Builder sinaAppID(String str, String str2) {
            this.r = str;
            this.v = str2;
            return this;
        }

        public Builder sinaAppID(String str) {
            return sinaAppID(str, Domain.DOMAIN_ONLINE.getURL(true));
        }

        public Builder xiaomiLoginConfig(Long l, String str) {
            this.p = l;
            this.t = str;
            return this;
        }

        public Builder meizuLoginConfig(String str, String str2) {
            this.q = str;
            this.u = str2;
            return this;
        }

        public Builder realnameAuthenticateStoken(String str) {
            this.s = str;
            return this;
        }

        public Builder sofireSdkConfig(String str, String str2, int i) {
            this.w = str;
            this.x = str2;
            this.y = i;
            return this;
        }

        public Builder importSofireSdk(boolean z) {
            this.z = z;
            return this;
        }

        public Builder fastRegConfirm(boolean z) {
            this.A = z;
            return this;
        }

        public Builder fastRegConfirmMsg(String str) {
            this.B = str;
            return this;
        }

        public Builder skin(String str) {
            this.C = str;
            return this;
        }

        public Builder customActionBar(boolean z) {
            this.F = z;
            return this;
        }

        public Builder showBottomBack(boolean z) {
            this.G = z;
            return this;
        }

        public Builder enableQuickUser(boolean z) {
            this.P = z;
            return this;
        }

        public Builder smsLoginConfig(SmsLoginConfig smsLoginConfig) {
            this.L = smsLoginConfig;
            return this;
        }

        public Builder uniteVerify(boolean z) {
            this.M = z;
            return this;
        }

        public Builder setSupportFaceLogin(boolean z) {
            this.X = z;
            return this;
        }

        public Builder setLowerUpdateFreq(boolean z) {
            this.Y = z;
            return this;
        }

        public Builder setNeedOpenid(boolean z) {
            this.af = z;
            SapiContext.MAX_SHARE_ACCOUNTS = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            return this;
        }

        public Builder setProcessName(String str) {
            boolean z;
            if (!TextUtils.isEmpty(str)) {
                Iterator<String> it = SapiOptions.i().iterator();
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
                    this.V = str;
                }
            }
            return this;
        }

        public Builder setLanguage(Language language) {
            this.i = language;
            return this;
        }

        public Builder biometricTypeSupport(BiometricType... biometricTypeArr) {
            this.Q = new ArrayList();
            if (biometricTypeArr != null) {
                Collections.addAll(this.Q, biometricTypeArr);
            }
            return this;
        }

        public Builder supportRealNameAuthen(boolean z) {
            this.R = z;
            return this;
        }

        public Builder setSupportPhoto(boolean z) {
            this.U = z;
            return this;
        }

        public Builder forbidSslErrorDalog(boolean z) {
            this.S = z;
            return this;
        }

        public Builder enableShare(boolean z) {
            this.T = z;
            return this;
        }

        public Builder customWebviewUA(String str) {
            this.W = str;
            return this;
        }

        public Builder setNightMode(boolean z) {
            this.Z = z;
            return this;
        }

        public Builder setSupSpecialLogin(boolean z) {
            this.aa = z;
            return this;
        }

        public Builder setActivityAnim(int i, int i2) {
            this.ab = i;
            this.ac = i2;
            return this;
        }

        public Builder showPmnRationaleDialog(boolean z) {
            this.ad = z;
            return this;
        }

        public Builder setSupNewVerSapiLogin(boolean z) {
            this.ae = z;
            return this;
        }

        public SapiConfiguration build() {
            if (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.c) || TextUtils.isEmpty(this.d)) {
                throw new IllegalArgumentException("tpl, appId, appsignkey can not be null, please use setProductLineInfo(String tpl, String appId, String appSignKey)to initialize them.");
            }
            if (this.f == null) {
                this.f = Domain.DOMAIN_ONLINE;
            }
            if (this.i == null) {
                this.i = Language.CHINESE;
            }
            if (this.g == null) {
                this.g = BindType.BIND_MOBILE;
            }
            if (this.h == null) {
                this.h = RegistMode.NORMAL;
            }
            if (this.j == null) {
                this.j = LoginShareStrategy.getDefault();
            }
            if (this.k == null) {
                this.k = new ArrayList();
            }
            if (this.L == null) {
                this.L = new SmsLoginConfig(Switch.OFF, Switch.OFF, Switch.OFF);
            }
            if (this.I == null) {
                this.I = Switch.OFF;
            }
            if (this.Q == null) {
                this.Q = new ArrayList();
            }
            if (this.G) {
                this.F = true;
            }
            Log.enable(this.K);
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
        if (this.quickUserEnabled) {
            return LoginShareStrategy.DISABLED;
        }
        SapiOptions sapiOptions = SapiContext.getInstance(this.context).getSapiOptions();
        if (sapiOptions.getSpecificShareStrategy().containsKey(this.tpl) && sapiOptions.getSpecificShareStrategy().get(this.tpl) != null) {
            return sapiOptions.getSpecificShareStrategy().get(this.tpl);
        }
        if (sapiOptions.getGlobalShareStrategy() != null) {
            return sapiOptions.getGlobalShareStrategy();
        }
        return this.a;
    }
}
