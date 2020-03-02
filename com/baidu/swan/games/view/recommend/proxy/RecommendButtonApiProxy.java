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
public class RecommendButtonApiProxy extends EventTargetImpl implements com.baidu.swan.games.view.a, com.baidu.swan.games.view.recommend.a, a.InterfaceC0350a, d.a {
    private static final boolean DEBUG = b.DEBUG;
    private com.baidu.swan.games.e.b cka;
    private com.baidu.swan.games.view.recommend.model.a ctR;
    private c cuC;
    private com.baidu.swan.games.view.recommend.a.b cuM;
    private RecommendButtonState cuN;
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
        this.cuC = new c();
        this.style = new d();
        this.cka = bVar;
        if (p(jsObject)) {
            com.baidu.swan.games.view.c.a(this);
        }
    }

    @JavascriptInterface
    public void load() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "load: state-" + this.cuN);
        }
        if (this.cuN == RecommendButtonState.IDLE) {
            this.cuN = RecommendButtonState.LOADING;
            e.a(this.mSourceType, new a() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.1
                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onSuccess(String str) {
                    com.baidu.swan.games.view.recommend.model.c pV = com.baidu.swan.games.view.recommend.model.b.pV(str);
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onSuccess-" + pV.isSuccess());
                    }
                    if (RecommendButtonApiProxy.this.cuN != RecommendButtonState.DESTROYED) {
                        if (pV.isSuccess()) {
                            RecommendButtonApiProxy.this.cuN = RecommendButtonState.HIDE;
                            RecommendButtonApiProxy.this.ctR = com.baidu.swan.games.view.recommend.model.b.bI(pV.data);
                            RecommendButtonApiProxy.this.cuM.a(RecommendButtonApiProxy.this.ctR);
                            RecommendButtonApiProxy.this.arm();
                            return;
                        }
                        RecommendButtonApiProxy.this.cuN = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.pY(String.format("RecommendationButton.load failed,%s", pV.errMsg));
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onFail(String str) {
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onFail-" + str);
                    }
                    if (RecommendButtonApiProxy.this.cuN != RecommendButtonState.DESTROYED) {
                        RecommendButtonApiProxy.this.cuN = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.pY(String.format("RecommendationButton.load failed,%s", str));
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void show() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "show: state-" + this.cuN);
        }
        if (this.cuN == RecommendButtonState.HIDE) {
            this.cuN = RecommendButtonState.SHOW;
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.2
                @Override // java.lang.Runnable
                public void run() {
                    RecommendButtonApiProxy.this.cuC.a(RecommendButtonApiProxy.this.mSourceType, RecommendButtonApiProxy.this.ctR);
                }
            });
            this.cuM.show();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void hide() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "hide: state-" + this.cuN);
        }
        if (this.cuN == RecommendButtonState.SHOW) {
            this.cuN = RecommendButtonState.HIDE;
            this.cuM.hide();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void destroy() {
        ark();
        com.baidu.swan.games.view.c.b(this);
    }

    private void ark() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "destroy: state-" + this.cuN);
        }
        if (this.cuN != RecommendButtonState.DESTROYED) {
            this.cuN = RecommendButtonState.DESTROYED;
            if (this.cuM != null) {
                this.cuM.destroy();
            }
            this.ctR = null;
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.d.a
    public void nS(String str) {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "onStyleChanged:" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + this.cuN + Constants.ACCEPT_TIME_SEPARATOR_SP + this.style);
        }
        if (this.cuN == RecommendButtonState.SHOW) {
            this.cuM.update();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0350a
    @UiThread
    public void id(int i) {
        if (this.ctR != null && i >= 0 && i < this.ctR.cuw.size()) {
            a(this.ctR.cuw.get(i), ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME);
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0350a
    @UiThread
    public void arb() {
        if (this.ctR != null) {
            a(this.ctR.cuv, "game_center");
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0350a
    @UiThread
    public void arc() {
        this.cuC.e(this.mSourceType, "list", c.ctX);
    }

    private void cS(boolean z) {
        if (arl()) {
            this.cuM.cS(z);
        }
    }

    private boolean p(JsObject jsObject) {
        this.cuN = RecommendButtonState.IDLE;
        this.style.a(this);
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (c == null) {
            c = new com.baidu.swan.games.binding.model.c();
        }
        String optString = c.optString("type");
        if (g(c, "type")) {
            this.mSourceType = pW(optString);
        } else {
            this.mSourceType = 1;
        }
        if (this.mSourceType == 0) {
            pX("createRecommendationButton failed,parameter error: the 'type' is invalid.");
            return false;
        }
        if (g(c, "style")) {
            com.baidu.swan.games.binding.model.c oG = c.oG("style");
            if (oG == null) {
                pX("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            } else if (!n(oG)) {
                pX("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            }
        }
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "init: style-" + this.style);
        }
        this.cuM = new com.baidu.swan.games.view.recommend.proxy.a(this.mSourceType, this.style, this);
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
                this.style.f1014top = (float) cVar.getDouble(VerticalTranslateLayout.TOP);
                return true;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean g(com.baidu.swan.games.binding.model.c cVar, String str) {
        int oy = cVar != null ? cVar.oy(str) : 12;
        return (oy == 12 || oy == 11) ? false : true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int pW(@Nullable String str) {
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
            e.L(this.mSourceType, recommendItemModel.appKey);
            SchemeRouter.invokeScheme(com.baidu.swan.games.view.c.aqr(), Uri.parse(recommendItemModel.scheme), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            this.cuC.e(this.mSourceType, str, recommendItemModel.appKey);
        }
    }

    private boolean arl() {
        return this.cuN == RecommendButtonState.HIDE || this.cuN == RecommendButtonState.SHOW;
    }

    private void pX(String str) {
        this.cka.throwJSException(JSExceptionType.Error, str);
        ark();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arm() {
        dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pY(String str) {
        com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
        bVar.errMsg = str;
        dispatchEvent(new JSEvent(BdStatsConstant.StatsType.ERROR, bVar));
    }

    @Override // com.baidu.swan.games.view.a
    public void akO() {
        cS(true);
    }

    @Override // com.baidu.swan.games.view.a
    public void akP() {
        cS(false);
    }

    @Override // com.baidu.swan.games.view.a
    public void onViewDestroy() {
        ark();
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
            RecommendButtonApiProxy.this.cka.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onSuccess(str);
                }
            });
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(final Exception exc) {
            RecommendButtonApiProxy.this.cka.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onFail(exc.getMessage());
                }
            });
        }
    }
}
