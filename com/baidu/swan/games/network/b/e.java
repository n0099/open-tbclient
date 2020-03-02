package com.baidu.swan.games.network.b;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.searchbox.v8engine.event.JSEvent;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a cqv;
    private final Object mLock = new Object();
    private boolean cqt = true;
    private List<b> cqu = new ArrayList(3);

    public e(@NonNull a aVar) {
        this.cqv = aVar;
    }

    public void aoU() {
        synchronized (this.mLock) {
            this.cqt = false;
            aoV();
        }
    }

    public void onSuccess(Object obj) {
        synchronized (this.mLock) {
            if (this.cqt) {
                f(1, obj);
            } else {
                this.cqv.a(new b(1, obj));
            }
        }
    }

    public void i(String str, int i, String str2) {
        synchronized (this.mLock) {
            com.baidu.swan.games.network.c.b bVar = new com.baidu.swan.games.network.c.b();
            bVar.errMsg = str2;
            bVar.statusCode = i;
            bVar.url = str;
            if (this.cqt) {
                f(2, bVar);
            } else {
                this.cqv.a(new b(2, bVar));
            }
        }
    }

    public boolean b(JSEvent jSEvent) {
        synchronized (this.mLock) {
            if (this.cqt) {
                f(3, jSEvent);
            } else {
                this.cqv.a(new b(3, jSEvent));
            }
        }
        return true;
    }

    private void aoV() {
        for (b bVar : this.cqu) {
            this.cqv.a(bVar);
        }
        this.cqu.clear();
    }

    private void f(int i, Object obj) {
        if (obj != null) {
            if (DEBUG) {
                Log.d("SwanGameResponseCache", "addToCacheList type:" + i);
            }
            this.cqu.add(new b(i, obj));
        }
    }
}
