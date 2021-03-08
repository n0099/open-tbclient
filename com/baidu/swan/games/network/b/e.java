package com.baidu.swan.games.network.b;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.event.JSEvent;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a ekJ;
    private final Object mLock = new Object();
    private boolean ekH = true;
    private List<b> ekI = new ArrayList(3);

    public e(@NonNull a aVar) {
        this.ekJ = aVar;
    }

    public void aXG() {
        synchronized (this.mLock) {
            this.ekH = false;
            aXH();
        }
    }

    public void onSuccess(Object obj) {
        synchronized (this.mLock) {
            if (this.ekH) {
                f(1, obj);
            } else {
                this.ekJ.a(new b(1, obj));
            }
        }
    }

    public void l(String str, int i, String str2) {
        synchronized (this.mLock) {
            com.baidu.swan.games.network.c.b bVar = new com.baidu.swan.games.network.c.b();
            bVar.errMsg = str2;
            bVar.statusCode = i;
            bVar.url = str;
            if (this.ekH) {
                f(2, bVar);
            } else {
                this.ekJ.a(new b(2, bVar));
            }
        }
    }

    public boolean b(JSEvent jSEvent) {
        synchronized (this.mLock) {
            if (this.ekH) {
                f(3, jSEvent);
            } else {
                this.ekJ.a(new b(3, jSEvent));
            }
        }
        return true;
    }

    private void aXH() {
        for (b bVar : this.ekI) {
            this.ekJ.a(bVar);
        }
        this.ekI.clear();
    }

    private void f(int i, Object obj) {
        if (obj != null) {
            if (DEBUG) {
                Log.d("SwanGameResponseCache", "addToCacheList type:" + i);
            }
            this.ekI.add(new b(i, obj));
        }
    }
}
