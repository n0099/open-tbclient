package com.baidu.platform.comapi.walknavi.d.a.g;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes7.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static Handler f2991a;

    public static void a(Runnable runnable) {
        synchronized (j.class) {
            if (f2991a == null) {
                f2991a = new Handler(Looper.getMainLooper());
            }
        }
        f2991a.post(runnable);
    }
}
