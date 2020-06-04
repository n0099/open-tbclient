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
public class RecommendButtonApiProxy extends EventTargetImpl implements com.baidu.swan.games.view.a, com.baidu.swan.games.view.recommend.a, a.InterfaceC0442a, d.a {
    private static final boolean DEBUG = b.DEBUG;
    private com.baidu.swan.games.f.b cTU;
    private c deS;
    private com.baidu.swan.games.view.recommend.model.a dei;
    private com.baidu.swan.games.view.recommend.a.b dfc;
    private RecommendButtonState dfd;
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
        this.deS = new c();
        this.style = new d();
        this.cTU = bVar;
        if (r(jsObject)) {
            com.baidu.swan.games.view.c.a(this);
        }
    }

    @JavascriptInterface
    public void load() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "load: state-" + this.dfd);
        }
        if (this.dfd == RecommendButtonState.IDLE) {
            this.dfd = RecommendButtonState.LOADING;
            e.a(this.mSourceType, new a() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.1
                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onSuccess(String str) {
                    com.baidu.swan.games.view.recommend.model.c sL = com.baidu.swan.games.view.recommend.model.b.sL(str);
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onSuccess-" + sL.isSuccess());
                    }
                    if (RecommendButtonApiProxy.this.dfd != RecommendButtonState.DESTROYED) {
                        if (sL.isSuccess()) {
                            RecommendButtonApiProxy.this.dfd = RecommendButtonState.HIDE;
                            RecommendButtonApiProxy.this.dei = com.baidu.swan.games.view.recommend.model.b.bU(sL.data);
                            RecommendButtonApiProxy.this.dfc.a(RecommendButtonApiProxy.this.dei);
                            RecommendButtonApiProxy.this.aDs();
                            return;
                        }
                        RecommendButtonApiProxy.this.dfd = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.sO(String.format("RecommendationButton.load failed,%s", sL.errMsg));
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onFail(String str) {
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onFail-" + str);
                    }
                    if (RecommendButtonApiProxy.this.dfd != RecommendButtonState.DESTROYED) {
                        RecommendButtonApiProxy.this.dfd = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.sO(String.format("RecommendationButton.load failed,%s", str));
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void show() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "show: state-" + this.dfd);
        }
        if (this.dfd == RecommendButtonState.HIDE) {
            this.dfd = RecommendButtonState.SHOW;
            aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.2
                @Override // java.lang.Runnable
                public void run() {
                    RecommendButtonApiProxy.this.deS.a(RecommendButtonApiProxy.this.mSourceType, RecommendButtonApiProxy.this.dei);
                }
            });
            this.dfc.show();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void hide() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "hide: state-" + this.dfd);
        }
        if (this.dfd == RecommendButtonState.SHOW) {
            this.dfd = RecommendButtonState.HIDE;
            this.dfc.hide();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void destroy() {
        aDq();
        com.baidu.swan.games.view.c.b(this);
    }

    private void aDq() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "destroy: state-" + this.dfd);
        }
        if (this.dfd != RecommendButtonState.DESTROYED) {
            this.dfd = RecommendButtonState.DESTROYED;
            if (this.dfc != null) {
                this.dfc.destroy();
            }
            this.dei = null;
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.d.a
    public void qE(String str) {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "onStyleChanged:" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + this.dfd + Constants.ACCEPT_TIME_SEPARATOR_SP + this.style);
        }
        if (this.dfd == RecommendButtonState.SHOW) {
            this.dfc.update();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0442a
    @UiThread
    public void iD(int i) {
        if (this.dei != null && i >= 0 && i < this.dei.deM.size()) {
            a(this.dei.deM.get(i), ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME);
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0442a
    @UiThread
    public void aDh() {
        if (this.dei != null) {
            a(this.dei.deL, "game_center");
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0442a
    @UiThread
    public void aDi() {
        this.deS.f(this.mSourceType, "list", c.deo);
    }

    private void eg(boolean z) {
        if (aDr()) {
            this.dfc.eg(z);
        }
    }

    private boolean r(JsObject jsObject) {
        this.dfd = RecommendButtonState.IDLE;
        this.style.a(this);
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e == null) {
            e = new com.baidu.swan.games.binding.model.c();
        }
        String optString = e.optString("type");
        if (g(e, "type")) {
            this.mSourceType = sM(optString);
        } else {
            this.mSourceType = 1;
        }
        if (this.mSourceType == 0) {
            sN("createRecommendationButton failed,parameter error: the 'type' is invalid.");
            return false;
        }
        if (g(e, "style")) {
            com.baidu.swan.games.binding.model.c ru = e.ru("style");
            if (ru == null) {
                sN("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            } else if (!n(ru)) {
                sN("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            }
        }
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "init: style-" + this.style);
        }
        this.dfc = new com.baidu.swan.games.view.recommend.proxy.a(this.mSourceType, this.style, this);
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
                this.style.f1008top = (float) cVar.getDouble(VerticalTranslateLayout.TOP);
                return true;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean g(com.baidu.swan.games.binding.model.c cVar, String str) {
        int rm = cVar != null ? cVar.rm(str) : 12;
        return (rm == 12 || rm == 11) ? false : true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int sM(@Nullable String str) {
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
            e.ag(this.mSourceType, recommendItemModel.appKey);
            SchemeRouter.invokeScheme(com.baidu.swan.games.view.c.aCy(), Uri.parse(recommendItemModel.scheme), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            this.deS.f(this.mSourceType, str, recommendItemModel.appKey);
        }
    }

    private boolean aDr() {
        return this.dfd == RecommendButtonState.HIDE || this.dfd == RecommendButtonState.SHOW;
    }

    private void sN(String str) {
        this.cTU.throwJSException(JSExceptionType.Error, str);
        aDq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDs() {
        dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sO(String str) {
        com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
        bVar.errMsg = str;
        dispatchEvent(new JSEvent(BdStatsConstant.StatsType.ERROR, bVar));
    }

    @Override // com.baidu.swan.games.view.a
    public void awL() {
        eg(true);
    }

    @Override // com.baidu.swan.games.view.a
    public void awM() {
        eg(false);
    }

    @Override // com.baidu.swan.games.view.a
    public void onViewDestroy() {
        aDq();
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
            RecommendButtonApiProxy.this.cTU.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onSuccess(str);
                }
            });
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(final Exception exc) {
            RecommendButtonApiProxy.this.cTU.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onFail(exc.getMessage());
                }
            });
        }
    }
}
