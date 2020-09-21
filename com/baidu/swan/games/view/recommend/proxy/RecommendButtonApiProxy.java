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
/* loaded from: classes3.dex */
public class RecommendButtonApiProxy extends EventTargetImpl implements com.baidu.swan.games.view.a, com.baidu.swan.games.view.recommend.a, a.InterfaceC0504a, d.a {
    private static final boolean DEBUG = b.DEBUG;
    private com.baidu.swan.games.view.recommend.model.a dAX;
    private c dBG;
    private com.baidu.swan.games.view.recommend.a.b dBP;
    private RecommendButtonState dBQ;
    private com.baidu.swan.games.f.b dqC;
    private int mSourceType;
    @V8JavascriptField
    public final d style;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum RecommendButtonState {
        IDLE,
        LOADING,
        HIDE,
        SHOW,
        DESTROYED
    }

    public RecommendButtonApiProxy(com.baidu.swan.games.f.b bVar, JsObject jsObject) {
        super(bVar);
        this.dBG = new c();
        this.style = new d();
        this.dqC = bVar;
        if (r(jsObject)) {
            com.baidu.swan.games.view.c.a(this);
        }
    }

    @JavascriptInterface
    public void load() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "load: state-" + this.dBQ);
        }
        if (this.dBQ == RecommendButtonState.IDLE) {
            this.dBQ = RecommendButtonState.LOADING;
            e.a(this.mSourceType, new a() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.1
                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onSuccess(String str) {
                    com.baidu.swan.games.view.recommend.model.c wG = com.baidu.swan.games.view.recommend.model.b.wG(str);
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onSuccess-" + wG.isSuccess());
                    }
                    if (RecommendButtonApiProxy.this.dBQ != RecommendButtonState.DESTROYED) {
                        if (wG.isSuccess()) {
                            RecommendButtonApiProxy.this.dBQ = RecommendButtonState.HIDE;
                            RecommendButtonApiProxy.this.dAX = com.baidu.swan.games.view.recommend.model.b.cq(wG.data);
                            RecommendButtonApiProxy.this.dBP.a(RecommendButtonApiProxy.this.dAX);
                            RecommendButtonApiProxy.this.aRR();
                            return;
                        }
                        RecommendButtonApiProxy.this.dBQ = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.wJ(String.format("RecommendationButton.load failed,%s", wG.errMsg));
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onFail(String str) {
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onFail-" + str);
                    }
                    if (RecommendButtonApiProxy.this.dBQ != RecommendButtonState.DESTROYED) {
                        RecommendButtonApiProxy.this.dBQ = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.wJ(String.format("RecommendationButton.load failed,%s", str));
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void show() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "show: state-" + this.dBQ);
        }
        if (this.dBQ == RecommendButtonState.HIDE) {
            this.dBQ = RecommendButtonState.SHOW;
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.2
                @Override // java.lang.Runnable
                public void run() {
                    RecommendButtonApiProxy.this.dBG.a(RecommendButtonApiProxy.this.mSourceType, RecommendButtonApiProxy.this.dAX);
                }
            });
            this.dBP.show();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void hide() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "hide: state-" + this.dBQ);
        }
        if (this.dBQ == RecommendButtonState.SHOW) {
            this.dBQ = RecommendButtonState.HIDE;
            this.dBP.hide();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void destroy() {
        aRP();
        com.baidu.swan.games.view.c.b(this);
    }

    private void aRP() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "destroy: state-" + this.dBQ);
        }
        if (this.dBQ != RecommendButtonState.DESTROYED) {
            this.dBQ = RecommendButtonState.DESTROYED;
            if (this.dBP != null) {
                this.dBP.destroy();
            }
            this.dAX = null;
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.d.a
    public void ut(String str) {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "onStyleChanged:" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + this.dBQ + Constants.ACCEPT_TIME_SEPARATOR_SP + this.style);
        }
        if (this.dBQ == RecommendButtonState.SHOW) {
            this.dBP.update();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0504a
    @UiThread
    public void lz(int i) {
        if (this.dAX != null && i >= 0 && i < this.dAX.dBA.size()) {
            a(this.dAX.dBA.get(i), ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME);
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0504a
    @UiThread
    public void aRI() {
        if (this.dAX != null) {
            a(this.dAX.dBz, "game_center");
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0504a
    @UiThread
    public void aRJ() {
        this.dBG.f(this.mSourceType, "list", c.dBd);
    }

    private void eI(boolean z) {
        if (aRQ()) {
            this.dBP.eI(z);
        }
    }

    private boolean r(JsObject jsObject) {
        this.dBQ = RecommendButtonState.IDLE;
        this.style.a(this);
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e == null) {
            e = new com.baidu.swan.games.binding.model.c();
        }
        String optString = e.optString("type");
        if (g(e, "type")) {
            this.mSourceType = wH(optString);
        } else {
            this.mSourceType = 1;
        }
        if (this.mSourceType == 0) {
            wI("createRecommendationButton failed,parameter error: the 'type' is invalid.");
            return false;
        }
        if (g(e, "style")) {
            com.baidu.swan.games.binding.model.c vm = e.vm("style");
            if (vm == null) {
                wI("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            } else if (!n(vm)) {
                wI("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            }
        }
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "init: style-" + this.style);
        }
        this.dBP = new com.baidu.swan.games.view.recommend.proxy.a(this.mSourceType, this.style, this);
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
        int ve = cVar != null ? cVar.ve(str) : 12;
        return (ve == 12 || ve == 11) ? false : true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int wH(@Nullable String str) {
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
            SchemeRouter.invokeScheme(com.baidu.swan.games.view.c.aQY(), Uri.parse(recommendItemModel.scheme), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            this.dBG.f(this.mSourceType, str, recommendItemModel.appKey);
        }
    }

    private boolean aRQ() {
        return this.dBQ == RecommendButtonState.HIDE || this.dBQ == RecommendButtonState.SHOW;
    }

    private void wI(String str) {
        this.dqC.throwJSException(JSExceptionType.Error, str);
        aRP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRR() {
        dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wJ(String str) {
        com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
        bVar.errMsg = str;
        dispatchEvent(new JSEvent(BdStatsConstant.StatsType.ERROR, bVar));
    }

    @Override // com.baidu.swan.games.view.a
    public void aKI() {
        eI(true);
    }

    @Override // com.baidu.swan.games.view.a
    public void aKJ() {
        eI(false);
    }

    @Override // com.baidu.swan.games.view.a
    public void onViewDestroy() {
        aRP();
    }

    /* loaded from: classes3.dex */
    private abstract class a extends StringResponseCallback {
        abstract void onFail(String str);

        abstract void onSuccess(String str);

        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(final String str, int i) {
            RecommendButtonApiProxy.this.dqC.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onSuccess(str);
                }
            });
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(final Exception exc) {
            RecommendButtonApiProxy.this.dqC.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onFail(exc.getMessage());
                }
            });
        }
    }
}
