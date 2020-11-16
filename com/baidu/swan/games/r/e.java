package com.baidu.swan.games.r;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes7.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @V8JavascriptField
    public JsObject canvas = null;
    private com.baidu.swan.games.f.b dPn;

    public e(com.baidu.swan.games.f.b bVar) {
        this.dPn = bVar;
        aVQ();
        aVR();
    }

    private boolean aVQ() {
        return dh(this.dPn.getInitBasePath(), "swan-game-open-data.js");
    }

    private boolean aVR() {
        String ayN = com.baidu.swan.apps.v.f.azg().ayN();
        String aVU = f.aVS().aVU();
        if (DEBUG) {
            Log.d("SwanGameOpenDataContext", "baseFilePath: " + ayN);
            Log.d("SwanGameOpenDataContext", "openDataJSFile: " + aVU);
        }
        return dh(ayN, aVU);
    }

    @JavascriptInterface
    public void destroyOpenDataContext() {
        this.dPn.aUf().aUr();
    }

    @JavascriptInterface
    public void postMessage(JsObject jsObject) {
        this.dPn.aUi().dispatchEvent(new JSEvent("postmessage", jsObject));
    }

    private boolean dh(String str, String str2) {
        if (!f.aVS().aVT() || TextUtils.isEmpty(str)) {
            return false;
        }
        this.dPn.aUf().cU(str, str2);
        return true;
    }
}
