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
public class c extends EventTargetImpl implements a.InterfaceC0417a, f.a, com.baidu.swan.games.a.b {
    public boolean aFg;
    @V8JavascriptField
    public String adUnitId;
    private com.baidu.swan.games.f.b cRV;
    private e cRW;
    private h cRX;
    private String cRd;
    private String mErrorCode;
    @V8JavascriptField
    public f style;

    public c(com.baidu.swan.games.f.b bVar, JsObject jsObject) {
        super(bVar);
        this.style = null;
        this.cRX = new h() { // from class: com.baidu.swan.game.ad.f.c.2
            @Override // com.baidu.swan.game.ad.f.h
            public void onLoad() {
                c.this.dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
            }

            @Override // com.baidu.swan.game.ad.f.h
            public void onError(String str) {
                JSEvent jSEvent = new JSEvent(BdStatsConstant.StatsType.ERROR);
                jSEvent.data = d.qF(str);
                c.this.dispatchEvent(jSEvent);
            }

            @Override // com.baidu.swan.game.ad.f.h
            public void a(f fVar) {
                JSEvent jSEvent = new JSEvent(ResizeImageAction.ACTION_NAME);
                jSEvent.data = d.b(fVar);
                c.this.dispatchEvent(jSEvent);
            }
        };
        this.cRV = bVar;
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e != null) {
            this.adUnitId = e.optString("adUnitId");
            this.cRd = e.optString("appSid");
            com.baidu.swan.games.binding.model.c ru = e.ru("style");
            if (ru != null) {
                this.style = new f(ru);
            }
        }
        if (awA()) {
            if (e == null || TextUtils.isEmpty(this.adUnitId) || TextUtils.isEmpty(this.cRd) || this.style == null) {
                bVar.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
                return;
            }
            this.cRW = new e(this.cRd, this.adUnitId, this.style, this);
            this.cRW.a(this.cRX);
            if (this.style != null) {
                this.style.a(this);
            }
        }
    }

    private boolean awA() {
        if (TextUtils.isEmpty(this.mErrorCode)) {
            com.baidu.swan.games.utils.c aCc = com.baidu.swan.games.utils.c.aCc();
            if (!aCc.aCk()) {
                if (!aCc.aCl()) {
                    if (aCc.sF(this.adUnitId)) {
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
            this.cRV.postOnJSThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.c.1
                @Override // java.lang.Runnable
                public void run() {
                    JSEvent jSEvent = new JSEvent(BdStatsConstant.StatsType.ERROR);
                    jSEvent.data = d.qF(c.this.mErrorCode);
                    c.this.dispatchEvent(jSEvent);
                }
            });
            com.baidu.swan.games.view.a.b.Q("banner", "reject", this.mErrorCode);
            return false;
        }
        return true;
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void showAd(JsObject jsObject) {
        com.baidu.swan.games.view.a.b.sI("banner");
        if (awA() && this.cRW != null) {
            com.baidu.swan.games.utils.c.aCc().aCj();
            this.cRW.c(jsObject);
        }
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void hide() {
        if (this.cRW != null) {
            this.cRW.awB();
        }
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void destroy() {
        this.aFg = true;
        removeEventListener(BdStatsConstant.StatsType.ERROR, null);
        removeEventListener(TrackLoadSettingsAtom.TYPE, null);
        removeEventListener(ResizeImageAction.ACTION_NAME, null);
        if (this.cRW != null) {
            this.cRW.awC();
            this.cRW = null;
        }
    }

    @Override // com.baidu.swan.game.ad.f.f.a
    public void qE(String str) {
        if (!this.aFg && !TextUtils.isEmpty(str) && !str.equals("height") && this.style != null && this.cRW != null) {
            this.cRW.qG(str);
        }
    }

    @Override // com.baidu.swan.game.ad.a.InterfaceC0417a
    public void avQ() {
        destroy();
    }
}
