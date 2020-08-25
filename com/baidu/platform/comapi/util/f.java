package com.baidu.platform.comapi.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes20.dex */
class f {
    private static final int a = Runtime.getRuntime().availableProcessors();
    private static final int b = Math.min((a * 2) + 1, 8);

    public static ExecutorService a(String str) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(b, b, 60L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new c(str));
        try {
            threadPoolExecutor.setKeepAliveTime(60L, TimeUnit.MILLISECONDS);
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Exception e) {
        }
        return threadPoolExecutor;
    }
}
