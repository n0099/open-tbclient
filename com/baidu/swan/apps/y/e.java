package com.baidu.swan.apps.y;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Log;
import android.widget.AbsoluteLayout;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.apps.y.b.a;
/* loaded from: classes8.dex */
public final class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile String dmf = "";
    private static volatile boolean dmg = true;

    public static void aCs() {
    }

    public static void gl(boolean z) {
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "on swan page change, isFromRoute : " + z);
        }
        if (z && com.baidu.swan.apps.statistic.e.aLk()) {
            if (DEBUG) {
                Log.d("SwanArrivalMonitor", "end handle swan page change");
                return;
            }
            return;
        }
        if (z) {
            dmg = false;
        }
        if (!z) {
            aCv();
        }
        com.baidu.swan.apps.statistic.e.aLc();
        aCu();
        com.baidu.swan.apps.runtime.e aIr = com.baidu.swan.apps.runtime.e.aIr();
        if (aIr != null && !z) {
            com.baidu.swan.apps.statistic.e.b(aIr.afB());
        }
    }

    public static void aCt() {
        dmf = "";
        dmg = true;
    }

    public static void pE(String str) {
        dmf = str;
    }

    public static boolean g(com.baidu.swan.apps.core.d.e eVar) {
        if (eVar == null) {
            return false;
        }
        boolean equals = TextUtils.equals(dmf, eVar.aoI());
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "FirstPage: " + equals);
            return equals;
        }
        return equals;
    }

    private static void aCu() {
        com.baidu.swan.apps.core.d.f afz;
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "start handle arrival report");
        }
        if (!com.baidu.swan.apps.statistic.e.aLj() && (afz = com.baidu.swan.apps.v.f.azN().afz()) != null) {
            com.baidu.swan.apps.core.d.e aoZ = afz.aoZ();
            com.baidu.swan.apps.adaptation.b.a.d dVar = null;
            if (aoZ != null) {
                com.baidu.swan.apps.adaptation.b.c aoN = aoZ.aoN();
                if (aoN != null) {
                    com.baidu.swan.apps.adaptation.b.f air = aoN.air();
                    if (air != null) {
                        dVar = air.aiw();
                    } else {
                        dVar = aoN.aiw();
                    }
                } else {
                    return;
                }
            }
            if (dVar != null && dVar.cAX > 0) {
                com.baidu.swan.apps.statistic.e.a(dVar);
            }
        }
    }

    private static void aCv() {
        if (!com.baidu.swan.apps.statistic.e.aLi()) {
            com.baidu.swan.apps.core.d.e aoZ = com.baidu.swan.apps.v.f.azN().aoZ();
            if (aoZ == null) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "NAArrival：top fragment is null");
                }
            } else if (!g(aoZ)) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start na report");
                }
                aCw();
            } else {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start check for na arrival");
                }
                pF(aoZ.aoI());
            }
        }
    }

    private static void pF(final String str) {
        ak.l(new Runnable() { // from class: com.baidu.swan.apps.y.e.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.core.d.f afz;
                com.baidu.swan.apps.core.d.e aoZ;
                SwanAppActivity azx = com.baidu.swan.apps.v.f.azN().azx();
                if (azx != null && !azx.isFinishing() && !azx.isDestroyed() && (afz = azx.afz()) != null && (aoZ = afz.aoZ()) != null) {
                    final Bitmap aNM = ah.aNM();
                    AbsoluteLayout oW = com.baidu.swan.apps.v.f.azN().oW(str);
                    final int f = c.f(aoZ);
                    final Rect a2 = c.a(aNM, aoZ, oW);
                    p.aNx().execute(new Runnable() { // from class: com.baidu.swan.apps.y.e.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.apps.y.b.a pG = a.C0485a.pG("simple_parser");
                            pG.il(f);
                            if (!pG.a(aNM, a2)) {
                                e.aCw();
                            }
                        }
                    }, "SwanNAArrivalCheck");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aCw() {
        b.a aVar = null;
        if (com.baidu.swan.apps.runtime.e.aIr() != null) {
            aVar = com.baidu.swan.apps.runtime.e.aIr().afB();
        }
        com.baidu.swan.apps.statistic.e.c(aVar);
    }

    public static boolean aCx() {
        return dmg;
    }
}
