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
import com.baidu.swan.apps.v.f;
import com.baidu.swan.games.audio.h;
import com.baidu.swan.games.c.g;
import com.baidu.swan.games.i.e;
import com.baidu.swan.games.r.d;
import com.baidu.swan.games.view.desktopguide.DesktopGuideApi;
import com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy;
/* loaded from: classes25.dex */
public final class c extends EventTargetImpl {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.f.b dWl;
    private e dXT;
    private d dXU;
    private com.baidu.swan.games.r.b dXV;
    private JsObject dXW;
    private com.baidu.swan.games.r.e dXX;
    private com.baidu.swan.games.n.a dXY;
    private com.baidu.swan.games.n.b dXZ;
    private com.baidu.swan.games.w.a dYa;
    private com.baidu.swan.games.aa.d dYb;
    private com.baidu.swan.games.a.c dYc;
    private com.baidu.swan.games.network.websocket.a dYd;
    private g dYe;
    private com.baidu.swan.games.screenrecord.a dYf;
    private h dYg;
    private DesktopGuideApi dYh;
    private com.baidu.swan.games.s.a dYi;
    private com.baidu.swan.games.view.webview.a dYj;
    private com.baidu.swan.games.b.b dYk;
    @V8JavascriptField
    public final String domain;
    @V8JavascriptField
    public com.baidu.swan.games.i.a env;

    public c(com.baidu.swan.games.f.b bVar) {
        super(bVar);
        this.domain = "main";
        this.dXW = null;
        this.dXX = null;
        this.dXY = null;
        this.dXZ = null;
        this.dYb = null;
        this.dYc = null;
        this.dYd = null;
        this.dYe = null;
        this.dYf = null;
        this.dYg = null;
        this.dYh = null;
        this.dYi = null;
        this.dYj = null;
        this.dYk = null;
        this.dWl = bVar;
        this.env = new com.baidu.swan.games.i.a();
        aWJ();
    }

    private void aWJ() {
        this.dXZ = new com.baidu.swan.games.n.b(this.dWl);
    }

    public void d(JsObject jsObject) {
        this.dXW = jsObject;
    }

    @JavascriptInterface
    public void setPreferredFramesPerSecond(short s) {
        if (s >= 1 && s <= 60) {
            this.dWl.setPreferredFramesPerSecond(s);
        }
    }

    @JavascriptInterface
    public com.baidu.swan.games.r.e getOpenDataContext() {
        if (this.dXX == null) {
            this.dXX = new com.baidu.swan.games.r.e(this.dWl);
            this.dXX.canvas = this.dXW;
            this.dXW = null;
        }
        return this.dXX;
    }

    @JavascriptInterface
    public e getFileSystemManager() {
        if (this.dXT == null) {
            this.dXT = new e((com.baidu.swan.games.f.a) this.dWl);
        }
        return this.dXT;
    }

    @JavascriptInterface
    public com.baidu.swan.games.y.c loadSubpackage(JsObject jsObject) {
        com.baidu.swan.games.y.c cVar = new com.baidu.swan.games.y.c(this.dWl);
        cVar.n(jsObject);
        return cVar;
    }

    @JavascriptInterface
    public void exit(JsObject jsObject) {
        if (DEBUG) {
            this.dWl.aXo().log("exit from java side.");
        }
        if (jsObject != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            com.baidu.swan.games.binding.model.a f = com.baidu.swan.games.binding.model.a.f(com.baidu.swan.games.binding.model.c.e(jsObject));
            SwanAppActivity aBZ = f.aCp().aBZ();
            if (aBZ == null) {
                bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "failed");
                f.ac(bVar);
                return;
            }
            bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "ok");
            f.onSuccess(bVar);
            if (Build.VERSION.SDK_INT >= 21) {
                aBZ.finishAndRemoveTask();
            } else {
                aBZ.finish();
            }
        }
    }

    @JavascriptInterface
    public void reload(JsObject jsObject) {
        if (this.dYi == null) {
            this.dYi = new com.baidu.swan.games.s.a();
        }
        this.dYi.reload(jsObject);
    }

    @JavascriptInterface
    public void reload() {
        reload(null);
    }

    @JavascriptInterface
    public d getOpenData() {
        if (this.dXU == null) {
            this.dXU = new d((com.baidu.swan.games.f.a) this.dWl);
        }
        return this.dXU;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        if (this.dXV == null) {
            this.dXV = new com.baidu.swan.games.r.b(this.dWl);
        }
        this.dXV.checkIsUserAdvisedToRest(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.c createRewardedVideoAd(JsObject jsObject) {
        if (this.dYc == null) {
            this.dYc = com.baidu.swan.apps.t.a.azD().a(this.dWl, jsObject);
            if (this.dYc == null) {
                this.dYc = new com.baidu.swan.games.a.a();
            }
        }
        return this.dYc;
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.button.userinfo.b createUserInfoButton(JsObject jsObject) {
        return new com.baidu.swan.games.view.button.userinfo.b(jsObject, this.dWl);
    }

    @JavascriptInterface
    public void showKeyboard(JsObject jsObject) {
        if (this.dXY == null) {
            this.dXY = new com.baidu.swan.games.n.a(this.dWl, this.dXZ);
        }
        this.dXY.showKeyboard(jsObject);
    }

    @JavascriptInterface
    public void showKeyboard() {
        if (this.dXY == null) {
            this.dXY = new com.baidu.swan.games.n.a(this.dWl, this.dXZ);
        }
        this.dXY.showKeyboard(null);
    }

    @JavascriptInterface
    public void updateKeyboard(JsObject jsObject) {
        if (this.dXY != null) {
            this.dXY.updateKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void updateKeyboard() {
        if (this.dXY != null) {
            this.dXY.updateKeyboard(null);
        }
    }

    @JavascriptInterface
    public void hideKeyboard(JsObject jsObject) {
        if (this.dXY != null) {
            this.dXY.hideKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void hideKeyboard() {
        if (this.dXY != null) {
            this.dXY.hideKeyboard(null);
        }
    }

    @JavascriptInterface
    public void getStorage(JsObject jsObject) {
        aWK().getStorage(jsObject);
    }

    @JavascriptInterface
    public Object getStorageSync(String str) {
        return com.baidu.swan.games.w.a.d.a(this.dWl, "getStorageSync", str, aWK().yh(str));
    }

    @JavascriptInterface
    public void setStorage(JsObject jsObject) {
        aWK().setStorage(jsObject);
    }

    @JavascriptInterface
    public void setStorageSync(String str, JsSerializeValue jsSerializeValue) {
        com.baidu.swan.games.w.a.d.a(this.dWl, "setStorageSync", str, aWK().a(str, jsSerializeValue));
    }

    @JavascriptInterface
    public void setStorageSync(String str) {
        com.baidu.swan.games.w.a.d.a(this.dWl, "setStorageSync", str, aWK().a(str, (JsSerializeValue) null));
    }

    @JavascriptInterface
    public void removeStorage(JsObject jsObject) {
        aWK().removeStorage(jsObject);
    }

    @JavascriptInterface
    public void removeStorageSync(String str) {
        com.baidu.swan.games.w.a.d.a(this.dWl, "removeStorageSync", str, aWK().yi(str));
    }

    @JavascriptInterface
    public void clearStorage(JsObject jsObject) {
        aWK().clearStorage(jsObject);
    }

    @JavascriptInterface
    public void clearStorageSync() {
        com.baidu.swan.games.w.a.d.a(this.dWl, "clearStorageSync", "", aWK().aZI());
    }

    @JavascriptInterface
    public void getStorageInfo(JsObject jsObject) {
        aWK().getStorageInfo(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.w.a.c getStorageInfoSync() {
        return aWK().getStorageInfoSync();
    }

    @NonNull
    private com.baidu.swan.games.w.a aWK() {
        if (this.dYa == null) {
            this.dYa = new com.baidu.swan.games.w.a(this.dWl);
        }
        return this.dYa;
    }

    @JavascriptInterface
    public void setInnerAudioOption(JsObject jsObject) {
        this.dYg = new h(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.audio.g createInnerAudioContext() {
        return new com.baidu.swan.games.audio.g(this.dWl);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.b createBannerAd(JsObject jsObject) {
        return com.baidu.swan.apps.t.a.azD().b(this.dWl, jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.aa.d getUpdateManager(JsObject jsObject) {
        if (this.dYb == null) {
            this.dYb = new com.baidu.swan.games.aa.d(jsObject);
        }
        return this.dYb;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.websocket.c connectSocket(JsObject jsObject) {
        if (this.dYd == null) {
            this.dYd = new com.baidu.swan.games.network.websocket.a(this.dWl);
        }
        return this.dYd.connectSocket(jsObject);
    }

    @JavascriptInterface
    public void setEnableDebug(JsObject jsObject) {
        if (this.dYe == null) {
            this.dYe = new g(this.dWl);
        }
        this.dYe.setEnableDebug(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.c.c request(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        com.baidu.swan.games.network.a a2 = com.baidu.swan.games.network.b.d.aYP().a(this.dWl, e, 1);
        if (a2 instanceof com.baidu.swan.games.network.c.c) {
            com.baidu.swan.games.network.c.c cVar = (com.baidu.swan.games.network.c.c) a2;
            cVar.j(e);
            return cVar;
        }
        com.baidu.swan.games.network.c.c cVar2 = new com.baidu.swan.games.network.c.c(this.dWl, e);
        cVar2.start();
        return cVar2;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.d.b uploadFile(JsObject jsObject) {
        com.baidu.swan.games.network.d.b bVar = new com.baidu.swan.games.network.d.b(this.dWl, com.baidu.swan.games.binding.model.c.e(jsObject));
        bVar.start();
        return bVar;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.a.b downloadFile(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        com.baidu.swan.games.network.a a2 = com.baidu.swan.games.network.b.d.aYP().a(this.dWl, e, 2);
        if (a2 instanceof com.baidu.swan.games.network.a.b) {
            com.baidu.swan.games.network.a.b bVar = (com.baidu.swan.games.network.a.b) a2;
            bVar.j(e);
            return bVar;
        }
        com.baidu.swan.games.network.a.b bVar2 = new com.baidu.swan.games.network.a.b(this.dWl, e);
        bVar2.start();
        return bVar2;
    }

    @JavascriptInterface
    public void openCustomerServiceConversation(JsObject jsObject) {
        com.baidu.swan.games.d.a.a((c) this.dWl.aXm(), jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.screenrecord.a getVideoRecorderManager() {
        if (this.dYf == null) {
            this.dYf = new com.baidu.swan.games.screenrecord.a(this.dWl);
        }
        return this.dYf;
    }

    @JavascriptInterface
    public void shareVideo(JsObject jsObject) {
        new com.baidu.swan.games.u.b.a(jsObject).aqt();
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return com.baidu.swan.apps.jsbridge.a.b.f(this.dWl);
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton(JsObject jsObject) {
        return new RecommendButtonApiProxy(this.dWl, jsObject);
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton() {
        return createRecommendationButton(null);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide(JsObject jsObject) {
        if (this.dYh == null) {
            this.dYh = new DesktopGuideApi(this.dWl);
        }
        this.dYh.q(jsObject);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide() {
        showAddToDesktopGuide(null);
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.webview.a getWebViewManager() {
        if (this.dYj == null) {
            this.dYj = new com.baidu.swan.games.view.webview.a(this.dWl);
        }
        return this.dYj;
    }

    @JavascriptInterface
    public void getUUAPInfo(JsObject jsObject) {
        com.baidu.swan.games.ab.a.getUUAPInfo(jsObject);
    }

    @JavascriptInterface
    public String getAPIs(int i) {
        if (DEBUG) {
            return com.baidu.swan.apps.ad.a.a.aHt() ? SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i) : "";
        }
        return SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i);
    }

    @JavascriptInterface
    public void authorizeEval(JsObject jsObject) {
        com.baidu.swan.games.g.a.authorizeEval(jsObject);
    }

    @JavascriptInterface
    public void menuItemCtrl(JsObject jsObject) {
        com.baidu.swan.games.q.a aCd = f.aCp().aCd();
        if (aCd != null) {
            aCd.i(com.baidu.swan.games.binding.model.c.e(jsObject));
        }
    }

    @JavascriptInterface
    public com.baidu.swan.games.b.b getAntiAddiction() {
        if (this.dYk == null) {
            this.dYk = new com.baidu.swan.games.b.b(this.dWl);
        }
        return this.dYk;
    }
}
