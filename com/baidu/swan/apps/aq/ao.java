package com.baidu.swan.apps.aq;

import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes11.dex */
public class ao {
    private static Runnable cPc = null;
    private final Queue<Runnable> cEk = new ArrayDeque();

    public synchronized boolean q(Runnable runnable) {
        boolean z;
        boolean z2;
        z = runnable == null;
        if (!z) {
            this.cEk.offer(runnable);
        }
        z2 = cPc == null && !this.cEk.isEmpty();
        if (z2) {
            while (!this.cEk.isEmpty()) {
                cPc = this.cEk.poll();
                if (cPc != null) {
                    cPc.run();
                }
                cPc = null;
            }
        }
        return !z && z2;
    }
}
