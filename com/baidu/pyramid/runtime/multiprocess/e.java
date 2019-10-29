package com.baidu.pyramid.runtime.multiprocess;

import android.app.Application;
import android.content.Context;
/* loaded from: classes.dex */
public class e {
    private static Application sApplication;

    public static void c(Application application) {
        sApplication = application;
    }

    public static void a(d dVar) {
        g.a(dVar);
    }

    public static Context getAppContext() {
        return sApplication;
    }
}
