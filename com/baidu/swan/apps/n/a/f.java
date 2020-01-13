package com.baidu.swan.apps.n.a;

import android.net.Uri;
import android.util.Log;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class f<T> extends a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean bqn = true;
    public T mData;

    public f() {
        this.bqi = "message";
    }

    @Override // com.baidu.swan.apps.n.a.a
    public String hu(String str) {
        if (this.mData instanceof String) {
            String encode = this.bqn ? Uri.encode((String) this.mData) : (String) this.mData;
            if (DEBUG) {
                Log.d("SwanAppWebMessage", "mData: " + this.mData);
                Log.d("SwanAppWebMessage", "encode mData: " + encode);
            }
            return com.baidu.swan.apps.n.a.r(str, "message", encode);
        } else if (!(this.mData instanceof JSONObject)) {
            return "";
        } else {
            return com.baidu.swan.apps.n.a.c(str, "message", (JSONObject) this.mData);
        }
    }
}
