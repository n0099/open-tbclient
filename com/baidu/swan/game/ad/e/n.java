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
/* loaded from: classes14.dex */
public class n extends EventTargetImpl implements com.baidu.swan.games.a.c {
    @V8JavascriptField
    public String adUnitId;
    private String dNk;
    private j dPf;
    private boolean dPp;
    private h dPt;

    public n(com.baidu.swan.games.f.b bVar, JsObject jsObject) {
        super(bVar);
        this.adUnitId = "";
        this.dPf = new j() { // from class: com.baidu.swan.game.ad.e.n.1
            @Override // com.baidu.swan.game.ad.e.j
            public void onLoad() {
                n.this.dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
            }

            @Override // com.baidu.swan.game.ad.e.j
            public void onError(String str) {
                JSEvent jSEvent = new JSEvent(BdStatsConstant.StatsType.ERROR);
                jSEvent.data = m.vN(str);
                n.this.dispatchEvent(jSEvent);
            }

            @Override // com.baidu.swan.game.ad.e.j
            public void hk(boolean z) {
                JSEvent jSEvent = new JSEvent("close");
                jSEvent.data = m.hl(z);
                n.this.dispatchEvent(jSEvent);
            }
        };
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e != null) {
            this.adUnitId = e.optString("adUnitId");
            this.dNk = e.optString("appSid");
        }
        if (e == null || TextUtils.isEmpty(this.adUnitId) || TextUtils.isEmpty(this.dNk)) {
            bVar.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
            return;
        }
        this.dPp = com.baidu.swan.game.ad.d.f.aRg();
        if (this.dPp) {
            this.dNk = com.baidu.swan.game.ad.d.f.aRj();
            this.adUnitId = com.baidu.swan.game.ad.d.f.aRk();
        }
        this.dPt = new h(this.dNk, this.adUnitId, this.dPp);
        this.dPt.a(this.dPf);
        loadAd(null);
    }

    @Override // com.baidu.swan.games.a.c
    @JavascriptInterface
    public synchronized void loadAd(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.dPt != null) {
            this.dPt.b(e);
        }
    }

    @Override // com.baidu.swan.games.a.c
    @JavascriptInterface
    public synchronized void showAd(JsObject jsObject) {
        com.baidu.swan.games.view.a.b.xW(this.dPt.getType());
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.dPt != null) {
            this.dPt.c(e);
        }
    }
}
