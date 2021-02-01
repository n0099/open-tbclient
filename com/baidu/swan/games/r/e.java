package com.baidu.swan.games.r;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes9.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @V8JavascriptField
    public JsObject canvas = null;
    private com.baidu.swan.games.f.b ecD;

    public e(com.baidu.swan.games.f.b bVar) {
        this.ecD = bVar;
        aXI();
        aXJ();
    }

    private boolean aXI() {
        return dg(this.ecD.getInitBasePath(), "swan-game-open-data.js");
    }

    private boolean aXJ() {
        String azS = com.baidu.swan.apps.v.f.aAl().azS();
        String aXM = f.aXK().aXM();
        if (DEBUG) {
            Log.d("SwanGameOpenDataContext", "baseFilePath: " + azS);
            Log.d("SwanGameOpenDataContext", "openDataJSFile: " + aXM);
        }
        return dg(azS, aXM);
    }

    @JavascriptInterface
    public void destroyOpenDataContext() {
        this.ecD.aVX().aWj();
    }

    @JavascriptInterface
    public void postMessage(JsObject jsObject) {
        this.ecD.aWa().dispatchEvent(new JSEvent("postmessage", jsObject));
    }

    private boolean dg(String str, String str2) {
        if (!f.aXK().aXL() || TextUtils.isEmpty(str)) {
            return false;
        }
        this.ecD.aVX().cT(str, str2);
        return true;
    }
}
