package com.baidu.swan.apps.ap.d;

import com.baidu.swan.apps.ap.ak;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes10.dex */
public class c implements b {
    private final Queue<a> dqA = new ArrayDeque();
    private a dqB;

    public void b(a aVar) {
        if (aVar != null) {
            synchronized (this.dqA) {
                this.dqA.offer(aVar.a(this));
            }
        }
        aJa();
    }

    @Override // com.baidu.swan.apps.ap.d.b
    public void a(a aVar) {
        synchronized (this.dqA) {
            if (aVar == this.dqB) {
                runNextTask();
            }
        }
    }

    private void aJa() {
        synchronized (this.dqA) {
            if (this.dqB == null) {
                runNextTask();
            }
        }
    }

    private void runNextTask() {
        synchronized (this.dqA) {
            this.dqB = null;
            if (!this.dqA.isEmpty()) {
                this.dqB = this.dqA.poll();
                if (this.dqB == null) {
                    runNextTask();
                } else {
                    ak.m(this.dqB);
                }
            }
        }
    }

    public synchronized void clear() {
        if (this.dqB != null) {
            this.dqB.finish();
            this.dqB = null;
        }
        this.dqA.clear();
    }
}
