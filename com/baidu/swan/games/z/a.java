package com.baidu.swan.games.z;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes9.dex */
public class a {
    private static final ReentrantLock cor = new ReentrantLock();
    private static volatile a cos;
    private d chq;
    private List<c> cii = new ArrayList(3);

    private a() {
    }

    public static a anj() {
        if (cos == null) {
            synchronized (a.class) {
                if (cos == null) {
                    cos = new a();
                }
            }
        }
        return cos;
    }

    public void a(d dVar) {
        this.chq = dVar;
        ank();
    }

    public void O(String str, boolean z) {
        com.baidu.swan.apps.console.c.d("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
        c cVar = new c(str);
        cVar.hasUpdate = z;
        a(cVar);
    }

    public void release() {
        this.chq = null;
        this.cii.clear();
    }

    private void a(c cVar) {
        cor.lock();
        try {
            if (this.chq != null) {
                this.chq.c(cVar);
            } else {
                this.cii.add(cVar);
            }
        } finally {
            cor.unlock();
        }
    }

    private void ank() {
        if (!this.cii.isEmpty() && this.chq != null) {
            cor.lock();
            try {
                for (c cVar : this.cii) {
                    this.chq.c(cVar);
                }
                this.cii.clear();
            } finally {
                cor.unlock();
            }
        }
    }
}
