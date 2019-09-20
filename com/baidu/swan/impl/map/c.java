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
    private static volatile c bnZ;
    private Map<com.baidu.swan.apps.b.c.c, b> boa;

    private c() {
        a.Ut();
        this.boa = new HashMap();
    }

    public static c UA() {
        if (bnZ == null) {
            synchronized (c.class) {
                if (bnZ == null) {
                    bnZ = new c();
                }
            }
        }
        return bnZ;
    }

    public static void c(com.baidu.swan.apps.b.c.c cVar) {
        synchronized (c.class) {
            if (bnZ != null) {
                bnZ.h(cVar).resume();
            } else if (DEBUG) {
                Log.v(TAG, "未初始化，无需执行resume");
            }
        }
    }

    public static void d(com.baidu.swan.apps.b.c.c cVar) {
        synchronized (c.class) {
            if (bnZ != null) {
                bnZ.h(cVar).pause();
            } else if (DEBUG) {
                Log.v(TAG, "未初始化，无需执行pause");
            }
        }
    }

    public static void e(com.baidu.swan.apps.b.c.c cVar) {
        synchronized (c.class) {
            if (bnZ != null) {
                bnZ.i(cVar);
            } else if (DEBUG) {
                Log.v(TAG, "未初始化，无需执行release");
            }
        }
    }

    public boolean a(Context context, com.baidu.swan.apps.x.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map create start");
        AbsoluteLayout fg = ac.fg(cVar.aEs);
        if (fg == null || !cVar.isValid()) {
            com.baidu.swan.apps.console.c.e("map", "model data is invalid");
            return false;
        }
        e ea = com.baidu.swan.apps.w.e.GJ().ea(cVar.aEs);
        if (!(ea instanceof com.baidu.swan.apps.b.c.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.b.c.c) ea);
        if (h.kl(cVar.id) != null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.id + " exist");
            return false;
        }
        com.baidu.swan.impl.map.item.b c = com.baidu.swan.impl.map.item.b.c(context, cVar);
        if (c == null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.id + " model is invalid");
            return false;
        } else if (!new SwanAppNAViewContainer(fg.getContext()).a(c.boD, cVar)) {
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
        if (ac.fg(cVar.aEs) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        e ea = com.baidu.swan.apps.w.e.GJ().ea(cVar.aEs);
        if (!(ea instanceof com.baidu.swan.apps.b.c.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.b.c.c) ea);
        if (h.kl(cVar.id) == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.id + " not exist");
            return false;
        } else if (h.remove(cVar.id)) {
            com.baidu.swan.apps.console.c.i("map", "map remove end");
            SwanAppNAViewContainer a = com.baidu.swan.apps.view.container.c.b.a(cVar, null);
            return a != null && a.Qm();
        } else {
            return false;
        }
    }

    public boolean b(Context context, com.baidu.swan.apps.x.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map update start");
        if (ac.fg(cVar.aEs) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        e ea = com.baidu.swan.apps.w.e.GJ().ea(cVar.aEs);
        if (ea == null || !(ea instanceof com.baidu.swan.apps.b.c.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.b.c.c) ea);
        com.baidu.swan.impl.map.item.b kl = h.kl(cVar.id);
        if (kl == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.id + " not exist");
            return false;
        }
        kl.clear();
        com.baidu.swan.impl.map.a.b.e.a(context, kl, cVar, h, true);
        com.baidu.swan.apps.console.c.i("map", "map update end");
        SwanAppNAViewContainer a = com.baidu.swan.apps.view.container.c.b.a(cVar, null);
        return a != null && a.a(cVar);
    }

    public synchronized b h(com.baidu.swan.apps.b.c.c cVar) {
        b bVar;
        if (cVar == null) {
            bVar = null;
        } else {
            bVar = this.boa.get(cVar);
            if (bVar == null) {
                bVar = new b();
                this.boa.put(cVar, bVar);
            }
        }
        return bVar;
    }

    private synchronized void i(com.baidu.swan.apps.b.c.c cVar) {
        if (cVar != null) {
            b remove = this.boa.remove(cVar);
            if (remove != null) {
                remove.release();
            }
        }
    }
}
