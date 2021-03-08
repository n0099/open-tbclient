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
    private com.baidu.swan.games.f.b eee;
    private e efL;
    private d efM;
    private com.baidu.swan.games.r.b efN;
    private JsObject efO;
    private com.baidu.swan.games.r.e efP;
    private com.baidu.swan.games.n.a efQ;
    private com.baidu.swan.games.n.b efR;
    private com.baidu.swan.games.w.a efS;
    private com.baidu.swan.games.aa.d efT;
    private com.baidu.swan.games.a.c efU;
    private com.baidu.swan.games.network.websocket.a efV;
    private g efW;
    private com.baidu.swan.games.screenrecord.a efX;
    private h efY;
    private DesktopGuideApi efZ;
    private com.baidu.swan.games.s.a ega;
    private com.baidu.swan.games.view.webview.a egb;
    private com.baidu.swan.games.b.b egc;
    @V8JavascriptField
    public com.baidu.swan.games.i.a env;

    public c(com.baidu.swan.games.f.b bVar) {
        super(bVar);
        this.domain = "main";
        this.efO = null;
        this.efP = null;
        this.efQ = null;
        this.efR = null;
        this.efT = null;
        this.efU = null;
        this.efV = null;
        this.efW = null;
        this.efX = null;
        this.efY = null;
        this.efZ = null;
        this.ega = null;
        this.egb = null;
        this.egc = null;
        this.eee = bVar;
        this.env = new com.baidu.swan.games.i.a();
        aVz();
    }

    private void aVz() {
        this.efR = new com.baidu.swan.games.n.b(this.eee);
    }

    public void d(JsObject jsObject) {
        this.efO = jsObject;
    }

    @JavascriptInterface
    public void setPreferredFramesPerSecond(short s) {
        if (s >= 1 && s <= 60) {
            this.eee.setPreferredFramesPerSecond(s);
        }
    }

    @JavascriptInterface
    public com.baidu.swan.games.r.e getOpenDataContext() {
        if (this.efP == null) {
            this.efP = new com.baidu.swan.games.r.e(this.eee);
            this.efP.canvas = this.efO;
            this.efO = null;
        }
        return this.efP;
    }

    @JavascriptInterface
    public e getFileSystemManager() {
        if (this.efL == null) {
            this.efL = new e((com.baidu.swan.games.f.a) this.eee);
        }
        return this.efL;
    }

    @JavascriptInterface
    public com.baidu.swan.games.y.c loadSubpackage(JsObject jsObject) {
        com.baidu.swan.games.y.c cVar = new com.baidu.swan.games.y.c(this.eee);
        cVar.n(jsObject);
        return cVar;
    }

    @JavascriptInterface
    public void exit(JsObject jsObject) {
        if (DEBUG) {
            this.eee.aWe().log("exit from java side.");
        }
        if (jsObject != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            com.baidu.swan.games.binding.model.a f = com.baidu.swan.games.binding.model.a.f(com.baidu.swan.games.binding.model.c.e(jsObject));
            SwanAppActivity azY = f.aAo().azY();
            if (azY == null) {
                bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "failed");
                f.af(bVar);
                return;
            }
            bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "ok");
            f.onSuccess(bVar);
            if (Build.VERSION.SDK_INT >= 21) {
                azY.finishAndRemoveTask();
            } else {
                azY.finish();
            }
        }
    }

    @JavascriptInterface
    public void reload(JsObject jsObject) {
        if (this.ega == null) {
            this.ega = new com.baidu.swan.games.s.a();
        }
        this.ega.reload(jsObject);
    }

    @JavascriptInterface
    public void reload() {
        reload(null);
    }

    @JavascriptInterface
    public d getOpenData() {
        if (this.efM == null) {
            this.efM = new d((com.baidu.swan.games.f.a) this.eee);
        }
        return this.efM;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        if (this.efN == null) {
            this.efN = new com.baidu.swan.games.r.b(this.eee);
        }
        this.efN.checkIsUserAdvisedToRest(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.c createRewardedVideoAd(JsObject jsObject) {
        if (this.efU == null) {
            this.efU = com.baidu.swan.apps.t.a.axC().a(this.eee, jsObject);
            if (this.efU == null) {
                this.efU = new com.baidu.swan.games.a.a();
            }
        }
        return this.efU;
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.button.userinfo.b createUserInfoButton(JsObject jsObject) {
        return new com.baidu.swan.games.view.button.userinfo.b(jsObject, this.eee);
    }

    @JavascriptInterface
    public void showKeyboard(JsObject jsObject) {
        if (this.efQ == null) {
            this.efQ = new com.baidu.swan.games.n.a(this.eee, this.efR);
        }
        this.efQ.showKeyboard(jsObject);
    }

    @JavascriptInterface
    public void showKeyboard() {
        if (this.efQ == null) {
            this.efQ = new com.baidu.swan.games.n.a(this.eee, this.efR);
        }
        this.efQ.showKeyboard(null);
    }

    @JavascriptInterface
    public void updateKeyboard(JsObject jsObject) {
        if (this.efQ != null) {
            this.efQ.updateKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void updateKeyboard() {
        if (this.efQ != null) {
            this.efQ.updateKeyboard(null);
        }
    }

    @JavascriptInterface
    public void hideKeyboard(JsObject jsObject) {
        if (this.efQ != null) {
            this.efQ.hideKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void hideKeyboard() {
        if (this.efQ != null) {
            this.efQ.hideKeyboard(null);
        }
    }

    @JavascriptInterface
    public void getStorage(JsObject jsObject) {
        aVA().getStorage(jsObject);
    }

    @JavascriptInterface
    public Object getStorageSync(String str) {
        return com.baidu.swan.games.w.a.d.a(this.eee, "getStorageSync", str, aVA().xv(str));
    }

    @JavascriptInterface
    public void setStorage(JsObject jsObject) {
        aVA().setStorage(jsObject);
    }

    @JavascriptInterface
    public void setStorageSync(String str, JsSerializeValue jsSerializeValue) {
        com.baidu.swan.games.w.a.d.a(this.eee, "setStorageSync", str, aVA().a(str, jsSerializeValue));
    }

    @JavascriptInterface
    public void setStorageSync(String str) {
        com.baidu.swan.games.w.a.d.a(this.eee, "setStorageSync", str, aVA().a(str, (JsSerializeValue) null));
    }

    @JavascriptInterface
    public void removeStorage(JsObject jsObject) {
        aVA().removeStorage(jsObject);
    }

    @JavascriptInterface
    public void removeStorageSync(String str) {
        com.baidu.swan.games.w.a.d.a(this.eee, "removeStorageSync", str, aVA().xw(str));
    }

    @JavascriptInterface
    public void clearStorage(JsObject jsObject) {
        aVA().clearStorage(jsObject);
    }

    @JavascriptInterface
    public void clearStorageSync() {
        com.baidu.swan.games.w.a.d.a(this.eee, "clearStorageSync", "", aVA().aYy());
    }

    @JavascriptInterface
    public void getStorageInfo(JsObject jsObject) {
        aVA().getStorageInfo(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.w.a.c getStorageInfoSync() {
        return aVA().getStorageInfoSync();
    }

    @NonNull
    private com.baidu.swan.games.w.a aVA() {
        if (this.efS == null) {
            this.efS = new com.baidu.swan.games.w.a(this.eee);
        }
        return this.efS;
    }

    @JavascriptInterface
    public void setInnerAudioOption(JsObject jsObject) {
        this.efY = new h(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.audio.g createInnerAudioContext() {
        return new com.baidu.swan.games.audio.g(this.eee);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.b createBannerAd(JsObject jsObject) {
        return com.baidu.swan.apps.t.a.axC().b(this.eee, jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.aa.d getUpdateManager(JsObject jsObject) {
        if (this.efT == null) {
            this.efT = new com.baidu.swan.games.aa.d(jsObject);
        }
        return this.efT;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.websocket.c connectSocket(JsObject jsObject) {
        if (this.efV == null) {
            this.efV = new com.baidu.swan.games.network.websocket.a(this.eee);
        }
        return this.efV.connectSocket(jsObject);
    }

    @JavascriptInterface
    public void setEnableDebug(JsObject jsObject) {
        if (this.efW == null) {
            this.efW = new g(this.eee);
        }
        this.efW.setEnableDebug(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.c.c request(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        com.baidu.swan.games.network.a a2 = com.baidu.swan.games.network.b.d.aXF().a(this.eee, e, 1);
        if (a2 instanceof com.baidu.swan.games.network.c.c) {
            com.baidu.swan.games.network.c.c cVar = (com.baidu.swan.games.network.c.c) a2;
            cVar.j(e);
            return cVar;
        }
        com.baidu.swan.games.network.c.c cVar2 = new com.baidu.swan.games.network.c.c(this.eee, e);
        cVar2.start();
        return cVar2;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.d.b uploadFile(JsObject jsObject) {
        com.baidu.swan.games.network.d.b bVar = new com.baidu.swan.games.network.d.b(this.eee, com.baidu.swan.games.binding.model.c.e(jsObject));
        bVar.start();
        return bVar;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.a.b downloadFile(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        com.baidu.swan.games.network.a a2 = com.baidu.swan.games.network.b.d.aXF().a(this.eee, e, 2);
        if (a2 instanceof com.baidu.swan.games.network.a.b) {
            com.baidu.swan.games.network.a.b bVar = (com.baidu.swan.games.network.a.b) a2;
            bVar.j(e);
            return bVar;
        }
        com.baidu.swan.games.network.a.b bVar2 = new com.baidu.swan.games.network.a.b(this.eee, e);
        bVar2.start();
        return bVar2;
    }

    @JavascriptInterface
    public void openCustomerServiceConversation(JsObject jsObject) {
        com.baidu.swan.games.d.a.a((c) this.eee.aWc(), jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.screenrecord.a getVideoRecorderManager() {
        if (this.efX == null) {
            this.efX = new com.baidu.swan.games.screenrecord.a(this.eee);
        }
        return this.efX;
    }

    @JavascriptInterface
    public void shareVideo(JsObject jsObject) {
        new com.baidu.swan.games.u.b.a(jsObject).aom();
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return com.baidu.swan.apps.jsbridge.a.b.f(this.eee);
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton(JsObject jsObject) {
        return new RecommendButtonApiProxy(this.eee, jsObject);
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton() {
        return createRecommendationButton(null);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide(JsObject jsObject) {
        if (this.efZ == null) {
            this.efZ = new DesktopGuideApi(this.eee);
        }
        this.efZ.q(jsObject);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide() {
        showAddToDesktopGuide(null);
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.webview.a getWebViewManager() {
        if (this.egb == null) {
            this.egb = new com.baidu.swan.games.view.webview.a(this.eee);
        }
        return this.egb;
    }

    @JavascriptInterface
    public void getUUAPInfo(JsObject jsObject) {
        com.baidu.swan.games.ab.a.getUUAPInfo(jsObject);
    }

    @JavascriptInterface
    public String getAPIs(int i) {
        if (DEBUG) {
            return com.baidu.swan.apps.ad.a.a.aFr() ? SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i) : "";
        }
        return SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i);
    }

    @JavascriptInterface
    public void authorizeEval(JsObject jsObject) {
        com.baidu.swan.games.g.a.authorizeEval(jsObject);
    }

    @JavascriptInterface
    public void menuItemCtrl(JsObject jsObject) {
        com.baidu.swan.games.q.a aAc = f.aAo().aAc();
        if (aAc != null) {
            aAc.i(com.baidu.swan.games.binding.model.c.e(jsObject));
        }
    }

    @JavascriptInterface
    public com.baidu.swan.games.b.b getAntiAddiction() {
        if (this.egc == null) {
            this.egc = new com.baidu.swan.games.b.b(this.eee);
        }
        return this.egc;
    }
}
