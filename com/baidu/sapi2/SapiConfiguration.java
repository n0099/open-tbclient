package com.baidu.sapi2;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.util.DeviceId;
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
    public final String clientId;
    public final String clientIp;
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
    public final FirstLaunchListener firstLaunchListener;
    public final LoginShareStrategy loginShareStrategy;
    public String presetPhoneNumber;
    public final RegistMode registMode;
    public final boolean showRegLink;
    public String skin;
    public final SmsLoginConfig smsLoginConfig;
    public final BindType socialBindType;
    public final String tpl;

    /* loaded from: classes.dex */
    public interface FirstLaunchListener {
        void onReceivedAccount();
    }

    private SapiConfiguration(Builder builder) {
        this.context = builder.a;
        this.tpl = builder.b;
        this.appId = builder.c;
        this.appSignKey = builder.d;
        this.deviceLoginSignKey = builder.g;
        this.environment = builder.h;
        this.socialBindType = builder.i;
        this.registMode = builder.j;
        this.loginShareStrategy = builder.k;
        this.fastLoginFeatureList = builder.l;
        this.firstLaunchListener = builder.m;
        this.fastRegConfirm = builder.n;
        this.fastRegConfirmMsg = builder.o;
        this.skin = builder.p;
        this.presetPhoneNumber = builder.q;
        this.collapseFastLoginArea = builder.r;
        this.customActionBarEnabled = builder.s;
        this.showRegLink = builder.t;
        this.configurableViewLayout = builder.u;
        this.fastRegTitleText = builder.v;
        this.debug = builder.w;
        this.clientId = builder.e;
        this.clientIp = builder.f;
        this.smsLoginConfig = builder.x;
    }

    /* loaded from: classes.dex */
    public class Builder {
        private Context a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;
        private Domain h;
        private BindType i;
        private RegistMode j;
        private LoginShareStrategy k;
        private List<FastLoginFeature> l;
        private FirstLaunchListener m;
        private String o;
        private String p;
        private String q;
        private String v;
        private SmsLoginConfig x;
        private boolean n = false;
        private boolean r = false;
        private boolean s = false;
        private boolean t = true;
        private Switch u = Switch.OFF;
        private boolean w = false;

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
            this.g = str;
            return this;
        }

        public Builder setRuntimeEnvironment(Domain domain) {
            this.h = domain;
            return this;
        }

        public Builder setSocialBindType(BindType bindType) {
            this.i = bindType;
            return this;
        }

        public Builder registMode(RegistMode registMode) {
            this.j = registMode;
            return this;
        }

        public Builder presetPhoneNumber(String str) {
            this.q = str;
            return this;
        }

        public Builder collapseFastLoginArea(boolean z) {
            this.r = z;
            return this;
        }

        public Builder showRegLink(boolean z) {
            this.t = z;
            return this;
        }

        public Builder configurableViewLayout(Switch r1) {
            this.u = r1;
            return this;
        }

        public Builder fastRegTitleText(String str) {
            this.v = str;
            return this;
        }

        public Builder debug(boolean z) {
            this.w = z;
            return this;
        }

        public Builder loginShareStrategy(LoginShareStrategy loginShareStrategy) {
            this.k = loginShareStrategy;
            return this;
        }

        public Builder fastLoginSupport(FastLoginFeature... fastLoginFeatureArr) {
            this.l = new ArrayList();
            if (fastLoginFeatureArr != null) {
                Collections.addAll(this.l, fastLoginFeatureArr);
                Collections.unmodifiableList(this.l);
            }
            return this;
        }

        public Builder setFirstLaunchListener(FirstLaunchListener firstLaunchListener) {
            this.m = firstLaunchListener;
            return this;
        }

        public Builder fastRegConfirm(boolean z) {
            this.n = z;
            return this;
        }

        public Builder fastRegConfirmMsg(String str) {
            this.o = str;
            return this;
        }

        public Builder skin(String str) {
            this.p = str;
            return this;
        }

        public Builder customActionBar(boolean z) {
            this.s = z;
            return this;
        }

        public Builder smsLoginConfig(SmsLoginConfig smsLoginConfig) {
            this.x = smsLoginConfig;
            return this;
        }

        public SapiConfiguration build() {
            if (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.c) || TextUtils.isEmpty(this.d)) {
                throw new IllegalArgumentException("tpl, appId, appsignkey can not be null, please use setProductLineInfo(String tpl, String appId, String appSignKey)to initialize them.");
            }
            if (this.h == null) {
                this.h = Domain.DOMAIN_ONLINE;
            }
            if (this.i == null) {
                this.i = BindType.EXPLICIT;
            }
            if (this.j == null) {
                this.j = RegistMode.NORMAL;
            }
            if (this.k == null) {
                this.k = LoginShareStrategy.CHOICE;
            }
            if (this.l == null) {
                this.l = new ArrayList();
            }
            if (this.x == null) {
                this.x = new SmsLoginConfig(Switch.OFF, Switch.OFF, Switch.OFF);
            }
            if (this.u == null) {
                this.u = Switch.OFF;
            }
            try {
                String deviceID = DeviceId.getDeviceID(this.a);
                if (TextUtils.isEmpty(deviceID)) {
                    deviceID = "123456789";
                }
                this.e = deviceID;
            } catch (Throwable th) {
                this.e = "123456789";
            }
            this.f = SapiUtils.getLocalIpAddress();
            L.enable(this.w);
            return new SapiConfiguration(this);
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
