package com.baidu.swan.apps.core.prefetch;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.core.a.a.a;
import com.baidu.swan.apps.process.messaging.service.c;
import com.baidu.swan.apps.process.messaging.service.e;
import com.baidu.swan.games.view.webview.GameWebViewJavascriptInterface;
import com.baidu.swan.pms.model.PMSAppInfo;
/* loaded from: classes8.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static c cXr = new c();
    private static d cXs = new d();

    /* renamed from: com.baidu.swan.apps.core.prefetch.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0418a {
        void a(com.baidu.swan.apps.process.messaging.service.c cVar);
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(@NonNull com.baidu.swan.apps.process.messaging.service.c cVar, @Nullable PMSAppInfo pMSAppInfo);
    }

    static com.baidu.swan.apps.process.messaging.service.c a(@NonNull PrefetchEvent prefetchEvent) {
        return e.aGq().a((e) prefetchEvent.appId, (e.a<e>) cXr);
    }

    static com.baidu.swan.apps.process.messaging.service.c b(@NonNull PrefetchEvent prefetchEvent) {
        return e.aGq().a((e) prefetchEvent.appId, (e.a<e>) cXs);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.baidu.swan.apps.process.messaging.service.c c(@NonNull PrefetchEvent prefetchEvent) {
        com.baidu.swan.apps.process.messaging.service.c b2 = b(prefetchEvent);
        if (b2 == null) {
            com.baidu.swan.apps.process.messaging.service.c a2 = a(prefetchEvent);
            return (a2 == null || !a2.aGa()) ? e.aGq().aGt() : a2;
        }
        return b2;
    }

    public void a(@NonNull final PrefetchEvent prefetchEvent, @NonNull final b bVar) {
        a(prefetchEvent, new InterfaceC0418a() { // from class: com.baidu.swan.apps.core.prefetch.a.1
            @Override // com.baidu.swan.apps.core.prefetch.a.InterfaceC0418a
            public void a(com.baidu.swan.apps.process.messaging.service.c cVar) {
                if (cVar != null) {
                    if (!cVar.aGb()) {
                        a.this.a(cVar, prefetchEvent, bVar);
                    } else {
                        bVar.a(cVar, null);
                    }
                }
            }
        });
    }

    @Nullable
    private void a(@NonNull PrefetchEvent prefetchEvent, @NonNull final InterfaceC0418a interfaceC0418a) {
        com.baidu.swan.apps.process.messaging.service.c b2 = b(prefetchEvent);
        if (b2 != null) {
            interfaceC0418a.a(b2);
            return;
        }
        com.baidu.swan.apps.process.messaging.service.c a2 = a(prefetchEvent);
        if (a2 != null && a2.aGa()) {
            interfaceC0418a.a(a2);
            return;
        }
        com.baidu.swan.apps.process.messaging.service.c aGt = e.aGq().aGt();
        if (aGt.aGb()) {
            if (DEBUG) {
                Log.e("PrefetchEnv", "prepareEnv isSwanAppLoaded.");
            }
            interfaceC0418a.a(null);
        } else if (aGt.aGa()) {
            if (DEBUG) {
                Log.d("PrefetchEnv", "prepareEnv isPreloaded.");
            }
            interfaceC0418a.a(aGt);
        } else {
            aGt.a(new c.a() { // from class: com.baidu.swan.apps.core.prefetch.a.2
                @Override // com.baidu.swan.apps.process.messaging.service.c.a
                public void b(com.baidu.swan.apps.process.messaging.service.c cVar) {
                    interfaceC0418a.a(cVar);
                }
            });
            Bundle bundle = new Bundle();
            bundle.putString("bundle_key_preload_preload_scene", "8");
            com.baidu.swan.apps.process.messaging.service.b.a(com.baidu.swan.apps.t.a.awZ(), aGt, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull com.baidu.swan.apps.process.messaging.service.c cVar, @NonNull PrefetchEvent prefetchEvent, @NonNull b bVar) {
        PMSAppInfo yc = com.baidu.swan.pms.database.a.bcx().yc(prefetchEvent.appId);
        boolean h = h(yc);
        if (h && !yc.bcH()) {
            bVar.a(cVar, yc);
        } else {
            a(h, cVar, prefetchEvent, bVar);
        }
    }

    private boolean h(PMSAppInfo pMSAppInfo) {
        return pMSAppInfo != null && com.baidu.swan.apps.u.f.a.m(pMSAppInfo);
    }

    private void a(boolean z, @NonNull final com.baidu.swan.apps.process.messaging.service.c cVar, @NonNull PrefetchEvent prefetchEvent, @NonNull final b bVar) {
        com.baidu.swan.apps.core.a.a.a.a(z, prefetchEvent.appId, 200, new a.InterfaceC0406a() { // from class: com.baidu.swan.apps.core.prefetch.a.3
            @Override // com.baidu.swan.apps.core.a.a.a.InterfaceC0406a
            public void anN() {
                if (a.DEBUG) {
                    Log.d("PrefetchEnv", "prepareBundle swanAppIdInvalid");
                }
            }

            @Override // com.baidu.swan.apps.core.a.a.a.InterfaceC0406a
            public void anO() {
                if (a.DEBUG) {
                    Log.d("PrefetchEnv", "prepareBundle success isPreloaded: " + cVar.aGa());
                }
                if (cVar.aGa()) {
                    bVar.a(cVar, null);
                }
            }

            @Override // com.baidu.swan.apps.core.a.a.a.InterfaceC0406a
            public void gE(int i) {
                if (a.DEBUG) {
                    Log.d("PrefetchEnv", "prepareBundle failed: " + i);
                }
            }
        }, prefetchEvent.scene, GameWebViewJavascriptInterface.JAVASCRIPT_INTERFACE_NAME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class c implements e.a<String> {
        private c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.process.messaging.service.e.a
        public boolean a(String str, com.baidu.swan.apps.process.messaging.service.c cVar) {
            if (cVar.dvu == null) {
                return false;
            }
            return TextUtils.equals(str, cVar.dvu.appId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class d implements e.a<String> {
        private d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.process.messaging.service.e.a
        public boolean a(String str, com.baidu.swan.apps.process.messaging.service.c cVar) {
            return cVar.aGb() && TextUtils.equals(str, cVar.mAppId);
        }
    }
}
