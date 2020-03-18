package com.baidu.swan.apps.core.prefetch;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.a;
/* loaded from: classes11.dex */
public final class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.core.prefetch.a brd;
    private b bre;

    private c() {
        this.brd = new com.baidu.swan.apps.core.prefetch.a();
        this.bre = new b();
    }

    public static c PQ() {
        return a.brg;
    }

    public void e(final PrefetchEvent prefetchEvent) {
        if (DEBUG) {
            Log.d("SwanAppPrefetchManager", "firePrefetchEvent abSwitch: " + com.baidu.swan.apps.core.prefetch.a.a.PS());
        }
        if (com.baidu.swan.apps.core.prefetch.a.a.PS() != 0 && prefetchEvent != null && prefetchEvent.isValid()) {
            if (DEBUG) {
                Log.d("SwanAppPrefetchManager", "firePrefetchEvent event: " + prefetchEvent);
            }
            if (TextUtils.equals("show", prefetchEvent.state)) {
                this.brd.a(prefetchEvent, new a.b() { // from class: com.baidu.swan.apps.core.prefetch.c.1
                    @Override // com.baidu.swan.apps.core.prefetch.a.b
                    public void c(com.baidu.swan.apps.process.messaging.service.c cVar) {
                        c.this.bre.a(prefetchEvent, cVar);
                    }
                });
            } else {
                this.bre.e(prefetchEvent);
            }
        }
    }

    /* loaded from: classes11.dex */
    private static class a {
        private static final c brg = new c();
    }
}
