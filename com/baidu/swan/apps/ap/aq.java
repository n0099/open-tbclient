package com.baidu.swan.apps.ap;

import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes3.dex */
public class aq {
    private final Queue<Runnable> cSa = new ArrayDeque();
    private Runnable ddH = null;
    private boolean ddI = false;

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0013, code lost:
        if (aGm() != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean n(Runnable runnable) {
        boolean z = true;
        synchronized (this) {
            boolean z2 = runnable == null;
            if (!z2) {
                this.cSa.offer(runnable);
            }
            if (!z2) {
            }
            z = false;
        }
        return z;
    }

    public synchronized boolean aGj() {
        boolean aGl;
        aGl = aGl();
        this.ddI = true;
        return aGl;
    }

    public synchronized void aGk() {
        this.ddI = false;
        aGm();
    }

    private boolean aGl() {
        return !this.ddI && this.ddH == null;
    }

    private synchronized boolean aGm() {
        boolean aGl;
        aGl = aGl();
        if (aGl) {
            while (!this.cSa.isEmpty()) {
                this.ddH = this.cSa.poll();
                if (this.ddH != null) {
                    this.ddH.run();
                }
            }
            this.ddH = null;
        }
        return aGl;
    }
}
