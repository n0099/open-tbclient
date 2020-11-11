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
public class RecommendButtonApiProxy extends EventTargetImpl implements com.baidu.swan.games.view.a, com.baidu.swan.games.view.recommend.a, a.InterfaceC0547a, d.a {
    private static final boolean DEBUG = b.DEBUG;
    private com.baidu.swan.games.f.b dQV;
    private c ebW;
    private com.baidu.swan.games.view.recommend.model.a ebn;
    private com.baidu.swan.games.view.recommend.a.b ecf;
    private RecommendButtonState ecg;
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
        this.ebW = new c();
        this.style = new d();
        this.dQV = bVar;
        if (r(jsObject)) {
            com.baidu.swan.games.view.c.a(this);
        }
    }

    @JavascriptInterface
    public void load() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "load: state-" + this.ecg);
        }
        if (this.ecg == RecommendButtonState.IDLE) {
            this.ecg = RecommendButtonState.LOADING;
            e.a(this.mSourceType, new a() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.1
                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onSuccess(String str) {
                    com.baidu.swan.games.view.recommend.model.c xZ = com.baidu.swan.games.view.recommend.model.b.xZ(str);
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onSuccess-" + xZ.isSuccess());
                    }
                    if (RecommendButtonApiProxy.this.ecg != RecommendButtonState.DESTROYED) {
                        if (xZ.isSuccess()) {
                            RecommendButtonApiProxy.this.ecg = RecommendButtonState.HIDE;
                            RecommendButtonApiProxy.this.ebn = com.baidu.swan.games.view.recommend.model.b.cG(xZ.data);
                            RecommendButtonApiProxy.this.ecf.a(RecommendButtonApiProxy.this.ebn);
                            RecommendButtonApiProxy.this.aYU();
                            return;
                        }
                        RecommendButtonApiProxy.this.ecg = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.yc(String.format("RecommendationButton.load failed,%s", xZ.errMsg));
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onFail(String str) {
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onFail-" + str);
                    }
                    if (RecommendButtonApiProxy.this.ecg != RecommendButtonState.DESTROYED) {
                        RecommendButtonApiProxy.this.ecg = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.yc(String.format("RecommendationButton.load failed,%s", str));
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void show() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "show: state-" + this.ecg);
        }
        if (this.ecg == RecommendButtonState.HIDE) {
            this.ecg = RecommendButtonState.SHOW;
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.2
                @Override // java.lang.Runnable
                public void run() {
                    RecommendButtonApiProxy.this.ebW.a(RecommendButtonApiProxy.this.mSourceType, RecommendButtonApiProxy.this.ebn);
                }
            });
            this.ecf.show();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void hide() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "hide: state-" + this.ecg);
        }
        if (this.ecg == RecommendButtonState.SHOW) {
            this.ecg = RecommendButtonState.HIDE;
            this.ecf.hide();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void destroy() {
        aYS();
        com.baidu.swan.games.view.c.b(this);
    }

    private void aYS() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "destroy: state-" + this.ecg);
        }
        if (this.ecg != RecommendButtonState.DESTROYED) {
            this.ecg = RecommendButtonState.DESTROYED;
            if (this.ecf != null) {
                this.ecf.destroy();
            }
            this.ebn = null;
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.d.a
    public void vM(String str) {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "onStyleChanged:" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + this.ecg + Constants.ACCEPT_TIME_SEPARATOR_SP + this.style);
        }
        if (this.ecg == RecommendButtonState.SHOW) {
            this.ecf.update();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0547a
    @UiThread
    public void mr(int i) {
        if (this.ebn != null && i >= 0 && i < this.ebn.ebQ.size()) {
            a(this.ebn.ebQ.get(i), ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME);
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0547a
    @UiThread
    public void aYL() {
        if (this.ebn != null) {
            a(this.ebn.ebP, "game_center");
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0547a
    @UiThread
    public void aYM() {
        this.ebW.g(this.mSourceType, "list", c.ebt);
    }

    private void fA(boolean z) {
        if (aYT()) {
            this.ecf.fA(z);
        }
    }

    private boolean r(JsObject jsObject) {
        this.ecg = RecommendButtonState.IDLE;
        this.style.a(this);
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e == null) {
            e = new com.baidu.swan.games.binding.model.c();
        }
        String optString = e.optString("type");
        if (g(e, "type")) {
            this.mSourceType = ya(optString);
        } else {
            this.mSourceType = 1;
        }
        if (this.mSourceType == 0) {
            yb("createRecommendationButton failed,parameter error: the 'type' is invalid.");
            return false;
        }
        if (g(e, "style")) {
            com.baidu.swan.games.binding.model.c wF = e.wF("style");
            if (wF == null) {
                yb("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            } else if (!n(wF)) {
                yb("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            }
        }
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "init: style-" + this.style);
        }
        this.ecf = new com.baidu.swan.games.view.recommend.proxy.a(this.mSourceType, this.style, this);
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
        int wx = cVar != null ? cVar.wx(str) : 12;
        return (wx == 12 || wx == 11) ? false : true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int ya(@Nullable String str) {
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
            SchemeRouter.invokeScheme(com.baidu.swan.games.view.c.aYb(), Uri.parse(recommendItemModel.scheme), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            this.ebW.g(this.mSourceType, str, recommendItemModel.appKey);
        }
    }

    private boolean aYT() {
        return this.ecg == RecommendButtonState.HIDE || this.ecg == RecommendButtonState.SHOW;
    }

    private void yb(String str) {
        this.dQV.throwJSException(JSExceptionType.Error, str);
        aYS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYU() {
        dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yc(String str) {
        com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
        bVar.errMsg = str;
        dispatchEvent(new JSEvent(BdStatsConstant.StatsType.ERROR, bVar));
    }

    @Override // com.baidu.swan.games.view.a
    public void aRL() {
        fA(true);
    }

    @Override // com.baidu.swan.games.view.a
    public void aRM() {
        fA(false);
    }

    @Override // com.baidu.swan.games.view.a
    public void onViewDestroy() {
        aYS();
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
            RecommendButtonApiProxy.this.dQV.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onSuccess(str);
                }
            });
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(final Exception exc) {
            RecommendButtonApiProxy.this.dQV.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onFail(exc.getMessage());
                }
            });
        }
    }
}
