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
/* loaded from: classes10.dex */
public final class c extends EventTargetImpl {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.f.b dCG;
    private com.baidu.swan.games.screenrecord.a dEA;
    private h dEB;
    private DesktopGuideApi dEC;
    private com.baidu.swan.games.s.a dED;
    private com.baidu.swan.games.view.webview.a dEE;
    private com.baidu.swan.games.b.b dEF;
    private e dEo;
    private d dEp;
    private com.baidu.swan.games.r.b dEq;
    private JsObject dEr;
    private com.baidu.swan.games.r.e dEs;
    private com.baidu.swan.games.n.a dEt;
    private com.baidu.swan.games.n.b dEu;
    private com.baidu.swan.games.w.a dEv;
    private com.baidu.swan.games.aa.d dEw;
    private com.baidu.swan.games.a.c dEx;
    private com.baidu.swan.games.network.websocket.a dEy;
    private g dEz;
    @V8JavascriptField
    public final String domain;
    @V8JavascriptField
    public com.baidu.swan.games.i.a env;

    public c(com.baidu.swan.games.f.b bVar) {
        super(bVar);
        this.domain = "main";
        this.dEr = null;
        this.dEs = null;
        this.dEt = null;
        this.dEu = null;
        this.dEw = null;
        this.dEx = null;
        this.dEy = null;
        this.dEz = null;
        this.dEA = null;
        this.dEB = null;
        this.dEC = null;
        this.dED = null;
        this.dEE = null;
        this.dEF = null;
        this.dCG = bVar;
        this.env = new com.baidu.swan.games.i.a();
        aPS();
    }

    private void aPS() {
        this.dEu = new com.baidu.swan.games.n.b(this.dCG);
    }

    public void d(JsObject jsObject) {
        this.dEr = jsObject;
    }

    @JavascriptInterface
    public void setPreferredFramesPerSecond(short s) {
        if (s >= 1 && s <= 60) {
            this.dCG.setPreferredFramesPerSecond(s);
        }
    }

    @JavascriptInterface
    public com.baidu.swan.games.r.e getOpenDataContext() {
        if (this.dEs == null) {
            this.dEs = new com.baidu.swan.games.r.e(this.dCG);
            this.dEs.canvas = this.dEr;
            this.dEr = null;
        }
        return this.dEs;
    }

    @JavascriptInterface
    public e getFileSystemManager() {
        if (this.dEo == null) {
            this.dEo = new e((com.baidu.swan.games.f.a) this.dCG);
        }
        return this.dEo;
    }

    @JavascriptInterface
    public com.baidu.swan.games.y.c loadSubpackage(JsObject jsObject) {
        com.baidu.swan.games.y.c cVar = new com.baidu.swan.games.y.c(this.dCG);
        cVar.n(jsObject);
        return cVar;
    }

    @JavascriptInterface
    public void exit(JsObject jsObject) {
        if (DEBUG) {
            this.dCG.aQx().log("exit from java side.");
        }
        if (jsObject != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            com.baidu.swan.games.binding.model.a f = com.baidu.swan.games.binding.model.a.f(com.baidu.swan.games.binding.model.c.e(jsObject));
            SwanAppActivity ave = f.avu().ave();
            if (ave == null) {
                bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "failed");
                f.ac(bVar);
                return;
            }
            bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "ok");
            f.onSuccess(bVar);
            if (Build.VERSION.SDK_INT >= 21) {
                ave.finishAndRemoveTask();
            } else {
                ave.finish();
            }
        }
    }

    @JavascriptInterface
    public void reload(JsObject jsObject) {
        if (this.dED == null) {
            this.dED = new com.baidu.swan.games.s.a();
        }
        this.dED.reload(jsObject);
    }

    @JavascriptInterface
    public void reload() {
        reload(null);
    }

    @JavascriptInterface
    public d getOpenData() {
        if (this.dEp == null) {
            this.dEp = new d((com.baidu.swan.games.f.a) this.dCG);
        }
        return this.dEp;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        if (this.dEq == null) {
            this.dEq = new com.baidu.swan.games.r.b(this.dCG);
        }
        this.dEq.checkIsUserAdvisedToRest(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.c createRewardedVideoAd(JsObject jsObject) {
        if (this.dEx == null) {
            this.dEx = com.baidu.swan.apps.t.a.asJ().a(this.dCG, jsObject);
            if (this.dEx == null) {
                this.dEx = new com.baidu.swan.games.a.a();
            }
        }
        return this.dEx;
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.button.userinfo.b createUserInfoButton(JsObject jsObject) {
        return new com.baidu.swan.games.view.button.userinfo.b(jsObject, this.dCG);
    }

    @JavascriptInterface
    public void showKeyboard(JsObject jsObject) {
        if (this.dEt == null) {
            this.dEt = new com.baidu.swan.games.n.a(this.dCG, this.dEu);
        }
        this.dEt.showKeyboard(jsObject);
    }

    @JavascriptInterface
    public void showKeyboard() {
        if (this.dEt == null) {
            this.dEt = new com.baidu.swan.games.n.a(this.dCG, this.dEu);
        }
        this.dEt.showKeyboard(null);
    }

    @JavascriptInterface
    public void updateKeyboard(JsObject jsObject) {
        if (this.dEt != null) {
            this.dEt.updateKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void updateKeyboard() {
        if (this.dEt != null) {
            this.dEt.updateKeyboard(null);
        }
    }

    @JavascriptInterface
    public void hideKeyboard(JsObject jsObject) {
        if (this.dEt != null) {
            this.dEt.hideKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void hideKeyboard() {
        if (this.dEt != null) {
            this.dEt.hideKeyboard(null);
        }
    }

    @JavascriptInterface
    public void getStorage(JsObject jsObject) {
        aPT().getStorage(jsObject);
    }

    @JavascriptInterface
    public Object getStorageSync(String str) {
        return com.baidu.swan.games.w.a.d.a(this.dCG, "getStorageSync", str, aPT().wY(str));
    }

    @JavascriptInterface
    public void setStorage(JsObject jsObject) {
        aPT().setStorage(jsObject);
    }

    @JavascriptInterface
    public void setStorageSync(String str, JsSerializeValue jsSerializeValue) {
        com.baidu.swan.games.w.a.d.a(this.dCG, "setStorageSync", str, aPT().a(str, jsSerializeValue));
    }

    @JavascriptInterface
    public void setStorageSync(String str) {
        com.baidu.swan.games.w.a.d.a(this.dCG, "setStorageSync", str, aPT().a(str, (JsSerializeValue) null));
    }

    @JavascriptInterface
    public void removeStorage(JsObject jsObject) {
        aPT().removeStorage(jsObject);
    }

    @JavascriptInterface
    public void removeStorageSync(String str) {
        com.baidu.swan.games.w.a.d.a(this.dCG, "removeStorageSync", str, aPT().wZ(str));
    }

    @JavascriptInterface
    public void clearStorage(JsObject jsObject) {
        aPT().clearStorage(jsObject);
    }

    @JavascriptInterface
    public void clearStorageSync() {
        com.baidu.swan.games.w.a.d.a(this.dCG, "clearStorageSync", "", aPT().aSR());
    }

    @JavascriptInterface
    public void getStorageInfo(JsObject jsObject) {
        aPT().getStorageInfo(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.w.a.c getStorageInfoSync() {
        return aPT().getStorageInfoSync();
    }

    @NonNull
    private com.baidu.swan.games.w.a aPT() {
        if (this.dEv == null) {
            this.dEv = new com.baidu.swan.games.w.a(this.dCG);
        }
        return this.dEv;
    }

    @JavascriptInterface
    public void setInnerAudioOption(JsObject jsObject) {
        this.dEB = new h(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.audio.g createInnerAudioContext() {
        return new com.baidu.swan.games.audio.g(this.dCG);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.b createBannerAd(JsObject jsObject) {
        return com.baidu.swan.apps.t.a.asJ().b(this.dCG, jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.aa.d getUpdateManager(JsObject jsObject) {
        if (this.dEw == null) {
            this.dEw = new com.baidu.swan.games.aa.d(jsObject);
        }
        return this.dEw;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.websocket.c connectSocket(JsObject jsObject) {
        if (this.dEy == null) {
            this.dEy = new com.baidu.swan.games.network.websocket.a(this.dCG);
        }
        return this.dEy.connectSocket(jsObject);
    }

    @JavascriptInterface
    public void setEnableDebug(JsObject jsObject) {
        if (this.dEz == null) {
            this.dEz = new g(this.dCG);
        }
        this.dEz.setEnableDebug(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.c.c request(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        com.baidu.swan.games.network.a a2 = com.baidu.swan.games.network.b.d.aRY().a(this.dCG, e, 1);
        if (a2 instanceof com.baidu.swan.games.network.c.c) {
            com.baidu.swan.games.network.c.c cVar = (com.baidu.swan.games.network.c.c) a2;
            cVar.j(e);
            return cVar;
        }
        com.baidu.swan.games.network.c.c cVar2 = new com.baidu.swan.games.network.c.c(this.dCG, e);
        cVar2.start();
        return cVar2;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.d.b uploadFile(JsObject jsObject) {
        com.baidu.swan.games.network.d.b bVar = new com.baidu.swan.games.network.d.b(this.dCG, com.baidu.swan.games.binding.model.c.e(jsObject));
        bVar.start();
        return bVar;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.a.b downloadFile(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        com.baidu.swan.games.network.a a2 = com.baidu.swan.games.network.b.d.aRY().a(this.dCG, e, 2);
        if (a2 instanceof com.baidu.swan.games.network.a.b) {
            com.baidu.swan.games.network.a.b bVar = (com.baidu.swan.games.network.a.b) a2;
            bVar.j(e);
            return bVar;
        }
        com.baidu.swan.games.network.a.b bVar2 = new com.baidu.swan.games.network.a.b(this.dCG, e);
        bVar2.start();
        return bVar2;
    }

    @JavascriptInterface
    public void openCustomerServiceConversation(JsObject jsObject) {
        com.baidu.swan.games.d.a.a((c) this.dCG.aQv(), jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.screenrecord.a getVideoRecorderManager() {
        if (this.dEA == null) {
            this.dEA = new com.baidu.swan.games.screenrecord.a(this.dCG);
        }
        return this.dEA;
    }

    @JavascriptInterface
    public void shareVideo(JsObject jsObject) {
        new com.baidu.swan.games.u.b.a(jsObject).ajz();
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return com.baidu.swan.apps.jsbridge.a.b.f(this.dCG);
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton(JsObject jsObject) {
        return new RecommendButtonApiProxy(this.dCG, jsObject);
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton() {
        return createRecommendationButton(null);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide(JsObject jsObject) {
        if (this.dEC == null) {
            this.dEC = new DesktopGuideApi(this.dCG);
        }
        this.dEC.q(jsObject);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide() {
        showAddToDesktopGuide(null);
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.webview.a getWebViewManager() {
        if (this.dEE == null) {
            this.dEE = new com.baidu.swan.games.view.webview.a(this.dCG);
        }
        return this.dEE;
    }

    @JavascriptInterface
    public void getUUAPInfo(JsObject jsObject) {
        com.baidu.swan.games.ab.a.getUUAPInfo(jsObject);
    }

    @JavascriptInterface
    public String getAPIs(int i) {
        if (DEBUG) {
            return com.baidu.swan.apps.ad.a.a.aAz() ? SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i) : "";
        }
        return SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i);
    }

    @JavascriptInterface
    public void authorizeEval(JsObject jsObject) {
        com.baidu.swan.games.g.a.authorizeEval(jsObject);
    }

    @JavascriptInterface
    public void menuItemCtrl(JsObject jsObject) {
        com.baidu.swan.games.q.a avi = f.avu().avi();
        if (avi != null) {
            avi.i(com.baidu.swan.games.binding.model.c.e(jsObject));
        }
    }

    @JavascriptInterface
    public com.baidu.swan.games.b.b getAntiAddiction() {
        if (this.dEF == null) {
            this.dEF = new com.baidu.swan.games.b.b(this.dCG);
        }
        return this.dEF;
    }
}
