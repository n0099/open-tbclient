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
    private d beD;
    private com.baidu.swan.games.o.d beE;
    private com.baidu.swan.games.o.b beF;
    private JsObject beG;
    private e beH;
    private com.baidu.swan.games.k.a beI;
    private com.baidu.swan.games.k.b beJ;
    private com.baidu.swan.games.s.a beK;
    private com.baidu.swan.games.u.d beL;
    private com.baidu.swan.games.a.c beM;
    private com.baidu.swan.games.network.websocket.a beN;
    private com.baidu.swan.games.c.e beO;
    private com.baidu.swan.games.screenrecord.a beP;
    private com.baidu.swan.games.e.b beh;
    @V8JavascriptField
    public final String domain;
    @V8JavascriptField
    public com.baidu.swan.games.f.a env;

    public c(com.baidu.swan.games.e.b bVar) {
        super(bVar);
        this.domain = "main";
        this.beG = null;
        this.beH = null;
        this.beI = null;
        this.beJ = null;
        this.beL = null;
        this.beM = null;
        this.beN = null;
        this.beO = null;
        this.beP = null;
        this.beh = bVar;
        this.env = new com.baidu.swan.games.f.a();
        Qo();
    }

    private void Qo() {
        this.beJ = new com.baidu.swan.games.k.b(this.beh);
    }

    public void b(JsObject jsObject) {
        this.beG = jsObject;
    }

    @JavascriptInterface
    public void setPreferredFramesPerSecond(short s) {
        if (s >= 1 && s <= 60) {
            this.beh.setPreferredFramesPerSecond(s);
        }
    }

    @JavascriptInterface
    public e getOpenDataContext() {
        if (this.beH == null) {
            this.beH = new e(this.beh);
            this.beH.canvas = this.beG;
            this.beG = null;
        }
        return this.beH;
    }

    @JavascriptInterface
    public d getFileSystemManager() {
        if (this.beD == null) {
            this.beD = new d((com.baidu.swan.games.e.a) this.beh);
        }
        return this.beD;
    }

    @JavascriptInterface
    public com.baidu.swan.games.subpackage.d loadSubpackage(JsObject jsObject) {
        com.baidu.swan.games.subpackage.d dVar = new com.baidu.swan.games.subpackage.d(this.beh);
        dVar.l(jsObject);
        return dVar;
    }

    @JavascriptInterface
    public void exit(JsObject jsObject) {
        if (DEBUG) {
            this.beh.QP().log("exit from java side.");
        }
        if (jsObject != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            com.baidu.swan.games.binding.model.a e = com.baidu.swan.games.binding.model.a.e(com.baidu.swan.games.binding.model.c.c(jsObject));
            SwanAppActivity FH = com.baidu.swan.apps.w.e.FV().FH();
            if (FH == null) {
                bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "failed");
                e.L(bVar);
                e.onComplete();
                return;
            }
            bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "ok");
            e.onSuccess(bVar);
            e.onComplete();
            if (Build.VERSION.SDK_INT >= 21) {
                FH.finishAndRemoveTask();
            } else {
                FH.finish();
            }
        }
    }

    @JavascriptInterface
    public com.baidu.swan.games.o.d getOpenData() {
        if (this.beE == null) {
            this.beE = new com.baidu.swan.games.o.d((com.baidu.swan.games.e.a) this.beh);
        }
        return this.beE;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        if (this.beF == null) {
            this.beF = new com.baidu.swan.games.o.b(this.beh);
        }
        this.beF.checkIsUserAdvisedToRest(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.c createRewardedVideoAd(JsObject jsObject) {
        if (this.beM == null) {
            this.beM = com.baidu.swan.apps.u.a.Ec().a(this.beh, jsObject);
            if (this.beM == null) {
                this.beM = new com.baidu.swan.games.a.a();
            }
        }
        return this.beM;
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.button.userinfo.b createUserInfoButton(JsObject jsObject) {
        return new com.baidu.swan.games.view.button.userinfo.b(jsObject, this.beh);
    }

    @JavascriptInterface
    public void showKeyboard(JsObject jsObject) {
        if (this.beI == null) {
            this.beI = new com.baidu.swan.games.k.a(this.beh, this.beJ);
        }
        this.beI.showKeyboard(jsObject);
    }

    @JavascriptInterface
    public void showKeyboard() {
        if (this.beI == null) {
            this.beI = new com.baidu.swan.games.k.a(this.beh, this.beJ);
        }
        this.beI.showKeyboard(null);
    }

    @JavascriptInterface
    public void updateKeyboard(JsObject jsObject) {
        if (this.beI != null) {
            this.beI.updateKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void updateKeyboard() {
        if (this.beI != null) {
            this.beI.updateKeyboard(null);
        }
    }

    @JavascriptInterface
    public void hideKeyboard(JsObject jsObject) {
        if (this.beI != null) {
            this.beI.hideKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void hideKeyboard() {
        if (this.beI != null) {
            this.beI.hideKeyboard(null);
        }
    }

    @JavascriptInterface
    public void getStorage(JsObject jsObject) {
        Qp().getStorage(jsObject);
    }

    @JavascriptInterface
    public Object getStorageSync(String str) {
        return com.baidu.swan.games.s.a.d.a(this.beh, "getStorageSync", str, Qp().jQ(str));
    }

    @JavascriptInterface
    public void setStorage(JsObject jsObject) {
        Qp().setStorage(jsObject);
    }

    @JavascriptInterface
    public void setStorageSync(String str, JsSerializeValue jsSerializeValue) {
        com.baidu.swan.games.s.a.d.a(this.beh, "setStorageSync", str, Qp().a(str, jsSerializeValue));
    }

    @JavascriptInterface
    public void setStorageSync(String str) {
        com.baidu.swan.games.s.a.d.a(this.beh, "setStorageSync", str, Qp().a(str, (JsSerializeValue) null));
    }

    @JavascriptInterface
    public void removeStorage(JsObject jsObject) {
        Qp().removeStorage(jsObject);
    }

    @JavascriptInterface
    public void removeStorageSync(String str) {
        com.baidu.swan.games.s.a.d.a(this.beh, "removeStorageSync", str, Qp().jR(str));
    }

    @JavascriptInterface
    public void clearStorage(JsObject jsObject) {
        Qp().clearStorage(jsObject);
    }

    @JavascriptInterface
    public void clearStorageSync() {
        com.baidu.swan.games.s.a.d.a(this.beh, "clearStorageSync", "", Qp().St());
    }

    @JavascriptInterface
    public void getStorageInfo(JsObject jsObject) {
        Qp().getStorageInfo(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.s.a.c getStorageInfoSync() {
        return Qp().getStorageInfoSync();
    }

    @NonNull
    private com.baidu.swan.games.s.a Qp() {
        if (this.beK == null) {
            this.beK = new com.baidu.swan.games.s.a(this.beh);
        }
        return this.beK;
    }

    @JavascriptInterface
    public g createInnerAudioContext() {
        return new g(this.beh);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.b createBannerAd(JsObject jsObject) {
        return com.baidu.swan.apps.u.a.Ec().b(this.beh, jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.u.d getUpdateManager(JsObject jsObject) {
        if (this.beL == null) {
            this.beL = new com.baidu.swan.games.u.d(jsObject);
        }
        return this.beL;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.websocket.c connectSocket(JsObject jsObject) {
        if (this.beN == null) {
            this.beN = new com.baidu.swan.games.network.websocket.a(this.beh);
        }
        return this.beN.connectSocket(jsObject);
    }

    @JavascriptInterface
    public void setEnableDebug(JsObject jsObject) {
        if (this.beO == null) {
            this.beO = new com.baidu.swan.games.c.e(this.beh);
        }
        this.beO.setEnableDebug(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.a.c request(JsObject jsObject) {
        return new com.baidu.swan.games.network.a.c(jsObject);
    }

    @JavascriptInterface
    public void openCustomerServiceConversation(JsObject jsObject) {
        com.baidu.swan.games.d.a.a((c) this.beh.QN(), jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.screenrecord.a getVideoRecorderManager() {
        if (this.beP == null) {
            this.beP = new com.baidu.swan.games.screenrecord.a(this.beh);
        }
        return this.beP;
    }

    @JavascriptInterface
    public void shareVideo(JsObject jsObject) {
        new com.baidu.swan.games.q.b.a(jsObject).zo();
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return com.baidu.swan.apps.jsbridge.a.a.getEnvVariables();
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton(JsObject jsObject) {
        return new RecommendButtonApiProxy(this.beh, jsObject);
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton() {
        return createRecommendationButton(null);
    }
}
