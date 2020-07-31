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
/* loaded from: classes9.dex */
public class c extends EventTargetImpl implements a.InterfaceC0430a, f.a, com.baidu.swan.games.a.b {
    public boolean aIX;
    @V8JavascriptField
    public String adUnitId;
    private String daz;
    private com.baidu.swan.games.f.b dbN;
    private e dbO;
    private boolean dbP;
    private i dbQ;
    private String mErrorCode;
    @V8JavascriptField
    public f style;

    public c(com.baidu.swan.games.f.b bVar, JsObject jsObject) {
        super(bVar);
        this.style = null;
        this.dbQ = new i() { // from class: com.baidu.swan.game.ad.e.c.2
            @Override // com.baidu.swan.game.ad.e.i
            public void onLoad() {
                c.this.dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
            }

            @Override // com.baidu.swan.game.ad.e.i
            public void onError(String str) {
                JSEvent jSEvent = new JSEvent(BdStatsConstant.StatsType.ERROR);
                jSEvent.data = d.rH(str);
                c.this.dispatchEvent(jSEvent);
            }

            @Override // com.baidu.swan.game.ad.e.i
            public void a(f fVar) {
                JSEvent jSEvent = new JSEvent(ResizeImageAction.ACTION_NAME);
                jSEvent.data = d.b(fVar);
                c.this.dispatchEvent(jSEvent);
            }
        };
        this.dbN = bVar;
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e != null) {
            this.adUnitId = e.optString("adUnitId");
            this.daz = e.optString("appSid");
            com.baidu.swan.games.binding.model.c sB = e.sB("style");
            if (sB != null) {
                this.style = new f(sB);
            }
        }
        this.dbP = com.baidu.swan.game.ad.d.f.aAH();
        if (this.dbP) {
            this.daz = com.baidu.swan.game.ad.d.f.aAK();
            this.adUnitId = com.baidu.swan.game.ad.d.f.aAL();
        }
        if (aAR()) {
            if (e == null || TextUtils.isEmpty(this.adUnitId) || TextUtils.isEmpty(this.daz) || this.style == null) {
                bVar.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
                return;
            }
            this.dbO = new e(this.daz, this.adUnitId, this.style, this, this.dbP);
            this.dbO.a(this.dbQ);
            if (this.style != null) {
                this.style.a(this);
            }
        }
    }

    private boolean aAR() {
        if (TextUtils.isEmpty(this.mErrorCode)) {
            com.baidu.swan.games.utils.c aGP = com.baidu.swan.games.utils.c.aGP();
            if (!aGP.aGX()) {
                if (!aGP.aGY()) {
                    if (aGP.tL(this.adUnitId)) {
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
            this.dbN.postOnJSThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.c.1
                @Override // java.lang.Runnable
                public void run() {
                    JSEvent jSEvent = new JSEvent(BdStatsConstant.StatsType.ERROR);
                    jSEvent.data = d.rH(c.this.mErrorCode);
                    c.this.dispatchEvent(jSEvent);
                }
            });
            com.baidu.swan.games.view.a.b.R(this.dbP ? "gdtbanner" : "banner", "reject", this.mErrorCode);
            return false;
        }
        return true;
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void showAd(JsObject jsObject) {
        com.baidu.swan.games.view.a.b.tT(this.dbP ? "gdtbanner" : "banner");
        if (aAR() && this.dbO != null) {
            com.baidu.swan.games.utils.c.aGP().aGW();
            this.dbO.c(jsObject);
        }
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void hide() {
        if (this.dbO != null) {
            this.dbO.aAS();
        }
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void destroy() {
        this.aIX = true;
        removeEventListener(BdStatsConstant.StatsType.ERROR, null);
        removeEventListener(TrackLoadSettingsAtom.TYPE, null);
        removeEventListener(ResizeImageAction.ACTION_NAME, null);
        if (this.dbO != null) {
            this.dbO.aAT();
            this.dbO = null;
        }
    }

    @Override // com.baidu.swan.game.ad.e.f.a
    public void rG(String str) {
        if (!this.aIX && !TextUtils.isEmpty(str) && !str.equals("height") && this.style != null && this.dbO != null) {
            this.dbO.rI(str);
        }
    }

    @Override // com.baidu.swan.game.ad.a.InterfaceC0430a
    public void azK() {
        destroy();
    }
}
