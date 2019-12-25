package com.baidu.poly.b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes9.dex */
public class b {
    private static ExecutorService aMF = Executors.newSingleThreadExecutor();

    public static void e(Runnable runnable) {
        aMF.submit(runnable);
    }
}
