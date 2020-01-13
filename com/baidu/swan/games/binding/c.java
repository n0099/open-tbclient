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
import com.baidu.swan.games.q.e;
import com.baidu.swan.games.view.desktopguide.DesktopGuideApi;
import com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy;
import com.baidu.swan.games.z.d;
/* loaded from: classes10.dex */
public final class c extends EventTargetImpl {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.e.b cfV;
    private com.baidu.swan.games.m.a chA;
    private com.baidu.swan.games.m.b chB;
    private com.baidu.swan.games.v.a chC;
    private d chD;
    private com.baidu.swan.games.a.c chE;
    private com.baidu.swan.games.network.websocket.a chF;
    private g chG;
    private com.baidu.swan.games.screenrecord.a chH;
    private h chI;
    private DesktopGuideApi chJ;
    private com.baidu.swan.games.r.a chK;
    private com.baidu.swan.games.view.webview.a chL;
    private com.baidu.swan.games.h.d chv;
    private com.baidu.swan.games.q.d chw;
    private com.baidu.swan.games.q.b chx;
    private JsObject chy;
    private e chz;
    @V8JavascriptField
    public final String domain;
    @V8JavascriptField
    public com.baidu.swan.games.h.a env;

    public c(com.baidu.swan.games.e.b bVar) {
        super(bVar);
        this.domain = "main";
        this.chy = null;
        this.chz = null;
        this.chA = null;
        this.chB = null;
        this.chD = null;
        this.chE = null;
        this.chF = null;
        this.chG = null;
        this.chH = null;
        this.chI = null;
        this.chJ = null;
        this.chK = null;
        this.chL = null;
        this.cfV = bVar;
        this.env = new com.baidu.swan.games.h.a();
        akD();
    }

    private void akD() {
        this.chB = new com.baidu.swan.games.m.b(this.cfV);
    }

    public void b(JsObject jsObject) {
        this.chy = jsObject;
    }

    @JavascriptInterface
    public void setPreferredFramesPerSecond(short s) {
        if (s >= 1 && s <= 60) {
            this.cfV.setPreferredFramesPerSecond(s);
        }
    }

    @JavascriptInterface
    public e getOpenDataContext() {
        if (this.chz == null) {
            this.chz = new e(this.cfV);
            this.chz.canvas = this.chy;
            this.chy = null;
        }
        return this.chz;
    }

    @JavascriptInterface
    public com.baidu.swan.games.h.d getFileSystemManager() {
        if (this.chv == null) {
            this.chv = new com.baidu.swan.games.h.d((com.baidu.swan.games.e.a) this.cfV);
        }
        return this.chv;
    }

    @JavascriptInterface
    public com.baidu.swan.games.x.c loadSubpackage(JsObject jsObject) {
        com.baidu.swan.games.x.c cVar = new com.baidu.swan.games.x.c(this.cfV);
        cVar.l(jsObject);
        return cVar;
    }

    @JavascriptInterface
    public void exit(JsObject jsObject) {
        if (DEBUG) {
            this.cfV.ali().log("exit from java side.");
        }
        if (jsObject != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            com.baidu.swan.games.binding.model.a f = com.baidu.swan.games.binding.model.a.f(com.baidu.swan.games.binding.model.c.c(jsObject));
            SwanAppActivity Un = f.UC().Un();
            if (Un == null) {
                bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "failed");
                f.Q(bVar);
                return;
            }
            bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "ok");
            f.onSuccess(bVar);
            if (Build.VERSION.SDK_INT >= 21) {
                Un.finishAndRemoveTask();
            } else {
                Un.finish();
            }
        }
    }

    @JavascriptInterface
    public void reload(JsObject jsObject) {
        if (this.chK == null) {
            this.chK = new com.baidu.swan.games.r.a();
        }
        this.chK.reload(jsObject);
    }

    @JavascriptInterface
    public void reload() {
        reload(null);
    }

    @JavascriptInterface
    public com.baidu.swan.games.q.d getOpenData() {
        if (this.chw == null) {
            this.chw = new com.baidu.swan.games.q.d((com.baidu.swan.games.e.a) this.cfV);
        }
        return this.chw;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        if (this.chx == null) {
            this.chx = new com.baidu.swan.games.q.b(this.cfV);
        }
        this.chx.checkIsUserAdvisedToRest(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.c createRewardedVideoAd(JsObject jsObject) {
        if (this.chE == null) {
            this.chE = com.baidu.swan.apps.w.a.Si().a(this.cfV, jsObject);
            if (this.chE == null) {
                this.chE = new com.baidu.swan.games.a.a();
            }
        }
        return this.chE;
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.button.userinfo.b createUserInfoButton(JsObject jsObject) {
        return new com.baidu.swan.games.view.button.userinfo.b(jsObject, this.cfV);
    }

    @JavascriptInterface
    public void showKeyboard(JsObject jsObject) {
        if (this.chA == null) {
            this.chA = new com.baidu.swan.games.m.a(this.cfV, this.chB);
        }
        this.chA.showKeyboard(jsObject);
    }

    @JavascriptInterface
    public void showKeyboard() {
        if (this.chA == null) {
            this.chA = new com.baidu.swan.games.m.a(this.cfV, this.chB);
        }
        this.chA.showKeyboard(null);
    }

    @JavascriptInterface
    public void updateKeyboard(JsObject jsObject) {
        if (this.chA != null) {
            this.chA.updateKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void updateKeyboard() {
        if (this.chA != null) {
            this.chA.updateKeyboard(null);
        }
    }

    @JavascriptInterface
    public void hideKeyboard(JsObject jsObject) {
        if (this.chA != null) {
            this.chA.hideKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void hideKeyboard() {
        if (this.chA != null) {
            this.chA.hideKeyboard(null);
        }
    }

    @JavascriptInterface
    public void getStorage(JsObject jsObject) {
        akE().getStorage(jsObject);
    }

    @JavascriptInterface
    public Object getStorageSync(String str) {
        return com.baidu.swan.games.v.a.d.a(this.cfV, "getStorageSync", str, akE().pr(str));
    }

    @JavascriptInterface
    public void setStorage(JsObject jsObject) {
        akE().setStorage(jsObject);
    }

    @JavascriptInterface
    public void setStorageSync(String str, JsSerializeValue jsSerializeValue) {
        com.baidu.swan.games.v.a.d.a(this.cfV, "setStorageSync", str, akE().a(str, jsSerializeValue));
    }

    @JavascriptInterface
    public void setStorageSync(String str) {
        com.baidu.swan.games.v.a.d.a(this.cfV, "setStorageSync", str, akE().a(str, (JsSerializeValue) null));
    }

    @JavascriptInterface
    public void removeStorage(JsObject jsObject) {
        akE().removeStorage(jsObject);
    }

    @JavascriptInterface
    public void removeStorageSync(String str) {
        com.baidu.swan.games.v.a.d.a(this.cfV, "removeStorageSync", str, akE().ps(str));
    }

    @JavascriptInterface
    public void clearStorage(JsObject jsObject) {
        akE().clearStorage(jsObject);
    }

    @JavascriptInterface
    public void clearStorageSync() {
        com.baidu.swan.games.v.a.d.a(this.cfV, "clearStorageSync", "", akE().anx());
    }

    @JavascriptInterface
    public void getStorageInfo(JsObject jsObject) {
        akE().getStorageInfo(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.v.a.c getStorageInfoSync() {
        return akE().getStorageInfoSync();
    }

    @NonNull
    private com.baidu.swan.games.v.a akE() {
        if (this.chC == null) {
            this.chC = new com.baidu.swan.games.v.a(this.cfV);
        }
        return this.chC;
    }

    @JavascriptInterface
    public void setInnerAudioOption(JsObject jsObject) {
        this.chI = new h(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.audio.g createInnerAudioContext() {
        return new com.baidu.swan.games.audio.g(this.cfV);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.b createBannerAd(JsObject jsObject) {
        return com.baidu.swan.apps.w.a.Si().b(this.cfV, jsObject);
    }

    @JavascriptInterface
    public d getUpdateManager(JsObject jsObject) {
        if (this.chD == null) {
            this.chD = new d(jsObject);
        }
        return this.chD;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.websocket.c connectSocket(JsObject jsObject) {
        if (this.chF == null) {
            this.chF = new com.baidu.swan.games.network.websocket.a(this.cfV);
        }
        return this.chF.connectSocket(jsObject);
    }

    @JavascriptInterface
    public void setEnableDebug(JsObject jsObject) {
        if (this.chG == null) {
            this.chG = new g(this.cfV);
        }
        this.chG.setEnableDebug(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.c.c request(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        com.baidu.swan.games.network.a a = com.baidu.swan.games.network.b.d.amE().a(this.cfV, c, 1);
        if (a instanceof com.baidu.swan.games.network.c.c) {
            com.baidu.swan.games.network.c.c cVar = (com.baidu.swan.games.network.c.c) a;
            cVar.j(c);
            return cVar;
        }
        com.baidu.swan.games.network.c.c cVar2 = new com.baidu.swan.games.network.c.c(this.cfV, c);
        cVar2.start();
        return cVar2;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.d.b uploadFile(JsObject jsObject) {
        com.baidu.swan.games.network.d.b bVar = new com.baidu.swan.games.network.d.b(this.cfV, com.baidu.swan.games.binding.model.c.c(jsObject));
        bVar.start();
        return bVar;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.a.b downloadFile(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        com.baidu.swan.games.network.a a = com.baidu.swan.games.network.b.d.amE().a(this.cfV, c, 2);
        if (a instanceof com.baidu.swan.games.network.a.b) {
            com.baidu.swan.games.network.a.b bVar = (com.baidu.swan.games.network.a.b) a;
            bVar.j(c);
            return bVar;
        }
        com.baidu.swan.games.network.a.b bVar2 = new com.baidu.swan.games.network.a.b(this.cfV, c);
        bVar2.start();
        return bVar2;
    }

    @JavascriptInterface
    public void openCustomerServiceConversation(JsObject jsObject) {
        com.baidu.swan.games.c.a.a((c) this.cfV.alg(), jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.screenrecord.a getVideoRecorderManager() {
        if (this.chH == null) {
            this.chH = new com.baidu.swan.games.screenrecord.a(this.cfV);
        }
        return this.chH;
    }

    @JavascriptInterface
    public void shareVideo(JsObject jsObject) {
        new com.baidu.swan.games.t.b.a(jsObject).LB();
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return com.baidu.swan.apps.jsbridge.a.b.getEnvVariables();
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton(JsObject jsObject) {
        return new RecommendButtonApiProxy(this.cfV, jsObject);
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton() {
        return createRecommendationButton(null);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide(JsObject jsObject) {
        if (this.chJ == null) {
            this.chJ = new DesktopGuideApi(this.cfV);
        }
        this.chJ.o(jsObject);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide() {
        showAddToDesktopGuide(null);
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.webview.a getWebViewManager() {
        if (this.chL == null) {
            this.chL = new com.baidu.swan.games.view.webview.a(this.cfV);
        }
        return this.chL;
    }

    @JavascriptInterface
    public void getUUAPInfo(JsObject jsObject) {
        com.baidu.swan.games.aa.a.getUUAPInfo(jsObject);
    }

    @JavascriptInterface
    public String getAPIs(int i) {
        return DEBUG ? com.baidu.swan.apps.ah.a.a.Yp() ? SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i) : "" : com.baidu.swan.apps.w.a.RJ().EO() ? SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i) : "";
    }

    @JavascriptInterface
    public void authorizeEval(JsObject jsObject) {
        com.baidu.swan.games.f.a.authorizeEval(jsObject);
    }

    @JavascriptInterface
    public void menuItemCtrl(JsObject jsObject) {
        com.baidu.swan.games.p.a Ur = f.UC().Ur();
        if (Ur != null) {
            Ur.i(com.baidu.swan.games.binding.model.c.c(jsObject));
        }
    }
}
