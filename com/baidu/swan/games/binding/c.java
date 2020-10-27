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
    private com.baidu.swan.games.f.b dLd;
    private e dML;
    private d dMM;
    private com.baidu.swan.games.r.b dMN;
    private JsObject dMO;
    private com.baidu.swan.games.r.e dMP;
    private com.baidu.swan.games.n.a dMQ;
    private com.baidu.swan.games.n.b dMR;
    private com.baidu.swan.games.w.a dMS;
    private com.baidu.swan.games.aa.d dMT;
    private com.baidu.swan.games.a.c dMU;
    private com.baidu.swan.games.network.websocket.a dMV;
    private g dMW;
    private com.baidu.swan.games.screenrecord.a dMX;
    private h dMY;
    private DesktopGuideApi dMZ;
    private com.baidu.swan.games.s.a dNa;
    private com.baidu.swan.games.view.webview.a dNb;
    private com.baidu.swan.games.b.b dNc;
    @V8JavascriptField
    public final String domain;
    @V8JavascriptField
    public com.baidu.swan.games.i.a env;

    public c(com.baidu.swan.games.f.b bVar) {
        super(bVar);
        this.domain = "main";
        this.dMO = null;
        this.dMP = null;
        this.dMQ = null;
        this.dMR = null;
        this.dMT = null;
        this.dMU = null;
        this.dMV = null;
        this.dMW = null;
        this.dMX = null;
        this.dMY = null;
        this.dMZ = null;
        this.dNa = null;
        this.dNb = null;
        this.dNc = null;
        this.dLd = bVar;
        this.env = new com.baidu.swan.games.i.a();
        aRM();
    }

    private void aRM() {
        this.dMR = new com.baidu.swan.games.n.b(this.dLd);
    }

    public void d(JsObject jsObject) {
        this.dMO = jsObject;
    }

    @JavascriptInterface
    public void setPreferredFramesPerSecond(short s) {
        if (s >= 1 && s <= 60) {
            this.dLd.setPreferredFramesPerSecond(s);
        }
    }

    @JavascriptInterface
    public com.baidu.swan.games.r.e getOpenDataContext() {
        if (this.dMP == null) {
            this.dMP = new com.baidu.swan.games.r.e(this.dLd);
            this.dMP.canvas = this.dMO;
            this.dMO = null;
        }
        return this.dMP;
    }

    @JavascriptInterface
    public e getFileSystemManager() {
        if (this.dML == null) {
            this.dML = new e((com.baidu.swan.games.f.a) this.dLd);
        }
        return this.dML;
    }

    @JavascriptInterface
    public com.baidu.swan.games.y.c loadSubpackage(JsObject jsObject) {
        com.baidu.swan.games.y.c cVar = new com.baidu.swan.games.y.c(this.dLd);
        cVar.n(jsObject);
        return cVar;
    }

    @JavascriptInterface
    public void exit(JsObject jsObject) {
        if (DEBUG) {
            this.dLd.aSr().log("exit from java side.");
        }
        if (jsObject != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            com.baidu.swan.games.binding.model.a f = com.baidu.swan.games.binding.model.a.f(com.baidu.swan.games.binding.model.c.e(jsObject));
            SwanAppActivity awY = f.axo().awY();
            if (awY == null) {
                bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "failed");
                f.ac(bVar);
                return;
            }
            bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "ok");
            f.onSuccess(bVar);
            if (Build.VERSION.SDK_INT >= 21) {
                awY.finishAndRemoveTask();
            } else {
                awY.finish();
            }
        }
    }

    @JavascriptInterface
    public void reload(JsObject jsObject) {
        if (this.dNa == null) {
            this.dNa = new com.baidu.swan.games.s.a();
        }
        this.dNa.reload(jsObject);
    }

    @JavascriptInterface
    public void reload() {
        reload(null);
    }

    @JavascriptInterface
    public d getOpenData() {
        if (this.dMM == null) {
            this.dMM = new d((com.baidu.swan.games.f.a) this.dLd);
        }
        return this.dMM;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        if (this.dMN == null) {
            this.dMN = new com.baidu.swan.games.r.b(this.dLd);
        }
        this.dMN.checkIsUserAdvisedToRest(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.c createRewardedVideoAd(JsObject jsObject) {
        if (this.dMU == null) {
            this.dMU = com.baidu.swan.apps.t.a.auD().a(this.dLd, jsObject);
            if (this.dMU == null) {
                this.dMU = new com.baidu.swan.games.a.a();
            }
        }
        return this.dMU;
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.button.userinfo.b createUserInfoButton(JsObject jsObject) {
        return new com.baidu.swan.games.view.button.userinfo.b(jsObject, this.dLd);
    }

    @JavascriptInterface
    public void showKeyboard(JsObject jsObject) {
        if (this.dMQ == null) {
            this.dMQ = new com.baidu.swan.games.n.a(this.dLd, this.dMR);
        }
        this.dMQ.showKeyboard(jsObject);
    }

    @JavascriptInterface
    public void showKeyboard() {
        if (this.dMQ == null) {
            this.dMQ = new com.baidu.swan.games.n.a(this.dLd, this.dMR);
        }
        this.dMQ.showKeyboard(null);
    }

    @JavascriptInterface
    public void updateKeyboard(JsObject jsObject) {
        if (this.dMQ != null) {
            this.dMQ.updateKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void updateKeyboard() {
        if (this.dMQ != null) {
            this.dMQ.updateKeyboard(null);
        }
    }

    @JavascriptInterface
    public void hideKeyboard(JsObject jsObject) {
        if (this.dMQ != null) {
            this.dMQ.hideKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void hideKeyboard() {
        if (this.dMQ != null) {
            this.dMQ.hideKeyboard(null);
        }
    }

    @JavascriptInterface
    public void getStorage(JsObject jsObject) {
        aRN().getStorage(jsObject);
    }

    @JavascriptInterface
    public Object getStorageSync(String str) {
        return com.baidu.swan.games.w.a.d.a(this.dLd, "getStorageSync", str, aRN().xr(str));
    }

    @JavascriptInterface
    public void setStorage(JsObject jsObject) {
        aRN().setStorage(jsObject);
    }

    @JavascriptInterface
    public void setStorageSync(String str, JsSerializeValue jsSerializeValue) {
        com.baidu.swan.games.w.a.d.a(this.dLd, "setStorageSync", str, aRN().a(str, jsSerializeValue));
    }

    @JavascriptInterface
    public void setStorageSync(String str) {
        com.baidu.swan.games.w.a.d.a(this.dLd, "setStorageSync", str, aRN().a(str, (JsSerializeValue) null));
    }

    @JavascriptInterface
    public void removeStorage(JsObject jsObject) {
        aRN().removeStorage(jsObject);
    }

    @JavascriptInterface
    public void removeStorageSync(String str) {
        com.baidu.swan.games.w.a.d.a(this.dLd, "removeStorageSync", str, aRN().xs(str));
    }

    @JavascriptInterface
    public void clearStorage(JsObject jsObject) {
        aRN().clearStorage(jsObject);
    }

    @JavascriptInterface
    public void clearStorageSync() {
        com.baidu.swan.games.w.a.d.a(this.dLd, "clearStorageSync", "", aRN().aUL());
    }

    @JavascriptInterface
    public void getStorageInfo(JsObject jsObject) {
        aRN().getStorageInfo(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.w.a.c getStorageInfoSync() {
        return aRN().getStorageInfoSync();
    }

    @NonNull
    private com.baidu.swan.games.w.a aRN() {
        if (this.dMS == null) {
            this.dMS = new com.baidu.swan.games.w.a(this.dLd);
        }
        return this.dMS;
    }

    @JavascriptInterface
    public void setInnerAudioOption(JsObject jsObject) {
        this.dMY = new h(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.audio.g createInnerAudioContext() {
        return new com.baidu.swan.games.audio.g(this.dLd);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.b createBannerAd(JsObject jsObject) {
        return com.baidu.swan.apps.t.a.auD().b(this.dLd, jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.aa.d getUpdateManager(JsObject jsObject) {
        if (this.dMT == null) {
            this.dMT = new com.baidu.swan.games.aa.d(jsObject);
        }
        return this.dMT;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.websocket.c connectSocket(JsObject jsObject) {
        if (this.dMV == null) {
            this.dMV = new com.baidu.swan.games.network.websocket.a(this.dLd);
        }
        return this.dMV.connectSocket(jsObject);
    }

    @JavascriptInterface
    public void setEnableDebug(JsObject jsObject) {
        if (this.dMW == null) {
            this.dMW = new g(this.dLd);
        }
        this.dMW.setEnableDebug(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.c.c request(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        com.baidu.swan.games.network.a a2 = com.baidu.swan.games.network.b.d.aTS().a(this.dLd, e, 1);
        if (a2 instanceof com.baidu.swan.games.network.c.c) {
            com.baidu.swan.games.network.c.c cVar = (com.baidu.swan.games.network.c.c) a2;
            cVar.j(e);
            return cVar;
        }
        com.baidu.swan.games.network.c.c cVar2 = new com.baidu.swan.games.network.c.c(this.dLd, e);
        cVar2.start();
        return cVar2;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.d.b uploadFile(JsObject jsObject) {
        com.baidu.swan.games.network.d.b bVar = new com.baidu.swan.games.network.d.b(this.dLd, com.baidu.swan.games.binding.model.c.e(jsObject));
        bVar.start();
        return bVar;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.a.b downloadFile(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        com.baidu.swan.games.network.a a2 = com.baidu.swan.games.network.b.d.aTS().a(this.dLd, e, 2);
        if (a2 instanceof com.baidu.swan.games.network.a.b) {
            com.baidu.swan.games.network.a.b bVar = (com.baidu.swan.games.network.a.b) a2;
            bVar.j(e);
            return bVar;
        }
        com.baidu.swan.games.network.a.b bVar2 = new com.baidu.swan.games.network.a.b(this.dLd, e);
        bVar2.start();
        return bVar2;
    }

    @JavascriptInterface
    public void openCustomerServiceConversation(JsObject jsObject) {
        com.baidu.swan.games.d.a.a((c) this.dLd.aSp(), jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.screenrecord.a getVideoRecorderManager() {
        if (this.dMX == null) {
            this.dMX = new com.baidu.swan.games.screenrecord.a(this.dLd);
        }
        return this.dMX;
    }

    @JavascriptInterface
    public void shareVideo(JsObject jsObject) {
        new com.baidu.swan.games.u.b.a(jsObject).alt();
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return com.baidu.swan.apps.jsbridge.a.b.f(this.dLd);
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton(JsObject jsObject) {
        return new RecommendButtonApiProxy(this.dLd, jsObject);
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton() {
        return createRecommendationButton(null);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide(JsObject jsObject) {
        if (this.dMZ == null) {
            this.dMZ = new DesktopGuideApi(this.dLd);
        }
        this.dMZ.q(jsObject);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide() {
        showAddToDesktopGuide(null);
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.webview.a getWebViewManager() {
        if (this.dNb == null) {
            this.dNb = new com.baidu.swan.games.view.webview.a(this.dLd);
        }
        return this.dNb;
    }

    @JavascriptInterface
    public void getUUAPInfo(JsObject jsObject) {
        com.baidu.swan.games.ab.a.getUUAPInfo(jsObject);
    }

    @JavascriptInterface
    public String getAPIs(int i) {
        if (DEBUG) {
            return com.baidu.swan.apps.ad.a.a.aCt() ? SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i) : "";
        }
        return SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i);
    }

    @JavascriptInterface
    public void authorizeEval(JsObject jsObject) {
        com.baidu.swan.games.g.a.authorizeEval(jsObject);
    }

    @JavascriptInterface
    public void menuItemCtrl(JsObject jsObject) {
        com.baidu.swan.games.q.a axc = f.axo().axc();
        if (axc != null) {
            axc.i(com.baidu.swan.games.binding.model.c.e(jsObject));
        }
    }

    @JavascriptInterface
    public com.baidu.swan.games.b.b getAntiAddiction() {
        if (this.dNc == null) {
            this.dNc = new com.baidu.swan.games.b.b(this.dLd);
        }
        return this.dNc;
    }
}
