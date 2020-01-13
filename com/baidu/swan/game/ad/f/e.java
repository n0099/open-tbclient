package com.baidu.swan.game.ad.f;

import android.content.Context;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.game.ad.a;
import com.baidu.swan.game.ad.a.a;
import com.baidu.swan.game.ad.c.b;
import com.baidu.swan.game.ad.entity.AdElementInfo;
/* loaded from: classes10.dex */
public class e implements a.InterfaceC0317a {
    public String ccv;
    private a.InterfaceC0316a ccx;
    private String cdB;
    private AdElementInfo ceA;
    private com.baidu.swan.game.ad.a ceB;
    private boolean ceC;
    private h cex;
    public f cey;
    private Context mContext = AppRuntime.getAppContext();
    private b cez = new b(this.mContext);

    public e(String str, String str2, f fVar, a.InterfaceC0316a interfaceC0316a) {
        this.cey = null;
        this.cdB = str;
        this.ccv = str2;
        this.cey = fVar;
        this.ccx = interfaceC0316a;
        ait();
        loadAd();
    }

    public void a(h hVar) {
        this.cex = hVar;
    }

    public void a(JsObject jsObject) {
        final k e = k.e(com.baidu.swan.games.binding.model.c.c(jsObject));
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.1
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.ceB != null && com.baidu.swan.games.view.a.c.ay(e.this.ceB.getConvertView())) {
                    e.this.ceB.show();
                    if (e != null) {
                        e.aiB();
                    }
                    if (!e.this.ceC) {
                        e.this.ceC = true;
                        com.baidu.swan.game.ad.d.a.a(e.this.ceA, e.this.cez);
                        return;
                    }
                    return;
                }
                if (e != null) {
                    e.nH("3010010");
                }
                if (e.this.cex != null) {
                    e.this.cex.onError("3010010");
                }
            }
        });
    }

    public void aip() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.2
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.ceB != null) {
                    e.this.ceB.hide();
                }
            }
        });
    }

    public void aiq() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.3
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.ceB != null) {
                    com.baidu.swan.games.view.a.c.au(e.this.ceB.getConvertView());
                }
                e.this.ceB = null;
                e.this.cex = null;
                e.this.ceA = null;
            }
        });
    }

    public void nF(final String str) {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z = e.this.cey.width != e.this.cey.realWidth;
                e.this.ait();
                if (e.this.ceB != null) {
                    e.this.ceB.hk(e.this.cey.width);
                    com.baidu.swan.games.view.a.c.b(e.this.ceB.getConvertView(), new com.baidu.swan.apps.model.a.a.a(af.S(e.this.cey.left), af.S(e.this.cey.top), af.S(e.this.cey.realWidth), af.S(e.this.cey.realHeight)));
                }
                if (str.equals("width") && z && e.this.cex != null) {
                    e.this.cex.a(e.this.cey);
                }
            }
        });
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0317a
    public void b(AdElementInfo adElementInfo) {
        this.ceA = adElementInfo;
        ais();
        com.baidu.swan.games.view.a.b.bO("banner", "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0317a
    public void nt(String str) {
        if (this.cex != null) {
            this.cex.onError(str);
        }
        com.baidu.swan.apps.runtime.e aap = com.baidu.swan.apps.runtime.e.aap();
        String str2 = "";
        if (aap != null) {
            str2 = aap.id;
        }
        if (str2.lastIndexOf("_dev") >= 0 && str2.lastIndexOf("_dev") < str2.length() && str.equals("201000")) {
            air();
        }
        com.baidu.swan.games.view.a.b.M("banner", LivenessStat.TYPE_FACE_MATCH_FAIL, str);
    }

    private void air() {
        this.ceB = new com.baidu.swan.game.ad.a(this.mContext);
        this.ceB.hk(this.cey.width);
        if (com.baidu.swan.games.view.a.c.ay(this.ceB.getConvertView())) {
            com.baidu.swan.games.view.a.c.au(this.ceB.getConvertView());
        }
        com.baidu.swan.games.view.a.c.c(this.ceB.getConvertView(), new com.baidu.swan.apps.model.a.a.a(af.S(this.cey.left), af.S(this.cey.top), af.S(this.cey.realWidth), af.S(this.cey.realHeight)));
        this.ceB.getConvertView().postDelayed(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.ceB != null && com.baidu.swan.games.view.a.c.ay(e.this.ceB.getConvertView())) {
                    com.baidu.swan.games.view.a.c.au(e.this.ceB.getConvertView());
                }
            }
        }, 20000L);
    }

    private void ais() {
        this.ceB = new com.baidu.swan.game.ad.a(this.mContext, this.ceA, this.ccv);
        this.ceB.a(this.ccx);
        this.ceB.a(new a.c() { // from class: com.baidu.swan.game.ad.f.e.6
            @Override // com.baidu.swan.game.ad.a.a.c
            public void kR() {
                com.baidu.swan.apps.core.d.e El = com.baidu.swan.apps.y.f.UC().El();
                if (El == null) {
                    if (e.this.mContext != null) {
                        com.baidu.swan.apps.res.widget.b.d.q(e.this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
                    }
                } else if (e.this.ceA != null) {
                    String ahV = e.this.ceA.ahV();
                    El.gM("adLanding").Y(com.baidu.swan.apps.core.d.e.bjU, com.baidu.swan.apps.core.d.e.bjW).a("adLanding", com.baidu.swan.apps.model.b.aO(ahV, ahV)).Mj();
                    com.baidu.swan.game.ad.d.a.b(e.this.ceA, e.this.cez);
                }
            }
        });
        this.ceB.hk(this.cey.width);
        if (com.baidu.swan.games.view.a.c.ay(this.ceB.getConvertView())) {
            com.baidu.swan.games.view.a.c.au(this.ceB.getConvertView());
        }
        if (com.baidu.swan.games.view.a.c.c(this.ceB.getConvertView(), new com.baidu.swan.apps.model.a.a.a(af.S(this.cey.left), af.S(this.cey.top), af.S(this.cey.realWidth), af.S(this.cey.realHeight)))) {
            if (this.cex != null) {
                this.cex.onLoad();
            }
        } else if (this.cex != null) {
            this.cex.onError("3010000");
        }
    }

    private void loadAd() {
        com.baidu.swan.apps.runtime.e aap = com.baidu.swan.apps.runtime.e.aap();
        String str = "";
        if (aap != null) {
            str = aap.getAppKey();
        }
        com.baidu.swan.game.ad.c.c cVar = new com.baidu.swan.game.ad.c.c(this.mContext, new b.a().nz(this.cdB).nA(this.ccv).nB(str).hn(this.cey.width).ho(this.cey.height).aij());
        com.baidu.swan.game.ad.c.a aVar = new com.baidu.swan.game.ad.c.a(this.mContext);
        aVar.a(this);
        com.baidu.swan.games.view.a.b.bO("banner", null);
        aVar.a(cVar, this.cez);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ait() {
        if (this.cey != null) {
            if (af.S(this.cey.width) < 300) {
                this.cey.width = af.U(300.0f);
            }
            int aoj = com.baidu.swan.games.view.a.c.aoj();
            int aok = com.baidu.swan.games.view.a.c.aok();
            if (af.S(this.cey.width) > aoj) {
                this.cey.width = af.U(aoj);
            }
            this.cey.height = (int) (this.cey.width / com.baidu.swan.game.ad.e.d.ceb);
            if (this.cey.left < 0) {
                this.cey.left = 0;
            }
            int U = af.U(aoj) - this.cey.width;
            if (this.cey.left > U) {
                this.cey.left = U;
            }
            if (this.cey.top < 0) {
                this.cey.top = 0;
            }
            int U2 = af.U(aok) - this.cey.height;
            if (this.cey.top > U2) {
                this.cey.top = U2;
            }
            this.cey.realWidth = this.cey.width;
            this.cey.realHeight = this.cey.height;
        }
    }
}
