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
    private static c bOO;
    private static j bOP;
    private static Handler sMainHandler;
    private com.baidu.swan.apps.adaptation.a bOR;
    public final com.baidu.swan.apps.x.b.a.c bOQ = new c.a();
    private final Set<com.baidu.swan.apps.as.d.b<i.a>> bOS = new HashSet();
    public int bOT = 0;

    public static d acC() {
        if (bOP != null) {
            return bOP;
        }
        synchronized (d.class) {
            if (bOP != null) {
                return bOP;
            } else if (SwanAppProcessInfo.current().isSwanAppProcess()) {
                bOP = new j();
                acD();
                return bOP;
            } else {
                if (bOO == null) {
                    bOO = new c();
                }
                return bOO;
            }
        }
    }

    private static void acD() {
        if (bOO != null) {
            bOO = null;
        }
    }

    public static Handler getMainHandler() {
        if (sMainHandler == null) {
            sMainHandler = new Handler(Looper.getMainLooper());
        }
        return sMainHandler;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.adaptation.a acE() {
        if (this.bOR == null) {
            this.bOR = new com.baidu.swan.apps.adaptation.a();
        }
        return this.bOR;
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
            Log.i("SwanImpl", "dispatchEvent: " + aVar + " mEventCallbacks:" + this.bOS.size());
        }
        if (aVar != null) {
            synchronized (this.bOS) {
                boolean z = Looper.getMainLooper() == Looper.myLooper();
                for (final com.baidu.swan.apps.as.d.b<i.a> bVar : this.bOS) {
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
            synchronized (this.bOS) {
                this.bOS.add(bVar);
            }
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void f(com.baidu.swan.apps.as.d.b<i.a> bVar) {
        if (bVar != null) {
            synchronized (this.bOS) {
                this.bOS.remove(bVar);
            }
        }
    }
}
