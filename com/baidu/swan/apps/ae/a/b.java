package com.baidu.swan.apps.ae.a;

import android.util.Log;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes2.dex */
    public static class a {
        public int aOf;
        public int aOg;
        public int aOh;
        public int aOi;

        public static a N(JSONObject jSONObject) {
            if (jSONObject == null) {
                return Jn();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("networkTimeout");
            if (optJSONObject == null) {
                return Jn();
            }
            a aVar = new a();
            aVar.aOf = optJSONObject.optInt("request", 60000);
            aVar.aOg = optJSONObject.optInt("connectSocket", 60000);
            aVar.aOh = optJSONObject.optInt("uploadFile");
            aVar.aOi = optJSONObject.optInt("downloadFile");
            return aVar;
        }

        private static a Jn() {
            if (b.DEBUG) {
                Log.e("SwanAppCommonConfigData", "NetworkConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            a aVar = new a();
            aVar.aOf = 60000;
            aVar.aOg = 60000;
            return aVar;
        }
    }
}
