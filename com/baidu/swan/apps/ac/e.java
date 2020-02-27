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
    private static volatile String bFJ = "";
    private static volatile boolean bFK = true;

    public static void YG() {
    }

    public static void de(boolean z) {
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "on swan page change, isFromRoute : " + z);
        }
        if (z && com.baidu.swan.apps.statistic.c.aeV()) {
            if (DEBUG) {
                Log.d("SwanArrivalMonitor", "end handle swan page change");
                return;
            }
            return;
        }
        if (z) {
            bFK = false;
        }
        if (!z) {
            YJ();
        }
        com.baidu.swan.apps.statistic.c.aeO();
        YI();
        com.baidu.swan.apps.runtime.e acD = com.baidu.swan.apps.runtime.e.acD();
        if (acD != null && !z) {
            com.baidu.swan.apps.statistic.c.a(acD.GC());
        }
    }

    public static void YH() {
        bFJ = "";
        bFK = true;
    }

    public static void jC(String str) {
        bFJ = str;
    }

    public static boolean f(com.baidu.swan.apps.core.d.d dVar) {
        if (dVar == null) {
            return false;
        }
        boolean equals = TextUtils.equals(bFJ, dVar.NX());
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "FirstPage: " + equals);
            return equals;
        }
        return equals;
    }

    private static void YI() {
        com.baidu.swan.apps.core.d.e GA;
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "start handle arrival report");
        }
        if (!com.baidu.swan.apps.statistic.c.aeU() && (GA = com.baidu.swan.apps.y.f.WQ().GA()) != null) {
            com.baidu.swan.apps.core.d.d Om = GA.Om();
            com.baidu.swan.apps.adaptation.b.a.d dVar = null;
            if (Om != null) {
                com.baidu.swan.apps.adaptation.b.c Ob = Om.Ob();
                if (Ob != null) {
                    com.baidu.swan.apps.adaptation.b.f IH = Ob.IH();
                    if (IH != null) {
                        dVar = IH.IM();
                    } else {
                        dVar = Ob.IM();
                    }
                } else {
                    return;
                }
            }
            if (dVar != null && dVar.bbA > 0) {
                com.baidu.swan.apps.statistic.c.a(dVar);
            }
        }
    }

    private static void YJ() {
        if (!com.baidu.swan.apps.statistic.c.aeT()) {
            com.baidu.swan.apps.core.d.d Om = com.baidu.swan.apps.y.f.WQ().Om();
            if (Om == null) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "NAArrival：top fragment is null");
                }
            } else if (!f(Om)) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start na report");
                }
                YK();
            } else {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start check for na arrival");
                }
                jD(Om.NX());
            }
        }
    }

    private static void jD(final String str) {
        ai.l(new Runnable() { // from class: com.baidu.swan.apps.ac.e.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.core.d.e GA;
                com.baidu.swan.apps.core.d.d Om;
                SwanAppActivity WB = com.baidu.swan.apps.y.f.WQ().WB();
                if (WB != null && !WB.isFinishing() && !WB.isDestroyed() && (GA = WB.GA()) != null && (Om = GA.Om()) != null) {
                    final Bitmap agV = af.agV();
                    AbsoluteLayout iT = com.baidu.swan.apps.y.f.WQ().iT(str);
                    final int e = c.e(Om);
                    final Rect a = c.a(agV, Om, iT);
                    m.agK().execute(new Runnable() { // from class: com.baidu.swan.apps.ac.e.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.apps.ac.b.a jE = a.C0200a.jE("simple_parser");
                            jE.fB(e);
                            if (!jE.a(agV, a)) {
                                e.YK();
                            }
                        }
                    }, "SwanNAArrivalCheck");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void YK() {
        b.a aVar = null;
        if (com.baidu.swan.apps.runtime.e.acD() != null) {
            aVar = com.baidu.swan.apps.runtime.e.acD().GC();
        }
        com.baidu.swan.apps.statistic.c.b(aVar);
    }

    public static boolean YL() {
        return bFK;
    }
}
