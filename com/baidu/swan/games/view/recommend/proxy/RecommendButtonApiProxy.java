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
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.b;
import com.baidu.swan.games.view.recommend.a.a;
import com.baidu.swan.games.view.recommend.a.c;
import com.baidu.swan.games.view.recommend.a.d;
import com.baidu.swan.games.view.recommend.a.e;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes10.dex */
public class RecommendButtonApiProxy extends EventTargetImpl implements com.baidu.swan.games.view.a, com.baidu.swan.games.view.recommend.a, a.InterfaceC0521a, d.a {
    private static final boolean DEBUG = b.DEBUG;
    private com.baidu.swan.games.f.b dCG;
    private com.baidu.swan.games.view.recommend.model.a dMY;
    private c dNH;
    private com.baidu.swan.games.view.recommend.a.b dNQ;
    private RecommendButtonState dNR;
    private int mSourceType;
    @V8JavascriptField
    public final d style;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public enum RecommendButtonState {
        IDLE,
        LOADING,
        HIDE,
        SHOW,
        DESTROYED
    }

    public RecommendButtonApiProxy(com.baidu.swan.games.f.b bVar, JsObject jsObject) {
        super(bVar);
        this.dNH = new c();
        this.style = new d();
        this.dCG = bVar;
        if (r(jsObject)) {
            com.baidu.swan.games.view.c.a(this);
        }
    }

    @JavascriptInterface
    public void load() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "load: state-" + this.dNR);
        }
        if (this.dNR == RecommendButtonState.IDLE) {
            this.dNR = RecommendButtonState.LOADING;
            e.a(this.mSourceType, new a() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.1
                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onSuccess(String str) {
                    com.baidu.swan.games.view.recommend.model.c xs = com.baidu.swan.games.view.recommend.model.b.xs(str);
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onSuccess-" + xs.isSuccess());
                    }
                    if (RecommendButtonApiProxy.this.dNR != RecommendButtonState.DESTROYED) {
                        if (xs.isSuccess()) {
                            RecommendButtonApiProxy.this.dNR = RecommendButtonState.HIDE;
                            RecommendButtonApiProxy.this.dMY = com.baidu.swan.games.view.recommend.model.b.cx(xs.data);
                            RecommendButtonApiProxy.this.dNQ.a(RecommendButtonApiProxy.this.dMY);
                            RecommendButtonApiProxy.this.aUA();
                            return;
                        }
                        RecommendButtonApiProxy.this.dNR = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.xv(String.format("RecommendationButton.load failed,%s", xs.errMsg));
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onFail(String str) {
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onFail-" + str);
                    }
                    if (RecommendButtonApiProxy.this.dNR != RecommendButtonState.DESTROYED) {
                        RecommendButtonApiProxy.this.dNR = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.xv(String.format("RecommendationButton.load failed,%s", str));
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void show() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "show: state-" + this.dNR);
        }
        if (this.dNR == RecommendButtonState.HIDE) {
            this.dNR = RecommendButtonState.SHOW;
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.2
                @Override // java.lang.Runnable
                public void run() {
                    RecommendButtonApiProxy.this.dNH.a(RecommendButtonApiProxy.this.mSourceType, RecommendButtonApiProxy.this.dMY);
                }
            });
            this.dNQ.show();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void hide() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "hide: state-" + this.dNR);
        }
        if (this.dNR == RecommendButtonState.SHOW) {
            this.dNR = RecommendButtonState.HIDE;
            this.dNQ.hide();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void destroy() {
        aUy();
        com.baidu.swan.games.view.c.b(this);
    }

    private void aUy() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "destroy: state-" + this.dNR);
        }
        if (this.dNR != RecommendButtonState.DESTROYED) {
            this.dNR = RecommendButtonState.DESTROYED;
            if (this.dNQ != null) {
                this.dNQ.destroy();
            }
            this.dMY = null;
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.d.a
    public void vf(String str) {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "onStyleChanged:" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + this.dNR + Constants.ACCEPT_TIME_SEPARATOR_SP + this.style);
        }
        if (this.dNR == RecommendButtonState.SHOW) {
            this.dNQ.update();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0521a
    @UiThread
    public void lW(int i) {
        if (this.dMY != null && i >= 0 && i < this.dMY.dNB.size()) {
            a(this.dMY.dNB.get(i), ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME);
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0521a
    @UiThread
    public void aUr() {
        if (this.dMY != null) {
            a(this.dMY.dNA, "game_center");
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0521a
    @UiThread
    public void aUs() {
        this.dNH.f(this.mSourceType, "list", c.dNe);
    }

    private void fe(boolean z) {
        if (aUz()) {
            this.dNQ.fe(z);
        }
    }

    private boolean r(JsObject jsObject) {
        this.dNR = RecommendButtonState.IDLE;
        this.style.a(this);
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e == null) {
            e = new com.baidu.swan.games.binding.model.c();
        }
        String optString = e.optString("type");
        if (g(e, "type")) {
            this.mSourceType = xt(optString);
        } else {
            this.mSourceType = 1;
        }
        if (this.mSourceType == 0) {
            xu("createRecommendationButton failed,parameter error: the 'type' is invalid.");
            return false;
        }
        if (g(e, "style")) {
            com.baidu.swan.games.binding.model.c vY = e.vY("style");
            if (vY == null) {
                xu("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            } else if (!n(vY)) {
                xu("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            }
        }
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "init: style-" + this.style);
        }
        this.dNQ = new com.baidu.swan.games.view.recommend.proxy.a(this.mSourceType, this.style, this);
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
        int vQ = cVar != null ? cVar.vQ(str) : 12;
        return (vQ == 12 || vQ == 11) ? false : true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int xt(@Nullable String str) {
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
            e.at(this.mSourceType, recommendItemModel.appKey);
            SchemeRouter.invokeScheme(com.baidu.swan.games.view.c.aTH(), Uri.parse(recommendItemModel.scheme), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            this.dNH.f(this.mSourceType, str, recommendItemModel.appKey);
        }
    }

    private boolean aUz() {
        return this.dNR == RecommendButtonState.HIDE || this.dNR == RecommendButtonState.SHOW;
    }

    private void xu(String str) {
        this.dCG.throwJSException(JSExceptionType.Error, str);
        aUy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUA() {
        dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xv(String str) {
        com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
        bVar.errMsg = str;
        dispatchEvent(new JSEvent(BdStatsConstant.StatsType.ERROR, bVar));
    }

    @Override // com.baidu.swan.games.view.a
    public void aNr() {
        fe(true);
    }

    @Override // com.baidu.swan.games.view.a
    public void aNs() {
        fe(false);
    }

    @Override // com.baidu.swan.games.view.a
    public void onViewDestroy() {
        aUy();
    }

    /* loaded from: classes10.dex */
    private abstract class a extends StringResponseCallback {
        abstract void onFail(String str);

        abstract void onSuccess(String str);

        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(final String str, int i) {
            RecommendButtonApiProxy.this.dCG.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onSuccess(str);
                }
            });
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(final Exception exc) {
            RecommendButtonApiProxy.this.dCG.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onFail(exc.getMessage());
                }
            });
        }
    }
}
