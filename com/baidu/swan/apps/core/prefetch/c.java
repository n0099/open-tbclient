package com.baidu.swan.apps.core.prefetch;

import android.os.Bundle;
import com.baidu.swan.pms.model.PMSAppInfo;
/* loaded from: classes10.dex */
public interface c {
    public static final c cIA = new c() { // from class: com.baidu.swan.apps.core.prefetch.c.1
        @Override // com.baidu.swan.apps.core.prefetch.c
        public boolean a(PrefetchEvent prefetchEvent, PMSAppInfo pMSAppInfo, Bundle bundle) {
            if (!com.baidu.swan.apps.core.prefetch.a.a.isOn()) {
                return false;
            }
            bundle.putString("swan_app_prefetch_event_name", a(prefetchEvent, pMSAppInfo) ? "prefetch" : "preload");
            return true;
        }

        private boolean a(PrefetchEvent prefetchEvent, PMSAppInfo pMSAppInfo) {
            return false;
        }
    };

    boolean a(PrefetchEvent prefetchEvent, PMSAppInfo pMSAppInfo, Bundle bundle);
}
