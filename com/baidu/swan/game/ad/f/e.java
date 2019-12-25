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
/* loaded from: classes9.dex */
public class e implements a.InterfaceC0315a {
    public String cci;
    private a.InterfaceC0314a cck;
    private String cdo;
    private h cek;
    public f cel;
    private AdElementInfo cen;
    private com.baidu.swan.game.ad.a ceo;
    private boolean cep;
    private Context mContext = AppRuntime.getAppContext();
    private b cem = new b(this.mContext);

    public e(String str, String str2, f fVar, a.InterfaceC0314a interfaceC0314a) {
        this.cel = null;
        this.cdo = str;
        this.cci = str2;
        this.cel = fVar;
        this.cck = interfaceC0314a;
        aia();
        loadAd();
    }

    public void a(h hVar) {
        this.cek = hVar;
    }

    public void a(JsObject jsObject) {
        final k e = k.e(com.baidu.swan.games.binding.model.c.c(jsObject));
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.1
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.ceo != null && com.baidu.swan.games.view.a.c.au(e.this.ceo.getConvertView())) {
                    e.this.ceo.show();
                    if (e != null) {
                        e.aii();
                    }
                    if (!e.this.cep) {
                        e.this.cep = true;
                        com.baidu.swan.game.ad.d.a.a(e.this.cen, e.this.cem);
                        return;
                    }
                    return;
                }
                if (e != null) {
                    e.nE("3010010");
                }
                if (e.this.cek != null) {
                    e.this.cek.onError("3010010");
                }
            }
        });
    }

    public void ahW() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.2
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.ceo != null) {
                    e.this.ceo.hide();
                }
            }
        });
    }

    public void ahX() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.3
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.ceo != null) {
                    com.baidu.swan.games.view.a.c.aq(e.this.ceo.getConvertView());
                }
                e.this.ceo = null;
                e.this.cek = null;
                e.this.cen = null;
            }
        });
    }

    public void nC(final String str) {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z = e.this.cel.width != e.this.cel.realWidth;
                e.this.aia();
                if (e.this.ceo != null) {
                    e.this.ceo.hk(e.this.cel.width);
                    com.baidu.swan.games.view.a.c.b(e.this.ceo.getConvertView(), new com.baidu.swan.apps.model.a.a.a(af.T(e.this.cel.left), af.T(e.this.cel.top), af.T(e.this.cel.realWidth), af.T(e.this.cel.realHeight)));
                }
                if (str.equals("width") && z && e.this.cek != null) {
                    e.this.cek.a(e.this.cel);
                }
            }
        });
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0315a
    public void b(AdElementInfo adElementInfo) {
        this.cen = adElementInfo;
        ahZ();
        com.baidu.swan.games.view.a.b.bN("banner", "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0315a
    public void nq(String str) {
        if (this.cek != null) {
            this.cek.onError(str);
        }
        com.baidu.swan.apps.runtime.e ZS = com.baidu.swan.apps.runtime.e.ZS();
        String str2 = "";
        if (ZS != null) {
            str2 = ZS.id;
        }
        if (str2.lastIndexOf("_dev") >= 0 && str2.lastIndexOf("_dev") < str2.length() && str.equals("201000")) {
            ahY();
        }
        com.baidu.swan.games.view.a.b.M("banner", LivenessStat.TYPE_FACE_MATCH_FAIL, str);
    }

    private void ahY() {
        this.ceo = new com.baidu.swan.game.ad.a(this.mContext);
        this.ceo.hk(this.cel.width);
        if (com.baidu.swan.games.view.a.c.au(this.ceo.getConvertView())) {
            com.baidu.swan.games.view.a.c.aq(this.ceo.getConvertView());
        }
        com.baidu.swan.games.view.a.c.c(this.ceo.getConvertView(), new com.baidu.swan.apps.model.a.a.a(af.T(this.cel.left), af.T(this.cel.top), af.T(this.cel.realWidth), af.T(this.cel.realHeight)));
        this.ceo.getConvertView().postDelayed(new Runnable() { // from class: com.baidu.swan.game.ad.f.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.ceo != null && com.baidu.swan.games.view.a.c.au(e.this.ceo.getConvertView())) {
                    com.baidu.swan.games.view.a.c.aq(e.this.ceo.getConvertView());
                }
            }
        }, 20000L);
    }

    private void ahZ() {
        this.ceo = new com.baidu.swan.game.ad.a(this.mContext, this.cen, this.cci);
        this.ceo.a(this.cck);
        this.ceo.a(new a.c() { // from class: com.baidu.swan.game.ad.f.e.6
            @Override // com.baidu.swan.game.ad.a.a.c
            public void kQ() {
                com.baidu.swan.apps.core.d.e DP = com.baidu.swan.apps.y.f.Uf().DP();
                if (DP == null) {
                    if (e.this.mContext != null) {
                        com.baidu.swan.apps.res.widget.b.d.q(e.this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
                    }
                } else if (e.this.cen != null) {
                    String ahC = e.this.cen.ahC();
                    DP.gJ("adLanding").U(com.baidu.swan.apps.core.d.e.bjf, com.baidu.swan.apps.core.d.e.bjh).a("adLanding", com.baidu.swan.apps.model.b.aN(ahC, ahC)).LN();
                    com.baidu.swan.game.ad.d.a.b(e.this.cen, e.this.cem);
                }
            }
        });
        this.ceo.hk(this.cel.width);
        if (com.baidu.swan.games.view.a.c.au(this.ceo.getConvertView())) {
            com.baidu.swan.games.view.a.c.aq(this.ceo.getConvertView());
        }
        if (com.baidu.swan.games.view.a.c.c(this.ceo.getConvertView(), new com.baidu.swan.apps.model.a.a.a(af.T(this.cel.left), af.T(this.cel.top), af.T(this.cel.realWidth), af.T(this.cel.realHeight)))) {
            if (this.cek != null) {
                this.cek.onLoad();
            }
        } else if (this.cek != null) {
            this.cek.onError("3010000");
        }
    }

    private void loadAd() {
        com.baidu.swan.apps.runtime.e ZS = com.baidu.swan.apps.runtime.e.ZS();
        String str = "";
        if (ZS != null) {
            str = ZS.getAppKey();
        }
        com.baidu.swan.game.ad.c.c cVar = new com.baidu.swan.game.ad.c.c(this.mContext, new b.a().nw(this.cdo).nx(this.cci).ny(str).hn(this.cel.width).ho(this.cel.height).ahQ());
        com.baidu.swan.game.ad.c.a aVar = new com.baidu.swan.game.ad.c.a(this.mContext);
        aVar.a(this);
        com.baidu.swan.games.view.a.b.bN("banner", null);
        aVar.a(cVar, this.cem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aia() {
        if (this.cel != null) {
            if (af.T(this.cel.width) < 300) {
                this.cel.width = af.V(300.0f);
            }
            int anQ = com.baidu.swan.games.view.a.c.anQ();
            int anR = com.baidu.swan.games.view.a.c.anR();
            if (af.T(this.cel.width) > anQ) {
                this.cel.width = af.V(anQ);
            }
            this.cel.height = (int) (this.cel.width / com.baidu.swan.game.ad.e.d.cdO);
            if (this.cel.left < 0) {
                this.cel.left = 0;
            }
            int V = af.V(anQ) - this.cel.width;
            if (this.cel.left > V) {
                this.cel.left = V;
            }
            if (this.cel.top < 0) {
                this.cel.top = 0;
            }
            int V2 = af.V(anR) - this.cel.height;
            if (this.cel.top > V2) {
                this.cel.top = V2;
            }
            this.cel.realWidth = this.cel.width;
            this.cel.realHeight = this.cel.height;
        }
    }
}
