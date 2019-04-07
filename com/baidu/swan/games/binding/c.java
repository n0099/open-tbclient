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
    private d baH;
    private com.baidu.swan.games.n.d baI;
    private com.baidu.swan.games.n.b baJ;
    private JsObject baK;
    private e baL;
    private com.baidu.swan.games.j.a baM;
    private com.baidu.swan.games.j.b baN;
    private com.baidu.swan.games.q.a baO;
    private com.baidu.swan.games.s.d baP;
    private com.baidu.swan.games.a.d baQ;
    private com.baidu.swan.games.network.websocket.a baR;
    private com.baidu.swan.games.c.d baS;
    private com.baidu.swan.games.e.b bac;
    @V8JavascriptField
    public final String domain;
    @V8JavascriptField
    public com.baidu.swan.games.f.a env;

    public c(com.baidu.swan.games.e.b bVar) {
        super(bVar);
        this.domain = "main";
        this.baK = null;
        this.baL = null;
        this.baM = null;
        this.baN = null;
        this.baP = null;
        this.baQ = null;
        this.baR = null;
        this.baS = null;
        this.bac = bVar;
        this.env = new com.baidu.swan.games.f.a();
        Nx();
    }

    private void Nx() {
        this.baN = new com.baidu.swan.games.j.b(this.bac);
    }

    public void a(JsObject jsObject) {
        this.baK = jsObject;
    }

    @JavascriptInterface
    public void setPreferredFramesPerSecond(short s) {
        if (s >= 1 && s <= 60) {
            this.bac.setPreferredFramesPerSecond(s);
        }
    }

    @JavascriptInterface
    public e getOpenDataContext() {
        if (this.baL == null) {
            this.baL = new e(this.bac);
            this.baL.canvas = this.baK;
            this.baK = null;
        }
        return this.baL;
    }

    @JavascriptInterface
    public d getFileSystemManager() {
        if (this.baH == null) {
            this.baH = new d((com.baidu.swan.games.e.a) this.bac);
        }
        return this.baH;
    }

    @JavascriptInterface
    public com.baidu.swan.games.subpackage.d loadSubpackage(JsObject jsObject) {
        com.baidu.swan.games.subpackage.d dVar = new com.baidu.swan.games.subpackage.d(this.bac);
        dVar.k(jsObject);
        return dVar;
    }

    @JavascriptInterface
    public void exit(JsObject jsObject) {
        if (DEBUG) {
            this.bac.NV().log("exit from java side.");
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
        if (this.baI == null) {
            this.baI = new com.baidu.swan.games.n.d((com.baidu.swan.games.e.a) this.bac);
        }
        return this.baI;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        if (this.baJ == null) {
            this.baJ = new com.baidu.swan.games.n.b(this.bac);
        }
        this.baJ.checkIsUserAdvisedToRest(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.d createRewardedVideoAd(JsObject jsObject) {
        if (this.baQ == null) {
            this.baQ = com.baidu.swan.apps.u.a.CX().a(this.bac, jsObject);
            if (this.baQ == null) {
                this.baQ = new com.baidu.swan.games.a.b();
            }
        }
        return this.baQ;
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.button.userinfo.b createUserInfoButton(JsObject jsObject) {
        return new com.baidu.swan.games.view.button.userinfo.b(jsObject, this.bac);
    }

    @JavascriptInterface
    public void showKeyboard(JsObject jsObject) {
        if (this.baM == null) {
            this.baM = new com.baidu.swan.games.j.a(this.bac, this.baN);
        }
        this.baM.showKeyboard(jsObject);
    }

    @JavascriptInterface
    public void showKeyboard() {
        if (this.baM == null) {
            this.baM = new com.baidu.swan.games.j.a(this.bac, this.baN);
        }
        this.baM.showKeyboard(null);
    }

    @JavascriptInterface
    public void updateKeyboard(JsObject jsObject) {
        if (this.baM != null) {
            this.baM.updateKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void updateKeyboard() {
        if (this.baM != null) {
            this.baM.updateKeyboard(null);
        }
    }

    @JavascriptInterface
    public void hideKeyboard(JsObject jsObject) {
        if (this.baM != null) {
            this.baM.hideKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void hideKeyboard() {
        if (this.baM != null) {
            this.baM.hideKeyboard(null);
        }
    }

    @JavascriptInterface
    public void getStorage(JsObject jsObject) {
        Ny().getStorage(jsObject);
    }

    @JavascriptInterface
    public Object getStorageSync(String str) {
        return com.baidu.swan.games.q.a.d.a(this.bac, "getStorageSync", Ny().iX(str));
    }

    @JavascriptInterface
    public void setStorage(JsObject jsObject) {
        Ny().setStorage(jsObject);
    }

    @JavascriptInterface
    public void setStorageSync(String str, JsSerializeValue jsSerializeValue) {
        com.baidu.swan.games.q.a.d.a(this.bac, "setStorageSync", Ny().a(str, jsSerializeValue));
    }

    @JavascriptInterface
    public void setStorageSync(String str) {
        com.baidu.swan.games.q.a.d.a(this.bac, "setStorageSync", Ny().a(str, (JsSerializeValue) null));
    }

    @JavascriptInterface
    public void removeStorage(JsObject jsObject) {
        Ny().removeStorage(jsObject);
    }

    @JavascriptInterface
    public void removeStorageSync(String str) {
        com.baidu.swan.games.q.a.d.a(this.bac, "removeStorageSync", Ny().iY(str));
    }

    @JavascriptInterface
    public void clearStorage(JsObject jsObject) {
        Ny().clearStorage(jsObject);
    }

    @JavascriptInterface
    public void clearStorageSync() {
        com.baidu.swan.games.q.a.d.a(this.bac, "clearStorageSync", Ny().Pa());
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
        if (this.baO == null) {
            this.baO = new com.baidu.swan.games.q.a(this.bac);
        }
        return this.baO;
    }

    @JavascriptInterface
    public f createInnerAudioContext() {
        return new f(this.bac);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.c createBannerAd(JsObject jsObject) {
        return com.baidu.swan.apps.u.a.CX().b(this.bac, jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.s.d getUpdateManager(JsObject jsObject) {
        if (this.baP == null) {
            this.baP = new com.baidu.swan.games.s.d(jsObject);
        }
        return this.baP;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.websocket.c connectSocket(JsObject jsObject) {
        if (this.baR == null) {
            this.baR = new com.baidu.swan.games.network.websocket.a(this.bac);
        }
        return this.baR.connectSocket(jsObject);
    }

    @JavascriptInterface
    public void setEnableDebug(JsObject jsObject) {
        if (this.baS == null) {
            this.baS = new com.baidu.swan.games.c.d(this.bac);
        }
        this.baS.setEnableDebug(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.a.b request(JsObject jsObject) {
        return new com.baidu.swan.games.network.a.b(jsObject);
    }

    @JavascriptInterface
    public void openCustomerServiceConversation(JsObject jsObject) {
        com.baidu.swan.games.d.a.a((c) this.bac.NT(), jsObject);
    }
}
