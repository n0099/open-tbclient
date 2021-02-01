package com.baidu.swan.games.network.b;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.event.JSEvent;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a eji;
    private final Object mLock = new Object();
    private boolean ejg = true;
    private List<b> ejh = new ArrayList(3);

    public e(@NonNull a aVar) {
        this.eji = aVar;
    }

    public void aXD() {
        synchronized (this.mLock) {
            this.ejg = false;
            aXE();
        }
    }

    public void onSuccess(Object obj) {
        synchronized (this.mLock) {
            if (this.ejg) {
                f(1, obj);
            } else {
                this.eji.a(new b(1, obj));
            }
        }
    }

    public void onError(String str, int i, String str2) {
        synchronized (this.mLock) {
            com.baidu.swan.games.network.c.b bVar = new com.baidu.swan.games.network.c.b();
            bVar.errMsg = str2;
            bVar.statusCode = i;
            bVar.url = str;
            if (this.ejg) {
                f(2, bVar);
            } else {
                this.eji.a(new b(2, bVar));
            }
        }
    }

    public boolean b(JSEvent jSEvent) {
        synchronized (this.mLock) {
            if (this.ejg) {
                f(3, jSEvent);
            } else {
                this.eji.a(new b(3, jSEvent));
            }
        }
        return true;
    }

    private void aXE() {
        for (b bVar : this.ejh) {
            this.eji.a(bVar);
        }
        this.ejh.clear();
    }

    private void f(int i, Object obj) {
        if (obj != null) {
            if (DEBUG) {
                Log.d("SwanGameResponseCache", "addToCacheList type:" + i);
            }
            this.ejh.add(new b(i, obj));
        }
    }
}
