package com.baidu.swan.games.binding;

import android.os.Build;
import android.support.annotation.NonNull;
import android.webkit.JavascriptInterface;
import com.baidu.platform.comapi.walknavi.fsm.RGState;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.y.f;
import com.baidu.swan.games.audio.h;
import com.baidu.swan.games.b.g;
import com.baidu.swan.games.h.d;
import com.baidu.swan.games.q.e;
import com.baidu.swan.games.view.desktopguide.DesktopGuideApi;
import com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy;
/* loaded from: classes11.dex */
public final class c extends EventTargetImpl {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.e.b cka;
    private d clA;
    private com.baidu.swan.games.q.d clB;
    private com.baidu.swan.games.q.b clC;
    private JsObject clD;
    private e clE;
    private com.baidu.swan.games.m.a clF;
    private com.baidu.swan.games.m.b clG;
    private com.baidu.swan.games.v.a clH;
    private com.baidu.swan.games.z.d clI;
    private com.baidu.swan.games.a.c clJ;
    private com.baidu.swan.games.network.websocket.a clK;
    private g clL;
    private com.baidu.swan.games.screenrecord.a clM;
    private h clN;
    private DesktopGuideApi clO;
    private com.baidu.swan.games.r.a clP;
    private com.baidu.swan.games.view.webview.a clQ;
    @V8JavascriptField
    public final String domain;
    @V8JavascriptField
    public com.baidu.swan.games.h.a env;

    public c(com.baidu.swan.games.e.b bVar) {
        super(bVar);
        this.domain = "main";
        this.clD = null;
        this.clE = null;
        this.clF = null;
        this.clG = null;
        this.clI = null;
        this.clJ = null;
        this.clK = null;
        this.clL = null;
        this.clM = null;
        this.clN = null;
        this.clO = null;
        this.clP = null;
        this.clQ = null;
        this.cka = bVar;
        this.env = new com.baidu.swan.games.h.a();
        amT();
    }

    private void amT() {
        this.clG = new com.baidu.swan.games.m.b(this.cka);
    }

    public void b(JsObject jsObject) {
        this.clD = jsObject;
    }

    @JavascriptInterface
    public void setPreferredFramesPerSecond(short s) {
        if (s >= 1 && s <= 60) {
            this.cka.setPreferredFramesPerSecond(s);
        }
    }

    @JavascriptInterface
    public e getOpenDataContext() {
        if (this.clE == null) {
            this.clE = new e(this.cka);
            this.clE.canvas = this.clD;
            this.clD = null;
        }
        return this.clE;
    }

    @JavascriptInterface
    public d getFileSystemManager() {
        if (this.clA == null) {
            this.clA = new d((com.baidu.swan.games.e.a) this.cka);
        }
        return this.clA;
    }

    @JavascriptInterface
    public com.baidu.swan.games.x.c loadSubpackage(JsObject jsObject) {
        com.baidu.swan.games.x.c cVar = new com.baidu.swan.games.x.c(this.cka);
        cVar.l(jsObject);
        return cVar;
    }

    @JavascriptInterface
    public void exit(JsObject jsObject) {
        if (DEBUG) {
            this.cka.any().log("exit from java side.");
        }
        if (jsObject != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            com.baidu.swan.games.binding.model.a f = com.baidu.swan.games.binding.model.a.f(com.baidu.swan.games.binding.model.c.c(jsObject));
            SwanAppActivity WD = f.WS().WD();
            if (WD == null) {
                bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "failed");
                f.S(bVar);
                return;
            }
            bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "ok");
            f.onSuccess(bVar);
            if (Build.VERSION.SDK_INT >= 21) {
                WD.finishAndRemoveTask();
            } else {
                WD.finish();
            }
        }
    }

    @JavascriptInterface
    public void reload(JsObject jsObject) {
        if (this.clP == null) {
            this.clP = new com.baidu.swan.games.r.a();
        }
        this.clP.reload(jsObject);
    }

    @JavascriptInterface
    public void reload() {
        reload(null);
    }

    @JavascriptInterface
    public com.baidu.swan.games.q.d getOpenData() {
        if (this.clB == null) {
            this.clB = new com.baidu.swan.games.q.d((com.baidu.swan.games.e.a) this.cka);
        }
        return this.clB;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        if (this.clC == null) {
            this.clC = new com.baidu.swan.games.q.b(this.cka);
        }
        this.clC.checkIsUserAdvisedToRest(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.c createRewardedVideoAd(JsObject jsObject) {
        if (this.clJ == null) {
            this.clJ = com.baidu.swan.apps.w.a.Uy().a(this.cka, jsObject);
            if (this.clJ == null) {
                this.clJ = new com.baidu.swan.games.a.a();
            }
        }
        return this.clJ;
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.button.userinfo.b createUserInfoButton(JsObject jsObject) {
        return new com.baidu.swan.games.view.button.userinfo.b(jsObject, this.cka);
    }

    @JavascriptInterface
    public void showKeyboard(JsObject jsObject) {
        if (this.clF == null) {
            this.clF = new com.baidu.swan.games.m.a(this.cka, this.clG);
        }
        this.clF.showKeyboard(jsObject);
    }

    @JavascriptInterface
    public void showKeyboard() {
        if (this.clF == null) {
            this.clF = new com.baidu.swan.games.m.a(this.cka, this.clG);
        }
        this.clF.showKeyboard(null);
    }

    @JavascriptInterface
    public void updateKeyboard(JsObject jsObject) {
        if (this.clF != null) {
            this.clF.updateKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void updateKeyboard() {
        if (this.clF != null) {
            this.clF.updateKeyboard(null);
        }
    }

    @JavascriptInterface
    public void hideKeyboard(JsObject jsObject) {
        if (this.clF != null) {
            this.clF.hideKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void hideKeyboard() {
        if (this.clF != null) {
            this.clF.hideKeyboard(null);
        }
    }

    @JavascriptInterface
    public void getStorage(JsObject jsObject) {
        amU().getStorage(jsObject);
    }

    @JavascriptInterface
    public Object getStorageSync(String str) {
        return com.baidu.swan.games.v.a.d.a(this.cka, "getStorageSync", str, amU().pG(str));
    }

    @JavascriptInterface
    public void setStorage(JsObject jsObject) {
        amU().setStorage(jsObject);
    }

    @JavascriptInterface
    public void setStorageSync(String str, JsSerializeValue jsSerializeValue) {
        com.baidu.swan.games.v.a.d.a(this.cka, "setStorageSync", str, amU().a(str, jsSerializeValue));
    }

    @JavascriptInterface
    public void setStorageSync(String str) {
        com.baidu.swan.games.v.a.d.a(this.cka, "setStorageSync", str, amU().a(str, (JsSerializeValue) null));
    }

    @JavascriptInterface
    public void removeStorage(JsObject jsObject) {
        amU().removeStorage(jsObject);
    }

    @JavascriptInterface
    public void removeStorageSync(String str) {
        com.baidu.swan.games.v.a.d.a(this.cka, "removeStorageSync", str, amU().pH(str));
    }

    @JavascriptInterface
    public void clearStorage(JsObject jsObject) {
        amU().clearStorage(jsObject);
    }

    @JavascriptInterface
    public void clearStorageSync() {
        com.baidu.swan.games.v.a.d.a(this.cka, "clearStorageSync", "", amU().apN());
    }

    @JavascriptInterface
    public void getStorageInfo(JsObject jsObject) {
        amU().getStorageInfo(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.v.a.c getStorageInfoSync() {
        return amU().getStorageInfoSync();
    }

    @NonNull
    private com.baidu.swan.games.v.a amU() {
        if (this.clH == null) {
            this.clH = new com.baidu.swan.games.v.a(this.cka);
        }
        return this.clH;
    }

    @JavascriptInterface
    public void setInnerAudioOption(JsObject jsObject) {
        this.clN = new h(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.audio.g createInnerAudioContext() {
        return new com.baidu.swan.games.audio.g(this.cka);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.b createBannerAd(JsObject jsObject) {
        return com.baidu.swan.apps.w.a.Uy().b(this.cka, jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.z.d getUpdateManager(JsObject jsObject) {
        if (this.clI == null) {
            this.clI = new com.baidu.swan.games.z.d(jsObject);
        }
        return this.clI;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.websocket.c connectSocket(JsObject jsObject) {
        if (this.clK == null) {
            this.clK = new com.baidu.swan.games.network.websocket.a(this.cka);
        }
        return this.clK.connectSocket(jsObject);
    }

    @JavascriptInterface
    public void setEnableDebug(JsObject jsObject) {
        if (this.clL == null) {
            this.clL = new g(this.cka);
        }
        this.clL.setEnableDebug(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.c.c request(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        com.baidu.swan.games.network.a a = com.baidu.swan.games.network.b.d.aoT().a(this.cka, c, 1);
        if (a instanceof com.baidu.swan.games.network.c.c) {
            com.baidu.swan.games.network.c.c cVar = (com.baidu.swan.games.network.c.c) a;
            cVar.j(c);
            return cVar;
        }
        com.baidu.swan.games.network.c.c cVar2 = new com.baidu.swan.games.network.c.c(this.cka, c);
        cVar2.start();
        return cVar2;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.d.b uploadFile(JsObject jsObject) {
        com.baidu.swan.games.network.d.b bVar = new com.baidu.swan.games.network.d.b(this.cka, com.baidu.swan.games.binding.model.c.c(jsObject));
        bVar.start();
        return bVar;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.a.b downloadFile(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        com.baidu.swan.games.network.a a = com.baidu.swan.games.network.b.d.aoT().a(this.cka, c, 2);
        if (a instanceof com.baidu.swan.games.network.a.b) {
            com.baidu.swan.games.network.a.b bVar = (com.baidu.swan.games.network.a.b) a;
            bVar.j(c);
            return bVar;
        }
        com.baidu.swan.games.network.a.b bVar2 = new com.baidu.swan.games.network.a.b(this.cka, c);
        bVar2.start();
        return bVar2;
    }

    @JavascriptInterface
    public void openCustomerServiceConversation(JsObject jsObject) {
        com.baidu.swan.games.c.a.a((c) this.cka.anw(), jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.screenrecord.a getVideoRecorderManager() {
        if (this.clM == null) {
            this.clM = new com.baidu.swan.games.screenrecord.a(this.cka);
        }
        return this.clM;
    }

    @JavascriptInterface
    public void shareVideo(JsObject jsObject) {
        new com.baidu.swan.games.t.b.a(jsObject).NR();
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return com.baidu.swan.apps.jsbridge.a.b.getEnvVariables();
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton(JsObject jsObject) {
        return new RecommendButtonApiProxy(this.cka, jsObject);
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton() {
        return createRecommendationButton(null);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide(JsObject jsObject) {
        if (this.clO == null) {
            this.clO = new DesktopGuideApi(this.cka);
        }
        this.clO.o(jsObject);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide() {
        showAddToDesktopGuide(null);
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.webview.a getWebViewManager() {
        if (this.clQ == null) {
            this.clQ = new com.baidu.swan.games.view.webview.a(this.cka);
        }
        return this.clQ;
    }

    @JavascriptInterface
    public void getUUAPInfo(JsObject jsObject) {
        com.baidu.swan.games.aa.a.getUUAPInfo(jsObject);
    }

    @JavascriptInterface
    public String getAPIs(int i) {
        return DEBUG ? com.baidu.swan.apps.ah.a.a.aaF() ? SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i) : "" : com.baidu.swan.apps.w.a.TZ().Hf() ? SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i) : "";
    }

    @JavascriptInterface
    public void authorizeEval(JsObject jsObject) {
        com.baidu.swan.games.f.a.authorizeEval(jsObject);
    }

    @JavascriptInterface
    public void menuItemCtrl(JsObject jsObject) {
        com.baidu.swan.games.p.a WH = f.WS().WH();
        if (WH != null) {
            WH.i(com.baidu.swan.games.binding.model.c.c(jsObject));
        }
    }
}
