package com.baidu.swan.games.z;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes11.dex */
public class a {
    private static final ReentrantLock cRS = new ReentrantLock();
    private static volatile a cRT;
    private d cKX;
    private List<c> cLO = new ArrayList(3);

    private a() {
    }

    public static a ayh() {
        if (cRT == null) {
            synchronized (a.class) {
                if (cRT == null) {
                    cRT = new a();
                }
            }
        }
        return cRT;
    }

    public void a(d dVar) {
        this.cKX = dVar;
        ayi();
    }

    public void T(String str, boolean z) {
        com.baidu.swan.apps.console.c.d("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
        c cVar = new c(str);
        cVar.hasUpdate = z;
        a(cVar);
    }

    public void release() {
        this.cKX = null;
        this.cLO.clear();
    }

    private void a(c cVar) {
        cRS.lock();
        try {
            if (this.cKX != null) {
                this.cKX.c(cVar);
            } else {
                this.cLO.add(cVar);
            }
        } finally {
            cRS.unlock();
        }
    }

    private void ayi() {
        if (!this.cLO.isEmpty() && this.cKX != null) {
            cRS.lock();
            try {
                for (c cVar : this.cLO) {
                    this.cKX.c(cVar);
                }
                this.cLO.clear();
            } finally {
                cRS.unlock();
            }
        }
    }
}
