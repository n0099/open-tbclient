package com.baidu.swan.games.r;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes10.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @V8JavascriptField
    public JsObject canvas = null;
    private com.baidu.swan.games.f.b dQV;

    public e(com.baidu.swan.games.f.b bVar) {
        this.dQV = bVar;
        aWy();
        aWz();
    }

    private boolean aWy() {
        return di(this.dQV.getInitBasePath(), "swan-game-open-data.js");
    }

    private boolean aWz() {
        String azv = com.baidu.swan.apps.v.f.azO().azv();
        String aWC = f.aWA().aWC();
        if (DEBUG) {
            Log.d("SwanGameOpenDataContext", "baseFilePath: " + azv);
            Log.d("SwanGameOpenDataContext", "openDataJSFile: " + aWC);
        }
        return di(azv, aWC);
    }

    @JavascriptInterface
    public void destroyOpenDataContext() {
        this.dQV.aUN().aUZ();
    }

    @JavascriptInterface
    public void postMessage(JsObject jsObject) {
        this.dQV.aUQ().dispatchEvent(new JSEvent("postmessage", jsObject));
    }

    private boolean di(String str, String str2) {
        if (!f.aWA().aWB() || TextUtils.isEmpty(str)) {
            return false;
        }
        this.dQV.aUN().cV(str, str2);
        return true;
    }
}
