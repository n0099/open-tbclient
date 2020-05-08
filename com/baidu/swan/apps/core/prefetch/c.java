package com.baidu.swan.apps.core.prefetch;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.a;
/* loaded from: classes11.dex */
public final class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.core.prefetch.a bPp;
    private b bPq;

    private c() {
        this.bPp = new com.baidu.swan.apps.core.prefetch.a();
        this.bPq = new b();
    }

    public static c XE() {
        return a.bPs;
    }

    public void e(final PrefetchEvent prefetchEvent) {
        if (DEBUG) {
            Log.d("SwanAppPrefetchManager", "firePrefetchEvent abSwitch: " + com.baidu.swan.apps.core.prefetch.a.a.XG());
        }
        if (com.baidu.swan.apps.core.prefetch.a.a.XG() != 0 && prefetchEvent != null && prefetchEvent.isValid()) {
            if (DEBUG) {
                Log.d("SwanAppPrefetchManager", "firePrefetchEvent event: " + prefetchEvent);
            }
            if (TextUtils.equals("show", prefetchEvent.state)) {
                this.bPp.a(prefetchEvent, new a.b() { // from class: com.baidu.swan.apps.core.prefetch.c.1
                    @Override // com.baidu.swan.apps.core.prefetch.a.b
                    public void c(com.baidu.swan.apps.process.messaging.service.c cVar) {
                        c.this.bPq.a(prefetchEvent, cVar);
                    }
                });
            } else {
                this.bPq.e(prefetchEvent);
            }
        }
    }

    /* loaded from: classes11.dex */
    private static class a {
        private static final c bPs = new c();
    }
}
