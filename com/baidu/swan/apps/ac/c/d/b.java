package com.baidu.swan.apps.ac.c.d;

import android.text.TextUtils;
import com.baidu.swan.apps.core.pms.c.a;
import com.baidu.swan.pms.c.d.f;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public abstract class b {
    abstract com.baidu.swan.apps.api.c.b a(com.baidu.swan.apps.ac.c.b.b bVar, com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ac.c.c.a> bVar2);

    abstract com.baidu.swan.apps.api.c.b a(String str, com.baidu.swan.apps.ac.c.b.b bVar);

    abstract boolean aER();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String aES();

    abstract com.baidu.swan.apps.ac.c.b.a b(com.baidu.swan.apps.ac.c.b.b bVar);

    abstract com.baidu.swan.apps.api.c.b bx(JSONObject jSONObject);

    public final com.baidu.swan.apps.api.c.b c(com.baidu.swan.apps.ac.c.b.b bVar, com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ac.c.c.a> bVar2) {
        com.baidu.swan.apps.ac.d.a.print("open fun page start");
        if (bVar == null || !bVar.aEO()) {
            com.baidu.swan.apps.ac.d.a.print("params parse fail");
            return new com.baidu.swan.apps.api.c.b(202, "params parse fail");
        }
        com.baidu.swan.apps.api.c.b bx = bx(bVar.pageParams);
        if (bx != null) {
            com.baidu.swan.apps.ac.d.a.print("fun page args params invalid");
            return bx;
        } else if (aER()) {
            com.baidu.swan.apps.ac.d.a.print("open payment fun page");
            com.baidu.swan.apps.ac.c.b.a b2 = b(bVar);
            if (b2 == null) {
                return new com.baidu.swan.apps.api.c.b(1001, "fun page not exists");
            }
            if (!b2.dss) {
                com.baidu.swan.apps.ac.d.a.print("payment fun page, " + bVar.dsx + " mode");
                if (qN(bVar.dsx)) {
                    if (b2.dsr) {
                        a(bVar, b2, bVar2);
                    } else {
                        return new com.baidu.swan.apps.api.c.b(1001, "fun page not exists");
                    }
                } else if (b2.dsr) {
                    a(bVar, b2, bVar2);
                } else {
                    a(bVar, b2.appKey, bVar2);
                }
                com.baidu.swan.apps.ac.d.a.print("open fun page end");
                return new com.baidu.swan.apps.api.c.b(0);
            }
            return a(b2.dsp, bVar);
        } else {
            com.baidu.swan.apps.ac.d.a.print("open user info or choose address fun page");
            return a(bVar, bVar2);
        }
    }

    private boolean qN(String str) {
        return TextUtils.equals(str, "develop");
    }

    private void a(final com.baidu.swan.apps.ac.c.b.b bVar, String str, final com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ac.c.c.a> bVar2) {
        com.baidu.swan.apps.ac.d.a.print("local has not main pkg, download fun page main pkg");
        com.baidu.swan.pms.c.d.c cVar = new com.baidu.swan.pms.c.d.c(str, com.baidu.swan.apps.runtime.d.aIG().getFrameType());
        cVar.lW(0);
        cVar.yf(bVar.dsw);
        cVar.yj("3");
        com.baidu.swan.pms.c.a(cVar, new com.baidu.swan.apps.core.pms.c.a(str, new a.InterfaceC0409a() { // from class: com.baidu.swan.apps.ac.c.d.b.1
            @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0409a
            public void arb() {
                com.baidu.swan.apps.ac.d.a.print("payment fun page, your pkg is latest");
            }

            @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0409a
            public void onSuccess() {
                b.this.a(bVar, true, (com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ac.c.c.a>) bVar2);
            }

            @Override // com.baidu.swan.apps.core.pms.c.a.InterfaceC0409a
            public void onError() {
                b.this.a(bVar, false, (com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ac.c.c.a>) bVar2);
            }
        }));
    }

    private void a(final com.baidu.swan.apps.ac.c.b.b bVar, com.baidu.swan.apps.ac.c.b.a aVar, final com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ac.c.c.a> bVar2) {
        com.baidu.swan.apps.ac.d.a.print("main pkg is exist, download fun page sub pkg");
        String str = aVar.appKey;
        int i = aVar.dsq;
        com.baidu.swan.pms.c.a(new f(str, i, com.baidu.swan.apps.ac.g.b.cj(aVar.dsp, aVar.dso), 0), new com.baidu.swan.apps.core.pms.e.a(str, String.valueOf(i), new com.baidu.swan.apps.core.pms.b() { // from class: com.baidu.swan.apps.ac.c.d.b.2
            @Override // com.baidu.swan.apps.core.pms.b
            public void aqD() {
                b.this.a(bVar, true, (com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ac.c.c.a>) bVar2);
            }

            @Override // com.baidu.swan.apps.core.pms.b
            public void gU(int i2) {
                b.this.a(bVar, false, (com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ac.c.c.a>) bVar2);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.ac.c.b.b bVar, boolean z, com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ac.c.c.a> bVar2) {
        if (z) {
            com.baidu.swan.apps.ac.c.b.a b2 = b(bVar);
            if (b2 == null || !b2.dss) {
                com.baidu.swan.apps.ac.d.a.print("payment fun page, download success, but not exist");
                com.baidu.swan.apps.ac.c.c.a aVar = new com.baidu.swan.apps.ac.c.c.a(bVar.cLq);
                aVar.cLr = bVar.cLr;
                bVar2.N(aVar);
                return;
            }
            com.baidu.swan.apps.ac.d.a.print("payment fun page, download success, ready to jump");
            a(b2.dsp, bVar);
            return;
        }
        com.baidu.swan.apps.ac.d.a.print("payment fun page, download failed");
        com.baidu.swan.apps.ac.c.c.a aVar2 = new com.baidu.swan.apps.ac.c.c.a(bVar.cLq);
        aVar2.cLr = bVar.cLr;
        bVar2.N(aVar2);
    }
}
