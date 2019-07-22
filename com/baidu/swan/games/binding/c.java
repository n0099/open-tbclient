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
import com.baidu.swan.games.c.e;
import com.baidu.swan.games.f.d;
import com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy;
/* loaded from: classes2.dex */
public final class c extends EventTargetImpl {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.e.b beU;
    private com.baidu.swan.games.network.websocket.a bfA;
    private e bfB;
    private com.baidu.swan.games.screenrecord.a bfC;
    private d bfq;
    private com.baidu.swan.games.o.d bfr;
    private com.baidu.swan.games.o.b bfs;
    private JsObject bft;
    private com.baidu.swan.games.o.e bfu;
    private com.baidu.swan.games.k.a bfv;
    private com.baidu.swan.games.k.b bfw;
    private com.baidu.swan.games.s.a bfx;
    private com.baidu.swan.games.u.d bfy;
    private com.baidu.swan.games.a.c bfz;
    @V8JavascriptField
    public final String domain;
    @V8JavascriptField
    public com.baidu.swan.games.f.a env;

    public c(com.baidu.swan.games.e.b bVar) {
        super(bVar);
        this.domain = "main";
        this.bft = null;
        this.bfu = null;
        this.bfv = null;
        this.bfw = null;
        this.bfy = null;
        this.bfz = null;
        this.bfA = null;
        this.bfB = null;
        this.bfC = null;
        this.beU = bVar;
        this.env = new com.baidu.swan.games.f.a();
        Rg();
    }

    private void Rg() {
        this.bfw = new com.baidu.swan.games.k.b(this.beU);
    }

    public void b(JsObject jsObject) {
        this.bft = jsObject;
    }

    @JavascriptInterface
    public void setPreferredFramesPerSecond(short s) {
        if (s >= 1 && s <= 60) {
            this.beU.setPreferredFramesPerSecond(s);
        }
    }

    @JavascriptInterface
    public com.baidu.swan.games.o.e getOpenDataContext() {
        if (this.bfu == null) {
            this.bfu = new com.baidu.swan.games.o.e(this.beU);
            this.bfu.canvas = this.bft;
            this.bft = null;
        }
        return this.bfu;
    }

    @JavascriptInterface
    public d getFileSystemManager() {
        if (this.bfq == null) {
            this.bfq = new d((com.baidu.swan.games.e.a) this.beU);
        }
        return this.bfq;
    }

    @JavascriptInterface
    public com.baidu.swan.games.subpackage.d loadSubpackage(JsObject jsObject) {
        com.baidu.swan.games.subpackage.d dVar = new com.baidu.swan.games.subpackage.d(this.beU);
        dVar.l(jsObject);
        return dVar;
    }

    @JavascriptInterface
    public void exit(JsObject jsObject) {
        if (DEBUG) {
            this.beU.RI().log("exit from java side.");
        }
        if (jsObject != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            com.baidu.swan.games.binding.model.a e = com.baidu.swan.games.binding.model.a.e(com.baidu.swan.games.binding.model.c.c(jsObject));
            SwanAppActivity Gr = com.baidu.swan.apps.w.e.GF().Gr();
            if (Gr == null) {
                bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "failed");
                e.L(bVar);
                e.onComplete();
                return;
            }
            bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "ok");
            e.onSuccess(bVar);
            e.onComplete();
            if (Build.VERSION.SDK_INT >= 21) {
                Gr.finishAndRemoveTask();
            } else {
                Gr.finish();
            }
        }
    }

    @JavascriptInterface
    public com.baidu.swan.games.o.d getOpenData() {
        if (this.bfr == null) {
            this.bfr = new com.baidu.swan.games.o.d((com.baidu.swan.games.e.a) this.beU);
        }
        return this.bfr;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        if (this.bfs == null) {
            this.bfs = new com.baidu.swan.games.o.b(this.beU);
        }
        this.bfs.checkIsUserAdvisedToRest(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.c createRewardedVideoAd(JsObject jsObject) {
        if (this.bfz == null) {
            this.bfz = com.baidu.swan.apps.u.a.EL().a(this.beU, jsObject);
            if (this.bfz == null) {
                this.bfz = new com.baidu.swan.games.a.a();
            }
        }
        return this.bfz;
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.button.userinfo.b createUserInfoButton(JsObject jsObject) {
        return new com.baidu.swan.games.view.button.userinfo.b(jsObject, this.beU);
    }

    @JavascriptInterface
    public void showKeyboard(JsObject jsObject) {
        if (this.bfv == null) {
            this.bfv = new com.baidu.swan.games.k.a(this.beU, this.bfw);
        }
        this.bfv.showKeyboard(jsObject);
    }

    @JavascriptInterface
    public void showKeyboard() {
        if (this.bfv == null) {
            this.bfv = new com.baidu.swan.games.k.a(this.beU, this.bfw);
        }
        this.bfv.showKeyboard(null);
    }

    @JavascriptInterface
    public void updateKeyboard(JsObject jsObject) {
        if (this.bfv != null) {
            this.bfv.updateKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void updateKeyboard() {
        if (this.bfv != null) {
            this.bfv.updateKeyboard(null);
        }
    }

    @JavascriptInterface
    public void hideKeyboard(JsObject jsObject) {
        if (this.bfv != null) {
            this.bfv.hideKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void hideKeyboard() {
        if (this.bfv != null) {
            this.bfv.hideKeyboard(null);
        }
    }

    @JavascriptInterface
    public void getStorage(JsObject jsObject) {
        Rh().getStorage(jsObject);
    }

    @JavascriptInterface
    public Object getStorageSync(String str) {
        return com.baidu.swan.games.s.a.d.a(this.beU, "getStorageSync", str, Rh().jX(str));
    }

    @JavascriptInterface
    public void setStorage(JsObject jsObject) {
        Rh().setStorage(jsObject);
    }

    @JavascriptInterface
    public void setStorageSync(String str, JsSerializeValue jsSerializeValue) {
        com.baidu.swan.games.s.a.d.a(this.beU, "setStorageSync", str, Rh().a(str, jsSerializeValue));
    }

    @JavascriptInterface
    public void setStorageSync(String str) {
        com.baidu.swan.games.s.a.d.a(this.beU, "setStorageSync", str, Rh().a(str, (JsSerializeValue) null));
    }

    @JavascriptInterface
    public void removeStorage(JsObject jsObject) {
        Rh().removeStorage(jsObject);
    }

    @JavascriptInterface
    public void removeStorageSync(String str) {
        com.baidu.swan.games.s.a.d.a(this.beU, "removeStorageSync", str, Rh().jY(str));
    }

    @JavascriptInterface
    public void clearStorage(JsObject jsObject) {
        Rh().clearStorage(jsObject);
    }

    @JavascriptInterface
    public void clearStorageSync() {
        com.baidu.swan.games.s.a.d.a(this.beU, "clearStorageSync", "", Rh().Tm());
    }

    @JavascriptInterface
    public void getStorageInfo(JsObject jsObject) {
        Rh().getStorageInfo(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.s.a.c getStorageInfoSync() {
        return Rh().getStorageInfoSync();
    }

    @NonNull
    private com.baidu.swan.games.s.a Rh() {
        if (this.bfx == null) {
            this.bfx = new com.baidu.swan.games.s.a(this.beU);
        }
        return this.bfx;
    }

    @JavascriptInterface
    public g createInnerAudioContext() {
        return new g(this.beU);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.b createBannerAd(JsObject jsObject) {
        return com.baidu.swan.apps.u.a.EL().b(this.beU, jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.u.d getUpdateManager(JsObject jsObject) {
        if (this.bfy == null) {
            this.bfy = new com.baidu.swan.games.u.d(jsObject);
        }
        return this.bfy;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.websocket.c connectSocket(JsObject jsObject) {
        if (this.bfA == null) {
            this.bfA = new com.baidu.swan.games.network.websocket.a(this.beU);
        }
        return this.bfA.connectSocket(jsObject);
    }

    @JavascriptInterface
    public void setEnableDebug(JsObject jsObject) {
        if (this.bfB == null) {
            this.bfB = new e(this.beU);
        }
        this.bfB.setEnableDebug(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.a.c request(JsObject jsObject) {
        return new com.baidu.swan.games.network.a.c(jsObject);
    }

    @JavascriptInterface
    public void openCustomerServiceConversation(JsObject jsObject) {
        com.baidu.swan.games.d.a.a((c) this.beU.RG(), jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.screenrecord.a getVideoRecorderManager() {
        if (this.bfC == null) {
            this.bfC = new com.baidu.swan.games.screenrecord.a(this.beU);
        }
        return this.bfC;
    }

    @JavascriptInterface
    public void shareVideo(JsObject jsObject) {
        new com.baidu.swan.games.q.b.a(jsObject).zV();
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return com.baidu.swan.apps.jsbridge.a.a.getEnvVariables();
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton(JsObject jsObject) {
        return new RecommendButtonApiProxy(this.beU, jsObject);
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton() {
        return createRecommendationButton(null);
    }
}
