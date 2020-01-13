package com.baidu.swan.games.network.b;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.searchbox.v8engine.event.JSEvent;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private a cms;
    private final Object mLock = new Object();
    private boolean cmq = true;
    private List<b> cmr = new ArrayList(3);

    public e(@NonNull a aVar) {
        this.cms = aVar;
    }

    public void amF() {
        synchronized (this.mLock) {
            this.cmq = false;
            amG();
        }
    }

    public void onSuccess(Object obj) {
        synchronized (this.mLock) {
            if (this.cmq) {
                f(1, obj);
            } else {
                this.cms.a(new b(1, obj));
            }
        }
    }

    public void h(String str, int i, String str2) {
        synchronized (this.mLock) {
            com.baidu.swan.games.network.c.b bVar = new com.baidu.swan.games.network.c.b();
            bVar.errMsg = str2;
            bVar.statusCode = i;
            bVar.url = str;
            if (this.cmq) {
                f(2, bVar);
            } else {
                this.cms.a(new b(2, bVar));
            }
        }
    }

    public boolean b(JSEvent jSEvent) {
        synchronized (this.mLock) {
            if (this.cmq) {
                f(3, jSEvent);
            } else {
                this.cms.a(new b(3, jSEvent));
            }
        }
        return true;
    }

    private void amG() {
        for (b bVar : this.cmr) {
            this.cms.a(bVar);
        }
        this.cmr.clear();
    }

    private void f(int i, Object obj) {
        if (obj != null) {
            if (DEBUG) {
                Log.d("SwanGameResponseCache", "addToCacheList type:" + i);
            }
            this.cmr.add(new b(i, obj));
        }
    }
}
