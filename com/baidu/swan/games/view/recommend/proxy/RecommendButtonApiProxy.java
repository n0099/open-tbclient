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
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.d.h;
import com.baidu.swan.games.view.recommend.a.a;
import com.baidu.swan.games.view.recommend.a.c;
import com.baidu.swan.games.view.recommend.a.d;
import com.baidu.swan.games.view.recommend.a.e;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes2.dex */
public class RecommendButtonApiProxy extends EventTargetImpl implements com.baidu.swan.games.view.recommend.a, a.InterfaceC0261a, d.a {
    private static final boolean DEBUG = b.DEBUG;
    private com.baidu.swan.games.view.recommend.d.b bEV;
    private com.baidu.swan.games.view.recommend.a.b bFA;
    private c bFB;
    private int bFC;
    private RecommendButtonState bFD;
    private com.baidu.swan.games.e.b bxv;
    @V8JavascriptField
    public final d style;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum RecommendButtonState {
        IDLE,
        LOADING,
        HIDE,
        SHOW,
        DESTROYED
    }

    public RecommendButtonApiProxy(com.baidu.swan.games.e.b bVar, JsObject jsObject) {
        super(bVar);
        com.baidu.swan.games.view.recommend.b FO;
        this.bFB = new c();
        this.style = new d();
        this.bxv = bVar;
        if (p(jsObject) && (FO = FO()) != null) {
            FO.a(this);
        }
    }

    @JavascriptInterface
    public void load() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "load: state-" + this.bFD);
        }
        if (this.bFD == RecommendButtonState.IDLE) {
            this.bFD = RecommendButtonState.LOADING;
            e.a(this.bFC, new a() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.1
                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onSuccess(String str) {
                    com.baidu.swan.games.view.recommend.d.d kJ = com.baidu.swan.games.view.recommend.d.c.kJ(str);
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onSuccess-" + kJ.isSuccess());
                    }
                    if (RecommendButtonApiProxy.this.bFD != RecommendButtonState.DESTROYED) {
                        if (kJ.isSuccess()) {
                            RecommendButtonApiProxy.this.bFD = RecommendButtonState.HIDE;
                            RecommendButtonApiProxy.this.bEV = com.baidu.swan.games.view.recommend.d.c.aY(kJ.data);
                            RecommendButtonApiProxy.this.bFA.a(RecommendButtonApiProxy.this.bEV);
                            RecommendButtonApiProxy.this.Zf();
                            return;
                        }
                        RecommendButtonApiProxy.this.bFD = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.kM(String.format("RecommendationButton.load failed,%s", kJ.errMsg));
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onFail(String str) {
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onFail-" + str);
                    }
                    if (RecommendButtonApiProxy.this.bFD != RecommendButtonState.DESTROYED) {
                        RecommendButtonApiProxy.this.bFD = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.kM(String.format("RecommendationButton.load failed,%s", str));
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void show() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "show: state-" + this.bFD);
        }
        if (Ze()) {
            this.bFD = RecommendButtonState.SHOW;
            ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.2
                @Override // java.lang.Runnable
                public void run() {
                    RecommendButtonApiProxy.this.bFB.a(RecommendButtonApiProxy.this.bFC, RecommendButtonApiProxy.this.bEV);
                }
            });
            this.bFA.show();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void hide() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "hide: state-" + this.bFD);
        }
        if (Ze()) {
            this.bFD = RecommendButtonState.HIDE;
            this.bFA.hide();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void destroy() {
        Zd();
        com.baidu.swan.games.view.recommend.b FO = FO();
        if (FO != null) {
            FO.b(this);
        }
    }

    public void Zd() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "destroy: state-" + this.bFD);
        }
        if (this.bFD != RecommendButtonState.DESTROYED) {
            this.bFD = RecommendButtonState.DESTROYED;
            if (this.bFA != null) {
                this.bFA.destroy();
            }
            this.bEV = null;
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.d.a
    public void jp(String str) {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "onStyleChanged:" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + this.bFD + Constants.ACCEPT_TIME_SEPARATOR_SP + this.style);
        }
        if (this.bFD == RecommendButtonState.SHOW) {
            this.bFA.update();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0261a
    @UiThread
    public void gh(int i) {
        if (this.bEV != null && i >= 0 && i < this.bEV.bFz.size()) {
            a(this.bEV.bFz.get(i), ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME);
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0261a
    @UiThread
    public void YW() {
        if (this.bEV != null) {
            a(this.bEV.bFy, "game_center");
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0261a
    @UiThread
    public void YX() {
        this.bFB.g(this.bFC, "list", c.bFc);
    }

    public void bQ(boolean z) {
        if (Ze()) {
            this.bFA.bQ(z);
        }
    }

    private com.baidu.swan.games.view.recommend.b FO() {
        com.baidu.swan.apps.core.d.e AI;
        SwanAppActivity Lq = com.baidu.swan.apps.w.e.LE().Lq();
        if (Lq == null || (AI = Lq.AI()) == null) {
            return null;
        }
        h hVar = (h) AI.i(h.class);
        if (hVar != null) {
            return hVar.FO();
        }
        return null;
    }

    private boolean p(JsObject jsObject) {
        this.bFD = RecommendButtonState.IDLE;
        this.style.a(this);
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (c == null) {
            c = new com.baidu.swan.games.binding.model.c();
        }
        String optString = c.optString("type");
        if (c(c, "type")) {
            this.bFC = kK(optString);
        } else {
            this.bFC = 1;
        }
        if (this.bFC == 0) {
            kL("createRecommendationButton failed,parameter error: the 'type' is invalid.");
            return false;
        }
        if (c(c, "style")) {
            JsObject jE = c.jE("style");
            if (jE == null) {
                kL("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            } else if (!q(jE)) {
                kL("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            }
        }
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "init: style-" + this.style);
        }
        this.bFA = new com.baidu.swan.games.view.recommend.proxy.a(this.bFC, this.style, this);
        return true;
    }

    private boolean q(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (c == null) {
            return true;
        }
        try {
            if (c(c, "left")) {
                this.style.left = (float) c.getDouble("left");
            }
            if (c(c, VerticalTranslateLayout.TOP)) {
                this.style.top = (float) c.getDouble(VerticalTranslateLayout.TOP);
                return true;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean c(com.baidu.swan.games.binding.model.c cVar, String str) {
        int jy = cVar != null ? cVar.jy(str) : 12;
        return (jy == 12 || jy == 11) ? false : true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int kK(@Nullable String str) {
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
    private void a(com.baidu.swan.games.view.recommend.d.a aVar, String str) {
        if (aVar != null && !TextUtils.isEmpty(aVar.appKey) && !TextUtils.isEmpty(aVar.scheme)) {
            e.A(this.bFC, aVar.appKey);
            SchemeRouter.invokeScheme(com.baidu.swan.games.view.a.Yq(), Uri.parse(aVar.scheme), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            this.bFB.g(this.bFC, str, aVar.appKey);
        }
    }

    private boolean Ze() {
        return this.bFD == RecommendButtonState.HIDE || this.bFD == RecommendButtonState.SHOW;
    }

    private void kL(String str) {
        this.bxv.throwJSException(JSExceptionType.Error, str);
        Zd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zf() {
        dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kM(String str) {
        com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
        bVar.errMsg = str;
        dispatchEvent(new JSEvent(BdStatsConstant.StatsType.ERROR, bVar));
    }

    /* loaded from: classes2.dex */
    private abstract class a extends StringResponseCallback {
        abstract void onFail(String str);

        abstract void onSuccess(String str);

        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: x */
        public void onSuccess(final String str, int i) {
            RecommendButtonApiProxy.this.bxv.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onSuccess(str);
                }
            });
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(final Exception exc) {
            RecommendButtonApiProxy.this.bxv.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onFail(exc.getMessage());
                }
            });
        }
    }
}
