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
    private static c bOZ;
    private static j bPa;
    private static Handler sMainHandler;
    private com.baidu.swan.apps.adaptation.a bPc;
    public final com.baidu.swan.apps.x.b.a.c bPb = new c.a();
    private final Set<com.baidu.swan.apps.as.d.b<i.a>> bPd = new HashSet();
    public int bPe = 0;

    public static d acF() {
        if (bPa != null) {
            return bPa;
        }
        synchronized (d.class) {
            if (bPa != null) {
                return bPa;
            } else if (SwanAppProcessInfo.current().isSwanAppProcess()) {
                bPa = new j();
                acG();
                return bPa;
            } else {
                if (bOZ == null) {
                    bOZ = new c();
                }
                return bOZ;
            }
        }
    }

    private static void acG() {
        if (bOZ != null) {
            bOZ = null;
        }
    }

    public static Handler getMainHandler() {
        if (sMainHandler == null) {
            sMainHandler = new Handler(Looper.getMainLooper());
        }
        return sMainHandler;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.adaptation.a acH() {
        if (this.bPc == null) {
            this.bPc = new com.baidu.swan.apps.adaptation.a();
        }
        return this.bPc;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void kK(String str) {
        d(str, null);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void d(String str, Bundle bundle) {
        d(new i.a(str, bundle));
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void d(final i.a aVar) {
        if (DEBUG) {
            Log.i("SwanImpl", "dispatchEvent: " + aVar + " mEventCallbacks:" + this.bPd.size());
        }
        if (aVar != null) {
            synchronized (this.bPd) {
                boolean z = Looper.getMainLooper() == Looper.myLooper();
                for (final com.baidu.swan.apps.as.d.b<i.a> bVar : this.bPd) {
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
            synchronized (this.bPd) {
                this.bPd.add(bVar);
            }
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void f(com.baidu.swan.apps.as.d.b<i.a> bVar) {
        if (bVar != null) {
            synchronized (this.bPd) {
                this.bPd.remove(bVar);
            }
        }
    }
}
