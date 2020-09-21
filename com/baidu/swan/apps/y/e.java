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
/* loaded from: classes3.dex */
public final class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile String cGi = "";
    private static volatile boolean cGj = true;

    public static void avl() {
    }

    public static void eW(boolean z) {
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "on swan page change, isFromRoute : " + z);
        }
        if (z && com.baidu.swan.apps.statistic.e.aDk()) {
            if (DEBUG) {
                Log.d("SwanArrivalMonitor", "end handle swan page change");
                return;
            }
            return;
        }
        if (z) {
            cGj = false;
        }
        if (!z) {
            avo();
        }
        com.baidu.swan.apps.statistic.e.aDc();
        avn();
        com.baidu.swan.apps.runtime.e aAr = com.baidu.swan.apps.runtime.e.aAr();
        if (aAr != null && !z) {
            com.baidu.swan.apps.statistic.e.b(aAr.YI());
        }
    }

    public static void avm() {
        cGi = "";
        cGj = true;
    }

    public static void pb(String str) {
        cGi = str;
    }

    public static boolean g(com.baidu.swan.apps.core.d.e eVar) {
        if (eVar == null) {
            return false;
        }
        boolean equals = TextUtils.equals(cGi, eVar.ahG());
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "FirstPage: " + equals);
            return equals;
        }
        return equals;
    }

    private static void avn() {
        com.baidu.swan.apps.core.d.f YG;
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "start handle arrival report");
        }
        if (!com.baidu.swan.apps.statistic.e.aDj() && (YG = com.baidu.swan.apps.v.f.asJ().YG()) != null) {
            com.baidu.swan.apps.core.d.e ahX = YG.ahX();
            com.baidu.swan.apps.adaptation.b.a.d dVar = null;
            if (ahX != null) {
                com.baidu.swan.apps.adaptation.b.c ahL = ahX.ahL();
                if (ahL != null) {
                    com.baidu.swan.apps.adaptation.b.f abu = ahL.abu();
                    if (abu != null) {
                        dVar = abu.abz();
                    } else {
                        dVar = ahL.abz();
                    }
                } else {
                    return;
                }
            }
            if (dVar != null && dVar.bUY > 0) {
                com.baidu.swan.apps.statistic.e.a(dVar);
            }
        }
    }

    private static void avo() {
        if (!com.baidu.swan.apps.statistic.e.aDi()) {
            com.baidu.swan.apps.core.d.e ahX = com.baidu.swan.apps.v.f.asJ().ahX();
            if (ahX == null) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "NAArrival：top fragment is null");
                }
            } else if (!g(ahX)) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start na report");
                }
                avp();
            } else {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start check for na arrival");
                }
                pc(ahX.ahG());
            }
        }
    }

    private static void pc(final String str) {
        ak.m(new Runnable() { // from class: com.baidu.swan.apps.y.e.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.core.d.f YG;
                com.baidu.swan.apps.core.d.e ahX;
                SwanAppActivity ast = com.baidu.swan.apps.v.f.asJ().ast();
                if (ast != null && !ast.isFinishing() && !ast.isDestroyed() && (YG = ast.YG()) != null && (ahX = YG.ahX()) != null) {
                    final Bitmap aFM = ah.aFM();
                    AbsoluteLayout ou = com.baidu.swan.apps.v.f.asJ().ou(str);
                    final int f = c.f(ahX);
                    final Rect a = c.a(aFM, ahX, ou);
                    p.aFx().execute(new Runnable() { // from class: com.baidu.swan.apps.y.e.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.apps.y.b.a pd = a.C0456a.pd("simple_parser");
                            pd.iK(f);
                            if (!pd.a(aFM, a)) {
                                e.avp();
                            }
                        }
                    }, "SwanNAArrivalCheck");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void avp() {
        b.a aVar = null;
        if (com.baidu.swan.apps.runtime.e.aAr() != null) {
            aVar = com.baidu.swan.apps.runtime.e.aAr().YI();
        }
        com.baidu.swan.apps.statistic.e.c(aVar);
    }

    public static boolean avq() {
        return cGj;
    }
}
