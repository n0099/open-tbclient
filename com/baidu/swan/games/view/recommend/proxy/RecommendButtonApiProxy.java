package com.baidu.swan.games.view.recommend.proxy;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
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
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.b;
import com.baidu.swan.games.view.recommend.a.a;
import com.baidu.swan.games.view.recommend.a.c;
import com.baidu.swan.games.view.recommend.a.d;
import com.baidu.swan.games.view.recommend.a.e;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
import java.util.Locale;
/* loaded from: classes9.dex */
public class RecommendButtonApiProxy extends EventTargetImpl implements com.baidu.swan.games.view.a, com.baidu.swan.games.view.recommend.a, a.InterfaceC0530a, d.a {
    private static final boolean DEBUG = b.DEBUG;
    private com.baidu.swan.games.f.b ecD;
    private com.baidu.swan.games.view.recommend.model.a emY;
    private c enK;
    private com.baidu.swan.games.view.recommend.a.b enT;
    private int enU;
    private RecommendButtonState enV;
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

    public RecommendButtonApiProxy(com.baidu.swan.games.f.b bVar, JsObject jsObject) {
        super(bVar);
        this.enK = new c();
        this.style = new d();
        this.ecD = bVar;
        if (r(jsObject)) {
            com.baidu.swan.games.view.c.a(this);
        }
    }

    @JavascriptInterface
    public void load() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "load: state-" + this.enV);
        }
        if (this.enV == RecommendButtonState.IDLE) {
            this.enV = RecommendButtonState.LOADING;
            e.a(this.enU, new a() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.1
                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onSuccess(String str) {
                    com.baidu.swan.games.view.recommend.model.c xI = com.baidu.swan.games.view.recommend.model.b.xI(str);
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onSuccess-" + xI.isSuccess());
                    }
                    if (RecommendButtonApiProxy.this.enV != RecommendButtonState.DESTROYED) {
                        if (xI.isSuccess()) {
                            RecommendButtonApiProxy.this.enV = RecommendButtonState.HIDE;
                            RecommendButtonApiProxy.this.emY = com.baidu.swan.games.view.recommend.model.b.cH(xI.data);
                            RecommendButtonApiProxy.this.enT.a(RecommendButtonApiProxy.this.emY);
                            RecommendButtonApiProxy.this.bae();
                            return;
                        }
                        RecommendButtonApiProxy.this.enV = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.xL(String.format("RecommendationButton.load failed,%s", xI.errMsg));
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onFail(String str) {
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onFail-" + str);
                    }
                    if (RecommendButtonApiProxy.this.enV != RecommendButtonState.DESTROYED) {
                        RecommendButtonApiProxy.this.enV = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.xL(String.format("RecommendationButton.load failed,%s", str));
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void show() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "show: state-" + this.enV);
        }
        if (this.enV == RecommendButtonState.HIDE) {
            this.enV = RecommendButtonState.SHOW;
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.2
                @Override // java.lang.Runnable
                public void run() {
                    RecommendButtonApiProxy.this.enK.a(RecommendButtonApiProxy.this.enU, RecommendButtonApiProxy.this.emY);
                }
            });
            this.enT.show();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void hide() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "hide: state-" + this.enV);
        }
        if (this.enV == RecommendButtonState.SHOW) {
            this.enV = RecommendButtonState.HIDE;
            this.enT.hide();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void destroy() {
        bac();
        com.baidu.swan.games.view.c.b(this);
    }

    private void bac() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "destroy: state-" + this.enV);
        }
        if (this.enV != RecommendButtonState.DESTROYED) {
            this.enV = RecommendButtonState.DESTROYED;
            if (this.enT != null) {
                this.enT.destroy();
            }
            this.emY = null;
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.d.a
    public void vv(String str) {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "onStyleChanged:" + str + "," + this.enV + "," + this.style);
        }
        if (this.enV == RecommendButtonState.SHOW) {
            this.enT.update();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0530a
    @UiThread
    public void lq(int i) {
        if (this.emY != null && i >= 0 && i < this.emY.enE.size()) {
            a(this.emY.enE.get(i), ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME);
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0530a
    @UiThread
    public void aZV() {
        if (this.emY != null) {
            a(this.emY.enD, "game_center");
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0530a
    @UiThread
    public void aZW() {
        this.enK.i(this.enU, "list", c.eng);
    }

    private void fZ(boolean z) {
        if (bad()) {
            this.enT.fZ(z);
        }
    }

    private boolean r(JsObject jsObject) {
        this.enV = RecommendButtonState.IDLE;
        this.style.a(this);
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e == null) {
            e = new com.baidu.swan.games.binding.model.c();
        }
        String optString = e.optString("type");
        if (g(e, "type")) {
            this.enU = xJ(optString);
        } else {
            this.enU = 1;
        }
        if (this.enU == 0) {
            xK("createRecommendationButton failed,parameter error: the 'type' is invalid.");
            return false;
        }
        if (g(e, "style")) {
            com.baidu.swan.games.binding.model.c wo = e.wo("style");
            if (wo == null) {
                xK("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            } else if (!n(wo)) {
                xK("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            }
        }
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "init: style-" + this.style);
        }
        this.enT = new com.baidu.swan.games.view.recommend.proxy.a(this.enU, this.style, this);
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
        int wg = cVar != null ? cVar.wg(str) : 12;
        return (wg == 12 || wg == 11) ? false : true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int xJ(@Nullable String str) {
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
            e.aG(this.enU, recommendItemModel.appKey);
            SchemeRouter.invokeScheme(com.baidu.swan.games.view.c.getViewContext(), Uri.parse(recommendItemModel.scheme), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            this.enK.i(this.enU, str, recommendItemModel.appKey);
        }
    }

    private boolean bad() {
        return this.enV == RecommendButtonState.HIDE || this.enV == RecommendButtonState.SHOW;
    }

    private void xK(String str) {
        this.ecD.throwJSException(JSExceptionType.Error, str);
        bac();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bae() {
        dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xL(String str) {
        com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
        bVar.errMsg = str;
        dispatchEvent(new JSEvent(BdStatsConstant.StatsType.ERROR, bVar));
    }

    @Override // com.baidu.swan.games.view.a
    public void aSV() {
        fZ(true);
    }

    @Override // com.baidu.swan.games.view.a
    public void aSW() {
        fZ(false);
    }

    @Override // com.baidu.swan.games.view.a
    public void aSX() {
        bac();
    }

    /* loaded from: classes9.dex */
    private abstract class a extends StringResponseCallback {
        abstract void onFail(String str);

        abstract void onSuccess(String str);

        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: U */
        public void onSuccess(final String str, int i) {
            RecommendButtonApiProxy.this.ecD.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onSuccess(str);
                }
            });
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(final Exception exc) {
            RecommendButtonApiProxy.this.ecD.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onFail(exc.getMessage());
                }
            });
        }
    }
}
