package com.baidu.swan.apps.ap;

import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes10.dex */
public class aq {
    private final Queue<Runnable> deh = new ArrayDeque();
    private Runnable dpP = null;
    private boolean dpQ = false;

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0013, code lost:
        if (aIV() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean n(Runnable runnable) {
        boolean z = true;
        synchronized (this) {
            boolean z2 = runnable == null;
            if (!z2) {
                this.deh.offer(runnable);
            }
            if (!z2) {
            }
            z = false;
        }
        return z;
    }

    public synchronized boolean aIS() {
        boolean aIU;
        aIU = aIU();
        this.dpQ = true;
        return aIU;
    }

    public synchronized void aIT() {
        this.dpQ = false;
        aIV();
    }

    private boolean aIU() {
        return !this.dpQ && this.dpP == null;
    }

    private synchronized boolean aIV() {
        boolean aIU;
        aIU = aIU();
        if (aIU) {
            while (!this.deh.isEmpty()) {
                this.dpP = this.deh.poll();
                if (this.dpP != null) {
                    this.dpP.run();
                }
            }
            this.dpP = null;
        }
        return aIU;
    }
}
