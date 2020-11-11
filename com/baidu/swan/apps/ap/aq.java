package com.baidu.swan.apps.ap;

import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes10.dex */
public class aq {
    private final Queue<Runnable> dsE = new ArrayDeque();
    private Runnable dEh = null;
    private boolean dEi = false;

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0013, code lost:
        if (aNp() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean n(Runnable runnable) {
        boolean z = true;
        synchronized (this) {
            boolean z2 = runnable == null;
            if (!z2) {
                this.dsE.offer(runnable);
            }
            if (!z2) {
            }
            z = false;
        }
        return z;
    }

    public synchronized boolean aNm() {
        boolean aNo;
        aNo = aNo();
        this.dEi = true;
        return aNo;
    }

    public synchronized void aNn() {
        this.dEi = false;
        aNp();
    }

    private boolean aNo() {
        return !this.dEi && this.dEh == null;
    }

    private synchronized boolean aNp() {
        boolean aNo;
        aNo = aNo();
        if (aNo) {
            while (!this.dsE.isEmpty()) {
                this.dEh = this.dsE.poll();
                if (this.dEh != null) {
                    this.dEh.run();
                }
            }
            this.dEh = null;
        }
        return aNo;
    }
}
