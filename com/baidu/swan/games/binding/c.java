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
    private com.baidu.swan.games.f.b dQV;
    private e dSD;
    private d dSE;
    private com.baidu.swan.games.r.b dSF;
    private JsObject dSG;
    private com.baidu.swan.games.r.e dSH;
    private com.baidu.swan.games.n.a dSI;
    private com.baidu.swan.games.n.b dSJ;
    private com.baidu.swan.games.w.a dSK;
    private com.baidu.swan.games.aa.d dSL;
    private com.baidu.swan.games.a.c dSM;
    private com.baidu.swan.games.network.websocket.a dSN;
    private g dSO;
    private com.baidu.swan.games.screenrecord.a dSP;
    private h dSQ;
    private DesktopGuideApi dSR;
    private com.baidu.swan.games.s.a dSS;
    private com.baidu.swan.games.view.webview.a dST;
    private com.baidu.swan.games.b.b dSU;
    @V8JavascriptField
    public final String domain;
    @V8JavascriptField
    public com.baidu.swan.games.i.a env;

    public c(com.baidu.swan.games.f.b bVar) {
        super(bVar);
        this.domain = "main";
        this.dSG = null;
        this.dSH = null;
        this.dSI = null;
        this.dSJ = null;
        this.dSL = null;
        this.dSM = null;
        this.dSN = null;
        this.dSO = null;
        this.dSP = null;
        this.dSQ = null;
        this.dSR = null;
        this.dSS = null;
        this.dST = null;
        this.dSU = null;
        this.dQV = bVar;
        this.env = new com.baidu.swan.games.i.a();
        aUm();
    }

    private void aUm() {
        this.dSJ = new com.baidu.swan.games.n.b(this.dQV);
    }

    public void d(JsObject jsObject) {
        this.dSG = jsObject;
    }

    @JavascriptInterface
    public void setPreferredFramesPerSecond(short s) {
        if (s >= 1 && s <= 60) {
            this.dQV.setPreferredFramesPerSecond(s);
        }
    }

    @JavascriptInterface
    public com.baidu.swan.games.r.e getOpenDataContext() {
        if (this.dSH == null) {
            this.dSH = new com.baidu.swan.games.r.e(this.dQV);
            this.dSH.canvas = this.dSG;
            this.dSG = null;
        }
        return this.dSH;
    }

    @JavascriptInterface
    public e getFileSystemManager() {
        if (this.dSD == null) {
            this.dSD = new e((com.baidu.swan.games.f.a) this.dQV);
        }
        return this.dSD;
    }

    @JavascriptInterface
    public com.baidu.swan.games.y.c loadSubpackage(JsObject jsObject) {
        com.baidu.swan.games.y.c cVar = new com.baidu.swan.games.y.c(this.dQV);
        cVar.n(jsObject);
        return cVar;
    }

    @JavascriptInterface
    public void exit(JsObject jsObject) {
        if (DEBUG) {
            this.dQV.aUR().log("exit from java side.");
        }
        if (jsObject != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            com.baidu.swan.games.binding.model.a f = com.baidu.swan.games.binding.model.a.f(com.baidu.swan.games.binding.model.c.e(jsObject));
            SwanAppActivity azy = f.azO().azy();
            if (azy == null) {
                bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "failed");
                f.ac(bVar);
                return;
            }
            bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "ok");
            f.onSuccess(bVar);
            if (Build.VERSION.SDK_INT >= 21) {
                azy.finishAndRemoveTask();
            } else {
                azy.finish();
            }
        }
    }

    @JavascriptInterface
    public void reload(JsObject jsObject) {
        if (this.dSS == null) {
            this.dSS = new com.baidu.swan.games.s.a();
        }
        this.dSS.reload(jsObject);
    }

    @JavascriptInterface
    public void reload() {
        reload(null);
    }

    @JavascriptInterface
    public d getOpenData() {
        if (this.dSE == null) {
            this.dSE = new d((com.baidu.swan.games.f.a) this.dQV);
        }
        return this.dSE;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        if (this.dSF == null) {
            this.dSF = new com.baidu.swan.games.r.b(this.dQV);
        }
        this.dSF.checkIsUserAdvisedToRest(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.c createRewardedVideoAd(JsObject jsObject) {
        if (this.dSM == null) {
            this.dSM = com.baidu.swan.apps.t.a.axd().a(this.dQV, jsObject);
            if (this.dSM == null) {
                this.dSM = new com.baidu.swan.games.a.a();
            }
        }
        return this.dSM;
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.button.userinfo.b createUserInfoButton(JsObject jsObject) {
        return new com.baidu.swan.games.view.button.userinfo.b(jsObject, this.dQV);
    }

    @JavascriptInterface
    public void showKeyboard(JsObject jsObject) {
        if (this.dSI == null) {
            this.dSI = new com.baidu.swan.games.n.a(this.dQV, this.dSJ);
        }
        this.dSI.showKeyboard(jsObject);
    }

    @JavascriptInterface
    public void showKeyboard() {
        if (this.dSI == null) {
            this.dSI = new com.baidu.swan.games.n.a(this.dQV, this.dSJ);
        }
        this.dSI.showKeyboard(null);
    }

    @JavascriptInterface
    public void updateKeyboard(JsObject jsObject) {
        if (this.dSI != null) {
            this.dSI.updateKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void updateKeyboard() {
        if (this.dSI != null) {
            this.dSI.updateKeyboard(null);
        }
    }

    @JavascriptInterface
    public void hideKeyboard(JsObject jsObject) {
        if (this.dSI != null) {
            this.dSI.hideKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void hideKeyboard() {
        if (this.dSI != null) {
            this.dSI.hideKeyboard(null);
        }
    }

    @JavascriptInterface
    public void getStorage(JsObject jsObject) {
        aUn().getStorage(jsObject);
    }

    @JavascriptInterface
    public Object getStorageSync(String str) {
        return com.baidu.swan.games.w.a.d.a(this.dQV, "getStorageSync", str, aUn().xF(str));
    }

    @JavascriptInterface
    public void setStorage(JsObject jsObject) {
        aUn().setStorage(jsObject);
    }

    @JavascriptInterface
    public void setStorageSync(String str, JsSerializeValue jsSerializeValue) {
        com.baidu.swan.games.w.a.d.a(this.dQV, "setStorageSync", str, aUn().a(str, jsSerializeValue));
    }

    @JavascriptInterface
    public void setStorageSync(String str) {
        com.baidu.swan.games.w.a.d.a(this.dQV, "setStorageSync", str, aUn().a(str, (JsSerializeValue) null));
    }

    @JavascriptInterface
    public void removeStorage(JsObject jsObject) {
        aUn().removeStorage(jsObject);
    }

    @JavascriptInterface
    public void removeStorageSync(String str) {
        com.baidu.swan.games.w.a.d.a(this.dQV, "removeStorageSync", str, aUn().xG(str));
    }

    @JavascriptInterface
    public void clearStorage(JsObject jsObject) {
        aUn().clearStorage(jsObject);
    }

    @JavascriptInterface
    public void clearStorageSync() {
        com.baidu.swan.games.w.a.d.a(this.dQV, "clearStorageSync", "", aUn().aXl());
    }

    @JavascriptInterface
    public void getStorageInfo(JsObject jsObject) {
        aUn().getStorageInfo(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.w.a.c getStorageInfoSync() {
        return aUn().getStorageInfoSync();
    }

    @NonNull
    private com.baidu.swan.games.w.a aUn() {
        if (this.dSK == null) {
            this.dSK = new com.baidu.swan.games.w.a(this.dQV);
        }
        return this.dSK;
    }

    @JavascriptInterface
    public void setInnerAudioOption(JsObject jsObject) {
        this.dSQ = new h(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.audio.g createInnerAudioContext() {
        return new com.baidu.swan.games.audio.g(this.dQV);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.b createBannerAd(JsObject jsObject) {
        return com.baidu.swan.apps.t.a.axd().b(this.dQV, jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.aa.d getUpdateManager(JsObject jsObject) {
        if (this.dSL == null) {
            this.dSL = new com.baidu.swan.games.aa.d(jsObject);
        }
        return this.dSL;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.websocket.c connectSocket(JsObject jsObject) {
        if (this.dSN == null) {
            this.dSN = new com.baidu.swan.games.network.websocket.a(this.dQV);
        }
        return this.dSN.connectSocket(jsObject);
    }

    @JavascriptInterface
    public void setEnableDebug(JsObject jsObject) {
        if (this.dSO == null) {
            this.dSO = new g(this.dQV);
        }
        this.dSO.setEnableDebug(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.c.c request(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        com.baidu.swan.games.network.a a2 = com.baidu.swan.games.network.b.d.aWs().a(this.dQV, e, 1);
        if (a2 instanceof com.baidu.swan.games.network.c.c) {
            com.baidu.swan.games.network.c.c cVar = (com.baidu.swan.games.network.c.c) a2;
            cVar.j(e);
            return cVar;
        }
        com.baidu.swan.games.network.c.c cVar2 = new com.baidu.swan.games.network.c.c(this.dQV, e);
        cVar2.start();
        return cVar2;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.d.b uploadFile(JsObject jsObject) {
        com.baidu.swan.games.network.d.b bVar = new com.baidu.swan.games.network.d.b(this.dQV, com.baidu.swan.games.binding.model.c.e(jsObject));
        bVar.start();
        return bVar;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.a.b downloadFile(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        com.baidu.swan.games.network.a a2 = com.baidu.swan.games.network.b.d.aWs().a(this.dQV, e, 2);
        if (a2 instanceof com.baidu.swan.games.network.a.b) {
            com.baidu.swan.games.network.a.b bVar = (com.baidu.swan.games.network.a.b) a2;
            bVar.j(e);
            return bVar;
        }
        com.baidu.swan.games.network.a.b bVar2 = new com.baidu.swan.games.network.a.b(this.dQV, e);
        bVar2.start();
        return bVar2;
    }

    @JavascriptInterface
    public void openCustomerServiceConversation(JsObject jsObject) {
        com.baidu.swan.games.d.a.a((c) this.dQV.aUP(), jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.screenrecord.a getVideoRecorderManager() {
        if (this.dSP == null) {
            this.dSP = new com.baidu.swan.games.screenrecord.a(this.dQV);
        }
        return this.dSP;
    }

    @JavascriptInterface
    public void shareVideo(JsObject jsObject) {
        new com.baidu.swan.games.u.b.a(jsObject).anT();
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return com.baidu.swan.apps.jsbridge.a.b.f(this.dQV);
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton(JsObject jsObject) {
        return new RecommendButtonApiProxy(this.dQV, jsObject);
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton() {
        return createRecommendationButton(null);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide(JsObject jsObject) {
        if (this.dSR == null) {
            this.dSR = new DesktopGuideApi(this.dQV);
        }
        this.dSR.q(jsObject);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide() {
        showAddToDesktopGuide(null);
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.webview.a getWebViewManager() {
        if (this.dST == null) {
            this.dST = new com.baidu.swan.games.view.webview.a(this.dQV);
        }
        return this.dST;
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
        com.baidu.swan.games.q.a azC = f.azO().azC();
        if (azC != null) {
            azC.i(com.baidu.swan.games.binding.model.c.e(jsObject));
        }
    }

    @JavascriptInterface
    public com.baidu.swan.games.b.b getAntiAddiction() {
        if (this.dSU == null) {
            this.dSU = new com.baidu.swan.games.b.b(this.dQV);
        }
        return this.dSU;
    }
}
