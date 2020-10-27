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
    private static volatile String daJ = "";
    private static volatile boolean daK = true;

    public static void azQ() {
    }

    public static void fF(boolean z) {
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "on swan page change, isFromRoute : " + z);
        }
        if (z && com.baidu.swan.apps.statistic.e.aHN()) {
            if (DEBUG) {
                Log.d("SwanArrivalMonitor", "end handle swan page change");
                return;
            }
            return;
        }
        if (z) {
            daK = false;
        }
        if (!z) {
            azT();
        }
        com.baidu.swan.apps.statistic.e.aHF();
        azS();
        com.baidu.swan.apps.runtime.e aEU = com.baidu.swan.apps.runtime.e.aEU();
        if (aEU != null && !z) {
            com.baidu.swan.apps.statistic.e.b(aEU.ado());
        }
    }

    public static void azR() {
        daJ = "";
        daK = true;
    }

    public static void qg(String str) {
        daJ = str;
    }

    public static boolean g(com.baidu.swan.apps.core.d.e eVar) {
        if (eVar == null) {
            return false;
        }
        boolean equals = TextUtils.equals(daJ, eVar.aml());
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "FirstPage: " + equals);
            return equals;
        }
        return equals;
    }

    private static void azS() {
        com.baidu.swan.apps.core.d.f adm;
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "start handle arrival report");
        }
        if (!com.baidu.swan.apps.statistic.e.aHM() && (adm = com.baidu.swan.apps.v.f.axo().adm()) != null) {
            com.baidu.swan.apps.core.d.e amC = adm.amC();
            com.baidu.swan.apps.adaptation.b.a.d dVar = null;
            if (amC != null) {
                com.baidu.swan.apps.adaptation.b.c amq = amC.amq();
                if (amq != null) {
                    com.baidu.swan.apps.adaptation.b.f aga = amq.aga();
                    if (aga != null) {
                        dVar = aga.agf();
                    } else {
                        dVar = amq.agf();
                    }
                } else {
                    return;
                }
            }
            if (dVar != null && dVar.cpN > 0) {
                com.baidu.swan.apps.statistic.e.a(dVar);
            }
        }
    }

    private static void azT() {
        if (!com.baidu.swan.apps.statistic.e.aHL()) {
            com.baidu.swan.apps.core.d.e amC = com.baidu.swan.apps.v.f.axo().amC();
            if (amC == null) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "NAArrival：top fragment is null");
                }
            } else if (!g(amC)) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start na report");
                }
                azU();
            } else {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start check for na arrival");
                }
                qh(amC.aml());
            }
        }
    }

    private static void qh(final String str) {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.y.e.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.core.d.f adm;
                com.baidu.swan.apps.core.d.e amC;
                SwanAppActivity awY = com.baidu.swan.apps.v.f.axo().awY();
                if (awY != null && !awY.isFinishing() && !awY.isDestroyed() && (adm = awY.adm()) != null && (amC = adm.amC()) != null) {
                    final Bitmap aKp = ah.aKp();
                    AbsoluteLayout pz = com.baidu.swan.apps.v.f.axo().pz(str);
                    final int f = c.f(amC);
                    final Rect a2 = c.a(aKp, amC, pz);
                    p.aKa().execute(new Runnable() { // from class: com.baidu.swan.apps.y.e.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.apps.y.b.a qi = a.C0487a.qi("simple_parser");
                            qi.js(f);
                            if (!qi.a(aKp, a2)) {
                                e.azU();
                            }
                        }
                    }, "SwanNAArrivalCheck");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void azU() {
        b.a aVar = null;
        if (com.baidu.swan.apps.runtime.e.aEU() != null) {
            aVar = com.baidu.swan.apps.runtime.e.aEU().ado();
        }
        com.baidu.swan.apps.statistic.e.c(aVar);
    }

    public static boolean azV() {
        return daK;
    }
}
