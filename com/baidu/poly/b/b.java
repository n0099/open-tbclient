package com.baidu.poly.b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes10.dex */
public class b {
    private static ExecutorService aNx = Executors.newSingleThreadExecutor();

    public static void e(Runnable runnable) {
        aNx.submit(runnable);
    }
}
