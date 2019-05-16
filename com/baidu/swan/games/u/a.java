package com.baidu.swan.games.u;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes2.dex */
public class a {
    private static final ReentrantLock bkQ = new ReentrantLock();
    private static volatile a bkR;
    private d beL;
    private List<c> bfC = new ArrayList(3);

    private a() {
    }

    public static a Sz() {
        if (bkR == null) {
            synchronized (a.class) {
                if (bkR == null) {
                    bkR = new a();
                }
            }
        }
        return bkR;
    }

    public void a(d dVar) {
        this.beL = dVar;
        SA();
    }

    public void F(String str, boolean z) {
        com.baidu.swan.apps.console.c.d("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
        c cVar = new c(str);
        cVar.hasUpdate = z;
        a(cVar);
    }

    public void release() {
        this.beL = null;
        this.bfC.clear();
    }

    private void a(c cVar) {
        bkQ.lock();
        try {
            if (this.beL != null) {
                this.beL.c(cVar);
            } else {
                this.bfC.add(cVar);
            }
        } finally {
            bkQ.unlock();
        }
    }

    private void SA() {
        if (!this.bfC.isEmpty() && this.beL != null) {
            bkQ.lock();
            try {
                for (c cVar : this.bfC) {
                    this.beL.c(cVar);
                }
                this.bfC.clear();
            } finally {
                bkQ.unlock();
            }
        }
    }
}
