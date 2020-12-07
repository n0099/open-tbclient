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
import java.util.Locale;
/* loaded from: classes25.dex */
public class RecommendButtonApiProxy extends EventTargetImpl implements com.baidu.swan.games.view.a, com.baidu.swan.games.view.recommend.a, a.InterfaceC0557a, d.a {
    private static final boolean DEBUG = b.DEBUG;
    private com.baidu.swan.games.f.b dWl;
    private com.baidu.swan.games.view.recommend.model.a egF;
    private c eho;
    private com.baidu.swan.games.view.recommend.a.b ehx;
    private RecommendButtonState ehy;
    private int mSourceType;
    @V8JavascriptField
    public final d style;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public enum RecommendButtonState {
        IDLE,
        LOADING,
        HIDE,
        SHOW,
        DESTROYED
    }

    public RecommendButtonApiProxy(com.baidu.swan.games.f.b bVar, JsObject jsObject) {
        super(bVar);
        this.eho = new c();
        this.style = new d();
        this.dWl = bVar;
        if (r(jsObject)) {
            com.baidu.swan.games.view.c.a(this);
        }
    }

    @JavascriptInterface
    public void load() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "load: state-" + this.ehy);
        }
        if (this.ehy == RecommendButtonState.IDLE) {
            this.ehy = RecommendButtonState.LOADING;
            e.a(this.mSourceType, new a() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.1
                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onSuccess(String str) {
                    com.baidu.swan.games.view.recommend.model.c yB = com.baidu.swan.games.view.recommend.model.b.yB(str);
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onSuccess-" + yB.isSuccess());
                    }
                    if (RecommendButtonApiProxy.this.ehy != RecommendButtonState.DESTROYED) {
                        if (yB.isSuccess()) {
                            RecommendButtonApiProxy.this.ehy = RecommendButtonState.HIDE;
                            RecommendButtonApiProxy.this.egF = com.baidu.swan.games.view.recommend.model.b.cC(yB.data);
                            RecommendButtonApiProxy.this.ehx.a(RecommendButtonApiProxy.this.egF);
                            RecommendButtonApiProxy.this.bbs();
                            return;
                        }
                        RecommendButtonApiProxy.this.ehy = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.yE(String.format("RecommendationButton.load failed,%s", yB.errMsg));
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onFail(String str) {
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onFail-" + str);
                    }
                    if (RecommendButtonApiProxy.this.ehy != RecommendButtonState.DESTROYED) {
                        RecommendButtonApiProxy.this.ehy = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.yE(String.format("RecommendationButton.load failed,%s", str));
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void show() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "show: state-" + this.ehy);
        }
        if (this.ehy == RecommendButtonState.HIDE) {
            this.ehy = RecommendButtonState.SHOW;
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.2
                @Override // java.lang.Runnable
                public void run() {
                    RecommendButtonApiProxy.this.eho.a(RecommendButtonApiProxy.this.mSourceType, RecommendButtonApiProxy.this.egF);
                }
            });
            this.ehx.show();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void hide() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "hide: state-" + this.ehy);
        }
        if (this.ehy == RecommendButtonState.SHOW) {
            this.ehy = RecommendButtonState.HIDE;
            this.ehx.hide();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void destroy() {
        bbq();
        com.baidu.swan.games.view.c.b(this);
    }

    private void bbq() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "destroy: state-" + this.ehy);
        }
        if (this.ehy != RecommendButtonState.DESTROYED) {
            this.ehy = RecommendButtonState.DESTROYED;
            if (this.ehx != null) {
                this.ehx.destroy();
            }
            this.egF = null;
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.d.a
    public void wo(String str) {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "onStyleChanged:" + str + "," + this.ehy + "," + this.style);
        }
        if (this.ehy == RecommendButtonState.SHOW) {
            this.ehx.update();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0557a
    @UiThread
    public void mL(int i) {
        if (this.egF != null && i >= 0 && i < this.egF.ehi.size()) {
            a(this.egF.ehi.get(i), ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME);
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0557a
    @UiThread
    public void bbj() {
        if (this.egF != null) {
            a(this.egF.ehh, "game_center");
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0557a
    @UiThread
    public void bbk() {
        this.eho.i(this.mSourceType, "list", c.egL);
    }

    private void fS(boolean z) {
        if (bbr()) {
            this.ehx.fS(z);
        }
    }

    private boolean r(JsObject jsObject) {
        this.ehy = RecommendButtonState.IDLE;
        this.style.a(this);
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e == null) {
            e = new com.baidu.swan.games.binding.model.c();
        }
        String optString = e.optString("type");
        if (g(e, "type")) {
            this.mSourceType = yC(optString);
        } else {
            this.mSourceType = 1;
        }
        if (this.mSourceType == 0) {
            yD("createRecommendationButton failed,parameter error: the 'type' is invalid.");
            return false;
        }
        if (g(e, "style")) {
            com.baidu.swan.games.binding.model.c xh = e.xh("style");
            if (xh == null) {
                yD("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            } else if (!n(xh)) {
                yD("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            }
        }
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "init: style-" + this.style);
        }
        this.ehx = new com.baidu.swan.games.view.recommend.proxy.a(this.mSourceType, this.style, this);
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
        int wZ = cVar != null ? cVar.wZ(str) : 12;
        return (wZ == 12 || wZ == 11) ? false : true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int yC(@Nullable String str) {
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
            SchemeRouter.invokeScheme(com.baidu.swan.games.view.c.bay(), Uri.parse(recommendItemModel.scheme), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            this.eho.i(this.mSourceType, str, recommendItemModel.appKey);
        }
    }

    private boolean bbr() {
        return this.ehy == RecommendButtonState.HIDE || this.ehy == RecommendButtonState.SHOW;
    }

    private void yD(String str) {
        this.dWl.throwJSException(JSExceptionType.Error, str);
        bbq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbs() {
        dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yE(String str) {
        com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
        bVar.errMsg = str;
        dispatchEvent(new JSEvent(BdStatsConstant.StatsType.ERROR, bVar));
    }

    @Override // com.baidu.swan.games.view.a
    public void aUi() {
        fS(true);
    }

    @Override // com.baidu.swan.games.view.a
    public void aUj() {
        fS(false);
    }

    @Override // com.baidu.swan.games.view.a
    public void onViewDestroy() {
        bbq();
    }

    /* loaded from: classes25.dex */
    private abstract class a extends StringResponseCallback {
        abstract void onFail(String str);

        abstract void onSuccess(String str);

        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(final String str, int i) {
            RecommendButtonApiProxy.this.dWl.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onSuccess(str);
                }
            });
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(final Exception exc) {
            RecommendButtonApiProxy.this.dWl.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onFail(exc.getMessage());
                }
            });
        }
    }
}
