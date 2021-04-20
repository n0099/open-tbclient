package com.baidu.nps;

import android.app.Application;
import android.os.Build;
import d.b.w.b.a.a;
/* loaded from: classes2.dex */
public class NPSHookManager {
    public static void init(Application application) {
        if (Build.VERSION.SDK_INT < 28) {
            a.a(application);
        }
    }
}
