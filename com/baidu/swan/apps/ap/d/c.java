package com.baidu.swan.apps.ap.d;

import com.baidu.swan.apps.ap.ak;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes8.dex */
public class c implements b {
    private final Queue<a> dcr = new ArrayDeque();
    private a dcs;

    public void b(a aVar) {
        if (aVar != null) {
            synchronized (this.dcr) {
                this.dcr.offer(aVar.a(this));
            }
        }
        aFH();
    }

    @Override // com.baidu.swan.apps.ap.d.b
    public void a(a aVar) {
        synchronized (this.dcr) {
            if (aVar == this.dcs) {
                runNextTask();
            }
        }
    }

    private void aFH() {
        synchronized (this.dcr) {
            if (this.dcs == null) {
                runNextTask();
            }
        }
    }

    private void runNextTask() {
        synchronized (this.dcr) {
            this.dcs = null;
            if (!this.dcr.isEmpty()) {
                this.dcs = this.dcr.poll();
                if (this.dcs == null) {
                    runNextTask();
                } else {
                    ak.m(this.dcs);
                }
            }
        }
    }

    public synchronized void clear() {
        if (this.dcs != null) {
            this.dcs.finish();
            this.dcs = null;
        }
        this.dcr.clear();
    }
}
