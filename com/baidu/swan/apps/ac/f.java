package com.baidu.swan.apps.ac;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.android.app.event.EventBusWrapper;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.x.b.b;
/* loaded from: classes11.dex */
public class f implements com.baidu.swan.apps.core.f.c, com.baidu.swan.apps.core.f.e {
    private static f ceM;
    private boolean ceN;
    private a ceO = new b();
    public static final String TAG = f.class.getSimpleName();
    private static final boolean DEBUG = com.baidu.swan.apps.runtime.e.DEBUG;

    private f() {
        EventBusWrapper.lazyRegister("dialog_event_tag", com.baidu.swan.apps.res.widget.dialog.a.class, new rx.functions.b<com.baidu.swan.apps.res.widget.dialog.a>() { // from class: com.baidu.swan.apps.ac.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: a */
            public void call(com.baidu.swan.apps.res.widget.dialog.a aVar) {
                f.this.d(new com.baidu.swan.apps.ac.a.a(aVar));
            }
        });
    }

    @NonNull
    public static f agX() {
        if (ceM == null) {
            synchronized (f.class) {
                if (ceM == null) {
                    ceM = new f();
                }
            }
        }
        return ceM;
    }

    public void ec(boolean z) {
        this.ceN = z;
        if (this.ceN) {
            e.agS();
            com.baidu.swan.apps.statistic.c.ana();
        }
    }

    public void start() {
        com.baidu.swan.apps.ac.a.c cVar;
        b.a akQ;
        long j = 6000;
        if (DEBUG) {
            Log.d(TAG, "start page monitoring");
        }
        if (this.ceN) {
            boolean z = com.baidu.swan.apps.w.a.abR().getSwitch("swan_white_screen_forward", false);
            if (DEBUG) {
                Log.d(TAG, "WhiteScreenForward: switch=" + z);
            }
            SwanAppActivity aev = com.baidu.swan.apps.y.f.aeK().aev();
            if (z && aev != null && (akQ = com.baidu.swan.apps.runtime.d.akK().akH().akQ()) != null) {
                long currentTimeMillis = System.currentTimeMillis() - akQ.adP();
                j = 6000 - currentTimeMillis;
                if (j < 0) {
                    if (DEBUG) {
                        Log.d(TAG, "WhiteScreenMonitor out of time: time=" + currentTimeMillis);
                    }
                    com.baidu.swan.apps.statistic.f.b(new com.baidu.swan.apps.statistic.a.d().mZ(com.baidu.swan.apps.statistic.f.gz(akQ.getAppFrameType())).e(new com.baidu.swan.apps.ap.a().bn(5L).bo(40L).nL("whitescreen monitor out of time: time=" + currentTimeMillis)).a(akQ));
                }
            }
            cVar = new com.baidu.swan.apps.ac.a.c(1, null, j, true);
            this.ceN = false;
        } else {
            cVar = null;
        }
        if (DEBUG) {
            Log.d(TAG, "WhiteScreenMonitor monitortime: " + j);
        }
        if (cVar == null) {
            cVar = new com.baidu.swan.apps.ac.a.c(1, null, j);
        }
        d(cVar);
    }

    public void agY() {
        if (DEBUG) {
            Log.d(TAG, "stop page monitoring");
        }
        d(new com.baidu.swan.apps.ac.a.c(7));
    }

    @Override // com.baidu.swan.apps.core.f.c
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        if (i3 != 0 || i4 != 0 || i != 0 || i2 != 1) {
            d(new com.baidu.swan.apps.ac.a.c(3));
        }
    }

    @Override // com.baidu.swan.apps.core.f.e
    public void a(com.baidu.swan.apps.adaptation.b.f fVar) {
        if (DEBUG) {
            Log.d(TAG, "webview insert event");
        }
        d(new com.baidu.swan.apps.ac.a.e(fVar, true));
    }

    @Override // com.baidu.swan.apps.core.f.e
    public void b(com.baidu.swan.apps.adaptation.b.f fVar) {
        if (DEBUG) {
            Log.d(TAG, "webview remove event");
        }
        d(new com.baidu.swan.apps.ac.a.e(fVar, false));
    }

    public void dV(boolean z) {
        if (DEBUG) {
            Log.d(TAG, "change to " + (z ? "background" : "foreground"));
        }
        d(new com.baidu.swan.apps.ac.a.b(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.swan.apps.ac.a.c cVar) {
        this.ceO.a(cVar);
    }

    public static void agM() {
        c.agM();
    }

    public void agZ() {
        d(new com.baidu.swan.apps.ac.a.c(9, null, 6000L));
    }
}
