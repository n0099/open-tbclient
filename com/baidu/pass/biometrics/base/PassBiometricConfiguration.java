package com.baidu.pass.biometrics.base;

import android.app.Application;
import android.text.TextUtils;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
/* loaded from: classes2.dex */
public class PassBiometricConfiguration {
    public static final String TARGET_TPL = "pp";

    /* renamed from: a  reason: collision with root package name */
    public Application f9063a;
    public final String appId;
    public final String appSignKey;
    public String passDomain;
    public boolean showPmnRationaleDialog;
    public final String tpl;

    /* loaded from: classes2.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f9064a;

        /* renamed from: b  reason: collision with root package name */
        public String f9065b;

        /* renamed from: c  reason: collision with root package name */
        public String f9066c;

        /* renamed from: d  reason: collision with root package name */
        public String f9067d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f9068e = false;

        /* renamed from: f  reason: collision with root package name */
        public boolean f9069f = false;

        /* renamed from: g  reason: collision with root package name */
        public Application f9070g;

        public Builder(Application application) {
            this.f9070g = application;
        }

        public PassBiometricConfiguration build() {
            if (!TextUtils.isEmpty(this.f9064a) && !TextUtils.isEmpty(this.f9065b) && !TextUtils.isEmpty(this.f9066c)) {
                if (this.f9067d == null) {
                    this.f9067d = PassBioEnv.PASSPORT_DOMAIN;
                }
                return new PassBiometricConfiguration(this);
            }
            throw new IllegalArgumentException("tpl, appId, appsignkey, passProductId can not be null, please use setProductLineInfo(String tpl, String appId, String appSignKey, String passProductId)to initialize them.");
        }

        public Builder debug(boolean z) {
            this.f9069f = z;
            return this;
        }

        public Builder setProductLineInfo(String str, String str2, String str3) {
            this.f9064a = str;
            this.f9065b = str2;
            this.f9066c = str3;
            return this;
        }

        public Builder setRuntimeEnvironment(String str) {
            this.f9067d = str;
            return this;
        }

        public Builder showPmnRationaleDialog(boolean z) {
            this.f9068e = z;
            return this;
        }
    }

    public void debug(boolean z) {
        Log.enable(z);
    }

    public Application getApplication() {
        return this.f9063a;
    }

    public PassBiometricConfiguration(Builder builder) {
        this.tpl = builder.f9064a;
        this.appId = builder.f9065b;
        this.appSignKey = builder.f9066c;
        this.passDomain = builder.f9067d;
        debug(builder.f9069f);
        this.showPmnRationaleDialog = builder.f9068e;
        this.f9063a = builder.f9070g;
    }
}
