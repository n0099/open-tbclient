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
    private static d dec;
    private static Handler sMainHandler;
    private com.baidu.swan.apps.adaptation.a dee;
    private com.baidu.swan.pms.c.f dej;
    public final com.baidu.swan.apps.u.c.a.c ded = new c.a();
    private final Set<com.baidu.swan.apps.ap.e.b<i.a>> def = new HashSet();
    public volatile int deg = 0;
    private final Queue<Runnable> deh = new ArrayDeque();
    private Runnable dei = null;
    private boolean inited = false;

    protected abstract com.baidu.swan.pms.c.f aCV();

    public static d aCW() {
        d aCX = aCX();
        if (!aCX.inited) {
            aCX.init();
        }
        return aCX;
    }

    private static d aCX() {
        if (dec instanceof j) {
            return dec;
        }
        synchronized (d.class) {
            if (dec instanceof j) {
                return dec;
            }
            SwanAppProcessInfo current = SwanAppProcessInfo.current();
            if (current.isSwanClient) {
                dec = new j();
                return dec;
            } else if (current.isSwanService) {
                if (!(dec instanceof l)) {
                    dec = new l();
                }
                return dec;
            } else {
                if (dec == null) {
                    dec = new c();
                }
                return dec;
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
            aCZ();
            com.baidu.swan.apps.process.b.c.init();
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.adaptation.a aCY() {
        if (this.dee == null) {
            this.dee = new com.baidu.swan.apps.adaptation.a();
        }
        return this.dee;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void rm(String str) {
        f(str, null);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void f(String str, Bundle bundle) {
        i(new i.a(str, bundle));
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void i(final i.a aVar) {
        if (DEBUG) {
            Log.i("SwanImpl", "SwanEvent dispatchEvent: " + aVar + " mEventCallbacks:" + this.def.size());
        }
        if (aVar != null) {
            g(new Runnable() { // from class: com.baidu.swan.apps.runtime.d.1
                @Override // java.lang.Runnable
                public void run() {
                    boolean z = Looper.getMainLooper() == Looper.myLooper();
                    for (final com.baidu.swan.apps.ap.e.b bVar : d.this.def) {
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
                    d.this.def.add(bVar);
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
                    d.this.def.remove(bVar);
                }
            });
        }
    }

    private synchronized void g(@NonNull Runnable runnable) {
        this.deh.offer(runnable);
        if (this.dei == null) {
            while (!this.deh.isEmpty()) {
                this.dei = this.deh.poll();
                if (this.dei != null) {
                    this.dei.run();
                }
                this.dei = null;
            }
        }
    }

    public com.baidu.swan.pms.c.f aCZ() {
        if (this.dej == null) {
            this.dej = aCV();
        }
        return this.dej;
    }
}
