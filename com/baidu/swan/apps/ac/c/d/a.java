package com.baidu.swan.apps.ac.c.d;

import android.text.TextUtils;
import com.baidu.swan.apps.SwanAppActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public abstract class a extends b {
    abstract void a(SwanAppActivity swanAppActivity, String str, com.baidu.swan.apps.ac.c.b.b bVar, com.baidu.swan.apps.setting.b.a aVar, com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ac.c.c.a> bVar2);

    @Override // com.baidu.swan.apps.ac.c.d.b
    boolean aEw() {
        return false;
    }

    @Override // com.baidu.swan.apps.ac.c.d.b
    com.baidu.swan.apps.api.c.b a(String str, com.baidu.swan.apps.ac.c.b.b bVar) {
        return new com.baidu.swan.apps.api.c.b(0);
    }

    @Override // com.baidu.swan.apps.ac.c.d.b
    com.baidu.swan.apps.api.c.b a(final com.baidu.swan.apps.ac.c.b.b bVar, final com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ac.c.c.a> bVar2) {
        if (bVar == null || TextUtils.isEmpty(bVar.dqi)) {
            return new com.baidu.swan.apps.api.c.b(1001, "get fun page info, provider appKey is empty");
        }
        if (bVar2 == null) {
            return new com.baidu.swan.apps.api.c.b(1001, "get fun page info, cb is null");
        }
        com.baidu.swan.apps.runtime.e aIj = com.baidu.swan.apps.runtime.d.aIn().aIj();
        SwanAppActivity aIl = aIj.aIl();
        if (aIl == null || aIl.isFinishing()) {
            return new com.baidu.swan.apps.api.c.b(1001, "get fun page info, master has dead");
        }
        if (!aIj.aIE().isLogin(aIj)) {
            aIj.aIE().a(aIl, null, new com.baidu.swan.apps.a.a() { // from class: com.baidu.swan.apps.ac.c.d.a.1
                @Override // com.baidu.swan.apps.a.a
                public void onResult(int i) {
                    if (i == 0) {
                        a.this.b(bVar, bVar2);
                        return;
                    }
                    com.baidu.swan.apps.ac.c.c.a aVar = new com.baidu.swan.apps.ac.c.c.a(bVar.cJc);
                    aVar.cJd = bVar.cJd;
                    bVar2.N(aVar);
                }
            });
            return new com.baidu.swan.apps.api.c.b(1001, "not login");
        }
        b(bVar, bVar2);
        return new com.baidu.swan.apps.api.c.b(0);
    }

    @Override // com.baidu.swan.apps.ac.c.d.b
    com.baidu.swan.apps.ac.c.b.a b(com.baidu.swan.apps.ac.c.b.b bVar) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.baidu.swan.apps.ac.c.b.b bVar, final com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ac.c.c.a> bVar2) {
        com.baidu.swan.apps.ac.d.a.print("start get open data");
        final com.baidu.swan.apps.runtime.e aIj = com.baidu.swan.apps.runtime.d.aIn().aIj();
        final SwanAppActivity aIl = aIj.aIl();
        com.baidu.swan.apps.setting.b.a.a(aIl, aEx(), bVar.dqi, true, new com.baidu.swan.apps.ao.e.b<com.baidu.swan.apps.setting.b.a>() { // from class: com.baidu.swan.apps.ac.c.d.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.ao.e.b
            /* renamed from: a */
            public void L(com.baidu.swan.apps.setting.b.a aVar) {
                a.this.a(aIl, aIj.getAppKey(), bVar, aVar, bVar2);
            }
        });
    }
}
