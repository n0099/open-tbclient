package com.baidu.poly.c;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class a {
    private static ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static void e(Runnable runnable) {
        executorService.submit(runnable);
    }
}
