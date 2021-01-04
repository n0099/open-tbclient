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
/* loaded from: classes9.dex */
public final class c extends EventTargetImpl {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @V8JavascriptField
    public final String domain;
    private com.baidu.swan.games.f.b efi;
    private e egQ;
    private d egR;
    private com.baidu.swan.games.r.b egS;
    private JsObject egT;
    private com.baidu.swan.games.r.e egU;
    private com.baidu.swan.games.n.a egV;
    private com.baidu.swan.games.n.b egW;
    private com.baidu.swan.games.w.a egX;
    private com.baidu.swan.games.aa.d egY;
    private com.baidu.swan.games.a.c egZ;
    private com.baidu.swan.games.network.websocket.a eha;
    private g ehb;
    private com.baidu.swan.games.screenrecord.a ehc;
    private h ehd;
    private DesktopGuideApi ehe;
    private com.baidu.swan.games.s.a ehf;
    private com.baidu.swan.games.view.webview.a ehg;
    private com.baidu.swan.games.b.b ehh;
    @V8JavascriptField
    public com.baidu.swan.games.i.a env;

    public c(com.baidu.swan.games.f.b bVar) {
        super(bVar);
        this.domain = "main";
        this.egT = null;
        this.egU = null;
        this.egV = null;
        this.egW = null;
        this.egY = null;
        this.egZ = null;
        this.eha = null;
        this.ehb = null;
        this.ehc = null;
        this.ehd = null;
        this.ehe = null;
        this.ehf = null;
        this.ehg = null;
        this.ehh = null;
        this.efi = bVar;
        this.env = new com.baidu.swan.games.i.a();
        aZd();
    }

    private void aZd() {
        this.egW = new com.baidu.swan.games.n.b(this.efi);
    }

    public void d(JsObject jsObject) {
        this.egT = jsObject;
    }

    @JavascriptInterface
    public void setPreferredFramesPerSecond(short s) {
        if (s >= 1 && s <= 60) {
            this.efi.setPreferredFramesPerSecond(s);
        }
    }

    @JavascriptInterface
    public com.baidu.swan.games.r.e getOpenDataContext() {
        if (this.egU == null) {
            this.egU = new com.baidu.swan.games.r.e(this.efi);
            this.egU.canvas = this.egT;
            this.egT = null;
        }
        return this.egU;
    }

    @JavascriptInterface
    public e getFileSystemManager() {
        if (this.egQ == null) {
            this.egQ = new e((com.baidu.swan.games.f.a) this.efi);
        }
        return this.egQ;
    }

    @JavascriptInterface
    public com.baidu.swan.games.y.c loadSubpackage(JsObject jsObject) {
        com.baidu.swan.games.y.c cVar = new com.baidu.swan.games.y.c(this.efi);
        cVar.n(jsObject);
        return cVar;
    }

    @JavascriptInterface
    public void exit(JsObject jsObject) {
        if (DEBUG) {
            this.efi.aZI().log("exit from java side.");
        }
        if (jsObject != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            com.baidu.swan.games.binding.model.a f = com.baidu.swan.games.binding.model.a.f(com.baidu.swan.games.binding.model.c.e(jsObject));
            SwanAppActivity aDq = f.aDG().aDq();
            if (aDq == null) {
                bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "failed");
                f.ad(bVar);
                return;
            }
            bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "ok");
            f.onSuccess(bVar);
            if (Build.VERSION.SDK_INT >= 21) {
                aDq.finishAndRemoveTask();
            } else {
                aDq.finish();
            }
        }
    }

    @JavascriptInterface
    public void reload(JsObject jsObject) {
        if (this.ehf == null) {
            this.ehf = new com.baidu.swan.games.s.a();
        }
        this.ehf.reload(jsObject);
    }

    @JavascriptInterface
    public void reload() {
        reload(null);
    }

    @JavascriptInterface
    public d getOpenData() {
        if (this.egR == null) {
            this.egR = new d((com.baidu.swan.games.f.a) this.efi);
        }
        return this.egR;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        if (this.egS == null) {
            this.egS = new com.baidu.swan.games.r.b(this.efi);
        }
        this.egS.checkIsUserAdvisedToRest(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.c createRewardedVideoAd(JsObject jsObject) {
        if (this.egZ == null) {
            this.egZ = com.baidu.swan.apps.t.a.aAU().a(this.efi, jsObject);
            if (this.egZ == null) {
                this.egZ = new com.baidu.swan.games.a.a();
            }
        }
        return this.egZ;
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.button.userinfo.b createUserInfoButton(JsObject jsObject) {
        return new com.baidu.swan.games.view.button.userinfo.b(jsObject, this.efi);
    }

    @JavascriptInterface
    public void showKeyboard(JsObject jsObject) {
        if (this.egV == null) {
            this.egV = new com.baidu.swan.games.n.a(this.efi, this.egW);
        }
        this.egV.showKeyboard(jsObject);
    }

    @JavascriptInterface
    public void showKeyboard() {
        if (this.egV == null) {
            this.egV = new com.baidu.swan.games.n.a(this.efi, this.egW);
        }
        this.egV.showKeyboard(null);
    }

    @JavascriptInterface
    public void updateKeyboard(JsObject jsObject) {
        if (this.egV != null) {
            this.egV.updateKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void updateKeyboard() {
        if (this.egV != null) {
            this.egV.updateKeyboard(null);
        }
    }

    @JavascriptInterface
    public void hideKeyboard(JsObject jsObject) {
        if (this.egV != null) {
            this.egV.hideKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void hideKeyboard() {
        if (this.egV != null) {
            this.egV.hideKeyboard(null);
        }
    }

    @JavascriptInterface
    public void getStorage(JsObject jsObject) {
        aZe().getStorage(jsObject);
    }

    @JavascriptInterface
    public Object getStorageSync(String str) {
        return com.baidu.swan.games.w.a.d.a(this.efi, "getStorageSync", str, aZe().yg(str));
    }

    @JavascriptInterface
    public void setStorage(JsObject jsObject) {
        aZe().setStorage(jsObject);
    }

    @JavascriptInterface
    public void setStorageSync(String str, JsSerializeValue jsSerializeValue) {
        com.baidu.swan.games.w.a.d.a(this.efi, "setStorageSync", str, aZe().a(str, jsSerializeValue));
    }

    @JavascriptInterface
    public void setStorageSync(String str) {
        com.baidu.swan.games.w.a.d.a(this.efi, "setStorageSync", str, aZe().a(str, (JsSerializeValue) null));
    }

    @JavascriptInterface
    public void removeStorage(JsObject jsObject) {
        aZe().removeStorage(jsObject);
    }

    @JavascriptInterface
    public void removeStorageSync(String str) {
        com.baidu.swan.games.w.a.d.a(this.efi, "removeStorageSync", str, aZe().yh(str));
    }

    @JavascriptInterface
    public void clearStorage(JsObject jsObject) {
        aZe().clearStorage(jsObject);
    }

    @JavascriptInterface
    public void clearStorageSync() {
        com.baidu.swan.games.w.a.d.a(this.efi, "clearStorageSync", "", aZe().bcc());
    }

    @JavascriptInterface
    public void getStorageInfo(JsObject jsObject) {
        aZe().getStorageInfo(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.w.a.c getStorageInfoSync() {
        return aZe().getStorageInfoSync();
    }

    @NonNull
    private com.baidu.swan.games.w.a aZe() {
        if (this.egX == null) {
            this.egX = new com.baidu.swan.games.w.a(this.efi);
        }
        return this.egX;
    }

    @JavascriptInterface
    public void setInnerAudioOption(JsObject jsObject) {
        this.ehd = new h(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.audio.g createInnerAudioContext() {
        return new com.baidu.swan.games.audio.g(this.efi);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.b createBannerAd(JsObject jsObject) {
        return com.baidu.swan.apps.t.a.aAU().b(this.efi, jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.aa.d getUpdateManager(JsObject jsObject) {
        if (this.egY == null) {
            this.egY = new com.baidu.swan.games.aa.d(jsObject);
        }
        return this.egY;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.websocket.c connectSocket(JsObject jsObject) {
        if (this.eha == null) {
            this.eha = new com.baidu.swan.games.network.websocket.a(this.efi);
        }
        return this.eha.connectSocket(jsObject);
    }

    @JavascriptInterface
    public void setEnableDebug(JsObject jsObject) {
        if (this.ehb == null) {
            this.ehb = new g(this.efi);
        }
        this.ehb.setEnableDebug(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.c.c request(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        com.baidu.swan.games.network.a a2 = com.baidu.swan.games.network.b.d.bbj().a(this.efi, e, 1);
        if (a2 instanceof com.baidu.swan.games.network.c.c) {
            com.baidu.swan.games.network.c.c cVar = (com.baidu.swan.games.network.c.c) a2;
            cVar.j(e);
            return cVar;
        }
        com.baidu.swan.games.network.c.c cVar2 = new com.baidu.swan.games.network.c.c(this.efi, e);
        cVar2.start();
        return cVar2;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.d.b uploadFile(JsObject jsObject) {
        com.baidu.swan.games.network.d.b bVar = new com.baidu.swan.games.network.d.b(this.efi, com.baidu.swan.games.binding.model.c.e(jsObject));
        bVar.start();
        return bVar;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.a.b downloadFile(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        com.baidu.swan.games.network.a a2 = com.baidu.swan.games.network.b.d.bbj().a(this.efi, e, 2);
        if (a2 instanceof com.baidu.swan.games.network.a.b) {
            com.baidu.swan.games.network.a.b bVar = (com.baidu.swan.games.network.a.b) a2;
            bVar.j(e);
            return bVar;
        }
        com.baidu.swan.games.network.a.b bVar2 = new com.baidu.swan.games.network.a.b(this.efi, e);
        bVar2.start();
        return bVar2;
    }

    @JavascriptInterface
    public void openCustomerServiceConversation(JsObject jsObject) {
        com.baidu.swan.games.d.a.a((c) this.efi.aZG(), jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.screenrecord.a getVideoRecorderManager() {
        if (this.ehc == null) {
            this.ehc = new com.baidu.swan.games.screenrecord.a(this.efi);
        }
        return this.ehc;
    }

    @JavascriptInterface
    public void shareVideo(JsObject jsObject) {
        new com.baidu.swan.games.u.b.a(jsObject).arF();
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return com.baidu.swan.apps.jsbridge.a.b.f(this.efi);
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton(JsObject jsObject) {
        return new RecommendButtonApiProxy(this.efi, jsObject);
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton() {
        return createRecommendationButton(null);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide(JsObject jsObject) {
        if (this.ehe == null) {
            this.ehe = new DesktopGuideApi(this.efi);
        }
        this.ehe.q(jsObject);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide() {
        showAddToDesktopGuide(null);
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.webview.a getWebViewManager() {
        if (this.ehg == null) {
            this.ehg = new com.baidu.swan.games.view.webview.a(this.efi);
        }
        return this.ehg;
    }

    @JavascriptInterface
    public void getUUAPInfo(JsObject jsObject) {
        com.baidu.swan.games.ab.a.getUUAPInfo(jsObject);
    }

    @JavascriptInterface
    public String getAPIs(int i) {
        if (DEBUG) {
            return com.baidu.swan.apps.ad.a.a.aIM() ? SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i) : "";
        }
        return SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i);
    }

    @JavascriptInterface
    public void authorizeEval(JsObject jsObject) {
        com.baidu.swan.games.g.a.authorizeEval(jsObject);
    }

    @JavascriptInterface
    public void menuItemCtrl(JsObject jsObject) {
        com.baidu.swan.games.q.a aDu = f.aDG().aDu();
        if (aDu != null) {
            aDu.i(com.baidu.swan.games.binding.model.c.e(jsObject));
        }
    }

    @JavascriptInterface
    public com.baidu.swan.games.b.b getAntiAddiction() {
        if (this.ehh == null) {
            this.ehh = new com.baidu.swan.games.b.b(this.efi);
        }
        return this.ehh;
    }
}
