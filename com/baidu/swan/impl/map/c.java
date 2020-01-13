package com.baidu.swan.impl.map;

import android.content.Context;
import android.util.Log;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.y.f;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = c.class.getSimpleName();
    private static volatile c crm;
    private Map<com.baidu.swan.apps.adaptation.b.c, b> crn;

    private c() {
        a.ape();
        this.crn = new HashMap();
    }

    public static c apm() {
        if (crm == null) {
            synchronized (c.class) {
                if (crm == null) {
                    crm = new c();
                }
            }
        }
        return crm;
    }

    public static void c(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (crm != null) {
                crm.h(cVar).resume();
            }
        }
    }

    public static void d(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (crm != null) {
                crm.h(cVar).pause();
            }
        }
    }

    public static void e(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (crm != null) {
                crm.i(cVar);
            } else if (DEBUG) {
                Log.v(TAG, "未初始化，无需执行release");
            }
        }
    }

    public boolean a(Context context, com.baidu.swan.apps.z.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map create start");
        if (ai.iE(cVar.bdW) == null || !cVar.isValid()) {
            com.baidu.swan.apps.console.c.e("map", "model data is invalid");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e hg = f.UC().hg(cVar.bdW);
        if (!(hg instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) hg);
        if (h.pL(cVar.bdV) != null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.bdV + " exist");
            return false;
        }
        com.baidu.swan.impl.map.item.c c = com.baidu.swan.impl.map.item.c.c(context, cVar);
        if (c == null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.bdV + " model is invalid");
            return false;
        }
        com.baidu.swan.apps.component.b.c Io = c.Io();
        if (!Io.isSuccess()) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.bdV + " create fail: " + Io.msg);
            return false;
        } else if (h.a(c)) {
            com.baidu.swan.apps.console.c.i("map", "map with id " + cVar.bdV + " init start");
            com.baidu.swan.impl.map.a.b.e.a(context, c, cVar, h);
            com.baidu.swan.apps.console.c.i("map", "map with id " + cVar.bdV + " init end");
            com.baidu.swan.apps.console.c.i("map", "map create end");
            return true;
        } else {
            return false;
        }
    }

    public boolean a(com.baidu.swan.apps.z.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map remove start");
        if (ai.iE(cVar.bdW) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e hg = f.UC().hg(cVar.bdW);
        if (!(hg instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) hg);
        com.baidu.swan.impl.map.item.c pL = h.pL(cVar.bdV);
        if (pL == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.bdV + " not exist");
            return false;
        } else if (h.remove(cVar.bdV)) {
            com.baidu.swan.apps.console.c.i("map", "map remove end");
            if (com.baidu.swan.apps.component.container.a.d(cVar) == null) {
                com.baidu.swan.apps.component.e.a.ak("map", "remove with a null map component");
            }
            com.baidu.swan.apps.component.b.c Iq = pL.Iq();
            boolean isSuccess = Iq.isSuccess();
            if (!isSuccess) {
                com.baidu.swan.apps.console.c.e(TAG, "map remove fail: " + Iq.msg);
                return isSuccess;
            }
            return isSuccess;
        } else {
            return false;
        }
    }

    public boolean b(Context context, com.baidu.swan.apps.z.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map update start");
        if (ai.iE(cVar.bdW) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e hg = f.UC().hg(cVar.bdW);
        if (hg == null || !(hg instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) hg);
        com.baidu.swan.impl.map.item.c pL = h.pL(cVar.bdV);
        if (pL == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.bdV + " not exist");
            return false;
        }
        pL.clear();
        com.baidu.swan.impl.map.a.b.e.a(context, pL, cVar, h, true);
        com.baidu.swan.apps.console.c.i("map", "map update end");
        if (com.baidu.swan.apps.component.container.a.d(cVar) == null) {
            com.baidu.swan.apps.component.e.a.ak("map", "update with a null map component");
        }
        com.baidu.swan.apps.component.b.c a = pL.a((com.baidu.swan.impl.map.item.c) cVar);
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
            bVar = this.crn.get(cVar);
            if (bVar == null) {
                bVar = new b();
                this.crn.put(cVar, bVar);
            }
        }
        return bVar;
    }

    private synchronized void i(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (cVar != null) {
            b remove = this.crn.remove(cVar);
            if (remove != null) {
                remove.release();
            }
        }
    }
}
