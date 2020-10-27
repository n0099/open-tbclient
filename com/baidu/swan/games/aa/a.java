package com.baidu.swan.games.aa;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes10.dex */
public class a {
    private static final ReentrantLock dTT = new ReentrantLock();
    private static volatile a dTU;
    private d dMT;
    private List<c> dNL = new ArrayList(3);

    private a() {
    }

    public static a aUQ() {
        if (dTU == null) {
            synchronized (a.class) {
                if (dTU == null) {
                    dTU = new a();
                }
            }
        }
        return dTU;
    }

    public void a(d dVar) {
        this.dMT = dVar;
        aUR();
    }

    public void as(String str, boolean z) {
        com.baidu.swan.apps.console.c.i("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
        c cVar = new c(str);
        cVar.hasUpdate = z;
        a(cVar);
    }

    public void release() {
        this.dMT = null;
        this.dNL.clear();
    }

    private void a(c cVar) {
        dTT.lock();
        try {
            if (this.dMT != null) {
                this.dMT.c(cVar);
            } else {
                this.dNL.add(cVar);
            }
        } finally {
            dTT.unlock();
        }
    }

    private void aUR() {
        if (!this.dNL.isEmpty() && this.dMT != null) {
            dTT.lock();
            try {
                for (c cVar : this.dNL) {
                    this.dMT.c(cVar);
                }
                this.dNL.clear();
            } finally {
                dTT.unlock();
            }
        }
    }
}
