package com.baidu.poly.b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes11.dex */
public class b {
    private static ExecutorService aSl = Executors.newSingleThreadExecutor();

    public static void e(Runnable runnable) {
        aSl.submit(runnable);
    }
}
