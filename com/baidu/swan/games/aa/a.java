package com.baidu.swan.games.aa;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes10.dex */
public class a {
    private static final ReentrantLock dZL = new ReentrantLock();
    private static volatile a dZM;
    private d dSL;
    private List<c> dTD = new ArrayList(3);

    private a() {
    }

    public static a aXq() {
        if (dZM == null) {
            synchronized (a.class) {
                if (dZM == null) {
                    dZM = new a();
                }
            }
        }
        return dZM;
    }

    public void a(d dVar) {
        this.dSL = dVar;
        aXr();
    }

    public void as(String str, boolean z) {
        com.baidu.swan.apps.console.c.i("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
        c cVar = new c(str);
        cVar.hasUpdate = z;
        a(cVar);
    }

    public void release() {
        this.dSL = null;
        this.dTD.clear();
    }

    private void a(c cVar) {
        dZL.lock();
        try {
            if (this.dSL != null) {
                this.dSL.c(cVar);
            } else {
                this.dTD.add(cVar);
            }
        } finally {
            dZL.unlock();
        }
    }

    private void aXr() {
        if (!this.dTD.isEmpty() && this.dSL != null) {
            dZL.lock();
            try {
                for (c cVar : this.dTD) {
                    this.dSL.c(cVar);
                }
                this.dTD.clear();
            } finally {
                dZL.unlock();
            }
        }
    }
}
