package com.baidu.pass.biometrics.base;

import android.app.Application;
import android.text.TextUtils;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
/* loaded from: classes2.dex */
public class PassBiometricConfiguration {
    public static final String TARGET_TPL = "pp";

    /* renamed from: a  reason: collision with root package name */
    public Application f9018a;
    public final String appId;
    public final String appSignKey;
    public String passDomain;
    public boolean showPmnRationaleDialog;
    public final String tpl;

    /* loaded from: classes2.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f9019a;

        /* renamed from: b  reason: collision with root package name */
        public String f9020b;

        /* renamed from: c  reason: collision with root package name */
        public String f9021c;

        /* renamed from: d  reason: collision with root package name */
        public String f9022d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f9023e = false;

        /* renamed from: f  reason: collision with root package name */
        public boolean f9024f = false;

        /* renamed from: g  reason: collision with root package name */
        public Application f9025g;

        public Builder(Application application) {
            this.f9025g = application;
        }

        public PassBiometricConfiguration build() {
            if (!TextUtils.isEmpty(this.f9019a) && !TextUtils.isEmpty(this.f9020b) && !TextUtils.isEmpty(this.f9021c)) {
                if (this.f9022d == null) {
                    this.f9022d = PassBioEnv.PASSPORT_DOMAIN;
                }
                return new PassBiometricConfiguration(this);
            }
            throw new IllegalArgumentException("tpl, appId, appsignkey, passProductId can not be null, please use setProductLineInfo(String tpl, String appId, String appSignKey, String passProductId)to initialize them.");
        }

        public Builder debug(boolean z) {
            this.f9024f = z;
            return this;
        }

        public Builder setProductLineInfo(String str, String str2, String str3) {
            this.f9019a = str;
            this.f9020b = str2;
            this.f9021c = str3;
            return this;
        }

        public Builder setRuntimeEnvironment(String str) {
            this.f9022d = str;
            return this;
        }

        public Builder showPmnRationaleDialog(boolean z) {
            this.f9023e = z;
            return this;
        }
    }

    public void debug(boolean z) {
        Log.enable(z);
    }

    public Application getApplication() {
        return this.f9018a;
    }

    public PassBiometricConfiguration(Builder builder) {
        this.tpl = builder.f9019a;
        this.appId = builder.f9020b;
        this.appSignKey = builder.f9021c;
        this.passDomain = builder.f9022d;
        debug(builder.f9024f);
        this.showPmnRationaleDialog = builder.f9023e;
        this.f9018a = builder.f9025g;
    }
}
