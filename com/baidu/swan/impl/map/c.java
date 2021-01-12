package com.baidu.swan.impl.map;

import android.content.Context;
import android.util.Log;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.v.f;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = c.class.getSimpleName();
    private static volatile c emm;
    private Map<com.baidu.swan.apps.adaptation.b.c, b> emn;

    private c() {
        a.aZZ();
        this.emn = new HashMap();
    }

    public static c bag() {
        if (emm == null) {
            synchronized (c.class) {
                if (emm == null) {
                    emm = new c();
                }
            }
        }
        return emm;
    }

    public static void c(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (emm != null) {
                emm.h(cVar).resume();
            }
        }
    }

    public static void d(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (emm != null) {
                emm.h(cVar).pause();
            }
        }
    }

    public static void e(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (emm != null) {
                emm.i(cVar);
            } else if (DEBUG) {
                Log.v(TAG, "未初始化，无需执行release");
            }
        }
    }

    public boolean a(Context context, com.baidu.swan.apps.w.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map create start");
        if (ak.oW(cVar.cJd) == null || !cVar.isValid()) {
            com.baidu.swan.apps.console.c.e("map", "model data is invalid");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e mQ = f.azN().mQ(cVar.cJd);
        if (!(mQ instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) mQ);
        if (h.xu(cVar.cJc) != null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.cJc + " exist");
            return false;
        }
        com.baidu.swan.impl.map.item.c c = com.baidu.swan.impl.map.item.c.c(context, cVar);
        if (c == null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.cJc + " model is invalid");
            return false;
        }
        com.baidu.swan.apps.component.b.c akD = c.akD();
        if (!akD.isSuccess()) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.cJc + " create fail: " + akD.msg);
            return false;
        } else if (h.a(c)) {
            com.baidu.swan.apps.console.c.i("map", "map with id " + cVar.cJc + " init start");
            com.baidu.swan.impl.map.a.b.e.a(context, c, cVar, h);
            com.baidu.swan.apps.console.c.i("map", "map with id " + cVar.cJc + " init end");
            com.baidu.swan.apps.console.c.i("map", "map create end");
            return true;
        } else {
            return false;
        }
    }

    public boolean a(com.baidu.swan.apps.w.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map remove start");
        if (ak.oW(cVar.cJd) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e mQ = f.azN().mQ(cVar.cJd);
        if (!(mQ instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) mQ);
        com.baidu.swan.impl.map.item.c xu = h.xu(cVar.cJc);
        if (xu == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.cJc + " not exist");
            return false;
        } else if (h.remove(cVar.cJc)) {
            com.baidu.swan.apps.console.c.i("map", "map remove end");
            if (com.baidu.swan.apps.component.container.a.d(cVar) == null) {
                com.baidu.swan.apps.component.e.a.bq("map", "remove with a null map component");
            }
            com.baidu.swan.apps.component.b.c akF = xu.akF();
            boolean isSuccess = akF.isSuccess();
            if (!isSuccess) {
                com.baidu.swan.apps.console.c.e(TAG, "map remove fail: " + akF.msg);
                return isSuccess;
            }
            return isSuccess;
        } else {
            return false;
        }
    }

    public boolean b(Context context, com.baidu.swan.apps.w.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map update start");
        if (ak.oW(cVar.cJd) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e mQ = f.azN().mQ(cVar.cJd);
        if (mQ == null || !(mQ instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) mQ);
        com.baidu.swan.impl.map.item.c xu = h.xu(cVar.cJc);
        if (xu == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.cJc + " not exist");
            return false;
        }
        xu.clear();
        com.baidu.swan.impl.map.a.b.e.a(context, xu, cVar, h, true);
        com.baidu.swan.apps.console.c.i("map", "map update end");
        if (com.baidu.swan.apps.component.container.a.d(cVar) == null) {
            com.baidu.swan.apps.component.e.a.bq("map", "update with a null map component");
        }
        com.baidu.swan.apps.component.b.c a2 = xu.a((com.baidu.swan.impl.map.item.c) cVar);
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
            bVar = this.emn.get(cVar);
            if (bVar == null) {
                bVar = new b();
                this.emn.put(cVar, bVar);
            }
        }
        return bVar;
    }

    private synchronized void i(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (cVar != null) {
            b remove = this.emn.remove(cVar);
            if (remove != null) {
                remove.release();
            }
        }
    }
}
