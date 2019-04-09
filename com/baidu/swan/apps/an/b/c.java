package com.baidu.swan.apps.an.b;

import com.baidu.swan.apps.an.aa;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes2.dex */
public class c implements b {
    private final Queue<a> aWH = new ArrayDeque();
    private a aWI;

    public void b(a aVar) {
        if (aVar != null) {
            synchronized (this.aWH) {
                this.aWH.offer(aVar.a(this));
            }
        }
        Mq();
    }

    @Override // com.baidu.swan.apps.an.b.b
    public void a(a aVar) {
        synchronized (this.aWH) {
            if (aVar == this.aWI) {
                Mr();
            }
        }
    }

    private void Mq() {
        synchronized (this.aWH) {
            if (this.aWI == null) {
                Mr();
            }
        }
    }

    private void Mr() {
        synchronized (this.aWH) {
            this.aWI = null;
            if (!this.aWH.isEmpty()) {
                this.aWI = this.aWH.poll();
                if (this.aWI == null) {
                    Mr();
                } else {
                    aa.j(this.aWI);
                }
            }
        }
    }

    public synchronized void clear() {
        if (this.aWI != null) {
            this.aWI.finish();
            this.aWI = null;
        }
        this.aWH.clear();
    }
}
