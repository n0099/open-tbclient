package com.baidu.swan.apps.ap;

import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes8.dex */
public class aq {
    private final Queue<Runnable> cPW = new ArrayDeque();
    private Runnable dbB = null;
    private boolean dbC = false;

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
                this.cPW.offer(runnable);
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
        this.dbC = true;
        return aFB;
    }

    public synchronized void aFA() {
        this.dbC = false;
        aFC();
    }

    private boolean aFB() {
        return !this.dbC && this.dbB == null;
    }

    private synchronized boolean aFC() {
        boolean aFB;
        aFB = aFB();
        if (aFB) {
            while (!this.cPW.isEmpty()) {
                this.dbB = this.cPW.poll();
                if (this.dbB != null) {
                    this.dbB.run();
                }
            }
            this.dbB = null;
        }
        return aFB;
    }
}
