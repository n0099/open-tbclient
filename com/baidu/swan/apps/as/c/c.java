package com.baidu.swan.apps.as.c;

import com.baidu.swan.apps.as.ai;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes11.dex */
public class c implements b {
    private final Queue<a> cyj = new ArrayDeque();
    private a cyk;

    public void b(a aVar) {
        if (aVar != null) {
            synchronized (this.cyj) {
                this.cyj.offer(aVar.a(this));
            }
        }
        apy();
    }

    @Override // com.baidu.swan.apps.as.c.b
    public void a(a aVar) {
        synchronized (this.cyj) {
            if (aVar == this.cyk) {
                runNextTask();
            }
        }
    }

    private void apy() {
        synchronized (this.cyj) {
            if (this.cyk == null) {
                runNextTask();
            }
        }
    }

    private void runNextTask() {
        synchronized (this.cyj) {
            this.cyk = null;
            if (!this.cyj.isEmpty()) {
                this.cyk = this.cyj.poll();
                if (this.cyk == null) {
                    runNextTask();
                } else {
                    ai.o(this.cyk);
                }
            }
        }
    }

    public synchronized void clear() {
        if (this.cyk != null) {
            this.cyk.finish();
            this.cyk = null;
        }
        this.cyj.clear();
    }
}
