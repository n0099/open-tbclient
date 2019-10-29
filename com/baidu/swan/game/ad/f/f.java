package com.baidu.swan.game.ad.f;

import android.content.Context;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.game.ad.b.a;
import com.baidu.swan.game.ad.c.b;
/* loaded from: classes2.dex */
public class f implements a.InterfaceC0240a {
    public String a;
    private i bxA;
    public g bxB;
    private com.baidu.swan.game.ad.a.a bxD;
    private com.baidu.swan.game.ad.b bxE;
    private String d;
    private boolean i;
    private Context c = AppRuntime.getAppContext();
    private d bxC = new d(this.c);

    public f(String str, String str2, g gVar) {
        this.bxB = null;
        this.d = str;
        this.a = str2;
        this.bxB = gVar;
        e();
        d();
    }

    public void a(i iVar) {
        this.bxA = iVar;
    }

    public void a(JsObject jsObject) {
        final l d = l.d(com.baidu.swan.games.binding.model.c.c(jsObject));
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.bxE != null && com.baidu.swan.games.view.a.c.az(f.this.bxE.a())) {
                    f.this.bxE.b();
                    if (d != null) {
                        d.a();
                    }
                    if (!f.this.i) {
                        f.this.i = true;
                        com.baidu.swan.game.ad.d.a.a(f.this.bxD, f.this.bxC);
                        return;
                    }
                    return;
                }
                if (d != null) {
                    d.a("3010010");
                }
                if (f.this.bxA != null) {
                    f.this.bxA.a("3010010");
                }
            }
        });
    }

    public void a() {
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.f.2
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.bxE != null) {
                    f.this.bxE.c();
                }
            }
        });
    }

    public void b() {
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.f.3
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.bxE != null) {
                    com.baidu.swan.games.view.a.c.at(f.this.bxE.a());
                }
                f.this.bxE = null;
                f.this.bxA = null;
                f.this.bxD = null;
            }
        });
    }

    public void b(final String str) {
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.f.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z = f.this.bxB.width != f.this.bxB.realWidth;
                f.this.e();
                if (f.this.bxE != null) {
                    f.this.bxE.a(f.this.bxB.width);
                    com.baidu.swan.games.view.a.c.b(f.this.bxE.a(), new com.baidu.swan.apps.model.a.a.b(z.S(f.this.bxB.left), z.S(f.this.bxB.top), z.S(f.this.bxB.realWidth), z.S(f.this.bxB.realHeight)));
                }
                if (str.equals("width") && z && f.this.bxA != null) {
                    f.this.bxA.a(f.this.bxB);
                }
            }
        });
    }

    @Override // com.baidu.swan.game.ad.b.a.InterfaceC0240a
    public void a(com.baidu.swan.game.ad.a.a aVar) {
        this.bxD = aVar;
        c();
        com.baidu.swan.games.view.a.b.br("banner", "success");
    }

    @Override // com.baidu.swan.game.ad.b.a.InterfaceC0240a
    public void a(String str) {
        if (this.bxA != null) {
            this.bxA.a(str);
        }
        com.baidu.swan.games.view.a.b.br("banner", LivenessStat.TYPE_FACE_MATCH_FAIL);
    }

    private void c() {
        this.bxE = new com.baidu.swan.game.ad.b(this.c, this.bxD);
        this.bxE.a(new a.c() { // from class: com.baidu.swan.game.ad.f.f.5
            @Override // com.baidu.swan.game.ad.b.a.c
            public void b() {
                com.baidu.swan.apps.core.d.e AH = com.baidu.swan.apps.w.e.LD().AH();
                if (AH == null) {
                    if (f.this.c != null) {
                        com.baidu.swan.apps.res.widget.b.d.i(f.this.c, a.h.aiapps_open_fragment_failed_toast).QN();
                    }
                } else if (f.this.bxD != null) {
                    String f = f.this.bxD.f();
                    AH.eC("adLanding").H(com.baidu.swan.apps.core.d.e.aLl, com.baidu.swan.apps.core.d.e.aLn).a("adLanding", com.baidu.swan.apps.model.b.ay(f, f)).FC();
                    com.baidu.swan.game.ad.d.a.b(f.this.bxD, f.this.bxC);
                }
            }
        });
        this.bxE.a(this.bxB.width);
        if (com.baidu.swan.games.view.a.c.az(this.bxE.a())) {
            com.baidu.swan.games.view.a.c.at(this.bxE.a());
        }
        if (com.baidu.swan.games.view.a.c.c(this.bxE.a(), new com.baidu.swan.apps.model.a.a.b(z.S(this.bxB.left), z.S(this.bxB.top), z.S(this.bxB.realWidth), z.S(this.bxB.realHeight)))) {
            if (this.bxA != null) {
                this.bxA.a();
            }
        } else if (this.bxA != null) {
            this.bxA.a("3010000");
        }
    }

    private void d() {
        com.baidu.swan.apps.ae.b QZ = com.baidu.swan.apps.ae.b.QZ();
        String str = "";
        if (QZ != null) {
            str = QZ.getAppKey();
        }
        com.baidu.swan.game.ad.c.c cVar = new com.baidu.swan.game.ad.c.c(this.c, new b.a().jm(this.d).jn(this.a).jo(str).fP(this.bxB.width).fQ(this.bxB.height).VE());
        com.baidu.swan.game.ad.c.a aVar = new com.baidu.swan.game.ad.c.a(this.c);
        aVar.a(this);
        com.baidu.swan.games.view.a.b.br("banner", null);
        aVar.a(cVar, this.bxC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.bxB != null) {
            if (z.S(this.bxB.width) < 300) {
                this.bxB.width = z.U(300.0f);
            }
            int Yw = com.baidu.swan.games.view.a.c.Yw();
            int Yx = com.baidu.swan.games.view.a.c.Yx();
            if (z.S(this.bxB.width) > Yw) {
                this.bxB.width = z.U(Yw);
            }
            this.bxB.height = (int) (this.bxB.width / com.baidu.swan.game.ad.e.d.a);
            if (this.bxB.left < 0) {
                this.bxB.left = 0;
            }
            int U = z.U(Yw) - this.bxB.width;
            if (this.bxB.left > U) {
                this.bxB.left = U;
            }
            if (this.bxB.top < 0) {
                this.bxB.top = 0;
            }
            int U2 = z.U(Yx) - this.bxB.height;
            if (this.bxB.top > U2) {
                this.bxB.top = U2;
            }
            this.bxB.realWidth = this.bxB.width;
            this.bxB.realHeight = this.bxB.height;
        }
    }
}
