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
    private static d cPV;
    private static Handler sMainHandler;
    private com.baidu.swan.apps.adaptation.a cPX;
    private com.baidu.swan.pms.c.f cQc;
    public final com.baidu.swan.apps.u.c.a.c cPW = new c.a();
    private final Set<com.baidu.swan.apps.ap.e.b<i.a>> cPY = new HashSet();
    public volatile int cPZ = 0;
    private final Queue<Runnable> cQa = new ArrayDeque();
    private Runnable cQb = null;
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
        if (cPV instanceof j) {
            return cPV;
        }
        synchronized (d.class) {
            if (cPV instanceof j) {
                return cPV;
            }
            SwanAppProcessInfo current = SwanAppProcessInfo.current();
            if (current.isSwanClient) {
                cPV = new j();
                return cPV;
            } else if (current.isSwanService) {
                if (!(cPV instanceof l)) {
                    cPV = new l();
                }
                return cPV;
            } else {
                if (cPV == null) {
                    cPV = new c();
                }
                return cPV;
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
        if (this.cPX == null) {
            this.cPX = new com.baidu.swan.apps.adaptation.a();
        }
        return this.cPX;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void qh(String str) {
        f(str, null);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void f(String str, Bundle bundle) {
        i(new i.a(str, bundle));
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void i(final i.a aVar) {
        if (DEBUG) {
            Log.i("SwanImpl", "SwanEvent dispatchEvent: " + aVar + " mEventCallbacks:" + this.cPY.size());
        }
        if (aVar != null) {
            g(new Runnable() { // from class: com.baidu.swan.apps.runtime.d.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean z = Looper.getMainLooper() == Looper.myLooper();
                    for (final com.baidu.swan.apps.ap.e.b bVar : d.this.cPY) {
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
                    d.this.cPY.add(bVar);
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
                    d.this.cPY.remove(bVar);
                }
            });
        }
    }

    private synchronized void g(@NonNull Runnable runnable) {
        this.cQa.offer(runnable);
        if (this.cQb == null) {
            while (!this.cQa.isEmpty()) {
                this.cQb = this.cQa.poll();
                if (this.cQb != null) {
                    this.cQb.run();
                }
                this.cQb = null;
            }
        }
    }

    public com.baidu.swan.pms.c.f azH() {
        if (this.cQc == null) {
            this.cQc = azD();
        }
        return this.cQc;
    }
}
