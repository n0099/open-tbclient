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
    private com.baidu.swan.games.e.b bxv;
    @V8JavascriptField
    public JsObject canvas = null;

    public e(com.baidu.swan.games.e.b bVar) {
        this.bxv = bVar;
        Xz();
        XA();
    }

    private boolean Xz() {
        return bm(com.baidu.swan.games.i.a.bk(com.baidu.swan.apps.w.e.LE().Ln(), "swan-game-open-data.js"), "swan-game-open-data.js");
    }

    private boolean XA() {
        String Ln = com.baidu.swan.apps.w.e.LE().Ln();
        String XD = f.XB().XD();
        if (DEBUG) {
            Log.d("SwanGameOpenDataContext", "baseFilePath: " + Ln);
            Log.d("SwanGameOpenDataContext", "openDataJSFile: " + XD);
        }
        return bm(Ln, XD);
    }

    @JavascriptInterface
    public void destroyOpenDataContext() {
        this.bxv.Wy().WK();
    }

    @JavascriptInterface
    public void postMessage(JsObject jsObject) {
        this.bxv.WA().dispatchEvent(new JSEvent("postmessage", jsObject));
    }

    private boolean bm(String str, String str2) {
        if (!f.XB().XC() || TextUtils.isEmpty(str)) {
            return false;
        }
        this.bxv.Wy().bc(str, str2);
        return true;
    }
}
