package com.baidu.swan.games.network.b;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.searchbox.v8engine.event.JSEvent;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a cPI;
    private final Object mLock = new Object();
    private boolean cPG = true;
    private List<b> cPH = new ArrayList(3);

    public e(@NonNull a aVar) {
        this.cPI = aVar;
    }

    public void axk() {
        synchronized (this.mLock) {
            this.cPG = false;
            axl();
        }
    }

    public void onSuccess(Object obj) {
        synchronized (this.mLock) {
            if (this.cPG) {
                f(1, obj);
            } else {
                this.cPI.a(new b(1, obj));
            }
        }
    }

    public void i(String str, int i, String str2) {
        synchronized (this.mLock) {
            com.baidu.swan.games.network.c.b bVar = new com.baidu.swan.games.network.c.b();
            bVar.errMsg = str2;
            bVar.statusCode = i;
            bVar.url = str;
            if (this.cPG) {
                f(2, bVar);
            } else {
                this.cPI.a(new b(2, bVar));
            }
        }
    }

    public boolean b(JSEvent jSEvent) {
        synchronized (this.mLock) {
            if (this.cPG) {
                f(3, jSEvent);
            } else {
                this.cPI.a(new b(3, jSEvent));
            }
        }
        return true;
    }

    private void axl() {
        for (b bVar : this.cPH) {
            this.cPI.a(bVar);
        }
        this.cPH.clear();
    }

    private void f(int i, Object obj) {
        if (obj != null) {
            if (DEBUG) {
                Log.d("SwanGameResponseCache", "addToCacheList type:" + i);
            }
            this.cPH.add(new b(i, obj));
        }
    }
}
