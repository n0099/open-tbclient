package com.baidu.swan.games.network.b;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.searchbox.v8engine.event.JSEvent;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a dxj;
    private final Object mLock = new Object();
    private boolean dxh = true;
    private List<b> dxi = new ArrayList(3);

    public e(@NonNull a aVar) {
        this.dxj = aVar;
    }

    public void aPq() {
        synchronized (this.mLock) {
            this.dxh = false;
            aPr();
        }
    }

    public void onSuccess(Object obj) {
        synchronized (this.mLock) {
            if (this.dxh) {
                f(1, obj);
            } else {
                this.dxj.a(new b(1, obj));
            }
        }
    }

    public void i(String str, int i, String str2) {
        synchronized (this.mLock) {
            com.baidu.swan.games.network.c.b bVar = new com.baidu.swan.games.network.c.b();
            bVar.errMsg = str2;
            bVar.statusCode = i;
            bVar.url = str;
            if (this.dxh) {
                f(2, bVar);
            } else {
                this.dxj.a(new b(2, bVar));
            }
        }
    }

    public boolean b(JSEvent jSEvent) {
        synchronized (this.mLock) {
            if (this.dxh) {
                f(3, jSEvent);
            } else {
                this.dxj.a(new b(3, jSEvent));
            }
        }
        return true;
    }

    private void aPr() {
        for (b bVar : this.dxi) {
            this.dxj.a(bVar);
        }
        this.dxi.clear();
    }

    private void f(int i, Object obj) {
        if (obj != null) {
            if (DEBUG) {
                Log.d("SwanGameResponseCache", "addToCacheList type:" + i);
            }
            this.dxi.add(new b(i, obj));
        }
    }
}
