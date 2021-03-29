package com.baidu.pass.biometrics.base;

import android.app.Application;
import android.text.TextUtils;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
/* loaded from: classes2.dex */
public class PassBiometricConfiguration {
    public static final String TARGET_TPL = "pp";

    /* renamed from: a  reason: collision with root package name */
    public Application f9505a;
    public final String appId;
    public final String appSignKey;
    public String passDomain;
    public boolean showPmnRationaleDialog;
    public final String tpl;

    /* loaded from: classes2.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f9506a;

        /* renamed from: b  reason: collision with root package name */
        public String f9507b;

        /* renamed from: c  reason: collision with root package name */
        public String f9508c;

        /* renamed from: d  reason: collision with root package name */
        public String f9509d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f9510e = false;

        /* renamed from: f  reason: collision with root package name */
        public boolean f9511f = false;

        /* renamed from: g  reason: collision with root package name */
        public Application f9512g;

        public Builder(Application application) {
            this.f9512g = application;
        }

        public PassBiometricConfiguration build() {
            if (!TextUtils.isEmpty(this.f9506a) && !TextUtils.isEmpty(this.f9507b) && !TextUtils.isEmpty(this.f9508c)) {
                if (this.f9509d == null) {
                    this.f9509d = PassBioEnv.PASSPORT_DOMAIN;
                }
                return new PassBiometricConfiguration(this);
            }
            throw new IllegalArgumentException("tpl, appId, appsignkey, passProductId can not be null, please use setProductLineInfo(String tpl, String appId, String appSignKey, String passProductId)to initialize them.");
        }

        public Builder debug(boolean z) {
            this.f9511f = z;
            return this;
        }

        public Builder setProductLineInfo(String str, String str2, String str3) {
            this.f9506a = str;
            this.f9507b = str2;
            this.f9508c = str3;
            return this;
        }

        public Builder setRuntimeEnvironment(String str) {
            this.f9509d = str;
            return this;
        }

        public Builder showPmnRationaleDialog(boolean z) {
            this.f9510e = z;
            return this;
        }
    }

    public void debug(boolean z) {
        Log.enable(z);
    }

    public Application getApplication() {
        return this.f9505a;
    }

    public PassBiometricConfiguration(Builder builder) {
        this.tpl = builder.f9506a;
        this.appId = builder.f9507b;
        this.appSignKey = builder.f9508c;
        this.passDomain = builder.f9509d;
        debug(builder.f9511f);
        this.showPmnRationaleDialog = builder.f9510e;
        this.f9505a = builder.f9512g;
    }
}
