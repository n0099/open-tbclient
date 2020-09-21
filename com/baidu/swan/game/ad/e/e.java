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
/* loaded from: classes10.dex */
public class e implements a.b {
    public String dkH;
    private a.InterfaceC0472a dkK;
    private AdElementInfo dll;
    private boolean dmG;
    private String dmP;
    private String dnl;
    private i dol;
    public f dom;
    private com.baidu.swan.game.ad.a don;
    private boolean doo;
    private g dop;
    private Context mContext = AppRuntime.getAppContext();
    private b dle = new b(this.mContext);

    public e(String str, String str2, f fVar, a.InterfaceC0472a interfaceC0472a, boolean z) {
        this.dom = null;
        this.dmP = str;
        this.dkH = str2;
        this.dom = fVar;
        this.dkK = interfaceC0472a;
        this.dmG = z;
        aKq();
        loadAd();
    }

    public void a(i iVar) {
        this.dol = iVar;
    }

    public void c(JsObject jsObject) {
        final l e = l.e(com.baidu.swan.games.binding.model.c.e(jsObject));
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.1
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.don != null && com.baidu.swan.games.view.a.c.aH(e.this.don.getConvertView())) {
                    e.this.don.show();
                    if (e != null) {
                        e.aKL();
                    }
                    if (!e.this.doo) {
                        e.this.doo = true;
                        if (e.this.dmG) {
                            com.baidu.swan.game.ad.c.d.a(e.this.dll, e.this.dle);
                            return;
                        }
                        com.baidu.swan.game.ad.c.c.a(e.this.dll, e.this.dle);
                        com.baidu.swan.game.ad.c.c.a(e.this.dmP, e.this.dkH, e.this.dnl, e.this.dle);
                        return;
                    }
                    return;
                }
                if (e != null) {
                    e.uy("3010010");
                }
                if (e.this.dol != null) {
                    e.this.dol.onError("3010010");
                }
            }
        });
    }

    public void aKm() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.2
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.don != null) {
                    e.this.don.hide();
                }
            }
        });
    }

    public void aKn() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.3
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.don != null) {
                    com.baidu.swan.games.view.a.c.removeView(e.this.don.getConvertView());
                }
                e.this.don = null;
                e.this.dol = null;
                e.this.dll = null;
                if (e.this.dop != null) {
                    e.this.dop.release();
                    e.this.dop = null;
                }
            }
        });
    }

    public void uv(final String str) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z = e.this.dom.width != e.this.dom.realWidth;
                e.this.aKq();
                if (e.this.don != null) {
                    e.this.don.kS(e.this.dom.width);
                    com.baidu.swan.games.view.a.c.b(e.this.don.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ah.H(e.this.dom.left), ah.H(e.this.dom.top), ah.H(e.this.dom.realWidth), ah.H(e.this.dom.realHeight)));
                }
                if (str.equals("width") && z && e.this.dol != null) {
                    e.this.dol.a(e.this.dom);
                }
            }
        });
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void a(AdElementInfo adElementInfo) {
        this.dll = adElementInfo;
        aKp();
        com.baidu.swan.games.view.a.b.db(this.dmG ? "gdtbanner" : "banner", "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void uj(String str) {
        if (this.dol != null) {
            this.dol.onError(str);
        }
        com.baidu.swan.apps.runtime.e aAr = com.baidu.swan.apps.runtime.e.aAr();
        String str2 = "";
        if (aAr != null) {
            str2 = aAr.id;
        }
        if (str2.lastIndexOf("_dev") >= 0 && str2.lastIndexOf("_dev") < str2.length() && str.equals("201000")) {
            aKo();
        }
        com.baidu.swan.games.view.a.b.U(this.dmG ? "gdtbanner" : "banner", "fail", str);
    }

    private void aKo() {
        this.don = new com.baidu.swan.game.ad.a(this.mContext);
        this.don.kS(this.dom.width);
        if (com.baidu.swan.games.view.a.c.aH(this.don.getConvertView())) {
            com.baidu.swan.games.view.a.c.removeView(this.don.getConvertView());
        }
        com.baidu.swan.games.view.a.c.c(this.don.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ah.H(this.dom.left), ah.H(this.dom.top), ah.H(this.dom.realWidth), ah.H(this.dom.realHeight)));
        this.don.getConvertView().postDelayed(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.don != null && com.baidu.swan.games.view.a.c.aH(e.this.don.getConvertView())) {
                    com.baidu.swan.games.view.a.c.removeView(e.this.don.getConvertView());
                }
            }
        }, 20000L);
    }

    private void aKp() {
        this.don = new com.baidu.swan.game.ad.a(this.mContext, this.dll, this.dkH, this.dmG);
        this.don.a(this.dkK);
        if (this.dmG) {
            this.don.a(new a.d() { // from class: com.baidu.swan.game.ad.e.e.6
                @Override // com.baidu.swan.game.ad.a.a.d
                public void aE(View view) {
                    if (e.this.dmG) {
                        e.this.aF(view);
                        com.baidu.swan.games.view.a.b.db("gdtbanner", "click");
                    }
                }

                @Override // com.baidu.swan.game.ad.a.a.d
                public void cC(String str, String str2) {
                }
            });
        } else {
            this.don.a(new a.InterfaceC0473a() { // from class: com.baidu.swan.game.ad.e.e.7
                @Override // com.baidu.swan.game.ad.a.a.InterfaceC0473a
                public void a(CommandType commandType, Uri uri) {
                    com.baidu.swan.apps.core.d.f YG = com.baidu.swan.apps.v.f.asJ().YG();
                    if (YG == null) {
                        if (e.this.mContext != null) {
                            com.baidu.swan.apps.res.widget.b.d.k(e.this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
                        }
                    } else if (e.this.dll != null) {
                        String aJB = e.this.dll.aJB();
                        YG.lH("adLanding").al(com.baidu.swan.apps.core.d.f.ckl, com.baidu.swan.apps.core.d.f.ckn).a("adLanding", com.baidu.swan.apps.model.b.bP(aJB, aJB)).aih();
                        com.baidu.swan.game.ad.c.c.d(e.this.dll, e.this.dle);
                    }
                }
            });
        }
        this.don.kS(this.dom.width);
        if (com.baidu.swan.games.view.a.c.aH(this.don.getConvertView())) {
            com.baidu.swan.games.view.a.c.removeView(this.don.getConvertView());
        }
        if (com.baidu.swan.games.view.a.c.c(this.don.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ah.H(this.dom.left), ah.H(this.dom.top), ah.H(this.dom.realWidth), ah.H(this.dom.realHeight)))) {
            if (this.dol != null) {
                this.dol.onLoad();
            }
        } else if (this.dol != null) {
            this.dol.onError("3010000");
        }
    }

    private void loadAd() {
        com.baidu.swan.game.ad.b.d cVar;
        com.baidu.swan.apps.runtime.e aAr = com.baidu.swan.apps.runtime.e.aAr();
        String str = "";
        if (aAr != null) {
            str = aAr.getAppKey();
        }
        com.baidu.swan.game.ad.b.b aJS = new b.a().up(this.dmP).uq(this.dkH).ur(str).kX(this.dom.width).kY(this.dom.height).aJS();
        if (this.dmG) {
            cVar = new com.baidu.swan.game.ad.b.e(this.mContext, aJS, 1, aKr());
            com.baidu.swan.games.view.a.b.db("gdtbanner", null);
        } else {
            cVar = new com.baidu.swan.game.ad.b.c(this.mContext, aJS);
            this.dnl = cVar.aJX();
            com.baidu.swan.games.view.a.b.db("banner", null);
        }
        com.baidu.swan.game.ad.b.a aVar = new com.baidu.swan.game.ad.b.a(this.mContext, this.dmG);
        aVar.a(this);
        aVar.a(cVar, this.dle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKq() {
        if (this.dom != null) {
            if (ah.H(this.dom.width) < 300) {
                this.dom.width = ah.J(300.0f);
            }
            int aRf = com.baidu.swan.games.view.a.c.aRf();
            int aRg = com.baidu.swan.games.view.a.c.aRg();
            if (ah.H(this.dom.width) > aRf) {
                this.dom.width = ah.J(aRf);
            }
            this.dom.height = (int) (this.dom.width / com.baidu.swan.game.ad.d.d.dnN);
            if (this.dom.left < 0) {
                this.dom.left = 0;
            }
            int J = ah.J(aRf) - this.dom.width;
            if (this.dom.left > J) {
                this.dom.left = J;
            }
            if (this.dom.top < 0) {
                this.dom.top = 0;
            }
            int J2 = ah.J(aRg) - this.dom.height;
            if (this.dom.top > J2) {
                this.dom.top = J2;
            }
            this.dom.realWidth = this.dom.width;
            this.dom.realHeight = this.dom.height;
        }
    }

    private int aKr() {
        if (this.dom == null) {
            return 2;
        }
        int J = ah.J(com.baidu.swan.games.view.a.c.aRg());
        if (this.dom.top < J / 3) {
            return 1;
        }
        return this.dom.top < (J / 3) * 2 ? 4 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aF(View view) {
        if (this.dmG && this.dll != null && this.dom != null && view != null) {
            com.baidu.swan.game.ad.c.d.d(this.dll, this.dle);
            com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
            bVar.dnu = String.valueOf(this.dom.width);
            bVar.dnv = String.valueOf(this.dom.height);
            bVar.dnw = String.valueOf(this.dom.width);
            bVar.dnx = String.valueOf(this.dom.height);
            bVar.dny = String.valueOf((int) view.getX());
            bVar.dnz = String.valueOf((int) view.getY());
            bVar.dnA = String.valueOf((int) view.getX());
            bVar.dnB = String.valueOf((int) view.getY());
            if (this.dll.getActionType() == 2) {
                com.baidu.swan.game.ad.c.d.a(bVar, this.dll, this.dle, new a.d() { // from class: com.baidu.swan.game.ad.e.e.8
                    @Override // com.baidu.swan.game.ad.a.a.d
                    public void aE(View view2) {
                    }

                    @Override // com.baidu.swan.game.ad.a.a.d
                    public void cC(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("url", str2);
                                if (e.this.dop == null) {
                                    e.this.dop = new g(e.this.mContext, e.this.dll, e.this.dle);
                                }
                                e.this.dop.pJ(str);
                                com.baidu.swan.apps.t.a.apE().a(e.this.mContext, jSONObject, SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, e.this.dop);
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
            com.baidu.swan.apps.core.d.f YG = com.baidu.swan.apps.v.f.asJ().YG();
            if (YG == null) {
                if (this.mContext != null) {
                    com.baidu.swan.apps.res.widget.b.d.k(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
                }
            } else if (this.dll != null) {
                String a = com.baidu.swan.game.ad.c.d.a(this.dll.aJB(), bVar);
                YG.lH("adLanding").al(com.baidu.swan.apps.core.d.f.ckl, com.baidu.swan.apps.core.d.f.ckn).a("adLanding", com.baidu.swan.apps.model.b.bP(a, a)).aih();
            }
        }
    }
}
