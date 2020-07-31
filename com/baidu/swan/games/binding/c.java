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
    private com.baidu.swan.games.f.b deo;
    private e dfW;
    private d dfX;
    private com.baidu.swan.games.r.b dfY;
    private JsObject dfZ;
    private com.baidu.swan.games.r.e dga;
    private com.baidu.swan.games.n.a dgb;
    private com.baidu.swan.games.n.b dgc;
    private com.baidu.swan.games.w.a dgd;
    private com.baidu.swan.games.aa.d dge;
    private com.baidu.swan.games.a.c dgf;
    private com.baidu.swan.games.network.websocket.a dgg;
    private g dgh;
    private com.baidu.swan.games.screenrecord.a dgi;
    private h dgj;
    private DesktopGuideApi dgk;
    private com.baidu.swan.games.s.a dgl;
    private com.baidu.swan.games.view.webview.a dgm;
    private com.baidu.swan.games.b.b dgn;
    @V8JavascriptField
    public final String domain;
    @V8JavascriptField
    public com.baidu.swan.games.i.a env;

    public c(com.baidu.swan.games.f.b bVar) {
        super(bVar);
        this.domain = "main";
        this.dfZ = null;
        this.dga = null;
        this.dgb = null;
        this.dgc = null;
        this.dge = null;
        this.dgf = null;
        this.dgg = null;
        this.dgh = null;
        this.dgi = null;
        this.dgj = null;
        this.dgk = null;
        this.dgl = null;
        this.dgm = null;
        this.dgn = null;
        this.deo = bVar;
        this.env = new com.baidu.swan.games.i.a();
        aDJ();
    }

    private void aDJ() {
        this.dgc = new com.baidu.swan.games.n.b(this.deo);
    }

    public void d(JsObject jsObject) {
        this.dfZ = jsObject;
    }

    @JavascriptInterface
    public void setPreferredFramesPerSecond(short s) {
        if (s >= 1 && s <= 60) {
            this.deo.setPreferredFramesPerSecond(s);
        }
    }

    @JavascriptInterface
    public com.baidu.swan.games.r.e getOpenDataContext() {
        if (this.dga == null) {
            this.dga = new com.baidu.swan.games.r.e(this.deo);
            this.dga.canvas = this.dfZ;
            this.dfZ = null;
        }
        return this.dga;
    }

    @JavascriptInterface
    public e getFileSystemManager() {
        if (this.dfW == null) {
            this.dfW = new e((com.baidu.swan.games.f.a) this.deo);
        }
        return this.dfW;
    }

    @JavascriptInterface
    public com.baidu.swan.games.y.c loadSubpackage(JsObject jsObject) {
        com.baidu.swan.games.y.c cVar = new com.baidu.swan.games.y.c(this.deo);
        cVar.n(jsObject);
        return cVar;
    }

    @JavascriptInterface
    public void exit(JsObject jsObject) {
        if (DEBUG) {
            this.deo.aEo().log("exit from java side.");
        }
        if (jsObject != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            com.baidu.swan.games.binding.model.a f = com.baidu.swan.games.binding.model.a.f(com.baidu.swan.games.binding.model.c.e(jsObject));
            SwanAppActivity akb = f.akr().akb();
            if (akb == null) {
                bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "failed");
                f.Y(bVar);
                return;
            }
            bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "ok");
            f.onSuccess(bVar);
            if (Build.VERSION.SDK_INT >= 21) {
                akb.finishAndRemoveTask();
            } else {
                akb.finish();
            }
        }
    }

    @JavascriptInterface
    public void reload(JsObject jsObject) {
        if (this.dgl == null) {
            this.dgl = new com.baidu.swan.games.s.a();
        }
        this.dgl.reload(jsObject);
    }

    @JavascriptInterface
    public void reload() {
        reload(null);
    }

    @JavascriptInterface
    public d getOpenData() {
        if (this.dfX == null) {
            this.dfX = new d((com.baidu.swan.games.f.a) this.deo);
        }
        return this.dfX;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        if (this.dfY == null) {
            this.dfY = new com.baidu.swan.games.r.b(this.deo);
        }
        this.dfY.checkIsUserAdvisedToRest(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.c createRewardedVideoAd(JsObject jsObject) {
        if (this.dgf == null) {
            this.dgf = com.baidu.swan.apps.t.a.ahL().a(this.deo, jsObject);
            if (this.dgf == null) {
                this.dgf = new com.baidu.swan.games.a.a();
            }
        }
        return this.dgf;
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.button.userinfo.b createUserInfoButton(JsObject jsObject) {
        return new com.baidu.swan.games.view.button.userinfo.b(jsObject, this.deo);
    }

    @JavascriptInterface
    public void showKeyboard(JsObject jsObject) {
        if (this.dgb == null) {
            this.dgb = new com.baidu.swan.games.n.a(this.deo, this.dgc);
        }
        this.dgb.showKeyboard(jsObject);
    }

    @JavascriptInterface
    public void showKeyboard() {
        if (this.dgb == null) {
            this.dgb = new com.baidu.swan.games.n.a(this.deo, this.dgc);
        }
        this.dgb.showKeyboard(null);
    }

    @JavascriptInterface
    public void updateKeyboard(JsObject jsObject) {
        if (this.dgb != null) {
            this.dgb.updateKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void updateKeyboard() {
        if (this.dgb != null) {
            this.dgb.updateKeyboard(null);
        }
    }

    @JavascriptInterface
    public void hideKeyboard(JsObject jsObject) {
        if (this.dgb != null) {
            this.dgb.hideKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void hideKeyboard() {
        if (this.dgb != null) {
            this.dgb.hideKeyboard(null);
        }
    }

    @JavascriptInterface
    public void getStorage(JsObject jsObject) {
        aDK().getStorage(jsObject);
    }

    @JavascriptInterface
    public Object getStorageSync(String str) {
        return com.baidu.swan.games.w.a.d.a(this.deo, "getStorageSync", str, aDK().tC(str));
    }

    @JavascriptInterface
    public void setStorage(JsObject jsObject) {
        aDK().setStorage(jsObject);
    }

    @JavascriptInterface
    public void setStorageSync(String str, JsSerializeValue jsSerializeValue) {
        com.baidu.swan.games.w.a.d.a(this.deo, "setStorageSync", str, aDK().a(str, jsSerializeValue));
    }

    @JavascriptInterface
    public void setStorageSync(String str) {
        com.baidu.swan.games.w.a.d.a(this.deo, "setStorageSync", str, aDK().a(str, (JsSerializeValue) null));
    }

    @JavascriptInterface
    public void removeStorage(JsObject jsObject) {
        aDK().removeStorage(jsObject);
    }

    @JavascriptInterface
    public void removeStorageSync(String str) {
        com.baidu.swan.games.w.a.d.a(this.deo, "removeStorageSync", str, aDK().tD(str));
    }

    @JavascriptInterface
    public void clearStorage(JsObject jsObject) {
        aDK().clearStorage(jsObject);
    }

    @JavascriptInterface
    public void clearStorageSync() {
        com.baidu.swan.games.w.a.d.a(this.deo, "clearStorageSync", "", aDK().aGG());
    }

    @JavascriptInterface
    public void getStorageInfo(JsObject jsObject) {
        aDK().getStorageInfo(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.w.a.c getStorageInfoSync() {
        return aDK().getStorageInfoSync();
    }

    @NonNull
    private com.baidu.swan.games.w.a aDK() {
        if (this.dgd == null) {
            this.dgd = new com.baidu.swan.games.w.a(this.deo);
        }
        return this.dgd;
    }

    @JavascriptInterface
    public void setInnerAudioOption(JsObject jsObject) {
        this.dgj = new h(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.audio.g createInnerAudioContext() {
        return new com.baidu.swan.games.audio.g(this.deo);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.b createBannerAd(JsObject jsObject) {
        return com.baidu.swan.apps.t.a.ahL().b(this.deo, jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.aa.d getUpdateManager(JsObject jsObject) {
        if (this.dge == null) {
            this.dge = new com.baidu.swan.games.aa.d(jsObject);
        }
        return this.dge;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.websocket.c connectSocket(JsObject jsObject) {
        if (this.dgg == null) {
            this.dgg = new com.baidu.swan.games.network.websocket.a(this.deo);
        }
        return this.dgg.connectSocket(jsObject);
    }

    @JavascriptInterface
    public void setEnableDebug(JsObject jsObject) {
        if (this.dgh == null) {
            this.dgh = new g(this.deo);
        }
        this.dgh.setEnableDebug(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.c.c request(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        com.baidu.swan.games.network.a a = com.baidu.swan.games.network.b.d.aFN().a(this.deo, e, 1);
        if (a instanceof com.baidu.swan.games.network.c.c) {
            com.baidu.swan.games.network.c.c cVar = (com.baidu.swan.games.network.c.c) a;
            cVar.j(e);
            return cVar;
        }
        com.baidu.swan.games.network.c.c cVar2 = new com.baidu.swan.games.network.c.c(this.deo, e);
        cVar2.start();
        return cVar2;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.d.b uploadFile(JsObject jsObject) {
        com.baidu.swan.games.network.d.b bVar = new com.baidu.swan.games.network.d.b(this.deo, com.baidu.swan.games.binding.model.c.e(jsObject));
        bVar.start();
        return bVar;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.a.b downloadFile(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        com.baidu.swan.games.network.a a = com.baidu.swan.games.network.b.d.aFN().a(this.deo, e, 2);
        if (a instanceof com.baidu.swan.games.network.a.b) {
            com.baidu.swan.games.network.a.b bVar = (com.baidu.swan.games.network.a.b) a;
            bVar.j(e);
            return bVar;
        }
        com.baidu.swan.games.network.a.b bVar2 = new com.baidu.swan.games.network.a.b(this.deo, e);
        bVar2.start();
        return bVar2;
    }

    @JavascriptInterface
    public void openCustomerServiceConversation(JsObject jsObject) {
        com.baidu.swan.games.d.a.a((c) this.deo.aEm(), jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.screenrecord.a getVideoRecorderManager() {
        if (this.dgi == null) {
            this.dgi = new com.baidu.swan.games.screenrecord.a(this.deo);
        }
        return this.dgi;
    }

    @JavascriptInterface
    public void shareVideo(JsObject jsObject) {
        new com.baidu.swan.games.u.b.a(jsObject).ZU();
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return com.baidu.swan.apps.jsbridge.a.b.getEnvVariables();
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton(JsObject jsObject) {
        return new RecommendButtonApiProxy(this.deo, jsObject);
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton() {
        return createRecommendationButton(null);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide(JsObject jsObject) {
        if (this.dgk == null) {
            this.dgk = new DesktopGuideApi(this.deo);
        }
        this.dgk.q(jsObject);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide() {
        showAddToDesktopGuide(null);
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.webview.a getWebViewManager() {
        if (this.dgm == null) {
            this.dgm = new com.baidu.swan.games.view.webview.a(this.deo);
        }
        return this.dgm;
    }

    @JavascriptInterface
    public void getUUAPInfo(JsObject jsObject) {
        com.baidu.swan.games.ab.a.getUUAPInfo(jsObject);
    }

    @JavascriptInterface
    public String getAPIs(int i) {
        return DEBUG ? com.baidu.swan.apps.ae.a.a.apj() ? SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i) : "" : com.baidu.swan.apps.t.a.ahm().SE() ? SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i) : "";
    }

    @JavascriptInterface
    public void authorizeEval(JsObject jsObject) {
        com.baidu.swan.games.g.a.authorizeEval(jsObject);
    }

    @JavascriptInterface
    public void menuItemCtrl(JsObject jsObject) {
        com.baidu.swan.games.q.a akf = f.akr().akf();
        if (akf != null) {
            akf.i(com.baidu.swan.games.binding.model.c.e(jsObject));
        }
    }

    @JavascriptInterface
    public com.baidu.swan.games.b.b getAntiAddiction() {
        if (this.dgn == null) {
            this.dgn = new com.baidu.swan.games.b.b(this.deo);
        }
        return this.dgn;
    }
}
