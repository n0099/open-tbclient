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
/* loaded from: classes12.dex */
public class c extends EventTargetImpl implements a.InterfaceC0513a, f.a, com.baidu.swan.games.a.b {
    public boolean aTX;
    @V8JavascriptField
    public String adUnitId;
    private String dLC;
    private com.baidu.swan.games.f.b dMR;
    private e dMS;
    private boolean dMT;
    private i dMU;
    private String mErrorCode;
    @V8JavascriptField
    public f style;

    public c(com.baidu.swan.games.f.b bVar, JsObject jsObject) {
        super(bVar);
        this.style = null;
        this.dMU = new i() { // from class: com.baidu.swan.game.ad.e.c.2
            @Override // com.baidu.swan.game.ad.e.i
            public void onLoad() {
                c.this.dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
            }

            @Override // com.baidu.swan.game.ad.e.i
            public void onError(String str) {
                JSEvent jSEvent = new JSEvent(BdStatsConstant.StatsType.ERROR);
                jSEvent.data = d.vI(str);
                c.this.dispatchEvent(jSEvent);
            }

            @Override // com.baidu.swan.game.ad.e.i
            public void a(f fVar) {
                JSEvent jSEvent = new JSEvent(ResizeImageAction.ACTION_NAME);
                jSEvent.data = d.b(fVar);
                c.this.dispatchEvent(jSEvent);
            }
        };
        this.dMR = bVar;
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e != null) {
            this.adUnitId = e.optString("adUnitId");
            this.dLC = e.optString("appSid");
            com.baidu.swan.games.binding.model.c wA = e.wA("style");
            if (wA != null) {
                this.style = new f(wA);
            }
        }
        this.dMT = com.baidu.swan.game.ad.d.f.aQw();
        if (this.dMT) {
            this.dLC = com.baidu.swan.game.ad.d.f.aQz();
            this.adUnitId = com.baidu.swan.game.ad.d.f.aQA();
        }
        if (aQG()) {
            if (e == null || TextUtils.isEmpty(this.adUnitId) || TextUtils.isEmpty(this.dLC) || this.style == null) {
                bVar.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
                return;
            }
            this.dMS = new e(this.dLC, this.adUnitId, this.style, this, this.dMT);
            this.dMS.a(this.dMU);
            if (this.style != null) {
                this.style.a(this);
            }
        }
    }

    private boolean aQG() {
        if (TextUtils.isEmpty(this.mErrorCode)) {
            com.baidu.swan.games.utils.c aWM = com.baidu.swan.games.utils.c.aWM();
            if (!aWM.aWU()) {
                if (!aWM.aWV()) {
                    if (aWM.xJ(this.adUnitId)) {
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
            this.dMR.postOnJSThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.c.1
                @Override // java.lang.Runnable
                public void run() {
                    JSEvent jSEvent = new JSEvent(BdStatsConstant.StatsType.ERROR);
                    jSEvent.data = d.vI(c.this.mErrorCode);
                    c.this.dispatchEvent(jSEvent);
                }
            });
            com.baidu.swan.games.view.a.b.ac(this.dMT ? "gdtbanner" : "banner", "reject", this.mErrorCode);
            return false;
        }
        return true;
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void showAd(JsObject jsObject) {
        com.baidu.swan.games.view.a.b.xR(this.dMT ? "gdtbanner" : "banner");
        if (aQG() && this.dMS != null) {
            com.baidu.swan.games.utils.c.aWM().aWT();
            this.dMS.c(jsObject);
        }
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void hide() {
        if (this.dMS != null) {
            this.dMS.aQH();
        }
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void destroy() {
        this.aTX = true;
        removeEventListener(BdStatsConstant.StatsType.ERROR, null);
        removeEventListener(TrackLoadSettingsAtom.TYPE, null);
        removeEventListener(ResizeImageAction.ACTION_NAME, null);
        if (this.dMS != null) {
            this.dMS.aQI();
            this.dMS = null;
        }
    }

    @Override // com.baidu.swan.game.ad.e.f.a
    public void vH(String str) {
        if (!this.aTX && !TextUtils.isEmpty(str) && !str.equals("height") && this.style != null && this.dMS != null) {
            this.dMS.vJ(str);
        }
    }

    @Override // com.baidu.swan.game.ad.a.InterfaceC0513a
    public void aPa() {
        destroy();
    }
}
