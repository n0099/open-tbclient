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
    public final String licenseFileName;
    public final String licenseID;
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
        public String f8985e;

        /* renamed from: f  reason: collision with root package name */
        public String f8986f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f8987g = false;

        /* renamed from: h  reason: collision with root package name */
        public boolean f8988h = false;

        /* renamed from: i  reason: collision with root package name */
        public Application f8989i;

        public Builder(Application application) {
            this.f8989i = application;
        }

        public PassBiometricConfiguration build() {
            if (!TextUtils.isEmpty(this.f8981a) && !TextUtils.isEmpty(this.f8982b) && !TextUtils.isEmpty(this.f8983c)) {
                if (this.f8986f == null) {
                    this.f8986f = PassBioEnv.PASSPORT_DOMAIN;
                }
                return new PassBiometricConfiguration(this);
            }
            throw new IllegalArgumentException("tpl, appId, appsignkey, passProductId can not be null, please use setProductLineInfo(String tpl, String appId, String appSignKey, String passProductId)to initialize them.");
        }

        public Builder debug(boolean z) {
            this.f8988h = z;
            return this;
        }

        public Builder setProductLicenseInfo(String str, String str2) {
            this.f8984d = str;
            this.f8985e = str2;
            return this;
        }

        public Builder setProductLineInfo(String str, String str2, String str3) {
            this.f8981a = str;
            this.f8982b = str2;
            this.f8983c = str3;
            return this;
        }

        public Builder setRuntimeEnvironment(String str) {
            this.f8986f = str;
            return this;
        }

        public Builder showPmnRationaleDialog(boolean z) {
            this.f8987g = z;
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
        this.passDomain = builder.f8986f;
        this.licenseID = builder.f8984d;
        this.licenseFileName = builder.f8985e;
        debug(builder.f8988h);
        this.showPmnRationaleDialog = builder.f8987g;
        this.f8980a = builder.f8989i;
    }
}
