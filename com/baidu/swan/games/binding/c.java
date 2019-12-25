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
import com.baidu.swan.apps.y.f;
import com.baidu.swan.games.audio.h;
import com.baidu.swan.games.b.g;
import com.baidu.swan.games.h.d;
import com.baidu.swan.games.q.e;
import com.baidu.swan.games.view.desktopguide.DesktopGuideApi;
import com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy;
/* loaded from: classes9.dex */
public final class c extends EventTargetImpl {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.e.b cfI;
    private d chi;
    private com.baidu.swan.games.q.d chj;
    private com.baidu.swan.games.q.b chk;
    private JsObject chl;
    private e chm;
    private com.baidu.swan.games.m.a chn;
    private com.baidu.swan.games.m.b cho;
    private com.baidu.swan.games.v.a chp;
    private com.baidu.swan.games.z.d chq;
    private com.baidu.swan.games.a.c chr;
    private com.baidu.swan.games.network.websocket.a chs;
    private g cht;
    private com.baidu.swan.games.screenrecord.a chu;
    private h chv;
    private DesktopGuideApi chw;
    private com.baidu.swan.games.r.a chx;
    private com.baidu.swan.games.view.webview.a chy;
    @V8JavascriptField
    public final String domain;
    @V8JavascriptField
    public com.baidu.swan.games.h.a env;

    public c(com.baidu.swan.games.e.b bVar) {
        super(bVar);
        this.domain = "main";
        this.chl = null;
        this.chm = null;
        this.chn = null;
        this.cho = null;
        this.chq = null;
        this.chr = null;
        this.chs = null;
        this.cht = null;
        this.chu = null;
        this.chv = null;
        this.chw = null;
        this.chx = null;
        this.chy = null;
        this.cfI = bVar;
        this.env = new com.baidu.swan.games.h.a();
        akk();
    }

    private void akk() {
        this.cho = new com.baidu.swan.games.m.b(this.cfI);
    }

    public void b(JsObject jsObject) {
        this.chl = jsObject;
    }

    @JavascriptInterface
    public void setPreferredFramesPerSecond(short s) {
        if (s >= 1 && s <= 60) {
            this.cfI.setPreferredFramesPerSecond(s);
        }
    }

    @JavascriptInterface
    public e getOpenDataContext() {
        if (this.chm == null) {
            this.chm = new e(this.cfI);
            this.chm.canvas = this.chl;
            this.chl = null;
        }
        return this.chm;
    }

    @JavascriptInterface
    public d getFileSystemManager() {
        if (this.chi == null) {
            this.chi = new d((com.baidu.swan.games.e.a) this.cfI);
        }
        return this.chi;
    }

    @JavascriptInterface
    public com.baidu.swan.games.x.c loadSubpackage(JsObject jsObject) {
        com.baidu.swan.games.x.c cVar = new com.baidu.swan.games.x.c(this.cfI);
        cVar.l(jsObject);
        return cVar;
    }

    @JavascriptInterface
    public void exit(JsObject jsObject) {
        if (DEBUG) {
            this.cfI.akP().log("exit from java side.");
        }
        if (jsObject != null) {
            com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
            com.baidu.swan.games.binding.model.a f = com.baidu.swan.games.binding.model.a.f(com.baidu.swan.games.binding.model.c.c(jsObject));
            SwanAppActivity TQ = f.Uf().TQ();
            if (TQ == null) {
                bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "failed");
                f.Q(bVar);
                return;
            }
            bVar.errMsg = String.format("%s:%s", RGState.METHOD_NAME_EXIT, "ok");
            f.onSuccess(bVar);
            if (Build.VERSION.SDK_INT >= 21) {
                TQ.finishAndRemoveTask();
            } else {
                TQ.finish();
            }
        }
    }

    @JavascriptInterface
    public void reload(JsObject jsObject) {
        if (this.chx == null) {
            this.chx = new com.baidu.swan.games.r.a();
        }
        this.chx.reload(jsObject);
    }

    @JavascriptInterface
    public void reload() {
        reload(null);
    }

    @JavascriptInterface
    public com.baidu.swan.games.q.d getOpenData() {
        if (this.chj == null) {
            this.chj = new com.baidu.swan.games.q.d((com.baidu.swan.games.e.a) this.cfI);
        }
        return this.chj;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        if (this.chk == null) {
            this.chk = new com.baidu.swan.games.q.b(this.cfI);
        }
        this.chk.checkIsUserAdvisedToRest(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.c createRewardedVideoAd(JsObject jsObject) {
        if (this.chr == null) {
            this.chr = com.baidu.swan.apps.w.a.RM().a(this.cfI, jsObject);
            if (this.chr == null) {
                this.chr = new com.baidu.swan.games.a.a();
            }
        }
        return this.chr;
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.button.userinfo.b createUserInfoButton(JsObject jsObject) {
        return new com.baidu.swan.games.view.button.userinfo.b(jsObject, this.cfI);
    }

    @JavascriptInterface
    public void showKeyboard(JsObject jsObject) {
        if (this.chn == null) {
            this.chn = new com.baidu.swan.games.m.a(this.cfI, this.cho);
        }
        this.chn.showKeyboard(jsObject);
    }

    @JavascriptInterface
    public void showKeyboard() {
        if (this.chn == null) {
            this.chn = new com.baidu.swan.games.m.a(this.cfI, this.cho);
        }
        this.chn.showKeyboard(null);
    }

    @JavascriptInterface
    public void updateKeyboard(JsObject jsObject) {
        if (this.chn != null) {
            this.chn.updateKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void updateKeyboard() {
        if (this.chn != null) {
            this.chn.updateKeyboard(null);
        }
    }

    @JavascriptInterface
    public void hideKeyboard(JsObject jsObject) {
        if (this.chn != null) {
            this.chn.hideKeyboard(jsObject);
        }
    }

    @JavascriptInterface
    public void hideKeyboard() {
        if (this.chn != null) {
            this.chn.hideKeyboard(null);
        }
    }

    @JavascriptInterface
    public void getStorage(JsObject jsObject) {
        akl().getStorage(jsObject);
    }

    @JavascriptInterface
    public Object getStorageSync(String str) {
        return com.baidu.swan.games.v.a.d.a(this.cfI, "getStorageSync", str, akl().po(str));
    }

    @JavascriptInterface
    public void setStorage(JsObject jsObject) {
        akl().setStorage(jsObject);
    }

    @JavascriptInterface
    public void setStorageSync(String str, JsSerializeValue jsSerializeValue) {
        com.baidu.swan.games.v.a.d.a(this.cfI, "setStorageSync", str, akl().a(str, jsSerializeValue));
    }

    @JavascriptInterface
    public void setStorageSync(String str) {
        com.baidu.swan.games.v.a.d.a(this.cfI, "setStorageSync", str, akl().a(str, (JsSerializeValue) null));
    }

    @JavascriptInterface
    public void removeStorage(JsObject jsObject) {
        akl().removeStorage(jsObject);
    }

    @JavascriptInterface
    public void removeStorageSync(String str) {
        com.baidu.swan.games.v.a.d.a(this.cfI, "removeStorageSync", str, akl().pp(str));
    }

    @JavascriptInterface
    public void clearStorage(JsObject jsObject) {
        akl().clearStorage(jsObject);
    }

    @JavascriptInterface
    public void clearStorageSync() {
        com.baidu.swan.games.v.a.d.a(this.cfI, "clearStorageSync", "", akl().ane());
    }

    @JavascriptInterface
    public void getStorageInfo(JsObject jsObject) {
        akl().getStorageInfo(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.v.a.c getStorageInfoSync() {
        return akl().getStorageInfoSync();
    }

    @NonNull
    private com.baidu.swan.games.v.a akl() {
        if (this.chp == null) {
            this.chp = new com.baidu.swan.games.v.a(this.cfI);
        }
        return this.chp;
    }

    @JavascriptInterface
    public void setInnerAudioOption(JsObject jsObject) {
        this.chv = new h(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.audio.g createInnerAudioContext() {
        return new com.baidu.swan.games.audio.g(this.cfI);
    }

    @JavascriptInterface
    public com.baidu.swan.games.a.b createBannerAd(JsObject jsObject) {
        return com.baidu.swan.apps.w.a.RM().b(this.cfI, jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.z.d getUpdateManager(JsObject jsObject) {
        if (this.chq == null) {
            this.chq = new com.baidu.swan.games.z.d(jsObject);
        }
        return this.chq;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.websocket.c connectSocket(JsObject jsObject) {
        if (this.chs == null) {
            this.chs = new com.baidu.swan.games.network.websocket.a(this.cfI);
        }
        return this.chs.connectSocket(jsObject);
    }

    @JavascriptInterface
    public void setEnableDebug(JsObject jsObject) {
        if (this.cht == null) {
            this.cht = new g(this.cfI);
        }
        this.cht.setEnableDebug(jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.c.c request(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        com.baidu.swan.games.network.a a = com.baidu.swan.games.network.b.d.aml().a(this.cfI, c, 1);
        if (a instanceof com.baidu.swan.games.network.c.c) {
            com.baidu.swan.games.network.c.c cVar = (com.baidu.swan.games.network.c.c) a;
            cVar.j(c);
            return cVar;
        }
        com.baidu.swan.games.network.c.c cVar2 = new com.baidu.swan.games.network.c.c(this.cfI, c);
        cVar2.start();
        return cVar2;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.d.b uploadFile(JsObject jsObject) {
        com.baidu.swan.games.network.d.b bVar = new com.baidu.swan.games.network.d.b(this.cfI, com.baidu.swan.games.binding.model.c.c(jsObject));
        bVar.start();
        return bVar;
    }

    @JavascriptInterface
    public com.baidu.swan.games.network.a.b downloadFile(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        com.baidu.swan.games.network.a a = com.baidu.swan.games.network.b.d.aml().a(this.cfI, c, 2);
        if (a instanceof com.baidu.swan.games.network.a.b) {
            com.baidu.swan.games.network.a.b bVar = (com.baidu.swan.games.network.a.b) a;
            bVar.j(c);
            return bVar;
        }
        com.baidu.swan.games.network.a.b bVar2 = new com.baidu.swan.games.network.a.b(this.cfI, c);
        bVar2.start();
        return bVar2;
    }

    @JavascriptInterface
    public void openCustomerServiceConversation(JsObject jsObject) {
        com.baidu.swan.games.c.a.a((c) this.cfI.akN(), jsObject);
    }

    @JavascriptInterface
    public com.baidu.swan.games.screenrecord.a getVideoRecorderManager() {
        if (this.chu == null) {
            this.chu = new com.baidu.swan.games.screenrecord.a(this.cfI);
        }
        return this.chu;
    }

    @JavascriptInterface
    public void shareVideo(JsObject jsObject) {
        new com.baidu.swan.games.t.b.a(jsObject).Lf();
    }

    @JavascriptInterface
    public String getEnvVariables() {
        return com.baidu.swan.apps.jsbridge.a.b.getEnvVariables();
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton(JsObject jsObject) {
        return new RecommendButtonApiProxy(this.cfI, jsObject);
    }

    @JavascriptInterface
    public RecommendButtonApiProxy createRecommendationButton() {
        return createRecommendationButton(null);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide(JsObject jsObject) {
        if (this.chw == null) {
            this.chw = new DesktopGuideApi(this.cfI);
        }
        this.chw.o(jsObject);
    }

    @JavascriptInterface
    public void showAddToDesktopGuide() {
        showAddToDesktopGuide(null);
    }

    @JavascriptInterface
    public com.baidu.swan.games.view.webview.a getWebViewManager() {
        if (this.chy == null) {
            this.chy = new com.baidu.swan.games.view.webview.a(this.cfI);
        }
        return this.chy;
    }

    @JavascriptInterface
    public void getUUAPInfo(JsObject jsObject) {
        com.baidu.swan.games.aa.a.getUUAPInfo(jsObject);
    }

    @JavascriptInterface
    public String getAPIs(int i) {
        return DEBUG ? com.baidu.swan.apps.ah.a.a.XS() ? SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i) : "" : com.baidu.swan.apps.w.a.Rn().Es() ? SchemeCollecter.getSchemesDes(SchemeCollecter.CLASSIFY_SWAN_V8, i) : "";
    }

    @JavascriptInterface
    public void authorizeEval(JsObject jsObject) {
        com.baidu.swan.games.f.a.authorizeEval(jsObject);
    }

    @JavascriptInterface
    public void menuItemCtrl(JsObject jsObject) {
        com.baidu.swan.games.p.a TU = f.Uf().TU();
        if (TU != null) {
            TU.i(com.baidu.swan.games.binding.model.c.c(jsObject));
        }
    }
}
