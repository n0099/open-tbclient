package com.baidu.swan.apps.ao.d;

import com.baidu.swan.apps.ao.ak;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes9.dex */
public class c implements b {
    private final Queue<a> dQn = new ArrayDeque();
    private a dQo;

    public void b(a aVar) {
        if (aVar != null) {
            synchronized (this.dQn) {
                this.dQn.offer(aVar.a(this));
            }
        }
        aOK();
    }

    @Override // com.baidu.swan.apps.ao.d.b
    public void a(a aVar) {
        synchronized (this.dQn) {
            if (aVar == this.dQo) {
                aOL();
            }
        }
    }

    private void aOK() {
        synchronized (this.dQn) {
            if (this.dQo == null) {
                aOL();
            }
        }
    }

    private void aOL() {
        synchronized (this.dQn) {
            this.dQo = null;
            if (!this.dQn.isEmpty()) {
                this.dQo = this.dQn.poll();
                if (this.dQo == null) {
                    aOL();
                } else {
                    ak.k(this.dQo);
                }
            }
        }
    }

    public synchronized void clear() {
        if (this.dQo != null) {
            this.dQo.finish();
            this.dQo = null;
        }
        this.dQn.clear();
    }
}
