package com.baidu.bdhttpdns;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
final class m {
    private static volatile m adG;
    private final Executor b = new ThreadPoolExecutor(5, 25, 20, TimeUnit.SECONDS, new LinkedBlockingDeque(50));

    private m() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m sY() {
        if (adG == null) {
            synchronized (m.class) {
                if (adG == null) {
                    adG = new m();
                }
            }
        }
        return adG;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Executor b() {
        return this.b;
    }
}
