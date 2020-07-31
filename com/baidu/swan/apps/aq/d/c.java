package com.baidu.swan.apps.aq.d;

import com.baidu.swan.apps.aq.al;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes7.dex */
public class c implements b {
    private final Queue<a> cTn = new ArrayDeque();
    private a cTo;

    public void b(a aVar) {
        if (aVar != null) {
            synchronized (this.cTn) {
                this.cTn.offer(aVar.a(this));
            }
        }
        axz();
    }

    @Override // com.baidu.swan.apps.aq.d.b
    public void a(a aVar) {
        synchronized (this.cTn) {
            if (aVar == this.cTo) {
                runNextTask();
            }
        }
    }

    private void axz() {
        synchronized (this.cTn) {
            if (this.cTo == null) {
                runNextTask();
            }
        }
    }

    private void runNextTask() {
        synchronized (this.cTn) {
            this.cTo = null;
            if (!this.cTn.isEmpty()) {
                this.cTo = this.cTn.poll();
                if (this.cTo == null) {
                    runNextTask();
                } else {
                    al.p(this.cTo);
                }
            }
        }
    }

    public synchronized void clear() {
        if (this.cTo != null) {
            this.cTo.finish();
            this.cTo = null;
        }
        this.cTn.clear();
    }
}
