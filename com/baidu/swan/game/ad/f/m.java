package com.baidu.swan.game.ad.f;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
/* loaded from: classes11.dex */
public class m extends EventTargetImpl implements com.baidu.swan.games.a.c {
    @V8JavascriptField
    public String adUnitId;
    private String chR;
    private i cje;
    private g cjk;

    public m(com.baidu.swan.games.e.b bVar, JsObject jsObject) {
        super(bVar);
        this.adUnitId = "";
        this.cje = new i() { // from class: com.baidu.swan.game.ad.f.m.1
            @Override // com.baidu.swan.game.ad.f.i
            public void onLoad() {
                m.this.dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
            }

            @Override // com.baidu.swan.game.ad.f.i
            public void onError(String str) {
                JSEvent jSEvent = new JSEvent(BdStatsConstant.StatsType.ERROR);
                jSEvent.data = l.nS(str);
                m.this.dispatchEvent(jSEvent);
            }

            @Override // com.baidu.swan.game.ad.f.i
            public void ew(boolean z) {
                JSEvent jSEvent = new JSEvent("close");
                jSEvent.data = l.ex(z);
                m.this.dispatchEvent(jSEvent);
            }
        };
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (c != null) {
            this.adUnitId = c.optString("adUnitId");
            this.chR = c.optString("appSid");
        }
        if (c == null || TextUtils.isEmpty(this.adUnitId) || TextUtils.isEmpty(this.chR)) {
            bVar.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
            return;
        }
        this.cjk = new g(this.chR, this.adUnitId);
        this.cjk.a(this.cje);
        loadAd(null);
    }

    @Override // com.baidu.swan.games.a.c
    @JavascriptInterface
    public synchronized void loadAd(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (this.cjk != null) {
            this.cjk.b(c);
        }
    }

    @Override // com.baidu.swan.games.a.c
    @JavascriptInterface
    public synchronized void showAd(JsObject jsObject) {
        com.baidu.swan.games.view.a.b.pR("video");
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (this.cjk != null) {
            this.cjk.c(c);
        }
    }
}
