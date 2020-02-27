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
import com.baidu.swan.games.q.d;
import com.baidu.swan.games.q.e;
import com.baidu.swan.games.view.desktopguide.DesktopGuideApi;
import com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy;
/* loaded from: classes11.dex */
public final class c extends EventTargetImpl {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.e.b cjZ;
    private d clA;
    private com.baidu.swan.games.q.b clB;
    private JsObject clC;
    private e clD;
    private com.baidu.swan.games.m.a clE;
    private com.baidu.swan.games.m.b clF;
    private com.baidu.swan.games.v.a clG;
    private com.baidu.swan.games.z.d clH;
    private com.baidu.swan.games.a.c clI;
    private com.baidu.swan.games.network.websocket.a clJ;
    private g clK;
    private com.baidu.swan.games.screenrecord.a clL;
    private h clM;
    private DesktopGuideApi clN;
    private com.baidu.swan.games.r.a clO;
    private com.baidu.swan.games.view.webview.a clP;
    private com.baidu.swan.games.h.d clz;
    @V8JavascriptField
    public final String domain;
    @V8JavascriptField
    public com.baidu.swan.games.h.a env;

    public c(com.baidu.swan.games.e.b bVar) {
        super(bVar);
        this.domain = "main";
        this.clC = null;
        this.clD = null;
        this.clE = null;
        this.clF = null;
        this.clH = null;
        this.clI = null;
        this.clJ = null;
        this.clK = null;
        this.clL = null;
        this.clM = null;
        this.clN = null;
        this.clO = null;
        this.clP = null;
        this.cjZ = bVar;
        this.env = new com.baidu.swan.games.h.a();
        amR();
    }

    private void amR() {
        this.clF = new com.baidu.swan.games.m.b(this.cjZ);
    }

    public void b(JsObject jsObject) {
        this.clC = jsObject;
    }

    @JavascriptInterface
    public void setPreferredFramesPerSecond(short s) {
        if (s >= 1 && s <= 60) {
            this.cjZ.setPreferredFramesPerSecond(s);
        }
    }

    @JavascriptInterface
    public e getOpenDataContext() {
        if (this.clD == null) {
            this.clD = new e(this.cjZ);
            this.clD.canvas = this.clC;
            this.clC = null;
        }
        return this.clD;
    }

    @JavascriptInterface
    public com.baidu.swan.games.h.d getFileSystemManager() {
        if (this.clz == null) {
            this.clz = new com.baidu.swan.games.h.d((com.baidu.swan.games.e.a) this.cjZ);
        }
        return this.clz;
    }

    @JavascriptInterface
    public com.baidu.swan.games.x.c loadSubpackage(JsObject jsObject) {
        com.baidu.swan.games.x.c cVar = new com.baidu.swan.games.x.c(this.cjZ);
        cVar.l(jsObject);
        return cVar;
    }

    @JavascriptInterface
    public void exit(JsObject jsObject) {
        if (DEBUG) {
            this.cjZ.anw().log("exit from java side.");
        }
        if (jsObject != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            com.baidu.swan.games.binding.model.a f = com.baidu.swan.games.binding.model.a.f(com.baidu.swan.games.binding.model.c.c(jsObject));
            SwanAppActivity WB = f.WQ().WB();
            if (WB == null) {
                bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "failed");
                f.S(bVar);
                return;
            }
            bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "ok");
            f.onSuccess(bVar);
            if (Build.VERSION.SDK_INT >= 21) {
                WB.finishAndRemoveTask();
            } else {
                WB.finish();
            }
        }
    }

    @JavascriptInterface
    public void reload(JsObject jsObject) {
        if (this.clO == null) {
            this.clO = new com.baidu.swan.games.r.a();
        }
        this.clO.reload(jsObject);
    }

    @JavascriptInterface
    public void reload() {
        reload(null);
    }

    @JavascriptInterface
    public d getOpenData() {
        if (this.clA == null) {
            this.clA = new d((com.baidu.swan.games.e.a) this.cjZ);
        }
        return this.clA;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        if (this.clB == null) {
            this.clB = new com.baidu.swan.games.q.b(this.cjZ);
        }
        this.clB.checkIsUserAdvisedToRest(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.c createRewardedVideoAd(JsObject jsObject) {
        if (this.clI == null) {
            this.clI = com.baidu.swan.apps.w.a.Uw().a(this.cjZ, jsObject);
            if (this.clI == null) {
                this.clI = new com.baidu.swan.games.a.a();
            }
        }
        return this.clI;
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.button.userinfo.b createUserInfoButton(JsObject jsObject) {
        return new com.baidu.swan.games.view.button.userinfo.b(jsObject, this.cjZ);
    }

    @JavascriptInterface
    public void showKeyboard(JsObject jsObject) {
        if (this.clE == null) {
            this.clE = new com.baidu.swan.games.m.a(this.cjZ, this.clF);
        }
        this.clE.showKeyboard(jsObject);
    }

    @JavascriptInterface
    public void showKeyboard() {
        if (this.clE == null) {
            this.clE = new com.baidu.swan.games.m.a(this.cjZ, this.clF);
        }
        this.clE.showKeyboard(null);
    }

    @JavascriptInterface
    public void updateKeyboard(JsObject jsObject) {
        if (this.clE != null) {
            this.clE.updateKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void updateKeyboard() {
        if (this.clE != null) {
            this.clE.updateKeyboard(null);
        }
    }

    @JavascriptInterface
    public void hideKeyboard(JsObject jsObject) {
        if (this.clE != null) {
            this.clE.hideKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void hideKeyboard() {
        if (this.clE != null) {
            this.clE.hideKeyboard(null);
        }
    }

    @JavascriptInterface
    public void getStorage(JsObject jsObject) {
        amS().getStorage(jsObject);
    }

    @JavascriptInterface
    public Object getStorageSync(String str) {
        return com.baidu.swan.games.v.a.d.a(this.cjZ, "getStorageSync", str, amS().pG(str));
    }

    @JavascriptInterface
    public void setStorage(JsObject jsObject) {
        amS().setStorage(jsObject);
    }

    @JavascriptInterface
    public void setStorageSync(String str, JsSerializeValue jsSerializeValue) {
        com.baidu.swan.games.v.a.d.a(this.cjZ, "setStorageSync", str, amS().a(str, jsSerializeValue));
    }

    @JavascriptInterface
    public void setStorageSync(String str) {
        com.baidu.swan.games.v.a.d.a(this.cjZ, "setStorageSync", str, amS().a(str, (JsSerializeValue) null));
    }

    @JavascriptInterface
    public void removeStorage(JsObject jsObject) {
        amS().removeStorage(jsObject);
    }

    @JavascriptInterface
    public void removeStorageSync(String str) {
        com.baidu.swan.games.v.a.d.a(this.cjZ, "removeStorageSync", str, amS().pH(str));
    }

    @JavascriptInterface
    public void clearStorage(JsObject jsObject) {
        amS().clearStorage(jsObject);
    }

    @JavascriptInterface
    public void clearStorageSync() {
        com.baidu.swan.games.v.a.d.a(this.cjZ, "clearStorageSync", "", amS().apL());
    }

    @JavascriptInterface
    public void getStorageInfo(JsObject jsObject) {
        amS().getStorageInfo(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.v.a.c getStorageInfoSync() {
        return amS().getStorageInfoSync();
    }

    @NonNull
    private com.baidu.swan.games.v.a amS() {
        if (this.clG == null) {
            this.clG = new com.baidu.swan.games.v.a(this.cjZ);
        }
        return this.clG;
    }

    @JavascriptInterface
    public void setInnerAudioOption(JsObject jsObject) {
        this.clM = new h(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.audio.g createInnerAudioContext() {
        return new com.baidu.swan.games.audio.g(this.cjZ);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.b createBannerAd(JsObject jsObject) {
        return com.baidu.swan.apps.w.a.Uw().b(this.cjZ, jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.z.d getUpdateManager(JsObject jsObject) {
        if (this.clH == null) {
            this.clH = new com.baidu.swan.games.z.d(jsObject);
        }
        return this.clH;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.websocket.c connectSocket(JsObject jsObject) {
        if (this.clJ == null) {
            this.clJ = new com.baidu.swan.games.network.websocket.a(this.cjZ);
        }
        return this.clJ.connectSocket(jsObject);
    }

    @JavascriptInterface
    public void setEnableDebug(JsObject jsObject) {
        if (this.clK == null) {
            this.clK = new g(this.cjZ);
        }
        this.clK.setEnableDebug(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.c.c request(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        com.baidu.swan.games.network.a a = com.baidu.swan.games.network.b.d.aoR().a(this.cjZ, c, 1);
        if (a instanceof com.baidu.swan.games.network.c.c) {
            com.baidu.swan.games.network.c.c cVar = (com.baidu.swan.games.network.c.c) a;
            cVar.j(c);
            return cVar;
        }
        com.baidu.swan.games.network.c.c cVar2 = new com.baidu.swan.games.network.c.c(this.cjZ, c);
        cVar2.start();
        return cVar2;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.d.b uploadFile(JsObject jsObject) {
        com.baidu.swan.games.network.d.b bVar = new com.baidu.swan.games.network.d.b(this.cjZ, com.baidu.swan.games.binding.model.c.c(jsObject));
        bVar.start();
        return bVar;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.a.b downloadFile(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        com.baidu.swan.games.network.a a = com.baidu.swan.games.network.b.d.aoR().a(this.cjZ, c, 2);
        if (a instanceof com.baidu.swan.games.network.a.b) {
            com.baidu.swan.games.network.a.b bVar = (com.baidu.swan.games.network.a.b) a;
            bVar.j(c);
            return bVar;
        }
        com.baidu.swan.games.network.a.b bVar2 = new com.baidu.swan.games.network.a.b(this.cjZ, c);
        bVar2.start();
        return bVar2;
    }

    @JavascriptInterface
    public void openCustomerServiceConversation(JsObject jsObject) {
        com.baidu.swan.games.c.a.a((c) this.cjZ.anu(), jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.screenrecord.a getVideoRecorderManager() {
        if (this.clL == null) {
            this.clL = new com.baidu.swan.games.screenrecord.a(this.cjZ);
        }
        return this.clL;
    }

    @JavascriptInterface
    public void shareVideo(JsObject jsObject) {
        new com.baidu.swan.games.t.b.a(jsObject).NP();
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return com.baidu.swan.apps.jsbridge.a.b.getEnvVariables();
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton(JsObject jsObject) {
        return new RecommendButtonApiProxy(this.cjZ, jsObject);
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton() {
        return createRecommendationButton(null);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide(JsObject jsObject) {
        if (this.clN == null) {
            this.clN = new DesktopGuideApi(this.cjZ);
        }
        this.clN.o(jsObject);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide() {
        showAddToDesktopGuide(null);
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.webview.a getWebViewManager() {
        if (this.clP == null) {
            this.clP = new com.baidu.swan.games.view.webview.a(this.cjZ);
        }
        return this.clP;
    }

    @JavascriptInterface
    public void getUUAPInfo(JsObject jsObject) {
        com.baidu.swan.games.aa.a.getUUAPInfo(jsObject);
    }

    @JavascriptInterface
    public String getAPIs(int i) {
        return DEBUG ? com.baidu.swan.apps.ah.a.a.aaD() ? SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i) : "" : com.baidu.swan.apps.w.a.TX().Hd() ? SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i) : "";
    }

    @JavascriptInterface
    public void authorizeEval(JsObject jsObject) {
        com.baidu.swan.games.f.a.authorizeEval(jsObject);
    }

    @JavascriptInterface
    public void menuItemCtrl(JsObject jsObject) {
        com.baidu.swan.games.p.a WF = f.WQ().WF();
        if (WF != null) {
            WF.i(com.baidu.swan.games.binding.model.c.c(jsObject));
        }
    }
}
