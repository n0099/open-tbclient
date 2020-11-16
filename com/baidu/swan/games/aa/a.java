package com.baidu.swan.games.aa;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes7.dex */
public class a {
    private static final ReentrantLock dYd = new ReentrantLock();
    private static volatile a dYe;
    private List<c> dRV = new ArrayList(3);
    private d dRd;

    private a() {
    }

    public static a aWI() {
        if (dYe == null) {
            synchronized (a.class) {
                if (dYe == null) {
                    dYe = new a();
                }
            }
        }
        return dYe;
    }

    public void a(d dVar) {
        this.dRd = dVar;
        aWJ();
    }

    public void as(String str, boolean z) {
        com.baidu.swan.apps.console.c.i("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
        c cVar = new c(str);
        cVar.hasUpdate = z;
        a(cVar);
    }

    public void release() {
        this.dRd = null;
        this.dRV.clear();
    }

    private void a(c cVar) {
        dYd.lock();
        try {
            if (this.dRd != null) {
                this.dRd.c(cVar);
            } else {
                this.dRV.add(cVar);
            }
        } finally {
            dYd.unlock();
        }
    }

    private void aWJ() {
        if (!this.dRV.isEmpty() && this.dRd != null) {
            dYd.lock();
            try {
                for (c cVar : this.dRV) {
                    this.dRd.c(cVar);
                }
                this.dRV.clear();
            } finally {
                dYd.unlock();
            }
        }
    }
}
