package com.baidu.swan.games.u;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes2.dex */
public class a {
    private static final ReentrantLock blD = new ReentrantLock();
    private static volatile a blE;
    private d bfy;
    private List<c> bgo = new ArrayList(3);

    private a() {
    }

    public static a Ts() {
        if (blE == null) {
            synchronized (a.class) {
                if (blE == null) {
                    blE = new a();
                }
            }
        }
        return blE;
    }

    public void a(d dVar) {
        this.bfy = dVar;
        Tt();
    }

    public void G(String str, boolean z) {
        com.baidu.swan.apps.console.c.d("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
        c cVar = new c(str);
        cVar.hasUpdate = z;
        a(cVar);
    }

    public void release() {
        this.bfy = null;
        this.bgo.clear();
    }

    private void a(c cVar) {
        blD.lock();
        try {
            if (this.bfy != null) {
                this.bfy.c(cVar);
            } else {
                this.bgo.add(cVar);
            }
        } finally {
            blD.unlock();
        }
    }

    private void Tt() {
        if (!this.bgo.isEmpty() && this.bfy != null) {
            blD.lock();
            try {
                for (c cVar : this.bgo) {
                    this.bfy.c(cVar);
                }
                this.bgo.clear();
            } finally {
                blD.unlock();
            }
        }
    }
}
