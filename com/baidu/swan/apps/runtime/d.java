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
/* loaded from: classes10.dex */
public abstract class d extends a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static d dsz;
    private static Handler sMainHandler;
    private com.baidu.swan.apps.adaptation.a dsB;
    private com.baidu.swan.pms.c.f dsG;
    public final com.baidu.swan.apps.u.c.a.c dsA = new c.a();
    private final Set<com.baidu.swan.apps.ap.e.b<i.a>> dsC = new HashSet();
    public volatile int dsD = 0;
    private final Queue<Runnable> dsE = new ArrayDeque();
    private Runnable dsF = null;
    private boolean inited = false;

    protected abstract com.baidu.swan.pms.c.f aHp();

    public static d aHq() {
        d aHr = aHr();
        if (!aHr.inited) {
            aHr.init();
        }
        return aHr;
    }

    private static d aHr() {
        if (dsz instanceof j) {
            return dsz;
        }
        synchronized (d.class) {
            if (dsz instanceof j) {
                return dsz;
            }
            SwanAppProcessInfo current = SwanAppProcessInfo.current();
            if (current.isSwanClient) {
                dsz = new j();
                return dsz;
            } else if (current.isSwanService) {
                if (!(dsz instanceof l)) {
                    dsz = new l();
                }
                return dsz;
            } else {
                if (dsz == null) {
                    dsz = new c();
                }
                return dsz;
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
            aHt();
            com.baidu.swan.apps.process.b.c.init();
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.adaptation.a aHs() {
        if (this.dsB == null) {
            this.dsB = new com.baidu.swan.apps.adaptation.a();
        }
        return this.dsB;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void rT(String str) {
        f(str, null);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void f(String str, Bundle bundle) {
        i(new i.a(str, bundle));
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void i(final i.a aVar) {
        if (DEBUG) {
            Log.i("SwanImpl", "SwanEvent dispatchEvent: " + aVar + " mEventCallbacks:" + this.dsC.size());
        }
        if (aVar != null) {
            g(new Runnable() { // from class: com.baidu.swan.apps.runtime.d.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean z = Looper.getMainLooper() == Looper.myLooper();
                    for (final com.baidu.swan.apps.ap.e.b bVar : d.this.dsC) {
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
                    d.this.dsC.add(bVar);
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
                    d.this.dsC.remove(bVar);
                }
            });
        }
    }

    private synchronized void g(@NonNull Runnable runnable) {
        this.dsE.offer(runnable);
        if (this.dsF == null) {
            while (!this.dsE.isEmpty()) {
                this.dsF = this.dsE.poll();
                if (this.dsF != null) {
                    this.dsF.run();
                }
                this.dsF = null;
            }
        }
    }

    public com.baidu.swan.pms.c.f aHt() {
        if (this.dsG == null) {
            this.dsG = aHp();
        }
        return this.dsG;
    }
}
