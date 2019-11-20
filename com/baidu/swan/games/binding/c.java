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
    private d bxQ;
    private com.baidu.swan.games.o.d bxR;
    private com.baidu.swan.games.o.b bxS;
    private JsObject bxT;
    private e bxU;
    private com.baidu.swan.games.k.a bxV;
    private com.baidu.swan.games.k.b bxW;
    private com.baidu.swan.games.s.a bxX;
    private com.baidu.swan.games.u.d bxY;
    private com.baidu.swan.games.a.c bxZ;
    private com.baidu.swan.games.e.b bxv;
    private com.baidu.swan.games.network.websocket.a bya;
    private com.baidu.swan.games.c.e byb;
    private com.baidu.swan.games.screenrecord.a byc;
    @V8JavascriptField
    public final String domain;
    @V8JavascriptField
    public com.baidu.swan.games.f.a env;

    public c(com.baidu.swan.games.e.b bVar) {
        super(bVar);
        this.domain = "main";
        this.bxT = null;
        this.bxU = null;
        this.bxV = null;
        this.bxW = null;
        this.bxY = null;
        this.bxZ = null;
        this.bya = null;
        this.byb = null;
        this.byc = null;
        this.bxv = bVar;
        this.env = new com.baidu.swan.games.f.a();
        VZ();
    }

    private void VZ() {
        this.bxW = new com.baidu.swan.games.k.b(this.bxv);
    }

    public void b(JsObject jsObject) {
        this.bxT = jsObject;
    }

    @JavascriptInterface
    public void setPreferredFramesPerSecond(short s) {
        if (s >= 1 && s <= 60) {
            this.bxv.setPreferredFramesPerSecond(s);
        }
    }

    @JavascriptInterface
    public e getOpenDataContext() {
        if (this.bxU == null) {
            this.bxU = new e(this.bxv);
            this.bxU.canvas = this.bxT;
            this.bxT = null;
        }
        return this.bxU;
    }

    @JavascriptInterface
    public d getFileSystemManager() {
        if (this.bxQ == null) {
            this.bxQ = new d((com.baidu.swan.games.e.a) this.bxv);
        }
        return this.bxQ;
    }

    @JavascriptInterface
    public com.baidu.swan.games.subpackage.d loadSubpackage(JsObject jsObject) {
        com.baidu.swan.games.subpackage.d dVar = new com.baidu.swan.games.subpackage.d(this.bxv);
        dVar.l(jsObject);
        return dVar;
    }

    @JavascriptInterface
    public void exit(JsObject jsObject) {
        if (DEBUG) {
            this.bxv.WB().log("exit from java side.");
        }
        if (jsObject != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            com.baidu.swan.games.binding.model.a e = com.baidu.swan.games.binding.model.a.e(com.baidu.swan.games.binding.model.c.c(jsObject));
            SwanAppActivity Lq = com.baidu.swan.apps.w.e.LE().Lq();
            if (Lq == null) {
                bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "failed");
                e.J(bVar);
                e.onComplete();
                return;
            }
            bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "ok");
            e.onSuccess(bVar);
            e.onComplete();
            if (Build.VERSION.SDK_INT >= 21) {
                Lq.finishAndRemoveTask();
            } else {
                Lq.finish();
            }
        }
    }

    @JavascriptInterface
    public com.baidu.swan.games.o.d getOpenData() {
        if (this.bxR == null) {
            this.bxR = new com.baidu.swan.games.o.d((com.baidu.swan.games.e.a) this.bxv);
        }
        return this.bxR;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        if (this.bxS == null) {
            this.bxS = new com.baidu.swan.games.o.b(this.bxv);
        }
        this.bxS.checkIsUserAdvisedToRest(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.c createRewardedVideoAd(JsObject jsObject) {
        if (this.bxZ == null) {
            this.bxZ = com.baidu.swan.apps.u.a.JK().a(this.bxv, jsObject);
            if (this.bxZ == null) {
                this.bxZ = new com.baidu.swan.games.a.a();
            }
        }
        return this.bxZ;
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.button.userinfo.b createUserInfoButton(JsObject jsObject) {
        return new com.baidu.swan.games.view.button.userinfo.b(jsObject, this.bxv);
    }

    @JavascriptInterface
    public void showKeyboard(JsObject jsObject) {
        if (this.bxV == null) {
            this.bxV = new com.baidu.swan.games.k.a(this.bxv, this.bxW);
        }
        this.bxV.showKeyboard(jsObject);
    }

    @JavascriptInterface
    public void showKeyboard() {
        if (this.bxV == null) {
            this.bxV = new com.baidu.swan.games.k.a(this.bxv, this.bxW);
        }
        this.bxV.showKeyboard(null);
    }

    @JavascriptInterface
    public void updateKeyboard(JsObject jsObject) {
        if (this.bxV != null) {
            this.bxV.updateKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void updateKeyboard() {
        if (this.bxV != null) {
            this.bxV.updateKeyboard(null);
        }
    }

    @JavascriptInterface
    public void hideKeyboard(JsObject jsObject) {
        if (this.bxV != null) {
            this.bxV.hideKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void hideKeyboard() {
        if (this.bxV != null) {
            this.bxV.hideKeyboard(null);
        }
    }

    @JavascriptInterface
    public void getStorage(JsObject jsObject) {
        Wa().getStorage(jsObject);
    }

    @JavascriptInterface
    public Object getStorageSync(String str) {
        return com.baidu.swan.games.s.a.d.a(this.bxv, "getStorageSync", str, Wa().kB(str));
    }

    @JavascriptInterface
    public void setStorage(JsObject jsObject) {
        Wa().setStorage(jsObject);
    }

    @JavascriptInterface
    public void setStorageSync(String str, JsSerializeValue jsSerializeValue) {
        com.baidu.swan.games.s.a.d.a(this.bxv, "setStorageSync", str, Wa().a(str, jsSerializeValue));
    }

    @JavascriptInterface
    public void setStorageSync(String str) {
        com.baidu.swan.games.s.a.d.a(this.bxv, "setStorageSync", str, Wa().a(str, (JsSerializeValue) null));
    }

    @JavascriptInterface
    public void removeStorage(JsObject jsObject) {
        Wa().removeStorage(jsObject);
    }

    @JavascriptInterface
    public void removeStorageSync(String str) {
        com.baidu.swan.games.s.a.d.a(this.bxv, "removeStorageSync", str, Wa().kC(str));
    }

    @JavascriptInterface
    public void clearStorage(JsObject jsObject) {
        Wa().clearStorage(jsObject);
    }

    @JavascriptInterface
    public void clearStorageSync() {
        com.baidu.swan.games.s.a.d.a(this.bxv, "clearStorageSync", "", Wa().Yf());
    }

    @JavascriptInterface
    public void getStorageInfo(JsObject jsObject) {
        Wa().getStorageInfo(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.s.a.c getStorageInfoSync() {
        return Wa().getStorageInfoSync();
    }

    @NonNull
    private com.baidu.swan.games.s.a Wa() {
        if (this.bxX == null) {
            this.bxX = new com.baidu.swan.games.s.a(this.bxv);
        }
        return this.bxX;
    }

    @JavascriptInterface
    public g createInnerAudioContext() {
        return new g(this.bxv);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.b createBannerAd(JsObject jsObject) {
        return com.baidu.swan.apps.u.a.JK().b(this.bxv, jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.u.d getUpdateManager(JsObject jsObject) {
        if (this.bxY == null) {
            this.bxY = new com.baidu.swan.games.u.d(jsObject);
        }
        return this.bxY;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.websocket.c connectSocket(JsObject jsObject) {
        if (this.bya == null) {
            this.bya = new com.baidu.swan.games.network.websocket.a(this.bxv);
        }
        return this.bya.connectSocket(jsObject);
    }

    @JavascriptInterface
    public void setEnableDebug(JsObject jsObject) {
        if (this.byb == null) {
            this.byb = new com.baidu.swan.games.c.e(this.bxv);
        }
        this.byb.setEnableDebug(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.a.c request(JsObject jsObject) {
        return new com.baidu.swan.games.network.a.c(jsObject);
    }

    @JavascriptInterface
    public void openCustomerServiceConversation(JsObject jsObject) {
        com.baidu.swan.games.d.a.a((c) this.bxv.Wz(), jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.screenrecord.a getVideoRecorderManager() {
        if (this.byc == null) {
            this.byc = new com.baidu.swan.games.screenrecord.a(this.bxv);
        }
        return this.byc;
    }

    @JavascriptInterface
    public void shareVideo(JsObject jsObject) {
        new com.baidu.swan.games.q.b.a(jsObject).EV();
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return com.baidu.swan.apps.jsbridge.a.a.getEnvVariables();
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton(JsObject jsObject) {
        return new RecommendButtonApiProxy(this.bxv, jsObject);
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton() {
        return createRecommendationButton(null);
    }
}
