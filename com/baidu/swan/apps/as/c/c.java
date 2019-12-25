package com.baidu.swan.apps.as.c;

import com.baidu.swan.apps.as.ai;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes9.dex */
public class c implements b {
    private final Queue<a> bUH = new ArrayDeque();
    private a bUI;

    public void b(a aVar) {
        if (aVar != null) {
            synchronized (this.bUH) {
                this.bUH.offer(aVar.a(this));
            }
        }
        aeF();
    }

    @Override // com.baidu.swan.apps.as.c.b
    public void a(a aVar) {
        synchronized (this.bUH) {
            if (aVar == this.bUI) {
                runNextTask();
            }
        }
    }

    private void aeF() {
        synchronized (this.bUH) {
            if (this.bUI == null) {
                runNextTask();
            }
        }
    }

    private void runNextTask() {
        synchronized (this.bUH) {
            this.bUI = null;
            if (!this.bUH.isEmpty()) {
                this.bUI = this.bUH.poll();
                if (this.bUI == null) {
                    runNextTask();
                } else {
                    ai.l(this.bUI);
                }
            }
        }
    }

    public synchronized void clear() {
        if (this.bUI != null) {
            this.bUI.finish();
            this.bUI = null;
        }
        this.bUH.clear();
    }
}
