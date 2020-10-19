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
public class c extends EventTargetImpl implements a.InterfaceC0489a, f.a, com.baidu.swan.games.a.b {
    public boolean aTu;
    @V8JavascriptField
    public String adUnitId;
    private com.baidu.swan.games.f.b dAk;
    private e dAl;
    private boolean dAm;
    private i dAn;
    private String dyV;
    private String mErrorCode;
    @V8JavascriptField
    public f style;

    public c(com.baidu.swan.games.f.b bVar, JsObject jsObject) {
        super(bVar);
        this.style = null;
        this.dAn = new i() { // from class: com.baidu.swan.game.ad.e.c.2
            @Override // com.baidu.swan.game.ad.e.i
            public void onLoad() {
                c.this.dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
            }

            @Override // com.baidu.swan.game.ad.e.i
            public void onError(String str) {
                JSEvent jSEvent = new JSEvent(BdStatsConstant.StatsType.ERROR);
                jSEvent.data = d.vg(str);
                c.this.dispatchEvent(jSEvent);
            }

            @Override // com.baidu.swan.game.ad.e.i
            public void a(f fVar) {
                JSEvent jSEvent = new JSEvent(ResizeImageAction.ACTION_NAME);
                jSEvent.data = d.b(fVar);
                c.this.dispatchEvent(jSEvent);
            }
        };
        this.dAk = bVar;
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e != null) {
            this.adUnitId = e.optString("adUnitId");
            this.dyV = e.optString("appSid");
            com.baidu.swan.games.binding.model.c vY = e.vY("style");
            if (vY != null) {
                this.style = new f(vY);
            }
        }
        this.dAm = com.baidu.swan.game.ad.d.f.aMK();
        if (this.dAm) {
            this.dyV = com.baidu.swan.game.ad.d.f.aMN();
            this.adUnitId = com.baidu.swan.game.ad.d.f.aMO();
        }
        if (aMU()) {
            if (e == null || TextUtils.isEmpty(this.adUnitId) || TextUtils.isEmpty(this.dyV) || this.style == null) {
                bVar.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
                return;
            }
            this.dAl = new e(this.dyV, this.adUnitId, this.style, this, this.dAm);
            this.dAl.a(this.dAn);
            if (this.style != null) {
                this.style.a(this);
            }
        }
    }

    private boolean aMU() {
        if (TextUtils.isEmpty(this.mErrorCode)) {
            com.baidu.swan.games.utils.c aTa = com.baidu.swan.games.utils.c.aTa();
            if (!aTa.aTi()) {
                if (!aTa.aTj()) {
                    if (aTa.xh(this.adUnitId)) {
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
            this.dAk.postOnJSThread(new Runnable() { // from class: com.baidu.swan.game.ad.e.c.1
                @Override // java.lang.Runnable
                public void run() {
                    JSEvent jSEvent = new JSEvent(BdStatsConstant.StatsType.ERROR);
                    jSEvent.data = d.vg(c.this.mErrorCode);
                    c.this.dispatchEvent(jSEvent);
                }
            });
            com.baidu.swan.games.view.a.b.V(this.dAm ? "gdtbanner" : "banner", "reject", this.mErrorCode);
            return false;
        }
        return true;
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void showAd(JsObject jsObject) {
        com.baidu.swan.games.view.a.b.xp(this.dAm ? "gdtbanner" : "banner");
        if (aMU() && this.dAl != null) {
            com.baidu.swan.games.utils.c.aTa().aTh();
            this.dAl.c(jsObject);
        }
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void hide() {
        if (this.dAl != null) {
            this.dAl.aMV();
        }
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void destroy() {
        this.aTu = true;
        removeEventListener(BdStatsConstant.StatsType.ERROR, null);
        removeEventListener(TrackLoadSettingsAtom.TYPE, null);
        removeEventListener(ResizeImageAction.ACTION_NAME, null);
        if (this.dAl != null) {
            this.dAl.aMW();
            this.dAl = null;
        }
    }

    @Override // com.baidu.swan.game.ad.e.f.a
    public void vf(String str) {
        if (!this.aTu && !TextUtils.isEmpty(str) && !str.equals("height") && this.style != null && this.dAl != null) {
            this.dAl.vh(str);
        }
    }

    @Override // com.baidu.swan.game.ad.a.InterfaceC0489a
    public void aLo() {
        destroy();
    }
}
