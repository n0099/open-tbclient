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
    private i bwJ;
    public g bwK;
    private com.baidu.swan.game.ad.a.a bwM;
    private com.baidu.swan.game.ad.b bwN;
    private String d;
    private boolean i;
    private Context c = AppRuntime.getAppContext();
    private d bwL = new d(this.c);

    public f(String str, String str2, g gVar) {
        this.bwK = null;
        this.d = str;
        this.a = str2;
        this.bwK = gVar;
        e();
        d();
    }

    public void a(i iVar) {
        this.bwJ = iVar;
    }

    public void a(JsObject jsObject) {
        final l d = l.d(com.baidu.swan.games.binding.model.c.c(jsObject));
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.bwN != null && com.baidu.swan.games.view.a.c.az(f.this.bwN.a())) {
                    f.this.bwN.b();
                    if (d != null) {
                        d.a();
                    }
                    if (!f.this.i) {
                        f.this.i = true;
                        com.baidu.swan.game.ad.d.a.a(f.this.bwM, f.this.bwL);
                        return;
                    }
                    return;
                }
                if (d != null) {
                    d.a("3010010");
                }
                if (f.this.bwJ != null) {
                    f.this.bwJ.a("3010010");
                }
            }
        });
    }

    public void a() {
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.f.2
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.bwN != null) {
                    f.this.bwN.c();
                }
            }
        });
    }

    public void b() {
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.f.3
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.bwN != null) {
                    com.baidu.swan.games.view.a.c.at(f.this.bwN.a());
                }
                f.this.bwN = null;
                f.this.bwJ = null;
                f.this.bwM = null;
            }
        });
    }

    public void b(final String str) {
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.f.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z = f.this.bwK.width != f.this.bwK.realWidth;
                f.this.e();
                if (f.this.bwN != null) {
                    f.this.bwN.a(f.this.bwK.width);
                    com.baidu.swan.games.view.a.c.b(f.this.bwN.a(), new com.baidu.swan.apps.model.a.a.b(z.S(f.this.bwK.left), z.S(f.this.bwK.top), z.S(f.this.bwK.realWidth), z.S(f.this.bwK.realHeight)));
                }
                if (str.equals("width") && z && f.this.bwJ != null) {
                    f.this.bwJ.a(f.this.bwK);
                }
            }
        });
    }

    @Override // com.baidu.swan.game.ad.b.a.InterfaceC0240a
    public void a(com.baidu.swan.game.ad.a.a aVar) {
        this.bwM = aVar;
        c();
        com.baidu.swan.games.view.a.b.br("banner", "success");
    }

    @Override // com.baidu.swan.game.ad.b.a.InterfaceC0240a
    public void a(String str) {
        if (this.bwJ != null) {
            this.bwJ.a(str);
        }
        com.baidu.swan.games.view.a.b.br("banner", LivenessStat.TYPE_FACE_MATCH_FAIL);
    }

    private void c() {
        this.bwN = new com.baidu.swan.game.ad.b(this.c, this.bwM);
        this.bwN.a(new a.c() { // from class: com.baidu.swan.game.ad.f.f.5
            @Override // com.baidu.swan.game.ad.b.a.c
            public void b() {
                com.baidu.swan.apps.core.d.e AI = com.baidu.swan.apps.w.e.LE().AI();
                if (AI == null) {
                    if (f.this.c != null) {
                        com.baidu.swan.apps.res.widget.b.d.i(f.this.c, a.h.aiapps_open_fragment_failed_toast).QO();
                    }
                } else if (f.this.bwM != null) {
                    String f = f.this.bwM.f();
                    AI.eC("adLanding").F(com.baidu.swan.apps.core.d.e.aKT, com.baidu.swan.apps.core.d.e.aKV).a("adLanding", com.baidu.swan.apps.model.b.ay(f, f)).FD();
                    com.baidu.swan.game.ad.d.a.b(f.this.bwM, f.this.bwL);
                }
            }
        });
        this.bwN.a(this.bwK.width);
        if (com.baidu.swan.games.view.a.c.az(this.bwN.a())) {
            com.baidu.swan.games.view.a.c.at(this.bwN.a());
        }
        if (com.baidu.swan.games.view.a.c.c(this.bwN.a(), new com.baidu.swan.apps.model.a.a.b(z.S(this.bwK.left), z.S(this.bwK.top), z.S(this.bwK.realWidth), z.S(this.bwK.realHeight)))) {
            if (this.bwJ != null) {
                this.bwJ.a();
            }
        } else if (this.bwJ != null) {
            this.bwJ.a("3010000");
        }
    }

    private void d() {
        com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
        String str = "";
        if (Ra != null) {
            str = Ra.getAppKey();
        }
        com.baidu.swan.game.ad.c.c cVar = new com.baidu.swan.game.ad.c.c(this.c, new b.a().jm(this.d).jn(this.a).jo(str).fO(this.bwK.width).fP(this.bwK.height).VC());
        com.baidu.swan.game.ad.c.a aVar = new com.baidu.swan.game.ad.c.a(this.c);
        aVar.a(this);
        com.baidu.swan.games.view.a.b.br("banner", null);
        aVar.a(cVar, this.bwL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.bwK != null) {
            if (z.S(this.bwK.width) < 300) {
                this.bwK.width = z.U(300.0f);
            }
            int Yu = com.baidu.swan.games.view.a.c.Yu();
            int Yv = com.baidu.swan.games.view.a.c.Yv();
            if (z.S(this.bwK.width) > Yu) {
                this.bwK.width = z.U(Yu);
            }
            this.bwK.height = (int) (this.bwK.width / com.baidu.swan.game.ad.e.d.a);
            if (this.bwK.left < 0) {
                this.bwK.left = 0;
            }
            int U = z.U(Yu) - this.bwK.width;
            if (this.bwK.left > U) {
                this.bwK.left = U;
            }
            if (this.bwK.top < 0) {
                this.bwK.top = 0;
            }
            int U2 = z.U(Yv) - this.bwK.height;
            if (this.bwK.top > U2) {
                this.bwK.top = U2;
            }
            this.bwK.realWidth = this.bwK.width;
            this.bwK.realHeight = this.bwK.height;
        }
    }
}
