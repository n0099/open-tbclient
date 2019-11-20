package com.baidu.swan.apps.an.c;

import com.baidu.swan.apps.an.ac;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes2.dex */
public class c implements b {
    private final Queue<a> btq = new ArrayDeque();
    private a btr;

    public void b(a aVar) {
        if (aVar != null) {
            synchronized (this.btq) {
                this.btq.offer(aVar.a(this));
            }
        }
        UI();
    }

    @Override // com.baidu.swan.apps.an.c.b
    public void a(a aVar) {
        synchronized (this.btq) {
            if (aVar == this.btr) {
                UJ();
            }
        }
    }

    private void UI() {
        synchronized (this.btq) {
            if (this.btr == null) {
                UJ();
            }
        }
    }

    private void UJ() {
        synchronized (this.btq) {
            this.btr = null;
            if (!this.btq.isEmpty()) {
                this.btr = this.btq.poll();
                if (this.btr == null) {
                    UJ();
                } else {
                    ac.i(this.btr);
                }
            }
        }
    }

    public synchronized void clear() {
        if (this.btr != null) {
            this.btr.finish();
            this.btr = null;
        }
        this.btq.clear();
    }
}
