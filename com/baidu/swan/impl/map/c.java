package com.baidu.swan.impl.map;

import android.content.Context;
import android.util.Log;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.v.f;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = c.class.getSimpleName();
    private static volatile c eow;
    private Map<com.baidu.swan.apps.adaptation.b.c, b> eox;

    private c() {
        a.bam();
        this.eox = new HashMap();
    }

    public static c bat() {
        if (eow == null) {
            synchronized (c.class) {
                if (eow == null) {
                    eow = new c();
                }
            }
        }
        return eow;
    }

    public static void c(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (eow != null) {
                eow.h(cVar).resume();
            }
        }
    }

    public static void d(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (eow != null) {
                eow.h(cVar).pause();
            }
        }
    }

    public static void e(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (eow != null) {
                eow.i(cVar);
            } else if (DEBUG) {
                Log.v(TAG, "未初始化，无需执行release");
            }
        }
    }

    public boolean a(Context context, com.baidu.swan.apps.w.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map create start");
        if (ak.po(cVar.cLr) == null || !cVar.isValid()) {
            com.baidu.swan.apps.console.c.e("map", "model data is invalid");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e ni = f.aAl().ni(cVar.cLr);
        if (!(ni instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) ni);
        if (h.xN(cVar.cLq) != null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.cLq + " exist");
            return false;
        }
        com.baidu.swan.impl.map.item.c c = com.baidu.swan.impl.map.item.c.c(context, cVar);
        if (c == null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.cLq + " model is invalid");
            return false;
        }
        com.baidu.swan.apps.component.b.c alb = c.alb();
        if (!alb.isSuccess()) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.cLq + " create fail: " + alb.msg);
            return false;
        } else if (h.a(c)) {
            com.baidu.swan.apps.console.c.i("map", "map with id " + cVar.cLq + " init start");
            com.baidu.swan.impl.map.a.b.e.a(context, c, cVar, h);
            com.baidu.swan.apps.console.c.i("map", "map with id " + cVar.cLq + " init end");
            com.baidu.swan.apps.console.c.i("map", "map create end");
            return true;
        } else {
            return false;
        }
    }

    public boolean a(com.baidu.swan.apps.w.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map remove start");
        if (ak.po(cVar.cLr) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e ni = f.aAl().ni(cVar.cLr);
        if (!(ni instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) ni);
        com.baidu.swan.impl.map.item.c xN = h.xN(cVar.cLq);
        if (xN == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.cLq + " not exist");
            return false;
        } else if (h.remove(cVar.cLq)) {
            com.baidu.swan.apps.console.c.i("map", "map remove end");
            if (com.baidu.swan.apps.component.container.a.d(cVar) == null) {
                com.baidu.swan.apps.component.e.a.bk("map", "remove with a null map component");
            }
            com.baidu.swan.apps.component.b.c ald = xN.ald();
            boolean isSuccess = ald.isSuccess();
            if (!isSuccess) {
                com.baidu.swan.apps.console.c.e(TAG, "map remove fail: " + ald.msg);
                return isSuccess;
            }
            return isSuccess;
        } else {
            return false;
        }
    }

    public boolean b(Context context, com.baidu.swan.apps.w.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map update start");
        if (ak.po(cVar.cLr) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e ni = f.aAl().ni(cVar.cLr);
        if (ni == null || !(ni instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) ni);
        com.baidu.swan.impl.map.item.c xN = h.xN(cVar.cLq);
        if (xN == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.cLq + " not exist");
            return false;
        }
        xN.clear();
        com.baidu.swan.impl.map.a.b.e.a(context, xN, cVar, h, true);
        com.baidu.swan.apps.console.c.i("map", "map update end");
        if (com.baidu.swan.apps.component.container.a.d(cVar) == null) {
            com.baidu.swan.apps.component.e.a.bk("map", "update with a null map component");
        }
        com.baidu.swan.apps.component.b.c a2 = xN.a((com.baidu.swan.impl.map.item.c) cVar);
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
            bVar = this.eox.get(cVar);
            if (bVar == null) {
                bVar = new b();
                this.eox.put(cVar, bVar);
            }
        }
        return bVar;
    }

    private synchronized void i(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (cVar != null) {
            b remove = this.eox.remove(cVar);
            if (remove != null) {
                remove.release();
            }
        }
    }
}
