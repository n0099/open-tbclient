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
/* loaded from: classes25.dex */
public final class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile String dlW = "";
    private static volatile boolean dlX = true;

    public static void aER() {
    }

    public static void gg(boolean z) {
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "on swan page change, isFromRoute : " + z);
        }
        if (z && com.baidu.swan.apps.statistic.e.aMN()) {
            if (DEBUG) {
                Log.d("SwanArrivalMonitor", "end handle swan page change");
                return;
            }
            return;
        }
        if (z) {
            dlX = false;
        }
        if (!z) {
            aEU();
        }
        com.baidu.swan.apps.statistic.e.aMF();
        aET();
        com.baidu.swan.apps.runtime.e aJU = com.baidu.swan.apps.runtime.e.aJU();
        if (aJU != null && !z) {
            com.baidu.swan.apps.statistic.e.b(aJU.aio());
        }
    }

    public static void aES() {
        dlW = "";
        dlX = true;
    }

    public static void qV(String str) {
        dlW = str;
    }

    public static boolean g(com.baidu.swan.apps.core.d.e eVar) {
        if (eVar == null) {
            return false;
        }
        boolean equals = TextUtils.equals(dlW, eVar.arl());
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "FirstPage: " + equals);
            return equals;
        }
        return equals;
    }

    private static void aET() {
        com.baidu.swan.apps.core.d.f aim;
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "start handle arrival report");
        }
        if (!com.baidu.swan.apps.statistic.e.aMM() && (aim = com.baidu.swan.apps.v.f.aCp().aim()) != null) {
            com.baidu.swan.apps.core.d.e arC = aim.arC();
            com.baidu.swan.apps.adaptation.b.a.d dVar = null;
            if (arC != null) {
                com.baidu.swan.apps.adaptation.b.c arq = arC.arq();
                if (arq != null) {
                    com.baidu.swan.apps.adaptation.b.f ala = arq.ala();
                    if (ala != null) {
                        dVar = ala.alf();
                    } else {
                        dVar = arq.alf();
                    }
                } else {
                    return;
                }
            }
            if (dVar != null && dVar.cAT > 0) {
                com.baidu.swan.apps.statistic.e.a(dVar);
            }
        }
    }

    private static void aEU() {
        if (!com.baidu.swan.apps.statistic.e.aML()) {
            com.baidu.swan.apps.core.d.e arC = com.baidu.swan.apps.v.f.aCp().arC();
            if (arC == null) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "NAArrival：top fragment is null");
                }
            } else if (!g(arC)) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start na report");
                }
                aEV();
            } else {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start check for na arrival");
                }
                qW(arC.arl());
            }
        }
    }

    private static void qW(final String str) {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.y.e.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.core.d.f aim;
                com.baidu.swan.apps.core.d.e arC;
                SwanAppActivity aBZ = com.baidu.swan.apps.v.f.aCp().aBZ();
                if (aBZ != null && !aBZ.isFinishing() && !aBZ.isDestroyed() && (aim = aBZ.aim()) != null && (arC = aim.arC()) != null) {
                    final Bitmap aPo = ah.aPo();
                    AbsoluteLayout qo = com.baidu.swan.apps.v.f.aCp().qo(str);
                    final int f = c.f(arC);
                    final Rect a2 = c.a(aPo, arC, qo);
                    p.aOZ().execute(new Runnable() { // from class: com.baidu.swan.apps.y.e.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.apps.y.b.a qX = a.C0509a.qX("simple_parser");
                            qX.jW(f);
                            if (!qX.a(aPo, a2)) {
                                e.aEV();
                            }
                        }
                    }, "SwanNAArrivalCheck");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aEV() {
        b.a aVar = null;
        if (com.baidu.swan.apps.runtime.e.aJU() != null) {
            aVar = com.baidu.swan.apps.runtime.e.aJU().aio();
        }
        com.baidu.swan.apps.statistic.e.c(aVar);
    }

    public static boolean aEW() {
        return dlX;
    }
}
