package com.baidu.pass.biometrics.base;

import android.app.Application;
import android.text.TextUtils;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
/* loaded from: classes2.dex */
public class PassBiometricConfiguration {
    public static final String TARGET_TPL = "pp";

    /* renamed from: a  reason: collision with root package name */
    public Application f9397a;
    public final String appId;
    public final String appSignKey;
    public String passDomain;
    public boolean showPmnRationaleDialog;
    public final String tpl;

    /* loaded from: classes2.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f9398a;

        /* renamed from: b  reason: collision with root package name */
        public String f9399b;

        /* renamed from: c  reason: collision with root package name */
        public String f9400c;

        /* renamed from: d  reason: collision with root package name */
        public String f9401d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f9402e = false;

        /* renamed from: f  reason: collision with root package name */
        public boolean f9403f = false;

        /* renamed from: g  reason: collision with root package name */
        public Application f9404g;

        public Builder(Application application) {
            this.f9404g = application;
        }

        public PassBiometricConfiguration build() {
            if (!TextUtils.isEmpty(this.f9398a) && !TextUtils.isEmpty(this.f9399b) && !TextUtils.isEmpty(this.f9400c)) {
                if (this.f9401d == null) {
                    this.f9401d = PassBioEnv.PASSPORT_DOMAIN;
                }
                return new PassBiometricConfiguration(this);
            }
            throw new IllegalArgumentException("tpl, appId, appsignkey, passProductId can not be null, please use setProductLineInfo(String tpl, String appId, String appSignKey, String passProductId)to initialize them.");
        }

        public Builder debug(boolean z) {
            this.f9403f = z;
            return this;
        }

        public Builder setProductLineInfo(String str, String str2, String str3) {
            this.f9398a = str;
            this.f9399b = str2;
            this.f9400c = str3;
            return this;
        }

        public Builder setRuntimeEnvironment(String str) {
            this.f9401d = str;
            return this;
        }

        public Builder showPmnRationaleDialog(boolean z) {
            this.f9402e = z;
            return this;
        }
    }

    public void debug(boolean z) {
        Log.enable(z);
    }

    public Application getApplication() {
        return this.f9397a;
    }

    public PassBiometricConfiguration(Builder builder) {
        this.tpl = builder.f9398a;
        this.appId = builder.f9399b;
        this.appSignKey = builder.f9400c;
        this.passDomain = builder.f9401d;
        debug(builder.f9403f);
        this.showPmnRationaleDialog = builder.f9402e;
        this.f9397a = builder.f9404g;
    }
}
