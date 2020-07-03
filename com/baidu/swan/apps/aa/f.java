package com.baidu.swan.apps.aa;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.android.app.event.EventBusWrapper;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.v.b.b;
/* loaded from: classes11.dex */
public class f implements com.baidu.swan.apps.core.f.c, com.baidu.swan.apps.core.f.e {
    private static f cun;
    private boolean cuo;
    private a cup = new b();
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
    public static f alv() {
        if (cun == null) {
            synchronized (f.class) {
                if (cun == null) {
                    cun = new f();
                }
            }
        }
        return cun;
    }

    public void ey(boolean z) {
        this.cuo = z;
        if (this.cuo) {
            e.alq();
            com.baidu.swan.apps.statistic.e.asp();
        }
    }

    public void start() {
        com.baidu.swan.apps.aa.a.c cVar;
        b.a apQ;
        long SL = com.baidu.swan.apps.u.a.aga().SL();
        if (DEBUG) {
            Log.d(TAG, "start page monitoring, delay: " + SL);
        }
        if (this.cuo) {
            boolean z = com.baidu.swan.apps.u.a.aga().getSwitch("swan_white_screen_forward", false);
            if (DEBUG) {
                Log.d(TAG, "WhiteScreenForward: switch=" + z);
            }
            SwanAppActivity aiL = com.baidu.swan.apps.w.f.ajb().aiL();
            if (z && aiL != null && (apQ = com.baidu.swan.apps.runtime.d.apI().apE().apQ()) != null) {
                long currentTimeMillis = System.currentTimeMillis() - apQ.aie();
                SL -= currentTimeMillis;
                if (SL < 0) {
                    if (DEBUG) {
                        Log.d(TAG, "WhiteScreenMonitor out of time: time=" + currentTimeMillis);
                    }
                    h.b(new com.baidu.swan.apps.statistic.a.d().oK(h.hf(apQ.getAppFrameType())).f(new com.baidu.swan.apps.an.a().bw(5L).bx(40L).pB("whitescreen monitor out of time: time=" + currentTimeMillis)).a(apQ));
                }
            }
            cVar = new com.baidu.swan.apps.aa.a.c(1, null, SL, true);
            this.cuo = false;
        } else {
            cVar = null;
        }
        if (DEBUG) {
            Log.d(TAG, "WhiteScreenMonitor monitortime: " + SL);
        }
        if (cVar == null) {
            cVar = new com.baidu.swan.apps.aa.a.c(1, null, SL);
        }
        d(cVar);
    }

    public void alw() {
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

    public void er(boolean z) {
        if (DEBUG) {
            Log.d(TAG, "change to " + (z ? "background" : "foreground"));
        }
        d(new com.baidu.swan.apps.aa.a.b(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.swan.apps.aa.a.c cVar) {
        this.cup.a(cVar);
    }

    public static void alk() {
        c.alk();
    }

    public void alx() {
        d(new com.baidu.swan.apps.aa.a.c(9, null, 6000L));
    }
}
