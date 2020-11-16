package com.baidu.swan.apps.ap;

import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes7.dex */
public class aq {
    private final Queue<Runnable> dqV = new ArrayDeque();
    private Runnable dCA = null;
    private boolean dCB = false;

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0013, code lost:
        if (aMH() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean n(Runnable runnable) {
        boolean z = true;
        synchronized (this) {
            boolean z2 = runnable == null;
            if (!z2) {
                this.dqV.offer(runnable);
            }
            if (!z2) {
            }
            z = false;
        }
        return z;
    }

    public synchronized boolean aME() {
        boolean aMG;
        aMG = aMG();
        this.dCB = true;
        return aMG;
    }

    public synchronized void aMF() {
        this.dCB = false;
        aMH();
    }

    private boolean aMG() {
        return !this.dCB && this.dCA == null;
    }

    private synchronized boolean aMH() {
        boolean aMG;
        aMG = aMG();
        if (aMG) {
            while (!this.dqV.isEmpty()) {
                this.dCA = this.dqV.poll();
                if (this.dCA != null) {
                    this.dCA.run();
                }
            }
            this.dCA = null;
        }
        return aMG;
    }
}
