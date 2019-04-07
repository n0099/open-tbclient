package com.baidu.swan.games.s;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes2.dex */
public class a {
    private static final ReentrantLock bfB = new ReentrantLock();
    private static volatile a bfC;
    private d baP;
    private List<c> bbz = new ArrayList(3);

    private a() {
    }

    public static a Pg() {
        if (bfC == null) {
            synchronized (a.class) {
                if (bfC == null) {
                    bfC = new a();
                }
            }
        }
        return bfC;
    }

    public void a(d dVar) {
        this.baP = dVar;
        Ph();
    }

    public void E(String str, boolean z) {
        com.baidu.swan.apps.console.c.d("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
        c cVar = new c(str);
        cVar.hasUpdate = z;
        a(cVar);
    }

    public void release() {
        this.baP = null;
        this.bbz.clear();
    }

    private void a(c cVar) {
        bfB.lock();
        try {
            if (this.baP != null) {
                this.baP.c(cVar);
            } else {
                this.bbz.add(cVar);
            }
        } finally {
            bfB.unlock();
        }
    }

    private void Ph() {
        if (!this.bbz.isEmpty() && this.baP != null) {
            bfB.lock();
            try {
                for (c cVar : this.bbz) {
                    this.baP.c(cVar);
                }
                this.bbz.clear();
            } finally {
                bfB.unlock();
            }
        }
    }
}
