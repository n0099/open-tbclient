package com.baidu.swan.games.network.b;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.event.JSEvent;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a elN;
    private final Object mLock = new Object();
    private boolean elL = true;
    private List<b> elM = new ArrayList(3);

    public e(@NonNull a aVar) {
        this.elN = aVar;
    }

    public void bbl() {
        synchronized (this.mLock) {
            this.elL = false;
            bbm();
        }
    }

    public void onSuccess(Object obj) {
        synchronized (this.mLock) {
            if (this.elL) {
                f(1, obj);
            } else {
                this.elN.a(new b(1, obj));
            }
        }
    }

    public void onError(String str, int i, String str2) {
        synchronized (this.mLock) {
            com.baidu.swan.games.network.c.b bVar = new com.baidu.swan.games.network.c.b();
            bVar.errMsg = str2;
            bVar.statusCode = i;
            bVar.url = str;
            if (this.elL) {
                f(2, bVar);
            } else {
                this.elN.a(new b(2, bVar));
            }
        }
    }

    public boolean b(JSEvent jSEvent) {
        synchronized (this.mLock) {
            if (this.elL) {
                f(3, jSEvent);
            } else {
                this.elN.a(new b(3, jSEvent));
            }
        }
        return true;
    }

    private void bbm() {
        for (b bVar : this.elM) {
            this.elN.a(bVar);
        }
        this.elM.clear();
    }

    private void f(int i, Object obj) {
        if (obj != null) {
            if (DEBUG) {
                Log.d("SwanGameResponseCache", "addToCacheList type:" + i);
            }
            this.elM.add(new b(i, obj));
        }
    }
}
