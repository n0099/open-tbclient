package com.baidu.swan.apps.ao.d;

import com.baidu.swan.apps.ao.ak;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes8.dex */
public class c implements b {
    private final Queue<a> dOh = new ArrayDeque();
    private a dOi;

    public void b(a aVar) {
        if (aVar != null) {
            synchronized (this.dOh) {
                this.dOh.offer(aVar.a(this));
            }
        }
        aOr();
    }

    @Override // com.baidu.swan.apps.ao.d.b
    public void a(a aVar) {
        synchronized (this.dOh) {
            if (aVar == this.dOi) {
                aOs();
            }
        }
    }

    private void aOr() {
        synchronized (this.dOh) {
            if (this.dOi == null) {
                aOs();
            }
        }
    }

    private void aOs() {
        synchronized (this.dOh) {
            this.dOi = null;
            if (!this.dOh.isEmpty()) {
                this.dOi = this.dOh.poll();
                if (this.dOi == null) {
                    aOs();
                } else {
                    ak.l(this.dOi);
                }
            }
        }
    }

    public synchronized void clear() {
        if (this.dOi != null) {
            this.dOi.finish();
            this.dOi = null;
        }
        this.dOh.clear();
    }
}
