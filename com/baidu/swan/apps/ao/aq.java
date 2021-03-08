package com.baidu.swan.apps.ao;

import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes8.dex */
public class aq {
    private final Queue<Runnable> dFu = new ArrayDeque();
    private Runnable dRc = null;
    private boolean dRd = false;

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0013, code lost:
        if (aOI() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean k(Runnable runnable) {
        boolean z = true;
        synchronized (this) {
            boolean z2 = runnable == null;
            if (!z2) {
                this.dFu.offer(runnable);
            }
            if (!z2) {
            }
            z = false;
        }
        return z;
    }

    public synchronized boolean aOF() {
        boolean aOH;
        aOH = aOH();
        this.dRd = true;
        return aOH;
    }

    public synchronized void aOG() {
        this.dRd = false;
        aOI();
    }

    private boolean aOH() {
        return !this.dRd && this.dRc == null;
    }

    private synchronized boolean aOI() {
        boolean aOH;
        aOH = aOH();
        if (aOH) {
            while (!this.dFu.isEmpty()) {
                this.dRc = this.dFu.poll();
                if (this.dRc != null) {
                    this.dRc.run();
                }
            }
            this.dRc = null;
        }
        return aOH;
    }
}
