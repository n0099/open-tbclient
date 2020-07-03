package com.baidu.swan.game.ad.f;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.game.ad.a;
import com.baidu.swan.game.ad.a.a;
import com.baidu.swan.game.ad.c.b;
import com.baidu.swan.game.ad.entity.AdElementInfo;
/* loaded from: classes11.dex */
public class e implements a.InterfaceC0424a {
    public String cUK;
    private a.InterfaceC0423a cUM;
    private String cVN;
    private h cWJ;
    public f cWK;
    private AdElementInfo cWM;
    private com.baidu.swan.game.ad.a cWN;
    private boolean cWO;
    private Context mContext = AppRuntime.getAppContext();
    private b cWL = new b(this.mContext);

    public e(String str, String str2, f fVar, a.InterfaceC0423a interfaceC0423a) {
        this.cWK = null;
        this.cVN = str;
        this.cUK = str2;
        this.cWK = fVar;
        this.cUM = interfaceC0423a;
        axL();
        loadAd();
    }

    public void a(h hVar) {
        this.cWJ = hVar;
    }

    public void c(JsObject jsObject) {
        final k e = k.e(com.baidu.swan.games.binding.model.c.e(jsObject));
        aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.1
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.cWN != null && com.baidu.swan.games.view.a.c.ay(e.this.cWN.getConvertView())) {
                    e.this.cWN.show();
                    if (e != null) {
                        e.axU();
                    }
                    if (!e.this.cWO) {
                        e.this.cWO = true;
                        com.baidu.swan.game.ad.d.a.a(e.this.cWM, e.this.cWL);
                        return;
                    }
                    return;
                }
                if (e != null) {
                    e.qQ("3010010");
                }
                if (e.this.cWJ != null) {
                    e.this.cWJ.onError("3010010");
                }
            }
        });
    }

    public void axH() {
        aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.2
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.cWN != null) {
                    e.this.cWN.hide();
                }
            }
        });
    }

    public void axI() {
        aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.3
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.cWN != null) {
                    com.baidu.swan.games.view.a.c.av(e.this.cWN.getConvertView());
                }
                e.this.cWN = null;
                e.this.cWJ = null;
                e.this.cWM = null;
            }
        });
    }

    public void qO(final String str) {
        aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z = e.this.cWK.width != e.this.cWK.realWidth;
                e.this.axL();
                if (e.this.cWN != null) {
                    e.this.cWN.im(e.this.cWK.width);
                    com.baidu.swan.games.view.a.c.b(e.this.cWN.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ag.D(e.this.cWK.left), ag.D(e.this.cWK.f1010top), ag.D(e.this.cWK.realWidth), ag.D(e.this.cWK.realHeight)));
                }
                if (str.equals("width") && z && e.this.cWJ != null) {
                    e.this.cWJ.a(e.this.cWK);
                }
            }
        });
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0424a
    public void b(AdElementInfo adElementInfo) {
        this.cWM = adElementInfo;
        axK();
        com.baidu.swan.games.view.a.b.cE("banner", "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0424a
    public void qC(String str) {
        if (this.cWJ != null) {
            this.cWJ.onError(str);
        }
        com.baidu.swan.apps.runtime.e apM = com.baidu.swan.apps.runtime.e.apM();
        String str2 = "";
        if (apM != null) {
            str2 = apM.id;
        }
        if (str2.lastIndexOf("_dev") >= 0 && str2.lastIndexOf("_dev") < str2.length() && str.equals("201000")) {
            axJ();
        }
        com.baidu.swan.games.view.a.b.R("banner", "fail", str);
    }

    private void axJ() {
        this.cWN = new com.baidu.swan.game.ad.a(this.mContext);
        this.cWN.im(this.cWK.width);
        if (com.baidu.swan.games.view.a.c.ay(this.cWN.getConvertView())) {
            com.baidu.swan.games.view.a.c.av(this.cWN.getConvertView());
        }
        com.baidu.swan.games.view.a.c.c(this.cWN.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ag.D(this.cWK.left), ag.D(this.cWK.f1010top), ag.D(this.cWK.realWidth), ag.D(this.cWK.realHeight)));
        this.cWN.getConvertView().postDelayed(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.cWN != null && com.baidu.swan.games.view.a.c.ay(e.this.cWN.getConvertView())) {
                    com.baidu.swan.games.view.a.c.av(e.this.cWN.getConvertView());
                }
            }
        }, 20000L);
    }

    private void axK() {
        this.cWN = new com.baidu.swan.game.ad.a(this.mContext, this.cWM, this.cUK);
        this.cWN.a(this.cUM);
        this.cWN.a(new a.c() { // from class: com.baidu.swan.game.ad.f.e.6
            @Override // com.baidu.swan.game.ad.a.a.c
            public void qh() {
                com.baidu.swan.apps.core.d.e RN = com.baidu.swan.apps.w.f.ajb().RN();
                if (RN == null) {
                    if (e.this.mContext != null) {
                        com.baidu.swan.apps.res.widget.b.d.k(e.this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
                    }
                } else if (e.this.cWM != null) {
                    String axm = e.this.cWM.axm();
                    RN.jx("adLanding").ag(com.baidu.swan.apps.core.d.e.caB, com.baidu.swan.apps.core.d.e.caD).a("adLanding", com.baidu.swan.apps.model.b.bz(axm, axm)).aah();
                    com.baidu.swan.game.ad.d.a.b(e.this.cWM, e.this.cWL);
                }
            }
        });
        this.cWN.im(this.cWK.width);
        if (com.baidu.swan.games.view.a.c.ay(this.cWN.getConvertView())) {
            com.baidu.swan.games.view.a.c.av(this.cWN.getConvertView());
        }
        if (com.baidu.swan.games.view.a.c.c(this.cWN.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ag.D(this.cWK.left), ag.D(this.cWK.f1010top), ag.D(this.cWK.realWidth), ag.D(this.cWK.realHeight)))) {
            if (this.cWJ != null) {
                this.cWJ.onLoad();
            }
        } else if (this.cWJ != null) {
            this.cWJ.onError("3010000");
        }
    }

    private void loadAd() {
        com.baidu.swan.apps.runtime.e apM = com.baidu.swan.apps.runtime.e.apM();
        String str = "";
        if (apM != null) {
            str = apM.getAppKey();
        }
        com.baidu.swan.game.ad.c.c cVar = new com.baidu.swan.game.ad.c.c(this.mContext, new b.a().qI(this.cVN).qJ(this.cUK).qK(str).ip(this.cWK.width).iq(this.cWK.height).axA());
        com.baidu.swan.game.ad.c.a aVar = new com.baidu.swan.game.ad.c.a(this.mContext);
        aVar.a(this);
        com.baidu.swan.games.view.a.b.cE("banner", null);
        aVar.a(cVar, this.cWL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axL() {
        if (this.cWK != null) {
            if (ag.D(this.cWK.width) < 300) {
                this.cWK.width = ag.F(300.0f);
            }
            int aDM = com.baidu.swan.games.view.a.c.aDM();
            int aDN = com.baidu.swan.games.view.a.c.aDN();
            if (ag.D(this.cWK.width) > aDM) {
                this.cWK.width = ag.F(aDM);
            }
            this.cWK.height = (int) (this.cWK.width / com.baidu.swan.game.ad.e.d.cWn);
            if (this.cWK.left < 0) {
                this.cWK.left = 0;
            }
            int F = ag.F(aDM) - this.cWK.width;
            if (this.cWK.left > F) {
                this.cWK.left = F;
            }
            if (this.cWK.f1010top < 0) {
                this.cWK.f1010top = 0;
            }
            int F2 = ag.F(aDN) - this.cWK.height;
            if (this.cWK.f1010top > F2) {
                this.cWK.f1010top = F2;
            }
            this.cWK.realWidth = this.cWK.width;
            this.cWK.realHeight = this.cWK.height;
        }
    }
}
