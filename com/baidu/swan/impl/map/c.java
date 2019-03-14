package com.baidu.swan.impl.map;

import android.content.Context;
import android.util.Log;
import android.widget.AbsoluteLayout;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.b.c.e;
import com.baidu.swan.apps.view.container.SwanAppNAViewContainer;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = c.class.getSimpleName();
    private static volatile c bgF;
    private Map<com.baidu.swan.apps.b.c.c, b> bgG;

    private c() {
        a.PN();
        this.bgG = new HashMap();
    }

    public static c PU() {
        if (bgF == null) {
            synchronized (c.class) {
                if (bgF == null) {
                    bgF = new c();
                }
            }
        }
        return bgF;
    }

    public static void c(com.baidu.swan.apps.b.c.c cVar) {
        synchronized (c.class) {
            if (bgF != null) {
                bgF.h(cVar).resume();
            } else if (DEBUG) {
                Log.v(TAG, "未初始化，无需执行resume");
            }
        }
    }

    public static void d(com.baidu.swan.apps.b.c.c cVar) {
        synchronized (c.class) {
            if (bgF != null) {
                bgF.h(cVar).pause();
            } else if (DEBUG) {
                Log.v(TAG, "未初始化，无需执行pause");
            }
        }
    }

    public static void e(com.baidu.swan.apps.b.c.c cVar) {
        synchronized (c.class) {
            if (bgF != null) {
                bgF.i(cVar);
            } else if (DEBUG) {
                Log.v(TAG, "未初始化，无需执行release");
            }
        }
    }

    public boolean a(Context context, com.baidu.swan.apps.x.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map create start");
        AbsoluteLayout eO = aa.eO(cVar.aBD);
        if (eO == null || !cVar.isValid()) {
            com.baidu.swan.apps.console.c.e("map", "model data is invalid");
            return false;
        }
        e ee = com.baidu.swan.apps.w.e.Ec().ee(cVar.aBD);
        if (!(ee instanceof com.baidu.swan.apps.b.c.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.b.c.c) ee);
        if (h.jc(cVar.id) != null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.id + " exist");
            return false;
        }
        com.baidu.swan.impl.map.item.b c = com.baidu.swan.impl.map.item.b.c(context, cVar);
        if (c == null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.id + " model is invalid");
            return false;
        } else if (!new SwanAppNAViewContainer(eO.getContext()).a(c.bhj, cVar)) {
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
        if (aa.eO(cVar.aBD) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        e ee = com.baidu.swan.apps.w.e.Ec().ee(cVar.aBD);
        if (!(ee instanceof com.baidu.swan.apps.b.c.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.b.c.c) ee);
        if (h.jc(cVar.id) == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.id + " not exist");
            return false;
        } else if (h.remove(cVar.id)) {
            com.baidu.swan.apps.console.c.i("map", "map remove end");
            SwanAppNAViewContainer a = com.baidu.swan.apps.view.container.c.b.a(cVar, null);
            return a != null && a.MK();
        } else {
            return false;
        }
    }

    public boolean b(Context context, com.baidu.swan.apps.x.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map update start");
        if (aa.eO(cVar.aBD) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        e ee = com.baidu.swan.apps.w.e.Ec().ee(cVar.aBD);
        if (ee == null || !(ee instanceof com.baidu.swan.apps.b.c.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.b.c.c) ee);
        com.baidu.swan.impl.map.item.b jc = h.jc(cVar.id);
        if (jc == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.id + " not exist");
            return false;
        }
        jc.clear();
        com.baidu.swan.impl.map.a.b.e.a(context, jc, cVar, h, true);
        com.baidu.swan.apps.console.c.i("map", "map update end");
        SwanAppNAViewContainer a = com.baidu.swan.apps.view.container.c.b.a(cVar, null);
        return a != null && a.a(cVar);
    }

    public synchronized b h(com.baidu.swan.apps.b.c.c cVar) {
        b bVar;
        if (cVar == null) {
            bVar = null;
        } else {
            bVar = this.bgG.get(cVar);
            if (bVar == null) {
                bVar = new b();
                this.bgG.put(cVar, bVar);
            }
        }
        return bVar;
    }

    private synchronized void i(com.baidu.swan.apps.b.c.c cVar) {
        if (cVar != null) {
            b remove = this.bgG.remove(cVar);
            if (remove != null) {
                remove.release();
            }
        }
    }
}
