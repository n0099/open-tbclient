package com.baidu.swan.apps.y;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.android.app.event.EventBusWrapper;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
/* loaded from: classes25.dex */
public class f implements com.baidu.swan.apps.core.f.c, com.baidu.swan.apps.core.f.e {
    private static final boolean DEBUG = com.baidu.swan.apps.runtime.e.DEBUG;
    private static f dmc;
    private boolean dmd;
    private a dme = new b();

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
    public static f aEX() {
        if (dmc == null) {
            synchronized (f.class) {
                if (dmc == null) {
                    dmc = new f();
                }
            }
        }
        return dmc;
    }

    public void gh(boolean z) {
        this.dmd = z;
        if (this.dmd) {
            e.aES();
            com.baidu.swan.apps.statistic.e.aMI();
        }
    }

    public void start() {
        com.baidu.swan.apps.y.a.c cVar;
        b.a aJY;
        long ajk = com.baidu.swan.apps.t.a.azd().ajk();
        if (DEBUG) {
            Log.d("SwanAppPageMonitor", "start page monitoring, delay: " + ajk);
        }
        if (this.dmd) {
            boolean aEZ = aEZ();
            if (DEBUG) {
                Log.d("SwanAppPageMonitor", "WhiteScreenForward: switch=" + aEZ);
            }
            SwanAppActivity aBZ = com.baidu.swan.apps.v.f.aCp().aBZ();
            if (aEZ && aBZ != null && (aJY = com.baidu.swan.apps.runtime.d.aJQ().aJM().aJY()) != null) {
                long currentTimeMillis = System.currentTimeMillis() - aJY.aBs();
                ajk -= currentTimeMillis;
                if (ajk < 0) {
                    if (DEBUG) {
                        Log.d("SwanAppPageMonitor", "WhiteScreenMonitor out of time: time=" + currentTimeMillis);
                    }
                    h.b(new com.baidu.swan.apps.statistic.a.d().tK(h.kS(aJY.getAppFrameType())).i(new com.baidu.swan.apps.am.a().cU(5L).cV(40L).uC("whitescreen monitor out of time: time=" + currentTimeMillis)).a(aJY));
                }
            }
            cVar = new com.baidu.swan.apps.y.a.c(1, null, ajk, true);
            this.dmd = false;
        } else {
            cVar = null;
        }
        if (DEBUG) {
            Log.d("SwanAppPageMonitor", "WhiteScreenMonitor monitortime: " + ajk);
        }
        if (cVar == null) {
            cVar = new com.baidu.swan.apps.y.a.c(1, null, ajk);
        }
        d(cVar);
    }

    public void aEY() {
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

    public void fY(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppPageMonitor", "change to " + (z ? "background" : "foreground"));
        }
        d(new com.baidu.swan.apps.y.a.b(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.swan.apps.y.a.c cVar) {
        this.dme.a(cVar);
    }

    public static void aEM() {
        c.aEM();
    }

    public static boolean aEZ() {
        return com.baidu.swan.apps.performance.b.b.aGw() ? com.baidu.swan.apps.performance.b.b.aEZ() : com.baidu.swan.apps.t.a.azd().getSwitch("swan_white_screen_forward", false);
    }

    public void aFa() {
        d(new com.baidu.swan.apps.y.a.c(9, null, 6000L));
    }
}
