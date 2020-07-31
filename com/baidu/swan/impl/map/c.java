package com.baidu.swan.impl.map;

import android.content.Context;
import android.util.Log;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.v.f;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes19.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static final String TAG = c.class.getSimpleName();
    private static volatile c dqj;
    private Map<com.baidu.swan.apps.adaptation.b.c, b> dqk;

    private c() {
        a.aIx();
        this.dqk = new HashMap();
    }

    public static c aIE() {
        if (dqj == null) {
            synchronized (c.class) {
                if (dqj == null) {
                    dqj = new c();
                }
            }
        }
        return dqj;
    }

    public static void c(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (dqj != null) {
                dqj.h(cVar).resume();
            }
        }
    }

    public static void d(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (dqj != null) {
                dqj.h(cVar).pause();
            }
        }
    }

    public static void e(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (dqj != null) {
                dqj.i(cVar);
            } else if (DEBUG) {
                Log.v(TAG, "未初始化，无需执行release");
            }
        }
    }

    public boolean a(Context context, com.baidu.swan.apps.w.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map create start");
        if (al.mb(cVar.bVm) == null || !cVar.isValid()) {
            com.baidu.swan.apps.console.c.e("map", "model data is invalid");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e kq = f.akr().kq(cVar.bVm);
        if (!(kq instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) kq);
        if (h.ub(cVar.bVl) != null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.bVl + " exist");
            return false;
        }
        com.baidu.swan.impl.map.item.c c = com.baidu.swan.impl.map.item.c.c(context, cVar);
        if (c == null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.bVl + " model is invalid");
            return false;
        }
        com.baidu.swan.apps.component.b.c WT = c.WT();
        if (!WT.isSuccess()) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.bVl + " create fail: " + WT.msg);
            return false;
        } else if (h.a(c)) {
            com.baidu.swan.apps.console.c.i("map", "map with id " + cVar.bVl + " init start");
            com.baidu.swan.impl.map.a.b.e.a(context, c, cVar, h);
            com.baidu.swan.apps.console.c.i("map", "map with id " + cVar.bVl + " init end");
            com.baidu.swan.apps.console.c.i("map", "map create end");
            return true;
        } else {
            return false;
        }
    }

    public boolean a(com.baidu.swan.apps.w.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map remove start");
        if (al.mb(cVar.bVm) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e kq = f.akr().kq(cVar.bVm);
        if (!(kq instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) kq);
        com.baidu.swan.impl.map.item.c ub = h.ub(cVar.bVl);
        if (ub == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.bVl + " not exist");
            return false;
        } else if (h.remove(cVar.bVl)) {
            com.baidu.swan.apps.console.c.i("map", "map remove end");
            if (com.baidu.swan.apps.component.container.a.d(cVar) == null) {
                com.baidu.swan.apps.component.e.a.aV("map", "remove with a null map component");
            }
            com.baidu.swan.apps.component.b.c WV = ub.WV();
            boolean isSuccess = WV.isSuccess();
            if (!isSuccess) {
                com.baidu.swan.apps.console.c.e(TAG, "map remove fail: " + WV.msg);
                return isSuccess;
            }
            return isSuccess;
        } else {
            return false;
        }
    }

    public boolean b(Context context, com.baidu.swan.apps.w.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map update start");
        if (al.mb(cVar.bVm) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e kq = f.akr().kq(cVar.bVm);
        if (kq == null || !(kq instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) kq);
        com.baidu.swan.impl.map.item.c ub = h.ub(cVar.bVl);
        if (ub == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.bVl + " not exist");
            return false;
        }
        ub.clear();
        com.baidu.swan.impl.map.a.b.e.a(context, ub, cVar, h, true);
        com.baidu.swan.apps.console.c.i("map", "map update end");
        if (com.baidu.swan.apps.component.container.a.d(cVar) == null) {
            com.baidu.swan.apps.component.e.a.aV("map", "update with a null map component");
        }
        com.baidu.swan.apps.component.b.c a = ub.a((com.baidu.swan.impl.map.item.c) cVar);
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
            bVar = this.dqk.get(cVar);
            if (bVar == null) {
                bVar = new b();
                this.dqk.put(cVar, bVar);
            }
        }
        return bVar;
    }

    private synchronized void i(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (cVar != null) {
            b remove = this.dqk.remove(cVar);
            if (remove != null) {
                remove.release();
            }
        }
    }
}
