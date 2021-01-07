package com.baidu.swan.apps.ao.d;

import com.baidu.swan.apps.ao.ak;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes9.dex */
public class c implements b {
    private final Queue<a> dST = new ArrayDeque();
    private a dSU;

    public void b(a aVar) {
        if (aVar != null) {
            synchronized (this.dST) {
                this.dST.offer(aVar.a(this));
            }
        }
        aSl();
    }

    @Override // com.baidu.swan.apps.ao.d.b
    public void a(a aVar) {
        synchronized (this.dST) {
            if (aVar == this.dSU) {
                aSm();
            }
        }
    }

    private void aSl() {
        synchronized (this.dST) {
            if (this.dSU == null) {
                aSm();
            }
        }
    }

    private void aSm() {
        synchronized (this.dST) {
            this.dSU = null;
            if (!this.dST.isEmpty()) {
                this.dSU = this.dST.poll();
                if (this.dSU == null) {
                    aSm();
                } else {
                    ak.l(this.dSU);
                }
            }
        }
    }

    public synchronized void clear() {
        if (this.dSU != null) {
            this.dSU.finish();
            this.dSU = null;
        }
        this.dST.clear();
    }
}
