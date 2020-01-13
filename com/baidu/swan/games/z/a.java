package com.baidu.swan.games.z;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes10.dex */
public class a {
    private static final ReentrantLock coE = new ReentrantLock();
    private static volatile a coF;
    private d chD;
    private List<c> civ = new ArrayList(3);

    private a() {
    }

    public static a anC() {
        if (coF == null) {
            synchronized (a.class) {
                if (coF == null) {
                    coF = new a();
                }
            }
        }
        return coF;
    }

    public void a(d dVar) {
        this.chD = dVar;
        anD();
    }

    public void O(String str, boolean z) {
        com.baidu.swan.apps.console.c.d("SwanGameBundleUpdateManager", String.format("sendJSMessage : eventType = %s; hasUpdate = %s", str, Boolean.valueOf(z)));
        c cVar = new c(str);
        cVar.hasUpdate = z;
        a(cVar);
    }

    public void release() {
        this.chD = null;
        this.civ.clear();
    }

    private void a(c cVar) {
        coE.lock();
        try {
            if (this.chD != null) {
                this.chD.c(cVar);
            } else {
                this.civ.add(cVar);
            }
        } finally {
            coE.unlock();
        }
    }

    private void anD() {
        if (!this.civ.isEmpty() && this.chD != null) {
            coE.lock();
            try {
                for (c cVar : this.civ) {
                    this.chD.c(cVar);
                }
                this.civ.clear();
            } finally {
                coE.unlock();
            }
        }
    }
}
