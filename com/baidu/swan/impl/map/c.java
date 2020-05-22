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
    private static volatile c dfD;
    private Map<com.baidu.swan.apps.adaptation.b.c, b> dfE;

    private c() {
        a.aDA();
        this.dfE = new HashMap();
    }

    public static c aDH() {
        if (dfD == null) {
            synchronized (c.class) {
                if (dfD == null) {
                    dfD = new c();
                }
            }
        }
        return dfD;
    }

    public static void c(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (dfD != null) {
                dfD.h(cVar).resume();
            }
        }
    }

    public static void d(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (dfD != null) {
                dfD.h(cVar).pause();
            }
        }
    }

    public static void e(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (dfD != null) {
                dfD.i(cVar);
            } else if (DEBUG) {
                Log.v(TAG, "未初始化，无需执行release");
            }
        }
    }

    public boolean a(Context context, com.baidu.swan.apps.x.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map create start");
        if (aj.ls(cVar.bPG) == null || !cVar.isValid()) {
            com.baidu.swan.apps.console.c.e("map", "model data is invalid");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e jO = f.ahV().jO(cVar.bPG);
        if (!(jO instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) jO);
        if (h.sQ(cVar.bPF) != null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.bPF + " exist");
            return false;
        }
        com.baidu.swan.impl.map.item.c c = com.baidu.swan.impl.map.item.c.c(context, cVar);
        if (c == null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.bPF + " model is invalid");
            return false;
        }
        com.baidu.swan.apps.component.b.c Vg = c.Vg();
        if (!Vg.isSuccess()) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.bPF + " create fail: " + Vg.msg);
            return false;
        } else if (h.a(c)) {
            com.baidu.swan.apps.console.c.i("map", "map with id " + cVar.bPF + " init start");
            com.baidu.swan.impl.map.a.b.e.a(context, c, cVar, h);
            com.baidu.swan.apps.console.c.i("map", "map with id " + cVar.bPF + " init end");
            com.baidu.swan.apps.console.c.i("map", "map create end");
            return true;
        } else {
            return false;
        }
    }

    public boolean a(com.baidu.swan.apps.x.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map remove start");
        if (aj.ls(cVar.bPG) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e jO = f.ahV().jO(cVar.bPG);
        if (!(jO instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) jO);
        com.baidu.swan.impl.map.item.c sQ = h.sQ(cVar.bPF);
        if (sQ == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.bPF + " not exist");
            return false;
        } else if (h.remove(cVar.bPF)) {
            com.baidu.swan.apps.console.c.i("map", "map remove end");
            if (com.baidu.swan.apps.component.container.a.d(cVar) == null) {
                com.baidu.swan.apps.component.e.a.aS("map", "remove with a null map component");
            }
            com.baidu.swan.apps.component.b.c Vi = sQ.Vi();
            boolean isSuccess = Vi.isSuccess();
            if (!isSuccess) {
                com.baidu.swan.apps.console.c.e(TAG, "map remove fail: " + Vi.msg);
                return isSuccess;
            }
            return isSuccess;
        } else {
            return false;
        }
    }

    public boolean b(Context context, com.baidu.swan.apps.x.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map update start");
        if (aj.ls(cVar.bPG) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e jO = f.ahV().jO(cVar.bPG);
        if (jO == null || !(jO instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) jO);
        com.baidu.swan.impl.map.item.c sQ = h.sQ(cVar.bPF);
        if (sQ == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.bPF + " not exist");
            return false;
        }
        sQ.clear();
        com.baidu.swan.impl.map.a.b.e.a(context, sQ, cVar, h, true);
        com.baidu.swan.apps.console.c.i("map", "map update end");
        if (com.baidu.swan.apps.component.container.a.d(cVar) == null) {
            com.baidu.swan.apps.component.e.a.aS("map", "update with a null map component");
        }
        com.baidu.swan.apps.component.b.c a = sQ.a((com.baidu.swan.impl.map.item.c) cVar);
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
            bVar = this.dfE.get(cVar);
            if (bVar == null) {
                bVar = new b();
                this.dfE.put(cVar, bVar);
            }
        }
        return bVar;
    }

    private synchronized void i(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (cVar != null) {
            b remove = this.dfE.remove(cVar);
            if (remove != null) {
                remove.release();
            }
        }
    }
}
