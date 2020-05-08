package com.baidu.swan.impl.map;

import android.content.Context;
import android.util.Log;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.y.f;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes12.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = c.class.getSimpleName();
    private static volatile c cUC;
    private Map<com.baidu.swan.apps.adaptation.b.c, b> cUD;

    private c() {
        a.azI();
        this.cUD = new HashMap();
    }

    public static c azP() {
        if (cUC == null) {
            synchronized (c.class) {
                if (cUC == null) {
                    cUC = new c();
                }
            }
        }
        return cUC;
    }

    public static void c(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (cUC != null) {
                cUC.h(cVar).resume();
            }
        }
    }

    public static void d(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (cUC != null) {
                cUC.h(cVar).pause();
            }
        }
    }

    public static void e(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (cUC != null) {
                cUC.i(cVar);
            } else if (DEBUG) {
                Log.v(TAG, "未初始化，无需执行release");
            }
        }
    }

    public boolean a(Context context, com.baidu.swan.apps.z.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map create start");
        if (ai.kf(cVar.bGO) == null || !cVar.isValid()) {
            com.baidu.swan.apps.console.c.e("map", "model data is invalid");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e iI = f.aeJ().iI(cVar.bGO);
        if (!(iI instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) iI);
        if (h.rm(cVar.bGN) != null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.bGN + " exist");
            return false;
        }
        com.baidu.swan.impl.map.item.c c = com.baidu.swan.impl.map.item.c.c(context, cVar);
        if (c == null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.bGN + " model is invalid");
            return false;
        }
        com.baidu.swan.apps.component.b.c Sv = c.Sv();
        if (!Sv.isSuccess()) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.bGN + " create fail: " + Sv.msg);
            return false;
        } else if (h.a(c)) {
            com.baidu.swan.apps.console.c.i("map", "map with id " + cVar.bGN + " init start");
            com.baidu.swan.impl.map.a.b.e.a(context, c, cVar, h);
            com.baidu.swan.apps.console.c.i("map", "map with id " + cVar.bGN + " init end");
            com.baidu.swan.apps.console.c.i("map", "map create end");
            return true;
        } else {
            return false;
        }
    }

    public boolean a(com.baidu.swan.apps.z.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map remove start");
        if (ai.kf(cVar.bGO) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e iI = f.aeJ().iI(cVar.bGO);
        if (!(iI instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) iI);
        com.baidu.swan.impl.map.item.c rm = h.rm(cVar.bGN);
        if (rm == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.bGN + " not exist");
            return false;
        } else if (h.remove(cVar.bGN)) {
            com.baidu.swan.apps.console.c.i("map", "map remove end");
            if (com.baidu.swan.apps.component.container.a.d(cVar) == null) {
                com.baidu.swan.apps.component.e.a.aC("map", "remove with a null map component");
            }
            com.baidu.swan.apps.component.b.c Sx = rm.Sx();
            boolean isSuccess = Sx.isSuccess();
            if (!isSuccess) {
                com.baidu.swan.apps.console.c.e(TAG, "map remove fail: " + Sx.msg);
                return isSuccess;
            }
            return isSuccess;
        } else {
            return false;
        }
    }

    public boolean b(Context context, com.baidu.swan.apps.z.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map update start");
        if (ai.kf(cVar.bGO) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e iI = f.aeJ().iI(cVar.bGO);
        if (iI == null || !(iI instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) iI);
        com.baidu.swan.impl.map.item.c rm = h.rm(cVar.bGN);
        if (rm == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.bGN + " not exist");
            return false;
        }
        rm.clear();
        com.baidu.swan.impl.map.a.b.e.a(context, rm, cVar, h, true);
        com.baidu.swan.apps.console.c.i("map", "map update end");
        if (com.baidu.swan.apps.component.container.a.d(cVar) == null) {
            com.baidu.swan.apps.component.e.a.aC("map", "update with a null map component");
        }
        com.baidu.swan.apps.component.b.c a = rm.a((com.baidu.swan.impl.map.item.c) cVar);
        boolean isSuccess = a.isSuccess();
        if (!isSuccess) {
            com.baidu.swan.apps.console.c.e(TAG, "map update fail: " + a.msg);
            return isSuccess;
        }
        return isSuccess;
    }

    public synchronized b h(com.baidu.swan.apps.adaptation.b.c cVar) {
        b bVar;
        if (cVar == null) {
            bVar = null;
        } else {
            bVar = this.cUD.get(cVar);
            if (bVar == null) {
                bVar = new b();
                this.cUD.put(cVar, bVar);
            }
        }
        return bVar;
    }

    private synchronized void i(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (cVar != null) {
            b remove = this.cUD.remove(cVar);
            if (remove != null) {
                remove.release();
            }
        }
    }
}
