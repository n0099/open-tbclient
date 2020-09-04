package com.baidu.swan.games.network.b;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.searchbox.v8engine.event.JSEvent;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a dvi;
    private final Object mLock = new Object();
    private boolean dvg = true;
    private List<b> dvh = new ArrayList(3);

    public e(@NonNull a aVar) {
        this.dvi = aVar;
    }

    public void aOF() {
        synchronized (this.mLock) {
            this.dvg = false;
            aOG();
        }
    }

    public void onSuccess(Object obj) {
        synchronized (this.mLock) {
            if (this.dvg) {
                f(1, obj);
            } else {
                this.dvi.a(new b(1, obj));
            }
        }
    }

    public void i(String str, int i, String str2) {
        synchronized (this.mLock) {
            com.baidu.swan.games.network.c.b bVar = new com.baidu.swan.games.network.c.b();
            bVar.errMsg = str2;
            bVar.statusCode = i;
            bVar.url = str;
            if (this.dvg) {
                f(2, bVar);
            } else {
                this.dvi.a(new b(2, bVar));
            }
        }
    }

    public boolean b(JSEvent jSEvent) {
        synchronized (this.mLock) {
            if (this.dvg) {
                f(3, jSEvent);
            } else {
                this.dvi.a(new b(3, jSEvent));
            }
        }
        return true;
    }

    private void aOG() {
        for (b bVar : this.dvh) {
            this.dvi.a(bVar);
        }
        this.dvh.clear();
    }

    private void f(int i, Object obj) {
        if (obj != null) {
            if (DEBUG) {
                Log.d("SwanGameResponseCache", "addToCacheList type:" + i);
            }
            this.dvh.add(new b(i, obj));
        }
    }
}
