package com.baidu.swan.apps.y;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Log;
import android.widget.AbsoluteLayout;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.apps.y.b.a;
/* loaded from: classes10.dex */
public final class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile String cSl = "";
    private static volatile boolean cSm = true;

    public static void axW() {
    }

    public static void fs(boolean z) {
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "on swan page change, isFromRoute : " + z);
        }
        if (z && com.baidu.swan.apps.statistic.e.aFT()) {
            if (DEBUG) {
                Log.d("SwanArrivalMonitor", "end handle swan page change");
                return;
            }
            return;
        }
        if (z) {
            cSm = false;
        }
        if (!z) {
            axZ();
        }
        com.baidu.swan.apps.statistic.e.aFL();
        axY();
        com.baidu.swan.apps.runtime.e aDa = com.baidu.swan.apps.runtime.e.aDa();
        if (aDa != null && !z) {
            com.baidu.swan.apps.statistic.e.b(aDa.abu());
        }
    }

    public static void axX() {
        cSl = "";
        cSm = true;
    }

    public static void pN(String str) {
        cSl = str;
    }

    public static boolean g(com.baidu.swan.apps.core.d.e eVar) {
        if (eVar == null) {
            return false;
        }
        boolean equals = TextUtils.equals(cSl, eVar.akr());
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "FirstPage: " + equals);
            return equals;
        }
        return equals;
    }

    private static void axY() {
        com.baidu.swan.apps.core.d.f abs;
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "start handle arrival report");
        }
        if (!com.baidu.swan.apps.statistic.e.aFS() && (abs = com.baidu.swan.apps.v.f.avu().abs()) != null) {
            com.baidu.swan.apps.core.d.e akI = abs.akI();
            com.baidu.swan.apps.adaptation.b.a.d dVar = null;
            if (akI != null) {
                com.baidu.swan.apps.adaptation.b.c akw = akI.akw();
                if (akw != null) {
                    com.baidu.swan.apps.adaptation.b.f aeg = akw.aeg();
                    if (aeg != null) {
                        dVar = aeg.ael();
                    } else {
                        dVar = akw.ael();
                    }
                } else {
                    return;
                }
            }
            if (dVar != null && dVar.chm > 0) {
                com.baidu.swan.apps.statistic.e.a(dVar);
            }
        }
    }

    private static void axZ() {
        if (!com.baidu.swan.apps.statistic.e.aFR()) {
            com.baidu.swan.apps.core.d.e akI = com.baidu.swan.apps.v.f.avu().akI();
            if (akI == null) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "NAArrival：top fragment is null");
                }
            } else if (!g(akI)) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start na report");
                }
                aya();
            } else {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start check for na arrival");
                }
                pO(akI.akr());
            }
        }
    }

    private static void pO(final String str) {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.y.e.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.core.d.f abs;
                com.baidu.swan.apps.core.d.e akI;
                SwanAppActivity ave = com.baidu.swan.apps.v.f.avu().ave();
                if (ave != null && !ave.isFinishing() && !ave.isDestroyed() && (abs = ave.abs()) != null && (akI = abs.akI()) != null) {
                    final Bitmap aIv = ah.aIv();
                    AbsoluteLayout pg = com.baidu.swan.apps.v.f.avu().pg(str);
                    final int f = c.f(akI);
                    final Rect a2 = c.a(aIv, akI, pg);
                    p.aIg().execute(new Runnable() { // from class: com.baidu.swan.apps.y.e.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.apps.y.b.a pP = a.C0473a.pP("simple_parser");
                            pP.jh(f);
                            if (!pP.a(aIv, a2)) {
                                e.aya();
                            }
                        }
                    }, "SwanNAArrivalCheck");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aya() {
        b.a aVar = null;
        if (com.baidu.swan.apps.runtime.e.aDa() != null) {
            aVar = com.baidu.swan.apps.runtime.e.aDa().abu();
        }
        com.baidu.swan.apps.statistic.e.c(aVar);
    }

    public static boolean ayb() {
        return cSm;
    }
}
