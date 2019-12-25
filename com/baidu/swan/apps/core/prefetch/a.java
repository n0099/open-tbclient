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
/* loaded from: classes9.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static c blI = new c();
    private static d blJ = new d();

    /* renamed from: com.baidu.swan.apps.core.prefetch.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0241a {
        void a(com.baidu.swan.apps.process.messaging.service.c cVar);
    }

    /* loaded from: classes9.dex */
    public interface b {
        void c(com.baidu.swan.apps.process.messaging.service.c cVar);
    }

    static com.baidu.swan.apps.process.messaging.service.c a(@NonNull PrefetchEvent prefetchEvent) {
        return e.YH().a((e) prefetchEvent.appId, (e.a<e>) blI);
    }

    static com.baidu.swan.apps.process.messaging.service.c b(@NonNull PrefetchEvent prefetchEvent) {
        return e.YH().a((e) prefetchEvent.appId, (e.a<e>) blJ);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.baidu.swan.apps.process.messaging.service.c c(@NonNull PrefetchEvent prefetchEvent) {
        com.baidu.swan.apps.process.messaging.service.c b2 = b(prefetchEvent);
        if (b2 == null) {
            com.baidu.swan.apps.process.messaging.service.c a = a(prefetchEvent);
            return (a == null || !a.Yv()) ? e.YH().YK() : a;
        }
        return b2;
    }

    public void a(@NonNull final PrefetchEvent prefetchEvent, @NonNull final b bVar) {
        a(prefetchEvent, new InterfaceC0241a() { // from class: com.baidu.swan.apps.core.prefetch.a.1
            @Override // com.baidu.swan.apps.core.prefetch.a.InterfaceC0241a
            public void a(com.baidu.swan.apps.process.messaging.service.c cVar) {
                if (cVar != null) {
                    if (!cVar.Yw()) {
                        a.this.a(cVar, prefetchEvent, bVar);
                    } else {
                        bVar.c(cVar);
                    }
                }
            }
        });
    }

    @Nullable
    private void a(@NonNull final PrefetchEvent prefetchEvent, @NonNull final InterfaceC0241a interfaceC0241a) {
        com.baidu.swan.apps.process.messaging.service.c b2 = b(prefetchEvent);
        if (b2 != null) {
            interfaceC0241a.a(b2);
            return;
        }
        com.baidu.swan.apps.process.messaging.service.c a = a(prefetchEvent);
        if (a != null && a.Yv()) {
            interfaceC0241a.a(a);
            return;
        }
        com.baidu.swan.apps.process.messaging.service.c YK = e.YH().YK();
        if (YK.Yw()) {
            if (DEBUG) {
                Log.e("PrefetchEnv", "prepareEnv isSwanAppLoaded.");
            }
            interfaceC0241a.a(null);
        } else if (YK.Yv()) {
            if (DEBUG) {
                Log.d("PrefetchEnv", "prepareEnv isPreloaded.");
            }
            a(prefetchEvent, YK, interfaceC0241a);
        } else {
            YK.a(new c.a() { // from class: com.baidu.swan.apps.core.prefetch.a.2
                @Override // com.baidu.swan.apps.process.messaging.service.c.a
                public void b(com.baidu.swan.apps.process.messaging.service.c cVar) {
                    a.this.a(prefetchEvent, cVar, interfaceC0241a);
                }
            });
            Bundle bundle = new Bundle();
            bundle.putString("bundle_key_preload_preload_scene", "8");
            com.baidu.swan.apps.process.messaging.service.b.a(com.baidu.swan.apps.w.a.Rk(), YK, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull PrefetchEvent prefetchEvent, @NonNull com.baidu.swan.apps.process.messaging.service.c cVar, @NonNull InterfaceC0241a interfaceC0241a) {
        switch (com.baidu.swan.apps.core.prefetch.a.a.Nd()) {
            case 1:
                if (cVar.bEK == null || TextUtils.equals(cVar.bEK.appId, prefetchEvent.appId)) {
                    interfaceC0241a.a(cVar);
                    return;
                }
                return;
            case 2:
                interfaceC0241a.a(cVar);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull com.baidu.swan.apps.process.messaging.service.c cVar, @NonNull PrefetchEvent prefetchEvent, @NonNull b bVar) {
        PMSAppInfo pW = com.baidu.swan.pms.database.a.aqM().pW(prefetchEvent.appId);
        if (pW != null && !pW.agr()) {
            bVar.c(cVar);
        } else {
            b(cVar, prefetchEvent, bVar);
        }
    }

    private void b(@NonNull final com.baidu.swan.apps.process.messaging.service.c cVar, @NonNull PrefetchEvent prefetchEvent, @NonNull final b bVar) {
        com.baidu.swan.apps.core.a.a.a.a(prefetchEvent.appId, 200, new a.InterfaceC0231a() { // from class: com.baidu.swan.apps.core.prefetch.a.3
            @Override // com.baidu.swan.apps.core.a.a.a.InterfaceC0231a
            public void Kq() {
                if (a.DEBUG) {
                    Log.d("PrefetchEnv", "prepareBundle swanAppIdInvalid");
                }
            }

            @Override // com.baidu.swan.apps.core.a.a.a.InterfaceC0231a
            public void Kr() {
                if (a.DEBUG) {
                    Log.d("PrefetchEnv", "prepareBundle success isPreloaded: " + cVar.Yv());
                }
                if (cVar.Yv()) {
                    bVar.c(cVar);
                }
            }

            @Override // com.baidu.swan.apps.core.a.a.a.InterfaceC0231a
            public void dZ(int i) {
                if (a.DEBUG) {
                    Log.d("PrefetchEnv", "prepareBundle failed: " + i);
                }
            }
        }, prefetchEvent.scene, "swan");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class c implements e.a<String> {
        private c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.process.messaging.service.e.a
        public boolean a(String str, com.baidu.swan.apps.process.messaging.service.c cVar) {
            if (cVar.bEK == null) {
                return false;
            }
            return TextUtils.equals(str, cVar.bEK.appId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class d implements e.a<String> {
        private d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.process.messaging.service.e.a
        public boolean a(String str, com.baidu.swan.apps.process.messaging.service.c cVar) {
            return cVar.Yw() && TextUtils.equals(str, cVar.mAppId);
        }
    }
}
