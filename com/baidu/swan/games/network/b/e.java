package com.baidu.swan.games.network.b;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.searchbox.v8engine.event.JSEvent;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a dve;
    private final Object mLock = new Object();
    private boolean dvc = true;
    private List<b> dvd = new ArrayList(3);

    public e(@NonNull a aVar) {
        this.dve = aVar;
    }

    public void aOF() {
        synchronized (this.mLock) {
            this.dvc = false;
            aOG();
        }
    }

    public void onSuccess(Object obj) {
        synchronized (this.mLock) {
            if (this.dvc) {
                f(1, obj);
            } else {
                this.dve.a(new b(1, obj));
            }
        }
    }

    public void i(String str, int i, String str2) {
        synchronized (this.mLock) {
            com.baidu.swan.games.network.c.b bVar = new com.baidu.swan.games.network.c.b();
            bVar.errMsg = str2;
            bVar.statusCode = i;
            bVar.url = str;
            if (this.dvc) {
                f(2, bVar);
            } else {
                this.dve.a(new b(2, bVar));
            }
        }
    }

    public boolean b(JSEvent jSEvent) {
        synchronized (this.mLock) {
            if (this.dvc) {
                f(3, jSEvent);
            } else {
                this.dve.a(new b(3, jSEvent));
            }
        }
        return true;
    }

    private void aOG() {
        for (b bVar : this.dvd) {
            this.dve.a(bVar);
        }
        this.dvd.clear();
    }

    private void f(int i, Object obj) {
        if (obj != null) {
            if (DEBUG) {
                Log.d("SwanGameResponseCache", "addToCacheList type:" + i);
            }
            this.dvd.add(new b(i, obj));
        }
    }
}
