package com.baidu.swan.apps.event.a;

import android.net.Uri;
import android.util.Log;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class g<T> extends a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean dcA = true;
    public T mData;

    public g() {
        this.cJT = "message";
    }

    @Override // com.baidu.swan.apps.event.a.a
    public String nR(String str) {
        if (this.mData instanceof String) {
            String encode = this.dcA ? Uri.encode((String) this.mData) : (String) this.mData;
            if (DEBUG) {
                Log.d("SwanAppWebMessage", "mData: " + this.mData);
                Log.d("SwanAppWebMessage", "encode mData: " + encode);
            }
            return com.baidu.swan.apps.event.a.O(str, "message", encode);
        } else if (!(this.mData instanceof JSONObject)) {
            return "";
        } else {
            return com.baidu.swan.apps.event.a.c(str, "message", (JSONObject) this.mData);
        }
    }
}
