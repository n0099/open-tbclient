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
    private static volatile String dgE = "";
    private static volatile boolean dgF = true;

    public static void aCq() {
    }

    public static void fO(boolean z) {
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "on swan page change, isFromRoute : " + z);
        }
        if (z && com.baidu.swan.apps.statistic.e.aKn()) {
            if (DEBUG) {
                Log.d("SwanArrivalMonitor", "end handle swan page change");
                return;
            }
            return;
        }
        if (z) {
            dgF = false;
        }
        if (!z) {
            aCt();
        }
        com.baidu.swan.apps.statistic.e.aKf();
        aCs();
        com.baidu.swan.apps.runtime.e aHu = com.baidu.swan.apps.runtime.e.aHu();
        if (aHu != null && !z) {
            com.baidu.swan.apps.statistic.e.b(aHu.afO());
        }
    }

    public static void aCr() {
        dgE = "";
        dgF = true;
    }

    public static void qu(String str) {
        dgE = str;
    }

    public static boolean g(com.baidu.swan.apps.core.d.e eVar) {
        if (eVar == null) {
            return false;
        }
        boolean equals = TextUtils.equals(dgE, eVar.aoL());
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "FirstPage: " + equals);
            return equals;
        }
        return equals;
    }

    private static void aCs() {
        com.baidu.swan.apps.core.d.f afM;
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "start handle arrival report");
        }
        if (!com.baidu.swan.apps.statistic.e.aKm() && (afM = com.baidu.swan.apps.v.f.azO().afM()) != null) {
            com.baidu.swan.apps.core.d.e apc = afM.apc();
            com.baidu.swan.apps.adaptation.b.a.d dVar = null;
            if (apc != null) {
                com.baidu.swan.apps.adaptation.b.c aoQ = apc.aoQ();
                if (aoQ != null) {
                    com.baidu.swan.apps.adaptation.b.f aiA = aoQ.aiA();
                    if (aiA != null) {
                        dVar = aiA.aiF();
                    } else {
                        dVar = aoQ.aiF();
                    }
                } else {
                    return;
                }
            }
            if (dVar != null && dVar.cvL > 0) {
                com.baidu.swan.apps.statistic.e.a(dVar);
            }
        }
    }

    private static void aCt() {
        if (!com.baidu.swan.apps.statistic.e.aKl()) {
            com.baidu.swan.apps.core.d.e apc = com.baidu.swan.apps.v.f.azO().apc();
            if (apc == null) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "NAArrival：top fragment is null");
                }
            } else if (!g(apc)) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start na report");
                }
                aCu();
            } else {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start check for na arrival");
                }
                qv(apc.aoL());
            }
        }
    }

    private static void qv(final String str) {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.y.e.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.core.d.f afM;
                com.baidu.swan.apps.core.d.e apc;
                SwanAppActivity azy = com.baidu.swan.apps.v.f.azO().azy();
                if (azy != null && !azy.isFinishing() && !azy.isDestroyed() && (afM = azy.afM()) != null && (apc = afM.apc()) != null) {
                    final Bitmap aMP = ah.aMP();
                    AbsoluteLayout pN = com.baidu.swan.apps.v.f.azO().pN(str);
                    final int f = c.f(apc);
                    final Rect a2 = c.a(aMP, apc, pN);
                    p.aMA().execute(new Runnable() { // from class: com.baidu.swan.apps.y.e.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.apps.y.b.a qw = a.C0499a.qw("simple_parser");
                            qw.jC(f);
                            if (!qw.a(aMP, a2)) {
                                e.aCu();
                            }
                        }
                    }, "SwanNAArrivalCheck");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aCu() {
        b.a aVar = null;
        if (com.baidu.swan.apps.runtime.e.aHu() != null) {
            aVar = com.baidu.swan.apps.runtime.e.aHu().afO();
        }
        com.baidu.swan.apps.statistic.e.c(aVar);
    }

    public static boolean aCv() {
        return dgF;
    }
}
