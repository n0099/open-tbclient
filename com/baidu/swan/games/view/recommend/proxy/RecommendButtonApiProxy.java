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
/* loaded from: classes7.dex */
public class RecommendButtonApiProxy extends EventTargetImpl implements com.baidu.swan.games.view.a, com.baidu.swan.games.view.recommend.a, a.InterfaceC0545a, d.a {
    private static final boolean DEBUG = b.DEBUG;
    private com.baidu.swan.games.f.b dPn;
    private com.baidu.swan.games.view.recommend.model.a dZF;
    private c eao;
    private com.baidu.swan.games.view.recommend.a.b eax;
    private RecommendButtonState eay;
    private int mSourceType;
    @V8JavascriptField
    public final d style;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public enum RecommendButtonState {
        IDLE,
        LOADING,
        HIDE,
        SHOW,
        DESTROYED
    }

    public RecommendButtonApiProxy(com.baidu.swan.games.f.b bVar, JsObject jsObject) {
        super(bVar);
        this.eao = new c();
        this.style = new d();
        this.dPn = bVar;
        if (r(jsObject)) {
            com.baidu.swan.games.view.c.a(this);
        }
    }

    @JavascriptInterface
    public void load() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "load: state-" + this.eay);
        }
        if (this.eay == RecommendButtonState.IDLE) {
            this.eay = RecommendButtonState.LOADING;
            e.a(this.mSourceType, new a() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.1
                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onSuccess(String str) {
                    com.baidu.swan.games.view.recommend.model.c xU = com.baidu.swan.games.view.recommend.model.b.xU(str);
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onSuccess-" + xU.isSuccess());
                    }
                    if (RecommendButtonApiProxy.this.eay != RecommendButtonState.DESTROYED) {
                        if (xU.isSuccess()) {
                            RecommendButtonApiProxy.this.eay = RecommendButtonState.HIDE;
                            RecommendButtonApiProxy.this.dZF = com.baidu.swan.games.view.recommend.model.b.cA(xU.data);
                            RecommendButtonApiProxy.this.eax.a(RecommendButtonApiProxy.this.dZF);
                            RecommendButtonApiProxy.this.aYn();
                            return;
                        }
                        RecommendButtonApiProxy.this.eay = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.xX(String.format("RecommendationButton.load failed,%s", xU.errMsg));
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onFail(String str) {
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onFail-" + str);
                    }
                    if (RecommendButtonApiProxy.this.eay != RecommendButtonState.DESTROYED) {
                        RecommendButtonApiProxy.this.eay = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.xX(String.format("RecommendationButton.load failed,%s", str));
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void show() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "show: state-" + this.eay);
        }
        if (this.eay == RecommendButtonState.HIDE) {
            this.eay = RecommendButtonState.SHOW;
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.2
                @Override // java.lang.Runnable
                public void run() {
                    RecommendButtonApiProxy.this.eao.a(RecommendButtonApiProxy.this.mSourceType, RecommendButtonApiProxy.this.dZF);
                }
            });
            this.eax.show();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void hide() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "hide: state-" + this.eay);
        }
        if (this.eay == RecommendButtonState.SHOW) {
            this.eay = RecommendButtonState.HIDE;
            this.eax.hide();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void destroy() {
        aYl();
        com.baidu.swan.games.view.c.b(this);
    }

    private void aYl() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "destroy: state-" + this.eay);
        }
        if (this.eay != RecommendButtonState.DESTROYED) {
            this.eay = RecommendButtonState.DESTROYED;
            if (this.eax != null) {
                this.eax.destroy();
            }
            this.dZF = null;
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.d.a
    public void vH(String str) {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "onStyleChanged:" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + this.eay + Constants.ACCEPT_TIME_SEPARATOR_SP + this.style);
        }
        if (this.eay == RecommendButtonState.SHOW) {
            this.eax.update();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0545a
    @UiThread
    public void mn(int i) {
        if (this.dZF != null && i >= 0 && i < this.dZF.eai.size()) {
            a(this.dZF.eai.get(i), ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME);
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0545a
    @UiThread
    public void aYe() {
        if (this.dZF != null) {
            a(this.dZF.eah, "game_center");
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0545a
    @UiThread
    public void aYf() {
        this.eao.g(this.mSourceType, "list", c.dZL);
    }

    private void fD(boolean z) {
        if (aYm()) {
            this.eax.fD(z);
        }
    }

    private boolean r(JsObject jsObject) {
        this.eay = RecommendButtonState.IDLE;
        this.style.a(this);
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e == null) {
            e = new com.baidu.swan.games.binding.model.c();
        }
        String optString = e.optString("type");
        if (g(e, "type")) {
            this.mSourceType = xV(optString);
        } else {
            this.mSourceType = 1;
        }
        if (this.mSourceType == 0) {
            xW("createRecommendationButton failed,parameter error: the 'type' is invalid.");
            return false;
        }
        if (g(e, "style")) {
            com.baidu.swan.games.binding.model.c wA = e.wA("style");
            if (wA == null) {
                xW("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            } else if (!n(wA)) {
                xW("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            }
        }
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "init: style-" + this.style);
        }
        this.eax = new com.baidu.swan.games.view.recommend.proxy.a(this.mSourceType, this.style, this);
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
        int ws = cVar != null ? cVar.ws(str) : 12;
        return (ws == 12 || ws == 11) ? false : true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int xV(@Nullable String str) {
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
            e.az(this.mSourceType, recommendItemModel.appKey);
            SchemeRouter.invokeScheme(com.baidu.swan.games.view.c.aXt(), Uri.parse(recommendItemModel.scheme), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            this.eao.g(this.mSourceType, str, recommendItemModel.appKey);
        }
    }

    private boolean aYm() {
        return this.eay == RecommendButtonState.HIDE || this.eay == RecommendButtonState.SHOW;
    }

    private void xW(String str) {
        this.dPn.throwJSException(JSExceptionType.Error, str);
        aYl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYn() {
        dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xX(String str) {
        com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
        bVar.errMsg = str;
        dispatchEvent(new JSEvent(BdStatsConstant.StatsType.ERROR, bVar));
    }

    @Override // com.baidu.swan.games.view.a
    public void aRd() {
        fD(true);
    }

    @Override // com.baidu.swan.games.view.a
    public void aRe() {
        fD(false);
    }

    @Override // com.baidu.swan.games.view.a
    public void onViewDestroy() {
        aYl();
    }

    /* loaded from: classes7.dex */
    private abstract class a extends StringResponseCallback {
        abstract void onFail(String str);

        abstract void onSuccess(String str);

        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(final String str, int i) {
            RecommendButtonApiProxy.this.dPn.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onSuccess(str);
                }
            });
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(final Exception exc) {
            RecommendButtonApiProxy.this.dPn.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onFail(exc.getMessage());
                }
            });
        }
    }
}
