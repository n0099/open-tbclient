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
public class e implements a.InterfaceC0357a {
    public String cFK;
    private a.InterfaceC0356a cFM;
    private String cGN;
    private h cHJ;
    public f cHK;
    private AdElementInfo cHM;
    private com.baidu.swan.game.ad.a cHN;
    private boolean cHO;
    private Context mContext = AppRuntime.getAppContext();
    private b cHL = new b(this.mContext);

    public e(String str, String str2, f fVar, a.InterfaceC0356a interfaceC0356a) {
        this.cHK = null;
        this.cGN = str;
        this.cFK = str2;
        this.cHK = fVar;
        this.cFM = interfaceC0356a;
        asY();
        loadAd();
    }

    public void a(h hVar) {
        this.cHJ = hVar;
    }

    public void a(JsObject jsObject) {
        final k e = k.e(com.baidu.swan.games.binding.model.c.c(jsObject));
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.1
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.cHN != null && com.baidu.swan.games.view.a.c.az(e.this.cHN.getConvertView())) {
                    e.this.cHN.show();
                    if (e != null) {
                        e.ath();
                    }
                    if (!e.this.cHO) {
                        e.this.cHO = true;
                        com.baidu.swan.game.ad.d.a.a(e.this.cHM, e.this.cHL);
                        return;
                    }
                    return;
                }
                if (e != null) {
                    e.pk("3010010");
                }
                if (e.this.cHJ != null) {
                    e.this.cHJ.onError("3010010");
                }
            }
        });
    }

    public void asU() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.2
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.cHN != null) {
                    e.this.cHN.hide();
                }
            }
        });
    }

    public void asV() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.3
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.cHN != null) {
                    com.baidu.swan.games.view.a.c.av(e.this.cHN.getConvertView());
                }
                e.this.cHN = null;
                e.this.cHJ = null;
                e.this.cHM = null;
            }
        });
    }

    public void pi(final String str) {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z = e.this.cHK.width != e.this.cHK.realWidth;
                e.this.asY();
                if (e.this.cHN != null) {
                    e.this.cHN.hI(e.this.cHK.width);
                    com.baidu.swan.games.view.a.c.b(e.this.cHN.getConvertView(), new com.baidu.swan.apps.model.a.a.a(af.C(e.this.cHK.left), af.C(e.this.cHK.f1015top), af.C(e.this.cHK.realWidth), af.C(e.this.cHK.realHeight)));
                }
                if (str.equals("width") && z && e.this.cHJ != null) {
                    e.this.cHJ.a(e.this.cHK);
                }
            }
        });
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0357a
    public void b(AdElementInfo adElementInfo) {
        this.cHM = adElementInfo;
        asX();
        com.baidu.swan.games.view.a.b.ch("banner", "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0357a
    public void oW(String str) {
        if (this.cHJ != null) {
            this.cHJ.onError(str);
        }
        com.baidu.swan.apps.runtime.e akN = com.baidu.swan.apps.runtime.e.akN();
        String str2 = "";
        if (akN != null) {
            str2 = akN.id;
        }
        if (str2.lastIndexOf("_dev") >= 0 && str2.lastIndexOf("_dev") < str2.length() && str.equals("201000")) {
            asW();
        }
        com.baidu.swan.games.view.a.b.N("banner", "fail", str);
    }

    private void asW() {
        this.cHN = new com.baidu.swan.game.ad.a(this.mContext);
        this.cHN.hI(this.cHK.width);
        if (com.baidu.swan.games.view.a.c.az(this.cHN.getConvertView())) {
            com.baidu.swan.games.view.a.c.av(this.cHN.getConvertView());
        }
        com.baidu.swan.games.view.a.c.c(this.cHN.getConvertView(), new com.baidu.swan.apps.model.a.a.a(af.C(this.cHK.left), af.C(this.cHK.f1015top), af.C(this.cHK.realWidth), af.C(this.cHK.realHeight)));
        this.cHN.getConvertView().postDelayed(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.cHN != null && com.baidu.swan.games.view.a.c.az(e.this.cHN.getConvertView())) {
                    com.baidu.swan.games.view.a.c.av(e.this.cHN.getConvertView());
                }
            }
        }, 20000L);
    }

    private void asX() {
        this.cHN = new com.baidu.swan.game.ad.a(this.mContext, this.cHM, this.cFK);
        this.cHN.a(this.cFM);
        this.cHN.a(new a.c() { // from class: com.baidu.swan.game.ad.f.e.6
            @Override // com.baidu.swan.game.ad.a.a.c
            public void pK() {
                com.baidu.swan.apps.core.d.e Ou = com.baidu.swan.apps.y.f.aeK().Ou();
                if (Ou == null) {
                    if (e.this.mContext != null) {
                        com.baidu.swan.apps.res.widget.b.d.k(e.this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
                    }
                } else if (e.this.cHM != null) {
                    String asA = e.this.cHM.asA();
                    Ou.io("adLanding").ab(com.baidu.swan.apps.core.d.e.bMz, com.baidu.swan.apps.core.d.e.bMB).a("adLanding", com.baidu.swan.apps.model.b.bg(asA, asA)).Wq();
                    com.baidu.swan.game.ad.d.a.b(e.this.cHM, e.this.cHL);
                }
            }
        });
        this.cHN.hI(this.cHK.width);
        if (com.baidu.swan.games.view.a.c.az(this.cHN.getConvertView())) {
            com.baidu.swan.games.view.a.c.av(this.cHN.getConvertView());
        }
        if (com.baidu.swan.games.view.a.c.c(this.cHN.getConvertView(), new com.baidu.swan.apps.model.a.a.a(af.C(this.cHK.left), af.C(this.cHK.f1015top), af.C(this.cHK.realWidth), af.C(this.cHK.realHeight)))) {
            if (this.cHJ != null) {
                this.cHJ.onLoad();
            }
        } else if (this.cHJ != null) {
            this.cHJ.onError("3010000");
        }
    }

    private void loadAd() {
        com.baidu.swan.apps.runtime.e akN = com.baidu.swan.apps.runtime.e.akN();
        String str = "";
        if (akN != null) {
            str = akN.getAppKey();
        }
        com.baidu.swan.game.ad.c.c cVar = new com.baidu.swan.game.ad.c.c(this.mContext, new b.a().pc(this.cGN).pd(this.cFK).pe(str).hL(this.cHK.width).hM(this.cHK.height).asO());
        com.baidu.swan.game.ad.c.a aVar = new com.baidu.swan.game.ad.c.a(this.mContext);
        aVar.a(this);
        com.baidu.swan.games.view.a.b.ch("banner", null);
        aVar.a(cVar, this.cHL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asY() {
        if (this.cHK != null) {
            if (af.C(this.cHK.width) < 300) {
                this.cHK.width = af.E(300.0f);
            }
            int ayO = com.baidu.swan.games.view.a.c.ayO();
            int ayP = com.baidu.swan.games.view.a.c.ayP();
            if (af.C(this.cHK.width) > ayO) {
                this.cHK.width = af.E(ayO);
            }
            this.cHK.height = (int) (this.cHK.width / com.baidu.swan.game.ad.e.d.cHn);
            if (this.cHK.left < 0) {
                this.cHK.left = 0;
            }
            int E = af.E(ayO) - this.cHK.width;
            if (this.cHK.left > E) {
                this.cHK.left = E;
            }
            if (this.cHK.f1015top < 0) {
                this.cHK.f1015top = 0;
            }
            int E2 = af.E(ayP) - this.cHK.height;
            if (this.cHK.f1015top > E2) {
                this.cHK.f1015top = E2;
            }
            this.cHK.realWidth = this.cHK.width;
            this.cHK.realHeight = this.cHK.height;
        }
    }
}
