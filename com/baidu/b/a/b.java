package com.baidu.b.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.baidu.searchbox.common.runtime.AppRuntime;
/* loaded from: classes2.dex */
public class b {
    private static Context sAppContext = AppRuntime.getAppContext();
    private static boolean sIsMainProcess = true;
    private static ApplicationInfo Zu = null;

    public static synchronized void init(Context context, boolean z) {
        synchronized (b.class) {
            sIsMainProcess = z;
        }
    }
}
