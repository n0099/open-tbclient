package com.baidu.swan.apps.runtime.config;

import android.util.Log;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class b {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    /* loaded from: classes8.dex */
    public static class a {
        public int dCH;
        public int dCI;
        public int dCJ;
        public int dCK;

        public static a bC(JSONObject jSONObject) {
            if (jSONObject == null) {
                return aJd();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("networkTimeout");
            if (optJSONObject == null) {
                return aJd();
            }
            a aVar = new a();
            aVar.dCH = optJSONObject.optInt("request", com.baidu.swan.apps.t.a.awB().agg());
            aVar.dCI = optJSONObject.optInt("connectSocket", 60000);
            aVar.dCJ = optJSONObject.optInt("uploadFile");
            aVar.dCK = optJSONObject.optInt("downloadFile");
            return aVar;
        }

        private static a aJd() {
            if (b.DEBUG) {
                Log.e("SwanAppCommonConfigData", "NetworkConfig createNullObject() " + Log.getStackTraceString(new Exception()));
            }
            a aVar = new a();
            aVar.dCH = 60000;
            aVar.dCI = 60000;
            return aVar;
        }
    }
}
