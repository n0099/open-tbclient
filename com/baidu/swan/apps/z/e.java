package com.baidu.swan.apps.z;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Log;
import android.widget.AbsoluteLayout;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.aq.p;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.apps.z.b.a;
/* loaded from: classes7.dex */
public final class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile String cwk = "";
    private static volatile boolean cwl = true;

    public static void amG() {
    }

    public static void eG(boolean z) {
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "on swan page change, isFromRoute : " + z);
        }
        if (z && com.baidu.swan.apps.statistic.e.aur()) {
            if (DEBUG) {
                Log.d("SwanArrivalMonitor", "end handle swan page change");
                return;
            }
            return;
        }
        if (z) {
            cwl = false;
        }
        if (!z) {
            amJ();
        }
        com.baidu.swan.apps.statistic.e.auj();
        amI();
        com.baidu.swan.apps.runtime.e arv = com.baidu.swan.apps.runtime.e.arv();
        if (arv != null && !z) {
            com.baidu.swan.apps.statistic.e.a(arv.Se());
        }
    }

    public static void amH() {
        cwk = "";
        cwl = true;
    }

    public static void mI(String str) {
        cwk = str;
    }

    public static boolean f(com.baidu.swan.apps.core.d.e eVar) {
        if (eVar == null) {
            return false;
        }
        boolean equals = TextUtils.equals(cwk, eVar.aaL());
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "FirstPage: " + equals);
            return equals;
        }
        return equals;
    }

    private static void amI() {
        com.baidu.swan.apps.core.d.f Sc;
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "start handle arrival report");
        }
        if (!com.baidu.swan.apps.statistic.e.auq() && (Sc = com.baidu.swan.apps.v.f.akr().Sc()) != null) {
            com.baidu.swan.apps.core.d.e aba = Sc.aba();
            com.baidu.swan.apps.adaptation.b.a.d dVar = null;
            if (aba != null) {
                com.baidu.swan.apps.adaptation.b.c aaQ = aba.aaQ();
                if (aaQ != null) {
                    com.baidu.swan.apps.adaptation.b.f UI = aaQ.UI();
                    if (UI != null) {
                        dVar = UI.UN();
                    } else {
                        dVar = aaQ.UN();
                    }
                } else {
                    return;
                }
            }
            if (dVar != null && dVar.bNw > 0) {
                com.baidu.swan.apps.statistic.e.a(dVar);
            }
        }
    }

    private static void amJ() {
        if (!com.baidu.swan.apps.statistic.e.aup()) {
            com.baidu.swan.apps.core.d.e aba = com.baidu.swan.apps.v.f.akr().aba();
            if (aba == null) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "NAArrival：top fragment is null");
                }
            } else if (!f(aba)) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start na report");
                }
                amK();
            } else {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start check for na arrival");
                }
                mJ(aba.aaL());
            }
        }
    }

    private static void mJ(final String str) {
        al.p(new Runnable() { // from class: com.baidu.swan.apps.z.e.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.core.d.f Sc;
                com.baidu.swan.apps.core.d.e aba;
                SwanAppActivity akb = com.baidu.swan.apps.v.f.akr().akb();
                if (akb != null && !akb.isFinishing() && !akb.isDestroyed() && (Sc = akb.Sc()) != null && (aba = Sc.aba()) != null) {
                    final Bitmap awT = ai.awT();
                    AbsoluteLayout mb = com.baidu.swan.apps.v.f.akr().mb(str);
                    final int e = c.e(aba);
                    final Rect a = c.a(awT, aba, mb);
                    p.awD().execute(new Runnable() { // from class: com.baidu.swan.apps.z.e.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.apps.z.b.a mK = a.C0416a.mK("simple_parser");
                            mK.gu(e);
                            if (!mK.a(awT, a)) {
                                e.amK();
                            }
                        }
                    }, "SwanNAArrivalCheck");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void amK() {
        b.a aVar = null;
        if (com.baidu.swan.apps.runtime.e.arv() != null) {
            aVar = com.baidu.swan.apps.runtime.e.arv().Se();
        }
        com.baidu.swan.apps.statistic.e.b(aVar);
    }

    public static boolean amL() {
        return cwl;
    }
}
