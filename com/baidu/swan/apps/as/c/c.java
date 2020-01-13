package com.baidu.swan.apps.as.c;

import com.baidu.swan.apps.as.ai;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes10.dex */
public class c implements b {
    private final Queue<a> bUT = new ArrayDeque();
    private a bUU;

    public void b(a aVar) {
        if (aVar != null) {
            synchronized (this.bUT) {
                this.bUT.offer(aVar.a(this));
            }
        }
        aeY();
    }

    @Override // com.baidu.swan.apps.as.c.b
    public void a(a aVar) {
        synchronized (this.bUT) {
            if (aVar == this.bUU) {
                runNextTask();
            }
        }
    }

    private void aeY() {
        synchronized (this.bUT) {
            if (this.bUU == null) {
                runNextTask();
            }
        }
    }

    private void runNextTask() {
        synchronized (this.bUT) {
            this.bUU = null;
            if (!this.bUT.isEmpty()) {
                this.bUU = this.bUT.poll();
                if (this.bUU == null) {
                    runNextTask();
                } else {
                    ai.l(this.bUU);
                }
            }
        }
    }

    public synchronized void clear() {
        if (this.bUU != null) {
            this.bUU.finish();
            this.bUU = null;
        }
        this.bUT.clear();
    }
}
