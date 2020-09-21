package com.baidu.swan.games.aa;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes3.dex */
public class a {
    private static final ReentrantLock dzv = new ReentrantLock();
    private static volatile a dzw;
    private d dsu;
    private List<c> dtm = new ArrayList(3);

    private a() {
    }

    public static a aQn() {
        if (dzw == null) {
            synchronized (a.class) {
                if (dzw == null) {
                    dzw = new a();
                }
            }
        }
        return dzw;
    }

    public void a(d dVar) {
        this.dsu = dVar;
        aQo();
    }

    public void am(String str, boolean z) {
        com.baidu.swan.apps.console.c.i("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
        c cVar = new c(str);
        cVar.hasUpdate = z;
        a(cVar);
    }

    public void release() {
        this.dsu = null;
        this.dtm.clear();
    }

    private void a(c cVar) {
        dzv.lock();
        try {
            if (this.dsu != null) {
                this.dsu.c(cVar);
            } else {
                this.dtm.add(cVar);
            }
        } finally {
            dzv.unlock();
        }
    }

    private void aQo() {
        if (!this.dtm.isEmpty() && this.dsu != null) {
            dzv.lock();
            try {
                for (c cVar : this.dtm) {
                    this.dsu.c(cVar);
                }
                this.dtm.clear();
            } finally {
                dzv.unlock();
            }
        }
    }
}
