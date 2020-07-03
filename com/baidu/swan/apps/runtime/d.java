package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.i;
import com.baidu.swan.apps.v.b.a.c;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
/* loaded from: classes11.dex */
public abstract class d extends a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static d cEf;
    private static Handler sMainHandler;
    private com.baidu.swan.apps.adaptation.a cEh;
    private com.baidu.swan.pms.c.f cEm;
    public final com.baidu.swan.apps.v.b.a.c cEg = new c.a();
    private final Set<com.baidu.swan.apps.aq.e.b<i.a>> cEi = new HashSet();
    public int cEj = 0;
    private final Queue<Runnable> cEk = new ArrayDeque();
    private Runnable cEl = null;
    private boolean inited = false;

    protected abstract com.baidu.swan.pms.c.f apH();

    public static d apI() {
        d apJ = apJ();
        if (!apJ.inited) {
            apJ.init();
        }
        return apJ;
    }

    private static d apJ() {
        if (cEf instanceof j) {
            return cEf;
        }
        synchronized (d.class) {
            if (cEf instanceof j) {
                return cEf;
            }
            SwanAppProcessInfo current = SwanAppProcessInfo.current();
            if (current.isSwanClient) {
                cEf = new j();
                return cEf;
            } else if (current.isSwanService) {
                if (!(cEf instanceof l)) {
                    cEf = new l();
                }
                return cEf;
            } else {
                if (cEf == null) {
                    cEf = new c();
                }
                return cEf;
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
            apL();
            com.baidu.swan.apps.process.b.c.init();
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.adaptation.a apK() {
        if (this.cEh == null) {
            this.cEh = new com.baidu.swan.apps.adaptation.a();
        }
        return this.cEh;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void nA(String str) {
        g(str, null);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void g(String str, Bundle bundle) {
        i(new i.a(str, bundle));
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void i(final i.a aVar) {
        if (DEBUG) {
            Log.i("SwanImpl", "SwanEvent dispatchEvent: " + aVar + " mEventCallbacks:" + this.cEi.size());
        }
        if (aVar != null) {
            j(new Runnable() { // from class: com.baidu.swan.apps.runtime.d.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean z = Looper.getMainLooper() == Looper.myLooper();
                    for (final com.baidu.swan.apps.aq.e.b bVar : d.this.cEi) {
                        if (z && !aVar.getBoolean("event_flag_force_post", false)) {
                            bVar.H(aVar);
                        } else {
                            d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.runtime.d.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    bVar.H(aVar);
                                }
                            });
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void n(final com.baidu.swan.apps.aq.e.b<i.a> bVar) {
        if (bVar != null) {
            j(new Runnable() { // from class: com.baidu.swan.apps.runtime.d.2
                @Override // java.lang.Runnable
                public void run() {
                    d.this.cEi.add(bVar);
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void o(final com.baidu.swan.apps.aq.e.b<i.a> bVar) {
        if (bVar != null) {
            j(new Runnable() { // from class: com.baidu.swan.apps.runtime.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.cEi.remove(bVar);
                }
            });
        }
    }

    private synchronized void j(@NonNull Runnable runnable) {
        this.cEk.offer(runnable);
        if (this.cEl == null) {
            while (!this.cEk.isEmpty()) {
                this.cEl = this.cEk.poll();
                if (this.cEl != null) {
                    this.cEl.run();
                }
                this.cEl = null;
            }
        }
    }

    public com.baidu.swan.pms.c.f apL() {
        if (this.cEm == null) {
            this.cEm = apH();
        }
        return this.cEm;
    }
}
