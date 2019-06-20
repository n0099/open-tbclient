package com.baidu.swan.game.ad.f;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.game.ad.f.g;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
/* loaded from: classes2.dex */
public class a extends EventTargetImpl implements g.a, com.baidu.swan.games.a.b {
    @V8JavascriptField
    public String adUnitId;
    private String bdm;
    private f bdn;
    private i bdo;
    public boolean isDestroyed;
    @V8JavascriptField
    public g style;

    public a(com.baidu.swan.games.e.b bVar, JsObject jsObject) {
        super(bVar);
        this.style = null;
        this.bdo = new i() { // from class: com.baidu.swan.game.ad.f.a.1
            @Override // com.baidu.swan.game.ad.f.i
            public void a() {
                a.this.dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
            }

            @Override // com.baidu.swan.game.ad.f.i
            public void a(String str) {
                JSEvent jSEvent = new JSEvent("error");
                jSEvent.data = e.a(str);
                a.this.dispatchEvent(jSEvent);
            }

            @Override // com.baidu.swan.game.ad.f.i
            public void a(g gVar) {
                JSEvent jSEvent = new JSEvent("resize");
                jSEvent.data = e.b(gVar);
                a.this.dispatchEvent(jSEvent);
            }
        };
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (c != null) {
            this.adUnitId = c.optString("adUnitId");
            this.bdm = c.optString("appSid");
            JsObject iR = c.iR(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
            if (iR != null) {
                this.style = new g(iR);
            }
        }
        if (c == null || TextUtils.isEmpty(this.adUnitId) || TextUtils.isEmpty(this.bdm) || this.style == null) {
            bVar.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
            return;
        }
        this.bdn = new f(this.bdm, this.adUnitId, this.style);
        this.bdn.a(this.bdo);
        if (this.style != null) {
            this.style.a(this);
        }
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void showAd(JsObject jsObject) {
        com.baidu.swan.games.view.a.b.jV("banner");
        if (this.bdn != null) {
            this.bdn.a(jsObject);
        }
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void hide() {
        if (this.bdn != null) {
            this.bdn.a();
        }
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void destroy() {
        this.isDestroyed = true;
        removeEventListener("error", null);
        removeEventListener(TrackLoadSettingsAtom.TYPE, null);
        removeEventListener("resize", null);
        if (this.bdn != null) {
            this.bdn.b();
            this.bdn = null;
        }
    }

    @Override // com.baidu.swan.game.ad.f.g.a
    public void iD(String str) {
        if (!this.isDestroyed && !TextUtils.isEmpty(str) && !str.equals("height") && this.style != null && this.bdn != null) {
            this.bdn.b(str);
        }
    }
}
