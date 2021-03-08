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
/* loaded from: classes5.dex */
public class c extends EventTargetImpl implements a.InterfaceC0504a, f.a, com.baidu.swan.games.a.b {
    @V8JavascriptField
    public String adUnitId;
    private String eas;
    private com.baidu.swan.games.f.b ebI;
    private e ebJ;
    private boolean ebK;
    private i ebL;
    public boolean isDestroyed;
    private String mErrorCode;
    @V8JavascriptField
    public f style;

    public c(com.baidu.swan.games.f.b bVar, JsObject jsObject) {
        super(bVar);
        this.style = null;
        this.ebL = new i() { // from class: com.baidu.swan.game.ad.e.c.2
            @Override // com.baidu.swan.game.ad.e.i
            public void onLoad() {
                c.this.dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
            }

            @Override // com.baidu.swan.game.ad.e.i
            public void onError(String str) {
                JSEvent jSEvent = new JSEvent(BdStatsConstant.StatsType.ERROR);
                jSEvent.data = d.vD(str);
                c.this.dispatchEvent(jSEvent);
            }

            @Override // com.baidu.swan.game.ad.e.i
            public void a(f fVar) {
                JSEvent jSEvent = new JSEvent(ResizeImageAction.ACTION_NAME);
                jSEvent.data = d.b(fVar);
                c.this.dispatchEvent(jSEvent);
            }
        };
        this.ebI = bVar;
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e != null) {
            this.adUnitId = e.optString("adUnitId");
            this.eas = e.optString("appSid");
            com.baidu.swan.games.binding.model.c wv = e.wv("style");
            if (wv != null) {
                this.style = new f(wv);
            }
        }
        this.ebK = com.baidu.swan.game.ad.d.f.aSr();
        if (this.ebK) {
            this.eas = com.baidu.swan.game.ad.d.f.aSu();
            this.adUnitId = com.baidu.swan.game.ad.d.f.aSv();
        }
        if (aSB()) {
            if (e == null || TextUtils.isEmpty(this.adUnitId) || TextUtils.isEmpty(this.eas) || this.style == null) {
                bVar.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
                return;
            }
            this.ebJ = new e(this.eas, this.adUnitId, this.style, this, this.ebK);
            this.ebJ.a(this.ebL);
            if (this.style != null) {
                this.style.a(this);
            }
        }
    }

    private boolean aSB() {
        if (TextUtils.isEmpty(this.mErrorCode)) {
            com.baidu.swan.games.utils.c aYH = com.baidu.swan.games.utils.c.aYH();
            if (!aYH.aYP()) {
                if (!aYH.aYQ()) {
                    if (aYH.xE(this.adUnitId)) {
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
            this.ebI.postOnJSThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.c.1
                @Override // java.lang.Runnable
                public void run() {
                    JSEvent jSEvent = new JSEvent(BdStatsConstant.StatsType.ERROR);
                    jSEvent.data = d.vD(c.this.mErrorCode);
                    c.this.dispatchEvent(jSEvent);
                }
            });
            com.baidu.swan.games.view.a.b.ai(this.ebK ? "gdtbanner" : "banner", "reject", this.mErrorCode);
            return false;
        }
        return true;
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void showAd(JsObject jsObject) {
        com.baidu.swan.games.view.a.b.xM(this.ebK ? "gdtbanner" : "banner");
        if (aSB() && this.ebJ != null) {
            com.baidu.swan.games.utils.c.aYH().aYO();
            this.ebJ.c(jsObject);
        }
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void hide() {
        if (this.ebJ != null) {
            this.ebJ.aSC();
        }
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void destroy() {
        this.isDestroyed = true;
        removeEventListener(BdStatsConstant.StatsType.ERROR, null);
        removeEventListener(TrackLoadSettingsAtom.TYPE, null);
        removeEventListener(ResizeImageAction.ACTION_NAME, null);
        if (this.ebJ != null) {
            this.ebJ.aSD();
            this.ebJ = null;
        }
    }

    @Override // com.baidu.swan.game.ad.e.f.a
    public void vC(String str) {
        if (!this.isDestroyed && !TextUtils.isEmpty(str) && !str.equals("height") && this.style != null && this.ebJ != null) {
            this.ebJ.vE(str);
        }
    }

    @Override // com.baidu.swan.game.ad.a.InterfaceC0504a
    public void aRc() {
        destroy();
    }
}
