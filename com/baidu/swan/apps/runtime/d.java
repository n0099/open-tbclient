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
    private static d cGS;
    private static Handler sMainHandler;
    private com.baidu.swan.apps.adaptation.a cGU;
    private com.baidu.swan.pms.c.f cGZ;
    public final com.baidu.swan.apps.u.c.a.c cGT = new c.a();
    private final Set<com.baidu.swan.apps.aq.e.b<i.a>> cGV = new HashSet();
    public volatile int cGW = 0;
    private final Queue<Runnable> cGX = new ArrayDeque();
    private Runnable cGY = null;
    private boolean inited = false;

    protected abstract com.baidu.swan.pms.c.f arq();

    public static d arr() {
        d ars = ars();
        if (!ars.inited) {
            ars.init();
        }
        return ars;
    }

    private static d ars() {
        if (cGS instanceof j) {
            return cGS;
        }
        synchronized (d.class) {
            if (cGS instanceof j) {
                return cGS;
            }
            SwanAppProcessInfo current = SwanAppProcessInfo.current();
            if (current.isSwanClient) {
                cGS = new j();
                return cGS;
            } else if (current.isSwanService) {
                if (!(cGS instanceof l)) {
                    cGS = new l();
                }
                return cGS;
            } else {
                if (cGS == null) {
                    cGS = new c();
                }
                return cGS;
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
            aru();
            com.baidu.swan.apps.process.b.c.init();
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.adaptation.a art() {
        if (this.cGU == null) {
            this.cGU = new com.baidu.swan.apps.adaptation.a();
        }
        return this.cGU;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void oi(String str) {
        g(str, null);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void g(String str, Bundle bundle) {
        i(new i.a(str, bundle));
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void i(final i.a aVar) {
        if (DEBUG) {
            Log.i("SwanImpl", "SwanEvent dispatchEvent: " + aVar + " mEventCallbacks:" + this.cGV.size());
        }
        if (aVar != null) {
            j(new Runnable() { // from class: com.baidu.swan.apps.runtime.d.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean z = Looper.getMainLooper() == Looper.myLooper();
                    for (final com.baidu.swan.apps.aq.e.b bVar : d.this.cGV) {
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
    public void o(final com.baidu.swan.apps.aq.e.b<i.a> bVar) {
        if (bVar != null) {
            j(new Runnable() { // from class: com.baidu.swan.apps.runtime.d.2
                @Override // java.lang.Runnable
                public void run() {
                    d.this.cGV.add(bVar);
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void p(final com.baidu.swan.apps.aq.e.b<i.a> bVar) {
        if (bVar != null) {
            j(new Runnable() { // from class: com.baidu.swan.apps.runtime.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.cGV.remove(bVar);
                }
            });
        }
    }

    private synchronized void j(@NonNull Runnable runnable) {
        this.cGX.offer(runnable);
        if (this.cGY == null) {
            while (!this.cGX.isEmpty()) {
                this.cGY = this.cGX.poll();
                if (this.cGY != null) {
                    this.cGY.run();
                }
                this.cGY = null;
            }
        }
    }

    public com.baidu.swan.pms.c.f aru() {
        if (this.cGZ == null) {
            this.cGZ = arq();
        }
        return this.cGZ;
    }
}
