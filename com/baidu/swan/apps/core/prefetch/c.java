package com.baidu.swan.apps.core.prefetch;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.a;
/* loaded from: classes9.dex */
public final class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.core.prefetch.a blQ;
    private b blR;

    private c() {
        this.blQ = new com.baidu.swan.apps.core.prefetch.a();
        this.blR = new b();
    }

    public static c Nb() {
        return a.blT;
    }

    public void e(final PrefetchEvent prefetchEvent) {
        if (DEBUG) {
            Log.d("SwanAppPrefetchManager", "firePrefetchEvent abSwitch: " + com.baidu.swan.apps.core.prefetch.a.a.Nd());
        }
        if (com.baidu.swan.apps.core.prefetch.a.a.Nd() != 0 && prefetchEvent != null && prefetchEvent.isValid()) {
            if (DEBUG) {
                Log.d("SwanAppPrefetchManager", "firePrefetchEvent event: " + prefetchEvent);
            }
            if (TextUtils.equals("show", prefetchEvent.state)) {
                this.blQ.a(prefetchEvent, new a.b() { // from class: com.baidu.swan.apps.core.prefetch.c.1
                    @Override // com.baidu.swan.apps.core.prefetch.a.b
                    public void c(com.baidu.swan.apps.process.messaging.service.c cVar) {
                        c.this.blR.a(prefetchEvent, cVar);
                    }
                });
            } else {
                this.blR.e(prefetchEvent);
            }
        }
    }

    /* loaded from: classes9.dex */
    private static class a {
        private static final c blT = new c();
    }
}
