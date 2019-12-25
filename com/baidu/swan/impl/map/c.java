package com.baidu.swan.impl.map;

import android.content.Context;
import android.util.Log;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.y.f;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = c.class.getSimpleName();
    private static volatile c cra;
    private Map<com.baidu.swan.apps.adaptation.b.c, b> crb;

    private c() {
        a.aoL();
        this.crb = new HashMap();
    }

    public static c aoS() {
        if (cra == null) {
            synchronized (c.class) {
                if (cra == null) {
                    cra = new c();
                }
            }
        }
        return cra;
    }

    public static void c(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (cra != null) {
                cra.h(cVar).resume();
            }
        }
    }

    public static void d(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (cra != null) {
                cra.h(cVar).pause();
            }
        }
    }

    public static void e(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (cra != null) {
                cra.i(cVar);
            } else if (DEBUG) {
                Log.v(TAG, "未初始化，无需执行release");
            }
        }
    }

    public boolean a(Context context, com.baidu.swan.apps.z.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map create start");
        if (ai.iB(cVar.bdi) == null || !cVar.isValid()) {
            com.baidu.swan.apps.console.c.e("map", "model data is invalid");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e hd = f.Uf().hd(cVar.bdi);
        if (!(hd instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) hd);
        if (h.pI(cVar.bdh) != null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.bdh + " exist");
            return false;
        }
        com.baidu.swan.impl.map.item.c c = com.baidu.swan.impl.map.item.c.c(context, cVar);
        if (c == null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.bdh + " model is invalid");
            return false;
        }
        com.baidu.swan.apps.component.b.c HS = c.HS();
        if (!HS.isSuccess()) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.bdh + " create fail: " + HS.msg);
            return false;
        } else if (h.a(c)) {
            com.baidu.swan.apps.console.c.i("map", "map with id " + cVar.bdh + " init start");
            com.baidu.swan.impl.map.a.b.e.a(context, c, cVar, h);
            com.baidu.swan.apps.console.c.i("map", "map with id " + cVar.bdh + " init end");
            com.baidu.swan.apps.console.c.i("map", "map create end");
            return true;
        } else {
            return false;
        }
    }

    public boolean a(com.baidu.swan.apps.z.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map remove start");
        if (ai.iB(cVar.bdi) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e hd = f.Uf().hd(cVar.bdi);
        if (!(hd instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) hd);
        com.baidu.swan.impl.map.item.c pI = h.pI(cVar.bdh);
        if (pI == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.bdh + " not exist");
            return false;
        } else if (h.remove(cVar.bdh)) {
            com.baidu.swan.apps.console.c.i("map", "map remove end");
            if (com.baidu.swan.apps.component.container.a.d(cVar) == null) {
                com.baidu.swan.apps.component.e.a.aj("map", "remove with a null map component");
            }
            com.baidu.swan.apps.component.b.c HU = pI.HU();
            boolean isSuccess = HU.isSuccess();
            if (!isSuccess) {
                com.baidu.swan.apps.console.c.e(TAG, "map remove fail: " + HU.msg);
                return isSuccess;
            }
            return isSuccess;
        } else {
            return false;
        }
    }

    public boolean b(Context context, com.baidu.swan.apps.z.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map update start");
        if (ai.iB(cVar.bdi) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e hd = f.Uf().hd(cVar.bdi);
        if (hd == null || !(hd instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) hd);
        com.baidu.swan.impl.map.item.c pI = h.pI(cVar.bdh);
        if (pI == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.bdh + " not exist");
            return false;
        }
        pI.clear();
        com.baidu.swan.impl.map.a.b.e.a(context, pI, cVar, h, true);
        com.baidu.swan.apps.console.c.i("map", "map update end");
        if (com.baidu.swan.apps.component.container.a.d(cVar) == null) {
            com.baidu.swan.apps.component.e.a.aj("map", "update with a null map component");
        }
        com.baidu.swan.apps.component.b.c a = pI.a((com.baidu.swan.impl.map.item.c) cVar);
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
            bVar = this.crb.get(cVar);
            if (bVar == null) {
                bVar = new b();
                this.crb.put(cVar, bVar);
            }
        }
        return bVar;
    }

    private synchronized void i(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (cVar != null) {
            b remove = this.crb.remove(cVar);
            if (remove != null) {
                remove.release();
            }
        }
    }
}
