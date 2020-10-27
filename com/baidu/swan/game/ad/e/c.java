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
public class c extends EventTargetImpl implements a.InterfaceC0503a, f.a, com.baidu.swan.games.a.b {
    public boolean aUq;
    @V8JavascriptField
    public String adUnitId;
    private String dHs;
    private com.baidu.swan.games.f.b dIH;
    private e dII;
    private boolean dIJ;
    private i dIK;
    private String mErrorCode;
    @V8JavascriptField
    public f style;

    public c(com.baidu.swan.games.f.b bVar, JsObject jsObject) {
        super(bVar);
        this.style = null;
        this.dIK = new i() { // from class: com.baidu.swan.game.ad.e.c.2
            @Override // com.baidu.swan.game.ad.e.i
            public void onLoad() {
                c.this.dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
            }

            @Override // com.baidu.swan.game.ad.e.i
            public void onError(String str) {
                JSEvent jSEvent = new JSEvent(BdStatsConstant.StatsType.ERROR);
                jSEvent.data = d.vz(str);
                c.this.dispatchEvent(jSEvent);
            }

            @Override // com.baidu.swan.game.ad.e.i
            public void a(f fVar) {
                JSEvent jSEvent = new JSEvent(ResizeImageAction.ACTION_NAME);
                jSEvent.data = d.b(fVar);
                c.this.dispatchEvent(jSEvent);
            }
        };
        this.dIH = bVar;
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e != null) {
            this.adUnitId = e.optString("adUnitId");
            this.dHs = e.optString("appSid");
            com.baidu.swan.games.binding.model.c wr = e.wr("style");
            if (wr != null) {
                this.style = new f(wr);
            }
        }
        this.dIJ = com.baidu.swan.game.ad.d.f.aOE();
        if (this.dIJ) {
            this.dHs = com.baidu.swan.game.ad.d.f.aOH();
            this.adUnitId = com.baidu.swan.game.ad.d.f.aOI();
        }
        if (aOO()) {
            if (e == null || TextUtils.isEmpty(this.adUnitId) || TextUtils.isEmpty(this.dHs) || this.style == null) {
                bVar.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
                return;
            }
            this.dII = new e(this.dHs, this.adUnitId, this.style, this, this.dIJ);
            this.dII.a(this.dIK);
            if (this.style != null) {
                this.style.a(this);
            }
        }
    }

    private boolean aOO() {
        if (TextUtils.isEmpty(this.mErrorCode)) {
            com.baidu.swan.games.utils.c aUU = com.baidu.swan.games.utils.c.aUU();
            if (!aUU.aVc()) {
                if (!aUU.aVd()) {
                    if (aUU.xA(this.adUnitId)) {
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
            this.dIH.postOnJSThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.c.1
                @Override // java.lang.Runnable
                public void run() {
                    JSEvent jSEvent = new JSEvent(BdStatsConstant.StatsType.ERROR);
                    jSEvent.data = d.vz(c.this.mErrorCode);
                    c.this.dispatchEvent(jSEvent);
                }
            });
            com.baidu.swan.games.view.a.b.ac(this.dIJ ? "gdtbanner" : "banner", "reject", this.mErrorCode);
            return false;
        }
        return true;
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void showAd(JsObject jsObject) {
        com.baidu.swan.games.view.a.b.xI(this.dIJ ? "gdtbanner" : "banner");
        if (aOO() && this.dII != null) {
            com.baidu.swan.games.utils.c.aUU().aVb();
            this.dII.c(jsObject);
        }
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void hide() {
        if (this.dII != null) {
            this.dII.aOP();
        }
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void destroy() {
        this.aUq = true;
        removeEventListener(BdStatsConstant.StatsType.ERROR, null);
        removeEventListener(TrackLoadSettingsAtom.TYPE, null);
        removeEventListener(ResizeImageAction.ACTION_NAME, null);
        if (this.dII != null) {
            this.dII.aOQ();
            this.dII = null;
        }
    }

    @Override // com.baidu.swan.game.ad.e.f.a
    public void vy(String str) {
        if (!this.aUq && !TextUtils.isEmpty(str) && !str.equals("height") && this.style != null && this.dII != null) {
            this.dII.vA(str);
        }
    }

    @Override // com.baidu.swan.game.ad.a.InterfaceC0503a
    public void aNi() {
        destroy();
    }
}
