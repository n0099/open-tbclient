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
/* loaded from: classes3.dex */
public abstract class d extends a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static d cRV;
    private static Handler sMainHandler;
    private com.baidu.swan.apps.adaptation.a cRX;
    private com.baidu.swan.pms.c.f cSc;
    public final com.baidu.swan.apps.u.c.a.c cRW = new c.a();
    private final Set<com.baidu.swan.apps.ap.e.b<i.a>> cRY = new HashSet();
    public volatile int cRZ = 0;
    private final Queue<Runnable> cSa = new ArrayDeque();
    private Runnable cSb = null;
    private boolean inited = false;

    protected abstract com.baidu.swan.pms.c.f aAm();

    public static d aAn() {
        d aAo = aAo();
        if (!aAo.inited) {
            aAo.init();
        }
        return aAo;
    }

    private static d aAo() {
        if (cRV instanceof j) {
            return cRV;
        }
        synchronized (d.class) {
            if (cRV instanceof j) {
                return cRV;
            }
            SwanAppProcessInfo current = SwanAppProcessInfo.current();
            if (current.isSwanClient) {
                cRV = new j();
                return cRV;
            } else if (current.isSwanService) {
                if (!(cRV instanceof l)) {
                    cRV = new l();
                }
                return cRV;
            } else {
                if (cRV == null) {
                    cRV = new c();
                }
                return cRV;
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
            aAq();
            com.baidu.swan.apps.process.b.c.init();
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.adaptation.a aAp() {
        if (this.cRX == null) {
            this.cRX = new com.baidu.swan.apps.adaptation.a();
        }
        return this.cRX;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void qA(String str) {
        f(str, null);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void f(String str, Bundle bundle) {
        i(new i.a(str, bundle));
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void i(final i.a aVar) {
        if (DEBUG) {
            Log.i("SwanImpl", "SwanEvent dispatchEvent: " + aVar + " mEventCallbacks:" + this.cRY.size());
        }
        if (aVar != null) {
            g(new Runnable() { // from class: com.baidu.swan.apps.runtime.d.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean z = Looper.getMainLooper() == Looper.myLooper();
                    for (final com.baidu.swan.apps.ap.e.b bVar : d.this.cRY) {
                        if (z && !aVar.getBoolean("event_flag_force_post", false)) {
                            bVar.J(aVar);
                        } else {
                            d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.runtime.d.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    bVar.J(aVar);
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
                    d.this.cRY.add(bVar);
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
                    d.this.cRY.remove(bVar);
                }
            });
        }
    }

    private synchronized void g(@NonNull Runnable runnable) {
        this.cSa.offer(runnable);
        if (this.cSb == null) {
            while (!this.cSa.isEmpty()) {
                this.cSb = this.cSa.poll();
                if (this.cSb != null) {
                    this.cSb.run();
                }
                this.cSb = null;
            }
        }
    }

    public com.baidu.swan.pms.c.f aAq() {
        if (this.cSc == null) {
            this.cSc = aAm();
        }
        return this.cSc;
    }
}
