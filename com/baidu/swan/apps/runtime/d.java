package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.i;
import com.baidu.swan.apps.u.c.a.c;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
/* loaded from: classes8.dex */
public abstract class d extends a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static d cPR;
    private static Handler sMainHandler;
    private com.baidu.swan.apps.adaptation.a cPT;
    private com.baidu.swan.pms.c.f cPY;
    public final com.baidu.swan.apps.u.c.a.c cPS = new c.a();
    private final Set<com.baidu.swan.apps.ap.e.b<i.a>> cPU = new HashSet();
    public volatile int cPV = 0;
    private final Queue<Runnable> cPW = new ArrayDeque();
    private Runnable cPX = null;
    private boolean inited = false;

    protected abstract com.baidu.swan.pms.c.f azD();

    public static d azE() {
        d azF = azF();
        if (!azF.inited) {
            azF.init();
        }
        return azF;
    }

    private static d azF() {
        if (cPR instanceof j) {
            return cPR;
        }
        synchronized (d.class) {
            if (cPR instanceof j) {
                return cPR;
            }
            SwanAppProcessInfo current = SwanAppProcessInfo.current();
            if (current.isSwanClient) {
                cPR = new j();
                return cPR;
            } else if (current.isSwanService) {
                if (!(cPR instanceof l)) {
                    cPR = new l();
                }
                return cPR;
            } else {
                if (cPR == null) {
                    cPR = new c();
                }
                return cPR;
            }
        }
    }

    public static Handler getMainHandler() {
        if (sMainHandler == null) {
            sMainHandler = new Handler(Looper.getMainLooper());
        }
        return sMainHandler;
    }

    private void init() {
        if (!this.inited) {
            azH();
            com.baidu.swan.apps.process.b.c.init();
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.adaptation.a azG() {
        if (this.cPT == null) {
            this.cPT = new com.baidu.swan.apps.adaptation.a();
        }
        return this.cPT;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void qg(String str) {
        f(str, null);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void f(String str, Bundle bundle) {
        i(new i.a(str, bundle));
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void i(final i.a aVar) {
        if (DEBUG) {
            Log.i("SwanImpl", "SwanEvent dispatchEvent: " + aVar + " mEventCallbacks:" + this.cPU.size());
        }
        if (aVar != null) {
            g(new Runnable() { // from class: com.baidu.swan.apps.runtime.d.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean z = Looper.getMainLooper() == Looper.myLooper();
                    for (final com.baidu.swan.apps.ap.e.b bVar : d.this.cPU) {
                        if (z && !aVar.getBoolean("event_flag_force_post", false)) {
                            bVar.I(aVar);
                        } else {
                            d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.runtime.d.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    bVar.I(aVar);
                                }
                            });
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void v(final com.baidu.swan.apps.ap.e.b<i.a> bVar) {
        if (bVar != null) {
            g(new Runnable() { // from class: com.baidu.swan.apps.runtime.d.2
                @Override // java.lang.Runnable
                public void run() {
                    d.this.cPU.add(bVar);
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void w(final com.baidu.swan.apps.ap.e.b<i.a> bVar) {
        if (bVar != null) {
            g(new Runnable() { // from class: com.baidu.swan.apps.runtime.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.cPU.remove(bVar);
                }
            });
        }
    }

    private synchronized void g(@NonNull Runnable runnable) {
        this.cPW.offer(runnable);
        if (this.cPX == null) {
            while (!this.cPW.isEmpty()) {
                this.cPX = this.cPW.poll();
                if (this.cPX != null) {
                    this.cPX.run();
                }
                this.cPX = null;
            }
        }
    }

    public com.baidu.swan.pms.c.f azH() {
        if (this.cPY == null) {
            this.cPY = azD();
        }
        return this.cPY;
    }
}
