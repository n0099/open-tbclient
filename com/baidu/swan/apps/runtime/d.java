package com.baidu.swan.apps.runtime;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.runtime.i;
import com.baidu.swan.apps.x.b.a.c;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes11.dex */
public abstract class d extends a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static c bOM;
    private static j bON;
    private static Handler sMainHandler;
    private com.baidu.swan.apps.adaptation.a bOP;
    public final com.baidu.swan.apps.x.b.a.c bOO = new c.a();
    private final Set<com.baidu.swan.apps.as.d.b<i.a>> bOQ = new HashSet();
    public int bOR = 0;

    public static d acA() {
        if (bON != null) {
            return bON;
        }
        synchronized (d.class) {
            if (bON != null) {
                return bON;
            } else if (SwanAppProcessInfo.current().isSwanAppProcess()) {
                bON = new j();
                acB();
                return bON;
            } else {
                if (bOM == null) {
                    bOM = new c();
                }
                return bOM;
            }
        }
    }

    private static void acB() {
        if (bOM != null) {
            bOM = null;
        }
    }

    public static Handler getMainHandler() {
        if (sMainHandler == null) {
            sMainHandler = new Handler(Looper.getMainLooper());
        }
        return sMainHandler;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.adaptation.a acC() {
        if (this.bOP == null) {
            this.bOP = new com.baidu.swan.apps.adaptation.a();
        }
        return this.bOP;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void kL(String str) {
        d(str, null);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void d(String str, Bundle bundle) {
        d(new i.a(str, bundle));
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void d(final i.a aVar) {
        if (DEBUG) {
            Log.i("SwanImpl", "dispatchEvent: " + aVar + " mEventCallbacks:" + this.bOQ.size());
        }
        if (aVar != null) {
            synchronized (this.bOQ) {
                boolean z = Looper.getMainLooper() == Looper.myLooper();
                for (final com.baidu.swan.apps.as.d.b<i.a> bVar : this.bOQ) {
                    if (z && !aVar.getBoolean("event_flag_force_post", false)) {
                        bVar.D(aVar);
                    } else {
                        getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.runtime.d.1
                            @Override // java.lang.Runnable
                            public void run() {
                                bVar.D(aVar);
                            }
                        });
                    }
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void e(com.baidu.swan.apps.as.d.b<i.a> bVar) {
        if (bVar != null) {
            synchronized (this.bOQ) {
                this.bOQ.add(bVar);
            }
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void f(com.baidu.swan.apps.as.d.b<i.a> bVar) {
        if (bVar != null) {
            synchronized (this.bOQ) {
                this.bOQ.remove(bVar);
            }
        }
    }
}
