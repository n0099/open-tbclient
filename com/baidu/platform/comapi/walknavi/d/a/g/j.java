package com.baidu.platform.comapi.walknavi.d.a.g;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes6.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static Handler f4246a;

    public static void a(Runnable runnable) {
        synchronized (j.class) {
            if (f4246a == null) {
                f4246a = new Handler(Looper.getMainLooper());
            }
        }
        f4246a.post(runnable);
    }
}
