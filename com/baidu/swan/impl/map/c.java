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
    private static volatile c bGL;
    private Map<com.baidu.swan.apps.b.c.c, b> bGM;

    private c() {
        a.Zi();
        this.bGM = new HashMap();
    }

    public static c Zp() {
        if (bGL == null) {
            synchronized (c.class) {
                if (bGL == null) {
                    bGL = new c();
                }
            }
        }
        return bGL;
    }

    public static void c(com.baidu.swan.apps.b.c.c cVar) {
        synchronized (c.class) {
            if (bGL != null) {
                bGL.h(cVar).resume();
            } else if (DEBUG) {
                Log.v(TAG, "未初始化，无需执行resume");
            }
        }
    }

    public static void d(com.baidu.swan.apps.b.c.c cVar) {
        synchronized (c.class) {
            if (bGL != null) {
                bGL.h(cVar).pause();
            } else if (DEBUG) {
                Log.v(TAG, "未初始化，无需执行pause");
            }
        }
    }

    public static void e(com.baidu.swan.apps.b.c.c cVar) {
        synchronized (c.class) {
            if (bGL != null) {
                bGL.i(cVar);
            } else if (DEBUG) {
                Log.v(TAG, "未初始化，无需执行release");
            }
        }
    }

    public boolean a(Context context, com.baidu.swan.apps.x.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map create start");
        AbsoluteLayout fN = ac.fN(cVar.aXH);
        if (fN == null || !cVar.isValid()) {
            com.baidu.swan.apps.console.c.e("map", "model data is invalid");
            return false;
        }
        e eH = com.baidu.swan.apps.w.e.LD().eH(cVar.aXH);
        if (!(eH instanceof com.baidu.swan.apps.b.c.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.b.c.c) eH);
        if (h.kN(cVar.id) != null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.id + " exist");
            return false;
        }
        com.baidu.swan.impl.map.item.b c = com.baidu.swan.impl.map.item.b.c(context, cVar);
        if (c == null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.id + " model is invalid");
            return false;
        } else if (!new SwanAppNAViewContainer(fN.getContext()).a(c.bHp, cVar)) {
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
        if (ac.fN(cVar.aXH) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        e eH = com.baidu.swan.apps.w.e.LD().eH(cVar.aXH);
        if (!(eH instanceof com.baidu.swan.apps.b.c.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.b.c.c) eH);
        if (h.kN(cVar.id) == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.id + " not exist");
            return false;
        } else if (h.remove(cVar.id)) {
            com.baidu.swan.apps.console.c.i("map", "map remove end");
            SwanAppNAViewContainer a = com.baidu.swan.apps.view.container.c.b.a(cVar, null);
            return a != null && a.Vc();
        } else {
            return false;
        }
    }

    public boolean b(Context context, com.baidu.swan.apps.x.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map update start");
        if (ac.fN(cVar.aXH) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        e eH = com.baidu.swan.apps.w.e.LD().eH(cVar.aXH);
        if (eH == null || !(eH instanceof com.baidu.swan.apps.b.c.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.b.c.c) eH);
        com.baidu.swan.impl.map.item.b kN = h.kN(cVar.id);
        if (kN == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.id + " not exist");
            return false;
        }
        kN.clear();
        com.baidu.swan.impl.map.a.b.e.a(context, kN, cVar, h, true);
        com.baidu.swan.apps.console.c.i("map", "map update end");
        SwanAppNAViewContainer a = com.baidu.swan.apps.view.container.c.b.a(cVar, null);
        return a != null && a.a(cVar);
    }

    public synchronized b h(com.baidu.swan.apps.b.c.c cVar) {
        b bVar;
        if (cVar == null) {
            bVar = null;
        } else {
            bVar = this.bGM.get(cVar);
            if (bVar == null) {
                bVar = new b();
                this.bGM.put(cVar, bVar);
            }
        }
        return bVar;
    }

    private synchronized void i(com.baidu.swan.apps.b.c.c cVar) {
        if (cVar != null) {
            b remove = this.bGM.remove(cVar);
            if (remove != null) {
                remove.release();
            }
        }
    }
}
