package com.baidu.swan.apps.ag.c.d;

import android.text.TextUtils;
import com.baidu.swan.apps.SwanAppActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public abstract class a extends b {
    abstract void a(SwanAppActivity swanAppActivity, String str, com.baidu.swan.apps.ag.c.b.b bVar, com.baidu.swan.apps.setting.b.a aVar, com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ag.c.c.a> bVar2);

    @Override // com.baidu.swan.apps.ag.c.d.b
    boolean XS() {
        return false;
    }

    @Override // com.baidu.swan.apps.ag.c.d.b
    com.baidu.swan.apps.api.b.b a(String str, com.baidu.swan.apps.ag.c.b.b bVar) {
        return new com.baidu.swan.apps.api.b.b(0);
    }

    @Override // com.baidu.swan.apps.ag.c.d.b
    com.baidu.swan.apps.api.b.b a(final com.baidu.swan.apps.ag.c.b.b bVar, final com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ag.c.c.a> bVar2) {
        if (bVar == null || TextUtils.isEmpty(bVar.bEk)) {
            return new com.baidu.swan.apps.api.b.b(1001, "get fun page info, provider appKey is empty");
        }
        if (bVar2 == null) {
            return new com.baidu.swan.apps.api.b.b(1001, "get fun page info, cb is null");
        }
        com.baidu.swan.apps.runtime.e aaj = com.baidu.swan.apps.runtime.d.aam().aaj();
        SwanAppActivity aal = aaj.aal();
        if (aal == null || aal.isFinishing()) {
            return new com.baidu.swan.apps.api.b.b(1001, "get fun page info, master has dead");
        }
        if (!aaj.aaA().isLogin(aaj)) {
            aaj.aaA().a(aal, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.ag.c.d.a.1
                @Override // com.baidu.swan.apps.a.a
                public void onResult(int i) {
                    if (i == 0) {
                        a.this.b(bVar, bVar2);
                        return;
                    }
                    com.baidu.swan.apps.ag.c.c.a aVar = new com.baidu.swan.apps.ag.c.c.a(bVar.bdV);
                    aVar.bdW = bVar.bdW;
                    bVar2.D(aVar);
                }
            });
            return new com.baidu.swan.apps.api.b.b(1001, "not login");
        }
        b(bVar, bVar2);
        return new com.baidu.swan.apps.api.b.b(0);
    }

    @Override // com.baidu.swan.apps.ag.c.d.b
    com.baidu.swan.apps.ag.c.b.a b(com.baidu.swan.apps.ag.c.b.b bVar) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.apps.ag.c.b.b bVar, final com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ag.c.c.a> bVar2) {
        com.baidu.swan.apps.ag.d.a.print("start get open data");
        final com.baidu.swan.apps.runtime.e aaj = com.baidu.swan.apps.runtime.d.aam().aaj();
        final SwanAppActivity aal = aaj.aal();
        com.baidu.swan.apps.setting.b.a.a(aal, XT(), bVar.bEk, true, new com.baidu.swan.apps.as.d.b<com.baidu.swan.apps.setting.b.a>() { // from class: com.baidu.swan.apps.ag.c.d.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.as.d.b
            /* renamed from: a */
            public void B(com.baidu.swan.apps.setting.b.a aVar) {
                a.this.a(aal, aaj.getAppKey(), bVar, aVar, bVar2);
            }
        });
    }
}
