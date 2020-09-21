package com.baidu.swan.apps.core.prefetch;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.a;
import com.baidu.swan.pms.model.PMSAppInfo;
/* loaded from: classes3.dex */
public final class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.apps.core.prefetch.a cnP;
    private b cnQ;

    private d() {
        this.cnP = new com.baidu.swan.apps.core.prefetch.a();
        this.cnQ = new b();
    }

    public static d ajJ() {
        return a.cnS;
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
                this.cnP.a(prefetchEvent, new a.b() { // from class: com.baidu.swan.apps.core.prefetch.d.1
                    @Override // com.baidu.swan.apps.core.prefetch.a.b
                    public void a(com.baidu.swan.apps.process.messaging.service.c cVar, PMSAppInfo pMSAppInfo) {
                        d.this.cnQ.a(prefetchEvent, cVar, pMSAppInfo);
                    }
                });
            } else {
                this.cnQ.d(prefetchEvent);
            }
        }
    }

    private boolean e(PrefetchEvent prefetchEvent) {
        return (com.baidu.swan.apps.core.prefetch.a.a.isOn() && prefetchEvent != null && prefetchEvent.isValid()) ? false : true;
    }

    /* loaded from: classes3.dex */
    private static class a {
        private static final d cnS = new d();
    }
}
