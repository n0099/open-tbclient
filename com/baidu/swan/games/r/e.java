package com.baidu.swan.games.r;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes3.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @V8JavascriptField
    public JsObject canvas = null;
    private com.baidu.swan.games.f.b dqC;

    public e(com.baidu.swan.games.f.b bVar) {
        this.dqC = bVar;
        aPv();
        aPw();
    }

    private boolean aPv() {
        return cW(this.dqC.getInitBasePath(), "swan-game-open-data.js");
    }

    private boolean aPw() {
        String asq = com.baidu.swan.apps.v.f.asJ().asq();
        String aPz = f.aPx().aPz();
        if (DEBUG) {
            Log.d("SwanGameOpenDataContext", "baseFilePath: " + asq);
            Log.d("SwanGameOpenDataContext", "openDataJSFile: " + aPz);
        }
        return cW(asq, aPz);
    }

    @JavascriptInterface
    public void destroyOpenDataContext() {
        this.dqC.aNK().aNW();
    }

    @JavascriptInterface
    public void postMessage(JsObject jsObject) {
        this.dqC.aNN().dispatchEvent(new JSEvent("postmessage", jsObject));
    }

    private boolean cW(String str, String str2) {
        if (!f.aPx().aPy() || TextUtils.isEmpty(str)) {
            return false;
        }
        this.dqC.aNK().cJ(str, str2);
        return true;
    }
}
