package com.baidu.swan.apps.aq;

import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes7.dex */
public class ar {
    private final Queue<Runnable> cGX = new ArrayDeque();
    private Runnable cSC = null;
    private boolean cSD = false;

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0013, code lost:
        if (axt() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean q(Runnable runnable) {
        boolean z = true;
        synchronized (this) {
            boolean z2 = runnable == null;
            if (!z2) {
                this.cGX.offer(runnable);
            }
            if (!z2) {
            }
            z = false;
        }
        return z;
    }

    public synchronized boolean axq() {
        boolean axs;
        axs = axs();
        this.cSD = true;
        return axs;
    }

    public synchronized void axr() {
        this.cSD = false;
        axt();
    }

    private boolean axs() {
        return !this.cSD && this.cSC == null;
    }

    private synchronized boolean axt() {
        boolean axs;
        axs = axs();
        if (axs) {
            while (!this.cGX.isEmpty()) {
                this.cSC = this.cGX.poll();
                if (this.cSC != null) {
                    this.cSC.run();
                }
            }
            this.cSC = null;
        }
        return axs;
    }
}
