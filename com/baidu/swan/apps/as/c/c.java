package com.baidu.swan.apps.as.c;

import com.baidu.swan.apps.as.ai;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes11.dex */
public class c implements b {
    private final Queue<a> bZk = new ArrayDeque();
    private a bZl;

    public void b(a aVar) {
        if (aVar != null) {
            synchronized (this.bZk) {
                this.bZk.offer(aVar.a(this));
            }
        }
        ahr();
    }

    @Override // com.baidu.swan.apps.as.c.b
    public void a(a aVar) {
        synchronized (this.bZk) {
            if (aVar == this.bZl) {
                runNextTask();
            }
        }
    }

    private void ahr() {
        synchronized (this.bZk) {
            if (this.bZl == null) {
                runNextTask();
            }
        }
    }

    private void runNextTask() {
        synchronized (this.bZk) {
            this.bZl = null;
            if (!this.bZk.isEmpty()) {
                this.bZl = this.bZk.poll();
                if (this.bZl == null) {
                    runNextTask();
                } else {
                    ai.l(this.bZl);
                }
            }
        }
    }

    public synchronized void clear() {
        if (this.bZl != null) {
            this.bZl.finish();
            this.bZl = null;
        }
        this.bZk.clear();
    }
}
