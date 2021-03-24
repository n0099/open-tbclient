package com.baidu.fsg.base.restnet;

import com.baidu.fsg.base.ApollonConstants;
/* loaded from: classes2.dex */
public final class RestDebugConfig {
    public static RestDebugConfig mInstance;
    public boolean mIsQAEnv = false;

    public static synchronized RestDebugConfig getInstance() {
        RestDebugConfig restDebugConfig;
        synchronized (RestDebugConfig.class) {
            if (mInstance == null) {
                mInstance = new RestDebugConfig();
            }
            restDebugConfig = mInstance;
        }
        return restDebugConfig;
    }

    public boolean isQAEnv() {
        return this.mIsQAEnv;
    }

    public void setDebugOn(boolean z) {
        ApollonConstants.DEBUG = z;
    }

    public void setQAEnv(boolean z) {
        this.mIsQAEnv = z;
    }
}
