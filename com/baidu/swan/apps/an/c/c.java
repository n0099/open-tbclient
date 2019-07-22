package com.baidu.swan.apps.an.c;

import com.baidu.swan.apps.an.ac;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes2.dex */
public class c implements b {
    private final Queue<a> baK = new ArrayDeque();
    private a baL;

    public void b(a aVar) {
        if (aVar != null) {
            synchronized (this.baK) {
                this.baK.offer(aVar.a(this));
            }
        }
        PQ();
    }

    @Override // com.baidu.swan.apps.an.c.b
    public void a(a aVar) {
        synchronized (this.baK) {
            if (aVar == this.baL) {
                PR();
            }
        }
    }

    private void PQ() {
        synchronized (this.baK) {
            if (this.baL == null) {
                PR();
            }
        }
    }

    private void PR() {
        synchronized (this.baK) {
            this.baL = null;
            if (!this.baK.isEmpty()) {
                this.baL = this.baK.poll();
                if (this.baL == null) {
                    PR();
                } else {
                    ac.k(this.baL);
                }
            }
        }
    }

    public synchronized void clear() {
        if (this.baL != null) {
            this.baL.finish();
            this.baL = null;
        }
        this.baK.clear();
    }
}
