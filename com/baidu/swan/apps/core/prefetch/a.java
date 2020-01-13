package com.baidu.swan.apps.core.prefetch;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.a.a.a;
import com.baidu.swan.apps.process.messaging.service.c;
import com.baidu.swan.apps.process.messaging.service.e;
import com.baidu.swan.pms.model.PMSAppInfo;
/* loaded from: classes10.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static c bmy = new c();
    private static d bmz = new d();

    /* renamed from: com.baidu.swan.apps.core.prefetch.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0243a {
        void a(com.baidu.swan.apps.process.messaging.service.c cVar);
    }

    /* loaded from: classes10.dex */
    public interface b {
        void c(com.baidu.swan.apps.process.messaging.service.c cVar);
    }

    static com.baidu.swan.apps.process.messaging.service.c a(@NonNull PrefetchEvent prefetchEvent) {
        return e.Ze().a((e) prefetchEvent.appId, (e.a<e>) bmy);
    }

    static com.baidu.swan.apps.process.messaging.service.c b(@NonNull PrefetchEvent prefetchEvent) {
        return e.Ze().a((e) prefetchEvent.appId, (e.a<e>) bmz);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.baidu.swan.apps.process.messaging.service.c c(@NonNull PrefetchEvent prefetchEvent) {
        com.baidu.swan.apps.process.messaging.service.c b2 = b(prefetchEvent);
        if (b2 == null) {
            com.baidu.swan.apps.process.messaging.service.c a = a(prefetchEvent);
            return (a == null || !a.YS()) ? e.Ze().Zh() : a;
        }
        return b2;
    }

    public void a(@NonNull final PrefetchEvent prefetchEvent, @NonNull final b bVar) {
        a(prefetchEvent, new InterfaceC0243a() { // from class: com.baidu.swan.apps.core.prefetch.a.1
            @Override // com.baidu.swan.apps.core.prefetch.a.InterfaceC0243a
            public void a(com.baidu.swan.apps.process.messaging.service.c cVar) {
                if (cVar != null) {
                    if (!cVar.YT()) {
                        a.this.a(cVar, prefetchEvent, bVar);
                    } else {
                        bVar.c(cVar);
                    }
                }
            }
        });
    }

    @Nullable
    private void a(@NonNull final PrefetchEvent prefetchEvent, @NonNull final InterfaceC0243a interfaceC0243a) {
        com.baidu.swan.apps.process.messaging.service.c b2 = b(prefetchEvent);
        if (b2 != null) {
            interfaceC0243a.a(b2);
            return;
        }
        com.baidu.swan.apps.process.messaging.service.c a = a(prefetchEvent);
        if (a != null && a.YS()) {
            interfaceC0243a.a(a);
            return;
        }
        com.baidu.swan.apps.process.messaging.service.c Zh = e.Ze().Zh();
        if (Zh.YT()) {
            if (DEBUG) {
                Log.e("PrefetchEnv", "prepareEnv isSwanAppLoaded.");
            }
            interfaceC0243a.a(null);
        } else if (Zh.YS()) {
            if (DEBUG) {
                Log.d("PrefetchEnv", "prepareEnv isPreloaded.");
            }
            a(prefetchEvent, Zh, interfaceC0243a);
        } else {
            Zh.a(new c.a() { // from class: com.baidu.swan.apps.core.prefetch.a.2
                @Override // com.baidu.swan.apps.process.messaging.service.c.a
                public void b(com.baidu.swan.apps.process.messaging.service.c cVar) {
                    a.this.a(prefetchEvent, cVar, interfaceC0243a);
                }
            });
            Bundle bundle = new Bundle();
            bundle.putString("bundle_key_preload_preload_scene", "8");
            com.baidu.swan.apps.process.messaging.service.b.a(com.baidu.swan.apps.w.a.RG(), Zh, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull PrefetchEvent prefetchEvent, @NonNull com.baidu.swan.apps.process.messaging.service.c cVar, @NonNull InterfaceC0243a interfaceC0243a) {
        switch (com.baidu.swan.apps.core.prefetch.a.a.Nz()) {
            case 1:
                if (cVar.bFv == null || TextUtils.equals(cVar.bFv.appId, prefetchEvent.appId)) {
                    interfaceC0243a.a(cVar);
                    return;
                }
                return;
            case 2:
                interfaceC0243a.a(cVar);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull com.baidu.swan.apps.process.messaging.service.c cVar, @NonNull PrefetchEvent prefetchEvent, @NonNull b bVar) {
        PMSAppInfo pZ = com.baidu.swan.pms.database.a.arf().pZ(prefetchEvent.appId);
        if (pZ != null && !pZ.agK()) {
            bVar.c(cVar);
        } else {
            b(cVar, prefetchEvent, bVar);
        }
    }

    private void b(@NonNull final com.baidu.swan.apps.process.messaging.service.c cVar, @NonNull PrefetchEvent prefetchEvent, @NonNull final b bVar) {
        com.baidu.swan.apps.core.a.a.a.a(prefetchEvent.appId, 200, new a.InterfaceC0233a() { // from class: com.baidu.swan.apps.core.prefetch.a.3
            @Override // com.baidu.swan.apps.core.a.a.a.InterfaceC0233a
            public void KM() {
                if (a.DEBUG) {
                    Log.d("PrefetchEnv", "prepareBundle swanAppIdInvalid");
                }
            }

            @Override // com.baidu.swan.apps.core.a.a.a.InterfaceC0233a
            public void KN() {
                if (a.DEBUG) {
                    Log.d("PrefetchEnv", "prepareBundle success isPreloaded: " + cVar.YS());
                }
                if (cVar.YS()) {
                    bVar.c(cVar);
                }
            }

            @Override // com.baidu.swan.apps.core.a.a.a.InterfaceC0233a
            public void ea(int i) {
                if (a.DEBUG) {
                    Log.d("PrefetchEnv", "prepareBundle failed: " + i);
                }
            }
        }, prefetchEvent.scene, "swan");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class c implements e.a<String> {
        private c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.process.messaging.service.e.a
        public boolean a(String str, com.baidu.swan.apps.process.messaging.service.c cVar) {
            if (cVar.bFv == null) {
                return false;
            }
            return TextUtils.equals(str, cVar.bFv.appId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class d implements e.a<String> {
        private d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.process.messaging.service.e.a
        public boolean a(String str, com.baidu.swan.apps.process.messaging.service.c cVar) {
            return cVar.YT() && TextUtils.equals(str, cVar.mAppId);
        }
    }
}
