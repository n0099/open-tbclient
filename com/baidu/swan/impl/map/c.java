package com.baidu.swan.impl.map;

import android.content.Context;
import android.util.Log;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.v.f;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes25.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = c.class.getSimpleName();
    private static volatile c dOr;
    private Map<com.baidu.swan.apps.adaptation.b.c, b> dOs;

    private c() {
        a.aUI();
        this.dOs = new HashMap();
    }

    public static c aUP() {
        if (dOr == null) {
            synchronized (c.class) {
                if (dOr == null) {
                    dOr = new c();
                }
            }
        }
        return dOr;
    }

    public static void c(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (dOr != null) {
                dOr.h(cVar).resume();
            }
        }
    }

    public static void d(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (dOr != null) {
                dOr.h(cVar).pause();
            }
        }
    }

    public static void e(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (dOr != null) {
                dOr.i(cVar);
            } else if (DEBUG) {
                Log.v(TAG, "未初始化，无需执行release");
            }
        }
    }

    public boolean a(Context context, com.baidu.swan.apps.w.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map create start");
        if (ak.pg(cVar.cpq) == null || !cVar.isValid()) {
            com.baidu.swan.apps.console.c.e("map", "model data is invalid");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e mZ = f.avu().mZ(cVar.cpq);
        if (!(mZ instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) mZ);
        if (h.xx(cVar.cpp) != null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.cpp + " exist");
            return false;
        }
        com.baidu.swan.impl.map.item.c c = com.baidu.swan.impl.map.item.c.c(context, cVar);
        if (c == null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.cpp + " model is invalid");
            return false;
        }
        com.baidu.swan.apps.component.b.c agt = c.agt();
        if (!agt.isSuccess()) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.cpp + " create fail: " + agt.msg);
            return false;
        } else if (h.a(c)) {
            com.baidu.swan.apps.console.c.i("map", "map with id " + cVar.cpp + " init start");
            com.baidu.swan.impl.map.a.b.e.a(context, c, cVar, h);
            com.baidu.swan.apps.console.c.i("map", "map with id " + cVar.cpp + " init end");
            com.baidu.swan.apps.console.c.i("map", "map create end");
            return true;
        } else {
            return false;
        }
    }

    public boolean a(com.baidu.swan.apps.w.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map remove start");
        if (ak.pg(cVar.cpq) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e mZ = f.avu().mZ(cVar.cpq);
        if (!(mZ instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) mZ);
        com.baidu.swan.impl.map.item.c xx = h.xx(cVar.cpp);
        if (xx == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.cpp + " not exist");
            return false;
        } else if (h.remove(cVar.cpp)) {
            com.baidu.swan.apps.console.c.i("map", "map remove end");
            if (com.baidu.swan.apps.component.container.a.d(cVar) == null) {
                com.baidu.swan.apps.component.e.a.bf("map", "remove with a null map component");
            }
            com.baidu.swan.apps.component.b.c agv = xx.agv();
            boolean isSuccess = agv.isSuccess();
            if (!isSuccess) {
                com.baidu.swan.apps.console.c.e(TAG, "map remove fail: " + agv.msg);
                return isSuccess;
            }
            return isSuccess;
        } else {
            return false;
        }
    }

    public boolean b(Context context, com.baidu.swan.apps.w.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map update start");
        if (ak.pg(cVar.cpq) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e mZ = f.avu().mZ(cVar.cpq);
        if (mZ == null || !(mZ instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) mZ);
        com.baidu.swan.impl.map.item.c xx = h.xx(cVar.cpp);
        if (xx == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.cpp + " not exist");
            return false;
        }
        xx.clear();
        com.baidu.swan.impl.map.a.b.e.a(context, xx, cVar, h, true);
        com.baidu.swan.apps.console.c.i("map", "map update end");
        if (com.baidu.swan.apps.component.container.a.d(cVar) == null) {
            com.baidu.swan.apps.component.e.a.bf("map", "update with a null map component");
        }
        com.baidu.swan.apps.component.b.c a2 = xx.a((com.baidu.swan.impl.map.item.c) cVar);
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
            bVar = this.dOs.get(cVar);
            if (bVar == null) {
                bVar = new b();
                this.dOs.put(cVar, bVar);
            }
        }
        return bVar;
    }

    private synchronized void i(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (cVar != null) {
            b remove = this.dOs.remove(cVar);
            if (remove != null) {
                remove.release();
            }
        }
    }
}
