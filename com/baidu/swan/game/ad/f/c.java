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
    private String chG;
    private e ciA;
    private h ciB;
    private com.baidu.swan.games.e.b ciz;
    public boolean isDestroyed;
    private String mErrorCode;
    @V8JavascriptField
    public f style;

    public c(com.baidu.swan.games.e.b bVar, JsObject jsObject) {
        super(bVar);
        this.style = null;
        this.ciB = new h() { // from class: com.baidu.swan.game.ad.f.c.2
            @Override // com.baidu.swan.game.ad.f.h
            public void onLoad() {
                c.this.dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
            }

            @Override // com.baidu.swan.game.ad.f.h
            public void onError(String str) {
                JSEvent jSEvent = new JSEvent(BdStatsConstant.StatsType.ERROR);
                jSEvent.data = d.nT(str);
                c.this.dispatchEvent(jSEvent);
            }

            @Override // com.baidu.swan.game.ad.f.h
            public void a(f fVar) {
                JSEvent jSEvent = new JSEvent(ResizeImageAction.ACTION_NAME);
                jSEvent.data = d.b(fVar);
                c.this.dispatchEvent(jSEvent);
            }
        };
        this.ciz = bVar;
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (c != null) {
            this.adUnitId = c.optString("adUnitId");
            this.chG = c.optString("appSid");
            com.baidu.swan.games.binding.model.c oG = c.oG("style");
            if (oG != null) {
                this.style = new f(oG);
            }
        }
        if (akE()) {
            if (c == null || TextUtils.isEmpty(this.adUnitId) || TextUtils.isEmpty(this.chG) || this.style == null) {
                bVar.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
                return;
            }
            this.ciA = new e(this.chG, this.adUnitId, this.style, this);
            this.ciA.a(this.ciB);
            if (this.style != null) {
                this.style.a(this);
            }
        }
    }

    private boolean akE() {
        if (TextUtils.isEmpty(this.mErrorCode)) {
            com.baidu.swan.games.utils.c apV = com.baidu.swan.games.utils.c.apV();
            if (!apV.aqd()) {
                if (!apV.aqe()) {
                    if (apV.pP(this.adUnitId)) {
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
            this.ciz.postOnJSThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.c.1
                @Override // java.lang.Runnable
                public void run() {
                    JSEvent jSEvent = new JSEvent(BdStatsConstant.StatsType.ERROR);
                    jSEvent.data = d.nT(c.this.mErrorCode);
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
        com.baidu.swan.games.view.a.b.pS("banner");
        if (akE() && this.ciA != null) {
            com.baidu.swan.games.utils.c.apV().aqc();
            this.ciA.a(jsObject);
        }
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void hide() {
        if (this.ciA != null) {
            this.ciA.akF();
        }
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void destroy() {
        this.isDestroyed = true;
        removeEventListener(BdStatsConstant.StatsType.ERROR, null);
        removeEventListener(TrackLoadSettingsAtom.TYPE, null);
        removeEventListener(ResizeImageAction.ACTION_NAME, null);
        if (this.ciA != null) {
            this.ciA.akG();
            this.ciA = null;
        }
    }

    @Override // com.baidu.swan.game.ad.f.f.a
    public void nS(String str) {
        if (!this.isDestroyed && !TextUtils.isEmpty(str) && !str.equals("height") && this.style != null && this.ciA != null) {
            this.ciA.nU(str);
        }
    }

    @Override // com.baidu.swan.game.ad.a.InterfaceC0326a
    public void ajX() {
        destroy();
    }
}
