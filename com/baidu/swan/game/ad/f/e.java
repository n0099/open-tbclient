package com.baidu.swan.game.ad.f;

import android.content.Context;
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
public class e implements a.InterfaceC0378a {
    public String cFQ;
    private a.InterfaceC0377a cFS;
    private String cGT;
    private h cHP;
    public f cHQ;
    private AdElementInfo cHS;
    private com.baidu.swan.game.ad.a cHT;
    private boolean cHU;
    private Context mContext = AppRuntime.getAppContext();
    private b cHR = new b(this.mContext);

    public e(String str, String str2, f fVar, a.InterfaceC0377a interfaceC0377a) {
        this.cHQ = null;
        this.cGT = str;
        this.cFQ = str2;
        this.cHQ = fVar;
        this.cFS = interfaceC0377a;
        asY();
        loadAd();
    }

    public void a(h hVar) {
        this.cHP = hVar;
    }

    public void a(JsObject jsObject) {
        final k e = k.e(com.baidu.swan.games.binding.model.c.c(jsObject));
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.1
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.cHT != null && com.baidu.swan.games.view.a.c.az(e.this.cHT.getConvertView())) {
                    e.this.cHT.show();
                    if (e != null) {
                        e.ath();
                    }
                    if (!e.this.cHU) {
                        e.this.cHU = true;
                        com.baidu.swan.game.ad.d.a.a(e.this.cHS, e.this.cHR);
                        return;
                    }
                    return;
                }
                if (e != null) {
                    e.pk("3010010");
                }
                if (e.this.cHP != null) {
                    e.this.cHP.onError("3010010");
                }
            }
        });
    }

    public void asU() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.2
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.cHT != null) {
                    e.this.cHT.hide();
                }
            }
        });
    }

    public void asV() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.3
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.cHT != null) {
                    com.baidu.swan.games.view.a.c.av(e.this.cHT.getConvertView());
                }
                e.this.cHT = null;
                e.this.cHP = null;
                e.this.cHS = null;
            }
        });
    }

    public void pi(final String str) {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z = e.this.cHQ.width != e.this.cHQ.realWidth;
                e.this.asY();
                if (e.this.cHT != null) {
                    e.this.cHT.hI(e.this.cHQ.width);
                    com.baidu.swan.games.view.a.c.b(e.this.cHT.getConvertView(), new com.baidu.swan.apps.model.a.a.a(af.C(e.this.cHQ.left), af.C(e.this.cHQ.f1007top), af.C(e.this.cHQ.realWidth), af.C(e.this.cHQ.realHeight)));
                }
                if (str.equals("width") && z && e.this.cHP != null) {
                    e.this.cHP.a(e.this.cHQ);
                }
            }
        });
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0378a
    public void b(AdElementInfo adElementInfo) {
        this.cHS = adElementInfo;
        asX();
        com.baidu.swan.games.view.a.b.ch("banner", "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0378a
    public void oW(String str) {
        if (this.cHP != null) {
            this.cHP.onError(str);
        }
        com.baidu.swan.apps.runtime.e akM = com.baidu.swan.apps.runtime.e.akM();
        String str2 = "";
        if (akM != null) {
            str2 = akM.id;
        }
        if (str2.lastIndexOf("_dev") >= 0 && str2.lastIndexOf("_dev") < str2.length() && str.equals("201000")) {
            asW();
        }
        com.baidu.swan.games.view.a.b.N("banner", "fail", str);
    }

    private void asW() {
        this.cHT = new com.baidu.swan.game.ad.a(this.mContext);
        this.cHT.hI(this.cHQ.width);
        if (com.baidu.swan.games.view.a.c.az(this.cHT.getConvertView())) {
            com.baidu.swan.games.view.a.c.av(this.cHT.getConvertView());
        }
        com.baidu.swan.games.view.a.c.c(this.cHT.getConvertView(), new com.baidu.swan.apps.model.a.a.a(af.C(this.cHQ.left), af.C(this.cHQ.f1007top), af.C(this.cHQ.realWidth), af.C(this.cHQ.realHeight)));
        this.cHT.getConvertView().postDelayed(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.cHT != null && com.baidu.swan.games.view.a.c.az(e.this.cHT.getConvertView())) {
                    com.baidu.swan.games.view.a.c.av(e.this.cHT.getConvertView());
                }
            }
        }, 20000L);
    }

    private void asX() {
        this.cHT = new com.baidu.swan.game.ad.a(this.mContext, this.cHS, this.cFQ);
        this.cHT.a(this.cFS);
        this.cHT.a(new a.c() { // from class: com.baidu.swan.game.ad.f.e.6
            @Override // com.baidu.swan.game.ad.a.a.c
            public void pK() {
                com.baidu.swan.apps.core.d.e Ot = com.baidu.swan.apps.y.f.aeJ().Ot();
                if (Ot == null) {
                    if (e.this.mContext != null) {
                        com.baidu.swan.apps.res.widget.b.d.k(e.this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
                    }
                } else if (e.this.cHS != null) {
                    String asz = e.this.cHS.asz();
                    Ot.io("adLanding").ab(com.baidu.swan.apps.core.d.e.bME, com.baidu.swan.apps.core.d.e.bMG).a("adLanding", com.baidu.swan.apps.model.b.bg(asz, asz)).Wp();
                    com.baidu.swan.game.ad.d.a.b(e.this.cHS, e.this.cHR);
                }
            }
        });
        this.cHT.hI(this.cHQ.width);
        if (com.baidu.swan.games.view.a.c.az(this.cHT.getConvertView())) {
            com.baidu.swan.games.view.a.c.av(this.cHT.getConvertView());
        }
        if (com.baidu.swan.games.view.a.c.c(this.cHT.getConvertView(), new com.baidu.swan.apps.model.a.a.a(af.C(this.cHQ.left), af.C(this.cHQ.f1007top), af.C(this.cHQ.realWidth), af.C(this.cHQ.realHeight)))) {
            if (this.cHP != null) {
                this.cHP.onLoad();
            }
        } else if (this.cHP != null) {
            this.cHP.onError("3010000");
        }
    }

    private void loadAd() {
        com.baidu.swan.apps.runtime.e akM = com.baidu.swan.apps.runtime.e.akM();
        String str = "";
        if (akM != null) {
            str = akM.getAppKey();
        }
        com.baidu.swan.game.ad.c.c cVar = new com.baidu.swan.game.ad.c.c(this.mContext, new b.a().pc(this.cGT).pd(this.cFQ).pe(str).hL(this.cHQ.width).hM(this.cHQ.height).asN());
        com.baidu.swan.game.ad.c.a aVar = new com.baidu.swan.game.ad.c.a(this.mContext);
        aVar.a(this);
        com.baidu.swan.games.view.a.b.ch("banner", null);
        aVar.a(cVar, this.cHR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asY() {
        if (this.cHQ != null) {
            if (af.C(this.cHQ.width) < 300) {
                this.cHQ.width = af.E(300.0f);
            }
            int ayO = com.baidu.swan.games.view.a.c.ayO();
            int ayP = com.baidu.swan.games.view.a.c.ayP();
            if (af.C(this.cHQ.width) > ayO) {
                this.cHQ.width = af.E(ayO);
            }
            this.cHQ.height = (int) (this.cHQ.width / com.baidu.swan.game.ad.e.d.cHt);
            if (this.cHQ.left < 0) {
                this.cHQ.left = 0;
            }
            int E = af.E(ayO) - this.cHQ.width;
            if (this.cHQ.left > E) {
                this.cHQ.left = E;
            }
            if (this.cHQ.f1007top < 0) {
                this.cHQ.f1007top = 0;
            }
            int E2 = af.E(ayP) - this.cHQ.height;
            if (this.cHQ.f1007top > E2) {
                this.cHQ.f1007top = E2;
            }
            this.cHQ.realWidth = this.cHQ.width;
            this.cHQ.realHeight = this.cHQ.height;
        }
    }
}
