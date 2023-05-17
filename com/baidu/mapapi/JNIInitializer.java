package com.baidu.mapapi;

import android.app.Application;
import android.content.Context;
import com.baidu.vi.VIContext;
/* loaded from: classes3.dex */
public class JNIInitializer {
    public static Context a;

    public static Context getCachedContext() {
        return a;
    }

    public static void setContext(Application application) {
        if (application != null) {
            if (a == null) {
                a = application;
            }
            VIContext.init(application);
            return;
        }
        throw new RuntimeException();
    }
}
