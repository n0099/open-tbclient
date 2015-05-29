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
    private boolean b;
    public String clientId;
    public String clientIp;
    public final boolean collapseFastLoginArea;
    public final Switch configurableViewLayout;
    public final Context context;
    public final boolean customActionBarEnabled;
    public final boolean debug;
    public final String deviceLoginSignKey;
    public final Domain environment;
    public final List<FastLoginFeature> fastLoginFeatureList;
    public final boolean fastRegConfirm;
    public final String fastRegConfirmMsg;
    public final String fastRegTitleText;
    public String presetPhoneNumber;
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
        this.fastRegConfirm = builder.l;
        this.fastRegConfirmMsg = builder.m;
        this.skin = builder.n;
        this.presetPhoneNumber = builder.o;
        this.collapseFastLoginArea = builder.p;
        this.customActionBarEnabled = builder.q;
        this.showRegLink = builder.r;
        this.configurableViewLayout = builder.s;
        this.fastRegTitleText = builder.t;
        this.debug = builder.u;
        this.smsLoginConfig = builder.v;
        this.uniteVerify = builder.w;
        this.syncCacheOnInit = builder.x;
        this.silentShareOnUpgrade = builder.y;
        this.quickUserEnabled = builder.z;
        this.b = builder.A;
    }

    /* loaded from: classes.dex */
    public class Builder {
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
        private String m;
        private String n;
        private String o;
        private String t;
        private SmsLoginConfig v;
        private boolean l = false;
        private boolean p = false;
        private boolean q = false;
        private boolean r = true;
        private Switch s = Switch.OFF;
        private boolean u = false;
        private boolean w = false;
        private boolean x = true;
        private boolean y = true;
        private boolean z = false;
        private boolean A = false;

        public Builder(Context context) {
            this.a = context.getApplicationContext();
        }

        public Builder setProductLineInfo(String str, String str2, String str3) {
            this.b = str;
            this.c = str2;
            this.d = str3;
            return this;
        }

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
            this.o = str;
            return this;
        }

        public Builder collapseFastLoginArea(boolean z) {
            this.p = z;
            return this;
        }

        public Builder showRegLink(boolean z) {
            this.r = z;
            return this;
        }

        public Builder configurableViewLayout(Switch r1) {
            this.s = r1;
            return this;
        }

        public Builder fastRegTitleText(String str) {
            this.t = str;
            return this;
        }

        public Builder debug(boolean z) {
            this.u = z;
            return this;
        }

        public Builder syncCacheOnInit(boolean z) {
            this.x = z;
            return this;
        }

        public Builder silentShareOnUpgrade(boolean z) {
            this.y = z;
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

        public Builder fastRegConfirm(boolean z) {
            this.l = z;
            return this;
        }

        public Builder fastRegConfirmMsg(String str) {
            this.m = str;
            return this;
        }

        public Builder skin(String str) {
            this.n = str;
            return this;
        }

        public Builder customActionBar(boolean z) {
            this.q = z;
            return this;
        }

        public Builder enableQuickUser(boolean z) {
            this.z = z;
            return this;
        }

        public Builder enableB2CSync(boolean z) {
            this.A = z;
            return this;
        }

        public Builder smsLoginConfig(SmsLoginConfig smsLoginConfig) {
            this.v = smsLoginConfig;
            return this;
        }

        public Builder uniteVerify(boolean z) {
            this.w = z;
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
                this.g = BindType.IMPLICIT;
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
            if (this.v == null) {
                this.v = new SmsLoginConfig(Switch.OFF, Switch.OFF, Switch.OFF);
            }
            if (this.s == null) {
                this.s = Switch.OFF;
            }
            L.enable(this.u);
            return new SapiConfiguration(this);
        }
    }

    /* loaded from: classes.dex */
    public class SmsLoginConfig {
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

        public String toString() {
            return String.valueOf(this.flagShowLoginLink.ordinal()) + this.flagShowSmsLoginLink.ordinal() + this.flagLoginBtnType.ordinal();
        }
    }

    public LoginShareStrategy loginShareStrategy() {
        if (this.quickUserEnabled) {
            return LoginShareStrategy.DISABLED;
        }
        b k = d.a(this.context).k();
        if (k.e().containsKey(this.tpl) && k.e().get(this.tpl) != null) {
            return k.e().get(this.tpl);
        }
        if (k.d() != null) {
            return k.d();
        }
        return this.a;
    }

    public boolean b2cSyncEnabled() {
        return this.b && d.a(this.context).k().b() && (this.context.getPackageName().matches("com.baidu.searchbox(.*)") || this.context.getPackageName().matches("com.baidu.sapi2.(.*)"));
    }
}
