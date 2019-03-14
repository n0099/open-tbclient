package com.baidu.swan.apps.an.b;

import com.baidu.swan.apps.an.aa;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes2.dex */
public class c implements b {
    private final Queue<a> aWD = new ArrayDeque();
    private a aWE;

    public void b(a aVar) {
        if (aVar != null) {
            synchronized (this.aWD) {
                this.aWD.offer(aVar.a(this));
            }
        }
        Ms();
    }

    @Override // com.baidu.swan.apps.an.b.b
    public void a(a aVar) {
        synchronized (this.aWD) {
            if (aVar == this.aWE) {
                Mt();
            }
        }
    }

    private void Ms() {
        synchronized (this.aWD) {
            if (this.aWE == null) {
                Mt();
            }
        }
    }

    private void Mt() {
        synchronized (this.aWD) {
            this.aWE = null;
            if (!this.aWD.isEmpty()) {
                this.aWE = this.aWD.poll();
                if (this.aWE == null) {
                    Mt();
                } else {
                    aa.j(this.aWE);
                }
            }
        }
    }

    public synchronized void clear() {
        if (this.aWE != null) {
            this.aWE.finish();
            this.aWE = null;
        }
        this.aWD.clear();
    }
}
