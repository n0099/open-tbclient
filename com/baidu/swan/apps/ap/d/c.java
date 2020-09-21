package com.baidu.swan.apps.ap.d;

import com.baidu.swan.apps.ap.ak;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes3.dex */
public class c implements b {
    private final Queue<a> deu = new ArrayDeque();
    private a dev;

    public void b(a aVar) {
        if (aVar != null) {
            synchronized (this.deu) {
                this.deu.offer(aVar.a(this));
            }
        }
        aGr();
    }

    @Override // com.baidu.swan.apps.ap.d.b
    public void a(a aVar) {
        synchronized (this.deu) {
            if (aVar == this.dev) {
                runNextTask();
            }
        }
    }

    private void aGr() {
        synchronized (this.deu) {
            if (this.dev == null) {
                runNextTask();
            }
        }
    }

    private void runNextTask() {
        synchronized (this.deu) {
            this.dev = null;
            if (!this.deu.isEmpty()) {
                this.dev = this.deu.poll();
                if (this.dev == null) {
                    runNextTask();
                } else {
                    ak.m(this.dev);
                }
            }
        }
    }

    public synchronized void clear() {
        if (this.dev != null) {
            this.dev.finish();
            this.dev = null;
        }
        this.deu.clear();
    }
}
