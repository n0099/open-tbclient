package com.baidu.swan.impl.map;

import android.content.Context;
import android.util.Log;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.v.f;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes24.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = c.class.getSimpleName();
    private static volatile c dCq;
    private Map<com.baidu.swan.apps.adaptation.b.c, b> dCr;

    private c() {
        a.aRZ();
        this.dCr = new HashMap();
    }

    public static c aSg() {
        if (dCq == null) {
            synchronized (c.class) {
                if (dCq == null) {
                    dCq = new c();
                }
            }
        }
        return dCq;
    }

    public static void c(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (dCq != null) {
                dCq.h(cVar).resume();
            }
        }
    }

    public static void d(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (dCq != null) {
                dCq.h(cVar).pause();
            }
        }
    }

    public static void e(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (dCq != null) {
                dCq.i(cVar);
            } else if (DEBUG) {
                Log.v(TAG, "未初始化，无需执行release");
            }
        }
    }

    public boolean a(Context context, com.baidu.swan.apps.w.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map create start");
        if (ak.ou(cVar.cda) == null || !cVar.isValid()) {
            com.baidu.swan.apps.console.c.e("map", "model data is invalid");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e mn = f.asJ().mn(cVar.cda);
        if (!(mn instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) mn);
        if (h.wL(cVar.ccZ) != null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.ccZ + " exist");
            return false;
        }
        com.baidu.swan.impl.map.item.c c = com.baidu.swan.impl.map.item.c.c(context, cVar);
        if (c == null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.ccZ + " model is invalid");
            return false;
        }
        com.baidu.swan.apps.component.b.c adI = c.adI();
        if (!adI.isSuccess()) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.ccZ + " create fail: " + adI.msg);
            return false;
        } else if (h.a(c)) {
            com.baidu.swan.apps.console.c.i("map", "map with id " + cVar.ccZ + " init start");
            com.baidu.swan.impl.map.a.b.e.a(context, c, cVar, h);
            com.baidu.swan.apps.console.c.i("map", "map with id " + cVar.ccZ + " init end");
            com.baidu.swan.apps.console.c.i("map", "map create end");
            return true;
        } else {
            return false;
        }
    }

    public boolean a(com.baidu.swan.apps.w.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map remove start");
        if (ak.ou(cVar.cda) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e mn = f.asJ().mn(cVar.cda);
        if (!(mn instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) mn);
        com.baidu.swan.impl.map.item.c wL = h.wL(cVar.ccZ);
        if (wL == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.ccZ + " not exist");
            return false;
        } else if (h.remove(cVar.ccZ)) {
            com.baidu.swan.apps.console.c.i("map", "map remove end");
            if (com.baidu.swan.apps.component.container.a.d(cVar) == null) {
                com.baidu.swan.apps.component.e.a.ba("map", "remove with a null map component");
            }
            com.baidu.swan.apps.component.b.c adK = wL.adK();
            boolean isSuccess = adK.isSuccess();
            if (!isSuccess) {
                com.baidu.swan.apps.console.c.e(TAG, "map remove fail: " + adK.msg);
                return isSuccess;
            }
            return isSuccess;
        } else {
            return false;
        }
    }

    public boolean b(Context context, com.baidu.swan.apps.w.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map update start");
        if (ak.ou(cVar.cda) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e mn = f.asJ().mn(cVar.cda);
        if (mn == null || !(mn instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) mn);
        com.baidu.swan.impl.map.item.c wL = h.wL(cVar.ccZ);
        if (wL == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.ccZ + " not exist");
            return false;
        }
        wL.clear();
        com.baidu.swan.impl.map.a.b.e.a(context, wL, cVar, h, true);
        com.baidu.swan.apps.console.c.i("map", "map update end");
        if (com.baidu.swan.apps.component.container.a.d(cVar) == null) {
            com.baidu.swan.apps.component.e.a.ba("map", "update with a null map component");
        }
        com.baidu.swan.apps.component.b.c a = wL.a((com.baidu.swan.impl.map.item.c) cVar);
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
            bVar = this.dCr.get(cVar);
            if (bVar == null) {
                bVar = new b();
                this.dCr.put(cVar, bVar);
            }
        }
        return bVar;
    }

    private synchronized void i(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (cVar != null) {
            b remove = this.dCr.remove(cVar);
            if (remove != null) {
                remove.release();
            }
        }
    }
}
