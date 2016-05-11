package com.baidu.sapi2;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.utils.L;
import com.baidu.sapi2.utils.enums.BindType;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
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
    public final String appId;
    public final String appSignKey;
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
    public String presetPhoneNumber;
    public final String qqAppID;
    public final boolean quickUserEnabled;
    public final RegistMode registMode;
    public final boolean showRegLink;
    public final boolean silentShareOnUpgrade;
    public String skin;
    public final SmsLoginConfig smsLoginConfig;
    public final BindType socialBindType;
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
        this.socialBindType = builder.g;
        this.registMode = builder.h;
        this.a = builder.i;
        this.fastLoginFeatureList = builder.j;
        this.wxAppID = builder.k;
        this.hwAppId = builder.l;
        this.qqAppID = builder.m;
        this.xiaomiAppID = builder.n;
        this.xiaomiRedirectUri = builder.o;
        this.fastRegConfirm = builder.p;
        this.fastRegConfirmMsg = builder.q;
        this.skin = builder.r;
        this.presetPhoneNumber = builder.s;
        this.customActionBarEnabled = builder.t;
        this.showRegLink = builder.u;
        this.configurableViewLayout = builder.v;
        this.fastRegTitleText = builder.w;
        this.debug = builder.x;
        this.smsLoginConfig = builder.y;
        this.uniteVerify = builder.z;
        this.syncCacheOnInit = builder.A;
        this.silentShareOnUpgrade = builder.B;
        this.quickUserEnabled = builder.C;
        this.faceAppName = builder.D;
    }

    /* loaded from: classes.dex */
    public static class Builder {
        private String D;
        private Context a;
        private String b;
        private String c;
        private String d;
        private String e;
        private Domain f;
        private BindType g;
        private RegistMode h;
        private LoginShareStrategy i;
        private List<FastLoginFeature> j;
        private String k;
        private String l;
        private String m;
        private Long n;
        private String o;
        private String q;
        private String r;
        private String s;
        private String w;
        private SmsLoginConfig y;
        private boolean p = false;
        private boolean t = false;
        private boolean u = true;
        private Switch v = Switch.OFF;
        private boolean x = false;
        private boolean z = false;
        private boolean A = true;
        private boolean B = true;
        private boolean C = false;

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
            this.s = str;
            return this;
        }

        public Builder showRegLink(boolean z) {
            this.u = z;
            return this;
        }

        public Builder configurableViewLayout(Switch r1) {
            this.v = r1;
            return this;
        }

        public Builder fastRegTitleText(String str) {
            this.w = str;
            return this;
        }

        public Builder debug(boolean z) {
            this.x = z;
            return this;
        }

        public Builder syncCacheOnInit(boolean z) {
            this.A = z;
            return this;
        }

        public Builder silentShareOnUpgrade(boolean z) {
            this.B = z;
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

        public Builder hwAppID(String str) {
            this.l = str;
            return this;
        }

        public Builder qqAppID(String str) {
            this.m = str;
            return this;
        }

        public Builder xiaomiLoginConfig(Long l, String str) {
            this.n = l;
            this.o = str;
            return this;
        }

        public Builder fastRegConfirm(boolean z) {
            this.p = z;
            return this;
        }

        public Builder fastRegConfirmMsg(String str) {
            this.q = str;
            return this;
        }

        public Builder skin(String str) {
            this.r = str;
            return this;
        }

        public Builder customActionBar(boolean z) {
            this.t = z;
            return this;
        }

        public Builder enableQuickUser(boolean z) {
            this.C = z;
            return this;
        }

        public Builder smsLoginConfig(SmsLoginConfig smsLoginConfig) {
            this.y = smsLoginConfig;
            return this;
        }

        public Builder uniteVerify(boolean z) {
            this.z = z;
            return this;
        }

        public Builder setFaceAppName(String str) {
            this.D = str;
            return this;
        }

        public SapiConfiguration build() {
            if (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.c) || TextUtils.isEmpty(this.d)) {
                throw new IllegalArgumentException("tpl, appId, appsignkey can not be null, please use setProductLineInfo(String tpl, String appId, String appSignKey)to initialize them.");
            }
            if (this.f == null) {
                this.f = Domain.DOMAIN_ONLINE;
            }
            if (this.g == null) {
                this.g = BindType.BIND_MOBILE;
            }
            if (this.h == null) {
                this.h = RegistMode.NORMAL;
            }
            if (this.i == null) {
                this.i = LoginShareStrategy.getDefault();
            }
            if (this.j == null) {
                this.j = new ArrayList();
            }
            if (this.y == null) {
                this.y = new SmsLoginConfig(Switch.OFF, Switch.OFF, Switch.OFF);
            }
            if (this.v == null) {
                this.v = Switch.OFF;
            }
            L.enable(this.x);
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
        if (k.d().containsKey(this.tpl) && k.d().get(this.tpl) != null) {
            return k.d().get(this.tpl);
        }
        if (k.b() != null) {
            return k.b();
        }
        return this.a;
    }
}
