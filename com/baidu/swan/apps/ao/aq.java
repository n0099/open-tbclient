package com.baidu.swan.apps.ao;

import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes8.dex */
public class aq {
    private final Queue<Runnable> dBP = new ArrayDeque();
    private Runnable dNv = null;
    private boolean dNw = false;

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0013, code lost:
        if (aOm() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean m(Runnable runnable) {
        boolean z = true;
        synchronized (this) {
            boolean z2 = runnable == null;
            if (!z2) {
                this.dBP.offer(runnable);
            }
            if (!z2) {
            }
            z = false;
        }
        return z;
    }

    public synchronized boolean aOj() {
        boolean aOl;
        aOl = aOl();
        this.dNw = true;
        return aOl;
    }

    public synchronized void aOk() {
        this.dNw = false;
        aOm();
    }

    private boolean aOl() {
        return !this.dNw && this.dNv == null;
    }

    private synchronized boolean aOm() {
        boolean aOl;
        aOl = aOl();
        if (aOl) {
            while (!this.dBP.isEmpty()) {
                this.dNv = this.dBP.poll();
                if (this.dNv != null) {
                    this.dNv.run();
                }
            }
            this.dNv = null;
        }
        return aOl;
    }
}
