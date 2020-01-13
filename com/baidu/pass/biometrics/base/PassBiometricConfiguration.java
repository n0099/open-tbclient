package com.baidu.pass.biometrics.base;

import android.app.Application;
import android.text.TextUtils;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
/* loaded from: classes5.dex */
public class PassBiometricConfiguration {
    public static final String TARGET_TPL = "pp";
    public final String appId;
    public final String appSignKey;
    private Application application;
    public String passDomain;
    public boolean showPmnRationaleDialog;
    public final String tpl;

    private PassBiometricConfiguration(Builder builder) {
        this.tpl = builder.tpl;
        this.appId = builder.appId;
        this.appSignKey = builder.appSignKey;
        this.passDomain = builder.passDomain;
        debug(builder.debug);
        this.showPmnRationaleDialog = builder.showPmnRationaleDialog;
        this.application = builder.application;
    }

    public Application getApplication() {
        return this.application;
    }

    public void debug(boolean z) {
        Log.enable(z);
    }

    /* loaded from: classes5.dex */
    public static class Builder {
        private String appId;
        private String appSignKey;
        private Application application;
        private String passDomain;
        private String tpl;
        private boolean showPmnRationaleDialog = false;
        private boolean debug = false;

        public Builder(Application application) {
            this.application = application;
        }

        public Builder setProductLineInfo(String str, String str2, String str3) {
            this.tpl = str;
            this.appId = str2;
            this.appSignKey = str3;
            return this;
        }

        public Builder setRuntimeEnvironment(String str) {
            this.passDomain = str;
            return this;
        }

        public Builder debug(boolean z) {
            this.debug = z;
            return this;
        }

        public Builder showPmnRationaleDialog(boolean z) {
            this.showPmnRationaleDialog = z;
            return this;
        }

        public PassBiometricConfiguration build() {
            if (TextUtils.isEmpty(this.tpl) || TextUtils.isEmpty(this.appId) || TextUtils.isEmpty(this.appSignKey)) {
                throw new IllegalArgumentException("tpl, appId, appsignkey, passProductId can not be null, please use setProductLineInfo(String tpl, String appId, String appSignKey, String passProductId)to initialize them.");
            }
            if (this.passDomain == null) {
                this.passDomain = PassBioEnv.PASSPORT_DOMAIN;
            }
            return new PassBiometricConfiguration(this);
        }
    }
}
