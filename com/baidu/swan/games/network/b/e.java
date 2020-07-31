package com.baidu.swan.games.network.b;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.searchbox.v8engine.event.JSEvent;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a dkY;
    private final Object mLock = new Object();
    private boolean dkW = true;
    private List<b> dkX = new ArrayList(3);

    public e(@NonNull a aVar) {
        this.dkY = aVar;
    }

    public void aFO() {
        synchronized (this.mLock) {
            this.dkW = false;
            aFP();
        }
    }

    public void onSuccess(Object obj) {
        synchronized (this.mLock) {
            if (this.dkW) {
                f(1, obj);
            } else {
                this.dkY.a(new b(1, obj));
            }
        }
    }

    public void i(String str, int i, String str2) {
        synchronized (this.mLock) {
            com.baidu.swan.games.network.c.b bVar = new com.baidu.swan.games.network.c.b();
            bVar.errMsg = str2;
            bVar.statusCode = i;
            bVar.url = str;
            if (this.dkW) {
                f(2, bVar);
            } else {
                this.dkY.a(new b(2, bVar));
            }
        }
    }

    public boolean b(JSEvent jSEvent) {
        synchronized (this.mLock) {
            if (this.dkW) {
                f(3, jSEvent);
            } else {
                this.dkY.a(new b(3, jSEvent));
            }
        }
        return true;
    }

    private void aFP() {
        for (b bVar : this.dkX) {
            this.dkY.a(bVar);
        }
        this.dkX.clear();
    }

    private void f(int i, Object obj) {
        if (obj != null) {
            if (DEBUG) {
                Log.d("SwanGameResponseCache", "addToCacheList type:" + i);
            }
            this.dkX.add(new b(i, obj));
        }
    }
}
