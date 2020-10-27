package com.baidu.swan.apps.runtime.config;

import android.util.Log;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes10.dex */
    public static class a {
        public int dnA;
        public int dnB;
        public int dnC;
        public int dnz;

        public static a bs(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aFG();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("networkTimeout");
            if (optJSONObject == null) {
                return aFG();
            }
            a aVar = new a();
            aVar.dnz = optJSONObject.optInt("request", com.baidu.swan.apps.t.a.aud().adR());
            aVar.dnA = optJSONObject.optInt("connectSocket", 60000);
            aVar.dnB = optJSONObject.optInt("uploadFile");
            aVar.dnC = optJSONObject.optInt("downloadFile");
            return aVar;
        }

        private static a aFG() {
            if (b.DEBUG) {
                Log.e("SwanAppCommonConfigData", "NetworkConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            a aVar = new a();
            aVar.dnz = 60000;
            aVar.dnA = 60000;
            return aVar;
        }
    }
}
