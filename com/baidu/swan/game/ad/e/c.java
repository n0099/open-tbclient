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
/* loaded from: classes10.dex */
public class c extends EventTargetImpl implements a.InterfaceC0472a, f.a, com.baidu.swan.games.a.b {
    public boolean aQj;
    @V8JavascriptField
    public String adUnitId;
    private String dmP;
    private com.baidu.swan.games.f.b dog;
    private e doh;
    private boolean doi;
    private i doj;
    private String mErrorCode;
    @V8JavascriptField
    public f style;

    public c(com.baidu.swan.games.f.b bVar, JsObject jsObject) {
        super(bVar);
        this.style = null;
        this.doj = new i() { // from class: com.baidu.swan.game.ad.e.c.2
            @Override // com.baidu.swan.game.ad.e.i
            public void onLoad() {
                c.this.dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
            }

            @Override // com.baidu.swan.game.ad.e.i
            public void onError(String str) {
                JSEvent jSEvent = new JSEvent(BdStatsConstant.StatsType.ERROR);
                jSEvent.data = d.uu(str);
                c.this.dispatchEvent(jSEvent);
            }

            @Override // com.baidu.swan.game.ad.e.i
            public void a(f fVar) {
                JSEvent jSEvent = new JSEvent(ResizeImageAction.ACTION_NAME);
                jSEvent.data = d.b(fVar);
                c.this.dispatchEvent(jSEvent);
            }
        };
        this.dog = bVar;
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e != null) {
            this.adUnitId = e.optString("adUnitId");
            this.dmP = e.optString("appSid");
            com.baidu.swan.games.binding.model.c vm = e.vm("style");
            if (vm != null) {
                this.style = new f(vm);
            }
        }
        this.doi = com.baidu.swan.game.ad.d.f.aKb();
        if (this.doi) {
            this.dmP = com.baidu.swan.game.ad.d.f.aKe();
            this.adUnitId = com.baidu.swan.game.ad.d.f.aKf();
        }
        if (aKl()) {
            if (e == null || TextUtils.isEmpty(this.adUnitId) || TextUtils.isEmpty(this.dmP) || this.style == null) {
                bVar.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
                return;
            }
            this.doh = new e(this.dmP, this.adUnitId, this.style, this, this.doi);
            this.doh.a(this.doj);
            if (this.style != null) {
                this.style.a(this);
            }
        }
    }

    private boolean aKl() {
        if (TextUtils.isEmpty(this.mErrorCode)) {
            com.baidu.swan.games.utils.c aQr = com.baidu.swan.games.utils.c.aQr();
            if (!aQr.aQz()) {
                if (!aQr.aQA()) {
                    if (aQr.wv(this.adUnitId)) {
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
            this.dog.postOnJSThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.c.1
                @Override // java.lang.Runnable
                public void run() {
                    JSEvent jSEvent = new JSEvent(BdStatsConstant.StatsType.ERROR);
                    jSEvent.data = d.uu(c.this.mErrorCode);
                    c.this.dispatchEvent(jSEvent);
                }
            });
            com.baidu.swan.games.view.a.b.U(this.doi ? "gdtbanner" : "banner", "reject", this.mErrorCode);
            return false;
        }
        return true;
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void showAd(JsObject jsObject) {
        com.baidu.swan.games.view.a.b.wD(this.doi ? "gdtbanner" : "banner");
        if (aKl() && this.doh != null) {
            com.baidu.swan.games.utils.c.aQr().aQy();
            this.doh.c(jsObject);
        }
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void hide() {
        if (this.doh != null) {
            this.doh.aKm();
        }
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void destroy() {
        this.aQj = true;
        removeEventListener(BdStatsConstant.StatsType.ERROR, null);
        removeEventListener(TrackLoadSettingsAtom.TYPE, null);
        removeEventListener(ResizeImageAction.ACTION_NAME, null);
        if (this.doh != null) {
            this.doh.aKn();
            this.doh = null;
        }
    }

    @Override // com.baidu.swan.game.ad.e.f.a
    public void ut(String str) {
        if (!this.aQj && !TextUtils.isEmpty(str) && !str.equals("height") && this.style != null && this.doh != null) {
            this.doh.uv(str);
        }
    }

    @Override // com.baidu.swan.game.ad.a.InterfaceC0472a
    public void aIF() {
        destroy();
    }
}
