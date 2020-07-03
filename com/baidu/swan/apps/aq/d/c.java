package com.baidu.swan.apps.aq.d;

import com.baidu.swan.apps.aq.aj;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes11.dex */
public class c implements b {
    private final Queue<a> cPM = new ArrayDeque();
    private a cPN;

    public void b(a aVar) {
        if (aVar != null) {
            synchronized (this.cPM) {
                this.cPM.offer(aVar.a(this));
            }
        }
        avl();
    }

    @Override // com.baidu.swan.apps.aq.d.b
    public void a(a aVar) {
        synchronized (this.cPM) {
            if (aVar == this.cPN) {
                runNextTask();
            }
        }
    }

    private void avl() {
        synchronized (this.cPM) {
            if (this.cPN == null) {
                runNextTask();
            }
        }
    }

    private void runNextTask() {
        synchronized (this.cPM) {
            this.cPN = null;
            if (!this.cPM.isEmpty()) {
                this.cPN = this.cPM.poll();
                if (this.cPN == null) {
                    runNextTask();
                } else {
                    aj.p(this.cPN);
                }
            }
        }
    }

    public synchronized void clear() {
        if (this.cPN != null) {
            this.cPN.finish();
            this.cPN = null;
        }
        this.cPM.clear();
    }
}
