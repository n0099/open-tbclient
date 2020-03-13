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
    private com.baidu.swan.games.e.b ckb;
    private d clB;
    private com.baidu.swan.games.q.d clC;
    private com.baidu.swan.games.q.b clD;
    private JsObject clE;
    private e clF;
    private com.baidu.swan.games.m.a clG;
    private com.baidu.swan.games.m.b clH;
    private com.baidu.swan.games.v.a clI;
    private com.baidu.swan.games.z.d clJ;
    private com.baidu.swan.games.a.c clK;
    private com.baidu.swan.games.network.websocket.a clL;
    private g clM;
    private com.baidu.swan.games.screenrecord.a clN;
    private h clO;
    private DesktopGuideApi clP;
    private com.baidu.swan.games.r.a clQ;
    private com.baidu.swan.games.view.webview.a clR;
    @V8JavascriptField
    public final String domain;
    @V8JavascriptField
    public com.baidu.swan.games.h.a env;

    public c(com.baidu.swan.games.e.b bVar) {
        super(bVar);
        this.domain = "main";
        this.clE = null;
        this.clF = null;
        this.clG = null;
        this.clH = null;
        this.clJ = null;
        this.clK = null;
        this.clL = null;
        this.clM = null;
        this.clN = null;
        this.clO = null;
        this.clP = null;
        this.clQ = null;
        this.clR = null;
        this.ckb = bVar;
        this.env = new com.baidu.swan.games.h.a();
        amT();
    }

    private void amT() {
        this.clH = new com.baidu.swan.games.m.b(this.ckb);
    }

    public void b(JsObject jsObject) {
        this.clE = jsObject;
    }

    @JavascriptInterface
    public void setPreferredFramesPerSecond(short s) {
        if (s >= 1 && s <= 60) {
            this.ckb.setPreferredFramesPerSecond(s);
        }
    }

    @JavascriptInterface
    public e getOpenDataContext() {
        if (this.clF == null) {
            this.clF = new e(this.ckb);
            this.clF.canvas = this.clE;
            this.clE = null;
        }
        return this.clF;
    }

    @JavascriptInterface
    public d getFileSystemManager() {
        if (this.clB == null) {
            this.clB = new d((com.baidu.swan.games.e.a) this.ckb);
        }
        return this.clB;
    }

    @JavascriptInterface
    public com.baidu.swan.games.x.c loadSubpackage(JsObject jsObject) {
        com.baidu.swan.games.x.c cVar = new com.baidu.swan.games.x.c(this.ckb);
        cVar.l(jsObject);
        return cVar;
    }

    @JavascriptInterface
    public void exit(JsObject jsObject) {
        if (DEBUG) {
            this.ckb.any().log("exit from java side.");
        }
        if (jsObject != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            com.baidu.swan.games.binding.model.a f = com.baidu.swan.games.binding.model.a.f(com.baidu.swan.games.binding.model.c.c(jsObject));
            SwanAppActivity WD = f.WS().WD();
            if (WD == null) {
                bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "failed");
                f.S(bVar);
                return;
            }
            bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "ok");
            f.onSuccess(bVar);
            if (Build.VERSION.SDK_INT >= 21) {
                WD.finishAndRemoveTask();
            } else {
                WD.finish();
            }
        }
    }

    @JavascriptInterface
    public void reload(JsObject jsObject) {
        if (this.clQ == null) {
            this.clQ = new com.baidu.swan.games.r.a();
        }
        this.clQ.reload(jsObject);
    }

    @JavascriptInterface
    public void reload() {
        reload(null);
    }

    @JavascriptInterface
    public com.baidu.swan.games.q.d getOpenData() {
        if (this.clC == null) {
            this.clC = new com.baidu.swan.games.q.d((com.baidu.swan.games.e.a) this.ckb);
        }
        return this.clC;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        if (this.clD == null) {
            this.clD = new com.baidu.swan.games.q.b(this.ckb);
        }
        this.clD.checkIsUserAdvisedToRest(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.c createRewardedVideoAd(JsObject jsObject) {
        if (this.clK == null) {
            this.clK = com.baidu.swan.apps.w.a.Uy().a(this.ckb, jsObject);
            if (this.clK == null) {
                this.clK = new com.baidu.swan.games.a.a();
            }
        }
        return this.clK;
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.button.userinfo.b createUserInfoButton(JsObject jsObject) {
        return new com.baidu.swan.games.view.button.userinfo.b(jsObject, this.ckb);
    }

    @JavascriptInterface
    public void showKeyboard(JsObject jsObject) {
        if (this.clG == null) {
            this.clG = new com.baidu.swan.games.m.a(this.ckb, this.clH);
        }
        this.clG.showKeyboard(jsObject);
    }

    @JavascriptInterface
    public void showKeyboard() {
        if (this.clG == null) {
            this.clG = new com.baidu.swan.games.m.a(this.ckb, this.clH);
        }
        this.clG.showKeyboard(null);
    }

    @JavascriptInterface
    public void updateKeyboard(JsObject jsObject) {
        if (this.clG != null) {
            this.clG.updateKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void updateKeyboard() {
        if (this.clG != null) {
            this.clG.updateKeyboard(null);
        }
    }

    @JavascriptInterface
    public void hideKeyboard(JsObject jsObject) {
        if (this.clG != null) {
            this.clG.hideKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void hideKeyboard() {
        if (this.clG != null) {
            this.clG.hideKeyboard(null);
        }
    }

    @JavascriptInterface
    public void getStorage(JsObject jsObject) {
        amU().getStorage(jsObject);
    }

    @JavascriptInterface
    public Object getStorageSync(String str) {
        return com.baidu.swan.games.v.a.d.a(this.ckb, "getStorageSync", str, amU().pG(str));
    }

    @JavascriptInterface
    public void setStorage(JsObject jsObject) {
        amU().setStorage(jsObject);
    }

    @JavascriptInterface
    public void setStorageSync(String str, JsSerializeValue jsSerializeValue) {
        com.baidu.swan.games.v.a.d.a(this.ckb, "setStorageSync", str, amU().a(str, jsSerializeValue));
    }

    @JavascriptInterface
    public void setStorageSync(String str) {
        com.baidu.swan.games.v.a.d.a(this.ckb, "setStorageSync", str, amU().a(str, (JsSerializeValue) null));
    }

    @JavascriptInterface
    public void removeStorage(JsObject jsObject) {
        amU().removeStorage(jsObject);
    }

    @JavascriptInterface
    public void removeStorageSync(String str) {
        com.baidu.swan.games.v.a.d.a(this.ckb, "removeStorageSync", str, amU().pH(str));
    }

    @JavascriptInterface
    public void clearStorage(JsObject jsObject) {
        amU().clearStorage(jsObject);
    }

    @JavascriptInterface
    public void clearStorageSync() {
        com.baidu.swan.games.v.a.d.a(this.ckb, "clearStorageSync", "", amU().apN());
    }

    @JavascriptInterface
    public void getStorageInfo(JsObject jsObject) {
        amU().getStorageInfo(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.v.a.c getStorageInfoSync() {
        return amU().getStorageInfoSync();
    }

    @NonNull
    private com.baidu.swan.games.v.a amU() {
        if (this.clI == null) {
            this.clI = new com.baidu.swan.games.v.a(this.ckb);
        }
        return this.clI;
    }

    @JavascriptInterface
    public void setInnerAudioOption(JsObject jsObject) {
        this.clO = new h(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.audio.g createInnerAudioContext() {
        return new com.baidu.swan.games.audio.g(this.ckb);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.b createBannerAd(JsObject jsObject) {
        return com.baidu.swan.apps.w.a.Uy().b(this.ckb, jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.z.d getUpdateManager(JsObject jsObject) {
        if (this.clJ == null) {
            this.clJ = new com.baidu.swan.games.z.d(jsObject);
        }
        return this.clJ;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.websocket.c connectSocket(JsObject jsObject) {
        if (this.clL == null) {
            this.clL = new com.baidu.swan.games.network.websocket.a(this.ckb);
        }
        return this.clL.connectSocket(jsObject);
    }

    @JavascriptInterface
    public void setEnableDebug(JsObject jsObject) {
        if (this.clM == null) {
            this.clM = new g(this.ckb);
        }
        this.clM.setEnableDebug(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.c.c request(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        com.baidu.swan.games.network.a a = com.baidu.swan.games.network.b.d.aoT().a(this.ckb, c, 1);
        if (a instanceof com.baidu.swan.games.network.c.c) {
            com.baidu.swan.games.network.c.c cVar = (com.baidu.swan.games.network.c.c) a;
            cVar.j(c);
            return cVar;
        }
        com.baidu.swan.games.network.c.c cVar2 = new com.baidu.swan.games.network.c.c(this.ckb, c);
        cVar2.start();
        return cVar2;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.d.b uploadFile(JsObject jsObject) {
        com.baidu.swan.games.network.d.b bVar = new com.baidu.swan.games.network.d.b(this.ckb, com.baidu.swan.games.binding.model.c.c(jsObject));
        bVar.start();
        return bVar;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.a.b downloadFile(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        com.baidu.swan.games.network.a a = com.baidu.swan.games.network.b.d.aoT().a(this.ckb, c, 2);
        if (a instanceof com.baidu.swan.games.network.a.b) {
            com.baidu.swan.games.network.a.b bVar = (com.baidu.swan.games.network.a.b) a;
            bVar.j(c);
            return bVar;
        }
        com.baidu.swan.games.network.a.b bVar2 = new com.baidu.swan.games.network.a.b(this.ckb, c);
        bVar2.start();
        return bVar2;
    }

    @JavascriptInterface
    public void openCustomerServiceConversation(JsObject jsObject) {
        com.baidu.swan.games.c.a.a((c) this.ckb.anw(), jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.screenrecord.a getVideoRecorderManager() {
        if (this.clN == null) {
            this.clN = new com.baidu.swan.games.screenrecord.a(this.ckb);
        }
        return this.clN;
    }

    @JavascriptInterface
    public void shareVideo(JsObject jsObject) {
        new com.baidu.swan.games.t.b.a(jsObject).NR();
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return com.baidu.swan.apps.jsbridge.a.b.getEnvVariables();
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton(JsObject jsObject) {
        return new RecommendButtonApiProxy(this.ckb, jsObject);
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton() {
        return createRecommendationButton(null);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide(JsObject jsObject) {
        if (this.clP == null) {
            this.clP = new DesktopGuideApi(this.ckb);
        }
        this.clP.o(jsObject);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide() {
        showAddToDesktopGuide(null);
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.webview.a getWebViewManager() {
        if (this.clR == null) {
            this.clR = new com.baidu.swan.games.view.webview.a(this.ckb);
        }
        return this.clR;
    }

    @JavascriptInterface
    public void getUUAPInfo(JsObject jsObject) {
        com.baidu.swan.games.aa.a.getUUAPInfo(jsObject);
    }

    @JavascriptInterface
    public String getAPIs(int i) {
        return DEBUG ? com.baidu.swan.apps.ah.a.a.aaF() ? SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i) : "" : com.baidu.swan.apps.w.a.TZ().Hf() ? SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i) : "";
    }

    @JavascriptInterface
    public void authorizeEval(JsObject jsObject) {
        com.baidu.swan.games.f.a.authorizeEval(jsObject);
    }

    @JavascriptInterface
    public void menuItemCtrl(JsObject jsObject) {
        com.baidu.swan.games.p.a WH = f.WS().WH();
        if (WH != null) {
            WH.i(com.baidu.swan.games.binding.model.c.c(jsObject));
        }
    }
}
