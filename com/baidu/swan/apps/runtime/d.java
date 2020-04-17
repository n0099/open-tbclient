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
    private static c cnL;
    private static j cnM;
    private static Handler sMainHandler;
    private com.baidu.swan.apps.adaptation.a cnO;
    public final com.baidu.swan.apps.x.b.a.c cnN = new c.a();
    private final Set<com.baidu.swan.apps.as.d.b<i.a>> cnP = new HashSet();
    public int cnQ = 0;

    public static d akK() {
        if (cnM != null) {
            return cnM;
        }
        synchronized (d.class) {
            if (cnM != null) {
                return cnM;
            } else if (SwanAppProcessInfo.current().isSwanAppProcess()) {
                cnM = new j();
                akL();
                return cnM;
            } else {
                if (cnL == null) {
                    cnL = new c();
                }
                return cnL;
            }
        }
    }

    private static void akL() {
        if (cnL != null) {
            cnL = null;
        }
    }

    public static Handler getMainHandler() {
        if (sMainHandler == null) {
            sMainHandler = new Handler(Looper.getMainLooper());
        }
        return sMainHandler;
    }

    @Override // com.baidu.swan.apps.runtime.h
    public com.baidu.swan.apps.adaptation.a akM() {
        if (this.cnO == null) {
            this.cnO = new com.baidu.swan.apps.adaptation.a();
        }
        return this.cnO;
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
            Log.i("SwanImpl", "dispatchEvent: " + aVar + " mEventCallbacks:" + this.cnP.size());
        }
        if (aVar != null) {
            synchronized (this.cnP) {
                boolean z = Looper.getMainLooper() == Looper.myLooper();
                for (final com.baidu.swan.apps.as.d.b<i.a> bVar : this.cnP) {
                    if (z && !aVar.getBoolean("event_flag_force_post", false)) {
                        bVar.E(aVar);
                    } else {
                        getMainHandler().post(new Runnable() { // from class: com.baidu.swan.apps.runtime.d.1
                            @Override // java.lang.Runnable
                            public void run() {
                                bVar.E(aVar);
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
            synchronized (this.cnP) {
                this.cnP.add(bVar);
            }
        }
    }

    @Override // com.baidu.swan.apps.runtime.h
    public void f(com.baidu.swan.apps.as.d.b<i.a> bVar) {
        if (bVar != null) {
            synchronized (this.cnP) {
                this.cnP.remove(bVar);
            }
        }
    }
}
