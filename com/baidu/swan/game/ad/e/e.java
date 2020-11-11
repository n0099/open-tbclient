package com.baidu.swan.game.ad.e;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.game.ad.a;
import com.baidu.swan.game.ad.a.a;
import com.baidu.swan.game.ad.b.b;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.jsbridge.CommandType;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class e implements a.b {
    private AdElementInfo dLG;
    public String dLc;
    private a.InterfaceC0515a dLf;
    private String dNG;
    private boolean dNb;
    private String dNk;
    private i dOE;
    public f dOF;
    private com.baidu.swan.game.ad.a dOG;
    private boolean dOH;
    private g dOI;
    private Context mContext = AppRuntime.getAppContext();
    private b dLz = new b(this.mContext);

    public e(String str, String str2, f fVar, a.InterfaceC0515a interfaceC0515a, boolean z) {
        this.dOF = null;
        this.dNk = str;
        this.dLc = str2;
        this.dOF = fVar;
        this.dLf = interfaceC0515a;
        this.dNb = z;
        aRt();
        loadAd();
    }

    public void a(i iVar) {
        this.dOE = iVar;
    }

    public void c(JsObject jsObject) {
        final l e = l.e(com.baidu.swan.games.binding.model.c.e(jsObject));
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.1
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.dOG != null && com.baidu.swan.games.view.a.c.aN(e.this.dOG.getConvertView())) {
                    e.this.dOG.show();
                    if (e != null) {
                        e.aRO();
                    }
                    if (!e.this.dOH) {
                        e.this.dOH = true;
                        if (e.this.dNb) {
                            com.baidu.swan.game.ad.c.d.a(e.this.dLG, e.this.dLz);
                            return;
                        }
                        com.baidu.swan.game.ad.c.c.a(e.this.dLG, e.this.dLz);
                        com.baidu.swan.game.ad.c.c.a(e.this.dNk, e.this.dLc, e.this.dNG, e.this.dLz);
                        return;
                    }
                    return;
                }
                if (e != null) {
                    e.vR("3010010");
                }
                if (e.this.dOE != null) {
                    e.this.dOE.onError("3010010");
                }
            }
        });
    }

    public void aRp() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.2
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.dOG != null) {
                    e.this.dOG.hide();
                }
            }
        });
    }

    public void aRq() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.3
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.dOG != null) {
                    com.baidu.swan.games.view.a.c.removeView(e.this.dOG.getConvertView());
                }
                e.this.dOG = null;
                e.this.dOE = null;
                e.this.dLG = null;
                if (e.this.dOI != null) {
                    e.this.dOI.release();
                    e.this.dOI = null;
                }
            }
        });
    }

    public void vO(final String str) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z = e.this.dOF.width != e.this.dOF.realWidth;
                e.this.aRt();
                if (e.this.dOG != null) {
                    e.this.dOG.lK(e.this.dOF.width);
                    com.baidu.swan.games.view.a.c.b(e.this.dOG.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ah.N(e.this.dOF.left), ah.N(e.this.dOF.top), ah.N(e.this.dOF.realWidth), ah.N(e.this.dOF.realHeight)));
                }
                if (str.equals("width") && z && e.this.dOE != null) {
                    e.this.dOE.a(e.this.dOF);
                }
            }
        });
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void a(AdElementInfo adElementInfo) {
        this.dLG = adElementInfo;
        aRs();
        com.baidu.swan.games.view.a.b.dn(this.dNb ? "gdtbanner" : "banner", "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void vC(String str) {
        if (this.dOE != null) {
            this.dOE.onError(str);
        }
        com.baidu.swan.apps.runtime.e aHu = com.baidu.swan.apps.runtime.e.aHu();
        String str2 = "";
        if (aHu != null) {
            str2 = aHu.id;
        }
        if (str2.lastIndexOf("_dev") >= 0 && str2.lastIndexOf("_dev") < str2.length() && str.equals("201000")) {
            aRr();
        }
        com.baidu.swan.games.view.a.b.ac(this.dNb ? "gdtbanner" : "banner", "fail", str);
    }

    private void aRr() {
        this.dOG = new com.baidu.swan.game.ad.a(this.mContext);
        this.dOG.lK(this.dOF.width);
        if (com.baidu.swan.games.view.a.c.aN(this.dOG.getConvertView())) {
            com.baidu.swan.games.view.a.c.removeView(this.dOG.getConvertView());
        }
        com.baidu.swan.games.view.a.c.c(this.dOG.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ah.N(this.dOF.left), ah.N(this.dOF.top), ah.N(this.dOF.realWidth), ah.N(this.dOF.realHeight)));
        this.dOG.getConvertView().postDelayed(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.dOG != null && com.baidu.swan.games.view.a.c.aN(e.this.dOG.getConvertView())) {
                    com.baidu.swan.games.view.a.c.removeView(e.this.dOG.getConvertView());
                }
            }
        }, 20000L);
    }

    private void aRs() {
        this.dOG = new com.baidu.swan.game.ad.a(this.mContext, this.dLG, this.dLc, this.dNb);
        this.dOG.a(this.dLf);
        if (this.dNb) {
            this.dOG.a(new a.d() { // from class: com.baidu.swan.game.ad.e.e.6
                @Override // com.baidu.swan.game.ad.a.a.d
                public void aK(View view) {
                    if (e.this.dNb) {
                        e.this.aL(view);
                        com.baidu.swan.games.view.a.b.dn("gdtbanner", "click");
                    }
                }

                @Override // com.baidu.swan.game.ad.a.a.d
                public void cO(String str, String str2) {
                }
            });
        } else {
            this.dOG.a(new a.InterfaceC0516a() { // from class: com.baidu.swan.game.ad.e.e.7
                @Override // com.baidu.swan.game.ad.a.a.InterfaceC0516a
                public void a(CommandType commandType, Uri uri) {
                    com.baidu.swan.apps.core.d.f afM = com.baidu.swan.apps.v.f.azO().afM();
                    if (afM == null) {
                        if (e.this.mContext != null) {
                            com.baidu.swan.apps.res.widget.b.d.k(e.this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
                        }
                    } else if (e.this.dLG != null) {
                        String aQE = e.this.dLG.aQE();
                        afM.nb("adLanding").al(com.baidu.swan.apps.core.d.f.cKS, com.baidu.swan.apps.core.d.f.cKU).a("adLanding", com.baidu.swan.apps.model.b.cb(aQE, aQE)).apn();
                        com.baidu.swan.game.ad.c.c.d(e.this.dLG, e.this.dLz);
                    }
                }
            });
        }
        this.dOG.lK(this.dOF.width);
        if (com.baidu.swan.games.view.a.c.aN(this.dOG.getConvertView())) {
            com.baidu.swan.games.view.a.c.removeView(this.dOG.getConvertView());
        }
        if (com.baidu.swan.games.view.a.c.c(this.dOG.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ah.N(this.dOF.left), ah.N(this.dOF.top), ah.N(this.dOF.realWidth), ah.N(this.dOF.realHeight)))) {
            if (this.dOE != null) {
                this.dOE.onLoad();
            }
        } else if (this.dOE != null) {
            this.dOE.onError("3010000");
        }
    }

    private void loadAd() {
        com.baidu.swan.game.ad.b.d cVar;
        com.baidu.swan.apps.runtime.e aHu = com.baidu.swan.apps.runtime.e.aHu();
        String str = "";
        if (aHu != null) {
            str = aHu.getAppKey();
        }
        com.baidu.swan.game.ad.b.b aQV = new b.a().vI(this.dNk).vJ(this.dLc).vK(str).lP(this.dOF.width).lQ(this.dOF.height).aQV();
        if (this.dNb) {
            cVar = new com.baidu.swan.game.ad.b.e(this.mContext, aQV, 1, aRu());
            com.baidu.swan.games.view.a.b.dn("gdtbanner", null);
        } else {
            cVar = new com.baidu.swan.game.ad.b.c(this.mContext, aQV);
            this.dNG = cVar.aRa();
            com.baidu.swan.games.view.a.b.dn("banner", null);
        }
        com.baidu.swan.game.ad.b.a aVar = new com.baidu.swan.game.ad.b.a(this.mContext, this.dNb);
        aVar.a(this);
        aVar.a(cVar, this.dLz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRt() {
        if (this.dOF != null) {
            if (ah.N(this.dOF.width) < 300) {
                this.dOF.width = ah.P(300.0f);
            }
            int aYi = com.baidu.swan.games.view.a.c.aYi();
            int aYj = com.baidu.swan.games.view.a.c.aYj();
            if (ah.N(this.dOF.width) > aYi) {
                this.dOF.width = ah.P(aYi);
            }
            this.dOF.height = (int) (this.dOF.width / com.baidu.swan.game.ad.d.d.dOh);
            if (this.dOF.left < 0) {
                this.dOF.left = 0;
            }
            int P = ah.P(aYi) - this.dOF.width;
            if (this.dOF.left > P) {
                this.dOF.left = P;
            }
            if (this.dOF.top < 0) {
                this.dOF.top = 0;
            }
            int P2 = ah.P(aYj) - this.dOF.height;
            if (this.dOF.top > P2) {
                this.dOF.top = P2;
            }
            this.dOF.realWidth = this.dOF.width;
            this.dOF.realHeight = this.dOF.height;
        }
    }

    private int aRu() {
        if (this.dOF == null) {
            return 2;
        }
        int P = ah.P(com.baidu.swan.games.view.a.c.aYj());
        if (this.dOF.top < P / 3) {
            return 1;
        }
        return this.dOF.top < (P / 3) * 2 ? 4 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL(View view) {
        if (this.dNb && this.dLG != null && this.dOF != null && view != null) {
            com.baidu.swan.game.ad.c.d.d(this.dLG, this.dLz);
            com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
            bVar.dNO = String.valueOf(this.dOF.width);
            bVar.dNP = String.valueOf(this.dOF.height);
            bVar.dNQ = String.valueOf(this.dOF.width);
            bVar.dNR = String.valueOf(this.dOF.height);
            bVar.dNS = String.valueOf((int) view.getX());
            bVar.dNT = String.valueOf((int) view.getY());
            bVar.dNU = String.valueOf((int) view.getX());
            bVar.dNV = String.valueOf((int) view.getY());
            if (this.dLG.getActionType() == 2) {
                com.baidu.swan.game.ad.c.d.a(bVar, this.dLG, this.dLz, new a.d() { // from class: com.baidu.swan.game.ad.e.e.8
                    @Override // com.baidu.swan.game.ad.a.a.d
                    public void aK(View view2) {
                    }

                    @Override // com.baidu.swan.game.ad.a.a.d
                    public void cO(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("url", str2);
                                if (e.this.dOI == null) {
                                    e.this.dOI = new g(e.this.mContext, e.this.dLG, e.this.dLz);
                                }
                                e.this.dOI.rc(str);
                                com.baidu.swan.apps.t.a.awK().a(e.this.mContext, jSONObject, SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, e.this.dOI);
                            } catch (JSONException e) {
                                if (com.baidu.swan.apps.b.DEBUG) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                });
                return;
            }
            com.baidu.swan.apps.core.d.f afM = com.baidu.swan.apps.v.f.azO().afM();
            if (afM == null) {
                if (this.mContext != null) {
                    com.baidu.swan.apps.res.widget.b.d.k(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
                }
            } else if (this.dLG != null) {
                String a2 = com.baidu.swan.game.ad.c.d.a(this.dLG.aQE(), bVar);
                afM.nb("adLanding").al(com.baidu.swan.apps.core.d.f.cKS, com.baidu.swan.apps.core.d.f.cKU).a("adLanding", com.baidu.swan.apps.model.b.cb(a2, a2)).apn();
            }
        }
    }
}
