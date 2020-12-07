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
public class c extends EventTargetImpl implements a.InterfaceC0525a, f.a, com.baidu.swan.games.a.b {
    public boolean aXc;
    @V8JavascriptField
    public String adUnitId;
    private String dSz;
    private com.baidu.swan.games.f.b dTP;
    private e dTQ;
    private boolean dTR;
    private i dTS;
    private String mErrorCode;
    @V8JavascriptField
    public f style;

    public c(com.baidu.swan.games.f.b bVar, JsObject jsObject) {
        super(bVar);
        this.style = null;
        this.dTS = new i() { // from class: com.baidu.swan.game.ad.e.c.2
            @Override // com.baidu.swan.game.ad.e.i
            public void onLoad() {
                c.this.dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
            }

            @Override // com.baidu.swan.game.ad.e.i
            public void onError(String str) {
                JSEvent jSEvent = new JSEvent(BdStatsConstant.StatsType.ERROR);
                jSEvent.data = d.wp(str);
                c.this.dispatchEvent(jSEvent);
            }

            @Override // com.baidu.swan.game.ad.e.i
            public void a(f fVar) {
                JSEvent jSEvent = new JSEvent(ResizeImageAction.ACTION_NAME);
                jSEvent.data = d.b(fVar);
                c.this.dispatchEvent(jSEvent);
            }
        };
        this.dTP = bVar;
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e != null) {
            this.adUnitId = e.optString("adUnitId");
            this.dSz = e.optString("appSid");
            com.baidu.swan.games.binding.model.c xh = e.xh("style");
            if (xh != null) {
                this.style = new f(xh);
            }
        }
        this.dTR = com.baidu.swan.game.ad.d.f.aTB();
        if (this.dTR) {
            this.dSz = com.baidu.swan.game.ad.d.f.aTE();
            this.adUnitId = com.baidu.swan.game.ad.d.f.aTF();
        }
        if (aTL()) {
            if (e == null || TextUtils.isEmpty(this.adUnitId) || TextUtils.isEmpty(this.dSz) || this.style == null) {
                bVar.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
                return;
            }
            this.dTQ = new e(this.dSz, this.adUnitId, this.style, this, this.dTR);
            this.dTQ.a(this.dTS);
            if (this.style != null) {
                this.style.a(this);
            }
        }
    }

    private boolean aTL() {
        if (TextUtils.isEmpty(this.mErrorCode)) {
            com.baidu.swan.games.utils.c aZR = com.baidu.swan.games.utils.c.aZR();
            if (!aZR.aZZ()) {
                if (!aZR.baa()) {
                    if (aZR.yq(this.adUnitId)) {
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
            this.dTP.postOnJSThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.c.1
                @Override // java.lang.Runnable
                public void run() {
                    JSEvent jSEvent = new JSEvent(BdStatsConstant.StatsType.ERROR);
                    jSEvent.data = d.wp(c.this.mErrorCode);
                    c.this.dispatchEvent(jSEvent);
                }
            });
            com.baidu.swan.games.view.a.b.af(this.dTR ? "gdtbanner" : "banner", "reject", this.mErrorCode);
            return false;
        }
        return true;
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void showAd(JsObject jsObject) {
        com.baidu.swan.games.view.a.b.yy(this.dTR ? "gdtbanner" : "banner");
        if (aTL() && this.dTQ != null) {
            com.baidu.swan.games.utils.c.aZR().aZY();
            this.dTQ.c(jsObject);
        }
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void hide() {
        if (this.dTQ != null) {
            this.dTQ.aTM();
        }
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void destroy() {
        this.aXc = true;
        removeEventListener(BdStatsConstant.StatsType.ERROR, null);
        removeEventListener(TrackLoadSettingsAtom.TYPE, null);
        removeEventListener(ResizeImageAction.ACTION_NAME, null);
        if (this.dTQ != null) {
            this.dTQ.aTN();
            this.dTQ = null;
        }
    }

    @Override // com.baidu.swan.game.ad.e.f.a
    public void wo(String str) {
        if (!this.aXc && !TextUtils.isEmpty(str) && !str.equals("height") && this.style != null && this.dTQ != null) {
            this.dTQ.wq(str);
        }
    }

    @Override // com.baidu.swan.game.ad.a.InterfaceC0525a
    public void aSf() {
        destroy();
    }
}
