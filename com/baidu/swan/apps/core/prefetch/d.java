package com.baidu.swan.apps.core.prefetch;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.a;
/* loaded from: classes11.dex */
public final class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.core.prefetch.a cdK;
    private b cdL;

    private d() {
        this.cdK = new com.baidu.swan.apps.core.prefetch.a();
        this.cdL = new b();
    }

    public static d abz() {
        return a.cdN;
    }

    public void e(final PrefetchEvent prefetchEvent) {
        if (DEBUG) {
            Log.d("SwanAppPrefetchManager", "firePrefetchEvent abSwitch: " + com.baidu.swan.apps.core.prefetch.a.a.abB());
        }
        if (DEBUG || !f(prefetchEvent)) {
            if (DEBUG) {
                Log.d("SwanAppPrefetchManager", "firePrefetchEvent event: " + prefetchEvent);
            }
            if (TextUtils.equals("show", prefetchEvent.state)) {
                this.cdK.a(prefetchEvent, new a.b() { // from class: com.baidu.swan.apps.core.prefetch.d.1
                    @Override // com.baidu.swan.apps.core.prefetch.a.b
                    public void c(com.baidu.swan.apps.process.messaging.service.c cVar) {
                        d.this.cdL.a(prefetchEvent, cVar);
                    }
                });
            } else {
                this.cdL.e(prefetchEvent);
            }
        }
    }

    private boolean f(PrefetchEvent prefetchEvent) {
        if (com.baidu.swan.apps.core.prefetch.a.a.abB() == 0 || prefetchEvent == null || !prefetchEvent.isValid()) {
            return true;
        }
        return c.jO(prefetchEvent.appId);
    }

    /* loaded from: classes11.dex */
    private static class a {
        private static final d cdN = new d();
    }
}
