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
    private com.baidu.swan.games.f.b efi;

    public e(com.baidu.swan.games.f.b bVar) {
        this.efi = bVar;
        bbq();
        bbr();
    }

    private boolean bbq() {
        return dn(this.efi.getInitBasePath(), "swan-game-open-data.js");
    }

    private boolean bbr() {
        String aDo = com.baidu.swan.apps.v.f.aDH().aDo();
        String bbu = f.bbs().bbu();
        if (DEBUG) {
            Log.d("SwanGameOpenDataContext", "baseFilePath: " + aDo);
            Log.d("SwanGameOpenDataContext", "openDataJSFile: " + bbu);
        }
        return dn(aDo, bbu);
    }

    @JavascriptInterface
    public void destroyOpenDataContext() {
        this.efi.aZF().aZR();
    }

    @JavascriptInterface
    public void postMessage(JsObject jsObject) {
        this.efi.aZI().dispatchEvent(new JSEvent("postmessage", jsObject));
    }

    private boolean dn(String str, String str2) {
        if (!f.bbs().bbt() || TextUtils.isEmpty(str)) {
            return false;
        }
        this.efi.aZF().da(str, str2);
        return true;
    }
}
