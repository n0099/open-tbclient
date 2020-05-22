package com.baidu.swan.apps.core.prefetch;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.a;
/* loaded from: classes11.dex */
public final class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.core.prefetch.a bYU;
    private b bYV;

    private d() {
        this.bYU = new com.baidu.swan.apps.core.prefetch.a();
        this.bYV = new b();
    }

    public static d aat() {
        return a.bYX;
    }

    public void e(final PrefetchEvent prefetchEvent) {
        if (DEBUG) {
            Log.d("SwanAppPrefetchManager", "firePrefetchEvent abSwitch: " + com.baidu.swan.apps.core.prefetch.a.a.aav());
        }
        if (DEBUG || !f(prefetchEvent)) {
            if (DEBUG) {
                Log.d("SwanAppPrefetchManager", "firePrefetchEvent event: " + prefetchEvent);
            }
            if (TextUtils.equals("show", prefetchEvent.state)) {
                this.bYU.a(prefetchEvent, new a.b() { // from class: com.baidu.swan.apps.core.prefetch.d.1
                    @Override // com.baidu.swan.apps.core.prefetch.a.b
                    public void c(com.baidu.swan.apps.process.messaging.service.c cVar) {
                        d.this.bYV.a(prefetchEvent, cVar);
                    }
                });
            } else {
                this.bYV.e(prefetchEvent);
            }
        }
    }

    private boolean f(PrefetchEvent prefetchEvent) {
        if (com.baidu.swan.apps.core.prefetch.a.a.aav() == 0 || prefetchEvent == null || !prefetchEvent.isValid()) {
            return true;
        }
        return c.jG(prefetchEvent.appId);
    }

    /* loaded from: classes11.dex */
    private static class a {
        private static final d bYX = new d();
    }
}
