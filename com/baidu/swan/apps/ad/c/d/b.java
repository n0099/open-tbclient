package com.baidu.swan.apps.ad.c.d;

import android.text.TextUtils;
import com.baidu.swan.apps.core.pms.c.a;
import com.baidu.swan.pms.c.d.f;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class b {
    abstract com.baidu.swan.apps.api.c.b a(com.baidu.swan.apps.ad.c.b.b bVar, com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ad.c.c.a> bVar2);

    abstract com.baidu.swan.apps.api.c.b a(String str, com.baidu.swan.apps.ad.c.b.b bVar);

    abstract com.baidu.swan.apps.api.c.b aW(JSONObject jSONObject);

    abstract boolean aoL();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String aoM();

    abstract com.baidu.swan.apps.ad.c.b.a b(com.baidu.swan.apps.ad.c.b.b bVar);

    public final com.baidu.swan.apps.api.c.b c(com.baidu.swan.apps.ad.c.b.b bVar, com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ad.c.c.a> bVar2) {
        com.baidu.swan.apps.ad.d.a.print("open fun page start");
        if (bVar == null || !bVar.aoI()) {
            com.baidu.swan.apps.ad.d.a.print("params parse fail");
            return new com.baidu.swan.apps.api.c.b(202, "params parse fail");
        }
        com.baidu.swan.apps.api.c.b aW = aW(bVar.pageParams);
        if (aW != null) {
            com.baidu.swan.apps.ad.d.a.print("fun page args params invalid");
            return aW;
        } else if (aoL()) {
            com.baidu.swan.apps.ad.d.a.print("open payment fun page");
            com.baidu.swan.apps.ad.c.b.a b = b(bVar);
            if (b == null) {
                return new com.baidu.swan.apps.api.c.b(1001, "fun page not exists");
            }
            if (!b.czT) {
                com.baidu.swan.apps.ad.d.a.print("payment fun page, " + bVar.czX + " mode");
                if (nB(bVar.czX)) {
                    if (b.czS) {
                        a(bVar, b, bVar2);
                    } else {
                        return new com.baidu.swan.apps.api.c.b(1001, "fun page not exists");
                    }
                } else if (b.czS) {
                    a(bVar, b, bVar2);
                } else {
                    a(bVar, b.appKey, bVar2);
                }
                com.baidu.swan.apps.ad.d.a.print("open fun page end");
                return new com.baidu.swan.apps.api.c.b(0);
            }
            return a(b.czQ, bVar);
        } else {
            com.baidu.swan.apps.ad.d.a.print("open user info or choose address fun page");
            return a(bVar, bVar2);
        }
    }

    private boolean nB(String str) {
        return TextUtils.equals(str, "develop");
    }

    private void a(final com.baidu.swan.apps.ad.c.b.b bVar, String str, final com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ad.c.c.a> bVar2) {
        com.baidu.swan.apps.ad.d.a.print("local has not main pkg, download fun page main pkg");
        com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(str, com.baidu.swan.apps.runtime.d.arr().RU());
        cVar.jM(0);
        cVar.uA(bVar.czW);
        cVar.uE("3");
        com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.c.a(str, new a.InterfaceC0348a() { // from class: com.baidu.swan.apps.ad.c.d.b.1
            @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0348a
            public void acr() {
                com.baidu.swan.apps.ad.d.a.print("payment fun page, your pkg is latest");
            }

            @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0348a
            public void onSuccess() {
                b.this.a(bVar, true, (com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ad.c.c.a>) bVar2);
            }

            @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0348a
            public void onError() {
                b.this.a(bVar, false, (com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ad.c.c.a>) bVar2);
            }
        }));
    }

    private void a(final com.baidu.swan.apps.ad.c.b.b bVar, com.baidu.swan.apps.ad.c.b.a aVar, final com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ad.c.c.a> bVar2) {
        com.baidu.swan.apps.ad.d.a.print("main pkg is exist, download fun page sub pkg");
        String str = aVar.appKey;
        int i = aVar.czR;
        com.baidu.swan.pms.c.a(new f(str, i, com.baidu.swan.apps.ad.g.b.bK(aVar.czQ, aVar.czP), 0), new com.baidu.swan.apps.core.pms.e.a(str, String.valueOf(i), new com.baidu.swan.apps.core.pms.b() { // from class: com.baidu.swan.apps.ad.c.d.b.2
            @Override // com.baidu.swan.apps.core.pms.b
            public void abT() {
                b.this.a(bVar, true, (com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ad.c.c.a>) bVar2);
            }

            @Override // com.baidu.swan.apps.core.pms.b
            public void fl(int i2) {
                b.this.a(bVar, false, (com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ad.c.c.a>) bVar2);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.ad.c.b.b bVar, boolean z, com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ad.c.c.a> bVar2) {
        if (z) {
            com.baidu.swan.apps.ad.c.b.a b = b(bVar);
            if (b == null || !b.czT) {
                com.baidu.swan.apps.ad.d.a.print("payment fun page, download success, but not exist");
                com.baidu.swan.apps.ad.c.c.a aVar = new com.baidu.swan.apps.ad.c.c.a(bVar.bVl);
                aVar.bVm = bVar.bVm;
                bVar2.J(aVar);
                return;
            }
            com.baidu.swan.apps.ad.d.a.print("payment fun page, download success, ready to jump");
            a(b.czQ, bVar);
            return;
        }
        com.baidu.swan.apps.ad.d.a.print("payment fun page, download failed");
        com.baidu.swan.apps.ad.c.c.a aVar2 = new com.baidu.swan.apps.ad.c.c.a(bVar.bVl);
        aVar2.bVm = bVar.bVm;
        bVar2.J(aVar2);
    }
}
