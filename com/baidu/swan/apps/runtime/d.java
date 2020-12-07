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
/* loaded from: classes25.dex */
public abstract class d extends a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static d dxR;
    private static Handler sMainHandler;
    private com.baidu.swan.apps.adaptation.a dxT;
    private com.baidu.swan.pms.c.f dxY;
    public final com.baidu.swan.apps.u.c.a.c dxS = new c.a();
    private final Set<com.baidu.swan.apps.ap.e.b<i.a>> dxU = new HashSet();
    public volatile int dxV = 0;
    private final Queue<Runnable> dxW = new ArrayDeque();
    private Runnable dxX = null;
    private boolean dxZ = false;

    protected abstract com.baidu.swan.pms.c.f aJP();

    public static d aJQ() {
        d aJR = aJR();
        if (!aJR.dxZ) {
            aJR.init();
        }
        return aJR;
    }

    private static d aJR() {
        if (dxR instanceof j) {
            return dxR;
        }
        synchronized (d.class) {
            if (dxR instanceof j) {
                return dxR;
            }
            SwanAppProcessInfo current = SwanAppProcessInfo.current();
            if (current.isSwanClient) {
                dxR = new j();
                return dxR;
            } else if (current.isSwanService) {
                if (!(dxR instanceof l)) {
                    dxR = new l();
                }
                return dxR;
            } else {
                if (dxR == null) {
                    dxR = new c();
                }
                return dxR;
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
        if (!this.dxZ) {
            aJT();
            com.baidu.swan.apps.process.b.c.init();
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.adaptation.a aJS() {
        if (this.dxT == null) {
            this.dxT = new com.baidu.swan.apps.adaptation.a();
        }
        return this.dxT;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void sv(String str) {
        f(str, null);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void f(String str, Bundle bundle) {
        i(new i.a(str, bundle));
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void i(final i.a aVar) {
        if (DEBUG) {
            Log.i("SwanImpl", "SwanEvent dispatchEvent: " + aVar + " mEventCallbacks:" + this.dxU.size());
        }
        if (aVar != null) {
            g(new Runnable() { // from class: com.baidu.swan.apps.runtime.d.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean z = Looper.getMainLooper() == Looper.myLooper();
                    for (final com.baidu.swan.apps.ap.e.b bVar : d.this.dxU) {
                        if (z && !aVar.getBoolean("event_flag_force_post", false)) {
                            bVar.M(aVar);
                        } else {
                            d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.runtime.d.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    bVar.M(aVar);
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
                    d.this.dxU.add(bVar);
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
                    d.this.dxU.remove(bVar);
                }
            });
        }
    }

    private synchronized void g(@NonNull Runnable runnable) {
        this.dxW.offer(runnable);
        if (this.dxX == null) {
            while (!this.dxW.isEmpty()) {
                this.dxX = this.dxW.poll();
                if (this.dxX != null) {
                    this.dxX.run();
                }
                this.dxX = null;
            }
        }
    }

    public com.baidu.swan.pms.c.f aJT() {
        if (this.dxY == null) {
            this.dxY = aJP();
        }
        return this.dxY;
    }
}
