package com.baidu.swan.apps.extcore.cores;

import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.swan.apps.b;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a chM;

    public static a adO() {
        if (chM == null) {
            synchronized (a.class) {
                if (chM == null) {
                    chM = new a();
                }
            }
        }
        return chM;
    }

    public void a(@Nullable final com.baidu.swan.apps.aq.e.b<Exception> bVar, final int i) {
        if (DEBUG) {
            Log.i("SwanAppCoresManager", "ensureSwanCore: invoke frameType = " + i);
        }
        b(new com.baidu.swan.apps.aq.e.b<Exception>() { // from class: com.baidu.swan.apps.extcore.cores.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: p */
            public void H(Exception exc) {
                if (exc == null) {
                    if (a.DEBUG) {
                        Log.i("SwanAppCoresManager", "ensureSwanCore: excute frameType = " + i + " done by update preset ");
                    }
                    bVar.H(null);
                    return;
                }
                if (a.DEBUG) {
                    Log.i("SwanAppCoresManager", "ensureSwanCore: excute frameType = " + i + " UpdateSwanCore cause update preset failed ");
                }
                com.baidu.swan.apps.swancore.b.b(i, new com.baidu.swan.apps.aq.e.b<Exception>() { // from class: com.baidu.swan.apps.extcore.cores.a.1.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.aq.e.b
                    /* renamed from: p */
                    public void H(Exception exc2) {
                        if (a.DEBUG) {
                            Log.i("SwanAppCoresManager", "ensureSwanCore: excute frameType=" + i + " UpdateSwanCore finish with " + (exc2 == null ? "no err" : "err=" + Log.getStackTraceString(exc2)));
                        }
                        bVar.H(exc2);
                    }
                });
            }
        }, i);
    }

    public void b(@Nullable final com.baidu.swan.apps.aq.e.b<Exception> bVar, final int i) {
        com.baidu.swan.apps.swancore.c.b.ati().c(new com.baidu.swan.apps.aq.e.b<Exception>() { // from class: com.baidu.swan.apps.extcore.cores.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.aq.e.b
            /* renamed from: p */
            public void H(Exception exc) {
                if (exc != null) {
                    bVar.H(exc);
                } else {
                    com.baidu.swan.apps.extcore.b.a(i, new com.baidu.swan.apps.aq.e.b<Exception>() { // from class: com.baidu.swan.apps.extcore.cores.a.2.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.aq.e.b
                        /* renamed from: p */
                        public void H(Exception exc2) {
                            if (bVar != null) {
                                bVar.H(exc2);
                            }
                        }
                    });
                }
            }
        }, i);
    }

    public void adP() {
        com.baidu.swan.apps.swancore.c.b.ati().c(null, 0);
        com.baidu.swan.apps.swancore.c.b.ati().c(null, 1);
        com.baidu.swan.apps.extcore.b.a(0, (com.baidu.swan.apps.aq.e.b<Exception>) null);
        com.baidu.swan.apps.extcore.b.a(1, (com.baidu.swan.apps.aq.e.b<Exception>) null);
    }

    public void ah(int i, int i2) {
        if (DEBUG) {
            Log.d("SwanAppCoresManager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
        }
        com.baidu.swan.apps.swancore.b.ah(i, i2);
        com.baidu.swan.apps.extcore.b.ah(i, i2);
    }
}
