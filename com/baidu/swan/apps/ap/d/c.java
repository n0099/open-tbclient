package com.baidu.swan.apps.ap.d;

import com.baidu.swan.apps.ap.ak;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes10.dex */
public class c implements b {
    private final Queue<a> dza = new ArrayDeque();
    private a dzb;

    public void b(a aVar) {
        if (aVar != null) {
            synchronized (this.dza) {
                this.dza.offer(aVar.a(this));
            }
        }
        aKU();
    }

    @Override // com.baidu.swan.apps.ap.d.b
    public void a(a aVar) {
        synchronized (this.dza) {
            if (aVar == this.dzb) {
                runNextTask();
            }
        }
    }

    private void aKU() {
        synchronized (this.dza) {
            if (this.dzb == null) {
                runNextTask();
            }
        }
    }

    private void runNextTask() {
        synchronized (this.dza) {
            this.dzb = null;
            if (!this.dza.isEmpty()) {
                this.dzb = this.dza.poll();
                if (this.dzb == null) {
                    runNextTask();
                } else {
                    ak.m(this.dzb);
                }
            }
        }
    }

    public synchronized void clear() {
        if (this.dzb != null) {
            this.dzb.finish();
            this.dzb = null;
        }
        this.dza.clear();
    }
}
