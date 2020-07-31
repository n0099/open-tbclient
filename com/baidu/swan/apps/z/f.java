package com.baidu.swan.apps.z;

import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.android.app.event.EventBusWrapper;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
/* loaded from: classes7.dex */
public class f implements com.baidu.swan.apps.core.f.c, com.baidu.swan.apps.core.f.e {
    private static f cwq;
    private boolean cwr;
    private a cws = new b();
    public static final String TAG = f.class.getSimpleName();
    private static final boolean DEBUG = com.baidu.swan.apps.runtime.e.DEBUG;

    private f() {
        EventBusWrapper.lazyRegister("dialog_event_tag", com.baidu.swan.apps.res.widget.dialog.a.class, new rx.functions.b<com.baidu.swan.apps.res.widget.dialog.a>() { // from class: com.baidu.swan.apps.z.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // rx.functions.b
            /* renamed from: a */
            public void call(com.baidu.swan.apps.res.widget.dialog.a aVar) {
                f.this.d(new com.baidu.swan.apps.z.a.a(aVar));
            }
        });
    }

    @NonNull
    public static f amM() {
        if (cwq == null) {
            synchronized (f.class) {
                if (cwq == null) {
                    cwq = new f();
                }
            }
        }
        return cwq;
    }

    public void eH(boolean z) {
        this.cwr = z;
        if (this.cwr) {
            e.amH();
            com.baidu.swan.apps.statistic.e.aum();
        }
    }

    public void start() {
        com.baidu.swan.apps.z.a.c cVar;
        b.a arz;
        long Tb = com.baidu.swan.apps.t.a.ahm().Tb();
        if (DEBUG) {
            Log.d(TAG, "start page monitoring, delay: " + Tb);
        }
        if (this.cwr) {
            boolean z = com.baidu.swan.apps.t.a.ahm().getSwitch("swan_white_screen_forward", false);
            if (DEBUG) {
                Log.d(TAG, "WhiteScreenForward: switch=" + z);
            }
            SwanAppActivity akb = com.baidu.swan.apps.v.f.akr().akb();
            if (z && akb != null && (arz = com.baidu.swan.apps.runtime.d.arr().arn().arz()) != null) {
                long currentTimeMillis = System.currentTimeMillis() - arz.aju();
                Tb -= currentTimeMillis;
                if (Tb < 0) {
                    if (DEBUG) {
                        Log.d(TAG, "WhiteScreenMonitor out of time: time=" + currentTimeMillis);
                    }
                    h.b(new com.baidu.swan.apps.statistic.a.d().pu(h.ho(arz.getAppFrameType())).f(new com.baidu.swan.apps.an.a().bJ(5L).bK(40L).qm("whitescreen monitor out of time: time=" + currentTimeMillis)).a(arz));
                }
            }
            cVar = new com.baidu.swan.apps.z.a.c(1, null, Tb, true);
            this.cwr = false;
        } else {
            cVar = null;
        }
        if (DEBUG) {
            Log.d(TAG, "WhiteScreenMonitor monitortime: " + Tb);
        }
        if (cVar == null) {
            cVar = new com.baidu.swan.apps.z.a.c(1, null, Tb);
        }
        d(cVar);
    }

    public void amN() {
        if (DEBUG) {
            Log.d(TAG, "stop page monitoring");
        }
        d(new com.baidu.swan.apps.z.a.c(7));
    }

    @Override // com.baidu.swan.apps.core.f.c
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        if (i3 != 0 || i4 != 0 || i != 0 || i2 != 1) {
            d(new com.baidu.swan.apps.z.a.c(3));
        }
    }

    @Override // com.baidu.swan.apps.core.f.e
    public void a(com.baidu.swan.apps.adaptation.b.f fVar) {
        if (DEBUG) {
            Log.d(TAG, "webview insert event");
        }
        d(new com.baidu.swan.apps.z.a.e(fVar, true));
    }

    @Override // com.baidu.swan.apps.core.f.e
    public void b(com.baidu.swan.apps.adaptation.b.f fVar) {
        if (DEBUG) {
            Log.d(TAG, "webview remove event");
        }
        d(new com.baidu.swan.apps.z.a.e(fVar, false));
    }

    public void ez(boolean z) {
        if (DEBUG) {
            Log.d(TAG, "change to " + (z ? "background" : "foreground"));
        }
        d(new com.baidu.swan.apps.z.a.b(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.swan.apps.z.a.c cVar) {
        this.cws.a(cVar);
    }

    public static void amB() {
        c.amB();
    }

    public void amO() {
        d(new com.baidu.swan.apps.z.a.c(9, null, 6000L));
    }
}
