package com.baidu.mapapi;

import android.app.Application;
import android.content.Context;
import com.baidu.vi.VIContext;
/* loaded from: classes20.dex */
public class JNIInitializer {
    private static Context a;

    public static Context getCachedContext() {
        return a;
    }

    public static void setContext(Application application) {
        if (application == null) {
            throw new RuntimeException();
        }
        if (a == null) {
            a = application;
        }
        VIContext.init(application);
    }
}
