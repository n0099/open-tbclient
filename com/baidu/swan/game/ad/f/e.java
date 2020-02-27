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
    private a.InterfaceC0326a cgB;
    public String cgz;
    private String chE;
    private h ciB;
    public f ciC;
    private AdElementInfo ciE;
    private com.baidu.swan.game.ad.a ciF;
    private boolean ciG;
    private Context mContext = AppRuntime.getAppContext();
    private b ciD = new b(this.mContext);

    public e(String str, String str2, f fVar, a.InterfaceC0326a interfaceC0326a) {
        this.ciC = null;
        this.chE = str;
        this.cgz = str2;
        this.ciC = fVar;
        this.cgB = interfaceC0326a;
        akH();
        loadAd();
    }

    public void a(h hVar) {
        this.ciB = hVar;
    }

    public void a(JsObject jsObject) {
        final k e = k.e(com.baidu.swan.games.binding.model.c.c(jsObject));
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.1
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.ciF != null && com.baidu.swan.games.view.a.c.ay(e.this.ciF.getConvertView())) {
                    e.this.ciF.show();
                    if (e != null) {
                        e.akP();
                    }
                    if (!e.this.ciG) {
                        e.this.ciG = true;
                        com.baidu.swan.game.ad.d.a.a(e.this.ciE, e.this.ciD);
                        return;
                    }
                    return;
                }
                if (e != null) {
                    e.nW("3010010");
                }
                if (e.this.ciB != null) {
                    e.this.ciB.onError("3010010");
                }
            }
        });
    }

    public void akD() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.2
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.ciF != null) {
                    e.this.ciF.hide();
                }
            }
        });
    }

    public void akE() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.3
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.ciF != null) {
                    com.baidu.swan.games.view.a.c.au(e.this.ciF.getConvertView());
                }
                e.this.ciF = null;
                e.this.ciB = null;
                e.this.ciE = null;
            }
        });
    }

    public void nU(final String str) {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z = e.this.ciC.width != e.this.ciC.realWidth;
                e.this.akH();
                if (e.this.ciF != null) {
                    e.this.ciF.hB(e.this.ciC.width);
                    com.baidu.swan.games.view.a.c.b(e.this.ciF.getConvertView(), new com.baidu.swan.apps.model.a.a.a(af.S(e.this.ciC.left), af.S(e.this.ciC.f1012top), af.S(e.this.ciC.realWidth), af.S(e.this.ciC.realHeight)));
                }
                if (str.equals("width") && z && e.this.ciB != null) {
                    e.this.ciB.a(e.this.ciC);
                }
            }
        });
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0327a
    public void b(AdElementInfo adElementInfo) {
        this.ciE = adElementInfo;
        akG();
        com.baidu.swan.games.view.a.b.bX("banner", "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0327a
    public void nI(String str) {
        if (this.ciB != null) {
            this.ciB.onError(str);
        }
        com.baidu.swan.apps.runtime.e acD = com.baidu.swan.apps.runtime.e.acD();
        String str2 = "";
        if (acD != null) {
            str2 = acD.id;
        }
        if (str2.lastIndexOf("_dev") >= 0 && str2.lastIndexOf("_dev") < str2.length() && str.equals("201000")) {
            akF();
        }
        com.baidu.swan.games.view.a.b.N("banner", LivenessStat.TYPE_FACE_MATCH_FAIL, str);
    }

    private void akF() {
        this.ciF = new com.baidu.swan.game.ad.a(this.mContext);
        this.ciF.hB(this.ciC.width);
        if (com.baidu.swan.games.view.a.c.ay(this.ciF.getConvertView())) {
            com.baidu.swan.games.view.a.c.au(this.ciF.getConvertView());
        }
        com.baidu.swan.games.view.a.c.c(this.ciF.getConvertView(), new com.baidu.swan.apps.model.a.a.a(af.S(this.ciC.left), af.S(this.ciC.f1012top), af.S(this.ciC.realWidth), af.S(this.ciC.realHeight)));
        this.ciF.getConvertView().postDelayed(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.ciF != null && com.baidu.swan.games.view.a.c.ay(e.this.ciF.getConvertView())) {
                    com.baidu.swan.games.view.a.c.au(e.this.ciF.getConvertView());
                }
            }
        }, 20000L);
    }

    private void akG() {
        this.ciF = new com.baidu.swan.game.ad.a(this.mContext, this.ciE, this.cgz);
        this.ciF.a(this.cgB);
        this.ciF.a(new a.c() { // from class: com.baidu.swan.game.ad.f.e.6
            @Override // com.baidu.swan.game.ad.a.a.c
            public void lg() {
                com.baidu.swan.apps.core.d.e GA = com.baidu.swan.apps.y.f.WQ().GA();
                if (GA == null) {
                    if (e.this.mContext != null) {
                        com.baidu.swan.apps.res.widget.b.d.q(e.this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
                    }
                } else if (e.this.ciE != null) {
                    String akj = e.this.ciE.akj();
                    GA.hb("adLanding").Y(com.baidu.swan.apps.core.d.e.boe, com.baidu.swan.apps.core.d.e.bog).a("adLanding", com.baidu.swan.apps.model.b.aX(akj, akj)).Ox();
                    com.baidu.swan.game.ad.d.a.b(e.this.ciE, e.this.ciD);
                }
            }
        });
        this.ciF.hB(this.ciC.width);
        if (com.baidu.swan.games.view.a.c.ay(this.ciF.getConvertView())) {
            com.baidu.swan.games.view.a.c.au(this.ciF.getConvertView());
        }
        if (com.baidu.swan.games.view.a.c.c(this.ciF.getConvertView(), new com.baidu.swan.apps.model.a.a.a(af.S(this.ciC.left), af.S(this.ciC.f1012top), af.S(this.ciC.realWidth), af.S(this.ciC.realHeight)))) {
            if (this.ciB != null) {
                this.ciB.onLoad();
            }
        } else if (this.ciB != null) {
            this.ciB.onError("3010000");
        }
    }

    private void loadAd() {
        com.baidu.swan.apps.runtime.e acD = com.baidu.swan.apps.runtime.e.acD();
        String str = "";
        if (acD != null) {
            str = acD.getAppKey();
        }
        com.baidu.swan.game.ad.c.c cVar = new com.baidu.swan.game.ad.c.c(this.mContext, new b.a().nO(this.chE).nP(this.cgz).nQ(str).hE(this.ciC.width).hF(this.ciC.height).akx());
        com.baidu.swan.game.ad.c.a aVar = new com.baidu.swan.game.ad.c.a(this.mContext);
        aVar.a(this);
        com.baidu.swan.games.view.a.b.bX("banner", null);
        aVar.a(cVar, this.ciD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akH() {
        if (this.ciC != null) {
            if (af.S(this.ciC.width) < 300) {
                this.ciC.width = af.U(300.0f);
            }
            int aqx = com.baidu.swan.games.view.a.c.aqx();
            int aqy = com.baidu.swan.games.view.a.c.aqy();
            if (af.S(this.ciC.width) > aqx) {
                this.ciC.width = af.U(aqx);
            }
            this.ciC.height = (int) (this.ciC.width / com.baidu.swan.game.ad.e.d.cif);
            if (this.ciC.left < 0) {
                this.ciC.left = 0;
            }
            int U = af.U(aqx) - this.ciC.width;
            if (this.ciC.left > U) {
                this.ciC.left = U;
            }
            if (this.ciC.f1012top < 0) {
                this.ciC.f1012top = 0;
            }
            int U2 = af.U(aqy) - this.ciC.height;
            if (this.ciC.f1012top > U2) {
                this.ciC.f1012top = U2;
            }
            this.ciC.realWidth = this.ciC.width;
            this.ciC.realHeight = this.ciC.height;
        }
    }
}
