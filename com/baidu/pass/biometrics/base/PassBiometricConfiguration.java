package com.baidu.pass.biometrics.base;

import android.app.Application;
import android.text.TextUtils;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
/* loaded from: classes2.dex */
public class PassBiometricConfiguration {
    public static final String TARGET_TPL = "pp";

    /* renamed from: a  reason: collision with root package name */
    public Application f8980a;
    public final String appId;
    public final String appSignKey;
    public String passDomain;
    public boolean showPmnRationaleDialog;
    public final String tpl;

    /* loaded from: classes2.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f8981a;

        /* renamed from: b  reason: collision with root package name */
        public String f8982b;

        /* renamed from: c  reason: collision with root package name */
        public String f8983c;

        /* renamed from: d  reason: collision with root package name */
        public String f8984d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f8985e = false;

        /* renamed from: f  reason: collision with root package name */
        public boolean f8986f = false;

        /* renamed from: g  reason: collision with root package name */
        public Application f8987g;

        public Builder(Application application) {
            this.f8987g = application;
        }

        public PassBiometricConfiguration build() {
            if (!TextUtils.isEmpty(this.f8981a) && !TextUtils.isEmpty(this.f8982b) && !TextUtils.isEmpty(this.f8983c)) {
                if (this.f8984d == null) {
                    this.f8984d = PassBioEnv.PASSPORT_DOMAIN;
                }
                return new PassBiometricConfiguration(this);
            }
            throw new IllegalArgumentException("tpl, appId, appsignkey, passProductId can not be null, please use setProductLineInfo(String tpl, String appId, String appSignKey, String passProductId)to initialize them.");
        }

        public Builder debug(boolean z) {
            this.f8986f = z;
            return this;
        }

        public Builder setProductLineInfo(String str, String str2, String str3) {
            this.f8981a = str;
            this.f8982b = str2;
            this.f8983c = str3;
            return this;
        }

        public Builder setRuntimeEnvironment(String str) {
            this.f8984d = str;
            return this;
        }

        public Builder showPmnRationaleDialog(boolean z) {
            this.f8985e = z;
            return this;
        }
    }

    public void debug(boolean z) {
        Log.enable(z);
    }

    public Application getApplication() {
        return this.f8980a;
    }

    public PassBiometricConfiguration(Builder builder) {
        this.tpl = builder.f8981a;
        this.appId = builder.f8982b;
        this.appSignKey = builder.f8983c;
        this.passDomain = builder.f8984d;
        debug(builder.f8986f);
        this.showPmnRationaleDialog = builder.f8985e;
        this.f8980a = builder.f8987g;
    }
}
