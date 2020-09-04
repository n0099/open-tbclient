package com.baidu.swan.apps.y;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.android.app.event.EventBusWrapper;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
/* loaded from: classes8.dex */
public class f implements com.baidu.swan.apps.core.f.c, com.baidu.swan.apps.core.f.e {
    private static final boolean DEBUG = com.baidu.swan.apps.runtime.e.DEBUG;
    private static f cEo;
    private boolean cEp;
    private a cEq = new b();

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
    public static f auI() {
        if (cEo == null) {
            synchronized (f.class) {
                if (cEo == null) {
                    cEo = new f();
                }
            }
        }
        return cEo;
    }

    public void eZ(boolean z) {
        this.cEp = z;
        if (this.cEp) {
            e.auD();
            com.baidu.swan.apps.statistic.e.aCv();
        }
    }

    public void start() {
        com.baidu.swan.apps.y.a.c cVar;
        b.a azM;
        long YV = com.baidu.swan.apps.t.a.aoM().YV();
        if (DEBUG) {
            Log.d("SwanAppPageMonitor", "start page monitoring, delay: " + YV);
        }
        if (this.cEp) {
            boolean auK = auK();
            if (DEBUG) {
                Log.d("SwanAppPageMonitor", "WhiteScreenForward: switch=" + auK);
            }
            SwanAppActivity arI = com.baidu.swan.apps.v.f.arY().arI();
            if (auK && arI != null && (azM = com.baidu.swan.apps.runtime.d.azE().azA().azM()) != null) {
                long currentTimeMillis = System.currentTimeMillis() - azM.arb();
                YV -= currentTimeMillis;
                if (YV < 0) {
                    if (DEBUG) {
                        Log.d("SwanAppPageMonitor", "WhiteScreenMonitor out of time: time=" + currentTimeMillis);
                    }
                    h.b(new com.baidu.swan.apps.statistic.a.d().rv(h.jv(azM.getAppFrameType())).i(new com.baidu.swan.apps.am.a().bO(5L).bP(40L).sn("whitescreen monitor out of time: time=" + currentTimeMillis)).a(azM));
                }
            }
            cVar = new com.baidu.swan.apps.y.a.c(1, null, YV, true);
            this.cEp = false;
        } else {
            cVar = null;
        }
        if (DEBUG) {
            Log.d("SwanAppPageMonitor", "WhiteScreenMonitor monitortime: " + YV);
        }
        if (cVar == null) {
            cVar = new com.baidu.swan.apps.y.a.c(1, null, YV);
        }
        d(cVar);
    }

    public void auJ() {
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

    public void eQ(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppPageMonitor", "change to " + (z ? "background" : "foreground"));
        }
        d(new com.baidu.swan.apps.y.a.b(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.swan.apps.y.a.c cVar) {
        this.cEq.a(cVar);
    }

    public static void aux() {
        c.aux();
    }

    public static boolean auK() {
        return com.baidu.swan.apps.performance.b.b.awi() ? com.baidu.swan.apps.performance.b.b.auK() : com.baidu.swan.apps.t.a.aoM().getSwitch("swan_white_screen_forward", false);
    }

    public void auL() {
        d(new com.baidu.swan.apps.y.a.c(9, null, 6000L));
    }
}
