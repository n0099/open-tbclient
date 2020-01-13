package com.baidu.swan.apps.core.prefetch;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
/* loaded from: classes10.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public void a(@NonNull PrefetchEvent prefetchEvent, @NonNull com.baidu.swan.apps.process.messaging.service.c cVar) {
        a(cVar, prefetchEvent);
        cVar.g(prefetchEvent);
        if (DEBUG) {
            Log.d("PrefetchMessenger", "onPrefetchReady event: " + prefetchEvent);
            Log.d("PrefetchMessenger", "onPrefetchReady client id: " + cVar.bFt.index);
        }
    }

    public void e(@NonNull PrefetchEvent prefetchEvent) {
        com.baidu.swan.apps.process.messaging.service.c c = a.c(prefetchEvent);
        if (c != null) {
            if ((c.YT() && TextUtils.equals(c.mAppId, prefetchEvent.appId)) || c.YS()) {
                a(c, prefetchEvent);
            }
        }
    }

    private void a(@NonNull com.baidu.swan.apps.process.messaging.service.c cVar, @NonNull PrefetchEvent prefetchEvent) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(PrefetchEvent.class.getClassLoader());
        bundle.putParcelable("swan_app_bundle_prefetch", prefetchEvent);
        com.baidu.swan.apps.process.messaging.a.Yv().a(new com.baidu.swan.apps.process.messaging.c(120, bundle).a(cVar.bFt).dk(true));
    }
}
