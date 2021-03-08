package com.baidu.mapapi;

import android.app.Application;
import android.content.Context;
/* loaded from: classes4.dex */
public class JNIInitializer {

    /* renamed from: a  reason: collision with root package name */
    private static Context f1976a;

    public static Context getCachedContext() {
        return f1976a;
    }

    public static void setContext(Application application) {
        if (application == null) {
            throw new RuntimeException();
        }
        if (f1976a == null) {
            f1976a = application;
        }
    }
}
