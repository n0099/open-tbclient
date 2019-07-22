package com.baidu.swan.impl.map;

import android.content.Context;
import android.util.Log;
import android.widget.AbsoluteLayout;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.b.c.e;
import com.baidu.swan.apps.view.container.SwanAppNAViewContainer;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = c.class.getSimpleName();
    private static volatile c bnB;
    private Map<com.baidu.swan.apps.b.c.c, b> bnC;

    private c() {
        a.Up();
        this.bnC = new HashMap();
    }

    public static c Uw() {
        if (bnB == null) {
            synchronized (c.class) {
                if (bnB == null) {
                    bnB = new c();
                }
            }
        }
        return bnB;
    }

    public static void c(com.baidu.swan.apps.b.c.c cVar) {
        synchronized (c.class) {
            if (bnB != null) {
                bnB.h(cVar).resume();
            } else if (DEBUG) {
                Log.v(TAG, "未初始化，无需执行resume");
            }
        }
    }

    public static void d(com.baidu.swan.apps.b.c.c cVar) {
        synchronized (c.class) {
            if (bnB != null) {
                bnB.h(cVar).pause();
            } else if (DEBUG) {
                Log.v(TAG, "未初始化，无需执行pause");
            }
        }
    }

    public static void e(com.baidu.swan.apps.b.c.c cVar) {
        synchronized (c.class) {
            if (bnB != null) {
                bnB.i(cVar);
            } else if (DEBUG) {
                Log.v(TAG, "未初始化，无需执行release");
            }
        }
    }

    public boolean a(Context context, com.baidu.swan.apps.x.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map create start");
        AbsoluteLayout fe = ac.fe(cVar.aDU);
        if (fe == null || !cVar.isValid()) {
            com.baidu.swan.apps.console.c.e("map", "model data is invalid");
            return false;
        }
        e dY = com.baidu.swan.apps.w.e.GF().dY(cVar.aDU);
        if (!(dY instanceof com.baidu.swan.apps.b.c.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.b.c.c) dY);
        if (h.kj(cVar.id) != null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.id + " exist");
            return false;
        }
        com.baidu.swan.impl.map.item.b c = com.baidu.swan.impl.map.item.b.c(context, cVar);
        if (c == null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.id + " model is invalid");
            return false;
        } else if (!new SwanAppNAViewContainer(fe.getContext()).a(c.bof, cVar)) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.id + " create fail");
            return false;
        } else if (h.a(c)) {
            com.baidu.swan.apps.console.c.i("map", "map with id " + cVar.id + " init start");
            com.baidu.swan.impl.map.a.b.e.a(context, c, cVar, h);
            com.baidu.swan.apps.console.c.i("map", "map with id " + cVar.id + " init end");
            com.baidu.swan.apps.console.c.i("map", "map create end");
            return true;
        } else {
            return false;
        }
    }

    public boolean a(com.baidu.swan.apps.x.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map remove start");
        if (ac.fe(cVar.aDU) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        e dY = com.baidu.swan.apps.w.e.GF().dY(cVar.aDU);
        if (!(dY instanceof com.baidu.swan.apps.b.c.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.b.c.c) dY);
        if (h.kj(cVar.id) == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.id + " not exist");
            return false;
        } else if (h.remove(cVar.id)) {
            com.baidu.swan.apps.console.c.i("map", "map remove end");
            SwanAppNAViewContainer a = com.baidu.swan.apps.view.container.c.b.a(cVar, null);
            return a != null && a.Qi();
        } else {
            return false;
        }
    }

    public boolean b(Context context, com.baidu.swan.apps.x.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map update start");
        if (ac.fe(cVar.aDU) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        e dY = com.baidu.swan.apps.w.e.GF().dY(cVar.aDU);
        if (dY == null || !(dY instanceof com.baidu.swan.apps.b.c.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.b.c.c) dY);
        com.baidu.swan.impl.map.item.b kj = h.kj(cVar.id);
        if (kj == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.id + " not exist");
            return false;
        }
        kj.clear();
        com.baidu.swan.impl.map.a.b.e.a(context, kj, cVar, h, true);
        com.baidu.swan.apps.console.c.i("map", "map update end");
        SwanAppNAViewContainer a = com.baidu.swan.apps.view.container.c.b.a(cVar, null);
        return a != null && a.a(cVar);
    }

    public synchronized b h(com.baidu.swan.apps.b.c.c cVar) {
        b bVar;
        if (cVar == null) {
            bVar = null;
        } else {
            bVar = this.bnC.get(cVar);
            if (bVar == null) {
                bVar = new b();
                this.bnC.put(cVar, bVar);
            }
        }
        return bVar;
    }

    private synchronized void i(com.baidu.swan.apps.b.c.c cVar) {
        if (cVar != null) {
            b remove = this.bnC.remove(cVar);
            if (remove != null) {
                remove.release();
            }
        }
    }
}
