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
    private String cRd;
    private i cSp;
    private g cSv;

    public m(com.baidu.swan.games.f.b bVar, JsObject jsObject) {
        super(bVar);
        this.adUnitId = "";
        this.cSp = new i() { // from class: com.baidu.swan.game.ad.f.m.1
            @Override // com.baidu.swan.game.ad.f.i
            public void onLoad() {
                m.this.dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
            }

            @Override // com.baidu.swan.game.ad.f.i
            public void onError(String str) {
                JSEvent jSEvent = new JSEvent(BdStatsConstant.StatsType.ERROR);
                jSEvent.data = l.qF(str);
                m.this.dispatchEvent(jSEvent);
            }

            @Override // com.baidu.swan.game.ad.f.i
            public void fD(boolean z) {
                JSEvent jSEvent = new JSEvent("close");
                jSEvent.data = l.fE(z);
                m.this.dispatchEvent(jSEvent);
            }
        };
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e != null) {
            this.adUnitId = e.optString("adUnitId");
            this.cRd = e.optString("appSid");
        }
        if (e == null || TextUtils.isEmpty(this.adUnitId) || TextUtils.isEmpty(this.cRd)) {
            bVar.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
            return;
        }
        this.cSv = new g(this.cRd, this.adUnitId);
        this.cSv.a(this.cSp);
        loadAd(null);
    }

    @Override // com.baidu.swan.games.a.c
    @JavascriptInterface
    public synchronized void loadAd(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.cSv != null) {
            this.cSv.b(e);
        }
    }

    @Override // com.baidu.swan.games.a.c
    @JavascriptInterface
    public synchronized void showAd(JsObject jsObject) {
        com.baidu.swan.games.view.a.b.sI("video");
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (this.cSv != null) {
            this.cSv.c(e);
        }
    }
}
