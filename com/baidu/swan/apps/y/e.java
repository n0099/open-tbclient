package com.baidu.swan.apps.y;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Log;
import android.widget.AbsoluteLayout;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.apps.y.b.a;
/* loaded from: classes9.dex */
public final class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile String dqV = "";
    private static volatile boolean dqW = true;

    public static void aGm() {
    }

    public static void gp(boolean z) {
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "on swan page change, isFromRoute : " + z);
        }
        if (z && com.baidu.swan.apps.statistic.e.aPe()) {
            if (DEBUG) {
                Log.d("SwanArrivalMonitor", "end handle swan page change");
                return;
            }
            return;
        }
        if (z) {
            dqW = false;
        }
        if (!z) {
            aGp();
        }
        com.baidu.swan.apps.statistic.e.aOW();
        aGo();
        com.baidu.swan.apps.runtime.e aMl = com.baidu.swan.apps.runtime.e.aMl();
        if (aMl != null && !z) {
            com.baidu.swan.apps.statistic.e.b(aMl.ajv());
        }
    }

    public static void aGn() {
        dqV = "";
        dqW = true;
    }

    public static void qP(String str) {
        dqV = str;
    }

    public static boolean g(com.baidu.swan.apps.core.d.e eVar) {
        if (eVar == null) {
            return false;
        }
        boolean equals = TextUtils.equals(dqV, eVar.asE());
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "FirstPage: " + equals);
            return equals;
        }
        return equals;
    }

    private static void aGo() {
        com.baidu.swan.apps.core.d.f ajt;
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "start handle arrival report");
        }
        if (!com.baidu.swan.apps.statistic.e.aPd() && (ajt = com.baidu.swan.apps.v.f.aDH().ajt()) != null) {
            com.baidu.swan.apps.core.d.e asV = ajt.asV();
            com.baidu.swan.apps.adaptation.b.a.d dVar = null;
            if (asV != null) {
                com.baidu.swan.apps.adaptation.b.c asJ = asV.asJ();
                if (asJ != null) {
                    com.baidu.swan.apps.adaptation.b.f aml = asJ.aml();
                    if (aml != null) {
                        dVar = aml.amq();
                    } else {
                        dVar = asJ.amq();
                    }
                } else {
                    return;
                }
            }
            if (dVar != null && dVar.cFJ > 0) {
                com.baidu.swan.apps.statistic.e.a(dVar);
            }
        }
    }

    private static void aGp() {
        if (!com.baidu.swan.apps.statistic.e.aPc()) {
            com.baidu.swan.apps.core.d.e asV = com.baidu.swan.apps.v.f.aDH().asV();
            if (asV == null) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "NAArrival：top fragment is null");
                }
            } else if (!g(asV)) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start na report");
                }
                aGq();
            } else {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start check for na arrival");
                }
                qQ(asV.asE());
            }
        }
    }

    private static void qQ(final String str) {
        ak.l(new Runnable() { // from class: com.baidu.swan.apps.y.e.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.core.d.f ajt;
                com.baidu.swan.apps.core.d.e asV;
                SwanAppActivity aDr = com.baidu.swan.apps.v.f.aDH().aDr();
                if (aDr != null && !aDr.isFinishing() && !aDr.isDestroyed() && (ajt = aDr.ajt()) != null && (asV = ajt.asV()) != null) {
                    final Bitmap aRG = ah.aRG();
                    AbsoluteLayout qh = com.baidu.swan.apps.v.f.aDH().qh(str);
                    final int f = c.f(asV);
                    final Rect a2 = c.a(aRG, asV, qh);
                    p.aRr().execute(new Runnable() { // from class: com.baidu.swan.apps.y.e.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.apps.y.b.a qR = a.C0502a.qR("simple_parser");
                            qR.jR(f);
                            if (!qR.a(aRG, a2)) {
                                e.aGq();
                            }
                        }
                    }, "SwanNAArrivalCheck");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aGq() {
        b.a aVar = null;
        if (com.baidu.swan.apps.runtime.e.aMl() != null) {
            aVar = com.baidu.swan.apps.runtime.e.aMl().ajv();
        }
        com.baidu.swan.apps.statistic.e.c(aVar);
    }

    public static boolean aGr() {
        return dqW;
    }
}
