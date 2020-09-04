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
/* loaded from: classes19.dex */
public class e implements a.b {
    public String diF;
    private a.InterfaceC0477a diI;
    private AdElementInfo djj;
    private boolean dkE;
    private String dkN;
    private String dlj;
    private i dmi;
    public f dmj;
    private com.baidu.swan.game.ad.a dmk;
    private boolean dml;
    private g dmm;
    private Context mContext = AppRuntime.getAppContext();
    private b djc = new b(this.mContext);

    public e(String str, String str2, f fVar, a.InterfaceC0477a interfaceC0477a, boolean z) {
        this.dmj = null;
        this.dkN = str;
        this.diF = str2;
        this.dmj = fVar;
        this.diI = interfaceC0477a;
        this.dkE = z;
        aJF();
        loadAd();
    }

    public void a(i iVar) {
        this.dmi = iVar;
    }

    public void c(JsObject jsObject) {
        final l e = l.e(com.baidu.swan.games.binding.model.c.e(jsObject));
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.1
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.dmk != null && com.baidu.swan.games.view.a.c.aF(e.this.dmk.getConvertView())) {
                    e.this.dmk.show();
                    if (e != null) {
                        e.aKa();
                    }
                    if (!e.this.dml) {
                        e.this.dml = true;
                        if (e.this.dkE) {
                            com.baidu.swan.game.ad.c.d.a(e.this.djj, e.this.djc);
                            return;
                        }
                        com.baidu.swan.game.ad.c.c.a(e.this.djj, e.this.djc);
                        com.baidu.swan.game.ad.c.c.a(e.this.dkN, e.this.diF, e.this.dlj, e.this.djc);
                        return;
                    }
                    return;
                }
                if (e != null) {
                    e.uf("3010010");
                }
                if (e.this.dmi != null) {
                    e.this.dmi.onError("3010010");
                }
            }
        });
    }

    public void aJB() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.2
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.dmk != null) {
                    e.this.dmk.hide();
                }
            }
        });
    }

    public void aJC() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.3
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.dmk != null) {
                    com.baidu.swan.games.view.a.c.removeView(e.this.dmk.getConvertView());
                }
                e.this.dmk = null;
                e.this.dmi = null;
                e.this.djj = null;
                if (e.this.dmm != null) {
                    e.this.dmm.release();
                    e.this.dmm = null;
                }
            }
        });
    }

    public void uc(final String str) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z = e.this.dmj.width != e.this.dmj.realWidth;
                e.this.aJF();
                if (e.this.dmk != null) {
                    e.this.dmk.kH(e.this.dmj.width);
                    com.baidu.swan.games.view.a.c.b(e.this.dmk.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ah.H(e.this.dmj.left), ah.H(e.this.dmj.top), ah.H(e.this.dmj.realWidth), ah.H(e.this.dmj.realHeight)));
                }
                if (str.equals("width") && z && e.this.dmi != null) {
                    e.this.dmi.a(e.this.dmj);
                }
            }
        });
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void a(AdElementInfo adElementInfo) {
        this.djj = adElementInfo;
        aJE();
        com.baidu.swan.games.view.a.b.db(this.dkE ? "gdtbanner" : "banner", "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void tQ(String str) {
        if (this.dmi != null) {
            this.dmi.onError(str);
        }
        com.baidu.swan.apps.runtime.e azI = com.baidu.swan.apps.runtime.e.azI();
        String str2 = "";
        if (azI != null) {
            str2 = azI.id;
        }
        if (str2.lastIndexOf("_dev") >= 0 && str2.lastIndexOf("_dev") < str2.length() && str.equals("201000")) {
            aJD();
        }
        com.baidu.swan.games.view.a.b.U(this.dkE ? "gdtbanner" : "banner", "fail", str);
    }

    private void aJD() {
        this.dmk = new com.baidu.swan.game.ad.a(this.mContext);
        this.dmk.kH(this.dmj.width);
        if (com.baidu.swan.games.view.a.c.aF(this.dmk.getConvertView())) {
            com.baidu.swan.games.view.a.c.removeView(this.dmk.getConvertView());
        }
        com.baidu.swan.games.view.a.c.c(this.dmk.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ah.H(this.dmj.left), ah.H(this.dmj.top), ah.H(this.dmj.realWidth), ah.H(this.dmj.realHeight)));
        this.dmk.getConvertView().postDelayed(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.dmk != null && com.baidu.swan.games.view.a.c.aF(e.this.dmk.getConvertView())) {
                    com.baidu.swan.games.view.a.c.removeView(e.this.dmk.getConvertView());
                }
            }
        }, 20000L);
    }

    private void aJE() {
        this.dmk = new com.baidu.swan.game.ad.a(this.mContext, this.djj, this.diF, this.dkE);
        this.dmk.a(this.diI);
        if (this.dkE) {
            this.dmk.a(new a.d() { // from class: com.baidu.swan.game.ad.e.e.6
                @Override // com.baidu.swan.game.ad.a.a.d
                public void aC(View view) {
                    if (e.this.dkE) {
                        e.this.aD(view);
                        com.baidu.swan.games.view.a.b.db("gdtbanner", "click");
                    }
                }

                @Override // com.baidu.swan.game.ad.a.a.d
                public void cC(String str, String str2) {
                }
            });
        } else {
            this.dmk.a(new a.InterfaceC0478a() { // from class: com.baidu.swan.game.ad.e.e.7
                @Override // com.baidu.swan.game.ad.a.a.InterfaceC0478a
                public void a(CommandType commandType, Uri uri) {
                    com.baidu.swan.apps.core.d.f XX = com.baidu.swan.apps.v.f.arY().XX();
                    if (XX == null) {
                        if (e.this.mContext != null) {
                            com.baidu.swan.apps.res.widget.b.d.k(e.this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
                        }
                    } else if (e.this.djj != null) {
                        String aIQ = e.this.djj.aIQ();
                        XX.lo("adLanding").al(com.baidu.swan.apps.core.d.f.cik, com.baidu.swan.apps.core.d.f.cim).a("adLanding", com.baidu.swan.apps.model.b.bP(aIQ, aIQ)).ahx();
                        com.baidu.swan.game.ad.c.c.d(e.this.djj, e.this.djc);
                    }
                }
            });
        }
        this.dmk.kH(this.dmj.width);
        if (com.baidu.swan.games.view.a.c.aF(this.dmk.getConvertView())) {
            com.baidu.swan.games.view.a.c.removeView(this.dmk.getConvertView());
        }
        if (com.baidu.swan.games.view.a.c.c(this.dmk.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ah.H(this.dmj.left), ah.H(this.dmj.top), ah.H(this.dmj.realWidth), ah.H(this.dmj.realHeight)))) {
            if (this.dmi != null) {
                this.dmi.onLoad();
            }
        } else if (this.dmi != null) {
            this.dmi.onError("3010000");
        }
    }

    private void loadAd() {
        com.baidu.swan.game.ad.b.d cVar;
        com.baidu.swan.apps.runtime.e azI = com.baidu.swan.apps.runtime.e.azI();
        String str = "";
        if (azI != null) {
            str = azI.getAppKey();
        }
        com.baidu.swan.game.ad.b.b aJh = new b.a().tW(this.dkN).tX(this.diF).tY(str).kM(this.dmj.width).kN(this.dmj.height).aJh();
        if (this.dkE) {
            cVar = new com.baidu.swan.game.ad.b.e(this.mContext, aJh, 1, aJG());
            com.baidu.swan.games.view.a.b.db("gdtbanner", null);
        } else {
            cVar = new com.baidu.swan.game.ad.b.c(this.mContext, aJh);
            this.dlj = cVar.aJm();
            com.baidu.swan.games.view.a.b.db("banner", null);
        }
        com.baidu.swan.game.ad.b.a aVar = new com.baidu.swan.game.ad.b.a(this.mContext, this.dkE);
        aVar.a(this);
        aVar.a(cVar, this.djc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJF() {
        if (this.dmj != null) {
            if (ah.H(this.dmj.width) < 300) {
                this.dmj.width = ah.J(300.0f);
            }
            int aQt = com.baidu.swan.games.view.a.c.aQt();
            int aQu = com.baidu.swan.games.view.a.c.aQu();
            if (ah.H(this.dmj.width) > aQt) {
                this.dmj.width = ah.J(aQt);
            }
            this.dmj.height = (int) (this.dmj.width / com.baidu.swan.game.ad.d.d.dlL);
            if (this.dmj.left < 0) {
                this.dmj.left = 0;
            }
            int J = ah.J(aQt) - this.dmj.width;
            if (this.dmj.left > J) {
                this.dmj.left = J;
            }
            if (this.dmj.top < 0) {
                this.dmj.top = 0;
            }
            int J2 = ah.J(aQu) - this.dmj.height;
            if (this.dmj.top > J2) {
                this.dmj.top = J2;
            }
            this.dmj.realWidth = this.dmj.width;
            this.dmj.realHeight = this.dmj.height;
        }
    }

    private int aJG() {
        if (this.dmj == null) {
            return 2;
        }
        int J = ah.J(com.baidu.swan.games.view.a.c.aQu());
        if (this.dmj.top < J / 3) {
            return 1;
        }
        return this.dmj.top < (J / 3) * 2 ? 4 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD(View view) {
        if (this.dkE && this.djj != null && this.dmj != null && view != null) {
            com.baidu.swan.game.ad.c.d.d(this.djj, this.djc);
            com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
            bVar.dlr = String.valueOf(this.dmj.width);
            bVar.dls = String.valueOf(this.dmj.height);
            bVar.dlt = String.valueOf(this.dmj.width);
            bVar.dlu = String.valueOf(this.dmj.height);
            bVar.dlv = String.valueOf((int) view.getX());
            bVar.dlw = String.valueOf((int) view.getY());
            bVar.dlx = String.valueOf((int) view.getX());
            bVar.dly = String.valueOf((int) view.getY());
            if (this.djj.getActionType() == 2) {
                com.baidu.swan.game.ad.c.d.a(bVar, this.djj, this.djc, new a.d() { // from class: com.baidu.swan.game.ad.e.e.8
                    @Override // com.baidu.swan.game.ad.a.a.d
                    public void aC(View view2) {
                    }

                    @Override // com.baidu.swan.game.ad.a.a.d
                    public void cC(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("url", str2);
                                if (e.this.dmm == null) {
                                    e.this.dmm = new g(e.this.mContext, e.this.djj, e.this.djc);
                                }
                                e.this.dmm.pq(str);
                                com.baidu.swan.apps.t.a.aoT().a(e.this.mContext, jSONObject, SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, e.this.dmm);
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
            com.baidu.swan.apps.core.d.f XX = com.baidu.swan.apps.v.f.arY().XX();
            if (XX == null) {
                if (this.mContext != null) {
                    com.baidu.swan.apps.res.widget.b.d.k(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
                }
            } else if (this.djj != null) {
                String a = com.baidu.swan.game.ad.c.d.a(this.djj.aIQ(), bVar);
                XX.lo("adLanding").al(com.baidu.swan.apps.core.d.f.cik, com.baidu.swan.apps.core.d.f.cim).a("adLanding", com.baidu.swan.apps.model.b.bP(a, a)).ahx();
            }
        }
    }
}
