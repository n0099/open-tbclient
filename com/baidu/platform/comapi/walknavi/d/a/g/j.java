package com.baidu.platform.comapi.walknavi.d.a.g;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes26.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static Handler f2995a;

    public static void a(Runnable runnable) {
        synchronized (j.class) {
            if (f2995a == null) {
                f2995a = new Handler(Looper.getMainLooper());
            }
        }
        f2995a.post(runnable);
    }
}
