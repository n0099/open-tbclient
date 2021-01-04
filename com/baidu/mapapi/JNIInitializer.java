package com.baidu.mapapi;

import android.app.Application;
import android.content.Context;
import com.baidu.vi.VIContext;
/* loaded from: classes15.dex */
public class JNIInitializer {

    /* renamed from: a  reason: collision with root package name */
    private static Context f2737a;

    public static Context getCachedContext() {
        return f2737a;
    }

    public static void setContext(Application application) {
        if (application == null) {
            throw new RuntimeException();
        }
        if (f2737a == null) {
            f2737a = application;
        }
        VIContext.init(application);
    }
}
