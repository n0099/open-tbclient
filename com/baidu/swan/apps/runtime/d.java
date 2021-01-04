package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.i;
import com.baidu.swan.apps.u.c.a.c;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
/* loaded from: classes9.dex */
public abstract class d extends a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static d dGw;
    private static Handler sMainHandler;
    private com.baidu.swan.pms.c.f dGD;
    private com.baidu.swan.apps.adaptation.a dGy;
    public final com.baidu.swan.apps.u.c.a.c dGx = new c.a();
    private final Set<com.baidu.swan.apps.ao.e.b<i.a>> dGz = new HashSet();
    public volatile int dGA = 0;
    private final Queue<Runnable> dGB = new ArrayDeque();
    private Runnable dGC = null;
    private boolean dGE = false;

    protected abstract com.baidu.swan.pms.c.f aMf();

    public static d aMg() {
        d aMh = aMh();
        if (!aMh.dGE) {
            aMh.init();
        }
        return aMh;
    }

    private static d aMh() {
        if (dGw instanceof j) {
            return dGw;
        }
        synchronized (d.class) {
            if (dGw instanceof j) {
                return dGw;
            }
            SwanAppProcessInfo current = SwanAppProcessInfo.current();
            if (current.isSwanClient) {
                dGw = new j();
                return dGw;
            } else if (current.isSwanService) {
                if (!(dGw instanceof l)) {
                    dGw = new l();
                }
                return dGw;
            } else {
                if (dGw == null) {
                    dGw = new c();
                }
                return dGw;
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
        if (!this.dGE) {
            aMj();
            com.baidu.swan.apps.process.b.c.init();
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.adaptation.a aMi() {
        if (this.dGy == null) {
            this.dGy = new com.baidu.swan.apps.adaptation.a();
        }
        return this.dGy;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void ss(String str) {
        f(str, null);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void f(String str, Bundle bundle) {
        i(new i.a(str, bundle));
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void i(final i.a aVar) {
        if (DEBUG) {
            Log.i("SwanImpl", "SwanEvent dispatchEvent: " + aVar + " mEventCallbacks:" + this.dGz.size());
        }
        if (aVar != null) {
            f(new Runnable() { // from class: com.baidu.swan.apps.runtime.d.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean z = Looper.getMainLooper() == Looper.myLooper();
                    for (final com.baidu.swan.apps.ao.e.b bVar : d.this.dGz) {
                        if (z && !aVar.getBoolean("event_flag_force_post", false)) {
                            bVar.L(aVar);
                        } else {
                            d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.runtime.d.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    bVar.L(aVar);
                                }
                            });
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void v(final com.baidu.swan.apps.ao.e.b<i.a> bVar) {
        if (bVar != null) {
            f(new Runnable() { // from class: com.baidu.swan.apps.runtime.d.2
                @Override // java.lang.Runnable
                public void run() {
                    d.this.dGz.add(bVar);
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void w(final com.baidu.swan.apps.ao.e.b<i.a> bVar) {
        if (bVar != null) {
            f(new Runnable() { // from class: com.baidu.swan.apps.runtime.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.dGz.remove(bVar);
                }
            });
        }
    }

    private synchronized void f(@NonNull Runnable runnable) {
        this.dGB.offer(runnable);
        if (this.dGC == null) {
            while (!this.dGB.isEmpty()) {
                this.dGC = this.dGB.poll();
                if (this.dGC != null) {
                    this.dGC.run();
                }
                this.dGC = null;
            }
        }
    }

    public com.baidu.swan.pms.c.f aMj() {
        if (this.dGD == null) {
            this.dGD = aMf();
        }
        return this.dGD;
    }
}
