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
    @V8JavascriptField
    public final String domain;
    private com.baidu.swan.games.f.b dox;
    private e dqf;
    private d dqg;
    private com.baidu.swan.games.r.b dqh;
    private JsObject dqi;
    private com.baidu.swan.games.r.e dqj;
    private com.baidu.swan.games.n.a dqk;
    private com.baidu.swan.games.n.b dql;
    private com.baidu.swan.games.w.a dqm;
    private com.baidu.swan.games.aa.d dqn;
    private com.baidu.swan.games.a.c dqo;
    private com.baidu.swan.games.network.websocket.a dqp;
    private g dqq;
    private com.baidu.swan.games.screenrecord.a dqr;
    private h dqs;
    private DesktopGuideApi dqt;
    private com.baidu.swan.games.s.a dqu;
    private com.baidu.swan.games.view.webview.a dqv;
    private com.baidu.swan.games.b.b dqw;
    @V8JavascriptField
    public com.baidu.swan.games.i.a env;

    public c(com.baidu.swan.games.f.b bVar) {
        super(bVar);
        this.domain = "main";
        this.dqi = null;
        this.dqj = null;
        this.dqk = null;
        this.dql = null;
        this.dqn = null;
        this.dqo = null;
        this.dqp = null;
        this.dqq = null;
        this.dqr = null;
        this.dqs = null;
        this.dqt = null;
        this.dqu = null;
        this.dqv = null;
        this.dqw = null;
        this.dox = bVar;
        this.env = new com.baidu.swan.games.i.a();
        aMy();
    }

    private void aMy() {
        this.dql = new com.baidu.swan.games.n.b(this.dox);
    }

    public void d(JsObject jsObject) {
        this.dqi = jsObject;
    }

    @JavascriptInterface
    public void setPreferredFramesPerSecond(short s) {
        if (s >= 1 && s <= 60) {
            this.dox.setPreferredFramesPerSecond(s);
        }
    }

    @JavascriptInterface
    public com.baidu.swan.games.r.e getOpenDataContext() {
        if (this.dqj == null) {
            this.dqj = new com.baidu.swan.games.r.e(this.dox);
            this.dqj.canvas = this.dqi;
            this.dqi = null;
        }
        return this.dqj;
    }

    @JavascriptInterface
    public e getFileSystemManager() {
        if (this.dqf == null) {
            this.dqf = new e((com.baidu.swan.games.f.a) this.dox);
        }
        return this.dqf;
    }

    @JavascriptInterface
    public com.baidu.swan.games.y.c loadSubpackage(JsObject jsObject) {
        com.baidu.swan.games.y.c cVar = new com.baidu.swan.games.y.c(this.dox);
        cVar.n(jsObject);
        return cVar;
    }

    @JavascriptInterface
    public void exit(JsObject jsObject) {
        if (DEBUG) {
            this.dox.aNd().log("exit from java side.");
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
        if (this.dqu == null) {
            this.dqu = new com.baidu.swan.games.s.a();
        }
        this.dqu.reload(jsObject);
    }

    @JavascriptInterface
    public void reload() {
        reload(null);
    }

    @JavascriptInterface
    public d getOpenData() {
        if (this.dqg == null) {
            this.dqg = new d((com.baidu.swan.games.f.a) this.dox);
        }
        return this.dqg;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        if (this.dqh == null) {
            this.dqh = new com.baidu.swan.games.r.b(this.dox);
        }
        this.dqh.checkIsUserAdvisedToRest(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.c createRewardedVideoAd(JsObject jsObject) {
        if (this.dqo == null) {
            this.dqo = com.baidu.swan.apps.t.a.apn().a(this.dox, jsObject);
            if (this.dqo == null) {
                this.dqo = new com.baidu.swan.games.a.a();
            }
        }
        return this.dqo;
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.button.userinfo.b createUserInfoButton(JsObject jsObject) {
        return new com.baidu.swan.games.view.button.userinfo.b(jsObject, this.dox);
    }

    @JavascriptInterface
    public void showKeyboard(JsObject jsObject) {
        if (this.dqk == null) {
            this.dqk = new com.baidu.swan.games.n.a(this.dox, this.dql);
        }
        this.dqk.showKeyboard(jsObject);
    }

    @JavascriptInterface
    public void showKeyboard() {
        if (this.dqk == null) {
            this.dqk = new com.baidu.swan.games.n.a(this.dox, this.dql);
        }
        this.dqk.showKeyboard(null);
    }

    @JavascriptInterface
    public void updateKeyboard(JsObject jsObject) {
        if (this.dqk != null) {
            this.dqk.updateKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void updateKeyboard() {
        if (this.dqk != null) {
            this.dqk.updateKeyboard(null);
        }
    }

    @JavascriptInterface
    public void hideKeyboard(JsObject jsObject) {
        if (this.dqk != null) {
            this.dqk.hideKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void hideKeyboard() {
        if (this.dqk != null) {
            this.dqk.hideKeyboard(null);
        }
    }

    @JavascriptInterface
    public void getStorage(JsObject jsObject) {
        aMz().getStorage(jsObject);
    }

    @JavascriptInterface
    public Object getStorageSync(String str) {
        return com.baidu.swan.games.w.a.d.a(this.dox, "getStorageSync", str, aMz().vS(str));
    }

    @JavascriptInterface
    public void setStorage(JsObject jsObject) {
        aMz().setStorage(jsObject);
    }

    @JavascriptInterface
    public void setStorageSync(String str, JsSerializeValue jsSerializeValue) {
        com.baidu.swan.games.w.a.d.a(this.dox, "setStorageSync", str, aMz().a(str, jsSerializeValue));
    }

    @JavascriptInterface
    public void setStorageSync(String str) {
        com.baidu.swan.games.w.a.d.a(this.dox, "setStorageSync", str, aMz().a(str, (JsSerializeValue) null));
    }

    @JavascriptInterface
    public void removeStorage(JsObject jsObject) {
        aMz().removeStorage(jsObject);
    }

    @JavascriptInterface
    public void removeStorageSync(String str) {
        com.baidu.swan.games.w.a.d.a(this.dox, "removeStorageSync", str, aMz().vT(str));
    }

    @JavascriptInterface
    public void clearStorage(JsObject jsObject) {
        aMz().clearStorage(jsObject);
    }

    @JavascriptInterface
    public void clearStorageSync() {
        com.baidu.swan.games.w.a.d.a(this.dox, "clearStorageSync", "", aMz().aPx());
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
        if (this.dqm == null) {
            this.dqm = new com.baidu.swan.games.w.a(this.dox);
        }
        return this.dqm;
    }

    @JavascriptInterface
    public void setInnerAudioOption(JsObject jsObject) {
        this.dqs = new h(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.audio.g createInnerAudioContext() {
        return new com.baidu.swan.games.audio.g(this.dox);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.b createBannerAd(JsObject jsObject) {
        return com.baidu.swan.apps.t.a.apn().b(this.dox, jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.aa.d getUpdateManager(JsObject jsObject) {
        if (this.dqn == null) {
            this.dqn = new com.baidu.swan.games.aa.d(jsObject);
        }
        return this.dqn;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.websocket.c connectSocket(JsObject jsObject) {
        if (this.dqp == null) {
            this.dqp = new com.baidu.swan.games.network.websocket.a(this.dox);
        }
        return this.dqp.connectSocket(jsObject);
    }

    @JavascriptInterface
    public void setEnableDebug(JsObject jsObject) {
        if (this.dqq == null) {
            this.dqq = new g(this.dox);
        }
        this.dqq.setEnableDebug(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.c.c request(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        com.baidu.swan.games.network.a a = com.baidu.swan.games.network.b.d.aOE().a(this.dox, e, 1);
        if (a instanceof com.baidu.swan.games.network.c.c) {
            com.baidu.swan.games.network.c.c cVar = (com.baidu.swan.games.network.c.c) a;
            cVar.j(e);
            return cVar;
        }
        com.baidu.swan.games.network.c.c cVar2 = new com.baidu.swan.games.network.c.c(this.dox, e);
        cVar2.start();
        return cVar2;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.d.b uploadFile(JsObject jsObject) {
        com.baidu.swan.games.network.d.b bVar = new com.baidu.swan.games.network.d.b(this.dox, com.baidu.swan.games.binding.model.c.e(jsObject));
        bVar.start();
        return bVar;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.a.b downloadFile(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        com.baidu.swan.games.network.a a = com.baidu.swan.games.network.b.d.aOE().a(this.dox, e, 2);
        if (a instanceof com.baidu.swan.games.network.a.b) {
            com.baidu.swan.games.network.a.b bVar = (com.baidu.swan.games.network.a.b) a;
            bVar.j(e);
            return bVar;
        }
        com.baidu.swan.games.network.a.b bVar2 = new com.baidu.swan.games.network.a.b(this.dox, e);
        bVar2.start();
        return bVar2;
    }

    @JavascriptInterface
    public void openCustomerServiceConversation(JsObject jsObject) {
        com.baidu.swan.games.d.a.a((c) this.dox.aNb(), jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.screenrecord.a getVideoRecorderManager() {
        if (this.dqr == null) {
            this.dqr = new com.baidu.swan.games.screenrecord.a(this.dox);
        }
        return this.dqr;
    }

    @JavascriptInterface
    public void shareVideo(JsObject jsObject) {
        new com.baidu.swan.games.u.b.a(jsObject).age();
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return com.baidu.swan.apps.jsbridge.a.b.f(this.dox);
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton(JsObject jsObject) {
        return new RecommendButtonApiProxy(this.dox, jsObject);
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton() {
        return createRecommendationButton(null);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide(JsObject jsObject) {
        if (this.dqt == null) {
            this.dqt = new DesktopGuideApi(this.dox);
        }
        this.dqt.q(jsObject);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide() {
        showAddToDesktopGuide(null);
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.webview.a getWebViewManager() {
        if (this.dqv == null) {
            this.dqv = new com.baidu.swan.games.view.webview.a(this.dox);
        }
        return this.dqv;
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
        if (this.dqw == null) {
            this.dqw = new com.baidu.swan.games.b.b(this.dox);
        }
        return this.dqw;
    }
}
