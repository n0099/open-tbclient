package com.baidu.swan.apps.m.a;

import android.net.Uri;
import android.util.Log;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f<T> extends a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public boolean awr = true;
    public T mData;

    public f() {
        this.awl = "message";
    }

    @Override // com.baidu.swan.apps.m.a.a
    public String ev(String str) {
        if (this.mData instanceof String) {
            String encode = this.awr ? Uri.encode((String) this.mData) : (String) this.mData;
            if (DEBUG) {
                Log.d("SwanAppWebMessage", "mData: " + this.mData);
                Log.d("SwanAppWebMessage", "encode mData: " + encode);
            }
            return com.baidu.swan.apps.m.a.n(str, "message", encode);
        } else if (!(this.mData instanceof JSONObject)) {
            return "";
        } else {
            return com.baidu.swan.apps.m.a.a(str, "message", (JSONObject) this.mData);
        }
    }
}
