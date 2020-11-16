package com.baidu.fsg.base.restnet;

import com.baidu.fsg.base.ApollonConstants;
/* loaded from: classes15.dex */
public final class RestDebugConfig {
    private static RestDebugConfig mInstance;
    private boolean mIsQAEnv = false;

    private RestDebugConfig() {
    }

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

    public void setQAEnv(boolean z) {
        this.mIsQAEnv = z;
    }

    public void setDebugOn(boolean z) {
        ApollonConstants.DEBUG = z;
    }
}
