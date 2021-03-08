package com.baidu.swan.games.aa;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes8.dex */
public class a {
    private static final ReentrantLock emX = new ReentrantLock();
    private static volatile a emY;
    private d efT;
    private List<c> egM = new ArrayList(3);

    private a() {
    }

    public static a aYD() {
        if (emY == null) {
            synchronized (a.class) {
                if (emY == null) {
                    emY = new a();
                }
            }
        }
        return emY;
    }

    public void a(d dVar) {
        this.efT = dVar;
        aYE();
    }

    public void as(String str, boolean z) {
        com.baidu.swan.apps.console.c.i("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
        c cVar = new c(str);
        cVar.hasUpdate = z;
        a(cVar);
    }

    public void release() {
        this.efT = null;
        this.egM.clear();
    }

    private void a(c cVar) {
        emX.lock();
        try {
            if (this.efT != null) {
                this.efT.c(cVar);
            } else {
                this.egM.add(cVar);
            }
        } finally {
            emX.unlock();
        }
    }

    private void aYE() {
        if (!this.egM.isEmpty() && this.efT != null) {
            emX.lock();
            try {
                for (c cVar : this.egM) {
                    this.efT.c(cVar);
                }
                this.egM.clear();
            } finally {
                emX.unlock();
            }
        }
    }
}
