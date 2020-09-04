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
    public boolean aOk;
    @V8JavascriptField
    public String adUnitId;
    private String dkN;
    private com.baidu.swan.games.f.b dmd;
    private e dme;
    private boolean dmf;
    private i dmg;
    private String mErrorCode;
    @V8JavascriptField
    public f style;

    public c(com.baidu.swan.games.f.b bVar, JsObject jsObject) {
        super(bVar);
        this.style = null;
        this.dmg = new i() { // from class: com.baidu.swan.game.ad.e.c.2
            @Override // com.baidu.swan.game.ad.e.i
            public void onLoad() {
                c.this.dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
            }

            @Override // com.baidu.swan.game.ad.e.i
            public void onError(String str) {
                JSEvent jSEvent = new JSEvent(BdStatsConstant.StatsType.ERROR);
                jSEvent.data = d.ub(str);
                c.this.dispatchEvent(jSEvent);
            }

            @Override // com.baidu.swan.game.ad.e.i
            public void a(f fVar) {
                JSEvent jSEvent = new JSEvent(ResizeImageAction.ACTION_NAME);
                jSEvent.data = d.b(fVar);
                c.this.dispatchEvent(jSEvent);
            }
        };
        this.dmd = bVar;
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e != null) {
            this.adUnitId = e.optString("adUnitId");
            this.dkN = e.optString("appSid");
            com.baidu.swan.games.binding.model.c uT = e.uT("style");
            if (uT != null) {
                this.style = new f(uT);
            }
        }
        this.dmf = com.baidu.swan.game.ad.d.f.aJq();
        if (this.dmf) {
            this.dkN = com.baidu.swan.game.ad.d.f.aJt();
            this.adUnitId = com.baidu.swan.game.ad.d.f.aJu();
        }
        if (aJA()) {
            if (e == null || TextUtils.isEmpty(this.adUnitId) || TextUtils.isEmpty(this.dkN) || this.style == null) {
                bVar.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
                return;
            }
            this.dme = new e(this.dkN, this.adUnitId, this.style, this, this.dmf);
            this.dme.a(this.dmg);
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
                    if (aPG.wc(this.adUnitId)) {
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
            this.dmd.postOnJSThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.c.1
                @Override // java.lang.Runnable
                public void run() {
                    JSEvent jSEvent = new JSEvent(BdStatsConstant.StatsType.ERROR);
                    jSEvent.data = d.ub(c.this.mErrorCode);
                    c.this.dispatchEvent(jSEvent);
                }
            });
            com.baidu.swan.games.view.a.b.U(this.dmf ? "gdtbanner" : "banner", "reject", this.mErrorCode);
            return false;
        }
        return true;
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void showAd(JsObject jsObject) {
        com.baidu.swan.games.view.a.b.wk(this.dmf ? "gdtbanner" : "banner");
        if (aJA() && this.dme != null) {
            com.baidu.swan.games.utils.c.aPG().aPN();
            this.dme.c(jsObject);
        }
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void hide() {
        if (this.dme != null) {
            this.dme.aJB();
        }
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void destroy() {
        this.aOk = true;
        removeEventListener(BdStatsConstant.StatsType.ERROR, null);
        removeEventListener(TrackLoadSettingsAtom.TYPE, null);
        removeEventListener(ResizeImageAction.ACTION_NAME, null);
        if (this.dme != null) {
            this.dme.aJC();
            this.dme = null;
        }
    }

    @Override // com.baidu.swan.game.ad.e.f.a
    public void ua(String str) {
        if (!this.aOk && !TextUtils.isEmpty(str) && !str.equals("height") && this.style != null && this.dme != null) {
            this.dme.uc(str);
        }
    }

    @Override // com.baidu.swan.game.ad.a.InterfaceC0477a
    public void aHU() {
        destroy();
    }
}
