package com.baidu.swan.apps.ac;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.android.app.event.EventBusWrapper;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.x.b.b;
/* loaded from: classes10.dex */
public class f implements com.baidu.swan.apps.core.f.c, com.baidu.swan.apps.core.f.e {
    private static f bBJ;
    private boolean bBK;
    private a bBL = new b();
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
    public static f Wy() {
        if (bBJ == null) {
            synchronized (f.class) {
                if (bBJ == null) {
                    bBJ = new f();
                }
            }
        }
        return bBJ;
    }

    public void cY(boolean z) {
        this.bBK = z;
        if (this.bBK) {
            e.Wt();
            com.baidu.swan.apps.statistic.c.acC();
        }
    }

    public void start() {
        com.baidu.swan.apps.ac.a.c cVar;
        b.a aas;
        long j = 6000;
        if (DEBUG) {
            Log.d(TAG, "start page monitoring");
        }
        if (this.bBK) {
            boolean z = com.baidu.swan.apps.w.a.RJ().getSwitch("swan_white_screen_forward", false);
            if (DEBUG) {
                Log.d(TAG, "WhiteScreenForward: switch=" + z);
            }
            SwanAppActivity Un = com.baidu.swan.apps.y.f.UC().Un();
            if (z && Un != null && (aas = com.baidu.swan.apps.runtime.d.aam().aaj().aas()) != null) {
                long currentTimeMillis = System.currentTimeMillis() - aas.TH();
                j = 6000 - currentTimeMillis;
                if (j < 0) {
                    if (DEBUG) {
                        Log.d(TAG, "WhiteScreenMonitor out of time: time=" + currentTimeMillis);
                    }
                    com.baidu.swan.apps.statistic.f.b(new com.baidu.swan.apps.statistic.a.d().ly(com.baidu.swan.apps.statistic.f.gb(aas.getAppFrameType())).e(new com.baidu.swan.apps.ap.a().aE(5L).aF(40L).mk("whitescreen monitor out of time: time=" + currentTimeMillis)).a(aas));
                }
            }
            cVar = new com.baidu.swan.apps.ac.a.c(1, null, j, true);
            this.bBK = false;
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

    public void Wz() {
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

    public void cR(boolean z) {
        if (DEBUG) {
            Log.d(TAG, "change to " + (z ? "background" : "foreground"));
        }
        d(new com.baidu.swan.apps.ac.a.b(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.swan.apps.ac.a.c cVar) {
        this.bBL.a(cVar);
    }

    public static void Wn() {
        c.Wn();
    }

    public void WA() {
        d(new com.baidu.swan.apps.ac.a.c(9, null, 6000L));
    }
}
