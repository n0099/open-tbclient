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
    private com.baidu.swan.games.f.b dLd;

    public e(com.baidu.swan.games.f.b bVar) {
        this.dLd = bVar;
        aTY();
        aTZ();
    }

    private boolean aTY() {
        return di(this.dLd.getInitBasePath(), "swan-game-open-data.js");
    }

    private boolean aTZ() {
        String awV = com.baidu.swan.apps.v.f.axo().awV();
        String aUc = f.aUa().aUc();
        if (DEBUG) {
            Log.d("SwanGameOpenDataContext", "baseFilePath: " + awV);
            Log.d("SwanGameOpenDataContext", "openDataJSFile: " + aUc);
        }
        return di(awV, aUc);
    }

    @JavascriptInterface
    public void destroyOpenDataContext() {
        this.dLd.aSn().aSz();
    }

    @JavascriptInterface
    public void postMessage(JsObject jsObject) {
        this.dLd.aSq().dispatchEvent(new JSEvent("postmessage", jsObject));
    }

    private boolean di(String str, String str2) {
        if (!f.aUa().aUb() || TextUtils.isEmpty(str)) {
            return false;
        }
        this.dLd.aSn().cV(str, str2);
        return true;
    }
}
