package com.baidu.platform.comapi.walknavi.d.a.g;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes2.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static Handler f10012a;

    public static void a(Runnable runnable) {
        synchronized (j.class) {
            if (f10012a == null) {
                f10012a = new Handler(Looper.getMainLooper());
            }
        }
        f10012a.post(runnable);
    }
}
