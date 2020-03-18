package com.baidu.swan.games.z;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes11.dex */
public class a {
    private static final ReentrantLock csS = new ReentrantLock();
    private static volatile a csT;
    private d clU;
    private List<c> cmM = new ArrayList(3);

    private a() {
    }

    public static a apV() {
        if (csT == null) {
            synchronized (a.class) {
                if (csT == null) {
                    csT = new a();
                }
            }
        }
        return csT;
    }

    public void a(d dVar) {
        this.clU = dVar;
        apW();
    }

    public void O(String str, boolean z) {
        com.baidu.swan.apps.console.c.d("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
        c cVar = new c(str);
        cVar.hasUpdate = z;
        a(cVar);
    }

    public void release() {
        this.clU = null;
        this.cmM.clear();
    }

    private void a(c cVar) {
        csS.lock();
        try {
            if (this.clU != null) {
                this.clU.c(cVar);
            } else {
                this.cmM.add(cVar);
            }
        } finally {
            csS.unlock();
        }
    }

    private void apW() {
        if (!this.cmM.isEmpty() && this.clU != null) {
            csS.lock();
            try {
                for (c cVar : this.cmM) {
                    this.clU.c(cVar);
                }
                this.cmM.clear();
            } finally {
                csS.unlock();
            }
        }
    }
}
