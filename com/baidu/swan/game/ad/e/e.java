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
    public String diB;
    private a.InterfaceC0477a diE;
    private AdElementInfo djf;
    private boolean dkA;
    private String dkJ;
    private String dlf;
    private i dme;
    public f dmf;
    private com.baidu.swan.game.ad.a dmg;
    private boolean dmh;
    private g dmi;
    private Context mContext = AppRuntime.getAppContext();
    private b diY = new b(this.mContext);

    public e(String str, String str2, f fVar, a.InterfaceC0477a interfaceC0477a, boolean z) {
        this.dmf = null;
        this.dkJ = str;
        this.diB = str2;
        this.dmf = fVar;
        this.diE = interfaceC0477a;
        this.dkA = z;
        aJF();
        loadAd();
    }

    public void a(i iVar) {
        this.dme = iVar;
    }

    public void c(JsObject jsObject) {
        final l e = l.e(com.baidu.swan.games.binding.model.c.e(jsObject));
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.1
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.dmg != null && com.baidu.swan.games.view.a.c.aF(e.this.dmg.getConvertView())) {
                    e.this.dmg.show();
                    if (e != null) {
                        e.aKa();
                    }
                    if (!e.this.dmh) {
                        e.this.dmh = true;
                        if (e.this.dkA) {
                            com.baidu.swan.game.ad.c.d.a(e.this.djf, e.this.diY);
                            return;
                        }
                        com.baidu.swan.game.ad.c.c.a(e.this.djf, e.this.diY);
                        com.baidu.swan.game.ad.c.c.a(e.this.dkJ, e.this.diB, e.this.dlf, e.this.diY);
                        return;
                    }
                    return;
                }
                if (e != null) {
                    e.ue("3010010");
                }
                if (e.this.dme != null) {
                    e.this.dme.onError("3010010");
                }
            }
        });
    }

    public void aJB() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.2
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.dmg != null) {
                    e.this.dmg.hide();
                }
            }
        });
    }

    public void aJC() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.3
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.dmg != null) {
                    com.baidu.swan.games.view.a.c.removeView(e.this.dmg.getConvertView());
                }
                e.this.dmg = null;
                e.this.dme = null;
                e.this.djf = null;
                if (e.this.dmi != null) {
                    e.this.dmi.release();
                    e.this.dmi = null;
                }
            }
        });
    }

    public void ub(final String str) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z = e.this.dmf.width != e.this.dmf.realWidth;
                e.this.aJF();
                if (e.this.dmg != null) {
                    e.this.dmg.kH(e.this.dmf.width);
                    com.baidu.swan.games.view.a.c.b(e.this.dmg.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ah.H(e.this.dmf.left), ah.H(e.this.dmf.top), ah.H(e.this.dmf.realWidth), ah.H(e.this.dmf.realHeight)));
                }
                if (str.equals("width") && z && e.this.dme != null) {
                    e.this.dme.a(e.this.dmf);
                }
            }
        });
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void a(AdElementInfo adElementInfo) {
        this.djf = adElementInfo;
        aJE();
        com.baidu.swan.games.view.a.b.db(this.dkA ? "gdtbanner" : "banner", "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void tP(String str) {
        if (this.dme != null) {
            this.dme.onError(str);
        }
        com.baidu.swan.apps.runtime.e azI = com.baidu.swan.apps.runtime.e.azI();
        String str2 = "";
        if (azI != null) {
            str2 = azI.id;
        }
        if (str2.lastIndexOf("_dev") >= 0 && str2.lastIndexOf("_dev") < str2.length() && str.equals("201000")) {
            aJD();
        }
        com.baidu.swan.games.view.a.b.U(this.dkA ? "gdtbanner" : "banner", "fail", str);
    }

    private void aJD() {
        this.dmg = new com.baidu.swan.game.ad.a(this.mContext);
        this.dmg.kH(this.dmf.width);
        if (com.baidu.swan.games.view.a.c.aF(this.dmg.getConvertView())) {
            com.baidu.swan.games.view.a.c.removeView(this.dmg.getConvertView());
        }
        com.baidu.swan.games.view.a.c.c(this.dmg.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ah.H(this.dmf.left), ah.H(this.dmf.top), ah.H(this.dmf.realWidth), ah.H(this.dmf.realHeight)));
        this.dmg.getConvertView().postDelayed(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.dmg != null && com.baidu.swan.games.view.a.c.aF(e.this.dmg.getConvertView())) {
                    com.baidu.swan.games.view.a.c.removeView(e.this.dmg.getConvertView());
                }
            }
        }, 20000L);
    }

    private void aJE() {
        this.dmg = new com.baidu.swan.game.ad.a(this.mContext, this.djf, this.diB, this.dkA);
        this.dmg.a(this.diE);
        if (this.dkA) {
            this.dmg.a(new a.d() { // from class: com.baidu.swan.game.ad.e.e.6
                @Override // com.baidu.swan.game.ad.a.a.d
                public void aC(View view) {
                    if (e.this.dkA) {
                        e.this.aD(view);
                        com.baidu.swan.games.view.a.b.db("gdtbanner", "click");
                    }
                }

                @Override // com.baidu.swan.game.ad.a.a.d
                public void cC(String str, String str2) {
                }
            });
        } else {
            this.dmg.a(new a.InterfaceC0478a() { // from class: com.baidu.swan.game.ad.e.e.7
                @Override // com.baidu.swan.game.ad.a.a.InterfaceC0478a
                public void a(CommandType commandType, Uri uri) {
                    com.baidu.swan.apps.core.d.f XX = com.baidu.swan.apps.v.f.arY().XX();
                    if (XX == null) {
                        if (e.this.mContext != null) {
                            com.baidu.swan.apps.res.widget.b.d.k(e.this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
                        }
                    } else if (e.this.djf != null) {
                        String aIQ = e.this.djf.aIQ();
                        XX.ln("adLanding").al(com.baidu.swan.apps.core.d.f.cig, com.baidu.swan.apps.core.d.f.cii).a("adLanding", com.baidu.swan.apps.model.b.bP(aIQ, aIQ)).ahx();
                        com.baidu.swan.game.ad.c.c.d(e.this.djf, e.this.diY);
                    }
                }
            });
        }
        this.dmg.kH(this.dmf.width);
        if (com.baidu.swan.games.view.a.c.aF(this.dmg.getConvertView())) {
            com.baidu.swan.games.view.a.c.removeView(this.dmg.getConvertView());
        }
        if (com.baidu.swan.games.view.a.c.c(this.dmg.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ah.H(this.dmf.left), ah.H(this.dmf.top), ah.H(this.dmf.realWidth), ah.H(this.dmf.realHeight)))) {
            if (this.dme != null) {
                this.dme.onLoad();
            }
        } else if (this.dme != null) {
            this.dme.onError("3010000");
        }
    }

    private void loadAd() {
        com.baidu.swan.game.ad.b.d cVar;
        com.baidu.swan.apps.runtime.e azI = com.baidu.swan.apps.runtime.e.azI();
        String str = "";
        if (azI != null) {
            str = azI.getAppKey();
        }
        com.baidu.swan.game.ad.b.b aJh = new b.a().tV(this.dkJ).tW(this.diB).tX(str).kM(this.dmf.width).kN(this.dmf.height).aJh();
        if (this.dkA) {
            cVar = new com.baidu.swan.game.ad.b.e(this.mContext, aJh, 1, aJG());
            com.baidu.swan.games.view.a.b.db("gdtbanner", null);
        } else {
            cVar = new com.baidu.swan.game.ad.b.c(this.mContext, aJh);
            this.dlf = cVar.aJm();
            com.baidu.swan.games.view.a.b.db("banner", null);
        }
        com.baidu.swan.game.ad.b.a aVar = new com.baidu.swan.game.ad.b.a(this.mContext, this.dkA);
        aVar.a(this);
        aVar.a(cVar, this.diY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJF() {
        if (this.dmf != null) {
            if (ah.H(this.dmf.width) < 300) {
                this.dmf.width = ah.J(300.0f);
            }
            int aQt = com.baidu.swan.games.view.a.c.aQt();
            int aQu = com.baidu.swan.games.view.a.c.aQu();
            if (ah.H(this.dmf.width) > aQt) {
                this.dmf.width = ah.J(aQt);
            }
            this.dmf.height = (int) (this.dmf.width / com.baidu.swan.game.ad.d.d.dlH);
            if (this.dmf.left < 0) {
                this.dmf.left = 0;
            }
            int J = ah.J(aQt) - this.dmf.width;
            if (this.dmf.left > J) {
                this.dmf.left = J;
            }
            if (this.dmf.top < 0) {
                this.dmf.top = 0;
            }
            int J2 = ah.J(aQu) - this.dmf.height;
            if (this.dmf.top > J2) {
                this.dmf.top = J2;
            }
            this.dmf.realWidth = this.dmf.width;
            this.dmf.realHeight = this.dmf.height;
        }
    }

    private int aJG() {
        if (this.dmf == null) {
            return 2;
        }
        int J = ah.J(com.baidu.swan.games.view.a.c.aQu());
        if (this.dmf.top < J / 3) {
            return 1;
        }
        return this.dmf.top < (J / 3) * 2 ? 4 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD(View view) {
        if (this.dkA && this.djf != null && this.dmf != null && view != null) {
            com.baidu.swan.game.ad.c.d.d(this.djf, this.diY);
            com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
            bVar.dln = String.valueOf(this.dmf.width);
            bVar.dlo = String.valueOf(this.dmf.height);
            bVar.dlp = String.valueOf(this.dmf.width);
            bVar.dlq = String.valueOf(this.dmf.height);
            bVar.dlr = String.valueOf((int) view.getX());
            bVar.dls = String.valueOf((int) view.getY());
            bVar.dlt = String.valueOf((int) view.getX());
            bVar.dlu = String.valueOf((int) view.getY());
            if (this.djf.getActionType() == 2) {
                com.baidu.swan.game.ad.c.d.a(bVar, this.djf, this.diY, new a.d() { // from class: com.baidu.swan.game.ad.e.e.8
                    @Override // com.baidu.swan.game.ad.a.a.d
                    public void aC(View view2) {
                    }

                    @Override // com.baidu.swan.game.ad.a.a.d
                    public void cC(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("url", str2);
                                if (e.this.dmi == null) {
                                    e.this.dmi = new g(e.this.mContext, e.this.djf, e.this.diY);
                                }
                                e.this.dmi.pp(str);
                                com.baidu.swan.apps.t.a.aoT().a(e.this.mContext, jSONObject, SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, e.this.dmi);
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
            } else if (this.djf != null) {
                String a = com.baidu.swan.game.ad.c.d.a(this.djf.aIQ(), bVar);
                XX.ln("adLanding").al(com.baidu.swan.apps.core.d.f.cig, com.baidu.swan.apps.core.d.f.cii).a("adLanding", com.baidu.swan.apps.model.b.bP(a, a)).ahx();
            }
        }
    }
}
