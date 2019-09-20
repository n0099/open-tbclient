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
    private d bfO;
    private com.baidu.swan.games.o.d bfP;
    private com.baidu.swan.games.o.b bfQ;
    private JsObject bfR;
    private e bfS;
    private com.baidu.swan.games.k.a bfT;
    private com.baidu.swan.games.k.b bfU;
    private com.baidu.swan.games.s.a bfV;
    private com.baidu.swan.games.u.d bfW;
    private com.baidu.swan.games.a.c bfX;
    private com.baidu.swan.games.network.websocket.a bfY;
    private com.baidu.swan.games.c.e bfZ;
    private com.baidu.swan.games.e.b bft;
    private com.baidu.swan.games.screenrecord.a bga;
    @V8JavascriptField
    public final String domain;
    @V8JavascriptField
    public com.baidu.swan.games.f.a env;

    public c(com.baidu.swan.games.e.b bVar) {
        super(bVar);
        this.domain = "main";
        this.bfR = null;
        this.bfS = null;
        this.bfT = null;
        this.bfU = null;
        this.bfW = null;
        this.bfX = null;
        this.bfY = null;
        this.bfZ = null;
        this.bga = null;
        this.bft = bVar;
        this.env = new com.baidu.swan.games.f.a();
        Rk();
    }

    private void Rk() {
        this.bfU = new com.baidu.swan.games.k.b(this.bft);
    }

    public void b(JsObject jsObject) {
        this.bfR = jsObject;
    }

    @JavascriptInterface
    public void setPreferredFramesPerSecond(short s) {
        if (s >= 1 && s <= 60) {
            this.bft.setPreferredFramesPerSecond(s);
        }
    }

    @JavascriptInterface
    public e getOpenDataContext() {
        if (this.bfS == null) {
            this.bfS = new e(this.bft);
            this.bfS.canvas = this.bfR;
            this.bfR = null;
        }
        return this.bfS;
    }

    @JavascriptInterface
    public d getFileSystemManager() {
        if (this.bfO == null) {
            this.bfO = new d((com.baidu.swan.games.e.a) this.bft);
        }
        return this.bfO;
    }

    @JavascriptInterface
    public com.baidu.swan.games.subpackage.d loadSubpackage(JsObject jsObject) {
        com.baidu.swan.games.subpackage.d dVar = new com.baidu.swan.games.subpackage.d(this.bft);
        dVar.l(jsObject);
        return dVar;
    }

    @JavascriptInterface
    public void exit(JsObject jsObject) {
        if (DEBUG) {
            this.bft.RM().log("exit from java side.");
        }
        if (jsObject != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            com.baidu.swan.games.binding.model.a e = com.baidu.swan.games.binding.model.a.e(com.baidu.swan.games.binding.model.c.c(jsObject));
            SwanAppActivity Gv = com.baidu.swan.apps.w.e.GJ().Gv();
            if (Gv == null) {
                bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "failed");
                e.L(bVar);
                e.onComplete();
                return;
            }
            bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "ok");
            e.onSuccess(bVar);
            e.onComplete();
            if (Build.VERSION.SDK_INT >= 21) {
                Gv.finishAndRemoveTask();
            } else {
                Gv.finish();
            }
        }
    }

    @JavascriptInterface
    public com.baidu.swan.games.o.d getOpenData() {
        if (this.bfP == null) {
            this.bfP = new com.baidu.swan.games.o.d((com.baidu.swan.games.e.a) this.bft);
        }
        return this.bfP;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        if (this.bfQ == null) {
            this.bfQ = new com.baidu.swan.games.o.b(this.bft);
        }
        this.bfQ.checkIsUserAdvisedToRest(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.c createRewardedVideoAd(JsObject jsObject) {
        if (this.bfX == null) {
            this.bfX = com.baidu.swan.apps.u.a.EP().a(this.bft, jsObject);
            if (this.bfX == null) {
                this.bfX = new com.baidu.swan.games.a.a();
            }
        }
        return this.bfX;
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.button.userinfo.b createUserInfoButton(JsObject jsObject) {
        return new com.baidu.swan.games.view.button.userinfo.b(jsObject, this.bft);
    }

    @JavascriptInterface
    public void showKeyboard(JsObject jsObject) {
        if (this.bfT == null) {
            this.bfT = new com.baidu.swan.games.k.a(this.bft, this.bfU);
        }
        this.bfT.showKeyboard(jsObject);
    }

    @JavascriptInterface
    public void showKeyboard() {
        if (this.bfT == null) {
            this.bfT = new com.baidu.swan.games.k.a(this.bft, this.bfU);
        }
        this.bfT.showKeyboard(null);
    }

    @JavascriptInterface
    public void updateKeyboard(JsObject jsObject) {
        if (this.bfT != null) {
            this.bfT.updateKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void updateKeyboard() {
        if (this.bfT != null) {
            this.bfT.updateKeyboard(null);
        }
    }

    @JavascriptInterface
    public void hideKeyboard(JsObject jsObject) {
        if (this.bfT != null) {
            this.bfT.hideKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void hideKeyboard() {
        if (this.bfT != null) {
            this.bfT.hideKeyboard(null);
        }
    }

    @JavascriptInterface
    public void getStorage(JsObject jsObject) {
        Rl().getStorage(jsObject);
    }

    @JavascriptInterface
    public Object getStorageSync(String str) {
        return com.baidu.swan.games.s.a.d.a(this.bft, "getStorageSync", str, Rl().jZ(str));
    }

    @JavascriptInterface
    public void setStorage(JsObject jsObject) {
        Rl().setStorage(jsObject);
    }

    @JavascriptInterface
    public void setStorageSync(String str, JsSerializeValue jsSerializeValue) {
        com.baidu.swan.games.s.a.d.a(this.bft, "setStorageSync", str, Rl().a(str, jsSerializeValue));
    }

    @JavascriptInterface
    public void setStorageSync(String str) {
        com.baidu.swan.games.s.a.d.a(this.bft, "setStorageSync", str, Rl().a(str, (JsSerializeValue) null));
    }

    @JavascriptInterface
    public void removeStorage(JsObject jsObject) {
        Rl().removeStorage(jsObject);
    }

    @JavascriptInterface
    public void removeStorageSync(String str) {
        com.baidu.swan.games.s.a.d.a(this.bft, "removeStorageSync", str, Rl().ka(str));
    }

    @JavascriptInterface
    public void clearStorage(JsObject jsObject) {
        Rl().clearStorage(jsObject);
    }

    @JavascriptInterface
    public void clearStorageSync() {
        com.baidu.swan.games.s.a.d.a(this.bft, "clearStorageSync", "", Rl().Tq());
    }

    @JavascriptInterface
    public void getStorageInfo(JsObject jsObject) {
        Rl().getStorageInfo(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.s.a.c getStorageInfoSync() {
        return Rl().getStorageInfoSync();
    }

    @NonNull
    private com.baidu.swan.games.s.a Rl() {
        if (this.bfV == null) {
            this.bfV = new com.baidu.swan.games.s.a(this.bft);
        }
        return this.bfV;
    }

    @JavascriptInterface
    public g createInnerAudioContext() {
        return new g(this.bft);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.b createBannerAd(JsObject jsObject) {
        return com.baidu.swan.apps.u.a.EP().b(this.bft, jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.u.d getUpdateManager(JsObject jsObject) {
        if (this.bfW == null) {
            this.bfW = new com.baidu.swan.games.u.d(jsObject);
        }
        return this.bfW;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.websocket.c connectSocket(JsObject jsObject) {
        if (this.bfY == null) {
            this.bfY = new com.baidu.swan.games.network.websocket.a(this.bft);
        }
        return this.bfY.connectSocket(jsObject);
    }

    @JavascriptInterface
    public void setEnableDebug(JsObject jsObject) {
        if (this.bfZ == null) {
            this.bfZ = new com.baidu.swan.games.c.e(this.bft);
        }
        this.bfZ.setEnableDebug(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.a.c request(JsObject jsObject) {
        return new com.baidu.swan.games.network.a.c(jsObject);
    }

    @JavascriptInterface
    public void openCustomerServiceConversation(JsObject jsObject) {
        com.baidu.swan.games.d.a.a((c) this.bft.RK(), jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.screenrecord.a getVideoRecorderManager() {
        if (this.bga == null) {
            this.bga = new com.baidu.swan.games.screenrecord.a(this.bft);
        }
        return this.bga;
    }

    @JavascriptInterface
    public void shareVideo(JsObject jsObject) {
        new com.baidu.swan.games.q.b.a(jsObject).zZ();
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return com.baidu.swan.apps.jsbridge.a.a.getEnvVariables();
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton(JsObject jsObject) {
        return new RecommendButtonApiProxy(this.bft, jsObject);
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton() {
        return createRecommendationButton(null);
    }
}
