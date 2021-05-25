package com.baidu.pass.biometrics.base;

import android.app.Application;
import android.text.TextUtils;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
/* loaded from: classes2.dex */
public class PassBiometricConfiguration {
    public static final String TARGET_TPL = "pp";

    /* renamed from: a  reason: collision with root package name */
    public Application f8918a;
    public final String appId;
    public final String appSignKey;
    public String passDomain;
    public boolean showPmnRationaleDialog;
    public final String tpl;

    /* loaded from: classes2.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f8919a;

        /* renamed from: b  reason: collision with root package name */
        public String f8920b;

        /* renamed from: c  reason: collision with root package name */
        public String f8921c;

        /* renamed from: d  reason: collision with root package name */
        public String f8922d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f8923e = false;

        /* renamed from: f  reason: collision with root package name */
        public boolean f8924f = false;

        /* renamed from: g  reason: collision with root package name */
        public Application f8925g;

        public Builder(Application application) {
            this.f8925g = application;
        }

        public PassBiometricConfiguration build() {
            if (!TextUtils.isEmpty(this.f8919a) && !TextUtils.isEmpty(this.f8920b) && !TextUtils.isEmpty(this.f8921c)) {
                if (this.f8922d == null) {
                    this.f8922d = PassBioEnv.PASSPORT_DOMAIN;
                }
                return new PassBiometricConfiguration(this);
            }
            throw new IllegalArgumentException("tpl, appId, appsignkey, passProductId can not be null, please use setProductLineInfo(String tpl, String appId, String appSignKey, String passProductId)to initialize them.");
        }

        public Builder debug(boolean z) {
            this.f8924f = z;
            return this;
        }

        public Builder setProductLineInfo(String str, String str2, String str3) {
            this.f8919a = str;
            this.f8920b = str2;
            this.f8921c = str3;
            return this;
        }

        public Builder setRuntimeEnvironment(String str) {
            this.f8922d = str;
            return this;
        }

        public Builder showPmnRationaleDialog(boolean z) {
            this.f8923e = z;
            return this;
        }
    }

    public void debug(boolean z) {
        Log.enable(z);
    }

    public Application getApplication() {
        return this.f8918a;
    }

    public PassBiometricConfiguration(Builder builder) {
        this.tpl = builder.f8919a;
        this.appId = builder.f8920b;
        this.appSignKey = builder.f8921c;
        this.passDomain = builder.f8922d;
        debug(builder.f8924f);
        this.showPmnRationaleDialog = builder.f8923e;
        this.f8918a = builder.f8925g;
    }
}
