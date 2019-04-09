package com.baidu.swan.games.s;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes2.dex */
public class a {
    private static final ReentrantLock bfC = new ReentrantLock();
    private static volatile a bfD;
    private d baQ;
    private List<c> bbA = new ArrayList(3);

    private a() {
    }

    public static a Pg() {
        if (bfD == null) {
            synchronized (a.class) {
                if (bfD == null) {
                    bfD = new a();
                }
            }
        }
        return bfD;
    }

    public void a(d dVar) {
        this.baQ = dVar;
        Ph();
    }

    public void E(String str, boolean z) {
        com.baidu.swan.apps.console.c.d("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
        c cVar = new c(str);
        cVar.hasUpdate = z;
        a(cVar);
    }

    public void release() {
        this.baQ = null;
        this.bbA.clear();
    }

    private void a(c cVar) {
        bfC.lock();
        try {
            if (this.baQ != null) {
                this.baQ.c(cVar);
            } else {
                this.bbA.add(cVar);
            }
        } finally {
            bfC.unlock();
        }
    }

    private void Ph() {
        if (!this.bbA.isEmpty() && this.baQ != null) {
            bfC.lock();
            try {
                for (c cVar : this.bbA) {
                    this.baQ.c(cVar);
                }
                this.bbA.clear();
            } finally {
                bfC.unlock();
            }
        }
    }
}
