package com.baidu.pyramid.runtime.multiprocess;

import android.app.Application;
import android.content.Context;
/* loaded from: classes2.dex */
public class f {
    private static Application sApplication;

    public static void onApplicationattachBaseContext(Application application) {
        sApplication = application;
    }

    public static void a(e eVar) {
        h.a(eVar);
    }

    public static Context getAppContext() {
        return sApplication;
    }
}
