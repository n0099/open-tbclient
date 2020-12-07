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
    private AdElementInfo dQW;
    public String dQs;
    private a.InterfaceC0525a dQv;
    private String dSV;
    private boolean dSq;
    private String dSz;
    private i dTU;
    public f dTV;
    private com.baidu.swan.game.ad.a dTW;
    private boolean dTX;
    private g dTY;
    private Context mContext = AppRuntime.getAppContext();
    private b dQP = new b(this.mContext);

    public e(String str, String str2, f fVar, a.InterfaceC0525a interfaceC0525a, boolean z) {
        this.dTV = null;
        this.dSz = str;
        this.dQs = str2;
        this.dTV = fVar;
        this.dQv = interfaceC0525a;
        this.dSq = z;
        aTQ();
        loadAd();
    }

    public void a(i iVar) {
        this.dTU = iVar;
    }

    public void c(JsObject jsObject) {
        final l e = l.e(com.baidu.swan.games.binding.model.c.e(jsObject));
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.1
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.dTW != null && com.baidu.swan.games.view.a.c.aP(e.this.dTW.getConvertView())) {
                    e.this.dTW.show();
                    if (e != null) {
                        e.aUl();
                    }
                    if (!e.this.dTX) {
                        e.this.dTX = true;
                        if (e.this.dSq) {
                            com.baidu.swan.game.ad.c.d.a(e.this.dQW, e.this.dQP);
                            return;
                        }
                        com.baidu.swan.game.ad.c.c.a(e.this.dQW, e.this.dQP);
                        com.baidu.swan.game.ad.c.c.a(e.this.dSz, e.this.dQs, e.this.dSV, e.this.dQP);
                        return;
                    }
                    return;
                }
                if (e != null) {
                    e.wt("3010010");
                }
                if (e.this.dTU != null) {
                    e.this.dTU.onError("3010010");
                }
            }
        });
    }

    public void aTM() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.2
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.dTW != null) {
                    e.this.dTW.hide();
                }
            }
        });
    }

    public void aTN() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.3
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.dTW != null) {
                    com.baidu.swan.games.view.a.c.removeView(e.this.dTW.getConvertView());
                }
                e.this.dTW = null;
                e.this.dTU = null;
                e.this.dQW = null;
                if (e.this.dTY != null) {
                    e.this.dTY.release();
                    e.this.dTY = null;
                }
            }
        });
    }

    public void wq(final String str) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z = e.this.dTV.width != e.this.dTV.realWidth;
                e.this.aTQ();
                if (e.this.dTW != null) {
                    e.this.dTW.me(e.this.dTV.width);
                    com.baidu.swan.games.view.a.c.b(e.this.dTW.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ah.M(e.this.dTV.left), ah.M(e.this.dTV.top), ah.M(e.this.dTV.realWidth), ah.M(e.this.dTV.realHeight)));
                }
                if (str.equals("width") && z && e.this.dTU != null) {
                    e.this.dTU.a(e.this.dTV);
                }
            }
        });
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void a(AdElementInfo adElementInfo) {
        this.dQW = adElementInfo;
        aTP();
        com.baidu.swan.games.view.a.b.dt(this.dSq ? "gdtbanner" : "banner", "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void we(String str) {
        if (this.dTU != null) {
            this.dTU.onError(str);
        }
        com.baidu.swan.apps.runtime.e aJU = com.baidu.swan.apps.runtime.e.aJU();
        String str2 = "";
        if (aJU != null) {
            str2 = aJU.id;
        }
        if (str2.lastIndexOf("_dev") >= 0 && str2.lastIndexOf("_dev") < str2.length() && str.equals("201000")) {
            aTO();
        }
        com.baidu.swan.games.view.a.b.af(this.dSq ? "gdtbanner" : "banner", "fail", str);
    }

    private void aTO() {
        this.dTW = new com.baidu.swan.game.ad.a(this.mContext);
        this.dTW.me(this.dTV.width);
        if (com.baidu.swan.games.view.a.c.aP(this.dTW.getConvertView())) {
            com.baidu.swan.games.view.a.c.removeView(this.dTW.getConvertView());
        }
        com.baidu.swan.games.view.a.c.c(this.dTW.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ah.M(this.dTV.left), ah.M(this.dTV.top), ah.M(this.dTV.realWidth), ah.M(this.dTV.realHeight)));
        this.dTW.getConvertView().postDelayed(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.dTW != null && com.baidu.swan.games.view.a.c.aP(e.this.dTW.getConvertView())) {
                    com.baidu.swan.games.view.a.c.removeView(e.this.dTW.getConvertView());
                }
            }
        }, 20000L);
    }

    private void aTP() {
        this.dTW = new com.baidu.swan.game.ad.a(this.mContext, this.dQW, this.dQs, this.dSq);
        this.dTW.a(this.dQv);
        if (this.dSq) {
            this.dTW.a(new a.d() { // from class: com.baidu.swan.game.ad.e.e.6
                @Override // com.baidu.swan.game.ad.a.a.d
                public void aM(View view) {
                    if (e.this.dSq) {
                        e.this.aN(view);
                        com.baidu.swan.games.view.a.b.dt("gdtbanner", "click");
                    }
                }

                @Override // com.baidu.swan.game.ad.a.a.d
                public void cU(String str, String str2) {
                }
            });
        } else {
            this.dTW.a(new a.InterfaceC0526a() { // from class: com.baidu.swan.game.ad.e.e.7
                @Override // com.baidu.swan.game.ad.a.a.InterfaceC0526a
                public void a(CommandType commandType, Uri uri) {
                    com.baidu.swan.apps.core.d.f aim = com.baidu.swan.apps.v.f.aCp().aim();
                    if (aim == null) {
                        if (e.this.mContext != null) {
                            com.baidu.swan.apps.res.widget.b.d.t(e.this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
                        }
                    } else if (e.this.dQW != null) {
                        String aTb = e.this.dQW.aTb();
                        aim.nC("adLanding").an(com.baidu.swan.apps.core.d.f.cQb, com.baidu.swan.apps.core.d.f.cQd).a("adLanding", com.baidu.swan.apps.model.b.ch(aTb, aTb)).arM();
                        com.baidu.swan.game.ad.c.c.d(e.this.dQW, e.this.dQP);
                    }
                }
            });
        }
        this.dTW.me(this.dTV.width);
        if (com.baidu.swan.games.view.a.c.aP(this.dTW.getConvertView())) {
            com.baidu.swan.games.view.a.c.removeView(this.dTW.getConvertView());
        }
        if (com.baidu.swan.games.view.a.c.c(this.dTW.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ah.M(this.dTV.left), ah.M(this.dTV.top), ah.M(this.dTV.realWidth), ah.M(this.dTV.realHeight)))) {
            if (this.dTU != null) {
                this.dTU.onLoad();
            }
        } else if (this.dTU != null) {
            this.dTU.onError("3010000");
        }
    }

    private void loadAd() {
        com.baidu.swan.game.ad.b.d cVar;
        com.baidu.swan.apps.runtime.e aJU = com.baidu.swan.apps.runtime.e.aJU();
        String str = "";
        if (aJU != null) {
            str = aJU.getAppKey();
        }
        com.baidu.swan.game.ad.b.b aTs = new b.a().wk(this.dSz).wl(this.dQs).wm(str).mj(this.dTV.width).mk(this.dTV.height).aTs();
        if (this.dSq) {
            cVar = new com.baidu.swan.game.ad.b.e(this.mContext, aTs, 1, aTR());
            com.baidu.swan.games.view.a.b.dt("gdtbanner", null);
        } else {
            cVar = new com.baidu.swan.game.ad.b.c(this.mContext, aTs);
            this.dSV = cVar.aTx();
            com.baidu.swan.games.view.a.b.dt("banner", null);
        }
        com.baidu.swan.game.ad.b.a aVar = new com.baidu.swan.game.ad.b.a(this.mContext, this.dSq);
        aVar.a(this);
        aVar.a(cVar, this.dQP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTQ() {
        if (this.dTV != null) {
            if (ah.M(this.dTV.width) < 300) {
                this.dTV.width = ah.O(300.0f);
            }
            int baF = com.baidu.swan.games.view.a.c.baF();
            int baG = com.baidu.swan.games.view.a.c.baG();
            if (ah.M(this.dTV.width) > baF) {
                this.dTV.width = ah.O(baF);
            }
            this.dTV.height = (int) (this.dTV.width / com.baidu.swan.game.ad.d.d.dTx);
            if (this.dTV.left < 0) {
                this.dTV.left = 0;
            }
            int O = ah.O(baF) - this.dTV.width;
            if (this.dTV.left > O) {
                this.dTV.left = O;
            }
            if (this.dTV.top < 0) {
                this.dTV.top = 0;
            }
            int O2 = ah.O(baG) - this.dTV.height;
            if (this.dTV.top > O2) {
                this.dTV.top = O2;
            }
            this.dTV.realWidth = this.dTV.width;
            this.dTV.realHeight = this.dTV.height;
        }
    }

    private int aTR() {
        if (this.dTV == null) {
            return 2;
        }
        int O = ah.O(com.baidu.swan.games.view.a.c.baG());
        if (this.dTV.top < O / 3) {
            return 1;
        }
        return this.dTV.top < (O / 3) * 2 ? 4 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN(View view) {
        if (this.dSq && this.dQW != null && this.dTV != null && view != null) {
            com.baidu.swan.game.ad.c.d.d(this.dQW, this.dQP);
            com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
            bVar.dTe = String.valueOf(this.dTV.width);
            bVar.dTf = String.valueOf(this.dTV.height);
            bVar.dTg = String.valueOf(this.dTV.width);
            bVar.dTh = String.valueOf(this.dTV.height);
            bVar.dTi = String.valueOf((int) view.getX());
            bVar.dTj = String.valueOf((int) view.getY());
            bVar.dTk = String.valueOf((int) view.getX());
            bVar.dTl = String.valueOf((int) view.getY());
            if (this.dQW.getActionType() == 2) {
                com.baidu.swan.game.ad.c.d.a(bVar, this.dQW, this.dQP, new a.d() { // from class: com.baidu.swan.game.ad.e.e.8
                    @Override // com.baidu.swan.game.ad.a.a.d
                    public void aM(View view2) {
                    }

                    @Override // com.baidu.swan.game.ad.a.a.d
                    public void cU(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("url", str2);
                                if (e.this.dTY == null) {
                                    e.this.dTY = new g(e.this.mContext, e.this.dQW, e.this.dQP);
                                }
                                e.this.dTY.rD(str);
                                com.baidu.swan.apps.t.a.azk().a(e.this.mContext, jSONObject, SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, e.this.dTY);
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
            com.baidu.swan.apps.core.d.f aim = com.baidu.swan.apps.v.f.aCp().aim();
            if (aim == null) {
                if (this.mContext != null) {
                    com.baidu.swan.apps.res.widget.b.d.t(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
                }
            } else if (this.dQW != null) {
                String a2 = com.baidu.swan.game.ad.c.d.a(this.dQW.aTb(), bVar);
                aim.nC("adLanding").an(com.baidu.swan.apps.core.d.f.cQb, com.baidu.swan.apps.core.d.f.cQd).a("adLanding", com.baidu.swan.apps.model.b.ch(a2, a2)).arM();
            }
        }
    }
}
