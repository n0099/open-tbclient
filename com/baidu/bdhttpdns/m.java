package com.baidu.bdhttpdns;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
final class m {
    private static volatile m abz;
    private final Executor b = new ThreadPoolExecutor(5, 25, 20, TimeUnit.SECONDS, new LinkedBlockingDeque(50));

    private m() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m qT() {
        if (abz == null) {
            synchronized (m.class) {
                if (abz == null) {
                    abz = new m();
                }
            }
        }
        return abz;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Executor b() {
        return this.b;
    }
}
