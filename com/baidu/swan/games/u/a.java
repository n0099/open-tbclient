package com.baidu.swan.games.u;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes2.dex */
public class a {
    private static final ReentrantLock bDX = new ReentrantLock();
    private static volatile a bDY;
    private d bxY;
    private List<c> byO = new ArrayList(3);

    private a() {
    }

    public static a Yl() {
        if (bDY == null) {
            synchronized (a.class) {
                if (bDY == null) {
                    bDY = new a();
                }
            }
        }
        return bDY;
    }

    public void a(d dVar) {
        this.bxY = dVar;
        Ym();
    }

    public void J(String str, boolean z) {
        com.baidu.swan.apps.console.c.d("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
        c cVar = new c(str);
        cVar.hasUpdate = z;
        a(cVar);
    }

    public void release() {
        this.bxY = null;
        this.byO.clear();
    }

    private void a(c cVar) {
        bDX.lock();
        try {
            if (this.bxY != null) {
                this.bxY.c(cVar);
            } else {
                this.byO.add(cVar);
            }
        } finally {
            bDX.unlock();
        }
    }

    private void Ym() {
        if (!this.byO.isEmpty() && this.bxY != null) {
            bDX.lock();
            try {
                for (c cVar : this.byO) {
                    this.bxY.c(cVar);
                }
                this.byO.clear();
            } finally {
                bDX.unlock();
            }
        }
    }
}
