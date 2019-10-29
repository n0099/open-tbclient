package com.baidu.swan.games.u;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes2.dex */
public class a {
    private static final ReentrantLock bEO = new ReentrantLock();
    private static volatile a bEP;
    private d byP;
    private List<c> bzF = new ArrayList(3);

    private a() {
    }

    public static a Yn() {
        if (bEP == null) {
            synchronized (a.class) {
                if (bEP == null) {
                    bEP = new a();
                }
            }
        }
        return bEP;
    }

    public void a(d dVar) {
        this.byP = dVar;
        Yo();
    }

    public void J(String str, boolean z) {
        com.baidu.swan.apps.console.c.d("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
        c cVar = new c(str);
        cVar.hasUpdate = z;
        a(cVar);
    }

    public void release() {
        this.byP = null;
        this.bzF.clear();
    }

    private void a(c cVar) {
        bEO.lock();
        try {
            if (this.byP != null) {
                this.byP.c(cVar);
            } else {
                this.bzF.add(cVar);
            }
        } finally {
            bEO.unlock();
        }
    }

    private void Yo() {
        if (!this.bzF.isEmpty() && this.byP != null) {
            bEO.lock();
            try {
                for (c cVar : this.bzF) {
                    this.byP.c(cVar);
                }
                this.bzF.clear();
            } finally {
                bEO.unlock();
            }
        }
    }
}
