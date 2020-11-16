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
/* loaded from: classes7.dex */
public abstract class d extends a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static d dqQ;
    private static Handler sMainHandler;
    private com.baidu.swan.apps.adaptation.a dqS;
    private com.baidu.swan.pms.c.f dqX;
    public final com.baidu.swan.apps.u.c.a.c dqR = new c.a();
    private final Set<com.baidu.swan.apps.ap.e.b<i.a>> dqT = new HashSet();
    public volatile int dqU = 0;
    private final Queue<Runnable> dqV = new ArrayDeque();
    private Runnable dqW = null;
    private boolean inited = false;

    protected abstract com.baidu.swan.pms.c.f aGH();

    public static d aGI() {
        d aGJ = aGJ();
        if (!aGJ.inited) {
            aGJ.init();
        }
        return aGJ;
    }

    private static d aGJ() {
        if (dqQ instanceof j) {
            return dqQ;
        }
        synchronized (d.class) {
            if (dqQ instanceof j) {
                return dqQ;
            }
            SwanAppProcessInfo current = SwanAppProcessInfo.current();
            if (current.isSwanClient) {
                dqQ = new j();
                return dqQ;
            } else if (current.isSwanService) {
                if (!(dqQ instanceof l)) {
                    dqQ = new l();
                }
                return dqQ;
            } else {
                if (dqQ == null) {
                    dqQ = new c();
                }
                return dqQ;
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
            aGL();
            com.baidu.swan.apps.process.b.c.init();
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.adaptation.a aGK() {
        if (this.dqS == null) {
            this.dqS = new com.baidu.swan.apps.adaptation.a();
        }
        return this.dqS;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void rN(String str) {
        f(str, null);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void f(String str, Bundle bundle) {
        i(new i.a(str, bundle));
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void i(final i.a aVar) {
        if (DEBUG) {
            Log.i("SwanImpl", "SwanEvent dispatchEvent: " + aVar + " mEventCallbacks:" + this.dqT.size());
        }
        if (aVar != null) {
            g(new Runnable() { // from class: com.baidu.swan.apps.runtime.d.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean z = Looper.getMainLooper() == Looper.myLooper();
                    for (final com.baidu.swan.apps.ap.e.b bVar : d.this.dqT) {
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
                    d.this.dqT.add(bVar);
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
                    d.this.dqT.remove(bVar);
                }
            });
        }
    }

    private synchronized void g(@NonNull Runnable runnable) {
        this.dqV.offer(runnable);
        if (this.dqW == null) {
            while (!this.dqV.isEmpty()) {
                this.dqW = this.dqV.poll();
                if (this.dqW != null) {
                    this.dqW.run();
                }
                this.dqW = null;
            }
        }
    }

    public com.baidu.swan.pms.c.f aGL() {
        if (this.dqX == null) {
            this.dqX = aGH();
        }
        return this.dqX;
    }
}
