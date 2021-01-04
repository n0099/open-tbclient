package com.baidu.swan.games.aa;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes9.dex */
public class a {
    private static final ReentrantLock eod = new ReentrantLock();
    private static volatile a eoe;
    private d egY;
    private List<c> ehQ = new ArrayList(3);

    private a() {
    }

    public static a bch() {
        if (eoe == null) {
            synchronized (a.class) {
                if (eoe == null) {
                    eoe = new a();
                }
            }
        }
        return eoe;
    }

    public void a(d dVar) {
        this.egY = dVar;
        bci();
    }

    public void at(String str, boolean z) {
        com.baidu.swan.apps.console.c.i("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
        c cVar = new c(str);
        cVar.hasUpdate = z;
        a(cVar);
    }

    public void release() {
        this.egY = null;
        this.ehQ.clear();
    }

    private void a(c cVar) {
        eod.lock();
        try {
            if (this.egY != null) {
                this.egY.c(cVar);
            } else {
                this.ehQ.add(cVar);
            }
        } finally {
            eod.unlock();
        }
    }

    private void bci() {
        if (!this.ehQ.isEmpty() && this.egY != null) {
            eod.lock();
            try {
                for (c cVar : this.ehQ) {
                    this.egY.c(cVar);
                }
                this.ehQ.clear();
            } finally {
                eod.unlock();
            }
        }
    }
}
