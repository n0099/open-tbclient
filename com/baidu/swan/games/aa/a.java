package com.baidu.swan.games.aa;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes8.dex */
public class a {
    private static final ReentrantLock dxq = new ReentrantLock();
    private static volatile a dxr;
    private d dqn;
    private List<c> drf = new ArrayList(3);

    private a() {
    }

    public static a aPC() {
        if (dxr == null) {
            synchronized (a.class) {
                if (dxr == null) {
                    dxr = new a();
                }
            }
        }
        return dxr;
    }

    public void a(d dVar) {
        this.dqn = dVar;
        aPD();
    }

    public void am(String str, boolean z) {
        com.baidu.swan.apps.console.c.i("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
        c cVar = new c(str);
        cVar.hasUpdate = z;
        a(cVar);
    }

    public void release() {
        this.dqn = null;
        this.drf.clear();
    }

    private void a(c cVar) {
        dxq.lock();
        try {
            if (this.dqn != null) {
                this.dqn.c(cVar);
            } else {
                this.drf.add(cVar);
            }
        } finally {
            dxq.unlock();
        }
    }

    private void aPD() {
        if (!this.drf.isEmpty() && this.dqn != null) {
            dxq.lock();
            try {
                for (c cVar : this.drf) {
                    this.dqn.c(cVar);
                }
                this.drf.clear();
            } finally {
                dxq.unlock();
            }
        }
    }
}
