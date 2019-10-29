package com.baidu.swan.apps.an.c;

import com.baidu.swan.apps.an.ac;
import java.util.ArrayDeque;
import java.util.Queue;
/* loaded from: classes2.dex */
public class c implements b {
    private final Queue<a> bui = new ArrayDeque();
    private a buj;

    public void b(a aVar) {
        if (aVar != null) {
            synchronized (this.bui) {
                this.bui.offer(aVar.a(this));
            }
        }
        UK();
    }

    @Override // com.baidu.swan.apps.an.c.b
    public void a(a aVar) {
        synchronized (this.bui) {
            if (aVar == this.buj) {
                UL();
            }
        }
    }

    private void UK() {
        synchronized (this.bui) {
            if (this.buj == null) {
                UL();
            }
        }
    }

    private void UL() {
        synchronized (this.bui) {
            this.buj = null;
            if (!this.bui.isEmpty()) {
                this.buj = this.bui.poll();
                if (this.buj == null) {
                    UL();
                } else {
                    ac.i(this.buj);
                }
            }
        }
    }

    public synchronized void clear() {
        if (this.buj != null) {
            this.buj.finish();
            this.buj = null;
        }
        this.bui.clear();
    }
}
