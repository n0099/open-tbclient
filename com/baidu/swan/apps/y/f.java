package com.baidu.swan.apps.y;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.android.app.event.EventBusWrapper;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
/* loaded from: classes10.dex */
public class f implements com.baidu.swan.apps.core.f.c, com.baidu.swan.apps.core.f.e {
    private static final boolean DEBUG = com.baidu.swan.apps.runtime.e.DEBUG;
    private static f cSr;
    private boolean cSs;
    private a cSt = new b();

    private f() {
        EventBusWrapper.lazyRegister("dialog_event_tag", com.baidu.swan.apps.res.widget.dialog.a.class, new rx.functions.b<com.baidu.swan.apps.res.widget.dialog.a>() { // from class: com.baidu.swan.apps.y.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: a */
            public void call(com.baidu.swan.apps.res.widget.dialog.a aVar) {
                f.this.d(new com.baidu.swan.apps.y.a.a(aVar));
            }
        });
    }

    @NonNull
    public static f ayc() {
        if (cSr == null) {
            synchronized (f.class) {
                if (cSr == null) {
                    cSr = new f();
                }
            }
        }
        return cSr;
    }

    public void ft(boolean z) {
        this.cSs = z;
        if (this.cSs) {
            e.axX();
            com.baidu.swan.apps.statistic.e.aFO();
        }
    }

    public void start() {
        com.baidu.swan.apps.y.a.c cVar;
        b.a aDe;
        long acq = com.baidu.swan.apps.t.a.asi().acq();
        if (DEBUG) {
            Log.d("SwanAppPageMonitor", "start page monitoring, delay: " + acq);
        }
        if (this.cSs) {
            boolean aye = aye();
            if (DEBUG) {
                Log.d("SwanAppPageMonitor", "WhiteScreenForward: switch=" + aye);
            }
            SwanAppActivity ave = com.baidu.swan.apps.v.f.avu().ave();
            if (aye && ave != null && (aDe = com.baidu.swan.apps.runtime.d.aCW().aCS().aDe()) != null) {
                long currentTimeMillis = System.currentTimeMillis() - aDe.aux();
                acq -= currentTimeMillis;
                if (acq < 0) {
                    if (DEBUG) {
                        Log.d("SwanAppPageMonitor", "WhiteScreenMonitor out of time: time=" + currentTimeMillis);
                    }
                    h.b(new com.baidu.swan.apps.statistic.a.d().sB(h.kd(aDe.getAppFrameType())).i(new com.baidu.swan.apps.am.a().bX(5L).bY(40L).tt("whitescreen monitor out of time: time=" + currentTimeMillis)).a(aDe));
                }
            }
            cVar = new com.baidu.swan.apps.y.a.c(1, null, acq, true);
            this.cSs = false;
        } else {
            cVar = null;
        }
        if (DEBUG) {
            Log.d("SwanAppPageMonitor", "WhiteScreenMonitor monitortime: " + acq);
        }
        if (cVar == null) {
            cVar = new com.baidu.swan.apps.y.a.c(1, null, acq);
        }
        d(cVar);
    }

    public void ayd() {
        if (DEBUG) {
            Log.d("SwanAppPageMonitor", "stop page monitoring");
        }
        d(new com.baidu.swan.apps.y.a.c(7));
    }

    @Override // com.baidu.swan.apps.core.f.c
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        if (i3 != 0 || i4 != 0 || i != 0 || i2 != 1) {
            d(new com.baidu.swan.apps.y.a.c(3));
        }
    }

    @Override // com.baidu.swan.apps.core.f.e
    public void a(com.baidu.swan.apps.adaptation.b.f fVar) {
        if (DEBUG) {
            Log.d("SwanAppPageMonitor", "webview insert event");
        }
        d(new com.baidu.swan.apps.y.a.e(fVar, true));
    }

    @Override // com.baidu.swan.apps.core.f.e
    public void b(com.baidu.swan.apps.adaptation.b.f fVar) {
        if (DEBUG) {
            Log.d("SwanAppPageMonitor", "webview remove event");
        }
        d(new com.baidu.swan.apps.y.a.e(fVar, false));
    }

    public void fk(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppPageMonitor", "change to " + (z ? "background" : "foreground"));
        }
        d(new com.baidu.swan.apps.y.a.b(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.swan.apps.y.a.c cVar) {
        this.cSt.a(cVar);
    }

    public static void axR() {
        c.axR();
    }

    public static boolean aye() {
        return com.baidu.swan.apps.performance.b.b.azC() ? com.baidu.swan.apps.performance.b.b.aye() : com.baidu.swan.apps.t.a.asi().getSwitch("swan_white_screen_forward", false);
    }

    public void ayf() {
        d(new com.baidu.swan.apps.y.a.c(9, null, 6000L));
    }
}
