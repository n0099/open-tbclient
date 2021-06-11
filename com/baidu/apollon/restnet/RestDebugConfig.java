package com.baidu.apollon.restnet;

import com.baidu.apollon.ApollonConstants;
/* loaded from: classes.dex */
public final class RestDebugConfig {

    /* renamed from: a  reason: collision with root package name */
    public static RestDebugConfig f3815a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f3816b = false;

    public static synchronized RestDebugConfig getInstance() {
        RestDebugConfig restDebugConfig;
        synchronized (RestDebugConfig.class) {
            if (f3815a == null) {
                f3815a = new RestDebugConfig();
            }
            restDebugConfig = f3815a;
        }
        return restDebugConfig;
    }

    public boolean isQAEnv() {
        return this.f3816b;
    }

    public void setDebugOn(boolean z) {
        ApollonConstants.DEBUG = z;
    }

    public void setQAEnv(boolean z) {
        this.f3816b = z;
    }
}
