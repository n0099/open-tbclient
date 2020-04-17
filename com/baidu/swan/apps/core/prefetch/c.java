package com.baidu.swan.apps.core.prefetch;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.a;
/* loaded from: classes11.dex */
public final class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.core.prefetch.a bPk;
    private b bPl;

    private c() {
        this.bPk = new com.baidu.swan.apps.core.prefetch.a();
        this.bPl = new b();
    }

    public static c XF() {
        return a.bPn;
    }

    public void e(final PrefetchEvent prefetchEvent) {
        if (DEBUG) {
            Log.d("SwanAppPrefetchManager", "firePrefetchEvent abSwitch: " + com.baidu.swan.apps.core.prefetch.a.a.XH());
        }
        if (com.baidu.swan.apps.core.prefetch.a.a.XH() != 0 && prefetchEvent != null && prefetchEvent.isValid()) {
            if (DEBUG) {
                Log.d("SwanAppPrefetchManager", "firePrefetchEvent event: " + prefetchEvent);
            }
            if (TextUtils.equals("show", prefetchEvent.state)) {
                this.bPk.a(prefetchEvent, new a.b() { // from class: com.baidu.swan.apps.core.prefetch.c.1
                    @Override // com.baidu.swan.apps.core.prefetch.a.b
                    public void c(com.baidu.swan.apps.process.messaging.service.c cVar) {
                        c.this.bPl.a(prefetchEvent, cVar);
                    }
                });
            } else {
                this.bPl.e(prefetchEvent);
            }
        }
    }

    /* loaded from: classes11.dex */
    private static class a {
        private static final c bPn = new c();
    }
}
