package com.baidu.pass.biometrics.base;

import android.app.Application;
import android.text.TextUtils;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
import java.util.Map;
/* loaded from: classes2.dex */
public class PassBiometricConfiguration {
    public static final String TARGET_TPL = "pp";
    public boolean a;
    public final String appId;
    public final String appSignKey;
    public Application b;
    public Map<String, String> faceResPaths;
    public final String licenseFileName;
    public final String licenseID;
    public String passDomain;
    public boolean showPmnRationaleDialog;
    public final String sofireAppKey;
    public final int sofireHostID;
    public final String sofireSecKey;
    public final String tpl;

    /* loaded from: classes2.dex */
    public static class Builder {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public int i;
        public Application l;
        public Map<String, String> n;
        public boolean j = false;
        public boolean k = false;
        public boolean m = true;

        public Builder(Application application) {
            this.l = application;
        }

        public Builder debug(boolean z) {
            this.k = z;
            return this;
        }

        public Builder setAgreeDangerousProtocol(boolean z) {
            this.m = z;
            return this;
        }

        public Builder setFaceResPaths(Map<String, String> map) {
            this.n = map;
            return this;
        }

        public Builder setRuntimeEnvironment(String str) {
            this.f = str;
            return this;
        }

        public Builder showPmnRationaleDialog(boolean z) {
            this.j = z;
            return this;
        }

        public PassBiometricConfiguration build() {
            if (!TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(this.c)) {
                if (this.f == null) {
                    this.f = PassBioEnv.PASSPORT_DOMAIN;
                }
                return new PassBiometricConfiguration(this);
            }
            throw new IllegalArgumentException("tpl, appId, appsignkey, passProductId can not be null, please use setProductLineInfo(String tpl, String appId, String appSignKey, String passProductId)to initialize them.");
        }

        public Builder setProductLicenseInfo(String str, String str2) {
            this.d = str;
            this.e = str2;
            return this;
        }

        public Builder setProductLineInfo(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            return this;
        }

        public Builder sofireSdkConfig(String str, String str2, int i) {
            this.g = str;
            this.h = str2;
            this.i = i;
            return this;
        }
    }

    public PassBiometricConfiguration(Builder builder) {
        this.a = true;
        this.tpl = builder.a;
        this.appId = builder.b;
        this.appSignKey = builder.c;
        this.passDomain = builder.f;
        this.licenseID = builder.d;
        this.licenseFileName = builder.e;
        this.sofireAppKey = builder.g;
        this.sofireSecKey = builder.h;
        this.sofireHostID = builder.i;
        this.a = builder.m;
        debug(builder.k);
        this.showPmnRationaleDialog = builder.j;
        this.b = builder.l;
        this.faceResPaths = builder.n;
    }

    public void debug(boolean z) {
        Log.enable(z);
    }

    public void setAgreeDangerousProtocol(boolean z) {
        this.a = z;
    }

    public Application getApplication() {
        return this.b;
    }

    public boolean isAgreeDangerousProtocol() {
        return this.a;
    }
}
