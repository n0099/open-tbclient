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
public class f implements a.InterfaceC0194a {
    public String a;
    private i beh;
    public g bei;
    private com.baidu.swan.game.ad.a.a bek;
    private com.baidu.swan.game.ad.b bel;
    private String d;
    private boolean i;
    private Context c = AppRuntime.getAppContext();
    private d bej = new d(this.c);

    public f(String str, String str2, g gVar) {
        this.bei = null;
        this.d = str;
        this.a = str2;
        this.bei = gVar;
        e();
        d();
    }

    public void a(i iVar) {
        this.beh = iVar;
    }

    public void a(JsObject jsObject) {
        final l d = l.d(com.baidu.swan.games.binding.model.c.c(jsObject));
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.bel != null && com.baidu.swan.games.view.a.c.at(f.this.bel.a())) {
                    f.this.bel.b();
                    if (d != null) {
                        d.a();
                    }
                    if (!f.this.i) {
                        f.this.i = true;
                        com.baidu.swan.game.ad.d.a.a(f.this.bek, f.this.bej);
                        return;
                    }
                    return;
                }
                if (d != null) {
                    d.a("3010010");
                }
                if (f.this.beh != null) {
                    f.this.beh.a("3010010");
                }
            }
        });
    }

    public void a() {
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.f.2
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.bel != null) {
                    f.this.bel.c();
                }
            }
        });
    }

    public void b() {
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.f.3
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.bel != null) {
                    com.baidu.swan.games.view.a.c.an(f.this.bel.a());
                }
                f.this.bel = null;
                f.this.beh = null;
                f.this.bek = null;
            }
        });
    }

    public void b(final String str) {
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.f.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z = f.this.bei.width != f.this.bei.realWidth;
                f.this.e();
                if (f.this.bel != null) {
                    f.this.bel.a(f.this.bei.width);
                    com.baidu.swan.games.view.a.c.b(f.this.bel.a(), new com.baidu.swan.apps.model.a.a.b(z.ad(f.this.bei.left), z.ad(f.this.bei.top), z.ad(f.this.bei.realWidth), z.ad(f.this.bei.realHeight)));
                }
                if (str.equals("width") && z && f.this.beh != null) {
                    f.this.beh.a(f.this.bei);
                }
            }
        });
    }

    @Override // com.baidu.swan.game.ad.b.a.InterfaceC0194a
    public void a(com.baidu.swan.game.ad.a.a aVar) {
        this.bek = aVar;
        c();
        com.baidu.swan.games.view.a.b.bk("banner", "success");
    }

    @Override // com.baidu.swan.game.ad.b.a.InterfaceC0194a
    public void a(String str) {
        if (this.beh != null) {
            this.beh.a(str);
        }
        com.baidu.swan.games.view.a.b.bk("banner", LivenessStat.TYPE_FACE_MATCH_FAIL);
    }

    private void c() {
        this.bel = new com.baidu.swan.game.ad.b(this.c, this.bek);
        this.bel.a(new a.c() { // from class: com.baidu.swan.game.ad.f.f.5
            @Override // com.baidu.swan.game.ad.b.a.c
            public void b() {
                com.baidu.swan.apps.core.d.e vJ = com.baidu.swan.apps.w.e.GF().vJ();
                if (vJ == null) {
                    if (f.this.c != null) {
                        com.baidu.swan.apps.res.widget.b.d.k(f.this.c, a.h.aiapps_open_fragment_failed_toast).LQ();
                    }
                } else if (f.this.bek != null) {
                    String f = f.this.bek.f();
                    vJ.dS("adLanding").B(com.baidu.swan.apps.core.d.e.arw, com.baidu.swan.apps.core.d.e.ary).a("adLanding", com.baidu.swan.apps.model.b.aq(f, f)).AD();
                    com.baidu.swan.game.ad.d.a.b(f.this.bek, f.this.bej);
                }
            }
        });
        this.bel.a(this.bei.width);
        if (com.baidu.swan.games.view.a.c.at(this.bel.a())) {
            com.baidu.swan.games.view.a.c.an(this.bel.a());
        }
        if (com.baidu.swan.games.view.a.c.c(this.bel.a(), new com.baidu.swan.apps.model.a.a.b(z.ad(this.bei.left), z.ad(this.bei.top), z.ad(this.bei.realWidth), z.ad(this.bei.realHeight)))) {
            if (this.beh != null) {
                this.beh.a();
            }
        } else if (this.beh != null) {
            this.beh.a("3010000");
        }
    }

    private void d() {
        com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
        String str = "";
        if (Md != null) {
            str = Md.getAppKey();
        }
        com.baidu.swan.game.ad.c.c cVar = new com.baidu.swan.game.ad.c.c(this.c, new b.a().iH(this.d).iI(this.a).iJ(str).eT(this.bei.width).eU(this.bei.height).QK());
        com.baidu.swan.game.ad.c.a aVar = new com.baidu.swan.game.ad.c.a(this.c);
        aVar.a(this);
        com.baidu.swan.games.view.a.b.bk("banner", null);
        aVar.a(cVar, this.bej);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.bei != null) {
            if (z.ad(this.bei.width) < 300) {
                this.bei.width = z.af(300.0f);
            }
            int TB = com.baidu.swan.games.view.a.c.TB();
            int TC = com.baidu.swan.games.view.a.c.TC();
            if (z.ad(this.bei.width) > TB) {
                this.bei.width = z.af(TB);
            }
            this.bei.height = (int) (this.bei.width / com.baidu.swan.game.ad.e.d.a);
            if (this.bei.left < 0) {
                this.bei.left = 0;
            }
            int af = z.af(TB) - this.bei.width;
            if (this.bei.left > af) {
                this.bei.left = af;
            }
            if (this.bei.top < 0) {
                this.bei.top = 0;
            }
            int af2 = z.af(TC) - this.bei.height;
            if (this.bei.top > af2) {
                this.bei.top = af2;
            }
            this.bei.realWidth = this.bei.width;
            this.bei.realHeight = this.bei.height;
        }
    }
}
