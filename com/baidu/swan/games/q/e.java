package com.baidu.swan.games.q;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes11.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @V8JavascriptField
    public JsObject canvas = null;
    private com.baidu.swan.games.e.b cka;

    public e(com.baidu.swan.games.e.b bVar) {
        this.cka = bVar;
        aoZ();
        apa();
    }

    private boolean aoZ() {
        return bS(this.cka.getInitBasePath(), "swan-game-open-data.js");
    }

    private boolean apa() {
        String WA = com.baidu.swan.apps.y.f.WS().WA();
        String apd = f.apb().apd();
        if (DEBUG) {
            Log.d("SwanGameOpenDataContext", "baseFilePath: " + WA);
            Log.d("SwanGameOpenDataContext", "openDataJSFile: " + apd);
        }
        return bS(WA, apd);
    }

    @JavascriptInterface
    public void destroyOpenDataContext() {
        this.cka.anu().anG();
    }

    @JavascriptInterface
    public void postMessage(JsObject jsObject) {
        this.cka.anx().dispatchEvent(new JSEvent("postmessage", jsObject));
    }

    private boolean bS(String str, String str2) {
        if (!f.apb().apc() || TextUtils.isEmpty(str)) {
            return false;
        }
        this.cka.anu().bF(str, str2);
        return true;
    }
}
