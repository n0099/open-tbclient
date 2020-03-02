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
    public String cgA;
    private a.InterfaceC0326a cgC;
    private String chF;
    private h ciC;
    public f ciD;
    private AdElementInfo ciF;
    private com.baidu.swan.game.ad.a ciG;
    private boolean ciH;
    private Context mContext = AppRuntime.getAppContext();
    private b ciE = new b(this.mContext);

    public e(String str, String str2, f fVar, a.InterfaceC0326a interfaceC0326a) {
        this.ciD = null;
        this.chF = str;
        this.cgA = str2;
        this.ciD = fVar;
        this.cgC = interfaceC0326a;
        akJ();
        loadAd();
    }

    public void a(h hVar) {
        this.ciC = hVar;
    }

    public void a(JsObject jsObject) {
        final k e = k.e(com.baidu.swan.games.binding.model.c.c(jsObject));
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.1
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.ciG != null && com.baidu.swan.games.view.a.c.ay(e.this.ciG.getConvertView())) {
                    e.this.ciG.show();
                    if (e != null) {
                        e.akR();
                    }
                    if (!e.this.ciH) {
                        e.this.ciH = true;
                        com.baidu.swan.game.ad.d.a.a(e.this.ciF, e.this.ciE);
                        return;
                    }
                    return;
                }
                if (e != null) {
                    e.nW("3010010");
                }
                if (e.this.ciC != null) {
                    e.this.ciC.onError("3010010");
                }
            }
        });
    }

    public void akF() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.2
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.ciG != null) {
                    e.this.ciG.hide();
                }
            }
        });
    }

    public void akG() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.3
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.ciG != null) {
                    com.baidu.swan.games.view.a.c.au(e.this.ciG.getConvertView());
                }
                e.this.ciG = null;
                e.this.ciC = null;
                e.this.ciF = null;
            }
        });
    }

    public void nU(final String str) {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z = e.this.ciD.width != e.this.ciD.realWidth;
                e.this.akJ();
                if (e.this.ciG != null) {
                    e.this.ciG.hB(e.this.ciD.width);
                    com.baidu.swan.games.view.a.c.b(e.this.ciG.getConvertView(), new com.baidu.swan.apps.model.a.a.a(af.S(e.this.ciD.left), af.S(e.this.ciD.f1011top), af.S(e.this.ciD.realWidth), af.S(e.this.ciD.realHeight)));
                }
                if (str.equals("width") && z && e.this.ciC != null) {
                    e.this.ciC.a(e.this.ciD);
                }
            }
        });
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0327a
    public void b(AdElementInfo adElementInfo) {
        this.ciF = adElementInfo;
        akI();
        com.baidu.swan.games.view.a.b.bX("banner", "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0327a
    public void nI(String str) {
        if (this.ciC != null) {
            this.ciC.onError(str);
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
        this.ciG = new com.baidu.swan.game.ad.a(this.mContext);
        this.ciG.hB(this.ciD.width);
        if (com.baidu.swan.games.view.a.c.ay(this.ciG.getConvertView())) {
            com.baidu.swan.games.view.a.c.au(this.ciG.getConvertView());
        }
        com.baidu.swan.games.view.a.c.c(this.ciG.getConvertView(), new com.baidu.swan.apps.model.a.a.a(af.S(this.ciD.left), af.S(this.ciD.f1011top), af.S(this.ciD.realWidth), af.S(this.ciD.realHeight)));
        this.ciG.getConvertView().postDelayed(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.ciG != null && com.baidu.swan.games.view.a.c.ay(e.this.ciG.getConvertView())) {
                    com.baidu.swan.games.view.a.c.au(e.this.ciG.getConvertView());
                }
            }
        }, 20000L);
    }

    private void akI() {
        this.ciG = new com.baidu.swan.game.ad.a(this.mContext, this.ciF, this.cgA);
        this.ciG.a(this.cgC);
        this.ciG.a(new a.c() { // from class: com.baidu.swan.game.ad.f.e.6
            @Override // com.baidu.swan.game.ad.a.a.c
            public void lg() {
                com.baidu.swan.apps.core.d.e GC = com.baidu.swan.apps.y.f.WS().GC();
                if (GC == null) {
                    if (e.this.mContext != null) {
                        com.baidu.swan.apps.res.widget.b.d.q(e.this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
                    }
                } else if (e.this.ciF != null) {
                    String akl = e.this.ciF.akl();
                    GC.hb("adLanding").Y(com.baidu.swan.apps.core.d.e.bof, com.baidu.swan.apps.core.d.e.boh).a("adLanding", com.baidu.swan.apps.model.b.aX(akl, akl)).Oz();
                    com.baidu.swan.game.ad.d.a.b(e.this.ciF, e.this.ciE);
                }
            }
        });
        this.ciG.hB(this.ciD.width);
        if (com.baidu.swan.games.view.a.c.ay(this.ciG.getConvertView())) {
            com.baidu.swan.games.view.a.c.au(this.ciG.getConvertView());
        }
        if (com.baidu.swan.games.view.a.c.c(this.ciG.getConvertView(), new com.baidu.swan.apps.model.a.a.a(af.S(this.ciD.left), af.S(this.ciD.f1011top), af.S(this.ciD.realWidth), af.S(this.ciD.realHeight)))) {
            if (this.ciC != null) {
                this.ciC.onLoad();
            }
        } else if (this.ciC != null) {
            this.ciC.onError("3010000");
        }
    }

    private void loadAd() {
        com.baidu.swan.apps.runtime.e acF = com.baidu.swan.apps.runtime.e.acF();
        String str = "";
        if (acF != null) {
            str = acF.getAppKey();
        }
        com.baidu.swan.game.ad.c.c cVar = new com.baidu.swan.game.ad.c.c(this.mContext, new b.a().nO(this.chF).nP(this.cgA).nQ(str).hE(this.ciD.width).hF(this.ciD.height).akz());
        com.baidu.swan.game.ad.c.a aVar = new com.baidu.swan.game.ad.c.a(this.mContext);
        aVar.a(this);
        com.baidu.swan.games.view.a.b.bX("banner", null);
        aVar.a(cVar, this.ciE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akJ() {
        if (this.ciD != null) {
            if (af.S(this.ciD.width) < 300) {
                this.ciD.width = af.U(300.0f);
            }
            int aqz = com.baidu.swan.games.view.a.c.aqz();
            int aqA = com.baidu.swan.games.view.a.c.aqA();
            if (af.S(this.ciD.width) > aqz) {
                this.ciD.width = af.U(aqz);
            }
            this.ciD.height = (int) (this.ciD.width / com.baidu.swan.game.ad.e.d.cig);
            if (this.ciD.left < 0) {
                this.ciD.left = 0;
            }
            int U = af.U(aqz) - this.ciD.width;
            if (this.ciD.left > U) {
                this.ciD.left = U;
            }
            if (this.ciD.f1011top < 0) {
                this.ciD.f1011top = 0;
            }
            int U2 = af.U(aqA) - this.ciD.height;
            if (this.ciD.f1011top > U2) {
                this.ciD.f1011top = U2;
            }
            this.ciD.realWidth = this.ciD.width;
            this.ciD.realHeight = this.ciD.height;
        }
    }
}
