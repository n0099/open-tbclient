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
    private static f dgK;
    private boolean dgL;
    private a dgM = new b();

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
    public static f aCw() {
        if (dgK == null) {
            synchronized (f.class) {
                if (dgK == null) {
                    dgK = new f();
                }
            }
        }
        return dgK;
    }

    public void fP(boolean z) {
        this.dgL = z;
        if (this.dgL) {
            e.aCr();
            com.baidu.swan.apps.statistic.e.aKi();
        }
    }

    public void start() {
        com.baidu.swan.apps.y.a.c cVar;
        b.a aHy;
        long agK = com.baidu.swan.apps.t.a.awD().agK();
        if (DEBUG) {
            Log.d("SwanAppPageMonitor", "start page monitoring, delay: " + agK);
        }
        if (this.dgL) {
            boolean aCy = aCy();
            if (DEBUG) {
                Log.d("SwanAppPageMonitor", "WhiteScreenForward: switch=" + aCy);
            }
            SwanAppActivity azy = com.baidu.swan.apps.v.f.azO().azy();
            if (aCy && azy != null && (aHy = com.baidu.swan.apps.runtime.d.aHq().aHm().aHy()) != null) {
                long currentTimeMillis = System.currentTimeMillis() - aHy.ayR();
                agK -= currentTimeMillis;
                if (agK < 0) {
                    if (DEBUG) {
                        Log.d("SwanAppPageMonitor", "WhiteScreenMonitor out of time: time=" + currentTimeMillis);
                    }
                    h.b(new com.baidu.swan.apps.statistic.a.d().ti(h.ky(aHy.getAppFrameType())).i(new com.baidu.swan.apps.am.a().cv(5L).cw(40L).ua("whitescreen monitor out of time: time=" + currentTimeMillis)).a(aHy));
                }
            }
            cVar = new com.baidu.swan.apps.y.a.c(1, null, agK, true);
            this.dgL = false;
        } else {
            cVar = null;
        }
        if (DEBUG) {
            Log.d("SwanAppPageMonitor", "WhiteScreenMonitor monitortime: " + agK);
        }
        if (cVar == null) {
            cVar = new com.baidu.swan.apps.y.a.c(1, null, agK);
        }
        d(cVar);
    }

    public void aCx() {
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

    public void fG(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppPageMonitor", "change to " + (z ? "background" : "foreground"));
        }
        d(new com.baidu.swan.apps.y.a.b(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.swan.apps.y.a.c cVar) {
        this.dgM.a(cVar);
    }

    public static void aCl() {
        c.aCl();
    }

    public static boolean aCy() {
        return com.baidu.swan.apps.performance.b.b.aDW() ? com.baidu.swan.apps.performance.b.b.aCy() : com.baidu.swan.apps.t.a.awD().getSwitch("swan_white_screen_forward", false);
    }

    public void aCz() {
        d(new com.baidu.swan.apps.y.a.c(9, null, 6000L));
    }
}
