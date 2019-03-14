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
    private com.baidu.swan.games.e.b aZZ;
    private d baE;
    private com.baidu.swan.games.n.d baF;
    private com.baidu.swan.games.n.b baG;
    private JsObject baH;
    private e baI;
    private com.baidu.swan.games.j.a baJ;
    private com.baidu.swan.games.j.b baK;
    private com.baidu.swan.games.q.a baL;
    private com.baidu.swan.games.s.d baM;
    private com.baidu.swan.games.a.d baN;
    private com.baidu.swan.games.network.websocket.a baO;
    private com.baidu.swan.games.c.d baP;
    @V8JavascriptField
    public final String domain;
    @V8JavascriptField
    public com.baidu.swan.games.f.a env;

    public c(com.baidu.swan.games.e.b bVar) {
        super(bVar);
        this.domain = "main";
        this.baH = null;
        this.baI = null;
        this.baJ = null;
        this.baK = null;
        this.baM = null;
        this.baN = null;
        this.baO = null;
        this.baP = null;
        this.aZZ = bVar;
        this.env = new com.baidu.swan.games.f.a();
        Nz();
    }

    private void Nz() {
        this.baK = new com.baidu.swan.games.j.b(this.aZZ);
    }

    public void a(JsObject jsObject) {
        this.baH = jsObject;
    }

    @JavascriptInterface
    public void setPreferredFramesPerSecond(short s) {
        if (s >= 1 && s <= 60) {
            this.aZZ.setPreferredFramesPerSecond(s);
        }
    }

    @JavascriptInterface
    public e getOpenDataContext() {
        if (this.baI == null) {
            this.baI = new e(this.aZZ);
            this.baI.canvas = this.baH;
            this.baH = null;
        }
        return this.baI;
    }

    @JavascriptInterface
    public d getFileSystemManager() {
        if (this.baE == null) {
            this.baE = new d((com.baidu.swan.games.e.a) this.aZZ);
        }
        return this.baE;
    }

    @JavascriptInterface
    public com.baidu.swan.games.subpackage.d loadSubpackage(JsObject jsObject) {
        com.baidu.swan.games.subpackage.d dVar = new com.baidu.swan.games.subpackage.d(this.aZZ);
        dVar.k(jsObject);
        return dVar;
    }

    @JavascriptInterface
    public void exit(JsObject jsObject) {
        if (DEBUG) {
            this.aZZ.NX().log("exit from java side.");
        }
        if (jsObject != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            com.baidu.swan.games.binding.model.a a = com.baidu.swan.games.binding.model.a.a(com.baidu.swan.games.binding.model.c.b(jsObject));
            SwanAppActivity DO = com.baidu.swan.apps.w.e.Ec().DO();
            if (DO == null) {
                bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "failed");
                a.L(bVar);
                a.onComplete();
                return;
            }
            bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "ok");
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
        if (this.baF == null) {
            this.baF = new com.baidu.swan.games.n.d((com.baidu.swan.games.e.a) this.aZZ);
        }
        return this.baF;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        if (this.baG == null) {
            this.baG = new com.baidu.swan.games.n.b(this.aZZ);
        }
        this.baG.checkIsUserAdvisedToRest(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.d createRewardedVideoAd(JsObject jsObject) {
        if (this.baN == null) {
            this.baN = com.baidu.swan.apps.u.a.CZ().a(this.aZZ, jsObject);
            if (this.baN == null) {
                this.baN = new com.baidu.swan.games.a.b();
            }
        }
        return this.baN;
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.button.userinfo.b createUserInfoButton(JsObject jsObject) {
        return new com.baidu.swan.games.view.button.userinfo.b(jsObject, this.aZZ);
    }

    @JavascriptInterface
    public void showKeyboard(JsObject jsObject) {
        if (this.baJ == null) {
            this.baJ = new com.baidu.swan.games.j.a(this.aZZ, this.baK);
        }
        this.baJ.showKeyboard(jsObject);
    }

    @JavascriptInterface
    public void showKeyboard() {
        if (this.baJ == null) {
            this.baJ = new com.baidu.swan.games.j.a(this.aZZ, this.baK);
        }
        this.baJ.showKeyboard(null);
    }

    @JavascriptInterface
    public void updateKeyboard(JsObject jsObject) {
        if (this.baJ != null) {
            this.baJ.updateKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void updateKeyboard() {
        if (this.baJ != null) {
            this.baJ.updateKeyboard(null);
        }
    }

    @JavascriptInterface
    public void hideKeyboard(JsObject jsObject) {
        if (this.baJ != null) {
            this.baJ.hideKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void hideKeyboard() {
        if (this.baJ != null) {
            this.baJ.hideKeyboard(null);
        }
    }

    @JavascriptInterface
    public void getStorage(JsObject jsObject) {
        NA().getStorage(jsObject);
    }

    @JavascriptInterface
    public Object getStorageSync(String str) {
        return com.baidu.swan.games.q.a.d.a(this.aZZ, "getStorageSync", NA().iW(str));
    }

    @JavascriptInterface
    public void setStorage(JsObject jsObject) {
        NA().setStorage(jsObject);
    }

    @JavascriptInterface
    public void setStorageSync(String str, JsSerializeValue jsSerializeValue) {
        com.baidu.swan.games.q.a.d.a(this.aZZ, "setStorageSync", NA().a(str, jsSerializeValue));
    }

    @JavascriptInterface
    public void setStorageSync(String str) {
        com.baidu.swan.games.q.a.d.a(this.aZZ, "setStorageSync", NA().a(str, (JsSerializeValue) null));
    }

    @JavascriptInterface
    public void removeStorage(JsObject jsObject) {
        NA().removeStorage(jsObject);
    }

    @JavascriptInterface
    public void removeStorageSync(String str) {
        com.baidu.swan.games.q.a.d.a(this.aZZ, "removeStorageSync", NA().iX(str));
    }

    @JavascriptInterface
    public void clearStorage(JsObject jsObject) {
        NA().clearStorage(jsObject);
    }

    @JavascriptInterface
    public void clearStorageSync() {
        com.baidu.swan.games.q.a.d.a(this.aZZ, "clearStorageSync", NA().Pc());
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
        if (this.baL == null) {
            this.baL = new com.baidu.swan.games.q.a(this.aZZ);
        }
        return this.baL;
    }

    @JavascriptInterface
    public f createInnerAudioContext() {
        return new f(this.aZZ);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.c createBannerAd(JsObject jsObject) {
        return com.baidu.swan.apps.u.a.CZ().b(this.aZZ, jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.s.d getUpdateManager(JsObject jsObject) {
        if (this.baM == null) {
            this.baM = new com.baidu.swan.games.s.d(jsObject);
        }
        return this.baM;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.websocket.c connectSocket(JsObject jsObject) {
        if (this.baO == null) {
            this.baO = new com.baidu.swan.games.network.websocket.a(this.aZZ);
        }
        return this.baO.connectSocket(jsObject);
    }

    @JavascriptInterface
    public void setEnableDebug(JsObject jsObject) {
        if (this.baP == null) {
            this.baP = new com.baidu.swan.games.c.d(this.aZZ);
        }
        this.baP.setEnableDebug(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.a.b request(JsObject jsObject) {
        return new com.baidu.swan.games.network.a.b(jsObject);
    }

    @JavascriptInterface
    public void openCustomerServiceConversation(JsObject jsObject) {
        com.baidu.swan.games.d.a.a((c) this.aZZ.NV(), jsObject);
    }
}
