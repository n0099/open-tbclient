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
/* loaded from: classes7.dex */
public final class c extends EventTargetImpl {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.f.b dPn;
    private e dQV;
    private d dQW;
    private com.baidu.swan.games.r.b dQX;
    private JsObject dQY;
    private com.baidu.swan.games.r.e dQZ;
    private com.baidu.swan.games.n.a dRa;
    private com.baidu.swan.games.n.b dRb;
    private com.baidu.swan.games.w.a dRc;
    private com.baidu.swan.games.aa.d dRd;
    private com.baidu.swan.games.a.c dRe;
    private com.baidu.swan.games.network.websocket.a dRf;
    private g dRg;
    private com.baidu.swan.games.screenrecord.a dRh;
    private h dRi;
    private DesktopGuideApi dRj;
    private com.baidu.swan.games.s.a dRk;
    private com.baidu.swan.games.view.webview.a dRl;
    private com.baidu.swan.games.b.b dRm;
    @V8JavascriptField
    public final String domain;
    @V8JavascriptField
    public com.baidu.swan.games.i.a env;

    public c(com.baidu.swan.games.f.b bVar) {
        super(bVar);
        this.domain = "main";
        this.dQY = null;
        this.dQZ = null;
        this.dRa = null;
        this.dRb = null;
        this.dRd = null;
        this.dRe = null;
        this.dRf = null;
        this.dRg = null;
        this.dRh = null;
        this.dRi = null;
        this.dRj = null;
        this.dRk = null;
        this.dRl = null;
        this.dRm = null;
        this.dPn = bVar;
        this.env = new com.baidu.swan.games.i.a();
        aTE();
    }

    private void aTE() {
        this.dRb = new com.baidu.swan.games.n.b(this.dPn);
    }

    public void d(JsObject jsObject) {
        this.dQY = jsObject;
    }

    @JavascriptInterface
    public void setPreferredFramesPerSecond(short s) {
        if (s >= 1 && s <= 60) {
            this.dPn.setPreferredFramesPerSecond(s);
        }
    }

    @JavascriptInterface
    public com.baidu.swan.games.r.e getOpenDataContext() {
        if (this.dQZ == null) {
            this.dQZ = new com.baidu.swan.games.r.e(this.dPn);
            this.dQZ.canvas = this.dQY;
            this.dQY = null;
        }
        return this.dQZ;
    }

    @JavascriptInterface
    public e getFileSystemManager() {
        if (this.dQV == null) {
            this.dQV = new e((com.baidu.swan.games.f.a) this.dPn);
        }
        return this.dQV;
    }

    @JavascriptInterface
    public com.baidu.swan.games.y.c loadSubpackage(JsObject jsObject) {
        com.baidu.swan.games.y.c cVar = new com.baidu.swan.games.y.c(this.dPn);
        cVar.n(jsObject);
        return cVar;
    }

    @JavascriptInterface
    public void exit(JsObject jsObject) {
        if (DEBUG) {
            this.dPn.aUj().log("exit from java side.");
        }
        if (jsObject != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            com.baidu.swan.games.binding.model.a f = com.baidu.swan.games.binding.model.a.f(com.baidu.swan.games.binding.model.c.e(jsObject));
            SwanAppActivity ayQ = f.azg().ayQ();
            if (ayQ == null) {
                bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "failed");
                f.ac(bVar);
                return;
            }
            bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "ok");
            f.onSuccess(bVar);
            if (Build.VERSION.SDK_INT >= 21) {
                ayQ.finishAndRemoveTask();
            } else {
                ayQ.finish();
            }
        }
    }

    @JavascriptInterface
    public void reload(JsObject jsObject) {
        if (this.dRk == null) {
            this.dRk = new com.baidu.swan.games.s.a();
        }
        this.dRk.reload(jsObject);
    }

    @JavascriptInterface
    public void reload() {
        reload(null);
    }

    @JavascriptInterface
    public d getOpenData() {
        if (this.dQW == null) {
            this.dQW = new d((com.baidu.swan.games.f.a) this.dPn);
        }
        return this.dQW;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        if (this.dQX == null) {
            this.dQX = new com.baidu.swan.games.r.b(this.dPn);
        }
        this.dQX.checkIsUserAdvisedToRest(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.c createRewardedVideoAd(JsObject jsObject) {
        if (this.dRe == null) {
            this.dRe = com.baidu.swan.apps.t.a.awv().a(this.dPn, jsObject);
            if (this.dRe == null) {
                this.dRe = new com.baidu.swan.games.a.a();
            }
        }
        return this.dRe;
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.button.userinfo.b createUserInfoButton(JsObject jsObject) {
        return new com.baidu.swan.games.view.button.userinfo.b(jsObject, this.dPn);
    }

    @JavascriptInterface
    public void showKeyboard(JsObject jsObject) {
        if (this.dRa == null) {
            this.dRa = new com.baidu.swan.games.n.a(this.dPn, this.dRb);
        }
        this.dRa.showKeyboard(jsObject);
    }

    @JavascriptInterface
    public void showKeyboard() {
        if (this.dRa == null) {
            this.dRa = new com.baidu.swan.games.n.a(this.dPn, this.dRb);
        }
        this.dRa.showKeyboard(null);
    }

    @JavascriptInterface
    public void updateKeyboard(JsObject jsObject) {
        if (this.dRa != null) {
            this.dRa.updateKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void updateKeyboard() {
        if (this.dRa != null) {
            this.dRa.updateKeyboard(null);
        }
    }

    @JavascriptInterface
    public void hideKeyboard(JsObject jsObject) {
        if (this.dRa != null) {
            this.dRa.hideKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void hideKeyboard() {
        if (this.dRa != null) {
            this.dRa.hideKeyboard(null);
        }
    }

    @JavascriptInterface
    public void getStorage(JsObject jsObject) {
        aTF().getStorage(jsObject);
    }

    @JavascriptInterface
    public Object getStorageSync(String str) {
        return com.baidu.swan.games.w.a.d.a(this.dPn, "getStorageSync", str, aTF().xA(str));
    }

    @JavascriptInterface
    public void setStorage(JsObject jsObject) {
        aTF().setStorage(jsObject);
    }

    @JavascriptInterface
    public void setStorageSync(String str, JsSerializeValue jsSerializeValue) {
        com.baidu.swan.games.w.a.d.a(this.dPn, "setStorageSync", str, aTF().a(str, jsSerializeValue));
    }

    @JavascriptInterface
    public void setStorageSync(String str) {
        com.baidu.swan.games.w.a.d.a(this.dPn, "setStorageSync", str, aTF().a(str, (JsSerializeValue) null));
    }

    @JavascriptInterface
    public void removeStorage(JsObject jsObject) {
        aTF().removeStorage(jsObject);
    }

    @JavascriptInterface
    public void removeStorageSync(String str) {
        com.baidu.swan.games.w.a.d.a(this.dPn, "removeStorageSync", str, aTF().xB(str));
    }

    @JavascriptInterface
    public void clearStorage(JsObject jsObject) {
        aTF().clearStorage(jsObject);
    }

    @JavascriptInterface
    public void clearStorageSync() {
        com.baidu.swan.games.w.a.d.a(this.dPn, "clearStorageSync", "", aTF().aWD());
    }

    @JavascriptInterface
    public void getStorageInfo(JsObject jsObject) {
        aTF().getStorageInfo(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.w.a.c getStorageInfoSync() {
        return aTF().getStorageInfoSync();
    }

    @NonNull
    private com.baidu.swan.games.w.a aTF() {
        if (this.dRc == null) {
            this.dRc = new com.baidu.swan.games.w.a(this.dPn);
        }
        return this.dRc;
    }

    @JavascriptInterface
    public void setInnerAudioOption(JsObject jsObject) {
        this.dRi = new h(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.audio.g createInnerAudioContext() {
        return new com.baidu.swan.games.audio.g(this.dPn);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.b createBannerAd(JsObject jsObject) {
        return com.baidu.swan.apps.t.a.awv().b(this.dPn, jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.aa.d getUpdateManager(JsObject jsObject) {
        if (this.dRd == null) {
            this.dRd = new com.baidu.swan.games.aa.d(jsObject);
        }
        return this.dRd;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.websocket.c connectSocket(JsObject jsObject) {
        if (this.dRf == null) {
            this.dRf = new com.baidu.swan.games.network.websocket.a(this.dPn);
        }
        return this.dRf.connectSocket(jsObject);
    }

    @JavascriptInterface
    public void setEnableDebug(JsObject jsObject) {
        if (this.dRg == null) {
            this.dRg = new g(this.dPn);
        }
        this.dRg.setEnableDebug(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.c.c request(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        com.baidu.swan.games.network.a a2 = com.baidu.swan.games.network.b.d.aVK().a(this.dPn, e, 1);
        if (a2 instanceof com.baidu.swan.games.network.c.c) {
            com.baidu.swan.games.network.c.c cVar = (com.baidu.swan.games.network.c.c) a2;
            cVar.j(e);
            return cVar;
        }
        com.baidu.swan.games.network.c.c cVar2 = new com.baidu.swan.games.network.c.c(this.dPn, e);
        cVar2.start();
        return cVar2;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.d.b uploadFile(JsObject jsObject) {
        com.baidu.swan.games.network.d.b bVar = new com.baidu.swan.games.network.d.b(this.dPn, com.baidu.swan.games.binding.model.c.e(jsObject));
        bVar.start();
        return bVar;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.a.b downloadFile(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        com.baidu.swan.games.network.a a2 = com.baidu.swan.games.network.b.d.aVK().a(this.dPn, e, 2);
        if (a2 instanceof com.baidu.swan.games.network.a.b) {
            com.baidu.swan.games.network.a.b bVar = (com.baidu.swan.games.network.a.b) a2;
            bVar.j(e);
            return bVar;
        }
        com.baidu.swan.games.network.a.b bVar2 = new com.baidu.swan.games.network.a.b(this.dPn, e);
        bVar2.start();
        return bVar2;
    }

    @JavascriptInterface
    public void openCustomerServiceConversation(JsObject jsObject) {
        com.baidu.swan.games.d.a.a((c) this.dPn.aUh(), jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.screenrecord.a getVideoRecorderManager() {
        if (this.dRh == null) {
            this.dRh = new com.baidu.swan.games.screenrecord.a(this.dPn);
        }
        return this.dRh;
    }

    @JavascriptInterface
    public void shareVideo(JsObject jsObject) {
        new com.baidu.swan.games.u.b.a(jsObject).anl();
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return com.baidu.swan.apps.jsbridge.a.b.f(this.dPn);
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton(JsObject jsObject) {
        return new RecommendButtonApiProxy(this.dPn, jsObject);
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton() {
        return createRecommendationButton(null);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide(JsObject jsObject) {
        if (this.dRj == null) {
            this.dRj = new DesktopGuideApi(this.dPn);
        }
        this.dRj.q(jsObject);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide() {
        showAddToDesktopGuide(null);
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.webview.a getWebViewManager() {
        if (this.dRl == null) {
            this.dRl = new com.baidu.swan.games.view.webview.a(this.dPn);
        }
        return this.dRl;
    }

    @JavascriptInterface
    public void getUUAPInfo(JsObject jsObject) {
        com.baidu.swan.games.ab.a.getUUAPInfo(jsObject);
    }

    @JavascriptInterface
    public String getAPIs(int i) {
        if (DEBUG) {
            return com.baidu.swan.apps.ad.a.a.aEl() ? SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i) : "";
        }
        return SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i);
    }

    @JavascriptInterface
    public void authorizeEval(JsObject jsObject) {
        com.baidu.swan.games.g.a.authorizeEval(jsObject);
    }

    @JavascriptInterface
    public void menuItemCtrl(JsObject jsObject) {
        com.baidu.swan.games.q.a ayU = f.azg().ayU();
        if (ayU != null) {
            ayU.i(com.baidu.swan.games.binding.model.c.e(jsObject));
        }
    }

    @JavascriptInterface
    public com.baidu.swan.games.b.b getAntiAddiction() {
        if (this.dRm == null) {
            this.dRm = new com.baidu.swan.games.b.b(this.dPn);
        }
        return this.dRm;
    }
}
