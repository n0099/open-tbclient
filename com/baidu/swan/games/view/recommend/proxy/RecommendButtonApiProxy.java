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
public class RecommendButtonApiProxy extends EventTargetImpl implements com.baidu.swan.games.view.a, com.baidu.swan.games.view.recommend.a, a.InterfaceC0535a, d.a {
    private static final boolean DEBUG = b.DEBUG;
    private com.baidu.swan.games.f.b dLd;
    private com.baidu.swan.games.view.recommend.model.a dVv;
    private c dWe;
    private com.baidu.swan.games.view.recommend.a.b dWn;
    private RecommendButtonState dWo;
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
        this.dWe = new c();
        this.style = new d();
        this.dLd = bVar;
        if (r(jsObject)) {
            com.baidu.swan.games.view.c.a(this);
        }
    }

    @JavascriptInterface
    public void load() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "load: state-" + this.dWo);
        }
        if (this.dWo == RecommendButtonState.IDLE) {
            this.dWo = RecommendButtonState.LOADING;
            e.a(this.mSourceType, new a() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.1
                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onSuccess(String str) {
                    com.baidu.swan.games.view.recommend.model.c xL = com.baidu.swan.games.view.recommend.model.b.xL(str);
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onSuccess-" + xL.isSuccess());
                    }
                    if (RecommendButtonApiProxy.this.dWo != RecommendButtonState.DESTROYED) {
                        if (xL.isSuccess()) {
                            RecommendButtonApiProxy.this.dWo = RecommendButtonState.HIDE;
                            RecommendButtonApiProxy.this.dVv = com.baidu.swan.games.view.recommend.model.b.cA(xL.data);
                            RecommendButtonApiProxy.this.dWn.a(RecommendButtonApiProxy.this.dVv);
                            RecommendButtonApiProxy.this.aWu();
                            return;
                        }
                        RecommendButtonApiProxy.this.dWo = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.xO(String.format("RecommendationButton.load failed,%s", xL.errMsg));
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onFail(String str) {
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onFail-" + str);
                    }
                    if (RecommendButtonApiProxy.this.dWo != RecommendButtonState.DESTROYED) {
                        RecommendButtonApiProxy.this.dWo = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.xO(String.format("RecommendationButton.load failed,%s", str));
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void show() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "show: state-" + this.dWo);
        }
        if (this.dWo == RecommendButtonState.HIDE) {
            this.dWo = RecommendButtonState.SHOW;
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.2
                @Override // java.lang.Runnable
                public void run() {
                    RecommendButtonApiProxy.this.dWe.a(RecommendButtonApiProxy.this.mSourceType, RecommendButtonApiProxy.this.dVv);
                }
            });
            this.dWn.show();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void hide() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "hide: state-" + this.dWo);
        }
        if (this.dWo == RecommendButtonState.SHOW) {
            this.dWo = RecommendButtonState.HIDE;
            this.dWn.hide();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void destroy() {
        aWs();
        com.baidu.swan.games.view.c.b(this);
    }

    private void aWs() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "destroy: state-" + this.dWo);
        }
        if (this.dWo != RecommendButtonState.DESTROYED) {
            this.dWo = RecommendButtonState.DESTROYED;
            if (this.dWn != null) {
                this.dWn.destroy();
            }
            this.dVv = null;
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.d.a
    public void vy(String str) {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "onStyleChanged:" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + this.dWo + Constants.ACCEPT_TIME_SEPARATOR_SP + this.style);
        }
        if (this.dWo == RecommendButtonState.SHOW) {
            this.dWn.update();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0535a
    @UiThread
    public void mh(int i) {
        if (this.dVv != null && i >= 0 && i < this.dVv.dVY.size()) {
            a(this.dVv.dVY.get(i), ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME);
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0535a
    @UiThread
    public void aWl() {
        if (this.dVv != null) {
            a(this.dVv.dVX, "game_center");
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0535a
    @UiThread
    public void aWm() {
        this.dWe.g(this.mSourceType, "list", c.dVB);
    }

    private void fr(boolean z) {
        if (aWt()) {
            this.dWn.fr(z);
        }
    }

    private boolean r(JsObject jsObject) {
        this.dWo = RecommendButtonState.IDLE;
        this.style.a(this);
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e == null) {
            e = new com.baidu.swan.games.binding.model.c();
        }
        String optString = e.optString("type");
        if (g(e, "type")) {
            this.mSourceType = xM(optString);
        } else {
            this.mSourceType = 1;
        }
        if (this.mSourceType == 0) {
            xN("createRecommendationButton failed,parameter error: the 'type' is invalid.");
            return false;
        }
        if (g(e, "style")) {
            com.baidu.swan.games.binding.model.c wr = e.wr("style");
            if (wr == null) {
                xN("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            } else if (!n(wr)) {
                xN("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            }
        }
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "init: style-" + this.style);
        }
        this.dWn = new com.baidu.swan.games.view.recommend.proxy.a(this.mSourceType, this.style, this);
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
        int wj = cVar != null ? cVar.wj(str) : 12;
        return (wj == 12 || wj == 11) ? false : true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int xM(@Nullable String str) {
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
            e.av(this.mSourceType, recommendItemModel.appKey);
            SchemeRouter.invokeScheme(com.baidu.swan.games.view.c.aVB(), Uri.parse(recommendItemModel.scheme), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            this.dWe.g(this.mSourceType, str, recommendItemModel.appKey);
        }
    }

    private boolean aWt() {
        return this.dWo == RecommendButtonState.HIDE || this.dWo == RecommendButtonState.SHOW;
    }

    private void xN(String str) {
        this.dLd.throwJSException(JSExceptionType.Error, str);
        aWs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWu() {
        dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xO(String str) {
        com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
        bVar.errMsg = str;
        dispatchEvent(new JSEvent(BdStatsConstant.StatsType.ERROR, bVar));
    }

    @Override // com.baidu.swan.games.view.a
    public void aPl() {
        fr(true);
    }

    @Override // com.baidu.swan.games.view.a
    public void aPm() {
        fr(false);
    }

    @Override // com.baidu.swan.games.view.a
    public void onViewDestroy() {
        aWs();
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
            RecommendButtonApiProxy.this.dLd.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onSuccess(str);
                }
            });
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(final Exception exc) {
            RecommendButtonApiProxy.this.dLd.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onFail(exc.getMessage());
                }
            });
        }
    }
}
