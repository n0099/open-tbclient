package com.baidu.swan.apps.core.prefetch;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.pms.model.PMSAppInfo;
/* loaded from: classes8.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private c cXz = c.cXA;

    public void a(@NonNull PrefetchEvent prefetchEvent, @NonNull com.baidu.swan.apps.process.messaging.service.c cVar, @Nullable PMSAppInfo pMSAppInfo) {
        a(cVar, prefetchEvent, pMSAppInfo);
        cVar.g(prefetchEvent);
        if (DEBUG) {
            Log.d("PrefetchMessenger", "onPrefetchReady event: " + prefetchEvent);
            Log.d("PrefetchMessenger", "onPrefetchReady client id: " + cVar.dvs.index);
        }
    }

    public void d(@NonNull PrefetchEvent prefetchEvent) {
        com.baidu.swan.apps.process.messaging.service.c c = a.c(prefetchEvent);
        if (c != null) {
            if ((c.aGb() && TextUtils.equals(c.mAppId, prefetchEvent.appId)) || c.aGa()) {
                a(c, prefetchEvent, (PMSAppInfo) null);
            }
        }
    }

    private void a(@NonNull com.baidu.swan.apps.process.messaging.service.c cVar, @NonNull PrefetchEvent prefetchEvent, @Nullable PMSAppInfo pMSAppInfo) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(PrefetchEvent.class.getClassLoader());
        bundle.putParcelable("swan_app_bundle_prefetch", prefetchEvent);
        if (pMSAppInfo == null) {
            pMSAppInfo = com.baidu.swan.pms.database.a.bcx().yc(prefetchEvent.appId);
        }
        if (pMSAppInfo != null) {
            bundle.putParcelable("swan_app_prefetch_pms_info", pMSAppInfo);
            if (this.cXz.a(prefetchEvent, pMSAppInfo, bundle)) {
                com.baidu.swan.apps.process.messaging.a.aFC().a(new com.baidu.swan.apps.process.messaging.c(120, bundle).a(cVar.dvs).gE(true));
            }
        }
    }
}
