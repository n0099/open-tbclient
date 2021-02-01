package com.baidu.swan.apps.ao;

import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes9.dex */
public class aq {
    private final Queue<Runnable> dDT = new ArrayDeque();
    private Runnable dPB = null;
    private boolean dPC = false;

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0013, code lost:
        if (aOF() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean l(Runnable runnable) {
        boolean z = true;
        synchronized (this) {
            boolean z2 = runnable == null;
            if (!z2) {
                this.dDT.offer(runnable);
            }
            if (!z2) {
            }
            z = false;
        }
        return z;
    }

    public synchronized boolean aOC() {
        boolean aOE;
        aOE = aOE();
        this.dPC = true;
        return aOE;
    }

    public synchronized void aOD() {
        this.dPC = false;
        aOF();
    }

    private boolean aOE() {
        return !this.dPC && this.dPB == null;
    }

    private synchronized boolean aOF() {
        boolean aOE;
        aOE = aOE();
        if (aOE) {
            while (!this.dDT.isEmpty()) {
                this.dPB = this.dDT.poll();
                if (this.dPB != null) {
                    this.dPB.run();
                }
            }
            this.dPB = null;
        }
        return aOE;
    }
}
