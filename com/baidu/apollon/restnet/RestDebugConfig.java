package com.baidu.apollon.restnet;

import com.baidu.apollon.ApollonConstants;
/* loaded from: classes2.dex */
public final class RestDebugConfig {

    /* renamed from: a  reason: collision with root package name */
    public static RestDebugConfig f3708a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f3709b = false;

    public static synchronized RestDebugConfig getInstance() {
        RestDebugConfig restDebugConfig;
        synchronized (RestDebugConfig.class) {
            if (f3708a == null) {
                f3708a = new RestDebugConfig();
            }
            restDebugConfig = f3708a;
        }
        return restDebugConfig;
    }

    public boolean isQAEnv() {
        return this.f3709b;
    }

    public void setDebugOn(boolean z) {
        ApollonConstants.DEBUG = z;
    }

    public void setQAEnv(boolean z) {
        this.f3709b = z;
    }
}
