package com.baidu.platform.comapi.walknavi.d.a.g;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static Handler f4249a;

    public static void a(Runnable runnable) {
        synchronized (j.class) {
            if (f4249a == null) {
                f4249a = new Handler(Looper.getMainLooper());
            }
        }
        f4249a.post(runnable);
    }
}
