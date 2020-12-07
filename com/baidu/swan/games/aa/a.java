package com.baidu.swan.games.aa;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes25.dex */
public class a {
    private static final ReentrantLock efc = new ReentrantLock();
    private static volatile a efd;
    private List<c> dYT = new ArrayList(3);
    private d dYb;

    private a() {
    }

    public static a aZN() {
        if (efd == null) {
            synchronized (a.class) {
                if (efd == null) {
                    efd = new a();
                }
            }
        }
        return efd;
    }

    public void a(d dVar) {
        this.dYb = dVar;
        aZO();
    }

    public void at(String str, boolean z) {
        com.baidu.swan.apps.console.c.i("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
        c cVar = new c(str);
        cVar.hasUpdate = z;
        a(cVar);
    }

    public void release() {
        this.dYb = null;
        this.dYT.clear();
    }

    private void a(c cVar) {
        efc.lock();
        try {
            if (this.dYb != null) {
                this.dYb.c(cVar);
            } else {
                this.dYT.add(cVar);
            }
        } finally {
            efc.unlock();
        }
    }

    private void aZO() {
        if (!this.dYT.isEmpty() && this.dYb != null) {
            efc.lock();
            try {
                for (c cVar : this.dYT) {
                    this.dYb.c(cVar);
                }
                this.dYT.clear();
            } finally {
                efc.unlock();
            }
        }
    }
}
