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
/* loaded from: classes19.dex */
public class c extends EventTargetImpl implements a.InterfaceC0477a, f.a, com.baidu.swan.games.a.b {
    public boolean aOi;
    @V8JavascriptField
    public String adUnitId;
    private String dkJ;
    private com.baidu.swan.games.f.b dlZ;
    private e dma;
    private boolean dmb;
    private i dmc;
    private String mErrorCode;
    @V8JavascriptField
    public f style;

    public c(com.baidu.swan.games.f.b bVar, JsObject jsObject) {
        super(bVar);
        this.style = null;
        this.dmc = new i() { // from class: com.baidu.swan.game.ad.e.c.2
            @Override // com.baidu.swan.game.ad.e.i
            public void onLoad() {
                c.this.dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
            }

            @Override // com.baidu.swan.game.ad.e.i
            public void onError(String str) {
                JSEvent jSEvent = new JSEvent(BdStatsConstant.StatsType.ERROR);
                jSEvent.data = d.ua(str);
                c.this.dispatchEvent(jSEvent);
            }

            @Override // com.baidu.swan.game.ad.e.i
            public void a(f fVar) {
                JSEvent jSEvent = new JSEvent(ResizeImageAction.ACTION_NAME);
                jSEvent.data = d.b(fVar);
                c.this.dispatchEvent(jSEvent);
            }
        };
        this.dlZ = bVar;
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e != null) {
            this.adUnitId = e.optString("adUnitId");
            this.dkJ = e.optString("appSid");
            com.baidu.swan.games.binding.model.c uS = e.uS("style");
            if (uS != null) {
                this.style = new f(uS);
            }
        }
        this.dmb = com.baidu.swan.game.ad.d.f.aJq();
        if (this.dmb) {
            this.dkJ = com.baidu.swan.game.ad.d.f.aJt();
            this.adUnitId = com.baidu.swan.game.ad.d.f.aJu();
        }
        if (aJA()) {
            if (e == null || TextUtils.isEmpty(this.adUnitId) || TextUtils.isEmpty(this.dkJ) || this.style == null) {
                bVar.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
                return;
            }
            this.dma = new e(this.dkJ, this.adUnitId, this.style, this, this.dmb);
            this.dma.a(this.dmc);
            if (this.style != null) {
                this.style.a(this);
            }
        }
    }

    private boolean aJA() {
        if (TextUtils.isEmpty(this.mErrorCode)) {
            com.baidu.swan.games.utils.c aPG = com.baidu.swan.games.utils.c.aPG();
            if (!aPG.aPO()) {
                if (!aPG.aPP()) {
                    if (aPG.wb(this.adUnitId)) {
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
            this.dlZ.postOnJSThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.c.1
                @Override // java.lang.Runnable
                public void run() {
                    JSEvent jSEvent = new JSEvent(BdStatsConstant.StatsType.ERROR);
                    jSEvent.data = d.ua(c.this.mErrorCode);
                    c.this.dispatchEvent(jSEvent);
                }
            });
            com.baidu.swan.games.view.a.b.U(this.dmb ? "gdtbanner" : "banner", "reject", this.mErrorCode);
            return false;
        }
        return true;
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void showAd(JsObject jsObject) {
        com.baidu.swan.games.view.a.b.wj(this.dmb ? "gdtbanner" : "banner");
        if (aJA() && this.dma != null) {
            com.baidu.swan.games.utils.c.aPG().aPN();
            this.dma.c(jsObject);
        }
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void hide() {
        if (this.dma != null) {
            this.dma.aJB();
        }
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void destroy() {
        this.aOi = true;
        removeEventListener(BdStatsConstant.StatsType.ERROR, null);
        removeEventListener(TrackLoadSettingsAtom.TYPE, null);
        removeEventListener(ResizeImageAction.ACTION_NAME, null);
        if (this.dma != null) {
            this.dma.aJC();
            this.dma = null;
        }
    }

    @Override // com.baidu.swan.game.ad.e.f.a
    public void tZ(String str) {
        if (!this.aOi && !TextUtils.isEmpty(str) && !str.equals("height") && this.style != null && this.dma != null) {
            this.dma.ub(str);
        }
    }

    @Override // com.baidu.swan.game.ad.a.InterfaceC0477a
    public void aHU() {
        destroy();
    }
}
