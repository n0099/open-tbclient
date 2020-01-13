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
/* loaded from: classes10.dex */
public final class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile String bBD = "";
    private static volatile boolean bBE = true;

    public static void Ws() {
    }

    public static void cX(boolean z) {
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "on swan page change, isFromRoute : " + z);
        }
        if (z && com.baidu.swan.apps.statistic.c.acH()) {
            if (DEBUG) {
                Log.d("SwanArrivalMonitor", "end handle swan page change");
                return;
            }
            return;
        }
        if (z) {
            bBE = false;
        }
        if (!z) {
            Wv();
        }
        com.baidu.swan.apps.statistic.c.acA();
        Wu();
        com.baidu.swan.apps.runtime.e aap = com.baidu.swan.apps.runtime.e.aap();
        if (aap != null && !z) {
            com.baidu.swan.apps.statistic.c.a(aap.En());
        }
    }

    public static void Wt() {
        bBD = "";
        bBE = true;
    }

    public static void jn(String str) {
        bBD = str;
    }

    public static boolean f(com.baidu.swan.apps.core.d.d dVar) {
        if (dVar == null) {
            return false;
        }
        boolean equals = TextUtils.equals(bBD, dVar.LJ());
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "FirstPage: " + equals);
            return equals;
        }
        return equals;
    }

    private static void Wu() {
        com.baidu.swan.apps.core.d.e El;
        if (DEBUG) {
            Log.d("SwanArrivalMonitor", "start handle arrival report");
        }
        if (!com.baidu.swan.apps.statistic.c.acG() && (El = com.baidu.swan.apps.y.f.UC().El()) != null) {
            com.baidu.swan.apps.core.d.d LY = El.LY();
            com.baidu.swan.apps.adaptation.b.a.d dVar = null;
            if (LY != null) {
                com.baidu.swan.apps.adaptation.b.c LN = LY.LN();
                if (LN != null) {
                    com.baidu.swan.apps.adaptation.b.f Gs = LN.Gs();
                    if (Gs != null) {
                        dVar = Gs.Gx();
                    } else {
                        dVar = LN.Gx();
                    }
                } else {
                    return;
                }
            }
            if (dVar != null && dVar.aXp > 0) {
                com.baidu.swan.apps.statistic.c.a(dVar);
            }
        }
    }

    private static void Wv() {
        if (!com.baidu.swan.apps.statistic.c.acF()) {
            com.baidu.swan.apps.core.d.d LY = com.baidu.swan.apps.y.f.UC().LY();
            if (LY == null) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "NAArrival：top fragment is null");
                }
            } else if (!f(LY)) {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start na report");
                }
                Ww();
            } else {
                if (DEBUG) {
                    Log.d("SwanArrivalMonitor", "start check for na arrival");
                }
                jo(LY.LJ());
            }
        }
    }

    private static void jo(final String str) {
        ai.l(new Runnable() { // from class: com.baidu.swan.apps.ac.e.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.core.d.e El;
                com.baidu.swan.apps.core.d.d LY;
                SwanAppActivity Un = com.baidu.swan.apps.y.f.UC().Un();
                if (Un != null && !Un.isFinishing() && !Un.isDestroyed() && (El = Un.El()) != null && (LY = El.LY()) != null) {
                    final Bitmap aeH = af.aeH();
                    AbsoluteLayout iE = com.baidu.swan.apps.y.f.UC().iE(str);
                    final int e = c.e(LY);
                    final Rect a = c.a(aeH, LY, iE);
                    m.aew().execute(new Runnable() { // from class: com.baidu.swan.apps.ac.e.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.apps.ac.b.a jp = a.C0190a.jp("simple_parser");
                            jp.fl(e);
                            if (!jp.a(aeH, a)) {
                                e.Ww();
                            }
                        }
                    }, "SwanNAArrivalCheck");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Ww() {
        b.a aVar = null;
        if (com.baidu.swan.apps.runtime.e.aap() != null) {
            aVar = com.baidu.swan.apps.runtime.e.aap().En();
        }
        com.baidu.swan.apps.statistic.c.b(aVar);
    }

    public static boolean Wx() {
        return bBE;
    }
}
