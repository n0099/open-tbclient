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
    private static volatile c dAl;
    private Map<com.baidu.swan.apps.adaptation.b.c, b> dAm;

    private c() {
        a.aRn();
        this.dAm = new HashMap();
    }

    public static c aRu() {
        if (dAl == null) {
            synchronized (c.class) {
                if (dAl == null) {
                    dAl = new c();
                }
            }
        }
        return dAl;
    }

    public static void c(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (dAl != null) {
                dAl.h(cVar).resume();
            }
        }
    }

    public static void d(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (dAl != null) {
                dAl.h(cVar).pause();
            }
        }
    }

    public static void e(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (dAl != null) {
                dAl.i(cVar);
            } else if (DEBUG) {
                Log.v(TAG, "未初始化，无需执行release");
            }
        }
    }

    public boolean a(Context context, com.baidu.swan.apps.w.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map create start");
        if (ak.nY(cVar.caU) == null || !cVar.isValid()) {
            com.baidu.swan.apps.console.c.e("map", "model data is invalid");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e lT = f.arY().lT(cVar.caU);
        if (!(lT instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) lT);
        if (h.wr(cVar.caT) != null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.caT + " exist");
            return false;
        }
        com.baidu.swan.impl.map.item.c c = com.baidu.swan.impl.map.item.c.c(context, cVar);
        if (c == null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.caT + " model is invalid");
            return false;
        }
        com.baidu.swan.apps.component.b.c acZ = c.acZ();
        if (!acZ.isSuccess()) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.caT + " create fail: " + acZ.msg);
            return false;
        } else if (h.a(c)) {
            com.baidu.swan.apps.console.c.i("map", "map with id " + cVar.caT + " init start");
            com.baidu.swan.impl.map.a.b.e.a(context, c, cVar, h);
            com.baidu.swan.apps.console.c.i("map", "map with id " + cVar.caT + " init end");
            com.baidu.swan.apps.console.c.i("map", "map create end");
            return true;
        } else {
            return false;
        }
    }

    public boolean a(com.baidu.swan.apps.w.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map remove start");
        if (ak.nY(cVar.caU) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e lT = f.arY().lT(cVar.caU);
        if (!(lT instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) lT);
        com.baidu.swan.impl.map.item.c wr = h.wr(cVar.caT);
        if (wr == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.caT + " not exist");
            return false;
        } else if (h.remove(cVar.caT)) {
            com.baidu.swan.apps.console.c.i("map", "map remove end");
            if (com.baidu.swan.apps.component.container.a.d(cVar) == null) {
                com.baidu.swan.apps.component.e.a.ba("map", "remove with a null map component");
            }
            com.baidu.swan.apps.component.b.c adb = wr.adb();
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
        if (ak.nY(cVar.caU) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e lT = f.arY().lT(cVar.caU);
        if (lT == null || !(lT instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) lT);
        com.baidu.swan.impl.map.item.c wr = h.wr(cVar.caT);
        if (wr == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.caT + " not exist");
            return false;
        }
        wr.clear();
        com.baidu.swan.impl.map.a.b.e.a(context, wr, cVar, h, true);
        com.baidu.swan.apps.console.c.i("map", "map update end");
        if (com.baidu.swan.apps.component.container.a.d(cVar) == null) {
            com.baidu.swan.apps.component.e.a.ba("map", "update with a null map component");
        }
        com.baidu.swan.apps.component.b.c a = wr.a((com.baidu.swan.impl.map.item.c) cVar);
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
            bVar = this.dAm.get(cVar);
            if (bVar == null) {
                bVar = new b();
                this.dAm.put(cVar, bVar);
            }
        }
        return bVar;
    }

    private synchronized void i(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (cVar != null) {
            b remove = this.dAm.remove(cVar);
            if (remove != null) {
                remove.release();
            }
        }
    }
}
