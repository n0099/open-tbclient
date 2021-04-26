package com.baidu.mapapi;

import android.app.Application;
import android.content.Context;
/* loaded from: classes2.dex */
public class JNIInitializer {

    /* renamed from: a  reason: collision with root package name */
    public static Context f6997a;

    public static Context getCachedContext() {
        return f6997a;
    }

    public static void setContext(Application application) {
        if (application == null) {
            throw new RuntimeException();
        }
        if (f6997a == null) {
            f6997a = application;
        }
    }
}
