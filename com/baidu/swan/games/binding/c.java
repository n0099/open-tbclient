package com.baidu.swan.games.binding;

import android.os.Build;
import android.support.annotation.NonNull;
import android.webkit.JavascriptInterface;
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
/* loaded from: classes8.dex */
public final class c extends EventTargetImpl {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.f.b doB;
    @V8JavascriptField
    public final String domain;
    private com.baidu.swan.games.b.b dqA;
    private e dqj;
    private d dqk;
    private com.baidu.swan.games.r.b dql;
    private JsObject dqm;
    private com.baidu.swan.games.r.e dqn;
    private com.baidu.swan.games.n.a dqo;
    private com.baidu.swan.games.n.b dqp;
    private com.baidu.swan.games.w.a dqq;
    private com.baidu.swan.games.aa.d dqr;
    private com.baidu.swan.games.a.c dqs;
    private com.baidu.swan.games.network.websocket.a dqt;
    private g dqu;
    private com.baidu.swan.games.screenrecord.a dqv;
    private h dqw;
    private DesktopGuideApi dqx;
    private com.baidu.swan.games.s.a dqy;
    private com.baidu.swan.games.view.webview.a dqz;
    @V8JavascriptField
    public com.baidu.swan.games.i.a env;

    public c(com.baidu.swan.games.f.b bVar) {
        super(bVar);
        this.domain = "main";
        this.dqm = null;
        this.dqn = null;
        this.dqo = null;
        this.dqp = null;
        this.dqr = null;
        this.dqs = null;
        this.dqt = null;
        this.dqu = null;
        this.dqv = null;
        this.dqw = null;
        this.dqx = null;
        this.dqy = null;
        this.dqz = null;
        this.dqA = null;
        this.doB = bVar;
        this.env = new com.baidu.swan.games.i.a();
        aMy();
    }

    private void aMy() {
        this.dqp = new com.baidu.swan.games.n.b(this.doB);
    }

    public void d(JsObject jsObject) {
        this.dqm = jsObject;
    }

    @JavascriptInterface
    public void setPreferredFramesPerSecond(short s) {
        if (s >= 1 && s <= 60) {
            this.doB.setPreferredFramesPerSecond(s);
        }
    }

    @JavascriptInterface
    public com.baidu.swan.games.r.e getOpenDataContext() {
        if (this.dqn == null) {
            this.dqn = new com.baidu.swan.games.r.e(this.doB);
            this.dqn.canvas = this.dqm;
            this.dqm = null;
        }
        return this.dqn;
    }

    @JavascriptInterface
    public e getFileSystemManager() {
        if (this.dqj == null) {
            this.dqj = new e((com.baidu.swan.games.f.a) this.doB);
        }
        return this.dqj;
    }

    @JavascriptInterface
    public com.baidu.swan.games.y.c loadSubpackage(JsObject jsObject) {
        com.baidu.swan.games.y.c cVar = new com.baidu.swan.games.y.c(this.doB);
        cVar.n(jsObject);
        return cVar;
    }

    @JavascriptInterface
    public void exit(JsObject jsObject) {
        if (DEBUG) {
            this.doB.aNd().log("exit from java side.");
        }
        if (jsObject != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            com.baidu.swan.games.binding.model.a f = com.baidu.swan.games.binding.model.a.f(com.baidu.swan.games.binding.model.c.e(jsObject));
            SwanAppActivity arI = f.arY().arI();
            if (arI == null) {
                bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "failed");
                f.Y(bVar);
                return;
            }
            bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "ok");
            f.onSuccess(bVar);
            if (Build.VERSION.SDK_INT >= 21) {
                arI.finishAndRemoveTask();
            } else {
                arI.finish();
            }
        }
    }

    @JavascriptInterface
    public void reload(JsObject jsObject) {
        if (this.dqy == null) {
            this.dqy = new com.baidu.swan.games.s.a();
        }
        this.dqy.reload(jsObject);
    }

    @JavascriptInterface
    public void reload() {
        reload(null);
    }

    @JavascriptInterface
    public d getOpenData() {
        if (this.dqk == null) {
            this.dqk = new d((com.baidu.swan.games.f.a) this.doB);
        }
        return this.dqk;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        if (this.dql == null) {
            this.dql = new com.baidu.swan.games.r.b(this.doB);
        }
        this.dql.checkIsUserAdvisedToRest(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.c createRewardedVideoAd(JsObject jsObject) {
        if (this.dqs == null) {
            this.dqs = com.baidu.swan.apps.t.a.apn().a(this.doB, jsObject);
            if (this.dqs == null) {
                this.dqs = new com.baidu.swan.games.a.a();
            }
        }
        return this.dqs;
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.button.userinfo.b createUserInfoButton(JsObject jsObject) {
        return new com.baidu.swan.games.view.button.userinfo.b(jsObject, this.doB);
    }

    @JavascriptInterface
    public void showKeyboard(JsObject jsObject) {
        if (this.dqo == null) {
            this.dqo = new com.baidu.swan.games.n.a(this.doB, this.dqp);
        }
        this.dqo.showKeyboard(jsObject);
    }

    @JavascriptInterface
    public void showKeyboard() {
        if (this.dqo == null) {
            this.dqo = new com.baidu.swan.games.n.a(this.doB, this.dqp);
        }
        this.dqo.showKeyboard(null);
    }

    @JavascriptInterface
    public void updateKeyboard(JsObject jsObject) {
        if (this.dqo != null) {
            this.dqo.updateKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void updateKeyboard() {
        if (this.dqo != null) {
            this.dqo.updateKeyboard(null);
        }
    }

    @JavascriptInterface
    public void hideKeyboard(JsObject jsObject) {
        if (this.dqo != null) {
            this.dqo.hideKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void hideKeyboard() {
        if (this.dqo != null) {
            this.dqo.hideKeyboard(null);
        }
    }

    @JavascriptInterface
    public void getStorage(JsObject jsObject) {
        aMz().getStorage(jsObject);
    }

    @JavascriptInterface
    public Object getStorageSync(String str) {
        return com.baidu.swan.games.w.a.d.a(this.doB, "getStorageSync", str, aMz().vT(str));
    }

    @JavascriptInterface
    public void setStorage(JsObject jsObject) {
        aMz().setStorage(jsObject);
    }

    @JavascriptInterface
    public void setStorageSync(String str, JsSerializeValue jsSerializeValue) {
        com.baidu.swan.games.w.a.d.a(this.doB, "setStorageSync", str, aMz().a(str, jsSerializeValue));
    }

    @JavascriptInterface
    public void setStorageSync(String str) {
        com.baidu.swan.games.w.a.d.a(this.doB, "setStorageSync", str, aMz().a(str, (JsSerializeValue) null));
    }

    @JavascriptInterface
    public void removeStorage(JsObject jsObject) {
        aMz().removeStorage(jsObject);
    }

    @JavascriptInterface
    public void removeStorageSync(String str) {
        com.baidu.swan.games.w.a.d.a(this.doB, "removeStorageSync", str, aMz().vU(str));
    }

    @JavascriptInterface
    public void clearStorage(JsObject jsObject) {
        aMz().clearStorage(jsObject);
    }

    @JavascriptInterface
    public void clearStorageSync() {
        com.baidu.swan.games.w.a.d.a(this.doB, "clearStorageSync", "", aMz().aPx());
    }

    @JavascriptInterface
    public void getStorageInfo(JsObject jsObject) {
        aMz().getStorageInfo(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.w.a.c getStorageInfoSync() {
        return aMz().getStorageInfoSync();
    }

    @NonNull
    private com.baidu.swan.games.w.a aMz() {
        if (this.dqq == null) {
            this.dqq = new com.baidu.swan.games.w.a(this.doB);
        }
        return this.dqq;
    }

    @JavascriptInterface
    public void setInnerAudioOption(JsObject jsObject) {
        this.dqw = new h(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.audio.g createInnerAudioContext() {
        return new com.baidu.swan.games.audio.g(this.doB);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.b createBannerAd(JsObject jsObject) {
        return com.baidu.swan.apps.t.a.apn().b(this.doB, jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.aa.d getUpdateManager(JsObject jsObject) {
        if (this.dqr == null) {
            this.dqr = new com.baidu.swan.games.aa.d(jsObject);
        }
        return this.dqr;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.websocket.c connectSocket(JsObject jsObject) {
        if (this.dqt == null) {
            this.dqt = new com.baidu.swan.games.network.websocket.a(this.doB);
        }
        return this.dqt.connectSocket(jsObject);
    }

    @JavascriptInterface
    public void setEnableDebug(JsObject jsObject) {
        if (this.dqu == null) {
            this.dqu = new g(this.doB);
        }
        this.dqu.setEnableDebug(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.c.c request(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        com.baidu.swan.games.network.a a = com.baidu.swan.games.network.b.d.aOE().a(this.doB, e, 1);
        if (a instanceof com.baidu.swan.games.network.c.c) {
            com.baidu.swan.games.network.c.c cVar = (com.baidu.swan.games.network.c.c) a;
            cVar.j(e);
            return cVar;
        }
        com.baidu.swan.games.network.c.c cVar2 = new com.baidu.swan.games.network.c.c(this.doB, e);
        cVar2.start();
        return cVar2;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.d.b uploadFile(JsObject jsObject) {
        com.baidu.swan.games.network.d.b bVar = new com.baidu.swan.games.network.d.b(this.doB, com.baidu.swan.games.binding.model.c.e(jsObject));
        bVar.start();
        return bVar;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.a.b downloadFile(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        com.baidu.swan.games.network.a a = com.baidu.swan.games.network.b.d.aOE().a(this.doB, e, 2);
        if (a instanceof com.baidu.swan.games.network.a.b) {
            com.baidu.swan.games.network.a.b bVar = (com.baidu.swan.games.network.a.b) a;
            bVar.j(e);
            return bVar;
        }
        com.baidu.swan.games.network.a.b bVar2 = new com.baidu.swan.games.network.a.b(this.doB, e);
        bVar2.start();
        return bVar2;
    }

    @JavascriptInterface
    public void openCustomerServiceConversation(JsObject jsObject) {
        com.baidu.swan.games.d.a.a((c) this.doB.aNb(), jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.screenrecord.a getVideoRecorderManager() {
        if (this.dqv == null) {
            this.dqv = new com.baidu.swan.games.screenrecord.a(this.doB);
        }
        return this.dqv;
    }

    @JavascriptInterface
    public void shareVideo(JsObject jsObject) {
        new com.baidu.swan.games.u.b.a(jsObject).age();
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return com.baidu.swan.apps.jsbridge.a.b.f(this.doB);
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton(JsObject jsObject) {
        return new RecommendButtonApiProxy(this.doB, jsObject);
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton() {
        return createRecommendationButton(null);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide(JsObject jsObject) {
        if (this.dqx == null) {
            this.dqx = new DesktopGuideApi(this.doB);
        }
        this.dqx.q(jsObject);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide() {
        showAddToDesktopGuide(null);
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.webview.a getWebViewManager() {
        if (this.dqz == null) {
            this.dqz = new com.baidu.swan.games.view.webview.a(this.doB);
        }
        return this.dqz;
    }

    @JavascriptInterface
    public void getUUAPInfo(JsObject jsObject) {
        com.baidu.swan.games.ab.a.getUUAPInfo(jsObject);
    }

    @JavascriptInterface
    public String getAPIs(int i) {
        if (DEBUG) {
            return com.baidu.swan.apps.ad.a.a.axf() ? SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i) : "";
        }
        return SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i);
    }

    @JavascriptInterface
    public void authorizeEval(JsObject jsObject) {
        com.baidu.swan.games.g.a.authorizeEval(jsObject);
    }

    @JavascriptInterface
    public void menuItemCtrl(JsObject jsObject) {
        com.baidu.swan.games.q.a arM = f.arY().arM();
        if (arM != null) {
            arM.i(com.baidu.swan.games.binding.model.c.e(jsObject));
        }
    }

    @JavascriptInterface
    public com.baidu.swan.games.b.b getAntiAddiction() {
        if (this.dqA == null) {
            this.dqA = new com.baidu.swan.games.b.b(this.doB);
        }
        return this.dqA;
    }
}
