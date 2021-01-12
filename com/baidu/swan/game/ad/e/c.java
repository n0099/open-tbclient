package com.baidu.swan.game.ad.e;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.img.effect.ResizeImageAction;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.game.ad.a;
import com.baidu.swan.game.ad.e.f;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
/* loaded from: classes14.dex */
public class c extends EventTargetImpl implements a.InterfaceC0501a, f.a, com.baidu.swan.games.a.b {
    @V8JavascriptField
    public String adUnitId;
    private String dWK;
    private com.baidu.swan.games.f.b dYa;
    private e dYb;
    private boolean dYc;
    private i dYd;
    public boolean isDestroyed;
    private String mErrorCode;
    @V8JavascriptField
    public f style;

    public c(com.baidu.swan.games.f.b bVar, JsObject jsObject) {
        super(bVar);
        this.style = null;
        this.dYd = new i() { // from class: com.baidu.swan.game.ad.e.c.2
            @Override // com.baidu.swan.game.ad.e.i
            public void onLoad() {
                c.this.dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
            }

            @Override // com.baidu.swan.game.ad.e.i
            public void onError(String str) {
                JSEvent jSEvent = new JSEvent(BdStatsConstant.StatsType.ERROR);
                jSEvent.data = d.vd(str);
                c.this.dispatchEvent(jSEvent);
            }

            @Override // com.baidu.swan.game.ad.e.i
            public void a(f fVar) {
                JSEvent jSEvent = new JSEvent(ResizeImageAction.ACTION_NAME);
                jSEvent.data = d.b(fVar);
                c.this.dispatchEvent(jSEvent);
            }
        };
        this.dYa = bVar;
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e != null) {
            this.adUnitId = e.optString("adUnitId");
            this.dWK = e.optString("appSid");
            com.baidu.swan.games.binding.model.c vV = e.vV("style");
            if (vV != null) {
                this.style = new f(vV);
            }
        }
        this.dYc = com.baidu.swan.game.ad.d.f.aSc();
        if (this.dYc) {
            this.dWK = com.baidu.swan.game.ad.d.f.aSf();
            this.adUnitId = com.baidu.swan.game.ad.d.f.aSg();
        }
        if (aSm()) {
            if (e == null || TextUtils.isEmpty(this.adUnitId) || TextUtils.isEmpty(this.dWK) || this.style == null) {
                bVar.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
                return;
            }
            this.dYb = new e(this.dWK, this.adUnitId, this.style, this, this.dYc);
            this.dYb.a(this.dYd);
            if (this.style != null) {
                this.style.a(this);
            }
        }
    }

    private boolean aSm() {
        if (TextUtils.isEmpty(this.mErrorCode)) {
            com.baidu.swan.games.utils.c aYs = com.baidu.swan.games.utils.c.aYs();
            if (!aYs.aYA()) {
                if (!aYs.aYB()) {
                    if (aYs.xe(this.adUnitId)) {
                        this.mErrorCode = "3010011";
                    }
                } else {
                    this.mErrorCode = "3010013";
                }
            } else {
                this.mErrorCode = "3010012";
            }
        }
        if (!TextUtils.isEmpty(this.mErrorCode)) {
            this.dYa.postOnJSThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.c.1
                @Override // java.lang.Runnable
                public void run() {
                    JSEvent jSEvent = new JSEvent(BdStatsConstant.StatsType.ERROR);
                    jSEvent.data = d.vd(c.this.mErrorCode);
                    c.this.dispatchEvent(jSEvent);
                }
            });
            com.baidu.swan.games.view.a.b.ah(this.dYc ? "gdtbanner" : "banner", "reject", this.mErrorCode);
            return false;
        }
        return true;
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void showAd(JsObject jsObject) {
        com.baidu.swan.games.view.a.b.xm(this.dYc ? "gdtbanner" : "banner");
        if (aSm() && this.dYb != null) {
            com.baidu.swan.games.utils.c.aYs().aYz();
            this.dYb.c(jsObject);
        }
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void hide() {
        if (this.dYb != null) {
            this.dYb.aSn();
        }
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void destroy() {
        this.isDestroyed = true;
        removeEventListener(BdStatsConstant.StatsType.ERROR, null);
        removeEventListener(TrackLoadSettingsAtom.TYPE, null);
        removeEventListener(ResizeImageAction.ACTION_NAME, null);
        if (this.dYb != null) {
            this.dYb.aSo();
            this.dYb = null;
        }
    }

    @Override // com.baidu.swan.game.ad.e.f.a
    public void vc(String str) {
        if (!this.isDestroyed && !TextUtils.isEmpty(str) && !str.equals("height") && this.style != null && this.dYb != null) {
            this.dYb.ve(str);
        }
    }

    @Override // com.baidu.swan.game.ad.a.InterfaceC0501a
    public void aQG() {
        destroy();
    }
}
