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
    public String cgM;
    private a.InterfaceC0326a cgO;
    private String chR;
    private h ciO;
    public f ciP;
    private AdElementInfo ciR;
    private com.baidu.swan.game.ad.a ciS;
    private boolean ciT;
    private Context mContext = AppRuntime.getAppContext();
    private b ciQ = new b(this.mContext);

    public e(String str, String str2, f fVar, a.InterfaceC0326a interfaceC0326a) {
        this.ciP = null;
        this.chR = str;
        this.cgM = str2;
        this.ciP = fVar;
        this.cgO = interfaceC0326a;
        akM();
        loadAd();
    }

    public void a(h hVar) {
        this.ciO = hVar;
    }

    public void a(JsObject jsObject) {
        final k e = k.e(com.baidu.swan.games.binding.model.c.c(jsObject));
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.1
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.ciS != null && com.baidu.swan.games.view.a.c.ay(e.this.ciS.getConvertView())) {
                    e.this.ciS.show();
                    if (e != null) {
                        e.akU();
                    }
                    if (!e.this.ciT) {
                        e.this.ciT = true;
                        com.baidu.swan.game.ad.d.a.a(e.this.ciR, e.this.ciQ);
                        return;
                    }
                    return;
                }
                if (e != null) {
                    e.nV("3010010");
                }
                if (e.this.ciO != null) {
                    e.this.ciO.onError("3010010");
                }
            }
        });
    }

    public void akI() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.2
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.ciS != null) {
                    e.this.ciS.hide();
                }
            }
        });
    }

    public void akJ() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.3
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.ciS != null) {
                    com.baidu.swan.games.view.a.c.au(e.this.ciS.getConvertView());
                }
                e.this.ciS = null;
                e.this.ciO = null;
                e.this.ciR = null;
            }
        });
    }

    public void nT(final String str) {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z = e.this.ciP.width != e.this.ciP.realWidth;
                e.this.akM();
                if (e.this.ciS != null) {
                    e.this.ciS.hB(e.this.ciP.width);
                    com.baidu.swan.games.view.a.c.b(e.this.ciS.getConvertView(), new com.baidu.swan.apps.model.a.a.a(af.S(e.this.ciP.left), af.S(e.this.ciP.f1011top), af.S(e.this.ciP.realWidth), af.S(e.this.ciP.realHeight)));
                }
                if (str.equals("width") && z && e.this.ciO != null) {
                    e.this.ciO.a(e.this.ciP);
                }
            }
        });
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0327a
    public void b(AdElementInfo adElementInfo) {
        this.ciR = adElementInfo;
        akL();
        com.baidu.swan.games.view.a.b.bW("banner", "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0327a
    public void nH(String str) {
        if (this.ciO != null) {
            this.ciO.onError(str);
        }
        com.baidu.swan.apps.runtime.e acI = com.baidu.swan.apps.runtime.e.acI();
        String str2 = "";
        if (acI != null) {
            str2 = acI.id;
        }
        if (str2.lastIndexOf("_dev") >= 0 && str2.lastIndexOf("_dev") < str2.length() && str.equals("201000")) {
            akK();
        }
        com.baidu.swan.games.view.a.b.N("banner", LivenessStat.TYPE_FACE_MATCH_FAIL, str);
    }

    private void akK() {
        this.ciS = new com.baidu.swan.game.ad.a(this.mContext);
        this.ciS.hB(this.ciP.width);
        if (com.baidu.swan.games.view.a.c.ay(this.ciS.getConvertView())) {
            com.baidu.swan.games.view.a.c.au(this.ciS.getConvertView());
        }
        com.baidu.swan.games.view.a.c.c(this.ciS.getConvertView(), new com.baidu.swan.apps.model.a.a.a(af.S(this.ciP.left), af.S(this.ciP.f1011top), af.S(this.ciP.realWidth), af.S(this.ciP.realHeight)));
        this.ciS.getConvertView().postDelayed(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.ciS != null && com.baidu.swan.games.view.a.c.ay(e.this.ciS.getConvertView())) {
                    com.baidu.swan.games.view.a.c.au(e.this.ciS.getConvertView());
                }
            }
        }, 20000L);
    }

    private void akL() {
        this.ciS = new com.baidu.swan.game.ad.a(this.mContext, this.ciR, this.cgM);
        this.ciS.a(this.cgO);
        this.ciS.a(new a.c() { // from class: com.baidu.swan.game.ad.f.e.6
            @Override // com.baidu.swan.game.ad.a.a.c
            public void lg() {
                com.baidu.swan.apps.core.d.e GH = com.baidu.swan.apps.y.f.WV().GH();
                if (GH == null) {
                    if (e.this.mContext != null) {
                        com.baidu.swan.apps.res.widget.b.d.q(e.this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
                    }
                } else if (e.this.ciR != null) {
                    String ako = e.this.ciR.ako();
                    GH.ha("adLanding").Y(com.baidu.swan.apps.core.d.e.bos, com.baidu.swan.apps.core.d.e.bou).a("adLanding", com.baidu.swan.apps.model.b.aW(ako, ako)).OC();
                    com.baidu.swan.game.ad.d.a.b(e.this.ciR, e.this.ciQ);
                }
            }
        });
        this.ciS.hB(this.ciP.width);
        if (com.baidu.swan.games.view.a.c.ay(this.ciS.getConvertView())) {
            com.baidu.swan.games.view.a.c.au(this.ciS.getConvertView());
        }
        if (com.baidu.swan.games.view.a.c.c(this.ciS.getConvertView(), new com.baidu.swan.apps.model.a.a.a(af.S(this.ciP.left), af.S(this.ciP.f1011top), af.S(this.ciP.realWidth), af.S(this.ciP.realHeight)))) {
            if (this.ciO != null) {
                this.ciO.onLoad();
            }
        } else if (this.ciO != null) {
            this.ciO.onError("3010000");
        }
    }

    private void loadAd() {
        com.baidu.swan.apps.runtime.e acI = com.baidu.swan.apps.runtime.e.acI();
        String str = "";
        if (acI != null) {
            str = acI.getAppKey();
        }
        com.baidu.swan.game.ad.c.c cVar = new com.baidu.swan.game.ad.c.c(this.mContext, new b.a().nN(this.chR).nO(this.cgM).nP(str).hE(this.ciP.width).hF(this.ciP.height).akC());
        com.baidu.swan.game.ad.c.a aVar = new com.baidu.swan.game.ad.c.a(this.mContext);
        aVar.a(this);
        com.baidu.swan.games.view.a.b.bW("banner", null);
        aVar.a(cVar, this.ciQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akM() {
        if (this.ciP != null) {
            if (af.S(this.ciP.width) < 300) {
                this.ciP.width = af.U(300.0f);
            }
            int aqC = com.baidu.swan.games.view.a.c.aqC();
            int aqD = com.baidu.swan.games.view.a.c.aqD();
            if (af.S(this.ciP.width) > aqC) {
                this.ciP.width = af.U(aqC);
            }
            this.ciP.height = (int) (this.ciP.width / com.baidu.swan.game.ad.e.d.cis);
            if (this.ciP.left < 0) {
                this.ciP.left = 0;
            }
            int U = af.U(aqC) - this.ciP.width;
            if (this.ciP.left > U) {
                this.ciP.left = U;
            }
            if (this.ciP.f1011top < 0) {
                this.ciP.f1011top = 0;
            }
            int U2 = af.U(aqD) - this.ciP.height;
            if (this.ciP.f1011top > U2) {
                this.ciP.f1011top = U2;
            }
            this.ciP.realWidth = this.ciP.width;
            this.ciP.realHeight = this.ciP.height;
        }
    }
}
