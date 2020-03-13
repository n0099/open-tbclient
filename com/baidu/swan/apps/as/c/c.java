package com.baidu.swan.apps.as.c;

import com.baidu.swan.apps.as.ai;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes11.dex */
public class c implements b {
    private final Queue<a> bYZ = new ArrayDeque();
    private a bZa;

    public void b(a aVar) {
        if (aVar != null) {
            synchronized (this.bYZ) {
                this.bYZ.offer(aVar.a(this));
            }
        }
        aho();
    }

    @Override // com.baidu.swan.apps.as.c.b
    public void a(a aVar) {
        synchronized (this.bYZ) {
            if (aVar == this.bZa) {
                runNextTask();
            }
        }
    }

    private void aho() {
        synchronized (this.bYZ) {
            if (this.bZa == null) {
                runNextTask();
            }
        }
    }

    private void runNextTask() {
        synchronized (this.bYZ) {
            this.bZa = null;
            if (!this.bYZ.isEmpty()) {
                this.bZa = this.bYZ.poll();
                if (this.bZa == null) {
                    runNextTask();
                } else {
                    ai.l(this.bZa);
                }
            }
        }
    }

    public synchronized void clear() {
        if (this.bZa != null) {
            this.bZa.finish();
            this.bZa = null;
        }
        this.bYZ.clear();
    }
}
