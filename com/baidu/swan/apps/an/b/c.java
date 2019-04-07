package com.baidu.swan.apps.an.b;

import com.baidu.swan.apps.an.aa;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes2.dex */
public class c implements b {
    private final Queue<a> aWG = new ArrayDeque();
    private a aWH;

    public void b(a aVar) {
        if (aVar != null) {
            synchronized (this.aWG) {
                this.aWG.offer(aVar.a(this));
            }
        }
        Mq();
    }

    @Override // com.baidu.swan.apps.an.b.b
    public void a(a aVar) {
        synchronized (this.aWG) {
            if (aVar == this.aWH) {
                Mr();
            }
        }
    }

    private void Mq() {
        synchronized (this.aWG) {
            if (this.aWH == null) {
                Mr();
            }
        }
    }

    private void Mr() {
        synchronized (this.aWG) {
            this.aWH = null;
            if (!this.aWG.isEmpty()) {
                this.aWH = this.aWG.poll();
                if (this.aWH == null) {
                    Mr();
                } else {
                    aa.j(this.aWH);
                }
            }
        }
    }

    public synchronized void clear() {
        if (this.aWH != null) {
            this.aWH.finish();
            this.aWH = null;
        }
        this.aWG.clear();
    }
}
