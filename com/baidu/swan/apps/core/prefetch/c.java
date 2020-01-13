package com.baidu.swan.apps.core.prefetch;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.a;
/* loaded from: classes10.dex */
public final class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.core.prefetch.a bmG;
    private b bmH;

    private c() {
        this.bmG = new com.baidu.swan.apps.core.prefetch.a();
        this.bmH = new b();
    }

    public static c Nx() {
        return a.bmJ;
    }

    public void e(final PrefetchEvent prefetchEvent) {
        if (DEBUG) {
            Log.d("SwanAppPrefetchManager", "firePrefetchEvent abSwitch: " + com.baidu.swan.apps.core.prefetch.a.a.Nz());
        }
        if (com.baidu.swan.apps.core.prefetch.a.a.Nz() != 0 && prefetchEvent != null && prefetchEvent.isValid()) {
            if (DEBUG) {
                Log.d("SwanAppPrefetchManager", "firePrefetchEvent event: " + prefetchEvent);
            }
            if (TextUtils.equals("show", prefetchEvent.state)) {
                this.bmG.a(prefetchEvent, new a.b() { // from class: com.baidu.swan.apps.core.prefetch.c.1
                    @Override // com.baidu.swan.apps.core.prefetch.a.b
                    public void c(com.baidu.swan.apps.process.messaging.service.c cVar) {
                        c.this.bmH.a(prefetchEvent, cVar);
                    }
                });
            } else {
                this.bmH.e(prefetchEvent);
            }
        }
    }

    /* loaded from: classes10.dex */
    private static class a {
        private static final c bmJ = new c();
    }
}
