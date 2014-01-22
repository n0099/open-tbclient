package com.baidu.sapi2;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.utils.L;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.e;
import com.baidu.sapi2.utils.enums.BindType;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.LoginShareStrategy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class SapiConfiguration {
    public final String appId;
    public final String appSignKey;
    public final String clientId;
    public final String clientIp;
    public final Context context;
    public final boolean customActionBarEnabled;
    public final boolean debug;
    public final Domain environment;
    public final List<FastLoginFeature> fastLoginFeatureList;
    public final LoginShareStrategy loginShareStrategy;
    public String skin;
    public final BindType socialBindType;
    public final String tpl;

    private SapiConfiguration(Builder builder) {
        this.context = builder.a;
        this.tpl = builder.b;
        this.appId = builder.c;
        this.appSignKey = builder.d;
        this.environment = builder.g;
        this.socialBindType = builder.h;
        this.loginShareStrategy = builder.i;
        this.fastLoginFeatureList = builder.j;
        this.skin = builder.k;
        this.customActionBarEnabled = builder.l;
        this.debug = builder.m;
        this.clientId = builder.e;
        this.clientIp = builder.f;
    }

    /* loaded from: classes.dex */
    public class Builder {
        private Context a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private Domain g;
        private BindType h;
        private LoginShareStrategy i;
        private List<FastLoginFeature> j;
        private String k;
        private boolean l = false;
        private boolean m = false;

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
            this.g = domain;
            return this;
        }

        public Builder setSocialBindType(BindType bindType) {
            this.h = bindType;
            return this;
        }

        public Builder debug(boolean z) {
            this.m = z;
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

        public Builder skin(String str) {
            this.k = str;
            return this;
        }

        public Builder customActionBar(boolean z) {
            this.l = z;
            return this;
        }

        public SapiConfiguration build() {
            if (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.c) || TextUtils.isEmpty(this.d)) {
                throw new IllegalArgumentException("tpl, appId, appsignkey can not be null, please use setProductLineInfo(String tpl, String appId, String appSignKey)to initialize them.");
            }
            if (this.g == null) {
                this.g = Domain.DOMAIN_ONLINE;
            }
            if (this.h == null) {
                this.h = BindType.EXPLICIT;
            }
            if (this.i == null) {
                this.i = LoginShareStrategy.CHOICE;
            }
            if (this.j == null) {
                this.j = new ArrayList();
            }
            try {
                String a = e.a(this.a);
                if (TextUtils.isEmpty(a)) {
                    a = "123456789";
                }
                this.e = a;
            } catch (Throwable th) {
                this.e = "123456789";
            }
            this.f = SapiUtils.getLocalIpAddress();
            L.enable(this.m);
            return new SapiConfiguration(this);
        }
    }
}
