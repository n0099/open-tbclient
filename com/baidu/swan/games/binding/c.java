package com.baidu.swan.games.binding;

import android.os.Build;
import android.support.annotation.NonNull;
import android.webkit.JavascriptInterface;
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
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private com.baidu.swan.games.e.b aZY;
    private d baD;
    private com.baidu.swan.games.n.d baE;
    private com.baidu.swan.games.n.b baF;
    private JsObject baG;
    private e baH;
    private com.baidu.swan.games.j.a baI;
    private com.baidu.swan.games.j.b baJ;
    private com.baidu.swan.games.q.a baK;
    private com.baidu.swan.games.s.d baL;
    private com.baidu.swan.games.a.d baM;
    private com.baidu.swan.games.network.websocket.a baN;
    private com.baidu.swan.games.c.d baO;
    @V8JavascriptField
    public final String domain;
    @V8JavascriptField
    public com.baidu.swan.games.f.a env;

    public c(com.baidu.swan.games.e.b bVar) {
        super(bVar);
        this.domain = "main";
        this.baG = null;
        this.baH = null;
        this.baI = null;
        this.baJ = null;
        this.baL = null;
        this.baM = null;
        this.baN = null;
        this.baO = null;
        this.aZY = bVar;
        this.env = new com.baidu.swan.games.f.a();
        Nz();
    }

    private void Nz() {
        this.baJ = new com.baidu.swan.games.j.b(this.aZY);
    }

    public void a(JsObject jsObject) {
        this.baG = jsObject;
    }

    @JavascriptInterface
    public void setPreferredFramesPerSecond(short s) {
        if (s >= 1 && s <= 60) {
            this.aZY.setPreferredFramesPerSecond(s);
        }
    }

    @JavascriptInterface
    public e getOpenDataContext() {
        if (this.baH == null) {
            this.baH = new e(this.aZY);
            this.baH.canvas = this.baG;
            this.baG = null;
        }
        return this.baH;
    }

    @JavascriptInterface
    public d getFileSystemManager() {
        if (this.baD == null) {
            this.baD = new d((com.baidu.swan.games.e.a) this.aZY);
        }
        return this.baD;
    }

    @JavascriptInterface
    public com.baidu.swan.games.subpackage.d loadSubpackage(JsObject jsObject) {
        com.baidu.swan.games.subpackage.d dVar = new com.baidu.swan.games.subpackage.d(this.aZY);
        dVar.k(jsObject);
        return dVar;
    }

    @JavascriptInterface
    public void exit(JsObject jsObject) {
        if (DEBUG) {
            this.aZY.NX().log("exit from java side.");
        }
        if (jsObject != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            com.baidu.swan.games.binding.model.a a = com.baidu.swan.games.binding.model.a.a(com.baidu.swan.games.binding.model.c.b(jsObject));
            SwanAppActivity DO = com.baidu.swan.apps.w.e.Ec().DO();
            if (DO == null) {
                bVar.errMsg = String.format("%s:%s", "exit", "failed");
                a.L(bVar);
                a.onComplete();
                return;
            }
            bVar.errMsg = String.format("%s:%s", "exit", "ok");
            a.onSuccess(bVar);
            a.onComplete();
            if (Build.VERSION.SDK_INT >= 21) {
                DO.finishAndRemoveTask();
            } else {
                DO.finish();
            }
        }
    }

    @JavascriptInterface
    public com.baidu.swan.games.n.d getOpenData() {
        if (this.baE == null) {
            this.baE = new com.baidu.swan.games.n.d((com.baidu.swan.games.e.a) this.aZY);
        }
        return this.baE;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        if (this.baF == null) {
            this.baF = new com.baidu.swan.games.n.b(this.aZY);
        }
        this.baF.checkIsUserAdvisedToRest(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.d createRewardedVideoAd(JsObject jsObject) {
        if (this.baM == null) {
            this.baM = com.baidu.swan.apps.u.a.CZ().a(this.aZY, jsObject);
            if (this.baM == null) {
                this.baM = new com.baidu.swan.games.a.b();
            }
        }
        return this.baM;
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.button.userinfo.b createUserInfoButton(JsObject jsObject) {
        return new com.baidu.swan.games.view.button.userinfo.b(jsObject, this.aZY);
    }

    @JavascriptInterface
    public void showKeyboard(JsObject jsObject) {
        if (this.baI == null) {
            this.baI = new com.baidu.swan.games.j.a(this.aZY, this.baJ);
        }
        this.baI.showKeyboard(jsObject);
    }

    @JavascriptInterface
    public void showKeyboard() {
        if (this.baI == null) {
            this.baI = new com.baidu.swan.games.j.a(this.aZY, this.baJ);
        }
        this.baI.showKeyboard(null);
    }

    @JavascriptInterface
    public void updateKeyboard(JsObject jsObject) {
        if (this.baI != null) {
            this.baI.updateKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void updateKeyboard() {
        if (this.baI != null) {
            this.baI.updateKeyboard(null);
        }
    }

    @JavascriptInterface
    public void hideKeyboard(JsObject jsObject) {
        if (this.baI != null) {
            this.baI.hideKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void hideKeyboard() {
        if (this.baI != null) {
            this.baI.hideKeyboard(null);
        }
    }

    @JavascriptInterface
    public void getStorage(JsObject jsObject) {
        NA().getStorage(jsObject);
    }

    @JavascriptInterface
    public Object getStorageSync(String str) {
        return com.baidu.swan.games.q.a.d.a(this.aZY, "getStorageSync", NA().iW(str));
    }

    @JavascriptInterface
    public void setStorage(JsObject jsObject) {
        NA().setStorage(jsObject);
    }

    @JavascriptInterface
    public void setStorageSync(String str, JsSerializeValue jsSerializeValue) {
        com.baidu.swan.games.q.a.d.a(this.aZY, "setStorageSync", NA().a(str, jsSerializeValue));
    }

    @JavascriptInterface
    public void setStorageSync(String str) {
        com.baidu.swan.games.q.a.d.a(this.aZY, "setStorageSync", NA().a(str, (JsSerializeValue) null));
    }

    @JavascriptInterface
    public void removeStorage(JsObject jsObject) {
        NA().removeStorage(jsObject);
    }

    @JavascriptInterface
    public void removeStorageSync(String str) {
        com.baidu.swan.games.q.a.d.a(this.aZY, "removeStorageSync", NA().iX(str));
    }

    @JavascriptInterface
    public void clearStorage(JsObject jsObject) {
        NA().clearStorage(jsObject);
    }

    @JavascriptInterface
    public void clearStorageSync() {
        com.baidu.swan.games.q.a.d.a(this.aZY, "clearStorageSync", NA().Pc());
    }

    @JavascriptInterface
    public void getStorageInfo(JsObject jsObject) {
        NA().getStorageInfo(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.q.a.c getStorageInfoSync() {
        return NA().getStorageInfoSync();
    }

    @NonNull
    private com.baidu.swan.games.q.a NA() {
        if (this.baK == null) {
            this.baK = new com.baidu.swan.games.q.a(this.aZY);
        }
        return this.baK;
    }

    @JavascriptInterface
    public f createInnerAudioContext() {
        return new f(this.aZY);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.c createBannerAd(JsObject jsObject) {
        return com.baidu.swan.apps.u.a.CZ().b(this.aZY, jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.s.d getUpdateManager(JsObject jsObject) {
        if (this.baL == null) {
            this.baL = new com.baidu.swan.games.s.d(jsObject);
        }
        return this.baL;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.websocket.c connectSocket(JsObject jsObject) {
        if (this.baN == null) {
            this.baN = new com.baidu.swan.games.network.websocket.a(this.aZY);
        }
        return this.baN.connectSocket(jsObject);
    }

    @JavascriptInterface
    public void setEnableDebug(JsObject jsObject) {
        if (this.baO == null) {
            this.baO = new com.baidu.swan.games.c.d(this.aZY);
        }
        this.baO.setEnableDebug(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.a.b request(JsObject jsObject) {
        return new com.baidu.swan.games.network.a.b(jsObject);
    }

    @JavascriptInterface
    public void openCustomerServiceConversation(JsObject jsObject) {
        com.baidu.swan.games.d.a.a((c) this.aZY.NV(), jsObject);
    }
}
