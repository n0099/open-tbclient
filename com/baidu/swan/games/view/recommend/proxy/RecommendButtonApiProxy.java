package com.baidu.swan.games.view.recommend.proxy;

import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
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
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes2.dex */
public class RecommendButtonApiProxy extends EventTargetImpl implements com.baidu.swan.games.view.recommend.a, a.InterfaceC0218a, d.a {
    private static final boolean DEBUG = b.DEBUG;
    private com.baidu.swan.games.e.b beh;
    private com.baidu.swan.games.view.recommend.d.b blO;
    private com.baidu.swan.games.view.recommend.a.b bmu;
    private c bmv;
    private int bmw;
    private RecommendButtonState bmx;
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
        com.baidu.swan.games.view.recommend.b Ah;
        this.bmv = new c();
        this.style = new d();
        this.beh = bVar;
        if (p(jsObject) && (Ah = Ah()) != null) {
            Ah.a(this);
        }
    }

    @JavascriptInterface
    public void load() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "load: state-" + this.bmx);
        }
        if (this.bmx == RecommendButtonState.IDLE) {
            this.bmx = RecommendButtonState.LOADING;
            e.a(this.bmw, new a() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.1
                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onSuccess(String str) {
                    com.baidu.swan.games.view.recommend.d.d jY = com.baidu.swan.games.view.recommend.d.c.jY(str);
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onSuccess-" + jY.isSuccess());
                    }
                    if (RecommendButtonApiProxy.this.bmx != RecommendButtonState.DESTROYED) {
                        if (jY.isSuccess()) {
                            RecommendButtonApiProxy.this.bmx = RecommendButtonState.HIDE;
                            RecommendButtonApiProxy.this.blO = com.baidu.swan.games.view.recommend.d.c.az(jY.data);
                            RecommendButtonApiProxy.this.bmu.a(RecommendButtonApiProxy.this.blO);
                            RecommendButtonApiProxy.this.Tw();
                            return;
                        }
                        RecommendButtonApiProxy.this.bmx = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.kb(String.format("RecommendationButton.load failed,%s", jY.errMsg));
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onFail(String str) {
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onFail-" + str);
                    }
                    if (RecommendButtonApiProxy.this.bmx != RecommendButtonState.DESTROYED) {
                        RecommendButtonApiProxy.this.bmx = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.kb(String.format("RecommendationButton.load failed,%s", str));
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void show() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "show: state-" + this.bmx);
        }
        if (Tv()) {
            this.bmx = RecommendButtonState.SHOW;
            ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.2
                @Override // java.lang.Runnable
                public void run() {
                    RecommendButtonApiProxy.this.bmv.a(RecommendButtonApiProxy.this.bmw, RecommendButtonApiProxy.this.blO);
                }
            });
            this.bmu.show();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void hide() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "hide: state-" + this.bmx);
        }
        if (Tv()) {
            this.bmx = RecommendButtonState.HIDE;
            this.bmu.hide();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void destroy() {
        Tu();
        com.baidu.swan.games.view.recommend.b Ah = Ah();
        if (Ah != null) {
            Ah.b(this);
        }
    }

    public void Tu() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "destroy: state-" + this.bmx);
        }
        if (this.bmx != RecommendButtonState.DESTROYED) {
            this.bmx = RecommendButtonState.DESTROYED;
            if (this.bmu != null) {
                this.bmu.destroy();
            }
            this.blO = null;
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.d.a
    public void iE(String str) {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "onStyleChanged:" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + this.bmx + Constants.ACCEPT_TIME_SEPARATOR_SP + this.style);
        }
        if (this.bmx == RecommendButtonState.SHOW) {
            this.bmu.update();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0218a
    @UiThread
    public void fi(int i) {
        if (this.blO != null && i >= 0 && i < this.blO.bmt.size()) {
            a(this.blO.bmt.get(i), "game");
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0218a
    @UiThread
    public void Tm() {
        if (this.blO != null) {
            a(this.blO.bms, "game_center");
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0218a
    @UiThread
    public void Tn() {
        this.bmv.f(this.bmw, IntentConfig.LIST, c.blV);
    }

    public void bv(boolean z) {
        if (Tv()) {
            this.bmu.bv(z);
        }
    }

    private com.baidu.swan.games.view.recommend.b Ah() {
        com.baidu.swan.apps.core.d.e vi;
        SwanAppActivity FH = com.baidu.swan.apps.w.e.FV().FH();
        if (FH == null || (vi = FH.vi()) == null) {
            return null;
        }
        h hVar = (h) vi.k(h.class);
        if (hVar != null) {
            return hVar.Ah();
        }
        return null;
    }

    private boolean p(JsObject jsObject) {
        this.bmx = RecommendButtonState.IDLE;
        this.style.a(this);
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (c == null) {
            c = new com.baidu.swan.games.binding.model.c();
        }
        String optString = c.optString("type");
        if (c(c, "type")) {
            this.bmw = jZ(optString);
        } else {
            this.bmw = 1;
        }
        if (this.bmw == 0) {
            ka("createRecommendationButton failed,parameter error: the 'type' is invalid.");
            return false;
        }
        if (c(c, UnitedSchemeConstants.UNITED_SCHEME_STYLE)) {
            JsObject iS = c.iS(UnitedSchemeConstants.UNITED_SCHEME_STYLE);
            if (iS == null) {
                ka("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            } else if (!q(iS)) {
                ka("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            }
        }
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "init: style-" + this.style);
        }
        this.bmu = new com.baidu.swan.games.view.recommend.proxy.a(this.bmw, this.style, this);
        return true;
    }

    private boolean q(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (c == null) {
            return true;
        }
        try {
            if (c(c, CustomDialogData.POS_LEFT)) {
                this.style.left = (float) c.getDouble(CustomDialogData.POS_LEFT);
            }
            if (c(c, "top")) {
                this.style.top = (float) c.getDouble("top");
                return true;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean c(com.baidu.swan.games.binding.model.c cVar, String str) {
        int iN = cVar != null ? cVar.iN(str) : 12;
        return (iN == 12 || iN == 11) ? false : true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int jZ(@Nullable String str) {
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
                if (lowerCase.equals(IntentConfig.LIST)) {
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
            e.x(this.bmw, aVar.appKey);
            SchemeRouter.invokeScheme(com.baidu.swan.games.view.a.SE(), Uri.parse(aVar.scheme), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            this.bmv.f(this.bmw, str, aVar.appKey);
        }
    }

    private boolean Tv() {
        return this.bmx == RecommendButtonState.HIDE || this.bmx == RecommendButtonState.SHOW;
    }

    private void ka(String str) {
        this.beh.throwJSException(JSExceptionType.Error, str);
        Tu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tw() {
        dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kb(String str) {
        com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
        bVar.errMsg = str;
        dispatchEvent(new JSEvent("error", bVar));
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
            RecommendButtonApiProxy.this.beh.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onSuccess(str);
                }
            });
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(final Exception exc) {
            RecommendButtonApiProxy.this.beh.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onFail(exc.getMessage());
                }
            });
        }
    }
}
