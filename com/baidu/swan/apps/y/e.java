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

    public static void aGl() {
    }

    public static void gp(boolean z) {
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "on swan page change, isFromRoute : " + z);
        }
        if (z && com.baidu.swan.apps.statistic.e.aPd()) {
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
            aGo();
        }
        com.baidu.swan.apps.statistic.e.aOV();
        aGn();
        com.baidu.swan.apps.runtime.e aMk = com.baidu.swan.apps.runtime.e.aMk();
        if (aMk != null && !z) {
            com.baidu.swan.apps.statistic.e.b(aMk.aju());
        }
    }

    public static void aGm() {
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
        boolean equals = TextUtils.equals(dqV, eVar.asD());
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "FirstPage: " + equals);
            return equals;
        }
        return equals;
    }

    private static void aGn() {
        com.baidu.swan.apps.core.d.f ajs;
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "start handle arrival report");
        }
        if (!com.baidu.swan.apps.statistic.e.aPc() && (ajs = com.baidu.swan.apps.v.f.aDG().ajs()) != null) {
            com.baidu.swan.apps.core.d.e asU = ajs.asU();
            com.baidu.swan.apps.adaptation.b.a.d dVar = null;
            if (asU != null) {
                com.baidu.swan.apps.adaptation.b.c asI = asU.asI();
                if (asI != null) {
                    com.baidu.swan.apps.adaptation.b.f amk = asI.amk();
                    if (amk != null) {
                        dVar = amk.amp();
                    } else {
                        dVar = asI.amp();
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

    private static void aGo() {
        if (!com.baidu.swan.apps.statistic.e.aPb()) {
            com.baidu.swan.apps.core.d.e asU = com.baidu.swan.apps.v.f.aDG().asU();
            if (asU == null) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "NAArrival：top fragment is null");
                }
            } else if (!g(asU)) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start na report");
                }
                aGp();
            } else {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start check for na arrival");
                }
                qQ(asU.asD());
            }
        }
    }

    private static void qQ(final String str) {
        ak.l(new Runnable() { // from class: com.baidu.swan.apps.y.e.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.core.d.f ajs;
                com.baidu.swan.apps.core.d.e asU;
                SwanAppActivity aDq = com.baidu.swan.apps.v.f.aDG().aDq();
                if (aDq != null && !aDq.isFinishing() && !aDq.isDestroyed() && (ajs = aDq.ajs()) != null && (asU = ajs.asU()) != null) {
                    final Bitmap aRF = ah.aRF();
                    AbsoluteLayout qh = com.baidu.swan.apps.v.f.aDG().qh(str);
                    final int f = c.f(asU);
                    final Rect a2 = c.a(aRF, asU, qh);
                    p.aRq().execute(new Runnable() { // from class: com.baidu.swan.apps.y.e.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.apps.y.b.a qR = a.C0502a.qR("simple_parser");
                            qR.jR(f);
                            if (!qR.a(aRF, a2)) {
                                e.aGp();
                            }
                        }
                    }, "SwanNAArrivalCheck");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aGp() {
        b.a aVar = null;
        if (com.baidu.swan.apps.runtime.e.aMk() != null) {
            aVar = com.baidu.swan.apps.runtime.e.aMk().aju();
        }
        com.baidu.swan.apps.statistic.e.c(aVar);
    }

    public static boolean aGq() {
        return dqW;
    }
}
