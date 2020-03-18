package com.baidu.swan.games.network.b;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.searchbox.v8engine.event.JSEvent;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a cqH;
    private final Object mLock = new Object();
    private boolean cqF = true;
    private List<b> cqG = new ArrayList(3);

    public e(@NonNull a aVar) {
        this.cqH = aVar;
    }

    public void aoX() {
        synchronized (this.mLock) {
            this.cqF = false;
            aoY();
        }
    }

    public void onSuccess(Object obj) {
        synchronized (this.mLock) {
            if (this.cqF) {
                f(1, obj);
            } else {
                this.cqH.a(new b(1, obj));
            }
        }
    }

    public void i(String str, int i, String str2) {
        synchronized (this.mLock) {
            com.baidu.swan.games.network.c.b bVar = new com.baidu.swan.games.network.c.b();
            bVar.errMsg = str2;
            bVar.statusCode = i;
            bVar.url = str;
            if (this.cqF) {
                f(2, bVar);
            } else {
                this.cqH.a(new b(2, bVar));
            }
        }
    }

    public boolean b(JSEvent jSEvent) {
        synchronized (this.mLock) {
            if (this.cqF) {
                f(3, jSEvent);
            } else {
                this.cqH.a(new b(3, jSEvent));
            }
        }
        return true;
    }

    private void aoY() {
        for (b bVar : this.cqG) {
            this.cqH.a(bVar);
        }
        this.cqG.clear();
    }

    private void f(int i, Object obj) {
        if (obj != null) {
            if (DEBUG) {
                Log.d("SwanGameResponseCache", "addToCacheList type:" + i);
            }
            this.cqG.add(new b(i, obj));
        }
    }
}
