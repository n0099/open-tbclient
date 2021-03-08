package com.baidu.platform.comapi.walknavi.d.a.g;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static Handler f2939a;

    public static void a(Runnable runnable) {
        synchronized (j.class) {
            if (f2939a == null) {
                f2939a = new Handler(Looper.getMainLooper());
            }
        }
        f2939a.post(runnable);
    }
}
