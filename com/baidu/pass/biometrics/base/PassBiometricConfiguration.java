package com.baidu.pass.biometrics.base;

import android.app.Application;
import android.text.TextUtils;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
/* loaded from: classes9.dex */
public class PassBiometricConfiguration {
    public static final String TARGET_TPL = "pp";

    /* renamed from: a  reason: collision with root package name */
    private Application f2686a;
    public final String appId;
    public final String appSignKey;
    public String passDomain;
    public boolean showPmnRationaleDialog;
    public final String tpl;

    /* loaded from: classes9.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f2687a;
        private String b;
        private String c;
        private String d;
        private boolean e = false;
        private boolean f = false;
        private Application g;

        public Builder(Application application) {
            this.g = application;
        }

        public PassBiometricConfiguration build() {
            if (!TextUtils.isEmpty(this.f2687a) && !TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(this.c)) {
                if (this.d == null) {
                    this.d = PassBioEnv.PASSPORT_DOMAIN;
                }
                return new PassBiometricConfiguration(this);
            }
            throw new IllegalArgumentException("tpl, appId, appsignkey, passProductId can not be null, please use setProductLineInfo(String tpl, String appId, String appSignKey, String passProductId)to initialize them.");
        }

        public Builder debug(boolean z) {
            this.f = z;
            return this;
        }

        public Builder setProductLineInfo(String str, String str2, String str3) {
            this.f2687a = str;
            this.b = str2;
            this.c = str3;
            return this;
        }

        public Builder setRuntimeEnvironment(String str) {
            this.d = str;
            return this;
        }

        public Builder showPmnRationaleDialog(boolean z) {
            this.e = z;
            return this;
        }
    }

    public void debug(boolean z) {
        Log.enable(z);
    }

    public Application getApplication() {
        return this.f2686a;
    }

    private PassBiometricConfiguration(Builder builder) {
        this.tpl = builder.f2687a;
        this.appId = builder.b;
        this.appSignKey = builder.c;
        this.passDomain = builder.d;
        debug(builder.f);
        this.showPmnRationaleDialog = builder.e;
        this.f2686a = builder.g;
    }
}
