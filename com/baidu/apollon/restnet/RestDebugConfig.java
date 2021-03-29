package com.baidu.apollon.restnet;

import com.baidu.apollon.ApollonConstants;
/* loaded from: classes.dex */
public final class RestDebugConfig {

    /* renamed from: a  reason: collision with root package name */
    public static RestDebugConfig f3709a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f3710b = false;

    public static synchronized RestDebugConfig getInstance() {
        RestDebugConfig restDebugConfig;
        synchronized (RestDebugConfig.class) {
            if (f3709a == null) {
                f3709a = new RestDebugConfig();
            }
            restDebugConfig = f3709a;
        }
        return restDebugConfig;
    }

    public boolean isQAEnv() {
        return this.f3710b;
    }

    public void setDebugOn(boolean z) {
        ApollonConstants.DEBUG = z;
    }

    public void setQAEnv(boolean z) {
        this.f3710b = z;
    }
}
