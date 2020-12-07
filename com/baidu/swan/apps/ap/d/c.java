package com.baidu.swan.apps.ap.d;

import com.baidu.swan.apps.ap.ak;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes25.dex */
public class c implements b {
    private final Queue<a> dKj = new ArrayDeque();
    private a dKk;

    public void b(a aVar) {
        if (aVar != null) {
            synchronized (this.dKj) {
                this.dKj.offer(aVar.a(this));
            }
        }
        aPS();
    }

    @Override // com.baidu.swan.apps.ap.d.b
    public void a(a aVar) {
        synchronized (this.dKj) {
            if (aVar == this.dKk) {
                runNextTask();
            }
        }
    }

    private void aPS() {
        synchronized (this.dKj) {
            if (this.dKk == null) {
                runNextTask();
            }
        }
    }

    private void runNextTask() {
        synchronized (this.dKj) {
            this.dKk = null;
            if (!this.dKj.isEmpty()) {
                this.dKk = this.dKj.poll();
                if (this.dKk == null) {
                    runNextTask();
                } else {
                    ak.m(this.dKk);
                }
            }
        }
    }

    public synchronized void clear() {
        if (this.dKk != null) {
            this.dKk.finish();
            this.dKk = null;
        }
        this.dKj.clear();
    }
}
