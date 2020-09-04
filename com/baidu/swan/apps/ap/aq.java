package com.baidu.swan.apps.ap;

import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes8.dex */
public class aq {
    private final Queue<Runnable> cQa = new ArrayDeque();
    private Runnable dbF = null;
    private boolean dbG = false;

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0013, code lost:
        if (aFC() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean n(Runnable runnable) {
        boolean z = true;
        synchronized (this) {
            boolean z2 = runnable == null;
            if (!z2) {
                this.cQa.offer(runnable);
            }
            if (!z2) {
            }
            z = false;
        }
        return z;
    }

    public synchronized boolean aFz() {
        boolean aFB;
        aFB = aFB();
        this.dbG = true;
        return aFB;
    }

    public synchronized void aFA() {
        this.dbG = false;
        aFC();
    }

    private boolean aFB() {
        return !this.dbG && this.dbF == null;
    }

    private synchronized boolean aFC() {
        boolean aFB;
        aFB = aFB();
        if (aFB) {
            while (!this.cQa.isEmpty()) {
                this.dbF = this.cQa.poll();
                if (this.dbF != null) {
                    this.dbF.run();
                }
            }
            this.dbF = null;
        }
        return aFB;
    }
}
