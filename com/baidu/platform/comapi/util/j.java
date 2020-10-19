package com.baidu.platform.comapi.util;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes7.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static final ExecutorService f2948a = Executors.newSingleThreadExecutor(new c("Single"));
    private static final ExecutorService b = Executors.newFixedThreadPool(4, new c("FixedPool"));
    private static final Handler c = new Handler(Looper.getMainLooper());
    private static final ExecutorService d = f.a("DefaultPool");

    public static ExecutorService a() {
        return d;
    }

    public static void a(Runnable runnable, long j) {
        c.postDelayed(runnable, j);
    }
}
