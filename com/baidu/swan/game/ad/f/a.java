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
    private String bdY;
    private f bdZ;
    private i bea;
    public boolean isDestroyed;
    @V8JavascriptField
    public g style;

    public a(com.baidu.swan.games.e.b bVar, JsObject jsObject) {
        super(bVar);
        this.style = null;
        this.bea = new i() { // from class: com.baidu.swan.game.ad.f.a.1
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
            this.bdY = c.optString("appSid");
            JsObject iZ = c.iZ(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
            if (iZ != null) {
                this.style = new g(iZ);
            }
        }
        if (c == null || TextUtils.isEmpty(this.adUnitId) || TextUtils.isEmpty(this.bdY) || this.style == null) {
            bVar.throwJSException(JSExceptionType.Error, "请求广告的必须参数为空,中断执行");
            return;
        }
        this.bdZ = new f(this.bdY, this.adUnitId, this.style);
        this.bdZ.a(this.bea);
        if (this.style != null) {
            this.style.a(this);
        }
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void showAd(JsObject jsObject) {
        com.baidu.swan.games.view.a.b.kd("banner");
        if (this.bdZ != null) {
            this.bdZ.a(jsObject);
        }
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void hide() {
        if (this.bdZ != null) {
            this.bdZ.a();
        }
    }

    @Override // com.baidu.swan.games.a.b
    @JavascriptInterface
    public void destroy() {
        this.isDestroyed = true;
        removeEventListener("error", null);
        removeEventListener(TrackLoadSettingsAtom.TYPE, null);
        removeEventListener("resize", null);
        if (this.bdZ != null) {
            this.bdZ.b();
            this.bdZ = null;
        }
    }

    @Override // com.baidu.swan.game.ad.f.g.a
    public void iK(String str) {
        if (!this.isDestroyed && !TextUtils.isEmpty(str) && !str.equals("height") && this.style != null && this.bdZ != null) {
            this.bdZ.b(str);
        }
    }
}
