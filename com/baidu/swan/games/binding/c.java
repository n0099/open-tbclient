package com.baidu.swan.games.binding;

import android.os.Build;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
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
/* loaded from: classes9.dex */
public final class c extends EventTargetImpl {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @V8JavascriptField
    public final String domain;
    private com.baidu.swan.games.f.b ecD;
    private com.baidu.swan.games.view.webview.a eeA;
    private com.baidu.swan.games.b.b eeB;
    private e eek;
    private d eel;
    private com.baidu.swan.games.r.b eem;
    private JsObject een;
    private com.baidu.swan.games.r.e eeo;
    private com.baidu.swan.games.n.a eep;
    private com.baidu.swan.games.n.b eeq;
    private com.baidu.swan.games.w.a eer;
    private com.baidu.swan.games.aa.d ees;
    private com.baidu.swan.games.a.c eet;
    private com.baidu.swan.games.network.websocket.a eeu;
    private g eev;
    private com.baidu.swan.games.screenrecord.a eew;
    private h eex;
    private DesktopGuideApi eey;
    private com.baidu.swan.games.s.a eez;
    @V8JavascriptField
    public com.baidu.swan.games.i.a env;

    public c(com.baidu.swan.games.f.b bVar) {
        super(bVar);
        this.domain = "main";
        this.een = null;
        this.eeo = null;
        this.eep = null;
        this.eeq = null;
        this.ees = null;
        this.eet = null;
        this.eeu = null;
        this.eev = null;
        this.eew = null;
        this.eex = null;
        this.eey = null;
        this.eez = null;
        this.eeA = null;
        this.eeB = null;
        this.ecD = bVar;
        this.env = new com.baidu.swan.games.i.a();
        aVw();
    }

    private void aVw() {
        this.eeq = new com.baidu.swan.games.n.b(this.ecD);
    }

    public void d(JsObject jsObject) {
        this.een = jsObject;
    }

    @JavascriptInterface
    public void setPreferredFramesPerSecond(short s) {
        if (s >= 1 && s <= 60) {
            this.ecD.setPreferredFramesPerSecond(s);
        }
    }

    @JavascriptInterface
    public com.baidu.swan.games.r.e getOpenDataContext() {
        if (this.eeo == null) {
            this.eeo = new com.baidu.swan.games.r.e(this.ecD);
            this.eeo.canvas = this.een;
            this.een = null;
        }
        return this.eeo;
    }

    @JavascriptInterface
    public e getFileSystemManager() {
        if (this.eek == null) {
            this.eek = new e((com.baidu.swan.games.f.a) this.ecD);
        }
        return this.eek;
    }

    @JavascriptInterface
    public com.baidu.swan.games.y.c loadSubpackage(JsObject jsObject) {
        com.baidu.swan.games.y.c cVar = new com.baidu.swan.games.y.c(this.ecD);
        cVar.n(jsObject);
        return cVar;
    }

    @JavascriptInterface
    public void exit(JsObject jsObject) {
        if (DEBUG) {
            this.ecD.aWb().log("exit from java side.");
        }
        if (jsObject != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            com.baidu.swan.games.binding.model.a f = com.baidu.swan.games.binding.model.a.f(com.baidu.swan.games.binding.model.c.e(jsObject));
            SwanAppActivity azV = f.aAl().azV();
            if (azV == null) {
                bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "failed");
                f.ad(bVar);
                return;
            }
            bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "ok");
            f.onSuccess(bVar);
            if (Build.VERSION.SDK_INT >= 21) {
                azV.finishAndRemoveTask();
            } else {
                azV.finish();
            }
        }
    }

    @JavascriptInterface
    public void reload(JsObject jsObject) {
        if (this.eez == null) {
            this.eez = new com.baidu.swan.games.s.a();
        }
        this.eez.reload(jsObject);
    }

    @JavascriptInterface
    public void reload() {
        reload(null);
    }

    @JavascriptInterface
    public d getOpenData() {
        if (this.eel == null) {
            this.eel = new d((com.baidu.swan.games.f.a) this.ecD);
        }
        return this.eel;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        if (this.eem == null) {
            this.eem = new com.baidu.swan.games.r.b(this.ecD);
        }
        this.eem.checkIsUserAdvisedToRest(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.c createRewardedVideoAd(JsObject jsObject) {
        if (this.eet == null) {
            this.eet = com.baidu.swan.apps.t.a.axz().a(this.ecD, jsObject);
            if (this.eet == null) {
                this.eet = new com.baidu.swan.games.a.a();
            }
        }
        return this.eet;
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.button.userinfo.b createUserInfoButton(JsObject jsObject) {
        return new com.baidu.swan.games.view.button.userinfo.b(jsObject, this.ecD);
    }

    @JavascriptInterface
    public void showKeyboard(JsObject jsObject) {
        if (this.eep == null) {
            this.eep = new com.baidu.swan.games.n.a(this.ecD, this.eeq);
        }
        this.eep.showKeyboard(jsObject);
    }

    @JavascriptInterface
    public void showKeyboard() {
        if (this.eep == null) {
            this.eep = new com.baidu.swan.games.n.a(this.ecD, this.eeq);
        }
        this.eep.showKeyboard(null);
    }

    @JavascriptInterface
    public void updateKeyboard(JsObject jsObject) {
        if (this.eep != null) {
            this.eep.updateKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void updateKeyboard() {
        if (this.eep != null) {
            this.eep.updateKeyboard(null);
        }
    }

    @JavascriptInterface
    public void hideKeyboard(JsObject jsObject) {
        if (this.eep != null) {
            this.eep.hideKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void hideKeyboard() {
        if (this.eep != null) {
            this.eep.hideKeyboard(null);
        }
    }

    @JavascriptInterface
    public void getStorage(JsObject jsObject) {
        aVx().getStorage(jsObject);
    }

    @JavascriptInterface
    public Object getStorageSync(String str) {
        return com.baidu.swan.games.w.a.d.a(this.ecD, "getStorageSync", str, aVx().xo(str));
    }

    @JavascriptInterface
    public void setStorage(JsObject jsObject) {
        aVx().setStorage(jsObject);
    }

    @JavascriptInterface
    public void setStorageSync(String str, JsSerializeValue jsSerializeValue) {
        com.baidu.swan.games.w.a.d.a(this.ecD, "setStorageSync", str, aVx().a(str, jsSerializeValue));
    }

    @JavascriptInterface
    public void setStorageSync(String str) {
        com.baidu.swan.games.w.a.d.a(this.ecD, "setStorageSync", str, aVx().a(str, (JsSerializeValue) null));
    }

    @JavascriptInterface
    public void removeStorage(JsObject jsObject) {
        aVx().removeStorage(jsObject);
    }

    @JavascriptInterface
    public void removeStorageSync(String str) {
        com.baidu.swan.games.w.a.d.a(this.ecD, "removeStorageSync", str, aVx().xp(str));
    }

    @JavascriptInterface
    public void clearStorage(JsObject jsObject) {
        aVx().clearStorage(jsObject);
    }

    @JavascriptInterface
    public void clearStorageSync() {
        com.baidu.swan.games.w.a.d.a(this.ecD, "clearStorageSync", "", aVx().aYv());
    }

    @JavascriptInterface
    public void getStorageInfo(JsObject jsObject) {
        aVx().getStorageInfo(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.w.a.c getStorageInfoSync() {
        return aVx().getStorageInfoSync();
    }

    @NonNull
    private com.baidu.swan.games.w.a aVx() {
        if (this.eer == null) {
            this.eer = new com.baidu.swan.games.w.a(this.ecD);
        }
        return this.eer;
    }

    @JavascriptInterface
    public void setInnerAudioOption(JsObject jsObject) {
        this.eex = new h(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.audio.g createInnerAudioContext() {
        return new com.baidu.swan.games.audio.g(this.ecD);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.b createBannerAd(JsObject jsObject) {
        return com.baidu.swan.apps.t.a.axz().b(this.ecD, jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.aa.d getUpdateManager(JsObject jsObject) {
        if (this.ees == null) {
            this.ees = new com.baidu.swan.games.aa.d(jsObject);
        }
        return this.ees;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.websocket.c connectSocket(JsObject jsObject) {
        if (this.eeu == null) {
            this.eeu = new com.baidu.swan.games.network.websocket.a(this.ecD);
        }
        return this.eeu.connectSocket(jsObject);
    }

    @JavascriptInterface
    public void setEnableDebug(JsObject jsObject) {
        if (this.eev == null) {
            this.eev = new g(this.ecD);
        }
        this.eev.setEnableDebug(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.c.c request(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        com.baidu.swan.games.network.a a2 = com.baidu.swan.games.network.b.d.aXC().a(this.ecD, e, 1);
        if (a2 instanceof com.baidu.swan.games.network.c.c) {
            com.baidu.swan.games.network.c.c cVar = (com.baidu.swan.games.network.c.c) a2;
            cVar.j(e);
            return cVar;
        }
        com.baidu.swan.games.network.c.c cVar2 = new com.baidu.swan.games.network.c.c(this.ecD, e);
        cVar2.start();
        return cVar2;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.d.b uploadFile(JsObject jsObject) {
        com.baidu.swan.games.network.d.b bVar = new com.baidu.swan.games.network.d.b(this.ecD, com.baidu.swan.games.binding.model.c.e(jsObject));
        bVar.start();
        return bVar;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.a.b downloadFile(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        com.baidu.swan.games.network.a a2 = com.baidu.swan.games.network.b.d.aXC().a(this.ecD, e, 2);
        if (a2 instanceof com.baidu.swan.games.network.a.b) {
            com.baidu.swan.games.network.a.b bVar = (com.baidu.swan.games.network.a.b) a2;
            bVar.j(e);
            return bVar;
        }
        com.baidu.swan.games.network.a.b bVar2 = new com.baidu.swan.games.network.a.b(this.ecD, e);
        bVar2.start();
        return bVar2;
    }

    @JavascriptInterface
    public void openCustomerServiceConversation(JsObject jsObject) {
        com.baidu.swan.games.d.a.a((c) this.ecD.aVZ(), jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.screenrecord.a getVideoRecorderManager() {
        if (this.eew == null) {
            this.eew = new com.baidu.swan.games.screenrecord.a(this.ecD);
        }
        return this.eew;
    }

    @JavascriptInterface
    public void shareVideo(JsObject jsObject) {
        new com.baidu.swan.games.u.b.a(jsObject).aoj();
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return com.baidu.swan.apps.jsbridge.a.b.f(this.ecD);
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton(JsObject jsObject) {
        return new RecommendButtonApiProxy(this.ecD, jsObject);
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton() {
        return createRecommendationButton(null);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide(JsObject jsObject) {
        if (this.eey == null) {
            this.eey = new DesktopGuideApi(this.ecD);
        }
        this.eey.q(jsObject);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide() {
        showAddToDesktopGuide(null);
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.webview.a getWebViewManager() {
        if (this.eeA == null) {
            this.eeA = new com.baidu.swan.games.view.webview.a(this.ecD);
        }
        return this.eeA;
    }

    @JavascriptInterface
    public void getUUAPInfo(JsObject jsObject) {
        com.baidu.swan.games.ab.a.getUUAPInfo(jsObject);
    }

    @JavascriptInterface
    public String getAPIs(int i) {
        if (DEBUG) {
            return com.baidu.swan.apps.ad.a.a.aFo() ? SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i) : "";
        }
        return SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i);
    }

    @JavascriptInterface
    public void authorizeEval(JsObject jsObject) {
        com.baidu.swan.games.g.a.authorizeEval(jsObject);
    }

    @JavascriptInterface
    public void menuItemCtrl(JsObject jsObject) {
        com.baidu.swan.games.q.a azZ = f.aAl().azZ();
        if (azZ != null) {
            azZ.i(com.baidu.swan.games.binding.model.c.e(jsObject));
        }
    }

    @JavascriptInterface
    public com.baidu.swan.games.b.b getAntiAddiction() {
        if (this.eeB == null) {
            this.eeB = new com.baidu.swan.games.b.b(this.ecD);
        }
        return this.eeB;
    }
}
