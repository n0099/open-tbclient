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
import com.baidu.swan.games.audio.f;
import com.baidu.swan.games.f.d;
import com.baidu.swan.games.n.e;
/* loaded from: classes2.dex */
public final class c extends EventTargetImpl {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private d baI;
    private com.baidu.swan.games.n.d baJ;
    private com.baidu.swan.games.n.b baK;
    private JsObject baL;
    private e baM;
    private com.baidu.swan.games.j.a baN;
    private com.baidu.swan.games.j.b baO;
    private com.baidu.swan.games.q.a baP;
    private com.baidu.swan.games.s.d baQ;
    private com.baidu.swan.games.a.d baR;
    private com.baidu.swan.games.network.websocket.a baS;
    private com.baidu.swan.games.c.d baT;
    private com.baidu.swan.games.e.b bad;
    @V8JavascriptField
    public final String domain;
    @V8JavascriptField
    public com.baidu.swan.games.f.a env;

    public c(com.baidu.swan.games.e.b bVar) {
        super(bVar);
        this.domain = "main";
        this.baL = null;
        this.baM = null;
        this.baN = null;
        this.baO = null;
        this.baQ = null;
        this.baR = null;
        this.baS = null;
        this.baT = null;
        this.bad = bVar;
        this.env = new com.baidu.swan.games.f.a();
        Nx();
    }

    private void Nx() {
        this.baO = new com.baidu.swan.games.j.b(this.bad);
    }

    public void a(JsObject jsObject) {
        this.baL = jsObject;
    }

    @JavascriptInterface
    public void setPreferredFramesPerSecond(short s) {
        if (s >= 1 && s <= 60) {
            this.bad.setPreferredFramesPerSecond(s);
        }
    }

    @JavascriptInterface
    public e getOpenDataContext() {
        if (this.baM == null) {
            this.baM = new e(this.bad);
            this.baM.canvas = this.baL;
            this.baL = null;
        }
        return this.baM;
    }

    @JavascriptInterface
    public d getFileSystemManager() {
        if (this.baI == null) {
            this.baI = new d((com.baidu.swan.games.e.a) this.bad);
        }
        return this.baI;
    }

    @JavascriptInterface
    public com.baidu.swan.games.subpackage.d loadSubpackage(JsObject jsObject) {
        com.baidu.swan.games.subpackage.d dVar = new com.baidu.swan.games.subpackage.d(this.bad);
        dVar.k(jsObject);
        return dVar;
    }

    @JavascriptInterface
    public void exit(JsObject jsObject) {
        if (DEBUG) {
            this.bad.NV().log("exit from java side.");
        }
        if (jsObject != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            com.baidu.swan.games.binding.model.a a = com.baidu.swan.games.binding.model.a.a(com.baidu.swan.games.binding.model.c.b(jsObject));
            SwanAppActivity DM = com.baidu.swan.apps.w.e.Ea().DM();
            if (DM == null) {
                bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "failed");
                a.L(bVar);
                a.onComplete();
                return;
            }
            bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "ok");
            a.onSuccess(bVar);
            a.onComplete();
            if (Build.VERSION.SDK_INT >= 21) {
                DM.finishAndRemoveTask();
            } else {
                DM.finish();
            }
        }
    }

    @JavascriptInterface
    public com.baidu.swan.games.n.d getOpenData() {
        if (this.baJ == null) {
            this.baJ = new com.baidu.swan.games.n.d((com.baidu.swan.games.e.a) this.bad);
        }
        return this.baJ;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        if (this.baK == null) {
            this.baK = new com.baidu.swan.games.n.b(this.bad);
        }
        this.baK.checkIsUserAdvisedToRest(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.d createRewardedVideoAd(JsObject jsObject) {
        if (this.baR == null) {
            this.baR = com.baidu.swan.apps.u.a.CX().a(this.bad, jsObject);
            if (this.baR == null) {
                this.baR = new com.baidu.swan.games.a.b();
            }
        }
        return this.baR;
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.button.userinfo.b createUserInfoButton(JsObject jsObject) {
        return new com.baidu.swan.games.view.button.userinfo.b(jsObject, this.bad);
    }

    @JavascriptInterface
    public void showKeyboard(JsObject jsObject) {
        if (this.baN == null) {
            this.baN = new com.baidu.swan.games.j.a(this.bad, this.baO);
        }
        this.baN.showKeyboard(jsObject);
    }

    @JavascriptInterface
    public void showKeyboard() {
        if (this.baN == null) {
            this.baN = new com.baidu.swan.games.j.a(this.bad, this.baO);
        }
        this.baN.showKeyboard(null);
    }

    @JavascriptInterface
    public void updateKeyboard(JsObject jsObject) {
        if (this.baN != null) {
            this.baN.updateKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void updateKeyboard() {
        if (this.baN != null) {
            this.baN.updateKeyboard(null);
        }
    }

    @JavascriptInterface
    public void hideKeyboard(JsObject jsObject) {
        if (this.baN != null) {
            this.baN.hideKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void hideKeyboard() {
        if (this.baN != null) {
            this.baN.hideKeyboard(null);
        }
    }

    @JavascriptInterface
    public void getStorage(JsObject jsObject) {
        Ny().getStorage(jsObject);
    }

    @JavascriptInterface
    public Object getStorageSync(String str) {
        return com.baidu.swan.games.q.a.d.a(this.bad, "getStorageSync", Ny().iX(str));
    }

    @JavascriptInterface
    public void setStorage(JsObject jsObject) {
        Ny().setStorage(jsObject);
    }

    @JavascriptInterface
    public void setStorageSync(String str, JsSerializeValue jsSerializeValue) {
        com.baidu.swan.games.q.a.d.a(this.bad, "setStorageSync", Ny().a(str, jsSerializeValue));
    }

    @JavascriptInterface
    public void setStorageSync(String str) {
        com.baidu.swan.games.q.a.d.a(this.bad, "setStorageSync", Ny().a(str, (JsSerializeValue) null));
    }

    @JavascriptInterface
    public void removeStorage(JsObject jsObject) {
        Ny().removeStorage(jsObject);
    }

    @JavascriptInterface
    public void removeStorageSync(String str) {
        com.baidu.swan.games.q.a.d.a(this.bad, "removeStorageSync", Ny().iY(str));
    }

    @JavascriptInterface
    public void clearStorage(JsObject jsObject) {
        Ny().clearStorage(jsObject);
    }

    @JavascriptInterface
    public void clearStorageSync() {
        com.baidu.swan.games.q.a.d.a(this.bad, "clearStorageSync", Ny().Pa());
    }

    @JavascriptInterface
    public void getStorageInfo(JsObject jsObject) {
        Ny().getStorageInfo(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.q.a.c getStorageInfoSync() {
        return Ny().getStorageInfoSync();
    }

    @NonNull
    private com.baidu.swan.games.q.a Ny() {
        if (this.baP == null) {
            this.baP = new com.baidu.swan.games.q.a(this.bad);
        }
        return this.baP;
    }

    @JavascriptInterface
    public f createInnerAudioContext() {
        return new f(this.bad);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.c createBannerAd(JsObject jsObject) {
        return com.baidu.swan.apps.u.a.CX().b(this.bad, jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.s.d getUpdateManager(JsObject jsObject) {
        if (this.baQ == null) {
            this.baQ = new com.baidu.swan.games.s.d(jsObject);
        }
        return this.baQ;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.websocket.c connectSocket(JsObject jsObject) {
        if (this.baS == null) {
            this.baS = new com.baidu.swan.games.network.websocket.a(this.bad);
        }
        return this.baS.connectSocket(jsObject);
    }

    @JavascriptInterface
    public void setEnableDebug(JsObject jsObject) {
        if (this.baT == null) {
            this.baT = new com.baidu.swan.games.c.d(this.bad);
        }
        this.baT.setEnableDebug(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.a.b request(JsObject jsObject) {
        return new com.baidu.swan.games.network.a.b(jsObject);
    }

    @JavascriptInterface
    public void openCustomerServiceConversation(JsObject jsObject) {
        com.baidu.swan.games.d.a.a((c) this.bad.NT(), jsObject);
    }
}
