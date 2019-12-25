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
/* loaded from: classes9.dex */
public class RecommendButtonApiProxy extends EventTargetImpl implements com.baidu.swan.games.view.a, com.baidu.swan.games.view.recommend.a, a.InterfaceC0338a, d.a {
    private static final boolean DEBUG = b.DEBUG;
    private com.baidu.swan.games.e.b cfI;
    private com.baidu.swan.games.view.recommend.model.a cpD;
    private c cqm;
    private com.baidu.swan.games.view.recommend.a.b cqw;
    private RecommendButtonState cqx;
    private int mSourceType;
    @V8JavascriptField
    public final d style;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public enum RecommendButtonState {
        IDLE,
        LOADING,
        HIDE,
        SHOW,
        DESTROYED
    }

    public RecommendButtonApiProxy(com.baidu.swan.games.e.b bVar, JsObject jsObject) {
        super(bVar);
        this.cqm = new c();
        this.style = new d();
        this.cfI = bVar;
        if (p(jsObject)) {
            com.baidu.swan.games.view.c.a(this);
        }
    }

    @JavascriptInterface
    public void load() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "load: state-" + this.cqx);
        }
        if (this.cqx == RecommendButtonState.IDLE) {
            this.cqx = RecommendButtonState.LOADING;
            e.a(this.mSourceType, new a() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.1
                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onSuccess(String str) {
                    com.baidu.swan.games.view.recommend.model.c pD = com.baidu.swan.games.view.recommend.model.b.pD(str);
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onSuccess-" + pD.isSuccess());
                    }
                    if (RecommendButtonApiProxy.this.cqx != RecommendButtonState.DESTROYED) {
                        if (pD.isSuccess()) {
                            RecommendButtonApiProxy.this.cqx = RecommendButtonState.HIDE;
                            RecommendButtonApiProxy.this.cpD = com.baidu.swan.games.view.recommend.model.b.bI(pD.data);
                            RecommendButtonApiProxy.this.cqw.a(RecommendButtonApiProxy.this.cpD);
                            RecommendButtonApiProxy.this.aoD();
                            return;
                        }
                        RecommendButtonApiProxy.this.cqx = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.pG(String.format("RecommendationButton.load failed,%s", pD.errMsg));
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onFail(String str) {
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onFail-" + str);
                    }
                    if (RecommendButtonApiProxy.this.cqx != RecommendButtonState.DESTROYED) {
                        RecommendButtonApiProxy.this.cqx = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.pG(String.format("RecommendationButton.load failed,%s", str));
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void show() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "show: state-" + this.cqx);
        }
        if (this.cqx == RecommendButtonState.HIDE) {
            this.cqx = RecommendButtonState.SHOW;
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.2
                @Override // java.lang.Runnable
                public void run() {
                    RecommendButtonApiProxy.this.cqm.a(RecommendButtonApiProxy.this.mSourceType, RecommendButtonApiProxy.this.cpD);
                }
            });
            this.cqw.show();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void hide() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "hide: state-" + this.cqx);
        }
        if (this.cqx == RecommendButtonState.SHOW) {
            this.cqx = RecommendButtonState.HIDE;
            this.cqw.hide();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void destroy() {
        aoB();
        com.baidu.swan.games.view.c.b(this);
    }

    private void aoB() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "destroy: state-" + this.cqx);
        }
        if (this.cqx != RecommendButtonState.DESTROYED) {
            this.cqx = RecommendButtonState.DESTROYED;
            if (this.cqw != null) {
                this.cqw.destroy();
            }
            this.cpD = null;
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.d.a
    public void nA(String str) {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "onStyleChanged:" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + this.cqx + Constants.ACCEPT_TIME_SEPARATOR_SP + this.style);
        }
        if (this.cqx == RecommendButtonState.SHOW) {
            this.cqw.update();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0338a
    @UiThread
    public void hM(int i) {
        if (this.cpD != null && i >= 0 && i < this.cpD.cqg.size()) {
            a(this.cpD.cqg.get(i), ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME);
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0338a
    @UiThread
    public void aos() {
        if (this.cpD != null) {
            a(this.cpD.cqf, "game_center");
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0338a
    @UiThread
    public void aot() {
        this.cqm.e(this.mSourceType, "list", c.cpJ);
    }

    private void cG(boolean z) {
        if (aoC()) {
            this.cqw.cG(z);
        }
    }

    private boolean p(JsObject jsObject) {
        this.cqx = RecommendButtonState.IDLE;
        this.style.a(this);
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (c == null) {
            c = new com.baidu.swan.games.binding.model.c();
        }
        String optString = c.optString("type");
        if (g(c, "type")) {
            this.mSourceType = pE(optString);
        } else {
            this.mSourceType = 1;
        }
        if (this.mSourceType == 0) {
            pF("createRecommendationButton failed,parameter error: the 'type' is invalid.");
            return false;
        }
        if (g(c, "style")) {
            com.baidu.swan.games.binding.model.c oo = c.oo("style");
            if (oo == null) {
                pF("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            } else if (!n(oo)) {
                pF("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            }
        }
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "init: style-" + this.style);
        }
        this.cqw = new com.baidu.swan.games.view.recommend.proxy.a(this.mSourceType, this.style, this);
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
        int oe = cVar != null ? cVar.oe(str) : 12;
        return (oe == 12 || oe == 11) ? false : true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int pE(@Nullable String str) {
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
            e.H(this.mSourceType, recommendItemModel.appKey);
            SchemeRouter.invokeScheme(com.baidu.swan.games.view.c.anI(), Uri.parse(recommendItemModel.scheme), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            this.cqm.e(this.mSourceType, str, recommendItemModel.appKey);
        }
    }

    private boolean aoC() {
        return this.cqx == RecommendButtonState.HIDE || this.cqx == RecommendButtonState.SHOW;
    }

    private void pF(String str) {
        this.cfI.throwJSException(JSExceptionType.Error, str);
        aoB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoD() {
        dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pG(String str) {
        com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
        bVar.errMsg = str;
        dispatchEvent(new JSEvent(BdStatsConstant.StatsType.ERROR, bVar));
    }

    @Override // com.baidu.swan.games.view.a
    public void aif() {
        cG(true);
    }

    @Override // com.baidu.swan.games.view.a
    public void aig() {
        cG(false);
    }

    @Override // com.baidu.swan.games.view.a
    public void onViewDestroy() {
        aoB();
    }

    /* loaded from: classes9.dex */
    private abstract class a extends StringResponseCallback {
        abstract void onFail(String str);

        abstract void onSuccess(String str);

        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(final String str, int i) {
            RecommendButtonApiProxy.this.cfI.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onSuccess(str);
                }
            });
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(final Exception exc) {
            RecommendButtonApiProxy.this.cfI.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onFail(exc.getMessage());
                }
            });
        }
    }
}
