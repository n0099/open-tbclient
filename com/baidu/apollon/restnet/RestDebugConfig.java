package com.baidu.apollon.restnet;

import com.baidu.apollon.ApollonConstants;
/* loaded from: classes.dex */
public final class RestDebugConfig {

    /* renamed from: a  reason: collision with root package name */
    public static RestDebugConfig f3744a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f3745b = false;

    public static synchronized RestDebugConfig getInstance() {
        RestDebugConfig restDebugConfig;
        synchronized (RestDebugConfig.class) {
            if (f3744a == null) {
                f3744a = new RestDebugConfig();
            }
            restDebugConfig = f3744a;
        }
        return restDebugConfig;
    }

    public boolean isQAEnv() {
        return this.f3745b;
    }

    public void setDebugOn(boolean z) {
        ApollonConstants.DEBUG = z;
    }

    public void setQAEnv(boolean z) {
        this.f3745b = z;
    }
}
