package com.baidu.swan.apps.aa;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Log;
import android.widget.AbsoluteLayout;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.aa.b.a;
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.n;
import com.baidu.swan.apps.v.b.b;
/* loaded from: classes11.dex */
public final class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile String cpt = "";
    private static volatile boolean cpv = true;

    public static void akj() {
    }

    public static void es(boolean z) {
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "on swan page change, isFromRoute : " + z);
        }
        if (z && com.baidu.swan.apps.statistic.e.arn()) {
            if (DEBUG) {
                Log.d("SwanArrivalMonitor", "end handle swan page change");
                return;
            }
            return;
        }
        if (z) {
            cpv = false;
        }
        if (!z) {
            akm();
        }
        com.baidu.swan.apps.statistic.e.arg();
        akl();
        com.baidu.swan.apps.runtime.e aoF = com.baidu.swan.apps.runtime.e.aoF();
        if (aoF != null && !z) {
            com.baidu.swan.apps.statistic.e.a(aoF.QJ());
        }
    }

    public static void akk() {
        cpt = "";
        cpv = true;
    }

    public static void mc(String str) {
        cpt = str;
    }

    public static boolean f(com.baidu.swan.apps.core.d.d dVar) {
        if (dVar == null) {
            return false;
        }
        boolean equals = TextUtils.equals(cpt, dVar.YB());
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "FirstPage: " + equals);
            return equals;
        }
        return equals;
    }

    private static void akl() {
        com.baidu.swan.apps.core.d.e QH;
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "start handle arrival report");
        }
        if (!com.baidu.swan.apps.statistic.e.arm() && (QH = com.baidu.swan.apps.w.f.ahV().QH()) != null) {
            com.baidu.swan.apps.core.d.d YQ = QH.YQ();
            com.baidu.swan.apps.adaptation.b.a.d dVar = null;
            if (YQ != null) {
                com.baidu.swan.apps.adaptation.b.c YG = YQ.YG();
                if (YG != null) {
                    com.baidu.swan.apps.adaptation.b.f Tb = YG.Tb();
                    if (Tb != null) {
                        dVar = Tb.Tg();
                    } else {
                        dVar = YG.Tg();
                    }
                } else {
                    return;
                }
            }
            if (dVar != null && dVar.bHR > 0) {
                com.baidu.swan.apps.statistic.e.a(dVar);
            }
        }
    }

    private static void akm() {
        if (!com.baidu.swan.apps.statistic.e.arl()) {
            com.baidu.swan.apps.core.d.d YQ = com.baidu.swan.apps.w.f.ahV().YQ();
            if (YQ == null) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "NAArrival：top fragment is null");
                }
            } else if (!f(YQ)) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start na report");
                }
                akn();
            } else {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start check for na arrival");
                }
                md(YQ.YB());
            }
        }
    }

    private static void md(final String str) {
        aj.p(new Runnable() { // from class: com.baidu.swan.apps.aa.e.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.core.d.e QH;
                com.baidu.swan.apps.core.d.d YQ;
                SwanAppActivity ahF = com.baidu.swan.apps.w.f.ahV().ahF();
                if (ahF != null && !ahF.isFinishing() && !ahF.isDestroyed() && (QH = ahF.QH()) != null && (YQ = QH.YQ()) != null) {
                    final Bitmap atH = ag.atH();
                    AbsoluteLayout ls = com.baidu.swan.apps.w.f.ahV().ls(str);
                    final int e = c.e(YQ);
                    final Rect a = c.a(atH, YQ, ls);
                    n.atv().execute(new Runnable() { // from class: com.baidu.swan.apps.aa.e.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.apps.aa.b.a me = a.C0283a.me("simple_parser");
                            me.fZ(e);
                            if (!me.a(atH, a)) {
                                e.akn();
                            }
                        }
                    }, "SwanNAArrivalCheck");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void akn() {
        b.a aVar = null;
        if (com.baidu.swan.apps.runtime.e.aoF() != null) {
            aVar = com.baidu.swan.apps.runtime.e.aoF().QJ();
        }
        com.baidu.swan.apps.statistic.e.b(aVar);
    }

    public static boolean ako() {
        return cpv;
    }
}
