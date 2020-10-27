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
    private static c cIr = new c();
    private static d cIs = new d();

    /* renamed from: com.baidu.swan.apps.core.prefetch.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0418a {
        void a(com.baidu.swan.apps.process.messaging.service.c cVar);
    }

    /* loaded from: classes10.dex */
    public interface b {
        void a(@NonNull com.baidu.swan.apps.process.messaging.service.c cVar, @Nullable PMSAppInfo pMSAppInfo);
    }

    static com.baidu.swan.apps.process.messaging.service.c a(@NonNull PrefetchEvent prefetchEvent) {
        return e.aDs().a((e) prefetchEvent.appId, (e.a<e>) cIr);
    }

    static com.baidu.swan.apps.process.messaging.service.c b(@NonNull PrefetchEvent prefetchEvent) {
        return e.aDs().a((e) prefetchEvent.appId, (e.a<e>) cIs);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.baidu.swan.apps.process.messaging.service.c c(@NonNull PrefetchEvent prefetchEvent) {
        com.baidu.swan.apps.process.messaging.service.c b2 = b(prefetchEvent);
        if (b2 == null) {
            com.baidu.swan.apps.process.messaging.service.c a2 = a(prefetchEvent);
            return (a2 == null || !a2.aDc()) ? e.aDs().aDv() : a2;
        }
        return b2;
    }

    public void a(@NonNull final PrefetchEvent prefetchEvent, @NonNull final b bVar) {
        a(prefetchEvent, new InterfaceC0418a() { // from class: com.baidu.swan.apps.core.prefetch.a.1
            @Override // com.baidu.swan.apps.core.prefetch.a.InterfaceC0418a
            public void a(com.baidu.swan.apps.process.messaging.service.c cVar) {
                if (cVar != null) {
                    if (!cVar.aDd()) {
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
        if (a2 != null && a2.aDc()) {
            interfaceC0418a.a(a2);
            return;
        }
        com.baidu.swan.apps.process.messaging.service.c aDv = e.aDs().aDv();
        if (aDv.aDd()) {
            if (DEBUG) {
                Log.e("PrefetchEnv", "prepareEnv isSwanAppLoaded.");
            }
            interfaceC0418a.a(null);
        } else if (aDv.aDc()) {
            if (DEBUG) {
                Log.d("PrefetchEnv", "prepareEnv isPreloaded.");
            }
            interfaceC0418a.a(aDv);
        } else {
            aDv.a(new c.a() { // from class: com.baidu.swan.apps.core.prefetch.a.2
                @Override // com.baidu.swan.apps.process.messaging.service.c.a
                public void b(com.baidu.swan.apps.process.messaging.service.c cVar) {
                    interfaceC0418a.a(cVar);
                }
            });
            Bundle bundle = new Bundle();
            bundle.putString("bundle_key_preload_preload_scene", "8");
            com.baidu.swan.apps.process.messaging.service.b.a(com.baidu.swan.apps.t.a.aua(), aDv, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull com.baidu.swan.apps.process.messaging.service.c cVar, @NonNull PrefetchEvent prefetchEvent, @NonNull b bVar) {
        PMSAppInfo xY = com.baidu.swan.pms.database.a.aYH().xY(prefetchEvent.appId);
        boolean h = h(xY);
        if (h && !xY.aYR()) {
            bVar.a(cVar, xY);
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
            public void akU() {
                if (a.DEBUG) {
                    Log.d("PrefetchEnv", "prepareBundle swanAppIdInvalid");
                }
            }

            @Override // com.baidu.swan.apps.core.a.a.a.InterfaceC0406a
            public void akV() {
                if (a.DEBUG) {
                    Log.d("PrefetchEnv", "prepareBundle success isPreloaded: " + cVar.aDc());
                }
                if (cVar.aDc()) {
                    bVar.a(cVar, null);
                }
            }

            @Override // com.baidu.swan.apps.core.a.a.a.InterfaceC0406a
            public void hI(int i) {
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
            if (cVar.dgj == null) {
                return false;
            }
            return TextUtils.equals(str, cVar.dgj.appId);
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
            return cVar.aDd() && TextUtils.equals(str, cVar.mAppId);
        }
    }
}
