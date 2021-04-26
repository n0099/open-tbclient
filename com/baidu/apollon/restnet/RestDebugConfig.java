package com.baidu.apollon.restnet;

import com.baidu.apollon.ApollonConstants;
/* loaded from: classes.dex */
public final class RestDebugConfig {

    /* renamed from: a  reason: collision with root package name */
    public static RestDebugConfig f3792a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f3793b = false;

    public static synchronized RestDebugConfig getInstance() {
        RestDebugConfig restDebugConfig;
        synchronized (RestDebugConfig.class) {
            if (f3792a == null) {
                f3792a = new RestDebugConfig();
            }
            restDebugConfig = f3792a;
        }
        return restDebugConfig;
    }

    public boolean isQAEnv() {
        return this.f3793b;
    }

    public void setDebugOn(boolean z) {
        ApollonConstants.DEBUG = z;
    }

    public void setQAEnv(boolean z) {
        this.f3793b = z;
    }
}
