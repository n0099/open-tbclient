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
/* loaded from: classes8.dex */
public abstract class d extends a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static d dFp;
    private static Handler sMainHandler;
    private com.baidu.swan.apps.adaptation.a dFr;
    private com.baidu.swan.pms.c.f dFw;
    public final com.baidu.swan.apps.u.c.a.c dFq = new c.a();
    private final Set<com.baidu.swan.apps.ao.e.b<i.a>> dFs = new HashSet();
    public volatile int dFt = 0;
    private final Queue<Runnable> dFu = new ArrayDeque();
    private Runnable dFv = null;
    private boolean dFx = false;

    protected abstract com.baidu.swan.pms.c.f aII();

    public static d aIJ() {
        d aIK = aIK();
        if (!aIK.dFx) {
            aIK.init();
        }
        return aIK;
    }

    private static d aIK() {
        if (dFp instanceof j) {
            return dFp;
        }
        synchronized (d.class) {
            if (dFp instanceof j) {
                return dFp;
            }
            SwanAppProcessInfo current = SwanAppProcessInfo.current();
            if (current.isSwanClient) {
                dFp = new j();
                return dFp;
            } else if (current.isSwanService) {
                if (!(dFp instanceof l)) {
                    dFp = new l();
                }
                return dFp;
            } else {
                if (dFp == null) {
                    dFp = new c();
                }
                return dFp;
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
        if (!this.dFx) {
            aIM();
            com.baidu.swan.apps.process.b.c.init();
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.adaptation.a aIL() {
        if (this.dFr == null) {
            this.dFr = new com.baidu.swan.apps.adaptation.a();
        }
        return this.dFr;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void rG(String str) {
        g(str, null);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void g(String str, Bundle bundle) {
        i(new i.a(str, bundle));
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void i(final i.a aVar) {
        if (DEBUG) {
            Log.i("SwanImpl", "SwanEvent dispatchEvent: " + aVar + " mEventCallbacks:" + this.dFs.size());
        }
        if (aVar != null) {
            d(new Runnable() { // from class: com.baidu.swan.apps.runtime.d.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean z = Looper.getMainLooper() == Looper.myLooper();
                    for (final com.baidu.swan.apps.ao.e.b bVar : d.this.dFs) {
                        if (z && !aVar.getBoolean("event_flag_force_post", false)) {
                            bVar.N(aVar);
                        } else {
                            d.getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.runtime.d.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    bVar.N(aVar);
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
            d(new Runnable() { // from class: com.baidu.swan.apps.runtime.d.2
                @Override // java.lang.Runnable
                public void run() {
                    d.this.dFs.add(bVar);
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void w(final com.baidu.swan.apps.ao.e.b<i.a> bVar) {
        if (bVar != null) {
            d(new Runnable() { // from class: com.baidu.swan.apps.runtime.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.dFs.remove(bVar);
                }
            });
        }
    }

    private synchronized void d(@NonNull Runnable runnable) {
        this.dFu.offer(runnable);
        if (this.dFv == null) {
            while (!this.dFu.isEmpty()) {
                this.dFv = this.dFu.poll();
                if (this.dFv != null) {
                    this.dFv.run();
                }
                this.dFv = null;
            }
        }
    }

    public com.baidu.swan.pms.c.f aIM() {
        if (this.dFw == null) {
            this.dFw = aII();
        }
        return this.dFw;
    }
}
