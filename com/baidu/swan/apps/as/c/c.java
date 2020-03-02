package com.baidu.swan.apps.as.c;

import com.baidu.swan.apps.as.ai;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes11.dex */
public class c implements b {
    private final Queue<a> bYY = new ArrayDeque();
    private a bYZ;

    public void b(a aVar) {
        if (aVar != null) {
            synchronized (this.bYY) {
                this.bYY.offer(aVar.a(this));
            }
        }
        aho();
    }

    @Override // com.baidu.swan.apps.as.c.b
    public void a(a aVar) {
        synchronized (this.bYY) {
            if (aVar == this.bYZ) {
                runNextTask();
            }
        }
    }

    private void aho() {
        synchronized (this.bYY) {
            if (this.bYZ == null) {
                runNextTask();
            }
        }
    }

    private void runNextTask() {
        synchronized (this.bYY) {
            this.bYZ = null;
            if (!this.bYY.isEmpty()) {
                this.bYZ = this.bYY.poll();
                if (this.bYZ == null) {
                    runNextTask();
                } else {
                    ai.l(this.bYZ);
                }
            }
        }
    }

    public synchronized void clear() {
        if (this.bYZ != null) {
            this.bYZ.finish();
            this.bYZ = null;
        }
        this.bYY.clear();
    }
}
