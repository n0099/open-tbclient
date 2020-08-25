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
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.core.turbo.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.games.view.webview.b;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes8.dex */
public class a extends EventTargetImpl {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private g dzV;
    private C0512a dzW;
    private volatile String mCurrentUrl;

    public a(com.baidu.swan.games.f.b bVar) {
        super(bVar);
    }

    @JavascriptInterface
    public void open(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e == null) {
            v(BdStatsConstant.StatsType.ERROR, dc(null, PayHelper.STATUS_SUCC));
            return;
        }
        final String optString = e.optString("url", null);
        if (!wq(optString)) {
            v(BdStatsConstant.StatsType.ERROR, dc(optString, PayHelper.STATUS_SUCC));
        } else if (!com.baidu.swan.apps.ag.a.b.qD(optString)) {
            v(BdStatsConstant.StatsType.ERROR, dc(optString, PayHelper.STATUS_FAIL));
        } else {
            if (DEBUG) {
                Log.i("GameWebViewApi", "open:" + optString);
            }
            this.mCurrentUrl = optString;
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.webview.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.dzV == null) {
                        a.this.aRg();
                    }
                    if (!a.this.dzV.aaJ()) {
                        a.this.dzV.aaZ();
                    }
                    a.this.dzV.loadUrl(optString);
                    a.this.v("open", new b.a(optString));
                }
            });
        }
    }

    @JavascriptInterface
    public void close() {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.webview.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dzV != null && a.this.dzV.aaJ()) {
                    a.this.dzV.aba();
                    a.this.dzV.destroy();
                    a.this.dzV = null;
                    a.this.v("close", new b.a(a.this.mCurrentUrl));
                }
            }
        });
    }

    @JavascriptInterface
    public void setCloseViewVisibility(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e == null) {
            v(BdStatsConstant.StatsType.ERROR, dc(null, PayHelper.STATUS_SUCC));
            return;
        }
        final String optString = e.optString("setCloseViewVisibility", null);
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.view.webview.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.dzV != null) {
                    if (TextUtils.equals("1", optString)) {
                        a.this.dzV.dx(true);
                    } else {
                        a.this.dzV.dx(false);
                    }
                }
            }
        });
    }

    @JavascriptInterface
    public void onGameLoadingStart(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        if (e != null) {
            String optString = e.optString("gameId");
            String optString2 = e.optString("gameName");
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                com.baidu.swan.games.utils.b.a(e, false, null);
                return;
            }
            this.dzW = new C0512a(optString, optString2, System.currentTimeMillis());
            if (DEBUG) {
                Log.d("GameWebViewApi", "onGameLoadingStart: " + this.dzW);
            }
            com.baidu.swan.games.utils.b.a(e, true, null);
        }
    }

    public void onGameLoadingFinish() {
        if (this.dzW == null) {
            if (DEBUG) {
                Log.d("GameWebViewApi", "onGameLoadingFinish: H5GameInfo is null.");
                return;
            }
            return;
        }
        e azJ = e.azJ();
        if (azJ == null) {
            if (DEBUG) {
                Log.d("GameWebViewApi", "onGameLoadingFinish: SwanApp is null.");
                return;
            }
            return;
        }
        this.dzW.dAa = System.currentTimeMillis();
        if (DEBUG) {
            Log.d("GameWebViewApi", "onGameLoadingFinish: " + this.dzW);
        }
        c.a(azJ, this.dzW);
        this.dzW = null;
    }

    private boolean wq(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.startsWith("http://") || lowerCase.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRg() {
        if (this.dzV == null) {
            this.dzV = d.ajS().ajT().bv(com.baidu.swan.apps.t.a.aoJ());
            this.dzV.d(new View.OnClickListener() { // from class: com.baidu.swan.games.view.webview.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.close();
                }
            });
        }
    }

    private b.C0513b dc(String str, @NonNull String str2) {
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
                return new b.C0513b(str, str2, "open:url is invalid");
            case 1:
                return new b.C0513b(str, str2, "open:host not in white list");
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(String str, Object obj) {
        if (DEBUG) {
            Log.i("GameWebViewApi", "dispatchEvent:" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + obj);
        }
        dispatchEvent(new JSEvent(str, obj));
    }

    public static a aRh() {
        com.baidu.swan.games.f.a aND = com.baidu.swan.games.j.a.aNC().aND();
        if (aND == null) {
            return null;
        }
        EventTarget aNb = aND.aNb();
        if (aNb instanceof com.baidu.swan.games.binding.c) {
            return ((com.baidu.swan.games.binding.c) aNb).getWebViewManager();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.swan.games.view.webview.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0512a {
        long dAa;
        long dzZ;
        String mGameId;
        String mGameName;

        private C0512a(String str, String str2, long j) {
            this.mGameId = str;
            this.mGameName = str2;
            this.dzZ = j;
        }

        public String toString() {
            return "H5GameInfo{mGameId='" + this.mGameId + "', mGameName='" + this.mGameName + "', mStartLoadingTimestamp=" + this.dzZ + ", mFinishLoadingTimestamp=" + this.dAa + '}';
        }
    }
}
