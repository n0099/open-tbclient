package com.baidu.swan.games.binding;

import android.os.Build;
import android.support.annotation.NonNull;
import android.webkit.JavascriptInterface;
import com.baidu.platform.comapi.walknavi.fsm.RGState;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.games.audio.g;
import com.baidu.swan.games.f.d;
import com.baidu.swan.games.o.e;
import com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy;
/* loaded from: classes2.dex */
public final class c extends EventTargetImpl {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private d byH;
    private com.baidu.swan.games.o.d byI;
    private com.baidu.swan.games.o.b byJ;
    private JsObject byK;
    private e byL;
    private com.baidu.swan.games.k.a byM;
    private com.baidu.swan.games.k.b byN;
    private com.baidu.swan.games.s.a byO;
    private com.baidu.swan.games.u.d byP;
    private com.baidu.swan.games.a.c byQ;
    private com.baidu.swan.games.network.websocket.a byR;
    private com.baidu.swan.games.c.e byS;
    private com.baidu.swan.games.screenrecord.a byT;
    private com.baidu.swan.games.e.b bym;
    @V8JavascriptField
    public final String domain;
    @V8JavascriptField
    public com.baidu.swan.games.f.a env;

    public c(com.baidu.swan.games.e.b bVar) {
        super(bVar);
        this.domain = "main";
        this.byK = null;
        this.byL = null;
        this.byM = null;
        this.byN = null;
        this.byP = null;
        this.byQ = null;
        this.byR = null;
        this.byS = null;
        this.byT = null;
        this.bym = bVar;
        this.env = new com.baidu.swan.games.f.a();
        Wb();
    }

    private void Wb() {
        this.byN = new com.baidu.swan.games.k.b(this.bym);
    }

    public void b(JsObject jsObject) {
        this.byK = jsObject;
    }

    @JavascriptInterface
    public void setPreferredFramesPerSecond(short s) {
        if (s >= 1 && s <= 60) {
            this.bym.setPreferredFramesPerSecond(s);
        }
    }

    @JavascriptInterface
    public e getOpenDataContext() {
        if (this.byL == null) {
            this.byL = new e(this.bym);
            this.byL.canvas = this.byK;
            this.byK = null;
        }
        return this.byL;
    }

    @JavascriptInterface
    public d getFileSystemManager() {
        if (this.byH == null) {
            this.byH = new d((com.baidu.swan.games.e.a) this.bym);
        }
        return this.byH;
    }

    @JavascriptInterface
    public com.baidu.swan.games.subpackage.d loadSubpackage(JsObject jsObject) {
        com.baidu.swan.games.subpackage.d dVar = new com.baidu.swan.games.subpackage.d(this.bym);
        dVar.l(jsObject);
        return dVar;
    }

    @JavascriptInterface
    public void exit(JsObject jsObject) {
        if (DEBUG) {
            this.bym.WD().log("exit from java side.");
        }
        if (jsObject != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            com.baidu.swan.games.binding.model.a e = com.baidu.swan.games.binding.model.a.e(com.baidu.swan.games.binding.model.c.c(jsObject));
            SwanAppActivity Lp = com.baidu.swan.apps.w.e.LD().Lp();
            if (Lp == null) {
                bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "failed");
                e.J(bVar);
                e.onComplete();
                return;
            }
            bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "ok");
            e.onSuccess(bVar);
            e.onComplete();
            if (Build.VERSION.SDK_INT >= 21) {
                Lp.finishAndRemoveTask();
            } else {
                Lp.finish();
            }
        }
    }

    @JavascriptInterface
    public com.baidu.swan.games.o.d getOpenData() {
        if (this.byI == null) {
            this.byI = new com.baidu.swan.games.o.d((com.baidu.swan.games.e.a) this.bym);
        }
        return this.byI;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        if (this.byJ == null) {
            this.byJ = new com.baidu.swan.games.o.b(this.bym);
        }
        this.byJ.checkIsUserAdvisedToRest(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.c createRewardedVideoAd(JsObject jsObject) {
        if (this.byQ == null) {
            this.byQ = com.baidu.swan.apps.u.a.JJ().a(this.bym, jsObject);
            if (this.byQ == null) {
                this.byQ = new com.baidu.swan.games.a.a();
            }
        }
        return this.byQ;
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.button.userinfo.b createUserInfoButton(JsObject jsObject) {
        return new com.baidu.swan.games.view.button.userinfo.b(jsObject, this.bym);
    }

    @JavascriptInterface
    public void showKeyboard(JsObject jsObject) {
        if (this.byM == null) {
            this.byM = new com.baidu.swan.games.k.a(this.bym, this.byN);
        }
        this.byM.showKeyboard(jsObject);
    }

    @JavascriptInterface
    public void showKeyboard() {
        if (this.byM == null) {
            this.byM = new com.baidu.swan.games.k.a(this.bym, this.byN);
        }
        this.byM.showKeyboard(null);
    }

    @JavascriptInterface
    public void updateKeyboard(JsObject jsObject) {
        if (this.byM != null) {
            this.byM.updateKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void updateKeyboard() {
        if (this.byM != null) {
            this.byM.updateKeyboard(null);
        }
    }

    @JavascriptInterface
    public void hideKeyboard(JsObject jsObject) {
        if (this.byM != null) {
            this.byM.hideKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void hideKeyboard() {
        if (this.byM != null) {
            this.byM.hideKeyboard(null);
        }
    }

    @JavascriptInterface
    public void getStorage(JsObject jsObject) {
        Wc().getStorage(jsObject);
    }

    @JavascriptInterface
    public Object getStorageSync(String str) {
        return com.baidu.swan.games.s.a.d.a(this.bym, "getStorageSync", str, Wc().kB(str));
    }

    @JavascriptInterface
    public void setStorage(JsObject jsObject) {
        Wc().setStorage(jsObject);
    }

    @JavascriptInterface
    public void setStorageSync(String str, JsSerializeValue jsSerializeValue) {
        com.baidu.swan.games.s.a.d.a(this.bym, "setStorageSync", str, Wc().a(str, jsSerializeValue));
    }

    @JavascriptInterface
    public void setStorageSync(String str) {
        com.baidu.swan.games.s.a.d.a(this.bym, "setStorageSync", str, Wc().a(str, (JsSerializeValue) null));
    }

    @JavascriptInterface
    public void removeStorage(JsObject jsObject) {
        Wc().removeStorage(jsObject);
    }

    @JavascriptInterface
    public void removeStorageSync(String str) {
        com.baidu.swan.games.s.a.d.a(this.bym, "removeStorageSync", str, Wc().kC(str));
    }

    @JavascriptInterface
    public void clearStorage(JsObject jsObject) {
        Wc().clearStorage(jsObject);
    }

    @JavascriptInterface
    public void clearStorageSync() {
        com.baidu.swan.games.s.a.d.a(this.bym, "clearStorageSync", "", Wc().Yh());
    }

    @JavascriptInterface
    public void getStorageInfo(JsObject jsObject) {
        Wc().getStorageInfo(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.s.a.c getStorageInfoSync() {
        return Wc().getStorageInfoSync();
    }

    @NonNull
    private com.baidu.swan.games.s.a Wc() {
        if (this.byO == null) {
            this.byO = new com.baidu.swan.games.s.a(this.bym);
        }
        return this.byO;
    }

    @JavascriptInterface
    public g createInnerAudioContext() {
        return new g(this.bym);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.b createBannerAd(JsObject jsObject) {
        return com.baidu.swan.apps.u.a.JJ().b(this.bym, jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.u.d getUpdateManager(JsObject jsObject) {
        if (this.byP == null) {
            this.byP = new com.baidu.swan.games.u.d(jsObject);
        }
        return this.byP;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.websocket.c connectSocket(JsObject jsObject) {
        if (this.byR == null) {
            this.byR = new com.baidu.swan.games.network.websocket.a(this.bym);
        }
        return this.byR.connectSocket(jsObject);
    }

    @JavascriptInterface
    public void setEnableDebug(JsObject jsObject) {
        if (this.byS == null) {
            this.byS = new com.baidu.swan.games.c.e(this.bym);
        }
        this.byS.setEnableDebug(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.a.c request(JsObject jsObject) {
        return new com.baidu.swan.games.network.a.c(jsObject);
    }

    @JavascriptInterface
    public void openCustomerServiceConversation(JsObject jsObject) {
        com.baidu.swan.games.d.a.a((c) this.bym.WB(), jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.screenrecord.a getVideoRecorderManager() {
        if (this.byT == null) {
            this.byT = new com.baidu.swan.games.screenrecord.a(this.bym);
        }
        return this.byT;
    }

    @JavascriptInterface
    public void shareVideo(JsObject jsObject) {
        new com.baidu.swan.games.q.b.a(jsObject).EU();
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return com.baidu.swan.apps.jsbridge.a.a.getEnvVariables();
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton(JsObject jsObject) {
        return new RecommendButtonApiProxy(this.bym, jsObject);
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton() {
        return createRecommendationButton(null);
    }
}
