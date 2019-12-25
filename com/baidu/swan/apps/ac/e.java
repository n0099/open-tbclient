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
/* loaded from: classes9.dex */
public final class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile String bAR = "";
    private static volatile boolean bAS = true;

    public static void VV() {
    }

    public static void cS(boolean z) {
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "on swan page change, isFromRoute : " + z);
        }
        if (z && com.baidu.swan.apps.statistic.c.ack()) {
            if (DEBUG) {
                Log.d("SwanArrivalMonitor", "end handle swan page change");
                return;
            }
            return;
        }
        if (z) {
            bAS = false;
        }
        if (!z) {
            VY();
        }
        com.baidu.swan.apps.statistic.c.acd();
        VX();
        com.baidu.swan.apps.runtime.e ZS = com.baidu.swan.apps.runtime.e.ZS();
        if (ZS != null && !z) {
            com.baidu.swan.apps.statistic.c.a(ZS.DR());
        }
    }

    public static void VW() {
        bAR = "";
        bAS = true;
    }

    public static void jk(String str) {
        bAR = str;
    }

    public static boolean f(com.baidu.swan.apps.core.d.d dVar) {
        if (dVar == null) {
            return false;
        }
        boolean equals = TextUtils.equals(bAR, dVar.Ln());
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "FirstPage: " + equals);
            return equals;
        }
        return equals;
    }

    private static void VX() {
        com.baidu.swan.apps.core.d.e DP;
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "start handle arrival report");
        }
        if (!com.baidu.swan.apps.statistic.c.acj() && (DP = com.baidu.swan.apps.y.f.Uf().DP()) != null) {
            com.baidu.swan.apps.core.d.d LC = DP.LC();
            com.baidu.swan.apps.adaptation.b.a.d dVar = null;
            if (LC != null) {
                com.baidu.swan.apps.adaptation.b.c Lr = LC.Lr();
                if (Lr != null) {
                    com.baidu.swan.apps.adaptation.b.f FW = Lr.FW();
                    if (FW != null) {
                        dVar = FW.Gb();
                    } else {
                        dVar = Lr.Gb();
                    }
                } else {
                    return;
                }
            }
            if (dVar != null && dVar.aWx > 0) {
                com.baidu.swan.apps.statistic.c.a(dVar);
            }
        }
    }

    private static void VY() {
        if (!com.baidu.swan.apps.statistic.c.aci()) {
            com.baidu.swan.apps.core.d.d LC = com.baidu.swan.apps.y.f.Uf().LC();
            if (LC == null) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "NAArrival：top fragment is null");
                }
            } else if (!f(LC)) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start na report");
                }
                VZ();
            } else {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start check for na arrival");
                }
                jl(LC.Ln());
            }
        }
    }

    private static void jl(final String str) {
        ai.l(new Runnable() { // from class: com.baidu.swan.apps.ac.e.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.core.d.e DP;
                com.baidu.swan.apps.core.d.d LC;
                SwanAppActivity TQ = com.baidu.swan.apps.y.f.Uf().TQ();
                if (TQ != null && !TQ.isFinishing() && !TQ.isDestroyed() && (DP = TQ.DP()) != null && (LC = DP.LC()) != null) {
                    final Bitmap aeo = af.aeo();
                    AbsoluteLayout iB = com.baidu.swan.apps.y.f.Uf().iB(str);
                    final int e = c.e(LC);
                    final Rect a = c.a(aeo, LC, iB);
                    m.aed().execute(new Runnable() { // from class: com.baidu.swan.apps.ac.e.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.apps.ac.b.a jm = a.C0188a.jm("simple_parser");
                            jm.fk(e);
                            if (!jm.a(aeo, a)) {
                                e.VZ();
                            }
                        }
                    }, "SwanNAArrivalCheck");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void VZ() {
        b.a aVar = null;
        if (com.baidu.swan.apps.runtime.e.ZS() != null) {
            aVar = com.baidu.swan.apps.runtime.e.ZS().DR();
        }
        com.baidu.swan.apps.statistic.c.b(aVar);
    }

    public static boolean Wa() {
        return bAS;
    }
}
