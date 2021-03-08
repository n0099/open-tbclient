package com.baidu.swan.game.ad.e;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.game.ad.a;
import com.baidu.swan.game.ad.a.a;
import com.baidu.swan.game.ad.b.b;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.jsbridge.CommandType;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e implements a.b {
    private AdElementInfo dYQ;
    public String dYk;
    private a.InterfaceC0504a dYn;
    private String eaO;
    private boolean eaj;
    private String eas;
    private i ebN;
    public f ebO;
    private com.baidu.swan.game.ad.a ebP;
    private boolean ebQ;
    private g ebR;
    private Context mContext = AppRuntime.getAppContext();
    private b dYJ = new b(this.mContext);

    public e(String str, String str2, f fVar, a.InterfaceC0504a interfaceC0504a, boolean z) {
        this.ebO = null;
        this.eas = str;
        this.dYk = str2;
        this.ebO = fVar;
        this.dYn = interfaceC0504a;
        this.eaj = z;
        aSG();
        loadAd();
    }

    public void a(i iVar) {
        this.ebN = iVar;
    }

    public void c(JsObject jsObject) {
        final l e = l.e(com.baidu.swan.games.binding.model.c.e(jsObject));
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.1
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.ebP != null && com.baidu.swan.games.view.a.c.aU(e.this.ebP.getConvertView())) {
                    e.this.ebP.show();
                    if (e != null) {
                        e.aTb();
                    }
                    if (!e.this.ebQ) {
                        e.this.ebQ = true;
                        if (e.this.eaj) {
                            com.baidu.swan.game.ad.c.d.a(e.this.dYQ, e.this.dYJ);
                            return;
                        }
                        com.baidu.swan.game.ad.c.c.a(e.this.dYQ, e.this.dYJ);
                        com.baidu.swan.game.ad.c.c.a(e.this.eas, e.this.dYk, e.this.eaO, e.this.dYJ);
                        return;
                    }
                    return;
                }
                if (e != null) {
                    e.vH("3010010");
                }
                if (e.this.ebN != null) {
                    e.this.ebN.onError("3010010");
                }
            }
        });
    }

    public void aSC() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.2
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.ebP != null) {
                    e.this.ebP.hide();
                }
            }
        });
    }

    public void aSD() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.3
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.ebP != null) {
                    com.baidu.swan.games.view.a.c.removeView(e.this.ebP.getConvertView());
                }
                e.this.ebP = null;
                e.this.ebN = null;
                e.this.dYQ = null;
                if (e.this.ebR != null) {
                    e.this.ebR.release();
                    e.this.ebR = null;
                }
            }
        });
    }

    public void vE(final String str) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z = e.this.ebO.width != e.this.ebO.realWidth;
                e.this.aSG();
                if (e.this.ebP != null) {
                    e.this.ebP.kK(e.this.ebO.width);
                    com.baidu.swan.games.view.a.c.b(e.this.ebP.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ah.T(e.this.ebO.left), ah.T(e.this.ebO.top), ah.T(e.this.ebO.realWidth), ah.T(e.this.ebO.realHeight)));
                }
                if (str.equals("width") && z && e.this.ebN != null) {
                    e.this.ebN.a(e.this.ebO);
                }
            }
        });
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void a(AdElementInfo adElementInfo) {
        this.dYQ = adElementInfo;
        aSF();
        com.baidu.swan.games.view.a.b.dl(this.eaj ? "gdtbanner" : "banner", "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void vs(String str) {
        if (this.ebN != null) {
            this.ebN.onError(str);
        }
        com.baidu.swan.apps.runtime.e aIN = com.baidu.swan.apps.runtime.e.aIN();
        String str2 = "";
        if (aIN != null) {
            str2 = aIN.id;
        }
        if (str2.lastIndexOf("_dev") >= 0 && str2.lastIndexOf("_dev") < str2.length() && str.equals("201000")) {
            aSE();
        }
        com.baidu.swan.games.view.a.b.ai(this.eaj ? "gdtbanner" : "banner", com.baidu.pass.biometrics.face.liveness.c.a.p, str);
    }

    private void aSE() {
        this.ebP = new com.baidu.swan.game.ad.a(this.mContext);
        this.ebP.kK(this.ebO.width);
        if (com.baidu.swan.games.view.a.c.aU(this.ebP.getConvertView())) {
            com.baidu.swan.games.view.a.c.removeView(this.ebP.getConvertView());
        }
        com.baidu.swan.games.view.a.c.c(this.ebP.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ah.T(this.ebO.left), ah.T(this.ebO.top), ah.T(this.ebO.realWidth), ah.T(this.ebO.realHeight)));
        this.ebP.getConvertView().postDelayed(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.ebP != null && com.baidu.swan.games.view.a.c.aU(e.this.ebP.getConvertView())) {
                    com.baidu.swan.games.view.a.c.removeView(e.this.ebP.getConvertView());
                }
            }
        }, 20000L);
    }

    private void aSF() {
        this.ebP = new com.baidu.swan.game.ad.a(this.mContext, this.dYQ, this.dYk, this.eaj);
        this.ebP.a(this.dYn);
        if (this.eaj) {
            this.ebP.a(new a.d() { // from class: com.baidu.swan.game.ad.e.e.6
                @Override // com.baidu.swan.game.ad.a.a.d
                public void aR(View view) {
                    if (e.this.eaj) {
                        e.this.aS(view);
                        com.baidu.swan.games.view.a.b.dl("gdtbanner", "click");
                    }
                }

                @Override // com.baidu.swan.game.ad.a.a.d
                public void cM(String str, String str2) {
                }
            });
        } else {
            this.ebP.a(new a.InterfaceC0505a() { // from class: com.baidu.swan.game.ad.e.e.7
                @Override // com.baidu.swan.game.ad.a.a.InterfaceC0505a
                public void a(CommandType commandType, Uri uri) {
                    com.baidu.swan.apps.core.d.f aga = com.baidu.swan.apps.v.f.aAo().aga();
                    if (aga == null) {
                        if (e.this.mContext != null) {
                            com.baidu.swan.apps.res.widget.b.d.u(e.this.mContext, a.h.aiapps_open_fragment_failed_toast).aIv();
                        }
                    } else if (e.this.dYQ != null) {
                        String aRU = e.this.dYQ.aRU();
                        aga.mJ("adLanding").af(com.baidu.swan.apps.core.d.f.cTZ, com.baidu.swan.apps.core.d.f.cUb).a("adLanding", com.baidu.swan.apps.model.b.bZ(aRU, aRU)).apL();
                        com.baidu.swan.game.ad.c.c.d(e.this.dYQ, e.this.dYJ);
                    }
                }
            });
        }
        this.ebP.kK(this.ebO.width);
        if (com.baidu.swan.games.view.a.c.aU(this.ebP.getConvertView())) {
            com.baidu.swan.games.view.a.c.removeView(this.ebP.getConvertView());
        }
        if (com.baidu.swan.games.view.a.c.c(this.ebP.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ah.T(this.ebO.left), ah.T(this.ebO.top), ah.T(this.ebO.realWidth), ah.T(this.ebO.realHeight)))) {
            if (this.ebN != null) {
                this.ebN.onLoad();
            }
        } else if (this.ebN != null) {
            this.ebN.onError("3010000");
        }
    }

    private void loadAd() {
        com.baidu.swan.game.ad.b.d cVar;
        com.baidu.swan.apps.runtime.e aIN = com.baidu.swan.apps.runtime.e.aIN();
        String str = "";
        if (aIN != null) {
            str = aIN.getAppKey();
        }
        com.baidu.swan.game.ad.b.b aSi = new b.a().vy(this.eas).vz(this.dYk).vA(str).kP(this.ebO.width).kQ(this.ebO.height).aSi();
        if (this.eaj) {
            cVar = new com.baidu.swan.game.ad.b.e(this.mContext, aSi, 1, aSH());
            com.baidu.swan.games.view.a.b.dl("gdtbanner", null);
        } else {
            cVar = new com.baidu.swan.game.ad.b.c(this.mContext, aSi);
            this.eaO = cVar.aSn();
            com.baidu.swan.games.view.a.b.dl("banner", null);
        }
        com.baidu.swan.game.ad.b.a aVar = new com.baidu.swan.game.ad.b.a(this.mContext, this.eaj);
        aVar.a(this);
        aVar.a(cVar, this.dYJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSG() {
        if (this.ebO != null) {
            if (ah.T(this.ebO.width) < 300) {
                this.ebO.width = ah.V(300.0f);
            }
            int aZt = com.baidu.swan.games.view.a.c.aZt();
            int aZu = com.baidu.swan.games.view.a.c.aZu();
            if (ah.T(this.ebO.width) > aZt) {
                this.ebO.width = ah.V(aZt);
            }
            this.ebO.height = (int) (this.ebO.width / com.baidu.swan.game.ad.d.d.ebq);
            if (this.ebO.left < 0) {
                this.ebO.left = 0;
            }
            int V = ah.V(aZt) - this.ebO.width;
            if (this.ebO.left > V) {
                this.ebO.left = V;
            }
            if (this.ebO.top < 0) {
                this.ebO.top = 0;
            }
            int V2 = ah.V(aZu) - this.ebO.height;
            if (this.ebO.top > V2) {
                this.ebO.top = V2;
            }
            this.ebO.realWidth = this.ebO.width;
            this.ebO.realHeight = this.ebO.height;
        }
    }

    private int aSH() {
        if (this.ebO == null) {
            return 2;
        }
        int V = ah.V(com.baidu.swan.games.view.a.c.aZu());
        if (this.ebO.top < V / 3) {
            return 1;
        }
        return this.ebO.top < (V / 3) * 2 ? 4 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(View view) {
        if (this.eaj && this.dYQ != null && this.ebO != null && view != null) {
            com.baidu.swan.game.ad.c.d.d(this.dYQ, this.dYJ);
            com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
            bVar.eaX = String.valueOf(this.ebO.width);
            bVar.eaY = String.valueOf(this.ebO.height);
            bVar.eaZ = String.valueOf(this.ebO.width);
            bVar.eba = String.valueOf(this.ebO.height);
            bVar.ebb = String.valueOf((int) view.getX());
            bVar.ebc = String.valueOf((int) view.getY());
            bVar.ebd = String.valueOf((int) view.getX());
            bVar.ebe = String.valueOf((int) view.getY());
            if (this.dYQ.getActionType() == 2) {
                com.baidu.swan.game.ad.c.d.a(bVar, this.dYQ, this.dYJ, new a.d() { // from class: com.baidu.swan.game.ad.e.e.8
                    @Override // com.baidu.swan.game.ad.a.a.d
                    public void aR(View view2) {
                    }

                    @Override // com.baidu.swan.game.ad.a.a.d
                    public void cM(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("url", str2);
                                if (e.this.ebR == null) {
                                    e.this.ebR = new g(e.this.mContext, e.this.dYQ, e.this.dYJ);
                                }
                                e.this.ebR.qK(str);
                                com.baidu.swan.apps.t.a.axj().a(e.this.mContext, jSONObject, SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, e.this.ebR);
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
            com.baidu.swan.apps.core.d.f aga = com.baidu.swan.apps.v.f.aAo().aga();
            if (aga == null) {
                if (this.mContext != null) {
                    com.baidu.swan.apps.res.widget.b.d.u(this.mContext, a.h.aiapps_open_fragment_failed_toast).aIv();
                }
            } else if (this.dYQ != null) {
                String a2 = com.baidu.swan.game.ad.c.d.a(this.dYQ.aRU(), bVar);
                aga.mJ("adLanding").af(com.baidu.swan.apps.core.d.f.cTZ, com.baidu.swan.apps.core.d.f.cUb).a("adLanding", com.baidu.swan.apps.model.b.bZ(a2, a2)).apL();
            }
        }
    }
}
