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
    private static d dBK;
    private static Handler sMainHandler;
    private com.baidu.swan.apps.adaptation.a dBM;
    private com.baidu.swan.pms.c.f dBR;
    public final com.baidu.swan.apps.u.c.a.c dBL = new c.a();
    private final Set<com.baidu.swan.apps.ao.e.b<i.a>> dBN = new HashSet();
    public volatile int dBO = 0;
    private final Queue<Runnable> dBP = new ArrayDeque();
    private Runnable dBQ = null;
    private boolean dBS = false;

    protected abstract com.baidu.swan.pms.c.f aIm();

    public static d aIn() {
        d aIo = aIo();
        if (!aIo.dBS) {
            aIo.init();
        }
        return aIo;
    }

    private static d aIo() {
        if (dBK instanceof j) {
            return dBK;
        }
        synchronized (d.class) {
            if (dBK instanceof j) {
                return dBK;
            }
            SwanAppProcessInfo current = SwanAppProcessInfo.current();
            if (current.isSwanClient) {
                dBK = new j();
                return dBK;
            } else if (current.isSwanService) {
                if (!(dBK instanceof l)) {
                    dBK = new l();
                }
                return dBK;
            } else {
                if (dBK == null) {
                    dBK = new c();
                }
                return dBK;
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
        if (!this.dBS) {
            aIq();
            com.baidu.swan.apps.process.b.c.init();
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.adaptation.a aIp() {
        if (this.dBM == null) {
            this.dBM = new com.baidu.swan.apps.adaptation.a();
        }
        return this.dBM;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void rg(String str) {
        g(str, null);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void g(String str, Bundle bundle) {
        i(new i.a(str, bundle));
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void i(final i.a aVar) {
        if (DEBUG) {
            Log.i("SwanImpl", "SwanEvent dispatchEvent: " + aVar + " mEventCallbacks:" + this.dBN.size());
        }
        if (aVar != null) {
            f(new Runnable() { // from class: com.baidu.swan.apps.runtime.d.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean z = Looper.getMainLooper() == Looper.myLooper();
                    for (final com.baidu.swan.apps.ao.e.b bVar : d.this.dBN) {
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
                    d.this.dBN.add(bVar);
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
                    d.this.dBN.remove(bVar);
                }
            });
        }
    }

    private synchronized void f(@NonNull Runnable runnable) {
        this.dBP.offer(runnable);
        if (this.dBQ == null) {
            while (!this.dBP.isEmpty()) {
                this.dBQ = this.dBP.poll();
                if (this.dBQ != null) {
                    this.dBQ.run();
                }
                this.dBQ = null;
            }
        }
    }

    public com.baidu.swan.pms.c.f aIq() {
        if (this.dBR == null) {
            this.dBR = aIm();
        }
        return this.dBR;
    }
}
