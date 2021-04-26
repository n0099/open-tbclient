package com.baidu.platform.comapi.walknavi.d.a.g;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes2.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static Handler f9928a;

    public static void a(Runnable runnable) {
        synchronized (j.class) {
            if (f9928a == null) {
                f9928a = new Handler(Looper.getMainLooper());
            }
        }
        f9928a.post(runnable);
    }
}
