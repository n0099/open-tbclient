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
    private com.baidu.swan.games.e.b cJn;
    private d cKP;
    private com.baidu.swan.games.q.d cKQ;
    private com.baidu.swan.games.q.b cKR;
    private JsObject cKS;
    private e cKT;
    private com.baidu.swan.games.m.a cKU;
    private com.baidu.swan.games.m.b cKV;
    private com.baidu.swan.games.v.a cKW;
    private com.baidu.swan.games.z.d cKX;
    private com.baidu.swan.games.a.c cKY;
    private com.baidu.swan.games.network.websocket.a cKZ;
    private g cLa;
    private com.baidu.swan.games.screenrecord.a cLb;
    private h cLc;
    private DesktopGuideApi cLd;
    private com.baidu.swan.games.r.a cLe;
    private com.baidu.swan.games.view.webview.a cLf;
    @V8JavascriptField
    public final String domain;
    @V8JavascriptField
    public com.baidu.swan.games.h.a env;

    public c(com.baidu.swan.games.e.b bVar) {
        super(bVar);
        this.domain = "main";
        this.cKS = null;
        this.cKT = null;
        this.cKU = null;
        this.cKV = null;
        this.cKX = null;
        this.cKY = null;
        this.cKZ = null;
        this.cLa = null;
        this.cLb = null;
        this.cLc = null;
        this.cLd = null;
        this.cLe = null;
        this.cLf = null;
        this.cJn = bVar;
        this.env = new com.baidu.swan.games.h.a();
        avj();
    }

    private void avj() {
        this.cKV = new com.baidu.swan.games.m.b(this.cJn);
    }

    public void b(JsObject jsObject) {
        this.cKS = jsObject;
    }

    @JavascriptInterface
    public void setPreferredFramesPerSecond(short s) {
        if (s >= 1 && s <= 60) {
            this.cJn.setPreferredFramesPerSecond(s);
        }
    }

    @JavascriptInterface
    public e getOpenDataContext() {
        if (this.cKT == null) {
            this.cKT = new e(this.cJn);
            this.cKT.canvas = this.cKS;
            this.cKS = null;
        }
        return this.cKT;
    }

    @JavascriptInterface
    public d getFileSystemManager() {
        if (this.cKP == null) {
            this.cKP = new d((com.baidu.swan.games.e.a) this.cJn);
        }
        return this.cKP;
    }

    @JavascriptInterface
    public com.baidu.swan.games.x.c loadSubpackage(JsObject jsObject) {
        com.baidu.swan.games.x.c cVar = new com.baidu.swan.games.x.c(this.cJn);
        cVar.l(jsObject);
        return cVar;
    }

    @JavascriptInterface
    public void exit(JsObject jsObject) {
        if (DEBUG) {
            this.cJn.avO().log("exit from java side.");
        }
        if (jsObject != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            com.baidu.swan.games.binding.model.a f = com.baidu.swan.games.binding.model.a.f(com.baidu.swan.games.binding.model.c.c(jsObject));
            SwanAppActivity aeu = f.aeJ().aeu();
            if (aeu == null) {
                bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "failed");
                f.U(bVar);
                return;
            }
            bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "ok");
            f.onSuccess(bVar);
            if (Build.VERSION.SDK_INT >= 21) {
                aeu.finishAndRemoveTask();
            } else {
                aeu.finish();
            }
        }
    }

    @JavascriptInterface
    public void reload(JsObject jsObject) {
        if (this.cLe == null) {
            this.cLe = new com.baidu.swan.games.r.a();
        }
        this.cLe.reload(jsObject);
    }

    @JavascriptInterface
    public void reload() {
        reload(null);
    }

    @JavascriptInterface
    public com.baidu.swan.games.q.d getOpenData() {
        if (this.cKQ == null) {
            this.cKQ = new com.baidu.swan.games.q.d((com.baidu.swan.games.e.a) this.cJn);
        }
        return this.cKQ;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        if (this.cKR == null) {
            this.cKR = new com.baidu.swan.games.q.b(this.cJn);
        }
        this.cKR.checkIsUserAdvisedToRest(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.c createRewardedVideoAd(JsObject jsObject) {
        if (this.cKY == null) {
            this.cKY = com.baidu.swan.apps.w.a.acp().a(this.cJn, jsObject);
            if (this.cKY == null) {
                this.cKY = new com.baidu.swan.games.a.a();
            }
        }
        return this.cKY;
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.button.userinfo.b createUserInfoButton(JsObject jsObject) {
        return new com.baidu.swan.games.view.button.userinfo.b(jsObject, this.cJn);
    }

    @JavascriptInterface
    public void showKeyboard(JsObject jsObject) {
        if (this.cKU == null) {
            this.cKU = new com.baidu.swan.games.m.a(this.cJn, this.cKV);
        }
        this.cKU.showKeyboard(jsObject);
    }

    @JavascriptInterface
    public void showKeyboard() {
        if (this.cKU == null) {
            this.cKU = new com.baidu.swan.games.m.a(this.cJn, this.cKV);
        }
        this.cKU.showKeyboard(null);
    }

    @JavascriptInterface
    public void updateKeyboard(JsObject jsObject) {
        if (this.cKU != null) {
            this.cKU.updateKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void updateKeyboard() {
        if (this.cKU != null) {
            this.cKU.updateKeyboard(null);
        }
    }

    @JavascriptInterface
    public void hideKeyboard(JsObject jsObject) {
        if (this.cKU != null) {
            this.cKU.hideKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void hideKeyboard() {
        if (this.cKU != null) {
            this.cKU.hideKeyboard(null);
        }
    }

    @JavascriptInterface
    public void getStorage(JsObject jsObject) {
        avk().getStorage(jsObject);
    }

    @JavascriptInterface
    public Object getStorageSync(String str) {
        return com.baidu.swan.games.v.a.d.a(this.cJn, "getStorageSync", str, avk().qS(str));
    }

    @JavascriptInterface
    public void setStorage(JsObject jsObject) {
        avk().setStorage(jsObject);
    }

    @JavascriptInterface
    public void setStorageSync(String str, JsSerializeValue jsSerializeValue) {
        com.baidu.swan.games.v.a.d.a(this.cJn, "setStorageSync", str, avk().a(str, jsSerializeValue));
    }

    @JavascriptInterface
    public void setStorageSync(String str) {
        com.baidu.swan.games.v.a.d.a(this.cJn, "setStorageSync", str, avk().a(str, (JsSerializeValue) null));
    }

    @JavascriptInterface
    public void removeStorage(JsObject jsObject) {
        avk().removeStorage(jsObject);
    }

    @JavascriptInterface
    public void removeStorageSync(String str) {
        com.baidu.swan.games.v.a.d.a(this.cJn, "removeStorageSync", str, avk().qT(str));
    }

    @JavascriptInterface
    public void clearStorage(JsObject jsObject) {
        avk().clearStorage(jsObject);
    }

    @JavascriptInterface
    public void clearStorageSync() {
        com.baidu.swan.games.v.a.d.a(this.cJn, "clearStorageSync", "", avk().ayc());
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
        if (this.cKW == null) {
            this.cKW = new com.baidu.swan.games.v.a(this.cJn);
        }
        return this.cKW;
    }

    @JavascriptInterface
    public void setInnerAudioOption(JsObject jsObject) {
        this.cLc = new h(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.audio.g createInnerAudioContext() {
        return new com.baidu.swan.games.audio.g(this.cJn);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.b createBannerAd(JsObject jsObject) {
        return com.baidu.swan.apps.w.a.acp().b(this.cJn, jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.z.d getUpdateManager(JsObject jsObject) {
        if (this.cKX == null) {
            this.cKX = new com.baidu.swan.games.z.d(jsObject);
        }
        return this.cKX;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.websocket.c connectSocket(JsObject jsObject) {
        if (this.cKZ == null) {
            this.cKZ = new com.baidu.swan.games.network.websocket.a(this.cJn);
        }
        return this.cKZ.connectSocket(jsObject);
    }

    @JavascriptInterface
    public void setEnableDebug(JsObject jsObject) {
        if (this.cLa == null) {
            this.cLa = new g(this.cJn);
        }
        this.cLa.setEnableDebug(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.c.c request(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        com.baidu.swan.games.network.a a = com.baidu.swan.games.network.b.d.axj().a(this.cJn, c, 1);
        if (a instanceof com.baidu.swan.games.network.c.c) {
            com.baidu.swan.games.network.c.c cVar = (com.baidu.swan.games.network.c.c) a;
            cVar.j(c);
            return cVar;
        }
        com.baidu.swan.games.network.c.c cVar2 = new com.baidu.swan.games.network.c.c(this.cJn, c);
        cVar2.start();
        return cVar2;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.d.b uploadFile(JsObject jsObject) {
        com.baidu.swan.games.network.d.b bVar = new com.baidu.swan.games.network.d.b(this.cJn, com.baidu.swan.games.binding.model.c.c(jsObject));
        bVar.start();
        return bVar;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.a.b downloadFile(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        com.baidu.swan.games.network.a a = com.baidu.swan.games.network.b.d.axj().a(this.cJn, c, 2);
        if (a instanceof com.baidu.swan.games.network.a.b) {
            com.baidu.swan.games.network.a.b bVar = (com.baidu.swan.games.network.a.b) a;
            bVar.j(c);
            return bVar;
        }
        com.baidu.swan.games.network.a.b bVar2 = new com.baidu.swan.games.network.a.b(this.cJn, c);
        bVar2.start();
        return bVar2;
    }

    @JavascriptInterface
    public void openCustomerServiceConversation(JsObject jsObject) {
        com.baidu.swan.games.c.a.a((c) this.cJn.avM(), jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.screenrecord.a getVideoRecorderManager() {
        if (this.cLb == null) {
            this.cLb = new com.baidu.swan.games.screenrecord.a(this.cJn);
        }
        return this.cLb;
    }

    @JavascriptInterface
    public void shareVideo(JsObject jsObject) {
        new com.baidu.swan.games.t.b.a(jsObject).VH();
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return com.baidu.swan.apps.jsbridge.a.b.getEnvVariables();
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton(JsObject jsObject) {
        return new RecommendButtonApiProxy(this.cJn, jsObject);
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton() {
        return createRecommendationButton(null);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide(JsObject jsObject) {
        if (this.cLd == null) {
            this.cLd = new DesktopGuideApi(this.cJn);
        }
        this.cLd.o(jsObject);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide() {
        showAddToDesktopGuide(null);
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.webview.a getWebViewManager() {
        if (this.cLf == null) {
            this.cLf = new com.baidu.swan.games.view.webview.a(this.cJn);
        }
        return this.cLf;
    }

    @JavascriptInterface
    public void getUUAPInfo(JsObject jsObject) {
        com.baidu.swan.games.aa.a.getUUAPInfo(jsObject);
    }

    @JavascriptInterface
    public String getAPIs(int i) {
        return DEBUG ? com.baidu.swan.apps.ah.a.a.aiM() ? SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i) : "" : com.baidu.swan.apps.w.a.abQ().OW() ? SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i) : "";
    }

    @JavascriptInterface
    public void authorizeEval(JsObject jsObject) {
        com.baidu.swan.games.f.a.authorizeEval(jsObject);
    }

    @JavascriptInterface
    public void menuItemCtrl(JsObject jsObject) {
        com.baidu.swan.games.p.a aey = f.aeJ().aey();
        if (aey != null) {
            aey.i(com.baidu.swan.games.binding.model.c.c(jsObject));
        }
    }
}
