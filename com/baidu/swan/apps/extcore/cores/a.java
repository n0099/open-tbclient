package com.baidu.swan.apps.extcore.cores;

import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.console.c;
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a ddK;

    public static a axV() {
        if (ddK == null) {
            synchronized (a.class) {
                if (ddK == null) {
                    ddK = new a();
                }
            }
        }
        return ddK;
    }

    public void a(@Nullable final com.baidu.swan.apps.ao.e.b<Exception> bVar, final int i) {
        c.bs("SwanAppCoresManager", "ensureSwanCore: invoke frameType = " + i);
        b(new com.baidu.swan.apps.ao.e.b<Exception>() { // from class: com.baidu.swan.apps.extcore.cores.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: q */
            public void L(Exception exc) {
                if (exc == null) {
                    c.bs("SwanAppCoresManager", "ensureSwanCore: done by update preset ");
                    if (bVar != null) {
                        bVar.L(null);
                        return;
                    }
                    return;
                }
                c.bs("SwanAppCoresManager", "ensureSwanCore: update preset failed ");
                com.baidu.swan.apps.swancore.b.b(i, new com.baidu.swan.apps.ao.e.b<Exception>() { // from class: com.baidu.swan.apps.extcore.cores.a.1.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ao.e.b
                    /* renamed from: q */
                    public void L(Exception exc2) {
                        c.g("SwanAppCoresManager", "ensureSwanCore: update swan-js finish. ", exc2);
                        if (bVar != null) {
                            bVar.L(exc2);
                        }
                    }
                });
            }
        }, i);
    }

    private void b(@Nullable final com.baidu.swan.apps.ao.e.b<Exception> bVar, final int i) {
        com.baidu.swan.apps.swancore.c.b.aPV().c(new com.baidu.swan.apps.ao.e.b<Exception>() { // from class: com.baidu.swan.apps.extcore.cores.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: q */
            public void L(Exception exc) {
                if (exc != null) {
                    if (bVar != null) {
                        bVar.L(exc);
                        return;
                    }
                    return;
                }
                com.baidu.swan.apps.extcore.b.a(i, new com.baidu.swan.apps.ao.e.b<Exception>() { // from class: com.baidu.swan.apps.extcore.cores.a.2.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ao.e.b
                    /* renamed from: q */
                    public void L(Exception exc2) {
                        if (bVar != null) {
                            bVar.L(exc2);
                        }
                    }
                });
            }
        }, i);
    }

    public void axW() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.extcore.cores.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.axX();
            }
        }, "tryUpdateAllPresetCoresAsync", 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axX() {
        com.baidu.swan.apps.swancore.c.b.aPV().c(null, 0);
        com.baidu.swan.apps.swancore.c.b.aPV().c(null, 1);
        com.baidu.swan.apps.extcore.b.a(0, (com.baidu.swan.apps.ao.e.b<Exception>) null);
        com.baidu.swan.apps.extcore.b.a(1, (com.baidu.swan.apps.ao.e.b<Exception>) null);
    }

    public void aj(int i, int i2) {
        if (DEBUG) {
            Log.d("SwanAppCoresManager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
        }
        com.baidu.swan.apps.swancore.b.aj(i, i2);
        com.baidu.swan.apps.extcore.b.aj(i, i2);
    }
}
