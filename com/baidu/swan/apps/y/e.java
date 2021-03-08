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
    private static volatile String dpU = "";
    private static volatile boolean dpV = true;

    public static void aCR() {
    }

    public static void gn(boolean z) {
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "on swan page change, isFromRoute : " + z);
        }
        if (z && com.baidu.swan.apps.statistic.e.aLG()) {
            if (DEBUG) {
                Log.d("SwanArrivalMonitor", "end handle swan page change");
                return;
            }
            return;
        }
        if (z) {
            dpV = false;
        }
        if (!z) {
            aCU();
        }
        com.baidu.swan.apps.statistic.e.aLy();
        aCT();
        com.baidu.swan.apps.runtime.e aIN = com.baidu.swan.apps.runtime.e.aIN();
        if (aIN != null && !z) {
            com.baidu.swan.apps.statistic.e.b(aIN.agc());
        }
    }

    public static void aCS() {
        dpU = "";
        dpV = true;
    }

    public static void qd(String str) {
        dpU = str;
    }

    public static boolean g(com.baidu.swan.apps.core.d.e eVar) {
        if (eVar == null) {
            return false;
        }
        boolean equals = TextUtils.equals(dpU, eVar.apk());
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "FirstPage: " + equals);
            return equals;
        }
        return equals;
    }

    private static void aCT() {
        com.baidu.swan.apps.core.d.f aga;
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "start handle arrival report");
        }
        if (!com.baidu.swan.apps.statistic.e.aLF() && (aga = com.baidu.swan.apps.v.f.aAo().aga()) != null) {
            com.baidu.swan.apps.core.d.e apB = aga.apB();
            com.baidu.swan.apps.adaptation.b.a.d dVar = null;
            if (apB != null) {
                com.baidu.swan.apps.adaptation.b.c app = apB.app();
                if (app != null) {
                    com.baidu.swan.apps.adaptation.b.f aiS = app.aiS();
                    if (aiS != null) {
                        dVar = aiS.aiX();
                    } else {
                        dVar = app.aiX();
                    }
                } else {
                    return;
                }
            }
            if (dVar != null && dVar.cET > 0) {
                com.baidu.swan.apps.statistic.e.a(dVar);
            }
        }
    }

    private static void aCU() {
        if (!com.baidu.swan.apps.statistic.e.aLE()) {
            com.baidu.swan.apps.core.d.e apB = com.baidu.swan.apps.v.f.aAo().apB();
            if (apB == null) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "NAArrival：top fragment is null");
                }
            } else if (!g(apB)) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start na report");
                }
                aCV();
            } else {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start check for na arrival");
                }
                qe(apB.apk());
            }
        }
    }

    private static void qe(final String str) {
        ak.j(new Runnable() { // from class: com.baidu.swan.apps.y.e.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.core.d.f aga;
                com.baidu.swan.apps.core.d.e apB;
                SwanAppActivity azY = com.baidu.swan.apps.v.f.aAo().azY();
                if (azY != null && !azY.isFinishing() && !azY.isDestroyed() && (aga = azY.aga()) != null && (apB = aga.apB()) != null) {
                    final Bitmap aOi = ah.aOi();
                    AbsoluteLayout pv = com.baidu.swan.apps.v.f.aAo().pv(str);
                    final int f = c.f(apB);
                    final Rect a2 = c.a(aOi, apB, pv);
                    p.aNT().execute(new Runnable() { // from class: com.baidu.swan.apps.y.e.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.apps.y.b.a qf = a.C0488a.qf("simple_parser");
                            qf.ip(f);
                            if (!qf.a(aOi, a2)) {
                                e.aCV();
                            }
                        }
                    }, "SwanNAArrivalCheck");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aCV() {
        b.a aVar = null;
        if (com.baidu.swan.apps.runtime.e.aIN() != null) {
            aVar = com.baidu.swan.apps.runtime.e.aIN().agc();
        }
        com.baidu.swan.apps.statistic.e.c(aVar);
    }

    public static boolean aCW() {
        return dpV;
    }
}
