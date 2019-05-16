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
public class f implements a.InterfaceC0197a {
    public String a;
    private i bdu;
    public g bdv;
    private com.baidu.swan.game.ad.a.a bdx;
    private com.baidu.swan.game.ad.b bdy;
    private String d;
    private boolean i;
    private Context c = AppRuntime.getAppContext();
    private d bdw = new d(this.c);

    public f(String str, String str2, g gVar) {
        this.bdv = null;
        this.d = str;
        this.a = str2;
        this.bdv = gVar;
        e();
        d();
    }

    public void a(i iVar) {
        this.bdu = iVar;
    }

    public void a(JsObject jsObject) {
        final l d = l.d(com.baidu.swan.games.binding.model.c.c(jsObject));
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.f.1
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.bdy != null && com.baidu.swan.games.view.a.c.ar(f.this.bdy.a())) {
                    f.this.bdy.b();
                    if (d != null) {
                        d.a();
                    }
                    if (!f.this.i) {
                        f.this.i = true;
                        com.baidu.swan.game.ad.d.a.a(f.this.bdx, f.this.bdw);
                        return;
                    }
                    return;
                }
                if (d != null) {
                    d.a("3010010");
                }
                if (f.this.bdu != null) {
                    f.this.bdu.a("3010010");
                }
            }
        });
    }

    public void a() {
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.f.2
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.bdy != null) {
                    f.this.bdy.c();
                }
            }
        });
    }

    public void b() {
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.f.3
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.bdy != null) {
                    com.baidu.swan.games.view.a.c.al(f.this.bdy.a());
                }
                f.this.bdy = null;
                f.this.bdu = null;
                f.this.bdx = null;
            }
        });
    }

    public void b(final String str) {
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.f.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z = f.this.bdv.width != f.this.bdv.realWidth;
                f.this.e();
                if (f.this.bdy != null) {
                    f.this.bdy.a(f.this.bdv.width);
                    com.baidu.swan.games.view.a.c.b(f.this.bdy.a(), new com.baidu.swan.apps.model.a.a.b(z.ad(f.this.bdv.left), z.ad(f.this.bdv.top), z.ad(f.this.bdv.realWidth), z.ad(f.this.bdv.realHeight)));
                }
                if (str.equals("width") && z && f.this.bdu != null) {
                    f.this.bdu.a(f.this.bdv);
                }
            }
        });
    }

    @Override // com.baidu.swan.game.ad.b.a.InterfaceC0197a
    public void a(com.baidu.swan.game.ad.a.a aVar) {
        this.bdx = aVar;
        c();
        com.baidu.swan.games.view.a.b.bk("banner", "success");
    }

    @Override // com.baidu.swan.game.ad.b.a.InterfaceC0197a
    public void a(String str) {
        if (this.bdu != null) {
            this.bdu.a(str);
        }
        com.baidu.swan.games.view.a.b.bk("banner", LivenessStat.TYPE_FACE_MATCH_FAIL);
    }

    private void c() {
        this.bdy = new com.baidu.swan.game.ad.b(this.c, this.bdx);
        this.bdy.a(new a.c() { // from class: com.baidu.swan.game.ad.f.f.5
            @Override // com.baidu.swan.game.ad.b.a.c
            public void b() {
                com.baidu.swan.apps.core.d.e vi = com.baidu.swan.apps.w.e.FV().vi();
                if (vi == null) {
                    if (f.this.c != null) {
                        com.baidu.swan.apps.res.widget.b.d.k(f.this.c, a.h.aiapps_open_fragment_failed_toast).Ld();
                    }
                } else if (f.this.bdx != null) {
                    String f = f.this.bdx.f();
                    vi.dO("adLanding").y(com.baidu.swan.apps.core.d.e.aqT, com.baidu.swan.apps.core.d.e.aqV).a("adLanding", com.baidu.swan.apps.model.b.aq(f, f)).zW();
                    com.baidu.swan.game.ad.d.a.b(f.this.bdx, f.this.bdw);
                }
            }
        });
        this.bdy.a(this.bdv.width);
        if (com.baidu.swan.games.view.a.c.ar(this.bdy.a())) {
            com.baidu.swan.games.view.a.c.al(this.bdy.a());
        }
        if (com.baidu.swan.games.view.a.c.c(this.bdy.a(), new com.baidu.swan.apps.model.a.a.b(z.ad(this.bdv.left), z.ad(this.bdv.top), z.ad(this.bdv.realWidth), z.ad(this.bdv.realHeight)))) {
            if (this.bdu != null) {
                this.bdu.a();
            }
        } else if (this.bdu != null) {
            this.bdu.a("3010000");
        }
    }

    private void d() {
        com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
        String str = "";
        if (Lq != null) {
            str = Lq.getAppKey();
        }
        com.baidu.swan.game.ad.c.c cVar = new com.baidu.swan.game.ad.c.c(this.c, new b.a().iB(this.d).iC(this.a).iD(str).eP(this.bdv.width).eQ(this.bdv.height).PS());
        com.baidu.swan.game.ad.c.a aVar = new com.baidu.swan.game.ad.c.a(this.c);
        aVar.a(this);
        com.baidu.swan.games.view.a.b.bk("banner", null);
        aVar.a(cVar, this.bdw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.bdv != null) {
            if (z.ad(this.bdv.width) < 300) {
                this.bdv.width = z.af(300.0f);
            }
            int SI = com.baidu.swan.games.view.a.c.SI();
            int SJ = com.baidu.swan.games.view.a.c.SJ();
            if (z.ad(this.bdv.width) > SI) {
                this.bdv.width = z.af(SI);
            }
            this.bdv.height = (int) (this.bdv.width / com.baidu.swan.game.ad.e.d.a);
            if (this.bdv.left < 0) {
                this.bdv.left = 0;
            }
            int af = z.af(SI) - this.bdv.width;
            if (this.bdv.left > af) {
                this.bdv.left = af;
            }
            if (this.bdv.top < 0) {
                this.bdv.top = 0;
            }
            int af2 = z.af(SJ) - this.bdv.height;
            if (this.bdv.top > af2) {
                this.bdv.top = af2;
            }
            this.bdv.realWidth = this.bdv.width;
            this.bdv.realHeight = this.bdv.height;
        }
    }
}
