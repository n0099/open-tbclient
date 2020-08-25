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
/* loaded from: classes8.dex */
public final class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile String cEe = "";
    private static volatile boolean cEf = true;

    public static void auC() {
    }

    public static void eX(boolean z) {
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "on swan page change, isFromRoute : " + z);
        }
        if (z && com.baidu.swan.apps.statistic.e.aCA()) {
            if (DEBUG) {
                Log.d("SwanArrivalMonitor", "end handle swan page change");
                return;
            }
            return;
        }
        if (z) {
            cEf = false;
        }
        if (!z) {
            auF();
        }
        com.baidu.swan.apps.statistic.e.aCs();
        auE();
        com.baidu.swan.apps.runtime.e azI = com.baidu.swan.apps.runtime.e.azI();
        if (azI != null && !z) {
            com.baidu.swan.apps.statistic.e.b(azI.XZ());
        }
    }

    public static void auD() {
        cEe = "";
        cEf = true;
    }

    public static void oH(String str) {
        cEe = str;
    }

    public static boolean g(com.baidu.swan.apps.core.d.e eVar) {
        if (eVar == null) {
            return false;
        }
        boolean equals = TextUtils.equals(cEe, eVar.agW());
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "FirstPage: " + equals);
            return equals;
        }
        return equals;
    }

    private static void auE() {
        com.baidu.swan.apps.core.d.f XX;
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "start handle arrival report");
        }
        if (!com.baidu.swan.apps.statistic.e.aCz() && (XX = com.baidu.swan.apps.v.f.arY().XX()) != null) {
            com.baidu.swan.apps.core.d.e ahn = XX.ahn();
            com.baidu.swan.apps.adaptation.b.a.d dVar = null;
            if (ahn != null) {
                com.baidu.swan.apps.adaptation.b.c ahb = ahn.ahb();
                if (ahb != null) {
                    com.baidu.swan.apps.adaptation.b.f aaL = ahb.aaL();
                    if (aaL != null) {
                        dVar = aaL.aaQ();
                    } else {
                        dVar = ahb.aaQ();
                    }
                } else {
                    return;
                }
            }
            if (dVar != null && dVar.bSU > 0) {
                com.baidu.swan.apps.statistic.e.a(dVar);
            }
        }
    }

    private static void auF() {
        if (!com.baidu.swan.apps.statistic.e.aCy()) {
            com.baidu.swan.apps.core.d.e ahn = com.baidu.swan.apps.v.f.arY().ahn();
            if (ahn == null) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "NAArrival：top fragment is null");
                }
            } else if (!g(ahn)) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start na report");
                }
                auG();
            } else {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start check for na arrival");
                }
                oI(ahn.agW());
            }
        }
    }

    private static void oI(final String str) {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.y.e.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.core.d.f XX;
                com.baidu.swan.apps.core.d.e ahn;
                SwanAppActivity arI = com.baidu.swan.apps.v.f.arY().arI();
                if (arI != null && !arI.isFinishing() && !arI.isDestroyed() && (XX = arI.XX()) != null && (ahn = XX.ahn()) != null) {
                    final Bitmap aFc = ah.aFc();
                    AbsoluteLayout nY = com.baidu.swan.apps.v.f.arY().nY(str);
                    final int f = c.f(ahn);
                    final Rect a = c.a(aFc, ahn, nY);
                    p.aEN().execute(new Runnable() { // from class: com.baidu.swan.apps.y.e.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.apps.y.b.a oJ = a.C0461a.oJ("simple_parser");
                            oJ.iA(f);
                            if (!oJ.a(aFc, a)) {
                                e.auG();
                            }
                        }
                    }, "SwanNAArrivalCheck");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void auG() {
        b.a aVar = null;
        if (com.baidu.swan.apps.runtime.e.azI() != null) {
            aVar = com.baidu.swan.apps.runtime.e.azI().XZ();
        }
        com.baidu.swan.apps.statistic.e.c(aVar);
    }

    public static boolean auH() {
        return cEf;
    }
}
