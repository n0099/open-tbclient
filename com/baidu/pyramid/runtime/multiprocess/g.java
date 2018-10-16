package com.baidu.pyramid.runtime.multiprocess;

import android.app.Application;
import android.content.Context;
/* loaded from: classes2.dex */
public class g {
    private static Application sApplication;

    public static void onApplicationattachBaseContext(Application application) {
        sApplication = application;
    }

    public static void a(f fVar) {
        j.a(fVar);
    }

    public static Context getAppContext() {
        return sApplication;
    }
}
