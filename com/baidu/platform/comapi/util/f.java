package com.baidu.platform.comapi.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes15.dex */
class f {

    /* renamed from: a  reason: collision with root package name */
    private static final int f4389a = Runtime.getRuntime().availableProcessors();

    /* renamed from: b  reason: collision with root package name */
    private static final int f4390b = Math.min((f4389a * 2) + 1, 8);

    public static ExecutorService a(String str) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f4390b, f4390b, 60L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new c(str));
        try {
            threadPoolExecutor.setKeepAliveTime(60L, TimeUnit.MILLISECONDS);
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Exception e) {
        }
        return threadPoolExecutor;
    }
}
