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
    private static d dDO;
    private static Handler sMainHandler;
    private com.baidu.swan.apps.adaptation.a dDQ;
    private com.baidu.swan.pms.c.f dDV;
    public final com.baidu.swan.apps.u.c.a.c dDP = new c.a();
    private final Set<com.baidu.swan.apps.ao.e.b<i.a>> dDR = new HashSet();
    public volatile int dDS = 0;
    private final Queue<Runnable> dDT = new ArrayDeque();
    private Runnable dDU = null;
    private boolean dDW = false;

    protected abstract com.baidu.swan.pms.c.f aIF();

    public static d aIG() {
        d aIH = aIH();
        if (!aIH.dDW) {
            aIH.init();
        }
        return aIH;
    }

    private static d aIH() {
        if (dDO instanceof j) {
            return dDO;
        }
        synchronized (d.class) {
            if (dDO instanceof j) {
                return dDO;
            }
            SwanAppProcessInfo current = SwanAppProcessInfo.current();
            if (current.isSwanClient) {
                dDO = new j();
                return dDO;
            } else if (current.isSwanService) {
                if (!(dDO instanceof l)) {
                    dDO = new l();
                }
                return dDO;
            } else {
                if (dDO == null) {
                    dDO = new c();
                }
                return dDO;
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
        if (!this.dDW) {
            aIJ();
            com.baidu.swan.apps.process.b.c.init();
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.adaptation.a aII() {
        if (this.dDQ == null) {
            this.dDQ = new com.baidu.swan.apps.adaptation.a();
        }
        return this.dDQ;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void rz(String str) {
        g(str, null);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void g(String str, Bundle bundle) {
        i(new i.a(str, bundle));
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void i(final i.a aVar) {
        if (DEBUG) {
            Log.i("SwanImpl", "SwanEvent dispatchEvent: " + aVar + " mEventCallbacks:" + this.dDR.size());
        }
        if (aVar != null) {
            e(new Runnable() { // from class: com.baidu.swan.apps.runtime.d.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean z = Looper.getMainLooper() == Looper.myLooper();
                    for (final com.baidu.swan.apps.ao.e.b bVar : d.this.dDR) {
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
            e(new Runnable() { // from class: com.baidu.swan.apps.runtime.d.2
                @Override // java.lang.Runnable
                public void run() {
                    d.this.dDR.add(bVar);
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void w(final com.baidu.swan.apps.ao.e.b<i.a> bVar) {
        if (bVar != null) {
            e(new Runnable() { // from class: com.baidu.swan.apps.runtime.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.dDR.remove(bVar);
                }
            });
        }
    }

    private synchronized void e(@NonNull Runnable runnable) {
        this.dDT.offer(runnable);
        if (this.dDU == null) {
            while (!this.dDT.isEmpty()) {
                this.dDU = this.dDT.poll();
                if (this.dDU != null) {
                    this.dDU.run();
                }
                this.dDU = null;
            }
        }
    }

    public com.baidu.swan.pms.c.f aIJ() {
        if (this.dDV == null) {
            this.dDV = aIF();
        }
        return this.dDV;
    }
}
