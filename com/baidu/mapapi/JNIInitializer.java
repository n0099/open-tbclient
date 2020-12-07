package com.baidu.mapapi;

import android.app.Application;
import android.content.Context;
import com.baidu.vi.VIContext;
/* loaded from: classes26.dex */
public class JNIInitializer {

    /* renamed from: a  reason: collision with root package name */
    private static Context f1961a;

    public static Context getCachedContext() {
        return f1961a;
    }

    public static void setContext(Application application) {
        if (application == null) {
            throw new RuntimeException();
        }
        if (f1961a == null) {
            f1961a = application;
        }
        VIContext.init(application);
    }
}
