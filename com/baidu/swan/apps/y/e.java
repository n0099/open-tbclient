package com.baidu.swan.apps.y;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Log;
import android.widget.AbsoluteLayout;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.apps.y.b.a;
/* loaded from: classes7.dex */
public final class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile String deX = "";
    private static volatile boolean deY = true;

    public static void aBI() {
    }

    public static void fR(boolean z) {
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "on swan page change, isFromRoute : " + z);
        }
        if (z && com.baidu.swan.apps.statistic.e.aJF()) {
            if (DEBUG) {
                Log.d("SwanArrivalMonitor", "end handle swan page change");
                return;
            }
            return;
        }
        if (z) {
            deY = false;
        }
        if (!z) {
            aBL();
        }
        com.baidu.swan.apps.statistic.e.aJx();
        aBK();
        com.baidu.swan.apps.runtime.e aGM = com.baidu.swan.apps.runtime.e.aGM();
        if (aGM != null && !z) {
            com.baidu.swan.apps.statistic.e.b(aGM.afg());
        }
    }

    public static void aBJ() {
        deX = "";
        deY = true;
    }

    public static void qo(String str) {
        deX = str;
    }

    public static boolean g(com.baidu.swan.apps.core.d.e eVar) {
        if (eVar == null) {
            return false;
        }
        boolean equals = TextUtils.equals(deX, eVar.aod());
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "FirstPage: " + equals);
            return equals;
        }
        return equals;
    }

    private static void aBK() {
        com.baidu.swan.apps.core.d.f afe;
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "start handle arrival report");
        }
        if (!com.baidu.swan.apps.statistic.e.aJE() && (afe = com.baidu.swan.apps.v.f.azg().afe()) != null) {
            com.baidu.swan.apps.core.d.e aou = afe.aou();
            com.baidu.swan.apps.adaptation.b.a.d dVar = null;
            if (aou != null) {
                com.baidu.swan.apps.adaptation.b.c aoi = aou.aoi();
                if (aoi != null) {
                    com.baidu.swan.apps.adaptation.b.f ahS = aoi.ahS();
                    if (ahS != null) {
                        dVar = ahS.ahX();
                    } else {
                        dVar = aoi.ahX();
                    }
                } else {
                    return;
                }
            }
            if (dVar != null && dVar.ctZ > 0) {
                com.baidu.swan.apps.statistic.e.a(dVar);
            }
        }
    }

    private static void aBL() {
        if (!com.baidu.swan.apps.statistic.e.aJD()) {
            com.baidu.swan.apps.core.d.e aou = com.baidu.swan.apps.v.f.azg().aou();
            if (aou == null) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "NAArrival：top fragment is null");
                }
            } else if (!g(aou)) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start na report");
                }
                aBM();
            } else {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start check for na arrival");
                }
                qp(aou.aod());
            }
        }
    }

    private static void qp(final String str) {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.y.e.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.core.d.f afe;
                com.baidu.swan.apps.core.d.e aou;
                SwanAppActivity ayQ = com.baidu.swan.apps.v.f.azg().ayQ();
                if (ayQ != null && !ayQ.isFinishing() && !ayQ.isDestroyed() && (afe = ayQ.afe()) != null && (aou = afe.aou()) != null) {
                    final Bitmap aMh = ah.aMh();
                    AbsoluteLayout pH = com.baidu.swan.apps.v.f.azg().pH(str);
                    final int f = c.f(aou);
                    final Rect a2 = c.a(aMh, aou, pH);
                    p.aLS().execute(new Runnable() { // from class: com.baidu.swan.apps.y.e.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.apps.y.b.a qq = a.C0497a.qq("simple_parser");
                            qq.jy(f);
                            if (!qq.a(aMh, a2)) {
                                e.aBM();
                            }
                        }
                    }, "SwanNAArrivalCheck");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aBM() {
        b.a aVar = null;
        if (com.baidu.swan.apps.runtime.e.aGM() != null) {
            aVar = com.baidu.swan.apps.runtime.e.aGM().afg();
        }
        com.baidu.swan.apps.statistic.e.c(aVar);
    }

    public static boolean aBN() {
        return deY;
    }
}
