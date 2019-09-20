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
public class f implements a.InterfaceC0208a {
    public String a;
    private i beG;
    public g beH;
    private com.baidu.swan.game.ad.a.a beJ;
    private com.baidu.swan.game.ad.b beK;
    private String d;
    private boolean i;
    private Context c = AppRuntime.getAppContext();
    private d beI = new d(this.c);

    public f(String str, String str2, g gVar) {
        this.beH = null;
        this.d = str;
        this.a = str2;
        this.beH = gVar;
        e();
        d();
    }

    public void a(i iVar) {
        this.beG = iVar;
    }

    public void a(JsObject jsObject) {
        final l d = l.d(com.baidu.swan.games.binding.model.c.c(jsObject));
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.beK != null && com.baidu.swan.games.view.a.c.at(f.this.beK.a())) {
                    f.this.beK.b();
                    if (d != null) {
                        d.a();
                    }
                    if (!f.this.i) {
                        f.this.i = true;
                        com.baidu.swan.game.ad.d.a.a(f.this.beJ, f.this.beI);
                        return;
                    }
                    return;
                }
                if (d != null) {
                    d.a("3010010");
                }
                if (f.this.beG != null) {
                    f.this.beG.a("3010010");
                }
            }
        });
    }

    public void a() {
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.f.2
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.beK != null) {
                    f.this.beK.c();
                }
            }
        });
    }

    public void b() {
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.f.3
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.beK != null) {
                    com.baidu.swan.games.view.a.c.an(f.this.beK.a());
                }
                f.this.beK = null;
                f.this.beG = null;
                f.this.beJ = null;
            }
        });
    }

    public void b(final String str) {
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.f.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z = f.this.beH.width != f.this.beH.realWidth;
                f.this.e();
                if (f.this.beK != null) {
                    f.this.beK.a(f.this.beH.width);
                    com.baidu.swan.games.view.a.c.b(f.this.beK.a(), new com.baidu.swan.apps.model.a.a.b(z.ad(f.this.beH.left), z.ad(f.this.beH.top), z.ad(f.this.beH.realWidth), z.ad(f.this.beH.realHeight)));
                }
                if (str.equals("width") && z && f.this.beG != null) {
                    f.this.beG.a(f.this.beH);
                }
            }
        });
    }

    @Override // com.baidu.swan.game.ad.b.a.InterfaceC0208a
    public void a(com.baidu.swan.game.ad.a.a aVar) {
        this.beJ = aVar;
        c();
        com.baidu.swan.games.view.a.b.bk("banner", "success");
    }

    @Override // com.baidu.swan.game.ad.b.a.InterfaceC0208a
    public void a(String str) {
        if (this.beG != null) {
            this.beG.a(str);
        }
        com.baidu.swan.games.view.a.b.bk("banner", LivenessStat.TYPE_FACE_MATCH_FAIL);
    }

    private void c() {
        this.beK = new com.baidu.swan.game.ad.b(this.c, this.beJ);
        this.beK.a(new a.c() { // from class: com.baidu.swan.game.ad.f.f.5
            @Override // com.baidu.swan.game.ad.b.a.c
            public void b() {
                com.baidu.swan.apps.core.d.e vN = com.baidu.swan.apps.w.e.GJ().vN();
                if (vN == null) {
                    if (f.this.c != null) {
                        com.baidu.swan.apps.res.widget.b.d.k(f.this.c, a.h.aiapps_open_fragment_failed_toast).LU();
                    }
                } else if (f.this.beJ != null) {
                    String f = f.this.beJ.f();
                    vN.dU("adLanding").B(com.baidu.swan.apps.core.d.e.arU, com.baidu.swan.apps.core.d.e.arW).a("adLanding", com.baidu.swan.apps.model.b.aq(f, f)).AH();
                    com.baidu.swan.game.ad.d.a.b(f.this.beJ, f.this.beI);
                }
            }
        });
        this.beK.a(this.beH.width);
        if (com.baidu.swan.games.view.a.c.at(this.beK.a())) {
            com.baidu.swan.games.view.a.c.an(this.beK.a());
        }
        if (com.baidu.swan.games.view.a.c.c(this.beK.a(), new com.baidu.swan.apps.model.a.a.b(z.ad(this.beH.left), z.ad(this.beH.top), z.ad(this.beH.realWidth), z.ad(this.beH.realHeight)))) {
            if (this.beG != null) {
                this.beG.a();
            }
        } else if (this.beG != null) {
            this.beG.a("3010000");
        }
    }

    private void d() {
        com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
        String str = "";
        if (Mh != null) {
            str = Mh.getAppKey();
        }
        com.baidu.swan.game.ad.c.c cVar = new com.baidu.swan.game.ad.c.c(this.c, new b.a().iJ(this.d).iK(this.a).iL(str).eU(this.beH.width).eV(this.beH.height).QO());
        com.baidu.swan.game.ad.c.a aVar = new com.baidu.swan.game.ad.c.a(this.c);
        aVar.a(this);
        com.baidu.swan.games.view.a.b.bk("banner", null);
        aVar.a(cVar, this.beI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.beH != null) {
            if (z.ad(this.beH.width) < 300) {
                this.beH.width = z.af(300.0f);
            }
            int TF = com.baidu.swan.games.view.a.c.TF();
            int TG = com.baidu.swan.games.view.a.c.TG();
            if (z.ad(this.beH.width) > TF) {
                this.beH.width = z.af(TF);
            }
            this.beH.height = (int) (this.beH.width / com.baidu.swan.game.ad.e.d.a);
            if (this.beH.left < 0) {
                this.beH.left = 0;
            }
            int af = z.af(TF) - this.beH.width;
            if (this.beH.left > af) {
                this.beH.left = af;
            }
            if (this.beH.top < 0) {
                this.beH.top = 0;
            }
            int af2 = z.af(TG) - this.beH.height;
            if (this.beH.top > af2) {
                this.beH.top = af2;
            }
            this.beH.realWidth = this.beH.width;
            this.beH.realHeight = this.beH.height;
        }
    }
}
