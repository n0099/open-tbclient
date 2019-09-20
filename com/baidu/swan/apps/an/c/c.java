package com.baidu.swan.apps.an.c;

import com.baidu.swan.apps.an.ac;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes2.dex */
public class c implements b {
    private final Queue<a> bbi = new ArrayDeque();
    private a bbj;

    public void b(a aVar) {
        if (aVar != null) {
            synchronized (this.bbi) {
                this.bbi.offer(aVar.a(this));
            }
        }
        PU();
    }

    @Override // com.baidu.swan.apps.an.c.b
    public void a(a aVar) {
        synchronized (this.bbi) {
            if (aVar == this.bbj) {
                PV();
            }
        }
    }

    private void PU() {
        synchronized (this.bbi) {
            if (this.bbj == null) {
                PV();
            }
        }
    }

    private void PV() {
        synchronized (this.bbi) {
            this.bbj = null;
            if (!this.bbi.isEmpty()) {
                this.bbj = this.bbi.poll();
                if (this.bbj == null) {
                    PV();
                } else {
                    ac.k(this.bbj);
                }
            }
        }
    }

    public synchronized void clear() {
        if (this.bbj != null) {
            this.bbj.finish();
            this.bbj = null;
        }
        this.bbi.clear();
    }
}
