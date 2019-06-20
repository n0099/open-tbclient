package com.baidu.swan.game.ad.f;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
/* loaded from: classes2.dex */
public class b extends EventTargetImpl implements com.baidu.swan.games.a.c {
    @V8JavascriptField
    public String adUnitId;
    private String bdm;
    private h bdq;
    private j bdr;

    public b(com.baidu.swan.games.e.b bVar, JsObject jsObject) {
        super(bVar);
        this.adUnitId = "";
        this.bdr = new j() { // from class: com.baidu.swan.game.ad.f.b.1
            @Override // com.baidu.swan.game.ad.f.j
            public void a() {
                b.this.dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
            }

            @Override // com.baidu.swan.game.ad.f.j
            public void a(String str) {
                JSEvent jSEvent = new JSEvent("error");
                jSEvent.data = m.a(str);
                b.this.dispatchEvent(jSEvent);
            }

            @Override // com.baidu.swan.game.ad.f.j
            public void a(boolean z) {
                JSEvent jSEvent = new JSEvent("close");
                jSEvent.data = m.cI(z);
                b.this.dispatchEvent(jSEvent);
            }
        };
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (c != null) {
            this.adUnitId = c.optString("adUnitId");
            this.bdm = c.optString("appSid");
        }
        if (c == null || TextUtils.isEmpty(this.adUnitId) || TextUtils.isEmpty(this.bdm)) {
            bVar.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
            return;
        }
        this.bdq = new h(this.bdm, this.adUnitId);
        this.bdq.a(this.bdr);
        loadAd(null);
    }

    @Override // com.baidu.swan.games.a.c
    @JavascriptInterface
    public synchronized void loadAd(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (this.bdq != null) {
            this.bdq.a(c);
        }
    }

    @Override // com.baidu.swan.games.a.c
    @JavascriptInterface
    public synchronized void showAd(JsObject jsObject) {
        com.baidu.swan.games.view.a.b.jV("video");
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (this.bdq != null) {
            this.bdq.b(c);
        }
    }
}
