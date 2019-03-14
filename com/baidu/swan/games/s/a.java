package com.baidu.swan.games.s;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes2.dex */
public class a {
    private static final ReentrantLock bfy = new ReentrantLock();
    private static volatile a bfz;
    private d baM;
    private List<c> bbw = new ArrayList(3);

    private a() {
    }

    public static a Pi() {
        if (bfz == null) {
            synchronized (a.class) {
                if (bfz == null) {
                    bfz = new a();
                }
            }
        }
        return bfz;
    }

    public void a(d dVar) {
        this.baM = dVar;
        Pj();
    }

    public void E(String str, boolean z) {
        com.baidu.swan.apps.console.c.d("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
        c cVar = new c(str);
        cVar.hasUpdate = z;
        a(cVar);
    }

    public void release() {
        this.baM = null;
        this.bbw.clear();
    }

    private void a(c cVar) {
        bfy.lock();
        try {
            if (this.baM != null) {
                this.baM.c(cVar);
            } else {
                this.bbw.add(cVar);
            }
        } finally {
            bfy.unlock();
        }
    }

    private void Pj() {
        if (!this.bbw.isEmpty() && this.baM != null) {
            bfy.lock();
            try {
                for (c cVar : this.bbw) {
                    this.baM.c(cVar);
                }
                this.bbw.clear();
            } finally {
                bfy.unlock();
            }
        }
    }
}
