package com.baidu.swan.games.aa;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes10.dex */
public class a {
    private static final ReentrantLock dLw = new ReentrantLock();
    private static volatile a dLx;
    private d dEw;
    private List<c> dFo = new ArrayList(3);

    private a() {
    }

    public static a aSW() {
        if (dLx == null) {
            synchronized (a.class) {
                if (dLx == null) {
                    dLx = new a();
                }
            }
        }
        return dLx;
    }

    public void a(d dVar) {
        this.dEw = dVar;
        aSX();
    }

    public void aq(String str, boolean z) {
        com.baidu.swan.apps.console.c.i("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
        c cVar = new c(str);
        cVar.hasUpdate = z;
        a(cVar);
    }

    public void release() {
        this.dEw = null;
        this.dFo.clear();
    }

    private void a(c cVar) {
        dLw.lock();
        try {
            if (this.dEw != null) {
                this.dEw.c(cVar);
            } else {
                this.dFo.add(cVar);
            }
        } finally {
            dLw.unlock();
        }
    }

    private void aSX() {
        if (!this.dFo.isEmpty() && this.dEw != null) {
            dLw.lock();
            try {
                for (c cVar : this.dFo) {
                    this.dEw.c(cVar);
                }
                this.dFo.clear();
            } finally {
                dLw.unlock();
            }
        }
    }
}
