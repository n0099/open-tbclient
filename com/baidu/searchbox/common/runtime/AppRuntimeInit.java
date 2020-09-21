package com.baidu.searchbox.common.runtime;

import android.app.Application;
/* loaded from: classes15.dex */
public class AppRuntimeInit {
    public static void onApplicationattachBaseContext(Application application) {
        AppRuntime.sApplication = application;
    }

    public static void onApplicationCreate() {
    }
}
