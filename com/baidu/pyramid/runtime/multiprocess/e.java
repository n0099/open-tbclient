package com.baidu.pyramid.runtime.multiprocess;

import android.app.Application;
import android.content.Context;
/* loaded from: classes10.dex */
public class e {
    private static Application sApplication;

    public static void onApplicationattachBaseContext(Application application) {
        sApplication = application;
    }

    public static Context getAppContext() {
        return sApplication;
    }
}
