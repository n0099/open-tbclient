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
/* loaded from: classes14.dex */
public class e implements a.b {
    public String dUD;
    private a.InterfaceC0501a dUG;
    private AdElementInfo dVh;
    private boolean dWB;
    private String dWK;
    private String dXg;
    private i dYf;
    public f dYg;
    private com.baidu.swan.game.ad.a dYh;
    private boolean dYi;
    private g dYj;
    private Context mContext = AppRuntime.getAppContext();
    private b dVa = new b(this.mContext);

    public e(String str, String str2, f fVar, a.InterfaceC0501a interfaceC0501a, boolean z) {
        this.dYg = null;
        this.dWK = str;
        this.dUD = str2;
        this.dYg = fVar;
        this.dUG = interfaceC0501a;
        this.dWB = z;
        aSr();
        loadAd();
    }

    public void a(i iVar) {
        this.dYf = iVar;
    }

    public void c(JsObject jsObject) {
        final l e = l.e(com.baidu.swan.games.binding.model.c.e(jsObject));
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.1
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.dYh != null && com.baidu.swan.games.view.a.c.aY(e.this.dYh.getConvertView())) {
                    e.this.dYh.show();
                    if (e != null) {
                        e.aSM();
                    }
                    if (!e.this.dYi) {
                        e.this.dYi = true;
                        if (e.this.dWB) {
                            com.baidu.swan.game.ad.c.d.a(e.this.dVh, e.this.dVa);
                            return;
                        }
                        com.baidu.swan.game.ad.c.c.a(e.this.dVh, e.this.dVa);
                        com.baidu.swan.game.ad.c.c.a(e.this.dWK, e.this.dUD, e.this.dXg, e.this.dVa);
                        return;
                    }
                    return;
                }
                if (e != null) {
                    e.vh("3010010");
                }
                if (e.this.dYf != null) {
                    e.this.dYf.onError("3010010");
                }
            }
        });
    }

    public void aSn() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.2
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.dYh != null) {
                    e.this.dYh.hide();
                }
            }
        });
    }

    public void aSo() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.3
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.dYh != null) {
                    com.baidu.swan.games.view.a.c.removeView(e.this.dYh.getConvertView());
                }
                e.this.dYh = null;
                e.this.dYf = null;
                e.this.dVh = null;
                if (e.this.dYj != null) {
                    e.this.dYj.release();
                    e.this.dYj = null;
                }
            }
        });
    }

    public void ve(final String str) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z = e.this.dYg.width != e.this.dYg.realWidth;
                e.this.aSr();
                if (e.this.dYh != null) {
                    e.this.dYh.kG(e.this.dYg.width);
                    com.baidu.swan.games.view.a.c.b(e.this.dYh.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ah.O(e.this.dYg.left), ah.O(e.this.dYg.top), ah.O(e.this.dYg.realWidth), ah.O(e.this.dYg.realHeight)));
                }
                if (str.equals("width") && z && e.this.dYf != null) {
                    e.this.dYf.a(e.this.dYg);
                }
            }
        });
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void a(AdElementInfo adElementInfo) {
        this.dVh = adElementInfo;
        aSq();
        com.baidu.swan.games.view.a.b.dr(this.dWB ? "gdtbanner" : "banner", "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void uS(String str) {
        if (this.dYf != null) {
            this.dYf.onError(str);
        }
        com.baidu.swan.apps.runtime.e aIr = com.baidu.swan.apps.runtime.e.aIr();
        String str2 = "";
        if (aIr != null) {
            str2 = aIr.id;
        }
        if (str2.lastIndexOf("_dev") >= 0 && str2.lastIndexOf("_dev") < str2.length() && str.equals("201000")) {
            aSp();
        }
        com.baidu.swan.games.view.a.b.ah(this.dWB ? "gdtbanner" : "banner", com.baidu.pass.biometrics.face.liveness.c.a.p, str);
    }

    private void aSp() {
        this.dYh = new com.baidu.swan.game.ad.a(this.mContext);
        this.dYh.kG(this.dYg.width);
        if (com.baidu.swan.games.view.a.c.aY(this.dYh.getConvertView())) {
            com.baidu.swan.games.view.a.c.removeView(this.dYh.getConvertView());
        }
        com.baidu.swan.games.view.a.c.c(this.dYh.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ah.O(this.dYg.left), ah.O(this.dYg.top), ah.O(this.dYg.realWidth), ah.O(this.dYg.realHeight)));
        this.dYh.getConvertView().postDelayed(new Runnable() { // from class: com.baidu.swan.game.ad.e.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.dYh != null && com.baidu.swan.games.view.a.c.aY(e.this.dYh.getConvertView())) {
                    com.baidu.swan.games.view.a.c.removeView(e.this.dYh.getConvertView());
                }
            }
        }, 20000L);
    }

    private void aSq() {
        this.dYh = new com.baidu.swan.game.ad.a(this.mContext, this.dVh, this.dUD, this.dWB);
        this.dYh.a(this.dUG);
        if (this.dWB) {
            this.dYh.a(new a.d() { // from class: com.baidu.swan.game.ad.e.e.6
                @Override // com.baidu.swan.game.ad.a.a.d
                public void aV(View view) {
                    if (e.this.dWB) {
                        e.this.aW(view);
                        com.baidu.swan.games.view.a.b.dr("gdtbanner", "click");
                    }
                }

                @Override // com.baidu.swan.game.ad.a.a.d
                public void cS(String str, String str2) {
                }
            });
        } else {
            this.dYh.a(new a.InterfaceC0502a() { // from class: com.baidu.swan.game.ad.e.e.7
                @Override // com.baidu.swan.game.ad.a.a.InterfaceC0502a
                public void a(CommandType commandType, Uri uri) {
                    com.baidu.swan.apps.core.d.f afz = com.baidu.swan.apps.v.f.azN().afz();
                    if (afz == null) {
                        if (e.this.mContext != null) {
                            com.baidu.swan.apps.res.widget.b.d.u(e.this.mContext, a.h.aiapps_open_fragment_failed_toast).aHZ();
                        }
                    } else if (e.this.dVh != null) {
                        String aRC = e.this.dVh.aRC();
                        afz.mk("adLanding").ai(com.baidu.swan.apps.core.d.f.cQm, com.baidu.swan.apps.core.d.f.cQo).a("adLanding", com.baidu.swan.apps.model.b.cf(aRC, aRC)).apk();
                        com.baidu.swan.game.ad.c.c.d(e.this.dVh, e.this.dVa);
                    }
                }
            });
        }
        this.dYh.kG(this.dYg.width);
        if (com.baidu.swan.games.view.a.c.aY(this.dYh.getConvertView())) {
            com.baidu.swan.games.view.a.c.removeView(this.dYh.getConvertView());
        }
        if (com.baidu.swan.games.view.a.c.c(this.dYh.getConvertView(), new com.baidu.swan.apps.model.a.a.a(ah.O(this.dYg.left), ah.O(this.dYg.top), ah.O(this.dYg.realWidth), ah.O(this.dYg.realHeight)))) {
            if (this.dYf != null) {
                this.dYf.onLoad();
            }
        } else if (this.dYf != null) {
            this.dYf.onError("3010000");
        }
    }

    private void loadAd() {
        com.baidu.swan.game.ad.b.d cVar;
        com.baidu.swan.apps.runtime.e aIr = com.baidu.swan.apps.runtime.e.aIr();
        String str = "";
        if (aIr != null) {
            str = aIr.getAppKey();
        }
        com.baidu.swan.game.ad.b.b aRT = new b.a().uY(this.dWK).uZ(this.dUD).va(str).kL(this.dYg.width).kM(this.dYg.height).aRT();
        if (this.dWB) {
            cVar = new com.baidu.swan.game.ad.b.e(this.mContext, aRT, 1, aSs());
            com.baidu.swan.games.view.a.b.dr("gdtbanner", null);
        } else {
            cVar = new com.baidu.swan.game.ad.b.c(this.mContext, aRT);
            this.dXg = cVar.aRY();
            com.baidu.swan.games.view.a.b.dr("banner", null);
        }
        com.baidu.swan.game.ad.b.a aVar = new com.baidu.swan.game.ad.b.a(this.mContext, this.dWB);
        aVar.a(this);
        aVar.a(cVar, this.dVa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSr() {
        if (this.dYg != null) {
            if (ah.O(this.dYg.width) < 300) {
                this.dYg.width = ah.Q(300.0f);
            }
            int aZe = com.baidu.swan.games.view.a.c.aZe();
            int aZf = com.baidu.swan.games.view.a.c.aZf();
            if (ah.O(this.dYg.width) > aZe) {
                this.dYg.width = ah.Q(aZe);
            }
            this.dYg.height = (int) (this.dYg.width / com.baidu.swan.game.ad.d.d.dXI);
            if (this.dYg.left < 0) {
                this.dYg.left = 0;
            }
            int Q = ah.Q(aZe) - this.dYg.width;
            if (this.dYg.left > Q) {
                this.dYg.left = Q;
            }
            if (this.dYg.top < 0) {
                this.dYg.top = 0;
            }
            int Q2 = ah.Q(aZf) - this.dYg.height;
            if (this.dYg.top > Q2) {
                this.dYg.top = Q2;
            }
            this.dYg.realWidth = this.dYg.width;
            this.dYg.realHeight = this.dYg.height;
        }
    }

    private int aSs() {
        if (this.dYg == null) {
            return 2;
        }
        int Q = ah.Q(com.baidu.swan.games.view.a.c.aZf());
        if (this.dYg.top < Q / 3) {
            return 1;
        }
        return this.dYg.top < (Q / 3) * 2 ? 4 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aW(View view) {
        if (this.dWB && this.dVh != null && this.dYg != null && view != null) {
            com.baidu.swan.game.ad.c.d.d(this.dVh, this.dVa);
            com.baidu.swan.game.ad.c.b bVar = new com.baidu.swan.game.ad.c.b();
            bVar.dXp = String.valueOf(this.dYg.width);
            bVar.dXq = String.valueOf(this.dYg.height);
            bVar.dXr = String.valueOf(this.dYg.width);
            bVar.dXs = String.valueOf(this.dYg.height);
            bVar.dXt = String.valueOf((int) view.getX());
            bVar.dXu = String.valueOf((int) view.getY());
            bVar.dXv = String.valueOf((int) view.getX());
            bVar.dXw = String.valueOf((int) view.getY());
            if (this.dVh.getActionType() == 2) {
                com.baidu.swan.game.ad.c.d.a(bVar, this.dVh, this.dVa, new a.d() { // from class: com.baidu.swan.game.ad.e.e.8
                    @Override // com.baidu.swan.game.ad.a.a.d
                    public void aV(View view2) {
                    }

                    @Override // com.baidu.swan.game.ad.a.a.d
                    public void cS(String str, String str2) {
                        if (!TextUtils.isEmpty(str2)) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("url", str2);
                                if (e.this.dYj == null) {
                                    e.this.dYj = new g(e.this.mContext, e.this.dVh, e.this.dVa);
                                }
                                e.this.dYj.ql(str);
                                com.baidu.swan.apps.t.a.awI().a(e.this.mContext, jSONObject, SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, e.this.dYj);
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
            com.baidu.swan.apps.core.d.f afz = com.baidu.swan.apps.v.f.azN().afz();
            if (afz == null) {
                if (this.mContext != null) {
                    com.baidu.swan.apps.res.widget.b.d.u(this.mContext, a.h.aiapps_open_fragment_failed_toast).aHZ();
                }
            } else if (this.dVh != null) {
                String a2 = com.baidu.swan.game.ad.c.d.a(this.dVh.aRC(), bVar);
                afz.mk("adLanding").ai(com.baidu.swan.apps.core.d.f.cQm, com.baidu.swan.apps.core.d.f.cQo).a("adLanding", com.baidu.swan.apps.model.b.cf(a2, a2)).apk();
            }
        }
    }
}
