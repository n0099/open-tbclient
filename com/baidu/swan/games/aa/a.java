package com.baidu.swan.games.aa;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes8.dex */
public class a {
    private static final ReentrantLock ejp = new ReentrantLock();
    private static volatile a ejq;
    private d ecl;
    private List<c> edd = new ArrayList(3);

    private a() {
    }

    public static a aYo() {
        if (ejq == null) {
            synchronized (a.class) {
                if (ejq == null) {
                    ejq = new a();
                }
            }
        }
        return ejq;
    }

    public void a(d dVar) {
        this.ecl = dVar;
        aYp();
    }

    public void at(String str, boolean z) {
        com.baidu.swan.apps.console.c.i("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
        c cVar = new c(str);
        cVar.hasUpdate = z;
        a(cVar);
    }

    public void release() {
        this.ecl = null;
        this.edd.clear();
    }

    private void a(c cVar) {
        ejp.lock();
        try {
            if (this.ecl != null) {
                this.ecl.c(cVar);
            } else {
                this.edd.add(cVar);
            }
        } finally {
            ejp.unlock();
        }
    }

    private void aYp() {
        if (!this.edd.isEmpty() && this.ecl != null) {
            ejp.lock();
            try {
                for (c cVar : this.edd) {
                    this.ecl.c(cVar);
                }
                this.edd.clear();
            } finally {
                ejp.unlock();
            }
        }
    }
}
