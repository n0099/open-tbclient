package com.baidu.swan.apps.an.b;

import com.baidu.swan.apps.an.aa;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes2.dex */
public class c implements b {
    private final Queue<a> aWC = new ArrayDeque();
    private a aWD;

    public void b(a aVar) {
        if (aVar != null) {
            synchronized (this.aWC) {
                this.aWC.offer(aVar.a(this));
            }
        }
        Ms();
    }

    @Override // com.baidu.swan.apps.an.b.b
    public void a(a aVar) {
        synchronized (this.aWC) {
            if (aVar == this.aWD) {
                Mt();
            }
        }
    }

    private void Ms() {
        synchronized (this.aWC) {
            if (this.aWD == null) {
                Mt();
            }
        }
    }

    private void Mt() {
        synchronized (this.aWC) {
            this.aWD = null;
            if (!this.aWC.isEmpty()) {
                this.aWD = this.aWC.poll();
                if (this.aWD == null) {
                    Mt();
                } else {
                    aa.j(this.aWD);
                }
            }
        }
    }

    public synchronized void clear() {
        if (this.aWD != null) {
            this.aWD.finish();
            this.aWD = null;
        }
        this.aWC.clear();
    }
}
