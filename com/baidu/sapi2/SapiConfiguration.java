package com.baidu.sapi2;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.utils.L;
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
import java.util.List;
/* loaded from: classes.dex */
public final class SapiConfiguration {
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
    public final String deviceLoginSignKey;
    public final Domain environment;
    public final String faceAppName;
    public final List<FastLoginFeature> fastLoginFeatureList;
    public final boolean fastRegConfirm;
    public final String fastRegConfirmMsg;
    public final String fastRegTitleText;
    public final String hwAppId;
    public final String hwLoginChannelId;
    public Language language;
    public final String meizuRedirectUri;
    public final String mzAppID;
    public String presetPhoneNumber;
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
    public final String sofireSecKey;
    public final boolean syncCacheOnInit;
    public final String tpl;
    public final boolean uniteVerify;
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
        this.deviceLoginSignKey = builder.e;
        this.environment = builder.f;
        this.language = builder.i;
        this.socialBindType = builder.g;
        this.registMode = builder.h;
        this.a = builder.j;
        this.fastLoginFeatureList = builder.k;
        this.wxAppID = builder.l;
        this.hwAppId = builder.m;
        this.hwLoginChannelId = builder.n;
        this.qqAppID = builder.o;
        this.xiaomiAppID = builder.p;
        this.mzAppID = builder.q;
        this.xiaomiRedirectUri = builder.s;
        this.meizuRedirectUri = builder.t;
        this.sofireAppKey = builder.u;
        this.sofireSecKey = builder.v;
        this.realnameAuthenticateStoken = builder.r;
        this.fastRegConfirm = builder.w;
        this.fastRegConfirmMsg = builder.x;
        this.skin = builder.y;
        this.presetPhoneNumber = builder.z;
        this.customActionBarEnabled = builder.A;
        this.showRegLink = builder.B;
        this.configurableViewLayout = builder.C;
        this.fastRegTitleText = builder.D;
        this.debug = builder.E;
        this.smsLoginConfig = builder.F;
        this.uniteVerify = builder.G;
        this.syncCacheOnInit = builder.H;
        this.silentShareOnUpgrade = builder.I;
        this.quickUserEnabled = builder.J;
        this.faceAppName = builder.K;
        this.biometricTypeList = builder.L;
        this.accountCenterRealAutnen = builder.M;
    }

    /* loaded from: classes.dex */
    public static class Builder {
        private String D;
        private SmsLoginConfig F;
        private String K;
        private List<BiometricType> L;
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
        private String x;
        private String y;
        private String z;
        private boolean w = false;
        private boolean A = false;
        private boolean B = true;
        private Switch C = Switch.OFF;
        private boolean E = false;
        private boolean G = false;
        private boolean H = true;
        private boolean I = true;
        private boolean J = false;
        private boolean M = true;

        public Builder(Context context) {
            this.a = context.getApplicationContext();
        }

        public Builder setProductLineInfo(String str, String str2, String str3) {
            this.b = str;
            this.c = str2;
            this.d = str3;
            return this;
        }

        @Deprecated
        public Builder setDeviceLoginSignKey(String str) {
            this.e = str;
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
            this.z = str;
            return this;
        }

        public Builder showRegLink(boolean z) {
            this.B = z;
            return this;
        }

        public Builder configurableViewLayout(Switch r1) {
            this.C = r1;
            return this;
        }

        public Builder fastRegTitleText(String str) {
            this.D = str;
            return this;
        }

        public Builder debug(boolean z) {
            this.E = z;
            return this;
        }

        public Builder syncCacheOnInit(boolean z) {
            this.H = z;
            return this;
        }

        public Builder silentShareOnUpgrade(boolean z) {
            this.I = z;
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
            this.l = str;
            return this;
        }

        public Builder hwAppID(String str) {
            this.m = str;
            return this;
        }

        public Builder hwLoginChannelId(String str) {
            this.n = str;
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

        public Builder sofireSdkConfig(String str, String str2) {
            this.u = str;
            this.v = str2;
            return this;
        }

        public Builder fastRegConfirm(boolean z) {
            this.w = z;
            return this;
        }

        public Builder fastRegConfirmMsg(String str) {
            this.x = str;
            return this;
        }

        public Builder skin(String str) {
            this.y = str;
            return this;
        }

        public Builder customActionBar(boolean z) {
            this.A = z;
            return this;
        }

        public Builder enableQuickUser(boolean z) {
            this.J = z;
            return this;
        }

        public Builder smsLoginConfig(SmsLoginConfig smsLoginConfig) {
            this.F = smsLoginConfig;
            return this;
        }

        public Builder uniteVerify(boolean z) {
            this.G = z;
            return this;
        }

        public Builder setFaceAppName(String str) {
            this.K = str;
            return this;
        }

        public Builder setLanguage(Language language) {
            this.i = language;
            return this;
        }

        public Builder biometricTypeSupport(BiometricType... biometricTypeArr) {
            this.L = new ArrayList();
            if (biometricTypeArr != null) {
                Collections.addAll(this.L, biometricTypeArr);
            }
            return this;
        }

        public Builder supportRealNameAuthen(boolean z) {
            this.M = z;
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
            if (this.F == null) {
                this.F = new SmsLoginConfig(Switch.OFF, Switch.OFF, Switch.OFF);
            }
            if (this.C == null) {
                this.C = Switch.OFF;
            }
            if (this.L == null) {
                this.L = new ArrayList();
            }
            L.enable(this.E);
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
        d k = c.a(this.context).k();
        if (k.e().containsKey(this.tpl) && k.e().get(this.tpl) != null) {
            return k.e().get(this.tpl);
        }
        if (k.b() != null) {
            return k.b();
        }
        return this.a;
    }
}
