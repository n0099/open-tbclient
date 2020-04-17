package com.baidu.swan.apps.n.a;

import android.net.Uri;
import android.util.Log;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class f<T> extends a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean bSR = true;
    public T mData;

    public f() {
        this.bSM = "message";
    }

    @Override // com.baidu.swan.apps.n.a.a
    public String iW(String str) {
        if (this.mData instanceof String) {
            String encode = this.bSR ? Uri.encode((String) this.mData) : (String) this.mData;
            if (DEBUG) {
                Log.d("SwanAppWebMessage", "mData: " + this.mData);
                Log.d("SwanAppWebMessage", "encode mData: " + encode);
            }
            return com.baidu.swan.apps.n.a.s(str, "message", encode);
        } else if (!(this.mData instanceof JSONObject)) {
            return "";
        } else {
            return com.baidu.swan.apps.n.a.b(str, "message", (JSONObject) this.mData);
        }
    }
}
