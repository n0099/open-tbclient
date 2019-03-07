package com.baidu.swan.games.s;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes2.dex */
public class a {
    private static final ReentrantLock bfx = new ReentrantLock();
    private static volatile a bfy;
    private d baL;
    private List<c> bbv = new ArrayList(3);

    private a() {
    }

    public static a Pi() {
        if (bfy == null) {
            synchronized (a.class) {
                if (bfy == null) {
                    bfy = new a();
                }
            }
        }
        return bfy;
    }

    public void a(d dVar) {
        this.baL = dVar;
        Pj();
    }

    public void E(String str, boolean z) {
        com.baidu.swan.apps.console.c.d("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
        c cVar = new c(str);
        cVar.hasUpdate = z;
        a(cVar);
    }

    public void release() {
        this.baL = null;
        this.bbv.clear();
    }

    private void a(c cVar) {
        bfx.lock();
        try {
            if (this.baL != null) {
                this.baL.c(cVar);
            } else {
                this.bbv.add(cVar);
            }
        } finally {
            bfx.unlock();
        }
    }

    private void Pj() {
        if (!this.bbv.isEmpty() && this.baL != null) {
            bfx.lock();
            try {
                for (c cVar : this.bbv) {
                    this.baL.c(cVar);
                }
                this.bbv.clear();
            } finally {
                bfx.unlock();
            }
        }
    }
}
