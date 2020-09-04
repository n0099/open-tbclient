package com.baidu.swan.games.aa;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes8.dex */
public class a {
    private static final ReentrantLock dxu = new ReentrantLock();
    private static volatile a dxv;
    private d dqr;
    private List<c> drj = new ArrayList(3);

    private a() {
    }

    public static a aPC() {
        if (dxv == null) {
            synchronized (a.class) {
                if (dxv == null) {
                    dxv = new a();
                }
            }
        }
        return dxv;
    }

    public void a(d dVar) {
        this.dqr = dVar;
        aPD();
    }

    public void am(String str, boolean z) {
        com.baidu.swan.apps.console.c.i("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
        c cVar = new c(str);
        cVar.hasUpdate = z;
        a(cVar);
    }

    public void release() {
        this.dqr = null;
        this.drj.clear();
    }

    private void a(c cVar) {
        dxu.lock();
        try {
            if (this.dqr != null) {
                this.dqr.c(cVar);
            } else {
                this.drj.add(cVar);
            }
        } finally {
            dxu.unlock();
        }
    }

    private void aPD() {
        if (!this.drj.isEmpty() && this.dqr != null) {
            dxu.lock();
            try {
                for (c cVar : this.drj) {
                    this.dqr.c(cVar);
                }
                this.drj.clear();
            } finally {
                dxu.unlock();
            }
        }
    }
}
