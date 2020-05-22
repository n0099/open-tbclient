package com.baidu.swan.games.aa;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes11.dex */
public class a {
    private static final ReentrantLock dcQ = new ReentrantLock();
    private static volatile a dcR;
    private d cVJ;
    private List<c> cWB = new ArrayList(3);

    private a() {
    }

    public static a aBY() {
        if (dcR == null) {
            synchronized (a.class) {
                if (dcR == null) {
                    dcR = new a();
                }
            }
        }
        return dcR;
    }

    public void a(d dVar) {
        this.cVJ = dVar;
        aBZ();
    }

    public void ag(String str, boolean z) {
        com.baidu.swan.apps.console.c.d("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
        c cVar = new c(str);
        cVar.hasUpdate = z;
        a(cVar);
    }

    public void release() {
        this.cVJ = null;
        this.cWB.clear();
    }

    private void a(c cVar) {
        dcQ.lock();
        try {
            if (this.cVJ != null) {
                this.cVJ.c(cVar);
            } else {
                this.cWB.add(cVar);
            }
        } finally {
            dcQ.unlock();
        }
    }

    private void aBZ() {
        if (!this.cWB.isEmpty() && this.cVJ != null) {
            dcQ.lock();
            try {
                for (c cVar : this.cWB) {
                    this.cVJ.c(cVar);
                }
                this.cWB.clear();
            } finally {
                dcQ.unlock();
            }
        }
    }
}
