package com.baidu.swan.game.ad.e;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
/* loaded from: classes5.dex */
public class n extends EventTargetImpl implements com.baidu.swan.games.a.c {
    @V8JavascriptField
    public String adUnitId;
    private String eas;
    private h ecC;
    private j eco;
    private boolean ecy;

    public n(com.baidu.swan.games.f.b bVar, JsObject jsObject) {
        super(bVar);
        this.adUnitId = "";
        this.eco = new j() { // from class: com.baidu.swan.game.ad.e.n.1
            @Override // com.baidu.swan.game.ad.e.j
            public void onLoad() {
                n.this.dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
            }

            @Override // com.baidu.swan.game.ad.e.j
            public void onError(String str) {
                JSEvent jSEvent = new JSEvent(BdStatsConstant.StatsType.ERROR);
                jSEvent.data = m.vD(str);
                n.this.dispatchEvent(jSEvent);
            }

            @Override // com.baidu.swan.game.ad.e.j
            public void hS(boolean z) {
                JSEvent jSEvent = new JSEvent("close");
                jSEvent.data = m.hT(z);
                n.this.dispatchEvent(jSEvent);
            }
        };
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e != null) {
            this.adUnitId = e.optString("adUnitId");
            this.eas = e.optString("appSid");
        }
        if (e == null || TextUtils.isEmpty(this.adUnitId) || TextUtils.isEmpty(this.eas)) {
            bVar.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
            return;
        }
        this.ecy = com.baidu.swan.game.ad.d.f.aSt();
        if (this.ecy) {
            this.eas = com.baidu.swan.game.ad.d.f.aSw();
            this.adUnitId = com.baidu.swan.game.ad.d.f.aSx();
        }
        this.ecC = new h(this.eas, this.adUnitId, this.ecy);
        this.ecC.a(this.eco);
        loadAd(null);
    }

    @Override // com.baidu.swan.games.a.c
    @JavascriptInterface
    public synchronized void loadAd(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.ecC != null) {
            this.ecC.b(e);
        }
    }

    @Override // com.baidu.swan.games.a.c
    @JavascriptInterface
    public synchronized void showAd(JsObject jsObject) {
        com.baidu.swan.games.view.a.b.xM(this.ecC.getType());
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.ecC != null) {
            this.ecC.c(e);
        }
    }
}
