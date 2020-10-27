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
    private static f daP;
    private boolean daQ;
    private a daR = new b();

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
    public static f azW() {
        if (daP == null) {
            synchronized (f.class) {
                if (daP == null) {
                    daP = new f();
                }
            }
        }
        return daP;
    }

    public void fG(boolean z) {
        this.daQ = z;
        if (this.daQ) {
            e.azR();
            com.baidu.swan.apps.statistic.e.aHI();
        }
    }

    public void start() {
        com.baidu.swan.apps.y.a.c cVar;
        b.a aEY;
        long aek = com.baidu.swan.apps.t.a.aud().aek();
        if (DEBUG) {
            Log.d("SwanAppPageMonitor", "start page monitoring, delay: " + aek);
        }
        if (this.daQ) {
            boolean azY = azY();
            if (DEBUG) {
                Log.d("SwanAppPageMonitor", "WhiteScreenForward: switch=" + azY);
            }
            SwanAppActivity awY = com.baidu.swan.apps.v.f.axo().awY();
            if (azY && awY != null && (aEY = com.baidu.swan.apps.runtime.d.aEQ().aEM().aEY()) != null) {
                long currentTimeMillis = System.currentTimeMillis() - aEY.awr();
                aek -= currentTimeMillis;
                if (aek < 0) {
                    if (DEBUG) {
                        Log.d("SwanAppPageMonitor", "WhiteScreenMonitor out of time: time=" + currentTimeMillis);
                    }
                    h.b(new com.baidu.swan.apps.statistic.a.d().sU(h.ko(aEY.getAppFrameType())).i(new com.baidu.swan.apps.am.a().bZ(5L).ca(40L).tM("whitescreen monitor out of time: time=" + currentTimeMillis)).a(aEY));
                }
            }
            cVar = new com.baidu.swan.apps.y.a.c(1, null, aek, true);
            this.daQ = false;
        } else {
            cVar = null;
        }
        if (DEBUG) {
            Log.d("SwanAppPageMonitor", "WhiteScreenMonitor monitortime: " + aek);
        }
        if (cVar == null) {
            cVar = new com.baidu.swan.apps.y.a.c(1, null, aek);
        }
        d(cVar);
    }

    public void azX() {
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

    public void fx(boolean z) {
        if (DEBUG) {
            Log.d("SwanAppPageMonitor", "change to " + (z ? "background" : "foreground"));
        }
        d(new com.baidu.swan.apps.y.a.b(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.swan.apps.y.a.c cVar) {
        this.daR.a(cVar);
    }

    public static void azL() {
        c.azL();
    }

    public static boolean azY() {
        return com.baidu.swan.apps.performance.b.b.aBw() ? com.baidu.swan.apps.performance.b.b.azY() : com.baidu.swan.apps.t.a.aud().getSwitch("swan_white_screen_forward", false);
    }

    public void azZ() {
        d(new com.baidu.swan.apps.y.a.c(9, null, 6000L));
    }
}
