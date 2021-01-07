package com.baidu.swan.apps.ao;

import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes9.dex */
public class aq {
    private final Queue<Runnable> dGB = new ArrayDeque();
    private Runnable dSh = null;
    private boolean dSi = false;

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0013, code lost:
        if (aSg() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean m(Runnable runnable) {
        boolean z = true;
        synchronized (this) {
            boolean z2 = runnable == null;
            if (!z2) {
                this.dGB.offer(runnable);
            }
            if (!z2) {
            }
            z = false;
        }
        return z;
    }

    public synchronized boolean aSd() {
        boolean aSf;
        aSf = aSf();
        this.dSi = true;
        return aSf;
    }

    public synchronized void aSe() {
        this.dSi = false;
        aSg();
    }

    private boolean aSf() {
        return !this.dSi && this.dSh == null;
    }

    private synchronized boolean aSg() {
        boolean aSf;
        aSf = aSf();
        if (aSf) {
            while (!this.dGB.isEmpty()) {
                this.dSh = this.dGB.poll();
                if (this.dSh != null) {
                    this.dSh.run();
                }
            }
            this.dSh = null;
        }
        return aSf;
    }
}
