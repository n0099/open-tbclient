package com.baidu.swan.games.aa;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes9.dex */
public class a {
    private static final ReentrantLock elw = new ReentrantLock();
    private static volatile a elx;
    private d ees;
    private List<c> efk = new ArrayList(3);

    private a() {
    }

    public static a aYA() {
        if (elx == null) {
            synchronized (a.class) {
                if (elx == null) {
                    elx = new a();
                }
            }
        }
        return elx;
    }

    public void a(d dVar) {
        this.ees = dVar;
        aYB();
    }

    public void as(String str, boolean z) {
        com.baidu.swan.apps.console.c.i("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
        c cVar = new c(str);
        cVar.hasUpdate = z;
        a(cVar);
    }

    public void release() {
        this.ees = null;
        this.efk.clear();
    }

    private void a(c cVar) {
        elw.lock();
        try {
            if (this.ees != null) {
                this.ees.c(cVar);
            } else {
                this.efk.add(cVar);
            }
        } finally {
            elw.unlock();
        }
    }

    private void aYB() {
        if (!this.efk.isEmpty() && this.ees != null) {
            elw.lock();
            try {
                for (c cVar : this.efk) {
                    this.ees.c(cVar);
                }
                this.efk.clear();
            } finally {
                elw.unlock();
            }
        }
    }
}
