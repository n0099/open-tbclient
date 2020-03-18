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
    private com.baidu.swan.games.e.b ckm;
    private d clM;
    private com.baidu.swan.games.q.d clN;
    private com.baidu.swan.games.q.b clO;
    private JsObject clP;
    private e clQ;
    private com.baidu.swan.games.m.a clR;
    private com.baidu.swan.games.m.b clS;
    private com.baidu.swan.games.v.a clT;
    private com.baidu.swan.games.z.d clU;
    private com.baidu.swan.games.a.c clV;
    private com.baidu.swan.games.network.websocket.a clW;
    private g clX;
    private com.baidu.swan.games.screenrecord.a clY;
    private h clZ;
    private DesktopGuideApi cma;
    private com.baidu.swan.games.r.a cmb;
    private com.baidu.swan.games.view.webview.a cmc;
    @V8JavascriptField
    public final String domain;
    @V8JavascriptField
    public com.baidu.swan.games.h.a env;

    public c(com.baidu.swan.games.e.b bVar) {
        super(bVar);
        this.domain = "main";
        this.clP = null;
        this.clQ = null;
        this.clR = null;
        this.clS = null;
        this.clU = null;
        this.clV = null;
        this.clW = null;
        this.clX = null;
        this.clY = null;
        this.clZ = null;
        this.cma = null;
        this.cmb = null;
        this.cmc = null;
        this.ckm = bVar;
        this.env = new com.baidu.swan.games.h.a();
        amW();
    }

    private void amW() {
        this.clS = new com.baidu.swan.games.m.b(this.ckm);
    }

    public void b(JsObject jsObject) {
        this.clP = jsObject;
    }

    @JavascriptInterface
    public void setPreferredFramesPerSecond(short s) {
        if (s >= 1 && s <= 60) {
            this.ckm.setPreferredFramesPerSecond(s);
        }
    }

    @JavascriptInterface
    public e getOpenDataContext() {
        if (this.clQ == null) {
            this.clQ = new e(this.ckm);
            this.clQ.canvas = this.clP;
            this.clP = null;
        }
        return this.clQ;
    }

    @JavascriptInterface
    public d getFileSystemManager() {
        if (this.clM == null) {
            this.clM = new d((com.baidu.swan.games.e.a) this.ckm);
        }
        return this.clM;
    }

    @JavascriptInterface
    public com.baidu.swan.games.x.c loadSubpackage(JsObject jsObject) {
        com.baidu.swan.games.x.c cVar = new com.baidu.swan.games.x.c(this.ckm);
        cVar.l(jsObject);
        return cVar;
    }

    @JavascriptInterface
    public void exit(JsObject jsObject) {
        if (DEBUG) {
            this.ckm.anB().log("exit from java side.");
        }
        if (jsObject != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            com.baidu.swan.games.binding.model.a f = com.baidu.swan.games.binding.model.a.f(com.baidu.swan.games.binding.model.c.c(jsObject));
            SwanAppActivity WG = f.WV().WG();
            if (WG == null) {
                bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "failed");
                f.S(bVar);
                return;
            }
            bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "ok");
            f.onSuccess(bVar);
            if (Build.VERSION.SDK_INT >= 21) {
                WG.finishAndRemoveTask();
            } else {
                WG.finish();
            }
        }
    }

    @JavascriptInterface
    public void reload(JsObject jsObject) {
        if (this.cmb == null) {
            this.cmb = new com.baidu.swan.games.r.a();
        }
        this.cmb.reload(jsObject);
    }

    @JavascriptInterface
    public void reload() {
        reload(null);
    }

    @JavascriptInterface
    public com.baidu.swan.games.q.d getOpenData() {
        if (this.clN == null) {
            this.clN = new com.baidu.swan.games.q.d((com.baidu.swan.games.e.a) this.ckm);
        }
        return this.clN;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        if (this.clO == null) {
            this.clO = new com.baidu.swan.games.q.b(this.ckm);
        }
        this.clO.checkIsUserAdvisedToRest(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.c createRewardedVideoAd(JsObject jsObject) {
        if (this.clV == null) {
            this.clV = com.baidu.swan.apps.w.a.UB().a(this.ckm, jsObject);
            if (this.clV == null) {
                this.clV = new com.baidu.swan.games.a.a();
            }
        }
        return this.clV;
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.button.userinfo.b createUserInfoButton(JsObject jsObject) {
        return new com.baidu.swan.games.view.button.userinfo.b(jsObject, this.ckm);
    }

    @JavascriptInterface
    public void showKeyboard(JsObject jsObject) {
        if (this.clR == null) {
            this.clR = new com.baidu.swan.games.m.a(this.ckm, this.clS);
        }
        this.clR.showKeyboard(jsObject);
    }

    @JavascriptInterface
    public void showKeyboard() {
        if (this.clR == null) {
            this.clR = new com.baidu.swan.games.m.a(this.ckm, this.clS);
        }
        this.clR.showKeyboard(null);
    }

    @JavascriptInterface
    public void updateKeyboard(JsObject jsObject) {
        if (this.clR != null) {
            this.clR.updateKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void updateKeyboard() {
        if (this.clR != null) {
            this.clR.updateKeyboard(null);
        }
    }

    @JavascriptInterface
    public void hideKeyboard(JsObject jsObject) {
        if (this.clR != null) {
            this.clR.hideKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void hideKeyboard() {
        if (this.clR != null) {
            this.clR.hideKeyboard(null);
        }
    }

    @JavascriptInterface
    public void getStorage(JsObject jsObject) {
        amX().getStorage(jsObject);
    }

    @JavascriptInterface
    public Object getStorageSync(String str) {
        return com.baidu.swan.games.v.a.d.a(this.ckm, "getStorageSync", str, amX().pF(str));
    }

    @JavascriptInterface
    public void setStorage(JsObject jsObject) {
        amX().setStorage(jsObject);
    }

    @JavascriptInterface
    public void setStorageSync(String str, JsSerializeValue jsSerializeValue) {
        com.baidu.swan.games.v.a.d.a(this.ckm, "setStorageSync", str, amX().a(str, jsSerializeValue));
    }

    @JavascriptInterface
    public void setStorageSync(String str) {
        com.baidu.swan.games.v.a.d.a(this.ckm, "setStorageSync", str, amX().a(str, (JsSerializeValue) null));
    }

    @JavascriptInterface
    public void removeStorage(JsObject jsObject) {
        amX().removeStorage(jsObject);
    }

    @JavascriptInterface
    public void removeStorageSync(String str) {
        com.baidu.swan.games.v.a.d.a(this.ckm, "removeStorageSync", str, amX().pG(str));
    }

    @JavascriptInterface
    public void clearStorage(JsObject jsObject) {
        amX().clearStorage(jsObject);
    }

    @JavascriptInterface
    public void clearStorageSync() {
        com.baidu.swan.games.v.a.d.a(this.ckm, "clearStorageSync", "", amX().apQ());
    }

    @JavascriptInterface
    public void getStorageInfo(JsObject jsObject) {
        amX().getStorageInfo(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.v.a.c getStorageInfoSync() {
        return amX().getStorageInfoSync();
    }

    @NonNull
    private com.baidu.swan.games.v.a amX() {
        if (this.clT == null) {
            this.clT = new com.baidu.swan.games.v.a(this.ckm);
        }
        return this.clT;
    }

    @JavascriptInterface
    public void setInnerAudioOption(JsObject jsObject) {
        this.clZ = new h(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.audio.g createInnerAudioContext() {
        return new com.baidu.swan.games.audio.g(this.ckm);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.b createBannerAd(JsObject jsObject) {
        return com.baidu.swan.apps.w.a.UB().b(this.ckm, jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.z.d getUpdateManager(JsObject jsObject) {
        if (this.clU == null) {
            this.clU = new com.baidu.swan.games.z.d(jsObject);
        }
        return this.clU;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.websocket.c connectSocket(JsObject jsObject) {
        if (this.clW == null) {
            this.clW = new com.baidu.swan.games.network.websocket.a(this.ckm);
        }
        return this.clW.connectSocket(jsObject);
    }

    @JavascriptInterface
    public void setEnableDebug(JsObject jsObject) {
        if (this.clX == null) {
            this.clX = new g(this.ckm);
        }
        this.clX.setEnableDebug(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.c.c request(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        com.baidu.swan.games.network.a a = com.baidu.swan.games.network.b.d.aoW().a(this.ckm, c, 1);
        if (a instanceof com.baidu.swan.games.network.c.c) {
            com.baidu.swan.games.network.c.c cVar = (com.baidu.swan.games.network.c.c) a;
            cVar.j(c);
            return cVar;
        }
        com.baidu.swan.games.network.c.c cVar2 = new com.baidu.swan.games.network.c.c(this.ckm, c);
        cVar2.start();
        return cVar2;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.d.b uploadFile(JsObject jsObject) {
        com.baidu.swan.games.network.d.b bVar = new com.baidu.swan.games.network.d.b(this.ckm, com.baidu.swan.games.binding.model.c.c(jsObject));
        bVar.start();
        return bVar;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.a.b downloadFile(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        com.baidu.swan.games.network.a a = com.baidu.swan.games.network.b.d.aoW().a(this.ckm, c, 2);
        if (a instanceof com.baidu.swan.games.network.a.b) {
            com.baidu.swan.games.network.a.b bVar = (com.baidu.swan.games.network.a.b) a;
            bVar.j(c);
            return bVar;
        }
        com.baidu.swan.games.network.a.b bVar2 = new com.baidu.swan.games.network.a.b(this.ckm, c);
        bVar2.start();
        return bVar2;
    }

    @JavascriptInterface
    public void openCustomerServiceConversation(JsObject jsObject) {
        com.baidu.swan.games.c.a.a((c) this.ckm.anz(), jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.screenrecord.a getVideoRecorderManager() {
        if (this.clY == null) {
            this.clY = new com.baidu.swan.games.screenrecord.a(this.ckm);
        }
        return this.clY;
    }

    @JavascriptInterface
    public void shareVideo(JsObject jsObject) {
        new com.baidu.swan.games.t.b.a(jsObject).NU();
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return com.baidu.swan.apps.jsbridge.a.b.getEnvVariables();
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton(JsObject jsObject) {
        return new RecommendButtonApiProxy(this.ckm, jsObject);
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton() {
        return createRecommendationButton(null);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide(JsObject jsObject) {
        if (this.cma == null) {
            this.cma = new DesktopGuideApi(this.ckm);
        }
        this.cma.o(jsObject);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide() {
        showAddToDesktopGuide(null);
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.webview.a getWebViewManager() {
        if (this.cmc == null) {
            this.cmc = new com.baidu.swan.games.view.webview.a(this.ckm);
        }
        return this.cmc;
    }

    @JavascriptInterface
    public void getUUAPInfo(JsObject jsObject) {
        com.baidu.swan.games.aa.a.getUUAPInfo(jsObject);
    }

    @JavascriptInterface
    public String getAPIs(int i) {
        return DEBUG ? com.baidu.swan.apps.ah.a.a.aaI() ? SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i) : "" : com.baidu.swan.apps.w.a.Uc().Hk() ? SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i) : "";
    }

    @JavascriptInterface
    public void authorizeEval(JsObject jsObject) {
        com.baidu.swan.games.f.a.authorizeEval(jsObject);
    }

    @JavascriptInterface
    public void menuItemCtrl(JsObject jsObject) {
        com.baidu.swan.games.p.a WK = f.WV().WK();
        if (WK != null) {
            WK.i(com.baidu.swan.games.binding.model.c.c(jsObject));
        }
    }
}
