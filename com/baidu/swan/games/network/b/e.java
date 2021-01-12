package com.baidu.swan.games.network.b;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.event.JSEvent;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a ehb;
    private final Object mLock = new Object();
    private boolean egZ = true;
    private List<b> eha = new ArrayList(3);

    public e(@NonNull a aVar) {
        this.ehb = aVar;
    }

    public void aXr() {
        synchronized (this.mLock) {
            this.egZ = false;
            aXs();
        }
    }

    public void onSuccess(Object obj) {
        synchronized (this.mLock) {
            if (this.egZ) {
                f(1, obj);
            } else {
                this.ehb.a(new b(1, obj));
            }
        }
    }

    public void onError(String str, int i, String str2) {
        synchronized (this.mLock) {
            com.baidu.swan.games.network.c.b bVar = new com.baidu.swan.games.network.c.b();
            bVar.errMsg = str2;
            bVar.statusCode = i;
            bVar.url = str;
            if (this.egZ) {
                f(2, bVar);
            } else {
                this.ehb.a(new b(2, bVar));
            }
        }
    }

    public boolean b(JSEvent jSEvent) {
        synchronized (this.mLock) {
            if (this.egZ) {
                f(3, jSEvent);
            } else {
                this.ehb.a(new b(3, jSEvent));
            }
        }
        return true;
    }

    private void aXs() {
        for (b bVar : this.eha) {
            this.ehb.a(bVar);
        }
        this.eha.clear();
    }

    private void f(int i, Object obj) {
        if (obj != null) {
            if (DEBUG) {
                Log.d("SwanGameResponseCache", "addToCacheList type:" + i);
            }
            this.eha.add(new b(i, obj));
        }
    }
}
