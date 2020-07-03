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
import com.baidu.swan.apps.aq.aj;
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
public class RecommendButtonApiProxy extends EventTargetImpl implements com.baidu.swan.games.view.a, com.baidu.swan.games.view.recommend.a, a.InterfaceC0448a, d.a {
    private static final boolean DEBUG = b.DEBUG;
    private com.baidu.swan.games.f.b cYE;
    private com.baidu.swan.games.view.recommend.model.a diV;
    private c djE;
    private com.baidu.swan.games.view.recommend.a.b djO;
    private RecommendButtonState djP;
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

    public RecommendButtonApiProxy(com.baidu.swan.games.f.b bVar, JsObject jsObject) {
        super(bVar);
        this.djE = new c();
        this.style = new d();
        this.cYE = bVar;
        if (r(jsObject)) {
            com.baidu.swan.games.view.c.a(this);
        }
    }

    @JavascriptInterface
    public void load() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "load: state-" + this.djP);
        }
        if (this.djP == RecommendButtonState.IDLE) {
            this.djP = RecommendButtonState.LOADING;
            e.a(this.mSourceType, new a() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.1
                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onSuccess(String str) {
                    com.baidu.swan.games.view.recommend.model.c sT = com.baidu.swan.games.view.recommend.model.b.sT(str);
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onSuccess-" + sT.isSuccess());
                    }
                    if (RecommendButtonApiProxy.this.djP != RecommendButtonState.DESTROYED) {
                        if (sT.isSuccess()) {
                            RecommendButtonApiProxy.this.djP = RecommendButtonState.HIDE;
                            RecommendButtonApiProxy.this.diV = com.baidu.swan.games.view.recommend.model.b.cb(sT.data);
                            RecommendButtonApiProxy.this.djO.a(RecommendButtonApiProxy.this.diV);
                            RecommendButtonApiProxy.this.aEy();
                            return;
                        }
                        RecommendButtonApiProxy.this.djP = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.sW(String.format("RecommendationButton.load failed,%s", sT.errMsg));
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onFail(String str) {
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onFail-" + str);
                    }
                    if (RecommendButtonApiProxy.this.djP != RecommendButtonState.DESTROYED) {
                        RecommendButtonApiProxy.this.djP = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.sW(String.format("RecommendationButton.load failed,%s", str));
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void show() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "show: state-" + this.djP);
        }
        if (this.djP == RecommendButtonState.HIDE) {
            this.djP = RecommendButtonState.SHOW;
            aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.2
                @Override // java.lang.Runnable
                public void run() {
                    RecommendButtonApiProxy.this.djE.a(RecommendButtonApiProxy.this.mSourceType, RecommendButtonApiProxy.this.diV);
                }
            });
            this.djO.show();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void hide() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "hide: state-" + this.djP);
        }
        if (this.djP == RecommendButtonState.SHOW) {
            this.djP = RecommendButtonState.HIDE;
            this.djO.hide();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void destroy() {
        aEw();
        com.baidu.swan.games.view.c.b(this);
    }

    private void aEw() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "destroy: state-" + this.djP);
        }
        if (this.djP != RecommendButtonState.DESTROYED) {
            this.djP = RecommendButtonState.DESTROYED;
            if (this.djO != null) {
                this.djO.destroy();
            }
            this.diV = null;
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.d.a
    public void qM(String str) {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "onStyleChanged:" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + this.djP + Constants.ACCEPT_TIME_SEPARATOR_SP + this.style);
        }
        if (this.djP == RecommendButtonState.SHOW) {
            this.djO.update();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0448a
    @UiThread
    public void iO(int i) {
        if (this.diV != null && i >= 0 && i < this.diV.djy.size()) {
            a(this.diV.djy.get(i), ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME);
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0448a
    @UiThread
    public void aEn() {
        if (this.diV != null) {
            a(this.diV.djx, "game_center");
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0448a
    @UiThread
    public void aEo() {
        this.djE.f(this.mSourceType, "list", c.djb);
    }

    private void el(boolean z) {
        if (aEx()) {
            this.djO.el(z);
        }
    }

    private boolean r(JsObject jsObject) {
        this.djP = RecommendButtonState.IDLE;
        this.style.a(this);
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e == null) {
            e = new com.baidu.swan.games.binding.model.c();
        }
        String optString = e.optString("type");
        if (g(e, "type")) {
            this.mSourceType = sU(optString);
        } else {
            this.mSourceType = 1;
        }
        if (this.mSourceType == 0) {
            sV("createRecommendationButton failed,parameter error: the 'type' is invalid.");
            return false;
        }
        if (g(e, "style")) {
            com.baidu.swan.games.binding.model.c rC = e.rC("style");
            if (rC == null) {
                sV("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            } else if (!n(rC)) {
                sV("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            }
        }
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "init: style-" + this.style);
        }
        this.djO = new com.baidu.swan.games.view.recommend.proxy.a(this.mSourceType, this.style, this);
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
                this.style.f1012top = (float) cVar.getDouble(VerticalTranslateLayout.TOP);
                return true;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean g(com.baidu.swan.games.binding.model.c cVar, String str) {
        int ru = cVar != null ? cVar.ru(str) : 12;
        return (ru == 12 || ru == 11) ? false : true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int sU(@Nullable String str) {
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
            e.ai(this.mSourceType, recommendItemModel.appKey);
            SchemeRouter.invokeScheme(com.baidu.swan.games.view.c.aDE(), Uri.parse(recommendItemModel.scheme), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            this.djE.f(this.mSourceType, str, recommendItemModel.appKey);
        }
    }

    private boolean aEx() {
        return this.djP == RecommendButtonState.HIDE || this.djP == RecommendButtonState.SHOW;
    }

    private void sV(String str) {
        this.cYE.throwJSException(JSExceptionType.Error, str);
        aEw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEy() {
        dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sW(String str) {
        com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
        bVar.errMsg = str;
        dispatchEvent(new JSEvent(BdStatsConstant.StatsType.ERROR, bVar));
    }

    @Override // com.baidu.swan.games.view.a
    public void axR() {
        el(true);
    }

    @Override // com.baidu.swan.games.view.a
    public void axS() {
        el(false);
    }

    @Override // com.baidu.swan.games.view.a
    public void onViewDestroy() {
        aEw();
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
            RecommendButtonApiProxy.this.cYE.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onSuccess(str);
                }
            });
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(final Exception exc) {
            RecommendButtonApiProxy.this.cYE.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onFail(exc.getMessage());
                }
            });
        }
    }
}
