package com.baidu.pass.biometrics.base;

import android.app.Application;
import android.text.TextUtils;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
/* loaded from: classes2.dex */
public class PassBiometricConfiguration {
    public static final String TARGET_TPL = "pp";

    /* renamed from: a  reason: collision with root package name */
    public Application f9504a;
    public final String appId;
    public final String appSignKey;
    public String passDomain;
    public boolean showPmnRationaleDialog;
    public final String tpl;

    /* loaded from: classes2.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f9505a;

        /* renamed from: b  reason: collision with root package name */
        public String f9506b;

        /* renamed from: c  reason: collision with root package name */
        public String f9507c;

        /* renamed from: d  reason: collision with root package name */
        public String f9508d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f9509e = false;

        /* renamed from: f  reason: collision with root package name */
        public boolean f9510f = false;

        /* renamed from: g  reason: collision with root package name */
        public Application f9511g;

        public Builder(Application application) {
            this.f9511g = application;
        }

        public PassBiometricConfiguration build() {
            if (!TextUtils.isEmpty(this.f9505a) && !TextUtils.isEmpty(this.f9506b) && !TextUtils.isEmpty(this.f9507c)) {
                if (this.f9508d == null) {
                    this.f9508d = PassBioEnv.PASSPORT_DOMAIN;
                }
                return new PassBiometricConfiguration(this);
            }
            throw new IllegalArgumentException("tpl, appId, appsignkey, passProductId can not be null, please use setProductLineInfo(String tpl, String appId, String appSignKey, String passProductId)to initialize them.");
        }

        public Builder debug(boolean z) {
            this.f9510f = z;
            return this;
        }

        public Builder setProductLineInfo(String str, String str2, String str3) {
            this.f9505a = str;
            this.f9506b = str2;
            this.f9507c = str3;
            return this;
        }

        public Builder setRuntimeEnvironment(String str) {
            this.f9508d = str;
            return this;
        }

        public Builder showPmnRationaleDialog(boolean z) {
            this.f9509e = z;
            return this;
        }
    }

    public void debug(boolean z) {
        Log.enable(z);
    }

    public Application getApplication() {
        return this.f9504a;
    }

    public PassBiometricConfiguration(Builder builder) {
        this.tpl = builder.f9505a;
        this.appId = builder.f9506b;
        this.appSignKey = builder.f9507c;
        this.passDomain = builder.f9508d;
        debug(builder.f9510f);
        this.showPmnRationaleDialog = builder.f9509e;
        this.f9504a = builder.f9511g;
    }
}
