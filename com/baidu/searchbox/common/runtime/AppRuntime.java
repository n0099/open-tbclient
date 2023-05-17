package com.baidu.searchbox.common.runtime;

import android.app.Application;
import android.content.Context;
/* loaded from: classes3.dex */
public class AppRuntime {
    public static volatile Application sApplication;

    public static Context getAppContext() {
        return sApplication;
    }

    public static Application getApplication() {
        return sApplication;
    }
}
