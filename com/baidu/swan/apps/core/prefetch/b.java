package com.baidu.swan.apps.core.prefetch;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.pms.model.PMSAppInfo;
/* loaded from: classes7.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public void a(@NonNull PrefetchEvent prefetchEvent, @NonNull com.baidu.swan.apps.process.messaging.service.c cVar, @Nullable PMSAppInfo pMSAppInfo) {
        a(cVar, prefetchEvent, pMSAppInfo);
        cVar.h(prefetchEvent);
        if (DEBUG) {
            Log.d("PrefetchMessenger", "onPrefetchReady event: " + prefetchEvent);
            Log.d("PrefetchMessenger", "onPrefetchReady client id: " + cVar.cBq.index);
        }
    }

    public void e(@NonNull PrefetchEvent prefetchEvent) {
        com.baidu.swan.apps.process.messaging.service.c c = a.c(prefetchEvent);
        if (c != null) {
            if ((c.apU() && TextUtils.equals(c.mAppId, prefetchEvent.appId)) || c.apT()) {
                a(c, prefetchEvent, (PMSAppInfo) null);
            }
        }
    }

    private void a(@NonNull com.baidu.swan.apps.process.messaging.service.c cVar, @NonNull PrefetchEvent prefetchEvent, @Nullable PMSAppInfo pMSAppInfo) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(PrefetchEvent.class.getClassLoader());
        bundle.putParcelable("swan_app_bundle_prefetch", prefetchEvent);
        if (pMSAppInfo != null) {
            bundle.putParcelable("swan_app_prefetch_pms_info", pMSAppInfo);
        } else {
            bundle.putParcelable("swan_app_prefetch_pms_info", com.baidu.swan.pms.database.a.aKS().uq(prefetchEvent.appId));
        }
        com.baidu.swan.apps.process.messaging.a.apw().a(new com.baidu.swan.apps.process.messaging.c(120, bundle).a(cVar.cBq).eV(true));
    }
}
