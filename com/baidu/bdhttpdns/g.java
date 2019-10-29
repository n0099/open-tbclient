package com.baidu.bdhttpdns;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
final class g {
    private static volatile g Fn;
    private final Executor b = new ThreadPoolExecutor(5, 25, 20, TimeUnit.SECONDS, new LinkedBlockingDeque(50));

    private g() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g lF() {
        if (Fn == null) {
            synchronized (g.class) {
                if (Fn == null) {
                    Fn = new g();
                }
            }
        }
        return Fn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Executor b() {
        return this.b;
    }
}
