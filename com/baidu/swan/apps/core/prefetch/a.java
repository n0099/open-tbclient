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
/* loaded from: classes7.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static c cfh = new c();
    private static d cfi = new d();

    /* renamed from: com.baidu.swan.apps.core.prefetch.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0351a {
        void a(com.baidu.swan.apps.process.messaging.service.c cVar);
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(@NonNull com.baidu.swan.apps.process.messaging.service.c cVar, @Nullable PMSAppInfo pMSAppInfo);
    }

    static com.baidu.swan.apps.process.messaging.service.c a(@NonNull PrefetchEvent prefetchEvent) {
        return e.aqf().a((e) prefetchEvent.appId, (e.a<e>) cfh);
    }

    static com.baidu.swan.apps.process.messaging.service.c b(@NonNull PrefetchEvent prefetchEvent) {
        return e.aqf().a((e) prefetchEvent.appId, (e.a<e>) cfi);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.baidu.swan.apps.process.messaging.service.c c(@NonNull PrefetchEvent prefetchEvent) {
        com.baidu.swan.apps.process.messaging.service.c b2 = b(prefetchEvent);
        if (b2 == null) {
            com.baidu.swan.apps.process.messaging.service.c a = a(prefetchEvent);
            return (a == null || !a.apT()) ? e.aqf().aqi() : a;
        }
        return b2;
    }

    public void a(@NonNull final PrefetchEvent prefetchEvent, @NonNull final b bVar) {
        a(prefetchEvent, new InterfaceC0351a() { // from class: com.baidu.swan.apps.core.prefetch.a.1
            @Override // com.baidu.swan.apps.core.prefetch.a.InterfaceC0351a
            public void a(com.baidu.swan.apps.process.messaging.service.c cVar) {
                if (cVar != null) {
                    if (!cVar.apU()) {
                        a.this.a(cVar, prefetchEvent, bVar);
                    } else {
                        bVar.a(cVar, null);
                    }
                }
            }
        });
    }

    @Nullable
    private void a(@NonNull final PrefetchEvent prefetchEvent, @NonNull final InterfaceC0351a interfaceC0351a) {
        com.baidu.swan.apps.process.messaging.service.c b2 = b(prefetchEvent);
        if (b2 != null) {
            interfaceC0351a.a(b2);
            return;
        }
        com.baidu.swan.apps.process.messaging.service.c a = a(prefetchEvent);
        if (a != null && a.apT()) {
            interfaceC0351a.a(a);
            return;
        }
        com.baidu.swan.apps.process.messaging.service.c aqi = e.aqf().aqi();
        if (aqi.apU()) {
            if (DEBUG) {
                Log.e("PrefetchEnv", "prepareEnv isSwanAppLoaded.");
            }
            interfaceC0351a.a(null);
        } else if (aqi.apT()) {
            if (DEBUG) {
                Log.d("PrefetchEnv", "prepareEnv isPreloaded.");
            }
            a(prefetchEvent, aqi, interfaceC0351a);
        } else {
            aqi.a(new c.a() { // from class: com.baidu.swan.apps.core.prefetch.a.2
                @Override // com.baidu.swan.apps.process.messaging.service.c.a
                public void b(com.baidu.swan.apps.process.messaging.service.c cVar) {
                    a.this.a(prefetchEvent, cVar, interfaceC0351a);
                }
            });
            Bundle bundle = new Bundle();
            bundle.putString("bundle_key_preload_preload_scene", "8");
            com.baidu.swan.apps.process.messaging.service.b.a(com.baidu.swan.apps.t.a.ahj(), aqi, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull PrefetchEvent prefetchEvent, @NonNull com.baidu.swan.apps.process.messaging.service.c cVar, @NonNull InterfaceC0351a interfaceC0351a) {
        switch (com.baidu.swan.apps.core.prefetch.a.a.acD()) {
            case 1:
                if (cVar.cBs == null || TextUtils.equals(cVar.cBs.appId, prefetchEvent.appId)) {
                    interfaceC0351a.a(cVar);
                    return;
                }
                return;
            case 2:
                interfaceC0351a.a(cVar);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull com.baidu.swan.apps.process.messaging.service.c cVar, @NonNull PrefetchEvent prefetchEvent, @NonNull b bVar) {
        PMSAppInfo uq = com.baidu.swan.pms.database.a.aKS().uq(prefetchEvent.appId);
        boolean h = h(uq);
        if (h && !uq.aLf()) {
            bVar.a(cVar, uq);
        } else {
            a(h, cVar, prefetchEvent, bVar);
        }
    }

    private boolean h(PMSAppInfo pMSAppInfo) {
        return pMSAppInfo != null && com.baidu.swan.apps.u.e.a.m(pMSAppInfo);
    }

    private void a(boolean z, @NonNull final com.baidu.swan.apps.process.messaging.service.c cVar, @NonNull PrefetchEvent prefetchEvent, @NonNull final b bVar) {
        com.baidu.swan.apps.core.a.a.a.a(z, prefetchEvent.appId, 200, new a.InterfaceC0339a() { // from class: com.baidu.swan.apps.core.prefetch.a.3
            @Override // com.baidu.swan.apps.core.a.a.a.InterfaceC0339a
            public void Zw() {
                if (a.DEBUG) {
                    Log.d("PrefetchEnv", "prepareBundle swanAppIdInvalid");
                }
            }

            @Override // com.baidu.swan.apps.core.a.a.a.InterfaceC0339a
            public void Zx() {
                if (a.DEBUG) {
                    Log.d("PrefetchEnv", "prepareBundle success isPreloaded: " + cVar.apT());
                }
                if (cVar.apT()) {
                    bVar.a(cVar, null);
                }
            }

            @Override // com.baidu.swan.apps.core.a.a.a.InterfaceC0339a
            public void eV(int i) {
                if (a.DEBUG) {
                    Log.d("PrefetchEnv", "prepareBundle failed: " + i);
                }
            }
        }, prefetchEvent.scene, "swan");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class c implements e.a<String> {
        private c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.process.messaging.service.e.a
        public boolean a(String str, com.baidu.swan.apps.process.messaging.service.c cVar) {
            if (cVar.cBs == null) {
                return false;
            }
            return TextUtils.equals(str, cVar.cBs.appId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class d implements e.a<String> {
        private d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.process.messaging.service.e.a
        public boolean a(String str, com.baidu.swan.apps.process.messaging.service.c cVar) {
            return cVar.apU() && TextUtils.equals(str, cVar.mAppId);
        }
    }
}
