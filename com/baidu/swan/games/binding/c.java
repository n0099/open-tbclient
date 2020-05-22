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
    private com.baidu.swan.games.f.b cTU;
    private e cVB;
    private d cVC;
    private com.baidu.swan.games.r.b cVD;
    private JsObject cVE;
    private com.baidu.swan.games.r.e cVF;
    private com.baidu.swan.games.n.a cVG;
    private com.baidu.swan.games.n.b cVH;
    private com.baidu.swan.games.w.a cVI;
    private com.baidu.swan.games.aa.d cVJ;
    private com.baidu.swan.games.a.c cVK;
    private com.baidu.swan.games.network.websocket.a cVL;
    private g cVM;
    private com.baidu.swan.games.screenrecord.a cVN;
    private h cVO;
    private DesktopGuideApi cVP;
    private com.baidu.swan.games.s.a cVQ;
    private com.baidu.swan.games.view.webview.a cVR;
    private com.baidu.swan.games.b.b cVS;
    @V8JavascriptField
    public final String domain;
    @V8JavascriptField
    public com.baidu.swan.games.i.a env;

    public c(com.baidu.swan.games.f.b bVar) {
        super(bVar);
        this.domain = "main";
        this.cVE = null;
        this.cVF = null;
        this.cVG = null;
        this.cVH = null;
        this.cVJ = null;
        this.cVK = null;
        this.cVL = null;
        this.cVM = null;
        this.cVN = null;
        this.cVO = null;
        this.cVP = null;
        this.cVQ = null;
        this.cVR = null;
        this.cVS = null;
        this.cTU = bVar;
        this.env = new com.baidu.swan.games.i.a();
        ayY();
    }

    private void ayY() {
        this.cVH = new com.baidu.swan.games.n.b(this.cTU);
    }

    public void d(JsObject jsObject) {
        this.cVE = jsObject;
    }

    @JavascriptInterface
    public void setPreferredFramesPerSecond(short s) {
        if (s >= 1 && s <= 60) {
            this.cTU.setPreferredFramesPerSecond(s);
        }
    }

    @JavascriptInterface
    public com.baidu.swan.games.r.e getOpenDataContext() {
        if (this.cVF == null) {
            this.cVF = new com.baidu.swan.games.r.e(this.cTU);
            this.cVF.canvas = this.cVE;
            this.cVE = null;
        }
        return this.cVF;
    }

    @JavascriptInterface
    public e getFileSystemManager() {
        if (this.cVB == null) {
            this.cVB = new e((com.baidu.swan.games.f.a) this.cTU);
        }
        return this.cVB;
    }

    @JavascriptInterface
    public com.baidu.swan.games.y.c loadSubpackage(JsObject jsObject) {
        com.baidu.swan.games.y.c cVar = new com.baidu.swan.games.y.c(this.cTU);
        cVar.n(jsObject);
        return cVar;
    }

    @JavascriptInterface
    public void exit(JsObject jsObject) {
        if (DEBUG) {
            this.cTU.azD().log("exit from java side.");
        }
        if (jsObject != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            com.baidu.swan.games.binding.model.a f = com.baidu.swan.games.binding.model.a.f(com.baidu.swan.games.binding.model.c.e(jsObject));
            SwanAppActivity ahF = f.ahV().ahF();
            if (ahF == null) {
                bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "failed");
                f.Y(bVar);
                return;
            }
            bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "ok");
            f.onSuccess(bVar);
            if (Build.VERSION.SDK_INT >= 21) {
                ahF.finishAndRemoveTask();
            } else {
                ahF.finish();
            }
        }
    }

    @JavascriptInterface
    public void reload(JsObject jsObject) {
        if (this.cVQ == null) {
            this.cVQ = new com.baidu.swan.games.s.a();
        }
        this.cVQ.reload(jsObject);
    }

    @JavascriptInterface
    public void reload() {
        reload(null);
    }

    @JavascriptInterface
    public d getOpenData() {
        if (this.cVC == null) {
            this.cVC = new d((com.baidu.swan.games.f.a) this.cTU);
        }
        return this.cVC;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        if (this.cVD == null) {
            this.cVD = new com.baidu.swan.games.r.b(this.cTU);
        }
        this.cVD.checkIsUserAdvisedToRest(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.c createRewardedVideoAd(JsObject jsObject) {
        if (this.cVK == null) {
            this.cVK = com.baidu.swan.apps.u.a.afs().a(this.cTU, jsObject);
            if (this.cVK == null) {
                this.cVK = new com.baidu.swan.games.a.a();
            }
        }
        return this.cVK;
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.button.userinfo.b createUserInfoButton(JsObject jsObject) {
        return new com.baidu.swan.games.view.button.userinfo.b(jsObject, this.cTU);
    }

    @JavascriptInterface
    public void showKeyboard(JsObject jsObject) {
        if (this.cVG == null) {
            this.cVG = new com.baidu.swan.games.n.a(this.cTU, this.cVH);
        }
        this.cVG.showKeyboard(jsObject);
    }

    @JavascriptInterface
    public void showKeyboard() {
        if (this.cVG == null) {
            this.cVG = new com.baidu.swan.games.n.a(this.cTU, this.cVH);
        }
        this.cVG.showKeyboard(null);
    }

    @JavascriptInterface
    public void updateKeyboard(JsObject jsObject) {
        if (this.cVG != null) {
            this.cVG.updateKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void updateKeyboard() {
        if (this.cVG != null) {
            this.cVG.updateKeyboard(null);
        }
    }

    @JavascriptInterface
    public void hideKeyboard(JsObject jsObject) {
        if (this.cVG != null) {
            this.cVG.hideKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void hideKeyboard() {
        if (this.cVG != null) {
            this.cVG.hideKeyboard(null);
        }
    }

    @JavascriptInterface
    public void getStorage(JsObject jsObject) {
        ayZ().getStorage(jsObject);
    }

    @JavascriptInterface
    public Object getStorageSync(String str) {
        return com.baidu.swan.games.w.a.d.a(this.cTU, "getStorageSync", str, ayZ().sw(str));
    }

    @JavascriptInterface
    public void setStorage(JsObject jsObject) {
        ayZ().setStorage(jsObject);
    }

    @JavascriptInterface
    public void setStorageSync(String str, JsSerializeValue jsSerializeValue) {
        com.baidu.swan.games.w.a.d.a(this.cTU, "setStorageSync", str, ayZ().a(str, jsSerializeValue));
    }

    @JavascriptInterface
    public void setStorageSync(String str) {
        com.baidu.swan.games.w.a.d.a(this.cTU, "setStorageSync", str, ayZ().a(str, (JsSerializeValue) null));
    }

    @JavascriptInterface
    public void removeStorage(JsObject jsObject) {
        ayZ().removeStorage(jsObject);
    }

    @JavascriptInterface
    public void removeStorageSync(String str) {
        com.baidu.swan.games.w.a.d.a(this.cTU, "removeStorageSync", str, ayZ().sx(str));
    }

    @JavascriptInterface
    public void clearStorage(JsObject jsObject) {
        ayZ().clearStorage(jsObject);
    }

    @JavascriptInterface
    public void clearStorageSync() {
        com.baidu.swan.games.w.a.d.a(this.cTU, "clearStorageSync", "", ayZ().aBT());
    }

    @JavascriptInterface
    public void getStorageInfo(JsObject jsObject) {
        ayZ().getStorageInfo(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.w.a.c getStorageInfoSync() {
        return ayZ().getStorageInfoSync();
    }

    @NonNull
    private com.baidu.swan.games.w.a ayZ() {
        if (this.cVI == null) {
            this.cVI = new com.baidu.swan.games.w.a(this.cTU);
        }
        return this.cVI;
    }

    @JavascriptInterface
    public void setInnerAudioOption(JsObject jsObject) {
        this.cVO = new h(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.audio.g createInnerAudioContext() {
        return new com.baidu.swan.games.audio.g(this.cTU);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.b createBannerAd(JsObject jsObject) {
        return com.baidu.swan.apps.u.a.afs().b(this.cTU, jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.aa.d getUpdateManager(JsObject jsObject) {
        if (this.cVJ == null) {
            this.cVJ = new com.baidu.swan.games.aa.d(jsObject);
        }
        return this.cVJ;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.websocket.c connectSocket(JsObject jsObject) {
        if (this.cVL == null) {
            this.cVL = new com.baidu.swan.games.network.websocket.a(this.cTU);
        }
        return this.cVL.connectSocket(jsObject);
    }

    @JavascriptInterface
    public void setEnableDebug(JsObject jsObject) {
        if (this.cVM == null) {
            this.cVM = new g(this.cTU);
        }
        this.cVM.setEnableDebug(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.c.c request(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        com.baidu.swan.games.network.a a = com.baidu.swan.games.network.b.d.aBa().a(this.cTU, e, 1);
        if (a instanceof com.baidu.swan.games.network.c.c) {
            com.baidu.swan.games.network.c.c cVar = (com.baidu.swan.games.network.c.c) a;
            cVar.j(e);
            return cVar;
        }
        com.baidu.swan.games.network.c.c cVar2 = new com.baidu.swan.games.network.c.c(this.cTU, e);
        cVar2.start();
        return cVar2;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.d.b uploadFile(JsObject jsObject) {
        com.baidu.swan.games.network.d.b bVar = new com.baidu.swan.games.network.d.b(this.cTU, com.baidu.swan.games.binding.model.c.e(jsObject));
        bVar.start();
        return bVar;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.a.b downloadFile(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        com.baidu.swan.games.network.a a = com.baidu.swan.games.network.b.d.aBa().a(this.cTU, e, 2);
        if (a instanceof com.baidu.swan.games.network.a.b) {
            com.baidu.swan.games.network.a.b bVar = (com.baidu.swan.games.network.a.b) a;
            bVar.j(e);
            return bVar;
        }
        com.baidu.swan.games.network.a.b bVar2 = new com.baidu.swan.games.network.a.b(this.cTU, e);
        bVar2.start();
        return bVar2;
    }

    @JavascriptInterface
    public void openCustomerServiceConversation(JsObject jsObject) {
        com.baidu.swan.games.d.a.a((c) this.cTU.azB(), jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.screenrecord.a getVideoRecorderManager() {
        if (this.cVN == null) {
            this.cVN = new com.baidu.swan.games.screenrecord.a(this.cTU);
        }
        return this.cVN;
    }

    @JavascriptInterface
    public void shareVideo(JsObject jsObject) {
        new com.baidu.swan.games.u.b.a(jsObject).Ys();
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return com.baidu.swan.apps.jsbridge.a.b.getEnvVariables();
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton(JsObject jsObject) {
        return new RecommendButtonApiProxy(this.cTU, jsObject);
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton() {
        return createRecommendationButton(null);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide(JsObject jsObject) {
        if (this.cVP == null) {
            this.cVP = new DesktopGuideApi(this.cTU);
        }
        this.cVP.q(jsObject);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide() {
        showAddToDesktopGuide(null);
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.webview.a getWebViewManager() {
        if (this.cVR == null) {
            this.cVR = new com.baidu.swan.games.view.webview.a(this.cTU);
        }
        return this.cVR;
    }

    @JavascriptInterface
    public void getUUAPInfo(JsObject jsObject) {
        com.baidu.swan.games.ab.a.getUUAPInfo(jsObject);
    }

    @JavascriptInterface
    public String getAPIs(int i) {
        return DEBUG ? com.baidu.swan.apps.af.a.a.amt() ? SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i) : "" : com.baidu.swan.apps.u.a.aeU().Rh() ? SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i) : "";
    }

    @JavascriptInterface
    public void authorizeEval(JsObject jsObject) {
        com.baidu.swan.games.g.a.authorizeEval(jsObject);
    }

    @JavascriptInterface
    public void menuItemCtrl(JsObject jsObject) {
        com.baidu.swan.games.q.a ahJ = f.ahV().ahJ();
        if (ahJ != null) {
            ahJ.i(com.baidu.swan.games.binding.model.c.e(jsObject));
        }
    }

    @JavascriptInterface
    public com.baidu.swan.games.b.b getAntiAddiction() {
        if (this.cVS == null) {
            this.cVS = new com.baidu.swan.games.b.b(this.cTU);
        }
        return this.cVS;
    }
}
