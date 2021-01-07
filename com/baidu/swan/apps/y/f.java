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
    private static f drb;
    private boolean drc;
    private a drd = new b();

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
    public static f aGs() {
        if (drb == null) {
            synchronized (f.class) {
                if (drb == null) {
                    drb = new f();
                }
            }
        }
        return drb;
    }

    public void gq(boolean z) {
        this.drc = z;
        if (this.drc) {
            e.aGn();
            com.baidu.swan.apps.statistic.e.aOZ();
        }
    }

    public void start() {
        com.baidu.swan.apps.y.a.c cVar;
        b.a aMp;
        long akt = com.baidu.swan.apps.t.a.aAv().akt();
        if (DEBUG) {
            Log.d("SwanAppPageMonitor", "start page monitoring, delay: " + akt);
        }
        if (this.drc) {
            boolean aGu = aGu();
            if (DEBUG) {
                Log.d("SwanAppPageMonitor", "WhiteScreenForward: switch=" + aGu);
            }
            SwanAppActivity aDr = com.baidu.swan.apps.v.f.aDH().aDr();
            if (aGu && aDr != null && (aMp = com.baidu.swan.apps.runtime.d.aMh().aMd().aMp()) != null) {
                long currentTimeMillis = System.currentTimeMillis() - aMp.aCK();
                akt -= currentTimeMillis;
                if (akt < 0) {
                    if (DEBUG) {
                        Log.d("SwanAppPageMonitor", "WhiteScreenMonitor out of time: time=" + currentTimeMillis);
                    }
                    h.b(new com.baidu.swan.apps.statistic.a.d().tH(h.kX(aMp.getAppFrameType())).i(new com.baidu.swan.apps.al.a().cV(5L).cW(40L).uz("whitescreen monitor out of time: time=" + currentTimeMillis)).a(aMp));
                }
            }
            cVar = new com.baidu.swan.apps.y.a.c(1, null, akt, true);
            this.drc = false;
        } else {
            cVar = null;
        }
        if (DEBUG) {
            Log.d("SwanAppPageMonitor", "WhiteScreenMonitor monitortime: " + akt);
        }
        if (cVar == null) {
            cVar = new com.baidu.swan.apps.y.a.c(1, null, akt);
        }
        d(cVar);
    }

    public void aGt() {
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

    public void gh(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppPageMonitor", "change to " + (z ? "background" : "foreground"));
        }
        d(new com.baidu.swan.apps.y.a.b(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.swan.apps.y.a.c cVar) {
        this.drd.a(cVar);
    }

    public static void aGh() {
        c.aGh();
    }

    public static boolean aGu() {
        return com.baidu.swan.apps.performance.b.b.aHQ() ? com.baidu.swan.apps.performance.b.b.aGu() : com.baidu.swan.apps.t.a.aAv().getSwitch("swan_white_screen_forward", false);
    }

    public void aGv() {
        d(new com.baidu.swan.apps.y.a.c(9, null, 6000L));
    }
}
