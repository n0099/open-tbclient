package com.baidu.swan.apps.y;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.android.app.event.EventBusWrapper;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
/* loaded from: classes3.dex */
public class f implements com.baidu.swan.apps.core.f.c, com.baidu.swan.apps.core.f.e {
    private static final boolean DEBUG = com.baidu.swan.apps.runtime.e.DEBUG;
    private static f cGo;
    private boolean cGp;
    private a cGq = new b();

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
    public static f avr() {
        if (cGo == null) {
            synchronized (f.class) {
                if (cGo == null) {
                    cGo = new f();
                }
            }
        }
        return cGo;
    }

    public void eX(boolean z) {
        this.cGp = z;
        if (this.cGp) {
            e.avm();
            com.baidu.swan.apps.statistic.e.aDf();
        }
    }

    public void start() {
        com.baidu.swan.apps.y.a.c cVar;
        b.a aAv;
        long ZE = com.baidu.swan.apps.t.a.apx().ZE();
        if (DEBUG) {
            Log.d("SwanAppPageMonitor", "start page monitoring, delay: " + ZE);
        }
        if (this.cGp) {
            boolean avt = avt();
            if (DEBUG) {
                Log.d("SwanAppPageMonitor", "WhiteScreenForward: switch=" + avt);
            }
            SwanAppActivity ast = com.baidu.swan.apps.v.f.asJ().ast();
            if (avt && ast != null && (aAv = com.baidu.swan.apps.runtime.d.aAn().aAj().aAv()) != null) {
                long currentTimeMillis = System.currentTimeMillis() - aAv.arL();
                ZE -= currentTimeMillis;
                if (ZE < 0) {
                    if (DEBUG) {
                        Log.d("SwanAppPageMonitor", "WhiteScreenMonitor out of time: time=" + currentTimeMillis);
                    }
                    h.b(new com.baidu.swan.apps.statistic.a.d().rO(h.jG(aAv.getAppFrameType())).i(new com.baidu.swan.apps.am.a().bP(5L).bQ(40L).sH("whitescreen monitor out of time: time=" + currentTimeMillis)).a(aAv));
                }
            }
            cVar = new com.baidu.swan.apps.y.a.c(1, null, ZE, true);
            this.cGp = false;
        } else {
            cVar = null;
        }
        if (DEBUG) {
            Log.d("SwanAppPageMonitor", "WhiteScreenMonitor monitortime: " + ZE);
        }
        if (cVar == null) {
            cVar = new com.baidu.swan.apps.y.a.c(1, null, ZE);
        }
        d(cVar);
    }

    public void avs() {
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

    public void eO(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppPageMonitor", "change to " + (z ? "background" : "foreground"));
        }
        d(new com.baidu.swan.apps.y.a.b(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.swan.apps.y.a.c cVar) {
        this.cGq.a(cVar);
    }

    public static void avg() {
        c.avg();
    }

    public static boolean avt() {
        return com.baidu.swan.apps.performance.b.b.awR() ? com.baidu.swan.apps.performance.b.b.avt() : com.baidu.swan.apps.t.a.apx().getSwitch("swan_white_screen_forward", false);
    }

    public void avu() {
        d(new com.baidu.swan.apps.y.a.c(9, null, 6000L));
    }
}
