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
    private static volatile c cvB;
    private Map<com.baidu.swan.apps.adaptation.b.c, b> cvC;

    private c() {
        a.arx();
        this.cvC = new HashMap();
    }

    public static c arE() {
        if (cvB == null) {
            synchronized (c.class) {
                if (cvB == null) {
                    cvB = new c();
                }
            }
        }
        return cvB;
    }

    public static void c(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (cvB != null) {
                cvB.h(cVar).resume();
            }
        }
    }

    public static void d(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (cvB != null) {
                cvB.h(cVar).pause();
            }
        }
    }

    public static void e(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (cvB != null) {
                cvB.i(cVar);
            } else if (DEBUG) {
                Log.v(TAG, "未初始化，无需执行release");
            }
        }
    }

    public boolean a(Context context, com.baidu.swan.apps.z.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map create start");
        if (ai.iS(cVar.biB) == null || !cVar.isValid()) {
            com.baidu.swan.apps.console.c.e("map", "model data is invalid");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e hu = f.WV().hu(cVar.biB);
        if (!(hu instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) hu);
        if (h.pZ(cVar.biA) != null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.biA + " exist");
            return false;
        }
        com.baidu.swan.impl.map.item.c c = com.baidu.swan.impl.map.item.c.c(context, cVar);
        if (c == null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.biA + " model is invalid");
            return false;
        }
        com.baidu.swan.apps.component.b.c KI = c.KI();
        if (!KI.isSuccess()) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.biA + " create fail: " + KI.msg);
            return false;
        } else if (h.a(c)) {
            com.baidu.swan.apps.console.c.i("map", "map with id " + cVar.biA + " init start");
            com.baidu.swan.impl.map.a.b.e.a(context, c, cVar, h);
            com.baidu.swan.apps.console.c.i("map", "map with id " + cVar.biA + " init end");
            com.baidu.swan.apps.console.c.i("map", "map create end");
            return true;
        } else {
            return false;
        }
    }

    public boolean a(com.baidu.swan.apps.z.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map remove start");
        if (ai.iS(cVar.biB) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e hu = f.WV().hu(cVar.biB);
        if (!(hu instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) hu);
        com.baidu.swan.impl.map.item.c pZ = h.pZ(cVar.biA);
        if (pZ == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.biA + " not exist");
            return false;
        } else if (h.remove(cVar.biA)) {
            com.baidu.swan.apps.console.c.i("map", "map remove end");
            if (com.baidu.swan.apps.component.container.a.d(cVar) == null) {
                com.baidu.swan.apps.component.e.a.at("map", "remove with a null map component");
            }
            com.baidu.swan.apps.component.b.c KK = pZ.KK();
            boolean isSuccess = KK.isSuccess();
            if (!isSuccess) {
                com.baidu.swan.apps.console.c.e(TAG, "map remove fail: " + KK.msg);
                return isSuccess;
            }
            return isSuccess;
        } else {
            return false;
        }
    }

    public boolean b(Context context, com.baidu.swan.apps.z.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map update start");
        if (ai.iS(cVar.biB) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e hu = f.WV().hu(cVar.biB);
        if (hu == null || !(hu instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) hu);
        com.baidu.swan.impl.map.item.c pZ = h.pZ(cVar.biA);
        if (pZ == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.biA + " not exist");
            return false;
        }
        pZ.clear();
        com.baidu.swan.impl.map.a.b.e.a(context, pZ, cVar, h, true);
        com.baidu.swan.apps.console.c.i("map", "map update end");
        if (com.baidu.swan.apps.component.container.a.d(cVar) == null) {
            com.baidu.swan.apps.component.e.a.at("map", "update with a null map component");
        }
        com.baidu.swan.apps.component.b.c a = pZ.a((com.baidu.swan.impl.map.item.c) cVar);
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
            bVar = this.cvC.get(cVar);
            if (bVar == null) {
                bVar = new b();
                this.cvC.put(cVar, bVar);
            }
        }
        return bVar;
    }

    private synchronized void i(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (cVar != null) {
            b remove = this.cvC.remove(cVar);
            if (remove != null) {
                remove.release();
            }
        }
    }
}
