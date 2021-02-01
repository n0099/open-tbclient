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
    public String dWJ;
    private a.InterfaceC0498a dWM;
    private AdElementInfo dXp;
    private boolean dYI;
    private String dYQ;
    private String dZm;
    private i eal;
    public f eam;
    private com.baidu.swan.game.ad.a ean;
    private boolean eao;
    private g eaq;
    private Context mContext = AppRuntime.getAppContext();
    private b dXi = new b(this.mContext);

    public e(String str, String str2, f fVar, a.InterfaceC0498a interfaceC0498a, boolean z) {
        this.eam = null;
        this.dYQ = str;
        this.dWJ = str2;
        this.eam = fVar;
        this.dWM = interfaceC0498a;
        this.dYI = z;
        aSD();
        loadAd();
    }

    public void a(i iVar) {
        this.eal = iVar;
    }

    public void c(JsObject jsObject) {
        final l e = l.e(com.baidu.swan.games.binding.model.c.e(jsObject));
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.1
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.ean != null && com.baidu.swan.games.view.a.c.aU(e.this.ean.getConvertView())) {
                    e.this.ean.show();
                    if (e != null) {
                        e.aSY();
                    }
                    if (!e.this.eao) {
                        e.this.eao = true;
                        if (e.this.dYI) {
                            com.baidu.swan.game.ad.c.d.a(e.this.dXp, e.this.dXi);
                            return;
                        }
                        com.baidu.swan.game.ad.c.c.a(e.this.dXp, e.this.dXi);
                        com.baidu.swan.game.ad.c.c.a(e.this.dYQ, e.this.dWJ, e.this.dZm, e.this.dXi);
                        return;
                    }
                    return;
                }
                if (e != null) {
                    e.vA("3010010");
                }
                if (e.this.eal != null) {
                    e.this.eal.onError("3010010");
                }
            }
        });
    }

    public void aSz() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.2
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.ean != null) {
                    e.this.ean.hide();
                }
            }
        });
    }

    public void aSA() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.3
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.ean != null) {
                    com.baidu.swan.games.view.a.c.removeView(e.this.ean.getConvertView());
                }
                e.this.ean = null;
                e.this.eal = null;
                e.this.dXp = null;
                if (e.this.eaq != null) {
                    e.this.eaq.release();
                    e.this.eaq = null;
                }
            }
        });
    }

    public void vx(final String str) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z = e.this.eam.width != e.this.eam.realWidth;
                e.this.aSD();
                if (e.this.ean != null) {
                    e.this.ean.kJ(e.this.eam.width);
                    com.baidu.swan.games.view.a.c.b(e.this.ean.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ah.P(e.this.eam.left), ah.P(e.this.eam.top), ah.P(e.this.eam.realWidth), ah.P(e.this.eam.realHeight)));
                }
                if (str.equals("width") && z && e.this.eal != null) {
                    e.this.eal.a(e.this.eam);
                }
            }
        });
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void a(AdElementInfo adElementInfo) {
        this.dXp = adElementInfo;
        aSC();
        com.baidu.swan.games.view.a.b.dl(this.dYI ? "gdtbanner" : "banner", "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void vl(String str) {
        if (this.eal != null) {
            this.eal.onError(str);
        }
        com.baidu.swan.apps.runtime.e aIK = com.baidu.swan.apps.runtime.e.aIK();
        String str2 = "";
        if (aIK != null) {
            str2 = aIK.id;
        }
        if (str2.lastIndexOf("_dev") >= 0 && str2.lastIndexOf("_dev") < str2.length() && str.equals("201000")) {
            aSB();
        }
        com.baidu.swan.games.view.a.b.ai(this.dYI ? "gdtbanner" : "banner", com.baidu.pass.biometrics.face.liveness.c.a.p, str);
    }

    private void aSB() {
        this.ean = new com.baidu.swan.game.ad.a(this.mContext);
        this.ean.kJ(this.eam.width);
        if (com.baidu.swan.games.view.a.c.aU(this.ean.getConvertView())) {
            com.baidu.swan.games.view.a.c.removeView(this.ean.getConvertView());
        }
        com.baidu.swan.games.view.a.c.c(this.ean.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ah.P(this.eam.left), ah.P(this.eam.top), ah.P(this.eam.realWidth), ah.P(this.eam.realHeight)));
        this.ean.getConvertView().postDelayed(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.ean != null && com.baidu.swan.games.view.a.c.aU(e.this.ean.getConvertView())) {
                    com.baidu.swan.games.view.a.c.removeView(e.this.ean.getConvertView());
                }
            }
        }, 20000L);
    }

    private void aSC() {
        this.ean = new com.baidu.swan.game.ad.a(this.mContext, this.dXp, this.dWJ, this.dYI);
        this.ean.a(this.dWM);
        if (this.dYI) {
            this.ean.a(new a.d() { // from class: com.baidu.swan.game.ad.e.e.6
                @Override // com.baidu.swan.game.ad.a.a.d
                public void aR(View view) {
                    if (e.this.dYI) {
                        e.this.aS(view);
                        com.baidu.swan.games.view.a.b.dl("gdtbanner", "click");
                    }
                }

                @Override // com.baidu.swan.game.ad.a.a.d
                public void cM(String str, String str2) {
                }
            });
        } else {
            this.ean.a(new a.InterfaceC0499a() { // from class: com.baidu.swan.game.ad.e.e.7
                @Override // com.baidu.swan.game.ad.a.a.InterfaceC0499a
                public void a(CommandType commandType, Uri uri) {
                    com.baidu.swan.apps.core.d.f afX = com.baidu.swan.apps.v.f.aAl().afX();
                    if (afX == null) {
                        if (e.this.mContext != null) {
                            com.baidu.swan.apps.res.widget.b.d.u(e.this.mContext, a.h.aiapps_open_fragment_failed_toast).aIs();
                        }
                    } else if (e.this.dXp != null) {
                        String aRR = e.this.dXp.aRR();
                        afX.mC("adLanding").af(com.baidu.swan.apps.core.d.f.cSz, com.baidu.swan.apps.core.d.f.cSB).a("adLanding", com.baidu.swan.apps.model.b.bZ(aRR, aRR)).apI();
                        com.baidu.swan.game.ad.c.c.d(e.this.dXp, e.this.dXi);
                    }
                }
            });
        }
        this.ean.kJ(this.eam.width);
        if (com.baidu.swan.games.view.a.c.aU(this.ean.getConvertView())) {
            com.baidu.swan.games.view.a.c.removeView(this.ean.getConvertView());
        }
        if (com.baidu.swan.games.view.a.c.c(this.ean.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ah.P(this.eam.left), ah.P(this.eam.top), ah.P(this.eam.realWidth), ah.P(this.eam.realHeight)))) {
            if (this.eal != null) {
                this.eal.onLoad();
            }
        } else if (this.eal != null) {
            this.eal.onError("3010000");
        }
    }

    private void loadAd() {
        com.baidu.swan.game.ad.b.d cVar;
        com.baidu.swan.apps.runtime.e aIK = com.baidu.swan.apps.runtime.e.aIK();
        String str = "";
        if (aIK != null) {
            str = aIK.getAppKey();
        }
        com.baidu.swan.game.ad.b.b aSf = new b.a().vr(this.dYQ).vs(this.dWJ).vt(str).kO(this.eam.width).kP(this.eam.height).aSf();
        if (this.dYI) {
            cVar = new com.baidu.swan.game.ad.b.e(this.mContext, aSf, 1, aSE());
            com.baidu.swan.games.view.a.b.dl("gdtbanner", null);
        } else {
            cVar = new com.baidu.swan.game.ad.b.c(this.mContext, aSf);
            this.dZm = cVar.aSk();
            com.baidu.swan.games.view.a.b.dl("banner", null);
        }
        com.baidu.swan.game.ad.b.a aVar = new com.baidu.swan.game.ad.b.a(this.mContext, this.dYI);
        aVar.a(this);
        aVar.a(cVar, this.dXi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSD() {
        if (this.eam != null) {
            if (ah.P(this.eam.width) < 300) {
                this.eam.width = ah.R(300.0f);
            }
            int aZq = com.baidu.swan.games.view.a.c.aZq();
            int aZr = com.baidu.swan.games.view.a.c.aZr();
            if (ah.P(this.eam.width) > aZq) {
                this.eam.width = ah.R(aZq);
            }
            this.eam.height = (int) (this.eam.width / com.baidu.swan.game.ad.d.d.dZO);
            if (this.eam.left < 0) {
                this.eam.left = 0;
            }
            int R = ah.R(aZq) - this.eam.width;
            if (this.eam.left > R) {
                this.eam.left = R;
            }
            if (this.eam.top < 0) {
                this.eam.top = 0;
            }
            int R2 = ah.R(aZr) - this.eam.height;
            if (this.eam.top > R2) {
                this.eam.top = R2;
            }
            this.eam.realWidth = this.eam.width;
            this.eam.realHeight = this.eam.height;
        }
    }

    private int aSE() {
        if (this.eam == null) {
            return 2;
        }
        int R = ah.R(com.baidu.swan.games.view.a.c.aZr());
        if (this.eam.top < R / 3) {
            return 1;
        }
        return this.eam.top < (R / 3) * 2 ? 4 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(View view) {
        if (this.dYI && this.dXp != null && this.eam != null && view != null) {
            com.baidu.swan.game.ad.c.d.d(this.dXp, this.dXi);
            com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
            bVar.dZv = String.valueOf(this.eam.width);
            bVar.dZw = String.valueOf(this.eam.height);
            bVar.dZx = String.valueOf(this.eam.width);
            bVar.dZy = String.valueOf(this.eam.height);
            bVar.dZz = String.valueOf((int) view.getX());
            bVar.dZA = String.valueOf((int) view.getY());
            bVar.dZB = String.valueOf((int) view.getX());
            bVar.dZC = String.valueOf((int) view.getY());
            if (this.dXp.getActionType() == 2) {
                com.baidu.swan.game.ad.c.d.a(bVar, this.dXp, this.dXi, new a.d() { // from class: com.baidu.swan.game.ad.e.e.8
                    @Override // com.baidu.swan.game.ad.a.a.d
                    public void aR(View view2) {
                    }

                    @Override // com.baidu.swan.game.ad.a.a.d
                    public void cM(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("url", str2);
                                if (e.this.eaq == null) {
                                    e.this.eaq = new g(e.this.mContext, e.this.dXp, e.this.dXi);
                                }
                                e.this.eaq.qD(str);
                                com.baidu.swan.apps.t.a.axg().a(e.this.mContext, jSONObject, SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, e.this.eaq);
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
            com.baidu.swan.apps.core.d.f afX = com.baidu.swan.apps.v.f.aAl().afX();
            if (afX == null) {
                if (this.mContext != null) {
                    com.baidu.swan.apps.res.widget.b.d.u(this.mContext, a.h.aiapps_open_fragment_failed_toast).aIs();
                }
            } else if (this.dXp != null) {
                String a2 = com.baidu.swan.game.ad.c.d.a(this.dXp.aRR(), bVar);
                afX.mC("adLanding").af(com.baidu.swan.apps.core.d.f.cSz, com.baidu.swan.apps.core.d.f.cSB).a("adLanding", com.baidu.swan.apps.model.b.bZ(a2, a2)).apI();
            }
        }
    }
}
