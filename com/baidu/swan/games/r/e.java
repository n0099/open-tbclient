package com.baidu.swan.games.r;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes25.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    @V8JavascriptField
    public JsObject canvas = null;
    private com.baidu.swan.games.f.b dWl;

    public e(com.baidu.swan.games.f.b bVar) {
        this.dWl = bVar;
        aYV();
        aYW();
    }

    private boolean aYV() {
        return m33do(this.dWl.getInitBasePath(), "swan-game-open-data.js");
    }

    private boolean aYW() {
        String aBW = com.baidu.swan.apps.v.f.aCp().aBW();
        String aYZ = f.aYX().aYZ();
        if (DEBUG) {
            Log.d("SwanGameOpenDataContext", "baseFilePath: " + aBW);
            Log.d("SwanGameOpenDataContext", "openDataJSFile: " + aYZ);
        }
        return m33do(aBW, aYZ);
    }

    @JavascriptInterface
    public void destroyOpenDataContext() {
        this.dWl.aXk().aXw();
    }

    @JavascriptInterface
    public void postMessage(JsObject jsObject) {
        this.dWl.aXn().dispatchEvent(new JSEvent("postmessage", jsObject));
    }

    /* renamed from: do  reason: not valid java name */
    private boolean m33do(String str, String str2) {
        if (!f.aYX().aYY() || TextUtils.isEmpty(str)) {
            return false;
        }
        this.dWl.aXk().db(str, str2);
        return true;
    }
}
