package com.baidu.swan.games.network.b;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.searchbox.v8engine.event.JSEvent;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a cqw;
    private final Object mLock = new Object();
    private boolean cqu = true;
    private List<b> cqv = new ArrayList(3);

    public e(@NonNull a aVar) {
        this.cqw = aVar;
    }

    public void aoU() {
        synchronized (this.mLock) {
            this.cqu = false;
            aoV();
        }
    }

    public void onSuccess(Object obj) {
        synchronized (this.mLock) {
            if (this.cqu) {
                f(1, obj);
            } else {
                this.cqw.a(new b(1, obj));
            }
        }
    }

    public void i(String str, int i, String str2) {
        synchronized (this.mLock) {
            com.baidu.swan.games.network.c.b bVar = new com.baidu.swan.games.network.c.b();
            bVar.errMsg = str2;
            bVar.statusCode = i;
            bVar.url = str;
            if (this.cqu) {
                f(2, bVar);
            } else {
                this.cqw.a(new b(2, bVar));
            }
        }
    }

    public boolean b(JSEvent jSEvent) {
        synchronized (this.mLock) {
            if (this.cqu) {
                f(3, jSEvent);
            } else {
                this.cqw.a(new b(3, jSEvent));
            }
        }
        return true;
    }

    private void aoV() {
        for (b bVar : this.cqv) {
            this.cqw.a(bVar);
        }
        this.cqv.clear();
    }

    private void f(int i, Object obj) {
        if (obj != null) {
            if (DEBUG) {
                Log.d("SwanGameResponseCache", "addToCacheList type:" + i);
            }
            this.cqv.add(new b(i, obj));
        }
    }
}
