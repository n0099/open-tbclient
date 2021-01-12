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
/* loaded from: classes8.dex */
public final class c extends EventTargetImpl {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @V8JavascriptField
    public final String domain;
    private com.baidu.swan.games.f.b eaw;
    private e ecd;
    private d ece;
    private com.baidu.swan.games.r.b ecf;
    private JsObject ecg;
    private com.baidu.swan.games.r.e ech;
    private com.baidu.swan.games.n.a eci;
    private com.baidu.swan.games.n.b ecj;
    private com.baidu.swan.games.w.a eck;
    private com.baidu.swan.games.aa.d ecl;
    private com.baidu.swan.games.a.c ecm;
    private com.baidu.swan.games.network.websocket.a ecn;
    private g eco;
    private com.baidu.swan.games.screenrecord.a ecp;
    private h ecq;
    private DesktopGuideApi ecr;
    private com.baidu.swan.games.s.a ecs;
    private com.baidu.swan.games.view.webview.a ect;
    private com.baidu.swan.games.b.b ecu;
    @V8JavascriptField
    public com.baidu.swan.games.i.a env;

    public c(com.baidu.swan.games.f.b bVar) {
        super(bVar);
        this.domain = "main";
        this.ecg = null;
        this.ech = null;
        this.eci = null;
        this.ecj = null;
        this.ecl = null;
        this.ecm = null;
        this.ecn = null;
        this.eco = null;
        this.ecp = null;
        this.ecq = null;
        this.ecr = null;
        this.ecs = null;
        this.ect = null;
        this.ecu = null;
        this.eaw = bVar;
        this.env = new com.baidu.swan.games.i.a();
        aVk();
    }

    private void aVk() {
        this.ecj = new com.baidu.swan.games.n.b(this.eaw);
    }

    public void d(JsObject jsObject) {
        this.ecg = jsObject;
    }

    @JavascriptInterface
    public void setPreferredFramesPerSecond(short s) {
        if (s >= 1 && s <= 60) {
            this.eaw.setPreferredFramesPerSecond(s);
        }
    }

    @JavascriptInterface
    public com.baidu.swan.games.r.e getOpenDataContext() {
        if (this.ech == null) {
            this.ech = new com.baidu.swan.games.r.e(this.eaw);
            this.ech.canvas = this.ecg;
            this.ecg = null;
        }
        return this.ech;
    }

    @JavascriptInterface
    public e getFileSystemManager() {
        if (this.ecd == null) {
            this.ecd = new e((com.baidu.swan.games.f.a) this.eaw);
        }
        return this.ecd;
    }

    @JavascriptInterface
    public com.baidu.swan.games.y.c loadSubpackage(JsObject jsObject) {
        com.baidu.swan.games.y.c cVar = new com.baidu.swan.games.y.c(this.eaw);
        cVar.n(jsObject);
        return cVar;
    }

    @JavascriptInterface
    public void exit(JsObject jsObject) {
        if (DEBUG) {
            this.eaw.aVP().log("exit from java side.");
        }
        if (jsObject != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            com.baidu.swan.games.binding.model.a f = com.baidu.swan.games.binding.model.a.f(com.baidu.swan.games.binding.model.c.e(jsObject));
            SwanAppActivity azx = f.azN().azx();
            if (azx == null) {
                bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "failed");
                f.ad(bVar);
                return;
            }
            bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "ok");
            f.onSuccess(bVar);
            if (Build.VERSION.SDK_INT >= 21) {
                azx.finishAndRemoveTask();
            } else {
                azx.finish();
            }
        }
    }

    @JavascriptInterface
    public void reload(JsObject jsObject) {
        if (this.ecs == null) {
            this.ecs = new com.baidu.swan.games.s.a();
        }
        this.ecs.reload(jsObject);
    }

    @JavascriptInterface
    public void reload() {
        reload(null);
    }

    @JavascriptInterface
    public d getOpenData() {
        if (this.ece == null) {
            this.ece = new d((com.baidu.swan.games.f.a) this.eaw);
        }
        return this.ece;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        if (this.ecf == null) {
            this.ecf = new com.baidu.swan.games.r.b(this.eaw);
        }
        this.ecf.checkIsUserAdvisedToRest(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.c createRewardedVideoAd(JsObject jsObject) {
        if (this.ecm == null) {
            this.ecm = com.baidu.swan.apps.t.a.axb().a(this.eaw, jsObject);
            if (this.ecm == null) {
                this.ecm = new com.baidu.swan.games.a.a();
            }
        }
        return this.ecm;
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.button.userinfo.b createUserInfoButton(JsObject jsObject) {
        return new com.baidu.swan.games.view.button.userinfo.b(jsObject, this.eaw);
    }

    @JavascriptInterface
    public void showKeyboard(JsObject jsObject) {
        if (this.eci == null) {
            this.eci = new com.baidu.swan.games.n.a(this.eaw, this.ecj);
        }
        this.eci.showKeyboard(jsObject);
    }

    @JavascriptInterface
    public void showKeyboard() {
        if (this.eci == null) {
            this.eci = new com.baidu.swan.games.n.a(this.eaw, this.ecj);
        }
        this.eci.showKeyboard(null);
    }

    @JavascriptInterface
    public void updateKeyboard(JsObject jsObject) {
        if (this.eci != null) {
            this.eci.updateKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void updateKeyboard() {
        if (this.eci != null) {
            this.eci.updateKeyboard(null);
        }
    }

    @JavascriptInterface
    public void hideKeyboard(JsObject jsObject) {
        if (this.eci != null) {
            this.eci.hideKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void hideKeyboard() {
        if (this.eci != null) {
            this.eci.hideKeyboard(null);
        }
    }

    @JavascriptInterface
    public void getStorage(JsObject jsObject) {
        aVl().getStorage(jsObject);
    }

    @JavascriptInterface
    public Object getStorageSync(String str) {
        return com.baidu.swan.games.w.a.d.a(this.eaw, "getStorageSync", str, aVl().wV(str));
    }

    @JavascriptInterface
    public void setStorage(JsObject jsObject) {
        aVl().setStorage(jsObject);
    }

    @JavascriptInterface
    public void setStorageSync(String str, JsSerializeValue jsSerializeValue) {
        com.baidu.swan.games.w.a.d.a(this.eaw, "setStorageSync", str, aVl().a(str, jsSerializeValue));
    }

    @JavascriptInterface
    public void setStorageSync(String str) {
        com.baidu.swan.games.w.a.d.a(this.eaw, "setStorageSync", str, aVl().a(str, (JsSerializeValue) null));
    }

    @JavascriptInterface
    public void removeStorage(JsObject jsObject) {
        aVl().removeStorage(jsObject);
    }

    @JavascriptInterface
    public void removeStorageSync(String str) {
        com.baidu.swan.games.w.a.d.a(this.eaw, "removeStorageSync", str, aVl().wW(str));
    }

    @JavascriptInterface
    public void clearStorage(JsObject jsObject) {
        aVl().clearStorage(jsObject);
    }

    @JavascriptInterface
    public void clearStorageSync() {
        com.baidu.swan.games.w.a.d.a(this.eaw, "clearStorageSync", "", aVl().aYj());
    }

    @JavascriptInterface
    public void getStorageInfo(JsObject jsObject) {
        aVl().getStorageInfo(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.w.a.c getStorageInfoSync() {
        return aVl().getStorageInfoSync();
    }

    @NonNull
    private com.baidu.swan.games.w.a aVl() {
        if (this.eck == null) {
            this.eck = new com.baidu.swan.games.w.a(this.eaw);
        }
        return this.eck;
    }

    @JavascriptInterface
    public void setInnerAudioOption(JsObject jsObject) {
        this.ecq = new h(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.audio.g createInnerAudioContext() {
        return new com.baidu.swan.games.audio.g(this.eaw);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.b createBannerAd(JsObject jsObject) {
        return com.baidu.swan.apps.t.a.axb().b(this.eaw, jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.aa.d getUpdateManager(JsObject jsObject) {
        if (this.ecl == null) {
            this.ecl = new com.baidu.swan.games.aa.d(jsObject);
        }
        return this.ecl;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.websocket.c connectSocket(JsObject jsObject) {
        if (this.ecn == null) {
            this.ecn = new com.baidu.swan.games.network.websocket.a(this.eaw);
        }
        return this.ecn.connectSocket(jsObject);
    }

    @JavascriptInterface
    public void setEnableDebug(JsObject jsObject) {
        if (this.eco == null) {
            this.eco = new g(this.eaw);
        }
        this.eco.setEnableDebug(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.c.c request(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        com.baidu.swan.games.network.a a2 = com.baidu.swan.games.network.b.d.aXq().a(this.eaw, e, 1);
        if (a2 instanceof com.baidu.swan.games.network.c.c) {
            com.baidu.swan.games.network.c.c cVar = (com.baidu.swan.games.network.c.c) a2;
            cVar.j(e);
            return cVar;
        }
        com.baidu.swan.games.network.c.c cVar2 = new com.baidu.swan.games.network.c.c(this.eaw, e);
        cVar2.start();
        return cVar2;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.d.b uploadFile(JsObject jsObject) {
        com.baidu.swan.games.network.d.b bVar = new com.baidu.swan.games.network.d.b(this.eaw, com.baidu.swan.games.binding.model.c.e(jsObject));
        bVar.start();
        return bVar;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.a.b downloadFile(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        com.baidu.swan.games.network.a a2 = com.baidu.swan.games.network.b.d.aXq().a(this.eaw, e, 2);
        if (a2 instanceof com.baidu.swan.games.network.a.b) {
            com.baidu.swan.games.network.a.b bVar = (com.baidu.swan.games.network.a.b) a2;
            bVar.j(e);
            return bVar;
        }
        com.baidu.swan.games.network.a.b bVar2 = new com.baidu.swan.games.network.a.b(this.eaw, e);
        bVar2.start();
        return bVar2;
    }

    @JavascriptInterface
    public void openCustomerServiceConversation(JsObject jsObject) {
        com.baidu.swan.games.d.a.a((c) this.eaw.aVN(), jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.screenrecord.a getVideoRecorderManager() {
        if (this.ecp == null) {
            this.ecp = new com.baidu.swan.games.screenrecord.a(this.eaw);
        }
        return this.ecp;
    }

    @JavascriptInterface
    public void shareVideo(JsObject jsObject) {
        new com.baidu.swan.games.u.b.a(jsObject).anL();
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return com.baidu.swan.apps.jsbridge.a.b.f(this.eaw);
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton(JsObject jsObject) {
        return new RecommendButtonApiProxy(this.eaw, jsObject);
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton() {
        return createRecommendationButton(null);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide(JsObject jsObject) {
        if (this.ecr == null) {
            this.ecr = new DesktopGuideApi(this.eaw);
        }
        this.ecr.q(jsObject);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide() {
        showAddToDesktopGuide(null);
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.webview.a getWebViewManager() {
        if (this.ect == null) {
            this.ect = new com.baidu.swan.games.view.webview.a(this.eaw);
        }
        return this.ect;
    }

    @JavascriptInterface
    public void getUUAPInfo(JsObject jsObject) {
        com.baidu.swan.games.ab.a.getUUAPInfo(jsObject);
    }

    @JavascriptInterface
    public String getAPIs(int i) {
        if (DEBUG) {
            return com.baidu.swan.apps.ad.a.a.aET() ? SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i) : "";
        }
        return SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i);
    }

    @JavascriptInterface
    public void authorizeEval(JsObject jsObject) {
        com.baidu.swan.games.g.a.authorizeEval(jsObject);
    }

    @JavascriptInterface
    public void menuItemCtrl(JsObject jsObject) {
        com.baidu.swan.games.q.a azB = f.azN().azB();
        if (azB != null) {
            azB.i(com.baidu.swan.games.binding.model.c.e(jsObject));
        }
    }

    @JavascriptInterface
    public com.baidu.swan.games.b.b getAntiAddiction() {
        if (this.ecu == null) {
            this.ecu = new com.baidu.swan.games.b.b(this.eaw);
        }
        return this.ecu;
    }
}
