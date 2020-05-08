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
public class c extends EventTargetImpl implements a.InterfaceC0377a, f.a, com.baidu.swan.games.a.b {
    @V8JavascriptField
    public String adUnitId;
    public boolean azO;
    private String cGT;
    private com.baidu.swan.games.e.b cHL;
    private e cHM;
    private h cHN;
    private String mErrorCode;
    @V8JavascriptField
    public f style;

    public c(com.baidu.swan.games.e.b bVar, JsObject jsObject) {
        super(bVar);
        this.style = null;
        this.cHN = new h() { // from class: com.baidu.swan.game.ad.f.c.2
            @Override // com.baidu.swan.game.ad.f.h
            public void onLoad() {
                c.this.dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
            }

            @Override // com.baidu.swan.game.ad.f.h
            public void onError(String str) {
                JSEvent jSEvent = new JSEvent(BdStatsConstant.StatsType.ERROR);
                jSEvent.data = d.ph(str);
                c.this.dispatchEvent(jSEvent);
            }

            @Override // com.baidu.swan.game.ad.f.h
            public void a(f fVar) {
                JSEvent jSEvent = new JSEvent(ResizeImageAction.ACTION_NAME);
                jSEvent.data = d.b(fVar);
                c.this.dispatchEvent(jSEvent);
            }
        };
        this.cHL = bVar;
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (c != null) {
            this.adUnitId = c.optString("adUnitId");
            this.cGT = c.optString("appSid");
            com.baidu.swan.games.binding.model.c pS = c.pS("style");
            if (pS != null) {
                this.style = new f(pS);
            }
        }
        if (asT()) {
            if (c == null || TextUtils.isEmpty(this.adUnitId) || TextUtils.isEmpty(this.cGT) || this.style == null) {
                bVar.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
                return;
            }
            this.cHM = new e(this.cGT, this.adUnitId, this.style, this);
            this.cHM.a(this.cHN);
            if (this.style != null) {
                this.style.a(this);
            }
        }
    }

    private boolean asT() {
        if (TextUtils.isEmpty(this.mErrorCode)) {
            com.baidu.swan.games.utils.c ayk = com.baidu.swan.games.utils.c.ayk();
            if (!ayk.ays()) {
                if (!ayk.ayt()) {
                    if (ayk.rb(this.adUnitId)) {
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
            this.cHL.postOnJSThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.c.1
                @Override // java.lang.Runnable
                public void run() {
                    JSEvent jSEvent = new JSEvent(BdStatsConstant.StatsType.ERROR);
                    jSEvent.data = d.ph(c.this.mErrorCode);
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
        com.baidu.swan.games.view.a.b.re("banner");
        if (asT() && this.cHM != null) {
            com.baidu.swan.games.utils.c.ayk().ayr();
            this.cHM.a(jsObject);
        }
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void hide() {
        if (this.cHM != null) {
            this.cHM.asU();
        }
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void destroy() {
        this.azO = true;
        removeEventListener(BdStatsConstant.StatsType.ERROR, null);
        removeEventListener(TrackLoadSettingsAtom.TYPE, null);
        removeEventListener(ResizeImageAction.ACTION_NAME, null);
        if (this.cHM != null) {
            this.cHM.asV();
            this.cHM = null;
        }
    }

    @Override // com.baidu.swan.game.ad.f.f.a
    public void pg(String str) {
        if (!this.azO && !TextUtils.isEmpty(str) && !str.equals("height") && this.style != null && this.cHM != null) {
            this.cHM.pi(str);
        }
    }

    @Override // com.baidu.swan.game.ad.a.InterfaceC0377a
    public void asi() {
        destroy();
    }
}
