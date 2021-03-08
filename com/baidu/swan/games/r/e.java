package com.baidu.swan.games.r;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes8.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @V8JavascriptField
    public JsObject canvas = null;
    private com.baidu.swan.games.f.b eee;

    public e(com.baidu.swan.games.f.b bVar) {
        this.eee = bVar;
        aXL();
        aXM();
    }

    private boolean aXL() {
        return dg(this.eee.getInitBasePath(), "swan-game-open-data.js");
    }

    private boolean aXM() {
        String azV = com.baidu.swan.apps.v.f.aAo().azV();
        String aXP = f.aXN().aXP();
        if (DEBUG) {
            Log.d("SwanGameOpenDataContext", "baseFilePath: " + azV);
            Log.d("SwanGameOpenDataContext", "openDataJSFile: " + aXP);
        }
        return dg(azV, aXP);
    }

    @JavascriptInterface
    public void destroyOpenDataContext() {
        this.eee.aWa().aWm();
    }

    @JavascriptInterface
    public void postMessage(JsObject jsObject) {
        this.eee.aWd().dispatchEvent(new JSEvent("postmessage", jsObject));
    }

    private boolean dg(String str, String str2) {
        if (!f.aXN().aXO() || TextUtils.isEmpty(str)) {
            return false;
        }
        this.eee.aWa().cT(str, str2);
        return true;
    }
}
