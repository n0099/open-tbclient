package com.baidu.swan.apps.aq.d;

import com.baidu.swan.apps.aq.aj;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes11.dex */
public class c implements b {
    private final Queue<a> cLc = new ArrayDeque();
    private a cLd;

    public void b(a aVar) {
        if (aVar != null) {
            synchronized (this.cLc) {
                this.cLc.offer(aVar.a(this));
            }
        }
        auf();
    }

    @Override // com.baidu.swan.apps.aq.d.b
    public void a(a aVar) {
        synchronized (this.cLc) {
            if (aVar == this.cLd) {
                runNextTask();
            }
        }
    }

    private void auf() {
        synchronized (this.cLc) {
            if (this.cLd == null) {
                runNextTask();
            }
        }
    }

    private void runNextTask() {
        synchronized (this.cLc) {
            this.cLd = null;
            if (!this.cLc.isEmpty()) {
                this.cLd = this.cLc.poll();
                if (this.cLd == null) {
                    runNextTask();
                } else {
                    aj.p(this.cLd);
                }
            }
        }
    }

    public synchronized void clear() {
        if (this.cLd != null) {
            this.cLd.finish();
            this.cLd = null;
        }
        this.cLc.clear();
    }
}
