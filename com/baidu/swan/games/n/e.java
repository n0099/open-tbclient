package com.baidu.swan.games.n;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes2.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.e.b aZZ;
    @V8JavascriptField
    public JsObject canvas = null;

    public e(com.baidu.swan.games.e.b bVar) {
        this.aZZ = bVar;
        OK();
        OL();
    }

    private boolean OK() {
        return bd(com.baidu.swan.games.i.a.ba(com.baidu.swan.apps.w.e.Ec().DL(), "swan-game-open-data.js"), "swan-game-open-data.js");
    }

    private boolean OL() {
        String DL = com.baidu.swan.apps.w.e.Ec().DL();
        String OP = f.OM().OP();
        if (DEBUG) {
            Log.d("SwanGameOpenDataContext", "baseFilePath: " + DL);
            Log.d("SwanGameOpenDataContext", "openDataJSFile: " + OP);
        }
        return bd(DL, OP);
    }

    @JavascriptInterface
    public void destroyOpenDataContext() {
        this.aZZ.NU().Of();
    }

    @JavascriptInterface
    public void postMessage(JsObject jsObject) {
        this.aZZ.NW().dispatchEvent(new JSEvent("postmessage", jsObject));
    }

    private boolean bd(String str, String str2) {
        if (!f.OM().ON() || TextUtils.isEmpty(str)) {
            return false;
        }
        this.aZZ.NU().aS(str, str2);
        return true;
    }
}
