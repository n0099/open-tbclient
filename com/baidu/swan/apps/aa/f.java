package com.baidu.swan.apps.aa;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.android.app.event.EventBusWrapper;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.v.b.b;
/* loaded from: classes11.dex */
public class f implements com.baidu.swan.apps.core.f.c, com.baidu.swan.apps.core.f.e {
    private static f cpA;
    private boolean cpB;
    private a cpC = new b();
    public static final String TAG = f.class.getSimpleName();
    private static final boolean DEBUG = com.baidu.swan.apps.runtime.e.DEBUG;

    private f() {
        EventBusWrapper.lazyRegister("dialog_event_tag", com.baidu.swan.apps.res.widget.dialog.a.class, new rx.functions.b<com.baidu.swan.apps.res.widget.dialog.a>() { // from class: com.baidu.swan.apps.aa.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: a */
            public void call(com.baidu.swan.apps.res.widget.dialog.a aVar) {
                f.this.d(new com.baidu.swan.apps.aa.a.a(aVar));
            }
        });
    }

    @NonNull
    public static f akp() {
        if (cpA == null) {
            synchronized (f.class) {
                if (cpA == null) {
                    cpA = new f();
                }
            }
        }
        return cpA;
    }

    public void et(boolean z) {
        this.cpB = z;
        if (this.cpB) {
            e.akk();
            com.baidu.swan.apps.statistic.e.ari();
        }
    }

    public void start() {
        com.baidu.swan.apps.aa.a.c cVar;
        b.a aoJ;
        long RF = com.baidu.swan.apps.u.a.aeU().RF();
        if (DEBUG) {
            Log.d(TAG, "start page monitoring, delay: " + RF);
        }
        if (this.cpB) {
            boolean z = com.baidu.swan.apps.u.a.aeU().getSwitch("swan_white_screen_forward", false);
            if (DEBUG) {
                Log.d(TAG, "WhiteScreenForward: switch=" + z);
            }
            SwanAppActivity ahF = com.baidu.swan.apps.w.f.ahV().ahF();
            if (z && ahF != null && (aoJ = com.baidu.swan.apps.runtime.d.aoB().aox().aoJ()) != null) {
                long currentTimeMillis = System.currentTimeMillis() - aoJ.agY();
                RF -= currentTimeMillis;
                if (RF < 0) {
                    if (DEBUG) {
                        Log.d(TAG, "WhiteScreenMonitor out of time: time=" + currentTimeMillis);
                    }
                    h.b(new com.baidu.swan.apps.statistic.a.d().oC(h.gS(aoJ.getAppFrameType())).f(new com.baidu.swan.apps.an.a().bw(5L).bx(40L).pt("whitescreen monitor out of time: time=" + currentTimeMillis)).a(aoJ));
                }
            }
            cVar = new com.baidu.swan.apps.aa.a.c(1, null, RF, true);
            this.cpB = false;
        } else {
            cVar = null;
        }
        if (DEBUG) {
            Log.d(TAG, "WhiteScreenMonitor monitortime: " + RF);
        }
        if (cVar == null) {
            cVar = new com.baidu.swan.apps.aa.a.c(1, null, RF);
        }
        d(cVar);
    }

    public void akq() {
        if (DEBUG) {
            Log.d(TAG, "stop page monitoring");
        }
        d(new com.baidu.swan.apps.aa.a.c(7));
    }

    @Override // com.baidu.swan.apps.core.f.c
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        if (i3 != 0 || i4 != 0 || i != 0 || i2 != 1) {
            d(new com.baidu.swan.apps.aa.a.c(3));
        }
    }

    @Override // com.baidu.swan.apps.core.f.e
    public void a(com.baidu.swan.apps.adaptation.b.f fVar) {
        if (DEBUG) {
            Log.d(TAG, "webview insert event");
        }
        d(new com.baidu.swan.apps.aa.a.e(fVar, true));
    }

    @Override // com.baidu.swan.apps.core.f.e
    public void b(com.baidu.swan.apps.adaptation.b.f fVar) {
        if (DEBUG) {
            Log.d(TAG, "webview remove event");
        }
        d(new com.baidu.swan.apps.aa.a.e(fVar, false));
    }

    public void em(boolean z) {
        if (DEBUG) {
            Log.d(TAG, "change to " + (z ? "background" : "foreground"));
        }
        d(new com.baidu.swan.apps.aa.a.b(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.swan.apps.aa.a.c cVar) {
        this.cpC.a(cVar);
    }

    public static void ake() {
        c.ake();
    }

    public void akr() {
        d(new com.baidu.swan.apps.aa.a.c(9, null, 6000L));
    }
}
