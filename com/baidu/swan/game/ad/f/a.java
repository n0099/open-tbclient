package com.baidu.swan.game.ad.f;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.img.effect.ResizeImageAction;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.game.ad.f.g;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
/* loaded from: classes2.dex */
public class a extends EventTargetImpl implements g.a, com.baidu.swan.games.a.b {
    public boolean WK;
    @V8JavascriptField
    public String adUnitId;
    private String bwB;
    private f bwC;
    private i bwD;
    @V8JavascriptField
    public g style;

    public a(com.baidu.swan.games.e.b bVar, JsObject jsObject) {
        super(bVar);
        this.style = null;
        this.bwD = new i() { // from class: com.baidu.swan.game.ad.f.a.1
            @Override // com.baidu.swan.game.ad.f.i
            public void a() {
                a.this.dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
            }

            @Override // com.baidu.swan.game.ad.f.i
            public void a(String str) {
                JSEvent jSEvent = new JSEvent(BdStatsConstant.StatsType.ERROR);
                jSEvent.data = e.a(str);
                a.this.dispatchEvent(jSEvent);
            }

            @Override // com.baidu.swan.game.ad.f.i
            public void a(g gVar) {
                JSEvent jSEvent = new JSEvent(ResizeImageAction.ACTION_NAME);
                jSEvent.data = e.b(gVar);
                a.this.dispatchEvent(jSEvent);
            }
        };
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (c != null) {
            this.adUnitId = c.optString("adUnitId");
            this.bwB = c.optString("appSid");
            JsObject jE = c.jE("style");
            if (jE != null) {
                this.style = new g(jE);
            }
        }
        if (c == null || TextUtils.isEmpty(this.adUnitId) || TextUtils.isEmpty(this.bwB) || this.style == null) {
            bVar.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
            return;
        }
        this.bwC = new f(this.bwB, this.adUnitId, this.style);
        this.bwC.a(this.bwD);
        if (this.style != null) {
            this.style.a(this);
        }
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void showAd(JsObject jsObject) {
        com.baidu.swan.games.view.a.b.kH("banner");
        if (this.bwC != null) {
            this.bwC.a(jsObject);
        }
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void hide() {
        if (this.bwC != null) {
            this.bwC.a();
        }
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void destroy() {
        this.WK = true;
        removeEventListener(BdStatsConstant.StatsType.ERROR, null);
        removeEventListener(TrackLoadSettingsAtom.TYPE, null);
        removeEventListener(ResizeImageAction.ACTION_NAME, null);
        if (this.bwC != null) {
            this.bwC.b();
            this.bwC = null;
        }
    }

    @Override // com.baidu.swan.game.ad.f.g.a
    public void jp(String str) {
        if (!this.WK && !TextUtils.isEmpty(str) && !str.equals("height") && this.style != null && this.bwC != null) {
            this.bwC.b(str);
        }
    }
}
