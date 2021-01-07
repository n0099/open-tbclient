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
public class RecommendButtonApiProxy extends EventTargetImpl implements com.baidu.swan.games.view.a, com.baidu.swan.games.view.recommend.a, a.InterfaceC0550a, d.a {
    private static final boolean DEBUG = b.DEBUG;
    private com.baidu.swan.games.f.b efi;
    private com.baidu.swan.games.view.recommend.model.a epG;
    private int eqA;
    private RecommendButtonState eqB;
    private c eqq;
    private com.baidu.swan.games.view.recommend.a.b eqz;
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
        this.eqq = new c();
        this.style = new d();
        this.efi = bVar;
        if (r(jsObject)) {
            com.baidu.swan.games.view.c.a(this);
        }
    }

    @JavascriptInterface
    public void load() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "load: state-" + this.eqB);
        }
        if (this.eqB == RecommendButtonState.IDLE) {
            this.eqB = RecommendButtonState.LOADING;
            e.a(this.eqA, new a() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.1
                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onSuccess(String str) {
                    com.baidu.swan.games.view.recommend.model.c yA = com.baidu.swan.games.view.recommend.model.b.yA(str);
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onSuccess-" + yA.isSuccess());
                    }
                    if (RecommendButtonApiProxy.this.eqB != RecommendButtonState.DESTROYED) {
                        if (yA.isSuccess()) {
                            RecommendButtonApiProxy.this.eqB = RecommendButtonState.HIDE;
                            RecommendButtonApiProxy.this.epG = com.baidu.swan.games.view.recommend.model.b.cK(yA.data);
                            RecommendButtonApiProxy.this.eqz.a(RecommendButtonApiProxy.this.epG);
                            RecommendButtonApiProxy.this.bdL();
                            return;
                        }
                        RecommendButtonApiProxy.this.eqB = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.yD(String.format("RecommendationButton.load failed,%s", yA.errMsg));
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onFail(String str) {
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onFail-" + str);
                    }
                    if (RecommendButtonApiProxy.this.eqB != RecommendButtonState.DESTROYED) {
                        RecommendButtonApiProxy.this.eqB = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.yD(String.format("RecommendationButton.load failed,%s", str));
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void show() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "show: state-" + this.eqB);
        }
        if (this.eqB == RecommendButtonState.HIDE) {
            this.eqB = RecommendButtonState.SHOW;
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.2
                @Override // java.lang.Runnable
                public void run() {
                    RecommendButtonApiProxy.this.eqq.a(RecommendButtonApiProxy.this.eqA, RecommendButtonApiProxy.this.epG);
                }
            });
            this.eqz.show();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void hide() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "hide: state-" + this.eqB);
        }
        if (this.eqB == RecommendButtonState.SHOW) {
            this.eqB = RecommendButtonState.HIDE;
            this.eqz.hide();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void destroy() {
        bdJ();
        com.baidu.swan.games.view.c.b(this);
    }

    private void bdJ() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "destroy: state-" + this.eqB);
        }
        if (this.eqB != RecommendButtonState.DESTROYED) {
            this.eqB = RecommendButtonState.DESTROYED;
            if (this.eqz != null) {
                this.eqz.destroy();
            }
            this.epG = null;
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.d.a
    public void wn(String str) {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "onStyleChanged:" + str + "," + this.eqB + "," + this.style);
        }
        if (this.eqB == RecommendButtonState.SHOW) {
            this.eqz.update();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0550a
    @UiThread
    public void mT(int i) {
        if (this.epG != null && i >= 0 && i < this.epG.eqk.size()) {
            a(this.epG.eqk.get(i), ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME);
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0550a
    @UiThread
    public void bdC() {
        if (this.epG != null) {
            a(this.epG.eqj, "game_center");
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0550a
    @UiThread
    public void bdD() {
        this.eqq.i(this.eqA, "list", c.epN);
    }

    private void gb(boolean z) {
        if (bdK()) {
            this.eqz.gb(z);
        }
    }

    private boolean r(JsObject jsObject) {
        this.eqB = RecommendButtonState.IDLE;
        this.style.a(this);
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e == null) {
            e = new com.baidu.swan.games.binding.model.c();
        }
        String optString = e.optString("type");
        if (g(e, "type")) {
            this.eqA = yB(optString);
        } else {
            this.eqA = 1;
        }
        if (this.eqA == 0) {
            yC("createRecommendationButton failed,parameter error: the 'type' is invalid.");
            return false;
        }
        if (g(e, "style")) {
            com.baidu.swan.games.binding.model.c xg = e.xg("style");
            if (xg == null) {
                yC("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            } else if (!n(xg)) {
                yC("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            }
        }
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "init: style-" + this.style);
        }
        this.eqz = new com.baidu.swan.games.view.recommend.proxy.a(this.eqA, this.style, this);
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
        int wY = cVar != null ? cVar.wY(str) : 12;
        return (wY == 12 || wY == 11) ? false : true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int yB(@Nullable String str) {
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
            e.aB(this.eqA, recommendItemModel.appKey);
            SchemeRouter.invokeScheme(com.baidu.swan.games.view.c.getViewContext(), Uri.parse(recommendItemModel.scheme), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            this.eqq.i(this.eqA, str, recommendItemModel.appKey);
        }
    }

    private boolean bdK() {
        return this.eqB == RecommendButtonState.HIDE || this.eqB == RecommendButtonState.SHOW;
    }

    private void yC(String str) {
        this.efi.throwJSException(JSExceptionType.Error, str);
        bdJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdL() {
        dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yD(String str) {
        com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
        bVar.errMsg = str;
        dispatchEvent(new JSEvent(BdStatsConstant.StatsType.ERROR, bVar));
    }

    @Override // com.baidu.swan.games.view.a
    public void aWD() {
        gb(true);
    }

    @Override // com.baidu.swan.games.view.a
    public void aWE() {
        gb(false);
    }

    @Override // com.baidu.swan.games.view.a
    public void aWF() {
        bdJ();
    }

    /* loaded from: classes9.dex */
    private abstract class a extends StringResponseCallback {
        abstract void onFail(String str);

        abstract void onSuccess(String str);

        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: S */
        public void onSuccess(final String str, int i) {
            RecommendButtonApiProxy.this.efi.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onSuccess(str);
                }
            });
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(final Exception exc) {
            RecommendButtonApiProxy.this.efi.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onFail(exc.getMessage());
                }
            });
        }
    }
}
