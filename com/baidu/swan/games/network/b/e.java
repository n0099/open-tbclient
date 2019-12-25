package com.baidu.swan.games.network.b;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.searchbox.v8engine.event.JSEvent;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a cmf;
    private final Object mLock = new Object();
    private boolean cmc = true;
    private List<b> cme = new ArrayList(3);

    public e(@NonNull a aVar) {
        this.cmf = aVar;
    }

    public void amm() {
        synchronized (this.mLock) {
            this.cmc = false;
            amn();
        }
    }

    public void onSuccess(Object obj) {
        synchronized (this.mLock) {
            if (this.cmc) {
                f(1, obj);
            } else {
                this.cmf.a(new b(1, obj));
            }
        }
    }

    public void h(String str, int i, String str2) {
        synchronized (this.mLock) {
            com.baidu.swan.games.network.c.b bVar = new com.baidu.swan.games.network.c.b();
            bVar.errMsg = str2;
            bVar.statusCode = i;
            bVar.url = str;
            if (this.cmc) {
                f(2, bVar);
            } else {
                this.cmf.a(new b(2, bVar));
            }
        }
    }

    public boolean b(JSEvent jSEvent) {
        synchronized (this.mLock) {
            if (this.cmc) {
                f(3, jSEvent);
            } else {
                this.cmf.a(new b(3, jSEvent));
            }
        }
        return true;
    }

    private void amn() {
        for (b bVar : this.cme) {
            this.cmf.a(bVar);
        }
        this.cme.clear();
    }

    private void f(int i, Object obj) {
        if (obj != null) {
            if (DEBUG) {
                Log.d("SwanGameResponseCache", "addToCacheList type:" + i);
            }
            this.cme.add(new b(i, obj));
        }
    }
}
