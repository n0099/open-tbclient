package com.baidu.platform.comapi.walknavi.d.a.g;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes2.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static Handler f10013a;

    public static void a(Runnable runnable) {
        synchronized (j.class) {
            if (f10013a == null) {
                f10013a = new Handler(Looper.getMainLooper());
            }
        }
        f10013a.post(runnable);
    }
}
