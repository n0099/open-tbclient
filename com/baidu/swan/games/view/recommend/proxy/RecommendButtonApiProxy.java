package com.baidu.swan.games.view.recommend.proxy;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.b;
import com.baidu.swan.games.view.recommend.a.a;
import com.baidu.swan.games.view.recommend.a.c;
import com.baidu.swan.games.view.recommend.a.d;
import com.baidu.swan.games.view.recommend.a.e;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
import java.util.Locale;
/* loaded from: classes8.dex */
public class RecommendButtonApiProxy extends EventTargetImpl implements com.baidu.swan.games.view.a, com.baidu.swan.games.view.recommend.a, a.InterfaceC0536a, d.a {
    private static final boolean DEBUG = b.DEBUG;
    private com.baidu.swan.games.f.b eee;
    private com.baidu.swan.games.view.recommend.model.a eoC;
    private c epm;
    private com.baidu.swan.games.view.recommend.a.b epv;
    private int epw;
    private RecommendButtonState epx;
    @V8JavascriptField
    public final d style;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public enum RecommendButtonState {
        IDLE,
        LOADING,
        HIDE,
        SHOW,
        DESTROYED
    }

    public RecommendButtonApiProxy(com.baidu.swan.games.f.b bVar, JsObject jsObject) {
        super(bVar);
        this.epm = new c();
        this.style = new d();
        this.eee = bVar;
        if (r(jsObject)) {
            com.baidu.swan.games.view.c.a(this);
        }
    }

    @JavascriptInterface
    public void load() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "load: state-" + this.epx);
        }
        if (this.epx == RecommendButtonState.IDLE) {
            this.epx = RecommendButtonState.LOADING;
            e.a(this.epw, new a() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.1
                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onSuccess(String str) {
                    com.baidu.swan.games.view.recommend.model.c xP = com.baidu.swan.games.view.recommend.model.b.xP(str);
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onSuccess-" + xP.isSuccess());
                    }
                    if (RecommendButtonApiProxy.this.epx != RecommendButtonState.DESTROYED) {
                        if (xP.isSuccess()) {
                            RecommendButtonApiProxy.this.epx = RecommendButtonState.HIDE;
                            RecommendButtonApiProxy.this.eoC = com.baidu.swan.games.view.recommend.model.b.cJ(xP.data);
                            RecommendButtonApiProxy.this.epv.a(RecommendButtonApiProxy.this.eoC);
                            RecommendButtonApiProxy.this.bah();
                            return;
                        }
                        RecommendButtonApiProxy.this.epx = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.xS(String.format("RecommendationButton.load failed,%s", xP.errMsg));
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onFail(String str) {
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onFail-" + str);
                    }
                    if (RecommendButtonApiProxy.this.epx != RecommendButtonState.DESTROYED) {
                        RecommendButtonApiProxy.this.epx = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.xS(String.format("RecommendationButton.load failed,%s", str));
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void show() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "show: state-" + this.epx);
        }
        if (this.epx == RecommendButtonState.HIDE) {
            this.epx = RecommendButtonState.SHOW;
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.2
                @Override // java.lang.Runnable
                public void run() {
                    RecommendButtonApiProxy.this.epm.a(RecommendButtonApiProxy.this.epw, RecommendButtonApiProxy.this.eoC);
                }
            });
            this.epv.show();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void hide() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "hide: state-" + this.epx);
        }
        if (this.epx == RecommendButtonState.SHOW) {
            this.epx = RecommendButtonState.HIDE;
            this.epv.hide();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void destroy() {
        baf();
        com.baidu.swan.games.view.c.b(this);
    }

    private void baf() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "destroy: state-" + this.epx);
        }
        if (this.epx != RecommendButtonState.DESTROYED) {
            this.epx = RecommendButtonState.DESTROYED;
            if (this.epv != null) {
                this.epv.destroy();
            }
            this.eoC = null;
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.d.a
    public void vC(String str) {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "onStyleChanged:" + str + "," + this.epx + "," + this.style);
        }
        if (this.epx == RecommendButtonState.SHOW) {
            this.epv.update();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0536a
    @UiThread
    public void lr(int i) {
        if (this.eoC != null && i >= 0 && i < this.eoC.epg.size()) {
            a(this.eoC.epg.get(i), ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME);
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0536a
    @UiThread
    public void aZY() {
        if (this.eoC != null) {
            a(this.eoC.epf, "game_center");
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0536a
    @UiThread
    public void aZZ() {
        this.epm.i(this.epw, "list", c.eoJ);
    }

    private void fZ(boolean z) {
        if (bag()) {
            this.epv.fZ(z);
        }
    }

    private boolean r(JsObject jsObject) {
        this.epx = RecommendButtonState.IDLE;
        this.style.a(this);
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e == null) {
            e = new com.baidu.swan.games.binding.model.c();
        }
        String optString = e.optString("type");
        if (g(e, "type")) {
            this.epw = xQ(optString);
        } else {
            this.epw = 1;
        }
        if (this.epw == 0) {
            xR("createRecommendationButton failed,parameter error: the 'type' is invalid.");
            return false;
        }
        if (g(e, "style")) {
            com.baidu.swan.games.binding.model.c wv = e.wv("style");
            if (wv == null) {
                xR("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            } else if (!n(wv)) {
                xR("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            }
        }
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "init: style-" + this.style);
        }
        this.epv = new com.baidu.swan.games.view.recommend.proxy.a(this.epw, this.style, this);
        return true;
    }

    private boolean n(com.baidu.swan.games.binding.model.c cVar) {
        if (cVar == null) {
            return true;
        }
        try {
            if (g(cVar, "left")) {
                this.style.left = (float) cVar.getDouble("left");
            }
            if (g(cVar, VerticalTranslateLayout.TOP)) {
                this.style.top = (float) cVar.getDouble(VerticalTranslateLayout.TOP);
                return true;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean g(com.baidu.swan.games.binding.model.c cVar, String str) {
        int wn = cVar != null ? cVar.wn(str) : 12;
        return (wn == 12 || wn == 11) ? false : true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int xQ(@Nullable String str) {
        boolean z;
        String lowerCase = str == null ? "" : str.toLowerCase(Locale.CHINA);
        switch (lowerCase.hashCode()) {
            case 2908512:
                if (lowerCase.equals("carousel")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case 3322014:
                if (lowerCase.equals("list")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        switch (z) {
            case false:
                return 1;
            case true:
                return 2;
            default:
                return 0;
        }
    }

    @UiThread
    private void a(RecommendItemModel recommendItemModel, String str) {
        if (recommendItemModel != null && !TextUtils.isEmpty(recommendItemModel.appKey) && !TextUtils.isEmpty(recommendItemModel.scheme)) {
            e.aG(this.epw, recommendItemModel.appKey);
            SchemeRouter.invokeScheme(com.baidu.swan.games.view.c.getViewContext(), Uri.parse(recommendItemModel.scheme), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            this.epm.i(this.epw, str, recommendItemModel.appKey);
        }
    }

    private boolean bag() {
        return this.epx == RecommendButtonState.HIDE || this.epx == RecommendButtonState.SHOW;
    }

    private void xR(String str) {
        this.eee.throwJSException(JSExceptionType.Error, str);
        baf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bah() {
        dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xS(String str) {
        com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
        bVar.errMsg = str;
        dispatchEvent(new JSEvent(BdStatsConstant.StatsType.ERROR, bVar));
    }

    @Override // com.baidu.swan.games.view.a
    public void aSY() {
        fZ(true);
    }

    @Override // com.baidu.swan.games.view.a
    public void aSZ() {
        fZ(false);
    }

    @Override // com.baidu.swan.games.view.a
    public void aTa() {
        baf();
    }

    /* loaded from: classes8.dex */
    private abstract class a extends StringResponseCallback {
        abstract void onFail(String str);

        abstract void onSuccess(String str);

        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: V */
        public void onSuccess(final String str, int i) {
            RecommendButtonApiProxy.this.eee.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onSuccess(str);
                }
            });
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(final Exception exc) {
            RecommendButtonApiProxy.this.eee.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onFail(exc.getMessage());
                }
            });
        }
    }
}
