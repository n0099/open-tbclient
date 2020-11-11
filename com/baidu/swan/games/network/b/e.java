package com.baidu.swan.games.network.b;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.searchbox.v8engine.event.JSEvent;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a dXz;
    private final Object mLock = new Object();
    private boolean dXx = true;
    private List<b> dXy = new ArrayList(3);

    public e(@NonNull a aVar) {
        this.dXz = aVar;
    }

    public void aWt() {
        synchronized (this.mLock) {
            this.dXx = false;
            aWu();
        }
    }

    public void onSuccess(Object obj) {
        synchronized (this.mLock) {
            if (this.dXx) {
                f(1, obj);
            } else {
                this.dXz.a(new b(1, obj));
            }
        }
    }

    public void l(String str, int i, String str2) {
        synchronized (this.mLock) {
            com.baidu.swan.games.network.c.b bVar = new com.baidu.swan.games.network.c.b();
            bVar.errMsg = str2;
            bVar.statusCode = i;
            bVar.url = str;
            if (this.dXx) {
                f(2, bVar);
            } else {
                this.dXz.a(new b(2, bVar));
            }
        }
    }

    public boolean b(JSEvent jSEvent) {
        synchronized (this.mLock) {
            if (this.dXx) {
                f(3, jSEvent);
            } else {
                this.dXz.a(new b(3, jSEvent));
            }
        }
        return true;
    }

    private void aWu() {
        for (b bVar : this.dXy) {
            this.dXz.a(bVar);
        }
        this.dXy.clear();
    }

    private void f(int i, Object obj) {
        if (obj != null) {
            if (DEBUG) {
                Log.d("SwanGameResponseCache", "addToCacheList type:" + i);
            }
            this.dXy.add(new b(i, obj));
        }
    }
}
