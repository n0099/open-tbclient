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
    private i dAp;
    public f dAq;
    private com.baidu.swan.game.ad.a dAr;
    private boolean dAs;
    private g dAt;
    public String dwN;
    private a.InterfaceC0489a dwQ;
    private AdElementInfo dxr;
    private boolean dyM;
    private String dyV;
    private String dzr;
    private Context mContext = AppRuntime.getAppContext();
    private b dxk = new b(this.mContext);

    public e(String str, String str2, f fVar, a.InterfaceC0489a interfaceC0489a, boolean z) {
        this.dAq = null;
        this.dyV = str;
        this.dwN = str2;
        this.dAq = fVar;
        this.dwQ = interfaceC0489a;
        this.dyM = z;
        aMZ();
        loadAd();
    }

    public void a(i iVar) {
        this.dAp = iVar;
    }

    public void c(JsObject jsObject) {
        final l e = l.e(com.baidu.swan.games.binding.model.c.e(jsObject));
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.1
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.dAr != null && com.baidu.swan.games.view.a.c.aI(e.this.dAr.getConvertView())) {
                    e.this.dAr.show();
                    if (e != null) {
                        e.aNu();
                    }
                    if (!e.this.dAs) {
                        e.this.dAs = true;
                        if (e.this.dyM) {
                            com.baidu.swan.game.ad.c.d.a(e.this.dxr, e.this.dxk);
                            return;
                        }
                        com.baidu.swan.game.ad.c.c.a(e.this.dxr, e.this.dxk);
                        com.baidu.swan.game.ad.c.c.a(e.this.dyV, e.this.dwN, e.this.dzr, e.this.dxk);
                        return;
                    }
                    return;
                }
                if (e != null) {
                    e.vk("3010010");
                }
                if (e.this.dAp != null) {
                    e.this.dAp.onError("3010010");
                }
            }
        });
    }

    public void aMV() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.2
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.dAr != null) {
                    e.this.dAr.hide();
                }
            }
        });
    }

    public void aMW() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.3
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.dAr != null) {
                    com.baidu.swan.games.view.a.c.removeView(e.this.dAr.getConvertView());
                }
                e.this.dAr = null;
                e.this.dAp = null;
                e.this.dxr = null;
                if (e.this.dAt != null) {
                    e.this.dAt.release();
                    e.this.dAt = null;
                }
            }
        });
    }

    public void vh(final String str) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z = e.this.dAq.width != e.this.dAq.realWidth;
                e.this.aMZ();
                if (e.this.dAr != null) {
                    e.this.dAr.lp(e.this.dAq.width);
                    com.baidu.swan.games.view.a.c.b(e.this.dAr.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ah.J(e.this.dAq.left), ah.J(e.this.dAq.top), ah.J(e.this.dAq.realWidth), ah.J(e.this.dAq.realHeight)));
                }
                if (str.equals("width") && z && e.this.dAp != null) {
                    e.this.dAp.a(e.this.dAq);
                }
            }
        });
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void a(AdElementInfo adElementInfo) {
        this.dxr = adElementInfo;
        aMY();
        com.baidu.swan.games.view.a.b.dg(this.dyM ? "gdtbanner" : "banner", "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void uV(String str) {
        if (this.dAp != null) {
            this.dAp.onError(str);
        }
        com.baidu.swan.apps.runtime.e aDa = com.baidu.swan.apps.runtime.e.aDa();
        String str2 = "";
        if (aDa != null) {
            str2 = aDa.id;
        }
        if (str2.lastIndexOf("_dev") >= 0 && str2.lastIndexOf("_dev") < str2.length() && str.equals("201000")) {
            aMX();
        }
        com.baidu.swan.games.view.a.b.V(this.dyM ? "gdtbanner" : "banner", "fail", str);
    }

    private void aMX() {
        this.dAr = new com.baidu.swan.game.ad.a(this.mContext);
        this.dAr.lp(this.dAq.width);
        if (com.baidu.swan.games.view.a.c.aI(this.dAr.getConvertView())) {
            com.baidu.swan.games.view.a.c.removeView(this.dAr.getConvertView());
        }
        com.baidu.swan.games.view.a.c.c(this.dAr.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ah.J(this.dAq.left), ah.J(this.dAq.top), ah.J(this.dAq.realWidth), ah.J(this.dAq.realHeight)));
        this.dAr.getConvertView().postDelayed(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.dAr != null && com.baidu.swan.games.view.a.c.aI(e.this.dAr.getConvertView())) {
                    com.baidu.swan.games.view.a.c.removeView(e.this.dAr.getConvertView());
                }
            }
        }, 20000L);
    }

    private void aMY() {
        this.dAr = new com.baidu.swan.game.ad.a(this.mContext, this.dxr, this.dwN, this.dyM);
        this.dAr.a(this.dwQ);
        if (this.dyM) {
            this.dAr.a(new a.d() { // from class: com.baidu.swan.game.ad.e.e.6
                @Override // com.baidu.swan.game.ad.a.a.d
                public void aF(View view) {
                    if (e.this.dyM) {
                        e.this.aG(view);
                        com.baidu.swan.games.view.a.b.dg("gdtbanner", "click");
                    }
                }

                @Override // com.baidu.swan.game.ad.a.a.d
                public void cH(String str, String str2) {
                }
            });
        } else {
            this.dAr.a(new a.InterfaceC0490a() { // from class: com.baidu.swan.game.ad.e.e.7
                @Override // com.baidu.swan.game.ad.a.a.InterfaceC0490a
                public void a(CommandType commandType, Uri uri) {
                    com.baidu.swan.apps.core.d.f abs = com.baidu.swan.apps.v.f.avu().abs();
                    if (abs == null) {
                        if (e.this.mContext != null) {
                            com.baidu.swan.apps.res.widget.b.d.k(e.this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
                        }
                    } else if (e.this.dxr != null) {
                        String aMk = e.this.dxr.aMk();
                        abs.mt("adLanding").ak(com.baidu.swan.apps.core.d.f.cwD, com.baidu.swan.apps.core.d.f.cwF).a("adLanding", com.baidu.swan.apps.model.b.bU(aMk, aMk)).akS();
                        com.baidu.swan.game.ad.c.c.d(e.this.dxr, e.this.dxk);
                    }
                }
            });
        }
        this.dAr.lp(this.dAq.width);
        if (com.baidu.swan.games.view.a.c.aI(this.dAr.getConvertView())) {
            com.baidu.swan.games.view.a.c.removeView(this.dAr.getConvertView());
        }
        if (com.baidu.swan.games.view.a.c.c(this.dAr.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ah.J(this.dAq.left), ah.J(this.dAq.top), ah.J(this.dAq.realWidth), ah.J(this.dAq.realHeight)))) {
            if (this.dAp != null) {
                this.dAp.onLoad();
            }
        } else if (this.dAp != null) {
            this.dAp.onError("3010000");
        }
    }

    private void loadAd() {
        com.baidu.swan.game.ad.b.d cVar;
        com.baidu.swan.apps.runtime.e aDa = com.baidu.swan.apps.runtime.e.aDa();
        String str = "";
        if (aDa != null) {
            str = aDa.getAppKey();
        }
        com.baidu.swan.game.ad.b.b aMB = new b.a().vb(this.dyV).vc(this.dwN).vd(str).lu(this.dAq.width).lv(this.dAq.height).aMB();
        if (this.dyM) {
            cVar = new com.baidu.swan.game.ad.b.e(this.mContext, aMB, 1, aNa());
            com.baidu.swan.games.view.a.b.dg("gdtbanner", null);
        } else {
            cVar = new com.baidu.swan.game.ad.b.c(this.mContext, aMB);
            this.dzr = cVar.aMG();
            com.baidu.swan.games.view.a.b.dg("banner", null);
        }
        com.baidu.swan.game.ad.b.a aVar = new com.baidu.swan.game.ad.b.a(this.mContext, this.dyM);
        aVar.a(this);
        aVar.a(cVar, this.dxk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMZ() {
        if (this.dAq != null) {
            if (ah.J(this.dAq.width) < 300) {
                this.dAq.width = ah.L(300.0f);
            }
            int aTO = com.baidu.swan.games.view.a.c.aTO();
            int aTP = com.baidu.swan.games.view.a.c.aTP();
            if (ah.J(this.dAq.width) > aTO) {
                this.dAq.width = ah.L(aTO);
            }
            this.dAq.height = (int) (this.dAq.width / com.baidu.swan.game.ad.d.d.dzS);
            if (this.dAq.left < 0) {
                this.dAq.left = 0;
            }
            int L = ah.L(aTO) - this.dAq.width;
            if (this.dAq.left > L) {
                this.dAq.left = L;
            }
            if (this.dAq.top < 0) {
                this.dAq.top = 0;
            }
            int L2 = ah.L(aTP) - this.dAq.height;
            if (this.dAq.top > L2) {
                this.dAq.top = L2;
            }
            this.dAq.realWidth = this.dAq.width;
            this.dAq.realHeight = this.dAq.height;
        }
    }

    private int aNa() {
        if (this.dAq == null) {
            return 2;
        }
        int L = ah.L(com.baidu.swan.games.view.a.c.aTP());
        if (this.dAq.top < L / 3) {
            return 1;
        }
        return this.dAq.top < (L / 3) * 2 ? 4 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(View view) {
        if (this.dyM && this.dxr != null && this.dAq != null && view != null) {
            com.baidu.swan.game.ad.c.d.d(this.dxr, this.dxk);
            com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
            bVar.dzz = String.valueOf(this.dAq.width);
            bVar.dzA = String.valueOf(this.dAq.height);
            bVar.dzB = String.valueOf(this.dAq.width);
            bVar.dzC = String.valueOf(this.dAq.height);
            bVar.dzD = String.valueOf((int) view.getX());
            bVar.dzE = String.valueOf((int) view.getY());
            bVar.dzF = String.valueOf((int) view.getX());
            bVar.dzG = String.valueOf((int) view.getY());
            if (this.dxr.getActionType() == 2) {
                com.baidu.swan.game.ad.c.d.a(bVar, this.dxr, this.dxk, new a.d() { // from class: com.baidu.swan.game.ad.e.e.8
                    @Override // com.baidu.swan.game.ad.a.a.d
                    public void aF(View view2) {
                    }

                    @Override // com.baidu.swan.game.ad.a.a.d
                    public void cH(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("url", str2);
                                if (e.this.dAt == null) {
                                    e.this.dAt = new g(e.this.mContext, e.this.dxr, e.this.dxk);
                                }
                                e.this.dAt.qv(str);
                                com.baidu.swan.apps.t.a.asq().a(e.this.mContext, jSONObject, SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, e.this.dAt);
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
            com.baidu.swan.apps.core.d.f abs = com.baidu.swan.apps.v.f.avu().abs();
            if (abs == null) {
                if (this.mContext != null) {
                    com.baidu.swan.apps.res.widget.b.d.k(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
                }
            } else if (this.dxr != null) {
                String a2 = com.baidu.swan.game.ad.c.d.a(this.dxr.aMk(), bVar);
                abs.mt("adLanding").ak(com.baidu.swan.apps.core.d.f.cwD, com.baidu.swan.apps.core.d.f.cwF).a("adLanding", com.baidu.swan.apps.model.b.bU(a2, a2)).akS();
            }
        }
    }
}
