package com.baidu.swan.apps.as.c;

import com.baidu.swan.apps.as.ai;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes11.dex */
public class c implements b {
    private final Queue<a> bYX = new ArrayDeque();
    private a bYY;

    public void b(a aVar) {
        if (aVar != null) {
            synchronized (this.bYX) {
                this.bYX.offer(aVar.a(this));
            }
        }
        ahm();
    }

    @Override // com.baidu.swan.apps.as.c.b
    public void a(a aVar) {
        synchronized (this.bYX) {
            if (aVar == this.bYY) {
                runNextTask();
            }
        }
    }

    private void ahm() {
        synchronized (this.bYX) {
            if (this.bYY == null) {
                runNextTask();
            }
        }
    }

    private void runNextTask() {
        synchronized (this.bYX) {
            this.bYY = null;
            if (!this.bYX.isEmpty()) {
                this.bYY = this.bYX.poll();
                if (this.bYY == null) {
                    runNextTask();
                } else {
                    ai.l(this.bYY);
                }
            }
        }
    }

    public synchronized void clear() {
        if (this.bYY != null) {
            this.bYY.finish();
            this.bYY = null;
        }
        this.bYX.clear();
    }
}
