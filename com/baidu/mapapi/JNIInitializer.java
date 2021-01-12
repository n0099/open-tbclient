package com.baidu.mapapi;

import android.app.Application;
import android.content.Context;
/* loaded from: classes6.dex */
public class JNIInitializer {

    /* renamed from: a  reason: collision with root package name */
    private static Context f2648a;

    public static Context getCachedContext() {
        return f2648a;
    }

    public static void setContext(Application application) {
        if (application == null) {
            throw new RuntimeException();
        }
        if (f2648a == null) {
            f2648a = application;
        }
    }
}
