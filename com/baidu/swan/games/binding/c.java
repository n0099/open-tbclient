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
import com.baidu.swan.apps.w.f;
import com.baidu.swan.games.audio.h;
import com.baidu.swan.games.c.g;
import com.baidu.swan.games.i.e;
import com.baidu.swan.games.r.d;
import com.baidu.swan.games.view.desktopguide.DesktopGuideApi;
import com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy;
/* loaded from: classes11.dex */
public final class c extends EventTargetImpl {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.f.b cYE;
    private h daA;
    private DesktopGuideApi daB;
    private com.baidu.swan.games.s.a daC;
    private com.baidu.swan.games.view.webview.a daD;
    private com.baidu.swan.games.b.b daE;
    private e dal;
    private d dam;
    private com.baidu.swan.games.r.b dan;
    private JsObject dao;
    private com.baidu.swan.games.r.e dap;
    private com.baidu.swan.games.n.a daq;
    private com.baidu.swan.games.n.b dar;
    private com.baidu.swan.games.w.a das;
    private com.baidu.swan.games.aa.d dau;
    private com.baidu.swan.games.a.c dav;
    private com.baidu.swan.games.network.websocket.a daw;
    private g dax;
    private com.baidu.swan.games.screenrecord.a daz;
    @V8JavascriptField
    public final String domain;
    @V8JavascriptField
    public com.baidu.swan.games.i.a env;

    public c(com.baidu.swan.games.f.b bVar) {
        super(bVar);
        this.domain = "main";
        this.dao = null;
        this.dap = null;
        this.daq = null;
        this.dar = null;
        this.dau = null;
        this.dav = null;
        this.daw = null;
        this.dax = null;
        this.daz = null;
        this.daA = null;
        this.daB = null;
        this.daC = null;
        this.daD = null;
        this.daE = null;
        this.cYE = bVar;
        this.env = new com.baidu.swan.games.i.a();
        aAe();
    }

    private void aAe() {
        this.dar = new com.baidu.swan.games.n.b(this.cYE);
    }

    public void d(JsObject jsObject) {
        this.dao = jsObject;
    }

    @JavascriptInterface
    public void setPreferredFramesPerSecond(short s) {
        if (s >= 1 && s <= 60) {
            this.cYE.setPreferredFramesPerSecond(s);
        }
    }

    @JavascriptInterface
    public com.baidu.swan.games.r.e getOpenDataContext() {
        if (this.dap == null) {
            this.dap = new com.baidu.swan.games.r.e(this.cYE);
            this.dap.canvas = this.dao;
            this.dao = null;
        }
        return this.dap;
    }

    @JavascriptInterface
    public e getFileSystemManager() {
        if (this.dal == null) {
            this.dal = new e((com.baidu.swan.games.f.a) this.cYE);
        }
        return this.dal;
    }

    @JavascriptInterface
    public com.baidu.swan.games.y.c loadSubpackage(JsObject jsObject) {
        com.baidu.swan.games.y.c cVar = new com.baidu.swan.games.y.c(this.cYE);
        cVar.n(jsObject);
        return cVar;
    }

    @JavascriptInterface
    public void exit(JsObject jsObject) {
        if (DEBUG) {
            this.cYE.aAJ().log("exit from java side.");
        }
        if (jsObject != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            com.baidu.swan.games.binding.model.a f = com.baidu.swan.games.binding.model.a.f(com.baidu.swan.games.binding.model.c.e(jsObject));
            SwanAppActivity aiL = f.ajb().aiL();
            if (aiL == null) {
                bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "failed");
                f.Y(bVar);
                return;
            }
            bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "ok");
            f.onSuccess(bVar);
            if (Build.VERSION.SDK_INT >= 21) {
                aiL.finishAndRemoveTask();
            } else {
                aiL.finish();
            }
        }
    }

    @JavascriptInterface
    public void reload(JsObject jsObject) {
        if (this.daC == null) {
            this.daC = new com.baidu.swan.games.s.a();
        }
        this.daC.reload(jsObject);
    }

    @JavascriptInterface
    public void reload() {
        reload(null);
    }

    @JavascriptInterface
    public d getOpenData() {
        if (this.dam == null) {
            this.dam = new d((com.baidu.swan.games.f.a) this.cYE);
        }
        return this.dam;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        if (this.dan == null) {
            this.dan = new com.baidu.swan.games.r.b(this.cYE);
        }
        this.dan.checkIsUserAdvisedToRest(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.c createRewardedVideoAd(JsObject jsObject) {
        if (this.dav == null) {
            this.dav = com.baidu.swan.apps.u.a.agy().a(this.cYE, jsObject);
            if (this.dav == null) {
                this.dav = new com.baidu.swan.games.a.a();
            }
        }
        return this.dav;
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.button.userinfo.b createUserInfoButton(JsObject jsObject) {
        return new com.baidu.swan.games.view.button.userinfo.b(jsObject, this.cYE);
    }

    @JavascriptInterface
    public void showKeyboard(JsObject jsObject) {
        if (this.daq == null) {
            this.daq = new com.baidu.swan.games.n.a(this.cYE, this.dar);
        }
        this.daq.showKeyboard(jsObject);
    }

    @JavascriptInterface
    public void showKeyboard() {
        if (this.daq == null) {
            this.daq = new com.baidu.swan.games.n.a(this.cYE, this.dar);
        }
        this.daq.showKeyboard(null);
    }

    @JavascriptInterface
    public void updateKeyboard(JsObject jsObject) {
        if (this.daq != null) {
            this.daq.updateKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void updateKeyboard() {
        if (this.daq != null) {
            this.daq.updateKeyboard(null);
        }
    }

    @JavascriptInterface
    public void hideKeyboard(JsObject jsObject) {
        if (this.daq != null) {
            this.daq.hideKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void hideKeyboard() {
        if (this.daq != null) {
            this.daq.hideKeyboard(null);
        }
    }

    @JavascriptInterface
    public void getStorage(JsObject jsObject) {
        aAf().getStorage(jsObject);
    }

    @JavascriptInterface
    public Object getStorageSync(String str) {
        return com.baidu.swan.games.w.a.d.a(this.cYE, "getStorageSync", str, aAf().sE(str));
    }

    @JavascriptInterface
    public void setStorage(JsObject jsObject) {
        aAf().setStorage(jsObject);
    }

    @JavascriptInterface
    public void setStorageSync(String str, JsSerializeValue jsSerializeValue) {
        com.baidu.swan.games.w.a.d.a(this.cYE, "setStorageSync", str, aAf().a(str, jsSerializeValue));
    }

    @JavascriptInterface
    public void setStorageSync(String str) {
        com.baidu.swan.games.w.a.d.a(this.cYE, "setStorageSync", str, aAf().a(str, (JsSerializeValue) null));
    }

    @JavascriptInterface
    public void removeStorage(JsObject jsObject) {
        aAf().removeStorage(jsObject);
    }

    @JavascriptInterface
    public void removeStorageSync(String str) {
        com.baidu.swan.games.w.a.d.a(this.cYE, "removeStorageSync", str, aAf().sF(str));
    }

    @JavascriptInterface
    public void clearStorage(JsObject jsObject) {
        aAf().clearStorage(jsObject);
    }

    @JavascriptInterface
    public void clearStorageSync() {
        com.baidu.swan.games.w.a.d.a(this.cYE, "clearStorageSync", "", aAf().aCZ());
    }

    @JavascriptInterface
    public void getStorageInfo(JsObject jsObject) {
        aAf().getStorageInfo(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.w.a.c getStorageInfoSync() {
        return aAf().getStorageInfoSync();
    }

    @NonNull
    private com.baidu.swan.games.w.a aAf() {
        if (this.das == null) {
            this.das = new com.baidu.swan.games.w.a(this.cYE);
        }
        return this.das;
    }

    @JavascriptInterface
    public void setInnerAudioOption(JsObject jsObject) {
        this.daA = new h(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.audio.g createInnerAudioContext() {
        return new com.baidu.swan.games.audio.g(this.cYE);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.b createBannerAd(JsObject jsObject) {
        return com.baidu.swan.apps.u.a.agy().b(this.cYE, jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.aa.d getUpdateManager(JsObject jsObject) {
        if (this.dau == null) {
            this.dau = new com.baidu.swan.games.aa.d(jsObject);
        }
        return this.dau;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.websocket.c connectSocket(JsObject jsObject) {
        if (this.daw == null) {
            this.daw = new com.baidu.swan.games.network.websocket.a(this.cYE);
        }
        return this.daw.connectSocket(jsObject);
    }

    @JavascriptInterface
    public void setEnableDebug(JsObject jsObject) {
        if (this.dax == null) {
            this.dax = new g(this.cYE);
        }
        this.dax.setEnableDebug(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.c.c request(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        com.baidu.swan.games.network.a a = com.baidu.swan.games.network.b.d.aCg().a(this.cYE, e, 1);
        if (a instanceof com.baidu.swan.games.network.c.c) {
            com.baidu.swan.games.network.c.c cVar = (com.baidu.swan.games.network.c.c) a;
            cVar.j(e);
            return cVar;
        }
        com.baidu.swan.games.network.c.c cVar2 = new com.baidu.swan.games.network.c.c(this.cYE, e);
        cVar2.start();
        return cVar2;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.d.b uploadFile(JsObject jsObject) {
        com.baidu.swan.games.network.d.b bVar = new com.baidu.swan.games.network.d.b(this.cYE, com.baidu.swan.games.binding.model.c.e(jsObject));
        bVar.start();
        return bVar;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.a.b downloadFile(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        com.baidu.swan.games.network.a a = com.baidu.swan.games.network.b.d.aCg().a(this.cYE, e, 2);
        if (a instanceof com.baidu.swan.games.network.a.b) {
            com.baidu.swan.games.network.a.b bVar = (com.baidu.swan.games.network.a.b) a;
            bVar.j(e);
            return bVar;
        }
        com.baidu.swan.games.network.a.b bVar2 = new com.baidu.swan.games.network.a.b(this.cYE, e);
        bVar2.start();
        return bVar2;
    }

    @JavascriptInterface
    public void openCustomerServiceConversation(JsObject jsObject) {
        com.baidu.swan.games.d.a.a((c) this.cYE.aAH(), jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.screenrecord.a getVideoRecorderManager() {
        if (this.daz == null) {
            this.daz = new com.baidu.swan.games.screenrecord.a(this.cYE);
        }
        return this.daz;
    }

    @JavascriptInterface
    public void shareVideo(JsObject jsObject) {
        new com.baidu.swan.games.u.b.a(jsObject).Zy();
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return com.baidu.swan.apps.jsbridge.a.b.getEnvVariables();
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton(JsObject jsObject) {
        return new RecommendButtonApiProxy(this.cYE, jsObject);
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton() {
        return createRecommendationButton(null);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide(JsObject jsObject) {
        if (this.daB == null) {
            this.daB = new DesktopGuideApi(this.cYE);
        }
        this.daB.q(jsObject);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide() {
        showAddToDesktopGuide(null);
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.webview.a getWebViewManager() {
        if (this.daD == null) {
            this.daD = new com.baidu.swan.games.view.webview.a(this.cYE);
        }
        return this.daD;
    }

    @JavascriptInterface
    public void getUUAPInfo(JsObject jsObject) {
        com.baidu.swan.games.ab.a.getUUAPInfo(jsObject);
    }

    @JavascriptInterface
    public String getAPIs(int i) {
        return DEBUG ? com.baidu.swan.apps.af.a.a.anz() ? SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i) : "" : com.baidu.swan.apps.u.a.aga().Sn() ? SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i) : "";
    }

    @JavascriptInterface
    public void authorizeEval(JsObject jsObject) {
        com.baidu.swan.games.g.a.authorizeEval(jsObject);
    }

    @JavascriptInterface
    public void menuItemCtrl(JsObject jsObject) {
        com.baidu.swan.games.q.a aiP = f.ajb().aiP();
        if (aiP != null) {
            aiP.i(com.baidu.swan.games.binding.model.c.e(jsObject));
        }
    }

    @JavascriptInterface
    public com.baidu.swan.games.b.b getAntiAddiction() {
        if (this.daE == null) {
            this.daE = new com.baidu.swan.games.b.b(this.cYE);
        }
        return this.daE;
    }
}
