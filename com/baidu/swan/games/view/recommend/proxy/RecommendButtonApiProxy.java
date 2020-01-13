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
/* loaded from: classes10.dex */
public class RecommendButtonApiProxy extends EventTargetImpl implements com.baidu.swan.games.view.a, com.baidu.swan.games.view.recommend.a, a.InterfaceC0340a, d.a {
    private static final boolean DEBUG = b.DEBUG;
    private com.baidu.swan.games.e.b cfV;
    private com.baidu.swan.games.view.recommend.model.a cpP;
    private com.baidu.swan.games.view.recommend.a.b cqI;
    private RecommendButtonState cqJ;
    private c cqy;
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

    public RecommendButtonApiProxy(com.baidu.swan.games.e.b bVar, JsObject jsObject) {
        super(bVar);
        this.cqy = new c();
        this.style = new d();
        this.cfV = bVar;
        if (p(jsObject)) {
            com.baidu.swan.games.view.c.a(this);
        }
    }

    @JavascriptInterface
    public void load() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "load: state-" + this.cqJ);
        }
        if (this.cqJ == RecommendButtonState.IDLE) {
            this.cqJ = RecommendButtonState.LOADING;
            e.a(this.mSourceType, new a() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.1
                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onSuccess(String str) {
                    com.baidu.swan.games.view.recommend.model.c pG = com.baidu.swan.games.view.recommend.model.b.pG(str);
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onSuccess-" + pG.isSuccess());
                    }
                    if (RecommendButtonApiProxy.this.cqJ != RecommendButtonState.DESTROYED) {
                        if (pG.isSuccess()) {
                            RecommendButtonApiProxy.this.cqJ = RecommendButtonState.HIDE;
                            RecommendButtonApiProxy.this.cpP = com.baidu.swan.games.view.recommend.model.b.bI(pG.data);
                            RecommendButtonApiProxy.this.cqI.a(RecommendButtonApiProxy.this.cpP);
                            RecommendButtonApiProxy.this.aoW();
                            return;
                        }
                        RecommendButtonApiProxy.this.cqJ = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.pJ(String.format("RecommendationButton.load failed,%s", pG.errMsg));
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onFail(String str) {
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onFail-" + str);
                    }
                    if (RecommendButtonApiProxy.this.cqJ != RecommendButtonState.DESTROYED) {
                        RecommendButtonApiProxy.this.cqJ = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.pJ(String.format("RecommendationButton.load failed,%s", str));
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void show() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "show: state-" + this.cqJ);
        }
        if (this.cqJ == RecommendButtonState.HIDE) {
            this.cqJ = RecommendButtonState.SHOW;
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.2
                @Override // java.lang.Runnable
                public void run() {
                    RecommendButtonApiProxy.this.cqy.a(RecommendButtonApiProxy.this.mSourceType, RecommendButtonApiProxy.this.cpP);
                }
            });
            this.cqI.show();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void hide() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "hide: state-" + this.cqJ);
        }
        if (this.cqJ == RecommendButtonState.SHOW) {
            this.cqJ = RecommendButtonState.HIDE;
            this.cqI.hide();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void destroy() {
        aoU();
        com.baidu.swan.games.view.c.b(this);
    }

    private void aoU() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "destroy: state-" + this.cqJ);
        }
        if (this.cqJ != RecommendButtonState.DESTROYED) {
            this.cqJ = RecommendButtonState.DESTROYED;
            if (this.cqI != null) {
                this.cqI.destroy();
            }
            this.cpP = null;
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.d.a
    public void nD(String str) {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "onStyleChanged:" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + this.cqJ + Constants.ACCEPT_TIME_SEPARATOR_SP + this.style);
        }
        if (this.cqJ == RecommendButtonState.SHOW) {
            this.cqI.update();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0340a
    @UiThread
    public void hM(int i) {
        if (this.cpP != null && i >= 0 && i < this.cpP.cqs.size()) {
            a(this.cpP.cqs.get(i), ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME);
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0340a
    @UiThread
    public void aoL() {
        if (this.cpP != null) {
            a(this.cpP.cqr, "game_center");
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0340a
    @UiThread
    public void aoM() {
        this.cqy.e(this.mSourceType, "list", c.cpV);
    }

    private void cL(boolean z) {
        if (aoV()) {
            this.cqI.cL(z);
        }
    }

    private boolean p(JsObject jsObject) {
        this.cqJ = RecommendButtonState.IDLE;
        this.style.a(this);
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (c == null) {
            c = new com.baidu.swan.games.binding.model.c();
        }
        String optString = c.optString("type");
        if (g(c, "type")) {
            this.mSourceType = pH(optString);
        } else {
            this.mSourceType = 1;
        }
        if (this.mSourceType == 0) {
            pI("createRecommendationButton failed,parameter error: the 'type' is invalid.");
            return false;
        }
        if (g(c, "style")) {
            com.baidu.swan.games.binding.model.c or = c.or("style");
            if (or == null) {
                pI("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            } else if (!n(or)) {
                pI("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            }
        }
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "init: style-" + this.style);
        }
        this.cqI = new com.baidu.swan.games.view.recommend.proxy.a(this.mSourceType, this.style, this);
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
        int oi = cVar != null ? cVar.oi(str) : 12;
        return (oi == 12 || oi == 11) ? false : true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int pH(@Nullable String str) {
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
            e.J(this.mSourceType, recommendItemModel.appKey);
            SchemeRouter.invokeScheme(com.baidu.swan.games.view.c.aob(), Uri.parse(recommendItemModel.scheme), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            this.cqy.e(this.mSourceType, str, recommendItemModel.appKey);
        }
    }

    private boolean aoV() {
        return this.cqJ == RecommendButtonState.HIDE || this.cqJ == RecommendButtonState.SHOW;
    }

    private void pI(String str) {
        this.cfV.throwJSException(JSExceptionType.Error, str);
        aoU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoW() {
        dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pJ(String str) {
        com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
        bVar.errMsg = str;
        dispatchEvent(new JSEvent(BdStatsConstant.StatsType.ERROR, bVar));
    }

    @Override // com.baidu.swan.games.view.a
    public void aiy() {
        cL(true);
    }

    @Override // com.baidu.swan.games.view.a
    public void aiz() {
        cL(false);
    }

    @Override // com.baidu.swan.games.view.a
    public void onViewDestroy() {
        aoU();
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
            RecommendButtonApiProxy.this.cfV.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onSuccess(str);
                }
            });
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(final Exception exc) {
            RecommendButtonApiProxy.this.cfV.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onFail(exc.getMessage());
                }
            });
        }
    }
}
