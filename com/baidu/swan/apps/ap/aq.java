package com.baidu.swan.apps.ap;

import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes10.dex */
public class aq {
    private final Queue<Runnable> dmH = new ArrayDeque();
    private Runnable dyp = null;
    private boolean dyq = false;

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0013, code lost:
        if (aKP() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean n(Runnable runnable) {
        boolean z = true;
        synchronized (this) {
            boolean z2 = runnable == null;
            if (!z2) {
                this.dmH.offer(runnable);
            }
            if (!z2) {
            }
            z = false;
        }
        return z;
    }

    public synchronized boolean aKM() {
        boolean aKO;
        aKO = aKO();
        this.dyq = true;
        return aKO;
    }

    public synchronized void aKN() {
        this.dyq = false;
        aKP();
    }

    private boolean aKO() {
        return !this.dyq && this.dyp == null;
    }

    private synchronized boolean aKP() {
        boolean aKO;
        aKO = aKO();
        if (aKO) {
            while (!this.dmH.isEmpty()) {
                this.dyp = this.dmH.poll();
                if (this.dyp != null) {
                    this.dyp.run();
                }
            }
            this.dyp = null;
        }
        return aKO;
    }
}
