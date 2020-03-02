package com.baidu.swan.games.view.webview;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.adaptation.b.g;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.core.k.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.games.view.webview.b;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes11.dex */
public class a extends EventTargetImpl {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private g cuY;
    private C0354a cuZ;
    private volatile String mCurrentUrl;

    public a(com.baidu.swan.games.e.b bVar) {
        super(bVar);
    }

    @JavascriptInterface
    public void open(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (c == null) {
            o(BdStatsConstant.StatsType.ERROR, bY(null, PayHelper.STATUS_SUCC));
            return;
        }
        final String optString = c.optString("url", null);
        if (!pZ(optString)) {
            o(BdStatsConstant.StatsType.ERROR, bY(optString, PayHelper.STATUS_SUCC));
        } else if (!com.baidu.swan.apps.aj.a.b.lh(optString)) {
            o(BdStatsConstant.StatsType.ERROR, bY(optString, PayHelper.STATUS_FAIL));
        } else {
            if (DEBUG) {
                Log.i("GameWebViewApi", "open:" + optString);
            }
            this.mCurrentUrl = optString;
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.webview.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.cuY == null) {
                        a.this.arn();
                    }
                    if (!a.this.cuY.IH()) {
                        a.this.cuY.IU();
                    }
                    a.this.cuY.loadUrl(optString);
                    a.this.o("open", new b.a(optString));
                }
            });
        }
    }

    @JavascriptInterface
    public void close() {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.webview.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cuY != null && a.this.cuY.IH()) {
                    a.this.cuY.IV();
                    a.this.cuY.destroy();
                    a.this.cuY = null;
                    a.this.o("close", new b.a(a.this.mCurrentUrl));
                }
            }
        });
    }

    @JavascriptInterface
    public void setCloseViewVisibility(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (c == null) {
            o(BdStatsConstant.StatsType.ERROR, bY(null, PayHelper.STATUS_SUCC));
            return;
        }
        final String optString = c.optString("setCloseViewVisibility", null);
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.webview.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.cuY != null) {
                    if (TextUtils.equals("1", optString)) {
                        a.this.cuY.bX(true);
                    } else {
                        a.this.cuY.bX(false);
                    }
                }
            }
        });
    }

    @JavascriptInterface
    public void onGameLoadingStart(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        if (c != null) {
            String optString = c.optString("gameId");
            String optString2 = c.optString("gameName");
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                com.baidu.swan.games.utils.b.a(c, false, null);
                return;
            }
            this.cuZ = new C0354a(optString, optString2, System.currentTimeMillis());
            if (DEBUG) {
                Log.d("GameWebViewApi", "onGameLoadingStart: " + this.cuZ);
            }
            com.baidu.swan.games.utils.b.a(c, true, null);
        }
    }

    public void onGameLoadingFinish() {
        if (this.cuZ == null) {
            if (DEBUG) {
                Log.d("GameWebViewApi", "onGameLoadingFinish: H5GameInfo is null.");
                return;
            }
            return;
        }
        e acG = e.acG();
        if (acG == null) {
            if (DEBUG) {
                Log.d("GameWebViewApi", "onGameLoadingFinish: SwanApp is null.");
                return;
            }
            return;
        }
        this.cuZ.cvd = System.currentTimeMillis();
        if (DEBUG) {
            Log.d("GameWebViewApi", "onGameLoadingFinish: " + this.cuZ);
        }
        c.a(acG, this.cuZ);
        this.cuZ = null;
    }

    private boolean pZ(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.startsWith("http://") || lowerCase.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arn() {
        if (this.cuY == null) {
            this.cuY = d.Qw().Qx().bA(com.baidu.swan.apps.w.a.TW());
            this.cuY.d(new View.OnClickListener() { // from class: com.baidu.swan.games.view.webview.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.close();
                }
            });
        }
    }

    private b.C0355b bY(String str, @NonNull String str2) {
        char c = 65535;
        switch (str2.hashCode()) {
            case 1507424:
                if (str2.equals(PayHelper.STATUS_SUCC)) {
                    c = 0;
                    break;
                }
                break;
            case 1507425:
                if (str2.equals(PayHelper.STATUS_FAIL)) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return new b.C0355b(str, str2, "open:url is invalid");
            case 1:
                return new b.C0355b(str, str2, "open:host not in white list");
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(String str, Object obj) {
        if (DEBUG) {
            Log.i("GameWebViewApi", "dispatchEvent:" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + obj);
        }
        dispatchEvent(new JSEvent(str, obj));
    }

    public static a aro() {
        com.baidu.swan.games.e.a anZ = com.baidu.swan.games.i.a.anY().anZ();
        if (anZ == null) {
            return null;
        }
        EventTarget anw = anZ.anw();
        if (anw instanceof com.baidu.swan.games.binding.c) {
            return ((com.baidu.swan.games.binding.c) anw).getWebViewManager();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.games.view.webview.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0354a {
        long cvc;
        long cvd;
        String mGameId;
        String mGameName;

        private C0354a(String str, String str2, long j) {
            this.mGameId = str;
            this.mGameName = str2;
            this.cvc = j;
        }

        public String toString() {
            return "H5GameInfo{mGameId='" + this.mGameId + "', mGameName='" + this.mGameName + "', mStartLoadingTimestamp=" + this.cvc + ", mFinishLoadingTimestamp=" + this.cvd + '}';
        }
    }
}
