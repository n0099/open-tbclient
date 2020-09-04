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
    private com.baidu.swan.games.f.b doB;

    public e(com.baidu.swan.games.f.b bVar) {
        this.doB = bVar;
        aOK();
        aOL();
    }

    private boolean aOK() {
        return cW(this.doB.getInitBasePath(), "swan-game-open-data.js");
    }

    private boolean aOL() {
        String arF = com.baidu.swan.apps.v.f.arY().arF();
        String aOO = f.aOM().aOO();
        if (DEBUG) {
            Log.d("SwanGameOpenDataContext", "baseFilePath: " + arF);
            Log.d("SwanGameOpenDataContext", "openDataJSFile: " + aOO);
        }
        return cW(arF, aOO);
    }

    @JavascriptInterface
    public void destroyOpenDataContext() {
        this.doB.aMZ().aNl();
    }

    @JavascriptInterface
    public void postMessage(JsObject jsObject) {
        this.doB.aNc().dispatchEvent(new JSEvent("postmessage", jsObject));
    }

    private boolean cW(String str, String str2) {
        if (!f.aOM().aON() || TextUtils.isEmpty(str)) {
            return false;
        }
        this.doB.aMZ().cJ(str, str2);
        return true;
    }
}
