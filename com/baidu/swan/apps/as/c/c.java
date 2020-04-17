package com.baidu.swan.apps.as.c;

import com.baidu.swan.apps.as.ai;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes11.dex */
public class c implements b {
    private final Queue<a> cyd = new ArrayDeque();
    private a cye;

    public void b(a aVar) {
        if (aVar != null) {
            synchronized (this.cyd) {
                this.cyd.offer(aVar.a(this));
            }
        }
        apz();
    }

    @Override // com.baidu.swan.apps.as.c.b
    public void a(a aVar) {
        synchronized (this.cyd) {
            if (aVar == this.cye) {
                runNextTask();
            }
        }
    }

    private void apz() {
        synchronized (this.cyd) {
            if (this.cye == null) {
                runNextTask();
            }
        }
    }

    private void runNextTask() {
        synchronized (this.cyd) {
            this.cye = null;
            if (!this.cyd.isEmpty()) {
                this.cye = this.cyd.poll();
                if (this.cye == null) {
                    runNextTask();
                } else {
                    ai.o(this.cye);
                }
            }
        }
    }

    public synchronized void clear() {
        if (this.cye != null) {
            this.cye.finish();
            this.cye = null;
        }
        this.cyd.clear();
    }
}
