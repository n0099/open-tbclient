package com.baidu.swan.games.u;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes2.dex */
public class a {
    private static final ReentrantLock bmb = new ReentrantLock();
    private static volatile a bmc;
    private d bfW;
    private List<c> bgN = new ArrayList(3);

    private a() {
    }

    public static a Tw() {
        if (bmc == null) {
            synchronized (a.class) {
                if (bmc == null) {
                    bmc = new a();
                }
            }
        }
        return bmc;
    }

    public void a(d dVar) {
        this.bfW = dVar;
        Tx();
    }

    public void G(String str, boolean z) {
        com.baidu.swan.apps.console.c.d("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
        c cVar = new c(str);
        cVar.hasUpdate = z;
        a(cVar);
    }

    public void release() {
        this.bfW = null;
        this.bgN.clear();
    }

    private void a(c cVar) {
        bmb.lock();
        try {
            if (this.bfW != null) {
                this.bfW.c(cVar);
            } else {
                this.bgN.add(cVar);
            }
        } finally {
            bmb.unlock();
        }
    }

    private void Tx() {
        if (!this.bgN.isEmpty() && this.bfW != null) {
            bmb.lock();
            try {
                for (c cVar : this.bgN) {
                    this.bfW.c(cVar);
                }
                this.bgN.clear();
            } finally {
                bmb.unlock();
            }
        }
    }
}
