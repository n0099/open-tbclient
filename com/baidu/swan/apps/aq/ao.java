package com.baidu.swan.apps.aq;

import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes11.dex */
public class ao {
    private static Runnable cKs = null;
    private final Queue<Runnable> czA = new ArrayDeque();

    public synchronized boolean q(Runnable runnable) {
        boolean z;
        boolean z2;
        z = runnable == null;
        if (!z) {
            this.czA.offer(runnable);
        }
        z2 = cKs == null && !this.czA.isEmpty();
        if (z2) {
            while (!this.czA.isEmpty()) {
                cKs = this.czA.poll();
                if (cKs != null) {
                    cKs.run();
                }
                cKs = null;
            }
        }
        return !z && z2;
    }
}
