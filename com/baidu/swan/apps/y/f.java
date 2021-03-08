package com.baidu.swan.apps.y;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.app.event.EventBusWrapper;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
/* loaded from: classes8.dex */
public class f implements com.baidu.swan.apps.core.f.c, com.baidu.swan.apps.core.f.e {
    private static final boolean DEBUG = com.baidu.swan.apps.runtime.e.DEBUG;
    private static f dqa;
    private boolean dqb;
    private a dqc = new b();

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
    public static f aCX() {
        if (dqa == null) {
            synchronized (f.class) {
                if (dqa == null) {
                    dqa = new f();
                }
            }
        }
        return dqa;
    }

    public void go(boolean z) {
        this.dqb = z;
        if (this.dqb) {
            e.aCS();
            com.baidu.swan.apps.statistic.e.aLB();
        }
    }

    public void start() {
        com.baidu.swan.apps.y.a.c cVar;
        b.a aIR;
        long aha = com.baidu.swan.apps.t.a.axc().aha();
        if (DEBUG) {
            Log.d("SwanAppPageMonitor", "start page monitoring, delay: " + aha);
        }
        if (this.dqb) {
            boolean aCZ = aCZ();
            if (DEBUG) {
                Log.d("SwanAppPageMonitor", "WhiteScreenForward: switch=" + aCZ);
            }
            SwanAppActivity azY = com.baidu.swan.apps.v.f.aAo().azY();
            if (aCZ && azY != null && (aIR = com.baidu.swan.apps.runtime.d.aIJ().aIF().aIR()) != null) {
                long currentTimeMillis = System.currentTimeMillis() - aIR.azr();
                aha -= currentTimeMillis;
                if (aha < 0) {
                    if (DEBUG) {
                        Log.d("SwanAppPageMonitor", "WhiteScreenMonitor out of time: time=" + currentTimeMillis);
                    }
                    h.b(new com.baidu.swan.apps.statistic.a.d().sW(h.jv(aIR.getAppFrameType())).i(new com.baidu.swan.apps.al.a().db(5L).dc(40L).tO("whitescreen monitor out of time: time=" + currentTimeMillis)).a(aIR));
                }
            }
            cVar = new com.baidu.swan.apps.y.a.c(1, null, aha, true);
            this.dqb = false;
        } else {
            cVar = null;
        }
        if (DEBUG) {
            Log.d("SwanAppPageMonitor", "WhiteScreenMonitor monitortime: " + aha);
        }
        if (cVar == null) {
            cVar = new com.baidu.swan.apps.y.a.c(1, null, aha);
        }
        d(cVar);
    }

    public void aCY() {
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
        this.dqc.a(cVar);
    }

    public static void aCM() {
        c.aCM();
    }

    public static boolean aCZ() {
        return com.baidu.swan.apps.performance.b.b.aEu() ? com.baidu.swan.apps.performance.b.b.aCZ() : com.baidu.swan.apps.t.a.axc().getSwitch("swan_white_screen_forward", false);
    }

    public void aDa() {
        d(new com.baidu.swan.apps.y.a.c(9, null, 6000L));
    }
}
