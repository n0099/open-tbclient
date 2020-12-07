package com.baidu.swan.apps.ap;

import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes25.dex */
public class aq {
    private final Queue<Runnable> dxW = new ArrayDeque();
    private Runnable dJy = null;
    private boolean dJz = false;

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0013, code lost:
        if (aPN() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean n(Runnable runnable) {
        boolean z = true;
        synchronized (this) {
            boolean z2 = runnable == null;
            if (!z2) {
                this.dxW.offer(runnable);
            }
            if (!z2) {
            }
            z = false;
        }
        return z;
    }

    public synchronized boolean aPK() {
        boolean aPM;
        aPM = aPM();
        this.dJz = true;
        return aPM;
    }

    public synchronized void aPL() {
        this.dJz = false;
        aPN();
    }

    private boolean aPM() {
        return !this.dJz && this.dJy == null;
    }

    private synchronized boolean aPN() {
        boolean aPM;
        aPM = aPM();
        if (aPM) {
            while (!this.dxW.isEmpty()) {
                this.dJy = this.dxW.poll();
                if (this.dJy != null) {
                    this.dJy.run();
                }
            }
            this.dJy = null;
        }
        return aPM;
    }
}
