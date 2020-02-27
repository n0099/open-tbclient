package com.baidu.swan.games.z;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes11.dex */
public class a {
    private static final ReentrantLock csF = new ReentrantLock();
    private static volatile a csG;
    private d clH;
    private List<c> cmz = new ArrayList(3);

    private a() {
    }

    public static a apQ() {
        if (csG == null) {
            synchronized (a.class) {
                if (csG == null) {
                    csG = new a();
                }
            }
        }
        return csG;
    }

    public void a(d dVar) {
        this.clH = dVar;
        apR();
    }

    public void O(String str, boolean z) {
        com.baidu.swan.apps.console.c.d("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
        c cVar = new c(str);
        cVar.hasUpdate = z;
        a(cVar);
    }

    public void release() {
        this.clH = null;
        this.cmz.clear();
    }

    private void a(c cVar) {
        csF.lock();
        try {
            if (this.clH != null) {
                this.clH.c(cVar);
            } else {
                this.cmz.add(cVar);
            }
        } finally {
            csF.unlock();
        }
    }

    private void apR() {
        if (!this.cmz.isEmpty() && this.clH != null) {
            csF.lock();
            try {
                for (c cVar : this.cmz) {
                    this.clH.c(cVar);
                }
                this.cmz.clear();
            } finally {
                csF.unlock();
            }
        }
    }
}
