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
/* loaded from: classes8.dex */
public class RecommendButtonApiProxy extends EventTargetImpl implements com.baidu.swan.games.view.a, com.baidu.swan.games.view.recommend.a, a.InterfaceC0509a, d.a {
    private static final boolean DEBUG = b.DEBUG;
    private com.baidu.swan.games.f.b dox;
    private com.baidu.swan.games.view.recommend.model.a dyS;
    private c dzB;
    private com.baidu.swan.games.view.recommend.a.b dzK;
    private RecommendButtonState dzL;
    private int mSourceType;
    @V8JavascriptField
    public final d style;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public enum RecommendButtonState {
        IDLE,
        LOADING,
        HIDE,
        SHOW,
        DESTROYED
    }

    public RecommendButtonApiProxy(com.baidu.swan.games.f.b bVar, JsObject jsObject) {
        super(bVar);
        this.dzB = new c();
        this.style = new d();
        this.dox = bVar;
        if (r(jsObject)) {
            com.baidu.swan.games.view.c.a(this);
        }
    }

    @JavascriptInterface
    public void load() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "load: state-" + this.dzL);
        }
        if (this.dzL == RecommendButtonState.IDLE) {
            this.dzL = RecommendButtonState.LOADING;
            e.a(this.mSourceType, new a() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.1
                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onSuccess(String str) {
                    com.baidu.swan.games.view.recommend.model.c wm = com.baidu.swan.games.view.recommend.model.b.wm(str);
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onSuccess-" + wm.isSuccess());
                    }
                    if (RecommendButtonApiProxy.this.dzL != RecommendButtonState.DESTROYED) {
                        if (wm.isSuccess()) {
                            RecommendButtonApiProxy.this.dzL = RecommendButtonState.HIDE;
                            RecommendButtonApiProxy.this.dyS = com.baidu.swan.games.view.recommend.model.b.cn(wm.data);
                            RecommendButtonApiProxy.this.dzK.a(RecommendButtonApiProxy.this.dyS);
                            RecommendButtonApiProxy.this.aRf();
                            return;
                        }
                        RecommendButtonApiProxy.this.dzL = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.wp(String.format("RecommendationButton.load failed,%s", wm.errMsg));
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onFail(String str) {
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onFail-" + str);
                    }
                    if (RecommendButtonApiProxy.this.dzL != RecommendButtonState.DESTROYED) {
                        RecommendButtonApiProxy.this.dzL = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.wp(String.format("RecommendationButton.load failed,%s", str));
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void show() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "show: state-" + this.dzL);
        }
        if (this.dzL == RecommendButtonState.HIDE) {
            this.dzL = RecommendButtonState.SHOW;
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.2
                @Override // java.lang.Runnable
                public void run() {
                    RecommendButtonApiProxy.this.dzB.a(RecommendButtonApiProxy.this.mSourceType, RecommendButtonApiProxy.this.dyS);
                }
            });
            this.dzK.show();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void hide() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "hide: state-" + this.dzL);
        }
        if (this.dzL == RecommendButtonState.SHOW) {
            this.dzL = RecommendButtonState.HIDE;
            this.dzK.hide();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void destroy() {
        aRd();
        com.baidu.swan.games.view.c.b(this);
    }

    private void aRd() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "destroy: state-" + this.dzL);
        }
        if (this.dzL != RecommendButtonState.DESTROYED) {
            this.dzL = RecommendButtonState.DESTROYED;
            if (this.dzK != null) {
                this.dzK.destroy();
            }
            this.dyS = null;
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.d.a
    public void tZ(String str) {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "onStyleChanged:" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + this.dzL + Constants.ACCEPT_TIME_SEPARATOR_SP + this.style);
        }
        if (this.dzL == RecommendButtonState.SHOW) {
            this.dzK.update();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0509a
    @UiThread
    public void lo(int i) {
        if (this.dyS != null && i >= 0 && i < this.dyS.dzv.size()) {
            a(this.dyS.dzv.get(i), ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME);
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0509a
    @UiThread
    public void aQW() {
        if (this.dyS != null) {
            a(this.dyS.dzu, "game_center");
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0509a
    @UiThread
    public void aQX() {
        this.dzB.f(this.mSourceType, "list", c.dyY);
    }

    private void eJ(boolean z) {
        if (aRe()) {
            this.dzK.eJ(z);
        }
    }

    private boolean r(JsObject jsObject) {
        this.dzL = RecommendButtonState.IDLE;
        this.style.a(this);
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e == null) {
            e = new com.baidu.swan.games.binding.model.c();
        }
        String optString = e.optString("type");
        if (g(e, "type")) {
            this.mSourceType = wn(optString);
        } else {
            this.mSourceType = 1;
        }
        if (this.mSourceType == 0) {
            wo("createRecommendationButton failed,parameter error: the 'type' is invalid.");
            return false;
        }
        if (g(e, "style")) {
            com.baidu.swan.games.binding.model.c uS = e.uS("style");
            if (uS == null) {
                wo("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            } else if (!n(uS)) {
                wo("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            }
        }
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "init: style-" + this.style);
        }
        this.dzK = new com.baidu.swan.games.view.recommend.proxy.a(this.mSourceType, this.style, this);
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
        int uK = cVar != null ? cVar.uK(str) : 12;
        return (uK == 12 || uK == 11) ? false : true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int wn(@Nullable String str) {
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
            e.ah(this.mSourceType, recommendItemModel.appKey);
            SchemeRouter.invokeScheme(com.baidu.swan.games.view.c.aQm(), Uri.parse(recommendItemModel.scheme), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            this.dzB.f(this.mSourceType, str, recommendItemModel.appKey);
        }
    }

    private boolean aRe() {
        return this.dzL == RecommendButtonState.HIDE || this.dzL == RecommendButtonState.SHOW;
    }

    private void wo(String str) {
        this.dox.throwJSException(JSExceptionType.Error, str);
        aRd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRf() {
        dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wp(String str) {
        com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
        bVar.errMsg = str;
        dispatchEvent(new JSEvent(BdStatsConstant.StatsType.ERROR, bVar));
    }

    @Override // com.baidu.swan.games.view.a
    public void aJX() {
        eJ(true);
    }

    @Override // com.baidu.swan.games.view.a
    public void aJY() {
        eJ(false);
    }

    @Override // com.baidu.swan.games.view.a
    public void onViewDestroy() {
        aRd();
    }

    /* loaded from: classes8.dex */
    private abstract class a extends StringResponseCallback {
        abstract void onFail(String str);

        abstract void onSuccess(String str);

        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(final String str, int i) {
            RecommendButtonApiProxy.this.dox.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onSuccess(str);
                }
            });
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(final Exception exc) {
            RecommendButtonApiProxy.this.dox.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onFail(exc.getMessage());
                }
            });
        }
    }
}
