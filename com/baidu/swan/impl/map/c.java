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
    private static volatile c cvq;
    private Map<com.baidu.swan.apps.adaptation.b.c, b> cvr;

    private c() {
        a.aru();
        this.cvr = new HashMap();
    }

    public static c arB() {
        if (cvq == null) {
            synchronized (c.class) {
                if (cvq == null) {
                    cvq = new c();
                }
            }
        }
        return cvq;
    }

    public static void c(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (cvq != null) {
                cvq.h(cVar).resume();
            }
        }
    }

    public static void d(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (cvq != null) {
                cvq.h(cVar).pause();
            }
        }
    }

    public static void e(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (cvq != null) {
                cvq.i(cVar);
            } else if (DEBUG) {
                Log.v(TAG, "未初始化，无需执行release");
            }
        }
    }

    public boolean a(Context context, com.baidu.swan.apps.z.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map create start");
        if (ai.iT(cVar.bin) == null || !cVar.isValid()) {
            com.baidu.swan.apps.console.c.e("map", "model data is invalid");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e hv = f.WS().hv(cVar.bin);
        if (!(hv instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) hv);
        if (h.qa(cVar.bim) != null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.bim + " exist");
            return false;
        }
        com.baidu.swan.impl.map.item.c c = com.baidu.swan.impl.map.item.c.c(context, cVar);
        if (c == null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.bim + " model is invalid");
            return false;
        }
        com.baidu.swan.apps.component.b.c KF = c.KF();
        if (!KF.isSuccess()) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.bim + " create fail: " + KF.msg);
            return false;
        } else if (h.a(c)) {
            com.baidu.swan.apps.console.c.i("map", "map with id " + cVar.bim + " init start");
            com.baidu.swan.impl.map.a.b.e.a(context, c, cVar, h);
            com.baidu.swan.apps.console.c.i("map", "map with id " + cVar.bim + " init end");
            com.baidu.swan.apps.console.c.i("map", "map create end");
            return true;
        } else {
            return false;
        }
    }

    public boolean a(com.baidu.swan.apps.z.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map remove start");
        if (ai.iT(cVar.bin) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e hv = f.WS().hv(cVar.bin);
        if (!(hv instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) hv);
        com.baidu.swan.impl.map.item.c qa = h.qa(cVar.bim);
        if (qa == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.bim + " not exist");
            return false;
        } else if (h.remove(cVar.bim)) {
            com.baidu.swan.apps.console.c.i("map", "map remove end");
            if (com.baidu.swan.apps.component.container.a.d(cVar) == null) {
                com.baidu.swan.apps.component.e.a.au("map", "remove with a null map component");
            }
            com.baidu.swan.apps.component.b.c KH = qa.KH();
            boolean isSuccess = KH.isSuccess();
            if (!isSuccess) {
                com.baidu.swan.apps.console.c.e(TAG, "map remove fail: " + KH.msg);
                return isSuccess;
            }
            return isSuccess;
        } else {
            return false;
        }
    }

    public boolean b(Context context, com.baidu.swan.apps.z.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map update start");
        if (ai.iT(cVar.bin) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e hv = f.WS().hv(cVar.bin);
        if (hv == null || !(hv instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) hv);
        com.baidu.swan.impl.map.item.c qa = h.qa(cVar.bim);
        if (qa == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.bim + " not exist");
            return false;
        }
        qa.clear();
        com.baidu.swan.impl.map.a.b.e.a(context, qa, cVar, h, true);
        com.baidu.swan.apps.console.c.i("map", "map update end");
        if (com.baidu.swan.apps.component.container.a.d(cVar) == null) {
            com.baidu.swan.apps.component.e.a.au("map", "update with a null map component");
        }
        com.baidu.swan.apps.component.b.c a = qa.a((com.baidu.swan.impl.map.item.c) cVar);
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
            bVar = this.cvr.get(cVar);
            if (bVar == null) {
                bVar = new b();
                this.cvr.put(cVar, bVar);
            }
        }
        return bVar;
    }

    private synchronized void i(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (cVar != null) {
            b remove = this.cvr.remove(cVar);
            if (remove != null) {
                remove.release();
            }
        }
    }
}
