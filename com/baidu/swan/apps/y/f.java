package com.baidu.swan.apps.y;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.android.app.event.EventBusWrapper;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
/* loaded from: classes7.dex */
public class f implements com.baidu.swan.apps.core.f.c, com.baidu.swan.apps.core.f.e {
    private static final boolean DEBUG = com.baidu.swan.apps.runtime.e.DEBUG;
    private static f dfd;
    private boolean dfe;
    private a dff = new b();

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
    public static f aBO() {
        if (dfd == null) {
            synchronized (f.class) {
                if (dfd == null) {
                    dfd = new f();
                }
            }
        }
        return dfd;
    }

    public void fS(boolean z) {
        this.dfe = z;
        if (this.dfe) {
            e.aBJ();
            com.baidu.swan.apps.statistic.e.aJA();
        }
    }

    public void start() {
        com.baidu.swan.apps.y.a.c cVar;
        b.a aGQ;
        long agc = com.baidu.swan.apps.t.a.avV().agc();
        if (DEBUG) {
            Log.d("SwanAppPageMonitor", "start page monitoring, delay: " + agc);
        }
        if (this.dfe) {
            boolean aBQ = aBQ();
            if (DEBUG) {
                Log.d("SwanAppPageMonitor", "WhiteScreenForward: switch=" + aBQ);
            }
            SwanAppActivity ayQ = com.baidu.swan.apps.v.f.azg().ayQ();
            if (aBQ && ayQ != null && (aGQ = com.baidu.swan.apps.runtime.d.aGI().aGE().aGQ()) != null) {
                long currentTimeMillis = System.currentTimeMillis() - aGQ.ayj();
                agc -= currentTimeMillis;
                if (agc < 0) {
                    if (DEBUG) {
                        Log.d("SwanAppPageMonitor", "WhiteScreenMonitor out of time: time=" + currentTimeMillis);
                    }
                    h.b(new com.baidu.swan.apps.statistic.a.d().td(h.ku(aGQ.getAppFrameType())).i(new com.baidu.swan.apps.am.a().cv(5L).cw(40L).tV("whitescreen monitor out of time: time=" + currentTimeMillis)).a(aGQ));
                }
            }
            cVar = new com.baidu.swan.apps.y.a.c(1, null, agc, true);
            this.dfe = false;
        } else {
            cVar = null;
        }
        if (DEBUG) {
            Log.d("SwanAppPageMonitor", "WhiteScreenMonitor monitortime: " + agc);
        }
        if (cVar == null) {
            cVar = new com.baidu.swan.apps.y.a.c(1, null, agc);
        }
        d(cVar);
    }

    public void aBP() {
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

    public void fJ(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppPageMonitor", "change to " + (z ? "background" : "foreground"));
        }
        d(new com.baidu.swan.apps.y.a.b(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.swan.apps.y.a.c cVar) {
        this.dff.a(cVar);
    }

    public static void aBD() {
        c.aBD();
    }

    public static boolean aBQ() {
        return com.baidu.swan.apps.performance.b.b.aDo() ? com.baidu.swan.apps.performance.b.b.aBQ() : com.baidu.swan.apps.t.a.avV().getSwitch("swan_white_screen_forward", false);
    }

    public void aBR() {
        d(new com.baidu.swan.apps.y.a.c(9, null, 6000L));
    }
}
