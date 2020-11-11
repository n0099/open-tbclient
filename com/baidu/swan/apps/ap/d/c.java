package com.baidu.swan.apps.ap.d;

import com.baidu.swan.apps.ap.ak;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes10.dex */
public class c implements b {
    private final Queue<a> dES = new ArrayDeque();
    private a dET;

    public void b(a aVar) {
        if (aVar != null) {
            synchronized (this.dES) {
                this.dES.offer(aVar.a(this));
            }
        }
        aNu();
    }

    @Override // com.baidu.swan.apps.ap.d.b
    public void a(a aVar) {
        synchronized (this.dES) {
            if (aVar == this.dET) {
                runNextTask();
            }
        }
    }

    private void aNu() {
        synchronized (this.dES) {
            if (this.dET == null) {
                runNextTask();
            }
        }
    }

    private void runNextTask() {
        synchronized (this.dES) {
            this.dET = null;
            if (!this.dES.isEmpty()) {
                this.dET = this.dES.poll();
                if (this.dET == null) {
                    runNextTask();
                } else {
                    ak.m(this.dET);
                }
            }
        }
    }

    public synchronized void clear() {
        if (this.dET != null) {
            this.dET.finish();
            this.dET = null;
        }
        this.dES.clear();
    }
}
