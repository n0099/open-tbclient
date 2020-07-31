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
    private com.baidu.swan.games.f.b deo;

    public e(com.baidu.swan.games.f.b bVar) {
        this.deo = bVar;
        aFT();
        aFU();
    }

    private boolean aFT() {
        return cC(this.deo.getInitBasePath(), "swan-game-open-data.js");
    }

    private boolean aFU() {
        String ajY = com.baidu.swan.apps.v.f.akr().ajY();
        String aFX = f.aFV().aFX();
        if (DEBUG) {
            Log.d("SwanGameOpenDataContext", "baseFilePath: " + ajY);
            Log.d("SwanGameOpenDataContext", "openDataJSFile: " + aFX);
        }
        return cC(ajY, aFX);
    }

    @JavascriptInterface
    public void destroyOpenDataContext() {
        this.deo.aEk().aEw();
    }

    @JavascriptInterface
    public void postMessage(JsObject jsObject) {
        this.deo.aEn().dispatchEvent(new JSEvent("postmessage", jsObject));
    }

    private boolean cC(String str, String str2) {
        if (!f.aFV().aFW() || TextUtils.isEmpty(str)) {
            return false;
        }
        this.deo.aEk().cp(str, str2);
        return true;
    }
}
