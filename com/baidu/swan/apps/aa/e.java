package com.baidu.swan.apps.aa;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Log;
import android.widget.AbsoluteLayout;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.aa.b.a;
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.n;
import com.baidu.swan.apps.v.b.b;
/* loaded from: classes11.dex */
public final class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile String cuh = "";
    private static volatile boolean cui = true;

    public static void alp() {
    }

    public static void ex(boolean z) {
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "on swan page change, isFromRoute : " + z);
        }
        if (z && com.baidu.swan.apps.statistic.e.asu()) {
            if (DEBUG) {
                Log.d("SwanArrivalMonitor", "end handle swan page change");
                return;
            }
            return;
        }
        if (z) {
            cui = false;
        }
        if (!z) {
            als();
        }
        com.baidu.swan.apps.statistic.e.asn();
        alr();
        com.baidu.swan.apps.runtime.e apM = com.baidu.swan.apps.runtime.e.apM();
        if (apM != null && !z) {
            com.baidu.swan.apps.statistic.e.a(apM.RP());
        }
    }

    public static void alq() {
        cuh = "";
        cui = true;
    }

    public static void mk(String str) {
        cuh = str;
    }

    public static boolean f(com.baidu.swan.apps.core.d.d dVar) {
        if (dVar == null) {
            return false;
        }
        boolean equals = TextUtils.equals(cuh, dVar.ZH());
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "FirstPage: " + equals);
            return equals;
        }
        return equals;
    }

    private static void alr() {
        com.baidu.swan.apps.core.d.e RN;
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "start handle arrival report");
        }
        if (!com.baidu.swan.apps.statistic.e.ast() && (RN = com.baidu.swan.apps.w.f.ajb().RN()) != null) {
            com.baidu.swan.apps.core.d.d ZW = RN.ZW();
            com.baidu.swan.apps.adaptation.b.a.d dVar = null;
            if (ZW != null) {
                com.baidu.swan.apps.adaptation.b.c ZM = ZW.ZM();
                if (ZM != null) {
                    com.baidu.swan.apps.adaptation.b.f Uh = ZM.Uh();
                    if (Uh != null) {
                        dVar = Uh.Um();
                    } else {
                        dVar = ZM.Um();
                    }
                } else {
                    return;
                }
            }
            if (dVar != null && dVar.bMF > 0) {
                com.baidu.swan.apps.statistic.e.a(dVar);
            }
        }
    }

    private static void als() {
        if (!com.baidu.swan.apps.statistic.e.ass()) {
            com.baidu.swan.apps.core.d.d ZW = com.baidu.swan.apps.w.f.ajb().ZW();
            if (ZW == null) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "NAArrival：top fragment is null");
                }
            } else if (!f(ZW)) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start na report");
                }
                alt();
            } else {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start check for na arrival");
                }
                ml(ZW.ZH());
            }
        }
    }

    private static void ml(final String str) {
        aj.p(new Runnable() { // from class: com.baidu.swan.apps.aa.e.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.core.d.e RN;
                com.baidu.swan.apps.core.d.d ZW;
                SwanAppActivity aiL = com.baidu.swan.apps.w.f.ajb().aiL();
                if (aiL != null && !aiL.isFinishing() && !aiL.isDestroyed() && (RN = aiL.RN()) != null && (ZW = RN.ZW()) != null) {
                    final Bitmap auN = ag.auN();
                    AbsoluteLayout lA = com.baidu.swan.apps.w.f.ajb().lA(str);
                    final int e = c.e(ZW);
                    final Rect a = c.a(auN, ZW, lA);
                    n.auB().execute(new Runnable() { // from class: com.baidu.swan.apps.aa.e.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.apps.aa.b.a mm = a.C0289a.mm("simple_parser");
                            mm.gk(e);
                            if (!mm.a(auN, a)) {
                                e.alt();
                            }
                        }
                    }, "SwanNAArrivalCheck");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void alt() {
        b.a aVar = null;
        if (com.baidu.swan.apps.runtime.e.apM() != null) {
            aVar = com.baidu.swan.apps.runtime.e.apM().RP();
        }
        com.baidu.swan.apps.statistic.e.b(aVar);
    }

    public static boolean alu() {
        return cui;
    }
}
