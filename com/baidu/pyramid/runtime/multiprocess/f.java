package com.baidu.pyramid.runtime.multiprocess;

import android.app.Application;
import android.content.Context;
/* loaded from: classes.dex */
public class f {
    private static Application sApplication;

    public static void b(Application application) {
        sApplication = application;
    }

    public static void a(e eVar) {
        i.a(eVar);
    }

    public static Context getAppContext() {
        return sApplication;
    }
}
