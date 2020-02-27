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
    private static volatile c cvo;
    private Map<com.baidu.swan.apps.adaptation.b.c, b> cvp;

    private c() {
        a.ars();
        this.cvp = new HashMap();
    }

    public static c arz() {
        if (cvo == null) {
            synchronized (c.class) {
                if (cvo == null) {
                    cvo = new c();
                }
            }
        }
        return cvo;
    }

    public static void c(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (cvo != null) {
                cvo.h(cVar).resume();
            }
        }
    }

    public static void d(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (cvo != null) {
                cvo.h(cVar).pause();
            }
        }
    }

    public static void e(com.baidu.swan.apps.adaptation.b.c cVar) {
        synchronized (c.class) {
            if (cvo != null) {
                cvo.i(cVar);
            } else if (DEBUG) {
                Log.v(TAG, "未初始化，无需执行release");
            }
        }
    }

    public boolean a(Context context, com.baidu.swan.apps.z.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map create start");
        if (ai.iT(cVar.bil) == null || !cVar.isValid()) {
            com.baidu.swan.apps.console.c.e("map", "model data is invalid");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e hv = f.WQ().hv(cVar.bil);
        if (!(hv instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) hv);
        if (h.qa(cVar.bik) != null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.bik + " exist");
            return false;
        }
        com.baidu.swan.impl.map.item.c c = com.baidu.swan.impl.map.item.c.c(context, cVar);
        if (c == null) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.bik + " model is invalid");
            return false;
        }
        com.baidu.swan.apps.component.b.c KD = c.KD();
        if (!KD.isSuccess()) {
            com.baidu.swan.apps.console.c.e("map", "map with id " + cVar.bik + " create fail: " + KD.msg);
            return false;
        } else if (h.a(c)) {
            com.baidu.swan.apps.console.c.i("map", "map with id " + cVar.bik + " init start");
            com.baidu.swan.impl.map.a.b.e.a(context, c, cVar, h);
            com.baidu.swan.apps.console.c.i("map", "map with id " + cVar.bik + " init end");
            com.baidu.swan.apps.console.c.i("map", "map create end");
            return true;
        } else {
            return false;
        }
    }

    public boolean a(com.baidu.swan.apps.z.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map remove start");
        if (ai.iT(cVar.bil) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e hv = f.WQ().hv(cVar.bil);
        if (!(hv instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) hv);
        com.baidu.swan.impl.map.item.c qa = h.qa(cVar.bik);
        if (qa == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.bik + " not exist");
            return false;
        } else if (h.remove(cVar.bik)) {
            com.baidu.swan.apps.console.c.i("map", "map remove end");
            if (com.baidu.swan.apps.component.container.a.d(cVar) == null) {
                com.baidu.swan.apps.component.e.a.au("map", "remove with a null map component");
            }
            com.baidu.swan.apps.component.b.c KF = qa.KF();
            boolean isSuccess = KF.isSuccess();
            if (!isSuccess) {
                com.baidu.swan.apps.console.c.e(TAG, "map remove fail: " + KF.msg);
                return isSuccess;
            }
            return isSuccess;
        } else {
            return false;
        }
    }

    public boolean b(Context context, com.baidu.swan.apps.z.a.c cVar) {
        com.baidu.swan.apps.console.c.i("map", "map update start");
        if (ai.iT(cVar.bil) == null) {
            com.baidu.swan.apps.console.c.e("map", "webView is null or mapModel is null");
            return false;
        }
        com.baidu.swan.apps.adaptation.b.e hv = f.WQ().hv(cVar.bil);
        if (hv == null || !(hv instanceof com.baidu.swan.apps.adaptation.b.c)) {
            com.baidu.swan.apps.console.c.e("map", "WebViewManager is null");
            return false;
        }
        b h = h((com.baidu.swan.apps.adaptation.b.c) hv);
        com.baidu.swan.impl.map.item.c qa = h.qa(cVar.bik);
        if (qa == null) {
            com.baidu.swan.apps.console.c.e("map", "remove map with id " + cVar.bik + " not exist");
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
            bVar = this.cvp.get(cVar);
            if (bVar == null) {
                bVar = new b();
                this.cvp.put(cVar, bVar);
            }
        }
        return bVar;
    }

    private synchronized void i(com.baidu.swan.apps.adaptation.b.c cVar) {
        if (cVar != null) {
            b remove = this.cvp.remove(cVar);
            if (remove != null) {
                remove.release();
            }
        }
    }
}
