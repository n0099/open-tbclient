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
    private static d czv;
    private static Handler sMainHandler;
    private com.baidu.swan.pms.c.f czC;
    private com.baidu.swan.apps.adaptation.a czx;
    public final com.baidu.swan.apps.v.b.a.c czw = new c.a();
    private final Set<com.baidu.swan.apps.aq.e.b<i.a>> czy = new HashSet();
    public int czz = 0;
    private final Queue<Runnable> czA = new ArrayDeque();
    private Runnable czB = null;
    private boolean inited = false;

    protected abstract com.baidu.swan.pms.c.f aoA();

    public static d aoB() {
        d aoC = aoC();
        if (!aoC.inited) {
            aoC.init();
        }
        return aoC;
    }

    private static d aoC() {
        if (czv instanceof j) {
            return czv;
        }
        synchronized (d.class) {
            if (czv instanceof j) {
                return czv;
            }
            SwanAppProcessInfo current = SwanAppProcessInfo.current();
            if (current.isSwanClient) {
                czv = new j();
                return czv;
            } else if (current.isSwanService) {
                if (!(czv instanceof l)) {
                    czv = new l();
                }
                return czv;
            } else {
                if (czv == null) {
                    czv = new c();
                }
                return czv;
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
            aoE();
            com.baidu.swan.apps.process.b.c.init();
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.adaptation.a aoD() {
        if (this.czx == null) {
            this.czx = new com.baidu.swan.apps.adaptation.a();
        }
        return this.czx;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void ns(String str) {
        g(str, null);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void g(String str, Bundle bundle) {
        i(new i.a(str, bundle));
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void i(final i.a aVar) {
        if (DEBUG) {
            Log.i("SwanImpl", "SwanEvent dispatchEvent: " + aVar + " mEventCallbacks:" + this.czy.size());
        }
        if (aVar != null) {
            j(new Runnable() { // from class: com.baidu.swan.apps.runtime.d.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean z = Looper.getMainLooper() == Looper.myLooper();
                    for (final com.baidu.swan.apps.aq.e.b bVar : d.this.czy) {
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
                    d.this.czy.add(bVar);
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
                    d.this.czy.remove(bVar);
                }
            });
        }
    }

    private synchronized void j(@NonNull Runnable runnable) {
        this.czA.offer(runnable);
        if (this.czB == null) {
            while (!this.czA.isEmpty()) {
                this.czB = this.czA.poll();
                if (this.czB != null) {
                    this.czB.run();
                }
                this.czB = null;
            }
        }
    }

    public com.baidu.swan.pms.c.f aoE() {
        if (this.czC == null) {
            this.czC = aoA();
        }
        return this.czC;
    }
}
