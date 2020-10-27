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
    private AdElementInfo dFO;
    public String dFk;
    private a.InterfaceC0503a dFn;
    private String dHO;
    private boolean dHj;
    private String dHs;
    private i dIM;
    public f dIN;
    private com.baidu.swan.game.ad.a dIO;
    private boolean dIP;
    private g dIQ;
    private Context mContext = AppRuntime.getAppContext();
    private b dFH = new b(this.mContext);

    public e(String str, String str2, f fVar, a.InterfaceC0503a interfaceC0503a, boolean z) {
        this.dIN = null;
        this.dHs = str;
        this.dFk = str2;
        this.dIN = fVar;
        this.dFn = interfaceC0503a;
        this.dHj = z;
        aOT();
        loadAd();
    }

    public void a(i iVar) {
        this.dIM = iVar;
    }

    public void c(JsObject jsObject) {
        final l e = l.e(com.baidu.swan.games.binding.model.c.e(jsObject));
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.1
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.dIO != null && com.baidu.swan.games.view.a.c.aJ(e.this.dIO.getConvertView())) {
                    e.this.dIO.show();
                    if (e != null) {
                        e.aPo();
                    }
                    if (!e.this.dIP) {
                        e.this.dIP = true;
                        if (e.this.dHj) {
                            com.baidu.swan.game.ad.c.d.a(e.this.dFO, e.this.dFH);
                            return;
                        }
                        com.baidu.swan.game.ad.c.c.a(e.this.dFO, e.this.dFH);
                        com.baidu.swan.game.ad.c.c.a(e.this.dHs, e.this.dFk, e.this.dHO, e.this.dFH);
                        return;
                    }
                    return;
                }
                if (e != null) {
                    e.vD("3010010");
                }
                if (e.this.dIM != null) {
                    e.this.dIM.onError("3010010");
                }
            }
        });
    }

    public void aOP() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.2
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.dIO != null) {
                    e.this.dIO.hide();
                }
            }
        });
    }

    public void aOQ() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.3
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.dIO != null) {
                    com.baidu.swan.games.view.a.c.removeView(e.this.dIO.getConvertView());
                }
                e.this.dIO = null;
                e.this.dIM = null;
                e.this.dFO = null;
                if (e.this.dIQ != null) {
                    e.this.dIQ.release();
                    e.this.dIQ = null;
                }
            }
        });
    }

    public void vA(final String str) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z = e.this.dIN.width != e.this.dIN.realWidth;
                e.this.aOT();
                if (e.this.dIO != null) {
                    e.this.dIO.lA(e.this.dIN.width);
                    com.baidu.swan.games.view.a.c.b(e.this.dIO.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ah.L(e.this.dIN.left), ah.L(e.this.dIN.top), ah.L(e.this.dIN.realWidth), ah.L(e.this.dIN.realHeight)));
                }
                if (str.equals("width") && z && e.this.dIM != null) {
                    e.this.dIM.a(e.this.dIN);
                }
            }
        });
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void a(AdElementInfo adElementInfo) {
        this.dFO = adElementInfo;
        aOS();
        com.baidu.swan.games.view.a.b.dn(this.dHj ? "gdtbanner" : "banner", "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void vo(String str) {
        if (this.dIM != null) {
            this.dIM.onError(str);
        }
        com.baidu.swan.apps.runtime.e aEU = com.baidu.swan.apps.runtime.e.aEU();
        String str2 = "";
        if (aEU != null) {
            str2 = aEU.id;
        }
        if (str2.lastIndexOf("_dev") >= 0 && str2.lastIndexOf("_dev") < str2.length() && str.equals("201000")) {
            aOR();
        }
        com.baidu.swan.games.view.a.b.ac(this.dHj ? "gdtbanner" : "banner", "fail", str);
    }

    private void aOR() {
        this.dIO = new com.baidu.swan.game.ad.a(this.mContext);
        this.dIO.lA(this.dIN.width);
        if (com.baidu.swan.games.view.a.c.aJ(this.dIO.getConvertView())) {
            com.baidu.swan.games.view.a.c.removeView(this.dIO.getConvertView());
        }
        com.baidu.swan.games.view.a.c.c(this.dIO.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ah.L(this.dIN.left), ah.L(this.dIN.top), ah.L(this.dIN.realWidth), ah.L(this.dIN.realHeight)));
        this.dIO.getConvertView().postDelayed(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.dIO != null && com.baidu.swan.games.view.a.c.aJ(e.this.dIO.getConvertView())) {
                    com.baidu.swan.games.view.a.c.removeView(e.this.dIO.getConvertView());
                }
            }
        }, 20000L);
    }

    private void aOS() {
        this.dIO = new com.baidu.swan.game.ad.a(this.mContext, this.dFO, this.dFk, this.dHj);
        this.dIO.a(this.dFn);
        if (this.dHj) {
            this.dIO.a(new a.d() { // from class: com.baidu.swan.game.ad.e.e.6
                @Override // com.baidu.swan.game.ad.a.a.d
                public void aG(View view) {
                    if (e.this.dHj) {
                        e.this.aH(view);
                        com.baidu.swan.games.view.a.b.dn("gdtbanner", "click");
                    }
                }

                @Override // com.baidu.swan.game.ad.a.a.d
                public void cO(String str, String str2) {
                }
            });
        } else {
            this.dIO.a(new a.InterfaceC0504a() { // from class: com.baidu.swan.game.ad.e.e.7
                @Override // com.baidu.swan.game.ad.a.a.InterfaceC0504a
                public void a(CommandType commandType, Uri uri) {
                    com.baidu.swan.apps.core.d.f adm = com.baidu.swan.apps.v.f.axo().adm();
                    if (adm == null) {
                        if (e.this.mContext != null) {
                            com.baidu.swan.apps.res.widget.b.d.k(e.this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
                        }
                    } else if (e.this.dFO != null) {
                        String aOe = e.this.dFO.aOe();
                        adm.mM("adLanding").al(com.baidu.swan.apps.core.d.f.cEZ, com.baidu.swan.apps.core.d.f.cFb).a("adLanding", com.baidu.swan.apps.model.b.cb(aOe, aOe)).amM();
                        com.baidu.swan.game.ad.c.c.d(e.this.dFO, e.this.dFH);
                    }
                }
            });
        }
        this.dIO.lA(this.dIN.width);
        if (com.baidu.swan.games.view.a.c.aJ(this.dIO.getConvertView())) {
            com.baidu.swan.games.view.a.c.removeView(this.dIO.getConvertView());
        }
        if (com.baidu.swan.games.view.a.c.c(this.dIO.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ah.L(this.dIN.left), ah.L(this.dIN.top), ah.L(this.dIN.realWidth), ah.L(this.dIN.realHeight)))) {
            if (this.dIM != null) {
                this.dIM.onLoad();
            }
        } else if (this.dIM != null) {
            this.dIM.onError("3010000");
        }
    }

    private void loadAd() {
        com.baidu.swan.game.ad.b.d cVar;
        com.baidu.swan.apps.runtime.e aEU = com.baidu.swan.apps.runtime.e.aEU();
        String str = "";
        if (aEU != null) {
            str = aEU.getAppKey();
        }
        com.baidu.swan.game.ad.b.b aOv = new b.a().vu(this.dHs).vv(this.dFk).vw(str).lF(this.dIN.width).lG(this.dIN.height).aOv();
        if (this.dHj) {
            cVar = new com.baidu.swan.game.ad.b.e(this.mContext, aOv, 1, aOU());
            com.baidu.swan.games.view.a.b.dn("gdtbanner", null);
        } else {
            cVar = new com.baidu.swan.game.ad.b.c(this.mContext, aOv);
            this.dHO = cVar.aOA();
            com.baidu.swan.games.view.a.b.dn("banner", null);
        }
        com.baidu.swan.game.ad.b.a aVar = new com.baidu.swan.game.ad.b.a(this.mContext, this.dHj);
        aVar.a(this);
        aVar.a(cVar, this.dFH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOT() {
        if (this.dIN != null) {
            if (ah.L(this.dIN.width) < 300) {
                this.dIN.width = ah.N(300.0f);
            }
            int aVI = com.baidu.swan.games.view.a.c.aVI();
            int aVJ = com.baidu.swan.games.view.a.c.aVJ();
            if (ah.L(this.dIN.width) > aVI) {
                this.dIN.width = ah.N(aVI);
            }
            this.dIN.height = (int) (this.dIN.width / com.baidu.swan.game.ad.d.d.dIp);
            if (this.dIN.left < 0) {
                this.dIN.left = 0;
            }
            int N = ah.N(aVI) - this.dIN.width;
            if (this.dIN.left > N) {
                this.dIN.left = N;
            }
            if (this.dIN.top < 0) {
                this.dIN.top = 0;
            }
            int N2 = ah.N(aVJ) - this.dIN.height;
            if (this.dIN.top > N2) {
                this.dIN.top = N2;
            }
            this.dIN.realWidth = this.dIN.width;
            this.dIN.realHeight = this.dIN.height;
        }
    }

    private int aOU() {
        if (this.dIN == null) {
            return 2;
        }
        int N = ah.N(com.baidu.swan.games.view.a.c.aVJ());
        if (this.dIN.top < N / 3) {
            return 1;
        }
        return this.dIN.top < (N / 3) * 2 ? 4 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(View view) {
        if (this.dHj && this.dFO != null && this.dIN != null && view != null) {
            com.baidu.swan.game.ad.c.d.d(this.dFO, this.dFH);
            com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
            bVar.dHW = String.valueOf(this.dIN.width);
            bVar.dHX = String.valueOf(this.dIN.height);
            bVar.dHY = String.valueOf(this.dIN.width);
            bVar.dHZ = String.valueOf(this.dIN.height);
            bVar.dIa = String.valueOf((int) view.getX());
            bVar.dIb = String.valueOf((int) view.getY());
            bVar.dIc = String.valueOf((int) view.getX());
            bVar.dId = String.valueOf((int) view.getY());
            if (this.dFO.getActionType() == 2) {
                com.baidu.swan.game.ad.c.d.a(bVar, this.dFO, this.dFH, new a.d() { // from class: com.baidu.swan.game.ad.e.e.8
                    @Override // com.baidu.swan.game.ad.a.a.d
                    public void aG(View view2) {
                    }

                    @Override // com.baidu.swan.game.ad.a.a.d
                    public void cO(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("url", str2);
                                if (e.this.dIQ == null) {
                                    e.this.dIQ = new g(e.this.mContext, e.this.dFO, e.this.dFH);
                                }
                                e.this.dIQ.qO(str);
                                com.baidu.swan.apps.t.a.auk().a(e.this.mContext, jSONObject, SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, e.this.dIQ);
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
            com.baidu.swan.apps.core.d.f adm = com.baidu.swan.apps.v.f.axo().adm();
            if (adm == null) {
                if (this.mContext != null) {
                    com.baidu.swan.apps.res.widget.b.d.k(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
                }
            } else if (this.dFO != null) {
                String a2 = com.baidu.swan.game.ad.c.d.a(this.dFO.aOe(), bVar);
                adm.mM("adLanding").al(com.baidu.swan.apps.core.d.f.cEZ, com.baidu.swan.apps.core.d.f.cFb).a("adLanding", com.baidu.swan.apps.model.b.cb(a2, a2)).amM();
            }
        }
    }
}
