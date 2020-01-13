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
/* loaded from: classes10.dex */
public abstract class d extends a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static c bKH;
    private static j bKI;
    private static Handler sMainHandler;
    private com.baidu.swan.apps.adaptation.a bKK;
    public final com.baidu.swan.apps.x.b.a.c bKJ = new c.a();
    private final Set<com.baidu.swan.apps.as.d.b<i.a>> bKL = new HashSet();
    public int bKM = 0;

    public static d aam() {
        if (bKI != null) {
            return bKI;
        }
        synchronized (d.class) {
            if (bKI != null) {
                return bKI;
            } else if (SwanAppProcessInfo.current().isSwanAppProcess()) {
                bKI = new j();
                aan();
                return bKI;
            } else {
                if (bKH == null) {
                    bKH = new c();
                }
                return bKH;
            }
        }
    }

    private static void aan() {
        if (bKH != null) {
            bKH = null;
        }
    }

    public static Handler getMainHandler() {
        if (sMainHandler == null) {
            sMainHandler = new Handler(Looper.getMainLooper());
        }
        return sMainHandler;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.adaptation.a aao() {
        if (this.bKK == null) {
            this.bKK = new com.baidu.swan.apps.adaptation.a();
        }
        return this.bKK;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void kw(String str) {
        d(str, null);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void d(String str, Bundle bundle) {
        d(new i.a(str, bundle));
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void d(final i.a aVar) {
        if (DEBUG) {
            Log.i("SwanImpl", "dispatchEvent: " + aVar + " mEventCallbacks:" + this.bKL.size());
        }
        if (aVar != null) {
            synchronized (this.bKL) {
                boolean z = Looper.getMainLooper() == Looper.myLooper();
                for (final com.baidu.swan.apps.as.d.b<i.a> bVar : this.bKL) {
                    if (z && !aVar.getBoolean("event_flag_force_post", false)) {
                        bVar.B(aVar);
                    } else {
                        getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.runtime.d.1
                            @Override // java.lang.Runnable
                            public void run() {
                                bVar.B(aVar);
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
            synchronized (this.bKL) {
                this.bKL.add(bVar);
            }
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void f(com.baidu.swan.apps.as.d.b<i.a> bVar) {
        if (bVar != null) {
            synchronized (this.bKL) {
                this.bKL.remove(bVar);
            }
        }
    }
}
