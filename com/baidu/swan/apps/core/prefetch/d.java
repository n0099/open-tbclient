package com.baidu.swan.apps.core.prefetch;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.a;
import com.baidu.swan.pms.model.PMSAppInfo;
/* loaded from: classes9.dex */
public final class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.core.prefetch.a cWb;
    private b cWc;

    private d() {
        this.cWb = new com.baidu.swan.apps.core.prefetch.a();
        this.cWc = new b();
    }

    public static d ark() {
        return a.cWe;
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
                this.cWb.a(prefetchEvent, new a.b() { // from class: com.baidu.swan.apps.core.prefetch.d.1
                    @Override // com.baidu.swan.apps.core.prefetch.a.b
                    public void a(com.baidu.swan.apps.process.messaging.service.c cVar, PMSAppInfo pMSAppInfo) {
                        d.this.cWc.a(prefetchEvent, cVar, pMSAppInfo);
                    }
                });
            } else {
                this.cWc.d(prefetchEvent);
            }
        }
    }

    private boolean e(PrefetchEvent prefetchEvent) {
        return (com.baidu.swan.apps.core.prefetch.a.a.isOn() && prefetchEvent != null && prefetchEvent.isValid()) ? false : true;
    }

    /* loaded from: classes9.dex */
    private static class a {
        private static final d cWe = new d();
    }
}
