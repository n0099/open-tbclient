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
    private static f dml;
    private boolean dmm;
    private a dmn = new b();

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
    public static f aCy() {
        if (dml == null) {
            synchronized (f.class) {
                if (dml == null) {
                    dml = new f();
                }
            }
        }
        return dml;
    }

    public void gm(boolean z) {
        this.dmm = z;
        if (this.dmm) {
            e.aCt();
            com.baidu.swan.apps.statistic.e.aLf();
        }
    }

    public void start() {
        com.baidu.swan.apps.y.a.c cVar;
        b.a aIv;
        long agz = com.baidu.swan.apps.t.a.awB().agz();
        if (DEBUG) {
            Log.d("SwanAppPageMonitor", "start page monitoring, delay: " + agz);
        }
        if (this.dmm) {
            boolean aCA = aCA();
            if (DEBUG) {
                Log.d("SwanAppPageMonitor", "WhiteScreenForward: switch=" + aCA);
            }
            SwanAppActivity azx = com.baidu.swan.apps.v.f.azN().azx();
            if (aCA && azx != null && (aIv = com.baidu.swan.apps.runtime.d.aIn().aIj().aIv()) != null) {
                long currentTimeMillis = System.currentTimeMillis() - aIv.ayQ();
                agz -= currentTimeMillis;
                if (agz < 0) {
                    if (DEBUG) {
                        Log.d("SwanAppPageMonitor", "WhiteScreenMonitor out of time: time=" + currentTimeMillis);
                    }
                    h.b(new com.baidu.swan.apps.statistic.a.d().sw(h.jr(aIv.getAppFrameType())).i(new com.baidu.swan.apps.al.a().cV(5L).cW(40L).to("whitescreen monitor out of time: time=" + currentTimeMillis)).a(aIv));
                }
            }
            cVar = new com.baidu.swan.apps.y.a.c(1, null, agz, true);
            this.dmm = false;
        } else {
            cVar = null;
        }
        if (DEBUG) {
            Log.d("SwanAppPageMonitor", "WhiteScreenMonitor monitortime: " + agz);
        }
        if (cVar == null) {
            cVar = new com.baidu.swan.apps.y.a.c(1, null, agz);
        }
        d(cVar);
    }

    public void aCz() {
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

    public void gd(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppPageMonitor", "change to " + (z ? "background" : "foreground"));
        }
        d(new com.baidu.swan.apps.y.a.b(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.swan.apps.y.a.c cVar) {
        this.dmn.a(cVar);
    }

    public static void aCn() {
        c.aCn();
    }

    public static boolean aCA() {
        return com.baidu.swan.apps.performance.b.b.aDW() ? com.baidu.swan.apps.performance.b.b.aCA() : com.baidu.swan.apps.t.a.awB().getSwitch("swan_white_screen_forward", false);
    }

    public void aCB() {
        d(new com.baidu.swan.apps.y.a.c(9, null, 6000L));
    }
}
