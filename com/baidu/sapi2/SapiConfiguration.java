package com.baidu.sapi2;

import android.content.Context;
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
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_CUSTOM = 3;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_FAST_REG = 2;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_LOGIN = 0;
    public static final int QUICK_LOGIN_VIEW_BTN_ACTION_SMS_LOGIN = 1;
    private final LoginShareStrategy a;
    public final boolean accountCenterRealAutnen;
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
    public boolean isNightMode;
    public final Language language;
    public final boolean lowerUpdateFreq;
    public final String meizuRedirectUri;
    public final String mzAppID;
    public String presetPhoneNumber;
    public final String processName;
    public final String qqAppID;
    public final boolean quickUserEnabled;
    public final String realnameAuthenticateStoken;
    public final RegistMode registMode;
    public final boolean showRegLink;
    public final boolean silentShareOnUpgrade;
    public String skin;
    public final SmsLoginConfig smsLoginConfig;
    public final BindType socialBindType;
    public final String sofireAppKey;
    public final int sofireHostID;
    public final String sofireSecKey;
    public final boolean supportFaceLogin;
    public final boolean supportPhoto;
    public final boolean syncCacheOnInit;
    public final String tpl;
    public final boolean uniteVerify;
    public final String userAgent;
    public final String voicePid;
    public final String wxAppID;
    public final Long xiaomiAppID;
    public final String xiaomiRedirectUri;

    private SapiConfiguration(Builder builder) {
        this.voicePid = "2048";
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
        this.xiaomiRedirectUri = builder.s;
        this.meizuRedirectUri = builder.t;
        this.sofireAppKey = builder.u;
        this.sofireSecKey = builder.v;
        this.sofireHostID = builder.w;
        this.realnameAuthenticateStoken = builder.r;
        this.fastRegConfirm = builder.x;
        this.fastRegConfirmMsg = builder.y;
        this.skin = builder.z;
        this.presetPhoneNumber = builder.A;
        this.forbidPresetPhoneNumber = builder.B;
        this.customActionBarEnabled = builder.C;
        this.showRegLink = builder.D;
        this.configurableViewLayout = builder.E;
        this.fastRegTitleText = builder.F;
        this.debug = builder.G;
        this.smsLoginConfig = builder.H;
        this.uniteVerify = builder.I;
        this.syncCacheOnInit = builder.J;
        this.silentShareOnUpgrade = builder.K;
        this.quickUserEnabled = builder.L;
        this.biometricTypeList = builder.M;
        this.accountCenterRealAutnen = builder.N;
        this.forbidSslErrorDialog = builder.O;
        this.enableShare = builder.P;
        this.supportPhoto = builder.Q;
        this.processName = builder.R;
        this.supportFaceLogin = builder.T;
        this.lowerUpdateFreq = builder.U;
        this.isNightMode = builder.V;
        this.userAgent = builder.S;
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
    public String getVoicePid() {
        return "2048";
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
        private String A;
        private boolean B;
        private String F;
        private SmsLoginConfig H;
        private List<BiometricType> M;
        private String R;
        private String S;
        private boolean T;
        private boolean U;
        private Context a;
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
        private String y;
        private String z;
        private int w = -1;
        private boolean x = false;
        private boolean C = false;
        private boolean D = true;
        private Switch E = Switch.OFF;
        private boolean G = false;
        private boolean I = false;
        private boolean J = true;
        private boolean K = true;
        private boolean L = false;
        private boolean N = true;
        private boolean O = false;
        private boolean P = true;
        private boolean Q = true;
        private boolean V = false;

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
            this.A = str;
            return this;
        }

        public Builder forbidPresetPhoneNumber(boolean z) {
            this.B = z;
            return this;
        }

        public Builder showRegLink(boolean z) {
            this.D = z;
            return this;
        }

        public Builder configurableViewLayout(Switch r1) {
            this.E = r1;
            return this;
        }

        public Builder fastRegTitleText(String str) {
            this.F = str;
            return this;
        }

        public Builder debug(boolean z) {
            this.G = z;
            return this;
        }

        public Builder syncCacheOnInit(boolean z) {
            this.J = z;
            return this;
        }

        public Builder silentShareOnUpgrade(boolean z) {
            this.K = z;
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
                if (this.k.contains(FastLoginFeature.SINA_WEIBO_SSO) && this.k.contains(FastLoginFeature.SINA_WEIBO_WEBVIEW)) {
                    this.k.remove(FastLoginFeature.SINA_WEIBO_SSO);
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

        public Builder xiaomiLoginConfig(Long l, String str) {
            this.p = l;
            this.s = str;
            return this;
        }

        public Builder meizuLoginConfig(String str, String str2) {
            this.q = str;
            this.t = str2;
            return this;
        }

        public Builder realnameAuthenticateStoken(String str) {
            this.r = str;
            return this;
        }

        public Builder sofireSdkConfig(String str, String str2, int i) {
            this.u = str;
            this.v = str2;
            this.w = i;
            return this;
        }

        public Builder fastRegConfirm(boolean z) {
            this.x = z;
            return this;
        }

        public Builder fastRegConfirmMsg(String str) {
            this.y = str;
            return this;
        }

        public Builder skin(String str) {
            this.z = str;
            return this;
        }

        public Builder customActionBar(boolean z) {
            this.C = z;
            return this;
        }

        public Builder enableQuickUser(boolean z) {
            this.L = z;
            return this;
        }

        public Builder smsLoginConfig(SmsLoginConfig smsLoginConfig) {
            this.H = smsLoginConfig;
            return this;
        }

        public Builder uniteVerify(boolean z) {
            this.I = z;
            return this;
        }

        public Builder setFaceAppName(String str) {
            return this;
        }

        public Builder setSupportFaceLogin(boolean z) {
            this.T = z;
            return this;
        }

        public Builder setLowerUpdateFreq(boolean z) {
            this.U = z;
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
                    this.R = str;
                }
            }
            return this;
        }

        public Builder setLanguage(Language language) {
            this.i = language;
            return this;
        }

        public Builder biometricTypeSupport(BiometricType... biometricTypeArr) {
            this.M = new ArrayList();
            if (biometricTypeArr != null) {
                Collections.addAll(this.M, biometricTypeArr);
            }
            return this;
        }

        public Builder supportRealNameAuthen(boolean z) {
            this.N = z;
            return this;
        }

        public Builder setSupportPhoto(boolean z) {
            this.Q = z;
            return this;
        }

        public Builder forbidSslErrorDalog(boolean z) {
            this.O = z;
            return this;
        }

        public Builder enableShare(boolean z) {
            this.P = z;
            return this;
        }

        public Builder customWebviewUA(String str) {
            this.S = str;
            return this;
        }

        public Builder setNightMode(boolean z) {
            this.V = z;
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
            if (this.H == null) {
                this.H = new SmsLoginConfig(Switch.OFF, Switch.OFF, Switch.OFF);
            }
            if (this.E == null) {
                this.E = Switch.OFF;
            }
            if (this.M == null) {
                this.M = new ArrayList();
            }
            Log.enable(this.G);
            return new SapiConfiguration(this);
        }
    }

    /* loaded from: classes.dex */
    public static class SmsLoginConfig {
        public final Switch flagLoginBtnType;
        public final Switch flagShowFastRegLink;
        public final Switch flagShowLoginLink;
        public final Switch flagShowSmsLoginLink;

        public SmsLoginConfig(Switch r2, Switch r3, @Deprecated Switch r4) {
            r2 = r2 == null ? Switch.OFF : r2;
            r3 = r3 == null ? Switch.OFF : r3;
            r4 = r4 == null ? Switch.OFF : r4;
            this.flagShowLoginLink = r2;
            this.flagShowSmsLoginLink = r3;
            this.flagLoginBtnType = r4;
            this.flagShowFastRegLink = Switch.OFF;
        }

        public SmsLoginConfig(Switch r1, Switch r2, @Deprecated Switch r3, Switch r4) {
            r1 = r1 == null ? Switch.OFF : r1;
            r2 = r2 == null ? Switch.OFF : r2;
            r3 = r3 == null ? Switch.OFF : r3;
            r4 = r4 == null ? Switch.OFF : r4;
            this.flagShowLoginLink = r1;
            this.flagShowSmsLoginLink = r2;
            this.flagLoginBtnType = r3;
            this.flagShowFastRegLink = r4;
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
