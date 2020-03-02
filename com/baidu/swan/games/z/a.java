package com.baidu.swan.games.z;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes11.dex */
public class a {
    private static final ReentrantLock csG = new ReentrantLock();
    private static volatile a csH;
    private d clI;
    private List<c> cmA = new ArrayList(3);

    private a() {
    }

    public static a apS() {
        if (csH == null) {
            synchronized (a.class) {
                if (csH == null) {
                    csH = new a();
                }
            }
        }
        return csH;
    }

    public void a(d dVar) {
        this.clI = dVar;
        apT();
    }

    public void O(String str, boolean z) {
        com.baidu.swan.apps.console.c.d("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
        c cVar = new c(str);
        cVar.hasUpdate = z;
        a(cVar);
    }

    public void release() {
        this.clI = null;
        this.cmA.clear();
    }

    private void a(c cVar) {
        csG.lock();
        try {
            if (this.clI != null) {
                this.clI.c(cVar);
            } else {
                this.cmA.add(cVar);
            }
        } finally {
            csG.unlock();
        }
    }

    private void apT() {
        if (!this.cmA.isEmpty() && this.clI != null) {
            csG.lock();
            try {
                for (c cVar : this.cmA) {
                    this.clI.c(cVar);
                }
                this.cmA.clear();
            } finally {
                csG.unlock();
            }
        }
    }
}
