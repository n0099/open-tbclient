package com.baidu.swan.games.aa;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes11.dex */
public class a {
    private static final ReentrantLock dhC = new ReentrantLock();
    private static volatile a dhD;
    private d dau;
    private List<c> dbn = new ArrayList(3);

    private a() {
    }

    public static a aDe() {
        if (dhD == null) {
            synchronized (a.class) {
                if (dhD == null) {
                    dhD = new a();
                }
            }
        }
        return dhD;
    }

    public void a(d dVar) {
        this.dau = dVar;
        aDf();
    }

    public void ai(String str, boolean z) {
        com.baidu.swan.apps.console.c.d("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
        c cVar = new c(str);
        cVar.hasUpdate = z;
        a(cVar);
    }

    public void release() {
        this.dau = null;
        this.dbn.clear();
    }

    private void a(c cVar) {
        dhC.lock();
        try {
            if (this.dau != null) {
                this.dau.c(cVar);
            } else {
                this.dbn.add(cVar);
            }
        } finally {
            dhC.unlock();
        }
    }

    private void aDf() {
        if (!this.dbn.isEmpty() && this.dau != null) {
            dhC.lock();
            try {
                for (c cVar : this.dbn) {
                    this.dau.c(cVar);
                }
                this.dbn.clear();
            } finally {
                dhC.unlock();
            }
        }
    }
}
