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
/* loaded from: classes12.dex */
public class e implements a.b {
    private AdElementInfo dJY;
    public String dJu;
    private a.InterfaceC0513a dJx;
    private String dLC;
    private String dLY;
    private boolean dLt;
    private i dMW;
    public f dMX;
    private com.baidu.swan.game.ad.a dMY;
    private boolean dMZ;
    private g dNa;
    private Context mContext = AppRuntime.getAppContext();
    private b dJR = new b(this.mContext);

    public e(String str, String str2, f fVar, a.InterfaceC0513a interfaceC0513a, boolean z) {
        this.dMX = null;
        this.dLC = str;
        this.dJu = str2;
        this.dMX = fVar;
        this.dJx = interfaceC0513a;
        this.dLt = z;
        aQL();
        loadAd();
    }

    public void a(i iVar) {
        this.dMW = iVar;
    }

    public void c(JsObject jsObject) {
        final l e = l.e(com.baidu.swan.games.binding.model.c.e(jsObject));
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.1
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.dMY != null && com.baidu.swan.games.view.a.c.aN(e.this.dMY.getConvertView())) {
                    e.this.dMY.show();
                    if (e != null) {
                        e.aRg();
                    }
                    if (!e.this.dMZ) {
                        e.this.dMZ = true;
                        if (e.this.dLt) {
                            com.baidu.swan.game.ad.c.d.a(e.this.dJY, e.this.dJR);
                            return;
                        }
                        com.baidu.swan.game.ad.c.c.a(e.this.dJY, e.this.dJR);
                        com.baidu.swan.game.ad.c.c.a(e.this.dLC, e.this.dJu, e.this.dLY, e.this.dJR);
                        return;
                    }
                    return;
                }
                if (e != null) {
                    e.vM("3010010");
                }
                if (e.this.dMW != null) {
                    e.this.dMW.onError("3010010");
                }
            }
        });
    }

    public void aQH() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.2
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.dMY != null) {
                    e.this.dMY.hide();
                }
            }
        });
    }

    public void aQI() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.3
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.dMY != null) {
                    com.baidu.swan.games.view.a.c.removeView(e.this.dMY.getConvertView());
                }
                e.this.dMY = null;
                e.this.dMW = null;
                e.this.dJY = null;
                if (e.this.dNa != null) {
                    e.this.dNa.release();
                    e.this.dNa = null;
                }
            }
        });
    }

    public void vJ(final String str) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z = e.this.dMX.width != e.this.dMX.realWidth;
                e.this.aQL();
                if (e.this.dMY != null) {
                    e.this.dMY.lG(e.this.dMX.width);
                    com.baidu.swan.games.view.a.c.b(e.this.dMY.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ah.M(e.this.dMX.left), ah.M(e.this.dMX.top), ah.M(e.this.dMX.realWidth), ah.M(e.this.dMX.realHeight)));
                }
                if (str.equals("width") && z && e.this.dMW != null) {
                    e.this.dMW.a(e.this.dMX);
                }
            }
        });
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void a(AdElementInfo adElementInfo) {
        this.dJY = adElementInfo;
        aQK();
        com.baidu.swan.games.view.a.b.dm(this.dLt ? "gdtbanner" : "banner", "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void vx(String str) {
        if (this.dMW != null) {
            this.dMW.onError(str);
        }
        com.baidu.swan.apps.runtime.e aGM = com.baidu.swan.apps.runtime.e.aGM();
        String str2 = "";
        if (aGM != null) {
            str2 = aGM.id;
        }
        if (str2.lastIndexOf("_dev") >= 0 && str2.lastIndexOf("_dev") < str2.length() && str.equals("201000")) {
            aQJ();
        }
        com.baidu.swan.games.view.a.b.ac(this.dLt ? "gdtbanner" : "banner", "fail", str);
    }

    private void aQJ() {
        this.dMY = new com.baidu.swan.game.ad.a(this.mContext);
        this.dMY.lG(this.dMX.width);
        if (com.baidu.swan.games.view.a.c.aN(this.dMY.getConvertView())) {
            com.baidu.swan.games.view.a.c.removeView(this.dMY.getConvertView());
        }
        com.baidu.swan.games.view.a.c.c(this.dMY.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ah.M(this.dMX.left), ah.M(this.dMX.top), ah.M(this.dMX.realWidth), ah.M(this.dMX.realHeight)));
        this.dMY.getConvertView().postDelayed(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.dMY != null && com.baidu.swan.games.view.a.c.aN(e.this.dMY.getConvertView())) {
                    com.baidu.swan.games.view.a.c.removeView(e.this.dMY.getConvertView());
                }
            }
        }, 20000L);
    }

    private void aQK() {
        this.dMY = new com.baidu.swan.game.ad.a(this.mContext, this.dJY, this.dJu, this.dLt);
        this.dMY.a(this.dJx);
        if (this.dLt) {
            this.dMY.a(new a.d() { // from class: com.baidu.swan.game.ad.e.e.6
                @Override // com.baidu.swan.game.ad.a.a.d
                public void aK(View view) {
                    if (e.this.dLt) {
                        e.this.aL(view);
                        com.baidu.swan.games.view.a.b.dm("gdtbanner", "click");
                    }
                }

                @Override // com.baidu.swan.game.ad.a.a.d
                public void cN(String str, String str2) {
                }
            });
        } else {
            this.dMY.a(new a.InterfaceC0514a() { // from class: com.baidu.swan.game.ad.e.e.7
                @Override // com.baidu.swan.game.ad.a.a.InterfaceC0514a
                public void a(CommandType commandType, Uri uri) {
                    com.baidu.swan.apps.core.d.f afe = com.baidu.swan.apps.v.f.azg().afe();
                    if (afe == null) {
                        if (e.this.mContext != null) {
                            com.baidu.swan.apps.res.widget.b.d.k(e.this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
                        }
                    } else if (e.this.dJY != null) {
                        String aPW = e.this.dJY.aPW();
                        afe.mV("adLanding").al(com.baidu.swan.apps.core.d.f.cJi, com.baidu.swan.apps.core.d.f.cJk).a("adLanding", com.baidu.swan.apps.model.b.ca(aPW, aPW)).aoE();
                        com.baidu.swan.game.ad.c.c.d(e.this.dJY, e.this.dJR);
                    }
                }
            });
        }
        this.dMY.lG(this.dMX.width);
        if (com.baidu.swan.games.view.a.c.aN(this.dMY.getConvertView())) {
            com.baidu.swan.games.view.a.c.removeView(this.dMY.getConvertView());
        }
        if (com.baidu.swan.games.view.a.c.c(this.dMY.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ah.M(this.dMX.left), ah.M(this.dMX.top), ah.M(this.dMX.realWidth), ah.M(this.dMX.realHeight)))) {
            if (this.dMW != null) {
                this.dMW.onLoad();
            }
        } else if (this.dMW != null) {
            this.dMW.onError("3010000");
        }
    }

    private void loadAd() {
        com.baidu.swan.game.ad.b.d cVar;
        com.baidu.swan.apps.runtime.e aGM = com.baidu.swan.apps.runtime.e.aGM();
        String str = "";
        if (aGM != null) {
            str = aGM.getAppKey();
        }
        com.baidu.swan.game.ad.b.b aQn = new b.a().vD(this.dLC).vE(this.dJu).vF(str).lL(this.dMX.width).lM(this.dMX.height).aQn();
        if (this.dLt) {
            cVar = new com.baidu.swan.game.ad.b.e(this.mContext, aQn, 1, aQM());
            com.baidu.swan.games.view.a.b.dm("gdtbanner", null);
        } else {
            cVar = new com.baidu.swan.game.ad.b.c(this.mContext, aQn);
            this.dLY = cVar.aQs();
            com.baidu.swan.games.view.a.b.dm("banner", null);
        }
        com.baidu.swan.game.ad.b.a aVar = new com.baidu.swan.game.ad.b.a(this.mContext, this.dLt);
        aVar.a(this);
        aVar.a(cVar, this.dJR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQL() {
        if (this.dMX != null) {
            if (ah.M(this.dMX.width) < 300) {
                this.dMX.width = ah.O(300.0f);
            }
            int aXA = com.baidu.swan.games.view.a.c.aXA();
            int aXB = com.baidu.swan.games.view.a.c.aXB();
            if (ah.M(this.dMX.width) > aXA) {
                this.dMX.width = ah.O(aXA);
            }
            this.dMX.height = (int) (this.dMX.width / com.baidu.swan.game.ad.d.d.dMz);
            if (this.dMX.left < 0) {
                this.dMX.left = 0;
            }
            int O = ah.O(aXA) - this.dMX.width;
            if (this.dMX.left > O) {
                this.dMX.left = O;
            }
            if (this.dMX.top < 0) {
                this.dMX.top = 0;
            }
            int O2 = ah.O(aXB) - this.dMX.height;
            if (this.dMX.top > O2) {
                this.dMX.top = O2;
            }
            this.dMX.realWidth = this.dMX.width;
            this.dMX.realHeight = this.dMX.height;
        }
    }

    private int aQM() {
        if (this.dMX == null) {
            return 2;
        }
        int O = ah.O(com.baidu.swan.games.view.a.c.aXB());
        if (this.dMX.top < O / 3) {
            return 1;
        }
        return this.dMX.top < (O / 3) * 2 ? 4 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL(View view) {
        if (this.dLt && this.dJY != null && this.dMX != null && view != null) {
            com.baidu.swan.game.ad.c.d.d(this.dJY, this.dJR);
            com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
            bVar.dMg = String.valueOf(this.dMX.width);
            bVar.dMh = String.valueOf(this.dMX.height);
            bVar.dMi = String.valueOf(this.dMX.width);
            bVar.dMj = String.valueOf(this.dMX.height);
            bVar.dMk = String.valueOf((int) view.getX());
            bVar.dMl = String.valueOf((int) view.getY());
            bVar.dMm = String.valueOf((int) view.getX());
            bVar.dMn = String.valueOf((int) view.getY());
            if (this.dJY.getActionType() == 2) {
                com.baidu.swan.game.ad.c.d.a(bVar, this.dJY, this.dJR, new a.d() { // from class: com.baidu.swan.game.ad.e.e.8
                    @Override // com.baidu.swan.game.ad.a.a.d
                    public void aK(View view2) {
                    }

                    @Override // com.baidu.swan.game.ad.a.a.d
                    public void cN(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("url", str2);
                                if (e.this.dNa == null) {
                                    e.this.dNa = new g(e.this.mContext, e.this.dJY, e.this.dJR);
                                }
                                e.this.dNa.qW(str);
                                com.baidu.swan.apps.t.a.awc().a(e.this.mContext, jSONObject, SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, e.this.dNa);
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
            com.baidu.swan.apps.core.d.f afe = com.baidu.swan.apps.v.f.azg().afe();
            if (afe == null) {
                if (this.mContext != null) {
                    com.baidu.swan.apps.res.widget.b.d.k(this.mContext, a.h.aiapps_open_fragment_failed_toast).showToast();
                }
            } else if (this.dJY != null) {
                String a2 = com.baidu.swan.game.ad.c.d.a(this.dJY.aPW(), bVar);
                afe.mV("adLanding").al(com.baidu.swan.apps.core.d.f.cJi, com.baidu.swan.apps.core.d.f.cJk).a("adLanding", com.baidu.swan.apps.model.b.ca(a2, a2)).aoE();
            }
        }
    }
}
