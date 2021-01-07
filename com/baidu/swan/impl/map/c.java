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
    private static volatile c erb;
    private Map<com.baidu.swan.apps.adaptation.b.c, b> erc;

    private c() {
        a.bdT();
        this.erc = new HashMap();
    }

    public static c bea() {
        if (erb == null) {
            synchronized (c.class) {
                if (erb == null) {
                    erb = new c();
                }
            }
        }
        return erb;
    }

    public static void c(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (erb != null) {
                erb.h(cVar).resume();
            }
        }
    }

    public static void d(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (erb != null) {
                erb.h(cVar).pause();
            }
        }
    }

    public static void e(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (erb != null) {
                erb.i(cVar);
            } else if (DEBUG) {
                Log.v(TAG, "未初始化，无需执行release");
            }
        }
    }

    public boolean a(Context context, com.baidu.swan.apps.w.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map create start");
        if (ak.qh(cVar.cNP) == null || !cVar.isValid()) {
            com.baidu.swan.apps.console.c.e("map", "model data is invalid");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e ob = f.aDH().ob(cVar.cNP);
        if (!(ob instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) ob);
        if (h.yF(cVar.cNO) != null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.cNO + " exist");
            return false;
        }
        com.baidu.swan.impl.map.item.c c = com.baidu.swan.impl.map.item.c.c(context, cVar);
        if (c == null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.cNO + " model is invalid");
            return false;
        }
        com.baidu.swan.apps.component.b.c aox = c.aox();
        if (!aox.isSuccess()) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.cNO + " create fail: " + aox.msg);
            return false;
        } else if (h.a(c)) {
            com.baidu.swan.apps.console.c.i("map", "map with id " + cVar.cNO + " init start");
            com.baidu.swan.impl.map.a.b.e.a(context, c, cVar, h);
            com.baidu.swan.apps.console.c.i("map", "map with id " + cVar.cNO + " init end");
            com.baidu.swan.apps.console.c.i("map", "map create end");
            return true;
        } else {
            return false;
        }
    }

    public boolean a(com.baidu.swan.apps.w.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map remove start");
        if (ak.qh(cVar.cNP) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e ob = f.aDH().ob(cVar.cNP);
        if (!(ob instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) ob);
        com.baidu.swan.impl.map.item.c yF = h.yF(cVar.cNO);
        if (yF == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.cNO + " not exist");
            return false;
        } else if (h.remove(cVar.cNO)) {
            com.baidu.swan.apps.console.c.i("map", "map remove end");
            if (com.baidu.swan.apps.component.container.a.d(cVar) == null) {
                com.baidu.swan.apps.component.e.a.br("map", "remove with a null map component");
            }
            com.baidu.swan.apps.component.b.c aoz = yF.aoz();
            boolean isSuccess = aoz.isSuccess();
            if (!isSuccess) {
                com.baidu.swan.apps.console.c.e(TAG, "map remove fail: " + aoz.msg);
                return isSuccess;
            }
            return isSuccess;
        } else {
            return false;
        }
    }

    public boolean b(Context context, com.baidu.swan.apps.w.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map update start");
        if (ak.qh(cVar.cNP) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e ob = f.aDH().ob(cVar.cNP);
        if (ob == null || !(ob instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) ob);
        com.baidu.swan.impl.map.item.c yF = h.yF(cVar.cNO);
        if (yF == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.cNO + " not exist");
            return false;
        }
        yF.clear();
        com.baidu.swan.impl.map.a.b.e.a(context, yF, cVar, h, true);
        com.baidu.swan.apps.console.c.i("map", "map update end");
        if (com.baidu.swan.apps.component.container.a.d(cVar) == null) {
            com.baidu.swan.apps.component.e.a.br("map", "update with a null map component");
        }
        com.baidu.swan.apps.component.b.c a2 = yF.a((com.baidu.swan.impl.map.item.c) cVar);
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
            bVar = this.erc.get(cVar);
            if (bVar == null) {
                bVar = new b();
                this.erc.put(cVar, bVar);
            }
        }
        return bVar;
    }

    private synchronized void i(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (cVar != null) {
            b remove = this.erc.remove(cVar);
            if (remove != null) {
                remove.release();
            }
        }
    }
}
