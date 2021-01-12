package com.baidu.searchbox.common.runtime;

import android.app.Application;
import android.content.Context;
/* loaded from: classes5.dex */
public class AppRuntime {
    static Application sApplication;

    public static Context getAppContext() {
        return sApplication;
    }

    public static Application getApplication() {
        return sApplication;
    }
}
