package com.baidu.mapapi;

import android.app.Application;
import android.content.Context;
import com.baidu.vi.VIContext;
/* loaded from: classes3.dex */
public class JNIInitializer {

    /* renamed from: a  reason: collision with root package name */
    private static Context f2738a;

    public static Context getCachedContext() {
        return f2738a;
    }

    public static void setContext(Application application) {
        if (application == null) {
            throw new RuntimeException();
        }
        if (f2738a == null) {
            f2738a = application;
        }
        VIContext.init(application);
    }
}
