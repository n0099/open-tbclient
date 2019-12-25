package com.baidu.swan.apps.ag.c.d;

import android.text.TextUtils;
import com.baidu.swan.apps.core.pms.a.a;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public abstract class b {
    abstract boolean Xv();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String Xw();

    abstract com.baidu.swan.apps.api.b.b a(com.baidu.swan.apps.ag.c.b.b bVar, com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ag.c.c.a> bVar2);

    abstract com.baidu.swan.apps.api.b.b a(String str, com.baidu.swan.apps.ag.c.b.b bVar);

    abstract com.baidu.swan.apps.api.b.b ax(JSONObject jSONObject);

    abstract com.baidu.swan.apps.ag.c.b.a b(com.baidu.swan.apps.ag.c.b.b bVar);

    public final com.baidu.swan.apps.api.b.b c(com.baidu.swan.apps.ag.c.b.b bVar, com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ag.c.c.a> bVar2) {
        com.baidu.swan.apps.ag.d.a.print("open fun page start");
        if (bVar == null || !bVar.Xs()) {
            com.baidu.swan.apps.ag.d.a.print("params parse fail");
            return new com.baidu.swan.apps.api.b.b(202, "params parse fail");
        }
        com.baidu.swan.apps.api.b.b ax = ax(bVar.pageParams);
        if (ax != null) {
            com.baidu.swan.apps.ag.d.a.print("fun page args params invalid");
            return ax;
        } else if (Xv()) {
            com.baidu.swan.apps.ag.d.a.print("open payment fun page");
            com.baidu.swan.apps.ag.c.b.a b = b(bVar);
            if (b == null) {
                return new com.baidu.swan.apps.api.b.b(1001, "fun page not exists");
            }
            if (!b.bDy) {
                com.baidu.swan.apps.ag.d.a.print("payment fun page, " + bVar.bDC + " mode");
                if (jR(bVar.bDC)) {
                    if (b.bDx) {
                        a(bVar, b, bVar2);
                    } else {
                        return new com.baidu.swan.apps.api.b.b(1001, "fun page not exists");
                    }
                } else if (b.bDx) {
                    a(bVar, b, bVar2);
                } else {
                    a(bVar, b.appKey, bVar2);
                }
                com.baidu.swan.apps.ag.d.a.print("open fun page end");
                return new com.baidu.swan.apps.api.b.b(0);
            }
            return a(b.bDv, bVar);
        } else {
            com.baidu.swan.apps.ag.d.a.print("open user info or choose address fun page");
            return a(bVar, bVar2);
        }
    }

    private boolean jR(String str) {
        return TextUtils.equals(str, "develop");
    }

    private void a(final com.baidu.swan.apps.ag.c.b.b bVar, String str, final com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ag.c.c.a> bVar2) {
        com.baidu.swan.apps.ag.d.a.print("local has not main pkg, download fun page main pkg");
        com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(str, com.baidu.swan.apps.runtime.d.ZP().DH());
        cVar.is(0);
        cVar.qg(bVar.bDB);
        cVar.qk("3");
        com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.a.a(str, new a.InterfaceC0237a() { // from class: com.baidu.swan.apps.ag.c.d.b.1
            @Override // com.baidu.swan.apps.core.pms.a.a.InterfaceC0237a
            public void MT() {
                com.baidu.swan.apps.ag.d.a.print("payment fun page, your pkg is latest");
            }

            @Override // com.baidu.swan.apps.core.pms.a.a.InterfaceC0237a
            public void onSuccess() {
                b.this.a(bVar, true, (com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ag.c.c.a>) bVar2);
            }

            @Override // com.baidu.swan.apps.core.pms.a.a.InterfaceC0237a
            public void onError() {
                b.this.a(bVar, false, (com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ag.c.c.a>) bVar2);
            }
        }));
    }

    private void a(final com.baidu.swan.apps.ag.c.b.b bVar, com.baidu.swan.apps.ag.c.b.a aVar, final com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ag.c.c.a> bVar2) {
        com.baidu.swan.apps.ag.d.a.print("main pkg is exist, download fun page sub pkg");
        String str = aVar.appKey;
        int i = aVar.bDw;
        com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.e(str, i, com.baidu.swan.apps.ag.g.b.aU(aVar.bDv, aVar.bDu), 0), new com.baidu.swan.apps.core.pms.c.a(str, String.valueOf(i), new com.baidu.swan.apps.core.pms.b() { // from class: com.baidu.swan.apps.ag.c.d.b.2
            @Override // com.baidu.swan.apps.core.pms.b
            public void Mx() {
                b.this.a(bVar, true, (com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ag.c.c.a>) bVar2);
            }

            @Override // com.baidu.swan.apps.core.pms.b
            public void ep(int i2) {
                b.this.a(bVar, false, (com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ag.c.c.a>) bVar2);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.ag.c.b.b bVar, boolean z, com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ag.c.c.a> bVar2) {
        if (z) {
            com.baidu.swan.apps.ag.c.b.a b = b(bVar);
            if (b == null || !b.bDy) {
                com.baidu.swan.apps.ag.d.a.print("payment fun page, download success, but not exist");
                com.baidu.swan.apps.ag.c.c.a aVar = new com.baidu.swan.apps.ag.c.c.a(bVar.bdh);
                aVar.bdi = bVar.bdi;
                bVar2.D(aVar);
                return;
            }
            com.baidu.swan.apps.ag.d.a.print("payment fun page, download success, ready to jump");
            a(b.bDv, bVar);
            return;
        }
        com.baidu.swan.apps.ag.d.a.print("payment fun page, download failed");
        com.baidu.swan.apps.ag.c.c.a aVar2 = new com.baidu.swan.apps.ag.c.c.a(bVar.bdh);
        aVar2.bdi = bVar.bdi;
        bVar2.D(aVar2);
    }
}
