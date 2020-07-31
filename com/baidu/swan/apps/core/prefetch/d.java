package com.baidu.swan.apps.core.prefetch;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.a;
import com.baidu.swan.pms.model.PMSAppInfo;
/* loaded from: classes7.dex */
public final class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.core.prefetch.a cfr;
    private b cfs;

    private d() {
        this.cfr = new com.baidu.swan.apps.core.prefetch.a();
        this.cfs = new b();
    }

    public static d acB() {
        return a.cfu;
    }

    public void e(final PrefetchEvent prefetchEvent) {
        if (DEBUG) {
            Log.d("SwanAppPrefetchManager", "firePrefetchEvent abSwitch: " + com.baidu.swan.apps.core.prefetch.a.a.acD());
        }
        if (DEBUG || !f(prefetchEvent)) {
            if (DEBUG) {
                Log.d("SwanAppPrefetchManager", "firePrefetchEvent event: " + prefetchEvent);
            }
            if (TextUtils.equals("show", prefetchEvent.state)) {
                this.cfr.a(prefetchEvent, new a.b() { // from class: com.baidu.swan.apps.core.prefetch.d.1
                    @Override // com.baidu.swan.apps.core.prefetch.a.b
                    public void a(com.baidu.swan.apps.process.messaging.service.c cVar, PMSAppInfo pMSAppInfo) {
                        d.this.cfs.a(prefetchEvent, cVar, pMSAppInfo);
                    }
                });
            } else {
                this.cfs.e(prefetchEvent);
            }
        }
    }

    private boolean f(PrefetchEvent prefetchEvent) {
        if (com.baidu.swan.apps.core.prefetch.a.a.acD() == 0 || prefetchEvent == null || !prefetchEvent.isValid()) {
            return true;
        }
        return c.kh(prefetchEvent.appId);
    }

    /* loaded from: classes7.dex */
    private static class a {
        private static final d cfu = new d();
    }
}
