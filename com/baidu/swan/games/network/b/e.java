package com.baidu.swan.games.network.b;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.searchbox.v8engine.event.JSEvent;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a dJk;
    private final Object mLock = new Object();
    private boolean dJi = true;
    private List<b> dJj = new ArrayList(3);

    public e(@NonNull a aVar) {
        this.dJk = aVar;
    }

    public void aRZ() {
        synchronized (this.mLock) {
            this.dJi = false;
            aSa();
        }
    }

    public void onSuccess(Object obj) {
        synchronized (this.mLock) {
            if (this.dJi) {
                g(1, obj);
            } else {
                this.dJk.a(new b(1, obj));
            }
        }
    }

    public void k(String str, int i, String str2) {
        synchronized (this.mLock) {
            com.baidu.swan.games.network.c.b bVar = new com.baidu.swan.games.network.c.b();
            bVar.errMsg = str2;
            bVar.statusCode = i;
            bVar.url = str;
            if (this.dJi) {
                g(2, bVar);
            } else {
                this.dJk.a(new b(2, bVar));
            }
        }
    }

    public boolean b(JSEvent jSEvent) {
        synchronized (this.mLock) {
            if (this.dJi) {
                g(3, jSEvent);
            } else {
                this.dJk.a(new b(3, jSEvent));
            }
        }
        return true;
    }

    private void aSa() {
        for (b bVar : this.dJj) {
            this.dJk.a(bVar);
        }
        this.dJj.clear();
    }

    private void g(int i, Object obj) {
        if (obj != null) {
            if (DEBUG) {
                Log.d("SwanGameResponseCache", "addToCacheList type:" + i);
            }
            this.dJj.add(new b(i, obj));
        }
    }
}
