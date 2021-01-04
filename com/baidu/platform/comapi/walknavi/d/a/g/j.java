package com.baidu.platform.comapi.walknavi.d.a.g;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes15.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static Handler f4462a;

    public static void a(Runnable runnable) {
        synchronized (j.class) {
            if (f4462a == null) {
                f4462a = new Handler(Looper.getMainLooper());
            }
        }
        f4462a.post(runnable);
    }
}
