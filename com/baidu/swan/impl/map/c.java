package com.baidu.swan.impl.map;

import android.content.Context;
import android.util.Log;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.v.f;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = c.class.getSimpleName();
    private static volatile c epX;
    private Map<com.baidu.swan.apps.adaptation.b.c, b> epY;

    private c() {
        a.bap();
        this.epY = new HashMap();
    }

    public static c baw() {
        if (epX == null) {
            synchronized (c.class) {
                if (epX == null) {
                    epX = new c();
                }
            }
        }
        return epX;
    }

    public static void c(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (epX != null) {
                epX.h(cVar).resume();
            }
        }
    }

    public static void d(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (epX != null) {
                epX.h(cVar).pause();
            }
        }
    }

    public static void e(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (epX != null) {
                epX.i(cVar);
            } else if (DEBUG) {
                Log.v(TAG, "未初始化，无需执行release");
            }
        }
    }

    public boolean a(Context context, com.baidu.swan.apps.w.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map create start");
        if (ak.pv(cVar.cMR) == null || !cVar.isValid()) {
            com.baidu.swan.apps.console.c.e("map", "model data is invalid");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e np = f.aAo().np(cVar.cMR);
        if (!(np instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) np);
        if (h.xU(cVar.cMQ) != null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.cMQ + " exist");
            return false;
        }
        com.baidu.swan.impl.map.item.c c = com.baidu.swan.impl.map.item.c.c(context, cVar);
        if (c == null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.cMQ + " model is invalid");
            return false;
        }
        com.baidu.swan.apps.component.b.c ale = c.ale();
        if (!ale.isSuccess()) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.cMQ + " create fail: " + ale.msg);
            return false;
        } else if (h.a(c)) {
            com.baidu.swan.apps.console.c.i("map", "map with id " + cVar.cMQ + " init start");
            com.baidu.swan.impl.map.a.b.e.a(context, c, cVar, h);
            com.baidu.swan.apps.console.c.i("map", "map with id " + cVar.cMQ + " init end");
            com.baidu.swan.apps.console.c.i("map", "map create end");
            return true;
        } else {
            return false;
        }
    }

    public boolean a(com.baidu.swan.apps.w.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map remove start");
        if (ak.pv(cVar.cMR) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e np = f.aAo().np(cVar.cMR);
        if (!(np instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) np);
        com.baidu.swan.impl.map.item.c xU = h.xU(cVar.cMQ);
        if (xU == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.cMQ + " not exist");
            return false;
        } else if (h.remove(cVar.cMQ)) {
            com.baidu.swan.apps.console.c.i("map", "map remove end");
            if (com.baidu.swan.apps.component.container.a.d(cVar) == null) {
                com.baidu.swan.apps.component.e.a.bk("map", "remove with a null map component");
            }
            com.baidu.swan.apps.component.b.c alg = xU.alg();
            boolean isSuccess = alg.isSuccess();
            if (!isSuccess) {
                com.baidu.swan.apps.console.c.e(TAG, "map remove fail: " + alg.msg);
                return isSuccess;
            }
            return isSuccess;
        } else {
            return false;
        }
    }

    public boolean b(Context context, com.baidu.swan.apps.w.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map update start");
        if (ak.pv(cVar.cMR) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e np = f.aAo().np(cVar.cMR);
        if (np == null || !(np instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) np);
        com.baidu.swan.impl.map.item.c xU = h.xU(cVar.cMQ);
        if (xU == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.cMQ + " not exist");
            return false;
        }
        xU.clear();
        com.baidu.swan.impl.map.a.b.e.a(context, xU, cVar, h, true);
        com.baidu.swan.apps.console.c.i("map", "map update end");
        if (com.baidu.swan.apps.component.container.a.d(cVar) == null) {
            com.baidu.swan.apps.component.e.a.bk("map", "update with a null map component");
        }
        com.baidu.swan.apps.component.b.c a2 = xU.a((com.baidu.swan.impl.map.item.c) cVar);
        boolean isSuccess = a2.isSuccess();
        if (!isSuccess) {
            com.baidu.swan.apps.console.c.e(TAG, "map update fail: " + a2.msg);
            return isSuccess;
        }
        return isSuccess;
    }

    public synchronized b h(com.baidu.swan.apps.adaptation.b.c cVar) {
        b bVar;
        if (cVar == null) {
            bVar = null;
        } else {
            bVar = this.epY.get(cVar);
            if (bVar == null) {
                bVar = new b();
                this.epY.put(cVar, bVar);
            }
        }
        return bVar;
    }

    private synchronized void i(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (cVar != null) {
            b remove = this.epY.remove(cVar);
            if (remove != null) {
                remove.release();
            }
        }
    }
}
