package com.baidu.searchbox.common.runtime;

import android.app.Application;
/* loaded from: classes.dex */
public class AppRuntimeInit {
    public static void onApplicationCreate() {
    }

    public static void onApplicationattachBaseContext(Application application) {
        AppRuntime.sApplication = application;
    }
}
