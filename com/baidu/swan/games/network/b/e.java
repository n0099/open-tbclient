package com.baidu.swan.games.network.b;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.searchbox.v8engine.event.JSEvent;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a dRH;
    private final Object mLock = new Object();
    private boolean dRF = true;
    private List<b> dRG = new ArrayList(3);

    public e(@NonNull a aVar) {
        this.dRH = aVar;
    }

    public void aTT() {
        synchronized (this.mLock) {
            this.dRF = false;
            aTU();
        }
    }

    public void onSuccess(Object obj) {
        synchronized (this.mLock) {
            if (this.dRF) {
                g(1, obj);
            } else {
                this.dRH.a(new b(1, obj));
            }
        }
    }

    public void k(String str, int i, String str2) {
        synchronized (this.mLock) {
            com.baidu.swan.games.network.c.b bVar = new com.baidu.swan.games.network.c.b();
            bVar.errMsg = str2;
            bVar.statusCode = i;
            bVar.url = str;
            if (this.dRF) {
                g(2, bVar);
            } else {
                this.dRH.a(new b(2, bVar));
            }
        }
    }

    public boolean b(JSEvent jSEvent) {
        synchronized (this.mLock) {
            if (this.dRF) {
                g(3, jSEvent);
            } else {
                this.dRH.a(new b(3, jSEvent));
            }
        }
        return true;
    }

    private void aTU() {
        for (b bVar : this.dRG) {
            this.dRH.a(bVar);
        }
        this.dRG.clear();
    }

    private void g(int i, Object obj) {
        if (obj != null) {
            if (DEBUG) {
                Log.d("SwanGameResponseCache", "addToCacheList type:" + i);
            }
            this.dRG.add(new b(i, obj));
        }
    }
}
