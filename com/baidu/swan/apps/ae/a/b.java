package com.baidu.swan.apps.ae.a;

import android.util.Log;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes2.dex */
    public static class a {
        public int bkv;
        public int bkw;
        public int bkx;
        public int bky;

        public static a ak(JSONObject jSONObject) {
            if (jSONObject == null) {
                return Rs();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("networkTimeout");
            if (optJSONObject == null) {
                return Rs();
            }
            a aVar = new a();
            aVar.bkv = optJSONObject.optInt("request", 60000);
            aVar.bkw = optJSONObject.optInt("connectSocket", 60000);
            aVar.bkx = optJSONObject.optInt("uploadFile");
            aVar.bky = optJSONObject.optInt("downloadFile");
            return aVar;
        }

        private static a Rs() {
            if (b.DEBUG) {
                Log.e("SwanAppCommonConfigData", "NetworkConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            a aVar = new a();
            aVar.bkv = 60000;
            aVar.bkw = 60000;
            return aVar;
        }
    }
}
