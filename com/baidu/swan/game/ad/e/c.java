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
public class c extends EventTargetImpl implements a.InterfaceC0515a, f.a, com.baidu.swan.games.a.b {
    public boolean aVI;
    @V8JavascriptField
    public String adUnitId;
    private String dNk;
    private e dOA;
    private boolean dOB;
    private i dOC;
    private com.baidu.swan.games.f.b dOz;
    private String mErrorCode;
    @V8JavascriptField
    public f style;

    public c(com.baidu.swan.games.f.b bVar, JsObject jsObject) {
        super(bVar);
        this.style = null;
        this.dOC = new i() { // from class: com.baidu.swan.game.ad.e.c.2
            @Override // com.baidu.swan.game.ad.e.i
            public void onLoad() {
                c.this.dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
            }

            @Override // com.baidu.swan.game.ad.e.i
            public void onError(String str) {
                JSEvent jSEvent = new JSEvent(BdStatsConstant.StatsType.ERROR);
                jSEvent.data = d.vN(str);
                c.this.dispatchEvent(jSEvent);
            }

            @Override // com.baidu.swan.game.ad.e.i
            public void a(f fVar) {
                JSEvent jSEvent = new JSEvent(ResizeImageAction.ACTION_NAME);
                jSEvent.data = d.b(fVar);
                c.this.dispatchEvent(jSEvent);
            }
        };
        this.dOz = bVar;
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e != null) {
            this.adUnitId = e.optString("adUnitId");
            this.dNk = e.optString("appSid");
            com.baidu.swan.games.binding.model.c wF = e.wF("style");
            if (wF != null) {
                this.style = new f(wF);
            }
        }
        this.dOB = com.baidu.swan.game.ad.d.f.aRe();
        if (this.dOB) {
            this.dNk = com.baidu.swan.game.ad.d.f.aRh();
            this.adUnitId = com.baidu.swan.game.ad.d.f.aRi();
        }
        if (aRo()) {
            if (e == null || TextUtils.isEmpty(this.adUnitId) || TextUtils.isEmpty(this.dNk) || this.style == null) {
                bVar.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
                return;
            }
            this.dOA = new e(this.dNk, this.adUnitId, this.style, this, this.dOB);
            this.dOA.a(this.dOC);
            if (this.style != null) {
                this.style.a(this);
            }
        }
    }

    private boolean aRo() {
        if (TextUtils.isEmpty(this.mErrorCode)) {
            com.baidu.swan.games.utils.c aXu = com.baidu.swan.games.utils.c.aXu();
            if (!aXu.aXC()) {
                if (!aXu.aXD()) {
                    if (aXu.xO(this.adUnitId)) {
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
            this.dOz.postOnJSThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.c.1
                @Override // java.lang.Runnable
                public void run() {
                    JSEvent jSEvent = new JSEvent(BdStatsConstant.StatsType.ERROR);
                    jSEvent.data = d.vN(c.this.mErrorCode);
                    c.this.dispatchEvent(jSEvent);
                }
            });
            com.baidu.swan.games.view.a.b.ac(this.dOB ? "gdtbanner" : "banner", "reject", this.mErrorCode);
            return false;
        }
        return true;
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void showAd(JsObject jsObject) {
        com.baidu.swan.games.view.a.b.xW(this.dOB ? "gdtbanner" : "banner");
        if (aRo() && this.dOA != null) {
            com.baidu.swan.games.utils.c.aXu().aXB();
            this.dOA.c(jsObject);
        }
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void hide() {
        if (this.dOA != null) {
            this.dOA.aRp();
        }
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void destroy() {
        this.aVI = true;
        removeEventListener(BdStatsConstant.StatsType.ERROR, null);
        removeEventListener(TrackLoadSettingsAtom.TYPE, null);
        removeEventListener(ResizeImageAction.ACTION_NAME, null);
        if (this.dOA != null) {
            this.dOA.aRq();
            this.dOA = null;
        }
    }

    @Override // com.baidu.swan.game.ad.e.f.a
    public void vM(String str) {
        if (!this.aVI && !TextUtils.isEmpty(str) && !str.equals("height") && this.style != null && this.dOA != null) {
            this.dOA.vO(str);
        }
    }

    @Override // com.baidu.swan.game.ad.a.InterfaceC0515a
    public void aPI() {
        destroy();
    }
}
