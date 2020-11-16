package com.baidu.swan.games.network.b;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.searchbox.v8engine.event.JSEvent;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a dVR;
    private final Object mLock = new Object();
    private boolean dVP = true;
    private List<b> dVQ = new ArrayList(3);

    public e(@NonNull a aVar) {
        this.dVR = aVar;
    }

    public void aVL() {
        synchronized (this.mLock) {
            this.dVP = false;
            aVM();
        }
    }

    public void onSuccess(Object obj) {
        synchronized (this.mLock) {
            if (this.dVP) {
                f(1, obj);
            } else {
                this.dVR.a(new b(1, obj));
            }
        }
    }

    public void l(String str, int i, String str2) {
        synchronized (this.mLock) {
            com.baidu.swan.games.network.c.b bVar = new com.baidu.swan.games.network.c.b();
            bVar.errMsg = str2;
            bVar.statusCode = i;
            bVar.url = str;
            if (this.dVP) {
                f(2, bVar);
            } else {
                this.dVR.a(new b(2, bVar));
            }
        }
    }

    public boolean b(JSEvent jSEvent) {
        synchronized (this.mLock) {
            if (this.dVP) {
                f(3, jSEvent);
            } else {
                this.dVR.a(new b(3, jSEvent));
            }
        }
        return true;
    }

    private void aVM() {
        for (b bVar : this.dVQ) {
            this.dVR.a(bVar);
        }
        this.dVQ.clear();
    }

    private void f(int i, Object obj) {
        if (obj != null) {
            if (DEBUG) {
                Log.d("SwanGameResponseCache", "addToCacheList type:" + i);
            }
            this.dVQ.add(new b(i, obj));
        }
    }
}
