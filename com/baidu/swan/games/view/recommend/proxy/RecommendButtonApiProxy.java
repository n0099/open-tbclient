package com.baidu.swan.games.view.recommend.proxy;

import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
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
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.b;
import com.baidu.swan.games.view.recommend.a.a;
import com.baidu.swan.games.view.recommend.a.c;
import com.baidu.swan.games.view.recommend.a.d;
import com.baidu.swan.games.view.recommend.a.e;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes11.dex */
public class RecommendButtonApiProxy extends EventTargetImpl implements com.baidu.swan.games.view.a, com.baidu.swan.games.view.recommend.a, a.InterfaceC0401a, d.a {
    private static final boolean DEBUG = b.DEBUG;
    private com.baidu.swan.games.e.b cJn;
    private c cTP;
    private com.baidu.swan.games.view.recommend.a.b cTZ;
    private com.baidu.swan.games.view.recommend.model.a cTg;
    private RecommendButtonState cUa;
    private int mSourceType;
    @V8JavascriptField
    public final d style;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public enum RecommendButtonState {
        IDLE,
        LOADING,
        HIDE,
        SHOW,
        DESTROYED
    }

    public RecommendButtonApiProxy(com.baidu.swan.games.e.b bVar, JsObject jsObject) {
        super(bVar);
        this.cTP = new c();
        this.style = new d();
        this.cJn = bVar;
        if (p(jsObject)) {
            com.baidu.swan.games.view.c.a(this);
        }
    }

    @JavascriptInterface
    public void load() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "load: state-" + this.cUa);
        }
        if (this.cUa == RecommendButtonState.IDLE) {
            this.cUa = RecommendButtonState.LOADING;
            e.a(this.mSourceType, new a() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.1
                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onSuccess(String str) {
                    com.baidu.swan.games.view.recommend.model.c rh = com.baidu.swan.games.view.recommend.model.b.rh(str);
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onSuccess-" + rh.isSuccess());
                    }
                    if (RecommendButtonApiProxy.this.cUa != RecommendButtonState.DESTROYED) {
                        if (rh.isSuccess()) {
                            RecommendButtonApiProxy.this.cUa = RecommendButtonState.HIDE;
                            RecommendButtonApiProxy.this.cTg = com.baidu.swan.games.view.recommend.model.b.bT(rh.data);
                            RecommendButtonApiProxy.this.cTZ.a(RecommendButtonApiProxy.this.cTg);
                            RecommendButtonApiProxy.this.azA();
                            return;
                        }
                        RecommendButtonApiProxy.this.cUa = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.rk(String.format("RecommendationButton.load failed,%s", rh.errMsg));
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onFail(String str) {
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onFail-" + str);
                    }
                    if (RecommendButtonApiProxy.this.cUa != RecommendButtonState.DESTROYED) {
                        RecommendButtonApiProxy.this.cUa = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.rk(String.format("RecommendationButton.load failed,%s", str));
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void show() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "show: state-" + this.cUa);
        }
        if (this.cUa == RecommendButtonState.HIDE) {
            this.cUa = RecommendButtonState.SHOW;
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.2
                @Override // java.lang.Runnable
                public void run() {
                    RecommendButtonApiProxy.this.cTP.a(RecommendButtonApiProxy.this.mSourceType, RecommendButtonApiProxy.this.cTg);
                }
            });
            this.cTZ.show();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void hide() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "hide: state-" + this.cUa);
        }
        if (this.cUa == RecommendButtonState.SHOW) {
            this.cUa = RecommendButtonState.HIDE;
            this.cTZ.hide();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void destroy() {
        azy();
        com.baidu.swan.games.view.c.b(this);
    }

    private void azy() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "destroy: state-" + this.cUa);
        }
        if (this.cUa != RecommendButtonState.DESTROYED) {
            this.cUa = RecommendButtonState.DESTROYED;
            if (this.cTZ != null) {
                this.cTZ.destroy();
            }
            this.cTg = null;
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.d.a
    public void pg(String str) {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "onStyleChanged:" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + this.cUa + Constants.ACCEPT_TIME_SEPARATOR_SP + this.style);
        }
        if (this.cUa == RecommendButtonState.SHOW) {
            this.cTZ.update();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0401a
    @UiThread
    public void ik(int i) {
        if (this.cTg != null && i >= 0 && i < this.cTg.cTJ.size()) {
            a(this.cTg.cTJ.get(i), ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME);
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0401a
    @UiThread
    public void azp() {
        if (this.cTg != null) {
            a(this.cTg.cTI, "game_center");
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0401a
    @UiThread
    public void azq() {
        this.cTP.f(this.mSourceType, "list", c.cTm);
    }

    private void dP(boolean z) {
        if (azz()) {
            this.cTZ.dP(z);
        }
    }

    private boolean p(JsObject jsObject) {
        this.cUa = RecommendButtonState.IDLE;
        this.style.a(this);
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (c == null) {
            c = new com.baidu.swan.games.binding.model.c();
        }
        String optString = c.optString("type");
        if (g(c, "type")) {
            this.mSourceType = ri(optString);
        } else {
            this.mSourceType = 1;
        }
        if (this.mSourceType == 0) {
            rj("createRecommendationButton failed,parameter error: the 'type' is invalid.");
            return false;
        }
        if (g(c, "style")) {
            com.baidu.swan.games.binding.model.c pS = c.pS("style");
            if (pS == null) {
                rj("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            } else if (!n(pS)) {
                rj("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            }
        }
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "init: style-" + this.style);
        }
        this.cTZ = new com.baidu.swan.games.view.recommend.proxy.a(this.mSourceType, this.style, this);
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
                this.style.f1009top = (float) cVar.getDouble(VerticalTranslateLayout.TOP);
                return true;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean g(com.baidu.swan.games.binding.model.c cVar, String str) {
        int pK = cVar != null ? cVar.pK(str) : 12;
        return (pK == 12 || pK == 11) ? false : true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int ri(@Nullable String str) {
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
            e.ac(this.mSourceType, recommendItemModel.appKey);
            SchemeRouter.invokeScheme(com.baidu.swan.games.view.c.ayG(), Uri.parse(recommendItemModel.scheme), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            this.cTP.f(this.mSourceType, str, recommendItemModel.appKey);
        }
    }

    private boolean azz() {
        return this.cUa == RecommendButtonState.HIDE || this.cUa == RecommendButtonState.SHOW;
    }

    private void rj(String str) {
        this.cJn.throwJSException(JSExceptionType.Error, str);
        azy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azA() {
        dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rk(String str) {
        com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
        bVar.errMsg = str;
        dispatchEvent(new JSEvent(BdStatsConstant.StatsType.ERROR, bVar));
    }

    @Override // com.baidu.swan.games.view.a
    public void ate() {
        dP(true);
    }

    @Override // com.baidu.swan.games.view.a
    public void atf() {
        dP(false);
    }

    @Override // com.baidu.swan.games.view.a
    public void onViewDestroy() {
        azy();
    }

    /* loaded from: classes11.dex */
    private abstract class a extends StringResponseCallback {
        abstract void onFail(String str);

        abstract void onSuccess(String str);

        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(final String str, int i) {
            RecommendButtonApiProxy.this.cJn.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onSuccess(str);
                }
            });
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(final Exception exc) {
            RecommendButtonApiProxy.this.cJn.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onFail(exc.getMessage());
                }
            });
        }
    }
}
