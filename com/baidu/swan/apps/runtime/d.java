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
    private static d dmC;
    private static Handler sMainHandler;
    private com.baidu.swan.apps.adaptation.a dmE;
    private com.baidu.swan.pms.c.f dmJ;
    public final com.baidu.swan.apps.u.c.a.c dmD = new c.a();
    private final Set<com.baidu.swan.apps.ap.e.b<i.a>> dmF = new HashSet();
    public volatile int dmG = 0;
    private final Queue<Runnable> dmH = new ArrayDeque();
    private Runnable dmI = null;
    private boolean inited = false;

    protected abstract com.baidu.swan.pms.c.f aEP();

    public static d aEQ() {
        d aER = aER();
        if (!aER.inited) {
            aER.init();
        }
        return aER;
    }

    private static d aER() {
        if (dmC instanceof j) {
            return dmC;
        }
        synchronized (d.class) {
            if (dmC instanceof j) {
                return dmC;
            }
            SwanAppProcessInfo current = SwanAppProcessInfo.current();
            if (current.isSwanClient) {
                dmC = new j();
                return dmC;
            } else if (current.isSwanService) {
                if (!(dmC instanceof l)) {
                    dmC = new l();
                }
                return dmC;
            } else {
                if (dmC == null) {
                    dmC = new c();
                }
                return dmC;
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
            aET();
            com.baidu.swan.apps.process.b.c.init();
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.adaptation.a aES() {
        if (this.dmE == null) {
            this.dmE = new com.baidu.swan.apps.adaptation.a();
        }
        return this.dmE;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void rF(String str) {
        f(str, null);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void f(String str, Bundle bundle) {
        i(new i.a(str, bundle));
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void i(final i.a aVar) {
        if (DEBUG) {
            Log.i("SwanImpl", "SwanEvent dispatchEvent: " + aVar + " mEventCallbacks:" + this.dmF.size());
        }
        if (aVar != null) {
            g(new Runnable() { // from class: com.baidu.swan.apps.runtime.d.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean z = Looper.getMainLooper() == Looper.myLooper();
                    for (final com.baidu.swan.apps.ap.e.b bVar : d.this.dmF) {
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
                    d.this.dmF.add(bVar);
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
                    d.this.dmF.remove(bVar);
                }
            });
        }
    }

    private synchronized void g(@NonNull Runnable runnable) {
        this.dmH.offer(runnable);
        if (this.dmI == null) {
            while (!this.dmH.isEmpty()) {
                this.dmI = this.dmH.poll();
                if (this.dmI != null) {
                    this.dmI.run();
                }
                this.dmI = null;
            }
        }
    }

    public com.baidu.swan.pms.c.f aET() {
        if (this.dmJ == null) {
            this.dmJ = aEP();
        }
        return this.dmJ;
    }
}
