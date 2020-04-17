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
    private static volatile String ceG = "";
    private static volatile boolean ceH = true;

    public static void agR() {
    }

    public static void eb(boolean z) {
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "on swan page change, isFromRoute : " + z);
        }
        if (z && com.baidu.swan.apps.statistic.c.anf()) {
            if (DEBUG) {
                Log.d("SwanArrivalMonitor", "end handle swan page change");
                return;
            }
            return;
        }
        if (z) {
            ceH = false;
        }
        if (!z) {
            agU();
        }
        com.baidu.swan.apps.statistic.c.amY();
        agT();
        com.baidu.swan.apps.runtime.e akN = com.baidu.swan.apps.runtime.e.akN();
        if (akN != null && !z) {
            com.baidu.swan.apps.statistic.c.a(akN.Ow());
        }
    }

    public static void agS() {
        ceG = "";
        ceH = true;
    }

    public static void kO(String str) {
        ceG = str;
    }

    public static boolean f(com.baidu.swan.apps.core.d.d dVar) {
        if (dVar == null) {
            return false;
        }
        boolean equals = TextUtils.equals(ceG, dVar.VQ());
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "FirstPage: " + equals);
            return equals;
        }
        return equals;
    }

    private static void agT() {
        com.baidu.swan.apps.core.d.e Ou;
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "start handle arrival report");
        }
        if (!com.baidu.swan.apps.statistic.c.ane() && (Ou = com.baidu.swan.apps.y.f.aeK().Ou()) != null) {
            com.baidu.swan.apps.core.d.d Wf = Ou.Wf();
            com.baidu.swan.apps.adaptation.b.a.d dVar = null;
            if (Wf != null) {
                com.baidu.swan.apps.adaptation.b.c VU = Wf.VU();
                if (VU != null) {
                    com.baidu.swan.apps.adaptation.b.f Qy = VU.Qy();
                    if (Qy != null) {
                        dVar = Qy.QD();
                    } else {
                        dVar = VU.QD();
                    }
                } else {
                    return;
                }
            }
            if (dVar != null && dVar.bAd > 0) {
                com.baidu.swan.apps.statistic.c.a(dVar);
            }
        }
    }

    private static void agU() {
        if (!com.baidu.swan.apps.statistic.c.and()) {
            com.baidu.swan.apps.core.d.d Wf = com.baidu.swan.apps.y.f.aeK().Wf();
            if (Wf == null) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "NAArrival：top fragment is null");
                }
            } else if (!f(Wf)) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start na report");
                }
                agV();
            } else {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start check for na arrival");
                }
                kP(Wf.VQ());
            }
        }
    }

    private static void kP(final String str) {
        ai.o(new Runnable() { // from class: com.baidu.swan.apps.ac.e.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.core.d.e Ou;
                com.baidu.swan.apps.core.d.d Wf;
                SwanAppActivity aev = com.baidu.swan.apps.y.f.aeK().aev();
                if (aev != null && !aev.isFinishing() && !aev.isDestroyed() && (Ou = aev.Ou()) != null && (Wf = Ou.Wf()) != null) {
                    final Bitmap aph = af.aph();
                    AbsoluteLayout kf = com.baidu.swan.apps.y.f.aeK().kf(str);
                    final int e = c.e(Wf);
                    final Rect a = c.a(aph, Wf, kf);
                    m.aoV().execute(new Runnable() { // from class: com.baidu.swan.apps.ac.e.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.apps.ac.b.a kQ = a.C0230a.kQ("simple_parser");
                            kQ.fI(e);
                            if (!kQ.a(aph, a)) {
                                e.agV();
                            }
                        }
                    }, "SwanNAArrivalCheck");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void agV() {
        b.a aVar = null;
        if (com.baidu.swan.apps.runtime.e.akN() != null) {
            aVar = com.baidu.swan.apps.runtime.e.akN().Ow();
        }
        com.baidu.swan.apps.statistic.c.b(aVar);
    }

    public static boolean agW() {
        return ceH;
    }
}
