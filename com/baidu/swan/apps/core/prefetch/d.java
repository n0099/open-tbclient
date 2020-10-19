package com.baidu.swan.apps.core.prefetch;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.a;
import com.baidu.swan.pms.model.PMSAppInfo;
/* loaded from: classes10.dex */
public final class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.core.prefetch.a cAf;
    private b cAg;

    private d() {
        this.cAf = new com.baidu.swan.apps.core.prefetch.a();
        this.cAg = new b();
    }

    public static d amu() {
        return a.cAi;
    }

    public void d(final PrefetchEvent prefetchEvent) {
        if (DEBUG) {
            Log.d("SwanAppPrefetchManager", "fire preloadEvent abSwitch: " + com.baidu.swan.apps.core.prefetch.a.a.isOn());
        }
        if (!e(prefetchEvent)) {
            if (DEBUG) {
                Log.d("SwanAppPrefetchManager", "firePrefetchEvent event: " + prefetchEvent);
            }
            if (TextUtils.equals("show", prefetchEvent.state)) {
                this.cAf.a(prefetchEvent, new a.b() { // from class: com.baidu.swan.apps.core.prefetch.d.1
                    @Override // com.baidu.swan.apps.core.prefetch.a.b
                    public void a(com.baidu.swan.apps.process.messaging.service.c cVar, PMSAppInfo pMSAppInfo) {
                        d.this.cAg.a(prefetchEvent, cVar, pMSAppInfo);
                    }
                });
            } else {
                this.cAg.d(prefetchEvent);
            }
        }
    }

    private boolean e(PrefetchEvent prefetchEvent) {
        return (com.baidu.swan.apps.core.prefetch.a.a.isOn() && prefetchEvent != null && prefetchEvent.isValid()) ? false : true;
    }

    /* loaded from: classes10.dex */
    private static class a {
        private static final d cAi = new d();
    }
}
