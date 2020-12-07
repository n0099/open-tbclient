package com.baidu.swan.games.network.b;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.searchbox.v8engine.event.JSEvent;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes25.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a ecQ;
    private final Object mLock = new Object();
    private boolean ecO = true;
    private List<b> ecP = new ArrayList(3);

    public e(@NonNull a aVar) {
        this.ecQ = aVar;
    }

    public void aYQ() {
        synchronized (this.mLock) {
            this.ecO = false;
            aYR();
        }
    }

    public void onSuccess(Object obj) {
        synchronized (this.mLock) {
            if (this.ecO) {
                f(1, obj);
            } else {
                this.ecQ.a(new b(1, obj));
            }
        }
    }

    public void l(String str, int i, String str2) {
        synchronized (this.mLock) {
            com.baidu.swan.games.network.c.b bVar = new com.baidu.swan.games.network.c.b();
            bVar.errMsg = str2;
            bVar.statusCode = i;
            bVar.url = str;
            if (this.ecO) {
                f(2, bVar);
            } else {
                this.ecQ.a(new b(2, bVar));
            }
        }
    }

    public boolean b(JSEvent jSEvent) {
        synchronized (this.mLock) {
            if (this.ecO) {
                f(3, jSEvent);
            } else {
                this.ecQ.a(new b(3, jSEvent));
            }
        }
        return true;
    }

    private void aYR() {
        for (b bVar : this.ecP) {
            this.ecQ.a(bVar);
        }
        this.ecP.clear();
    }

    private void f(int i, Object obj) {
        if (obj != null) {
            if (DEBUG) {
                Log.d("SwanGameResponseCache", "addToCacheList type:" + i);
            }
            this.ecP.add(new b(i, obj));
        }
    }
}
