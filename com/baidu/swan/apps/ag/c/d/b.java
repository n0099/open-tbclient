package com.baidu.swan.apps.ag.c.d;

import android.text.TextUtils;
import com.baidu.swan.apps.core.pms.a.a;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public abstract class b {
    abstract com.baidu.swan.apps.api.b.b a(com.baidu.swan.apps.ag.c.b.b bVar, com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ag.c.c.a> bVar2);

    abstract com.baidu.swan.apps.api.b.b a(String str, com.baidu.swan.apps.ag.c.b.b bVar);

    abstract boolean aal();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String aam();

    abstract com.baidu.swan.apps.api.b.b ax(JSONObject jSONObject);

    abstract com.baidu.swan.apps.ag.c.b.a b(com.baidu.swan.apps.ag.c.b.b bVar);

    public final com.baidu.swan.apps.api.b.b c(com.baidu.swan.apps.ag.c.b.b bVar, com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ag.c.c.a> bVar2) {
        com.baidu.swan.apps.ag.d.a.print("open fun page start");
        if (bVar == null || !bVar.aai()) {
            com.baidu.swan.apps.ag.d.a.print("params parse fail");
            return new com.baidu.swan.apps.api.b.b(202, "params parse fail");
        }
        com.baidu.swan.apps.api.b.b ax = ax(bVar.pageParams);
        if (ax != null) {
            com.baidu.swan.apps.ag.d.a.print("fun page args params invalid");
            return ax;
        } else if (aal()) {
            com.baidu.swan.apps.ag.d.a.print("open payment fun page");
            com.baidu.swan.apps.ag.c.b.a b = b(bVar);
            if (b == null) {
                return new com.baidu.swan.apps.api.b.b(1001, "fun page not exists");
            }
            if (!b.bIB) {
                com.baidu.swan.apps.ag.d.a.print("payment fun page, " + bVar.bIF + " mode");
                if (ki(bVar.bIF)) {
                    if (b.bIA) {
                        a(bVar, b, bVar2);
                    } else {
                        return new com.baidu.swan.apps.api.b.b(1001, "fun page not exists");
                    }
                } else if (b.bIA) {
                    a(bVar, b, bVar2);
                } else {
                    a(bVar, b.appKey, bVar2);
                }
                com.baidu.swan.apps.ag.d.a.print("open fun page end");
                return new com.baidu.swan.apps.api.b.b(0);
            }
            return a(b.bIy, bVar);
        } else {
            com.baidu.swan.apps.ag.d.a.print("open user info or choose address fun page");
            return a(bVar, bVar2);
        }
    }

    private boolean ki(String str) {
        return TextUtils.equals(str, "develop");
    }

    private void a(final com.baidu.swan.apps.ag.c.b.b bVar, String str, final com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ag.c.c.a> bVar2) {
        com.baidu.swan.apps.ag.d.a.print("local has not main pkg, download fun page main pkg");
        com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(str, com.baidu.swan.apps.runtime.d.acF().Gz());
        cVar.iJ(0);
        cVar.qx(bVar.bIE);
        cVar.qB("3");
        com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.a.a(str, new a.InterfaceC0249a() { // from class: com.baidu.swan.apps.ag.c.d.b.1
            @Override // com.baidu.swan.apps.core.pms.a.a.InterfaceC0249a
            public void PI() {
                com.baidu.swan.apps.ag.d.a.print("payment fun page, your pkg is latest");
            }

            @Override // com.baidu.swan.apps.core.pms.a.a.InterfaceC0249a
            public void onSuccess() {
                b.this.a(bVar, true, (com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ag.c.c.a>) bVar2);
            }

            @Override // com.baidu.swan.apps.core.pms.a.a.InterfaceC0249a
            public void onError() {
                b.this.a(bVar, false, (com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ag.c.c.a>) bVar2);
            }
        }));
    }

    private void a(final com.baidu.swan.apps.ag.c.b.b bVar, com.baidu.swan.apps.ag.c.b.a aVar, final com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ag.c.c.a> bVar2) {
        com.baidu.swan.apps.ag.d.a.print("main pkg is exist, download fun page sub pkg");
        String str = aVar.appKey;
        int i = aVar.bIz;
        com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.e(str, i, com.baidu.swan.apps.ag.g.b.bd(aVar.bIy, aVar.bIx), 0), new com.baidu.swan.apps.core.pms.c.a(str, String.valueOf(i), new com.baidu.swan.apps.core.pms.b() { // from class: com.baidu.swan.apps.ag.c.d.b.2
            @Override // com.baidu.swan.apps.core.pms.b
            public void Pm() {
                b.this.a(bVar, true, (com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ag.c.c.a>) bVar2);
            }

            @Override // com.baidu.swan.apps.core.pms.b
            public void eG(int i2) {
                b.this.a(bVar, false, (com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ag.c.c.a>) bVar2);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.ag.c.b.b bVar, boolean z, com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ag.c.c.a> bVar2) {
        if (z) {
            com.baidu.swan.apps.ag.c.b.a b = b(bVar);
            if (b == null || !b.bIB) {
                com.baidu.swan.apps.ag.d.a.print("payment fun page, download success, but not exist");
                com.baidu.swan.apps.ag.c.c.a aVar = new com.baidu.swan.apps.ag.c.c.a(bVar.biA);
                aVar.biB = bVar.biB;
                bVar2.F(aVar);
                return;
            }
            com.baidu.swan.apps.ag.d.a.print("payment fun page, download success, ready to jump");
            a(b.bIy, bVar);
            return;
        }
        com.baidu.swan.apps.ag.d.a.print("payment fun page, download failed");
        com.baidu.swan.apps.ag.c.c.a aVar2 = new com.baidu.swan.apps.ag.c.c.a(bVar.biA);
        aVar2.biB = bVar.biB;
        bVar2.F(aVar2);
    }
}
