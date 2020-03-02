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
    private static volatile String bFK = "";
    private static volatile boolean bFL = true;

    public static void YI() {
    }

    public static void de(boolean z) {
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "on swan page change, isFromRoute : " + z);
        }
        if (z && com.baidu.swan.apps.statistic.c.aeX()) {
            if (DEBUG) {
                Log.d("SwanArrivalMonitor", "end handle swan page change");
                return;
            }
            return;
        }
        if (z) {
            bFL = false;
        }
        if (!z) {
            YL();
        }
        com.baidu.swan.apps.statistic.c.aeQ();
        YK();
        com.baidu.swan.apps.runtime.e acF = com.baidu.swan.apps.runtime.e.acF();
        if (acF != null && !z) {
            com.baidu.swan.apps.statistic.c.a(acF.GE());
        }
    }

    public static void YJ() {
        bFK = "";
        bFL = true;
    }

    public static void jC(String str) {
        bFK = str;
    }

    public static boolean f(com.baidu.swan.apps.core.d.d dVar) {
        if (dVar == null) {
            return false;
        }
        boolean equals = TextUtils.equals(bFK, dVar.NZ());
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "FirstPage: " + equals);
            return equals;
        }
        return equals;
    }

    private static void YK() {
        com.baidu.swan.apps.core.d.e GC;
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "start handle arrival report");
        }
        if (!com.baidu.swan.apps.statistic.c.aeW() && (GC = com.baidu.swan.apps.y.f.WS().GC()) != null) {
            com.baidu.swan.apps.core.d.d Oo = GC.Oo();
            com.baidu.swan.apps.adaptation.b.a.d dVar = null;
            if (Oo != null) {
                com.baidu.swan.apps.adaptation.b.c Od = Oo.Od();
                if (Od != null) {
                    com.baidu.swan.apps.adaptation.b.f IJ = Od.IJ();
                    if (IJ != null) {
                        dVar = IJ.IO();
                    } else {
                        dVar = Od.IO();
                    }
                } else {
                    return;
                }
            }
            if (dVar != null && dVar.bbB > 0) {
                com.baidu.swan.apps.statistic.c.a(dVar);
            }
        }
    }

    private static void YL() {
        if (!com.baidu.swan.apps.statistic.c.aeV()) {
            com.baidu.swan.apps.core.d.d Oo = com.baidu.swan.apps.y.f.WS().Oo();
            if (Oo == null) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "NAArrival：top fragment is null");
                }
            } else if (!f(Oo)) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start na report");
                }
                YM();
            } else {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start check for na arrival");
                }
                jD(Oo.NZ());
            }
        }
    }

    private static void jD(final String str) {
        ai.l(new Runnable() { // from class: com.baidu.swan.apps.ac.e.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.core.d.e GC;
                com.baidu.swan.apps.core.d.d Oo;
                SwanAppActivity WD = com.baidu.swan.apps.y.f.WS().WD();
                if (WD != null && !WD.isFinishing() && !WD.isDestroyed() && (GC = WD.GC()) != null && (Oo = GC.Oo()) != null) {
                    final Bitmap agX = af.agX();
                    AbsoluteLayout iT = com.baidu.swan.apps.y.f.WS().iT(str);
                    final int e = c.e(Oo);
                    final Rect a = c.a(agX, Oo, iT);
                    m.agM().execute(new Runnable() { // from class: com.baidu.swan.apps.ac.e.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.apps.ac.b.a jE = a.C0200a.jE("simple_parser");
                            jE.fB(e);
                            if (!jE.a(agX, a)) {
                                e.YM();
                            }
                        }
                    }, "SwanNAArrivalCheck");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void YM() {
        b.a aVar = null;
        if (com.baidu.swan.apps.runtime.e.acF() != null) {
            aVar = com.baidu.swan.apps.runtime.e.acF().GE();
        }
        com.baidu.swan.apps.statistic.c.b(aVar);
    }

    public static boolean YN() {
        return bFL;
    }
}
