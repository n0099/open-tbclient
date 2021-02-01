package com.baidu.swan.apps.y;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.app.event.EventBusWrapper;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
/* loaded from: classes9.dex */
public class f implements com.baidu.swan.apps.core.f.c, com.baidu.swan.apps.core.f.e {
    private static final boolean DEBUG = com.baidu.swan.apps.runtime.e.DEBUG;
    private static f doy;
    private a doA = new b();
    private boolean doz;

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
    public static f aCU() {
        if (doy == null) {
            synchronized (f.class) {
                if (doy == null) {
                    doy = new f();
                }
            }
        }
        return doy;
    }

    public void go(boolean z) {
        this.doz = z;
        if (this.doz) {
            e.aCP();
            com.baidu.swan.apps.statistic.e.aLy();
        }
    }

    public void start() {
        com.baidu.swan.apps.y.a.c cVar;
        b.a aIO;
        long agX = com.baidu.swan.apps.t.a.awZ().agX();
        if (DEBUG) {
            Log.d("SwanAppPageMonitor", "start page monitoring, delay: " + agX);
        }
        if (this.doz) {
            boolean aCW = aCW();
            if (DEBUG) {
                Log.d("SwanAppPageMonitor", "WhiteScreenForward: switch=" + aCW);
            }
            SwanAppActivity azV = com.baidu.swan.apps.v.f.aAl().azV();
            if (aCW && azV != null && (aIO = com.baidu.swan.apps.runtime.d.aIG().aIC().aIO()) != null) {
                long currentTimeMillis = System.currentTimeMillis() - aIO.azo();
                agX -= currentTimeMillis;
                if (agX < 0) {
                    if (DEBUG) {
                        Log.d("SwanAppPageMonitor", "WhiteScreenMonitor out of time: time=" + currentTimeMillis);
                    }
                    h.b(new com.baidu.swan.apps.statistic.a.d().sP(h.ju(aIO.getAppFrameType())).i(new com.baidu.swan.apps.al.a().db(5L).dc(40L).tH("whitescreen monitor out of time: time=" + currentTimeMillis)).a(aIO));
                }
            }
            cVar = new com.baidu.swan.apps.y.a.c(1, null, agX, true);
            this.doz = false;
        } else {
            cVar = null;
        }
        if (DEBUG) {
            Log.d("SwanAppPageMonitor", "WhiteScreenMonitor monitortime: " + agX);
        }
        if (cVar == null) {
            cVar = new com.baidu.swan.apps.y.a.c(1, null, agX);
        }
        d(cVar);
    }

    public void aCV() {
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

    public void gf(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppPageMonitor", "change to " + (z ? "background" : "foreground"));
        }
        d(new com.baidu.swan.apps.y.a.b(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.swan.apps.y.a.c cVar) {
        this.doA.a(cVar);
    }

    public static void aCJ() {
        c.aCJ();
    }

    public static boolean aCW() {
        return com.baidu.swan.apps.performance.b.b.aEr() ? com.baidu.swan.apps.performance.b.b.aCW() : com.baidu.swan.apps.t.a.awZ().getSwitch("swan_white_screen_forward", false);
    }

    public void aCX() {
        d(new com.baidu.swan.apps.y.a.c(9, null, 6000L));
    }
}
