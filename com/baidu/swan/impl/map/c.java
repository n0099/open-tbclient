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
    private static volatile c ecF;
    private Map<com.baidu.swan.apps.adaptation.b.c, b> ecG;

    private c() {
        a.aZc();
        this.ecG = new HashMap();
    }

    public static c aZj() {
        if (ecF == null) {
            synchronized (c.class) {
                if (ecF == null) {
                    ecF = new c();
                }
            }
        }
        return ecF;
    }

    public static void c(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (ecF != null) {
                ecF.h(cVar).resume();
            }
        }
    }

    public static void d(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (ecF != null) {
                ecF.h(cVar).pause();
            }
        }
    }

    public static void e(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (ecF != null) {
                ecF.i(cVar);
            } else if (DEBUG) {
                Log.v(TAG, "未初始化，无需执行release");
            }
        }
    }

    public boolean a(Context context, com.baidu.swan.apps.w.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map create start");
        if (ak.pN(cVar.cDL) == null || !cVar.isValid()) {
            com.baidu.swan.apps.console.c.e("map", "model data is invalid");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e nH = f.azO().nH(cVar.cDL);
        if (!(nH instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) nH);
        if (h.ye(cVar.cDK) != null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.cDK + " exist");
            return false;
        }
        com.baidu.swan.impl.map.item.c c = com.baidu.swan.impl.map.item.c.c(context, cVar);
        if (c == null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.cDK + " model is invalid");
            return false;
        }
        com.baidu.swan.apps.component.b.c akN = c.akN();
        if (!akN.isSuccess()) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.cDK + " create fail: " + akN.msg);
            return false;
        } else if (h.a(c)) {
            com.baidu.swan.apps.console.c.i("map", "map with id " + cVar.cDK + " init start");
            com.baidu.swan.impl.map.a.b.e.a(context, c, cVar, h);
            com.baidu.swan.apps.console.c.i("map", "map with id " + cVar.cDK + " init end");
            com.baidu.swan.apps.console.c.i("map", "map create end");
            return true;
        } else {
            return false;
        }
    }

    public boolean a(com.baidu.swan.apps.w.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map remove start");
        if (ak.pN(cVar.cDL) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e nH = f.azO().nH(cVar.cDL);
        if (!(nH instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) nH);
        com.baidu.swan.impl.map.item.c ye = h.ye(cVar.cDK);
        if (ye == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.cDK + " not exist");
            return false;
        } else if (h.remove(cVar.cDK)) {
            com.baidu.swan.apps.console.c.i("map", "map remove end");
            if (com.baidu.swan.apps.component.container.a.d(cVar) == null) {
                com.baidu.swan.apps.component.e.a.bm("map", "remove with a null map component");
            }
            com.baidu.swan.apps.component.b.c akP = ye.akP();
            boolean isSuccess = akP.isSuccess();
            if (!isSuccess) {
                com.baidu.swan.apps.console.c.e(TAG, "map remove fail: " + akP.msg);
                return isSuccess;
            }
            return isSuccess;
        } else {
            return false;
        }
    }

    public boolean b(Context context, com.baidu.swan.apps.w.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map update start");
        if (ak.pN(cVar.cDL) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e nH = f.azO().nH(cVar.cDL);
        if (nH == null || !(nH instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) nH);
        com.baidu.swan.impl.map.item.c ye = h.ye(cVar.cDK);
        if (ye == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.cDK + " not exist");
            return false;
        }
        ye.clear();
        com.baidu.swan.impl.map.a.b.e.a(context, ye, cVar, h, true);
        com.baidu.swan.apps.console.c.i("map", "map update end");
        if (com.baidu.swan.apps.component.container.a.d(cVar) == null) {
            com.baidu.swan.apps.component.e.a.bm("map", "update with a null map component");
        }
        com.baidu.swan.apps.component.b.c a2 = ye.a((com.baidu.swan.impl.map.item.c) cVar);
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
            bVar = this.ecG.get(cVar);
            if (bVar == null) {
                bVar = new b();
                this.ecG.put(cVar, bVar);
            }
        }
        return bVar;
    }

    private synchronized void i(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (cVar != null) {
            b remove = this.ecG.remove(cVar);
            if (remove != null) {
                remove.release();
            }
        }
    }
}
