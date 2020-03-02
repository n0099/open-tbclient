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
    private static volatile c cvp;
    private Map<com.baidu.swan.apps.adaptation.b.c, b> cvq;

    private c() {
        a.aru();
        this.cvq = new HashMap();
    }

    public static c arB() {
        if (cvp == null) {
            synchronized (c.class) {
                if (cvp == null) {
                    cvp = new c();
                }
            }
        }
        return cvp;
    }

    public static void c(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (cvp != null) {
                cvp.h(cVar).resume();
            }
        }
    }

    public static void d(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (cvp != null) {
                cvp.h(cVar).pause();
            }
        }
    }

    public static void e(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (cvp != null) {
                cvp.i(cVar);
            } else if (DEBUG) {
                Log.v(TAG, "未初始化，无需执行release");
            }
        }
    }

    public boolean a(Context context, com.baidu.swan.apps.z.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map create start");
        if (ai.iT(cVar.bim) == null || !cVar.isValid()) {
            com.baidu.swan.apps.console.c.e("map", "model data is invalid");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e hv = f.WS().hv(cVar.bim);
        if (!(hv instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) hv);
        if (h.qa(cVar.bil) != null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.bil + " exist");
            return false;
        }
        com.baidu.swan.impl.map.item.c c = com.baidu.swan.impl.map.item.c.c(context, cVar);
        if (c == null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.bil + " model is invalid");
            return false;
        }
        com.baidu.swan.apps.component.b.c KF = c.KF();
        if (!KF.isSuccess()) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.bil + " create fail: " + KF.msg);
            return false;
        } else if (h.a(c)) {
            com.baidu.swan.apps.console.c.i("map", "map with id " + cVar.bil + " init start");
            com.baidu.swan.impl.map.a.b.e.a(context, c, cVar, h);
            com.baidu.swan.apps.console.c.i("map", "map with id " + cVar.bil + " init end");
            com.baidu.swan.apps.console.c.i("map", "map create end");
            return true;
        } else {
            return false;
        }
    }

    public boolean a(com.baidu.swan.apps.z.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map remove start");
        if (ai.iT(cVar.bim) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e hv = f.WS().hv(cVar.bim);
        if (!(hv instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) hv);
        com.baidu.swan.impl.map.item.c qa = h.qa(cVar.bil);
        if (qa == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.bil + " not exist");
            return false;
        } else if (h.remove(cVar.bil)) {
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
        if (ai.iT(cVar.bim) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e hv = f.WS().hv(cVar.bim);
        if (hv == null || !(hv instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) hv);
        com.baidu.swan.impl.map.item.c qa = h.qa(cVar.bil);
        if (qa == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.bil + " not exist");
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
            bVar = this.cvq.get(cVar);
            if (bVar == null) {
                bVar = new b();
                this.cvq.put(cVar, bVar);
            }
        }
        return bVar;
    }

    private synchronized void i(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (cVar != null) {
            b remove = this.cvq.remove(cVar);
            if (remove != null) {
                remove.release();
            }
        }
    }
}
