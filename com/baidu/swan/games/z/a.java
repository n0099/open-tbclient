package com.baidu.swan.games.z;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes11.dex */
public class a {
    private static final ReentrantLock cRN = new ReentrantLock();
    private static volatile a cRO;
    private d cKR;
    private List<c> cLI = new ArrayList(3);

    private a() {
    }

    public static a ayh() {
        if (cRO == null) {
            synchronized (a.class) {
                if (cRO == null) {
                    cRO = new a();
                }
            }
        }
        return cRO;
    }

    public void a(d dVar) {
        this.cKR = dVar;
        ayi();
    }

    public void T(String str, boolean z) {
        com.baidu.swan.apps.console.c.d("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
        c cVar = new c(str);
        cVar.hasUpdate = z;
        a(cVar);
    }

    public void release() {
        this.cKR = null;
        this.cLI.clear();
    }

    private void a(c cVar) {
        cRN.lock();
        try {
            if (this.cKR != null) {
                this.cKR.c(cVar);
            } else {
                this.cLI.add(cVar);
            }
        } finally {
            cRN.unlock();
        }
    }

    private void ayi() {
        if (!this.cLI.isEmpty() && this.cKR != null) {
            cRN.lock();
            try {
                for (c cVar : this.cLI) {
                    this.cKR.c(cVar);
                }
                this.cLI.clear();
            } finally {
                cRN.unlock();
            }
        }
    }
}
