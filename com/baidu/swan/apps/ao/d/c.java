package com.baidu.swan.apps.ao.d;

import com.baidu.swan.apps.ao.ak;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes8.dex */
public class c implements b {
    private final Queue<a> dRO = new ArrayDeque();
    private a dRP;

    public void b(a aVar) {
        if (aVar != null) {
            synchronized (this.dRO) {
                this.dRO.offer(aVar.a(this));
            }
        }
        aON();
    }

    @Override // com.baidu.swan.apps.ao.d.b
    public void a(a aVar) {
        synchronized (this.dRO) {
            if (aVar == this.dRP) {
                aOO();
            }
        }
    }

    private void aON() {
        synchronized (this.dRO) {
            if (this.dRP == null) {
                aOO();
            }
        }
    }

    private void aOO() {
        synchronized (this.dRO) {
            this.dRP = null;
            if (!this.dRO.isEmpty()) {
                this.dRP = this.dRO.poll();
                if (this.dRP == null) {
                    aOO();
                } else {
                    ak.j(this.dRP);
                }
            }
        }
    }

    public synchronized void clear() {
        if (this.dRP != null) {
            this.dRP.finish();
            this.dRP = null;
        }
        this.dRO.clear();
    }
}
