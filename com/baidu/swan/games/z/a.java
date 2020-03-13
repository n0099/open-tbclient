package com.baidu.swan.games.z;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes11.dex */
public class a {
    private static final ReentrantLock csH = new ReentrantLock();
    private static volatile a csI;
    private d clJ;
    private List<c> cmB = new ArrayList(3);

    private a() {
    }

    public static a apS() {
        if (csI == null) {
            synchronized (a.class) {
                if (csI == null) {
                    csI = new a();
                }
            }
        }
        return csI;
    }

    public void a(d dVar) {
        this.clJ = dVar;
        apT();
    }

    public void O(String str, boolean z) {
        com.baidu.swan.apps.console.c.d("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
        c cVar = new c(str);
        cVar.hasUpdate = z;
        a(cVar);
    }

    public void release() {
        this.clJ = null;
        this.cmB.clear();
    }

    private void a(c cVar) {
        csH.lock();
        try {
            if (this.clJ != null) {
                this.clJ.c(cVar);
            } else {
                this.cmB.add(cVar);
            }
        } finally {
            csH.unlock();
        }
    }

    private void apT() {
        if (!this.cmB.isEmpty() && this.clJ != null) {
            csH.lock();
            try {
                for (c cVar : this.cmB) {
                    this.clJ.c(cVar);
                }
                this.cmB.clear();
            } finally {
                csH.unlock();
            }
        }
    }
}
