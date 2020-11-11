package com.baidu.platform.comapi.walknavi.d.a.g;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes7.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static Handler f2993a;

    public static void a(Runnable runnable) {
        synchronized (j.class) {
            if (f2993a == null) {
                f2993a = new Handler(Looper.getMainLooper());
            }
        }
        f2993a.post(runnable);
    }
}
