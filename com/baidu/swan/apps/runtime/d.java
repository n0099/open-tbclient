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
    private static c cnR;
    private static j cnS;
    private static Handler sMainHandler;
    private com.baidu.swan.apps.adaptation.a cnU;
    public final com.baidu.swan.apps.x.b.a.c cnT = new c.a();
    private final Set<com.baidu.swan.apps.as.d.b<i.a>> cnV = new HashSet();
    public int cnW = 0;

    public static d akJ() {
        if (cnS != null) {
            return cnS;
        }
        synchronized (d.class) {
            if (cnS != null) {
                return cnS;
            } else if (SwanAppProcessInfo.current().isSwanAppProcess()) {
                cnS = new j();
                akK();
                return cnS;
            } else {
                if (cnR == null) {
                    cnR = new c();
                }
                return cnR;
            }
        }
    }

    private static void akK() {
        if (cnR != null) {
            cnR = null;
        }
    }

    public static Handler getMainHandler() {
        if (sMainHandler == null) {
            sMainHandler = new Handler(Looper.getMainLooper());
        }
        return sMainHandler;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.adaptation.a akL() {
        if (this.cnU == null) {
            this.cnU = new com.baidu.swan.apps.adaptation.a();
        }
        return this.cnU;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void lX(String str) {
        d(str, null);
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void d(String str, Bundle bundle) {
        d(new i.a(str, bundle));
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void d(final i.a aVar) {
        if (DEBUG) {
            Log.i("SwanImpl", "dispatchEvent: " + aVar + " mEventCallbacks:" + this.cnV.size());
        }
        if (aVar != null) {
            synchronized (this.cnV) {
                boolean z = Looper.getMainLooper() == Looper.myLooper();
                for (final com.baidu.swan.apps.as.d.b<i.a> bVar : this.cnV) {
                    if (z && !aVar.getBoolean("event_flag_force_post", false)) {
                        bVar.F(aVar);
                    } else {
                        getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.runtime.d.1
                            @Override // java.lang.Runnable
                            public void run() {
                                bVar.F(aVar);
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
            synchronized (this.cnV) {
                this.cnV.add(bVar);
            }
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void f(com.baidu.swan.apps.as.d.b<i.a> bVar) {
        if (bVar != null) {
            synchronized (this.cnV) {
                this.cnV.remove(bVar);
            }
        }
    }
}
