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
/* loaded from: classes8.dex */
public class RecommendButtonApiProxy extends EventTargetImpl implements com.baidu.swan.games.view.a, com.baidu.swan.games.view.recommend.a, a.InterfaceC0533a, d.a {
    private static final boolean DEBUG = b.DEBUG;
    private com.baidu.swan.games.f.b eaw;
    private com.baidu.swan.games.view.recommend.model.a ekR;
    private c elB;
    private com.baidu.swan.games.view.recommend.a.b elK;
    private int elL;
    private RecommendButtonState elM;
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
        this.elB = new c();
        this.style = new d();
        this.eaw = bVar;
        if (r(jsObject)) {
            com.baidu.swan.games.view.c.a(this);
        }
    }

    @JavascriptInterface
    public void load() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "load: state-" + this.elM);
        }
        if (this.elM == RecommendButtonState.IDLE) {
            this.elM = RecommendButtonState.LOADING;
            e.a(this.elL, new a() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.1
                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onSuccess(String str) {
                    com.baidu.swan.games.view.recommend.model.c xp = com.baidu.swan.games.view.recommend.model.b.xp(str);
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onSuccess-" + xp.isSuccess());
                    }
                    if (RecommendButtonApiProxy.this.elM != RecommendButtonState.DESTROYED) {
                        if (xp.isSuccess()) {
                            RecommendButtonApiProxy.this.elM = RecommendButtonState.HIDE;
                            RecommendButtonApiProxy.this.ekR = com.baidu.swan.games.view.recommend.model.b.cK(xp.data);
                            RecommendButtonApiProxy.this.elK.a(RecommendButtonApiProxy.this.ekR);
                            RecommendButtonApiProxy.this.aZR();
                            return;
                        }
                        RecommendButtonApiProxy.this.elM = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.xs(String.format("RecommendationButton.load failed,%s", xp.errMsg));
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onFail(String str) {
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onFail-" + str);
                    }
                    if (RecommendButtonApiProxy.this.elM != RecommendButtonState.DESTROYED) {
                        RecommendButtonApiProxy.this.elM = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.xs(String.format("RecommendationButton.load failed,%s", str));
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void show() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "show: state-" + this.elM);
        }
        if (this.elM == RecommendButtonState.HIDE) {
            this.elM = RecommendButtonState.SHOW;
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.2
                @Override // java.lang.Runnable
                public void run() {
                    RecommendButtonApiProxy.this.elB.a(RecommendButtonApiProxy.this.elL, RecommendButtonApiProxy.this.ekR);
                }
            });
            this.elK.show();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void hide() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "hide: state-" + this.elM);
        }
        if (this.elM == RecommendButtonState.SHOW) {
            this.elM = RecommendButtonState.HIDE;
            this.elK.hide();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void destroy() {
        aZP();
        com.baidu.swan.games.view.c.b(this);
    }

    private void aZP() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "destroy: state-" + this.elM);
        }
        if (this.elM != RecommendButtonState.DESTROYED) {
            this.elM = RecommendButtonState.DESTROYED;
            if (this.elK != null) {
                this.elK.destroy();
            }
            this.ekR = null;
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.d.a
    public void vc(String str) {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "onStyleChanged:" + str + "," + this.elM + "," + this.style);
        }
        if (this.elM == RecommendButtonState.SHOW) {
            this.elK.update();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0533a
    @UiThread
    public void ln(int i) {
        if (this.ekR != null && i >= 0 && i < this.ekR.elv.size()) {
            a(this.ekR.elv.get(i), ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME);
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0533a
    @UiThread
    public void aZI() {
        if (this.ekR != null) {
            a(this.ekR.elu, "game_center");
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0533a
    @UiThread
    public void aZJ() {
        this.elB.i(this.elL, "list", c.ekY);
    }

    private void fX(boolean z) {
        if (aZQ()) {
            this.elK.fX(z);
        }
    }

    private boolean r(JsObject jsObject) {
        this.elM = RecommendButtonState.IDLE;
        this.style.a(this);
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e == null) {
            e = new com.baidu.swan.games.binding.model.c();
        }
        String optString = e.optString("type");
        if (g(e, "type")) {
            this.elL = xq(optString);
        } else {
            this.elL = 1;
        }
        if (this.elL == 0) {
            xr("createRecommendationButton failed,parameter error: the 'type' is invalid.");
            return false;
        }
        if (g(e, "style")) {
            com.baidu.swan.games.binding.model.c vV = e.vV("style");
            if (vV == null) {
                xr("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            } else if (!n(vV)) {
                xr("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            }
        }
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "init: style-" + this.style);
        }
        this.elK = new com.baidu.swan.games.view.recommend.proxy.a(this.elL, this.style, this);
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
        int vN = cVar != null ? cVar.vN(str) : 12;
        return (vN == 12 || vN == 11) ? false : true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int xq(@Nullable String str) {
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
            e.aC(this.elL, recommendItemModel.appKey);
            SchemeRouter.invokeScheme(com.baidu.swan.games.view.c.getViewContext(), Uri.parse(recommendItemModel.scheme), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            this.elB.i(this.elL, str, recommendItemModel.appKey);
        }
    }

    private boolean aZQ() {
        return this.elM == RecommendButtonState.HIDE || this.elM == RecommendButtonState.SHOW;
    }

    private void xr(String str) {
        this.eaw.throwJSException(JSExceptionType.Error, str);
        aZP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZR() {
        dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xs(String str) {
        com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
        bVar.errMsg = str;
        dispatchEvent(new JSEvent(BdStatsConstant.StatsType.ERROR, bVar));
    }

    @Override // com.baidu.swan.games.view.a
    public void aSJ() {
        fX(true);
    }

    @Override // com.baidu.swan.games.view.a
    public void aSK() {
        fX(false);
    }

    @Override // com.baidu.swan.games.view.a
    public void aSL() {
        aZP();
    }

    /* loaded from: classes8.dex */
    private abstract class a extends StringResponseCallback {
        abstract void onFail(String str);

        abstract void onSuccess(String str);

        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: S */
        public void onSuccess(final String str, int i) {
            RecommendButtonApiProxy.this.eaw.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onSuccess(str);
                }
            });
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(final Exception exc) {
            RecommendButtonApiProxy.this.eaw.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onFail(exc.getMessage());
                }
            });
        }
    }
}
