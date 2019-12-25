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
/* loaded from: classes9.dex */
public abstract class d extends a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static c bJX;
    private static j bJY;
    private static Handler sMainHandler;
    private com.baidu.swan.apps.adaptation.a bKa;
    public final com.baidu.swan.apps.x.b.a.c bJZ = new c.a();
    private final Set<com.baidu.swan.apps.as.d.b<i.a>> bKb = new HashSet();
    public int bKc = 0;

    public static d ZP() {
        if (bJY != null) {
            return bJY;
        }
        synchronized (d.class) {
            if (bJY != null) {
                return bJY;
            } else if (SwanAppProcessInfo.current().isSwanAppProcess()) {
                bJY = new j();
                ZQ();
                return bJY;
            } else {
                if (bJX == null) {
                    bJX = new c();
                }
                return bJX;
            }
        }
    }

    private static void ZQ() {
        if (bJX != null) {
            bJX = null;
        }
    }

    public static Handler getMainHandler() {
        if (sMainHandler == null) {
            sMainHandler = new Handler(Looper.getMainLooper());
        }
        return sMainHandler;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.adaptation.a ZR() {
        if (this.bKa == null) {
            this.bKa = new com.baidu.swan.apps.adaptation.a();
        }
        return this.bKa;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void kt(String str) {
        d(str, null);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void d(String str, Bundle bundle) {
        d(new i.a(str, bundle));
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void d(final i.a aVar) {
        if (DEBUG) {
            Log.i("SwanImpl", "dispatchEvent: " + aVar + " mEventCallbacks:" + this.bKb.size());
        }
        if (aVar != null) {
            synchronized (this.bKb) {
                boolean z = Looper.getMainLooper() == Looper.myLooper();
                for (final com.baidu.swan.apps.as.d.b<i.a> bVar : this.bKb) {
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
            synchronized (this.bKb) {
                this.bKb.add(bVar);
            }
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void f(com.baidu.swan.apps.as.d.b<i.a> bVar) {
        if (bVar != null) {
            synchronized (this.bKb) {
                this.bKb.remove(bVar);
            }
        }
    }
}
