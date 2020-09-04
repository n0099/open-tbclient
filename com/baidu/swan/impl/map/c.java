package com.baidu.swan.impl.map;

import android.content.Context;
import android.util.Log;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.v.f;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes19.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = c.class.getSimpleName();
    private static volatile c dAp;
    private Map<com.baidu.swan.apps.adaptation.b.c, b> dAq;

    private c() {
        a.aRn();
        this.dAq = new HashMap();
    }

    public static c aRu() {
        if (dAp == null) {
            synchronized (c.class) {
                if (dAp == null) {
                    dAp = new c();
                }
            }
        }
        return dAp;
    }

    public static void c(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (dAp != null) {
                dAp.h(cVar).resume();
            }
        }
    }

    public static void d(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (dAp != null) {
                dAp.h(cVar).pause();
            }
        }
    }

    public static void e(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (dAp != null) {
                dAp.i(cVar);
            } else if (DEBUG) {
                Log.v(TAG, "未初始化，无需执行release");
            }
        }
    }

    public boolean a(Context context, com.baidu.swan.apps.w.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map create start");
        if (ak.nZ(cVar.caY) == null || !cVar.isValid()) {
            com.baidu.swan.apps.console.c.e("map", "model data is invalid");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e lU = f.arY().lU(cVar.caY);
        if (!(lU instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) lU);
        if (h.ws(cVar.caX) != null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.caX + " exist");
            return false;
        }
        com.baidu.swan.impl.map.item.c c = com.baidu.swan.impl.map.item.c.c(context, cVar);
        if (c == null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.caX + " model is invalid");
            return false;
        }
        com.baidu.swan.apps.component.b.c acZ = c.acZ();
        if (!acZ.isSuccess()) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.caX + " create fail: " + acZ.msg);
            return false;
        } else if (h.a(c)) {
            com.baidu.swan.apps.console.c.i("map", "map with id " + cVar.caX + " init start");
            com.baidu.swan.impl.map.a.b.e.a(context, c, cVar, h);
            com.baidu.swan.apps.console.c.i("map", "map with id " + cVar.caX + " init end");
            com.baidu.swan.apps.console.c.i("map", "map create end");
            return true;
        } else {
            return false;
        }
    }

    public boolean a(com.baidu.swan.apps.w.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map remove start");
        if (ak.nZ(cVar.caY) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e lU = f.arY().lU(cVar.caY);
        if (!(lU instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) lU);
        com.baidu.swan.impl.map.item.c ws = h.ws(cVar.caX);
        if (ws == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.caX + " not exist");
            return false;
        } else if (h.remove(cVar.caX)) {
            com.baidu.swan.apps.console.c.i("map", "map remove end");
            if (com.baidu.swan.apps.component.container.a.d(cVar) == null) {
                com.baidu.swan.apps.component.e.a.ba("map", "remove with a null map component");
            }
            com.baidu.swan.apps.component.b.c adb = ws.adb();
            boolean isSuccess = adb.isSuccess();
            if (!isSuccess) {
                com.baidu.swan.apps.console.c.e(TAG, "map remove fail: " + adb.msg);
                return isSuccess;
            }
            return isSuccess;
        } else {
            return false;
        }
    }

    public boolean b(Context context, com.baidu.swan.apps.w.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map update start");
        if (ak.nZ(cVar.caY) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e lU = f.arY().lU(cVar.caY);
        if (lU == null || !(lU instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) lU);
        com.baidu.swan.impl.map.item.c ws = h.ws(cVar.caX);
        if (ws == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.caX + " not exist");
            return false;
        }
        ws.clear();
        com.baidu.swan.impl.map.a.b.e.a(context, ws, cVar, h, true);
        com.baidu.swan.apps.console.c.i("map", "map update end");
        if (com.baidu.swan.apps.component.container.a.d(cVar) == null) {
            com.baidu.swan.apps.component.e.a.ba("map", "update with a null map component");
        }
        com.baidu.swan.apps.component.b.c a = ws.a((com.baidu.swan.impl.map.item.c) cVar);
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
            bVar = this.dAq.get(cVar);
            if (bVar == null) {
                bVar = new b();
                this.dAq.put(cVar, bVar);
            }
        }
        return bVar;
    }

    private synchronized void i(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (cVar != null) {
            b remove = this.dAq.remove(cVar);
            if (remove != null) {
                remove.release();
            }
        }
    }
}
