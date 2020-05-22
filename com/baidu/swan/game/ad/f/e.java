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
public class e implements a.InterfaceC0418a {
    public String cQa;
    private a.InterfaceC0417a cQc;
    private h cRZ;
    private String cRd;
    public f cSa;
    private AdElementInfo cSc;
    private com.baidu.swan.game.ad.a cSd;
    private boolean cSe;
    private Context mContext = AppRuntime.getAppContext();
    private b cSb = new b(this.mContext);

    public e(String str, String str2, f fVar, a.InterfaceC0417a interfaceC0417a) {
        this.cSa = null;
        this.cRd = str;
        this.cQa = str2;
        this.cSa = fVar;
        this.cQc = interfaceC0417a;
        awF();
        loadAd();
    }

    public void a(h hVar) {
        this.cRZ = hVar;
    }

    public void c(JsObject jsObject) {
        final k e = k.e(com.baidu.swan.games.binding.model.c.e(jsObject));
        aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.1
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.cSd != null && com.baidu.swan.games.view.a.c.ay(e.this.cSd.getConvertView())) {
                    e.this.cSd.show();
                    if (e != null) {
                        e.awO();
                    }
                    if (!e.this.cSe) {
                        e.this.cSe = true;
                        com.baidu.swan.game.ad.d.a.a(e.this.cSc, e.this.cSb);
                        return;
                    }
                    return;
                }
                if (e != null) {
                    e.qI("3010010");
                }
                if (e.this.cRZ != null) {
                    e.this.cRZ.onError("3010010");
                }
            }
        });
    }

    public void awB() {
        aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.2
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.cSd != null) {
                    e.this.cSd.hide();
                }
            }
        });
    }

    public void awC() {
        aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.3
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.cSd != null) {
                    com.baidu.swan.games.view.a.c.av(e.this.cSd.getConvertView());
                }
                e.this.cSd = null;
                e.this.cRZ = null;
                e.this.cSc = null;
            }
        });
    }

    public void qG(final String str) {
        aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z = e.this.cSa.width != e.this.cSa.realWidth;
                e.this.awF();
                if (e.this.cSd != null) {
                    e.this.cSd.hZ(e.this.cSa.width);
                    com.baidu.swan.games.view.a.c.b(e.this.cSd.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ag.B(e.this.cSa.left), ag.B(e.this.cSa.f1006top), ag.B(e.this.cSa.realWidth), ag.B(e.this.cSa.realHeight)));
                }
                if (str.equals("width") && z && e.this.cRZ != null) {
                    e.this.cRZ.a(e.this.cSa);
                }
            }
        });
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0418a
    public void b(AdElementInfo adElementInfo) {
        this.cSc = adElementInfo;
        awE();
        com.baidu.swan.games.view.a.b.cC("banner", "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0418a
    public void qu(String str) {
        if (this.cRZ != null) {
            this.cRZ.onError(str);
        }
        com.baidu.swan.apps.runtime.e aoF = com.baidu.swan.apps.runtime.e.aoF();
        String str2 = "";
        if (aoF != null) {
            str2 = aoF.id;
        }
        if (str2.lastIndexOf("_dev") >= 0 && str2.lastIndexOf("_dev") < str2.length() && str.equals("201000")) {
            awD();
        }
        com.baidu.swan.games.view.a.b.Q("banner", "fail", str);
    }

    private void awD() {
        this.cSd = new com.baidu.swan.game.ad.a(this.mContext);
        this.cSd.hZ(this.cSa.width);
        if (com.baidu.swan.games.view.a.c.ay(this.cSd.getConvertView())) {
            com.baidu.swan.games.view.a.c.av(this.cSd.getConvertView());
        }
        com.baidu.swan.games.view.a.c.c(this.cSd.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ag.B(this.cSa.left), ag.B(this.cSa.f1006top), ag.B(this.cSa.realWidth), ag.B(this.cSa.realHeight)));
        this.cSd.getConvertView().postDelayed(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.cSd != null && com.baidu.swan.games.view.a.c.ay(e.this.cSd.getConvertView())) {
                    com.baidu.swan.games.view.a.c.av(e.this.cSd.getConvertView());
                }
            }
        }, 20000L);
    }

    private void awE() {
        this.cSd = new com.baidu.swan.game.ad.a(this.mContext, this.cSc, this.cQa);
        this.cSd.a(this.cQc);
        this.cSd.a(new a.c() { // from class: com.baidu.swan.game.ad.f.e.6
            @Override // com.baidu.swan.game.ad.a.a.c
            public void pQ() {
                com.baidu.swan.apps.core.d.e QH = com.baidu.swan.apps.w.f.ahV().QH();
                if (QH == null) {
                    if (e.this.mContext != null) {
                        com.baidu.swan.apps.res.widget.b.d.k(e.this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
                    }
                } else if (e.this.cSc != null) {
                    String awg = e.this.cSc.awg();
                    QH.jp("adLanding").ae(com.baidu.swan.apps.core.d.e.bVN, com.baidu.swan.apps.core.d.e.bVP).a("adLanding", com.baidu.swan.apps.model.b.bx(awg, awg)).Zb();
                    com.baidu.swan.game.ad.d.a.b(e.this.cSc, e.this.cSb);
                }
            }
        });
        this.cSd.hZ(this.cSa.width);
        if (com.baidu.swan.games.view.a.c.ay(this.cSd.getConvertView())) {
            com.baidu.swan.games.view.a.c.av(this.cSd.getConvertView());
        }
        if (com.baidu.swan.games.view.a.c.c(this.cSd.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ag.B(this.cSa.left), ag.B(this.cSa.f1006top), ag.B(this.cSa.realWidth), ag.B(this.cSa.realHeight)))) {
            if (this.cRZ != null) {
                this.cRZ.onLoad();
            }
        } else if (this.cRZ != null) {
            this.cRZ.onError("3010000");
        }
    }

    private void loadAd() {
        com.baidu.swan.apps.runtime.e aoF = com.baidu.swan.apps.runtime.e.aoF();
        String str = "";
        if (aoF != null) {
            str = aoF.getAppKey();
        }
        com.baidu.swan.game.ad.c.c cVar = new com.baidu.swan.game.ad.c.c(this.mContext, new b.a().qA(this.cRd).qB(this.cQa).qC(str).ic(this.cSa.width).id(this.cSa.height).awu());
        com.baidu.swan.game.ad.c.a aVar = new com.baidu.swan.game.ad.c.a(this.mContext);
        aVar.a(this);
        com.baidu.swan.games.view.a.b.cC("banner", null);
        aVar.a(cVar, this.cSb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awF() {
        if (this.cSa != null) {
            if (ag.B(this.cSa.width) < 300) {
                this.cSa.width = ag.D(300.0f);
            }
            int aCG = com.baidu.swan.games.view.a.c.aCG();
            int aCH = com.baidu.swan.games.view.a.c.aCH();
            if (ag.B(this.cSa.width) > aCG) {
                this.cSa.width = ag.D(aCG);
            }
            this.cSa.height = (int) (this.cSa.width / com.baidu.swan.game.ad.e.d.cRD);
            if (this.cSa.left < 0) {
                this.cSa.left = 0;
            }
            int D = ag.D(aCG) - this.cSa.width;
            if (this.cSa.left > D) {
                this.cSa.left = D;
            }
            if (this.cSa.f1006top < 0) {
                this.cSa.f1006top = 0;
            }
            int D2 = ag.D(aCH) - this.cSa.height;
            if (this.cSa.f1006top > D2) {
                this.cSa.f1006top = D2;
            }
            this.cSa.realWidth = this.cSa.width;
            this.cSa.realHeight = this.cSa.height;
        }
    }
}
