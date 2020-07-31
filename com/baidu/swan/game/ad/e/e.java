package com.baidu.swan.game.ad.e;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.game.ad.a;
import com.baidu.swan.game.ad.a.a;
import com.baidu.swan.game.ad.b.b;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.jsbridge.CommandType;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class e implements a.b {
    public String cZn;
    private a.InterfaceC0430a cZq;
    private String daV;
    private boolean dao;
    private String daz;
    private i dbS;
    public f dbT;
    private AdElementInfo dbV;
    private com.baidu.swan.game.ad.a dbW;
    private boolean dbX;
    private g dbY;
    private Context mContext = AppRuntime.getAppContext();
    private b dbU = new b(this.mContext);

    public e(String str, String str2, f fVar, a.InterfaceC0430a interfaceC0430a, boolean z) {
        this.dbT = null;
        this.daz = str;
        this.cZn = str2;
        this.dbT = fVar;
        this.cZq = interfaceC0430a;
        this.dao = z;
        aAW();
        loadAd();
    }

    public void a(i iVar) {
        this.dbS = iVar;
    }

    public void c(JsObject jsObject) {
        final l e = l.e(com.baidu.swan.games.binding.model.c.e(jsObject));
        al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.1
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.dbW != null && com.baidu.swan.games.view.a.c.aD(e.this.dbW.getConvertView())) {
                    e.this.dbW.show();
                    if (e != null) {
                        e.aBk();
                    }
                    if (!e.this.dbX) {
                        e.this.dbX = true;
                        if (e.this.dao) {
                            com.baidu.swan.game.ad.c.d.a(e.this.dbV, e.this.dbU);
                            return;
                        }
                        com.baidu.swan.game.ad.c.c.a(e.this.dbV, e.this.dbU);
                        com.baidu.swan.game.ad.c.c.a(e.this.daz, e.this.cZn, e.this.daV, e.this.dbU);
                        return;
                    }
                    return;
                }
                if (e != null) {
                    e.rM("3010010");
                }
                if (e.this.dbS != null) {
                    e.this.dbS.onError("3010010");
                }
            }
        });
    }

    public void aAS() {
        al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.2
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.dbW != null) {
                    e.this.dbW.hide();
                }
            }
        });
    }

    public void aAT() {
        al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.3
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.dbW != null) {
                    com.baidu.swan.games.view.a.c.ay(e.this.dbW.getConvertView());
                }
                e.this.dbW = null;
                e.this.dbS = null;
                e.this.dbV = null;
                if (e.this.dbY != null) {
                    e.this.dbY.release();
                    e.this.dbY = null;
                }
            }
        });
    }

    public void rI(final String str) {
        al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z = e.this.dbT.width != e.this.dbT.realWidth;
                e.this.aAW();
                if (e.this.dbW != null) {
                    e.this.dbW.iA(e.this.dbT.width);
                    com.baidu.swan.games.view.a.c.b(e.this.dbW.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ai.D(e.this.dbT.left), ai.D(e.this.dbT.top), ai.D(e.this.dbT.realWidth), ai.D(e.this.dbT.realHeight)));
                }
                if (str.equals("width") && z && e.this.dbS != null) {
                    e.this.dbS.a(e.this.dbT);
                }
            }
        });
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void a(AdElementInfo adElementInfo) {
        this.dbV = adElementInfo;
        aAV();
        com.baidu.swan.games.view.a.b.cH(this.dao ? "gdtbanner" : "banner", "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void rw(String str) {
        if (this.dbS != null) {
            this.dbS.onError(str);
        }
        com.baidu.swan.apps.runtime.e arv = com.baidu.swan.apps.runtime.e.arv();
        String str2 = "";
        if (arv != null) {
            str2 = arv.id;
        }
        if (str2.lastIndexOf("_dev") >= 0 && str2.lastIndexOf("_dev") < str2.length() && str.equals("201000")) {
            aAU();
        }
        com.baidu.swan.games.view.a.b.R(this.dao ? "gdtbanner" : "banner", "fail", str);
    }

    private void aAU() {
        this.dbW = new com.baidu.swan.game.ad.a(this.mContext);
        this.dbW.iA(this.dbT.width);
        if (com.baidu.swan.games.view.a.c.aD(this.dbW.getConvertView())) {
            com.baidu.swan.games.view.a.c.ay(this.dbW.getConvertView());
        }
        com.baidu.swan.games.view.a.c.c(this.dbW.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ai.D(this.dbT.left), ai.D(this.dbT.top), ai.D(this.dbT.realWidth), ai.D(this.dbT.realHeight)));
        this.dbW.getConvertView().postDelayed(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.dbW != null && com.baidu.swan.games.view.a.c.aD(e.this.dbW.getConvertView())) {
                    com.baidu.swan.games.view.a.c.ay(e.this.dbW.getConvertView());
                }
            }
        }, 20000L);
    }

    private void aAV() {
        this.dbW = new com.baidu.swan.game.ad.a(this.mContext, this.dbV, this.cZn, this.dao);
        this.dbW.a(this.cZq);
        if (this.dao) {
            this.dbW.a(new a.d() { // from class: com.baidu.swan.game.ad.e.e.6
                @Override // com.baidu.swan.game.ad.a.a.d
                public void aA(View view) {
                    if (e.this.dao) {
                        e.this.aB(view);
                        com.baidu.swan.games.view.a.b.cH("gdtbanner", "click");
                    }
                }

                @Override // com.baidu.swan.game.ad.a.a.d
                public void ci(String str, String str2) {
                }
            });
        } else {
            this.dbW.a(new a.InterfaceC0431a() { // from class: com.baidu.swan.game.ad.e.e.7
                @Override // com.baidu.swan.game.ad.a.a.InterfaceC0431a
                public void a(CommandType commandType, Uri uri) {
                    com.baidu.swan.apps.core.d.f Sc = com.baidu.swan.apps.v.f.akr().Sc();
                    if (Sc == null) {
                        if (e.this.mContext != null) {
                            com.baidu.swan.apps.res.widget.b.d.k(e.this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
                        }
                    } else if (e.this.dbV != null) {
                        String aAf = e.this.dbV.aAf();
                        Sc.jO("adLanding").ag(com.baidu.swan.apps.core.d.f.cci, com.baidu.swan.apps.core.d.f.cck).a("adLanding", com.baidu.swan.apps.model.b.bB(aAf, aAf)).abl();
                        com.baidu.swan.game.ad.c.c.b(e.this.dbV, e.this.dbU);
                    }
                }
            });
        }
        this.dbW.iA(this.dbT.width);
        if (com.baidu.swan.games.view.a.c.aD(this.dbW.getConvertView())) {
            com.baidu.swan.games.view.a.c.ay(this.dbW.getConvertView());
        }
        if (com.baidu.swan.games.view.a.c.c(this.dbW.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ai.D(this.dbT.left), ai.D(this.dbT.top), ai.D(this.dbT.realWidth), ai.D(this.dbT.realHeight)))) {
            if (this.dbS != null) {
                this.dbS.onLoad();
            }
        } else if (this.dbS != null) {
            this.dbS.onError("3010000");
        }
    }

    private void loadAd() {
        com.baidu.swan.game.ad.b.d cVar;
        com.baidu.swan.apps.runtime.e arv = com.baidu.swan.apps.runtime.e.arv();
        String str = "";
        if (arv != null) {
            str = arv.getAppKey();
        }
        com.baidu.swan.game.ad.b.b aAx = new b.a().rC(this.daz).rD(this.cZn).rE(str).iD(this.dbT.width).iE(this.dbT.height).aAx();
        if (this.dao) {
            cVar = new com.baidu.swan.game.ad.b.e(this.mContext, aAx, 1, aAX());
            com.baidu.swan.games.view.a.b.cH("gdtbanner", null);
        } else {
            cVar = new com.baidu.swan.game.ad.b.c(this.mContext, aAx);
            this.daV = cVar.aAD();
            com.baidu.swan.games.view.a.b.cH("banner", null);
        }
        com.baidu.swan.game.ad.b.a aVar = new com.baidu.swan.game.ad.b.a(this.mContext, this.dao);
        aVar.a(this);
        aVar.a(cVar, this.dbU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAW() {
        if (this.dbT != null) {
            if (ai.D(this.dbT.width) < 300) {
                this.dbT.width = ai.F(300.0f);
            }
            int aHD = com.baidu.swan.games.view.a.c.aHD();
            int aHE = com.baidu.swan.games.view.a.c.aHE();
            if (ai.D(this.dbT.width) > aHD) {
                this.dbT.width = ai.F(aHD);
            }
            this.dbT.height = (int) (this.dbT.width / com.baidu.swan.game.ad.d.d.dbv);
            if (this.dbT.left < 0) {
                this.dbT.left = 0;
            }
            int F = ai.F(aHD) - this.dbT.width;
            if (this.dbT.left > F) {
                this.dbT.left = F;
            }
            if (this.dbT.top < 0) {
                this.dbT.top = 0;
            }
            int F2 = ai.F(aHE) - this.dbT.height;
            if (this.dbT.top > F2) {
                this.dbT.top = F2;
            }
            this.dbT.realWidth = this.dbT.width;
            this.dbT.realHeight = this.dbT.height;
        }
    }

    private int aAX() {
        if (this.dbT == null) {
            return 2;
        }
        int F = ai.F(com.baidu.swan.games.view.a.c.aHE());
        if (this.dbT.top < F / 3) {
            return 1;
        }
        return this.dbT.top < (F / 3) * 2 ? 4 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aB(View view) {
        if (this.dao && this.dbV != null && this.dbT != null && view != null) {
            com.baidu.swan.game.ad.c.d.b(this.dbV, this.dbU);
            com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
            bVar.dbb = String.valueOf(this.dbT.width);
            bVar.dbc = String.valueOf(this.dbT.height);
            bVar.dbd = String.valueOf(this.dbT.width);
            bVar.dbe = String.valueOf(this.dbT.height);
            bVar.dbf = String.valueOf((int) view.getX());
            bVar.dbg = String.valueOf((int) view.getY());
            bVar.dbh = String.valueOf((int) view.getX());
            bVar.dbi = String.valueOf((int) view.getY());
            if (this.dbV.getActionType() == 2) {
                com.baidu.swan.game.ad.c.d.a(bVar, this.dbV, this.dbU, new a.d() { // from class: com.baidu.swan.game.ad.e.e.8
                    @Override // com.baidu.swan.game.ad.a.a.d
                    public void aA(View view2) {
                    }

                    @Override // com.baidu.swan.game.ad.a.a.d
                    public void ci(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("url", str2);
                                if (e.this.dbY == null) {
                                    e.this.dbY = new g(e.this.mContext, e.this.dbV, e.this.dbU);
                                }
                                e.this.dbY.rJ(str);
                                com.baidu.swan.apps.t.a.aht().a(e.this.mContext, jSONObject, SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, e.this.dbY);
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
            com.baidu.swan.apps.core.d.f Sc = com.baidu.swan.apps.v.f.akr().Sc();
            if (Sc == null) {
                if (this.mContext != null) {
                    com.baidu.swan.apps.res.widget.b.d.k(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
                }
            } else if (this.dbV != null) {
                String a = com.baidu.swan.game.ad.c.d.a(this.dbV.aAf(), bVar);
                Sc.jO("adLanding").ag(com.baidu.swan.apps.core.d.f.cci, com.baidu.swan.apps.core.d.f.cck).a("adLanding", com.baidu.swan.apps.model.b.bB(a, a)).abl();
            }
        }
    }
}
