package com.baidu.swan.games.o;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.JSEvent;
/* loaded from: classes2.dex */
public class e {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.e.b bym;
    @V8JavascriptField
    public JsObject canvas = null;

    public e(com.baidu.swan.games.e.b bVar) {
        this.bym = bVar;
        XB();
        XC();
    }

    private boolean XB() {
        return bm(com.baidu.swan.games.i.a.bk(com.baidu.swan.apps.w.e.LD().Lm(), "swan-game-open-data.js"), "swan-game-open-data.js");
    }

    private boolean XC() {
        String Lm = com.baidu.swan.apps.w.e.LD().Lm();
        String XF = f.XD().XF();
        if (DEBUG) {
            Log.d("SwanGameOpenDataContext", "baseFilePath: " + Lm);
            Log.d("SwanGameOpenDataContext", "openDataJSFile: " + XF);
        }
        return bm(Lm, XF);
    }

    @JavascriptInterface
    public void destroyOpenDataContext() {
        this.bym.WA().WM();
    }

    @JavascriptInterface
    public void postMessage(JsObject jsObject) {
        this.bym.WC().dispatchEvent(new JSEvent("postmessage", jsObject));
    }

    private boolean bm(String str, String str2) {
        if (!f.XD().XE() || TextUtils.isEmpty(str)) {
            return false;
        }
        this.bym.WA().bc(str, str2);
        return true;
    }
}
