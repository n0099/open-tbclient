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
public class RecommendButtonApiProxy extends EventTargetImpl implements com.baidu.swan.games.view.a, com.baidu.swan.games.view.recommend.a, a.InterfaceC0380a, d.a {
    private static final boolean DEBUG = b.DEBUG;
    private com.baidu.swan.games.e.b cJh;
    private c cTK;
    private com.baidu.swan.games.view.recommend.a.b cTU;
    private RecommendButtonState cTV;
    private com.baidu.swan.games.view.recommend.model.a cTb;
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
        this.cTK = new c();
        this.style = new d();
        this.cJh = bVar;
        if (p(jsObject)) {
            com.baidu.swan.games.view.c.a(this);
        }
    }

    @JavascriptInterface
    public void load() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "load: state-" + this.cTV);
        }
        if (this.cTV == RecommendButtonState.IDLE) {
            this.cTV = RecommendButtonState.LOADING;
            e.a(this.mSourceType, new a() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.1
                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onSuccess(String str) {
                    com.baidu.swan.games.view.recommend.model.c rh = com.baidu.swan.games.view.recommend.model.b.rh(str);
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onSuccess-" + rh.isSuccess());
                    }
                    if (RecommendButtonApiProxy.this.cTV != RecommendButtonState.DESTROYED) {
                        if (rh.isSuccess()) {
                            RecommendButtonApiProxy.this.cTV = RecommendButtonState.HIDE;
                            RecommendButtonApiProxy.this.cTb = com.baidu.swan.games.view.recommend.model.b.bT(rh.data);
                            RecommendButtonApiProxy.this.cTU.a(RecommendButtonApiProxy.this.cTb);
                            RecommendButtonApiProxy.this.azA();
                            return;
                        }
                        RecommendButtonApiProxy.this.cTV = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.rk(String.format("RecommendationButton.load failed,%s", rh.errMsg));
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onFail(String str) {
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onFail-" + str);
                    }
                    if (RecommendButtonApiProxy.this.cTV != RecommendButtonState.DESTROYED) {
                        RecommendButtonApiProxy.this.cTV = RecommendButtonState.IDLE;
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
            Log.d("RecommendButtonApiProxy", "show: state-" + this.cTV);
        }
        if (this.cTV == RecommendButtonState.HIDE) {
            this.cTV = RecommendButtonState.SHOW;
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.2
                @Override // java.lang.Runnable
                public void run() {
                    RecommendButtonApiProxy.this.cTK.a(RecommendButtonApiProxy.this.mSourceType, RecommendButtonApiProxy.this.cTb);
                }
            });
            this.cTU.show();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void hide() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "hide: state-" + this.cTV);
        }
        if (this.cTV == RecommendButtonState.SHOW) {
            this.cTV = RecommendButtonState.HIDE;
            this.cTU.hide();
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
            Log.d("RecommendButtonApiProxy", "destroy: state-" + this.cTV);
        }
        if (this.cTV != RecommendButtonState.DESTROYED) {
            this.cTV = RecommendButtonState.DESTROYED;
            if (this.cTU != null) {
                this.cTU.destroy();
            }
            this.cTb = null;
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.d.a
    public void pg(String str) {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "onStyleChanged:" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + this.cTV + Constants.ACCEPT_TIME_SEPARATOR_SP + this.style);
        }
        if (this.cTV == RecommendButtonState.SHOW) {
            this.cTU.update();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0380a
    @UiThread
    public void ik(int i) {
        if (this.cTb != null && i >= 0 && i < this.cTb.cTE.size()) {
            a(this.cTb.cTE.get(i), ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME);
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0380a
    @UiThread
    public void azp() {
        if (this.cTb != null) {
            a(this.cTb.cTD, "game_center");
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0380a
    @UiThread
    public void azq() {
        this.cTK.f(this.mSourceType, "list", c.cTh);
    }

    private void dP(boolean z) {
        if (azz()) {
            this.cTU.dP(z);
        }
    }

    private boolean p(JsObject jsObject) {
        this.cTV = RecommendButtonState.IDLE;
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
        this.cTU = new com.baidu.swan.games.view.recommend.proxy.a(this.mSourceType, this.style, this);
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
                this.style.f1017top = (float) cVar.getDouble(VerticalTranslateLayout.TOP);
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
            this.cTK.f(this.mSourceType, str, recommendItemModel.appKey);
        }
    }

    private boolean azz() {
        return this.cTV == RecommendButtonState.HIDE || this.cTV == RecommendButtonState.SHOW;
    }

    private void rj(String str) {
        this.cJh.throwJSException(JSExceptionType.Error, str);
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
            RecommendButtonApiProxy.this.cJh.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onSuccess(str);
                }
            });
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(final Exception exc) {
            RecommendButtonApiProxy.this.cJh.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onFail(exc.getMessage());
                }
            });
        }
    }
}
