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
    private static volatile String ceM = "";
    private static volatile boolean ceN = true;

    public static void agQ() {
    }

    public static void eb(boolean z) {
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "on swan page change, isFromRoute : " + z);
        }
        if (z && com.baidu.swan.apps.statistic.c.ane()) {
            if (DEBUG) {
                Log.d("SwanArrivalMonitor", "end handle swan page change");
                return;
            }
            return;
        }
        if (z) {
            ceN = false;
        }
        if (!z) {
            agT();
        }
        com.baidu.swan.apps.statistic.c.amX();
        agS();
        com.baidu.swan.apps.runtime.e akM = com.baidu.swan.apps.runtime.e.akM();
        if (akM != null && !z) {
            com.baidu.swan.apps.statistic.c.a(akM.Ov());
        }
    }

    public static void agR() {
        ceM = "";
        ceN = true;
    }

    public static void kO(String str) {
        ceM = str;
    }

    public static boolean f(com.baidu.swan.apps.core.d.d dVar) {
        if (dVar == null) {
            return false;
        }
        boolean equals = TextUtils.equals(ceM, dVar.VP());
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "FirstPage: " + equals);
            return equals;
        }
        return equals;
    }

    private static void agS() {
        com.baidu.swan.apps.core.d.e Ot;
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "start handle arrival report");
        }
        if (!com.baidu.swan.apps.statistic.c.and() && (Ot = com.baidu.swan.apps.y.f.aeJ().Ot()) != null) {
            com.baidu.swan.apps.core.d.d We = Ot.We();
            com.baidu.swan.apps.adaptation.b.a.d dVar = null;
            if (We != null) {
                com.baidu.swan.apps.adaptation.b.c VT = We.VT();
                if (VT != null) {
                    com.baidu.swan.apps.adaptation.b.f Qx = VT.Qx();
                    if (Qx != null) {
                        dVar = Qx.QC();
                    } else {
                        dVar = VT.QC();
                    }
                } else {
                    return;
                }
            }
            if (dVar != null && dVar.bAi > 0) {
                com.baidu.swan.apps.statistic.c.a(dVar);
            }
        }
    }

    private static void agT() {
        if (!com.baidu.swan.apps.statistic.c.anc()) {
            com.baidu.swan.apps.core.d.d We = com.baidu.swan.apps.y.f.aeJ().We();
            if (We == null) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "NAArrival：top fragment is null");
                }
            } else if (!f(We)) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start na report");
                }
                agU();
            } else {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start check for na arrival");
                }
                kP(We.VP());
            }
        }
    }

    private static void kP(final String str) {
        ai.o(new Runnable() { // from class: com.baidu.swan.apps.ac.e.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.core.d.e Ot;
                com.baidu.swan.apps.core.d.d We;
                SwanAppActivity aeu = com.baidu.swan.apps.y.f.aeJ().aeu();
                if (aeu != null && !aeu.isFinishing() && !aeu.isDestroyed() && (Ot = aeu.Ot()) != null && (We = Ot.We()) != null) {
                    final Bitmap apg = af.apg();
                    AbsoluteLayout kf = com.baidu.swan.apps.y.f.aeJ().kf(str);
                    final int e = c.e(We);
                    final Rect a = c.a(apg, We, kf);
                    m.aoU().execute(new Runnable() { // from class: com.baidu.swan.apps.ac.e.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.apps.ac.b.a kQ = a.C0251a.kQ("simple_parser");
                            kQ.fI(e);
                            if (!kQ.a(apg, a)) {
                                e.agU();
                            }
                        }
                    }, "SwanNAArrivalCheck");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void agU() {
        b.a aVar = null;
        if (com.baidu.swan.apps.runtime.e.akM() != null) {
            aVar = com.baidu.swan.apps.runtime.e.akM().Ov();
        }
        com.baidu.swan.apps.statistic.c.b(aVar);
    }

    public static boolean agV() {
        return ceN;
    }
}
