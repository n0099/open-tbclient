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
/* loaded from: classes11.dex */
public class e implements a.InterfaceC0327a {
    public String cgB;
    private a.InterfaceC0326a cgD;
    private String chG;
    private h ciD;
    public f ciE;
    private AdElementInfo ciG;
    private com.baidu.swan.game.ad.a ciH;
    private boolean ciI;
    private Context mContext = AppRuntime.getAppContext();
    private b ciF = new b(this.mContext);

    public e(String str, String str2, f fVar, a.InterfaceC0326a interfaceC0326a) {
        this.ciE = null;
        this.chG = str;
        this.cgB = str2;
        this.ciE = fVar;
        this.cgD = interfaceC0326a;
        akJ();
        loadAd();
    }

    public void a(h hVar) {
        this.ciD = hVar;
    }

    public void a(JsObject jsObject) {
        final k e = k.e(com.baidu.swan.games.binding.model.c.c(jsObject));
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.1
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.ciH != null && com.baidu.swan.games.view.a.c.ay(e.this.ciH.getConvertView())) {
                    e.this.ciH.show();
                    if (e != null) {
                        e.akR();
                    }
                    if (!e.this.ciI) {
                        e.this.ciI = true;
                        com.baidu.swan.game.ad.d.a.a(e.this.ciG, e.this.ciF);
                        return;
                    }
                    return;
                }
                if (e != null) {
                    e.nW("3010010");
                }
                if (e.this.ciD != null) {
                    e.this.ciD.onError("3010010");
                }
            }
        });
    }

    public void akF() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.2
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.ciH != null) {
                    e.this.ciH.hide();
                }
            }
        });
    }

    public void akG() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.3
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.ciH != null) {
                    com.baidu.swan.games.view.a.c.au(e.this.ciH.getConvertView());
                }
                e.this.ciH = null;
                e.this.ciD = null;
                e.this.ciG = null;
            }
        });
    }

    public void nU(final String str) {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z = e.this.ciE.width != e.this.ciE.realWidth;
                e.this.akJ();
                if (e.this.ciH != null) {
                    e.this.ciH.hB(e.this.ciE.width);
                    com.baidu.swan.games.view.a.c.b(e.this.ciH.getConvertView(), new com.baidu.swan.apps.model.a.a.a(af.S(e.this.ciE.left), af.S(e.this.ciE.f1011top), af.S(e.this.ciE.realWidth), af.S(e.this.ciE.realHeight)));
                }
                if (str.equals("width") && z && e.this.ciD != null) {
                    e.this.ciD.a(e.this.ciE);
                }
            }
        });
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0327a
    public void b(AdElementInfo adElementInfo) {
        this.ciG = adElementInfo;
        akI();
        com.baidu.swan.games.view.a.b.bX("banner", "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0327a
    public void nI(String str) {
        if (this.ciD != null) {
            this.ciD.onError(str);
        }
        com.baidu.swan.apps.runtime.e acF = com.baidu.swan.apps.runtime.e.acF();
        String str2 = "";
        if (acF != null) {
            str2 = acF.id;
        }
        if (str2.lastIndexOf("_dev") >= 0 && str2.lastIndexOf("_dev") < str2.length() && str.equals("201000")) {
            akH();
        }
        com.baidu.swan.games.view.a.b.N("banner", LivenessStat.TYPE_FACE_MATCH_FAIL, str);
    }

    private void akH() {
        this.ciH = new com.baidu.swan.game.ad.a(this.mContext);
        this.ciH.hB(this.ciE.width);
        if (com.baidu.swan.games.view.a.c.ay(this.ciH.getConvertView())) {
            com.baidu.swan.games.view.a.c.au(this.ciH.getConvertView());
        }
        com.baidu.swan.games.view.a.c.c(this.ciH.getConvertView(), new com.baidu.swan.apps.model.a.a.a(af.S(this.ciE.left), af.S(this.ciE.f1011top), af.S(this.ciE.realWidth), af.S(this.ciE.realHeight)));
        this.ciH.getConvertView().postDelayed(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.ciH != null && com.baidu.swan.games.view.a.c.ay(e.this.ciH.getConvertView())) {
                    com.baidu.swan.games.view.a.c.au(e.this.ciH.getConvertView());
                }
            }
        }, 20000L);
    }

    private void akI() {
        this.ciH = new com.baidu.swan.game.ad.a(this.mContext, this.ciG, this.cgB);
        this.ciH.a(this.cgD);
        this.ciH.a(new a.c() { // from class: com.baidu.swan.game.ad.f.e.6
            @Override // com.baidu.swan.game.ad.a.a.c
            public void lg() {
                com.baidu.swan.apps.core.d.e GC = com.baidu.swan.apps.y.f.WS().GC();
                if (GC == null) {
                    if (e.this.mContext != null) {
                        com.baidu.swan.apps.res.widget.b.d.q(e.this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
                    }
                } else if (e.this.ciG != null) {
                    String akl = e.this.ciG.akl();
                    GC.hb("adLanding").Y(com.baidu.swan.apps.core.d.e.bog, com.baidu.swan.apps.core.d.e.boi).a("adLanding", com.baidu.swan.apps.model.b.aX(akl, akl)).Oz();
                    com.baidu.swan.game.ad.d.a.b(e.this.ciG, e.this.ciF);
                }
            }
        });
        this.ciH.hB(this.ciE.width);
        if (com.baidu.swan.games.view.a.c.ay(this.ciH.getConvertView())) {
            com.baidu.swan.games.view.a.c.au(this.ciH.getConvertView());
        }
        if (com.baidu.swan.games.view.a.c.c(this.ciH.getConvertView(), new com.baidu.swan.apps.model.a.a.a(af.S(this.ciE.left), af.S(this.ciE.f1011top), af.S(this.ciE.realWidth), af.S(this.ciE.realHeight)))) {
            if (this.ciD != null) {
                this.ciD.onLoad();
            }
        } else if (this.ciD != null) {
            this.ciD.onError("3010000");
        }
    }

    private void loadAd() {
        com.baidu.swan.apps.runtime.e acF = com.baidu.swan.apps.runtime.e.acF();
        String str = "";
        if (acF != null) {
            str = acF.getAppKey();
        }
        com.baidu.swan.game.ad.c.c cVar = new com.baidu.swan.game.ad.c.c(this.mContext, new b.a().nO(this.chG).nP(this.cgB).nQ(str).hE(this.ciE.width).hF(this.ciE.height).akz());
        com.baidu.swan.game.ad.c.a aVar = new com.baidu.swan.game.ad.c.a(this.mContext);
        aVar.a(this);
        com.baidu.swan.games.view.a.b.bX("banner", null);
        aVar.a(cVar, this.ciF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akJ() {
        if (this.ciE != null) {
            if (af.S(this.ciE.width) < 300) {
                this.ciE.width = af.U(300.0f);
            }
            int aqz = com.baidu.swan.games.view.a.c.aqz();
            int aqA = com.baidu.swan.games.view.a.c.aqA();
            if (af.S(this.ciE.width) > aqz) {
                this.ciE.width = af.U(aqz);
            }
            this.ciE.height = (int) (this.ciE.width / com.baidu.swan.game.ad.e.d.cih);
            if (this.ciE.left < 0) {
                this.ciE.left = 0;
            }
            int U = af.U(aqz) - this.ciE.width;
            if (this.ciE.left > U) {
                this.ciE.left = U;
            }
            if (this.ciE.f1011top < 0) {
                this.ciE.f1011top = 0;
            }
            int U2 = af.U(aqA) - this.ciE.height;
            if (this.ciE.f1011top > U2) {
                this.ciE.f1011top = U2;
            }
            this.ciE.realWidth = this.ciE.width;
            this.ciE.realHeight = this.ciE.height;
        }
    }
}
