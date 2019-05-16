package com.baidu.swan.apps.an.c;

import com.baidu.swan.apps.an.ac;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes2.dex */
public class c implements b {
    private final Queue<a> baa = new ArrayDeque();
    private a bab;

    public void b(a aVar) {
        if (aVar != null) {
            synchronized (this.baa) {
                this.baa.offer(aVar.a(this));
            }
        }
        OZ();
    }

    @Override // com.baidu.swan.apps.an.c.b
    public void a(a aVar) {
        synchronized (this.baa) {
            if (aVar == this.bab) {
                Pa();
            }
        }
    }

    private void OZ() {
        synchronized (this.baa) {
            if (this.bab == null) {
                Pa();
            }
        }
    }

    private void Pa() {
        synchronized (this.baa) {
            this.bab = null;
            if (!this.baa.isEmpty()) {
                this.bab = this.baa.poll();
                if (this.bab == null) {
                    Pa();
                } else {
                    ac.k(this.bab);
                }
            }
        }
    }

    public synchronized void clear() {
        if (this.bab != null) {
            this.bab.finish();
            this.bab = null;
        }
        this.baa.clear();
    }
}
