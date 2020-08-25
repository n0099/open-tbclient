package com.baidu.swan.apps.ap.d;

import com.baidu.swan.apps.ap.ak;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes8.dex */
public class c implements b {
    private final Queue<a> dcn = new ArrayDeque();
    private a dco;

    public void b(a aVar) {
        if (aVar != null) {
            synchronized (this.dcn) {
                this.dcn.offer(aVar.a(this));
            }
        }
        aFH();
    }

    @Override // com.baidu.swan.apps.ap.d.b
    public void a(a aVar) {
        synchronized (this.dcn) {
            if (aVar == this.dco) {
                runNextTask();
            }
        }
    }

    private void aFH() {
        synchronized (this.dcn) {
            if (this.dco == null) {
                runNextTask();
            }
        }
    }

    private void runNextTask() {
        synchronized (this.dcn) {
            this.dco = null;
            if (!this.dcn.isEmpty()) {
                this.dco = this.dcn.poll();
                if (this.dco == null) {
                    runNextTask();
                } else {
                    ak.m(this.dco);
                }
            }
        }
    }

    public synchronized void clear() {
        if (this.dco != null) {
            this.dco.finish();
            this.dco = null;
        }
        this.dcn.clear();
    }
}
