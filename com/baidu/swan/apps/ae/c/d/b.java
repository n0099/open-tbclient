package com.baidu.swan.apps.ae.c.d;

import android.text.TextUtils;
import com.baidu.swan.apps.core.pms.c.a;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public abstract class b {
    abstract com.baidu.swan.apps.api.c.b a(com.baidu.swan.apps.ae.c.b.b bVar, com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ae.c.c.a> bVar2);

    abstract com.baidu.swan.apps.api.c.b a(String str, com.baidu.swan.apps.ae.c.b.b bVar);

    abstract com.baidu.swan.apps.api.c.b aN(JSONObject jSONObject);

    abstract boolean alW();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String alX();

    abstract com.baidu.swan.apps.ae.c.b.a b(com.baidu.swan.apps.ae.c.b.b bVar);

    public final com.baidu.swan.apps.api.c.b c(com.baidu.swan.apps.ae.c.b.b bVar, com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ae.c.c.a> bVar2) {
        com.baidu.swan.apps.ae.d.a.print("open fun page start");
        if (bVar == null || !bVar.alT()) {
            com.baidu.swan.apps.ae.d.a.print("params parse fail");
            return new com.baidu.swan.apps.api.c.b(202, "params parse fail");
        }
        com.baidu.swan.apps.api.c.b aN = aN(bVar.pageParams);
        if (aN != null) {
            com.baidu.swan.apps.ae.d.a.print("fun page args params invalid");
            return aN;
        } else if (alW()) {
            com.baidu.swan.apps.ae.d.a.print("open payment fun page");
            com.baidu.swan.apps.ae.c.b.a b = b(bVar);
            if (b == null) {
                return new com.baidu.swan.apps.api.c.b(1001, "fun page not exists");
            }
            if (!b.csF) {
                com.baidu.swan.apps.ae.d.a.print("payment fun page, " + bVar.csJ + " mode");
                if (mM(bVar.csJ)) {
                    if (b.csE) {
                        a(bVar, b, bVar2);
                    } else {
                        return new com.baidu.swan.apps.api.c.b(1001, "fun page not exists");
                    }
                } else if (b.csE) {
                    a(bVar, b, bVar2);
                } else {
                    a(bVar, b.appKey, bVar2);
                }
                com.baidu.swan.apps.ae.d.a.print("open fun page end");
                return new com.baidu.swan.apps.api.c.b(0);
            }
            return a(b.csC, bVar);
        } else {
            com.baidu.swan.apps.ae.d.a.print("open user info or choose address fun page");
            return a(bVar, bVar2);
        }
    }

    private boolean mM(String str) {
        return TextUtils.equals(str, "develop");
    }

    private void a(final com.baidu.swan.apps.ae.c.b.b bVar, String str, final com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ae.c.c.a> bVar2) {
        com.baidu.swan.apps.ae.d.a.print("local has not main pkg, download fun page main pkg");
        com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(str, com.baidu.swan.apps.runtime.d.aoB().Qz());
        cVar.jg(0);
        cVar.tp(bVar.csI);
        cVar.tt("3");
        com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.c.a(str, new a.InterfaceC0340a() { // from class: com.baidu.swan.apps.ae.c.d.b.1
            @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0340a
            public void aaj() {
                com.baidu.swan.apps.ae.d.a.print("payment fun page, your pkg is latest");
            }

            @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0340a
            public void onSuccess() {
                b.this.a(bVar, true, (com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ae.c.c.a>) bVar2);
            }

            @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0340a
            public void onError() {
                b.this.a(bVar, false, (com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ae.c.c.a>) bVar2);
            }
        }));
    }

    private void a(final com.baidu.swan.apps.ae.c.b.b bVar, com.baidu.swan.apps.ae.c.b.a aVar, final com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ae.c.c.a> bVar2) {
        com.baidu.swan.apps.ae.d.a.print("main pkg is exist, download fun page sub pkg");
        String str = aVar.appKey;
        int i = aVar.csD;
        com.baidu.swan.pms.c.a(new com.baidu.swan.pms.c.d.e(str, i, com.baidu.swan.apps.ae.g.b.bG(aVar.csC, aVar.csB), 0), new com.baidu.swan.apps.core.pms.e.a(str, String.valueOf(i), new com.baidu.swan.apps.core.pms.b() { // from class: com.baidu.swan.apps.ae.c.d.b.2
            @Override // com.baidu.swan.apps.core.pms.b
            public void ZM() {
                b.this.a(bVar, true, (com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ae.c.c.a>) bVar2);
            }

            @Override // com.baidu.swan.apps.core.pms.b
            public void eU(int i2) {
                b.this.a(bVar, false, (com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ae.c.c.a>) bVar2);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.ae.c.b.b bVar, boolean z, com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ae.c.c.a> bVar2) {
        if (z) {
            com.baidu.swan.apps.ae.c.b.a b = b(bVar);
            if (b == null || !b.csF) {
                com.baidu.swan.apps.ae.d.a.print("payment fun page, download success, but not exist");
                com.baidu.swan.apps.ae.c.c.a aVar = new com.baidu.swan.apps.ae.c.c.a(bVar.bPF);
                aVar.bPG = bVar.bPG;
                bVar2.K(aVar);
                return;
            }
            com.baidu.swan.apps.ae.d.a.print("payment fun page, download success, ready to jump");
            a(b.csC, bVar);
            return;
        }
        com.baidu.swan.apps.ae.d.a.print("payment fun page, download failed");
        com.baidu.swan.apps.ae.c.c.a aVar2 = new com.baidu.swan.apps.ae.c.c.a(bVar.bPF);
        aVar2.bPG = bVar.bPG;
        bVar2.K(aVar2);
    }
}
