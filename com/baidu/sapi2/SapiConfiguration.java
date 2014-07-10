package com.baidu.sapi2;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.utils.L;
import com.baidu.sapi2.utils.SapiUtils;
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
    public final String appId;
    public final String appSignKey;
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
    @Deprecated
    public final FirstLaunchListener firstLaunchListener;
    public final LoginShareStrategy loginShareStrategy;
    public String presetPhoneNumber;
    public final RegistMode registMode;
    public final ShareListener shareListener;
    public final boolean showRegLink;
    public String skin;
    public final SmsLoginConfig smsLoginConfig;
    public final BindType socialBindType;
    public final String tpl;

    @Deprecated
    /* loaded from: classes.dex */
    public interface FirstLaunchListener {
        @Deprecated
        void onReceivedAccount();
    }

    /* loaded from: classes.dex */
    public interface ShareListener {
        void onSilentShare();
    }

    /* synthetic */ SapiConfiguration(Builder builder, a aVar) {
        this(builder);
    }

    private SapiConfiguration(Builder builder) {
        this.context = builder.a;
        this.tpl = builder.b;
        this.appId = builder.c;
        this.appSignKey = builder.d;
        this.deviceLoginSignKey = builder.e;
        this.environment = builder.f;
        this.socialBindType = builder.g;
        this.registMode = builder.h;
        this.loginShareStrategy = builder.i;
        this.fastLoginFeatureList = builder.j;
        this.firstLaunchListener = builder.k;
        this.shareListener = builder.l;
        this.fastRegConfirm = builder.m;
        this.fastRegConfirmMsg = builder.n;
        this.skin = builder.o;
        this.presetPhoneNumber = builder.p;
        this.collapseFastLoginArea = builder.q;
        this.customActionBarEnabled = builder.r;
        this.showRegLink = builder.s;
        this.configurableViewLayout = builder.t;
        this.fastRegTitleText = builder.u;
        this.debug = builder.v;
        this.smsLoginConfig = builder.w;
        new Thread(new a()).start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SapiConfiguration.this.clientId = SapiUtils.getClientId(SapiConfiguration.this.context);
            SapiConfiguration.this.clientIp = SapiUtils.getLocalIpAddress();
        }
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
        @Deprecated
        private FirstLaunchListener k;
        private ShareListener l;
        private String n;
        private String o;
        private String p;
        private String u;
        private SmsLoginConfig w;
        private boolean m = false;
        private boolean q = false;
        private boolean r = false;
        private boolean s = true;
        private Switch t = Switch.OFF;
        private boolean v = false;

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
            this.p = str;
            return this;
        }

        public Builder collapseFastLoginArea(boolean z) {
            this.q = z;
            return this;
        }

        public Builder showRegLink(boolean z) {
            this.s = z;
            return this;
        }

        public Builder configurableViewLayout(Switch r1) {
            this.t = r1;
            return this;
        }

        public Builder fastRegTitleText(String str) {
            this.u = str;
            return this;
        }

        public Builder debug(boolean z) {
            this.v = z;
            return this;
        }

        public Builder loginShareStrategy(LoginShareStrategy loginShareStrategy) {
            this.i = loginShareStrategy;
            return this;
        }

        public Builder fastLoginSupport(FastLoginFeature... fastLoginFeatureArr) {
            this.j = new ArrayList();
            if (fastLoginFeatureArr != null) {
                Collections.addAll(this.j, fastLoginFeatureArr);
                Collections.unmodifiableList(this.j);
            }
            return this;
        }

        @Deprecated
        public Builder setFirstLaunchListener(FirstLaunchListener firstLaunchListener) {
            this.k = firstLaunchListener;
            return this;
        }

        public Builder setShareListener(ShareListener shareListener) {
            this.l = shareListener;
            return this;
        }

        public Builder fastRegConfirm(boolean z) {
            this.m = z;
            return this;
        }

        public Builder fastRegConfirmMsg(String str) {
            this.n = str;
            return this;
        }

        public Builder skin(String str) {
            this.o = str;
            return this;
        }

        public Builder customActionBar(boolean z) {
            this.r = z;
            return this;
        }

        public Builder smsLoginConfig(SmsLoginConfig smsLoginConfig) {
            this.w = smsLoginConfig;
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
                this.g = BindType.EXPLICIT;
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
            if (this.w == null) {
                this.w = new SmsLoginConfig(Switch.OFF, Switch.OFF, Switch.OFF);
            }
            if (this.t == null) {
                this.t = Switch.OFF;
            }
            L.enable(this.v);
            return new SapiConfiguration(this, null);
        }
    }

    /* loaded from: classes.dex */
    public class SmsLoginConfig {
        public final Switch flagLoginBtnType;
        public final Switch flagShowFastRegLink;
        public final Switch flagShowLoginLink;
        public final Switch flagShowSmsLoginLink;

        public SmsLoginConfig(Switch r2, Switch r3, Switch r4) {
            r2 = r2 == null ? Switch.OFF : r2;
            r3 = r3 == null ? Switch.OFF : r3;
            r4 = r4 == null ? Switch.OFF : r4;
            this.flagShowLoginLink = r2;
            this.flagShowSmsLoginLink = r3;
            this.flagLoginBtnType = r4;
            this.flagShowFastRegLink = Switch.OFF;
        }

        public SmsLoginConfig(Switch r1, Switch r2, Switch r3, Switch r4) {
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
}
