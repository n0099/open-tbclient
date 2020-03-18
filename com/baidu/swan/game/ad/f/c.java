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
import com.baidu.swan.game.ad.a;
import com.baidu.swan.game.ad.f.f;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
/* loaded from: classes11.dex */
public class c extends EventTargetImpl implements a.InterfaceC0326a, f.a, com.baidu.swan.games.a.b {
    @V8JavascriptField
    public String adUnitId;
    private String chR;
    private com.baidu.swan.games.e.b ciK;
    private e ciL;
    private h ciM;
    public boolean isDestroyed;
    private String mErrorCode;
    @V8JavascriptField
    public f style;

    public c(com.baidu.swan.games.e.b bVar, JsObject jsObject) {
        super(bVar);
        this.style = null;
        this.ciM = new h() { // from class: com.baidu.swan.game.ad.f.c.2
            @Override // com.baidu.swan.game.ad.f.h
            public void onLoad() {
                c.this.dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
            }

            @Override // com.baidu.swan.game.ad.f.h
            public void onError(String str) {
                JSEvent jSEvent = new JSEvent(BdStatsConstant.StatsType.ERROR);
                jSEvent.data = d.nS(str);
                c.this.dispatchEvent(jSEvent);
            }

            @Override // com.baidu.swan.game.ad.f.h
            public void a(f fVar) {
                JSEvent jSEvent = new JSEvent(ResizeImageAction.ACTION_NAME);
                jSEvent.data = d.b(fVar);
                c.this.dispatchEvent(jSEvent);
            }
        };
        this.ciK = bVar;
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (c != null) {
            this.adUnitId = c.optString("adUnitId");
            this.chR = c.optString("appSid");
            com.baidu.swan.games.binding.model.c oF = c.oF("style");
            if (oF != null) {
                this.style = new f(oF);
            }
        }
        if (akH()) {
            if (c == null || TextUtils.isEmpty(this.adUnitId) || TextUtils.isEmpty(this.chR) || this.style == null) {
                bVar.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
                return;
            }
            this.ciL = new e(this.chR, this.adUnitId, this.style, this);
            this.ciL.a(this.ciM);
            if (this.style != null) {
                this.style.a(this);
            }
        }
    }

    private boolean akH() {
        if (TextUtils.isEmpty(this.mErrorCode)) {
            com.baidu.swan.games.utils.c apY = com.baidu.swan.games.utils.c.apY();
            if (!apY.aqg()) {
                if (!apY.aqh()) {
                    if (apY.pO(this.adUnitId)) {
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
            this.ciK.postOnJSThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.c.1
                @Override // java.lang.Runnable
                public void run() {
                    JSEvent jSEvent = new JSEvent(BdStatsConstant.StatsType.ERROR);
                    jSEvent.data = d.nS(c.this.mErrorCode);
                    c.this.dispatchEvent(jSEvent);
                }
            });
            com.baidu.swan.games.view.a.b.N("banner", "reject", this.mErrorCode);
            return false;
        }
        return true;
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void showAd(JsObject jsObject) {
        com.baidu.swan.games.view.a.b.pR("banner");
        if (akH() && this.ciL != null) {
            com.baidu.swan.games.utils.c.apY().aqf();
            this.ciL.a(jsObject);
        }
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void hide() {
        if (this.ciL != null) {
            this.ciL.akI();
        }
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void destroy() {
        this.isDestroyed = true;
        removeEventListener(BdStatsConstant.StatsType.ERROR, null);
        removeEventListener(TrackLoadSettingsAtom.TYPE, null);
        removeEventListener(ResizeImageAction.ACTION_NAME, null);
        if (this.ciL != null) {
            this.ciL.akJ();
            this.ciL = null;
        }
    }

    @Override // com.baidu.swan.game.ad.f.f.a
    public void nR(String str) {
        if (!this.isDestroyed && !TextUtils.isEmpty(str) && !str.equals("height") && this.style != null && this.ciL != null) {
            this.ciL.nT(str);
        }
    }

    @Override // com.baidu.swan.game.ad.a.InterfaceC0326a
    public void aka() {
        destroy();
    }
}
