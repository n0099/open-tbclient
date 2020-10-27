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
    private static volatile c dWO;
    private Map<com.baidu.swan.apps.adaptation.b.c, b> dWP;

    private c() {
        a.aWC();
        this.dWP = new HashMap();
    }

    public static c aWJ() {
        if (dWO == null) {
            synchronized (c.class) {
                if (dWO == null) {
                    dWO = new c();
                }
            }
        }
        return dWO;
    }

    public static void c(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (dWO != null) {
                dWO.h(cVar).resume();
            }
        }
    }

    public static void d(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (dWO != null) {
                dWO.h(cVar).pause();
            }
        }
    }

    public static void e(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (dWO != null) {
                dWO.i(cVar);
            } else if (DEBUG) {
                Log.v(TAG, "未初始化，无需执行release");
            }
        }
    }

    public boolean a(Context context, com.baidu.swan.apps.w.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map create start");
        if (ak.pz(cVar.cxS) == null || !cVar.isValid()) {
            com.baidu.swan.apps.console.c.e("map", "model data is invalid");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e ns = f.axo().ns(cVar.cxS);
        if (!(ns instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) ns);
        if (h.xQ(cVar.cxR) != null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.cxR + " exist");
            return false;
        }
        com.baidu.swan.impl.map.item.c c = com.baidu.swan.impl.map.item.c.c(context, cVar);
        if (c == null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.cxR + " model is invalid");
            return false;
        }
        com.baidu.swan.apps.component.b.c ain = c.ain();
        if (!ain.isSuccess()) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.cxR + " create fail: " + ain.msg);
            return false;
        } else if (h.a(c)) {
            com.baidu.swan.apps.console.c.i("map", "map with id " + cVar.cxR + " init start");
            com.baidu.swan.impl.map.a.b.e.a(context, c, cVar, h);
            com.baidu.swan.apps.console.c.i("map", "map with id " + cVar.cxR + " init end");
            com.baidu.swan.apps.console.c.i("map", "map create end");
            return true;
        } else {
            return false;
        }
    }

    public boolean a(com.baidu.swan.apps.w.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map remove start");
        if (ak.pz(cVar.cxS) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e ns = f.axo().ns(cVar.cxS);
        if (!(ns instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) ns);
        com.baidu.swan.impl.map.item.c xQ = h.xQ(cVar.cxR);
        if (xQ == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.cxR + " not exist");
            return false;
        } else if (h.remove(cVar.cxR)) {
            com.baidu.swan.apps.console.c.i("map", "map remove end");
            if (com.baidu.swan.apps.component.container.a.d(cVar) == null) {
                com.baidu.swan.apps.component.e.a.bm("map", "remove with a null map component");
            }
            com.baidu.swan.apps.component.b.c aip = xQ.aip();
            boolean isSuccess = aip.isSuccess();
            if (!isSuccess) {
                com.baidu.swan.apps.console.c.e(TAG, "map remove fail: " + aip.msg);
                return isSuccess;
            }
            return isSuccess;
        } else {
            return false;
        }
    }

    public boolean b(Context context, com.baidu.swan.apps.w.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map update start");
        if (ak.pz(cVar.cxS) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e ns = f.axo().ns(cVar.cxS);
        if (ns == null || !(ns instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) ns);
        com.baidu.swan.impl.map.item.c xQ = h.xQ(cVar.cxR);
        if (xQ == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.cxR + " not exist");
            return false;
        }
        xQ.clear();
        com.baidu.swan.impl.map.a.b.e.a(context, xQ, cVar, h, true);
        com.baidu.swan.apps.console.c.i("map", "map update end");
        if (com.baidu.swan.apps.component.container.a.d(cVar) == null) {
            com.baidu.swan.apps.component.e.a.bm("map", "update with a null map component");
        }
        com.baidu.swan.apps.component.b.c a2 = xQ.a((com.baidu.swan.impl.map.item.c) cVar);
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
            bVar = this.dWP.get(cVar);
            if (bVar == null) {
                bVar = new b();
                this.dWP.put(cVar, bVar);
            }
        }
        return bVar;
    }

    private synchronized void i(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (cVar != null) {
            b remove = this.dWP.remove(cVar);
            if (remove != null) {
                remove.release();
            }
        }
    }
}
