package com.baidu.swan.games.aa;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes7.dex */
public class a {
    private static final ReentrantLock dnl = new ReentrantLock();
    private static volatile a dnm;
    private List<c> dgW = new ArrayList(3);
    private d dge;

    private a() {
    }

    public static a aGL() {
        if (dnm == null) {
            synchronized (a.class) {
                if (dnm == null) {
                    dnm = new a();
                }
            }
        }
        return dnm;
    }

    public void a(d dVar) {
        this.dge = dVar;
        aGM();
    }

    public void ah(String str, boolean z) {
        com.baidu.swan.apps.console.c.i("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
        c cVar = new c(str);
        cVar.hasUpdate = z;
        a(cVar);
    }

    public void release() {
        this.dge = null;
        this.dgW.clear();
    }

    private void a(c cVar) {
        dnl.lock();
        try {
            if (this.dge != null) {
                this.dge.c(cVar);
            } else {
                this.dgW.add(cVar);
            }
        } finally {
            dnl.unlock();
        }
    }

    private void aGM() {
        if (!this.dgW.isEmpty() && this.dge != null) {
            dnl.lock();
            try {
                for (c cVar : this.dgW) {
                    this.dge.c(cVar);
                }
                this.dgW.clear();
            } finally {
                dnl.unlock();
            }
        }
    }
}
