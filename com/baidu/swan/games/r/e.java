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
        bbp();
        bbq();
    }

    private boolean bbp() {
        return dn(this.efi.getInitBasePath(), "swan-game-open-data.js");
    }

    private boolean bbq() {
        String aDn = com.baidu.swan.apps.v.f.aDG().aDn();
        String bbt = f.bbr().bbt();
        if (DEBUG) {
            Log.d("SwanGameOpenDataContext", "baseFilePath: " + aDn);
            Log.d("SwanGameOpenDataContext", "openDataJSFile: " + bbt);
        }
        return dn(aDn, bbt);
    }

    @JavascriptInterface
    public void destroyOpenDataContext() {
        this.efi.aZE().aZQ();
    }

    @JavascriptInterface
    public void postMessage(JsObject jsObject) {
        this.efi.aZH().dispatchEvent(new JSEvent("postmessage", jsObject));
    }

    private boolean dn(String str, String str2) {
        if (!f.bbr().bbs() || TextUtils.isEmpty(str)) {
            return false;
        }
        this.efi.aZE().da(str, str2);
        return true;
    }
}
