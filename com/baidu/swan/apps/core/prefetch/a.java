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
/* loaded from: classes25.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static c cTt = new c();
    private static d cTu = new d();

    /* renamed from: com.baidu.swan.apps.core.prefetch.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public interface InterfaceC0440a {
        void a(com.baidu.swan.apps.process.messaging.service.c cVar);
    }

    /* loaded from: classes25.dex */
    public interface b {
        void a(@NonNull com.baidu.swan.apps.process.messaging.service.c cVar, @Nullable PMSAppInfo pMSAppInfo);
    }

    static com.baidu.swan.apps.process.messaging.service.c a(@NonNull PrefetchEvent prefetchEvent) {
        return e.aIs().a((e) prefetchEvent.appId, (e.a<e>) cTt);
    }

    static com.baidu.swan.apps.process.messaging.service.c b(@NonNull PrefetchEvent prefetchEvent) {
        return e.aIs().a((e) prefetchEvent.appId, (e.a<e>) cTu);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.baidu.swan.apps.process.messaging.service.c c(@NonNull PrefetchEvent prefetchEvent) {
        com.baidu.swan.apps.process.messaging.service.c b2 = b(prefetchEvent);
        if (b2 == null) {
            com.baidu.swan.apps.process.messaging.service.c a2 = a(prefetchEvent);
            return (a2 == null || !a2.aIc()) ? e.aIs().aIv() : a2;
        }
        return b2;
    }

    public void a(@NonNull final PrefetchEvent prefetchEvent, @NonNull final b bVar) {
        a(prefetchEvent, new InterfaceC0440a() { // from class: com.baidu.swan.apps.core.prefetch.a.1
            @Override // com.baidu.swan.apps.core.prefetch.a.InterfaceC0440a
            public void a(com.baidu.swan.apps.process.messaging.service.c cVar) {
                if (cVar != null) {
                    if (!cVar.aId()) {
                        a.this.a(cVar, prefetchEvent, bVar);
                    } else {
                        bVar.a(cVar, null);
                    }
                }
            }
        });
    }

    @Nullable
    private void a(@NonNull PrefetchEvent prefetchEvent, @NonNull final InterfaceC0440a interfaceC0440a) {
        com.baidu.swan.apps.process.messaging.service.c b2 = b(prefetchEvent);
        if (b2 != null) {
            interfaceC0440a.a(b2);
            return;
        }
        com.baidu.swan.apps.process.messaging.service.c a2 = a(prefetchEvent);
        if (a2 != null && a2.aIc()) {
            interfaceC0440a.a(a2);
            return;
        }
        com.baidu.swan.apps.process.messaging.service.c aIv = e.aIs().aIv();
        if (aIv.aId()) {
            if (DEBUG) {
                Log.e("PrefetchEnv", "prepareEnv isSwanAppLoaded.");
            }
            interfaceC0440a.a(null);
        } else if (aIv.aIc()) {
            if (DEBUG) {
                Log.d("PrefetchEnv", "prepareEnv isPreloaded.");
            }
            interfaceC0440a.a(aIv);
        } else {
            aIv.a(new c.a() { // from class: com.baidu.swan.apps.core.prefetch.a.2
                @Override // com.baidu.swan.apps.process.messaging.service.c.a
                public void b(com.baidu.swan.apps.process.messaging.service.c cVar) {
                    interfaceC0440a.a(cVar);
                }
            });
            Bundle bundle = new Bundle();
            bundle.putString("bundle_key_preload_preload_scene", "8");
            com.baidu.swan.apps.process.messaging.service.b.a(com.baidu.swan.apps.t.a.aza(), aIv, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull com.baidu.swan.apps.process.messaging.service.c cVar, @NonNull PrefetchEvent prefetchEvent, @NonNull b bVar) {
        PMSAppInfo yO = com.baidu.swan.pms.database.a.bdF().yO(prefetchEvent.appId);
        boolean h = h(yO);
        if (h && !yO.bdP()) {
            bVar.a(cVar, yO);
        } else {
            a(h, cVar, prefetchEvent, bVar);
        }
    }

    private boolean h(PMSAppInfo pMSAppInfo) {
        return pMSAppInfo != null && com.baidu.swan.apps.u.f.a.m(pMSAppInfo);
    }

    private void a(boolean z, @NonNull final com.baidu.swan.apps.process.messaging.service.c cVar, @NonNull PrefetchEvent prefetchEvent, @NonNull final b bVar) {
        com.baidu.swan.apps.core.a.a.a.a(z, prefetchEvent.appId, 200, new a.InterfaceC0428a() { // from class: com.baidu.swan.apps.core.prefetch.a.3
            @Override // com.baidu.swan.apps.core.a.a.a.InterfaceC0428a
            public void apU() {
                if (a.DEBUG) {
                    Log.d("PrefetchEnv", "prepareBundle swanAppIdInvalid");
                }
            }

            @Override // com.baidu.swan.apps.core.a.a.a.InterfaceC0428a
            public void apV() {
                if (a.DEBUG) {
                    Log.d("PrefetchEnv", "prepareBundle success isPreloaded: " + cVar.aIc());
                }
                if (cVar.aIc()) {
                    bVar.a(cVar, null);
                }
            }

            @Override // com.baidu.swan.apps.core.a.a.a.InterfaceC0428a
            public void im(int i) {
                if (a.DEBUG) {
                    Log.d("PrefetchEnv", "prepareBundle failed: " + i);
                }
            }
        }, prefetchEvent.scene, "swan");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public static class c implements e.a<String> {
        private c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.process.messaging.service.e.a
        public boolean a(String str, com.baidu.swan.apps.process.messaging.service.c cVar) {
            if (cVar.drx == null) {
                return false;
            }
            return TextUtils.equals(str, cVar.drx.appId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public static class d implements e.a<String> {
        private d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.process.messaging.service.e.a
        public boolean a(String str, com.baidu.swan.apps.process.messaging.service.c cVar) {
            return cVar.aId() && TextUtils.equals(str, cVar.mAppId);
        }
    }
}
