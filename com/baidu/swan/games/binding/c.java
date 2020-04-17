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
    private com.baidu.swan.games.e.b cJh;
    private d cKJ;
    private com.baidu.swan.games.q.d cKK;
    private com.baidu.swan.games.q.b cKL;
    private JsObject cKM;
    private e cKN;
    private com.baidu.swan.games.m.a cKO;
    private com.baidu.swan.games.m.b cKP;
    private com.baidu.swan.games.v.a cKQ;
    private com.baidu.swan.games.z.d cKR;
    private com.baidu.swan.games.a.c cKS;
    private com.baidu.swan.games.network.websocket.a cKT;
    private g cKU;
    private com.baidu.swan.games.screenrecord.a cKV;
    private h cKW;
    private DesktopGuideApi cKX;
    private com.baidu.swan.games.r.a cKY;
    private com.baidu.swan.games.view.webview.a cKZ;
    @V8JavascriptField
    public final String domain;
    @V8JavascriptField
    public com.baidu.swan.games.h.a env;

    public c(com.baidu.swan.games.e.b bVar) {
        super(bVar);
        this.domain = "main";
        this.cKM = null;
        this.cKN = null;
        this.cKO = null;
        this.cKP = null;
        this.cKR = null;
        this.cKS = null;
        this.cKT = null;
        this.cKU = null;
        this.cKV = null;
        this.cKW = null;
        this.cKX = null;
        this.cKY = null;
        this.cKZ = null;
        this.cJh = bVar;
        this.env = new com.baidu.swan.games.h.a();
        avj();
    }

    private void avj() {
        this.cKP = new com.baidu.swan.games.m.b(this.cJh);
    }

    public void b(JsObject jsObject) {
        this.cKM = jsObject;
    }

    @JavascriptInterface
    public void setPreferredFramesPerSecond(short s) {
        if (s >= 1 && s <= 60) {
            this.cJh.setPreferredFramesPerSecond(s);
        }
    }

    @JavascriptInterface
    public e getOpenDataContext() {
        if (this.cKN == null) {
            this.cKN = new e(this.cJh);
            this.cKN.canvas = this.cKM;
            this.cKM = null;
        }
        return this.cKN;
    }

    @JavascriptInterface
    public d getFileSystemManager() {
        if (this.cKJ == null) {
            this.cKJ = new d((com.baidu.swan.games.e.a) this.cJh);
        }
        return this.cKJ;
    }

    @JavascriptInterface
    public com.baidu.swan.games.x.c loadSubpackage(JsObject jsObject) {
        com.baidu.swan.games.x.c cVar = new com.baidu.swan.games.x.c(this.cJh);
        cVar.l(jsObject);
        return cVar;
    }

    @JavascriptInterface
    public void exit(JsObject jsObject) {
        if (DEBUG) {
            this.cJh.avO().log("exit from java side.");
        }
        if (jsObject != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            com.baidu.swan.games.binding.model.a f = com.baidu.swan.games.binding.model.a.f(com.baidu.swan.games.binding.model.c.c(jsObject));
            SwanAppActivity aev = f.aeK().aev();
            if (aev == null) {
                bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "failed");
                f.T(bVar);
                return;
            }
            bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "ok");
            f.onSuccess(bVar);
            if (Build.VERSION.SDK_INT >= 21) {
                aev.finishAndRemoveTask();
            } else {
                aev.finish();
            }
        }
    }

    @JavascriptInterface
    public void reload(JsObject jsObject) {
        if (this.cKY == null) {
            this.cKY = new com.baidu.swan.games.r.a();
        }
        this.cKY.reload(jsObject);
    }

    @JavascriptInterface
    public void reload() {
        reload(null);
    }

    @JavascriptInterface
    public com.baidu.swan.games.q.d getOpenData() {
        if (this.cKK == null) {
            this.cKK = new com.baidu.swan.games.q.d((com.baidu.swan.games.e.a) this.cJh);
        }
        return this.cKK;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        if (this.cKL == null) {
            this.cKL = new com.baidu.swan.games.q.b(this.cJh);
        }
        this.cKL.checkIsUserAdvisedToRest(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.c createRewardedVideoAd(JsObject jsObject) {
        if (this.cKS == null) {
            this.cKS = com.baidu.swan.apps.w.a.acq().a(this.cJh, jsObject);
            if (this.cKS == null) {
                this.cKS = new com.baidu.swan.games.a.a();
            }
        }
        return this.cKS;
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.button.userinfo.b createUserInfoButton(JsObject jsObject) {
        return new com.baidu.swan.games.view.button.userinfo.b(jsObject, this.cJh);
    }

    @JavascriptInterface
    public void showKeyboard(JsObject jsObject) {
        if (this.cKO == null) {
            this.cKO = new com.baidu.swan.games.m.a(this.cJh, this.cKP);
        }
        this.cKO.showKeyboard(jsObject);
    }

    @JavascriptInterface
    public void showKeyboard() {
        if (this.cKO == null) {
            this.cKO = new com.baidu.swan.games.m.a(this.cJh, this.cKP);
        }
        this.cKO.showKeyboard(null);
    }

    @JavascriptInterface
    public void updateKeyboard(JsObject jsObject) {
        if (this.cKO != null) {
            this.cKO.updateKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void updateKeyboard() {
        if (this.cKO != null) {
            this.cKO.updateKeyboard(null);
        }
    }

    @JavascriptInterface
    public void hideKeyboard(JsObject jsObject) {
        if (this.cKO != null) {
            this.cKO.hideKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void hideKeyboard() {
        if (this.cKO != null) {
            this.cKO.hideKeyboard(null);
        }
    }

    @JavascriptInterface
    public void getStorage(JsObject jsObject) {
        avk().getStorage(jsObject);
    }

    @JavascriptInterface
    public Object getStorageSync(String str) {
        return com.baidu.swan.games.v.a.d.a(this.cJh, "getStorageSync", str, avk().qS(str));
    }

    @JavascriptInterface
    public void setStorage(JsObject jsObject) {
        avk().setStorage(jsObject);
    }

    @JavascriptInterface
    public void setStorageSync(String str, JsSerializeValue jsSerializeValue) {
        com.baidu.swan.games.v.a.d.a(this.cJh, "setStorageSync", str, avk().a(str, jsSerializeValue));
    }

    @JavascriptInterface
    public void setStorageSync(String str) {
        com.baidu.swan.games.v.a.d.a(this.cJh, "setStorageSync", str, avk().a(str, (JsSerializeValue) null));
    }

    @JavascriptInterface
    public void removeStorage(JsObject jsObject) {
        avk().removeStorage(jsObject);
    }

    @JavascriptInterface
    public void removeStorageSync(String str) {
        com.baidu.swan.games.v.a.d.a(this.cJh, "removeStorageSync", str, avk().qT(str));
    }

    @JavascriptInterface
    public void clearStorage(JsObject jsObject) {
        avk().clearStorage(jsObject);
    }

    @JavascriptInterface
    public void clearStorageSync() {
        com.baidu.swan.games.v.a.d.a(this.cJh, "clearStorageSync", "", avk().ayc());
    }

    @JavascriptInterface
    public void getStorageInfo(JsObject jsObject) {
        avk().getStorageInfo(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.v.a.c getStorageInfoSync() {
        return avk().getStorageInfoSync();
    }

    @NonNull
    private com.baidu.swan.games.v.a avk() {
        if (this.cKQ == null) {
            this.cKQ = new com.baidu.swan.games.v.a(this.cJh);
        }
        return this.cKQ;
    }

    @JavascriptInterface
    public void setInnerAudioOption(JsObject jsObject) {
        this.cKW = new h(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.audio.g createInnerAudioContext() {
        return new com.baidu.swan.games.audio.g(this.cJh);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.b createBannerAd(JsObject jsObject) {
        return com.baidu.swan.apps.w.a.acq().b(this.cJh, jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.z.d getUpdateManager(JsObject jsObject) {
        if (this.cKR == null) {
            this.cKR = new com.baidu.swan.games.z.d(jsObject);
        }
        return this.cKR;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.websocket.c connectSocket(JsObject jsObject) {
        if (this.cKT == null) {
            this.cKT = new com.baidu.swan.games.network.websocket.a(this.cJh);
        }
        return this.cKT.connectSocket(jsObject);
    }

    @JavascriptInterface
    public void setEnableDebug(JsObject jsObject) {
        if (this.cKU == null) {
            this.cKU = new g(this.cJh);
        }
        this.cKU.setEnableDebug(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.c.c request(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        com.baidu.swan.games.network.a a = com.baidu.swan.games.network.b.d.axj().a(this.cJh, c, 1);
        if (a instanceof com.baidu.swan.games.network.c.c) {
            com.baidu.swan.games.network.c.c cVar = (com.baidu.swan.games.network.c.c) a;
            cVar.j(c);
            return cVar;
        }
        com.baidu.swan.games.network.c.c cVar2 = new com.baidu.swan.games.network.c.c(this.cJh, c);
        cVar2.start();
        return cVar2;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.d.b uploadFile(JsObject jsObject) {
        com.baidu.swan.games.network.d.b bVar = new com.baidu.swan.games.network.d.b(this.cJh, com.baidu.swan.games.binding.model.c.c(jsObject));
        bVar.start();
        return bVar;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.a.b downloadFile(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        com.baidu.swan.games.network.a a = com.baidu.swan.games.network.b.d.axj().a(this.cJh, c, 2);
        if (a instanceof com.baidu.swan.games.network.a.b) {
            com.baidu.swan.games.network.a.b bVar = (com.baidu.swan.games.network.a.b) a;
            bVar.j(c);
            return bVar;
        }
        com.baidu.swan.games.network.a.b bVar2 = new com.baidu.swan.games.network.a.b(this.cJh, c);
        bVar2.start();
        return bVar2;
    }

    @JavascriptInterface
    public void openCustomerServiceConversation(JsObject jsObject) {
        com.baidu.swan.games.c.a.a((c) this.cJh.avM(), jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.screenrecord.a getVideoRecorderManager() {
        if (this.cKV == null) {
            this.cKV = new com.baidu.swan.games.screenrecord.a(this.cJh);
        }
        return this.cKV;
    }

    @JavascriptInterface
    public void shareVideo(JsObject jsObject) {
        new com.baidu.swan.games.t.b.a(jsObject).VI();
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return com.baidu.swan.apps.jsbridge.a.b.getEnvVariables();
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton(JsObject jsObject) {
        return new RecommendButtonApiProxy(this.cJh, jsObject);
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton() {
        return createRecommendationButton(null);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide(JsObject jsObject) {
        if (this.cKX == null) {
            this.cKX = new DesktopGuideApi(this.cJh);
        }
        this.cKX.o(jsObject);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide() {
        showAddToDesktopGuide(null);
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.webview.a getWebViewManager() {
        if (this.cKZ == null) {
            this.cKZ = new com.baidu.swan.games.view.webview.a(this.cJh);
        }
        return this.cKZ;
    }

    @JavascriptInterface
    public void getUUAPInfo(JsObject jsObject) {
        com.baidu.swan.games.aa.a.getUUAPInfo(jsObject);
    }

    @JavascriptInterface
    public String getAPIs(int i) {
        return DEBUG ? com.baidu.swan.apps.ah.a.a.aiN() ? SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i) : "" : com.baidu.swan.apps.w.a.abR().OX() ? SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i) : "";
    }

    @JavascriptInterface
    public void authorizeEval(JsObject jsObject) {
        com.baidu.swan.games.f.a.authorizeEval(jsObject);
    }

    @JavascriptInterface
    public void menuItemCtrl(JsObject jsObject) {
        com.baidu.swan.games.p.a aez = f.aeK().aez();
        if (aez != null) {
            aez.i(com.baidu.swan.games.binding.model.c.c(jsObject));
        }
    }
}
