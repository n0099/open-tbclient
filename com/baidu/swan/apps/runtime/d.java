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
    private static c bON;
    private static j bOO;
    private static Handler sMainHandler;
    private com.baidu.swan.apps.adaptation.a bOQ;
    public final com.baidu.swan.apps.x.b.a.c bOP = new c.a();
    private final Set<com.baidu.swan.apps.as.d.b<i.a>> bOR = new HashSet();
    public int bOS = 0;

    public static d acC() {
        if (bOO != null) {
            return bOO;
        }
        synchronized (d.class) {
            if (bOO != null) {
                return bOO;
            } else if (SwanAppProcessInfo.current().isSwanAppProcess()) {
                bOO = new j();
                acD();
                return bOO;
            } else {
                if (bON == null) {
                    bON = new c();
                }
                return bON;
            }
        }
    }

    private static void acD() {
        if (bON != null) {
            bON = null;
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
        if (this.bOQ == null) {
            this.bOQ = new com.baidu.swan.apps.adaptation.a();
        }
        return this.bOQ;
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
            Log.i("SwanImpl", "dispatchEvent: " + aVar + " mEventCallbacks:" + this.bOR.size());
        }
        if (aVar != null) {
            synchronized (this.bOR) {
                boolean z = Looper.getMainLooper() == Looper.myLooper();
                for (final com.baidu.swan.apps.as.d.b<i.a> bVar : this.bOR) {
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
            synchronized (this.bOR) {
                this.bOR.add(bVar);
            }
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void f(com.baidu.swan.apps.as.d.b<i.a> bVar) {
        if (bVar != null) {
            synchronized (this.bOR) {
                this.bOR.remove(bVar);
            }
        }
    }
}
