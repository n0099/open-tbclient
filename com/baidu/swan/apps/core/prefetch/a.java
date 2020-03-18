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
/* loaded from: classes11.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static c bqV = new c();
    private static d bqW = new d();

    /* renamed from: com.baidu.swan.apps.core.prefetch.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0253a {
        void a(com.baidu.swan.apps.process.messaging.service.c cVar);
    }

    /* loaded from: classes11.dex */
    public interface b {
        void c(com.baidu.swan.apps.process.messaging.service.c cVar);
    }

    static com.baidu.swan.apps.process.messaging.service.c a(@NonNull PrefetchEvent prefetchEvent) {
        return e.abx().a((e) prefetchEvent.appId, (e.a<e>) bqV);
    }

    static com.baidu.swan.apps.process.messaging.service.c b(@NonNull PrefetchEvent prefetchEvent) {
        return e.abx().a((e) prefetchEvent.appId, (e.a<e>) bqW);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.baidu.swan.apps.process.messaging.service.c c(@NonNull PrefetchEvent prefetchEvent) {
        com.baidu.swan.apps.process.messaging.service.c b2 = b(prefetchEvent);
        if (b2 == null) {
            com.baidu.swan.apps.process.messaging.service.c a = a(prefetchEvent);
            return (a == null || !a.abl()) ? e.abx().abA() : a;
        }
        return b2;
    }

    public void a(@NonNull final PrefetchEvent prefetchEvent, @NonNull final b bVar) {
        a(prefetchEvent, new InterfaceC0253a() { // from class: com.baidu.swan.apps.core.prefetch.a.1
            @Override // com.baidu.swan.apps.core.prefetch.a.InterfaceC0253a
            public void a(com.baidu.swan.apps.process.messaging.service.c cVar) {
                if (cVar != null) {
                    if (!cVar.abm()) {
                        a.this.a(cVar, prefetchEvent, bVar);
                    } else {
                        bVar.c(cVar);
                    }
                }
            }
        });
    }

    @Nullable
    private void a(@NonNull final PrefetchEvent prefetchEvent, @NonNull final InterfaceC0253a interfaceC0253a) {
        com.baidu.swan.apps.process.messaging.service.c b2 = b(prefetchEvent);
        if (b2 != null) {
            interfaceC0253a.a(b2);
            return;
        }
        com.baidu.swan.apps.process.messaging.service.c a = a(prefetchEvent);
        if (a != null && a.abl()) {
            interfaceC0253a.a(a);
            return;
        }
        com.baidu.swan.apps.process.messaging.service.c abA = e.abx().abA();
        if (abA.abm()) {
            if (DEBUG) {
                Log.e("PrefetchEnv", "prepareEnv isSwanAppLoaded.");
            }
            interfaceC0253a.a(null);
        } else if (abA.abl()) {
            if (DEBUG) {
                Log.d("PrefetchEnv", "prepareEnv isPreloaded.");
            }
            a(prefetchEvent, abA, interfaceC0253a);
        } else {
            abA.a(new c.a() { // from class: com.baidu.swan.apps.core.prefetch.a.2
                @Override // com.baidu.swan.apps.process.messaging.service.c.a
                public void b(com.baidu.swan.apps.process.messaging.service.c cVar) {
                    a.this.a(prefetchEvent, cVar, interfaceC0253a);
                }
            });
            Bundle bundle = new Bundle();
            bundle.putString("bundle_key_preload_preload_scene", "8");
            com.baidu.swan.apps.process.messaging.service.b.a(com.baidu.swan.apps.w.a.TZ(), abA, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull PrefetchEvent prefetchEvent, @NonNull com.baidu.swan.apps.process.messaging.service.c cVar, @NonNull InterfaceC0253a interfaceC0253a) {
        switch (com.baidu.swan.apps.core.prefetch.a.a.PS()) {
            case 1:
                if (cVar.bJN == null || TextUtils.equals(cVar.bJN.appId, prefetchEvent.appId)) {
                    interfaceC0253a.a(cVar);
                    return;
                }
                return;
            case 2:
                interfaceC0253a.a(cVar);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull com.baidu.swan.apps.process.messaging.service.c cVar, @NonNull PrefetchEvent prefetchEvent, @NonNull b bVar) {
        PMSAppInfo qn = com.baidu.swan.pms.database.a.aty().qn(prefetchEvent.appId);
        if (qn != null && !qn.ajd()) {
            bVar.c(cVar);
        } else {
            b(cVar, prefetchEvent, bVar);
        }
    }

    private void b(@NonNull final com.baidu.swan.apps.process.messaging.service.c cVar, @NonNull PrefetchEvent prefetchEvent, @NonNull final b bVar) {
        com.baidu.swan.apps.core.a.a.a.a(prefetchEvent.appId, 200, new a.InterfaceC0243a() { // from class: com.baidu.swan.apps.core.prefetch.a.3
            @Override // com.baidu.swan.apps.core.a.a.a.InterfaceC0243a
            public void Ng() {
                if (a.DEBUG) {
                    Log.d("PrefetchEnv", "prepareBundle swanAppIdInvalid");
                }
            }

            @Override // com.baidu.swan.apps.core.a.a.a.InterfaceC0243a
            public void Nh() {
                if (a.DEBUG) {
                    Log.d("PrefetchEnv", "prepareBundle success isPreloaded: " + cVar.abl());
                }
                if (cVar.abl()) {
                    bVar.c(cVar);
                }
            }

            @Override // com.baidu.swan.apps.core.a.a.a.InterfaceC0243a
            public void eq(int i) {
                if (a.DEBUG) {
                    Log.d("PrefetchEnv", "prepareBundle failed: " + i);
                }
            }
        }, prefetchEvent.scene, "swan");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class c implements e.a<String> {
        private c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.process.messaging.service.e.a
        public boolean a(String str, com.baidu.swan.apps.process.messaging.service.c cVar) {
            if (cVar.bJN == null) {
                return false;
            }
            return TextUtils.equals(str, cVar.bJN.appId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class d implements e.a<String> {
        private d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.process.messaging.service.e.a
        public boolean a(String str, com.baidu.swan.apps.process.messaging.service.c cVar) {
            return cVar.abm() && TextUtils.equals(str, cVar.mAppId);
        }
    }
}
