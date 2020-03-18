package com.baidu.swan.apps.ac;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Log;
import android.widget.AbsoluteLayout;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ac.b.a;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.apps.x.b.b;
/* loaded from: classes11.dex */
public final class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile String bFW = "";
    private static volatile boolean bFX = true;

    public static void YL() {
    }

    public static void df(boolean z) {
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "on swan page change, isFromRoute : " + z);
        }
        if (z && com.baidu.swan.apps.statistic.c.afa()) {
            if (DEBUG) {
                Log.d("SwanArrivalMonitor", "end handle swan page change");
                return;
            }
            return;
        }
        if (z) {
            bFX = false;
        }
        if (!z) {
            YO();
        }
        com.baidu.swan.apps.statistic.c.aeT();
        YN();
        com.baidu.swan.apps.runtime.e acI = com.baidu.swan.apps.runtime.e.acI();
        if (acI != null && !z) {
            com.baidu.swan.apps.statistic.c.a(acI.GJ());
        }
    }

    public static void YM() {
        bFW = "";
        bFX = true;
    }

    public static void jB(String str) {
        bFW = str;
    }

    public static boolean f(com.baidu.swan.apps.core.d.d dVar) {
        if (dVar == null) {
            return false;
        }
        boolean equals = TextUtils.equals(bFW, dVar.Oc());
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "FirstPage: " + equals);
            return equals;
        }
        return equals;
    }

    private static void YN() {
        com.baidu.swan.apps.core.d.e GH;
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "start handle arrival report");
        }
        if (!com.baidu.swan.apps.statistic.c.aeZ() && (GH = com.baidu.swan.apps.y.f.WV().GH()) != null) {
            com.baidu.swan.apps.core.d.d Or = GH.Or();
            com.baidu.swan.apps.adaptation.b.a.d dVar = null;
            if (Or != null) {
                com.baidu.swan.apps.adaptation.b.c Og = Or.Og();
                if (Og != null) {
                    com.baidu.swan.apps.adaptation.b.f IM = Og.IM();
                    if (IM != null) {
                        dVar = IM.IR();
                    } else {
                        dVar = Og.IR();
                    }
                } else {
                    return;
                }
            }
            if (dVar != null && dVar.bbP > 0) {
                com.baidu.swan.apps.statistic.c.a(dVar);
            }
        }
    }

    private static void YO() {
        if (!com.baidu.swan.apps.statistic.c.aeY()) {
            com.baidu.swan.apps.core.d.d Or = com.baidu.swan.apps.y.f.WV().Or();
            if (Or == null) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "NAArrival：top fragment is null");
                }
            } else if (!f(Or)) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start na report");
                }
                YP();
            } else {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start check for na arrival");
                }
                jC(Or.Oc());
            }
        }
    }

    private static void jC(final String str) {
        ai.l(new Runnable() { // from class: com.baidu.swan.apps.ac.e.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.core.d.e GH;
                com.baidu.swan.apps.core.d.d Or;
                SwanAppActivity WG = com.baidu.swan.apps.y.f.WV().WG();
                if (WG != null && !WG.isFinishing() && !WG.isDestroyed() && (GH = WG.GH()) != null && (Or = GH.Or()) != null) {
                    final Bitmap aha = af.aha();
                    AbsoluteLayout iS = com.baidu.swan.apps.y.f.WV().iS(str);
                    final int e = c.e(Or);
                    final Rect a = c.a(aha, Or, iS);
                    m.agP().execute(new Runnable() { // from class: com.baidu.swan.apps.ac.e.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.apps.ac.b.a jD = a.C0200a.jD("simple_parser");
                            jD.fB(e);
                            if (!jD.a(aha, a)) {
                                e.YP();
                            }
                        }
                    }, "SwanNAArrivalCheck");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void YP() {
        b.a aVar = null;
        if (com.baidu.swan.apps.runtime.e.acI() != null) {
            aVar = com.baidu.swan.apps.runtime.e.acI().GJ();
        }
        com.baidu.swan.apps.statistic.c.b(aVar);
    }

    public static boolean YQ() {
        return bFX;
    }
}
