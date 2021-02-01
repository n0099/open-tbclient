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
/* loaded from: classes9.dex */
public final class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile String dor = "";
    private static volatile boolean dos = true;

    public static void aCO() {
    }

    public static void gn(boolean z) {
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "on swan page change, isFromRoute : " + z);
        }
        if (z && com.baidu.swan.apps.statistic.e.aLD()) {
            if (DEBUG) {
                Log.d("SwanArrivalMonitor", "end handle swan page change");
                return;
            }
            return;
        }
        if (z) {
            dos = false;
        }
        if (!z) {
            aCR();
        }
        com.baidu.swan.apps.statistic.e.aLv();
        aCQ();
        com.baidu.swan.apps.runtime.e aIK = com.baidu.swan.apps.runtime.e.aIK();
        if (aIK != null && !z) {
            com.baidu.swan.apps.statistic.e.b(aIK.afZ());
        }
    }

    public static void aCP() {
        dor = "";
        dos = true;
    }

    public static void pW(String str) {
        dor = str;
    }

    public static boolean g(com.baidu.swan.apps.core.d.e eVar) {
        if (eVar == null) {
            return false;
        }
        boolean equals = TextUtils.equals(dor, eVar.apg());
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "FirstPage: " + equals);
            return equals;
        }
        return equals;
    }

    private static void aCQ() {
        com.baidu.swan.apps.core.d.f afX;
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "start handle arrival report");
        }
        if (!com.baidu.swan.apps.statistic.e.aLC() && (afX = com.baidu.swan.apps.v.f.aAl().afX()) != null) {
            com.baidu.swan.apps.core.d.e apy = afX.apy();
            com.baidu.swan.apps.adaptation.b.a.d dVar = null;
            if (apy != null) {
                com.baidu.swan.apps.adaptation.b.c apm = apy.apm();
                if (apm != null) {
                    com.baidu.swan.apps.adaptation.b.f aiP = apm.aiP();
                    if (aiP != null) {
                        dVar = aiP.aiU();
                    } else {
                        dVar = apm.aiU();
                    }
                } else {
                    return;
                }
            }
            if (dVar != null && dVar.cDt > 0) {
                com.baidu.swan.apps.statistic.e.a(dVar);
            }
        }
    }

    private static void aCR() {
        if (!com.baidu.swan.apps.statistic.e.aLB()) {
            com.baidu.swan.apps.core.d.e apy = com.baidu.swan.apps.v.f.aAl().apy();
            if (apy == null) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "NAArrival：top fragment is null");
                }
            } else if (!g(apy)) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start na report");
                }
                aCS();
            } else {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start check for na arrival");
                }
                pX(apy.apg());
            }
        }
    }

    private static void pX(final String str) {
        ak.k(new Runnable() { // from class: com.baidu.swan.apps.y.e.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.core.d.f afX;
                com.baidu.swan.apps.core.d.e apy;
                SwanAppActivity azV = com.baidu.swan.apps.v.f.aAl().azV();
                if (azV != null && !azV.isFinishing() && !azV.isDestroyed() && (afX = azV.afX()) != null && (apy = afX.apy()) != null) {
                    final Bitmap aOf = ah.aOf();
                    AbsoluteLayout po = com.baidu.swan.apps.v.f.aAl().po(str);
                    final int f = c.f(apy);
                    final Rect a2 = c.a(aOf, apy, po);
                    p.aNQ().execute(new Runnable() { // from class: com.baidu.swan.apps.y.e.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.apps.y.b.a pY = a.C0482a.pY("simple_parser");
                            pY.io(f);
                            if (!pY.a(aOf, a2)) {
                                e.aCS();
                            }
                        }
                    }, "SwanNAArrivalCheck");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aCS() {
        b.a aVar = null;
        if (com.baidu.swan.apps.runtime.e.aIK() != null) {
            aVar = com.baidu.swan.apps.runtime.e.aIK().afZ();
        }
        com.baidu.swan.apps.statistic.e.c(aVar);
    }

    public static boolean aCT() {
        return dos;
    }
}
