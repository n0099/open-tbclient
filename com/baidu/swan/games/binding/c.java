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
/* loaded from: classes3.dex */
public final class c extends EventTargetImpl {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @V8JavascriptField
    public final String domain;
    private com.baidu.swan.games.f.b dqC;
    private DesktopGuideApi dsA;
    private com.baidu.swan.games.s.a dsB;
    private com.baidu.swan.games.view.webview.a dsC;
    private com.baidu.swan.games.b.b dsD;
    private e dsl;
    private d dsm;
    private com.baidu.swan.games.r.b dsn;
    private JsObject dso;
    private com.baidu.swan.games.r.e dsp;
    private com.baidu.swan.games.n.a dsq;
    private com.baidu.swan.games.n.b dsr;
    private com.baidu.swan.games.w.a dss;
    private com.baidu.swan.games.aa.d dsu;
    private com.baidu.swan.games.a.c dsv;
    private com.baidu.swan.games.network.websocket.a dsw;
    private g dsx;
    private com.baidu.swan.games.screenrecord.a dsy;
    private h dsz;
    @V8JavascriptField
    public com.baidu.swan.games.i.a env;

    public c(com.baidu.swan.games.f.b bVar) {
        super(bVar);
        this.domain = "main";
        this.dso = null;
        this.dsp = null;
        this.dsq = null;
        this.dsr = null;
        this.dsu = null;
        this.dsv = null;
        this.dsw = null;
        this.dsx = null;
        this.dsy = null;
        this.dsz = null;
        this.dsA = null;
        this.dsB = null;
        this.dsC = null;
        this.dsD = null;
        this.dqC = bVar;
        this.env = new com.baidu.swan.games.i.a();
        aNj();
    }

    private void aNj() {
        this.dsr = new com.baidu.swan.games.n.b(this.dqC);
    }

    public void d(JsObject jsObject) {
        this.dso = jsObject;
    }

    @JavascriptInterface
    public void setPreferredFramesPerSecond(short s) {
        if (s >= 1 && s <= 60) {
            this.dqC.setPreferredFramesPerSecond(s);
        }
    }

    @JavascriptInterface
    public com.baidu.swan.games.r.e getOpenDataContext() {
        if (this.dsp == null) {
            this.dsp = new com.baidu.swan.games.r.e(this.dqC);
            this.dsp.canvas = this.dso;
            this.dso = null;
        }
        return this.dsp;
    }

    @JavascriptInterface
    public e getFileSystemManager() {
        if (this.dsl == null) {
            this.dsl = new e((com.baidu.swan.games.f.a) this.dqC);
        }
        return this.dsl;
    }

    @JavascriptInterface
    public com.baidu.swan.games.y.c loadSubpackage(JsObject jsObject) {
        com.baidu.swan.games.y.c cVar = new com.baidu.swan.games.y.c(this.dqC);
        cVar.n(jsObject);
        return cVar;
    }

    @JavascriptInterface
    public void exit(JsObject jsObject) {
        if (DEBUG) {
            this.dqC.aNO().log("exit from java side.");
        }
        if (jsObject != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            com.baidu.swan.games.binding.model.a f = com.baidu.swan.games.binding.model.a.f(com.baidu.swan.games.binding.model.c.e(jsObject));
            SwanAppActivity ast = f.asJ().ast();
            if (ast == null) {
                bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "failed");
                f.Z(bVar);
                return;
            }
            bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "ok");
            f.onSuccess(bVar);
            if (Build.VERSION.SDK_INT >= 21) {
                ast.finishAndRemoveTask();
            } else {
                ast.finish();
            }
        }
    }

    @JavascriptInterface
    public void reload(JsObject jsObject) {
        if (this.dsB == null) {
            this.dsB = new com.baidu.swan.games.s.a();
        }
        this.dsB.reload(jsObject);
    }

    @JavascriptInterface
    public void reload() {
        reload(null);
    }

    @JavascriptInterface
    public d getOpenData() {
        if (this.dsm == null) {
            this.dsm = new d((com.baidu.swan.games.f.a) this.dqC);
        }
        return this.dsm;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        if (this.dsn == null) {
            this.dsn = new com.baidu.swan.games.r.b(this.dqC);
        }
        this.dsn.checkIsUserAdvisedToRest(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.c createRewardedVideoAd(JsObject jsObject) {
        if (this.dsv == null) {
            this.dsv = com.baidu.swan.apps.t.a.apX().a(this.dqC, jsObject);
            if (this.dsv == null) {
                this.dsv = new com.baidu.swan.games.a.a();
            }
        }
        return this.dsv;
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.button.userinfo.b createUserInfoButton(JsObject jsObject) {
        return new com.baidu.swan.games.view.button.userinfo.b(jsObject, this.dqC);
    }

    @JavascriptInterface
    public void showKeyboard(JsObject jsObject) {
        if (this.dsq == null) {
            this.dsq = new com.baidu.swan.games.n.a(this.dqC, this.dsr);
        }
        this.dsq.showKeyboard(jsObject);
    }

    @JavascriptInterface
    public void showKeyboard() {
        if (this.dsq == null) {
            this.dsq = new com.baidu.swan.games.n.a(this.dqC, this.dsr);
        }
        this.dsq.showKeyboard(null);
    }

    @JavascriptInterface
    public void updateKeyboard(JsObject jsObject) {
        if (this.dsq != null) {
            this.dsq.updateKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void updateKeyboard() {
        if (this.dsq != null) {
            this.dsq.updateKeyboard(null);
        }
    }

    @JavascriptInterface
    public void hideKeyboard(JsObject jsObject) {
        if (this.dsq != null) {
            this.dsq.hideKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void hideKeyboard() {
        if (this.dsq != null) {
            this.dsq.hideKeyboard(null);
        }
    }

    @JavascriptInterface
    public void getStorage(JsObject jsObject) {
        aNk().getStorage(jsObject);
    }

    @JavascriptInterface
    public Object getStorageSync(String str) {
        return com.baidu.swan.games.w.a.d.a(this.dqC, "getStorageSync", str, aNk().wm(str));
    }

    @JavascriptInterface
    public void setStorage(JsObject jsObject) {
        aNk().setStorage(jsObject);
    }

    @JavascriptInterface
    public void setStorageSync(String str, JsSerializeValue jsSerializeValue) {
        com.baidu.swan.games.w.a.d.a(this.dqC, "setStorageSync", str, aNk().a(str, jsSerializeValue));
    }

    @JavascriptInterface
    public void setStorageSync(String str) {
        com.baidu.swan.games.w.a.d.a(this.dqC, "setStorageSync", str, aNk().a(str, (JsSerializeValue) null));
    }

    @JavascriptInterface
    public void removeStorage(JsObject jsObject) {
        aNk().removeStorage(jsObject);
    }

    @JavascriptInterface
    public void removeStorageSync(String str) {
        com.baidu.swan.games.w.a.d.a(this.dqC, "removeStorageSync", str, aNk().wn(str));
    }

    @JavascriptInterface
    public void clearStorage(JsObject jsObject) {
        aNk().clearStorage(jsObject);
    }

    @JavascriptInterface
    public void clearStorageSync() {
        com.baidu.swan.games.w.a.d.a(this.dqC, "clearStorageSync", "", aNk().aQi());
    }

    @JavascriptInterface
    public void getStorageInfo(JsObject jsObject) {
        aNk().getStorageInfo(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.w.a.c getStorageInfoSync() {
        return aNk().getStorageInfoSync();
    }

    @NonNull
    private com.baidu.swan.games.w.a aNk() {
        if (this.dss == null) {
            this.dss = new com.baidu.swan.games.w.a(this.dqC);
        }
        return this.dss;
    }

    @JavascriptInterface
    public void setInnerAudioOption(JsObject jsObject) {
        this.dsz = new h(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.audio.g createInnerAudioContext() {
        return new com.baidu.swan.games.audio.g(this.dqC);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.b createBannerAd(JsObject jsObject) {
        return com.baidu.swan.apps.t.a.apX().b(this.dqC, jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.aa.d getUpdateManager(JsObject jsObject) {
        if (this.dsu == null) {
            this.dsu = new com.baidu.swan.games.aa.d(jsObject);
        }
        return this.dsu;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.websocket.c connectSocket(JsObject jsObject) {
        if (this.dsw == null) {
            this.dsw = new com.baidu.swan.games.network.websocket.a(this.dqC);
        }
        return this.dsw.connectSocket(jsObject);
    }

    @JavascriptInterface
    public void setEnableDebug(JsObject jsObject) {
        if (this.dsx == null) {
            this.dsx = new g(this.dqC);
        }
        this.dsx.setEnableDebug(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.c.c request(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        com.baidu.swan.games.network.a a = com.baidu.swan.games.network.b.d.aPp().a(this.dqC, e, 1);
        if (a instanceof com.baidu.swan.games.network.c.c) {
            com.baidu.swan.games.network.c.c cVar = (com.baidu.swan.games.network.c.c) a;
            cVar.j(e);
            return cVar;
        }
        com.baidu.swan.games.network.c.c cVar2 = new com.baidu.swan.games.network.c.c(this.dqC, e);
        cVar2.start();
        return cVar2;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.d.b uploadFile(JsObject jsObject) {
        com.baidu.swan.games.network.d.b bVar = new com.baidu.swan.games.network.d.b(this.dqC, com.baidu.swan.games.binding.model.c.e(jsObject));
        bVar.start();
        return bVar;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.a.b downloadFile(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        com.baidu.swan.games.network.a a = com.baidu.swan.games.network.b.d.aPp().a(this.dqC, e, 2);
        if (a instanceof com.baidu.swan.games.network.a.b) {
            com.baidu.swan.games.network.a.b bVar = (com.baidu.swan.games.network.a.b) a;
            bVar.j(e);
            return bVar;
        }
        com.baidu.swan.games.network.a.b bVar2 = new com.baidu.swan.games.network.a.b(this.dqC, e);
        bVar2.start();
        return bVar2;
    }

    @JavascriptInterface
    public void openCustomerServiceConversation(JsObject jsObject) {
        com.baidu.swan.games.d.a.a((c) this.dqC.aNM(), jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.screenrecord.a getVideoRecorderManager() {
        if (this.dsy == null) {
            this.dsy = new com.baidu.swan.games.screenrecord.a(this.dqC);
        }
        return this.dsy;
    }

    @JavascriptInterface
    public void shareVideo(JsObject jsObject) {
        new com.baidu.swan.games.u.b.a(jsObject).agO();
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return com.baidu.swan.apps.jsbridge.a.b.f(this.dqC);
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton(JsObject jsObject) {
        return new RecommendButtonApiProxy(this.dqC, jsObject);
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton() {
        return createRecommendationButton(null);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide(JsObject jsObject) {
        if (this.dsA == null) {
            this.dsA = new DesktopGuideApi(this.dqC);
        }
        this.dsA.q(jsObject);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide() {
        showAddToDesktopGuide(null);
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.webview.a getWebViewManager() {
        if (this.dsC == null) {
            this.dsC = new com.baidu.swan.games.view.webview.a(this.dqC);
        }
        return this.dsC;
    }

    @JavascriptInterface
    public void getUUAPInfo(JsObject jsObject) {
        com.baidu.swan.games.ab.a.getUUAPInfo(jsObject);
    }

    @JavascriptInterface
    public String getAPIs(int i) {
        if (DEBUG) {
            return com.baidu.swan.apps.ad.a.a.axO() ? SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i) : "";
        }
        return SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i);
    }

    @JavascriptInterface
    public void authorizeEval(JsObject jsObject) {
        com.baidu.swan.games.g.a.authorizeEval(jsObject);
    }

    @JavascriptInterface
    public void menuItemCtrl(JsObject jsObject) {
        com.baidu.swan.games.q.a asx = f.asJ().asx();
        if (asx != null) {
            asx.i(com.baidu.swan.games.binding.model.c.e(jsObject));
        }
    }

    @JavascriptInterface
    public com.baidu.swan.games.b.b getAntiAddiction() {
        if (this.dsD == null) {
            this.dsD = new com.baidu.swan.games.b.b(this.dqC);
        }
        return this.dsD;
    }
}
