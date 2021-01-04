package com.baidu.platform.comapi.util;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes15.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static final ExecutorService f4392a = Executors.newSingleThreadExecutor(new c("Single"));

    /* renamed from: b  reason: collision with root package name */
    private static final ExecutorService f4393b = Executors.newFixedThreadPool(4, new c("FixedPool"));
    private static final Handler c = new Handler(Looper.getMainLooper());
    private static final ExecutorService d = f.a("DefaultPool");

    public static ExecutorService a() {
        return d;
    }

    public static void a(Runnable runnable, long j) {
        c.postDelayed(runnable, j);
    }
}
