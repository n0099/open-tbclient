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
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.b;
import com.baidu.swan.games.view.recommend.a.a;
import com.baidu.swan.games.view.recommend.a.c;
import com.baidu.swan.games.view.recommend.a.d;
import com.baidu.swan.games.view.recommend.a.e;
import com.baidu.swan.games.view.recommend.model.RecommendItemModel;
import com.googlecode.mp4parser.boxes.apple.TrackLoadSettingsAtom;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;
/* loaded from: classes7.dex */
public class RecommendButtonApiProxy extends EventTargetImpl implements com.baidu.swan.games.view.a, com.baidu.swan.games.view.recommend.a, a.InterfaceC0461a, d.a {
    private static final boolean DEBUG = b.DEBUG;
    private com.baidu.swan.games.f.b deo;
    private com.baidu.swan.games.view.recommend.model.a doQ;
    private com.baidu.swan.games.view.recommend.a.b dpI;
    private RecommendButtonState dpJ;
    private c dpz;
    private int mSourceType;
    @V8JavascriptField
    public final d style;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public enum RecommendButtonState {
        IDLE,
        LOADING,
        HIDE,
        SHOW,
        DESTROYED
    }

    public RecommendButtonApiProxy(com.baidu.swan.games.f.b bVar, JsObject jsObject) {
        super(bVar);
        this.dpz = new c();
        this.style = new d();
        this.deo = bVar;
        if (r(jsObject)) {
            com.baidu.swan.games.view.c.a(this);
        }
    }

    @JavascriptInterface
    public void load() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "load: state-" + this.dpJ);
        }
        if (this.dpJ == RecommendButtonState.IDLE) {
            this.dpJ = RecommendButtonState.LOADING;
            e.a(this.mSourceType, new a() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.1
                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onSuccess(String str) {
                    com.baidu.swan.games.view.recommend.model.c tW = com.baidu.swan.games.view.recommend.model.b.tW(str);
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onSuccess-" + tW.isSuccess());
                    }
                    if (RecommendButtonApiProxy.this.dpJ != RecommendButtonState.DESTROYED) {
                        if (tW.isSuccess()) {
                            RecommendButtonApiProxy.this.dpJ = RecommendButtonState.HIDE;
                            RecommendButtonApiProxy.this.doQ = com.baidu.swan.games.view.recommend.model.b.ch(tW.data);
                            RecommendButtonApiProxy.this.dpI.a(RecommendButtonApiProxy.this.doQ);
                            RecommendButtonApiProxy.this.aIp();
                            return;
                        }
                        RecommendButtonApiProxy.this.dpJ = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.tZ(String.format("RecommendationButton.load failed,%s", tW.errMsg));
                    }
                }

                @Override // com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a
                void onFail(String str) {
                    if (RecommendButtonApiProxy.DEBUG) {
                        Log.d("RecommendButtonApiProxy", "load: onFail-" + str);
                    }
                    if (RecommendButtonApiProxy.this.dpJ != RecommendButtonState.DESTROYED) {
                        RecommendButtonApiProxy.this.dpJ = RecommendButtonState.IDLE;
                        RecommendButtonApiProxy.this.tZ(String.format("RecommendationButton.load failed,%s", str));
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void show() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "show: state-" + this.dpJ);
        }
        if (this.dpJ == RecommendButtonState.HIDE) {
            this.dpJ = RecommendButtonState.SHOW;
            al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.2
                @Override // java.lang.Runnable
                public void run() {
                    RecommendButtonApiProxy.this.dpz.a(RecommendButtonApiProxy.this.mSourceType, RecommendButtonApiProxy.this.doQ);
                }
            });
            this.dpI.show();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void hide() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "hide: state-" + this.dpJ);
        }
        if (this.dpJ == RecommendButtonState.SHOW) {
            this.dpJ = RecommendButtonState.HIDE;
            this.dpI.hide();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a
    @JavascriptInterface
    public void destroy() {
        aIn();
        com.baidu.swan.games.view.c.b(this);
    }

    private void aIn() {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "destroy: state-" + this.dpJ);
        }
        if (this.dpJ != RecommendButtonState.DESTROYED) {
            this.dpJ = RecommendButtonState.DESTROYED;
            if (this.dpI != null) {
                this.dpI.destroy();
            }
            this.doQ = null;
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.d.a
    public void rG(String str) {
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "onStyleChanged:" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + this.dpJ + Constants.ACCEPT_TIME_SEPARATOR_SP + this.style);
        }
        if (this.dpJ == RecommendButtonState.SHOW) {
            this.dpI.update();
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0461a
    @UiThread
    public void jf(int i) {
        if (this.doQ != null && i >= 0 && i < this.doQ.dpt.size()) {
            a(this.doQ.dpt.get(i), ConstantData.Forum.SPECAIL_FORUM_TYPE_GAME);
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0461a
    @UiThread
    public void aIg() {
        if (this.doQ != null) {
            a(this.doQ.dps, "game_center");
        }
    }

    @Override // com.baidu.swan.games.view.recommend.a.a.InterfaceC0461a
    @UiThread
    public void aIh() {
        this.dpz.f(this.mSourceType, "list", c.doW);
    }

    private void et(boolean z) {
        if (aIo()) {
            this.dpI.et(z);
        }
    }

    private boolean r(JsObject jsObject) {
        this.dpJ = RecommendButtonState.IDLE;
        this.style.a(this);
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e == null) {
            e = new com.baidu.swan.games.binding.model.c();
        }
        String optString = e.optString("type");
        if (g(e, "type")) {
            this.mSourceType = tX(optString);
        } else {
            this.mSourceType = 1;
        }
        if (this.mSourceType == 0) {
            tY("createRecommendationButton failed,parameter error: the 'type' is invalid.");
            return false;
        }
        if (g(e, "style")) {
            com.baidu.swan.games.binding.model.c sB = e.sB("style");
            if (sB == null) {
                tY("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            } else if (!n(sB)) {
                tY("createRecommendationButton failed,parameter error: the 'style' is invalid.");
                return false;
            }
        }
        if (DEBUG) {
            Log.d("RecommendButtonApiProxy", "init: style-" + this.style);
        }
        this.dpI = new com.baidu.swan.games.view.recommend.proxy.a(this.mSourceType, this.style, this);
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
        int st = cVar != null ? cVar.st(str) : 12;
        return (st == 12 || st == 11) ? false : true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int tX(@Nullable String str) {
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
            e.aj(this.mSourceType, recommendItemModel.appKey);
            SchemeRouter.invokeScheme(com.baidu.swan.games.view.c.aHu(), Uri.parse(recommendItemModel.scheme), UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE);
            this.dpz.f(this.mSourceType, str, recommendItemModel.appKey);
        }
    }

    private boolean aIo() {
        return this.dpJ == RecommendButtonState.HIDE || this.dpJ == RecommendButtonState.SHOW;
    }

    private void tY(String str) {
        this.deo.throwJSException(JSExceptionType.Error, str);
        aIn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIp() {
        dispatchEvent(new JSEvent(TrackLoadSettingsAtom.TYPE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tZ(String str) {
        com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
        bVar.errMsg = str;
        dispatchEvent(new JSEvent(BdStatsConstant.StatsType.ERROR, bVar));
    }

    @Override // com.baidu.swan.games.view.a
    public void aBh() {
        et(true);
    }

    @Override // com.baidu.swan.games.view.a
    public void aBi() {
        et(false);
    }

    @Override // com.baidu.swan.games.view.a
    public void onViewDestroy() {
        aIn();
    }

    /* loaded from: classes7.dex */
    private abstract class a extends StringResponseCallback {
        abstract void onFail(String str);

        abstract void onSuccess(String str);

        private a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(final String str, int i) {
            RecommendButtonApiProxy.this.deo.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onSuccess(str);
                }
            });
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(final Exception exc) {
            RecommendButtonApiProxy.this.deo.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.view.recommend.proxy.RecommendButtonApiProxy.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.onFail(exc.getMessage());
                }
            });
        }
    }
}
