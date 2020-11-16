package com.baidu.swan.apps.ap.d;

import com.baidu.swan.apps.ap.ak;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes7.dex */
public class c implements b {
    private final Queue<a> dDl = new ArrayDeque();
    private a dDm;

    public void b(a aVar) {
        if (aVar != null) {
            synchronized (this.dDl) {
                this.dDl.offer(aVar.a(this));
            }
        }
        aMM();
    }

    @Override // com.baidu.swan.apps.ap.d.b
    public void a(a aVar) {
        synchronized (this.dDl) {
            if (aVar == this.dDm) {
                runNextTask();
            }
        }
    }

    private void aMM() {
        synchronized (this.dDl) {
            if (this.dDm == null) {
                runNextTask();
            }
        }
    }

    private void runNextTask() {
        synchronized (this.dDl) {
            this.dDm = null;
            if (!this.dDl.isEmpty()) {
                this.dDm = this.dDl.poll();
                if (this.dDm == null) {
                    runNextTask();
                } else {
                    ak.m(this.dDm);
                }
            }
        }
    }

    public synchronized void clear() {
        if (this.dDm != null) {
            this.dDm.finish();
            this.dDm = null;
        }
        this.dDl.clear();
    }
}
