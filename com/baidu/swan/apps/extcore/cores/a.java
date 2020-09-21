package com.baidu.swan.apps.extcore.cores;

import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.console.c;
/* loaded from: classes3.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static volatile a ctf;

    public static a amV() {
        if (ctf == null) {
            synchronized (a.class) {
                if (ctf == null) {
                    ctf = new a();
                }
            }
        }
        return ctf;
    }

    public void a(@Nullable final com.baidu.swan.apps.ap.e.b<Exception> bVar, final int i) {
        c.bb("SwanAppCoresManager", "ensureSwanCore: invoke frameType = " + i);
        b(new com.baidu.swan.apps.ap.e.b<Exception>() { // from class: com.baidu.swan.apps.extcore.cores.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: p */
            public void J(Exception exc) {
                if (exc == null) {
                    c.bb("SwanAppCoresManager", "ensureSwanCore: done by update preset ");
                    if (bVar != null) {
                        bVar.J(null);
                        return;
                    }
                    return;
                }
                c.bb("SwanAppCoresManager", "ensureSwanCore: update preset failed ");
                com.baidu.swan.apps.swancore.b.b(i, new com.baidu.swan.apps.ap.e.b<Exception>() { // from class: com.baidu.swan.apps.extcore.cores.a.1.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ap.e.b
                    /* renamed from: p */
                    public void J(Exception exc2) {
                        c.f("SwanAppCoresManager", "ensureSwanCore: update swan-js finish. ", exc2);
                        if (bVar != null) {
                            bVar.J(exc2);
                        }
                    }
                });
            }
        }, i);
    }

    private void b(@Nullable final com.baidu.swan.apps.ap.e.b<Exception> bVar, final int i) {
        com.baidu.swan.apps.swancore.c.b.aEc().c(new com.baidu.swan.apps.ap.e.b<Exception>() { // from class: com.baidu.swan.apps.extcore.cores.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ap.e.b
            /* renamed from: p */
            public void J(Exception exc) {
                if (exc != null) {
                    if (bVar != null) {
                        bVar.J(exc);
                        return;
                    }
                    return;
                }
                com.baidu.swan.apps.extcore.b.a(i, new com.baidu.swan.apps.ap.e.b<Exception>() { // from class: com.baidu.swan.apps.extcore.cores.a.2.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ap.e.b
                    /* renamed from: p */
                    public void J(Exception exc2) {
                        if (bVar != null) {
                            bVar.J(exc2);
                        }
                    }
                });
            }
        }, i);
    }

    public void amW() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.extcore.cores.a.3
            @Override // java.lang.Runnable
            public void run() {
                a.this.amX();
            }
        }, "tryUpdateAllPresetCoresAsync", 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amX() {
        com.baidu.swan.apps.swancore.c.b.aEc().c(null, 0);
        com.baidu.swan.apps.swancore.c.b.aEc().c(null, 1);
        com.baidu.swan.apps.extcore.b.a(0, (com.baidu.swan.apps.ap.e.b<Exception>) null);
        com.baidu.swan.apps.extcore.b.a(1, (com.baidu.swan.apps.ap.e.b<Exception>) null);
    }

    public void am(int i, int i2) {
        if (DEBUG) {
            Log.d("SwanAppCoresManager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
        }
        com.baidu.swan.apps.swancore.b.am(i, i2);
        com.baidu.swan.apps.extcore.b.am(i, i2);
    }
}
