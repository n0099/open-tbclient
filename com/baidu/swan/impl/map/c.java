package com.baidu.swan.impl.map;

import android.content.Context;
import android.util.Log;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.w.f;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes12.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = c.class.getSimpleName();
    private static volatile c dkp;
    private Map<com.baidu.swan.apps.adaptation.b.c, b> dkq;

    private c() {
        a.aEG();
        this.dkq = new HashMap();
    }

    public static c aEN() {
        if (dkp == null) {
            synchronized (c.class) {
                if (dkp == null) {
                    dkp = new c();
                }
            }
        }
        return dkp;
    }

    public static void c(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (dkp != null) {
                dkp.h(cVar).resume();
            }
        }
    }

    public static void d(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (dkp != null) {
                dkp.h(cVar).pause();
            }
        }
    }

    public static void e(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (dkp != null) {
                dkp.i(cVar);
            } else if (DEBUG) {
                Log.v(TAG, "未初始化，无需执行release");
            }
        }
    }

    public boolean a(Context context, com.baidu.swan.apps.x.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map create start");
        if (aj.lA(cVar.bUu) == null || !cVar.isValid()) {
            com.baidu.swan.apps.console.c.e("map", "model data is invalid");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e jW = f.ajb().jW(cVar.bUu);
        if (!(jW instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) jW);
        if (h.sY(cVar.bUt) != null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.bUt + " exist");
            return false;
        }
        com.baidu.swan.impl.map.item.c c = com.baidu.swan.impl.map.item.c.c(context, cVar);
        if (c == null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.bUt + " model is invalid");
            return false;
        }
        com.baidu.swan.apps.component.b.c Wm = c.Wm();
        if (!Wm.isSuccess()) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.bUt + " create fail: " + Wm.msg);
            return false;
        } else if (h.a(c)) {
            com.baidu.swan.apps.console.c.i("map", "map with id " + cVar.bUt + " init start");
            com.baidu.swan.impl.map.a.b.e.a(context, c, cVar, h);
            com.baidu.swan.apps.console.c.i("map", "map with id " + cVar.bUt + " init end");
            com.baidu.swan.apps.console.c.i("map", "map create end");
            return true;
        } else {
            return false;
        }
    }

    public boolean a(com.baidu.swan.apps.x.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map remove start");
        if (aj.lA(cVar.bUu) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e jW = f.ajb().jW(cVar.bUu);
        if (!(jW instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) jW);
        com.baidu.swan.impl.map.item.c sY = h.sY(cVar.bUt);
        if (sY == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.bUt + " not exist");
            return false;
        } else if (h.remove(cVar.bUt)) {
            com.baidu.swan.apps.console.c.i("map", "map remove end");
            if (com.baidu.swan.apps.component.container.a.d(cVar) == null) {
                com.baidu.swan.apps.component.e.a.aU("map", "remove with a null map component");
            }
            com.baidu.swan.apps.component.b.c Wo = sY.Wo();
            boolean isSuccess = Wo.isSuccess();
            if (!isSuccess) {
                com.baidu.swan.apps.console.c.e(TAG, "map remove fail: " + Wo.msg);
                return isSuccess;
            }
            return isSuccess;
        } else {
            return false;
        }
    }

    public boolean b(Context context, com.baidu.swan.apps.x.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map update start");
        if (aj.lA(cVar.bUu) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e jW = f.ajb().jW(cVar.bUu);
        if (jW == null || !(jW instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) jW);
        com.baidu.swan.impl.map.item.c sY = h.sY(cVar.bUt);
        if (sY == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.bUt + " not exist");
            return false;
        }
        sY.clear();
        com.baidu.swan.impl.map.a.b.e.a(context, sY, cVar, h, true);
        com.baidu.swan.apps.console.c.i("map", "map update end");
        if (com.baidu.swan.apps.component.container.a.d(cVar) == null) {
            com.baidu.swan.apps.component.e.a.aU("map", "update with a null map component");
        }
        com.baidu.swan.apps.component.b.c a = sY.a((com.baidu.swan.impl.map.item.c) cVar);
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
            bVar = this.dkq.get(cVar);
            if (bVar == null) {
                bVar = new b();
                this.dkq.put(cVar, bVar);
            }
        }
        return bVar;
    }

    private synchronized void i(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (cVar != null) {
            b remove = this.dkq.remove(cVar);
            if (remove != null) {
                remove.release();
            }
        }
    }
}
