package com.baidu.bdhttpdns;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
final class g {
    private static volatile g EM;
    private final Executor b = new ThreadPoolExecutor(5, 25, 20, TimeUnit.SECONDS, new LinkedBlockingDeque(50));

    private g() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g lF() {
        if (EM == null) {
            synchronized (g.class) {
                if (EM == null) {
                    EM = new g();
                }
            }
        }
        return EM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Executor b() {
        return this.b;
    }
}
