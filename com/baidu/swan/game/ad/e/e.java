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
/* loaded from: classes3.dex */
public class e implements a.b {
    private AdElementInfo dZT;
    public String dZp;
    private a.InterfaceC0518a dZs;
    private String ebS;
    private boolean ebn;
    private String ebw;
    private i ecR;
    public f ecS;
    private com.baidu.swan.game.ad.a ecT;
    private boolean ecU;
    private g ecV;
    private Context mContext = AppRuntime.getAppContext();
    private b dZM = new b(this.mContext);

    public e(String str, String str2, f fVar, a.InterfaceC0518a interfaceC0518a, boolean z) {
        this.ecS = null;
        this.ebw = str;
        this.dZp = str2;
        this.ecS = fVar;
        this.dZs = interfaceC0518a;
        this.ebn = z;
        aWk();
        loadAd();
    }

    public void a(i iVar) {
        this.ecR = iVar;
    }

    public void c(JsObject jsObject) {
        final l e = l.e(com.baidu.swan.games.binding.model.c.e(jsObject));
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.1
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.ecT != null && com.baidu.swan.games.view.a.c.aY(e.this.ecT.getConvertView())) {
                    e.this.ecT.show();
                    if (e != null) {
                        e.aWF();
                    }
                    if (!e.this.ecU) {
                        e.this.ecU = true;
                        if (e.this.ebn) {
                            com.baidu.swan.game.ad.c.d.a(e.this.dZT, e.this.dZM);
                            return;
                        }
                        com.baidu.swan.game.ad.c.c.a(e.this.dZT, e.this.dZM);
                        com.baidu.swan.game.ad.c.c.a(e.this.ebw, e.this.dZp, e.this.ebS, e.this.dZM);
                        return;
                    }
                    return;
                }
                if (e != null) {
                    e.ws("3010010");
                }
                if (e.this.ecR != null) {
                    e.this.ecR.onError("3010010");
                }
            }
        });
    }

    public void aWg() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.2
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.ecT != null) {
                    e.this.ecT.hide();
                }
            }
        });
    }

    public void aWh() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.3
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.ecT != null) {
                    com.baidu.swan.games.view.a.c.removeView(e.this.ecT.getConvertView());
                }
                e.this.ecT = null;
                e.this.ecR = null;
                e.this.dZT = null;
                if (e.this.ecV != null) {
                    e.this.ecV.release();
                    e.this.ecV = null;
                }
            }
        });
    }

    public void wp(final String str) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z = e.this.ecS.width != e.this.ecS.realWidth;
                e.this.aWk();
                if (e.this.ecT != null) {
                    e.this.ecT.mm(e.this.ecS.width);
                    com.baidu.swan.games.view.a.c.b(e.this.ecT.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ah.O(e.this.ecS.left), ah.O(e.this.ecS.top), ah.O(e.this.ecS.realWidth), ah.O(e.this.ecS.realHeight)));
                }
                if (str.equals("width") && z && e.this.ecR != null) {
                    e.this.ecR.a(e.this.ecS);
                }
            }
        });
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void a(AdElementInfo adElementInfo) {
        this.dZT = adElementInfo;
        aWj();
        com.baidu.swan.games.view.a.b.ds(this.ebn ? "gdtbanner" : "banner", "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void wd(String str) {
        if (this.ecR != null) {
            this.ecR.onError(str);
        }
        com.baidu.swan.apps.runtime.e aMk = com.baidu.swan.apps.runtime.e.aMk();
        String str2 = "";
        if (aMk != null) {
            str2 = aMk.id;
        }
        if (str2.lastIndexOf("_dev") >= 0 && str2.lastIndexOf("_dev") < str2.length() && str.equals("201000")) {
            aWi();
        }
        com.baidu.swan.games.view.a.b.ai(this.ebn ? "gdtbanner" : "banner", com.baidu.pass.biometrics.face.liveness.c.a.p, str);
    }

    private void aWi() {
        this.ecT = new com.baidu.swan.game.ad.a(this.mContext);
        this.ecT.mm(this.ecS.width);
        if (com.baidu.swan.games.view.a.c.aY(this.ecT.getConvertView())) {
            com.baidu.swan.games.view.a.c.removeView(this.ecT.getConvertView());
        }
        com.baidu.swan.games.view.a.c.c(this.ecT.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ah.O(this.ecS.left), ah.O(this.ecS.top), ah.O(this.ecS.realWidth), ah.O(this.ecS.realHeight)));
        this.ecT.getConvertView().postDelayed(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.ecT != null && com.baidu.swan.games.view.a.c.aY(e.this.ecT.getConvertView())) {
                    com.baidu.swan.games.view.a.c.removeView(e.this.ecT.getConvertView());
                }
            }
        }, 20000L);
    }

    private void aWj() {
        this.ecT = new com.baidu.swan.game.ad.a(this.mContext, this.dZT, this.dZp, this.ebn);
        this.ecT.a(this.dZs);
        if (this.ebn) {
            this.ecT.a(new a.d() { // from class: com.baidu.swan.game.ad.e.e.6
                @Override // com.baidu.swan.game.ad.a.a.d
                public void aV(View view) {
                    if (e.this.ebn) {
                        e.this.aW(view);
                        com.baidu.swan.games.view.a.b.ds("gdtbanner", "click");
                    }
                }

                @Override // com.baidu.swan.game.ad.a.a.d
                public void cT(String str, String str2) {
                }
            });
        } else {
            this.ecT.a(new a.InterfaceC0519a() { // from class: com.baidu.swan.game.ad.e.e.7
                @Override // com.baidu.swan.game.ad.a.a.InterfaceC0519a
                public void a(CommandType commandType, Uri uri) {
                    com.baidu.swan.apps.core.d.f ajs = com.baidu.swan.apps.v.f.aDG().ajs();
                    if (ajs == null) {
                        if (e.this.mContext != null) {
                            com.baidu.swan.apps.res.widget.b.d.u(e.this.mContext, a.h.aiapps_open_fragment_failed_toast).aLS();
                        }
                    } else if (e.this.dZT != null) {
                        String aVv = e.this.dZT.aVv();
                        ajs.nv("adLanding").ai(com.baidu.swan.apps.core.d.f.cUY, com.baidu.swan.apps.core.d.f.cVa).a("adLanding", com.baidu.swan.apps.model.b.cg(aVv, aVv)).ate();
                        com.baidu.swan.game.ad.c.c.d(e.this.dZT, e.this.dZM);
                    }
                }
            });
        }
        this.ecT.mm(this.ecS.width);
        if (com.baidu.swan.games.view.a.c.aY(this.ecT.getConvertView())) {
            com.baidu.swan.games.view.a.c.removeView(this.ecT.getConvertView());
        }
        if (com.baidu.swan.games.view.a.c.c(this.ecT.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ah.O(this.ecS.left), ah.O(this.ecS.top), ah.O(this.ecS.realWidth), ah.O(this.ecS.realHeight)))) {
            if (this.ecR != null) {
                this.ecR.onLoad();
            }
        } else if (this.ecR != null) {
            this.ecR.onError("3010000");
        }
    }

    private void loadAd() {
        com.baidu.swan.game.ad.b.d cVar;
        com.baidu.swan.apps.runtime.e aMk = com.baidu.swan.apps.runtime.e.aMk();
        String str = "";
        if (aMk != null) {
            str = aMk.getAppKey();
        }
        com.baidu.swan.game.ad.b.b aVM = new b.a().wj(this.ebw).wk(this.dZp).wl(str).mr(this.ecS.width).ms(this.ecS.height).aVM();
        if (this.ebn) {
            cVar = new com.baidu.swan.game.ad.b.e(this.mContext, aVM, 1, aWl());
            com.baidu.swan.games.view.a.b.ds("gdtbanner", null);
        } else {
            cVar = new com.baidu.swan.game.ad.b.c(this.mContext, aVM);
            this.ebS = cVar.aVR();
            com.baidu.swan.games.view.a.b.ds("banner", null);
        }
        com.baidu.swan.game.ad.b.a aVar = new com.baidu.swan.game.ad.b.a(this.mContext, this.ebn);
        aVar.a(this);
        aVar.a(cVar, this.dZM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWk() {
        if (this.ecS != null) {
            if (ah.O(this.ecS.width) < 300) {
                this.ecS.width = ah.Q(300.0f);
            }
            int bcX = com.baidu.swan.games.view.a.c.bcX();
            int bcY = com.baidu.swan.games.view.a.c.bcY();
            if (ah.O(this.ecS.width) > bcX) {
                this.ecS.width = ah.Q(bcX);
            }
            this.ecS.height = (int) (this.ecS.width / com.baidu.swan.game.ad.d.d.ecu);
            if (this.ecS.left < 0) {
                this.ecS.left = 0;
            }
            int Q = ah.Q(bcX) - this.ecS.width;
            if (this.ecS.left > Q) {
                this.ecS.left = Q;
            }
            if (this.ecS.top < 0) {
                this.ecS.top = 0;
            }
            int Q2 = ah.Q(bcY) - this.ecS.height;
            if (this.ecS.top > Q2) {
                this.ecS.top = Q2;
            }
            this.ecS.realWidth = this.ecS.width;
            this.ecS.realHeight = this.ecS.height;
        }
    }

    private int aWl() {
        if (this.ecS == null) {
            return 2;
        }
        int Q = ah.Q(com.baidu.swan.games.view.a.c.bcY());
        if (this.ecS.top < Q / 3) {
            return 1;
        }
        return this.ecS.top < (Q / 3) * 2 ? 4 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aW(View view) {
        if (this.ebn && this.dZT != null && this.ecS != null && view != null) {
            com.baidu.swan.game.ad.c.d.d(this.dZT, this.dZM);
            com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
            bVar.ecb = String.valueOf(this.ecS.width);
            bVar.ecc = String.valueOf(this.ecS.height);
            bVar.ecd = String.valueOf(this.ecS.width);
            bVar.ece = String.valueOf(this.ecS.height);
            bVar.ecf = String.valueOf((int) view.getX());
            bVar.ecg = String.valueOf((int) view.getY());
            bVar.ech = String.valueOf((int) view.getX());
            bVar.eci = String.valueOf((int) view.getY());
            if (this.dZT.getActionType() == 2) {
                com.baidu.swan.game.ad.c.d.a(bVar, this.dZT, this.dZM, new a.d() { // from class: com.baidu.swan.game.ad.e.e.8
                    @Override // com.baidu.swan.game.ad.a.a.d
                    public void aV(View view2) {
                    }

                    @Override // com.baidu.swan.game.ad.a.a.d
                    public void cT(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("url", str2);
                                if (e.this.ecV == null) {
                                    e.this.ecV = new g(e.this.mContext, e.this.dZT, e.this.dZM);
                                }
                                e.this.ecV.rw(str);
                                com.baidu.swan.apps.t.a.aAB().a(e.this.mContext, jSONObject, SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, e.this.ecV);
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
            com.baidu.swan.apps.core.d.f ajs = com.baidu.swan.apps.v.f.aDG().ajs();
            if (ajs == null) {
                if (this.mContext != null) {
                    com.baidu.swan.apps.res.widget.b.d.u(this.mContext, a.h.aiapps_open_fragment_failed_toast).aLS();
                }
            } else if (this.dZT != null) {
                String a2 = com.baidu.swan.game.ad.c.d.a(this.dZT.aVv(), bVar);
                ajs.nv("adLanding").ai(com.baidu.swan.apps.core.d.f.cUY, com.baidu.swan.apps.core.d.f.cVa).a("adLanding", com.baidu.swan.apps.model.b.cg(a2, a2)).ate();
            }
        }
    }
}
